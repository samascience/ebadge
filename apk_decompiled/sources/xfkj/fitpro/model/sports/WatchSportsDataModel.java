package xfkj.fitpro.model.sports;

import android.os.Parcel;
import android.os.Parcelable;
import com.tenmeter.smlibrary.utils.DateFormatUtils;
import defpackage.e33;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class WatchSportsDataModel implements Parcelable {
    public static final Parcelable.Creator<WatchSportsDataModel> CREATOR = new Parcelable.Creator<WatchSportsDataModel>() { // from class: xfkj.fitpro.model.sports.WatchSportsDataModel.1
        @Override // android.os.Parcelable.Creator
        public WatchSportsDataModel createFromParcel(Parcel parcel) {
            return new WatchSportsDataModel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public WatchSportsDataModel[] newArray(int i) {
            return new WatchSportsDataModel[i];
        }
    };
    int avgHeartRate;
    Date date;
    String devid;
    int duration;
    Long id;
    boolean isUpload;
    int jumpNum;
    int maxHeart;
    int minHeart;
    int sportMode;
    int steps;
    int totalKcal;
    int totalKm;
    long userId;
    String yyyyMM;
    String yyyyMMdd;

    protected WatchSportsDataModel(Parcel parcel) {
        this.userId = -1L;
        this.isUpload = false;
        this.userId = parcel.readLong();
        this.devid = parcel.readString();
        this.sportMode = parcel.readInt();
        this.duration = parcel.readInt();
        this.totalKm = parcel.readInt();
        this.totalKcal = parcel.readInt();
        this.avgHeartRate = parcel.readInt();
        this.steps = parcel.readInt();
        this.minHeart = parcel.readInt();
        this.maxHeart = parcel.readInt();
        this.yyyyMM = parcel.readString();
        this.yyyyMMdd = parcel.readString();
        this.jumpNum = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAvgHeartRate() {
        return this.avgHeartRate;
    }

    public Date getDate() {
        return this.date;
    }

    public String getDevid() {
        return this.devid;
    }

    public int getDuration() {
        return this.duration;
    }

    public Long getId() {
        return this.id;
    }

    public boolean getIsUpload() {
        return this.isUpload;
    }

    public int getJumpNum() {
        return this.jumpNum;
    }

    public int getMaxHeart() {
        return this.maxHeart;
    }

    public int getMinHeart() {
        return this.minHeart;
    }

    public int getSportMode() {
        return this.sportMode;
    }

    public int getSteps() {
        return this.steps;
    }

    public int getTotalKcal() {
        return this.totalKcal;
    }

    public int getTotalKm() {
        return this.totalKm;
    }

    public long getUserId() {
        return this.userId;
    }

    public String getYyyyMM() {
        if (this.yyyyMM == null) {
            this.yyyyMM = e33.c(this.date, new SimpleDateFormat(DateFormatUtils.YYYY_MM, Locale.ENGLISH));
        }
        return this.yyyyMM;
    }

    public String getYyyyMMdd() {
        if (this.yyyyMMdd == null) {
            this.yyyyMMdd = e33.c(this.date, new SimpleDateFormat(DateFormatUtils.YYYYMMDD, Locale.ENGLISH));
        }
        return this.yyyyMMdd;
    }

    public void setAvgHeartRate(int i) {
        this.avgHeartRate = i;
    }

    public void setDate(Date date) {
        this.date = date;
        Locale locale = Locale.ENGLISH;
        this.yyyyMM = e33.c(date, new SimpleDateFormat(DateFormatUtils.YYYY_MM, locale));
        this.yyyyMMdd = e33.c(date, new SimpleDateFormat(DateFormatUtils.YYYYMMDD, locale));
    }

    public void setDevid(String str) {
        this.devid = str;
    }

    public void setDuration(int i) {
        this.duration = i;
    }

    public void setId(Long l) {
        this.id = l;
    }

    public void setIsUpload(boolean z) {
        this.isUpload = z;
    }

    public void setJumpNum(int i) {
        this.jumpNum = i;
    }

    public void setMaxHeart(int i) {
        this.maxHeart = i;
    }

    public void setMinHeart(int i) {
        this.minHeart = i;
    }

    public void setSportMode(int i) {
        this.sportMode = i;
    }

    public void setSteps(int i) {
        this.steps = i;
    }

    public void setTotalKcal(int i) {
        this.totalKcal = i;
    }

    public void setTotalKm(int i) {
        this.totalKm = i;
    }

    public void setUserId(long j) {
        this.userId = j;
    }

    public void setYyyyMM(String str) {
        this.yyyyMM = str;
    }

    public void setYyyyMMdd(String str) {
        this.yyyyMMdd = str;
    }

    public String toString() {
        return "WatchSportsDataModel{id=" + this.id + ", userId=" + this.userId + ", isUpload=" + this.isUpload + ", devid='" + this.devid + "', date=" + this.date + ", sportMode=" + this.sportMode + ", duration=" + this.duration + ", totalKm=" + this.totalKm + ", totalKcal=" + this.totalKcal + ", avgHeartRate=" + this.avgHeartRate + ", steps=" + this.steps + ", minHeart=" + this.minHeart + ", maxHeart=" + this.maxHeart + ", jumpNum=" + this.jumpNum + ", yyyyMM='" + this.yyyyMM + "', yyyyMMdd='" + this.yyyyMMdd + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.userId);
        parcel.writeString(this.devid);
        parcel.writeInt(this.sportMode);
        parcel.writeInt(this.duration);
        parcel.writeInt(this.totalKm);
        parcel.writeInt(this.totalKcal);
        parcel.writeInt(this.avgHeartRate);
        parcel.writeInt(this.steps);
        parcel.writeInt(this.minHeart);
        parcel.writeInt(this.maxHeart);
        parcel.writeString(this.yyyyMM);
        parcel.writeString(this.yyyyMMdd);
        parcel.writeInt(this.jumpNum);
    }

    public WatchSportsDataModel(Long l, long j, boolean z, String str, Date date, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, String str2, String str3) {
        this.id = l;
        this.userId = j;
        this.isUpload = z;
        this.devid = str;
        this.date = date;
        this.sportMode = i;
        this.duration = i2;
        this.totalKm = i3;
        this.totalKcal = i4;
        this.avgHeartRate = i5;
        this.steps = i6;
        this.minHeart = i7;
        this.maxHeart = i8;
        this.jumpNum = i9;
        this.yyyyMM = str2;
        this.yyyyMMdd = str3;
    }

    public WatchSportsDataModel() {
        this.userId = -1L;
        this.isUpload = false;
    }
}
