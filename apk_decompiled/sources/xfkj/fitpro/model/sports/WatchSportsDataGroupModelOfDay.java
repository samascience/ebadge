package xfkj.fitpro.model.sports;

/* JADX INFO: loaded from: classes4.dex */
public class WatchSportsDataGroupModelOfDay {
    String devid;
    Long id;
    int totalDistance;
    int totalDuration;
    int totalSteps;
    int totalXiaohao;
    long userId;
    String yyyyMMdd;

    public WatchSportsDataGroupModelOfDay(Long l, long j, String str, String str2, int i, int i2, int i3, int i4) {
        this.id = l;
        this.userId = j;
        this.devid = str;
        this.yyyyMMdd = str2;
        this.totalXiaohao = i;
        this.totalDuration = i2;
        this.totalDistance = i3;
        this.totalSteps = i4;
    }

    public String getDevid() {
        return this.devid;
    }

    public Long getId() {
        return this.id;
    }

    public int getTotalDistance() {
        return this.totalDistance;
    }

    public int getTotalDuration() {
        return this.totalDuration;
    }

    public int getTotalSteps() {
        return this.totalSteps;
    }

    public int getTotalXiaohao() {
        return this.totalXiaohao;
    }

    public long getUserId() {
        return this.userId;
    }

    public String getYyyyMMdd() {
        return this.yyyyMMdd;
    }

    public void setDevid(String str) {
        this.devid = str;
    }

    public void setId(Long l) {
        this.id = l;
    }

    public void setTotalDistance(int i) {
        this.totalDistance = i;
    }

    public void setTotalDuration(int i) {
        this.totalDuration = i;
    }

    public void setTotalSteps(int i) {
        this.totalSteps = i;
    }

    public void setTotalXiaohao(int i) {
        this.totalXiaohao = i;
    }

    public void setUserId(long j) {
        this.userId = j;
    }

    public void setYyyyMMdd(String str) {
        this.yyyyMMdd = str;
    }

    public String toString() {
        return "WatchSportsDataGroupModelOfDay{id=" + this.id + ", devid='" + this.devid + "', yyyyMMdd='" + this.yyyyMMdd + "', totalXiaohao=" + this.totalXiaohao + ", totalDuration=" + this.totalDuration + ", totalDistance=" + this.totalDistance + ", totalSteps=" + this.totalSteps + '}';
    }

    public WatchSportsDataGroupModelOfDay() {
        this.userId = -1L;
    }
}
