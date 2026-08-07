package com.jieli.jl_rcsp.tool.datahandles;

import android.bluetooth.BluetoothDevice;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.jieli.jl_rcsp.interfaces.bluetooth.IBluetoothProxy;
import com.jieli.jl_rcsp.interfaces.rcsp.RcspCommandCallback;
import com.jieli.jl_rcsp.model.DataInfo;
import com.jieli.jl_rcsp.model.base.BaseError;
import com.jieli.jl_rcsp.model.base.BasePacket;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.tool.CommandHelper;
import com.jieli.jl_rcsp.tool.DeviceStatusManager;
import com.jieli.jl_rcsp.tool.datahandles.DataHandlerModify;
import com.jieli.jl_rcsp.util.CHexConver;
import com.jieli.jl_rcsp.util.JL_Log;
import com.jieli.jl_rcsp.util.RcspUtil;
import defpackage.a60;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class DataHandlerModify implements DataHandler {
    public final IBluetoothProxy c;
    public final BasePacketParse d;
    public final HandlerThread f;
    public final Handler g;
    public final Handler h;
    public final String a = DataHandlerModify.class.getSimpleName();
    public final DeviceStatusManager b = DeviceStatusManager.getInstance();
    public final DataInfoCache e = new DataInfoCache();

    public class TimeOutCheck implements Runnable {
        public final DataInfo a;

        public TimeOutCheck(DataInfo dataInfo) {
            this.a = dataInfo;
            dataInfo.setSendTime(System.currentTimeMillis());
        }

        @Override // java.lang.Runnable
        public void run() {
            BasePacket basePacket;
            DataInfo dataInfo = this.a;
            if (dataInfo == null || (basePacket = dataInfo.getBasePacket()) == null) {
                return;
            }
            BluetoothDevice device = this.a.getDevice();
            int opCode = basePacket.getOpCode();
            int opCodeSn = basePacket.getOpCodeSn();
            int reSendCount = this.a.getReSendCount();
            JL_Log.w(DataHandlerModify.this.a, "TimeOutCheck", RcspUtil.formatString("Waiting for reply command timeout.\ndevice : %s, op : %d(0x%X), sn : %d, reSendCount : %d.", device, Integer.valueOf(opCode), Integer.valueOf(opCode), Integer.valueOf(opCodeSn), Integer.valueOf(reSendCount)));
            if (reSendCount < 3) {
                this.a.setReSendCount(reSendCount + 1);
                DataHandlerModify.this.e.remove(this.a);
                DataHandlerModify.this.addSendData(this.a);
            } else {
                DataHandlerModify.this.e.remove(this.a);
                CommandHelper.getInstance().removeCommandBase(device, basePacket);
                DataHandlerModify.this.a(this.a, new BaseError(12290));
            }
        }
    }

    public DataHandlerModify(IBluetoothProxy iBluetoothProxy) {
        HandlerThread handlerThread = new HandlerThread("DataHandlerModify");
        this.f = handlerThread;
        this.h = new Handler(Looper.getMainLooper());
        if (iBluetoothProxy == null) {
            throw new NullPointerException("IBluetoothProxy can not be null.");
        }
        this.c = iBluetoothProxy;
        this.d = new BasePacketParse();
        handlerThread.start();
        this.g = new Handler(handlerThread.getLooper(), new Handler.Callback() { // from class: c60
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return DataHandlerModify.a(message);
            }
        });
    }

    @Override // com.jieli.jl_rcsp.tool.datahandles.DataHandler
    public void addRecvData(final DataInfo dataInfo) {
        this.g.post(new Runnable() { // from class: i60
            @Override // java.lang.Runnable
            public final void run() {
                this.a.a(dataInfo);
            }
        });
    }

    @Override // com.jieli.jl_rcsp.tool.datahandles.DataHandler
    public void addSendData(final DataInfo dataInfo) {
        dataInfo.setSendTime(a());
        this.g.post(new Runnable() { // from class: e60
            @Override // java.lang.Runnable
            public final void run() {
                this.a.b(dataInfo);
            }
        });
    }

    public final boolean c(DataInfo dataInfo) {
        byte[] bArrPackSendBasePacket = ParseHelper.packSendBasePacket(dataInfo.getBasePacket());
        if (bArrPackSendBasePacket == null) {
            JL_Log.i(this.a, "sendData", "Packing data failed.");
            return false;
        }
        int iA = a(dataInfo.getDevice());
        if (bArrPackSendBasePacket.length > iA) {
            JL_Log.e(this.a, "sendData", "The length of the sent data exceeds the limit[" + iA + "].");
            return false;
        }
        boolean zSendDataToDevice = false;
        for (int i = 0; i < 3 && !(zSendDataToDevice = this.c.sendDataToDevice(dataInfo.getDevice(), bArrPackSendBasePacket)); i++) {
            try {
                Thread.sleep(10L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        JL_Log.d(this.a, "sendData", RcspUtil.formatString("result : %s, data : [%s]", Boolean.valueOf(zSendDataToDevice), CHexConver.byte2HexStr(bArrPackSendBasePacket)));
        return zSendDataToDevice;
    }

    public final int d(DataInfo dataInfo) {
        if (dataInfo == null) {
            return Integer.MAX_VALUE;
        }
        return dataInfo.getBasePacket().getOpCode() | (dataInfo.getBasePacket().getOpCodeSn() << 16);
    }

    @Override // com.jieli.jl_rcsp.tool.datahandles.DataHandler
    public void release() {
        JL_Log.i(this.a, "release", "=====>>>");
        this.g.removeCallbacksAndMessages(null);
        this.d.release();
        CommandHelper.getInstance().release();
        if (!this.e.isEmpty()) {
            ArrayList<DataInfo> arrayList = new ArrayList(this.e);
            this.e.clear();
            for (DataInfo dataInfo : arrayList) {
                RcspCommandCallback rcspCmdCallback = dataInfo.getRcspCmdCallback();
                if (rcspCmdCallback != null) {
                    rcspCmdCallback.onErrCode(dataInfo.getDevice(), new BaseError(8192));
                }
            }
        }
        this.f.quitSafely();
    }

    public final /* synthetic */ void b(DataInfo dataInfo) {
        if (!c(dataInfo)) {
            a(dataInfo, new BaseError(12288));
            return;
        }
        if (dataInfo.getBasePacket().getHasResponse() == 1) {
            this.e.add(dataInfo);
            Handler handler = this.g;
            handler.sendMessageDelayed(handler.obtainMessage(d(dataInfo), new TimeOutCheck(dataInfo)), dataInfo.getTimeoutMs());
            return;
        }
        BasePacket basePacket = dataInfo.getBasePacket();
        int opCodeSn = basePacket.getOpCodeSn();
        basePacket.setOpCodeSn(256);
        CommandBase commandBaseConvert2Command = ParseHelper.convert2Command(dataInfo.getDevice(), basePacket);
        if (commandBaseConvert2Command != null) {
            commandBaseConvert2Command.setOpCodeSn(opCodeSn);
        }
        a(dataInfo, commandBaseConvert2Command);
    }

    public static /* synthetic */ boolean a(Message message) {
        Object obj = message.obj;
        if (!(obj instanceof Runnable)) {
            return true;
        }
        ((Runnable) obj).run();
        return true;
    }

    public final /* synthetic */ void a(DataInfo dataInfo) {
        ArrayList<BasePacket> arrayListFindPacketData = this.d.findPacketData(b(dataInfo.getDevice()), dataInfo.getRecvData());
        if (arrayListFindPacketData != null && !arrayListFindPacketData.isEmpty()) {
            for (BasePacket basePacket : arrayListFindPacketData) {
                if (basePacket.getType() == 1) {
                    this.c.receiveDataFromDevice(dataInfo.getDevice(), basePacket);
                } else {
                    DataInfo dataInfo2 = this.e.getDataInfo(basePacket);
                    if (dataInfo2 == null) {
                        JL_Log.w(this.a, "addRecvData", "No cached command found. " + basePacket);
                    } else {
                        CommandBase commandBaseConvert2Command = ParseHelper.convert2Command(dataInfo2.getDevice(), basePacket);
                        if (commandBaseConvert2Command == null) {
                            a(dataInfo2, new BaseError(12289));
                        } else {
                            this.c.receiveDataFromDevice(dataInfo.getDevice(), basePacket);
                        }
                        this.e.remove(dataInfo2);
                        this.g.removeMessages(d(dataInfo2));
                        a(dataInfo2, commandBaseConvert2Command);
                        CommandHelper.getInstance().removeCommandBase(dataInfo2.getDevice(), basePacket);
                    }
                }
            }
            return;
        }
        JL_Log.w(this.a, "addRecvData", "Not found command.");
    }

    public final int b(BluetoothDevice bluetoothDevice) {
        return this.b.getMaxReceiveMtu(bluetoothDevice);
    }

    public final /* synthetic */ void b(DataInfo dataInfo, BaseError baseError) {
        JL_Log.w(this.a, "callError", "device : " + dataInfo.getDevice() + ", " + baseError);
        dataInfo.getRcspCmdCallback().onErrCode(dataInfo.getDevice(), baseError);
        this.c.callbackErrorEvent(baseError);
    }

    public final long a() {
        return System.currentTimeMillis();
    }

    public final int a(BluetoothDevice bluetoothDevice) {
        return this.b.getMaxCommunicationMtu(bluetoothDevice);
    }

    public final void a(final DataInfo dataInfo, final BaseError baseError) {
        if (dataInfo == null || dataInfo.getRcspCmdCallback() == null || baseError == null) {
            return;
        }
        if (dataInfo.getBasePacket() != null) {
            baseError.setOpCode(dataInfo.getBasePacket().getOpCode());
        }
        this.h.post(new Runnable() { // from class: g60
            @Override // java.lang.Runnable
            public final void run() {
                this.a.b(dataInfo, baseError);
            }
        });
    }

    public final void a(DataInfo dataInfo, CommandBase commandBase) {
        if (dataInfo == null || dataInfo.getRcspCmdCallback() == null || commandBase == null) {
            return;
        }
        this.h.post(new a60(dataInfo.getRcspCmdCallback(), dataInfo, commandBase));
    }

    public static /* synthetic */ void a(RcspCommandCallback rcspCommandCallback, DataInfo dataInfo, CommandBase commandBase) {
        if (rcspCommandCallback != null) {
            rcspCommandCallback.onCommandResponse(dataInfo.getDevice(), commandBase);
        }
    }
}
