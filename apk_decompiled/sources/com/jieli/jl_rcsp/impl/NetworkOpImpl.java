package com.jieli.jl_rcsp.impl;

import android.bluetooth.BluetoothDevice;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.jieli.jl_rcsp.constant.RcspErrorCode;
import com.jieli.jl_rcsp.constant.WatchError;
import com.jieli.jl_rcsp.impl.NetworkOpImpl;
import com.jieli.jl_rcsp.interfaces.OnOperationCallback;
import com.jieli.jl_rcsp.interfaces.data.OnDataEventCallback;
import com.jieli.jl_rcsp.interfaces.network.INetworkOp;
import com.jieli.jl_rcsp.interfaces.network.OnNetworkListener;
import com.jieli.jl_rcsp.interfaces.network.OnNetworkOTACallback;
import com.jieli.jl_rcsp.interfaces.rcsp.OnRcspCallback;
import com.jieli.jl_rcsp.interfaces.setting.OnSettingFunctionListener;
import com.jieli.jl_rcsp.model.base.BaseError;
import com.jieli.jl_rcsp.model.command.setting.PublicSettingsCmd;
import com.jieli.jl_rcsp.model.data.SendParams;
import com.jieli.jl_rcsp.model.device.DeviceInfo;
import com.jieli.jl_rcsp.model.device.settings.SettingData;
import com.jieli.jl_rcsp.model.device.settings.v0.NetworkBase;
import com.jieli.jl_rcsp.model.device.settings.v0.NetworkFunction;
import com.jieli.jl_rcsp.model.device.settings.v0.NetworkInfo;
import com.jieli.jl_rcsp.model.device.settings.v0.NetworkOTA;
import com.jieli.jl_rcsp.model.device.settings.v0.NetworkOTAState;
import com.jieli.jl_rcsp.model.device.settings.v0.SettingFunction;
import com.jieli.jl_rcsp.model.network.OTAParam;
import com.jieli.jl_rcsp.tool.callback.BaseCallbackManager;
import com.jieli.jl_rcsp.util.JL_Log;
import com.tencent.connect.common.Constants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class NetworkOpImpl implements INetworkOp {
    public static long WAITING_END_STATE_TIMEOUT = 240000;
    public static long WAITING_START_STATE_TIMEOUT = 60000;
    public static volatile NetworkOpImpl j = null;
    public static final int k = 4112;
    public final String a = getClass().getSimpleName();
    public final RcspOpImpl b;
    public final SettingFunctionImpl c;
    public final DataTransferOpImpl d;
    public final CallbackManager e;
    public Param f;
    public final Handler g;
    public final OnRcspCallback h;
    public final OnSettingFunctionListener i;

    public static class CallbackManager extends BaseCallbackManager<OnNetworkListener> implements OnNetworkListener {
        public CallbackManager(Handler handler) {
            super(handler);
        }

        @Override // com.jieli.jl_rcsp.interfaces.network.OnNetworkListener
        public void onNetworkInfo(final BluetoothDevice bluetoothDevice, final NetworkInfo networkInfo) {
            callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: com.jieli.jl_rcsp.impl.d
                @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
                public final void onPost(Object obj) {
                    ((OnNetworkListener) obj).onNetworkInfo(bluetoothDevice, networkInfo);
                }
            });
        }

        @Override // com.jieli.jl_rcsp.interfaces.network.OnNetworkListener
        public void onNetworkOTAState(final BluetoothDevice bluetoothDevice, final NetworkOTAState networkOTAState) {
            callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: com.jieli.jl_rcsp.impl.e
                @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
                public final void onPost(Object obj) {
                    ((OnNetworkListener) obj).onNetworkOTAState(bluetoothDevice, networkOTAState);
                }
            });
        }
    }

    public static class Param {
        public final BluetoothDevice a;
        public final OnNetworkOTACallback b;
        public byte[] c;
        public boolean d;

        public Param(BluetoothDevice bluetoothDevice, OnNetworkOTACallback onNetworkOTACallback) {
            this.a = bluetoothDevice;
            this.b = onNetworkOTACallback;
        }

        public OnNetworkOTACallback getCallback() {
            return this.b;
        }

        public BluetoothDevice getDevice() {
            return this.a;
        }

        public byte[] getOtaData() {
            return this.c;
        }

        public boolean isNetworkOTA() {
            return this.d;
        }

        public Param setNetworkOTA(boolean z) {
            this.d = z;
            return this;
        }

        public Param setOtaData(byte[] bArr) {
            this.c = bArr;
            return this;
        }
    }

    public NetworkOpImpl(RcspOpImpl rcspOpImpl) {
        Handler handler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: nq1
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return this.a.a(message);
            }
        });
        this.g = handler;
        OnRcspCallback onRcspCallback = new OnRcspCallback() { // from class: com.jieli.jl_rcsp.impl.NetworkOpImpl.6
            @Override // com.jieli.jl_rcsp.interfaces.rcsp.OnRcspCallback
            public void onConnectStateChange(BluetoothDevice bluetoothDevice, int i) {
                if (!NetworkOpImpl.this.isNetworkOTA() || i == 1) {
                    return;
                }
                NetworkOpImpl.this.a(8192);
            }
        };
        this.h = onRcspCallback;
        OnSettingFunctionListener onSettingFunctionListener = new OnSettingFunctionListener() { // from class: com.jieli.jl_rcsp.impl.NetworkOpImpl.7
            @Override // com.jieli.jl_rcsp.interfaces.setting.OnSettingFunctionListener
            public void onSettingData(BluetoothDevice bluetoothDevice, SettingData settingData) {
            }

            @Override // com.jieli.jl_rcsp.interfaces.setting.OnSettingFunctionListener
            public void onSettingFunction(BluetoothDevice bluetoothDevice, SettingFunction settingFunction) {
                NetworkBase networkBase;
                if (!(settingFunction instanceof NetworkFunction) || (networkBase = ((NetworkFunction) settingFunction).getNetworkBase()) == null) {
                    return;
                }
                if (networkBase instanceof NetworkInfo) {
                    NetworkInfo networkInfo = (NetworkInfo) networkBase;
                    DeviceInfo deviceInfo = NetworkOpImpl.this.b.getDeviceInfo(bluetoothDevice);
                    if (deviceInfo != null) {
                        deviceInfo.setNetworkInfo(networkInfo);
                    }
                    NetworkOpImpl.this.e.onNetworkInfo(bluetoothDevice, networkInfo);
                    return;
                }
                if (networkBase instanceof NetworkOTAState) {
                    NetworkOTAState networkOTAState = (NetworkOTAState) networkBase;
                    NetworkOpImpl.this.e.onNetworkOTAState(bluetoothDevice, networkOTAState);
                    JL_Log.d(NetworkOpImpl.this.a, "onSettingFunction", networkOTAState + ", isNetworkOTA = " + NetworkOpImpl.this.isNetworkOTA());
                    if (NetworkOpImpl.this.isNetworkOTA()) {
                        NetworkOpImpl.this.g.removeMessages(4112);
                        int state = networkOTAState.getState();
                        if (state != 0) {
                            if (state != 1) {
                                return;
                            }
                            NetworkOpImpl networkOpImpl = NetworkOpImpl.this;
                            networkOpImpl.a(networkOpImpl.f.c);
                            return;
                        }
                        int code = networkOTAState.getCode();
                        if (code == 0) {
                            NetworkOpImpl.this.f.setNetworkOTA(false);
                            OnNetworkOTACallback onNetworkOTACallback = NetworkOpImpl.this.f.b;
                            if (onNetworkOTACallback != null) {
                                onNetworkOTACallback.onProgress(100);
                                onNetworkOTACallback.onStop();
                                return;
                            }
                            return;
                        }
                        if (code == 1) {
                            NetworkOpImpl.this.a(20481);
                        } else if (code == 2) {
                            NetworkOpImpl.this.a(WatchError.ERR_NETWORK_OTA_TIMEOUT);
                        } else {
                            BaseError baseErrorBuildJsonError = RcspErrorCode.buildJsonError(51, WatchError.ERR_NETWORK_OTA_UNKNOWN, networkOTAState.getCode(), Constants.STR_EMPTY);
                            NetworkOpImpl.this.a(baseErrorBuildJsonError.getSubCode(), baseErrorBuildJsonError.getMessage());
                        }
                    }
                }
            }
        };
        this.i = onSettingFunctionListener;
        if (rcspOpImpl == null) {
            throw new NullPointerException("WatchOpImpl can not be null.");
        }
        this.b = rcspOpImpl;
        rcspOpImpl.registerOnRcspCallback(onRcspCallback);
        SettingFunctionImpl settingFunctionImplInstance = SettingFunctionImpl.instance(rcspOpImpl);
        this.c = settingFunctionImplInstance;
        this.d = DataTransferOpImpl.instance(rcspOpImpl);
        this.e = new CallbackManager(handler);
        settingFunctionImplInstance.addOnSettingFunctionListener(onSettingFunctionListener);
    }

    public static NetworkOpImpl instance(RcspOpImpl rcspOpImpl) {
        if (j == null) {
            synchronized (NetworkOpImpl.class) {
                try {
                    if (j == null) {
                        j = new NetworkOpImpl(rcspOpImpl);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return j;
    }

    @Override // com.jieli.jl_rcsp.interfaces.network.INetworkOp
    public void addOnNetworkListener(OnNetworkListener onNetworkListener) {
        this.e.registerCallback(onNetworkListener);
    }

    @Override // com.jieli.jl_rcsp.interfaces.network.INetworkOp
    public void cancelNetworkOTA(BluetoothDevice bluetoothDevice, OnOperationCallback<Boolean> onOperationCallback) {
        if (onOperationCallback != null) {
            onOperationCallback.onSuccess(Boolean.FALSE);
        }
    }

    public void destroy() {
        cancelNetworkOTA(b(), null);
        this.b.unregisterOnRcspCallback(this.h);
        this.c.removeOnSettingFunctionListener(this.i);
        this.c.destroy();
        this.d.destroy();
        this.e.release();
        j = null;
    }

    @Override // com.jieli.jl_rcsp.interfaces.network.INetworkOp
    public boolean isNetworkOTA() {
        Param param = this.f;
        return param != null && param.isNetworkOTA();
    }

    @Override // com.jieli.jl_rcsp.interfaces.network.INetworkOp
    public void queryNetworkInfo(final BluetoothDevice bluetoothDevice, final OnOperationCallback<Boolean> onOperationCallback) {
        this.c.settingFunction(bluetoothDevice, new PublicSettingsCmd.Param(new NetworkFunction(0, new NetworkBase(0))), new OnOperationCallback<PublicSettingsCmd.Response>() { // from class: com.jieli.jl_rcsp.impl.NetworkOpImpl.1
            @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
            public void onFailed(BaseError baseError) {
                OnOperationCallback onOperationCallback2 = onOperationCallback;
                if (onOperationCallback2 != null) {
                    onOperationCallback2.onFailed(baseError);
                }
            }

            @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
            public void onSuccess(PublicSettingsCmd.Response response) {
                if (response.getResult() == 0 && (response.getSettingData() instanceof NetworkFunction)) {
                    NetworkFunction networkFunction = (NetworkFunction) response.getSettingData();
                    if (networkFunction.getNetworkBase() instanceof NetworkInfo) {
                        NetworkInfo networkInfo = (NetworkInfo) networkFunction.getNetworkBase();
                        DeviceInfo deviceInfo = NetworkOpImpl.this.b.getDeviceInfo();
                        if (deviceInfo != null) {
                            deviceInfo.setNetworkInfo(networkInfo);
                        }
                        OnOperationCallback onOperationCallback2 = onOperationCallback;
                        if (onOperationCallback2 != null) {
                            onOperationCallback2.onSuccess(Boolean.TRUE);
                        }
                        NetworkOpImpl.this.e.onNetworkInfo(bluetoothDevice, networkInfo);
                        return;
                    }
                }
                onFailed(RcspErrorCode.buildJsonError(51, 12293, response.getResult(), null));
            }
        });
    }

    @Override // com.jieli.jl_rcsp.interfaces.network.INetworkOp
    public void removeOnNetworkListener(OnNetworkListener onNetworkListener) {
        this.e.unregisterCallback(onNetworkListener);
    }

    @Override // com.jieli.jl_rcsp.interfaces.network.INetworkOp
    public void startNetworkOTA(BluetoothDevice bluetoothDevice, OTAParam oTAParam, OnNetworkOTACallback onNetworkOTACallback) {
        if (isNetworkOTA()) {
            if (onNetworkOTACallback != null) {
                onNetworkOTACallback.onError(4352, WatchError.getErrorDesc(4352));
                return;
            }
            return;
        }
        this.f = new Param(bluetoothDevice, onNetworkOTACallback).setNetworkOTA(true);
        if (onNetworkOTACallback != null) {
            onNetworkOTACallback.onStart();
        }
        if (oTAParam.getOtaData() == null || oTAParam.getOtaData().length <= 0) {
            b(oTAParam.getOtaFilePath(), new OnOperationCallback<byte[]>() { // from class: com.jieli.jl_rcsp.impl.NetworkOpImpl.2
                @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
                public void onFailed(BaseError baseError) {
                    NetworkOpImpl.this.a(baseError.getSubCode(), baseError.getMessage());
                }

                @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
                public void onSuccess(byte[] bArr) {
                    NetworkOpImpl.this.f.setOtaData(bArr);
                    NetworkOpImpl networkOpImpl = NetworkOpImpl.this;
                    networkOpImpl.b(networkOpImpl.f.getOtaData().length);
                }
            });
        } else {
            this.f.setOtaData(oTAParam.getOtaData());
            b(this.f.getOtaData().length);
        }
    }

    public final BluetoothDevice b() {
        return this.b.getConnectedDevice();
    }

    public final void b(final String str, final OnOperationCallback<byte[]> onOperationCallback) {
        new Thread(new Runnable() { // from class: rq1
            @Override // java.lang.Runnable
            public final void run() {
                this.a.a(str, onOperationCallback);
            }
        }).start();
    }

    public final /* synthetic */ boolean a(Message message) {
        if (4112 != message.what) {
            return true;
        }
        a(WatchError.ERR_NETWORK_OTA_WAITING_COMMAND_TIMEOUT);
        return true;
    }

    public final void b(int i) {
        if (isNetworkOTA()) {
            a(this.f.a, i, new OnOperationCallback<Boolean>() { // from class: com.jieli.jl_rcsp.impl.NetworkOpImpl.3
                @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
                public void onFailed(BaseError baseError) {
                    NetworkOpImpl.this.a(baseError.getSubCode(), baseError.getMessage());
                }

                @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
                public void onSuccess(Boolean bool) {
                    if (NetworkOpImpl.this.isNetworkOTA()) {
                        NetworkInfo networkInfoA = NetworkOpImpl.this.a();
                        long startOtaTimeout = networkInfoA == null ? NetworkOpImpl.WAITING_START_STATE_TIMEOUT : ((long) networkInfoA.getStartOtaTimeout()) * 1000;
                        JL_Log.d(NetworkOpImpl.this.a, "prepareOta", "start OTA timeout = " + startOtaTimeout);
                        NetworkOpImpl.this.g.removeMessages(4112);
                        NetworkOpImpl.this.g.sendEmptyMessageDelayed(4112, startOtaTimeout);
                    }
                }
            });
        }
    }

    public final NetworkInfo a() {
        DeviceInfo deviceInfo = this.b.getDeviceInfo();
        if (deviceInfo == null) {
            return null;
        }
        return deviceInfo.getNetworkInfo();
    }

    public final void a(int i) {
        a(i, WatchError.getErrorDesc(i));
    }

    public final void a(int i, String str) {
        if (isNetworkOTA()) {
            this.g.removeMessages(4112);
            this.f.setNetworkOTA(false);
            OnNetworkOTACallback onNetworkOTACallback = this.f.b;
            if (onNetworkOTACallback != null) {
                if (i == 4098) {
                    onNetworkOTACallback.onCancel();
                } else {
                    onNetworkOTACallback.onError(i, str);
                }
            }
        }
    }

    public final /* synthetic */ void a(final String str, final OnOperationCallback onOperationCallback) {
        int i;
        File file = new File(str);
        if (file.exists() && file.isFile() && file.length() != 0) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[4096];
                do {
                    i = fileInputStream.read(bArr);
                    if (i > 0) {
                        byteArrayOutputStream.write(bArr, 0, i);
                    }
                } while (i != -1);
                fileInputStream.close();
                final byte[] byteArray = byteArrayOutputStream.toByteArray();
                this.g.post(new Runnable() { // from class: oq1
                    @Override // java.lang.Runnable
                    public final void run() {
                        NetworkOpImpl.a(onOperationCallback, byteArray);
                    }
                });
                byteArrayOutputStream.close();
                return;
            } catch (IOException e) {
                e.printStackTrace();
                this.g.post(new Runnable() { // from class: pq1
                    @Override // java.lang.Runnable
                    public final void run() {
                        NetworkOpImpl.a(onOperationCallback, e);
                    }
                });
                return;
            }
        }
        this.g.post(new Runnable() { // from class: qq1
            @Override // java.lang.Runnable
            public final void run() {
                NetworkOpImpl.a(onOperationCallback, str);
            }
        });
    }

    public static /* synthetic */ void a(OnOperationCallback onOperationCallback, String str) {
        if (onOperationCallback != null) {
            onOperationCallback.onFailed(new BaseError(4097, WatchError.getErrorDesc(4097) + " Error Path : " + str));
        }
    }

    public static /* synthetic */ void a(OnOperationCallback onOperationCallback, byte[] bArr) {
        if (onOperationCallback != null) {
            onOperationCallback.onSuccess(bArr);
        }
    }

    public static /* synthetic */ void a(OnOperationCallback onOperationCallback, IOException iOException) {
        if (onOperationCallback != null) {
            onOperationCallback.onFailed(new BaseError(16389, WatchError.getErrorDesc(16389) + ", " + iOException.getMessage()));
        }
    }

    public final void a(byte[] bArr) {
        if (isNetworkOTA()) {
            final OnNetworkOTACallback onNetworkOTACallback = this.f.b;
            this.d.sendLargeData(new SendParams(7, 0, 4096, 4096, bArr), new OnDataEventCallback() { // from class: com.jieli.jl_rcsp.impl.NetworkOpImpl.4
                @Override // com.jieli.jl_rcsp.interfaces.data.OnDataEventCallback
                public void onBegin(int i) {
                }

                @Override // com.jieli.jl_rcsp.interfaces.data.OnDataEventCallback
                public void onError(BaseError baseError) {
                    NetworkOpImpl.this.a(baseError.getSubCode(), baseError.getMessage());
                }

                @Override // com.jieli.jl_rcsp.interfaces.data.OnDataEventCallback
                public void onProgress(float f) {
                    int i = (int) f;
                    if (i >= 100) {
                        i = 99;
                    }
                    OnNetworkOTACallback onNetworkOTACallback2 = onNetworkOTACallback;
                    if (onNetworkOTACallback2 != null) {
                        onNetworkOTACallback2.onProgress(i);
                    }
                }

                @Override // com.jieli.jl_rcsp.interfaces.data.OnDataEventCallback
                public void onStop(int i, byte[] bArr2) {
                    NetworkInfo networkInfoA = NetworkOpImpl.this.a();
                    long stopOtaTimeout = networkInfoA == null ? NetworkOpImpl.WAITING_END_STATE_TIMEOUT : ((long) networkInfoA.getStopOtaTimeout()) * 1000;
                    JL_Log.d(NetworkOpImpl.this.a, "prepareOta", "stop OTA timeout = " + stopOtaTimeout);
                    NetworkOpImpl.this.g.removeMessages(4112);
                    NetworkOpImpl.this.g.sendEmptyMessageDelayed(4112, stopOtaTimeout);
                }
            });
        }
    }

    public final void a(BluetoothDevice bluetoothDevice, int i, final OnOperationCallback<Boolean> onOperationCallback) {
        this.c.settingFunction(bluetoothDevice, new PublicSettingsCmd.Param(new NetworkFunction(1, new NetworkOTA(i))), new OnOperationCallback<PublicSettingsCmd.Response>() { // from class: com.jieli.jl_rcsp.impl.NetworkOpImpl.5
            @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
            public void onFailed(BaseError baseError) {
                OnOperationCallback onOperationCallback2 = onOperationCallback;
                if (onOperationCallback2 != null) {
                    onOperationCallback2.onFailed(baseError);
                }
            }

            @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
            public void onSuccess(PublicSettingsCmd.Response response) {
                if (response.getResult() != 0) {
                    onFailed(RcspErrorCode.buildJsonError(51, 12293, response.getResult(), null));
                    return;
                }
                OnOperationCallback onOperationCallback2 = onOperationCallback;
                if (onOperationCallback2 != null) {
                    onOperationCallback2.onSuccess(Boolean.TRUE);
                }
            }
        });
    }
}
