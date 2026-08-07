package xfkj.fitpro.model;

import defpackage.e33;
import java.util.Date;

/* JADX INFO: loaded from: classes4.dex */
public class MeasureBloodModel {
    Date date;
    String devid;
    int hBlood;
    int lBlood;
    long userId;

    public MeasureBloodModel(long j, String str, Date date, int i, int i2) {
        this.userId = -1L;
        e33.e();
        this.userId = j;
        this.devid = str;
        this.date = date;
        this.hBlood = i;
        this.lBlood = i2;
    }

    public Date getChartDate() {
        return this.date;
    }

    public Date getDate() {
        return this.date;
    }

    public String getDevid() {
        return this.devid;
    }

    public int getHBlood() {
        return this.hBlood;
    }

    public int getLBlood() {
        return this.lBlood;
    }

    public long getUserId() {
        return this.userId;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDevid(String str) {
        this.devid = str;
    }

    public void setHBlood(int i) {
        this.hBlood = i;
    }

    public void setLBlood(int i) {
        this.lBlood = i;
    }

    public void setUserId(long j) {
        this.userId = j;
    }

    public String toString() {
        return "MeasureBloodModel{devid='" + this.devid + "', date=" + this.date + ", hBlood=" + this.hBlood + ", lBlood=" + this.lBlood + '}';
    }

    public MeasureBloodModel() {
        this.userId = -1L;
        this.date = e33.e();
    }
}
