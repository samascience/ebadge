package defpackage;

import android.graphics.Bitmap;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public class ww extends ri {
    private static final byte[] b = "com.bumptech.glide.load.resource.bitmap.CenterCrop".getBytes(w81.a);

    @Override // defpackage.w81
    public boolean equals(Object obj) {
        return obj instanceof ww;
    }

    @Override // defpackage.w81
    public int hashCode() {
        return -599754482;
    }

    @Override // defpackage.ri
    protected Bitmap transform(oi oiVar, Bitmap bitmap, int i, int i2) {
        return b53.b(oiVar, bitmap, i, i2);
    }

    @Override // defpackage.w81
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(b);
    }
}
