package defpackage;

import android.graphics.Bitmap;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public class pn0 extends ri {
    private static final byte[] b = "com.bumptech.glide.load.resource.bitmap.FitCenter".getBytes(w81.a);

    @Override // defpackage.w81
    public boolean equals(Object obj) {
        return obj instanceof pn0;
    }

    @Override // defpackage.w81
    public int hashCode() {
        return 1572326941;
    }

    @Override // defpackage.ri
    protected Bitmap transform(oi oiVar, Bitmap bitmap, int i, int i2) {
        return b53.e(oiVar, bitmap, i, i2);
    }

    @Override // defpackage.w81
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(b);
    }
}
