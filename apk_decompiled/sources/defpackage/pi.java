package defpackage;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes.dex */
public class pi implements oi {
    @Override // defpackage.oi
    public void a(int i) {
    }

    @Override // defpackage.oi
    public void b() {
    }

    @Override // defpackage.oi
    public void c(Bitmap bitmap) {
        bitmap.recycle();
    }

    @Override // defpackage.oi
    public Bitmap d(int i, int i2, Bitmap.Config config) {
        return Bitmap.createBitmap(i, i2, config);
    }

    @Override // defpackage.oi
    public Bitmap e(int i, int i2, Bitmap.Config config) {
        return d(i, i2, config);
    }
}
