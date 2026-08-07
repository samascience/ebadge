package defpackage;

import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public final class rx1 implements w81 {
    private final u9 b = new xp();

    private static void d(px1 px1Var, Object obj, MessageDigest messageDigest) {
        px1Var.g(obj, messageDigest);
    }

    public Object a(px1 px1Var) {
        return this.b.containsKey(px1Var) ? this.b.get(px1Var) : px1Var.c();
    }

    public void b(rx1 rx1Var) {
        this.b.i(rx1Var.b);
    }

    public rx1 c(px1 px1Var, Object obj) {
        this.b.put(px1Var, obj);
        return this;
    }

    @Override // defpackage.w81
    public boolean equals(Object obj) {
        if (obj instanceof rx1) {
            return this.b.equals(((rx1) obj).b);
        }
        return false;
    }

    @Override // defpackage.w81
    public int hashCode() {
        return this.b.hashCode();
    }

    public String toString() {
        return "Options{values=" + this.b + '}';
    }

    @Override // defpackage.w81
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        for (int i = 0; i < this.b.size(); i++) {
            d((px1) this.b.h(i), this.b.l(i), messageDigest);
        }
    }
}
