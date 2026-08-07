package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class fw0 {
    private static int b = 31;
    private int a = 1;

    public fw0 a(Object obj) {
        this.a = (b * this.a) + (obj == null ? 0 : obj.hashCode());
        return this;
    }

    public int b() {
        return this.a;
    }

    public final fw0 c(boolean z) {
        this.a = (b * this.a) + (z ? 1 : 0);
        return this;
    }
}
