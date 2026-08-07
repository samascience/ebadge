package com.jieli.jl_rcsp.impl;

import android.bluetooth.BluetoothDevice;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.jieli.jl_rcsp.constant.RcspConstant;
import com.jieli.jl_rcsp.interfaces.listener.LibLoader;
import com.jieli.jl_rcsp.util.CHexConver;
import com.jieli.jl_rcsp.util.JL_Log;
import com.jieli.jl_rcsp.util.RcspUtil;
import com.tencent.connect.common.Constants;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class RcspAuth {
    private static final int AUTH_RETRY_COUNT = 2;
    private static final long DEFAULT_AUTH_TIMEOUT = 3000;
    private static long DELAY_AUTH_WAITING_TIME = 3000;
    public static final int ERR_AUTH_DATA_CHECK = 40980;
    public static final int ERR_AUTH_DATA_SEND = 40979;
    public static final int ERR_AUTH_DEVICE_TIMEOUT = 40977;
    public static final int ERR_AUTH_USER_STOP = 40978;
    public static final int ERR_NONE = 0;
    private static final int MSG_AUTH_DEVICE_TIMEOUT = 18;
    private static final int MSG_SEND_AUTH_DATA_TIMEOUT = 17;
    private static final String TAG = "RcspAuth";
    private static volatile boolean mIsLibLoaded = false;
    public static final LibLoader sLocalLibLoader = new LibLoader() { // from class: pa2
        @Override // com.jieli.jl_rcsp.interfaces.listener.LibLoader
        public final void loadLibrary(String str) {
            System.loadLibrary(str);
        }
    };
    private boolean isLibInit;
    private final Map<String, AuthTask> mAuthTaskMap = Collections.synchronizedMap(new HashMap());
    private final Handler mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.jieli.jl_rcsp.impl.RcspAuth.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message == null) {
                return false;
            }
            int i = message.what;
            if (i == 17) {
                BluetoothDevice bluetoothDevice = (BluetoothDevice) message.obj;
                AuthTask authTask = (AuthTask) RcspAuth.this.mAuthTaskMap.get(bluetoothDevice.getAddress());
                if (authTask == null) {
                    return false;
                }
                if (authTask.getRetryNum() < 2) {
                    authTask.setRetryNum(authTask.getRetryNum() + 1);
                    RcspAuth.this.mRcspAuthOp.sendAuthDataToDevice(authTask.getDevice(), authTask.getRandomData());
                    RcspAuth.this.mHandler.removeMessages(18);
                    RcspAuth.this.mHandler.sendMessageDelayed(RcspAuth.this.mHandler.obtainMessage(17, bluetoothDevice), RcspAuth.DELAY_AUTH_WAITING_TIME);
                } else {
                    RcspAuth.this.onAuthFailed(bluetoothDevice, 40977);
                }
            } else if (i == 18) {
                BluetoothDevice bluetoothDevice2 = (BluetoothDevice) message.obj;
                AuthTask authTask2 = (AuthTask) RcspAuth.this.mAuthTaskMap.get(bluetoothDevice2.getAddress());
                if (authTask2 != null && !authTask2.isAuthDevice()) {
                    RcspAuth.this.onAuthFailed(bluetoothDevice2, 40977);
                }
            }
            return true;
        }
    });
    private final OnRcspAuthListener mListener;
    private final IRcspAuthOp mRcspAuthOp;

    public static class AuthTask {
        public BluetoothDevice a;
        public boolean b;
        public boolean c;
        public byte[] d;
        public int e;

        public AuthTask() {
        }

        public BluetoothDevice getDevice() {
            return this.a;
        }

        public byte[] getRandomData() {
            return this.d;
        }

        public int getRetryNum() {
            return this.e;
        }

        public boolean isAuthDevice() {
            return this.c;
        }

        public boolean isAuthProgressResult() {
            return this.b;
        }

        public void setAuthDevice(boolean z) {
            this.c = z;
        }

        public void setAuthProgressResult(boolean z) {
            this.b = z;
        }

        public AuthTask setDevice(BluetoothDevice bluetoothDevice) {
            this.a = bluetoothDevice;
            return this;
        }

        public AuthTask setRandomData(byte[] bArr) {
            this.d = bArr;
            return this;
        }

        public void setRetryNum(int i) {
            this.e = i;
        }

        public String toString() {
            return "AuthTask{device=" + this.a + ", isAuthProgressResult=" + this.b + ", isAuthDevice=" + this.c + ", randomData=" + CHexConver.byte2HexStr(this.d) + ", retryNum=" + this.e + '}';
        }
    }

    public interface IRcspAuthOp {
        boolean sendAuthDataToDevice(BluetoothDevice bluetoothDevice, byte[] bArr);
    }

    public interface OnRcspAuthListener {
        void onAuthFailed(BluetoothDevice bluetoothDevice, int i, String str);

        void onAuthSuccess(BluetoothDevice bluetoothDevice);

        void onInitResult(boolean z);
    }

    public RcspAuth(IRcspAuthOp iRcspAuthOp, OnRcspAuthListener onRcspAuthListener) {
        if (iRcspAuthOp == null) {
            throw new IllegalArgumentException("IRcspAuthOp can not be null.");
        }
        this.mRcspAuthOp = iRcspAuthOp;
        this.mListener = onRcspAuthListener;
        loadLibrariesOnce(null);
        boolean zNativeInit = nativeInit();
        this.isLibInit = zNativeInit;
        onInitResult(zNativeInit);
    }

    private String getErrorMsg(int i) {
        switch (i) {
            case 40977:
                return "Auth device timeout.";
            case 40978:
                return "User stop auth device.";
            case 40979:
                return "Failed to send data.";
            case 40980:
                return "Check auth data error.";
            default:
                return Constants.STR_EMPTY;
        }
    }

    private byte[] getResetAuthFlagCmdData() {
        return CHexConver.hexStr2Bytes("FEDCBAC00600020001EF");
    }

    private boolean isValidAuthData(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return false;
        }
        if (bArr.length != 5 || bArr[0] != 2) {
            if (bArr.length != 17) {
                return false;
            }
            byte b = bArr[0];
            if (b != 0 && b != 1) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startAuth$0(BluetoothDevice bluetoothDevice, AuthTask authTask) {
        if (!this.mRcspAuthOp.sendAuthDataToDevice(bluetoothDevice, authTask.getRandomData())) {
            onAuthFailed(bluetoothDevice, 40979, "Failed to send data.");
            return;
        }
        this.mHandler.removeMessages(17);
        Handler handler = this.mHandler;
        handler.sendMessageDelayed(handler.obtainMessage(17, bluetoothDevice), DELAY_AUTH_WAITING_TIME);
    }

    public static void loadLibrariesOnce(LibLoader libLoader) {
        synchronized (RcspAuth.class) {
            try {
                if (!mIsLibLoaded) {
                    if (libLoader == null) {
                        libLoader = sLocalLibLoader;
                    }
                    libLoader.loadLibrary(RcspConstant.JL_RCSP_LIB);
                    mIsLibLoaded = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAuthFailed(BluetoothDevice bluetoothDevice, int i) {
        onAuthFailed(bluetoothDevice, i, getErrorMsg(i));
    }

    private void onAuthSuccess(BluetoothDevice bluetoothDevice) {
        JL_Log.w(TAG, "onAuthSuccess", RcspUtil.formatString("device = %s, auth ok.", bluetoothDevice));
        if (bluetoothDevice != null) {
            this.mAuthTaskMap.remove(bluetoothDevice.getAddress());
        }
        OnRcspAuthListener onRcspAuthListener = this.mListener;
        if (onRcspAuthListener != null) {
            onRcspAuthListener.onAuthSuccess(bluetoothDevice);
        }
    }

    private void onInitResult(boolean z) {
        OnRcspAuthListener onRcspAuthListener = this.mListener;
        if (onRcspAuthListener != null) {
            onRcspAuthListener.onInitResult(z);
        }
    }

    public static boolean setAuthTimeout(long j) {
        if (j >= DEFAULT_AUTH_TIMEOUT) {
            DELAY_AUTH_WAITING_TIME = j;
            return true;
        }
        JL_Log.d(TAG, "setAuthTimeout", "The timeout is too short to be set successfully.  timeout : " + j);
        return false;
    }

    @Deprecated
    public void addListener(OnRcspAuthListener onRcspAuthListener) {
    }

    public void destroy() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mAuthTaskMap.clear();
        this.isLibInit = false;
        mIsLibLoaded = false;
    }

    public byte[] getAuthData(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return getEncryptedAuthData(bArr);
    }

    public byte[] getAuthOkData() {
        return new byte[]{2, 112, 97, 115, 115};
    }

    public native byte[] getEncryptedAuthData(byte[] bArr);

    public native byte[] getRandomAuthData();

    public byte[] getRandomData() {
        return getRandomAuthData();
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00b2  */
    public void handleAuthData(BluetoothDevice bluetoothDevice, byte[] bArr) {
        AuthTask authTask;
        int i;
        if (bluetoothDevice == null || !this.isLibInit || !isValidAuthData(bArr) || (authTask = this.mAuthTaskMap.get(bluetoothDevice.getAddress())) == null || authTask.isAuthDevice()) {
            return;
        }
        String str = TAG;
        JL_Log.d(str, "handleAuthData", RcspUtil.formatString("Device : %s, data : %s", bluetoothDevice, CHexConver.byte2HexStr(bArr)));
        if (authTask.isAuthProgressResult()) {
            if (bArr.length == 17 && bArr[0] == 0) {
                byte[] authData = getAuthData(bArr);
                JL_Log.i(str, "handleAuthData", "devAuthData : " + CHexConver.byte2HexStr(authData));
                if (!this.mRcspAuthOp.sendAuthDataToDevice(bluetoothDevice, authData)) {
                    i = 40979;
                }
            } else {
                if (!Arrays.equals(bArr, getAuthOkData())) {
                    return;
                }
                authTask.setAuthDevice(true);
                onAuthSuccess(bluetoothDevice);
            }
            i = 0;
        } else {
            if (bArr.length != 17 || bArr[0] != 1) {
                return;
            }
            byte[] authData2 = getAuthData(authTask.getRandomData());
            if (authData2 == null || !Arrays.equals(authData2, bArr)) {
                JL_Log.w(str, "handleAuthData", "Data not match. authData : " + CHexConver.byte2HexStr(authData2));
                i = 40980;
            } else if (this.mRcspAuthOp.sendAuthDataToDevice(bluetoothDevice, getAuthOkData())) {
                i = 0;
            } else {
                i = 40979;
            }
        }
        authTask.setAuthProgressResult(i == 0);
        if (i != 0) {
            authTask.setAuthDevice(false);
            onAuthFailed(bluetoothDevice, i, getErrorMsg(i));
            return;
        }
        this.mHandler.removeMessages(17);
        this.mHandler.removeMessages(18);
        if (authTask.isAuthDevice()) {
            return;
        }
        Handler handler = this.mHandler;
        handler.sendMessageDelayed(handler.obtainMessage(18, bluetoothDevice), DELAY_AUTH_WAITING_TIME);
    }

    public native boolean nativeInit();

    @Deprecated
    public void removeListener(OnRcspAuthListener onRcspAuthListener) {
    }

    public int setDeviceConnectionLinkKey(byte[] bArr) {
        return setLinkKey(bArr);
    }

    public native int setLinkKey(byte[] bArr);

    public boolean startAuth(final BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null || !this.isLibInit) {
            return false;
        }
        if (this.mAuthTaskMap.containsKey(bluetoothDevice.getAddress())) {
            AuthTask authTask = this.mAuthTaskMap.get(bluetoothDevice.getAddress());
            if (authTask != null && (authTask.isAuthDevice() || this.mHandler.hasMessages(18))) {
                JL_Log.i(TAG, "startAuth", "The device has been certified or certification of device is in progress.");
                return true;
            }
            this.mAuthTaskMap.remove(bluetoothDevice.getAddress());
        }
        JL_Log.d(TAG, "startAuth", "device : " + RcspUtil.printBtDeviceInfo(bluetoothDevice));
        final AuthTask randomData = new AuthTask().setDevice(bluetoothDevice).setRandomData(getRandomData());
        this.mAuthTaskMap.put(bluetoothDevice.getAddress(), randomData);
        boolean zSendAuthDataToDevice = this.mRcspAuthOp.sendAuthDataToDevice(bluetoothDevice, getResetAuthFlagCmdData());
        if (zSendAuthDataToDevice) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.jieli.jl_rcsp.impl.f
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.lambda$startAuth$0(bluetoothDevice, randomData);
                }
            }, 500L);
        }
        return zSendAuthDataToDevice;
    }

    public void stopAuth(BluetoothDevice bluetoothDevice) {
        stopAuth(bluetoothDevice, true);
    }

    private void onAuthFailed(BluetoothDevice bluetoothDevice, int i, String str) {
        JL_Log.e(TAG, "onAuthFailed", RcspUtil.formatString("Device = %s, code = %d, message = %s.", bluetoothDevice, Integer.valueOf(i), str));
        this.mHandler.removeMessages(17);
        this.mHandler.removeMessages(18);
        if (bluetoothDevice != null) {
            this.mAuthTaskMap.remove(bluetoothDevice.getAddress());
        }
        OnRcspAuthListener onRcspAuthListener = this.mListener;
        if (onRcspAuthListener != null) {
            onRcspAuthListener.onAuthFailed(bluetoothDevice, i, str);
        }
    }

    public void stopAuth(BluetoothDevice bluetoothDevice, boolean z) {
        if (bluetoothDevice == null || !this.isLibInit) {
            return;
        }
        AuthTask authTaskRemove = this.mAuthTaskMap.remove(bluetoothDevice.getAddress());
        if (z) {
            if (authTaskRemove != null) {
                onAuthFailed(bluetoothDevice, 40978);
            }
            this.mHandler.removeMessages(17);
            this.mHandler.removeMessages(18);
        }
    }
}
