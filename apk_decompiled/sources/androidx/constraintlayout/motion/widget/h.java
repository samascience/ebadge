package androidx.constraintlayout.motion.widget;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintAttribute;
import defpackage.ye0;
import defpackage.zn0;
import java.util.Arrays;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes.dex */
class h implements Comparable {
    static String[] t = {"position", "x", "y", "width", "height", "pathRotate"};
    ye0 a;
    float c;
    float d;
    float e;
    float f;
    float g;
    float h;
    int k;
    int l;
    float m;
    g n;
    LinkedHashMap o;
    int p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    int f176q;
    double[] r;
    double[] s;
    int b = 0;
    float i = Float.NaN;
    float j = Float.NaN;

    public h() {
        int i = a.f;
        this.k = i;
        this.l = i;
        this.m = Float.NaN;
        this.n = null;
        this.o = new LinkedHashMap();
        this.p = 0;
        this.r = new double[18];
        this.s = new double[18];
    }

    private boolean c(float f, float f2) {
        if (Float.isNaN(f) || Float.isNaN(f2)) {
            return Float.isNaN(f) != Float.isNaN(f2);
        }
        return Math.abs(f - f2) > 1.0E-6f;
    }

    public void a(androidx.constraintlayout.widget.b.a aVar) {
        this.a = ye0.c(aVar.d.d);
        androidx.constraintlayout.widget.b.c cVar = aVar.d;
        this.k = cVar.e;
        this.l = cVar.b;
        this.i = cVar.i;
        this.b = cVar.f;
        this.f176q = cVar.c;
        this.j = aVar.c.e;
        this.m = aVar.e.D;
        for (String str : aVar.g.keySet()) {
            ConstraintAttribute constraintAttribute = (ConstraintAttribute) aVar.g.get(str);
            if (constraintAttribute != null && constraintAttribute.f()) {
                this.o.put(str, constraintAttribute);
            }
        }
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(h hVar) {
        return Float.compare(this.d, hVar.d);
    }

    void d(h hVar, boolean[] zArr, String[] strArr, boolean z) {
        boolean zC = c(this.e, hVar.e);
        boolean zC2 = c(this.f, hVar.f);
        zArr[0] = zArr[0] | c(this.d, hVar.d);
        boolean z2 = zC | zC2 | z;
        zArr[1] = zArr[1] | z2;
        zArr[2] = z2 | zArr[2];
        zArr[3] = zArr[3] | c(this.g, hVar.g);
        zArr[4] = c(this.h, hVar.h) | zArr[4];
    }

    void e(double[] dArr, int[] iArr) {
        float[] fArr = {this.d, this.e, this.f, this.g, this.h, this.i};
        int i = 0;
        for (int i2 : iArr) {
            if (i2 < 6) {
                dArr[i] = fArr[i2];
                i++;
            }
        }
    }

    void f(double d, int[] iArr, double[] dArr, float[] fArr, int i) {
        float fSin = this.e;
        float fCos = this.f;
        float f = this.g;
        float f2 = this.h;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            float f3 = (float) dArr[i2];
            int i3 = iArr[i2];
            if (i3 == 1) {
                fSin = f3;
            } else if (i3 == 2) {
                fCos = f3;
            } else if (i3 == 3) {
                f = f3;
            } else if (i3 == 4) {
                f2 = f3;
            }
        }
        g gVar = this.n;
        if (gVar != null) {
            float[] fArr2 = new float[2];
            gVar.i(d, fArr2, new float[2]);
            float f4 = fArr2[0];
            float f5 = fArr2[1];
            double d2 = f4;
            double d3 = fSin;
            double d4 = fCos;
            fSin = (float) ((d2 + (Math.sin(d4) * d3)) - ((double) (f / 2.0f)));
            fCos = (float) ((((double) f5) - (d3 * Math.cos(d4))) - ((double) (f2 / 2.0f)));
        }
        fArr[i] = fSin + (f / 2.0f) + 0.0f;
        fArr[i + 1] = fCos + (f2 / 2.0f) + 0.0f;
    }

    void g(double d, int[] iArr, double[] dArr, float[] fArr, double[] dArr2, float[] fArr2) {
        float f = this.e;
        float f2 = this.f;
        float f3 = this.g;
        float f4 = this.h;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        float f8 = 0.0f;
        for (int i = 0; i < iArr.length; i++) {
            float f9 = (float) dArr[i];
            float f10 = (float) dArr2[i];
            int i2 = iArr[i];
            if (i2 == 1) {
                f = f9;
                f5 = f10;
            } else if (i2 == 2) {
                f2 = f9;
                f7 = f10;
            } else if (i2 == 3) {
                f3 = f9;
                f6 = f10;
            } else if (i2 == 4) {
                f4 = f9;
                f8 = f10;
            }
        }
        float f11 = 2.0f;
        float f12 = (f6 / 2.0f) + f5;
        float fCos = (f8 / 2.0f) + f7;
        g gVar = this.n;
        if (gVar != null) {
            float[] fArr3 = new float[2];
            float[] fArr4 = new float[2];
            gVar.i(d, fArr3, fArr4);
            float f13 = fArr3[0];
            float f14 = fArr3[1];
            float f15 = fArr4[0];
            float f16 = fArr4[1];
            double d2 = f;
            double d3 = f2;
            float fSin = (float) ((((double) f13) + (Math.sin(d3) * d2)) - ((double) (f3 / 2.0f)));
            float fCos2 = (float) ((((double) f14) - (d2 * Math.cos(d3))) - ((double) (f4 / 2.0f)));
            double d4 = f5;
            double d5 = f7;
            float fSin2 = (float) (((double) f15) + (Math.sin(d3) * d4) + (Math.cos(d3) * d5));
            fCos = (float) ((((double) f16) - (d4 * Math.cos(d3))) + (Math.sin(d3) * d5));
            f12 = fSin2;
            f = fSin;
            f2 = fCos2;
            f11 = 2.0f;
        }
        fArr[0] = f + (f3 / f11) + 0.0f;
        fArr[1] = f2 + (f4 / f11) + 0.0f;
        fArr2[0] = f12;
        fArr2[1] = fCos;
    }

    int h(String str, double[] dArr, int i) {
        ConstraintAttribute constraintAttribute = (ConstraintAttribute) this.o.get(str);
        int i2 = 0;
        if (constraintAttribute == null) {
            return 0;
        }
        if (constraintAttribute.g() == 1) {
            dArr[i] = constraintAttribute.d();
            return 1;
        }
        int iG = constraintAttribute.g();
        float[] fArr = new float[iG];
        constraintAttribute.e(fArr);
        while (i2 < iG) {
            dArr[i] = fArr[i2];
            i2++;
            i++;
        }
        return iG;
    }

    int i(String str) {
        ConstraintAttribute constraintAttribute = (ConstraintAttribute) this.o.get(str);
        if (constraintAttribute == null) {
            return 0;
        }
        return constraintAttribute.g();
    }

    void j(int[] iArr, double[] dArr, float[] fArr, int i) {
        float f = this.e;
        float fCos = this.f;
        float f2 = this.g;
        float f3 = this.h;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            float f4 = (float) dArr[i2];
            int i3 = iArr[i2];
            if (i3 == 1) {
                f = f4;
            } else if (i3 == 2) {
                fCos = f4;
            } else if (i3 == 3) {
                f2 = f4;
            } else if (i3 == 4) {
                f3 = f4;
            }
        }
        g gVar = this.n;
        if (gVar != null) {
            float fJ = gVar.j();
            float fK = this.n.k();
            double d = f;
            double d2 = fCos;
            float fSin = (float) ((((double) fJ) + (Math.sin(d2) * d)) - ((double) (f2 / 2.0f)));
            fCos = (float) ((((double) fK) - (d * Math.cos(d2))) - ((double) (f3 / 2.0f)));
            f = fSin;
        }
        float f5 = f2 + f;
        float f6 = f3 + fCos;
        Float.isNaN(Float.NaN);
        Float.isNaN(Float.NaN);
        fArr[i] = f + 0.0f;
        fArr[i + 1] = fCos + 0.0f;
        fArr[i + 2] = f5 + 0.0f;
        fArr[i + 3] = fCos + 0.0f;
        fArr[i + 4] = f5 + 0.0f;
        fArr[i + 5] = f6 + 0.0f;
        fArr[i + 6] = f + 0.0f;
        fArr[i + 7] = f6 + 0.0f;
    }

    boolean k(String str) {
        return this.o.containsKey(str);
    }

    void l(d dVar, h hVar, h hVar2) {
        float f = dVar.a / 100.0f;
        this.c = f;
        this.b = dVar.j;
        float f2 = Float.isNaN(dVar.k) ? f : dVar.k;
        float f3 = Float.isNaN(dVar.l) ? f : dVar.l;
        float f4 = hVar2.g;
        float f5 = hVar.g;
        float f6 = hVar2.h;
        float f7 = hVar.h;
        this.d = this.c;
        float f8 = hVar.e;
        float f9 = hVar.f;
        float f10 = (hVar2.e + (f4 / 2.0f)) - ((f5 / 2.0f) + f8);
        float f11 = (hVar2.f + (f6 / 2.0f)) - (f9 + (f7 / 2.0f));
        float f12 = (f4 - f5) * f2;
        float f13 = f12 / 2.0f;
        this.e = (int) ((f8 + (f10 * f)) - f13);
        float f14 = (f6 - f7) * f3;
        float f15 = f14 / 2.0f;
        this.f = (int) ((f9 + (f11 * f)) - f15);
        this.g = (int) (f5 + f12);
        this.h = (int) (f7 + f14);
        float f16 = Float.isNaN(dVar.m) ? f : dVar.m;
        float f17 = Float.isNaN(dVar.p) ? 0.0f : dVar.p;
        if (!Float.isNaN(dVar.n)) {
            f = dVar.n;
        }
        float f18 = Float.isNaN(dVar.o) ? 0.0f : dVar.o;
        this.p = 0;
        this.e = (int) (((hVar.e + (f16 * f10)) + (f18 * f11)) - f13);
        this.f = (int) (((hVar.f + (f10 * f17)) + (f11 * f)) - f15);
        this.a = ye0.c(dVar.h);
        this.k = dVar.i;
    }

    void m(d dVar, h hVar, h hVar2) {
        float f = dVar.a / 100.0f;
        this.c = f;
        this.b = dVar.j;
        float f2 = Float.isNaN(dVar.k) ? f : dVar.k;
        float f3 = Float.isNaN(dVar.l) ? f : dVar.l;
        float f4 = hVar2.g - hVar.g;
        float f5 = hVar2.h - hVar.h;
        this.d = this.c;
        if (!Float.isNaN(dVar.m)) {
            f = dVar.m;
        }
        float f6 = hVar.e;
        float f7 = hVar.g;
        float f8 = hVar.f;
        float f9 = hVar.h;
        float f10 = (hVar2.e + (hVar2.g / 2.0f)) - ((f7 / 2.0f) + f6);
        float f11 = (hVar2.f + (hVar2.h / 2.0f)) - ((f9 / 2.0f) + f8);
        float f12 = f10 * f;
        float f13 = f4 * f2;
        float f14 = f13 / 2.0f;
        this.e = (int) ((f6 + f12) - f14);
        float f15 = f * f11;
        float f16 = f5 * f3;
        float f17 = f16 / 2.0f;
        this.f = (int) ((f8 + f15) - f17);
        this.g = (int) (f7 + f13);
        this.h = (int) (f9 + f16);
        float f18 = Float.isNaN(dVar.n) ? 0.0f : dVar.n;
        this.p = 1;
        float f19 = (int) ((hVar.e + f12) - f14);
        float f20 = (int) ((hVar.f + f15) - f17);
        this.e = f19 + ((-f11) * f18);
        this.f = f20 + (f10 * f18);
        this.l = this.l;
        this.a = ye0.c(dVar.h);
        this.k = dVar.i;
    }

    void n(int i, int i2, d dVar, h hVar, h hVar2) {
        float fMin;
        float f;
        float f2 = dVar.a / 100.0f;
        this.c = f2;
        this.b = dVar.j;
        this.p = dVar.f173q;
        float f3 = Float.isNaN(dVar.k) ? f2 : dVar.k;
        float f4 = Float.isNaN(dVar.l) ? f2 : dVar.l;
        float f5 = hVar2.g;
        float f6 = hVar.g;
        float f7 = hVar2.h;
        float f8 = hVar.h;
        this.d = this.c;
        this.g = (int) (f6 + ((f5 - f6) * f3));
        this.h = (int) (f8 + ((f7 - f8) * f4));
        int i3 = dVar.f173q;
        if (i3 == 1) {
            float f9 = Float.isNaN(dVar.m) ? f2 : dVar.m;
            float f10 = hVar2.e;
            float f11 = hVar.e;
            this.e = (f9 * (f10 - f11)) + f11;
            if (!Float.isNaN(dVar.n)) {
                f2 = dVar.n;
            }
            float f12 = hVar2.f;
            float f13 = hVar.f;
            this.f = (f2 * (f12 - f13)) + f13;
        } else if (i3 != 2) {
            float f14 = Float.isNaN(dVar.m) ? f2 : dVar.m;
            float f15 = hVar2.e;
            float f16 = hVar.e;
            this.e = (f14 * (f15 - f16)) + f16;
            if (!Float.isNaN(dVar.n)) {
                f2 = dVar.n;
            }
            float f17 = hVar2.f;
            float f18 = hVar.f;
            this.f = (f2 * (f17 - f18)) + f18;
        } else {
            if (Float.isNaN(dVar.m)) {
                float f19 = hVar2.e;
                float f20 = hVar.e;
                fMin = ((f19 - f20) * f2) + f20;
            } else {
                fMin = Math.min(f4, f3) * dVar.m;
            }
            this.e = fMin;
            if (Float.isNaN(dVar.n)) {
                float f21 = hVar2.f;
                float f22 = hVar.f;
                f = (f2 * (f21 - f22)) + f22;
            } else {
                f = dVar.n;
            }
            this.f = f;
        }
        this.l = hVar.l;
        this.a = ye0.c(dVar.h);
        this.k = dVar.i;
    }

    void o(int i, int i2, d dVar, h hVar, h hVar2) {
        float f = dVar.a / 100.0f;
        this.c = f;
        this.b = dVar.j;
        float f2 = Float.isNaN(dVar.k) ? f : dVar.k;
        float f3 = Float.isNaN(dVar.l) ? f : dVar.l;
        float f4 = hVar2.g;
        float f5 = hVar.g;
        float f6 = hVar2.h;
        float f7 = hVar.h;
        this.d = this.c;
        float f8 = hVar.e;
        float f9 = hVar.f;
        float f10 = hVar2.e + (f4 / 2.0f);
        float f11 = hVar2.f + (f6 / 2.0f);
        float f12 = (f4 - f5) * f2;
        this.e = (int) ((f8 + ((f10 - ((f5 / 2.0f) + f8)) * f)) - (f12 / 2.0f));
        float f13 = (f6 - f7) * f3;
        this.f = (int) ((f9 + ((f11 - (f9 + (f7 / 2.0f))) * f)) - (f13 / 2.0f));
        this.g = (int) (f5 + f12);
        this.h = (int) (f7 + f13);
        this.p = 2;
        if (!Float.isNaN(dVar.m)) {
            this.e = (int) (dVar.m * ((int) (i - this.g)));
        }
        if (!Float.isNaN(dVar.n)) {
            this.f = (int) (dVar.n * ((int) (i2 - this.h)));
        }
        this.l = this.l;
        this.a = ye0.c(dVar.h);
        this.k = dVar.i;
    }

    void p(float f, float f2, float f3, float f4) {
        this.e = f;
        this.f = f2;
        this.g = f3;
        this.h = f4;
    }

    void q(float f, float f2, float[] fArr, int[] iArr, double[] dArr, double[] dArr2) {
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        for (int i = 0; i < iArr.length; i++) {
            float f7 = (float) dArr[i];
            double d = dArr2[i];
            int i2 = iArr[i];
            if (i2 == 1) {
                f3 = f7;
            } else if (i2 == 2) {
                f5 = f7;
            } else if (i2 == 3) {
                f4 = f7;
            } else if (i2 == 4) {
                f6 = f7;
            }
        }
        float f8 = f3 - ((0.0f * f4) / 2.0f);
        float f9 = f5 - ((0.0f * f6) / 2.0f);
        fArr[0] = (f8 * (1.0f - f)) + (((f4 * 1.0f) + f8) * f) + 0.0f;
        fArr[1] = (f9 * (1.0f - f2)) + (((f6 * 1.0f) + f9) * f2) + 0.0f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    void r(float f, View view, int[] iArr, double[] dArr, double[] dArr2, double[] dArr3, boolean z) {
        float f2;
        float f3;
        float f4 = this.e;
        float f5 = this.f;
        float f6 = this.g;
        float f7 = this.h;
        if (iArr.length != 0 && this.r.length <= iArr[iArr.length - 1]) {
            int i = iArr[iArr.length - 1] + 1;
            this.r = new double[i];
            this.s = new double[i];
        }
        Arrays.fill(this.r, Double.NaN);
        for (int i2 = 0; i2 < iArr.length; i2++) {
            double[] dArr4 = this.r;
            int i3 = iArr[i2];
            dArr4[i3] = dArr[i2];
            this.s[i3] = dArr2[i2];
        }
        float f8 = Float.NaN;
        int i4 = 0;
        float f9 = 0.0f;
        float f10 = 0.0f;
        float f11 = 0.0f;
        float f12 = 0.0f;
        while (true) {
            double[] dArr5 = this.r;
            if (i4 >= dArr5.length) {
                break;
            }
            if (Double.isNaN(dArr5[i4]) && (dArr3 == null || dArr3[i4] == 0.0d)) {
                f3 = f8;
            } else {
                double d = dArr3 != null ? dArr3[i4] : 0.0d;
                if (!Double.isNaN(this.r[i4])) {
                    d = this.r[i4] + d;
                }
                f3 = f8;
                float f13 = (float) d;
                float f14 = (float) this.s[i4];
                if (i4 == 1) {
                    f8 = f3;
                    f9 = f14;
                    f4 = f13;
                } else if (i4 == 2) {
                    f8 = f3;
                    f10 = f14;
                    f5 = f13;
                } else if (i4 == 3) {
                    f8 = f3;
                    f11 = f14;
                    f6 = f13;
                } else if (i4 == 4) {
                    f8 = f3;
                    f12 = f14;
                    f7 = f13;
                } else if (i4 == 5) {
                    f8 = f13;
                }
                i4++;
            }
            f8 = f3;
            i4++;
        }
        float f15 = f8;
        g gVar = this.n;
        if (gVar != null) {
            float[] fArr = new float[2];
            float[] fArr2 = new float[2];
            gVar.i(f, fArr, fArr2);
            float f16 = fArr[0];
            float f17 = fArr[1];
            float f18 = fArr2[0];
            float f19 = fArr2[1];
            double d2 = f4;
            double d3 = f5;
            float fSin = (float) ((((double) f16) + (Math.sin(d3) * d2)) - ((double) (f6 / 2.0f)));
            f2 = f7;
            float fCos = (float) ((((double) f17) - (Math.cos(d3) * d2)) - ((double) (f7 / 2.0f)));
            double d4 = f9;
            double d5 = f10;
            float fSin2 = (float) (((double) f18) + (Math.sin(d3) * d4) + (Math.cos(d3) * d2 * d5));
            float fCos2 = (float) ((((double) f19) - (d4 * Math.cos(d3))) + (d2 * Math.sin(d3) * d5));
            if (dArr2.length >= 2) {
                dArr2[0] = fSin2;
                dArr2[1] = fCos2;
            }
            if (!Float.isNaN(f15)) {
                view.setRotation((float) (((double) f15) + Math.toDegrees(Math.atan2(fCos2, fSin2))));
            }
            f4 = fSin;
            f5 = fCos;
        } else {
            f2 = f7;
            if (!Float.isNaN(f15)) {
                view.setRotation((float) (((double) 0.0f) + ((double) f15) + Math.toDegrees(Math.atan2(f10 + (f12 / 2.0f), f9 + (f11 / 2.0f)))));
            }
        }
        if (view instanceof zn0) {
            ((zn0) view).a(f4, f5, f6 + f4, f5 + f2);
            return;
        }
        float f20 = f4 + 0.5f;
        int i5 = (int) f20;
        float f21 = f5 + 0.5f;
        int i6 = (int) f21;
        int i7 = (int) (f20 + f6);
        int i8 = (int) (f21 + f2);
        int i9 = i7 - i5;
        int i10 = i8 - i6;
        if (i9 != view.getMeasuredWidth() || i10 != view.getMeasuredHeight() || z) {
            view.measure(View.MeasureSpec.makeMeasureSpec(i9, 1073741824), View.MeasureSpec.makeMeasureSpec(i10, 1073741824));
        }
        view.layout(i5, i6, i7, i8);
    }

    public void s(g gVar, h hVar) {
        double d = ((this.e + (this.g / 2.0f)) - hVar.e) - (hVar.g / 2.0f);
        double d2 = ((this.f + (this.h / 2.0f)) - hVar.f) - (hVar.h / 2.0f);
        this.n = gVar;
        this.e = (float) Math.hypot(d2, d);
        if (Float.isNaN(this.m)) {
            this.f = (float) (Math.atan2(d2, d) + 1.5707963267948966d);
        } else {
            this.f = (float) Math.toRadians(this.m);
        }
    }

    public h(int i, int i2, d dVar, h hVar, h hVar2) {
        int i3 = a.f;
        this.k = i3;
        this.l = i3;
        this.m = Float.NaN;
        this.n = null;
        this.o = new LinkedHashMap();
        this.p = 0;
        this.r = new double[18];
        this.s = new double[18];
        if (hVar.l != a.f) {
            n(i, i2, dVar, hVar, hVar2);
            return;
        }
        int i4 = dVar.f173q;
        if (i4 == 1) {
            m(dVar, hVar, hVar2);
        } else if (i4 != 2) {
            l(dVar, hVar, hVar2);
        } else {
            o(i, i2, dVar, hVar, hVar2);
        }
    }
}
