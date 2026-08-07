package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.a;

/* JADX INFO: loaded from: classes.dex */
public abstract class ri implements z43 {
    protected abstract Bitmap transform(oi oiVar, Bitmap bitmap, int i, int i2);

    @Override // defpackage.z43
    public final qg2 transform(Context context, qg2 qg2Var, int i, int i2) {
        if (!na3.s(i, i2)) {
            throw new IllegalArgumentException("Cannot apply transformation on width: " + i + " or height: " + i2 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
        }
        oi oiVarF = a.c(context).f();
        Bitmap bitmap = (Bitmap) qg2Var.get();
        if (i == Integer.MIN_VALUE) {
            i = bitmap.getWidth();
        }
        if (i2 == Integer.MIN_VALUE) {
            i2 = bitmap.getHeight();
        }
        Bitmap bitmapTransform = transform(oiVarF, bitmap, i, i2);
        return bitmap.equals(bitmapTransform) ? qg2Var : qi.d(bitmapTransform, oiVarF);
    }
}
