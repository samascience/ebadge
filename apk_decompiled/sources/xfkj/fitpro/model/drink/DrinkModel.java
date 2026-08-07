package xfkj.fitpro.model.drink;

import defpackage.e33;
import java.util.Date;

/* JADX INFO: loaded from: classes4.dex */
public class DrinkModel {
    Date date;
    int drinkType;
    Long id;
    boolean isPresets;
    String key;
    Date localDate;
    int ml;

    public DrinkModel(Date date, int i, String str) {
        this.isPresets = false;
        this.localDate = e33.e();
        this.date = date;
        this.ml = i;
        this.key = str;
    }

    public Date getDate() {
        return this.date;
    }

    public int getDrinkType() {
        return this.drinkType;
    }

    public Long getId() {
        return this.id;
    }

    public boolean getIsPresets() {
        return this.isPresets;
    }

    public String getKey() {
        return this.key;
    }

    public Date getLocalDate() {
        return this.localDate;
    }

    public int getMl() {
        return this.ml;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDrinkType(int i) {
        this.drinkType = i;
    }

    public void setId(Long l) {
        this.id = l;
    }

    public void setIsPresets(boolean z) {
        this.isPresets = z;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setLocalDate(Date date) {
        this.localDate = date;
    }

    public void setMl(int i) {
        this.ml = i;
    }

    public String toString() {
        return "DrinkModel{date=" + this.date + ", ml=" + this.ml + ", key='" + this.key + "'}";
    }

    public DrinkModel(Long l, Date date, int i, String str, int i2, boolean z, Date date2) {
        this.isPresets = false;
        e33.e();
        this.id = l;
        this.date = date;
        this.ml = i;
        this.key = str;
        this.drinkType = i2;
        this.isPresets = z;
        this.localDate = date2;
    }

    public DrinkModel() {
        this.isPresets = false;
        this.localDate = e33.e();
    }
}
