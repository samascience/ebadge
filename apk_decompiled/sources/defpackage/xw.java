package defpackage;

import android.graphics.Bitmap;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public class xw extends ri {
    private static final byte[] b = "com.bumptech.glide.load.resource.bitmap.CenterInside".getBytes(w81.a);

    @Override // defpackage.w81
    public boolean equals(Object obj) {
        return obj instanceof xw;
    }

    @Override // defpackage.w81
    public int hashCode() {
        return -670243078;
    }

    @Override // defpackage.ri
    protected Bitmap transform(oi oiVar, Bitmap bitmap, int i, int i2) {
        return b53.c(oiVar, bitmap, i, i2);
    }

    @Override // defpackage.w81
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(b);
    }
}
