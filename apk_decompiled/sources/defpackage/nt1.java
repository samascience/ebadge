package defpackage;

import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public final class nt1 implements w81 {
    private final Object b;

    public nt1(Object obj) {
        this.b = z42.d(obj);
    }

    @Override // defpackage.w81
    public boolean equals(Object obj) {
        if (obj instanceof nt1) {
            return this.b.equals(((nt1) obj).b);
        }
        return false;
    }

    @Override // defpackage.w81
    public int hashCode() {
        return this.b.hashCode();
    }

    public String toString() {
        return "ObjectKey{object=" + this.b + '}';
    }

    @Override // defpackage.w81
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(this.b.toString().getBytes(w81.a));
    }
}
