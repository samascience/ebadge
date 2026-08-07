package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import defpackage.rw0;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class b {
    private final ArrayList a = new ArrayList();
    private a b = new a();
    private androidx.constraintlayout.core.widgets.d c;

    public static class a {
        public static int k = 0;
        public static int l = 1;
        public static int m = 2;
        public ConstraintWidget.DimensionBehaviour a;
        public ConstraintWidget.DimensionBehaviour b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public boolean h;
        public boolean i;
        public int j;
    }

    /* JADX INFO: renamed from: androidx.constraintlayout.core.widgets.analyzer.b$b, reason: collision with other inner class name */
    public interface InterfaceC0013b {
        void a();

        void b(ConstraintWidget constraintWidget, a aVar);
    }

    public b(androidx.constraintlayout.core.widgets.d dVar) {
        this.c = dVar;
    }

    private boolean a(InterfaceC0013b interfaceC0013b, ConstraintWidget constraintWidget, int i) {
        this.b.a = constraintWidget.C();
        this.b.b = constraintWidget.V();
        this.b.c = constraintWidget.Y();
        this.b.d = constraintWidget.z();
        a aVar = this.b;
        aVar.i = false;
        aVar.j = i;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = aVar.a;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z = dimensionBehaviour == dimensionBehaviour2;
        boolean z2 = aVar.b == dimensionBehaviour2;
        boolean z3 = z && constraintWidget.f0 > 0.0f;
        boolean z4 = z2 && constraintWidget.f0 > 0.0f;
        if (z3 && constraintWidget.y[0] == 4) {
            aVar.a = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        if (z4 && constraintWidget.y[1] == 4) {
            aVar.b = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        interfaceC0013b.b(constraintWidget, aVar);
        constraintWidget.o1(this.b.e);
        constraintWidget.P0(this.b.f);
        constraintWidget.O0(this.b.h);
        constraintWidget.E0(this.b.g);
        a aVar2 = this.b;
        aVar2.j = a.k;
        return aVar2.i;
    }

    /* JADX WARN: Code duplicated, block: B:56:0x0097 A[PHI: r10
      0x0097: PHI (r10v2 boolean) = (r10v1 boolean), (r10v1 boolean), (r10v1 boolean), (r10v4 boolean), (r10v4 boolean) binds: [B:32:0x0061, B:34:0x0067, B:36:0x006b, B:54:0x0094, B:52:0x008d] A[DONT_GENERATE, DONT_INLINE]] */
    private void b(androidx.constraintlayout.core.widgets.d dVar) {
        boolean z;
        j jVar;
        l lVar;
        int size = dVar.V0.size();
        boolean zX1 = dVar.X1(64);
        InterfaceC0013b interfaceC0013bM1 = dVar.M1();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = (ConstraintWidget) dVar.V0.get(i);
            if (!(constraintWidget instanceof androidx.constraintlayout.core.widgets.f) && !(constraintWidget instanceof androidx.constraintlayout.core.widgets.a) && !constraintWidget.n0() && (!zX1 || (jVar = constraintWidget.e) == null || (lVar = constraintWidget.f) == null || !jVar.e.j || !lVar.e.j)) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviourW = constraintWidget.w(0);
                ConstraintWidget.DimensionBehaviour dimensionBehaviourW2 = constraintWidget.w(1);
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                boolean z2 = dimensionBehaviourW == dimensionBehaviour && constraintWidget.w != 1 && dimensionBehaviourW2 == dimensionBehaviour && constraintWidget.x != 1;
                if (!z2 && dVar.X1(1) && !(constraintWidget instanceof androidx.constraintlayout.core.widgets.i)) {
                    if (dimensionBehaviourW == dimensionBehaviour && constraintWidget.w == 0 && dimensionBehaviourW2 != dimensionBehaviour && !constraintWidget.k0()) {
                        z2 = true;
                    }
                    if (dimensionBehaviourW2 == dimensionBehaviour && constraintWidget.x == 0 && dimensionBehaviourW != dimensionBehaviour && !constraintWidget.k0()) {
                        z2 = true;
                    }
                    z = (!(dimensionBehaviourW == dimensionBehaviour || dimensionBehaviourW2 == dimensionBehaviour) || constraintWidget.f0 <= 0.0f) ? z2 : true;
                }
                if (!z) {
                    a(interfaceC0013bM1, constraintWidget, a.k);
                }
            }
        }
        interfaceC0013bM1.a();
    }

    private void c(androidx.constraintlayout.core.widgets.d dVar, String str, int i, int i2, int i3) {
        int iK = dVar.K();
        int iJ = dVar.J();
        dVar.e1(0);
        dVar.d1(0);
        dVar.o1(i2);
        dVar.P0(i3);
        dVar.e1(iK);
        dVar.d1(iJ);
        this.c.b2(i);
        this.c.w1();
    }

    /* JADX WARN: Code duplicated, block: B:143:0x0226  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v17, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r15v19 */
    /* JADX WARN: Type inference failed for: r15v20 */
    /* JADX WARN: Type inference failed for: r15v5, types: [int] */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v10 */
    /* JADX WARN: Type inference failed for: r16v13 */
    /* JADX WARN: Type inference failed for: r16v14 */
    /* JADX WARN: Type inference failed for: r16v15 */
    /* JADX WARN: Type inference failed for: r16v16 */
    /* JADX WARN: Type inference failed for: r16v17 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r16v3 */
    /* JADX WARN: Type inference failed for: r16v4 */
    /* JADX WARN: Type inference failed for: r16v5 */
    /* JADX WARN: Type inference failed for: r16v6 */
    /* JADX WARN: Type inference failed for: r16v7 */
    /* JADX WARN: Type inference failed for: r16v8 */
    /* JADX WARN: Type inference failed for: r16v9 */
    public long d(androidx.constraintlayout.core.widgets.d dVar, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        boolean z;
        boolean zL1;
        int i10;
        int i11;
        ?? r16;
        boolean z2;
        int i12;
        ?? r17;
        int i13;
        int i14;
        int i15;
        b bVar = this;
        InterfaceC0013b interfaceC0013bM1 = dVar.M1();
        int size = dVar.V0.size();
        int iY = dVar.Y();
        int iZ = dVar.z();
        boolean zB = androidx.constraintlayout.core.widgets.g.b(i, 128);
        int i16 = 1;
        boolean z3 = zB || androidx.constraintlayout.core.widgets.g.b(i, 64);
        if (z3) {
            for (int i17 = 0; i17 < size; i17++) {
                ConstraintWidget constraintWidget = (ConstraintWidget) dVar.V0.get(i17);
                ConstraintWidget.DimensionBehaviour dimensionBehaviourC = constraintWidget.C();
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                boolean z4 = (dimensionBehaviourC == dimensionBehaviour) && (constraintWidget.V() == dimensionBehaviour) && constraintWidget.x() > 0.0f;
                if ((constraintWidget.k0() && z4) || ((constraintWidget.m0() && z4) || (constraintWidget instanceof androidx.constraintlayout.core.widgets.i) || constraintWidget.k0() || constraintWidget.m0())) {
                    z3 = false;
                    break;
                }
            }
        }
        if (z3) {
            boolean z5 = androidx.constraintlayout.core.d.r;
        }
        boolean z6 = z3 & ((i4 == 1073741824 && i6 == 1073741824) || zB);
        int i18 = 2;
        if (z6) {
            int iMin = Math.min(dVar.I(), i5);
            int iMin2 = Math.min(dVar.H(), i7);
            if (i4 == 1073741824 && dVar.Y() != iMin) {
                dVar.o1(iMin);
                dVar.Q1();
            }
            if (i6 == 1073741824 && dVar.z() != iMin2) {
                dVar.P0(iMin2);
                dVar.Q1();
            }
            if (i4 == 1073741824 && i6 == 1073741824) {
                zL1 = dVar.J1(zB);
                i10 = 2;
                z = false;
            } else {
                boolean zK1 = dVar.K1(zB);
                z = false;
                if (i4 == 1073741824) {
                    zK1 &= dVar.L1(zB, 0);
                    i10 = 1;
                } else {
                    i10 = 0;
                }
                if (i6 == 1073741824) {
                    zL1 = dVar.L1(zB, 1) & zK1;
                    i10++;
                } else {
                    zL1 = zK1;
                }
            }
            if (zL1) {
                dVar.t1(i4 == 1073741824 ? true : z, i6 == 1073741824 ? true : z);
            }
        } else {
            z = false;
            zL1 = false;
            i10 = 0;
        }
        if (zL1 && i10 == 2) {
            return 0L;
        }
        int iN1 = dVar.N1();
        if (size > 0) {
            b(dVar);
        }
        e(dVar);
        int size2 = bVar.a.size();
        if (size > 0) {
            c(dVar, "First pass", 0, iY, iZ);
        }
        if (size2 > 0) {
            ConstraintWidget.DimensionBehaviour dimensionBehaviourC2 = dVar.C();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            boolean z7 = dimensionBehaviourC2 == dimensionBehaviour2 ? true : z;
            boolean z8 = dVar.V() == dimensionBehaviour2 ? true : z;
            int iMax = Math.max(dVar.Y(), bVar.c.K());
            int iMax2 = Math.max(dVar.z(), bVar.c.J());
            boolean z9 = z;
            ?? r18 = z9;
            ?? r15 = z9;
            while (r15 < size2) {
                ConstraintWidget constraintWidget2 = (ConstraintWidget) bVar.a.get(r15);
                if (constraintWidget2 instanceof androidx.constraintlayout.core.widgets.i) {
                    int iY2 = constraintWidget2.Y();
                    int iZ2 = constraintWidget2.z();
                    int i19 = (r18 == true ? 1 : 0) | (bVar.a(interfaceC0013bM1, constraintWidget2, a.l) ? 1 : 0);
                    int iY3 = constraintWidget2.Y();
                    int iZ3 = constraintWidget2.z();
                    if (iY3 != iY2) {
                        constraintWidget2.o1(iY3);
                        if (z7 && constraintWidget2.O() > iMax) {
                            iMax = Math.max(iMax, constraintWidget2.O() + constraintWidget2.q(ConstraintAnchor.Type.RIGHT).f());
                        }
                        i14 = 1;
                    }
                    if (iZ3 != iZ2) {
                        i14 = i19;
                        constraintWidget2.P0(iZ3);
                        if (z8 && constraintWidget2.t() > iMax2) {
                            iMax2 = Math.max(iMax2, constraintWidget2.t() + constraintWidget2.q(ConstraintAnchor.Type.BOTTOM).f());
                        }
                        i14 = 1;
                    }
                    i14 = i19;
                    r18 = i14 | (((androidx.constraintlayout.core.widgets.i) constraintWidget2).J1() ? 1 : 0);
                    i15 = 1;
                } else {
                    i15 = i16;
                }
                iN1 = iN1;
                i16 = i15;
                i18 = 2;
                r15 += i15;
                r18 = r18;
            }
            int i20 = iN1;
            int i21 = i18;
            int i22 = 0;
            ?? r19 = r18;
            while (i22 < i21) {
                int i23 = 0;
                while (i23 < size2) {
                    ConstraintWidget constraintWidget3 = (ConstraintWidget) bVar.a.get(i23);
                    if (!(constraintWidget3 instanceof rw0) || (constraintWidget3 instanceof androidx.constraintlayout.core.widgets.i)) {
                        r16 = r19;
                        r16 = r19;
                        if ((constraintWidget3 instanceof androidx.constraintlayout.core.widgets.f) || constraintWidget3.X() == 8 || ((z6 && constraintWidget3.e.e.j && constraintWidget3.f.e.j) || (constraintWidget3 instanceof androidx.constraintlayout.core.widgets.i))) {
                            r16 = r19;
                            z2 = z6;
                            r17 = r16;
                        } else {
                            int iY4 = constraintWidget3.Y();
                            int iZ4 = constraintWidget3.z();
                            int iR = constraintWidget3.r();
                            int i24 = a.l;
                            z2 = z6;
                            if (i22 == 1) {
                                i24 = a.m;
                            }
                            int i25 = (r16 == true ? 1 : 0) | (bVar.a(interfaceC0013bM1, constraintWidget3, i24) ? 1 : 0);
                            int iY5 = constraintWidget3.Y();
                            int iZ5 = constraintWidget3.z();
                            if (iY5 != iY4) {
                                constraintWidget3.o1(iY5);
                                if (z7 && constraintWidget3.O() > iMax) {
                                    iMax = Math.max(iMax, constraintWidget3.O() + constraintWidget3.q(ConstraintAnchor.Type.RIGHT).f());
                                }
                                i12 = 1;
                            } else {
                                i12 = i25;
                            }
                            if (iZ5 != iZ4) {
                                constraintWidget3.P0(iZ5);
                                if (z8 && constraintWidget3.t() > iMax2) {
                                    iMax2 = Math.max(iMax2, constraintWidget3.t() + constraintWidget3.q(ConstraintAnchor.Type.BOTTOM).f());
                                }
                                i12 = 1;
                            }
                            if (!constraintWidget3.b0() || iR == constraintWidget3.r()) {
                                r17 = i12;
                            } else {
                                i13 = 1;
                                r17 = 1;
                            }
                        }
                        i13 = 1;
                    } else {
                        r16 = r19;
                        z2 = z6;
                        r17 = r16;
                        i13 = 1;
                    }
                    i23 += i13;
                    bVar = this;
                    z6 = z2;
                    r16 = r17;
                }
                r16 = r19;
                boolean z10 = z6;
                if (r16 == 0) {
                    break;
                }
                i22++;
                c(dVar, "intermediate pass", i22, iY, iZ);
                i21 = 2;
                r19 = 0;
                bVar = this;
                z6 = z10;
            }
            i11 = i20;
        } else {
            i11 = iN1;
        }
        dVar.a2(i11);
        return 0L;
    }

    public void e(androidx.constraintlayout.core.widgets.d dVar) {
        this.a.clear();
        int size = dVar.V0.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = (ConstraintWidget) dVar.V0.get(i);
            ConstraintWidget.DimensionBehaviour dimensionBehaviourC = constraintWidget.C();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            if (dimensionBehaviourC == dimensionBehaviour || constraintWidget.V() == dimensionBehaviour) {
                this.a.add(constraintWidget);
            }
        }
        dVar.Q1();
    }
}
