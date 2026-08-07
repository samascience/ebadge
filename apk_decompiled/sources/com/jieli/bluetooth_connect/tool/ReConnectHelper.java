package com.jieli.bluetooth_connect.tool;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.jieli.bluetooth_connect.bean.ble.BleScanMessage;
import com.jieli.bluetooth_connect.bean.history.HistoryRecord;
import com.jieli.bluetooth_connect.impl.BluetoothManager;
import com.jieli.bluetooth_connect.interfaces.IBluetoothOperation;
import com.jieli.bluetooth_connect.interfaces.callback.BluetoothEventCallback;
import com.jieli.bluetooth_connect.interfaces.callback.OnHistoryRecordCallback;
import com.jieli.bluetooth_connect.util.BluetoothUtil;
import com.jieli.bluetooth_connect.util.ConnectUtil;
import com.jieli.bluetooth_connect.util.JL_Log;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class ReConnectHelper {
    private static final long DEFAULT_TASK_TIMEOUT = 50000;
    private static final long DELAY = 2000;
    private static final int FAIL_CONNECT_MAX = 2;
    private static final int MSG_RECONNECT = 39271;
    private static final int MSG_RECONNECT_TIMEOUT = 39270;
    private static final long RECONNECT_TIMEOUT = 52000;
    private static final long SCAN_LIMIT = 16000;
    private static final int STATE_CONNECTING = 2;
    private static final int STATE_IDLE = 0;
    private static final int STATE_SCANNING = 1;
    private static final String TAG = "ReConnectHelper";
    private static int sTaskID = 1;
    private final BluetoothEventCallback mBluetoothEventCallback;
    private final IBluetoothOperation mBtOp;
    private final Context mContext;
    private long startTime;
    private final List<ReconnectTask> mTaskList = new CopyOnWriteArrayList();
    private int taskState = 0;
    private final Handler mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: tc2
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            return this.a.lambda$new$0(message);
        }
    });

    public static class ReconnectTask {
        public static final int TASK_TYPE_DEVICE = 1;
        public static final int TASK_TYPE_HISTORY = 2;
        private String address;
        private OnHistoryRecordCallback callback;
        private int connectFailCount;
        private int connectWay;
        private int taskId;
        private int taskTimeout;
        private int taskType;

        public ReconnectTask(String str) {
            setAddress(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            ReconnectTask reconnectTask = (ReconnectTask) obj;
            return this.taskType == reconnectTask.taskType && Objects.equals(this.address, reconnectTask.address);
        }

        public String getAddress() {
            return this.address;
        }

        public OnHistoryRecordCallback getCallback() {
            return this.callback;
        }

        public int getConnectFailCount() {
            return this.connectFailCount;
        }

        public int getConnectWay() {
            return this.connectWay;
        }

        public int getTaskId() {
            return this.taskId;
        }

        public int getTaskTimeout() {
            return this.taskTimeout;
        }

        public int getTaskType() {
            return this.taskType;
        }

        public int hashCode() {
            return Objects.hash(this.address, Integer.valueOf(this.taskType));
        }

        public void setAddress(String str) {
            this.address = str;
        }

        public void setCallback(OnHistoryRecordCallback onHistoryRecordCallback) {
            this.callback = onHistoryRecordCallback;
        }

        public void setConnectFailCount(int i) {
            this.connectFailCount = i;
        }

        public void setConnectWay(int i) {
            this.connectWay = i;
        }

        public void setTaskId(int i) {
            this.taskId = i;
        }

        public void setTaskTimeout(int i) {
            this.taskTimeout = i;
        }

        public void setTaskType(int i) {
            this.taskType = i;
        }

        public String toString() {
            return "ReconnectTask{taskId=" + this.taskId + ", address='" + this.address + "', connectWay=" + this.connectWay + ", taskType=" + this.taskType + ", taskTimeout=" + this.taskTimeout + ", connectFailCount=" + this.connectFailCount + '}';
        }
    }

    public ReConnectHelper(Context context, IBluetoothOperation iBluetoothOperation) {
        BluetoothEventCallback bluetoothEventCallback = new BluetoothEventCallback() { // from class: com.jieli.bluetooth_connect.tool.ReConnectHelper.1
            @Override // com.jieli.bluetooth_connect.interfaces.callback.BluetoothEventCallback, com.jieli.bluetooth_connect.interfaces.callback.IBluetoothEventCallback
            public void onAdapterStatus(boolean z, boolean z2) {
                if (ReConnectHelper.this.isReconnecting()) {
                    if (z) {
                        ReConnectHelper.this.postReconnectTaskMsg(0L);
                    } else {
                        ReConnectHelper.this.setTaskState(0);
                    }
                }
            }

            @Override // com.jieli.bluetooth_connect.interfaces.callback.BluetoothEventCallback, com.jieli.bluetooth_connect.interfaces.callback.IBluetoothEventCallback
            public void onConnection(BluetoothDevice bluetoothDevice, int i) {
                if (ReConnectHelper.this.isReconnecting()) {
                    if (i == 1) {
                        return;
                    }
                    boolean zIsReconnectDev = ReConnectHelper.this.isReconnectDev(bluetoothDevice);
                    JL_Log.i(ReConnectHelper.TAG, "onConnection", "device ： " + ReConnectHelper.this.printBtDeviceInfo(bluetoothDevice) + ", status : " + i + ", isReconnectDevice = " + zIsReconnectDev);
                    if (zIsReconnectDev) {
                        ReConnectHelper.this.setTaskState(0);
                        ReConnectHelper.this.removeTask(bluetoothDevice.getAddress(), i == 2);
                    }
                }
            }

            @Override // com.jieli.bluetooth_connect.interfaces.callback.BluetoothEventCallback, com.jieli.bluetooth_connect.interfaces.callback.IBluetoothEventCallback
            public void onDiscovery(BluetoothDevice bluetoothDevice, BleScanMessage bleScanMessage) {
                ReconnectTask reconnectTaskFindReconnectTask;
                if (bluetoothDevice == null || bleScanMessage == null || !ReConnectHelper.this.isReconnecting()) {
                    return;
                }
                String address = bluetoothDevice.getAddress();
                JL_Log.d(ReConnectHelper.TAG, "onDiscovery", "device : " + ReConnectHelper.this.printBtDeviceInfo(bluetoothDevice) + ", " + bleScanMessage);
                if (bleScanMessage.isOTA()) {
                    reconnectTaskFindReconnectTask = ReConnectHelper.this.findReconnectTask(bleScanMessage.getOtaBleAddress());
                    if (reconnectTaskFindReconnectTask == null) {
                        reconnectTaskFindReconnectTask = ReConnectHelper.this.findReconnectTask(address);
                    }
                    if (reconnectTaskFindReconnectTask != null) {
                        if (reconnectTaskFindReconnectTask.getConnectWay() != 0) {
                            reconnectTaskFindReconnectTask.setConnectWay(0);
                        }
                        HistoryRecord historyRecord = ReConnectHelper.this.mBtOp.getHistoryRecord(address);
                        if (historyRecord != null && !bluetoothDevice.getAddress().equals(historyRecord.getUpdateAddress())) {
                            historyRecord.setUpdateAddress(bluetoothDevice.getAddress());
                            ((BluetoothManager) ReConnectHelper.this.mBtOp).getHistoryRecordHelper().updateHistoryRecord(historyRecord);
                        }
                    } else {
                        bluetoothDevice = null;
                    }
                } else {
                    ReconnectTask reconnectTaskFindReconnectTask2 = ReConnectHelper.this.findReconnectTask(address);
                    if (reconnectTaskFindReconnectTask2 != null) {
                        bluetoothDevice = ReConnectHelper.this.findTargetDevice(bluetoothDevice, bleScanMessage, reconnectTaskFindReconnectTask2.getConnectWay());
                        reconnectTaskFindReconnectTask = reconnectTaskFindReconnectTask2;
                    } else {
                        reconnectTaskFindReconnectTask = reconnectTaskFindReconnectTask2;
                        bluetoothDevice = null;
                    }
                }
                JL_Log.i(ReConnectHelper.TAG, "onDiscovery", "connectDev = " + ReConnectHelper.this.printBtDeviceInfo(bluetoothDevice) + ", " + reconnectTaskFindReconnectTask);
                if (bluetoothDevice != null) {
                    ReConnectHelper.this.connectBtDevice(bluetoothDevice, reconnectTaskFindReconnectTask);
                }
            }

            @Override // com.jieli.bluetooth_connect.interfaces.callback.BluetoothEventCallback, com.jieli.bluetooth_connect.interfaces.callback.IBluetoothEventCallback
            public void onDiscoveryStatus(boolean z, boolean z2) {
                if (ReConnectHelper.this.isReconnecting()) {
                    JL_Log.i(ReConnectHelper.TAG, "onDiscoveryStatus", "Start ： " + z2);
                    if (z2 || ReConnectHelper.this.taskState > 1) {
                        return;
                    }
                    ReConnectHelper.this.setTaskState(0);
                    ReConnectHelper.this.postReconnectTaskMsg(ReConnectHelper.DELAY);
                }
            }
        };
        this.mBluetoothEventCallback = bluetoothEventCallback;
        this.mContext = (Context) ConnectUtil.checkNotNull(context);
        IBluetoothOperation iBluetoothOperation2 = (IBluetoothOperation) ConnectUtil.checkNotNull(iBluetoothOperation);
        this.mBtOp = iBluetoothOperation2;
        iBluetoothOperation2.registerBluetoothCallback(bluetoothEventCallback);
    }

    private void addTask(ReconnectTask reconnectTask) {
        boolean zAdd = false;
        i = 0;
        int i = 0;
        zAdd = false;
        if (reconnectTask != null && !this.mTaskList.contains(reconnectTask)) {
            if (reconnectTask.getTaskType() == 1) {
                if (!this.mTaskList.isEmpty()) {
                    Iterator it = new ArrayList(this.mTaskList).iterator();
                    while (it.hasNext()) {
                        if (1 == ((ReconnectTask) it.next()).getTaskType()) {
                            i++;
                        }
                    }
                }
                this.mTaskList.add(i, reconnectTask);
                zAdd = true;
            } else {
                zAdd = this.mTaskList.add(reconnectTask);
            }
        }
        if (zAdd) {
            reconnectTask.setTaskId(autoIncTaskId());
            if (reconnectTask.getTaskTimeout() == 0) {
                reconnectTask.setTaskTimeout(50000);
            }
            JL_Log.d(TAG, "addTask", Constants.STR_EMPTY + reconnectTask);
            this.mHandler.removeMessages(reconnectTask.getTaskId());
            Handler handler = this.mHandler;
            handler.sendMessageDelayed(handler.obtainMessage(reconnectTask.getTaskId(), reconnectTask.getAddress()), (long) reconnectTask.getTaskTimeout());
            setStartTime(getCurrentTime());
            this.mHandler.removeMessages(MSG_RECONNECT_TIMEOUT);
            this.mHandler.sendEmptyMessageDelayed(MSG_RECONNECT_TIMEOUT, RECONNECT_TIMEOUT);
            postReconnectTaskMsg(0L);
        }
    }

    private static int autoIncTaskId() {
        int i = sTaskID;
        int i2 = i + 1;
        sTaskID = i2;
        if (i2 >= 256) {
            sTaskID = 1;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void connectBtDevice(BluetoothDevice bluetoothDevice, ReconnectTask reconnectTask) {
        String str = TAG;
        JL_Log.d(str, "connectBtDevice", "Ready to connect device. " + bluetoothDevice + ", " + reconnectTask);
        setTaskState(2);
        stopScan();
        if (this.mBtOp.connectBtDevice(bluetoothDevice, reconnectTask.getConnectWay())) {
            return;
        }
        int connectFailCount = reconnectTask.getConnectFailCount() + 1;
        setTaskState(0);
        JL_Log.w(str, "connectBtDevice", "Connect device failed. Failure count = " + connectFailCount + ", limit = 2");
        if (connectFailCount >= 2) {
            removeTask(reconnectTask, false);
        } else {
            reconnectTask.setConnectFailCount(connectFailCount);
            postReconnectTaskMsg(DELAY);
        }
    }

    private void doReconnectEvent(ReconnectTask reconnectTask) {
        boolean zStartDeviceScan;
        if (!BluetoothUtil.isBluetoothEnable()) {
            JL_Log.w(TAG, "doReconnectEvent", "bluetooth is close.");
            return;
        }
        if (isTaskRunning()) {
            JL_Log.w(TAG, "doReconnectEvent", "task is running.");
            return;
        }
        if (reconnectTask.getTaskType() == 2 && this.mBtOp.getConnectedDevice() != null && !this.mBtOp.getBluetoothOption().isUseMultiDevice()) {
            JL_Log.w(TAG, "doReconnectEvent", "single device manager ");
            stopReconnect();
            return;
        }
        BluetoothDevice bluetoothDeviceFindSysConnectedDevice = findSysConnectedDevice(reconnectTask.address);
        String str = TAG;
        JL_Log.i(str, "doReconnectEvent", "device ： " + printBtDeviceInfo(bluetoothDeviceFindSysConnectedDevice) + ", reconnectTask = " + reconnectTask);
        if (bluetoothDeviceFindSysConnectedDevice != null) {
            connectBtDevice(bluetoothDeviceFindSysConnectedDevice, reconnectTask);
            return;
        }
        if (this.mBtOp.isScanning()) {
            boolean z = this.mBtOp.getScanType() == 2;
            if (!z) {
                z = (reconnectTask.getConnectWay() == 1 && this.mBtOp.getScanType() == 1) || (reconnectTask.getConnectWay() == 0 && this.mBtOp.getScanType() == 0);
            }
            JL_Log.i(str, "doReconnectEvent", "isScanOk : " + z);
            if (z) {
                return;
            }
            stopScan();
            try {
                Thread.sleep(50L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long nowLeftTime = getNowLeftTime();
        String str2 = TAG;
        JL_Log.d(str2, "doReconnectEvent", "leftTime ： " + nowLeftTime + ", startTime : " + this.startTime);
        if (nowLeftTime < 20000) {
            int i = reconnectTask.getConnectWay() == 1 ? 0 : 2;
            zStartDeviceScan = this.mBtOp.startDeviceScan(i, nowLeftTime);
            JL_Log.i(str2, "doReconnectEvent", "startDeviceScan : " + zStartDeviceScan + ", way = " + i);
        } else if (reconnectTask.getConnectWay() == 1) {
            zStartDeviceScan = this.mBtOp.startDeviceScan(16000L);
            JL_Log.i(str2, "doReconnectEvent", "startDeviceScan ---> " + zStartDeviceScan);
        } else {
            zStartDeviceScan = this.mBtOp.startBLEScan(16000L);
            JL_Log.i(str2, "doReconnectEvent", "startBLEScan ---> " + zStartDeviceScan);
        }
        if (zStartDeviceScan) {
            setTaskState(1);
        } else {
            postReconnectTaskMsg(DELAY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ReconnectTask findReconnectTask(String str) {
        if (!BluetoothAdapter.checkBluetoothAddress(str) || this.mTaskList.isEmpty()) {
            return null;
        }
        for (ReconnectTask reconnectTask : new ArrayList(this.mTaskList)) {
            if (str.equals(reconnectTask.getAddress())) {
                return reconnectTask;
            }
        }
        return null;
    }

    private BluetoothDevice findSysConnectedDevice(String str) {
        List<BluetoothDevice> systemConnectedBtDeviceList = BluetoothUtil.getSystemConnectedBtDeviceList(this.mContext);
        if (systemConnectedBtDeviceList != null) {
            for (BluetoothDevice bluetoothDevice : systemConnectedBtDeviceList) {
                if (bluetoothDevice.getAddress().equals(str)) {
                    return bluetoothDevice;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"MissingPermission"})
    public BluetoothDevice findTargetDevice(BluetoothDevice bluetoothDevice, BleScanMessage bleScanMessage, int i) {
        HistoryRecord historyRecord;
        BluetoothDevice remoteDevice;
        if (i != 0) {
            BluetoothDevice remoteDevice2 = getRemoteDevice(bleScanMessage.getEdrAddr());
            if (remoteDevice2 == null && (historyRecord = this.mBtOp.getHistoryRecord(bluetoothDevice.getAddress())) != null) {
                remoteDevice2 = getRemoteDevice(historyRecord.getConnectType() == 1 ? historyRecord.getAddress() : historyRecord.getMappedAddress());
            }
            return remoteDevice2 != null ? remoteDevice2 : bluetoothDevice;
        }
        if (!ConnectUtil.isHasConnectPermission(this.mContext) || bluetoothDevice.getType() != 1) {
            return bluetoothDevice;
        }
        HistoryRecord historyRecord2 = this.mBtOp.getHistoryRecord(bluetoothDevice.getAddress());
        if (historyRecord2 != null) {
            remoteDevice = getRemoteDevice(historyRecord2.getConnectType() == 0 ? historyRecord2.getAddress() : historyRecord2.getMappedAddress());
        } else {
            remoteDevice = null;
        }
        return (remoteDevice == null || BluetoothUtil.deviceEquals(bluetoothDevice, remoteDevice)) ? bluetoothDevice : remoteDevice;
    }

    private long getCurrentTime() {
        return System.currentTimeMillis();
    }

    private long getNowLeftTime() {
        return RECONNECT_TIMEOUT - (getCurrentTime() - this.startTime);
    }

    private BluetoothDevice getRemoteDevice(String str) {
        return BluetoothUtil.getRemoteDevice(this.mContext, str);
    }

    private boolean isMatchAddress(String str, String str2) {
        if (!BluetoothAdapter.checkBluetoothAddress(str) || !BluetoothAdapter.checkBluetoothAddress(str2)) {
            return false;
        }
        HistoryRecord historyRecord = this.mBtOp.getHistoryRecord(str);
        if (historyRecord == null) {
            return str.equals(str2);
        }
        return str2.equals(historyRecord.getAddress()) || str2.equals(historyRecord.getMappedAddress()) || str2.equals(historyRecord.getUpdateAddress());
    }

    private boolean isTaskRunning() {
        return this.mBtOp.isConnecting() || this.mBtOp.isScanning() || this.taskState != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$new$0(Message message) {
        switch (message.what) {
            case MSG_RECONNECT_TIMEOUT /* 39270 */:
                JL_Log.w(TAG, "MSG_RECONNECT_TIMEOUT", Constants.STR_EMPTY);
                stopReconnect();
                break;
            case MSG_RECONNECT /* 39271 */:
                JL_Log.i(TAG, "MSG_RECONNECT", Constants.STR_EMPTY);
                startReconnectTask();
                break;
            default:
                Object obj = message.obj;
                if (obj instanceof String) {
                    String str = (String) obj;
                    JL_Log.w(TAG, "TASK_TIMEOUT", "address ： " + str);
                    removeTask(str, false);
                }
                break;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postReconnectTaskMsg(long j) {
        this.mHandler.removeMessages(MSG_RECONNECT);
        if (j > 0) {
            this.mHandler.sendEmptyMessageDelayed(MSG_RECONNECT, j);
        } else {
            this.mHandler.sendEmptyMessage(MSG_RECONNECT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String printBtDeviceInfo(BluetoothDevice bluetoothDevice) {
        return BluetoothUtil.printBtDeviceInfo(this.mContext, bluetoothDevice);
    }

    private void release() {
        setTaskState(0);
        setStartTime(0L);
        this.mHandler.removeMessages(MSG_RECONNECT_TIMEOUT);
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeTask(String str, boolean z) {
        ReconnectTask reconnectTaskFindReconnectTask = findReconnectTask(str);
        if (reconnectTaskFindReconnectTask != null) {
            removeTask(reconnectTaskFindReconnectTask, z);
        }
    }

    private void setStartTime(long j) {
        this.startTime = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTaskState(int i) {
        this.taskState = i;
    }

    private void startReconnectTask() {
        if (this.mTaskList.isEmpty() || !isReconnecting() || isTaskRunning()) {
            return;
        }
        ReconnectTask reconnectTask = this.mTaskList.get(0);
        long nowLeftTime = getNowLeftTime();
        JL_Log.i(TAG, "startReconnectTask", "left = " + nowLeftTime + ", start reconnect task.");
        doReconnectEvent(reconnectTask);
    }

    private void stopScan() {
        if (this.mBtOp.isScanning()) {
            if (this.mBtOp.getScanType() == 0) {
                this.mBtOp.stopBLEScan();
            } else {
                this.mBtOp.stopDeviceScan();
            }
        }
    }

    public void destroy() {
        stopReconnect();
        this.mBtOp.unregisterBluetoothCallback(this.mBluetoothEventCallback);
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean isReconnectDev(BluetoothDevice bluetoothDevice) {
        return (bluetoothDevice == null || findReconnectTask(bluetoothDevice.getAddress()) == null) ? false : true;
    }

    public boolean isReconnecting() {
        return this.mHandler.hasMessages(MSG_RECONNECT_TIMEOUT);
    }

    public void reconnectDevice(String str, int i, OnHistoryRecordCallback onHistoryRecordCallback) {
        reconnectDevice(str, i, 0, onHistoryRecordCallback);
    }

    public void reconnectHistory(HistoryRecord historyRecord) {
        int i = 0;
        boolean z = historyRecord.getDevType() == 5 || historyRecord.getSdkFlag() == 8 || historyRecord.getSdkFlag() == 9;
        String mappedAddress = (historyRecord.getConnectType() == 1 && z) ? historyRecord.getMappedAddress() : historyRecord.getAddress();
        int connectType = z ? 0 : historyRecord.getConnectType();
        if (!BluetoothAdapter.checkBluetoothAddress(historyRecord.getUpdateAddress()) || historyRecord.getUpdateAddress().equals(mappedAddress)) {
            i = connectType;
        } else {
            mappedAddress = historyRecord.getUpdateAddress();
        }
        ReconnectTask reconnectTask = new ReconnectTask(mappedAddress);
        reconnectTask.setConnectWay(i);
        reconnectTask.setTaskType(2);
        addTask(reconnectTask);
    }

    public void stopReconnect() {
        if (!this.mTaskList.isEmpty()) {
            for (ReconnectTask reconnectTask : new ArrayList(this.mTaskList)) {
                if (reconnectTask.getCallback() != null) {
                    reconnectTask.getCallback().onFailed(0, "Reconnect task is stop.");
                }
                this.mHandler.removeMessages(reconnectTask.getTaskId());
            }
            this.mTaskList.clear();
        }
        release();
    }

    public void reconnectDevice(String str, int i, int i2, OnHistoryRecordCallback onHistoryRecordCallback) {
        if (!BluetoothAdapter.checkBluetoothAddress(str)) {
            if (onHistoryRecordCallback != null) {
                onHistoryRecordCallback.onFailed(1, "Address is error.");
            }
        } else {
            ReconnectTask reconnectTask = new ReconnectTask(str);
            reconnectTask.setTaskType(1);
            reconnectTask.setConnectWay(i);
            reconnectTask.setTaskTimeout(i2);
            reconnectTask.setCallback(onHistoryRecordCallback);
            addTask(reconnectTask);
        }
    }

    private void removeTask(ReconnectTask reconnectTask, boolean z) {
        boolean zRemove = this.mTaskList.remove(reconnectTask);
        JL_Log.w(TAG, "removeTask", reconnectTask + ", ret = " + zRemove + ", result = " + z);
        if (zRemove) {
            if (reconnectTask.getCallback() != null) {
                if (z) {
                    reconnectTask.getCallback().onSuccess(this.mBtOp.getHistoryRecord(reconnectTask.getAddress()));
                } else {
                    reconnectTask.getCallback().onFailed(9, ConnectUtil.formatString("Connect device[%s] timeout.", reconnectTask.getAddress()));
                }
            }
            this.mHandler.removeMessages(reconnectTask.getTaskId());
            if (!this.mTaskList.isEmpty()) {
                postReconnectTaskMsg(0L);
            } else {
                stopReconnect();
            }
        }
    }
}
