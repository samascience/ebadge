package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import defpackage.cf3;
import defpackage.d70;
import defpackage.df3;
import defpackage.ff3;
import defpackage.h91;
import defpackage.hb3;
import defpackage.j50;
import defpackage.oe3;
import defpackage.rs2;
import defpackage.ye0;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class g {
    private HashMap B;
    private HashMap C;
    private HashMap D;
    private h91[] E;
    private int F;
    private int G;
    private View H;
    private int I;
    private float J;
    private Interpolator K;
    private boolean L;
    View b;
    int c;
    String e;
    private j50[] k;
    private j50 l;
    float p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    float f175q;
    private int[] r;
    private double[] s;
    private double[] t;
    private String[] u;
    private int[] v;
    Rect a = new Rect();
    boolean d = false;
    private int f = -1;
    private h g = new h();
    private h h = new h();
    private f i = new f();
    private f j = new f();
    float m = Float.NaN;
    float n = 0.0f;
    float o = 1.0f;
    private int w = 4;
    private float[] x = new float[4];
    private ArrayList y = new ArrayList();
    private float[] z = new float[1];
    private ArrayList A = new ArrayList();

    class a implements Interpolator {
        final /* synthetic */ ye0 a;

        a(ye0 ye0Var) {
            this.a = ye0Var;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return (float) this.a.a(f);
        }
    }

    g(View view) {
        int i = androidx.constraintlayout.motion.widget.a.f;
        this.F = i;
        this.G = i;
        this.H = null;
        this.I = i;
        this.J = Float.NaN;
        this.K = null;
        this.L = false;
        H(view);
    }

    private float g(float f, float[] fArr) {
        float f2 = 0.0f;
        if (fArr != null) {
            fArr[0] = 1.0f;
        } else {
            float f3 = this.o;
            if (f3 != 1.0d) {
                float f4 = this.n;
                if (f < f4) {
                    f = 0.0f;
                }
                if (f > f4 && f < 1.0d) {
                    f = Math.min((f - f4) * f3, 1.0f);
                }
            }
        }
        ye0 ye0Var = this.g.a;
        float f5 = Float.NaN;
        for (h hVar : this.y) {
            ye0 ye0Var2 = hVar.a;
            if (ye0Var2 != null) {
                float f6 = hVar.c;
                if (f6 < f) {
                    ye0Var = ye0Var2;
                    f2 = f6;
                } else if (Float.isNaN(f5)) {
                    f5 = hVar.c;
                }
            }
        }
        if (ye0Var != null) {
            float f7 = (Float.isNaN(f5) ? 1.0f : f5) - f2;
            double d = (f - f2) / f7;
            f = (((float) ye0Var.a(d)) * f7) + f2;
            if (fArr != null) {
                fArr[0] = (float) ye0Var.b(d);
            }
        }
        return f;
    }

    private static Interpolator p(Context context, int i, String str, int i2) {
        if (i == -2) {
            return AnimationUtils.loadInterpolator(context, i2);
        }
        if (i == -1) {
            return new a(ye0.c(str));
        }
        if (i == 0) {
            return new AccelerateDecelerateInterpolator();
        }
        if (i == 1) {
            return new AccelerateInterpolator();
        }
        if (i == 2) {
            return new DecelerateInterpolator();
        }
        if (i == 4) {
            return new BounceInterpolator();
        }
        if (i != 5) {
            return null;
        }
        return new OvershootInterpolator();
    }

    private float s() {
        char c;
        float fHypot;
        float[] fArr = new float[2];
        float f = 1.0f / 99;
        double d = 0.0d;
        double d2 = 0.0d;
        float f2 = 0.0f;
        int i = 0;
        while (i < 100) {
            float f3 = i * f;
            double dA = f3;
            ye0 ye0Var = this.g.a;
            float f4 = Float.NaN;
            float f5 = 0.0f;
            for (h hVar : this.y) {
                ye0 ye0Var2 = hVar.a;
                if (ye0Var2 != null) {
                    float f6 = hVar.c;
                    if (f6 < f3) {
                        ye0Var = ye0Var2;
                        f5 = f6;
                    } else if (Float.isNaN(f4)) {
                        f4 = hVar.c;
                    }
                }
            }
            if (ye0Var != null) {
                if (Float.isNaN(f4)) {
                    f4 = 1.0f;
                }
                float f7 = f4 - f5;
                dA = (((float) ye0Var.a((f3 - f5) / f7)) * f7) + f5;
            }
            this.k[0].d(dA, this.s);
            float f8 = f2;
            int i2 = i;
            this.g.f(dA, this.r, this.s, fArr, 0);
            if (i2 > 0) {
                c = 0;
                fHypot = (float) (((double) f8) + Math.hypot(d2 - ((double) fArr[1]), d - ((double) fArr[0])));
            } else {
                c = 0;
                fHypot = f8;
            }
            d = fArr[c];
            i = i2 + 1;
            f2 = fHypot;
            d2 = fArr[1];
        }
        return f2;
    }

    private void w(h hVar) {
        int iBinarySearch = Collections.binarySearch(this.y, hVar);
        if (iBinarySearch == 0) {
            Log.e("MotionController", " KeyPath position \"" + hVar.d + "\" outside of range");
        }
        this.y.add((-iBinarySearch) - 1, hVar);
    }

    private void y(h hVar) {
        hVar.p((int) this.b.getX(), (int) this.b.getY(), this.b.getWidth(), this.b.getHeight());
    }

    void A(Rect rect, Rect rect2, int i, int i2, int i3) {
        if (i == 1) {
            int i4 = rect.left + rect.right;
            rect2.left = ((rect.top + rect.bottom) - rect.width()) / 2;
            rect2.top = i3 - ((i4 + rect.height()) / 2);
            rect2.right = rect2.left + rect.width();
            rect2.bottom = rect2.top + rect.height();
            return;
        }
        if (i == 2) {
            int i5 = rect.left + rect.right;
            rect2.left = i2 - (((rect.top + rect.bottom) + rect.width()) / 2);
            rect2.top = (i5 - rect.height()) / 2;
            rect2.right = rect2.left + rect.width();
            rect2.bottom = rect2.top + rect.height();
            return;
        }
        if (i == 3) {
            int i6 = rect.left + rect.right;
            rect2.left = ((rect.height() / 2) + rect.top) - (i6 / 2);
            rect2.top = i3 - ((i6 + rect.height()) / 2);
            rect2.right = rect2.left + rect.width();
            rect2.bottom = rect2.top + rect.height();
            return;
        }
        if (i != 4) {
            return;
        }
        int i7 = rect.left + rect.right;
        rect2.left = i2 - (((rect.bottom + rect.top) + rect.width()) / 2);
        rect2.top = (i7 - rect.height()) / 2;
        rect2.right = rect2.left + rect.width();
        rect2.bottom = rect2.top + rect.height();
    }

    void B(View view) {
        h hVar = this.g;
        hVar.c = 0.0f;
        hVar.d = 0.0f;
        this.L = true;
        hVar.p(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        this.h.p(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        this.i.i(view);
        this.j.i(view);
    }

    void C(Rect rect, androidx.constraintlayout.widget.b bVar, int i, int i2) {
        int i3 = bVar.d;
        if (i3 != 0) {
            A(rect, this.a, i3, i, i2);
            rect = this.a;
        }
        h hVar = this.h;
        hVar.c = 1.0f;
        hVar.d = 1.0f;
        y(hVar);
        this.h.p(rect.left, rect.top, rect.width(), rect.height());
        this.h.a(bVar.y(this.c));
        this.j.h(rect, bVar, i3, this.c);
    }

    public void D(int i) {
        this.F = i;
    }

    void E(View view) {
        h hVar = this.g;
        hVar.c = 0.0f;
        hVar.d = 0.0f;
        hVar.p(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        this.i.i(view);
    }

    public void F(df3 df3Var, View view, int i, int i2, int i3) {
        h hVar = this.g;
        hVar.c = 0.0f;
        hVar.d = 0.0f;
        Rect rect = new Rect();
        if (i == 1 || i == 2) {
            throw null;
        }
        this.g.p(rect.left, rect.top, rect.width(), rect.height());
        throw null;
    }

    void G(Rect rect, androidx.constraintlayout.widget.b bVar, int i, int i2) {
        int i3 = bVar.d;
        if (i3 != 0) {
            A(rect, this.a, i3, i, i2);
        }
        h hVar = this.g;
        hVar.c = 0.0f;
        hVar.d = 0.0f;
        y(hVar);
        this.g.p(rect.left, rect.top, rect.width(), rect.height());
        androidx.constraintlayout.widget.b.a aVarY = bVar.y(this.c);
        this.g.a(aVarY);
        this.m = aVarY.d.g;
        this.i.h(rect, bVar, i3, this.c);
        this.G = aVarY.f.i;
        androidx.constraintlayout.widget.b.c cVar = aVarY.d;
        this.I = cVar.k;
        this.J = cVar.j;
        Context context = this.b.getContext();
        androidx.constraintlayout.widget.b.c cVar2 = aVarY.d;
        this.K = p(context, cVar2.m, cVar2.l, cVar2.n);
    }

    public void H(View view) {
        this.b = view;
        this.c = view.getId();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.b) {
            this.e = ((ConstraintLayout.b) layoutParams).a();
        }
    }

    public void I(int i, int i2, float f, long j) {
        String[] strArr;
        ConstraintAttribute constraintAttribute;
        ff3 ff3VarG;
        ConstraintAttribute constraintAttribute2;
        Integer num;
        cf3 cf3VarG;
        ConstraintAttribute constraintAttribute3;
        new HashSet();
        HashSet<String> hashSet = new HashSet();
        HashSet<String> hashSet2 = new HashSet();
        HashSet<String> hashSet3 = new HashSet();
        HashMap map = new HashMap();
        int i3 = this.F;
        if (i3 != androidx.constraintlayout.motion.widget.a.f) {
            this.g.k = i3;
        }
        this.i.f(this.j, hashSet2);
        ArrayList<androidx.constraintlayout.motion.widget.a> arrayList = this.A;
        if (arrayList != null) {
            for (androidx.constraintlayout.motion.widget.a aVar : arrayList) {
                if (aVar instanceof d) {
                    d dVar = (d) aVar;
                    w(new h(i, i2, dVar, this.g, this.h));
                    int i4 = dVar.g;
                    if (i4 != androidx.constraintlayout.motion.widget.a.f) {
                        this.f = i4;
                    }
                } else {
                    aVar.h(map);
                    aVar.d(hashSet2);
                }
            }
        }
        char c = 1;
        if (!hashSet2.isEmpty()) {
            this.C = new HashMap();
            for (String str : hashSet2) {
                if (str.startsWith("CUSTOM,")) {
                    SparseArray sparseArray = new SparseArray();
                    String str2 = str.split(",")[1];
                    for (androidx.constraintlayout.motion.widget.a aVar2 : this.A) {
                        HashMap map2 = aVar2.e;
                        if (map2 != null && (constraintAttribute3 = (ConstraintAttribute) map2.get(str2)) != null) {
                            sparseArray.append(aVar2.a, constraintAttribute3);
                        }
                    }
                    cf3VarG = cf3.f(str, sparseArray);
                } else {
                    cf3VarG = cf3.g(str);
                }
                if (cf3VarG != null) {
                    cf3VarG.d(str);
                    this.C.put(str, cf3VarG);
                }
            }
            ArrayList<androidx.constraintlayout.motion.widget.a> arrayList2 = this.A;
            if (arrayList2 != null) {
                for (androidx.constraintlayout.motion.widget.a aVar3 : arrayList2) {
                    if (aVar3 instanceof b) {
                        aVar3.a(this.C);
                    }
                }
            }
            this.i.a(this.C, 0);
            this.j.a(this.C, 100);
            for (String str3 : this.C.keySet()) {
                int iIntValue = (!map.containsKey(str3) || (num = (Integer) map.get(str3)) == null) ? 0 : num.intValue();
                rs2 rs2Var = (rs2) this.C.get(str3);
                if (rs2Var != null) {
                    rs2Var.e(iIntValue);
                }
            }
        }
        if (!hashSet.isEmpty()) {
            if (this.B == null) {
                this.B = new HashMap();
            }
            for (String str4 : hashSet) {
                if (!this.B.containsKey(str4)) {
                    if (str4.startsWith("CUSTOM,")) {
                        SparseArray sparseArray2 = new SparseArray();
                        String str5 = str4.split(",")[1];
                        for (androidx.constraintlayout.motion.widget.a aVar4 : this.A) {
                            HashMap map3 = aVar4.e;
                            if (map3 != null && (constraintAttribute2 = (ConstraintAttribute) map3.get(str5)) != null) {
                                sparseArray2.append(aVar4.a, constraintAttribute2);
                            }
                        }
                        ff3VarG = ff3.f(str4, sparseArray2);
                    } else {
                        ff3VarG = ff3.g(str4, j);
                    }
                    if (ff3VarG != null) {
                        ff3VarG.c(str4);
                        this.B.put(str4, ff3VarG);
                    }
                }
            }
            ArrayList<androidx.constraintlayout.motion.widget.a> arrayList3 = this.A;
            if (arrayList3 != null) {
                for (androidx.constraintlayout.motion.widget.a aVar5 : arrayList3) {
                }
            }
            for (String str6 : this.B.keySet()) {
                ((ff3) this.B.get(str6)).d(map.containsKey(str6) ? ((Integer) map.get(str6)).intValue() : 0);
            }
        }
        int size = this.y.size();
        int i5 = size + 2;
        h[] hVarArr = new h[i5];
        hVarArr[0] = this.g;
        hVarArr[size + 1] = this.h;
        if (this.y.size() > 0 && this.f == -1) {
            this.f = 0;
        }
        Iterator it = this.y.iterator();
        int i6 = 1;
        while (it.hasNext()) {
            hVarArr[i6] = (h) it.next();
            i6++;
        }
        HashSet hashSet4 = new HashSet();
        for (String str7 : this.h.o.keySet()) {
            if (this.g.o.containsKey(str7)) {
                if (!hashSet2.contains("CUSTOM," + str7)) {
                    hashSet4.add(str7);
                }
            }
        }
        String[] strArr2 = (String[]) hashSet4.toArray(new String[0]);
        this.u = strArr2;
        this.v = new int[strArr2.length];
        int i7 = 0;
        while (true) {
            strArr = this.u;
            if (i7 >= strArr.length) {
                break;
            }
            String str8 = strArr[i7];
            this.v[i7] = 0;
            for (int i8 = 0; i8 < i5; i8++) {
                if (hVarArr[i8].o.containsKey(str8) && (constraintAttribute = (ConstraintAttribute) hVarArr[i8].o.get(str8)) != null) {
                    int[] iArr = this.v;
                    iArr[i7] = iArr[i7] + constraintAttribute.g();
                    break;
                }
            }
            i7++;
        }
        boolean z = hVarArr[0].k != androidx.constraintlayout.motion.widget.a.f;
        int length = 18 + strArr.length;
        boolean[] zArr = new boolean[length];
        for (int i9 = 1; i9 < i5; i9++) {
            hVarArr[i9].d(hVarArr[i9 - 1], zArr, this.u, z);
        }
        int i10 = 0;
        for (int i11 = 1; i11 < length; i11++) {
            if (zArr[i11]) {
                i10++;
            }
        }
        this.r = new int[i10];
        int i12 = 2;
        int iMax = Math.max(2, i10);
        this.s = new double[iMax];
        this.t = new double[iMax];
        int i13 = 0;
        for (int i14 = 1; i14 < length; i14++) {
            if (zArr[i14]) {
                this.r[i13] = i14;
                i13++;
            }
        }
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i5, this.r.length);
        double[] dArr2 = new double[i5];
        for (int i15 = 0; i15 < i5; i15++) {
            hVarArr[i15].e(dArr[i15], this.r);
            dArr2[i15] = hVarArr[i15].c;
        }
        int i16 = 0;
        while (true) {
            int[] iArr2 = this.r;
            if (i16 >= iArr2.length) {
                break;
            }
            if (iArr2[i16] < h.t.length) {
                String str9 = h.t[this.r[i16]] + " [";
                for (int i17 = 0; i17 < i5; i17++) {
                    str9 = str9 + dArr[i17][i16];
                }
            }
            i16++;
        }
        this.k = new j50[this.u.length + 1];
        int i18 = 0;
        while (true) {
            String[] strArr3 = this.u;
            if (i18 >= strArr3.length) {
                break;
            }
            String str10 = strArr3[i18];
            double[] dArr3 = null;
            int i19 = 0;
            int i20 = 0;
            double[][] dArr4 = null;
            while (i19 < i5) {
                if (hVarArr[i19].k(str10)) {
                    if (dArr4 == null) {
                        dArr3 = new double[i5];
                        int[] iArr3 = new int[i12];
                        iArr3[c] = hVarArr[i19].i(str10);
                        iArr3[0] = i5;
                        dArr4 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, iArr3);
                    }
                    h hVar = hVarArr[i19];
                    dArr3[i20] = hVar.c;
                    hVar.h(str10, dArr4[i20], 0);
                    i20++;
                }
                i19++;
                dArr = dArr;
                i12 = 2;
                c = 1;
            }
            i18++;
            this.k[i18] = j50.a(this.f, Arrays.copyOf(dArr3, i20), (double[][]) Arrays.copyOf(dArr4, i20));
            dArr = dArr;
            i12 = 2;
            c = 1;
        }
        this.k[0] = j50.a(this.f, dArr2, dArr);
        if (hVarArr[0].k != androidx.constraintlayout.motion.widget.a.f) {
            int[] iArr4 = new int[i5];
            double[] dArr5 = new double[i5];
            double[][] dArr6 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i5, 2);
            for (int i21 = 0; i21 < i5; i21++) {
                h hVar2 = hVarArr[i21];
                iArr4[i21] = hVar2.k;
                dArr5[i21] = hVar2.c;
                double[] dArr7 = dArr6[i21];
                dArr7[0] = hVar2.e;
                dArr7[1] = hVar2.f;
            }
            this.l = j50.b(iArr4, dArr5, dArr6);
        }
        this.D = new HashMap();
        if (this.A != null) {
            float fS = Float.NaN;
            for (String str11 : hashSet3) {
                oe3 oe3VarF = oe3.f(str11);
                if (oe3VarF != null) {
                    if (oe3VarF.e() && Float.isNaN(fS)) {
                        fS = s();
                    }
                    oe3VarF.c(str11);
                    this.D.put(str11, oe3VarF);
                }
            }
            for (androidx.constraintlayout.motion.widget.a aVar6 : this.A) {
            }
            Iterator it2 = this.D.values().iterator();
            while (it2.hasNext()) {
                ((oe3) it2.next()).d(fS);
            }
        }
    }

    public void J(g gVar) {
        this.g.s(gVar, gVar.g);
        this.h.s(gVar, gVar.h);
    }

    public void a(androidx.constraintlayout.motion.widget.a aVar) {
        this.A.add(aVar);
    }

    void b(ArrayList arrayList) {
        this.A.addAll(arrayList);
    }

    int c(float[] fArr, int[] iArr) {
        if (fArr == null) {
            return 0;
        }
        double[] dArrH = this.k[0].h();
        if (iArr != null) {
            Iterator it = this.y.iterator();
            int i = 0;
            while (it.hasNext()) {
                iArr[i] = ((h) it.next()).p;
                i++;
            }
        }
        int i2 = 0;
        for (int i3 = 0; i3 < dArrH.length; i3++) {
            this.k[0].d(dArrH[i3], this.s);
            this.g.f(dArrH[i3], this.r, this.s, fArr, i2);
            i2 += 2;
        }
        return i2 / 2;
    }

    void d(float[] fArr, int i) {
        double dA;
        float f = 1.0f;
        float f2 = 1.0f / (i - 1);
        HashMap map = this.C;
        rs2 rs2Var = map == null ? null : (rs2) map.get("translationX");
        HashMap map2 = this.C;
        rs2 rs2Var2 = map2 == null ? null : (rs2) map2.get("translationY");
        HashMap map3 = this.D;
        oe3 oe3Var = map3 == null ? null : (oe3) map3.get("translationX");
        HashMap map4 = this.D;
        oe3 oe3Var2 = map4 != null ? (oe3) map4.get("translationY") : null;
        int i2 = 0;
        while (i2 < i) {
            float fMin = i2 * f2;
            float f3 = this.o;
            float f4 = 0.0f;
            if (f3 != f) {
                float f5 = this.n;
                if (fMin < f5) {
                    fMin = 0.0f;
                }
                if (fMin > f5 && fMin < 1.0d) {
                    fMin = Math.min((fMin - f5) * f3, f);
                }
            }
            float f6 = fMin;
            double d = f6;
            ye0 ye0Var = this.g.a;
            float f7 = Float.NaN;
            for (h hVar : this.y) {
                ye0 ye0Var2 = hVar.a;
                double d2 = d;
                if (ye0Var2 != null) {
                    float f8 = hVar.c;
                    if (f8 < f6) {
                        f4 = f8;
                        ye0Var = ye0Var2;
                    } else if (Float.isNaN(f7)) {
                        f7 = hVar.c;
                    }
                }
                d = d2;
            }
            double d3 = d;
            if (ye0Var != null) {
                if (Float.isNaN(f7)) {
                    f7 = 1.0f;
                }
                float f9 = f7 - f4;
                dA = (((float) ye0Var.a((f6 - f4) / f9)) * f9) + f4;
            } else {
                dA = d3;
            }
            this.k[0].d(dA, this.s);
            j50 j50Var = this.l;
            if (j50Var != null) {
                double[] dArr = this.s;
                if (dArr.length > 0) {
                    j50Var.d(dA, dArr);
                }
            }
            int i3 = i2 * 2;
            int i4 = i2;
            this.g.f(dA, this.r, this.s, fArr, i3);
            if (oe3Var != null) {
                fArr[i3] = fArr[i3] + oe3Var.a(f6);
            } else if (rs2Var != null) {
                fArr[i3] = fArr[i3] + rs2Var.a(f6);
            }
            if (oe3Var2 != null) {
                int i5 = i3 + 1;
                fArr[i5] = fArr[i5] + oe3Var2.a(f6);
            } else if (rs2Var2 != null) {
                int i6 = i3 + 1;
                fArr[i6] = fArr[i6] + rs2Var2.a(f6);
            }
            i2 = i4 + 1;
            f = 1.0f;
        }
    }

    void e(float f, float[] fArr, int i) {
        this.k[0].d(g(f, null), this.s);
        this.g.j(this.r, this.s, fArr, i);
    }

    void f(boolean z) {
        h91[] h91VarArr;
        if (!"button".equals(d70.d(this.b)) || (h91VarArr = this.E) == null || h91VarArr.length <= 0) {
            return;
        }
        h91 h91Var = h91VarArr[0];
        throw null;
    }

    public int h() {
        return this.g.l;
    }

    public void i(double d, float[] fArr, float[] fArr2) {
        double[] dArr = new double[4];
        double[] dArr2 = new double[4];
        this.k[0].d(d, dArr);
        this.k[0].g(d, dArr2);
        Arrays.fill(fArr2, 0.0f);
        this.g.g(d, this.r, dArr, fArr, dArr2, fArr2);
    }

    public float j() {
        return this.p;
    }

    public float k() {
        return this.f175q;
    }

    void l(float f, float f2, float f3, float[] fArr) {
        double[] dArr;
        float fG = g(f, this.z);
        j50[] j50VarArr = this.k;
        int i = 0;
        if (j50VarArr == null) {
            h hVar = this.h;
            float f4 = hVar.e;
            h hVar2 = this.g;
            float f5 = f4 - hVar2.e;
            float f6 = hVar.f - hVar2.f;
            float f7 = (hVar.g - hVar2.g) + f5;
            float f8 = (hVar.h - hVar2.h) + f6;
            fArr[0] = (f5 * (1.0f - f2)) + (f7 * f2);
            fArr[1] = (f6 * (1.0f - f3)) + (f8 * f3);
            return;
        }
        double d = fG;
        j50VarArr[0].g(d, this.t);
        this.k[0].d(d, this.s);
        float f9 = this.z[0];
        while (true) {
            dArr = this.t;
            if (i >= dArr.length) {
                break;
            }
            dArr[i] = dArr[i] * ((double) f9);
            i++;
        }
        j50 j50Var = this.l;
        if (j50Var == null) {
            this.g.q(f2, f3, fArr, this.r, dArr, this.s);
            return;
        }
        double[] dArr2 = this.s;
        if (dArr2.length > 0) {
            j50Var.d(d, dArr2);
            this.l.g(d, this.t);
            this.g.q(f2, f3, fArr, this.r, this.t, this.s);
        }
    }

    public int m() {
        int iMax = this.g.b;
        Iterator it = this.y.iterator();
        while (it.hasNext()) {
            iMax = Math.max(iMax, ((h) it.next()).b);
        }
        return Math.max(iMax, this.h.b);
    }

    public float n() {
        return this.h.e;
    }

    public float o() {
        return this.h.f;
    }

    h q(int i) {
        return (h) this.y.get(i);
    }

    void r(float f, int i, int i2, float f2, float f3, float[] fArr) {
        float fG = g(f, this.z);
        HashMap map = this.C;
        rs2 rs2Var = map == null ? null : (rs2) map.get("translationX");
        HashMap map2 = this.C;
        rs2 rs2Var2 = map2 == null ? null : (rs2) map2.get("translationY");
        HashMap map3 = this.C;
        rs2 rs2Var3 = map3 == null ? null : (rs2) map3.get("rotation");
        HashMap map4 = this.C;
        rs2 rs2Var4 = map4 == null ? null : (rs2) map4.get("scaleX");
        HashMap map5 = this.C;
        rs2 rs2Var5 = map5 == null ? null : (rs2) map5.get("scaleY");
        HashMap map6 = this.D;
        oe3 oe3Var = map6 == null ? null : (oe3) map6.get("translationX");
        HashMap map7 = this.D;
        oe3 oe3Var2 = map7 == null ? null : (oe3) map7.get("translationY");
        HashMap map8 = this.D;
        oe3 oe3Var3 = map8 == null ? null : (oe3) map8.get("rotation");
        HashMap map9 = this.D;
        oe3 oe3Var4 = map9 == null ? null : (oe3) map9.get("scaleX");
        HashMap map10 = this.D;
        oe3 oe3Var5 = map10 != null ? (oe3) map10.get("scaleY") : null;
        hb3 hb3Var = new hb3();
        hb3Var.b();
        hb3Var.d(rs2Var3, fG);
        hb3Var.h(rs2Var, rs2Var2, fG);
        hb3Var.f(rs2Var4, rs2Var5, fG);
        hb3Var.c(oe3Var3, fG);
        hb3Var.g(oe3Var, oe3Var2, fG);
        hb3Var.e(oe3Var4, oe3Var5, fG);
        j50 j50Var = this.l;
        if (j50Var != null) {
            double[] dArr = this.s;
            if (dArr.length > 0) {
                double d = fG;
                j50Var.d(d, dArr);
                this.l.g(d, this.t);
                this.g.q(f2, f3, fArr, this.r, this.t, this.s);
            }
            hb3Var.a(f2, f3, i, i2, fArr);
            return;
        }
        int i3 = 0;
        if (this.k == null) {
            h hVar = this.h;
            float f4 = hVar.e;
            h hVar2 = this.g;
            float f5 = f4 - hVar2.e;
            oe3 oe3Var6 = oe3Var5;
            float f6 = hVar.f - hVar2.f;
            oe3 oe3Var7 = oe3Var4;
            float f7 = (hVar.g - hVar2.g) + f5;
            float f8 = (hVar.h - hVar2.h) + f6;
            fArr[0] = (f5 * (1.0f - f2)) + (f7 * f2);
            fArr[1] = (f6 * (1.0f - f3)) + (f8 * f3);
            hb3Var.b();
            hb3Var.d(rs2Var3, fG);
            hb3Var.h(rs2Var, rs2Var2, fG);
            hb3Var.f(rs2Var4, rs2Var5, fG);
            hb3Var.c(oe3Var3, fG);
            hb3Var.g(oe3Var, oe3Var2, fG);
            hb3Var.e(oe3Var7, oe3Var6, fG);
            hb3Var.a(f2, f3, i, i2, fArr);
            return;
        }
        double dG = g(fG, this.z);
        this.k[0].g(dG, this.t);
        this.k[0].d(dG, this.s);
        float f9 = this.z[0];
        while (true) {
            double[] dArr2 = this.t;
            if (i3 >= dArr2.length) {
                this.g.q(f2, f3, fArr, this.r, dArr2, this.s);
                hb3Var.a(f2, f3, i, i2, fArr);
                return;
            } else {
                dArr2[i3] = dArr2[i3] * ((double) f9);
                i3++;
            }
        }
    }

    public float t() {
        return this.g.e;
    }

    public String toString() {
        return " start: x: " + this.g.e + " y: " + this.g.f + " end: x: " + this.h.e + " y: " + this.h.f;
    }

    public float u() {
        return this.g.f;
    }

    public View v() {
        return this.b;
    }

    /* JADX WARN: Failed to calculate best type for var: r3v7 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r3v7 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r14v1 ??, new type: char
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:186)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:245)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException
        */
    boolean x(android.view.View r21, float r22, long r23, defpackage.x81 r25) {
        /*
            Method dump skipped, instruction units count: 620
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.g.x(android.view.View, float, long, x81):boolean");
    }

    public void z() {
        this.d = true;
    }
}
