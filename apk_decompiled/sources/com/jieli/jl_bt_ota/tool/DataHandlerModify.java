package com.jieli.jl_bt_ota.tool;

import android.bluetooth.BluetoothDevice;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.jieli.jl_bt_ota.constant.ErrorCode;
import com.jieli.jl_bt_ota.impl.BluetoothOTAManager;
import com.jieli.jl_bt_ota.model.DataInfo;
import com.jieli.jl_bt_ota.model.OTAError;
import com.jieli.jl_bt_ota.model.base.BaseError;
import com.jieli.jl_bt_ota.model.base.BasePacket;
import com.jieli.jl_bt_ota.model.base.CommandBase;
import com.jieli.jl_bt_ota.tool.DataHandlerModify;
import com.jieli.jl_bt_ota.util.CHexConver;
import com.jieli.jl_bt_ota.util.JL_Log;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class DataHandlerModify implements IDataHandler {
    private final BluetoothOTAManager b;
    private final RcspParser c;
    private final HandlerThread e;
    private final Handler f;
    private final Handler g;
    private final String a = DataHandlerModify.class.getSimpleName();
    private final DataInfoCache d = new DataInfoCache();

    private class TimeOutCheck implements Runnable {
        private final DataInfo a;

        public TimeOutCheck(DataInfo dataInfo) {
            this.a = dataInfo;
            dataInfo.setSendTime(System.currentTimeMillis());
        }

        @Override // java.lang.Runnable
        public void run() {
            BasePacket basePacket = this.a.getBasePacket();
            JL_Log.w(DataHandlerModify.this.a, "send data timeout  --> opCode : " + basePacket.getOpCode() + ", sn : " + basePacket.getOpCodeSn() + ", resend Count : " + this.a.getReSendCount());
            if (this.a.getReSendCount() < 3) {
                DataInfo dataInfo = this.a;
                dataInfo.setReSendCount(dataInfo.getReSendCount() + 1);
                DataHandlerModify.this.d.remove(this.a);
                DataHandlerModify.this.addSendData(this.a);
                return;
            }
            DataHandlerModify.this.d.remove(this.a);
            DataHandlerModify.this.b.removeCacheCommand(this.a.getDevice(), this.a.getBasePacket());
            DataHandlerModify.this.a(this.a, OTAError.buildError(ErrorCode.SUB_ERR_SEND_TIMEOUT));
        }
    }

    public DataHandlerModify(BluetoothOTAManager bluetoothOTAManager) {
        HandlerThread handlerThread = new HandlerThread("DataHandlerModify");
        this.e = handlerThread;
        this.g = new Handler(Looper.getMainLooper());
        this.b = bluetoothOTAManager;
        this.c = new RcspParser();
        handlerThread.start();
        this.f = new Handler(handlerThread.getLooper(), new Handler.Callback() { // from class: j60
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return DataHandlerModify.a(message);
            }
        });
    }

    @Override // com.jieli.jl_bt_ota.tool.IDataHandler
    public void addRecvData(final DataInfo dataInfo) {
        this.f.post(new Runnable() { // from class: b60
            @Override // java.lang.Runnable
            public final void run() {
                this.a.a(dataInfo);
            }
        });
    }

    @Override // com.jieli.jl_bt_ota.tool.IDataHandler
    public void addSendData(final DataInfo dataInfo) {
        dataInfo.setSendTime(a());
        this.f.post(new Runnable() { // from class: h60
            @Override // java.lang.Runnable
            public final void run() {
                this.a.b(dataInfo);
            }
        });
    }

    @Override // com.jieli.jl_bt_ota.tool.IDataHandler
    public void release() {
        this.f.removeCallbacksAndMessages(null);
        this.c.release();
        this.d.clear();
        if (this.e.isInterrupted()) {
            return;
        }
        this.e.quitSafely();
    }

    private int d(DataInfo dataInfo) {
        if (dataInfo == null) {
            return Integer.MAX_VALUE;
        }
        return dataInfo.getBasePacket().getOpCode() | (dataInfo.getBasePacket().getOpCodeSn() << 16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean a(Message message) {
        Object obj = message.obj;
        if (!(obj instanceof Runnable)) {
            return true;
        }
        ((Runnable) obj).run();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(DataInfo dataInfo) {
        if (!c(dataInfo)) {
            a(dataInfo, OTAError.buildError(12290));
            return;
        }
        if (dataInfo.getBasePacket().getHasResponse() == 1) {
            this.d.add(dataInfo);
            Handler handler = this.f;
            handler.sendMessageDelayed(handler.obtainMessage(d(dataInfo), new TimeOutCheck(dataInfo)), dataInfo.getTimeoutMs());
            return;
        }
        BasePacket basePacket = dataInfo.getBasePacket();
        int opCodeSn = basePacket.getOpCodeSn();
        basePacket.setOpCodeSn(256);
        CommandBase commandBaseConvert2Command = ParseHelper.convert2Command(basePacket, this.b.getCacheCommand(dataInfo.getDevice(), basePacket));
        if (commandBaseConvert2Command != null) {
            commandBaseConvert2Command.setOpCodeSn(opCodeSn);
        }
        a(dataInfo, commandBaseConvert2Command);
    }

    private boolean c(DataInfo dataInfo) {
        byte[] bArrPackSendBasePacket = ParseHelper.packSendBasePacket(dataInfo.getBasePacket());
        if (bArrPackSendBasePacket == null) {
            JL_Log.i(this.a, "send data :: pack data error.");
            return false;
        }
        int iA = a(dataInfo.getDevice());
        if (bArrPackSendBasePacket.length > iA) {
            JL_Log.e(this.a, "send data over communication mtu [" + iA + "] limit.");
            return false;
        }
        boolean zSendDataToDevice = false;
        for (int i = 0; i < 3 && !(zSendDataToDevice = this.b.sendDataToDevice(dataInfo.getDevice(), bArrPackSendBasePacket)); i++) {
            try {
                Thread.sleep(10L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        JL_Log.i(this.a, "send ret : " + zSendDataToDevice);
        return zSendDataToDevice;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(DataInfo dataInfo) {
        ArrayList<BasePacket> arrayListFindPacketData = this.c.findPacketData(b(dataInfo.getDevice()), dataInfo.getRecvData());
        if (arrayListFindPacketData != null && !arrayListFindPacketData.isEmpty()) {
            int size = arrayListFindPacketData.size();
            int i = 0;
            while (i < size) {
                BasePacket basePacket = arrayListFindPacketData.get(i);
                i++;
                BasePacket basePacket2 = basePacket;
                byte[] bArrPackSendBasePacket = ParseHelper.packSendBasePacket(basePacket2);
                if (basePacket2.getType() == 1) {
                    this.b.receiveDataFromDevice(dataInfo.getDevice(), bArrPackSendBasePacket);
                } else {
                    DataInfo dataInfo2 = this.d.getDataInfo(basePacket2);
                    if (dataInfo2 == null) {
                        JL_Log.w(this.a, "addRecvData : not found cache data info. " + basePacket2);
                    } else {
                        CommandBase commandBaseConvert2Command = ParseHelper.convert2Command(basePacket2, this.b.getCacheCommand(dataInfo.getDevice(), basePacket2));
                        if (commandBaseConvert2Command == null) {
                            BaseError baseErrorBuildError = OTAError.buildError(12293);
                            baseErrorBuildError.setOpCode(basePacket2.getOpCode());
                            a(dataInfo2, baseErrorBuildError);
                        } else {
                            this.b.receiveDataFromDevice(dataInfo.getDevice(), bArrPackSendBasePacket);
                        }
                        this.d.remove(dataInfo2);
                        this.f.removeMessages(d(dataInfo2));
                        a(dataInfo2, commandBaseConvert2Command);
                        this.b.removeCacheCommand(dataInfo.getDevice(), basePacket2);
                    }
                }
            }
            return;
        }
        JL_Log.w(this.a, "addRecvData : not found cmd. " + CHexConver.byte2HexStr(dataInfo.getRecvData()));
    }

    private int b(BluetoothDevice bluetoothDevice) {
        return this.b.getReceiveMtu(bluetoothDevice);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(DataInfo dataInfo, BaseError baseError) {
        if (dataInfo.getCallback() != null) {
            dataInfo.getCallback().onErrCode(baseError);
        }
        this.b.errorEventCallback(baseError);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(DataInfo dataInfo, CommandBase commandBase) {
        dataInfo.getCallback().onCommandResponse(commandBase);
    }

    private long a() {
        return System.currentTimeMillis();
    }

    private int a(BluetoothDevice bluetoothDevice) {
        return this.b.getCommunicationMtu(bluetoothDevice);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final DataInfo dataInfo, final BaseError baseError) {
        if (dataInfo == null) {
            JL_Log.d(this.a, "callError : param is null");
            return;
        }
        if (dataInfo.getBasePacket() != null) {
            baseError.setOpCode(dataInfo.getBasePacket().getOpCode());
        }
        JL_Log.w(this.a, "callError : " + baseError);
        this.g.post(new Runnable() { // from class: f60
            @Override // java.lang.Runnable
            public final void run() {
                this.a.b(dataInfo, baseError);
            }
        });
    }

    private void a(final DataInfo dataInfo, final CommandBase commandBase) {
        if (dataInfo != null && dataInfo.getCallback() != null && commandBase != null) {
            this.g.post(new Runnable() { // from class: d60
                @Override // java.lang.Runnable
                public final void run() {
                    DataHandlerModify.b(dataInfo, commandBase);
                }
            });
            return;
        }
        JL_Log.d(this.a, " callbackCmd : param is null. " + dataInfo);
    }
}
