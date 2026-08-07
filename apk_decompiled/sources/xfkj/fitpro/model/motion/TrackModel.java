package xfkj.fitpro.model.motion;

import defpackage.e33;
import java.util.Date;

/* JADX INFO: loaded from: classes4.dex */
public class TrackModel {
    private Date date;
    Long id;
    private Long keyId;
    private double lat;
    private double lon;

    public TrackModel(Date date, double d, double d2) {
        this.date = date;
        this.lat = d;
        this.lon = d2;
    }

    public Date getDate() {
        return this.date;
    }

    public Long getId() {
        return this.id;
    }

    public Long getKeyId() {
        return this.keyId;
    }

    public double getLat() {
        return this.lat;
    }

    public double getLon() {
        return this.lon;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setId(Long l) {
        this.id = l;
    }

    public void setKeyId(Long l) {
        this.keyId = l;
    }

    public void setLat(double d) {
        this.lat = d;
    }

    public void setLon(double d) {
        this.lon = d;
    }

    public String toString() {
        return "TrackModel{id=" + this.id + ", date=" + e33.b(this.date) + ", lat=" + this.lat + ", lon=" + this.lon + ", keyId=" + this.keyId + '}';
    }

    public TrackModel(Long l, Date date, double d, double d2, Long l2) {
        this.id = l;
        this.date = date;
        this.lat = d;
        this.lon = d2;
        this.keyId = l2;
    }

    public TrackModel() {
    }
}
