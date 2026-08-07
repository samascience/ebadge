package com.jieli.jl_bt_ota.impl;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.Keep;
import com.jieli.jl_bt_ota.constant.BluetoothConstant;
import com.jieli.jl_bt_ota.interfaces.JieLiLibLoader;
import com.jieli.jl_bt_ota.util.BluetoothUtil;
import com.jieli.jl_bt_ota.util.CHexConver;
import com.jieli.jl_bt_ota.util.CommonUtil;
import com.jieli.jl_bt_ota.util.JL_Log;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
@Keep
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
    public static boolean SUPPORT_RESET_FLAG = false;
    private static final String TAG = "RcspAuth";
    private static volatile boolean mIsLibLoaded = false;
    public static final JieLiLibLoader sLocalLibLoader = new JieLiLibLoader() { // from class: oa2
        @Override // com.jieli.jl_bt_ota.interfaces.JieLiLibLoader
        public final void loadLibrary(String str) {
            System.loadLibrary(str);
        }
    };
    private final boolean isLibInit;
    private final Context mContext;
    private final IRcspAuthOp mIRcspAuthOp;
    private final List<OnRcspAuthListener> mOnRcspAuthListeners = Collections.synchronizedList(new ArrayList());
    private final Map<String, AuthTask> mAuthTaskMap = Collections.synchronizedMap(new HashMap());
    private final Handler mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.jieli.jl_bt_ota.impl.RcspAuth.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 17) {
                BluetoothDevice bluetoothDevice = (BluetoothDevice) message.obj;
                AuthTask authTask = (AuthTask) RcspAuth.this.mAuthTaskMap.get(bluetoothDevice.getAddress());
                if (authTask == null) {
                    return false;
                }
                if (authTask.getRetryNum() < 2) {
                    authTask.setRetryNum(authTask.getRetryNum() + 1);
                    RcspAuth.this.sendAuthDataToDevice(authTask.getDevice(), authTask.getRandomData());
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

    /* JADX INFO: Access modifiers changed from: private */
    static class AuthTask {
        private BluetoothDevice a;
        private boolean b;
        private boolean c;
        private byte[] d;
        private int e;

        private AuthTask() {
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

    public RcspAuth(Context context, IRcspAuthOp iRcspAuthOp, OnRcspAuthListener onRcspAuthListener) {
        if (iRcspAuthOp == null) {
            throw new IllegalArgumentException("IRcspAuthOp can not be null.");
        }
        loadLibrariesOnce(null);
        this.isLibInit = nativeInit();
        this.mContext = context;
        this.mIRcspAuthOp = iRcspAuthOp;
        addListener(onRcspAuthListener);
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
        byte b;
        return (bArr == null || bArr.length == 0 || ((bArr.length != 5 || bArr[0] != 2) && (bArr.length != 17 || ((b = bArr[0]) != 0 && b != 1)))) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onAuthFailed$3(BluetoothDevice bluetoothDevice, int i, String str) {
        if (this.mOnRcspAuthListeners.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.mOnRcspAuthListeners);
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            ((OnRcspAuthListener) obj).onAuthFailed(bluetoothDevice, i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onAuthSuccess$2(BluetoothDevice bluetoothDevice) {
        if (this.mOnRcspAuthListeners.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.mOnRcspAuthListeners);
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((OnRcspAuthListener) obj).onAuthSuccess(bluetoothDevice);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onInitResult$1(boolean z) {
        if (this.mOnRcspAuthListeners.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.mOnRcspAuthListeners);
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((OnRcspAuthListener) obj).onInitResult(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startAuth$0(BluetoothDevice bluetoothDevice, AuthTask authTask) {
        if (!sendAuthDataToDevice(bluetoothDevice, authTask.getRandomData())) {
            onAuthFailed(bluetoothDevice, 40979, "Failed to send data.");
            return;
        }
        this.mHandler.removeMessages(17);
        Handler handler = this.mHandler;
        handler.sendMessageDelayed(handler.obtainMessage(17, bluetoothDevice), DELAY_AUTH_WAITING_TIME);
    }

    public static void loadLibrariesOnce(JieLiLibLoader jieLiLibLoader) {
        synchronized (RcspAuth.class) {
            try {
                if (!mIsLibLoaded) {
                    if (jieLiLibLoader == null) {
                        jieLiLibLoader = sLocalLibLoader;
                    }
                    jieLiLibLoader.loadLibrary(BluetoothConstant.JL_AUTH);
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

    private void onAuthSuccess(final BluetoothDevice bluetoothDevice) {
        JL_Log.w(TAG, "onAuthSuccess", CommonUtil.formatString("device = %s,  auth ok.", printDeviceInfo(bluetoothDevice)));
        this.mHandler.post(new Runnable() { // from class: ra2
            @Override // java.lang.Runnable
            public final void run() {
                this.a.lambda$onAuthSuccess$2(bluetoothDevice);
            }
        });
        if (bluetoothDevice != null) {
            this.mAuthTaskMap.remove(bluetoothDevice.getAddress());
        }
    }

    private void onInitResult(final boolean z) {
        this.mHandler.post(new Runnable() { // from class: qa2
            @Override // java.lang.Runnable
            public final void run() {
                this.a.lambda$onInitResult$1(z);
            }
        });
    }

    private String printDeviceInfo(BluetoothDevice bluetoothDevice) {
        return BluetoothUtil.printBtDeviceInfo(this.mContext, bluetoothDevice);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean sendAuthDataToDevice(BluetoothDevice bluetoothDevice, byte[] bArr) {
        if (bluetoothDevice == null || bArr == null) {
            return false;
        }
        boolean zSendAuthDataToDevice = this.mIRcspAuthOp.sendAuthDataToDevice(bluetoothDevice, bArr);
        JL_Log.i(TAG, "sendAuthDataToDevice", CommonUtil.formatString("device : %s, authData : %s", printDeviceInfo(bluetoothDevice), CHexConver.byte2HexStr(bArr)));
        return zSendAuthDataToDevice;
    }

    public static boolean setAuthTimeout(long j) {
        if (j < DEFAULT_AUTH_TIMEOUT) {
            JL_Log.d(TAG, "setAuthTimeout", CommonUtil.formatString("The set time[%d] cannot be less than the minimum time[%d].", Long.valueOf(j), Long.valueOf(DEFAULT_AUTH_TIMEOUT)));
            return false;
        }
        DELAY_AUTH_WAITING_TIME = j;
        return true;
    }

    public void addListener(OnRcspAuthListener onRcspAuthListener) {
        if (onRcspAuthListener != null) {
            this.mOnRcspAuthListeners.add(onRcspAuthListener);
            onRcspAuthListener.onInitResult(this.isLibInit);
        }
    }

    public void destroy() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mAuthTaskMap.clear();
        this.mOnRcspAuthListeners.clear();
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

    protected native byte[] getEncryptedAuthData(byte[] bArr);

    protected native byte[] getRandomAuthData();

    public byte[] getRandomData() {
        return getRandomAuthData();
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00ae  */
    public void handleAuthData(BluetoothDevice bluetoothDevice, byte[] bArr) {
        AuthTask authTask;
        int i;
        if (bluetoothDevice == null || !isValidAuthData(bArr) || (authTask = this.mAuthTaskMap.get(bluetoothDevice.getAddress())) == null || authTask.isAuthDevice()) {
            return;
        }
        String str = TAG;
        JL_Log.d(str, "handleAuthData", CommonUtil.formatString("device : %s, data : %s", printDeviceInfo(bluetoothDevice), CHexConver.byte2HexStr(bArr)));
        if (authTask.isAuthProgressResult()) {
            if (bArr.length == 17 && bArr[0] == 0) {
                byte[] authData = getAuthData(bArr);
                JL_Log.i(str, "handleAuthData", "devAuthData : " + CHexConver.byte2HexStr(authData));
                if (!sendAuthDataToDevice(bluetoothDevice, authData)) {
                    i = 40979;
                }
            } else {
                if (!Arrays.equals(bArr, getAuthOkData())) {
                    return;
                }
                authTask.setAuthDevice(true);
                onAuthSuccess(bluetoothDevice);
                JL_Log.w(str, "handleAuthData", CommonUtil.formatString("device : %s, auth ok.", printDeviceInfo(bluetoothDevice)));
            }
            i = 0;
        } else {
            if (bArr.length != 17 || bArr[0] != 1) {
                return;
            }
            byte[] authData2 = getAuthData(authTask.getRandomData());
            if (authData2 == null || !Arrays.equals(authData2, bArr)) {
                JL_Log.w(str, "handleAuthData", "data not match. authData : " + CHexConver.byte2HexStr(authData2));
                i = 40980;
            } else if (sendAuthDataToDevice(bluetoothDevice, getAuthOkData())) {
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

    protected native boolean nativeInit();

    public void removeListener(OnRcspAuthListener onRcspAuthListener) {
        if (onRcspAuthListener != null) {
            this.mOnRcspAuthListeners.remove(onRcspAuthListener);
        }
    }

    public int setDeviceConnectionLinkKey(byte[] bArr) {
        return setLinkKey(bArr);
    }

    protected native int setLinkKey(byte[] bArr);

    public boolean startAuth(final BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null) {
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
        JL_Log.i(TAG, "startAuth", "device = " + printDeviceInfo(bluetoothDevice));
        final AuthTask randomData = new AuthTask().setDevice(bluetoothDevice).setRandomData(getRandomData());
        this.mAuthTaskMap.put(bluetoothDevice.getAddress(), randomData);
        if (SUPPORT_RESET_FLAG) {
            boolean zSendAuthDataToDevice = sendAuthDataToDevice(bluetoothDevice, getResetAuthFlagCmdData());
            if (zSendAuthDataToDevice) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.jieli.jl_bt_ota.impl.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.lambda$startAuth$0(bluetoothDevice, randomData);
                    }
                }, 500L);
            }
            return zSendAuthDataToDevice;
        }
        boolean zSendAuthDataToDevice2 = sendAuthDataToDevice(bluetoothDevice, randomData.getRandomData());
        if (zSendAuthDataToDevice2) {
            this.mHandler.removeMessages(17);
            Handler handler = this.mHandler;
            handler.sendMessageDelayed(handler.obtainMessage(17, bluetoothDevice), DELAY_AUTH_WAITING_TIME);
        }
        return zSendAuthDataToDevice2;
    }

    public void stopAuth(BluetoothDevice bluetoothDevice) {
        stopAuth(bluetoothDevice, true);
    }

    private void onAuthFailed(final BluetoothDevice bluetoothDevice, final int i, final String str) {
        JL_Log.e(TAG, "onAuthFailed", CommonUtil.formatString("device = %s,  code = %d, message = %s.", bluetoothDevice, Integer.valueOf(i), str));
        this.mHandler.removeMessages(17);
        this.mHandler.removeMessages(18);
        this.mHandler.post(new Runnable() { // from class: sa2
            @Override // java.lang.Runnable
            public final void run() {
                this.a.lambda$onAuthFailed$3(bluetoothDevice, i, str);
            }
        });
        if (bluetoothDevice != null) {
            this.mAuthTaskMap.remove(bluetoothDevice.getAddress());
        }
    }

    public void stopAuth(BluetoothDevice bluetoothDevice, boolean z) {
        if (bluetoothDevice == null) {
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
