package defpackage;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class d42 implements iz1, tg.a, f91 {
    private final Path a = new Path();
    private final String b;
    private final je1 c;
    private final PolystarShape.Type d;
    private final tg e;
    private final tg f;
    private final tg g;
    private final tg h;
    private final tg i;
    private final tg j;
    private final tg k;
    private b63 l;
    private boolean m;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[PolystarShape.Type.values().length];
            a = iArr;
            try {
                iArr[PolystarShape.Type.Star.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[PolystarShape.Type.Polygon.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public d42(je1 je1Var, com.airbnb.lottie.model.layer.a aVar, PolystarShape polystarShape) {
        this.c = je1Var;
        this.b = polystarShape.d();
        PolystarShape.Type typeJ = polystarShape.j();
        this.d = typeJ;
        tg tgVarA = polystarShape.g().a();
        this.e = tgVarA;
        tg tgVarA2 = polystarShape.h().a();
        this.f = tgVarA2;
        tg tgVarA3 = polystarShape.i().a();
        this.g = tgVarA3;
        tg tgVarA4 = polystarShape.e().a();
        this.i = tgVarA4;
        tg tgVarA5 = polystarShape.f().a();
        this.k = tgVarA5;
        PolystarShape.Type type = PolystarShape.Type.Star;
        if (typeJ == type) {
            this.h = polystarShape.b().a();
            this.j = polystarShape.c().a();
        } else {
            this.h = null;
            this.j = null;
        }
        aVar.i(tgVarA);
        aVar.i(tgVarA2);
        aVar.i(tgVarA3);
        aVar.i(tgVarA4);
        aVar.i(tgVarA5);
        if (typeJ == type) {
            aVar.i(this.h);
            aVar.i(this.j);
        }
        tgVarA.a(this);
        tgVarA2.a(this);
        tgVarA3.a(this);
        tgVarA4.a(this);
        tgVarA5.a(this);
        if (typeJ == type) {
            this.h.a(this);
            this.j.a(this);
        }
    }

    private void e() {
        int iFloor = (int) Math.floor(((Float) this.e.h()).floatValue());
        tg tgVar = this.g;
        double radians = Math.toRadians((tgVar == null ? 0.0d : ((Float) tgVar.h()).floatValue()) - 90.0d);
        double d = iFloor;
        float fFloatValue = ((Float) this.k.h()).floatValue() / 100.0f;
        float fFloatValue2 = ((Float) this.i.h()).floatValue();
        double d2 = fFloatValue2;
        float fCos = (float) (Math.cos(radians) * d2);
        float fSin = (float) (Math.sin(radians) * d2);
        this.a.moveTo(fCos, fSin);
        double d3 = (float) (6.283185307179586d / d);
        double d4 = radians + d3;
        double dCeil = Math.ceil(d);
        int i = 0;
        while (i < dCeil) {
            float fCos2 = (float) (Math.cos(d4) * d2);
            double d5 = dCeil;
            float fSin2 = (float) (d2 * Math.sin(d4));
            if (fFloatValue != 0.0f) {
                double dAtan2 = (float) (Math.atan2(fSin, fCos) - 1.5707963267948966d);
                float fCos3 = (float) Math.cos(dAtan2);
                float fSin3 = (float) Math.sin(dAtan2);
                double dAtan3 = (float) (Math.atan2(fSin2, fCos2) - 1.5707963267948966d);
                float f = fFloatValue2 * fFloatValue * 0.25f;
                this.a.cubicTo(fCos - (fCos3 * f), fSin - (fSin3 * f), fCos2 + (((float) Math.cos(dAtan3)) * f), fSin2 + (f * ((float) Math.sin(dAtan3))), fCos2, fSin2);
            } else {
                this.a.lineTo(fCos2, fSin2);
            }
            d4 += d3;
            i++;
            fSin = fSin2;
            fCos = fCos2;
            dCeil = d5;
            d2 = d2;
            d3 = d3;
        }
        PointF pointF = (PointF) this.f.h();
        this.a.offset(pointF.x, pointF.y);
        this.a.close();
    }

    private void i() {
        float f;
        float f2;
        double d;
        float fSin;
        float f3;
        float f4;
        float f5;
        float fFloatValue = ((Float) this.e.h()).floatValue();
        tg tgVar = this.g;
        double radians = Math.toRadians((tgVar == null ? 0.0d : ((Float) tgVar.h()).floatValue()) - 90.0d);
        double d2 = fFloatValue;
        float f6 = (float) (6.283185307179586d / d2);
        float f7 = f6 / 2.0f;
        float f8 = fFloatValue - ((int) fFloatValue);
        if (f8 != 0.0f) {
            radians += (double) ((1.0f - f8) * f7);
        }
        float fFloatValue2 = ((Float) this.i.h()).floatValue();
        float fFloatValue3 = ((Float) this.h.h()).floatValue();
        tg tgVar2 = this.j;
        float fFloatValue4 = tgVar2 != null ? ((Float) tgVar2.h()).floatValue() / 100.0f : 0.0f;
        tg tgVar3 = this.k;
        float fFloatValue5 = tgVar3 != null ? ((Float) tgVar3.h()).floatValue() / 100.0f : 0.0f;
        if (f8 != 0.0f) {
            f3 = ((fFloatValue2 - fFloatValue3) * f8) + fFloatValue3;
            double d3 = f3;
            float fCos = (float) (d3 * Math.cos(radians));
            fSin = (float) (d3 * Math.sin(radians));
            this.a.moveTo(fCos, fSin);
            d = radians + ((double) ((f6 * f8) / 2.0f));
            f = fCos;
            f2 = f7;
        } else {
            double d4 = fFloatValue2;
            float fCos2 = (float) (Math.cos(radians) * d4);
            float fSin2 = (float) (d4 * Math.sin(radians));
            this.a.moveTo(fCos2, fSin2);
            f = fCos2;
            f2 = f7;
            d = radians + ((double) f2);
            fSin = fSin2;
            f3 = 0.0f;
        }
        double dCeil = Math.ceil(d2) * 2.0d;
        int i = 0;
        float f9 = f2;
        float f10 = f;
        boolean z = false;
        while (true) {
            double d5 = i;
            if (d5 >= dCeil) {
                PointF pointF = (PointF) this.f.h();
                this.a.offset(pointF.x, pointF.y);
                this.a.close();
                return;
            }
            float f11 = z ? fFloatValue2 : fFloatValue3;
            float f12 = (f3 == 0.0f || d5 != dCeil - 2.0d) ? f9 : (f6 * f8) / 2.0f;
            if (f3 == 0.0f || d5 != dCeil - 1.0d) {
                f3 = f11;
            }
            double d6 = f3;
            double d7 = dCeil;
            float fCos3 = (float) (d6 * Math.cos(d));
            float fSin3 = (float) (d6 * Math.sin(d));
            if (fFloatValue4 == 0.0f && fFloatValue5 == 0.0f) {
                this.a.lineTo(fCos3, fSin3);
                f4 = fFloatValue4;
                f5 = fFloatValue5;
            } else {
                f4 = fFloatValue4;
                double dAtan2 = (float) (Math.atan2(fSin, f10) - 1.5707963267948966d);
                float fCos4 = (float) Math.cos(dAtan2);
                float fSin4 = (float) Math.sin(dAtan2);
                f5 = fFloatValue5;
                double dAtan3 = (float) (Math.atan2(fSin3, fCos3) - 1.5707963267948966d);
                float fCos5 = (float) Math.cos(dAtan3);
                float fSin5 = (float) Math.sin(dAtan3);
                float f13 = z ? f4 : f5;
                float f14 = z ? f5 : f4;
                float f15 = (z ? fFloatValue3 : fFloatValue2) * f13 * 0.47829f;
                float f16 = fCos4 * f15;
                float f17 = f15 * fSin4;
                float f18 = (z ? fFloatValue2 : fFloatValue3) * f14 * 0.47829f;
                float f19 = fCos5 * f18;
                float f20 = f18 * fSin5;
                if (f8 != 0.0f) {
                    if (i == 0) {
                        f16 *= f8;
                        f17 *= f8;
                    } else if (d5 == d7 - 1.0d) {
                        f19 *= f8;
                        f20 *= f8;
                    }
                }
                this.a.cubicTo(f10 - f16, fSin - f17, fCos3 + f19, fSin3 + f20, fCos3, fSin3);
            }
            d += (double) f12;
            z = !z;
            i++;
            f10 = fCos3;
            fSin = fSin3;
            fFloatValue5 = f5;
            fFloatValue4 = f4;
            f3 = f3;
            f6 = f6;
            dCeil = d7;
        }
    }

    private void j() {
        this.m = false;
        this.c.invalidateSelf();
    }

    @Override // tg.a
    public void a() {
        j();
    }

    @Override // defpackage.s20
    public void b(List list, List list2) {
        for (int i = 0; i < list.size(); i++) {
            s20 s20Var = (s20) list.get(i);
            if (s20Var instanceof b63) {
                b63 b63Var = (b63) s20Var;
                if (b63Var.j() == ShapeTrimPath.Type.Simultaneously) {
                    this.l = b63Var;
                    b63Var.e(this);
                }
            }
        }
    }

    @Override // defpackage.iz1
    public Path c() {
        if (this.m) {
            return this.a;
        }
        this.a.reset();
        int i = a.a[this.d.ordinal()];
        if (i == 1) {
            i();
        } else if (i == 2) {
            e();
        }
        this.a.close();
        ya3.b(this.a, this.l);
        this.m = true;
        return this.a;
    }

    @Override // defpackage.e91
    public void f(Object obj, re1 re1Var) {
        tg tgVar;
        tg tgVar2;
        if (obj == ne1.o) {
            this.e.m(re1Var);
            return;
        }
        if (obj == ne1.p) {
            this.g.m(re1Var);
            return;
        }
        if (obj == ne1.h) {
            this.f.m(re1Var);
            return;
        }
        if (obj == ne1.f363q && (tgVar2 = this.h) != null) {
            tgVar2.m(re1Var);
            return;
        }
        if (obj == ne1.r) {
            this.i.m(re1Var);
            return;
        }
        if (obj == ne1.s && (tgVar = this.j) != null) {
            tgVar.m(re1Var);
        } else if (obj == ne1.t) {
            this.k.m(re1Var);
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
