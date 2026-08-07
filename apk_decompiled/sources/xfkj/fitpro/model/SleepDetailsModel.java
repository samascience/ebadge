package xfkj.fitpro.model;

import defpackage.e33;
import java.util.Date;

/* JADX INFO: loaded from: classes4.dex */
public class SleepDetailsModel {
    Date date;
    String devid;
    Long id;
    boolean isUpload;
    Date localDate;
    int sleepType;
    long userId;

    public SleepDetailsModel(Long l, long j, boolean z, Date date, int i, String str, Date date2) {
        this.userId = -1L;
        this.isUpload = false;
        e33.e();
        this.id = l;
        this.userId = j;
        this.isUpload = z;
        this.date = date;
        this.sleepType = i;
        this.devid = str;
        this.localDate = date2;
    }

    public Date getDate() {
        return this.date;
    }

    public String getDevid() {
        return this.devid;
    }

    public Long getId() {
        return this.id;
    }

    public boolean getIsUpload() {
        return this.isUpload;
    }

    public Date getLocalDate() {
        return this.localDate;
    }

    public int getSleepType() {
        return this.sleepType;
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

    public void setId(Long l) {
        this.id = l;
    }

    public void setIsUpload(boolean z) {
        this.isUpload = z;
    }

    public void setLocalDate(Date date) {
        this.localDate = date;
    }

    public void setSleepType(int i) {
        this.sleepType = i;
    }

    public void setUserId(long j) {
        this.userId = j;
    }

    public String toString() {
        return "SleepDetailsModel{id=" + this.id + ", userId=" + this.userId + ", isUpload=" + this.isUpload + ", date=" + e33.b(this.date) + ", sleepType=" + this.sleepType + ", devid='" + this.devid + "', localDate=" + this.localDate + '}';
    }

    public SleepDetailsModel() {
        this.userId = -1L;
        this.isUpload = false;
        this.localDate = e33.e();
    }
}
