package defpackage;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.layer.a;
import com.jieli.jl_rcsp.BuildConfig;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ev0 implements wd0, tg.a, f91 {
    private final String a;
    private final a b;
    private final zd1 c = new zd1();
    private final zd1 d = new zd1();
    private final Matrix e = new Matrix();
    private final Path f;
    private final Paint g;
    private final RectF h;
    private final List i;
    private final GradientType j;
    private final tg k;
    private final tg l;
    private final tg m;
    private final tg n;
    private tg o;
    private final je1 p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final int f329q;

    public ev0(je1 je1Var, a aVar, dv0 dv0Var) {
        Path path = new Path();
        this.f = path;
        this.g = new Paint(1);
        this.h = new RectF();
        this.i = new ArrayList();
        this.b = aVar;
        this.a = dv0Var.f();
        this.p = je1Var;
        this.j = dv0Var.e();
        path.setFillType(dv0Var.c());
        this.f329q = (int) (je1Var.j().d() / 32.0f);
        tg tgVarA = dv0Var.d().a();
        this.k = tgVarA;
        tgVarA.a(this);
        aVar.i(tgVarA);
        tg tgVarA2 = dv0Var.g().a();
        this.l = tgVarA2;
        tgVarA2.a(this);
        aVar.i(tgVarA2);
        tg tgVarA3 = dv0Var.h().a();
        this.m = tgVarA3;
        tgVarA3.a(this);
        aVar.i(tgVarA3);
        tg tgVarA4 = dv0Var.b().a();
        this.n = tgVarA4;
        tgVarA4.a(this);
        aVar.i(tgVarA4);
    }

    private int e() {
        int iRound = Math.round(this.m.f() * this.f329q);
        int iRound2 = Math.round(this.n.f() * this.f329q);
        int iRound3 = Math.round(this.k.f() * this.f329q);
        int i = iRound != 0 ? BuildConfig.VERSION_CODE * iRound : 17;
        if (iRound2 != 0) {
            i = i * 31 * iRound2;
        }
        return iRound3 != 0 ? i * 31 * iRound3 : i;
    }

    private LinearGradient i() {
        long jE = e();
        LinearGradient linearGradient = (LinearGradient) this.c.c(jE);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF pointF = (PointF) this.m.h();
        PointF pointF2 = (PointF) this.n.h();
        zu0 zu0Var = (zu0) this.k.h();
        LinearGradient linearGradient2 = new LinearGradient(pointF.x, pointF.y, pointF2.x, pointF2.y, zu0Var.a(), zu0Var.b(), Shader.TileMode.CLAMP);
        this.c.f(jE, linearGradient2);
        return linearGradient2;
    }

    private RadialGradient j() {
        long jE = e();
        RadialGradient radialGradient = (RadialGradient) this.d.c(jE);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF pointF = (PointF) this.m.h();
        PointF pointF2 = (PointF) this.n.h();
        zu0 zu0Var = (zu0) this.k.h();
        int[] iArrA = zu0Var.a();
        float[] fArrB = zu0Var.b();
        float f = pointF.x;
        float f2 = pointF.y;
        RadialGradient radialGradient2 = new RadialGradient(f, f2, (float) Math.hypot(pointF2.x - f, pointF2.y - f2), iArrA, fArrB, Shader.TileMode.CLAMP);
        this.d.f(jE, radialGradient2);
        return radialGradient2;
    }

    @Override // tg.a
    public void a() {
        this.p.invalidateSelf();
    }

    @Override // defpackage.s20
    public void b(List list, List list2) {
        for (int i = 0; i < list2.size(); i++) {
            s20 s20Var = (s20) list2.get(i);
            if (s20Var instanceof iz1) {
                this.i.add((iz1) s20Var);
            }
        }
    }

    @Override // defpackage.wd0
    public void d(RectF rectF, Matrix matrix) {
        this.f.reset();
        for (int i = 0; i < this.i.size(); i++) {
            this.f.addPath(((iz1) this.i.get(i)).c(), matrix);
        }
        this.f.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // defpackage.e91
    public void f(Object obj, re1 re1Var) {
        if (obj == ne1.x) {
            if (re1Var == null) {
                this.o = null;
                return;
            }
            bb3 bb3Var = new bb3(re1Var);
            this.o = bb3Var;
            bb3Var.a(this);
            this.b.i(this.o);
        }
    }

    @Override // defpackage.e91
    public void g(d91 d91Var, int i, List list, d91 d91Var2) {
        ok1.l(d91Var, i, list, d91Var2, this);
    }

    @Override // defpackage.s20
    public String getName() {
        return this.a;
    }

    @Override // defpackage.wd0
    public void h(Canvas canvas, Matrix matrix, int i) {
        o91.a("GradientFillContent#draw");
        this.f.reset();
        for (int i2 = 0; i2 < this.i.size(); i2++) {
            this.f.addPath(((iz1) this.i.get(i2)).c(), matrix);
        }
        this.f.computeBounds(this.h, false);
        Shader shaderI = this.j == GradientType.Linear ? i() : j();
        this.e.set(matrix);
        shaderI.setLocalMatrix(this.e);
        this.g.setShader(shaderI);
        tg tgVar = this.o;
        if (tgVar != null) {
            this.g.setColorFilter((ColorFilter) tgVar.h());
        }
        this.g.setAlpha(ok1.c((int) ((((i / 255.0f) * ((Integer) this.l.h()).intValue()) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.f, this.g);
        o91.c("GradientFillContent#draw");
    }
}
