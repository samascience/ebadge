package xfkj.fitpro.model;

import defpackage.e33;
import java.util.Date;

/* JADX INFO: loaded from: classes4.dex */
public class MeasureHeartModel {
    Date date;
    String devid;
    int heart;
    boolean isLocal;
    byte status;
    long userId;

    public MeasureHeartModel(long j, String str, Date date, int i, byte b, boolean z) {
        this.userId = -1L;
        e33.e();
        this.userId = j;
        this.devid = str;
        this.date = date;
        this.heart = i;
        this.status = b;
        this.isLocal = z;
    }

    public Date getDate() {
        return this.date;
    }

    public String getDevid() {
        return this.devid;
    }

    public int getHeart() {
        return this.heart;
    }

    public boolean getIsLocal() {
        return this.isLocal;
    }

    public byte getStatus() {
        return this.status;
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

    public void setHeart(int i) {
        this.heart = i;
    }

    public void setIsLocal(boolean z) {
        this.isLocal = z;
    }

    public void setStatus(byte b) {
        this.status = b;
    }

    public void setUserId(long j) {
        this.userId = j;
    }

    public String toString() {
        return "MeasureHeartModel{devid='" + this.devid + "', date=" + this.date + ", heart=" + this.heart + ", status=" + ((int) this.status) + '}';
    }

    public MeasureHeartModel() {
        this.userId = -1L;
        this.date = e33.e();
        this.isLocal = false;
    }
}
