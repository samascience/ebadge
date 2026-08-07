package com.jieli.bluetooth_connect.impl;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.jieli.bluetooth_connect.bean.BluetoothOption;
import com.jieli.bluetooth_connect.bean.ErrorInfo;
import com.jieli.bluetooth_connect.interfaces.IBluetoothPair;
import com.jieli.bluetooth_connect.interfaces.listener.OnBtDevicePairListener;
import com.jieli.bluetooth_connect.tool.BtPairEventCbManager;
import com.jieli.bluetooth_connect.util.BluetoothUtil;
import com.jieli.bluetooth_connect.util.ConnectUtil;
import com.jieli.bluetooth_connect.util.JL_Log;
import com.tencent.connect.common.Constants;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes3.dex */
public class BluetoothPair implements IBluetoothPair {
    private static final int MSG_PAIR_TASK_TIMEOUT = 1014;
    private static final String TAG = "BluetoothPair";
    private final BluetoothAdapter btAdapter;
    private BluetoothOption mBluetoothOption;
    private BluetoothPairReceiver mBluetoothPairReceiver;
    private final Context mContext;
    private PairBtDeviceThread mPairBtDeviceThread;
    private volatile BluetoothDevice mPairingDevice;
    private final Handler mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: yl
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            return this.a.lambda$new$0(message);
        }
    });
    private final BtPairEventCbManager mBtPairEventCbManager = new BtPairEventCbManager();

    private class BluetoothPairReceiver extends BroadcastReceiver {
        private BluetoothPairReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        @SuppressLint({"MissingPermission"})
        public void onReceive(Context context, Intent intent) {
            BluetoothDevice bluetoothDevice;
            if (intent != null) {
                String action = intent.getAction();
                if (TextUtils.isEmpty(action)) {
                    return;
                }
                action.hashCode();
                if (action.equals("android.bluetooth.adapter.action.STATE_CHANGED")) {
                    int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1);
                    if (intExtra != -1) {
                        if (intExtra == 10) {
                            BluetoothPair.this.stopPairTaskThread();
                            BluetoothPair bluetoothPair = BluetoothPair.this;
                            bluetoothPair.onError(bluetoothPair.mPairingDevice, ErrorInfo.buildError(2));
                            BluetoothPair bluetoothPair2 = BluetoothPair.this;
                            bluetoothPair2.stopPairTimeout(bluetoothPair2.mPairingDevice);
                        }
                        BluetoothPair.this.mBtPairEventCbManager.onAdapterStatus(intExtra == 12, BluetoothUtil.hasBle(BluetoothPair.this.mContext));
                        return;
                    }
                    return;
                }
                if (action.equals("android.bluetooth.device.action.BOND_STATE_CHANGED") && (bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE")) != null && ConnectUtil.isHasConnectPermission(context)) {
                    int bondState = bluetoothDevice.getBondState();
                    JL_Log.i(BluetoothPair.TAG, "ACTION_BOND_STATE_CHANGED", "device : " + BluetoothUtil.printBtDeviceInfo(context, bluetoothDevice) + ", bound : " + bondState);
                    if (bondState == 10 || bondState == 12) {
                        BluetoothPair.this.stopPairTimeout(bluetoothDevice);
                        BluetoothPair.this.wakeupPairTaskThread(bluetoothDevice);
                    }
                    BluetoothPair.this.mBtPairEventCbManager.onBtDeviceBond(bluetoothDevice, bondState);
                }
            }
        }
    }

    private class PairBtDeviceThread extends Thread {
        private boolean isThreadRunning;
        private boolean isWaiting;
        private boolean isWaitingForResult;
        private BluetoothDevice mPairTaskDevice;
        private final LinkedBlockingQueue<PairTask> mPairTaskQueue;
        private final String tag;

        /* JADX INFO: Access modifiers changed from: private */
        public boolean addPairTask(PairTask pairTask) {
            boolean z;
            if (pairTask != null) {
                try {
                    this.mPairTaskQueue.put(pairTask);
                    z = true;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    z = false;
                }
            } else {
                z = false;
            }
            if (z && this.isWaiting && !this.isWaitingForResult) {
                this.isWaiting = false;
                synchronized (this.mPairTaskQueue) {
                    JL_Log.i(this.tag, "addPairTask", "notify");
                    this.mPairTaskQueue.notify();
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void stopThread() {
            JL_Log.i(this.tag, "stopThread", Constants.STR_EMPTY);
            this.isThreadRunning = false;
            this.mPairTaskDevice = null;
            wakeUp(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void wakeUp(BluetoothDevice bluetoothDevice) {
            if (bluetoothDevice == null || BluetoothUtil.deviceEquals(this.mPairTaskDevice, bluetoothDevice)) {
                synchronized (this.mPairTaskQueue) {
                    try {
                        if (this.isWaitingForResult) {
                            if (this.isWaiting) {
                                this.mPairTaskQueue.notifyAll();
                            } else {
                                this.mPairTaskQueue.notify();
                            }
                        } else if (this.isWaiting) {
                            this.mPairTaskQueue.notify();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            JL_Log.i(BluetoothPair.TAG, this.tag, "start..");
            this.isThreadRunning = true;
            synchronized (this.mPairTaskQueue) {
                while (this.isThreadRunning) {
                    this.isWaitingForResult = false;
                    this.mPairTaskDevice = null;
                    if (this.mPairTaskQueue.isEmpty()) {
                        this.isWaiting = true;
                        JL_Log.i(BluetoothPair.TAG, this.tag, "mPairTaskQueue is empty, wait ...");
                        try {
                            this.mPairTaskQueue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        JL_Log.i(BluetoothPair.TAG, this.tag, "mPairTaskQueue is not empty, notify ...");
                    } else {
                        this.isWaiting = false;
                        PairTask pairTaskPeek = this.mPairTaskQueue.peek();
                        if (pairTaskPeek != null) {
                            this.mPairTaskDevice = pairTaskPeek.getDevice();
                            boolean zPair = pairTaskPeek.getOp() == 0 ? BluetoothPair.this.pair(this.mPairTaskDevice, pairTaskPeek.getPairWay()) : BluetoothPair.this.unPair(this.mPairTaskDevice);
                            JL_Log.i(BluetoothPair.TAG, this.tag, "task : " + pairTaskPeek + " execute : " + zPair);
                            if (zPair) {
                                this.isWaitingForResult = true;
                                JL_Log.i(BluetoothPair.TAG, this.tag, "wait for system callback");
                                try {
                                    this.mPairTaskQueue.wait(30000L);
                                } catch (InterruptedException e2) {
                                    e2.printStackTrace();
                                }
                                JL_Log.i(BluetoothPair.TAG, this.tag, "system callback, notify and poll ...");
                            } else {
                                BluetoothPair bluetoothPair = BluetoothPair.this;
                                BluetoothDevice bluetoothDevice = this.mPairTaskDevice;
                                bluetoothPair.onError(bluetoothDevice, ErrorInfo.buildError(3, 0, bluetoothDevice == null ? Constants.STR_EMPTY : bluetoothDevice.getAddress()));
                            }
                        } else {
                            JL_Log.i(BluetoothPair.TAG, this.tag, "mPairTask is null,  poll...");
                        }
                        this.mPairTaskQueue.poll();
                    }
                }
            }
            this.mPairTaskQueue.clear();
            BluetoothPair.this.mPairBtDeviceThread = null;
            JL_Log.i(BluetoothPair.TAG, this.tag, "exit..");
        }

        private PairBtDeviceThread() {
            super("PairBtDeviceThread");
            this.tag = PairBtDeviceThread.class.getSimpleName();
            this.mPairTaskQueue = new LinkedBlockingQueue<>();
        }
    }

    public static class PairTask {
        private static final int OP_CANCEL_PAIR = 1;
        private static final int OP_PAIR = 0;
        private final BluetoothDevice mDevice;
        private final int mOp;
        private int pairWay = 0;

        public PairTask(int i, BluetoothDevice bluetoothDevice) {
            this.mOp = i;
            this.mDevice = bluetoothDevice;
        }

        public BluetoothDevice getDevice() {
            return this.mDevice;
        }

        public int getOp() {
            return this.mOp;
        }

        public int getPairWay() {
            return this.pairWay;
        }

        public PairTask setPairWay(int i) {
            this.pairWay = i;
            return this;
        }

        public String toString() {
            return "PairTask{mOp=" + this.mOp + ", mDevice=" + this.mDevice + ", pairWay=" + this.pairWay + '}';
        }
    }

    public BluetoothPair(Context context, OnBtDevicePairListener onBtDevicePairListener) {
        this.mContext = (Context) ConnectUtil.checkNotNull(context);
        android.bluetooth.BluetoothManager bluetoothManager = (android.bluetooth.BluetoothManager) context.getSystemService("bluetooth");
        if (bluetoothManager != null) {
            this.btAdapter = bluetoothManager.getAdapter();
        } else {
            this.btAdapter = BluetoothAdapter.getDefaultAdapter();
        }
        addListener(onBtDevicePairListener);
        registerReceiver();
        startPairTaskThread();
    }

    private boolean addPairTask(PairTask pairTask) {
        if (pairTask == null) {
            return false;
        }
        startPairTaskThread();
        return this.mPairBtDeviceThread.addPairTask(pairTask);
    }

    @SuppressLint({"MissingPermission"})
    private int getDeviceBoundWay(BluetoothDevice bluetoothDevice) {
        BluetoothAdapter bluetoothAdapter;
        int i = 0;
        if (bluetoothDevice != null && ConnectUtil.isHasConnectPermission(this.mContext)) {
            BluetoothOption bluetoothOption = this.mBluetoothOption;
            if (bluetoothOption != null && bluetoothOption.isSupportCTKD() && bluetoothDevice.getType() == 3) {
                if (Build.VERSION.SDK_INT >= 33 && (bluetoothAdapter = this.btAdapter) != null && bluetoothAdapter.isLeAudioSupported() == 10) {
                    i = 1;
                }
                i ^= 1;
            }
            JL_Log.d(TAG, "getDeviceBoundWay", "pairWay : " + i);
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$new$0(Message message) {
        BluetoothDevice bluetoothDevice;
        if (message.what == MSG_PAIR_TASK_TIMEOUT && (bluetoothDevice = (BluetoothDevice) message.obj) != null) {
            wakeupPairTaskThread(bluetoothDevice);
            onError(bluetoothDevice, ErrorInfo.buildError(4, 0, bluetoothDevice.getAddress()));
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(BluetoothDevice bluetoothDevice, ErrorInfo errorInfo) {
        this.mBtPairEventCbManager.onPairError(bluetoothDevice, errorInfo);
    }

    private void registerReceiver() {
        if (this.mBluetoothPairReceiver == null) {
            this.mBluetoothPairReceiver = new BluetoothPairReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.bluetooth.device.action.BOND_STATE_CHANGED");
            intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
            this.mContext.registerReceiver(this.mBluetoothPairReceiver, intentFilter);
        }
    }

    private void setPairingDevice(BluetoothDevice bluetoothDevice) {
        this.mPairingDevice = bluetoothDevice;
    }

    private void startPairTaskThread() {
        if (this.mPairBtDeviceThread == null) {
            PairBtDeviceThread pairBtDeviceThread = new PairBtDeviceThread();
            this.mPairBtDeviceThread = pairBtDeviceThread;
            pairBtDeviceThread.start();
        }
    }

    private void startPairTimeOut(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null) {
            onError(null, ErrorInfo.buildError(1));
        } else {
            if (this.mHandler.hasMessages(MSG_PAIR_TASK_TIMEOUT)) {
                onError(bluetoothDevice, ErrorInfo.buildError(5));
                return;
            }
            Message messageObtainMessage = this.mHandler.obtainMessage(MSG_PAIR_TASK_TIMEOUT, bluetoothDevice);
            setPairingDevice(bluetoothDevice);
            this.mHandler.sendMessageDelayed(messageObtainMessage, 30000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopPairTaskThread() {
        PairBtDeviceThread pairBtDeviceThread = this.mPairBtDeviceThread;
        if (pairBtDeviceThread != null) {
            pairBtDeviceThread.stopThread();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopPairTimeout(BluetoothDevice bluetoothDevice) {
        if (this.mHandler.hasMessages(MSG_PAIR_TASK_TIMEOUT) && BluetoothUtil.deviceEquals(bluetoothDevice, this.mPairingDevice)) {
            this.mHandler.removeMessages(MSG_PAIR_TASK_TIMEOUT);
            setPairingDevice(null);
        }
    }

    private void unregisterReceiver() {
        BluetoothPairReceiver bluetoothPairReceiver = this.mBluetoothPairReceiver;
        if (bluetoothPairReceiver != null) {
            this.mContext.unregisterReceiver(bluetoothPairReceiver);
            this.mBluetoothPairReceiver = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wakeupPairTaskThread(BluetoothDevice bluetoothDevice) {
        PairBtDeviceThread pairBtDeviceThread = this.mPairBtDeviceThread;
        if (pairBtDeviceThread != null) {
            pairBtDeviceThread.wakeUp(bluetoothDevice);
        }
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBase
    public void destroy() {
        unregisterReceiver();
        stopPairTaskThread();
        this.mBtPairEventCbManager.destroy();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothPair
    public List<BluetoothDevice> getPairedDevices() {
        return BluetoothUtil.getPairedDevices(this.mContext);
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothPair
    @SuppressLint({"MissingPermission"})
    public boolean isPaired(BluetoothDevice bluetoothDevice) {
        return ConnectUtil.isHasConnectPermission(this.mContext) && bluetoothDevice != null && 12 == bluetoothDevice.getBondState();
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothPair
    @SuppressLint({"MissingPermission"})
    public boolean isPairing(BluetoothDevice bluetoothDevice) {
        return ConnectUtil.isHasConnectPermission(this.mContext) && bluetoothDevice != null && 11 == bluetoothDevice.getBondState();
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothPair
    @SuppressLint({"MissingPermission"})
    public boolean pair(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice != null && ConnectUtil.isHasConnectPermission(this.mContext)) {
            return pair(bluetoothDevice, getDeviceBoundWay(bluetoothDevice));
        }
        JL_Log.w(TAG, "pair", "device is null");
        return false;
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBase
    public void setBluetoothOption(BluetoothOption bluetoothOption) {
        this.mBluetoothOption = bluetoothOption;
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothPair
    public boolean tryToPair(BluetoothDevice bluetoothDevice) {
        return tryToPair(bluetoothDevice, getDeviceBoundWay(bluetoothDevice));
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothPair
    public boolean tryToUnPair(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null) {
            return false;
        }
        return addPairTask(new PairTask(1, bluetoothDevice));
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothPair
    @SuppressLint({"MissingPermission"})
    public boolean unPair(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null) {
            JL_Log.e(TAG, "unPair", "device is null.");
            return false;
        }
        boolean zRemoveBond = BluetoothUtil.removeBond(this.mContext, bluetoothDevice);
        JL_Log.w(TAG, "unPair", "removeBond : " + zRemoveBond);
        if (zRemoveBond) {
            startPairTimeOut(bluetoothDevice);
        }
        return zRemoveBond;
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBase
    public void addListener(OnBtDevicePairListener onBtDevicePairListener) {
        this.mBtPairEventCbManager.addListener(onBtDevicePairListener);
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBase
    public void removeListener(OnBtDevicePairListener onBtDevicePairListener) {
        this.mBtPairEventCbManager.removeListener(onBtDevicePairListener);
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothPair
    public boolean tryToPair(BluetoothDevice bluetoothDevice, int i) {
        if (bluetoothDevice == null) {
            return false;
        }
        return addPairTask(new PairTask(0, bluetoothDevice).setPairWay(i));
    }

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothPair
    @SuppressLint({"MissingPermission"})
    public boolean pair(BluetoothDevice bluetoothDevice, int i) {
        boolean zCreateBond;
        if (bluetoothDevice == null || !ConnectUtil.isHasConnectPermission(this.mContext)) {
            JL_Log.w(TAG, "pair", "device is null");
            return false;
        }
        if (i < 0 || i > 2) {
            i = 0;
        }
        if (i == 0) {
            zCreateBond = BluetoothUtil.createBond(this.mContext, bluetoothDevice);
            JL_Log.d(TAG, "pair", "createBond ---> " + zCreateBond);
        } else {
            boolean zCreateBond2 = BluetoothUtil.createBond(this.mContext, bluetoothDevice, i);
            String str = TAG;
            JL_Log.d(str, "pair", "createBond pairWay = " + i + ", result : " + zCreateBond2);
            if (zCreateBond2) {
                zCreateBond = zCreateBond2;
            } else {
                zCreateBond = BluetoothUtil.createBond(this.mContext, bluetoothDevice);
                JL_Log.i(str, "pair", "Failed to pair with way, so createBond result : " + zCreateBond);
            }
        }
        if (!zCreateBond) {
            return false;
        }
        startPairTimeOut(bluetoothDevice);
        return true;
    }
}
