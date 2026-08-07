package androidx.camera.view;

import android.graphics.Bitmap;
import android.util.Size;
import android.view.View;
import android.widget.FrameLayout;
import androidx.camera.core.SurfaceRequest;
import defpackage.ub1;

/* JADX INFO: loaded from: classes.dex */
abstract class i {
    Size a;
    FrameLayout b;
    private final e c;
    private boolean d = false;

    interface a {
        void a();
    }

    i(FrameLayout frameLayout, e eVar) {
        this.b = frameLayout;
        this.c = eVar;
    }

    Bitmap a() {
        Bitmap bitmapC = c();
        if (bitmapC == null) {
            return null;
        }
        return this.c.a(bitmapC, new Size(this.b.getWidth(), this.b.getHeight()), this.b.getLayoutDirection());
    }

    abstract View b();

    abstract Bitmap c();

    abstract void d();

    abstract void e();

    void f() {
        this.d = true;
        h();
    }

    abstract void g(SurfaceRequest surfaceRequest, a aVar);

    void h() {
        View viewB = b();
        if (viewB == null || !this.d) {
            return;
        }
        this.c.s(new Size(this.b.getWidth(), this.b.getHeight()), this.b.getLayoutDirection(), viewB);
    }

    abstract ub1 i();
}
