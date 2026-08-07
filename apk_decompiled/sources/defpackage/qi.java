package defpackage;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes.dex */
public class qi implements qg2, e21 {
    private final Bitmap a;
    private final oi b;

    public qi(Bitmap bitmap, oi oiVar) {
        this.a = (Bitmap) z42.e(bitmap, "Bitmap must not be null");
        this.b = (oi) z42.e(oiVar, "BitmapPool must not be null");
    }

    public static qi d(Bitmap bitmap, oi oiVar) {
        if (bitmap == null) {
            return null;
        }
        return new qi(bitmap, oiVar);
    }

    @Override // defpackage.qg2
    public void a() {
        this.b.c(this.a);
    }

    @Override // defpackage.e21
    public void b() {
        this.a.prepareToDraw();
    }

    @Override // defpackage.qg2
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Bitmap get() {
        return this.a;
    }

    @Override // defpackage.qg2
    public int o() {
        return na3.g(this.a);
    }

    @Override // defpackage.qg2
    public Class p() {
        return Bitmap.class;
    }
}
