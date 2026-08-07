package com.jieli.jl_rcsp.impl;

import android.bluetooth.BluetoothDevice;
import android.os.Handler;
import android.os.Looper;
import com.jieli.jl_rcsp.constant.Command;
import com.jieli.jl_rcsp.constant.RcspConstant;
import com.jieli.jl_rcsp.constant.RcspErrorCode;
import com.jieli.jl_rcsp.interfaces.bluetooth.CmdSnGenerator;
import com.jieli.jl_rcsp.interfaces.bluetooth.IBluetoothProxy;
import com.jieli.jl_rcsp.interfaces.rcsp.IRcspOp;
import com.jieli.jl_rcsp.interfaces.rcsp.OnRcspCallback;
import com.jieli.jl_rcsp.interfaces.rcsp.OnRcspEventListener;
import com.jieli.jl_rcsp.interfaces.rcsp.RcspCommandCallback;
import com.jieli.jl_rcsp.model.DataInfo;
import com.jieli.jl_rcsp.model.Option;
import com.jieli.jl_rcsp.model.base.BaseError;
import com.jieli.jl_rcsp.model.base.BasePacket;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.model.command.SettingsMtuCmd;
import com.jieli.jl_rcsp.model.command.status.GetTargetInfoCmd;
import com.jieli.jl_rcsp.model.command.sys.GetSysInfoCmd;
import com.jieli.jl_rcsp.model.command.sys.UpdateSysInfoCmd;
import com.jieli.jl_rcsp.model.command.watch.HealthSettingCmd;
import com.jieli.jl_rcsp.model.device.DeviceInfo;
import com.jieli.jl_rcsp.model.device.DeviceStatus;
import com.jieli.jl_rcsp.model.parameter.SettingsMtuParam;
import com.jieli.jl_rcsp.model.parameter.UpdateSysInfoParam;
import com.jieli.jl_rcsp.model.response.SettingsMtuResponse;
import com.jieli.jl_rcsp.model.response.SysInfoResponse;
import com.jieli.jl_rcsp.model.response.TargetInfoResponse;
import com.jieli.jl_rcsp.tool.CommandHelper;
import com.jieli.jl_rcsp.tool.DataHandlerCache;
import com.jieli.jl_rcsp.tool.DeviceStatusManager;
import com.jieli.jl_rcsp.tool.HealthDataParseHelper;
import com.jieli.jl_rcsp.tool.RcspDataHandler;
import com.jieli.jl_rcsp.tool.SnGenerator;
import com.jieli.jl_rcsp.tool.callback.RcspCallbackManager;
import com.jieli.jl_rcsp.tool.callback.RcspEventListenerManager;
import com.jieli.jl_rcsp.tool.datahandles.DataHandler;
import com.jieli.jl_rcsp.tool.datahandles.DataHandlerModify;
import com.jieli.jl_rcsp.tool.datahandles.DataHandlerOld;
import com.jieli.jl_rcsp.tool.datahandles.ParseHelper;
import com.jieli.jl_rcsp.util.CHexConver;
import com.jieli.jl_rcsp.util.CommandBuilder;
import com.jieli.jl_rcsp.util.JL_Log;
import com.jieli.jl_rcsp.util.RcspUtil;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class RcspOpImpl implements IBluetoothProxy, IRcspOp {
    private static final String TAG = "jl_rcsp";
    public static boolean sUseNewDataHandler = true;
    protected CmdSnGenerator mCmdSnGenerator;
    protected final Handler mHandler;
    private final HealthDataParseHelper mHealthDataParseHelper;
    protected final Option mOption;
    protected final RcspCallbackManager mRcspCallbackManager;
    protected final RcspDataHandler mRcspDataHandler;
    protected final RcspEventListenerManager mRcspEventListenerManager;
    protected final DeviceStatusManager mStatusManager;
    private BluetoothDevice mTargetDevice;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.jieli.jl_rcsp.impl.RcspOpImpl$1, reason: invalid class name */
    public class AnonymousClass1<T> implements RcspCommandCallback<T> {
        public int a = 0;
        public final /* synthetic */ int b;
        public final /* synthetic */ RcspCommandCallback c;

        public AnonymousClass1(int i, RcspCommandCallback rcspCommandCallback) {
            this.b = i;
            this.c = rcspCommandCallback;
        }

        public final /* synthetic */ void a(BluetoothDevice bluetoothDevice, CommandBase commandBase, int i, RcspCommandCallback rcspCommandCallback) {
            RcspOpImpl.this.sendCommandAsync(bluetoothDevice, commandBase, i, rcspCommandCallback);
        }

        /* JADX WARN: Incorrect types in method signature: (Landroid/bluetooth/BluetoothDevice;TT;)V */
        @Override // com.jieli.jl_rcsp.interfaces.rcsp.RcspCommandCallback
        public void onCommandResponse(final BluetoothDevice bluetoothDevice, final CommandBase commandBase) {
            if (3 == commandBase.getStatus()) {
                int i = this.a + 1;
                this.a = i;
                if (i < 3) {
                    Handler handler = RcspOpImpl.this.mHandler;
                    final int i2 = this.b;
                    handler.postDelayed(new Runnable() { // from class: com.jieli.jl_rcsp.impl.g
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.a.a(bluetoothDevice, commandBase, i2, this);
                        }
                    }, 500L);
                    return;
                }
            }
            this.a = 0;
            RcspCommandCallback rcspCommandCallback = this.c;
            if (rcspCommandCallback != null) {
                rcspCommandCallback.onCommandResponse(bluetoothDevice, commandBase);
            }
        }

        @Override // com.jieli.jl_rcsp.interfaces.rcsp.RcspCommandCallback
        public void onErrCode(BluetoothDevice bluetoothDevice, BaseError baseError) {
            this.a = 0;
            RcspCommandCallback rcspCommandCallback = this.c;
            if (rcspCommandCallback != null) {
                rcspCommandCallback.onErrCode(bluetoothDevice, baseError);
            }
        }
    }

    public RcspOpImpl() {
        this(Option.createOption());
    }

    private void addDataHandlerInCache(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null || DataHandlerCache.getInstance().getDataHandler(bluetoothDevice) != null) {
            return;
        }
        DataHandlerCache.getInstance().addDataHandler(bluetoothDevice, sUseNewDataHandler ? new DataHandlerModify(this) : new DataHandlerOld(this));
    }

    private int getCmdSn(BluetoothDevice bluetoothDevice) {
        if (this.mCmdSnGenerator == null) {
            this.mCmdSnGenerator = new SnGenerator();
        }
        return this.mCmdSnGenerator.getRcspCmdSeq(bluetoothDevice);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleDeviceConnectedEvent(BluetoothDevice bluetoothDevice) {
        DeviceStatus deviceStatus = this.mStatusManager.getDeviceStatus(bluetoothDevice);
        DeviceInfo deviceInfo = deviceStatus == null ? null : deviceStatus.getDeviceInfo();
        if (deviceInfo == null) {
            syncDeviceInfo(bluetoothDevice);
        } else if (!deviceInfo.isMandatoryUpgrade()) {
            this.mRcspCallbackManager.onRcspInit(bluetoothDevice, true);
        } else {
            this.mStatusManager.updateDeviceMaxCommunicationMtu(bluetoothDevice, 530);
            this.mRcspCallbackManager.onMandatoryUpgrade(bluetoothDevice);
        }
    }

    private void handleDeviceConnection(BluetoothDevice bluetoothDevice, int i) {
        this.mRcspCallbackManager.onConnectStateChange(bluetoothDevice, i);
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 4) {
                        return;
                    }
                }
            }
            if (this.mTargetDevice == null) {
                setTargetDevice(bluetoothDevice);
            } else {
                addDataHandlerInCache(bluetoothDevice);
            }
            handleDeviceConnectedEvent(bluetoothDevice);
            return;
        }
        this.mStatusManager.removeDeviceStatus(bluetoothDevice);
        DataHandlerCache.getInstance().removeDataHandler(bluetoothDevice);
        if (RcspUtil.deviceEquals(this.mTargetDevice, bluetoothDevice)) {
            List<BluetoothDevice> deviceList = DataHandlerCache.getInstance().getDeviceList();
            if (deviceList.isEmpty()) {
                setTargetDevice(null);
            } else {
                setTargetDevice(deviceList.get(deviceList.size() - 1));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void handleRcspCommand(BluetoothDevice bluetoothDevice, CommandBase commandBase, int i) {
        int id = commandBase.getId();
        if (!Command.isValidCmd(id)) {
            if (i == 1) {
                CommandBase commandBase2 = new CommandBase(id, "unknownCommand");
                commandBase2.setOpCodeSn(commandBase.getOpCodeSn());
                commandBase2.setStatus(2);
                sendCommandResponse(bluetoothDevice, commandBase2, null);
                return;
            }
            return;
        }
        if (id == 9) {
            UpdateSysInfoParam updateSysInfoParam = (UpdateSysInfoParam) ((UpdateSysInfoCmd) commandBase).getParam();
            this.mRcspDataHandler.parseAttrMessage(bluetoothDevice, updateSysInfoParam.getFunction(), updateSysInfoParam.getAttrBeanList());
        } else if (id == 165) {
            HealthSettingCmd.Param param = ((HealthSettingCmd) commandBase).getParam();
            if (param instanceof HealthSettingCmd.UpdateParam) {
                this.mRcspDataHandler.parseHealthSetting(bluetoothDevice, ((HealthSettingCmd.UpdateParam) param).getList());
            }
        } else if (id == 209) {
            SettingsMtuCmd settingsMtuCmd = (SettingsMtuCmd) commandBase;
            SettingsMtuParam settingsMtuParam = (SettingsMtuParam) settingsMtuCmd.getParam();
            if (settingsMtuParam != null) {
                int mtu = settingsMtuParam.getMtu();
                this.mStatusManager.updateDeviceMaxCommunicationMtu(bluetoothDevice, mtu);
                settingsMtuCmd.setResponse(new SettingsMtuResponse(mtu));
            }
            settingsMtuCmd.setStatus(0);
            sendCommandResponse(bluetoothDevice, settingsMtuCmd, null);
        }
        this.mRcspCallbackManager.onRcspCommand(bluetoothDevice, commandBase);
    }

    private void handleReceiveDevRcspCmd(BluetoothDevice bluetoothDevice, BasePacket basePacket) {
        int opCode = basePacket.getOpCode();
        boolean z = basePacket.getType() == 1;
        CommandBase commandBaseConvert2Command = ParseHelper.convert2Command(bluetoothDevice, basePacket);
        if (commandBaseConvert2Command == null) {
            BaseError baseError = new BaseError(12289);
            baseError.setOpCode(basePacket.getOpCode());
            notifyRcspError(bluetoothDevice, baseError);
        } else {
            if (1 == opCode) {
                this.mRcspCallbackManager.onRcspDataCmd(bluetoothDevice, commandBaseConvert2Command);
                return;
            }
            if (z) {
                handleRcspCommand(bluetoothDevice, commandBaseConvert2Command, basePacket.getHasResponse());
            } else {
                handleRcspResponse(bluetoothDevice, commandBaseConvert2Command);
            }
            this.mHealthDataParseHelper.receiveCmdFromDevice(bluetoothDevice, commandBaseConvert2Command);
        }
    }

    private <T extends CommandBase> void notifyErrorEvent(final BluetoothDevice bluetoothDevice, final RcspCommandCallback<T> rcspCommandCallback, final BaseError baseError) {
        if (baseError == null) {
            return;
        }
        if (rcspCommandCallback == null) {
            notifyRcspError(bluetoothDevice, baseError);
        } else {
            JL_Log.e("jl_rcsp", "notifyErrorEvent", RcspUtil.formatString("device : %s ---> %s", RcspUtil.printBtDeviceInfo(bluetoothDevice), baseError));
            this.mHandler.post(new Runnable() { // from class: mc2
                @Override // java.lang.Runnable
                public final void run() {
                    rcspCommandCallback.onErrCode(bluetoothDevice, baseError);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyRcspError(BluetoothDevice bluetoothDevice, BaseError baseError) {
        JL_Log.e("jl_rcsp", "notifyRcspError", RcspUtil.formatString("device : %s ---> %s", RcspUtil.printBtDeviceInfo(bluetoothDevice), baseError));
        this.mRcspCallbackManager.onRcspError(bluetoothDevice, baseError);
    }

    private void setTargetDevice(BluetoothDevice bluetoothDevice) {
        if (!RcspUtil.deviceEquals(this.mTargetDevice, bluetoothDevice)) {
            boolean z = this.mTargetDevice != null;
            this.mTargetDevice = bluetoothDevice;
            if (z && bluetoothDevice != null) {
                this.mRcspCallbackManager.onSwitchConnectedDevice(bluetoothDevice);
            }
        }
        addDataHandlerInCache(bluetoothDevice);
    }

    private void syncDeviceInfo(BluetoothDevice bluetoothDevice) {
        JL_Log.d("jl_rcsp", "syncDeviceInfo", "device : " + RcspUtil.printBtDeviceInfo(bluetoothDevice));
        sendRcspCommand(bluetoothDevice, CommandBuilder.buildGetDeviceInfoCmdForAll(), new RcspCommandCallback<GetTargetInfoCmd>() { // from class: com.jieli.jl_rcsp.impl.RcspOpImpl.2
            @Override // com.jieli.jl_rcsp.interfaces.rcsp.RcspCommandCallback
            public void onErrCode(BluetoothDevice bluetoothDevice2, BaseError baseError) {
                JL_Log.w("jl_rcsp", "syncDeviceInfo", "onErrCode >>> device : " + bluetoothDevice2 + ",\n" + baseError);
                RcspOpImpl.this.notifyRcspError(bluetoothDevice2, baseError);
                RcspOpImpl.this.mRcspCallbackManager.onRcspInit(bluetoothDevice2, false);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.jieli.jl_rcsp.interfaces.rcsp.RcspCommandCallback
            public void onCommandResponse(BluetoothDevice bluetoothDevice2, GetTargetInfoCmd getTargetInfoCmd) {
                if (getTargetInfoCmd.getStatus() == 0) {
                    TargetInfoResponse targetInfoResponse = (TargetInfoResponse) getTargetInfoCmd.getResponse();
                    JL_Log.i("jl_rcsp", "syncDeviceInfo", "success >>> device : " + bluetoothDevice2 + ",\n" + targetInfoResponse);
                    if (targetInfoResponse != null) {
                        if (RcspOpImpl.this.mStatusManager.getDeviceInfo(bluetoothDevice2) == null) {
                            RcspOpImpl.this.mStatusManager.updateDeviceTargetInfo(bluetoothDevice2, targetInfoResponse);
                        }
                        RcspOpImpl.this.handleDeviceConnectedEvent(bluetoothDevice2);
                        return;
                    }
                    RcspOpImpl.this.notifyRcspError(bluetoothDevice2, new BaseError(12289).setOpCode(getTargetInfoCmd.getId()));
                } else {
                    RcspOpImpl.this.notifyRcspError(bluetoothDevice2, RcspErrorCode.buildJsonError(getTargetInfoCmd.getId(), 12292, getTargetInfoCmd.getStatus(), null));
                }
                RcspOpImpl.this.mRcspCallbackManager.onRcspInit(bluetoothDevice2, false);
            }
        });
    }

    @Override // com.jieli.jl_rcsp.interfaces.bluetooth.IBluetoothProxy
    public void callbackErrorEvent(BaseError baseError) {
        this.mRcspCallbackManager.onRcspError(getTargetDevice(), baseError);
    }

    public DeviceInfo getDeviceInfo() {
        return getDeviceInfo(this.mTargetDevice);
    }

    public BluetoothDevice getTargetDevice() {
        return this.mTargetDevice;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void handleRcspResponse(BluetoothDevice bluetoothDevice, CommandBase commandBase) {
        SettingsMtuResponse settingsMtuResponse;
        if (commandBase.getStatus() != 0) {
            return;
        }
        int id = commandBase.getId();
        if (id == 3) {
            TargetInfoResponse targetInfoResponse = (TargetInfoResponse) ((GetTargetInfoCmd) commandBase).getResponse();
            if (targetInfoResponse != null) {
                this.mStatusManager.updateDeviceTargetInfo(bluetoothDevice, targetInfoResponse);
                return;
            }
            return;
        }
        if (id == 7) {
            SysInfoResponse sysInfoResponse = (SysInfoResponse) ((GetSysInfoCmd) commandBase).getResponse();
            this.mRcspDataHandler.parseAttrMessage(bluetoothDevice, sysInfoResponse.getFunction(), sysInfoResponse.getAttrs());
        } else {
            if (id != 165) {
                if (id == 209 && (settingsMtuResponse = (SettingsMtuResponse) ((SettingsMtuCmd) commandBase).getResponse()) != null) {
                    this.mStatusManager.updateDeviceMaxCommunicationMtu(bluetoothDevice, settingsMtuResponse.getRealMtu());
                    return;
                }
                return;
            }
            HealthSettingCmd.Response response = ((HealthSettingCmd) commandBase).getResponse();
            if (response instanceof HealthSettingCmd.GetResponse) {
                this.mRcspDataHandler.parseHealthSetting(bluetoothDevice, ((HealthSettingCmd.GetResponse) response).getList());
            }
        }
    }

    public boolean isRcspInit() {
        return (getConnectedDevice() == null || getDeviceInfo() == null) ? false : true;
    }

    @Override // com.jieli.jl_rcsp.interfaces.bluetooth.IBluetoothProxy
    public void notifyBtDeviceConnection(BluetoothDevice bluetoothDevice, int i) {
        JL_Log.d("jl_rcsp", "notifyBtDeviceConnection", RcspUtil.formatString("device = %s, status = %d", RcspUtil.printBtDeviceInfo(bluetoothDevice), Integer.valueOf(i)));
        handleDeviceConnection(bluetoothDevice, i);
    }

    @Override // com.jieli.jl_rcsp.interfaces.bluetooth.IBluetoothProxy
    public void notifyReceiveDeviceData(BluetoothDevice bluetoothDevice, byte[] bArr) {
        JL_Log.d("jl_rcsp", "notifyReceiveDeviceData", RcspUtil.formatString("device = %s, data = [%s]", RcspUtil.printBtDeviceInfo(bluetoothDevice), CHexConver.byte2HexStr(bArr)));
        if (bluetoothDevice == null || bArr == null) {
            notifyRcspError(bluetoothDevice, new BaseError(4097));
            return;
        }
        if (!this.mOption.isMultiDevice() && !RcspUtil.deviceEquals(bluetoothDevice, getTargetDevice())) {
            notifyRcspError(bluetoothDevice, new BaseError(8193));
            return;
        }
        DataHandler dataHandler = DataHandlerCache.getInstance().getDataHandler(bluetoothDevice);
        if (dataHandler != null) {
            dataHandler.addRecvData(new DataInfo().setDevice(bluetoothDevice).setType(1).setRecvData(bArr));
        } else {
            JL_Log.w("jl_rcsp", "notifyReceiveDeviceData", "No Data Handler.");
            notifyRcspError(bluetoothDevice, new BaseError(8192));
        }
    }

    @Override // com.jieli.jl_rcsp.interfaces.bluetooth.IBluetoothProxy
    public void receiveDataFromDevice(BluetoothDevice bluetoothDevice, BasePacket basePacket) {
        if (bluetoothDevice == null || basePacket == null) {
            notifyRcspError(bluetoothDevice, new BaseError(4097));
            return;
        }
        JL_Log.v("jl_rcsp", "receiveDataFromDevice", RcspUtil.formatString("device = %s, %s", RcspUtil.printBtDeviceInfo(bluetoothDevice), basePacket));
        if (this.mOption.isMultiDevice() || RcspUtil.deviceEquals(bluetoothDevice, getTargetDevice()) || (basePacket.getType() == 1 && basePacket.getOpCode() == 194)) {
            handleReceiveDevRcspCmd(bluetoothDevice, basePacket);
        }
    }

    @Override // com.jieli.jl_rcsp.interfaces.rcsp.IRcspOp
    public void registerOnRcspCallback(OnRcspCallback onRcspCallback) {
        DeviceInfo deviceInfo;
        this.mRcspCallbackManager.registerCallback(onRcspCallback);
        BluetoothDevice targetDevice = getTargetDevice();
        if (targetDevice == null || (deviceInfo = this.mStatusManager.getDeviceInfo(targetDevice)) == null || !deviceInfo.isMandatoryUpgrade()) {
            return;
        }
        onRcspCallback.onMandatoryUpgrade(targetDevice);
    }

    @Override // com.jieli.jl_rcsp.interfaces.rcsp.IRcspOp
    public void registerOnRcspEventListener(OnRcspEventListener onRcspEventListener) {
        this.mRcspEventListenerManager.registerCallback(onRcspEventListener);
    }

    @Override // com.jieli.jl_rcsp.interfaces.rcsp.IRcspOp
    public void release() {
        JL_Log.i("jl_rcsp", "release", "clazz : " + this);
        setTargetDevice(null);
        CmdSnGenerator cmdSnGenerator = this.mCmdSnGenerator;
        if (cmdSnGenerator != null) {
            if (cmdSnGenerator instanceof SnGenerator) {
                ((SnGenerator) cmdSnGenerator).destroy();
            }
            this.mCmdSnGenerator = null;
        }
        this.mRcspCallbackManager.release();
        this.mRcspEventListenerManager.release();
        this.mStatusManager.release();
        DataHandlerCache.getInstance().destroy();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // com.jieli.jl_rcsp.interfaces.rcsp.IRcspOp
    public <T extends CommandBase> void sendCommandAsync(BluetoothDevice bluetoothDevice, CommandBase commandBase, int i, RcspCommandCallback<T> rcspCommandCallback) {
        if (bluetoothDevice == null || commandBase == null) {
            notifyErrorEvent(bluetoothDevice, rcspCommandCallback, new BaseError(4097));
            return;
        }
        DataHandler dataHandler = DataHandlerCache.getInstance().getDataHandler(bluetoothDevice);
        if (!isDeviceConnected(bluetoothDevice) || dataHandler == null) {
            BaseError baseError = new BaseError(8192);
            baseError.setOpCode(commandBase.getId());
            notifyErrorEvent(bluetoothDevice, rcspCommandCallback, baseError);
            return;
        }
        commandBase.setOpCodeSn(getCmdSn(bluetoothDevice));
        BasePacket basePacketConvert2BasePacket = ParseHelper.convert2BasePacket(commandBase, 1);
        if (basePacketConvert2BasePacket == null) {
            BaseError baseError2 = new BaseError(12289);
            baseError2.setOpCode(commandBase.getId());
            notifyErrorEvent(bluetoothDevice, rcspCommandCallback, baseError2);
        } else {
            CommandHelper.getInstance().putCommandBase(bluetoothDevice, commandBase);
            DataInfo rcspCmdCallback = new DataInfo().setDevice(bluetoothDevice).setType(0).setBasePacket(basePacketConvert2BasePacket).setTimeoutMs(i).setRcspCmdCallback(rcspCommandCallback);
            this.mRcspCallbackManager.onPutDataToDataHandler(bluetoothDevice, ParseHelper.packSendBasePacket(basePacketConvert2BasePacket));
            dataHandler.addSendData(rcspCmdCallback);
        }
    }

    @Override // com.jieli.jl_rcsp.interfaces.rcsp.IRcspOp
    public <T extends CommandBase> void sendCommandResponse(BluetoothDevice bluetoothDevice, CommandBase commandBase, RcspCommandCallback<T> rcspCommandCallback) {
        if (commandBase == null) {
            notifyErrorEvent(bluetoothDevice, rcspCommandCallback, new BaseError(4097));
            return;
        }
        if (!isDeviceConnected(bluetoothDevice) || DataHandlerCache.getInstance().getDataHandler(bluetoothDevice) == null) {
            BaseError baseError = new BaseError(8192);
            baseError.setOpCode(commandBase.getId());
            notifyErrorEvent(bluetoothDevice, rcspCommandCallback, baseError);
            return;
        }
        BasePacket basePacketConvert2BasePacket = ParseHelper.convert2BasePacket(commandBase, 0);
        if (basePacketConvert2BasePacket != null) {
            DataHandlerCache.getInstance().getDataHandler(bluetoothDevice).addSendData(new DataInfo().setDevice(bluetoothDevice).setType(0).setBasePacket(basePacketConvert2BasePacket).setRcspCmdCallback(rcspCommandCallback));
        } else {
            BaseError baseError2 = new BaseError(12289);
            baseError2.setOpCode(commandBase.getId());
            notifyErrorEvent(bluetoothDevice, rcspCommandCallback, baseError2);
        }
    }

    public <T extends CommandBase> void sendRcspCommand(BluetoothDevice bluetoothDevice, CommandBase commandBase, RcspCommandCallback<T> rcspCommandCallback) {
        sendRcspCommand(bluetoothDevice, commandBase, this.mOption.getCmdTimeout(), rcspCommandCallback);
    }

    @Override // com.jieli.jl_rcsp.interfaces.bluetooth.IBluetoothProxy
    public void setCmdSnGenerator(CmdSnGenerator cmdSnGenerator) {
        this.mCmdSnGenerator = cmdSnGenerator;
    }

    @Override // com.jieli.jl_rcsp.interfaces.rcsp.IRcspOp
    public void switchConnectedDevice(BluetoothDevice bluetoothDevice) {
        List<BluetoothDevice> deviceList = DataHandlerCache.getInstance().getDeviceList();
        if (bluetoothDevice == null || !deviceList.contains(bluetoothDevice) || RcspUtil.deviceEquals(this.mTargetDevice, bluetoothDevice)) {
            return;
        }
        setTargetDevice(bluetoothDevice);
    }

    @Override // com.jieli.jl_rcsp.interfaces.rcsp.IRcspOp
    public void unregisterOnRcspCallback(OnRcspCallback onRcspCallback) {
        this.mRcspCallbackManager.unregisterCallback(onRcspCallback);
    }

    @Override // com.jieli.jl_rcsp.interfaces.rcsp.IRcspOp
    public void unregisterOnRcspEventListener(OnRcspEventListener onRcspEventListener) {
        this.mRcspEventListenerManager.unregisterCallback(onRcspEventListener);
    }

    public RcspOpImpl(Option option) {
        this.mHandler = new Handler(Looper.getMainLooper());
        if (option == null) {
            throw new NullPointerException("Option can not be null.");
        }
        this.mOption = option;
        JL_Log.d("jl_rcsp", "init", RcspUtil.formatString("Lib Name : %s(%d), Option : %s. \nclazz: %s", RcspConstant.getLibVersionName(), Integer.valueOf(RcspConstant.getLibVersionCode()), option, this));
        this.mStatusManager = DeviceStatusManager.getInstance();
        this.mRcspCallbackManager = new RcspCallbackManager();
        RcspEventListenerManager rcspEventListenerManager = new RcspEventListenerManager();
        this.mRcspEventListenerManager = rcspEventListenerManager;
        this.mRcspDataHandler = new RcspDataHandler(this, rcspEventListenerManager);
        this.mHealthDataParseHelper = new HealthDataParseHelper(this, rcspEventListenerManager);
    }

    public DeviceInfo getDeviceInfo(BluetoothDevice bluetoothDevice) {
        return this.mStatusManager.getDeviceInfo(bluetoothDevice);
    }

    public <T extends CommandBase> void sendRcspCommand(BluetoothDevice bluetoothDevice, CommandBase commandBase, int i, RcspCommandCallback<T> rcspCommandCallback) {
        sendCommandAsync(bluetoothDevice, commandBase, i, new AnonymousClass1(i, rcspCommandCallback));
    }
}
