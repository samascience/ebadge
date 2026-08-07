package androidx.constraintlayout.core;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import defpackage.dk1;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class d {
    public static boolean r = false;
    public static boolean s = true;
    public static boolean t = true;
    public static boolean u = true;
    public static boolean v = false;
    private static int w = 1000;
    public static long x;
    public static long y;
    private a d;
    androidx.constraintlayout.core.b[] g;
    final c n;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private a f163q;
    public boolean a = false;
    int b = 0;
    private HashMap c = null;
    private int e = 32;
    private int f = 32;
    public boolean h = false;
    public boolean i = false;
    private boolean[] j = new boolean[32];
    int k = 1;
    int l = 0;
    private int m = 32;
    private SolverVariable[] o = new SolverVariable[w];
    private int p = 0;

    interface a {
        void a(a aVar);

        SolverVariable b(d dVar, boolean[] zArr);

        void c(SolverVariable solverVariable);

        void clear();

        SolverVariable getKey();

        boolean isEmpty();
    }

    class b extends androidx.constraintlayout.core.b {
        public b(c cVar) {
            this.e = new h(this, cVar);
        }
    }

    public d() {
        this.g = null;
        this.g = new androidx.constraintlayout.core.b[32];
        C();
        c cVar = new c();
        this.n = cVar;
        this.d = new g(cVar);
        if (v) {
            this.f163q = new b(cVar);
        } else {
            this.f163q = new androidx.constraintlayout.core.b(cVar);
        }
    }

    private final int B(a aVar, boolean z) {
        for (int i = 0; i < this.k; i++) {
            this.j[i] = false;
        }
        boolean z2 = false;
        int i2 = 0;
        while (!z2) {
            i2++;
            if (i2 >= this.k * 2) {
                return i2;
            }
            if (aVar.getKey() != null) {
                this.j[aVar.getKey().c] = true;
            }
            SolverVariable solverVariableB = aVar.b(this, this.j);
            if (solverVariableB != null) {
                boolean[] zArr = this.j;
                int i3 = solverVariableB.c;
                if (zArr[i3]) {
                    return i2;
                }
                zArr[i3] = true;
            }
            if (solverVariableB != null) {
                float f = Float.MAX_VALUE;
                int i4 = -1;
                for (int i5 = 0; i5 < this.l; i5++) {
                    androidx.constraintlayout.core.b bVar = this.g[i5];
                    if (bVar.a.j != SolverVariable.Type.UNRESTRICTED && !bVar.f && bVar.t(solverVariableB)) {
                        float fJ = bVar.e.j(solverVariableB);
                        if (fJ < 0.0f) {
                            float f2 = (-bVar.b) / fJ;
                            if (f2 < f) {
                                i4 = i5;
                                f = f2;
                            }
                        }
                    }
                }
                if (i4 > -1) {
                    androidx.constraintlayout.core.b bVar2 = this.g[i4];
                    bVar2.a.d = -1;
                    bVar2.x(solverVariableB);
                    SolverVariable solverVariable = bVar2.a;
                    solverVariable.d = i4;
                    solverVariable.h(this, bVar2);
                }
            } else {
                z2 = true;
            }
        }
        return i2;
    }

    private void C() {
        int i = 0;
        if (v) {
            while (i < this.l) {
                androidx.constraintlayout.core.b bVar = this.g[i];
                if (bVar != null) {
                    this.n.a.a(bVar);
                }
                this.g[i] = null;
                i++;
            }
            return;
        }
        while (i < this.l) {
            androidx.constraintlayout.core.b bVar2 = this.g[i];
            if (bVar2 != null) {
                this.n.b.a(bVar2);
            }
            this.g[i] = null;
            i++;
        }
    }

    private SolverVariable a(SolverVariable.Type type, String str) {
        SolverVariable solverVariable = (SolverVariable) this.n.c.b();
        if (solverVariable == null) {
            solverVariable = new SolverVariable(type, str);
            solverVariable.g(type, str);
        } else {
            solverVariable.e();
            solverVariable.g(type, str);
        }
        int i = this.p;
        int i2 = w;
        if (i >= i2) {
            int i3 = i2 * 2;
            w = i3;
            this.o = (SolverVariable[]) Arrays.copyOf(this.o, i3);
        }
        SolverVariable[] solverVariableArr = this.o;
        int i4 = this.p;
        this.p = i4 + 1;
        solverVariableArr[i4] = solverVariable;
        return solverVariable;
    }

    private final void l(androidx.constraintlayout.core.b bVar) {
        int i;
        if (t && bVar.f) {
            bVar.a.f(this, bVar.b);
        } else {
            androidx.constraintlayout.core.b[] bVarArr = this.g;
            int i2 = this.l;
            bVarArr[i2] = bVar;
            SolverVariable solverVariable = bVar.a;
            solverVariable.d = i2;
            this.l = i2 + 1;
            solverVariable.h(this, bVar);
        }
        if (t && this.a) {
            int i3 = 0;
            while (i3 < this.l) {
                if (this.g[i3] == null) {
                    System.out.println("WTF");
                }
                androidx.constraintlayout.core.b bVar2 = this.g[i3];
                if (bVar2 != null && bVar2.f) {
                    bVar2.a.f(this, bVar2.b);
                    if (v) {
                        this.n.a.a(bVar2);
                    } else {
                        this.n.b.a(bVar2);
                    }
                    this.g[i3] = null;
                    int i4 = i3 + 1;
                    int i5 = i4;
                    while (true) {
                        i = this.l;
                        if (i4 >= i) {
                            break;
                        }
                        androidx.constraintlayout.core.b[] bVarArr2 = this.g;
                        int i6 = i4 - 1;
                        androidx.constraintlayout.core.b bVar3 = bVarArr2[i4];
                        bVarArr2[i6] = bVar3;
                        SolverVariable solverVariable2 = bVar3.a;
                        if (solverVariable2.d == i4) {
                            solverVariable2.d = i6;
                        }
                        i5 = i4;
                        i4++;
                    }
                    if (i5 < i) {
                        this.g[i5] = null;
                    }
                    this.l = i - 1;
                    i3--;
                }
                i3++;
            }
            this.a = false;
        }
    }

    private void n() {
        for (int i = 0; i < this.l; i++) {
            androidx.constraintlayout.core.b bVar = this.g[i];
            bVar.a.f = bVar.b;
        }
    }

    public static androidx.constraintlayout.core.b s(d dVar, SolverVariable solverVariable, SolverVariable solverVariable2, float f) {
        return dVar.r().j(solverVariable, solverVariable2, f);
    }

    private int u(a aVar) {
        for (int i = 0; i < this.l; i++) {
            androidx.constraintlayout.core.b bVar = this.g[i];
            if (bVar.a.j != SolverVariable.Type.UNRESTRICTED && bVar.b < 0.0f) {
                boolean z = false;
                int i2 = 0;
                while (!z) {
                    i2++;
                    float f = Float.MAX_VALUE;
                    int i3 = 0;
                    int i4 = -1;
                    int i5 = -1;
                    int i6 = 0;
                    while (true) {
                        if (i3 >= this.l) {
                            break;
                        }
                        androidx.constraintlayout.core.b bVar2 = this.g[i3];
                        if (bVar2.a.j != SolverVariable.Type.UNRESTRICTED && !bVar2.f && bVar2.b < 0.0f) {
                            int i7 = 9;
                            if (u) {
                                int iA = bVar2.e.a();
                                int i8 = 0;
                                while (i8 < iA) {
                                    SolverVariable solverVariableE = bVar2.e.e(i8);
                                    float fJ = bVar2.e.j(solverVariableE);
                                    if (fJ > 0.0f) {
                                        int i9 = 0;
                                        while (i9 < i7) {
                                            float f2 = solverVariableE.h[i9] / fJ;
                                            if ((f2 < f && i9 == i6) || i9 > i6) {
                                                i6 = i9;
                                                i5 = solverVariableE.c;
                                                i4 = i3;
                                                f = f2;
                                            }
                                            i9++;
                                            i7 = 9;
                                        }
                                    }
                                    i8++;
                                    i7 = 9;
                                }
                            } else {
                                for (int i10 = 1; i10 < this.k; i10++) {
                                    SolverVariable solverVariable = this.n.d[i10];
                                    float fJ2 = bVar2.e.j(solverVariable);
                                    if (fJ2 > 0.0f) {
                                        for (int i11 = 0; i11 < 9; i11++) {
                                            float f3 = solverVariable.h[i11] / fJ2;
                                            if ((f3 < f && i11 == i6) || i11 > i6) {
                                                i4 = i3;
                                                i5 = i10;
                                                i6 = i11;
                                                f = f3;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        i3++;
                    }
                    if (i4 != -1) {
                        androidx.constraintlayout.core.b bVar3 = this.g[i4];
                        bVar3.a.d = -1;
                        bVar3.x(this.n.d[i5]);
                        SolverVariable solverVariable2 = bVar3.a;
                        solverVariable2.d = i4;
                        solverVariable2.h(this, bVar3);
                    } else {
                        z = true;
                    }
                    if (i2 > this.k / 2) {
                        z = true;
                    }
                }
                return i2;
            }
        }
        return 0;
    }

    public static dk1 w() {
        return null;
    }

    private void y() {
        int i = this.e * 2;
        this.e = i;
        this.g = (androidx.constraintlayout.core.b[]) Arrays.copyOf(this.g, i);
        c cVar = this.n;
        cVar.d = (SolverVariable[]) Arrays.copyOf(cVar.d, this.e);
        int i2 = this.e;
        this.j = new boolean[i2];
        this.f = i2;
        this.m = i2;
    }

    void A(a aVar) {
        u(aVar);
        B(aVar, false);
        n();
    }

    public void D() {
        c cVar;
        int i = 0;
        while (true) {
            cVar = this.n;
            SolverVariable[] solverVariableArr = cVar.d;
            if (i >= solverVariableArr.length) {
                break;
            }
            SolverVariable solverVariable = solverVariableArr[i];
            if (solverVariable != null) {
                solverVariable.e();
            }
            i++;
        }
        cVar.c.c(this.o, this.p);
        this.p = 0;
        Arrays.fill(this.n.d, (Object) null);
        HashMap map = this.c;
        if (map != null) {
            map.clear();
        }
        this.b = 0;
        this.d.clear();
        this.k = 1;
        for (int i2 = 0; i2 < this.l; i2++) {
            androidx.constraintlayout.core.b bVar = this.g[i2];
            if (bVar != null) {
                bVar.c = false;
            }
        }
        C();
        this.l = 0;
        if (v) {
            this.f163q = new b(this.n);
        } else {
            this.f163q = new androidx.constraintlayout.core.b(this.n);
        }
    }

    public void b(ConstraintWidget constraintWidget, ConstraintWidget constraintWidget2, float f, int i) {
        ConstraintAnchor.Type type = ConstraintAnchor.Type.LEFT;
        SolverVariable solverVariableQ = q(constraintWidget.q(type));
        ConstraintAnchor.Type type2 = ConstraintAnchor.Type.TOP;
        SolverVariable solverVariableQ2 = q(constraintWidget.q(type2));
        ConstraintAnchor.Type type3 = ConstraintAnchor.Type.RIGHT;
        SolverVariable solverVariableQ3 = q(constraintWidget.q(type3));
        ConstraintAnchor.Type type4 = ConstraintAnchor.Type.BOTTOM;
        SolverVariable solverVariableQ4 = q(constraintWidget.q(type4));
        SolverVariable solverVariableQ5 = q(constraintWidget2.q(type));
        SolverVariable solverVariableQ6 = q(constraintWidget2.q(type2));
        SolverVariable solverVariableQ7 = q(constraintWidget2.q(type3));
        SolverVariable solverVariableQ8 = q(constraintWidget2.q(type4));
        androidx.constraintlayout.core.b bVarR = r();
        double d = f;
        double d2 = i;
        bVarR.q(solverVariableQ2, solverVariableQ4, solverVariableQ6, solverVariableQ8, (float) (Math.sin(d) * d2));
        d(bVarR);
        androidx.constraintlayout.core.b bVarR2 = r();
        bVarR2.q(solverVariableQ, solverVariableQ3, solverVariableQ5, solverVariableQ7, (float) (Math.cos(d) * d2));
        d(bVarR2);
    }

    public void c(SolverVariable solverVariable, SolverVariable solverVariable2, int i, float f, SolverVariable solverVariable3, SolverVariable solverVariable4, int i2, int i3) {
        androidx.constraintlayout.core.b bVarR = r();
        bVarR.h(solverVariable, solverVariable2, i, f, solverVariable3, solverVariable4, i2);
        if (i3 != 8) {
            bVarR.d(this, i3);
        }
        d(bVarR);
    }

    /* JADX WARN: Code duplicated, block: B:33:0x007b  */
    public void d(androidx.constraintlayout.core.b bVar) {
        SolverVariable solverVariableV;
        if (bVar == null) {
            return;
        }
        boolean z = true;
        if (this.l + 1 >= this.m || this.k + 1 >= this.f) {
            y();
        }
        boolean z2 = false;
        if (!bVar.f) {
            bVar.D(this);
            if (bVar.isEmpty()) {
                return;
            }
            bVar.r();
            if (bVar.f(this)) {
                SolverVariable solverVariableP = p();
                bVar.a = solverVariableP;
                int i = this.l;
                l(bVar);
                if (this.l == i + 1) {
                    this.f163q.a(bVar);
                    B(this.f163q, true);
                    if (solverVariableP.d == -1) {
                        if (bVar.a == solverVariableP && (solverVariableV = bVar.v(solverVariableP)) != null) {
                            bVar.x(solverVariableV);
                        }
                        if (!bVar.f) {
                            bVar.a.h(this, bVar);
                        }
                        if (v) {
                            this.n.a.a(bVar);
                        } else {
                            this.n.b.a(bVar);
                        }
                        this.l--;
                    }
                } else {
                    z = false;
                }
            } else {
                z = false;
            }
            if (!bVar.s()) {
                return;
            } else {
                z2 = z;
            }
        }
        if (z2) {
            return;
        }
        l(bVar);
    }

    public androidx.constraintlayout.core.b e(SolverVariable solverVariable, SolverVariable solverVariable2, int i, int i2) {
        if (s && i2 == 8 && solverVariable2.g && solverVariable.d == -1) {
            solverVariable.f(this, solverVariable2.f + i);
            return null;
        }
        androidx.constraintlayout.core.b bVarR = r();
        bVarR.n(solverVariable, solverVariable2, i);
        if (i2 != 8) {
            bVarR.d(this, i2);
        }
        d(bVarR);
        return bVarR;
    }

    public void f(SolverVariable solverVariable, int i) {
        if (s && solverVariable.d == -1) {
            float f = i;
            solverVariable.f(this, f);
            for (int i2 = 0; i2 < this.b + 1; i2++) {
                SolverVariable solverVariable2 = this.n.d[i2];
                if (solverVariable2 != null && solverVariable2.n && solverVariable2.o == solverVariable.c) {
                    solverVariable2.f(this, solverVariable2.p + f);
                }
            }
            return;
        }
        int i3 = solverVariable.d;
        if (i3 == -1) {
            androidx.constraintlayout.core.b bVarR = r();
            bVarR.i(solverVariable, i);
            d(bVarR);
            return;
        }
        androidx.constraintlayout.core.b bVar = this.g[i3];
        if (bVar.f) {
            bVar.b = i;
            return;
        }
        if (bVar.e.a() == 0) {
            bVar.f = true;
            bVar.b = i;
        } else {
            androidx.constraintlayout.core.b bVarR2 = r();
            bVarR2.m(solverVariable, i);
            d(bVarR2);
        }
    }

    public void g(SolverVariable solverVariable, SolverVariable solverVariable2, int i, boolean z) {
        androidx.constraintlayout.core.b bVarR = r();
        SolverVariable solverVariableT = t();
        solverVariableT.e = 0;
        bVarR.o(solverVariable, solverVariable2, solverVariableT, i);
        d(bVarR);
    }

    public void h(SolverVariable solverVariable, SolverVariable solverVariable2, int i, int i2) {
        androidx.constraintlayout.core.b bVarR = r();
        SolverVariable solverVariableT = t();
        solverVariableT.e = 0;
        bVarR.o(solverVariable, solverVariable2, solverVariableT, i);
        if (i2 != 8) {
            m(bVarR, (int) (bVarR.e.j(solverVariableT) * (-1.0f)), i2);
        }
        d(bVarR);
    }

    public void i(SolverVariable solverVariable, SolverVariable solverVariable2, int i, boolean z) {
        androidx.constraintlayout.core.b bVarR = r();
        SolverVariable solverVariableT = t();
        solverVariableT.e = 0;
        bVarR.p(solverVariable, solverVariable2, solverVariableT, i);
        d(bVarR);
    }

    public void j(SolverVariable solverVariable, SolverVariable solverVariable2, int i, int i2) {
        androidx.constraintlayout.core.b bVarR = r();
        SolverVariable solverVariableT = t();
        solverVariableT.e = 0;
        bVarR.p(solverVariable, solverVariable2, solverVariableT, i);
        if (i2 != 8) {
            m(bVarR, (int) (bVarR.e.j(solverVariableT) * (-1.0f)), i2);
        }
        d(bVarR);
    }

    public void k(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f, int i) {
        androidx.constraintlayout.core.b bVarR = r();
        bVarR.k(solverVariable, solverVariable2, solverVariable3, solverVariable4, f);
        if (i != 8) {
            bVarR.d(this, i);
        }
        d(bVarR);
    }

    void m(androidx.constraintlayout.core.b bVar, int i, int i2) {
        bVar.e(o(i2, null), i);
    }

    public SolverVariable o(int i, String str) {
        if (this.k + 1 >= this.f) {
            y();
        }
        SolverVariable solverVariableA = a(SolverVariable.Type.ERROR, str);
        int i2 = this.b + 1;
        this.b = i2;
        this.k++;
        solverVariableA.c = i2;
        solverVariableA.e = i;
        this.n.d[i2] = solverVariableA;
        this.d.c(solverVariableA);
        return solverVariableA;
    }

    public SolverVariable p() {
        if (this.k + 1 >= this.f) {
            y();
        }
        SolverVariable solverVariableA = a(SolverVariable.Type.SLACK, null);
        int i = this.b + 1;
        this.b = i;
        this.k++;
        solverVariableA.c = i;
        this.n.d[i] = solverVariableA;
        return solverVariableA;
    }

    public SolverVariable q(Object obj) {
        SolverVariable solverVariableI = null;
        if (obj == null) {
            return null;
        }
        if (this.k + 1 >= this.f) {
            y();
        }
        if (obj instanceof ConstraintAnchor) {
            ConstraintAnchor constraintAnchor = (ConstraintAnchor) obj;
            solverVariableI = constraintAnchor.i();
            if (solverVariableI == null) {
                constraintAnchor.s(this.n);
                solverVariableI = constraintAnchor.i();
            }
            int i = solverVariableI.c;
            if (i == -1 || i > this.b || this.n.d[i] == null) {
                if (i != -1) {
                    solverVariableI.e();
                }
                int i2 = this.b + 1;
                this.b = i2;
                this.k++;
                solverVariableI.c = i2;
                solverVariableI.j = SolverVariable.Type.UNRESTRICTED;
                this.n.d[i2] = solverVariableI;
            }
        }
        return solverVariableI;
    }

    public androidx.constraintlayout.core.b r() {
        androidx.constraintlayout.core.b bVar;
        if (v) {
            bVar = (androidx.constraintlayout.core.b) this.n.a.b();
            if (bVar == null) {
                bVar = new b(this.n);
                y++;
            } else {
                bVar.y();
            }
        } else {
            bVar = (androidx.constraintlayout.core.b) this.n.b.b();
            if (bVar == null) {
                bVar = new androidx.constraintlayout.core.b(this.n);
                x++;
            } else {
                bVar.y();
            }
        }
        SolverVariable.c();
        return bVar;
    }

    public SolverVariable t() {
        if (this.k + 1 >= this.f) {
            y();
        }
        SolverVariable solverVariableA = a(SolverVariable.Type.SLACK, null);
        int i = this.b + 1;
        this.b = i;
        this.k++;
        solverVariableA.c = i;
        this.n.d[i] = solverVariableA;
        return solverVariableA;
    }

    public c v() {
        return this.n;
    }

    public int x(Object obj) {
        SolverVariable solverVariableI = ((ConstraintAnchor) obj).i();
        if (solverVariableI != null) {
            return (int) (solverVariableI.f + 0.5f);
        }
        return 0;
    }

    public void z() {
        if (this.d.isEmpty()) {
            n();
            return;
        }
        if (!this.h && !this.i) {
            A(this.d);
            return;
        }
        for (int i = 0; i < this.l; i++) {
            if (!this.g[i].f) {
                A(this.d);
                return;
            }
        }
        n();
    }
}
