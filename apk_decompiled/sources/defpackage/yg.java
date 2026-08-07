package defpackage;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class yg implements tg.a, f91, wd0 {
    private final je1 e;
    private final com.airbnb.lottie.model.layer.a f;
    private final float[] h;
    final Paint i;
    private final tg j;
    private final tg k;
    private final List l;
    private final tg m;
    private tg n;
    private final PathMeasure a = new PathMeasure();
    private final Path b = new Path();
    private final Path c = new Path();
    private final RectF d = new RectF();
    private final List g = new ArrayList();

    private static final class b {
        private final List a;
        private final b63 b;

        private b(b63 b63Var) {
            this.a = new ArrayList();
            this.b = b63Var;
        }
    }

    yg(je1 je1Var, com.airbnb.lottie.model.layer.a aVar, Paint.Cap cap, Paint.Join join, float f, i6 i6Var, g6 g6Var, List list, g6 g6Var2) {
        Paint paint = new Paint(1);
        this.i = paint;
        this.e = je1Var;
        this.f = aVar;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(cap);
        paint.setStrokeJoin(join);
        paint.setStrokeMiter(f);
        this.k = i6Var.a();
        this.j = g6Var.a();
        if (g6Var2 == null) {
            this.m = null;
        } else {
            this.m = g6Var2.a();
        }
        this.l = new ArrayList(list.size());
        this.h = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.l.add(((g6) list.get(i)).a());
        }
        aVar.i(this.k);
        aVar.i(this.j);
        for (int i2 = 0; i2 < this.l.size(); i2++) {
            aVar.i((tg) this.l.get(i2));
        }
        tg tgVar = this.m;
        if (tgVar != null) {
            aVar.i(tgVar);
        }
        this.k.a(this);
        this.j.a(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            ((tg) this.l.get(i3)).a(this);
        }
        tg tgVar2 = this.m;
        if (tgVar2 != null) {
            tgVar2.a(this);
        }
    }

    private void e(Matrix matrix) {
        o91.a("StrokeContent#applyDashPattern");
        if (this.l.isEmpty()) {
            o91.c("StrokeContent#applyDashPattern");
            return;
        }
        float f = ya3.f(matrix);
        for (int i = 0; i < this.l.size(); i++) {
            this.h[i] = ((Float) ((tg) this.l.get(i)).h()).floatValue();
            if (i % 2 == 0) {
                float[] fArr = this.h;
                if (fArr[i] < 1.0f) {
                    fArr[i] = 1.0f;
                }
            } else {
                float[] fArr2 = this.h;
                if (fArr2[i] < 0.1f) {
                    fArr2[i] = 0.1f;
                }
            }
            float[] fArr3 = this.h;
            fArr3[i] = fArr3[i] * f;
        }
        tg tgVar = this.m;
        this.i.setPathEffect(new DashPathEffect(this.h, tgVar == null ? 0.0f : ((Float) tgVar.h()).floatValue()));
        o91.c("StrokeContent#applyDashPattern");
    }

    /* JADX WARN: Code duplicated, block: B:26:0x00f6  */
    private void i(Canvas canvas, b bVar, Matrix matrix) {
        float f;
        o91.a("StrokeContent#applyTrimPath");
        if (bVar.b == null) {
            o91.c("StrokeContent#applyTrimPath");
            return;
        }
        this.b.reset();
        for (int size = bVar.a.size() - 1; size >= 0; size--) {
            this.b.addPath(((iz1) bVar.a.get(size)).c(), matrix);
        }
        this.a.setPath(this.b, false);
        float length = this.a.getLength();
        while (this.a.nextContour()) {
            length += this.a.getLength();
        }
        float fFloatValue = (((Float) bVar.b.g().h()).floatValue() * length) / 360.0f;
        float fFloatValue2 = ((((Float) bVar.b.i().h()).floatValue() * length) / 100.0f) + fFloatValue;
        float fFloatValue3 = ((((Float) bVar.b.f().h()).floatValue() * length) / 100.0f) + fFloatValue;
        float f2 = 0.0f;
        for (int size2 = bVar.a.size() - 1; size2 >= 0; size2--) {
            this.c.set(((iz1) bVar.a.get(size2)).c());
            this.c.transform(matrix);
            this.a.setPath(this.c, false);
            float length2 = this.a.getLength();
            if (fFloatValue3 > length) {
                float f3 = fFloatValue3 - length;
                if (f3 >= f2 + length2 || f2 >= f3) {
                    f = f2 + length2;
                    if (f < fFloatValue2 && f2 <= fFloatValue3) {
                        if (f > fFloatValue3 || fFloatValue2 >= f2) {
                            ya3.a(this.c, fFloatValue2 < f2 ? 0.0f : (fFloatValue2 - f2) / length2, fFloatValue3 <= f ? (fFloatValue3 - f2) / length2 : 1.0f, 0.0f);
                            canvas.drawPath(this.c, this.i);
                        } else {
                            canvas.drawPath(this.c, this.i);
                        }
                    }
                } else {
                    ya3.a(this.c, fFloatValue2 > length ? (fFloatValue2 - length) / length2 : 0.0f, Math.min(f3 / length2, 1.0f), 0.0f);
                    canvas.drawPath(this.c, this.i);
                }
            } else {
                f = f2 + length2;
                if (f < fFloatValue2) {
                }
            }
            f2 += length2;
        }
        o91.c("StrokeContent#applyTrimPath");
    }

    @Override // tg.a
    public void a() {
        this.e.invalidateSelf();
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0055  */
    /* JADX WARN: Code duplicated, block: B:23:0x0059 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:24:0x005b  */
    /* JADX WARN: Code duplicated, block: B:37:0x0069 A[SYNTHETIC] */
    @Override // defpackage.s20
    public void b(List list, List list2) {
        b63 b63Var = null;
        for (int size = list.size() - 1; size >= 0; size--) {
            s20 s20Var = (s20) list.get(size);
            if (s20Var instanceof b63) {
                b63 b63Var2 = (b63) s20Var;
                if (b63Var2.j() == ShapeTrimPath.Type.Individually) {
                    b63Var = b63Var2;
                }
            }
        }
        if (b63Var != null) {
            b63Var.e(this);
        }
        b bVar = null;
        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
            s20 s20Var2 = (s20) list2.get(size2);
            if (s20Var2 instanceof b63) {
                b63 b63Var3 = (b63) s20Var2;
                if (b63Var3.j() == ShapeTrimPath.Type.Individually) {
                    if (bVar != null) {
                        this.g.add(bVar);
                    }
                    bVar = new b(b63Var3);
                    b63Var3.e(this);
                } else if (!(s20Var2 instanceof iz1)) {
                    if (bVar == null) {
                        bVar = new b(b63Var);
                    }
                    bVar.a.add((iz1) s20Var2);
                }
            } else if (!(s20Var2 instanceof iz1)) {
                if (bVar == null) {
                    bVar = new b(b63Var);
                }
                bVar.a.add((iz1) s20Var2);
            }
        }
        if (bVar != null) {
            this.g.add(bVar);
        }
    }

    @Override // defpackage.wd0
    public void d(RectF rectF, Matrix matrix) {
        o91.a("StrokeContent#getBounds");
        this.b.reset();
        for (int i = 0; i < this.g.size(); i++) {
            b bVar = (b) this.g.get(i);
            for (int i2 = 0; i2 < bVar.a.size(); i2++) {
                this.b.addPath(((iz1) bVar.a.get(i2)).c(), matrix);
            }
        }
        this.b.computeBounds(this.d, false);
        float fFloatValue = ((Float) this.j.h()).floatValue();
        RectF rectF2 = this.d;
        float f = fFloatValue / 2.0f;
        rectF2.set(rectF2.left - f, rectF2.top - f, rectF2.right + f, rectF2.bottom + f);
        rectF.set(this.d);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        o91.c("StrokeContent#getBounds");
    }

    public void f(Object obj, re1 re1Var) {
        if (obj == ne1.d) {
            this.k.m(re1Var);
            return;
        }
        if (obj == ne1.k) {
            this.j.m(re1Var);
            return;
        }
        if (obj == ne1.x) {
            if (re1Var == null) {
                this.n = null;
                return;
            }
            bb3 bb3Var = new bb3(re1Var);
            this.n = bb3Var;
            bb3Var.a(this);
            this.f.i(this.n);
        }
    }

    @Override // defpackage.e91
    public void g(d91 d91Var, int i, List list, d91 d91Var2) {
        ok1.l(d91Var, i, list, d91Var2, this);
    }

    public void h(Canvas canvas, Matrix matrix, int i) {
        o91.a("StrokeContent#draw");
        this.i.setAlpha(ok1.c((int) ((((i / 255.0f) * ((Integer) this.k.h()).intValue()) / 100.0f) * 255.0f), 0, 255));
        this.i.setStrokeWidth(((Float) this.j.h()).floatValue() * ya3.f(matrix));
        if (this.i.getStrokeWidth() <= 0.0f) {
            o91.c("StrokeContent#draw");
            return;
        }
        e(matrix);
        tg tgVar = this.n;
        if (tgVar != null) {
            this.i.setColorFilter((ColorFilter) tgVar.h());
        }
        for (int i2 = 0; i2 < this.g.size(); i2++) {
            b bVar = (b) this.g.get(i2);
            if (bVar.b != null) {
                i(canvas, bVar, matrix);
            } else {
                o91.a("StrokeContent#buildPath");
                this.b.reset();
                for (int size = bVar.a.size() - 1; size >= 0; size--) {
                    this.b.addPath(((iz1) bVar.a.get(size)).c(), matrix);
                }
                o91.c("StrokeContent#buildPath");
                o91.a("StrokeContent#drawPath");
                canvas.drawPath(this.b, this.i);
                o91.c("StrokeContent#drawPath");
            }
        }
        o91.c("StrokeContent#draw");
    }
}
