package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.SolverVariable;
import cn.bertsir.zbar.Qr.Config;
import defpackage.ii3;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class d extends ii3 {
    private int Y0;
    int c1;
    int d1;
    int e1;
    int f1;
    androidx.constraintlayout.core.widgets.analyzer.b W0 = new androidx.constraintlayout.core.widgets.analyzer.b(this);
    public androidx.constraintlayout.core.widgets.analyzer.d X0 = new androidx.constraintlayout.core.widgets.analyzer.d(this);
    protected androidx.constraintlayout.core.widgets.analyzer.b.InterfaceC0013b Z0 = null;
    private boolean a1 = false;
    protected androidx.constraintlayout.core.d b1 = new androidx.constraintlayout.core.d();
    public int g1 = 0;
    public int h1 = 0;
    c[] i1 = new c[4];
    c[] j1 = new c[4];
    public boolean k1 = false;
    public boolean l1 = false;
    public boolean m1 = false;
    public int n1 = 0;
    public int o1 = 0;
    private int p1 = Config.Y_DENSITY;
    public boolean q1 = false;
    private boolean r1 = false;
    private boolean s1 = false;
    int t1 = 0;
    private WeakReference u1 = null;
    private WeakReference v1 = null;
    private WeakReference w1 = null;
    private WeakReference x1 = null;
    HashSet y1 = new HashSet();
    public androidx.constraintlayout.core.widgets.analyzer.b.a z1 = new androidx.constraintlayout.core.widgets.analyzer.b.a();

    private void B1(ConstraintWidget constraintWidget) {
        int i = this.g1 + 1;
        c[] cVarArr = this.j1;
        if (i >= cVarArr.length) {
            this.j1 = (c[]) Arrays.copyOf(cVarArr, cVarArr.length * 2);
        }
        this.j1[this.g1] = new c(constraintWidget, 0, T1());
        this.g1++;
    }

    private void E1(ConstraintAnchor constraintAnchor, SolverVariable solverVariable) {
        this.b1.h(solverVariable, this.b1.q(constraintAnchor), 0, 5);
    }

    private void F1(ConstraintAnchor constraintAnchor, SolverVariable solverVariable) {
        this.b1.h(this.b1.q(constraintAnchor), solverVariable, 0, 5);
    }

    private void G1(ConstraintWidget constraintWidget) {
        int i = this.h1 + 1;
        c[] cVarArr = this.i1;
        if (i >= cVarArr.length) {
            this.i1 = (c[]) Arrays.copyOf(cVarArr, cVarArr.length * 2);
        }
        this.i1[this.h1] = new c(constraintWidget, 1, T1());
        this.h1++;
    }

    public static boolean W1(int i, ConstraintWidget constraintWidget, androidx.constraintlayout.core.widgets.analyzer.b.InterfaceC0013b interfaceC0013b, androidx.constraintlayout.core.widgets.analyzer.b.a aVar, int i2) {
        int i3;
        int i4;
        if (interfaceC0013b == null) {
            return false;
        }
        if (constraintWidget.X() == 8 || (constraintWidget instanceof f) || (constraintWidget instanceof a)) {
            aVar.e = 0;
            aVar.f = 0;
            return false;
        }
        aVar.a = constraintWidget.C();
        aVar.b = constraintWidget.V();
        aVar.c = constraintWidget.Y();
        aVar.d = constraintWidget.z();
        aVar.i = false;
        aVar.j = i2;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = aVar.a;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z = dimensionBehaviour == dimensionBehaviour2;
        boolean z2 = aVar.b == dimensionBehaviour2;
        boolean z3 = z && constraintWidget.f0 > 0.0f;
        boolean z4 = z2 && constraintWidget.f0 > 0.0f;
        if (z && constraintWidget.c0(0) && constraintWidget.w == 0 && !z3) {
            aVar.a = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (z2 && constraintWidget.x == 0) {
                aVar.a = ConstraintWidget.DimensionBehaviour.FIXED;
            }
            z = false;
        }
        if (z2 && constraintWidget.c0(1) && constraintWidget.x == 0 && !z4) {
            aVar.b = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (z && constraintWidget.w == 0) {
                aVar.b = ConstraintWidget.DimensionBehaviour.FIXED;
            }
            z2 = false;
        }
        if (constraintWidget.p0()) {
            aVar.a = ConstraintWidget.DimensionBehaviour.FIXED;
            z = false;
        }
        if (constraintWidget.q0()) {
            aVar.b = ConstraintWidget.DimensionBehaviour.FIXED;
            z2 = false;
        }
        if (z3) {
            if (constraintWidget.y[0] == 4) {
                aVar.a = ConstraintWidget.DimensionBehaviour.FIXED;
            } else if (!z2) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = aVar.b;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.FIXED;
                if (dimensionBehaviour3 == dimensionBehaviour4) {
                    i4 = aVar.d;
                } else {
                    aVar.a = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    interfaceC0013b.b(constraintWidget, aVar);
                    i4 = aVar.f;
                }
                aVar.a = dimensionBehaviour4;
                aVar.c = (int) (constraintWidget.x() * i4);
            }
        }
        if (z4) {
            if (constraintWidget.y[1] == 4) {
                aVar.b = ConstraintWidget.DimensionBehaviour.FIXED;
            } else if (!z) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = aVar.a;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour6 = ConstraintWidget.DimensionBehaviour.FIXED;
                if (dimensionBehaviour5 == dimensionBehaviour6) {
                    i3 = aVar.c;
                } else {
                    aVar.b = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    interfaceC0013b.b(constraintWidget, aVar);
                    i3 = aVar.e;
                }
                aVar.b = dimensionBehaviour6;
                if (constraintWidget.y() == -1) {
                    aVar.d = (int) (i3 / constraintWidget.x());
                } else {
                    aVar.d = (int) (constraintWidget.x() * i3);
                }
            }
        }
        interfaceC0013b.b(constraintWidget, aVar);
        constraintWidget.o1(aVar.e);
        constraintWidget.P0(aVar.f);
        constraintWidget.O0(aVar.h);
        constraintWidget.E0(aVar.g);
        aVar.j = androidx.constraintlayout.core.widgets.analyzer.b.a.k;
        return aVar.i;
    }

    private void Y1() {
        this.g1 = 0;
        this.h1 = 0;
    }

    public boolean A1(androidx.constraintlayout.core.d dVar) {
        boolean zX1 = X1(64);
        g(dVar, zX1);
        int size = this.V0.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = (ConstraintWidget) this.V0.get(i);
            constraintWidget.W0(0, false);
            constraintWidget.W0(1, false);
            if (constraintWidget instanceof a) {
                z = true;
            }
        }
        if (z) {
            for (int i2 = 0; i2 < size; i2++) {
                ConstraintWidget constraintWidget2 = (ConstraintWidget) this.V0.get(i2);
                if (constraintWidget2 instanceof a) {
                    ((a) constraintWidget2).C1();
                }
            }
        }
        this.y1.clear();
        for (int i3 = 0; i3 < size; i3++) {
            ConstraintWidget constraintWidget3 = (ConstraintWidget) this.V0.get(i3);
            if (constraintWidget3.f()) {
                if (constraintWidget3 instanceof i) {
                    this.y1.add(constraintWidget3);
                } else {
                    constraintWidget3.g(dVar, zX1);
                }
            }
        }
        while (this.y1.size() > 0) {
            int size2 = this.y1.size();
            Iterator it = this.y1.iterator();
            while (it.hasNext()) {
                i iVar = (i) ((ConstraintWidget) it.next());
                if (iVar.z1(this.y1)) {
                    iVar.g(dVar, zX1);
                    this.y1.remove(iVar);
                    break;
                }
            }
            if (size2 == this.y1.size()) {
                Iterator it2 = this.y1.iterator();
                while (it2.hasNext()) {
                    ((ConstraintWidget) it2.next()).g(dVar, zX1);
                }
                this.y1.clear();
            }
        }
        if (androidx.constraintlayout.core.d.r) {
            HashSet<ConstraintWidget> hashSet = new HashSet();
            for (int i4 = 0; i4 < size; i4++) {
                ConstraintWidget constraintWidget4 = (ConstraintWidget) this.V0.get(i4);
                if (!constraintWidget4.f()) {
                    hashSet.add(constraintWidget4);
                }
            }
            e(this, dVar, hashSet, C() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT ? 0 : 1, false);
            for (ConstraintWidget constraintWidget5 : hashSet) {
                g.a(this, dVar, constraintWidget5);
                constraintWidget5.g(dVar, zX1);
            }
        } else {
            for (int i5 = 0; i5 < size; i5++) {
                ConstraintWidget constraintWidget6 = (ConstraintWidget) this.V0.get(i5);
                if (constraintWidget6 instanceof d) {
                    ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget6.b0;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[1];
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    if (dimensionBehaviour == dimensionBehaviour3) {
                        constraintWidget6.T0(ConstraintWidget.DimensionBehaviour.FIXED);
                    }
                    if (dimensionBehaviour2 == dimensionBehaviour3) {
                        constraintWidget6.k1(ConstraintWidget.DimensionBehaviour.FIXED);
                    }
                    constraintWidget6.g(dVar, zX1);
                    if (dimensionBehaviour == dimensionBehaviour3) {
                        constraintWidget6.T0(dimensionBehaviour);
                    }
                    if (dimensionBehaviour2 == dimensionBehaviour3) {
                        constraintWidget6.k1(dimensionBehaviour2);
                    }
                } else {
                    g.a(this, dVar, constraintWidget6);
                    if (!constraintWidget6.f()) {
                        constraintWidget6.g(dVar, zX1);
                    }
                }
            }
        }
        if (this.g1 > 0) {
            b.b(this, dVar, null, 0);
        }
        if (this.h1 > 0) {
            b.b(this, dVar, null, 1);
        }
        return true;
    }

    public void C1(ConstraintAnchor constraintAnchor) {
        WeakReference weakReference = this.x1;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.e() > ((ConstraintAnchor) this.x1.get()).e()) {
            this.x1 = new WeakReference(constraintAnchor);
        }
    }

    public void D1(ConstraintAnchor constraintAnchor) {
        WeakReference weakReference = this.v1;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.e() > ((ConstraintAnchor) this.v1.get()).e()) {
            this.v1 = new WeakReference(constraintAnchor);
        }
    }

    void H1(ConstraintAnchor constraintAnchor) {
        WeakReference weakReference = this.w1;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.e() > ((ConstraintAnchor) this.w1.get()).e()) {
            this.w1 = new WeakReference(constraintAnchor);
        }
    }

    void I1(ConstraintAnchor constraintAnchor) {
        WeakReference weakReference = this.u1;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.e() > ((ConstraintAnchor) this.u1.get()).e()) {
            this.u1 = new WeakReference(constraintAnchor);
        }
    }

    public boolean J1(boolean z) {
        return this.X0.f(z);
    }

    public boolean K1(boolean z) {
        return this.X0.g(z);
    }

    public boolean L1(boolean z, int i) {
        return this.X0.h(z, i);
    }

    public androidx.constraintlayout.core.widgets.analyzer.b.InterfaceC0013b M1() {
        return this.Z0;
    }

    public int N1() {
        return this.p1;
    }

    public androidx.constraintlayout.core.d O1() {
        return this.b1;
    }

    public boolean P1() {
        return false;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void Q(StringBuilder sb) {
        sb.append(this.o + ":{\n");
        sb.append("  actualWidth:" + this.d0);
        sb.append("\n");
        sb.append("  actualHeight:" + this.e0);
        sb.append("\n");
        Iterator it = v1().iterator();
        while (it.hasNext()) {
            ((ConstraintWidget) it.next()).Q(sb);
            sb.append(",\n");
        }
        sb.append("}");
    }

    public void Q1() {
        this.X0.j();
    }

    public void R1() {
        this.X0.k();
    }

    public boolean S1() {
        return this.s1;
    }

    public boolean T1() {
        return this.a1;
    }

    public boolean U1() {
        return this.r1;
    }

    public long V1(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.c1 = i8;
        this.d1 = i9;
        return this.W0.d(this, i, i8, i9, i2, i3, i4, i5, i6, i7);
    }

    public boolean X1(int i) {
        return (this.p1 & i) == i;
    }

    public void Z1(androidx.constraintlayout.core.widgets.analyzer.b.InterfaceC0013b interfaceC0013b) {
        this.Z0 = interfaceC0013b;
        this.X0.n(interfaceC0013b);
    }

    public void a2(int i) {
        this.p1 = i;
        androidx.constraintlayout.core.d.r = X1(512);
    }

    public void b2(int i) {
        this.Y0 = i;
    }

    public void c2(boolean z) {
        this.a1 = z;
    }

    public boolean d2(androidx.constraintlayout.core.d dVar, boolean[] zArr) {
        zArr[2] = false;
        boolean zX1 = X1(64);
        u1(dVar, zX1);
        int size = this.V0.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = (ConstraintWidget) this.V0.get(i);
            constraintWidget.u1(dVar, zX1);
            if (constraintWidget.e0()) {
                z = true;
            }
        }
        return z;
    }

    public void e2() {
        this.W0.e(this);
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void t1(boolean z, boolean z2) {
        super.t1(z, z2);
        int size = this.V0.size();
        for (int i = 0; i < size; i++) {
            ((ConstraintWidget) this.V0.get(i)).t1(z, z2);
        }
    }

    @Override // defpackage.ii3, androidx.constraintlayout.core.widgets.ConstraintWidget
    public void v0() {
        this.b1.D();
        this.c1 = 0;
        this.e1 = 0;
        this.d1 = 0;
        this.f1 = 0;
        this.q1 = false;
        super.v0();
    }

    /* JADX WARN: Code duplicated, block: B:151:0x0307 A[PHI: r2 r16
      0x0307: PHI (r2v15 ??) = (r2v14 ??), (r2v19 ??), (r2v19 ??), (r2v19 ??) binds: [B:138:0x02c8, B:146:0x02ed, B:147:0x02ef, B:149:0x02f5] A[DONT_GENERATE, DONT_INLINE]
      0x0307: PHI (r16v4 boolean) = (r16v3 boolean), (r16v5 boolean), (r16v5 boolean), (r16v5 boolean) binds: [B:138:0x02c8, B:146:0x02ed, B:147:0x02ef, B:149:0x02f5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v12 */
    /* JADX WARN: Type inference failed for: r13v13 */
    /* JADX WARN: Type inference failed for: r13v14 */
    /* JADX WARN: Type inference failed for: r13v15 */
    /* JADX WARN: Type inference failed for: r13v17 */
    /* JADX WARN: Type inference failed for: r13v18 */
    /* JADX WARN: Type inference failed for: r13v19 */
    /* JADX WARN: Type inference failed for: r13v20 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Type inference failed for: r13v9 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v39 */
    /* JADX WARN: Type inference failed for: r2v40 */
    /* JADX WARN: Type inference failed for: r2v41 */
    /* JADX WARN: Type inference failed for: r2v42 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v6 */
    @Override // defpackage.ii3
    public void w1() {
        int i;
        int i2;
        boolean z;
        boolean zD2;
        boolean z2;
        ?? r6;
        ?? r2;
        ?? r13;
        boolean z3;
        int i3;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        int i4 = 0;
        this.h0 = 0;
        this.i0 = 0;
        this.r1 = false;
        this.s1 = false;
        int size = this.V0.size();
        int iMax = Math.max(0, Y());
        int iMax2 = Math.max(0, z());
        ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = this.b0;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[1];
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = dimensionBehaviourArr[0];
        if (this.Y0 == 0 && g.b(this.p1, 1)) {
            androidx.constraintlayout.core.widgets.analyzer.f.h(this, M1());
            for (int i5 = 0; i5 < size; i5++) {
                ConstraintWidget constraintWidget = (ConstraintWidget) this.V0.get(i5);
                if (constraintWidget.o0() && !(constraintWidget instanceof f) && !(constraintWidget instanceof a) && !(constraintWidget instanceof i) && !constraintWidget.n0()) {
                    ConstraintWidget.DimensionBehaviour dimensionBehaviourW = constraintWidget.w(0);
                    ConstraintWidget.DimensionBehaviour dimensionBehaviourW2 = constraintWidget.w(1);
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                    if (dimensionBehaviourW != dimensionBehaviour4 || constraintWidget.w == 1 || dimensionBehaviourW2 != dimensionBehaviour4 || constraintWidget.x == 1) {
                        W1(0, constraintWidget, this.Z0, new androidx.constraintlayout.core.widgets.analyzer.b.a(), androidx.constraintlayout.core.widgets.analyzer.b.a.k);
                    }
                }
            }
        }
        if (size <= 2 || !((dimensionBehaviour3 == (dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || dimensionBehaviour2 == dimensionBehaviour) && g.b(this.p1, 1024) && androidx.constraintlayout.core.widgets.analyzer.g.c(this, M1()))) {
            i = iMax2;
            i2 = iMax;
            z = false;
        } else {
            if (dimensionBehaviour3 == dimensionBehaviour) {
                if (iMax >= Y() || iMax <= 0) {
                    iMax = Y();
                } else {
                    o1(iMax);
                    this.r1 = true;
                }
            }
            if (dimensionBehaviour2 == dimensionBehaviour) {
                if (iMax2 >= z() || iMax2 <= 0) {
                    iMax2 = z();
                } else {
                    P0(iMax2);
                    this.s1 = true;
                }
            }
            i = iMax2;
            i2 = iMax;
            z = true;
        }
        boolean z4 = X1(64) || X1(128);
        androidx.constraintlayout.core.d dVar = this.b1;
        dVar.h = false;
        dVar.i = false;
        if (this.p1 != 0 && z4) {
            dVar.i = true;
        }
        ArrayList arrayList = this.V0;
        ConstraintWidget.DimensionBehaviour dimensionBehaviourC = C();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        boolean z5 = dimensionBehaviourC == dimensionBehaviour5 || V() == dimensionBehaviour5;
        Y1();
        for (int i6 = 0; i6 < size; i6++) {
            ConstraintWidget constraintWidget2 = (ConstraintWidget) this.V0.get(i6);
            if (constraintWidget2 instanceof ii3) {
                ((ii3) constraintWidget2).w1();
            }
        }
        boolean zX1 = X1(64);
        ?? r14 = z;
        int i7 = 0;
        boolean zA1 = true;
        while (zA1) {
            int i8 = i7 + 1;
            try {
                this.b1.D();
                Y1();
                o(this.b1);
                for (int i9 = i4; i9 < size; i9++) {
                    ((ConstraintWidget) this.V0.get(i9)).o(this.b1);
                }
                zA1 = A1(this.b1);
                WeakReference weakReference = this.u1;
                if (weakReference != null && weakReference.get() != null) {
                    F1((ConstraintAnchor) this.u1.get(), this.b1.q(this.R));
                    this.u1 = null;
                }
                WeakReference weakReference2 = this.w1;
                if (weakReference2 != null && weakReference2.get() != null) {
                    E1((ConstraintAnchor) this.w1.get(), this.b1.q(this.T));
                    this.w1 = null;
                }
                WeakReference weakReference3 = this.v1;
                if (weakReference3 != null && weakReference3.get() != null) {
                    F1((ConstraintAnchor) this.v1.get(), this.b1.q(this.Q));
                    this.v1 = null;
                }
                WeakReference weakReference4 = this.x1;
                if (weakReference4 != null && weakReference4.get() != null) {
                    E1((ConstraintAnchor) this.x1.get(), this.b1.q(this.S));
                    this.x1 = null;
                }
                if (zA1) {
                    this.b1.z();
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("EXCEPTION : " + e);
            }
            if (zA1) {
                zD2 = d2(this.b1, g.a);
            } else {
                u1(this.b1, zX1);
                for (int i10 = 0; i10 < size; i10++) {
                    ((ConstraintWidget) this.V0.get(i10)).u1(this.b1, zX1);
                }
                zD2 = false;
            }
            if (z5 && i8 < 8 && g.a[2]) {
                int i11 = 0;
                int iMax3 = 0;
                int iMax4 = 0;
                while (i11 < size) {
                    ConstraintWidget constraintWidget3 = (ConstraintWidget) this.V0.get(i11);
                    iMax4 = Math.max(iMax4, constraintWidget3.h0 + constraintWidget3.Y());
                    iMax3 = Math.max(iMax3, constraintWidget3.i0 + constraintWidget3.z());
                    i11++;
                    zD2 = zD2;
                }
                z2 = zD2;
                int iMax5 = Math.max(this.o0, iMax4);
                int iMax6 = Math.max(this.p0, iMax3);
                ConstraintWidget.DimensionBehaviour dimensionBehaviour6 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                r14 = r14;
                if (dimensionBehaviour3 == dimensionBehaviour6 && Y() < iMax5) {
                    r14 = r14;
                    o1(iMax5);
                    this.b0[0] = dimensionBehaviour6;
                    r14 = 1;
                    z2 = true;
                }
                if (dimensionBehaviour2 == dimensionBehaviour6 && z() < iMax6) {
                    P0(iMax6);
                    this.b0[1] = dimensionBehaviour6;
                    r14 = 1;
                    z2 = true;
                }
            } else {
                z2 = zD2;
            }
            int iMax7 = Math.max(this.o0, Y());
            ?? r15 = r14;
            if (iMax7 > Y()) {
                o1(iMax7);
                this.b0[0] = ConstraintWidget.DimensionBehaviour.FIXED;
                r15 = 1;
                z2 = true;
            }
            int iMax8 = Math.max(this.p0, z());
            if (iMax8 > z()) {
                P0(iMax8);
                r6 = 1;
                this.b0[1] = ConstraintWidget.DimensionBehaviour.FIXED;
                r2 = 1;
                z2 = true;
            } else {
                r6 = 1;
                r2 = r15;
            }
            if (r2 == 0) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour7 = this.b0[0];
                ConstraintWidget.DimensionBehaviour dimensionBehaviour8 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                if (dimensionBehaviour7 == dimensionBehaviour8 && i2 > 0) {
                    r2 = r2;
                    if (Y() > i2) {
                        this.r1 = r6;
                        this.b0[0] = ConstraintWidget.DimensionBehaviour.FIXED;
                        o1(i2);
                        ?? r3 = r6;
                        z2 = r3 == true ? 1 : 0;
                        r2 = r3;
                    }
                }
                r2 = r2;
                r2 = r2;
                if (this.b0[r6] != dimensionBehaviour8 || i <= 0 || z() <= i) {
                    r13 = r2;
                    z3 = z2;
                    i3 = 8;
                } else {
                    this.s1 = r6;
                    this.b0[r6] = ConstraintWidget.DimensionBehaviour.FIXED;
                    P0(i);
                    i3 = 8;
                    z3 = true;
                    r13 = 1;
                }
            } else {
                r13 = r2;
                z3 = z2;
                i3 = 8;
            }
            zA1 = i8 > i3 ? false : z3;
            i7 = i8;
            i4 = 0;
            r14 = r13;
        }
        this.V0 = arrayList;
        if (r14 != 0) {
            ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr2 = this.b0;
            dimensionBehaviourArr2[0] = dimensionBehaviour3;
            dimensionBehaviourArr2[1] = dimensionBehaviour2;
        }
        z0(this.b1.v());
    }

    void z1(ConstraintWidget constraintWidget, int i) {
        if (i == 0) {
            B1(constraintWidget);
        } else if (i == 1) {
            G1(constraintWidget);
        }
    }
}
