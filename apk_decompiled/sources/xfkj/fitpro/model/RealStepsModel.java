package xfkj.fitpro.model;

/* JADX INFO: loaded from: classes4.dex */
public class RealStepsModel {
    private int calory;
    private int date;
    private int distance;
    private int step;
    private String userId;

    public int getCalory() {
        return this.calory;
    }

    public int getDate() {
        return this.date;
    }

    public int getDistance() {
        return this.distance;
    }

    public int getStep() {
        return this.step;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setCalory(int i) {
        this.calory = i;
    }

    public void setDate(int i) {
        this.date = i;
    }

    public void setDistance(int i) {
        this.distance = i;
    }

    public void setStep(int i) {
        this.step = i;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public String toString() {
        return "RealStepsModel{userId='" + this.userId + "', date=" + this.date + ", step=" + this.step + ", calory=" + this.calory + ", distance=" + this.distance + '}';
    }
}
