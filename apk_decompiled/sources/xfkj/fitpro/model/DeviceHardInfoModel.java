package xfkj.fitpro.model;

/* JADX INFO: loaded from: classes4.dex */
public class DeviceHardInfoModel {
    private String deviceId;
    private String gsensor;
    private String heart;
    private String led;

    public DeviceHardInfoModel(String str, String str2, String str3, String str4) {
        this.deviceId = str;
        this.led = str2;
        this.gsensor = str3;
        this.heart = str4;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public String getGsensor() {
        return this.gsensor;
    }

    public String getHeart() {
        return this.heart;
    }

    public String getLed() {
        return this.led;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setGsensor(String str) {
        this.gsensor = str;
    }

    public void setHeart(String str) {
        this.heart = str;
    }

    public void setLed(String str) {
        this.led = str;
    }

    public String toString() {
        return "DeviceHardInfoModel{deviceId='" + this.deviceId + "', led='" + this.led + "', gsensor='" + this.gsensor + "', heart='" + this.heart + "'}";
    }

    public DeviceHardInfoModel() {
    }
}
