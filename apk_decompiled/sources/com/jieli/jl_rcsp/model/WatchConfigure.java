package com.jieli.jl_rcsp.model;

import com.jieli.jl_rcsp.model.device.DeviceConfiguration;
import com.jieli.jl_rcsp.model.device.settings.v0.DialExpandInfo;
import com.jieli.jl_rcsp.util.CHexConver;

/* JADX INFO: loaded from: classes3.dex */
public class WatchConfigure extends DeviceConfiguration {
    private DialExpandInfo dialExpandInfo;
    private FunctionOption functionOption;
    private NecessaryFunc necessaryFunc;
    private SportHealthConfigure sportHealthConfigure;
    private SystemSetup systemSetup;

    public static class DataBlock {
        public byte[] data;
        public int offset;

        private DataBlock() {
        }
    }

    public static class FunctionOption {
        private final byte[] data;
        private boolean isSupportAICloud;
        private boolean isSupportAIDial;
        private boolean isSupportAlarmSetting;
        private boolean isSupportContacts;
        private boolean isSupportDialExpandInfo;
        private boolean isSupportFileBrowse;
        private boolean isSupportMessageSync;
        private boolean isSupportMusicTransfer;
        private boolean isSupportNetworkModule;
        private boolean isSupportPlatformInfo;
        private boolean isSupportSearchDevice;
        private boolean isSupportWeatherSync;
        private final int version;

        public FunctionOption(int i, byte[] bArr) throws RuntimeException {
            this.version = i;
            this.data = bArr;
            parseData(i, bArr);
        }

        private void parseData(int i, byte[] bArr) throws RuntimeException {
            if (i != 0) {
                throw new RuntimeException("Unsupported version :  " + i);
            }
            if (bArr == null || bArr.length < 1) {
                throw new RuntimeException(getClass().getSimpleName() + " : Data exception : " + CHexConver.byte2HexStr(bArr));
            }
            byte b = bArr[0];
            this.isSupportContacts = CHexConver.checkBitValue(b, 0);
            this.isSupportFileBrowse = CHexConver.checkBitValue(b, 1);
            this.isSupportMusicTransfer = CHexConver.checkBitValue(b, 2);
            this.isSupportAlarmSetting = CHexConver.checkBitValue(b, 3);
            this.isSupportMessageSync = CHexConver.checkBitValue(b, 4);
            this.isSupportWeatherSync = CHexConver.checkBitValue(b, 5);
            this.isSupportSearchDevice = CHexConver.checkBitValue(b, 6);
            this.isSupportAICloud = CHexConver.checkBitValue(b, 7);
            if (bArr.length <= 1) {
                return;
            }
            byte b2 = bArr[1];
            this.isSupportAIDial = CHexConver.checkBitValue(b2, 0);
            this.isSupportPlatformInfo = CHexConver.checkBitValue(b2, 1);
            this.isSupportNetworkModule = CHexConver.checkBitValue(b2, 2);
            this.isSupportDialExpandInfo = CHexConver.checkBitValue(b2, 3);
        }

        public byte[] getData() {
            return this.data;
        }

        public int getVersion() {
            return this.version;
        }

        public boolean isSupportAICloud() {
            return this.isSupportAICloud;
        }

        public boolean isSupportAIDial() {
            return this.isSupportAIDial;
        }

        public boolean isSupportAlarmSetting() {
            return this.isSupportAlarmSetting;
        }

        public boolean isSupportContacts() {
            return this.isSupportContacts;
        }

        public boolean isSupportDialExpandInfo() {
            return this.isSupportDialExpandInfo;
        }

        public boolean isSupportFileBrowse() {
            return this.isSupportFileBrowse;
        }

        public boolean isSupportMessageSync() {
            return this.isSupportMessageSync;
        }

        public boolean isSupportMusicTransfer() {
            return this.isSupportMusicTransfer;
        }

        public boolean isSupportNetworkModule() {
            return this.isSupportNetworkModule;
        }

        public boolean isSupportPlatformInfo() {
            return this.isSupportPlatformInfo;
        }

        public boolean isSupportSearchDevice() {
            return this.isSupportSearchDevice;
        }

        public boolean isSupportWeatherSync() {
            return this.isSupportWeatherSync;
        }

        public String toString() {
            return "FunctionOption{isSupportContacts=" + this.isSupportContacts + ", isSupportFileBrowse=" + this.isSupportFileBrowse + ", isSupportMusicTransfer=" + this.isSupportMusicTransfer + ", isSupportAlarmSetting=" + this.isSupportAlarmSetting + ", isSupportMessageSync=" + this.isSupportMessageSync + ", isSupportWeatherSync=" + this.isSupportWeatherSync + ", isSupportSearchDevice=" + this.isSupportSearchDevice + ", isSupportAICloud=" + this.isSupportAICloud + ", isSupportAIDial=" + this.isSupportAIDial + ", isSupportPlatformInfo=" + this.isSupportPlatformInfo + ", isSupportNetworkModule=" + this.isSupportNetworkModule + ", isSupportDialExpandInfo=" + this.isSupportDialExpandInfo + '}';
        }
    }

    public static class NecessaryFunc {
        private final byte[] data;
        private boolean isSupportDialBrowse;
        private boolean isSupportDialOp;
        private boolean isSupportDialSwitch;
        private boolean isSupportOTA;
        private boolean isSupportResourceUpdate;
        private final int version;

        public NecessaryFunc(int i, byte[] bArr) throws RuntimeException {
            this.version = i;
            this.data = bArr;
            parseData(i, bArr);
        }

        private void parseData(int i, byte[] bArr) throws RuntimeException {
            if (i != 0) {
                throw new RuntimeException("Unsupported version :  " + i);
            }
            if (bArr != null) {
                if (bArr.length >= 1) {
                    byte b = bArr[0];
                    this.isSupportOTA = (b & 1) == 1;
                    this.isSupportResourceUpdate = ((b >> 1) & 1) == 1;
                    this.isSupportDialOp = ((b >> 2) & 1) == 1;
                    this.isSupportDialSwitch = ((b >> 3) & 1) == 1;
                    this.isSupportDialBrowse = ((b >> 4) & 1) == 1;
                    return;
                }
            }
            throw new RuntimeException(getClass().getSimpleName() + " : Data exception : " + CHexConver.byte2HexStr(bArr));
        }

        public byte[] getData() {
            return this.data;
        }

        public int getVersion() {
            return this.version;
        }

        public boolean isSupportDialBrowse() {
            return this.isSupportDialBrowse;
        }

        public boolean isSupportDialOp() {
            return this.isSupportDialOp;
        }

        public boolean isSupportDialSwitch() {
            return this.isSupportDialSwitch;
        }

        public boolean isSupportOTA() {
            return this.isSupportOTA;
        }

        public boolean isSupportResourceUpdate() {
            return this.isSupportResourceUpdate;
        }

        public String toString() {
            return "NecessaryFunc{isSupportOTA=" + this.isSupportOTA + ", isSupportResourceUpdate=" + this.isSupportResourceUpdate + ", isSupportDialOp=" + this.isSupportDialOp + ", isSupportDialSwitch=" + this.isSupportDialSwitch + ", isSupportDialBrowse=" + this.isSupportDialBrowse + '}';
        }
    }

    public static class SystemSetup {
        private final byte[] data;
        private boolean isSupportBtDisconnectSetting;
        private boolean isSupportDNDMode;
        private boolean isSupportExerciseSetting;
        private boolean isSupportScreenSetting;
        private boolean isSupportVibrationSetting;
        private final int version;

        public SystemSetup(int i, byte[] bArr) throws RuntimeException {
            this.version = i;
            this.data = bArr;
            parseData(i, bArr);
        }

        private void parseData(int i, byte[] bArr) throws RuntimeException {
            if (i != 0) {
                throw new RuntimeException("Unsupported version :  " + i);
            }
            if (bArr != null) {
                if (bArr.length >= 1) {
                    byte b = bArr[0];
                    this.isSupportScreenSetting = (b & 1) == 1;
                    this.isSupportVibrationSetting = ((b >> 1) & 1) == 1;
                    this.isSupportDNDMode = ((b >> 2) & 1) == 1;
                    this.isSupportExerciseSetting = ((b >> 3) & 1) == 1;
                    this.isSupportBtDisconnectSetting = ((b >> 4) & 1) == 1;
                    return;
                }
            }
            throw new RuntimeException(getClass().getSimpleName() + " : Data exception : " + CHexConver.byte2HexStr(bArr));
        }

        public byte[] getData() {
            return this.data;
        }

        public int getVersion() {
            return this.version;
        }

        public boolean isSupportBtDisconnectSetting() {
            return this.isSupportBtDisconnectSetting;
        }

        public boolean isSupportDNDMode() {
            return this.isSupportDNDMode;
        }

        public boolean isSupportExerciseSetting() {
            return this.isSupportExerciseSetting;
        }

        public boolean isSupportScreenSetting() {
            return this.isSupportScreenSetting;
        }

        public boolean isSupportVibrationSetting() {
            return this.isSupportVibrationSetting;
        }

        public String toString() {
            return "SystemSetup{isSupportScreenSetting=" + this.isSupportScreenSetting + ", isSupportVibrationSetting=" + this.isSupportVibrationSetting + ", isSupportDNDMode=" + this.isSupportDNDMode + ", isSupportExerciseSetting=" + this.isSupportExerciseSetting + ", isSupportBtDisconnectSetting=" + this.isSupportBtDisconnectSetting + '}';
        }
    }

    public WatchConfigure(int i, byte[] bArr) throws RuntimeException {
        super(0, i, bArr);
        parsePayload(bArr);
    }

    private void getDataBlock(byte[] bArr, DataBlock dataBlock) {
        if (bArr == null || dataBlock == null) {
            return;
        }
        int i = dataBlock.offset;
        byte[] bArr2 = new byte[2];
        int i2 = 0;
        while (true) {
            int i3 = i + 2;
            if (i3 > bArr.length) {
                i2 = 0;
                break;
            }
            System.arraycopy(bArr, i, bArr2, 0, 2);
            byte[] booleanArrayBig = CHexConver.getBooleanArrayBig(bArr2[1]);
            i2 += 2;
            if (CHexConver.byteToInt(booleanArrayBig[booleanArrayBig.length - 1]) == 0) {
                break;
            } else {
                i = i3;
            }
        }
        if (i2 <= 0) {
            dataBlock.data = new byte[0];
            return;
        }
        byte[] bArr3 = new byte[i2];
        System.arraycopy(bArr, dataBlock.offset, bArr3, 0, i2);
        dataBlock.data = bArr3;
    }

    private int parseData(int i, byte[] bArr) throws RuntimeException {
        if (i != 0) {
            throw new RuntimeException("Unsupported version :  " + i);
        }
        if (bArr == null || bArr.length < 8) {
            throw new RuntimeException("Data exception : " + CHexConver.byte2HexStr(bArr));
        }
        DataBlock dataBlock = new DataBlock();
        int length = 0;
        for (int i2 = 0; i2 < 3; i2++) {
            dataBlock.offset = length;
            getDataBlock(bArr, dataBlock);
            byte[] bArr2 = dataBlock.data;
            if (bArr2.length == 0) {
                throw new RuntimeException("Data exception : not found block");
            }
            if (i2 == 0) {
                this.necessaryFunc = new NecessaryFunc(i, bArr2);
            } else if (i2 == 1) {
                this.systemSetup = new SystemSetup(i, bArr2);
            } else if (i2 == 2) {
                this.functionOption = new FunctionOption(i, bArr2);
            }
            length = dataBlock.offset + dataBlock.data.length;
            dataBlock.offset = length;
        }
        if (length + 2 >= bArr.length) {
            return length;
        }
        int length2 = bArr.length - length;
        byte[] bArr3 = new byte[length2];
        System.arraycopy(bArr, length, bArr3, 0, length2);
        int i3 = length + length2;
        this.sportHealthConfigure = new SportHealthConfigure(i, bArr3);
        return i3;
    }

    public DialExpandInfo getDialExpandInfo() {
        return this.dialExpandInfo;
    }

    public FunctionOption getFunctionOption() {
        return this.functionOption;
    }

    public NecessaryFunc getNecessaryFunc() {
        return this.necessaryFunc;
    }

    public SportHealthConfigure getSportHealthConfigure() {
        return this.sportHealthConfigure;
    }

    public SystemSetup getSystemSetup() {
        return this.systemSetup;
    }

    @Override // com.jieli.jl_rcsp.model.device.DeviceConfiguration
    public int parsePayload(byte[] bArr) throws RuntimeException {
        return parseData(getVersion(), bArr);
    }

    public WatchConfigure setDialExpandInfo(DialExpandInfo dialExpandInfo) {
        this.dialExpandInfo = dialExpandInfo;
        return this;
    }

    public String toString() {
        return "WatchConfigure{version=" + getVersion() + ", data=" + CHexConver.byte2HexStr(getData()) + ", necessaryFunc=" + this.necessaryFunc + ", systemSetup=" + this.systemSetup + ", functionOption=" + this.functionOption + ", sportHealthConfigure=" + this.sportHealthConfigure + ", dialExpandInfo=" + this.dialExpandInfo + '}';
    }
}
