package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class vw0 {
    protected final boolean a;
    protected final og2 b;
    protected final int c;

    public vw0(og2 og2Var, boolean z, int i) {
        this.b = og2Var;
        this.a = z;
        this.c = i;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != vw0.class) {
            return false;
        }
        return this.b.equals(((vw0) obj).b);
    }

    public int hashCode() {
        return this.b.hashCode();
    }

    public String toString() {
        return this.b.toString();
    }
}
