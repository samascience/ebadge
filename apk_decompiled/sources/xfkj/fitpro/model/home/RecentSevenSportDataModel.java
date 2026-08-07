package xfkj.fitpro.model.home;

/* JADX INFO: loaded from: classes4.dex */
public class RecentSevenSportDataModel extends BaseSportsModel {
    int avgHeart;
    int kcal;
    int sleepTime;
    int spo;
    int steps;
    int totalDuration;
    int totalKcal;
    int totalTimes;

    public int getAvgHeart() {
        return this.avgHeart;
    }

    @Override // xfkj.fitpro.model.home.BaseSportsModel
    public int getItemType() {
        return BaseSportsModel.RECENT_RECORD_TYPE_SEVEN;
    }

    public int getKcal() {
        return this.kcal;
    }

    public int getSleepTime() {
        return this.sleepTime;
    }

    public int getSpo() {
        return this.spo;
    }

    public int getSteps() {
        return this.steps;
    }

    public int getTotalDuration() {
        return this.totalDuration;
    }

    public int getTotalKcal() {
        return this.totalKcal;
    }

    public int getTotalTimes() {
        return this.totalTimes;
    }

    public void setAvgHeart(int i) {
        this.avgHeart = i;
    }

    public void setKcal(int i) {
        this.kcal = i;
    }

    public void setSleepTime(int i) {
        this.sleepTime = i;
    }

    public void setSpo(int i) {
        this.spo = i;
    }

    public void setSteps(int i) {
        this.steps = i;
    }

    public void setTotalDuration(int i) {
        this.totalDuration = i;
    }

    public void setTotalKcal(int i) {
        this.totalKcal = i;
    }

    public void setTotalTimes(int i) {
        this.totalTimes = i;
    }

    public String toString() {
        return "RecentSevenSportDataModel{totalKcal=" + this.totalKcal + ", totalDuration=" + this.totalDuration + ", totalTimes=" + this.totalTimes + ", steps=" + this.steps + ", kcal=" + this.kcal + ", avgHeart=" + this.avgHeart + ", sleepTime=" + this.sleepTime + ", spo=" + this.spo + '}';
    }
}
