package xfkj.fitpro.model;

import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class UserHabbitDetailsModel {
    private String avator;
    private int continueDays;
    private String habbitId;
    private String habbitName;
    private String nickname;
    private List<Date> signDays;
    private int totalDays;
    private long userId;

    public String getAvator() {
        return this.avator;
    }

    public int getContinueDays() {
        return this.continueDays;
    }

    public String getHabbitId() {
        return this.habbitId;
    }

    public String getHabbitName() {
        return this.habbitName;
    }

    public String getNickname() {
        return this.nickname;
    }

    public List<Date> getSignDays() {
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

    public void setHabbitId(String str) {
        this.habbitId = str;
    }

    public void setHabbitName(String str) {
        this.habbitName = str;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }

    public void setSignDays(List<Date> list) {
        this.signDays = list;
    }

    public void setTotalDays(int i) {
        this.totalDays = i;
    }

    public void setUserId(long j) {
        this.userId = j;
    }
}
