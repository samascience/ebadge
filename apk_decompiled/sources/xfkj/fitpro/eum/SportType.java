package xfkj.fitpro.eum;

/* JADX INFO: loaded from: classes4.dex */
public enum SportType {
    WALK(1),
    RUN(2),
    BIKE(3);

    private int type;

    SportType(int i) {
        this.type = i;
    }

    public int getType() {
        return this.type;
    }
}
