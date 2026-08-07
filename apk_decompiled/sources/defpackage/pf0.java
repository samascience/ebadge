package defpackage;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.a;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class pf0 implements iz1, tg.a, f91 {
    private final Path a = new Path();
    private final String b;
    private final je1 c;
    private final tg d;
    private final tg e;
    private final qx f;
    private b63 g;
    private boolean h;

    public pf0(je1 je1Var, a aVar, qx qxVar) {
        this.b = qxVar.b();
        this.c = je1Var;
        tg tgVarA = qxVar.d().a();
        this.d = tgVarA;
        tg tgVarA2 = qxVar.c().a();
        this.e = tgVarA2;
        this.f = qxVar;
        aVar.i(tgVarA);
        aVar.i(tgVarA2);
        tgVarA.a(this);
        tgVarA2.a(this);
    }

    private void e() {
        this.h = false;
        this.c.invalidateSelf();
    }

    @Override // tg.a
    public void a() {
        e();
    }

    @Override // defpackage.s20
    public void b(List list, List list2) {
        for (int i = 0; i < list.size(); i++) {
            s20 s20Var = (s20) list.get(i);
            if (s20Var instanceof b63) {
                b63 b63Var = (b63) s20Var;
                if (b63Var.j() == ShapeTrimPath.Type.Simultaneously) {
                    this.g = b63Var;
                    b63Var.e(this);
                }
            }
        }
    }

    @Override // defpackage.iz1
    public Path c() {
        if (this.h) {
            return this.a;
        }
        this.a.reset();
        PointF pointF = (PointF) this.d.h();
        float f = pointF.x / 2.0f;
        float f2 = pointF.y / 2.0f;
        float f3 = f * 0.55228f;
        float f4 = 0.55228f * f2;
        this.a.reset();
        if (this.f.e()) {
            float f5 = -f2;
            this.a.moveTo(0.0f, f5);
            float f6 = 0.0f - f3;
            float f7 = -f;
            float f8 = 0.0f - f4;
            this.a.cubicTo(f6, f5, f7, f8, f7, 0.0f);
            float f9 = f4 + 0.0f;
            this.a.cubicTo(f7, f9, f6, f2, 0.0f, f2);
            float f10 = f3 + 0.0f;
            this.a.cubicTo(f10, f2, f, f9, f, 0.0f);
            this.a.cubicTo(f, f8, f10, f5, 0.0f, f5);
        } else {
            float f11 = -f2;
            this.a.moveTo(0.0f, f11);
            float f12 = f3 + 0.0f;
            float f13 = 0.0f - f4;
            this.a.cubicTo(f12, f11, f, f13, f, 0.0f);
            float f14 = f4 + 0.0f;
            this.a.cubicTo(f, f14, f12, f2, 0.0f, f2);
            float f15 = 0.0f - f3;
            float f16 = -f;
            this.a.cubicTo(f15, f2, f16, f14, f16, 0.0f);
            this.a.cubicTo(f16, f13, f15, f11, 0.0f, f11);
        }
        PointF pointF2 = (PointF) this.e.h();
        this.a.offset(pointF2.x, pointF2.y);
        this.a.close();
        ya3.b(this.a, this.g);
        this.h = true;
        return this.a;
    }

    @Override // defpackage.e91
    public void f(Object obj, re1 re1Var) {
        if (obj == ne1.g) {
            this.d.m(re1Var);
        } else if (obj == ne1.h) {
            this.e.m(re1Var);
        }
    }

    @Override // defpackage.e91
    public void g(d91 d91Var, int i, List list, d91 d91Var2) {
        ok1.l(d91Var, i, list, d91Var2, this);
    }

    @Override // defpackage.s20
    public String getName() {
        return this.b;
    }
}
