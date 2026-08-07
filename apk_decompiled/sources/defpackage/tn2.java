package defpackage;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes3.dex */
public class tn2 {
    private final co2[] a = new co2[4];
    private final Matrix[] b = new Matrix[4];
    private final Matrix[] c = new Matrix[4];
    private final PointF d = new PointF();
    private final Path e = new Path();
    private final Path f = new Path();
    private final co2 g = new co2();
    private final float[] h = new float[2];
    private final float[] i = new float[2];
    private final Path j = new Path();
    private final Path k = new Path();
    private boolean l = true;

    private static class a {
        static final tn2 a = new tn2();
    }

    public interface b {
        void a(co2 co2Var, Matrix matrix, int i);

        void b(co2 co2Var, Matrix matrix, int i);
    }

    static final class c {
        public final sn2 a;
        public final Path b;
        public final RectF c;
        public final b d;
        public final float e;

        c(sn2 sn2Var, float f, RectF rectF, b bVar, Path path) {
            this.d = bVar;
            this.a = sn2Var;
            this.e = f;
            this.c = rectF;
            this.b = path;
        }
    }

    public tn2() {
        for (int i = 0; i < 4; i++) {
            this.a[i] = new co2();
            this.b[i] = new Matrix();
            this.c[i] = new Matrix();
        }
    }

    private float a(int i) {
        return ((i + 1) % 4) * 90;
    }

    private void b(c cVar, int i) {
        this.h[0] = this.a[i].k();
        this.h[1] = this.a[i].l();
        this.b[i].mapPoints(this.h);
        if (i == 0) {
            Path path = cVar.b;
            float[] fArr = this.h;
            path.moveTo(fArr[0], fArr[1]);
        } else {
            Path path2 = cVar.b;
            float[] fArr2 = this.h;
            path2.lineTo(fArr2[0], fArr2[1]);
        }
        this.a[i].d(this.b[i], cVar.b);
        b bVar = cVar.d;
        if (bVar != null) {
            bVar.b(this.a[i], this.b[i], i);
        }
    }

    private void c(c cVar, int i) {
        int i2 = (i + 1) % 4;
        this.h[0] = this.a[i].i();
        this.h[1] = this.a[i].j();
        this.b[i].mapPoints(this.h);
        this.i[0] = this.a[i2].k();
        this.i[1] = this.a[i2].l();
        this.b[i2].mapPoints(this.i);
        float[] fArr = this.h;
        float f = fArr[0];
        float[] fArr2 = this.i;
        float fMax = Math.max(((float) Math.hypot(f - fArr2[0], fArr[1] - fArr2[1])) - 0.001f, 0.0f);
        float fI = i(cVar.c, i);
        this.g.n(0.0f, 0.0f);
        ef0 ef0VarJ = j(i, cVar.a);
        ef0VarJ.b(fMax, fI, cVar.e, this.g);
        this.j.reset();
        this.g.d(this.c[i], this.j);
        if (this.l && (ef0VarJ.a() || l(this.j, i) || l(this.j, i2))) {
            Path path = this.j;
            path.op(path, this.f, Path.Op.DIFFERENCE);
            this.h[0] = this.g.k();
            this.h[1] = this.g.l();
            this.c[i].mapPoints(this.h);
            Path path2 = this.e;
            float[] fArr3 = this.h;
            path2.moveTo(fArr3[0], fArr3[1]);
            this.g.d(this.c[i], this.e);
        } else {
            this.g.d(this.c[i], cVar.b);
        }
        b bVar = cVar.d;
        if (bVar != null) {
            bVar.a(this.g, this.c[i], i);
        }
    }

    private void f(int i, RectF rectF, PointF pointF) {
        if (i == 1) {
            pointF.set(rectF.right, rectF.bottom);
            return;
        }
        if (i == 2) {
            pointF.set(rectF.left, rectF.bottom);
        } else if (i != 3) {
            pointF.set(rectF.right, rectF.top);
        } else {
            pointF.set(rectF.left, rectF.top);
        }
    }

    private l40 g(int i, sn2 sn2Var) {
        if (i == 1) {
            return sn2Var.l();
        }
        if (i != 2) {
            return i != 3 ? sn2Var.t() : sn2Var.r();
        }
        return sn2Var.j();
    }

    private m40 h(int i, sn2 sn2Var) {
        if (i == 1) {
            return sn2Var.k();
        }
        if (i != 2) {
            return i != 3 ? sn2Var.s() : sn2Var.q();
        }
        return sn2Var.i();
    }

    private float i(RectF rectF, int i) {
        float[] fArr = this.h;
        co2 co2Var = this.a[i];
        fArr[0] = co2Var.c;
        fArr[1] = co2Var.d;
        this.b[i].mapPoints(fArr);
        return (i == 1 || i == 3) ? Math.abs(rectF.centerX() - this.h[0]) : Math.abs(rectF.centerY() - this.h[1]);
    }

    private ef0 j(int i, sn2 sn2Var) {
        if (i == 1) {
            return sn2Var.h();
        }
        if (i != 2) {
            return i != 3 ? sn2Var.o() : sn2Var.p();
        }
        return sn2Var.n();
    }

    public static tn2 k() {
        return a.a;
    }

    private boolean l(Path path, int i) {
        this.k.reset();
        this.a[i].d(this.b[i], this.k);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        this.k.computeBounds(rectF, true);
        path.op(this.k, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        if (rectF.isEmpty()) {
            return rectF.width() > 1.0f && rectF.height() > 1.0f;
        }
        return true;
    }

    private void m(c cVar, int i) {
        h(i, cVar.a).b(this.a[i], 90.0f, cVar.e, cVar.c, g(i, cVar.a));
        float fA = a(i);
        this.b[i].reset();
        f(i, cVar.c, this.d);
        Matrix matrix = this.b[i];
        PointF pointF = this.d;
        matrix.setTranslate(pointF.x, pointF.y);
        this.b[i].preRotate(fA);
    }

    private void n(int i) {
        this.h[0] = this.a[i].i();
        this.h[1] = this.a[i].j();
        this.b[i].mapPoints(this.h);
        float fA = a(i);
        this.c[i].reset();
        Matrix matrix = this.c[i];
        float[] fArr = this.h;
        matrix.setTranslate(fArr[0], fArr[1]);
        this.c[i].preRotate(fA);
    }

    public void d(sn2 sn2Var, float f, RectF rectF, b bVar, Path path) {
        path.rewind();
        this.e.rewind();
        this.f.rewind();
        this.f.addRect(rectF, Path.Direction.CW);
        c cVar = new c(sn2Var, f, rectF, bVar, path);
        for (int i = 0; i < 4; i++) {
            m(cVar, i);
            n(i);
        }
        for (int i2 = 0; i2 < 4; i2++) {
            b(cVar, i2);
            c(cVar, i2);
        }
        path.close();
        this.e.close();
        if (this.e.isEmpty()) {
            return;
        }
        path.op(this.e, Path.Op.UNION);
    }

    public void e(sn2 sn2Var, float f, RectF rectF, Path path) {
        d(sn2Var, f, rectF, null, path);
    }
}
