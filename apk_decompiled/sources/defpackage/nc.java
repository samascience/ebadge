package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class nc {
    private final boolean a;
    private final boolean b;

    public nc(w92 w92Var) {
        this.a = w92Var.a(sz0.class);
        this.b = xa0.a(u40.class) != null;
    }

    public int a(int i) {
        if ((this.a || this.b) && i == 2) {
            return 1;
        }
        return i;
    }
}
