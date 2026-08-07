package xfkj.fitpro.model;

import defpackage.e33;
import defpackage.zm1;
import java.util.Date;

/* JADX INFO: loaded from: classes4.dex */
public class TempModel {
    Long dbId;
    String devid;
    String id;
    Date measureTime;
    int tmp;
    String userId;

    public TempModel(Long l, String str, Date date, int i, String str2, String str3) {
        this.measureTime = e33.e();
        zm1.n();
        this.dbId = l;
        this.id = str;
        this.measureTime = date;
        this.tmp = i;
        this.devid = str2;
        this.userId = str3;
    }

    public Long getDbId() {
        return this.dbId;
    }

    public String getDevid() {
        return this.devid;
    }

    public String getId() {
        return this.id;
    }

    public Date getMeasureTime() {
        return this.measureTime;
    }

    public int getTmp() {
        return this.tmp;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setDbId(Long l) {
        this.dbId = l;
    }

    public void setDevid(String str) {
        this.devid = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setMeasureTime(Date date) {
        this.measureTime = date;
    }

    public void setTmp(int i) {
        this.tmp = i;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public String toString() {
        return "TempModel{dbId=" + this.dbId + ", id='" + this.id + "', measureTime=" + this.measureTime + ", tmp=" + this.tmp + ", devid='" + this.devid + "', userId='" + this.userId + "'}";
    }

    public TempModel() {
        this.measureTime = e33.e();
        this.devid = zm1.n();
        this.userId = "-1";
    }
}
