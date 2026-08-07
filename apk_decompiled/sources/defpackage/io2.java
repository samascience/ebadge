package defpackage;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public abstract class io2 {
    sn2 c;
    boolean a = false;
    boolean b = false;
    RectF d = new RectF();
    final Path e = new Path();

    public static io2 a(View view) {
        return Build.VERSION.SDK_INT >= 33 ? new ko2(view) : new jo2(view);
    }

    private boolean d() {
        RectF rectF = this.d;
        return rectF.left <= rectF.right && rectF.top <= rectF.bottom;
    }

    private void k() {
        if (!d() || this.c == null) {
            return;
        }
        tn2.k().e(this.c, 1.0f, this.d, this.e);
    }

    abstract void b(View view);

    public boolean c() {
        return this.a;
    }

    public void e(Canvas canvas, nv.a aVar) {
        if (!j() || this.e.isEmpty()) {
            aVar.a(canvas);
            return;
        }
        canvas.save();
        canvas.clipPath(this.e);
        aVar.a(canvas);
        canvas.restore();
    }

    public void f(View view, RectF rectF) {
        this.d = rectF;
        k();
        b(view);
    }

    public void g(View view, sn2 sn2Var) {
        this.c = sn2Var;
        k();
        b(view);
    }

    public void h(View view, boolean z) {
        if (z != this.a) {
            this.a = z;
            b(view);
        }
    }

    public void i(View view, boolean z) {
        this.b = z;
        b(view);
    }

    abstract boolean j();
}
