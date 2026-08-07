package xfkj.fitpro.model;

import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class UserHabbitSignModel {
    private int continueDays;
    private Date firstSign;
    private String habbitId;
    private String habbitName;
    private Date lastSign;
    private List<Date> signDays;
    private int totalDays;
    private String userId;

    public int getContinueDays() {
        return this.continueDays;
    }

    public Date getFirstSign() {
        return this.firstSign;
    }

    public String getHabbitId() {
        return this.habbitId;
    }

    public String getHabbitName() {
        return this.habbitName;
    }

    public Date getLastSign() {
        return this.lastSign;
    }

    public List<Date> getSignDays() {
        return this.signDays;
    }

    public int getTotalDays() {
        return this.totalDays;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setContinueDays(int i) {
        this.continueDays = i;
    }

    public void setFirstSign(Date date) {
        this.firstSign = date;
    }

    public void setHabbitId(String str) {
        this.habbitId = str;
    }

    public void setHabbitName(String str) {
        this.habbitName = str;
    }

    public void setLastSign(Date date) {
        this.lastSign = date;
    }

    public void setSignDays(List<Date> list) {
        this.signDays = list;
    }

    public void setTotalDays(int i) {
        this.totalDays = i;
    }

    public void setUserId(String str) {
        this.userId = str;
    }
}
