package defpackage;

/* JADX INFO: loaded from: classes4.dex */
final class zy2 extends ni2 {
    private final ni2 a;
    private final Object b;

    zy2(ni2 ni2Var, Object obj) {
        this.a = ni2Var;
        this.b = obj;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zy2) {
            return this.a.equals(((zy2) obj).a);
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return this.a.toString() + " (with synchronization wrapper)";
    }
}
