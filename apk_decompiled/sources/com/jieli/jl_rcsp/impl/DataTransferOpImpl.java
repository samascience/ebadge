package com.jieli.jl_rcsp.impl;

import android.bluetooth.BluetoothDevice;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.jieli.jl_rcsp.constant.RcspErrorCode;
import com.jieli.jl_rcsp.constant.WatchError;
import com.jieli.jl_rcsp.interfaces.IHandleResult;
import com.jieli.jl_rcsp.interfaces.OnOperationCallback;
import com.jieli.jl_rcsp.interfaces.data.IDataTransferOp;
import com.jieli.jl_rcsp.interfaces.data.OnDataEventCallback;
import com.jieli.jl_rcsp.interfaces.data.OnDataTransferListener;
import com.jieli.jl_rcsp.interfaces.rcsp.OnRcspCallback;
import com.jieli.jl_rcsp.model.base.BaseError;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.model.command.data.DataTransferCmd;
import com.jieli.jl_rcsp.model.data.DataParams;
import com.jieli.jl_rcsp.model.data.ReadDataCache;
import com.jieli.jl_rcsp.model.data.ReadParams;
import com.jieli.jl_rcsp.model.data.SendDataCache;
import com.jieli.jl_rcsp.model.data.SendParams;
import com.jieli.jl_rcsp.tool.BooleanRcspActionCallback;
import com.jieli.jl_rcsp.tool.CustomRcspActionCallback;
import com.jieli.jl_rcsp.tool.DeviceStatusManager;
import com.jieli.jl_rcsp.tool.callback.BaseCallbackManager;
import com.jieli.jl_rcsp.util.CHexConver;
import com.jieli.jl_rcsp.util.CryptoUtil;
import com.jieli.jl_rcsp.util.JL_Log;
import com.jieli.jl_rcsp.util.RcspUtil;
import com.tencent.connect.common.Constants;

/* JADX INFO: loaded from: classes3.dex */
class DataTransferOpImpl implements IDataTransferOp {
    public static int WAITING_FOR_DATA_TIMEOUT = 20000;
    public static final String h = "DataTransferOpImpl";
    public static volatile DataTransferOpImpl i = null;
    public static final int j = 5237;
    public final RcspOpImpl a;
    public final DeviceStatusManager b;
    public final CallbackManager c;
    public volatile SendDataCache d;
    public volatile ReadDataCache e;
    public final Handler f;
    public final OnRcspCallback g;

    public static class CallbackManager extends BaseCallbackManager<OnDataTransferListener> implements OnDataTransferListener {
        public CallbackManager(Handler handler) {
            super(handler);
        }

        @Override // com.jieli.jl_rcsp.interfaces.data.OnDataTransferListener
        public void onError(final BluetoothDevice bluetoothDevice, final BaseError baseError) {
            callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: com.jieli.jl_rcsp.impl.b
                @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
                public final void onPost(Object obj) {
                    ((OnDataTransferListener) obj).onError(bluetoothDevice, baseError);
                }
            });
        }

        @Override // com.jieli.jl_rcsp.interfaces.data.OnDataTransferListener
        public void onReceiveData(final BluetoothDevice bluetoothDevice, final int i, final byte[] bArr) {
            callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: com.jieli.jl_rcsp.impl.c
                @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
                public final void onPost(Object obj) {
                    ((OnDataTransferListener) obj).onReceiveData(bluetoothDevice, i, bArr);
                }
            });
        }
    }

    public DataTransferOpImpl(RcspOpImpl rcspOpImpl) {
        Handler handler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.jieli.jl_rcsp.impl.a
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return this.a.a(message);
            }
        });
        this.f = handler;
        OnRcspCallback onRcspCallback = new OnRcspCallback() { // from class: com.jieli.jl_rcsp.impl.DataTransferOpImpl.7
            @Override // com.jieli.jl_rcsp.interfaces.rcsp.OnRcspCallback
            public void onConnectStateChange(BluetoothDevice bluetoothDevice, int i2) {
                if (i2 != 1) {
                    BaseError baseError = new BaseError(8192, "Device is not connected.");
                    DataTransferOpImpl.this.a(baseError);
                    DataTransferOpImpl.this.a(bluetoothDevice, baseError);
                }
            }

            @Override // com.jieli.jl_rcsp.interfaces.rcsp.OnRcspCallback
            public void onRcspCommand(BluetoothDevice bluetoothDevice, CommandBase commandBase) {
                if (commandBase == null || commandBase.getId() != 48) {
                    return;
                }
                DataTransferCmd dataTransferCmd = (DataTransferCmd) commandBase;
                JL_Log.d(DataTransferOpImpl.h, "onRcspCommand", Constants.STR_EMPTY + dataTransferCmd);
                if (dataTransferCmd.getParam() instanceof DataTransferCmd.SendDataParam) {
                    DataTransferOpImpl.this.a(bluetoothDevice, dataTransferCmd, (DataTransferCmd.SendDataParam) dataTransferCmd.getParam());
                } else if (dataTransferCmd.getParam() instanceof DataTransferCmd.ReadDataParam) {
                    DataTransferOpImpl.this.a(bluetoothDevice, dataTransferCmd, (DataTransferCmd.DataTransferParam) dataTransferCmd.getParam());
                } else if (dataTransferCmd.getParam() instanceof DataTransferCmd.DataTransferParam) {
                    DataTransferOpImpl.this.a(bluetoothDevice, dataTransferCmd, (DataTransferCmd.DataTransferParam) dataTransferCmd.getParam());
                }
            }
        };
        this.g = onRcspCallback;
        if (rcspOpImpl == null) {
            throw new NullPointerException("RcspOpImpl can not be null.");
        }
        this.a = rcspOpImpl;
        this.b = DeviceStatusManager.getInstance();
        this.c = new CallbackManager(handler);
        rcspOpImpl.registerOnRcspCallback(onRcspCallback);
    }

    public static DataTransferOpImpl instance(RcspOpImpl rcspOpImpl) {
        if (i == null) {
            synchronized (DataTransferOpImpl.class) {
                try {
                    if (i == null) {
                        i = new DataTransferOpImpl(rcspOpImpl);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return i;
    }

    @Override // com.jieli.jl_rcsp.interfaces.data.IDataTransferOp
    public void addListener(OnDataTransferListener onDataTransferListener) {
        this.c.registerCallback(onDataTransferListener);
    }

    @Override // com.jieli.jl_rcsp.interfaces.data.IDataTransferOp
    public void cancelDataTransfer(OnOperationCallback<Boolean> onOperationCallback) {
        if (onOperationCallback != null) {
            onOperationCallback.onSuccess(Boolean.FALSE);
        }
    }

    public void destroy() {
        this.f.removeMessages(j);
        this.f.removeCallbacksAndMessages(null);
        this.a.unregisterOnRcspCallback(this.g);
        a(new BaseError(4098, "Cancel send data task."));
        this.c.release();
        i = null;
    }

    @Override // com.jieli.jl_rcsp.interfaces.data.IDataTransferOp
    public boolean isDataTransfer() {
        return this.b.isDataTransfer(b());
    }

    @Override // com.jieli.jl_rcsp.interfaces.data.IDataTransferOp
    public void readLargeData(DataParams dataParams, final OnDataEventCallback onDataEventCallback) {
        if (dataParams == null) {
            if (onDataEventCallback != null) {
                onDataEventCallback.onError(new BaseError(4097, "ReadParams can not be null."));
            }
        } else if (isDataTransfer() || d() || c()) {
            if (onDataEventCallback != null) {
                onDataEventCallback.onError(new BaseError(4352, "Data task is in progress."));
            }
        } else {
            DataTransferCmd.ReadDataParam readDataParam = new DataTransferCmd.ReadDataParam(dataParams.getDataType(), dataParams.getVersion(), dataParams.getSendLimit(), dataParams.getReceiveLimit());
            final BluetoothDevice connectedDevice = this.a.getConnectedDevice();
            a(readDataParam, new OnOperationCallback<DataTransferCmd.ReadDataResponse>() { // from class: com.jieli.jl_rcsp.impl.DataTransferOpImpl.2
                @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
                public void onFailed(BaseError baseError) {
                    OnDataEventCallback onDataEventCallback2 = onDataEventCallback;
                    if (onDataEventCallback2 != null) {
                        onDataEventCallback2.onError(baseError);
                    }
                }

                @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
                public void onSuccess(DataTransferCmd.ReadDataResponse readDataResponse) {
                    if (readDataResponse.getResult() != 0) {
                        onFailed(RcspErrorCode.buildJsonError(48, 12293, readDataResponse.getResult(), null));
                        return;
                    }
                    int maxReceiveMtu = DeviceStatusManager.getInstance().getMaxReceiveMtu(DataTransferOpImpl.this.a.getConnectedDevice());
                    if (readDataResponse.getSendDataLimit() >= maxReceiveMtu) {
                        onFailed(new BaseError(4097, RcspUtil.formatString("Data sending limit exceeded the protocol MTU[%d] range.", Integer.valueOf(maxReceiveMtu))));
                        return;
                    }
                    DataTransferOpImpl.this.e = new ReadDataCache(new ReadParams(readDataResponse.getType(), readDataResponse.getVersion(), readDataResponse.getSendDataLimit(), readDataResponse.getReceiveDataLimit(), readDataResponse.getDataLen(), readDataResponse.getCrc()));
                    DataTransferOpImpl.this.e.setCallback(onDataEventCallback);
                    DataTransferOpImpl.this.b.updateDataTransfer(DataTransferOpImpl.this.b(), true);
                    if (DataTransferOpImpl.this.e.getCallback() != null) {
                        DataTransferOpImpl.this.e.getCallback().onBegin(0);
                    }
                    DataTransferOpImpl.this.f.sendMessageDelayed(DataTransferOpImpl.this.f.obtainMessage(DataTransferOpImpl.j, connectedDevice), DataTransferOpImpl.WAITING_FOR_DATA_TIMEOUT);
                }
            });
        }
    }

    @Override // com.jieli.jl_rcsp.interfaces.data.IDataTransferOp
    public void removeListener(OnDataTransferListener onDataTransferListener) {
        this.c.unregisterCallback(onDataTransferListener);
    }

    @Override // com.jieli.jl_rcsp.interfaces.data.IDataTransferOp
    public void sendLargeData(SendParams sendParams, OnDataEventCallback onDataEventCallback) {
        if (sendParams == null) {
            if (onDataEventCallback != null) {
                onDataEventCallback.onError(new BaseError(4097, "SendDataParam can not be null."));
            }
        } else if (isDataTransfer() || d()) {
            if (onDataEventCallback != null) {
                onDataEventCallback.onError(new BaseError(4352, WatchError.getErrorDesc(4352)));
            }
        } else {
            this.d = new SendDataCache(sendParams, onDataEventCallback);
            this.b.updateDataTransfer(b(), true);
            a(new DataTransferCmd.SendDataParam(sendParams.getDataType(), sendParams.getVersion(), sendParams.getDataLen(), sendParams.getDataCrc(), sendParams.getSendLimit(), sendParams.getReceiveLimit()), new OnOperationCallback<DataTransferCmd.SendDataResponse>() { // from class: com.jieli.jl_rcsp.impl.DataTransferOpImpl.1
                @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
                public void onFailed(BaseError baseError) {
                    DataTransferOpImpl.this.a(baseError);
                }

                @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
                public void onSuccess(DataTransferCmd.SendDataResponse sendDataResponse) {
                    if (sendDataResponse.getResult() != 0) {
                        onFailed(RcspErrorCode.buildJsonError(48, 12293, sendDataResponse.getResult(), null));
                        return;
                    }
                    if (DataTransferOpImpl.this.isDataTransfer() && DataTransferOpImpl.this.d()) {
                        int maxReceiveMtu = DeviceStatusManager.getInstance().getMaxReceiveMtu(DataTransferOpImpl.this.a.getConnectedDevice());
                        if (sendDataResponse.getReceiveDataLimit() >= maxReceiveMtu) {
                            onFailed(new BaseError(4097, RcspUtil.formatString("Data Receiving limit exceeded the protocol MTU[%d] range.", Integer.valueOf(maxReceiveMtu))));
                            return;
                        }
                        DataTransferOpImpl.this.d.setSendLimit(sendDataResponse.getSendDataLimit());
                        DataTransferOpImpl.this.d.setReceiveLimit(sendDataResponse.getReceiveDataLimit());
                        DataTransferOpImpl.this.d.setOffset(0);
                        DataTransferOpImpl.this.d.setSeq(-1);
                        if (DataTransferOpImpl.this.d.getCallback() != null) {
                            DataTransferOpImpl.this.d.getCallback().onBegin(1);
                        }
                        DataTransferOpImpl dataTransferOpImpl = DataTransferOpImpl.this;
                        dataTransferOpImpl.a(dataTransferOpImpl.d);
                    }
                }
            });
        }
    }

    public final boolean c() {
        return this.e != null;
    }

    public final boolean d() {
        return this.d != null;
    }

    public final BluetoothDevice b() {
        return this.a.getConnectedDevice();
    }

    public final /* synthetic */ boolean a(Message message) {
        if (message == null) {
            return false;
        }
        if (5237 != message.what) {
            return true;
        }
        Object obj = message.obj;
        if (!(obj instanceof BluetoothDevice)) {
            return true;
        }
        a((BluetoothDevice) obj, new BaseError(12290, "Waiting for data timeout."));
        return true;
    }

    public final void a(BaseError baseError) {
        if (baseError != null && d()) {
            OnDataEventCallback callback = this.d.getCallback();
            this.d.release();
            this.d = null;
            this.b.updateDataTransfer(b(), false);
            JL_Log.w(h, "onSendError", "device : " + b() + ", " + baseError);
            if (callback != null) {
                callback.onError(baseError);
            }
        }
    }

    public final void a(BluetoothDevice bluetoothDevice, BaseError baseError) {
        if (baseError != null && c()) {
            OnDataEventCallback callback = this.e.getCallback();
            this.f.removeMessages(j);
            this.e.release();
            this.e = null;
            this.b.updateDataTransfer(b(), false);
            JL_Log.w(h, "onReadError", "device : " + bluetoothDevice + ", " + baseError);
            if (callback != null) {
                callback.onError(baseError);
            }
            this.c.onError(bluetoothDevice, baseError);
        }
    }

    public final void a(SendDataCache sendDataCache) {
        if (sendDataCache == null || !isDataTransfer()) {
            return;
        }
        int receiveLimit = sendDataCache.getReceiveLimit();
        boolean z = sendDataCache.getOffset() + receiveLimit >= sendDataCache.getDataLen();
        int iMin = Math.min(sendDataCache.getDataLen() - sendDataCache.getOffset(), receiveLimit);
        byte[] bArr = new byte[iMin];
        System.arraycopy(sendDataCache.getData(), sendDataCache.getOffset(), bArr, 0, iMin);
        short sCRC16 = CryptoUtil.CRC16(bArr, (short) 0);
        sendDataCache.setSeq(sendDataCache.getSeq() + 1);
        DataTransferCmd.DataTransferParam dataTransferParam = new DataTransferCmd.DataTransferParam(sendDataCache.getDataType(), z, sendDataCache.getSeq(), sCRC16, sendDataCache.getOffset(), bArr);
        sendDataCache.setOffset(sendDataCache.getOffset() + iMin);
        a(dataTransferParam, new OnOperationCallback<DataTransferCmd.DataTransferResponse>() { // from class: com.jieli.jl_rcsp.impl.DataTransferOpImpl.3
            @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
            public void onFailed(BaseError baseError) {
                DataTransferOpImpl.this.a(baseError);
            }

            @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
            public void onSuccess(DataTransferCmd.DataTransferResponse dataTransferResponse) {
                String str;
                if (dataTransferResponse.getResult() != 0) {
                    try {
                        str = (dataTransferResponse.getMessage() == null || dataTransferResponse.getMessage().length <= 0) ? Constants.STR_EMPTY : new String(dataTransferResponse.getMessage());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    onFailed(RcspErrorCode.buildJsonError(48, 12293, dataTransferResponse.getResult(), str));
                    return;
                }
                if (DataTransferOpImpl.this.isDataTransfer() && DataTransferOpImpl.this.d()) {
                    if (!dataTransferResponse.isEnd()) {
                        if (DataTransferOpImpl.this.d.getDataLen() > 0) {
                            float offset = (DataTransferOpImpl.this.d.getOffset() * 100.0f) / DataTransferOpImpl.this.d.getDataLen();
                            if (DataTransferOpImpl.this.d.getCallback() != null) {
                                DataTransferOpImpl.this.d.getCallback().onProgress(offset);
                            }
                        }
                        DataTransferOpImpl dataTransferOpImpl = DataTransferOpImpl.this;
                        dataTransferOpImpl.a(dataTransferOpImpl.d);
                        return;
                    }
                    OnDataEventCallback callback = DataTransferOpImpl.this.d.getCallback();
                    int dataType = DataTransferOpImpl.this.d.getDataType();
                    byte[] data = DataTransferOpImpl.this.d.getData();
                    DataTransferOpImpl.this.d.release();
                    DataTransferOpImpl.this.d = null;
                    DataTransferOpImpl.this.b.updateDataTransfer(DataTransferOpImpl.this.b(), false);
                    if (callback != null) {
                        callback.onProgress(100.0f);
                        callback.onStop(dataType, data);
                    }
                }
            }
        });
    }

    public final void a(BluetoothDevice bluetoothDevice, DataTransferCmd dataTransferCmd, DataTransferCmd.SendDataParam sendDataParam) {
        if (dataTransferCmd == null || sendDataParam == null) {
            return;
        }
        if (c()) {
            dataTransferCmd.setParam(null);
            dataTransferCmd.setStatus(3);
            this.a.sendCommandResponse(bluetoothDevice, dataTransferCmd, null);
            return;
        }
        String str = h;
        JL_Log.d(str, "handleDataParam", Constants.STR_EMPTY + sendDataParam);
        DataTransferCmd.SendDataResponse sendDataResponse = new DataTransferCmd.SendDataResponse(sendDataParam.getWay(), sendDataParam.getType(), sendDataParam.getVersion(), 0, sendDataParam.getSendDataLimit(), sendDataParam.getReceiveDataLimit());
        JL_Log.d(str, "handleDataParam", sendDataResponse + "\n data = " + CHexConver.byte2HexStr(sendDataResponse.getParamData()));
        dataTransferCmd.setParam(new DataTransferCmd.CustomReplyParam(sendDataResponse.getParamData()));
        dataTransferCmd.setStatus(0);
        this.a.sendCommandResponse(bluetoothDevice, dataTransferCmd, null);
        this.e = new ReadDataCache(new ReadParams(sendDataParam.getType(), sendDataParam.getVersion(), sendDataParam.getSendDataLimit(), sendDataParam.getReceiveDataLimit(), sendDataParam.getDataLen(), sendDataParam.getCrc()));
        this.b.updateDataTransfer(b(), true);
        Handler handler = this.f;
        handler.sendMessageDelayed(handler.obtainMessage(j, bluetoothDevice), WAITING_FOR_DATA_TIMEOUT);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0127  */
    public final void a(BluetoothDevice bluetoothDevice, DataTransferCmd dataTransferCmd, DataTransferCmd.DataTransferParam dataTransferParam) {
        if (dataTransferCmd == null || dataTransferParam == null) {
            return;
        }
        if (!c()) {
            dataTransferCmd.setParam(new DataTransferCmd.CustomReplyParam(new DataTransferCmd.DataTransferResponse(dataTransferParam.getType(), true, dataTransferParam.getSeq(), 7, a(7).getBytes()).getParamData()));
            dataTransferCmd.setStatus(0);
            this.a.sendCommandResponse(bluetoothDevice, dataTransferCmd, null);
            return;
        }
        this.f.removeMessages(j);
        byte[] data = dataTransferParam.getData();
        short sCRC16 = CryptoUtil.CRC16(data, (short) 0);
        String str = h;
        JL_Log.d(str, "handleDataEvent", RcspUtil.formatString("device give crc = %d, hex --> %s, app count crc = %d, hex --> %s", Short.valueOf(dataTransferParam.getCrc()), Integer.toHexString(dataTransferParam.getCrc()), Short.valueOf(sCRC16), Integer.toHexString(sCRC16)));
        int i2 = 1;
        if (sCRC16 == dataTransferParam.getCrc()) {
            JL_Log.d(str, "handleDataEvent", RcspUtil.formatString("device give seq = %d, app count seq = %d", Integer.valueOf(dataTransferParam.getSeq()), Integer.valueOf(this.e.getSeq() + 1)));
            if (this.e.getSeq() + 1 == dataTransferParam.getSeq()) {
                boolean zPutData = this.e.putData(data);
                JL_Log.d(str, "handleDataEvent", "write data result : " + zPutData + ", data size = " + data.length);
                if (zPutData) {
                    this.e.setOffset(dataTransferParam.getOffset());
                    this.e.setSeq(dataTransferParam.getSeq());
                    if (dataTransferParam.isEnd()) {
                        short sCRC17 = CryptoUtil.CRC16(this.e.getOutputData(), (short) 0);
                        JL_Log.i(str, "handleDataEvent", RcspUtil.formatString("Checking Data Integrity. totalCrc : %d, hex --> %s, device give data crc = %d, hex --> %s.", Short.valueOf(sCRC17), Integer.toHexString(sCRC17), Short.valueOf(this.e.getCrc()), Integer.toHexString(this.e.getCrc())));
                        if (sCRC17 == this.e.getCrc()) {
                            i2 = 0;
                        }
                    } else {
                        i2 = 0;
                    }
                } else {
                    i2 = 6;
                }
            } else {
                i2 = 2;
            }
        }
        DataTransferCmd.DataTransferResponse dataTransferResponse = new DataTransferCmd.DataTransferResponse(dataTransferParam.getType(), dataTransferParam.isEnd(), dataTransferParam.getSeq(), i2, a(i2).getBytes());
        JL_Log.d(str, "handleDataEvent", "result = " + i2);
        dataTransferCmd.setParam(new DataTransferCmd.CustomReplyParam(dataTransferResponse.getParamData()));
        dataTransferCmd.setStatus(0);
        this.a.sendCommandResponse(bluetoothDevice, dataTransferCmd, null);
        if (i2 == 0) {
            OnDataEventCallback callback = this.e.getCallback();
            if (dataTransferParam.isEnd()) {
                byte[] bArr = (byte[]) this.e.getOutputData().clone();
                this.e.release();
                this.e = null;
                this.b.updateDataTransfer(b(), false);
                if (callback != null) {
                    callback.onProgress(100.0f);
                    callback.onStop(dataTransferParam.getType(), bArr);
                }
                this.c.onReceiveData(bluetoothDevice, dataTransferParam.getType(), bArr);
                return;
            }
            if (this.e.getDataLen() > 0) {
                float offset = ((this.e.getOffset() + data.length) * 100.0f) / this.e.getDataLen();
                if (callback != null) {
                    callback.onProgress(offset);
                }
            }
            Handler handler = this.f;
            handler.sendMessageDelayed(handler.obtainMessage(j, bluetoothDevice), WAITING_FOR_DATA_TIMEOUT);
            return;
        }
        a(bluetoothDevice, RcspErrorCode.buildJsonError(48, 12293, i2, null));
    }

    public final void a(DataTransferCmd.SendDataParam sendDataParam, OnOperationCallback<DataTransferCmd.SendDataResponse> onOperationCallback) {
        if (sendDataParam != null) {
            this.a.sendRcspCommand(b(), new DataTransferCmd(sendDataParam), new CustomRcspActionCallback("sendDataParam", onOperationCallback, new IHandleResult<DataTransferCmd.SendDataResponse, DataTransferCmd>() { // from class: com.jieli.jl_rcsp.impl.DataTransferOpImpl.4
                @Override // com.jieli.jl_rcsp.interfaces.IHandleResult
                public int hasResult(BluetoothDevice bluetoothDevice, DataTransferCmd dataTransferCmd) {
                    return 0;
                }

                @Override // com.jieli.jl_rcsp.interfaces.IHandleResult
                public DataTransferCmd.SendDataResponse handleResult(BluetoothDevice bluetoothDevice, DataTransferCmd dataTransferCmd) {
                    if (dataTransferCmd != null && dataTransferCmd.getStatus() == 0 && (dataTransferCmd.getResponse() instanceof DataTransferCmd.SendDataResponse)) {
                        return (DataTransferCmd.SendDataResponse) dataTransferCmd.getResponse();
                    }
                    return null;
                }
            }));
        } else if (onOperationCallback != null) {
            onOperationCallback.onFailed(new BaseError(4097, "SendDataParam can not be null."));
        }
    }

    public final void a(DataTransferCmd.ReadDataParam readDataParam, OnOperationCallback<DataTransferCmd.ReadDataResponse> onOperationCallback) {
        if (readDataParam != null) {
            this.a.sendRcspCommand(b(), new DataTransferCmd(readDataParam), new CustomRcspActionCallback("readDataParam", onOperationCallback, new IHandleResult<DataTransferCmd.ReadDataResponse, DataTransferCmd>() { // from class: com.jieli.jl_rcsp.impl.DataTransferOpImpl.5
                @Override // com.jieli.jl_rcsp.interfaces.IHandleResult
                public int hasResult(BluetoothDevice bluetoothDevice, DataTransferCmd dataTransferCmd) {
                    return 0;
                }

                @Override // com.jieli.jl_rcsp.interfaces.IHandleResult
                public DataTransferCmd.ReadDataResponse handleResult(BluetoothDevice bluetoothDevice, DataTransferCmd dataTransferCmd) {
                    if (dataTransferCmd != null && dataTransferCmd.getStatus() == 0 && (dataTransferCmd.getResponse() instanceof DataTransferCmd.ReadDataResponse)) {
                        return (DataTransferCmd.ReadDataResponse) dataTransferCmd.getResponse();
                    }
                    return null;
                }
            }));
        } else if (onOperationCallback != null) {
            onOperationCallback.onFailed(new BaseError(4097, "ReadDataParam can not be null."));
        }
    }

    public final void a(DataTransferCmd.DataTransferParam dataTransferParam, OnOperationCallback<DataTransferCmd.DataTransferResponse> onOperationCallback) {
        if (dataTransferParam != null) {
            this.a.sendRcspCommand(b(), new DataTransferCmd(dataTransferParam), new CustomRcspActionCallback("sendDataBlock", onOperationCallback, new IHandleResult<DataTransferCmd.DataTransferResponse, DataTransferCmd>() { // from class: com.jieli.jl_rcsp.impl.DataTransferOpImpl.6
                @Override // com.jieli.jl_rcsp.interfaces.IHandleResult
                public int hasResult(BluetoothDevice bluetoothDevice, DataTransferCmd dataTransferCmd) {
                    return 0;
                }

                @Override // com.jieli.jl_rcsp.interfaces.IHandleResult
                public DataTransferCmd.DataTransferResponse handleResult(BluetoothDevice bluetoothDevice, DataTransferCmd dataTransferCmd) {
                    if (dataTransferCmd != null && dataTransferCmd.getStatus() == 0 && (dataTransferCmd.getResponse() instanceof DataTransferCmd.DataTransferResponse)) {
                        return (DataTransferCmd.DataTransferResponse) dataTransferCmd.getResponse();
                    }
                    return null;
                }
            }));
        } else if (onOperationCallback != null) {
            onOperationCallback.onFailed(new BaseError(4097, "DataTransferParam can not be null."));
        }
    }

    public final void a(int i2, OnOperationCallback<Boolean> onOperationCallback) {
        this.a.sendRcspCommand(b(), new DataTransferCmd(new DataTransferCmd.CancelTransferParam(i2)), new BooleanRcspActionCallback("cancelTransfer", onOperationCallback));
    }

    public static String a(int i2) {
        switch (i2) {
            case 0:
                return "Successful.";
            case 1:
                return "CRC error.";
            case 2:
                return "Sequence error.";
            case 3:
                return "Data type is not supported.";
            case 4:
                return "Transfer way is not supported.";
            case 5:
                return "Data length is out of bounds.";
            case 6:
                return "Read/write Data Exception.";
            case 7:
                return "Missing parameter configuration.";
            default:
                return Constants.STR_EMPTY;
        }
    }
}
