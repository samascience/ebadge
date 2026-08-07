package xfkj.fitpro.model;

import defpackage.e33;
import java.util.Date;

/* JADX INFO: loaded from: classes4.dex */
public class MeasureSpoModel {
    Date date;
    String devid;
    int spo;
    long userId;

    public MeasureSpoModel(long j, String str, Date date, int i) {
        this.userId = -1L;
        e33.e();
        this.userId = j;
        this.devid = str;
        this.date = date;
        this.spo = i;
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

    public int getSpo() {
        return this.spo;
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

    public void setSpo(int i) {
        this.spo = i;
    }

    public void setUserId(long j) {
        this.userId = j;
    }

    public String toString() {
        return "MeasureSpoModel{devid='" + this.devid + "', date=" + this.date + ", spo=" + this.spo + '}';
    }

    public MeasureSpoModel() {
        this.userId = -1L;
        this.date = e33.e();
    }
}
