package xfkj.fitpro.model;

/* JADX INFO: loaded from: classes4.dex */
public class Gps {
    Long id;
    private double mLatitude;
    private double mLongitude;

    public Gps(double d, double d2) {
        setLatitude(d2);
        setLongitude(d);
    }

    public Long getId() {
        return this.id;
    }

    public double getLatitude() {
        return this.mLatitude;
    }

    public double getLongitude() {
        return this.mLongitude;
    }

    public double getMLatitude() {
        return this.mLatitude;
    }

    public double getMLongitude() {
        return this.mLongitude;
    }

    public void setId(Long l) {
        this.id = l;
    }

    public void setLatitude(double d) {
        this.mLatitude = d;
    }

    public void setLongitude(double d) {
        this.mLongitude = d;
    }

    public void setMLatitude(double d) {
        this.mLatitude = d;
    }

    public void setMLongitude(double d) {
        this.mLongitude = d;
    }

    public String toString() {
        return "Gps{mLatitude=" + this.mLatitude + ", mLongitude=" + this.mLongitude + '}';
    }

    public Gps(Long l, double d, double d2) {
        this.id = l;
        this.mLatitude = d;
        this.mLongitude = d2;
    }

    public Gps() {
    }
}
