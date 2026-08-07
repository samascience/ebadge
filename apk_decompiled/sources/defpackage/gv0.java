package defpackage;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.layer.a;
import com.jieli.jl_rcsp.BuildConfig;

/* JADX INFO: loaded from: classes.dex */
public class gv0 extends yg {
    private final String o;
    private final zd1 p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final zd1 f341q;
    private final RectF r;
    private final GradientType s;
    private final int t;
    private final tg u;
    private final tg v;
    private final tg w;

    public gv0(je1 je1Var, a aVar, com.airbnb.lottie.model.content.a aVar2) {
        super(je1Var, aVar, aVar2.b().toPaintCap(), aVar2.g().toPaintJoin(), aVar2.i(), aVar2.k(), aVar2.m(), aVar2.h(), aVar2.c());
        this.p = new zd1();
        this.f341q = new zd1();
        this.r = new RectF();
        this.o = aVar2.j();
        this.s = aVar2.f();
        this.t = (int) (je1Var.j().d() / 32.0f);
        tg tgVarA = aVar2.e().a();
        this.u = tgVarA;
        tgVarA.a(this);
        aVar.i(tgVarA);
        tg tgVarA2 = aVar2.l().a();
        this.v = tgVarA2;
        tgVarA2.a(this);
        aVar.i(tgVarA2);
        tg tgVarA3 = aVar2.d().a();
        this.w = tgVarA3;
        tgVarA3.a(this);
        aVar.i(tgVarA3);
    }

    private int j() {
        int iRound = Math.round(this.v.f() * this.t);
        int iRound2 = Math.round(this.w.f() * this.t);
        int iRound3 = Math.round(this.u.f() * this.t);
        int i = iRound != 0 ? BuildConfig.VERSION_CODE * iRound : 17;
        if (iRound2 != 0) {
            i = i * 31 * iRound2;
        }
        return iRound3 != 0 ? i * 31 * iRound3 : i;
    }

    private LinearGradient k() {
        long j = j();
        LinearGradient linearGradient = (LinearGradient) this.p.c(j);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF pointF = (PointF) this.v.h();
        PointF pointF2 = (PointF) this.w.h();
        zu0 zu0Var = (zu0) this.u.h();
        int[] iArrA = zu0Var.a();
        float[] fArrB = zu0Var.b();
        RectF rectF = this.r;
        int iWidth = (int) (rectF.left + (rectF.width() / 2.0f) + pointF.x);
        RectF rectF2 = this.r;
        int iHeight = (int) (rectF2.top + (rectF2.height() / 2.0f) + pointF.y);
        RectF rectF3 = this.r;
        int iWidth2 = (int) (rectF3.left + (rectF3.width() / 2.0f) + pointF2.x);
        RectF rectF4 = this.r;
        LinearGradient linearGradient2 = new LinearGradient(iWidth, iHeight, iWidth2, (int) (rectF4.top + (rectF4.height() / 2.0f) + pointF2.y), iArrA, fArrB, Shader.TileMode.CLAMP);
        this.p.f(j, linearGradient2);
        return linearGradient2;
    }

    private RadialGradient l() {
        long j = j();
        RadialGradient radialGradient = (RadialGradient) this.f341q.c(j);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF pointF = (PointF) this.v.h();
        PointF pointF2 = (PointF) this.w.h();
        zu0 zu0Var = (zu0) this.u.h();
        int[] iArrA = zu0Var.a();
        float[] fArrB = zu0Var.b();
        RectF rectF = this.r;
        int iWidth = (int) (rectF.left + (rectF.width() / 2.0f) + pointF.x);
        RectF rectF2 = this.r;
        int iHeight = (int) (rectF2.top + (rectF2.height() / 2.0f) + pointF.y);
        RectF rectF3 = this.r;
        int iWidth2 = (int) (rectF3.left + (rectF3.width() / 2.0f) + pointF2.x);
        RectF rectF4 = this.r;
        RadialGradient radialGradient2 = new RadialGradient(iWidth, iHeight, (float) Math.hypot(iWidth2 - iWidth, ((int) ((rectF4.top + (rectF4.height() / 2.0f)) + pointF2.y)) - iHeight), iArrA, fArrB, Shader.TileMode.CLAMP);
        this.f341q.f(j, radialGradient2);
        return radialGradient2;
    }

    @Override // defpackage.s20
    public String getName() {
        return this.o;
    }

    @Override // defpackage.yg, defpackage.wd0
    public void h(Canvas canvas, Matrix matrix, int i) {
        d(this.r, matrix);
        if (this.s == GradientType.Linear) {
            this.i.setShader(k());
        } else {
            this.i.setShader(l());
        }
        super.h(canvas, matrix, i);
    }
}
