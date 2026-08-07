package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public final class f0 {
    private final int a;
    private final int b;

    public f0(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f0)) {
            return false;
        }
        f0 f0Var = (f0) obj;
        return this.a == f0Var.a && this.b == f0Var.b;
    }

    public int hashCode() {
        return (Integer.hashCode(this.a) * 31) + Integer.hashCode(this.b);
    }

    public String toString() {
        return "AIGlassesWanDeleteFailureInfo(failureReason=" + this.a + ", wifiId=" + this.b + ")";
    }
}
