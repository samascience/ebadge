package xfkj.fitpro.model.sportDetails;

/* JADX INFO: loaded from: classes4.dex */
public class SportDetialsGroup {
    String dateStr;
    String devid;
    Long id;
    boolean isUpload;
    int totalCalory;
    int totalDistance;
    int totalStep;
    long userId;

    public SportDetialsGroup(long j, boolean z, int i, int i2, int i3, String str, String str2) {
        this.userId = j;
        this.isUpload = z;
        this.totalCalory = i;
        this.totalStep = i2;
        this.totalDistance = i3;
        this.devid = str;
        this.dateStr = str2;
    }

    public String getDateStr() {
        return this.dateStr;
    }

    public String getDevid() {
        return this.devid;
    }

    public Long getId() {
        return this.id;
    }

    public boolean getIsUpload() {
        return this.isUpload;
    }

    public int getTotalCalory() {
        return this.totalCalory;
    }

    public int getTotalDistance() {
        return this.totalDistance;
    }

    public int getTotalStep() {
        return this.totalStep;
    }

    public long getUserId() {
        return this.userId;
    }

    public void setDateStr(String str) {
        this.dateStr = str;
    }

    public void setDevid(String str) {
        this.devid = str;
    }

    public void setId(Long l) {
        this.id = l;
    }

    public void setIsUpload(boolean z) {
        this.isUpload = z;
    }

    public void setTotalCalory(int i) {
        this.totalCalory = i;
    }

    public void setTotalDistance(int i) {
        this.totalDistance = i;
    }

    public void setTotalStep(int i) {
        this.totalStep = i;
    }

    public void setUserId(long j) {
        this.userId = j;
    }

    public String toString() {
        return "SportDetialsGroup{id=" + this.id + ", userId=" + this.userId + ", isUpload=" + this.isUpload + ", totalCalory=" + this.totalCalory + ", totalStep=" + this.totalStep + ", totalDistance=" + this.totalDistance + ", devid='" + this.devid + "', dateStr='" + this.dateStr + "'}";
    }

    public SportDetialsGroup(Long l, long j, boolean z, int i, int i2, int i3, String str, String str2) {
        this.id = l;
        this.userId = j;
        this.isUpload = z;
        this.totalCalory = i;
        this.totalStep = i2;
        this.totalDistance = i3;
        this.devid = str;
        this.dateStr = str2;
    }

    public SportDetialsGroup() {
        this.userId = -1L;
        this.isUpload = false;
    }
}
