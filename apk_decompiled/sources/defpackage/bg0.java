package defpackage;

import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public final class bg0 implements w81 {
    private static final bg0 b = new bg0();

    private bg0() {
    }

    public static bg0 a() {
        return b;
    }

    public String toString() {
        return "EmptySignature";
    }

    @Override // defpackage.w81
    public void updateDiskCacheKey(MessageDigest messageDigest) {
    }
}
