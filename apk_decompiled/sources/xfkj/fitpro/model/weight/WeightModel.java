package xfkj.fitpro.model.weight;

import defpackage.e33;
import java.util.Date;

/* JADX INFO: loaded from: classes4.dex */
public class WeightModel {
    Date date;
    private Long id;
    long key;
    float weight;

    public WeightModel(Long l, long j, Date date, float f) {
        this.id = l;
        this.key = j;
        this.date = date;
        this.weight = f;
    }

    public Date getDate() {
        return this.date;
    }

    public Long getId() {
        return this.id;
    }

    public long getKey() {
        return this.key;
    }

    public float getWeight() {
        return this.weight;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setId(Long l) {
        this.id = l;
    }

    public void setKey(long j) {
        this.key = j;
    }

    public void setWeight(float f) {
        this.weight = f;
    }

    public String toString() {
        return "WeightModel{id=" + this.id + ", key=" + this.key + ", date=" + e33.b(this.date) + ", weight=" + this.weight + '}';
    }

    public WeightModel() {
    }
}
