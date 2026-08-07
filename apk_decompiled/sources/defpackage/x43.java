package defpackage;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.airbnb.lottie.model.layer.a;

/* JADX INFO: loaded from: classes.dex */
public class x43 {
    private final Matrix a = new Matrix();
    private final tg b;
    private final tg c;
    private final tg d;
    private final tg e;
    private final tg f;
    private final tg g;
    private final tg h;

    public x43(s6 s6Var) {
        this.b = s6Var.c().a();
        this.c = s6Var.f().a();
        this.d = s6Var.h().a();
        this.e = s6Var.g().a();
        this.f = s6Var.e().a();
        if (s6Var.i() != null) {
            this.g = s6Var.i().a();
        } else {
            this.g = null;
        }
        if (s6Var.d() != null) {
            this.h = s6Var.d().a();
        } else {
            this.h = null;
        }
    }

    public void a(a aVar) {
        aVar.i(this.b);
        aVar.i(this.c);
        aVar.i(this.d);
        aVar.i(this.e);
        aVar.i(this.f);
        tg tgVar = this.g;
        if (tgVar != null) {
            aVar.i(tgVar);
        }
        tg tgVar2 = this.h;
        if (tgVar2 != null) {
            aVar.i(tgVar2);
        }
    }

    public void b(tg.a aVar) {
        this.b.a(aVar);
        this.c.a(aVar);
        this.d.a(aVar);
        this.e.a(aVar);
        this.f.a(aVar);
        tg tgVar = this.g;
        if (tgVar != null) {
            tgVar.a(aVar);
        }
        tg tgVar2 = this.h;
        if (tgVar2 != null) {
            tgVar2.a(aVar);
        }
    }

    public boolean c(Object obj, re1 re1Var) {
        tg tgVar;
        tg tgVar2;
        if (obj == ne1.e) {
            this.b.m(re1Var);
            return true;
        }
        if (obj == ne1.f) {
            this.c.m(re1Var);
            return true;
        }
        if (obj == ne1.i) {
            this.d.m(re1Var);
            return true;
        }
        if (obj == ne1.j) {
            this.e.m(re1Var);
            return true;
        }
        if (obj == ne1.c) {
            this.f.m(re1Var);
            return true;
        }
        if (obj == ne1.u && (tgVar2 = this.g) != null) {
            tgVar2.m(re1Var);
            return true;
        }
        if (obj != ne1.v || (tgVar = this.h) == null) {
            return false;
        }
        tgVar.m(re1Var);
        return true;
    }

    public tg d() {
        return this.h;
    }

    public Matrix e() {
        this.a.reset();
        PointF pointF = (PointF) this.c.h();
        float f = pointF.x;
        if (f != 0.0f || pointF.y != 0.0f) {
            this.a.preTranslate(f, pointF.y);
        }
        float fFloatValue = ((Float) this.e.h()).floatValue();
        if (fFloatValue != 0.0f) {
            this.a.preRotate(fFloatValue);
        }
        ck2 ck2Var = (ck2) this.d.h();
        if (ck2Var.a() != 1.0f || ck2Var.b() != 1.0f) {
            this.a.preScale(ck2Var.a(), ck2Var.b());
        }
        PointF pointF2 = (PointF) this.b.h();
        float f2 = pointF2.x;
        if (f2 != 0.0f || pointF2.y != 0.0f) {
            this.a.preTranslate(-f2, -pointF2.y);
        }
        return this.a;
    }

    public Matrix f(float f) {
        PointF pointF = (PointF) this.c.h();
        PointF pointF2 = (PointF) this.b.h();
        ck2 ck2Var = (ck2) this.d.h();
        float fFloatValue = ((Float) this.e.h()).floatValue();
        this.a.reset();
        this.a.preTranslate(pointF.x * f, pointF.y * f);
        double d = f;
        this.a.preScale((float) Math.pow(ck2Var.a(), d), (float) Math.pow(ck2Var.b(), d));
        this.a.preRotate(fFloatValue * f, pointF2.x, pointF2.y);
        return this.a;
    }

    public tg g() {
        return this.f;
    }

    public tg h() {
        return this.g;
    }

    public void i(float f) {
        this.b.l(f);
        this.c.l(f);
        this.d.l(f);
        this.e.l(f);
        this.f.l(f);
        tg tgVar = this.g;
        if (tgVar != null) {
            tgVar.l(f);
        }
        tg tgVar2 = this.h;
        if (tgVar2 != null) {
            tgVar2.l(f);
        }
    }
}
