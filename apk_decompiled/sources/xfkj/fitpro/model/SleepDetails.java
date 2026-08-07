package xfkj.fitpro.model;

import defpackage.bn1;
import defpackage.e33;

/* JADX INFO: loaded from: classes4.dex */
public class SleepDetails {
    int asSleep;
    int deepDur;
    int lightDur;
    String sleepDate = e33.c(bn1.l(1), bn1.m());
    int wakeDur;
    int wakeup;

    public int getAsSleep() {
        return this.asSleep;
    }

    public int getDeepDur() {
        return this.deepDur;
    }

    public int getLightDur() {
        return this.lightDur;
    }

    public String getSleepDate() {
        return this.sleepDate;
    }

    public int getWakeDur() {
        return this.wakeDur;
    }

    public int getWakeup() {
        return this.wakeup;
    }

    public void setAsSleep(int i) {
        this.asSleep = i;
    }

    public void setDeepDur(int i) {
        this.deepDur = i;
    }

    public void setLightDur(int i) {
        this.lightDur = i;
    }

    public void setSleepDate(String str) {
        this.sleepDate = str;
    }

    public void setWakeDur(int i) {
        this.wakeDur = i;
    }

    public void setWakeup(int i) {
        this.wakeup = i;
    }

    public String toString() {
        return "SleepDetails{sleepDate='" + this.sleepDate + "', asSleep=" + this.asSleep + ", wakeup=" + this.wakeup + ", deepDur=" + this.deepDur + ", lightDur=" + this.lightDur + ", wakeDur=" + this.wakeDur + '}';
    }
}
