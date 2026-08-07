package defpackage;

import android.content.Context;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public final class q83 implements z43 {
    private static final z43 b = new q83();

    private q83() {
    }

    public static q83 a() {
        return (q83) b;
    }

    @Override // defpackage.z43
    public qg2 transform(Context context, qg2 qg2Var, int i, int i2) {
        return qg2Var;
    }

    @Override // defpackage.w81
    public void updateDiskCacheKey(MessageDigest messageDigest) {
    }
}
