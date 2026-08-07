package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class ly1 {
    private final boolean a;
    private boolean b = false;

    public ly1(w92 w92Var) {
        this.a = w92Var.b(oc.class) != null;
    }

    public void a() {
        this.b = false;
    }

    public void b() {
        this.b = true;
    }

    public boolean c(int i) {
        return this.b && i == 0 && this.a;
    }
}
