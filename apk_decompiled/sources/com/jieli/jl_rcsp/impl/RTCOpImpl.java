package com.jieli.jl_rcsp.impl;

import android.bluetooth.BluetoothDevice;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.jieli.jl_rcsp.constant.RcspErrorCode;
import com.jieli.jl_rcsp.interfaces.IHandleResult;
import com.jieli.jl_rcsp.interfaces.OnOperationCallback;
import com.jieli.jl_rcsp.interfaces.alarm.IRTCOp;
import com.jieli.jl_rcsp.interfaces.data.OnDataTransferListener;
import com.jieli.jl_rcsp.interfaces.rcsp.RcspCommandCallback;
import com.jieli.jl_rcsp.model.LtvBean;
import com.jieli.jl_rcsp.model.base.BaseError;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.model.command.AlarmExpandCmd;
import com.jieli.jl_rcsp.model.device.AlarmBean;
import com.jieli.jl_rcsp.model.device.AlarmListInfo;
import com.jieli.jl_rcsp.model.device.AuditionParam;
import com.jieli.jl_rcsp.model.device.DefaultAlarmBell;
import com.jieli.jl_rcsp.model.device.DeviceInfo;
import com.jieli.jl_rcsp.tool.BooleanRcspActionCallback;
import com.jieli.jl_rcsp.tool.CustomRcspActionCallback;
import com.jieli.jl_rcsp.tool.callback.RcspEventListenerManager;
import com.jieli.jl_rcsp.util.CHexConver;
import com.jieli.jl_rcsp.util.CommandBuilder;
import com.jieli.jl_rcsp.util.DataUtil;
import com.jieli.jl_rcsp.util.JL_Log;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class RTCOpImpl implements IRTCOp {
    public static final int WAY_NOTIFY = 1;
    public static final int WAY_REPLY = 0;
    public static final String f = "RTCOpImpl";
    public static final int g = 6000;
    public static final int h = 41216;
    public final RcspOpImpl a;
    public final DataTransferOpImpl b;
    public OnOperationCallback<Boolean> c;
    public final Handler d = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: ba2
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            return this.a.a(message);
        }
    });
    public final OnDataTransferListener e;

    public static class BigRTCData {
        public int a;
        public int b;
        public byte[] c;

        public BigRTCData(byte[] bArr) {
            a(bArr);
        }

        public void a(byte[] bArr) {
            int iByteToInt = CHexConver.byteToInt(bArr[0]);
            this.a = iByteToInt;
            if (iByteToInt == 0) {
                this.b = CHexConver.byteToInt(bArr[1]);
                int iMin = Math.min(CHexConver.bytesToInt(bArr, 2, 2), bArr.length - 4);
                byte[] bArr2 = new byte[iMin];
                this.c = bArr2;
                System.arraycopy(bArr, 4, bArr2, 0, iMin);
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("BigRTCData{version=");
            sb.append(this.a);
            sb.append(", way=");
            sb.append(this.b);
            sb.append(", len=");
            byte[] bArr = this.c;
            sb.append(bArr == null ? 0 : bArr.length);
            sb.append(", payload=");
            sb.append(CHexConver.byte2HexStr(this.c));
            sb.append('}');
            return sb.toString();
        }
    }

    public class ReadAlarmRcspCallback implements RcspCommandCallback<CommandBase> {
        public final OnOperationCallback<Boolean> a;

        public ReadAlarmRcspCallback(OnOperationCallback<Boolean> onOperationCallback) {
            this.a = onOperationCallback;
        }

        @Override // com.jieli.jl_rcsp.interfaces.rcsp.RcspCommandCallback
        public void onCommandResponse(BluetoothDevice bluetoothDevice, CommandBase commandBase) {
            if (commandBase.getStatus() == 0) {
                OnOperationCallback<Boolean> onOperationCallback = this.a;
                if (onOperationCallback != null) {
                    onOperationCallback.onSuccess(Boolean.TRUE);
                    return;
                }
                return;
            }
            if (commandBase.getStatus() != 8) {
                onErrCode(bluetoothDevice, RcspErrorCode.buildJsonError(commandBase.getId(), 12292, commandBase.getStatus(), null));
                return;
            }
            JL_Log.w(RTCOpImpl.f, "STATUS_RESPONSE_DATA_OVER_LIMIT", "start .... MSG_WAIT_ALARM_DATA >> ");
            RTCOpImpl.this.c = this.a;
            RTCOpImpl.this.d.removeMessages(RTCOpImpl.h);
            RTCOpImpl.this.d.sendEmptyMessageDelayed(RTCOpImpl.h, 6000L);
        }

        @Override // com.jieli.jl_rcsp.interfaces.rcsp.RcspCommandCallback
        public void onErrCode(BluetoothDevice bluetoothDevice, BaseError baseError) {
            OnOperationCallback<Boolean> onOperationCallback = this.a;
            if (onOperationCallback != null) {
                onOperationCallback.onFailed(baseError);
            }
        }
    }

    public RTCOpImpl(RcspOpImpl rcspOpImpl) {
        OnDataTransferListener onDataTransferListener = new OnDataTransferListener() { // from class: com.jieli.jl_rcsp.impl.RTCOpImpl.2
            @Override // com.jieli.jl_rcsp.interfaces.data.OnDataTransferListener
            public void onError(BluetoothDevice bluetoothDevice, BaseError baseError) {
            }

            @Override // com.jieli.jl_rcsp.interfaces.data.OnDataTransferListener
            public void onReceiveData(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
                if (i == 2) {
                    BigRTCData bigRTCData = new BigRTCData(bArr);
                    if (RTCOpImpl.this.b() && bigRTCData.b == 0) {
                        if (RTCOpImpl.this.c != null) {
                            RTCOpImpl.this.c.onSuccess(Boolean.TRUE);
                            RTCOpImpl.this.c = null;
                        }
                        RTCOpImpl.this.d.removeMessages(RTCOpImpl.h);
                    }
                }
            }
        };
        this.e = onDataTransferListener;
        if (rcspOpImpl == null) {
            throw new NullPointerException("WatchOpImpl can not be null.");
        }
        this.a = rcspOpImpl;
        DataTransferOpImpl dataTransferOpImplInstance = DataTransferOpImpl.instance(rcspOpImpl);
        this.b = dataTransferOpImplInstance;
        dataTransferOpImplInstance.addListener(onDataTransferListener);
    }

    public static void parseRTCBigData(RcspOpImpl rcspOpImpl, RcspEventListenerManager rcspEventListenerManager, byte[] bArr) {
        if (rcspOpImpl == null) {
            return;
        }
        BigRTCData bigRTCData = new BigRTCData(bArr);
        if (bigRTCData.a == 0) {
            a(rcspOpImpl, rcspEventListenerManager, bigRTCData.c);
        }
    }

    @Override // com.jieli.jl_rcsp.interfaces.alarm.IRTCOp
    public void addOrModifyAlarm(BluetoothDevice bluetoothDevice, AlarmBean alarmBean, OnOperationCallback<Boolean> onOperationCallback) {
        if (alarmBean != null) {
            this.a.sendRcspCommand(bluetoothDevice, CommandBuilder.buildSetAlarmCmd(AlarmBean.toAttrbean(alarmBean, false)), new BooleanRcspActionCallback("addOrModifyAlarm", onOperationCallback));
            return;
        }
        BaseError baseError = new BaseError(4097, "AlarmBean is null.");
        if (onOperationCallback != null) {
            onOperationCallback.onFailed(baseError);
        }
    }

    @Override // com.jieli.jl_rcsp.interfaces.alarm.IRTCOp
    public void auditionAlarmBell(BluetoothDevice bluetoothDevice, AuditionParam auditionParam, OnOperationCallback<Boolean> onOperationCallback) {
        if (auditionParam != null) {
            this.a.sendRcspCommand(bluetoothDevice, CommandBuilder.buildAuditionAlarmBellCmd(auditionParam.getType(), auditionParam.getDev(), auditionParam.getCluster()), new BooleanRcspActionCallback("auditionAlarmBell", onOperationCallback));
            return;
        }
        BaseError baseError = new BaseError(4097, "AlarmExpandCmd.BellArg is null.");
        if (onOperationCallback != null) {
            onOperationCallback.onFailed(baseError);
        }
    }

    @Override // com.jieli.jl_rcsp.interfaces.alarm.IRTCOp
    public void deleteAlarm(BluetoothDevice bluetoothDevice, AlarmBean alarmBean, OnOperationCallback<Boolean> onOperationCallback) {
        if (alarmBean != null) {
            this.a.sendRcspCommand(bluetoothDevice, CommandBuilder.buildDelAlarmCmd(AlarmBean.toAttrbean(alarmBean, true)), new BooleanRcspActionCallback("deleteAlarm", onOperationCallback));
            return;
        }
        BaseError baseError = new BaseError(4097, "AlarmBean is null.");
        if (onOperationCallback != null) {
            onOperationCallback.onFailed(baseError);
        }
    }

    public void destroy() {
        this.d.removeCallbacksAndMessages(null);
        this.b.removeListener(this.e);
    }

    public BluetoothDevice getConnectedDevice() {
        return this.a.getConnectedDevice();
    }

    public RcspOpImpl getRcspOp() {
        return this.a;
    }

    @Override // com.jieli.jl_rcsp.interfaces.alarm.IRTCOp
    public void readAlarmBellArgs(BluetoothDevice bluetoothDevice, byte b, OnOperationCallback<List<AlarmExpandCmd.BellArg>> onOperationCallback) {
        this.a.sendRcspCommand(bluetoothDevice, CommandBuilder.buildReadBellArgsCmd(b), new CustomRcspActionCallback("readAlarmBellArgs", onOperationCallback, new IHandleResult<List<AlarmExpandCmd.BellArg>, AlarmExpandCmd>() { // from class: com.jieli.jl_rcsp.impl.RTCOpImpl.1
            @Override // com.jieli.jl_rcsp.interfaces.IHandleResult
            public int hasResult(BluetoothDevice bluetoothDevice2, AlarmExpandCmd alarmExpandCmd) {
                return 0;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.jieli.jl_rcsp.interfaces.IHandleResult
            public List<AlarmExpandCmd.BellArg> handleResult(BluetoothDevice bluetoothDevice2, AlarmExpandCmd alarmExpandCmd) {
                AlarmExpandCmd.Response response = (AlarmExpandCmd.Response) alarmExpandCmd.getResponse();
                if (response != null && (response instanceof AlarmExpandCmd.ReadRtcBellArgsResponse)) {
                    return ((AlarmExpandCmd.ReadRtcBellArgsResponse) response).getBellArg();
                }
                return null;
            }
        }));
    }

    @Override // com.jieli.jl_rcsp.interfaces.alarm.IRTCOp
    public void readAlarmDefaultBellList(BluetoothDevice bluetoothDevice, OnOperationCallback<Boolean> onOperationCallback) {
        if (!b()) {
            this.a.sendRcspCommand(bluetoothDevice, CommandBuilder.buildGetDefaultAlarmBellsCmd(), new ReadAlarmRcspCallback(onOperationCallback));
        } else if (onOperationCallback != null) {
            onOperationCallback.onFailed(new BaseError(4352, "Reading alarm data is in progress."));
        }
    }

    @Override // com.jieli.jl_rcsp.interfaces.alarm.IRTCOp
    public void readAlarmList(BluetoothDevice bluetoothDevice, OnOperationCallback<Boolean> onOperationCallback) {
        if (!b()) {
            this.a.sendRcspCommand(bluetoothDevice, CommandBuilder.buildGetAlarmCmd(), new ReadAlarmRcspCallback(onOperationCallback));
        } else if (onOperationCallback != null) {
            onOperationCallback.onFailed(new BaseError(4352, "Reading alarm data is in progress."));
        }
    }

    @Override // com.jieli.jl_rcsp.interfaces.alarm.IRTCOp
    public void setAlarmBellArg(BluetoothDevice bluetoothDevice, AlarmExpandCmd.BellArg bellArg, OnOperationCallback<Boolean> onOperationCallback) {
        if (bellArg != null) {
            this.a.sendRcspCommand(bluetoothDevice, CommandBuilder.buildSetBellArgsCmd(bellArg), new BooleanRcspActionCallback("setAlarmBellArg", onOperationCallback));
            return;
        }
        BaseError baseError = new BaseError(4097, "AlarmExpandCmd.BellArg is null.");
        if (onOperationCallback != null) {
            onOperationCallback.onFailed(baseError);
        }
    }

    @Override // com.jieli.jl_rcsp.interfaces.alarm.IRTCOp
    public void stopAlarmBell(BluetoothDevice bluetoothDevice, OnOperationCallback<Boolean> onOperationCallback) {
        this.a.sendRcspCommand(bluetoothDevice, CommandBuilder.buildStopAlarmCmd(), new BooleanRcspActionCallback("stopAlarmBell", onOperationCallback));
    }

    @Override // com.jieli.jl_rcsp.interfaces.alarm.IRTCOp
    public void stopPlayAlarmBell(BluetoothDevice bluetoothDevice, OnOperationCallback<Boolean> onOperationCallback) {
        this.a.sendRcspCommand(bluetoothDevice, CommandBuilder.buildStopAuditionAlarmBellCmd(), new BooleanRcspActionCallback("stopPlayAlarmBell", onOperationCallback));
    }

    @Override // com.jieli.jl_rcsp.interfaces.alarm.IRTCOp
    public void syncTime(BluetoothDevice bluetoothDevice, OnOperationCallback<Boolean> onOperationCallback) {
        this.a.sendRcspCommand(bluetoothDevice, CommandBuilder.buildSyncTimeCmd(Calendar.getInstance()), new BooleanRcspActionCallback("syncTime", onOperationCallback));
    }

    public final boolean b() {
        return this.d.hasMessages(h);
    }

    public final /* synthetic */ boolean a(Message message) {
        if (message.what != 41216) {
            return true;
        }
        JL_Log.w(f, "MSG_WAIT_ALARM_DATA", Constants.STR_EMPTY);
        OnOperationCallback<Boolean> onOperationCallback = this.c;
        if (onOperationCallback == null) {
            return true;
        }
        onOperationCallback.onFailed(new BaseError(12290, "The device replies to the alarm clock data timeout."));
        this.c = null;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(RcspOpImpl rcspOpImpl, RcspEventListenerManager rcspEventListenerManager, byte[] bArr) {
        BluetoothDevice connectedDevice;
        DeviceInfo deviceInfo;
        AlarmBean alarmBean;
        List<AlarmBean> alarmBeans;
        BluetoothDevice bluetoothDevice;
        Iterator<LtvBean> it;
        String str;
        BluetoothDevice bluetoothDevice2;
        byte b;
        byte b2;
        int iBytesToInt;
        int i;
        String str2;
        RcspEventListenerManager rcspEventListenerManager2 = rcspEventListenerManager;
        List<LtvBean> lTVData2 = DataUtil.parseLTVData2(bArr);
        if (lTVData2.isEmpty() || (deviceInfo = rcspOpImpl.getDeviceInfo((connectedDevice = rcspOpImpl.getConnectedDevice()))) == null) {
            return;
        }
        int iA = a(lTVData2);
        Iterator<LtvBean> it2 = lTVData2.iterator();
        while (it2.hasNext()) {
            LtvBean next = it2.next();
            byte[] data = next.getData();
            int type = next.getType();
            int i2 = 5;
            int i3 = 1;
            boolean z = false;
            if (type == 1) {
                int iByteToInt = CHexConver.byteToInt(data[0]);
                ArrayList arrayList = new ArrayList();
                if (iByteToInt <= 0) {
                    bluetoothDevice = connectedDevice;
                    it = it2;
                    break;
                }
                int i4 = 1;
                int i5 = 0;
                while (true) {
                    if (i5 >= iByteToInt || data.length - i4 <= i2) {
                        bluetoothDevice = connectedDevice;
                        it = it2;
                        break;
                    }
                    byte b3 = data[i4];
                    int i6 = i4 + 2;
                    boolean z2 = CHexConver.byteToInt(data[i4 + 1]) == i3 ? i3 : z;
                    byte b4 = data[i6];
                    byte b5 = data[i4 + 3];
                    byte b6 = data[i4 + 4];
                    int i7 = i4 + 6;
                    int iByteToInt2 = CHexConver.byteToInt(data[i4 + 5]);
                    it = it2;
                    if (iByteToInt2 > data.length - i7) {
                        bluetoothDevice = connectedDevice;
                        break;
                    }
                    if (iByteToInt2 > 0) {
                        try {
                            str = new String(data, i7, iByteToInt2);
                            i7 += iByteToInt2;
                        } catch (Exception e) {
                            e.printStackTrace();
                            str = null;
                        }
                    } else {
                        str = null;
                    }
                    if (iA == 0) {
                        iA = deviceInfo.getAlarmVersion();
                    }
                    int length = data.length - i7;
                    int i8 = iByteToInt;
                    if (iA != 1 || length <= 6) {
                        bluetoothDevice2 = connectedDevice;
                        b = 0;
                        b2 = 0;
                        iBytesToInt = 0;
                    } else {
                        byte b7 = data[i7];
                        byte b8 = data[i7 + 1];
                        bluetoothDevice2 = connectedDevice;
                        byte[] bArr2 = new byte[4];
                        System.arraycopy(data, i7 + 2, bArr2, 0, 4);
                        iBytesToInt = CHexConver.bytesToInt(bArr2);
                        int i9 = i7 + 6;
                        i7 += 7;
                        int i10 = data[i9] & 255;
                        if (i10 <= data.length - i7) {
                            try {
                                i = i7 + i10;
                                b2 = b8;
                                str2 = new String(data, i7, i10);
                                b = b7;
                            } catch (Exception e2) {
                                e2.printStackTrace();
                                b = b7;
                                b2 = b8;
                                i = i7;
                                str2 = Constants.STR_EMPTY;
                            }
                            AlarmBean open = new AlarmBean().setVersion(iA).setIndex(b3).setRepeatMode(b4).setName(str).setDevIndex(b2).setHour(b5).setMin(b6).setBellCluster(iBytesToInt).setBellName(str2).setBellType(b).setOpen(z2);
                            JL_Log.d(f, "parseRTCDataVersion0", open.toString());
                            arrayList.add(open);
                            i5++;
                            it2 = it;
                            i4 = i;
                            iByteToInt = i8;
                            connectedDevice = bluetoothDevice2;
                            i2 = 5;
                            i3 = 1;
                            z = false;
                        }
                        b = b7;
                        b2 = b8;
                    }
                    i = i7;
                    str2 = Constants.STR_EMPTY;
                    AlarmBean open2 = new AlarmBean().setVersion(iA).setIndex(b3).setRepeatMode(b4).setName(str).setDevIndex(b2).setHour(b5).setMin(b6).setBellCluster(iBytesToInt).setBellName(str2).setBellType(b).setOpen(z2);
                    JL_Log.d(f, "parseRTCDataVersion0", open2.toString());
                    arrayList.add(open2);
                    i5++;
                    it2 = it;
                    i4 = i;
                    iByteToInt = i8;
                    connectedDevice = bluetoothDevice2;
                    i2 = 5;
                    i3 = 1;
                    z = false;
                }
                AlarmListInfo alarmListInfo = new AlarmListInfo(arrayList);
                alarmListInfo.setVersion(iA);
                deviceInfo.setAlarmListInfo(alarmListInfo);
                rcspEventListenerManager2 = rcspEventListenerManager;
                connectedDevice = bluetoothDevice;
                if (rcspEventListenerManager2 != null) {
                    rcspEventListenerManager2.onAlarmListChange(connectedDevice, alarmListInfo);
                }
                it2 = it;
            } else if (type == 2 || type == 3) {
                int iByteToInt3 = CHexConver.byteToInt(data[0]);
                if (deviceInfo.getAlarmListInfo() != null && (alarmBeans = deviceInfo.getAlarmListInfo().getAlarmBeans()) != null && !alarmBeans.isEmpty()) {
                    Iterator<AlarmBean> it3 = alarmBeans.iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            alarmBean = null;
                            break;
                        }
                        AlarmBean next2 = it3.next();
                        if (iByteToInt3 == next2.getIndex()) {
                            alarmBean = next2.copy();
                            break;
                        }
                    }
                } else {
                    alarmBean = null;
                    break;
                }
                if (alarmBean == null) {
                    alarmBean = new AlarmBean();
                    alarmBean.setIndex((byte) iByteToInt3);
                    alarmBean.setName("Alarm");
                    Calendar calendar = Calendar.getInstance();
                    alarmBean.setHour((byte) calendar.get(11));
                    alarmBean.setMin((byte) calendar.get(12));
                }
                if (next.getType() == 3) {
                    if (rcspEventListenerManager2 != null) {
                        rcspEventListenerManager2.onAlarmStop(connectedDevice, alarmBean);
                    }
                } else if (rcspEventListenerManager2 != null) {
                    rcspEventListenerManager2.onAlarmNotify(connectedDevice, alarmBean);
                }
            } else if (type == 4) {
                deviceInfo.setAlarmVersion(iA);
                if (deviceInfo.getAlarmListInfo() == null) {
                    deviceInfo.setAlarmListInfo(new AlarmListInfo(iA, new ArrayList()));
                } else {
                    deviceInfo.getAlarmListInfo().setVersion(iA);
                }
            } else if (type == 5) {
                int i11 = data[0] & 15;
                ArrayList arrayList2 = new ArrayList();
                while (i3 < data.length && arrayList2.size() < i11) {
                    int i12 = i3 + 1;
                    int i13 = data[i3];
                    int i14 = i3 + 2;
                    int i15 = data[i12];
                    byte[] bArr3 = new byte[i15];
                    System.arraycopy(data, i14, bArr3, 0, i15);
                    i3 = i14 + i15;
                    arrayList2.add(new DefaultAlarmBell(i13, new String(bArr3), false));
                }
                deviceInfo.setAlarmDefaultBells(arrayList2);
                if (rcspEventListenerManager2 != null) {
                    rcspEventListenerManager2.onAlarmDefaultBellListChange(connectedDevice, arrayList2);
                }
            } else if (type == 7) {
                deviceInfo.setAlarmExpandFlag(data[0]);
            }
        }
    }

    public static int a(List<LtvBean> list) {
        for (LtvBean ltvBean : list) {
            if (ltvBean.getType() == 4) {
                return ltvBean.getData()[0] & 7;
            }
        }
        return 0;
    }
}
