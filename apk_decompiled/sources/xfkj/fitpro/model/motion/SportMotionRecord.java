package xfkj.fitpro.model.motion;

import java.util.Date;

/* JADX INFO: loaded from: classes4.dex */
public class SportMotionRecord {
    private Double calorie;
    private Date date;
    private Double distance;
    private Double distribution;
    private Long duration;
    private String endPoint;
    private Long id;
    private Long mEndTime;
    private Long mStartTime;
    private int master;
    private String pathLine;
    private Double speed;
    private int sportType;
    private String str1;
    private String str2;
    private String str3;
    private String stratPoint;
    private long userId = -1;

    public Double getCalorie() {
        return this.calorie;
    }

    public Date getDate() {
        return this.date;
    }

    public Double getDistance() {
        return this.distance;
    }

    public Double getDistribution() {
        return this.distribution;
    }

    public Long getDuration() {
        return this.duration;
    }

    public String getEndPoint() {
        return this.endPoint;
    }

    public Long getEndTime() {
        return this.mEndTime;
    }

    public Long getId() {
        return this.id;
    }

    public int getMaster() {
        return this.master;
    }

    public String getPathLine() {
        return this.pathLine;
    }

    public Double getSpeed() {
        return this.speed;
    }

    public int getSportType() {
        return this.sportType;
    }

    public Long getStartTime() {
        return this.mStartTime;
    }

    public String getStr1() {
        return this.str1;
    }

    public String getStr2() {
        return this.str2;
    }

    public String getStr3() {
        return this.str3;
    }

    public String getStratPoint() {
        return this.stratPoint;
    }

    public long getUserId() {
        return this.userId;
    }

    public void setCalorie(Double d) {
        this.calorie = d;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDistance(Double d) {
        this.distance = d;
    }

    public void setDistribution(Double d) {
        this.distribution = d;
    }

    public void setDuration(Long l) {
        this.duration = l;
    }

    public void setEndPoint(String str) {
        this.endPoint = str;
    }

    public void setEndTime(Long l) {
        this.mEndTime = l;
    }

    public void setId(Long l) {
        this.id = l;
    }

    public void setMaster(int i) {
        this.master = i;
    }

    public void setPathLine(String str) {
        this.pathLine = str;
    }

    public void setSpeed(Double d) {
        this.speed = d;
    }

    public void setSportType(int i) {
        this.sportType = i;
    }

    public void setStartTime(Long l) {
        this.mStartTime = l;
    }

    public void setStr1(String str) {
        this.str1 = str;
    }

    public void setStr2(String str) {
        this.str2 = str;
    }

    public void setStr3(String str) {
        this.str3 = str;
    }

    public void setStratPoint(String str) {
        this.stratPoint = str;
    }

    public void setUserId(long j) {
        this.userId = j;
    }
}
