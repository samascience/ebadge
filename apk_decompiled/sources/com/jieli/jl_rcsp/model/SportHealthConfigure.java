package com.jieli.jl_rcsp.model;

import com.jieli.jl_rcsp.util.CHexConver;
import com.jieli.jl_rcsp.util.RcspUtil;

/* JADX INFO: loaded from: classes3.dex */
public class SportHealthConfigure {
    public static final int CONFIGURE_TYPE_ALTITUDE = 3;
    public static final int CONFIGURE_TYPE_BLOOD_OXYGEN = 2;
    public static final int CONFIGURE_TYPE_COMBINE_FUNC = 255;
    public static final int CONFIGURE_TYPE_GPS = 4;
    public static final int CONFIGURE_TYPE_GSENSOR = 0;
    public static final int CONFIGURE_TYPE_RATE = 1;
    public static final int CONFIGURE_TYPE_SPORT_MODE = 254;
    private AltitudeFunc altitudeFunc;
    private BloodOxygenFunc bloodOxygenFunc;
    private CombineFunc combineFunc;
    private GSensorFunc gSensorFunc;
    private GPSFunc gpsFunc;
    private RateFunc rateFunc;
    private SportModeFunc sportModeFunc;

    public static class AltitudeFunc extends BaseFunc {
        private boolean isOpen;

        public AltitudeFunc(int i, byte[] bArr) throws RuntimeException {
            super(3, i, bArr);
        }

        public boolean isOpen() {
            return this.isOpen;
        }

        @Override // com.jieli.jl_rcsp.model.SportHealthConfigure.BaseFunc
        public void parseData(int i, byte[] bArr) throws RuntimeException {
            if (i != 0) {
                throw new RuntimeException("Unsupported version :  " + i);
            }
            if (bArr != null) {
                if (bArr.length >= 1) {
                    this.isOpen = (bArr[0] & 1) == 1;
                    return;
                }
            }
            throw new RuntimeException(getClass().getSimpleName() + " : Data exception : " + CHexConver.byte2HexStr(bArr));
        }

        public String toString() {
            return "AltitudeFunc{isOpen=" + this.isOpen + "} ";
        }
    }

    public static abstract class BaseFunc {
        private final int type;

        public BaseFunc(int i, int i2, byte[] bArr) throws RuntimeException {
            this.type = i;
            parseData(i2, bArr);
        }

        public int getType() {
            return this.type;
        }

        public abstract void parseData(int i, byte[] bArr) throws RuntimeException;
    }

    public static class BloodOxygenFunc extends BaseFunc {
        private boolean isOpen;

        public BloodOxygenFunc(int i, byte[] bArr) throws RuntimeException {
            super(2, i, bArr);
        }

        public boolean isOpen() {
            return this.isOpen;
        }

        @Override // com.jieli.jl_rcsp.model.SportHealthConfigure.BaseFunc
        public void parseData(int i, byte[] bArr) throws RuntimeException {
            if (i != 0) {
                throw new RuntimeException("Unsupported version :  " + i);
            }
            if (bArr != null) {
                if (bArr.length >= 1) {
                    this.isOpen = (bArr[0] & 1) == 1;
                    return;
                }
            }
            throw new RuntimeException(getClass().getSimpleName() + " : Data exception : " + CHexConver.byte2HexStr(bArr));
        }

        public String toString() {
            return "BloodOxygenFunc{isOpen=" + this.isOpen + "} ";
        }
    }

    public static class CombineFunc extends BaseFunc {
        private boolean isSupportAutoPressureDetection;
        private boolean isSupportFallDetection;
        private boolean isSupportHealthMonitoring;
        private boolean isSupportPersonalInfo;
        private boolean isSupportSedentaryReminder;
        private boolean isSupportSensorSettings;
        private boolean isSupportSleepDetection;
        private boolean isSupportSportRateReminder;

        public CombineFunc(int i, byte[] bArr) throws RuntimeException {
            super(255, i, bArr);
        }

        public boolean isSupportAutoPressureDetection() {
            return this.isSupportAutoPressureDetection;
        }

        public boolean isSupportFallDetection() {
            return this.isSupportFallDetection;
        }

        public boolean isSupportHealthMonitoring() {
            return this.isSupportHealthMonitoring;
        }

        public boolean isSupportPersonalInfo() {
            return this.isSupportPersonalInfo;
        }

        public boolean isSupportSedentaryReminder() {
            return this.isSupportSedentaryReminder;
        }

        public boolean isSupportSensorSettings() {
            return this.isSupportSensorSettings;
        }

        public boolean isSupportSleepDetection() {
            return this.isSupportSleepDetection;
        }

        public boolean isSupportSportRateReminder() {
            return this.isSupportSportRateReminder;
        }

        @Override // com.jieli.jl_rcsp.model.SportHealthConfigure.BaseFunc
        public void parseData(int i, byte[] bArr) throws RuntimeException {
            if (i != 0) {
                throw new RuntimeException("Unsupported version :  " + i);
            }
            if (bArr != null) {
                if (bArr.length >= 1) {
                    byte b = bArr[0];
                    this.isSupportHealthMonitoring = (b & 1) == 1;
                    this.isSupportPersonalInfo = ((b >> 1) & 1) == 1;
                    this.isSupportSleepDetection = ((b >> 2) & 1) == 1;
                    this.isSupportSedentaryReminder = ((b >> 3) & 1) == 1;
                    this.isSupportSportRateReminder = ((b >> 4) & 1) == 1;
                    this.isSupportAutoPressureDetection = ((b >> 5) & 1) == 1;
                    this.isSupportFallDetection = ((b >> 6) & 1) == 1;
                    this.isSupportSensorSettings = ((b >> 7) & 1) == 1;
                    return;
                }
            }
            throw new RuntimeException(getClass().getSimpleName() + " : Data exception : " + CHexConver.byte2HexStr(bArr));
        }

        public String toString() {
            return "CombineFunc{isSupportHealthMonitoring=" + this.isSupportHealthMonitoring + ", isSupportPersonalInfo=" + this.isSupportPersonalInfo + ", isSupportSleepDetection=" + this.isSupportSleepDetection + ", isSupportSedentaryReminder=" + this.isSupportSedentaryReminder + ", isSupportSportRateReminder=" + this.isSupportSportRateReminder + ", isSupportAutoPressureDetection=" + this.isSupportAutoPressureDetection + ", isSupportFallDetection=" + this.isSupportFallDetection + ", isSupportSensorSettings=" + this.isSupportSensorSettings + "} ";
        }
    }

    public static class GPSFunc extends BaseFunc {
        private boolean isOpen;

        public GPSFunc(int i, byte[] bArr) throws RuntimeException {
            super(4, i, bArr);
        }

        public boolean isOpen() {
            return this.isOpen;
        }

        @Override // com.jieli.jl_rcsp.model.SportHealthConfigure.BaseFunc
        public void parseData(int i, byte[] bArr) throws RuntimeException {
            if (i != 0) {
                throw new RuntimeException("Unsupported version :  " + i);
            }
            if (bArr != null) {
                if (bArr.length >= 1) {
                    this.isOpen = (bArr[0] & 1) == 1;
                    return;
                }
            }
            throw new RuntimeException(getClass().getSimpleName() + " : Data exception : " + CHexConver.byte2HexStr(bArr));
        }

        public String toString() {
            return "GPSFunc{isOpen=" + this.isOpen + "} ";
        }
    }

    public static class GSensorFunc extends BaseFunc {
        private boolean isEnableSportStep;
        private boolean isOpen;

        public GSensorFunc(int i, byte[] bArr) throws RuntimeException {
            super(0, i, bArr);
        }

        public boolean isEnableSportStep() {
            return this.isEnableSportStep;
        }

        public boolean isOpen() {
            return this.isOpen;
        }

        @Override // com.jieli.jl_rcsp.model.SportHealthConfigure.BaseFunc
        public void parseData(int i, byte[] bArr) throws RuntimeException {
            if (i != 0) {
                throw new RuntimeException("Unsupported version :  " + i);
            }
            if (bArr != null) {
                if (bArr.length >= 1) {
                    byte b = bArr[0];
                    this.isOpen = (b & 1) == 1;
                    this.isEnableSportStep = ((b >> 1) & 1) == 1;
                    return;
                }
            }
            throw new RuntimeException(getClass().getSimpleName() + " : Data exception : " + CHexConver.byte2HexStr(bArr));
        }

        public String toString() {
            return "GSensorFunc{, isOpen=" + this.isOpen + ", isEnableSportStep=" + this.isEnableSportStep + "} ";
        }
    }

    public static class RateFunc extends BaseFunc {
        private boolean isEnableContinuousTest;
        private boolean isOpen;

        public RateFunc(int i, byte[] bArr) throws RuntimeException {
            super(1, i, bArr);
        }

        public boolean isEnableContinuousTest() {
            return this.isEnableContinuousTest;
        }

        public boolean isOpen() {
            return this.isOpen;
        }

        @Override // com.jieli.jl_rcsp.model.SportHealthConfigure.BaseFunc
        public void parseData(int i, byte[] bArr) throws RuntimeException {
            if (i != 0) {
                throw new RuntimeException("Unsupported version :  " + i);
            }
            if (bArr != null) {
                if (bArr.length >= 1) {
                    byte b = bArr[0];
                    this.isOpen = (b & 1) == 1;
                    this.isEnableContinuousTest = ((b >> 1) & 1) == 1;
                    return;
                }
            }
            throw new RuntimeException(getClass().getSimpleName() + " : Data exception : " + CHexConver.byte2HexStr(bArr));
        }

        public String toString() {
            return "RateFunc{isOpen=" + this.isOpen + ", isEnableContinuousTest=" + this.isEnableContinuousTest + "} ";
        }
    }

    public static class SportModeFunc extends BaseFunc {
        private boolean isSupportCount;
        private boolean isSupportInDoor;
        private boolean isSupportOutDoor;
        private boolean isSupportRecord;

        public SportModeFunc(int i, byte[] bArr) throws RuntimeException {
            super(SportHealthConfigure.CONFIGURE_TYPE_SPORT_MODE, i, bArr);
        }

        public boolean isSupportCount() {
            return this.isSupportCount;
        }

        public boolean isSupportInDoor() {
            return this.isSupportInDoor;
        }

        public boolean isSupportOutDoor() {
            return this.isSupportOutDoor;
        }

        public boolean isSupportRecord() {
            return this.isSupportRecord;
        }

        @Override // com.jieli.jl_rcsp.model.SportHealthConfigure.BaseFunc
        public void parseData(int i, byte[] bArr) throws RuntimeException {
            if (i != 0) {
                throw new RuntimeException("Unsupported version :  " + i);
            }
            if (bArr != null) {
                if (bArr.length >= 1) {
                    byte b = bArr[0];
                    this.isSupportRecord = (b & 1) == 1;
                    this.isSupportCount = ((b >> 1) & 1) == 1;
                    this.isSupportOutDoor = ((b >> 2) & 1) == 1;
                    this.isSupportInDoor = ((b >> 3) & 1) == 1;
                    return;
                }
            }
            throw new RuntimeException(getClass().getSimpleName() + " : Data exception : " + CHexConver.byte2HexStr(bArr));
        }

        public String toString() {
            return "SportModeFunc{isSupportRecord=" + this.isSupportRecord + ", isSupportCount=" + this.isSupportCount + ", isSupportOutDoor=" + this.isSupportOutDoor + ", isSupportInDoor=" + this.isSupportInDoor + "} ";
        }
    }

    public SportHealthConfigure(int i, byte[] bArr) throws RuntimeException {
        parseData(i, bArr);
    }

    private void parseData(int i, byte[] bArr) throws RuntimeException {
        if (i != 0) {
            throw new RuntimeException("Unsupported version :  " + i);
        }
        if (bArr == null || bArr.length < 2) {
            throw new RuntimeException("Data exception : " + CHexConver.byte2HexStr(bArr));
        }
        for (LtvBean ltvBean : RcspUtil.parseLTVData(bArr)) {
            byte[] data = ltvBean.getData();
            int type = ltvBean.getType();
            if (type == 254) {
                this.sportModeFunc = new SportModeFunc(i, data);
            } else if (type == 255) {
                this.combineFunc = new CombineFunc(i, data);
            } else if (type == 0) {
                this.gSensorFunc = new GSensorFunc(i, data);
            } else if (type == 1) {
                this.rateFunc = new RateFunc(i, data);
            } else if (type == 2) {
                this.bloodOxygenFunc = new BloodOxygenFunc(i, data);
            } else if (type == 3) {
                this.altitudeFunc = new AltitudeFunc(i, data);
            } else if (type == 4) {
                this.gpsFunc = new GPSFunc(i, data);
            }
        }
    }

    public AltitudeFunc getAltitudeFunc() {
        return this.altitudeFunc;
    }

    public BloodOxygenFunc getBloodOxygenFunc() {
        return this.bloodOxygenFunc;
    }

    public CombineFunc getCombineFunc() {
        return this.combineFunc;
    }

    public GSensorFunc getGSensorFunc() {
        return this.gSensorFunc;
    }

    public GPSFunc getGpsFunc() {
        return this.gpsFunc;
    }

    public RateFunc getRateFunc() {
        return this.rateFunc;
    }

    public SportModeFunc getSportModeFunc() {
        return this.sportModeFunc;
    }

    public boolean isExistAltitude() {
        return this.altitudeFunc != null;
    }

    public boolean isExistBloodOxygen() {
        return this.bloodOxygenFunc != null;
    }

    public boolean isExistGSensor() {
        return this.gSensorFunc != null;
    }

    public boolean isExistGps() {
        return this.gpsFunc != null;
    }

    public boolean isExistRate() {
        return this.rateFunc != null;
    }

    public String toString() {
        return "SportHealthConfigure{gSensorFunc=" + this.gSensorFunc + ", rateFunc=" + this.rateFunc + ",bloodOxygenFunc=" + this.bloodOxygenFunc + ",altitudeFunc=" + this.altitudeFunc + ",gpsFunc=" + this.gpsFunc + ",sportModeFunc=" + this.sportModeFunc + ",combineFunc=" + this.combineFunc + '}';
    }
}
