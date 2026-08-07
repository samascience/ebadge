package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import com.airbnb.lottie.model.content.Mask;
import defpackage.d91;
import defpackage.e91;
import defpackage.fe1;
import defpackage.je1;
import defpackage.o91;
import defpackage.re1;
import defpackage.tg;
import defpackage.wd0;
import defpackage.x43;
import defpackage.xf1;
import defpackage.yn0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements wd0, tg.a, e91 {
    private final Path a = new Path();
    private final Matrix b = new Matrix();
    private final Paint c = new Paint(1);
    private final Paint d;
    private final Paint e;
    private final Paint f;
    private final Paint g;
    private final RectF h;
    private final RectF i;
    private final RectF j;
    private final RectF k;
    private final String l;
    final Matrix m;
    final je1 n;
    final Layer o;
    private xf1 p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private a f210q;
    private a r;
    private List s;
    private final List t;
    final x43 u;
    private boolean v;

    /* JADX INFO: renamed from: com.airbnb.lottie.model.layer.a$a, reason: collision with other inner class name */
    class C0050a implements tg.a {
        final /* synthetic */ yn0 a;

        C0050a(yn0 yn0Var) {
            this.a = yn0Var;
        }

        @Override // tg.a
        public void a() {
            a.this.B(((Float) this.a.h()).floatValue() == 1.0f);
        }
    }

    static /* synthetic */ class b {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[Mask.MaskMode.values().length];
            b = iArr;
            try {
                iArr[Mask.MaskMode.MaskModeSubtract.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[Mask.MaskMode.MaskModeIntersect.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[Mask.MaskMode.MaskModeAdd.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[Layer.LayerType.values().length];
            a = iArr2;
            try {
                iArr2[Layer.LayerType.Shape.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[Layer.LayerType.PreComp.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[Layer.LayerType.Solid.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[Layer.LayerType.Image.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[Layer.LayerType.Null.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[Layer.LayerType.Text.ordinal()] = 6;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[Layer.LayerType.Unknown.ordinal()] = 7;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    a(je1 je1Var, Layer layer) {
        Paint paint = new Paint(1);
        this.d = paint;
        Paint paint2 = new Paint(1);
        this.e = paint2;
        Paint paint3 = new Paint(1);
        this.f = paint3;
        Paint paint4 = new Paint();
        this.g = paint4;
        this.h = new RectF();
        this.i = new RectF();
        this.j = new RectF();
        this.k = new RectF();
        this.m = new Matrix();
        this.t = new ArrayList();
        this.v = true;
        this.n = je1Var;
        this.o = layer;
        this.l = layer.g() + "#draw";
        paint4.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        PorterDuff.Mode mode = PorterDuff.Mode.DST_IN;
        paint.setXfermode(new PorterDuffXfermode(mode));
        PorterDuff.Mode mode2 = PorterDuff.Mode.DST_OUT;
        paint2.setXfermode(new PorterDuffXfermode(mode2));
        if (layer.f() == Layer.MatteType.Invert) {
            paint3.setXfermode(new PorterDuffXfermode(mode2));
        } else {
            paint3.setXfermode(new PorterDuffXfermode(mode));
        }
        x43 x43VarB = layer.u().b();
        this.u = x43VarB;
        x43VarB.b(this);
        if (layer.e() != null && !layer.e().isEmpty()) {
            xf1 xf1Var = new xf1(layer.e());
            this.p = xf1Var;
            Iterator it = xf1Var.a().iterator();
            while (it.hasNext()) {
                ((tg) it.next()).a(this);
            }
            for (tg tgVar : this.p.c()) {
                i(tgVar);
                tgVar.a(this);
            }
        }
        C();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(boolean z) {
        if (z != this.v) {
            this.v = z;
            u();
        }
    }

    private void C() {
        if (this.o.c().isEmpty()) {
            B(true);
            return;
        }
        yn0 yn0Var = new yn0(this.o.c());
        yn0Var.k();
        yn0Var.a(new C0050a(yn0Var));
        B(((Float) yn0Var.h()).floatValue() == 1.0f);
        i(yn0Var);
    }

    private void j(Canvas canvas, Matrix matrix) {
        k(canvas, matrix, Mask.MaskMode.MaskModeAdd);
        k(canvas, matrix, Mask.MaskMode.MaskModeIntersect);
        k(canvas, matrix, Mask.MaskMode.MaskModeSubtract);
    }

    private void k(Canvas canvas, Matrix matrix, Mask.MaskMode maskMode) {
        Paint paint = b.b[maskMode.ordinal()] != 1 ? this.d : this.e;
        int size = this.p.b().size();
        for (int i = 0; i < size; i++) {
            if (((Mask) this.p.b().get(i)).a() == maskMode) {
                o91.a("Layer#drawMask");
                o91.a("Layer#saveLayer");
                x(canvas, this.h, paint, false);
                o91.c("Layer#saveLayer");
                m(canvas);
                for (int i2 = 0; i2 < size; i2++) {
                    if (((Mask) this.p.b().get(i2)).a() == maskMode) {
                        this.a.set((Path) ((tg) this.p.a().get(i2)).h());
                        this.a.transform(matrix);
                        tg tgVar = (tg) this.p.c().get(i2);
                        int alpha = this.c.getAlpha();
                        this.c.setAlpha((int) (((Integer) tgVar.h()).intValue() * 2.55f));
                        canvas.drawPath(this.a, this.c);
                        this.c.setAlpha(alpha);
                    }
                }
                o91.a("Layer#restoreLayer");
                canvas.restore();
                o91.c("Layer#restoreLayer");
                o91.c("Layer#drawMask");
                return;
            }
        }
    }

    private void l() {
        if (this.s != null) {
            return;
        }
        if (this.r == null) {
            this.s = Collections.emptyList();
            return;
        }
        this.s = new ArrayList();
        for (a aVar = this.r; aVar != null; aVar = aVar.r) {
            this.s.add(aVar);
        }
    }

    private void m(Canvas canvas) {
        o91.a("Layer#clearLayer");
        RectF rectF = this.h;
        canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f, this.g);
        o91.c("Layer#clearLayer");
    }

    static a o(Layer layer, je1 je1Var, fe1 fe1Var) {
        switch (b.a[layer.d().ordinal()]) {
            case 1:
                return new e(je1Var, layer);
            case 2:
                return new com.airbnb.lottie.model.layer.b(je1Var, layer, fe1Var.l(layer.k()), fe1Var);
            case 3:
                return new f(je1Var, layer);
            case 4:
                return new c(je1Var, layer);
            case 5:
                return new d(je1Var, layer);
            case 6:
                return new g(je1Var, layer);
            default:
                o91.d("Unknown layer type " + layer.d());
                return null;
        }
    }

    private void s(RectF rectF, Matrix matrix) {
        this.i.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (q()) {
            int size = this.p.b().size();
            for (int i = 0; i < size; i++) {
                Mask mask = (Mask) this.p.b().get(i);
                this.a.set((Path) ((tg) this.p.a().get(i)).h());
                this.a.transform(matrix);
                int i2 = b.b[mask.a().ordinal()];
                if (i2 == 1 || i2 == 2) {
                    return;
                }
                this.a.computeBounds(this.k, false);
                if (i == 0) {
                    this.i.set(this.k);
                } else {
                    RectF rectF2 = this.i;
                    rectF2.set(Math.min(rectF2.left, this.k.left), Math.min(this.i.top, this.k.top), Math.max(this.i.right, this.k.right), Math.max(this.i.bottom, this.k.bottom));
                }
            }
            rectF.set(Math.max(rectF.left, this.i.left), Math.max(rectF.top, this.i.top), Math.min(rectF.right, this.i.right), Math.min(rectF.bottom, this.i.bottom));
        }
    }

    private void t(RectF rectF, Matrix matrix) {
        if (r() && this.o.f() != Layer.MatteType.Invert) {
            this.f210q.d(this.j, matrix);
            rectF.set(Math.max(rectF.left, this.j.left), Math.max(rectF.top, this.j.top), Math.min(rectF.right, this.j.right), Math.min(rectF.bottom, this.j.bottom));
        }
    }

    private void u() {
        this.n.invalidateSelf();
    }

    private void v(float f) {
        this.n.j().k().a(this.o.g(), f);
    }

    private void x(Canvas canvas, RectF rectF, Paint paint, boolean z) {
        canvas.saveLayer(rectF, paint);
    }

    void A(float f) {
        this.u.i(f);
        if (this.p != null) {
            for (int i = 0; i < this.p.a().size(); i++) {
                ((tg) this.p.a().get(i)).l(f);
            }
        }
        if (this.o.t() != 0.0f) {
            f /= this.o.t();
        }
        a aVar = this.f210q;
        if (aVar != null) {
            this.f210q.A(aVar.o.t() * f);
        }
        for (int i2 = 0; i2 < this.t.size(); i2++) {
            ((tg) this.t.get(i2)).l(f);
        }
    }

    @Override // tg.a
    public void a() {
        u();
    }

    @Override // defpackage.s20
    public void b(List list, List list2) {
    }

    @Override // defpackage.wd0
    public void d(RectF rectF, Matrix matrix) {
        this.m.set(matrix);
        this.m.preConcat(this.u.e());
    }

    @Override // defpackage.e91
    public void f(Object obj, re1 re1Var) {
        this.u.c(obj, re1Var);
    }

    @Override // defpackage.e91
    public void g(d91 d91Var, int i, List list, d91 d91Var2) {
        if (d91Var.g(getName(), i)) {
            if (!"__container".equals(getName())) {
                d91Var2 = d91Var2.a(getName());
                if (d91Var.c(getName(), i)) {
                    list.add(d91Var2.i(this));
                }
            }
            if (d91Var.h(getName(), i)) {
                w(d91Var, i + d91Var.e(getName(), i), list, d91Var2);
            }
        }
    }

    @Override // defpackage.s20
    public String getName() {
        return this.o.g();
    }

    @Override // defpackage.wd0
    public void h(Canvas canvas, Matrix matrix, int i) {
        o91.a(this.l);
        if (!this.v) {
            o91.c(this.l);
            return;
        }
        l();
        o91.a("Layer#parentMatrix");
        this.b.reset();
        this.b.set(matrix);
        for (int size = this.s.size() - 1; size >= 0; size--) {
            this.b.preConcat(((a) this.s.get(size)).u.e());
        }
        o91.c("Layer#parentMatrix");
        int iIntValue = (int) ((((i / 255.0f) * ((Integer) this.u.g().h()).intValue()) / 100.0f) * 255.0f);
        if (!r() && !q()) {
            this.b.preConcat(this.u.e());
            o91.a("Layer#drawLayer");
            n(canvas, this.b, iIntValue);
            o91.c("Layer#drawLayer");
            v(o91.c(this.l));
            return;
        }
        o91.a("Layer#computeBounds");
        this.h.set(0.0f, 0.0f, 0.0f, 0.0f);
        d(this.h, this.b);
        t(this.h, this.b);
        this.b.preConcat(this.u.e());
        s(this.h, this.b);
        this.h.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        o91.c("Layer#computeBounds");
        o91.a("Layer#saveLayer");
        x(canvas, this.h, this.c, true);
        o91.c("Layer#saveLayer");
        m(canvas);
        o91.a("Layer#drawLayer");
        n(canvas, this.b, iIntValue);
        o91.c("Layer#drawLayer");
        if (q()) {
            j(canvas, this.b);
        }
        if (r()) {
            o91.a("Layer#drawMatte");
            o91.a("Layer#saveLayer");
            x(canvas, this.h, this.f, false);
            o91.c("Layer#saveLayer");
            m(canvas);
            this.f210q.h(canvas, matrix, iIntValue);
            o91.a("Layer#restoreLayer");
            canvas.restore();
            o91.c("Layer#restoreLayer");
            o91.c("Layer#drawMatte");
        }
        o91.a("Layer#restoreLayer");
        canvas.restore();
        o91.c("Layer#restoreLayer");
        v(o91.c(this.l));
    }

    public void i(tg tgVar) {
        this.t.add(tgVar);
    }

    abstract void n(Canvas canvas, Matrix matrix, int i);

    Layer p() {
        return this.o;
    }

    boolean q() {
        xf1 xf1Var = this.p;
        return (xf1Var == null || xf1Var.a().isEmpty()) ? false : true;
    }

    boolean r() {
        return this.f210q != null;
    }

    void w(d91 d91Var, int i, List list, d91 d91Var2) {
    }

    void y(a aVar) {
        this.f210q = aVar;
    }

    void z(a aVar) {
        this.r = aVar;
    }
}
