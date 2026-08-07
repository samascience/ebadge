package xfkj.fitpro.model;

/* JADX INFO: loaded from: classes4.dex */
public class SleepWarnModel {
    String devid;
    boolean isOpen;
    short startSleepTime;
    byte weeks;

    public SleepWarnModel(String str, boolean z, byte b, short s) {
        this.devid = str;
        this.isOpen = z;
        this.weeks = b;
        this.startSleepTime = s;
    }

    public String getDevid() {
        return this.devid;
    }

    public boolean getIsOpen() {
        return this.isOpen;
    }

    public short getStartSleepTime() {
        return this.startSleepTime;
    }

    public byte getWeeks() {
        return this.weeks;
    }

    public void setDevid(String str) {
        this.devid = str;
    }

    public void setIsOpen(boolean z) {
        this.isOpen = z;
    }

    public void setStartSleepTime(short s) {
        this.startSleepTime = s;
    }

    public void setWeeks(byte b) {
        this.weeks = b;
    }

    public String toString() {
        return "SleepWarnModel{devid='" + this.devid + "', isOpen=" + this.isOpen + ", startSleepTime=" + ((int) this.startSleepTime) + '}';
    }

    public SleepWarnModel() {
    }
}
