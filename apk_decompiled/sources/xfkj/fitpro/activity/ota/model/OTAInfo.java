package xfkj.fitpro.activity.ota.model;

import com.tencent.connect.common.Constants;
import defpackage.p31;

/* JADX INFO: loaded from: classes4.dex */
public final class OTAInfo {
    private String classicBluetoothMac;
    private int plarmType;
    private String softVersion;
    private String deviceId = Constants.STR_EMPTY;
    private String led = Constants.STR_EMPTY;
    private String gsensor = Constants.STR_EMPTY;
    private String heart = Constants.STR_EMPTY;
    private String bluetoothName = Constants.STR_EMPTY;

    public final String getBluetoothName() {
        return this.bluetoothName;
    }

    public final String getClassicBluetoothMac() {
        return this.classicBluetoothMac;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final String getGsensor() {
        return this.gsensor;
    }

    public final String getHeart() {
        return this.heart;
    }

    public final String getLed() {
        return this.led;
    }

    public final int getPlarmType() {
        return this.plarmType;
    }

    public final String getSoftVersion() {
        return this.softVersion;
    }

    public final void setBluetoothName(String str) {
        p31.f(str, "<set-?>");
        this.bluetoothName = str;
    }

    public final void setClassicBluetoothMac(String str) {
        this.classicBluetoothMac = str;
    }

    public final void setDeviceId(String str) {
        p31.f(str, "<set-?>");
        this.deviceId = str;
    }

    public final void setGsensor(String str) {
        p31.f(str, "<set-?>");
        this.gsensor = str;
    }

    public final void setHeart(String str) {
        p31.f(str, "<set-?>");
        this.heart = str;
    }

    public final void setLed(String str) {
        p31.f(str, "<set-?>");
        this.led = str;
    }

    public final void setPlarmType(int i) {
        this.plarmType = i;
    }

    public final void setSoftVersion(String str) {
        this.softVersion = str;
    }
}
