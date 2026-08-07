package androidx.camera.view;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.util.Size;
import defpackage.t23;
import defpackage.uj1;

/* JADX INFO: loaded from: classes.dex */
class j extends uj1 {
    static final PointF d = new PointF(2.0f, 2.0f);
    private final e b;
    private Matrix c;

    j(e eVar) {
        this.b = eVar;
    }

    void a(Size size, int i) {
        t23.a();
        synchronized (this) {
            try {
                if (size.getWidth() != 0 && size.getHeight() != 0) {
                    this.c = this.b.c(size, i);
                    return;
                }
                this.c = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
