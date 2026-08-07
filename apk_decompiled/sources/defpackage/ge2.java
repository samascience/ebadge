package defpackage;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.a;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ge2 implements tg.a, f91, iz1 {
    private final Path a = new Path();
    private final RectF b = new RectF();
    private final String c;
    private final je1 d;
    private final tg e;
    private final tg f;
    private final tg g;
    private b63 h;
    private boolean i;

    public ge2(je1 je1Var, a aVar, he2 he2Var) {
        this.c = he2Var.c();
        this.d = je1Var;
        tg tgVarA = he2Var.d().a();
        this.e = tgVarA;
        tg tgVarA2 = he2Var.e().a();
        this.f = tgVarA2;
        tg tgVarA3 = he2Var.b().a();
        this.g = tgVarA3;
        aVar.i(tgVarA);
        aVar.i(tgVarA2);
        aVar.i(tgVarA3);
        tgVarA.a(this);
        tgVarA2.a(this);
        tgVarA3.a(this);
    }

    private void e() {
        this.i = false;
        this.d.invalidateSelf();
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
                    this.h = b63Var;
                    b63Var.e(this);
                }
            }
        }
    }

    @Override // defpackage.iz1
    public Path c() {
        if (this.i) {
            return this.a;
        }
        this.a.reset();
        PointF pointF = (PointF) this.f.h();
        float f = pointF.x / 2.0f;
        float f2 = pointF.y / 2.0f;
        tg tgVar = this.g;
        float fFloatValue = tgVar == null ? 0.0f : ((Float) tgVar.h()).floatValue();
        float fMin = Math.min(f, f2);
        if (fFloatValue > fMin) {
            fFloatValue = fMin;
        }
        PointF pointF2 = (PointF) this.e.h();
        this.a.moveTo(pointF2.x + f, (pointF2.y - f2) + fFloatValue);
        this.a.lineTo(pointF2.x + f, (pointF2.y + f2) - fFloatValue);
        if (fFloatValue > 0.0f) {
            RectF rectF = this.b;
            float f3 = pointF2.x;
            float f4 = fFloatValue * 2.0f;
            float f5 = pointF2.y;
            rectF.set((f3 + f) - f4, (f5 + f2) - f4, f3 + f, f5 + f2);
            this.a.arcTo(this.b, 0.0f, 90.0f, false);
        }
        this.a.lineTo((pointF2.x - f) + fFloatValue, pointF2.y + f2);
        if (fFloatValue > 0.0f) {
            RectF rectF2 = this.b;
            float f6 = pointF2.x;
            float f7 = pointF2.y;
            float f8 = fFloatValue * 2.0f;
            rectF2.set(f6 - f, (f7 + f2) - f8, (f6 - f) + f8, f7 + f2);
            this.a.arcTo(this.b, 90.0f, 90.0f, false);
        }
        this.a.lineTo(pointF2.x - f, (pointF2.y - f2) + fFloatValue);
        if (fFloatValue > 0.0f) {
            RectF rectF3 = this.b;
            float f9 = pointF2.x;
            float f10 = pointF2.y;
            float f11 = fFloatValue * 2.0f;
            rectF3.set(f9 - f, f10 - f2, (f9 - f) + f11, (f10 - f2) + f11);
            this.a.arcTo(this.b, 180.0f, 90.0f, false);
        }
        this.a.lineTo((pointF2.x + f) - fFloatValue, pointF2.y - f2);
        if (fFloatValue > 0.0f) {
            RectF rectF4 = this.b;
            float f12 = pointF2.x;
            float f13 = fFloatValue * 2.0f;
            float f14 = pointF2.y;
            rectF4.set((f12 + f) - f13, f14 - f2, f12 + f, (f14 - f2) + f13);
            this.a.arcTo(this.b, 270.0f, 90.0f, false);
        }
        this.a.close();
        ya3.b(this.a, this.h);
        this.i = true;
        return this.a;
    }

    @Override // defpackage.e91
    public void f(Object obj, re1 re1Var) {
    }

    @Override // defpackage.e91
    public void g(d91 d91Var, int i, List list, d91 d91Var2) {
        ok1.l(d91Var, i, list, d91Var2, this);
    }

    @Override // defpackage.s20
    public String getName() {
        return this.c;
    }
}
