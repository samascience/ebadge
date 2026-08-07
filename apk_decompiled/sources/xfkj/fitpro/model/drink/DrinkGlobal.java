package xfkj.fitpro.model.drink;

/* JADX INFO: loaded from: classes4.dex */
public class DrinkGlobal {
    Long id;
    int targetMl;
    String yyyyMMdd;

    public DrinkGlobal(Long l, String str, int i) {
        this.id = l;
        this.yyyyMMdd = str;
        this.targetMl = i;
    }

    public Long getId() {
        return this.id;
    }

    public int getTargetMl() {
        return this.targetMl;
    }

    public String getYyyyMMdd() {
        return this.yyyyMMdd;
    }

    public void setId(Long l) {
        this.id = l;
    }

    public void setTargetMl(int i) {
        this.targetMl = i;
    }

    public void setYyyyMMdd(String str) {
        this.yyyyMMdd = str;
    }

    public DrinkGlobal() {
    }
}
