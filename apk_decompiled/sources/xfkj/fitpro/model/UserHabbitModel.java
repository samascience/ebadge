package xfkj.fitpro.model;

import java.util.Date;

/* JADX INFO: loaded from: classes4.dex */
public class UserHabbitModel {
    private String avator;
    private int continueDays;
    private Date firstSign;
    private long habbitId;
    private String habbitName;
    Long id;
    private Date lastSign;
    private String nickname;
    private String signDays;
    private int totalDays;
    private long userId;

    public UserHabbitModel(Long l, long j, long j2, String str, String str2, String str3, int i, int i2, String str4, Date date, Date date2) {
        this.id = l;
        this.habbitId = j;
        this.userId = j2;
        this.nickname = str;
        this.avator = str2;
        this.habbitName = str3;
        this.continueDays = i;
        this.totalDays = i2;
        this.signDays = str4;
        this.firstSign = date;
        this.lastSign = date2;
    }

    public String getAvator() {
        return this.avator;
    }

    public int getContinueDays() {
        return this.continueDays;
    }

    public Date getFirstSign() {
        return this.firstSign;
    }

    public long getHabbitId() {
        return this.habbitId;
    }

    public String getHabbitName() {
        return this.habbitName;
    }

    public Long getId() {
        return this.id;
    }

    public Date getLastSign() {
        return this.lastSign;
    }

    public String getNickname() {
        return this.nickname;
    }

    public String getSignDays() {
        return this.signDays;
    }

    public int getTotalDays() {
        return this.totalDays;
    }

    public long getUserId() {
        return this.userId;
    }

    public void setAvator(String str) {
        this.avator = str;
    }

    public void setContinueDays(int i) {
        this.continueDays = i;
    }

    public void setFirstSign(Date date) {
        this.firstSign = date;
    }

    public void setHabbitId(long j) {
        this.habbitId = j;
    }

    public void setHabbitName(String str) {
        this.habbitName = str;
    }

    public void setId(Long l) {
        this.id = l;
    }

    public void setLastSign(Date date) {
        this.lastSign = date;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }

    public void setSignDays(String str) {
        this.signDays = str;
    }

    public void setTotalDays(int i) {
        this.totalDays = i;
    }

    public void setUserId(long j) {
        this.userId = j;
    }

    public String toString() {
        return "UserHabbitModel{id=" + this.id + ", habbitId=" + this.habbitId + ", userId=" + this.userId + ", nickname='" + this.nickname + "', avator='" + this.avator + "', habbitName='" + this.habbitName + "', continueDays=" + this.continueDays + ", totalDays=" + this.totalDays + ", signDays='" + this.signDays + "', firstSign=" + this.firstSign + ", lastSign=" + this.lastSign + '}';
    }

    public UserHabbitModel() {
    }
}
