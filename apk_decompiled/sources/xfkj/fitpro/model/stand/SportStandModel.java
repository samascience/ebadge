package xfkj.fitpro.model.stand;

import com.tenmeter.smlibrary.utils.DateFormatUtils;
import defpackage.e33;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class SportStandModel {
    Date date;
    String dateStrIndex;
    String devid;
    int flag;
    Long id;
    boolean isUpload;
    long userId;

    public SportStandModel(Long l, long j, String str, Date date, int i, String str2, boolean z) {
        this.id = l;
        this.userId = j;
        this.devid = str;
        this.date = date;
        this.flag = i;
        this.dateStrIndex = str2;
        this.isUpload = z;
    }

    public Date getDate() {
        return this.date;
    }

    public String getDateStrIndex() {
        return this.dateStrIndex;
    }

    public String getDevid() {
        return this.devid;
    }

    public int getFlag() {
        return this.flag;
    }

    public Long getId() {
        return this.id;
    }

    public boolean getIsUpload() {
        return this.isUpload;
    }

    public long getUserId() {
        return this.userId;
    }

    public void setDate(Date date) {
        this.date = date;
        this.dateStrIndex = e33.c(date, new SimpleDateFormat(DateFormatUtils.YYYYMMDD, Locale.ENGLISH));
    }

    public void setDateStrIndex(String str) {
        this.dateStrIndex = str;
    }

    public void setDevid(String str) {
        this.devid = str;
    }

    public void setFlag(int i) {
        this.flag = i;
    }

    public void setId(Long l) {
        this.id = l;
    }

    public void setIsUpload(boolean z) {
        this.isUpload = z;
    }

    public void setUserId(long j) {
        this.userId = j;
    }

    public String toString() {
        return "SportStandModel{id=" + this.id + ", userId=" + this.userId + ", devid='" + this.devid + "', date=" + this.date + ", flag=" + this.flag + ", dateStrIndex='" + this.dateStrIndex + "'}";
    }

    public SportStandModel() {
        this.userId = -1L;
        this.isUpload = false;
    }
}
