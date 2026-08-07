package xfkj.fitpro.model.sports;

/* JADX INFO: loaded from: classes4.dex */
public class WatchSportsDataGroupModelOfMonth {
    String devid;
    Long id;
    int totalDuration;
    int totalXiaohao;
    long userId;
    String yyyyMM;
    String yyyyMMdd;

    public WatchSportsDataGroupModelOfMonth(Long l, long j, String str, String str2, String str3, int i, int i2) {
        this.id = l;
        this.userId = j;
        this.devid = str;
        this.yyyyMM = str2;
        this.yyyyMMdd = str3;
        this.totalXiaohao = i;
        this.totalDuration = i2;
    }

    public String getDevid() {
        return this.devid;
    }

    public Long getId() {
        return this.id;
    }

    public int getTotalDuration() {
        return this.totalDuration;
    }

    public int getTotalXiaohao() {
        return this.totalXiaohao;
    }

    public long getUserId() {
        return this.userId;
    }

    public String getYyyyMM() {
        return this.yyyyMM;
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

    public void setTotalDuration(int i) {
        this.totalDuration = i;
    }

    public void setTotalXiaohao(int i) {
        this.totalXiaohao = i;
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

    public WatchSportsDataGroupModelOfMonth() {
        this.userId = -1L;
    }
}
