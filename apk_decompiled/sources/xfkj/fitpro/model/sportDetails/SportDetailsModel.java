package xfkj.fitpro.model.sportDetails;

import com.tenmeter.smlibrary.utils.DateFormatUtils;
import defpackage.e33;
import defpackage.pv2;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class SportDetailsModel {
    int activeTime;
    int calory;
    Date date;
    String dateStr;
    String devid;
    int distance;
    Long id;
    boolean isLastHistory;
    boolean isUpload;
    int mode;
    int step;
    int targetSteps;
    long userId;

    public SportDetailsModel(int i, int i2, int i3, int i4, int i5, Date date) {
        this.userId = -1L;
        this.isUpload = false;
        this.isLastHistory = false;
        this.calory = i;
        this.mode = i2;
        this.step = i3;
        this.distance = i4;
        this.activeTime = i5;
        this.date = date;
        this.dateStr = e33.c(date, new SimpleDateFormat(DateFormatUtils.YYYYMMDD, Locale.ENGLISH));
    }

    public int getActiveTime() {
        return this.activeTime;
    }

    public int getCalory() {
        return this.calory;
    }

    public Date getDate() {
        return this.date;
    }

    public String getDateStr() {
        if (pv2.h(this.dateStr)) {
            this.dateStr = e33.c(this.date, new SimpleDateFormat(DateFormatUtils.YYYYMMDD, Locale.ENGLISH));
        }
        return this.dateStr;
    }

    public String getDevid() {
        return this.devid;
    }

    public int getDistance() {
        return this.distance;
    }

    public Long getId() {
        return this.id;
    }

    public boolean getIsLastHistory() {
        return this.isLastHistory;
    }

    public boolean getIsUpload() {
        return this.isUpload;
    }

    public int getMode() {
        return this.mode;
    }

    public int getStep() {
        return this.step;
    }

    public int getTargetSteps() {
        return this.targetSteps;
    }

    public long getUserId() {
        return this.userId;
    }

    public void setActiveTime(int i) {
        this.activeTime = i;
    }

    public void setCalory(int i) {
        this.calory = i;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDateStr(String str) {
        this.dateStr = str;
    }

    public void setDevid(String str) {
        this.devid = str;
    }

    public void setDistance(int i) {
        this.distance = i;
    }

    public void setId(Long l) {
        this.id = l;
    }

    public void setIsLastHistory(boolean z) {
        this.isLastHistory = z;
    }

    public void setIsUpload(boolean z) {
        this.isUpload = z;
    }

    public void setMode(int i) {
        this.mode = i;
    }

    public void setStep(int i) {
        this.step = i;
    }

    public void setTargetSteps(int i) {
        this.targetSteps = i;
    }

    public void setUserId(long j) {
        this.userId = j;
    }

    public String toString() {
        return "SportDetailsModel{id=" + this.id + ", userId=" + this.userId + ", isUpload=" + this.isUpload + ", calory=" + this.calory + ", mode=" + this.mode + ", step=" + this.step + ", distance=" + this.distance + ", activeTime=" + this.activeTime + ", devid='" + this.devid + "', date=" + this.date + ", dateStr='" + this.dateStr + "', isLastHistory=" + this.isLastHistory + ", targetSteps=" + this.targetSteps + '}';
    }

    public SportDetailsModel(Long l, long j, boolean z, int i, int i2, int i3, int i4, int i5, String str, Date date, String str2, boolean z2, int i6) {
        this.id = l;
        this.userId = j;
        this.isUpload = z;
        this.calory = i;
        this.mode = i2;
        this.step = i3;
        this.distance = i4;
        this.activeTime = i5;
        this.devid = str;
        this.date = date;
        this.dateStr = str2;
        this.isLastHistory = z2;
        this.targetSteps = i6;
    }

    public SportDetailsModel() {
        this.userId = -1L;
        this.isUpload = false;
        this.isLastHistory = false;
    }
}
