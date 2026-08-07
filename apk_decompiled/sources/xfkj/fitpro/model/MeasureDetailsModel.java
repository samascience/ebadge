package xfkj.fitpro.model;

import java.util.Date;

/* JADX INFO: loaded from: classes4.dex */
public class MeasureDetailsModel {
    Date date;
    String devid;
    int hblood;
    int heart;
    Long id;
    boolean isUpload;
    int lblood;
    int spo;
    long userId;

    public MeasureDetailsModel(Long l, long j, boolean z, Date date, int i, int i2, int i3, int i4, String str) {
        this.id = l;
        this.userId = j;
        this.isUpload = z;
        this.date = date;
        this.heart = i;
        this.lblood = i2;
        this.hblood = i3;
        this.spo = i4;
        this.devid = str;
    }

    public Date getDate() {
        return this.date;
    }

    public String getDevid() {
        return this.devid;
    }

    public int getHblood() {
        return this.hblood;
    }

    public int getHeart() {
        return this.heart;
    }

    public Long getId() {
        return this.id;
    }

    public boolean getIsUpload() {
        return this.isUpload;
    }

    public int getLblood() {
        return this.lblood;
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

    public void setHblood(int i) {
        this.hblood = i;
    }

    public void setHeart(int i) {
        this.heart = i;
    }

    public void setId(Long l) {
        this.id = l;
    }

    public void setIsUpload(boolean z) {
        this.isUpload = z;
    }

    public void setLblood(int i) {
        this.lblood = i;
    }

    public void setSpo(int i) {
        this.spo = i;
    }

    public void setUserId(long j) {
        this.userId = j;
    }

    public String toString() {
        return "MeasureDetailsModel{id=" + this.id + ", userId=" + this.userId + ", isUpload=" + this.isUpload + ", date=" + this.date + ", heart=" + this.heart + ", lblood=" + this.lblood + ", hblood=" + this.hblood + ", spo=" + this.spo + ", devid='" + this.devid + "'}";
    }

    public MeasureDetailsModel() {
        this.userId = -1L;
        this.isUpload = false;
    }
}
