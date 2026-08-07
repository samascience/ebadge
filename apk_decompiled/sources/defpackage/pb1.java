package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class pb1 {
    private final Object a;
    private pb1 b;

    public pb1(Object obj, pb1 pb1Var) {
        this.a = obj;
        this.b = pb1Var;
    }

    public static boolean a(pb1 pb1Var, Object obj) {
        while (pb1Var != null) {
            if (pb1Var.d() == obj) {
                return true;
            }
            pb1Var = pb1Var.c();
        }
        return false;
    }

    public void b(pb1 pb1Var) {
        if (this.b != null) {
            throw new IllegalStateException();
        }
        this.b = pb1Var;
    }

    public pb1 c() {
        return this.b;
    }

    public Object d() {
        return this.a;
    }
}
