package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import defpackage.j90;
import defpackage.rw0;

/* JADX INFO: loaded from: classes.dex */
public class j extends WidgetRun {
    private static int[] k = new int[2];

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[WidgetRun.RunType.values().length];
            a = iArr;
            try {
                iArr[WidgetRun.RunType.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[WidgetRun.RunType.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[WidgetRun.RunType.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public j(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        this.h.e = DependencyNode.Type.LEFT;
        this.i.e = DependencyNode.Type.RIGHT;
        this.f = 0;
    }

    private void q(int[] iArr, int i, int i2, int i3, int i4, float f, int i5) {
        int i6 = i2 - i;
        int i7 = i4 - i3;
        if (i5 != -1) {
            if (i5 == 0) {
                iArr[0] = (int) ((i7 * f) + 0.5f);
                iArr[1] = i7;
                return;
            } else {
                if (i5 != 1) {
                    return;
                }
                iArr[0] = i6;
                iArr[1] = (int) ((i6 * f) + 0.5f);
                return;
            }
        }
        int i8 = (int) ((i7 * f) + 0.5f);
        int i9 = (int) ((i6 / f) + 0.5f);
        if (i8 <= i6) {
            iArr[0] = i8;
            iArr[1] = i7;
        } else if (i9 <= i7) {
            iArr[0] = i6;
            iArr[1] = i9;
        }
    }

    /* JADX WARN: Code duplicated, block: B:125:0x02df  */
    /* JADX WARN: Code duplicated, block: B:127:0x02ee  */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, defpackage.j90
    public void a(j90 j90Var) {
        int iG;
        int i;
        int iG2;
        float f;
        float fX;
        float fX2;
        int i2;
        int i3 = a.a[this.j.ordinal()];
        if (i3 == 1) {
            p(j90Var);
        } else if (i3 == 2) {
            o(j90Var);
        } else if (i3 == 3) {
            ConstraintWidget constraintWidget = this.b;
            n(j90Var, constraintWidget.Q, constraintWidget.S, 0);
            return;
        }
        if (!this.e.j && this.d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            ConstraintWidget constraintWidget2 = this.b;
            int i4 = constraintWidget2.w;
            if (i4 == 2) {
                ConstraintWidget constraintWidgetM = constraintWidget2.M();
                if (constraintWidgetM != null) {
                    e eVar = constraintWidgetM.e.e;
                    if (eVar.j) {
                        this.e.d((int) ((eVar.g * this.b.B) + 0.5f));
                    }
                }
            } else if (i4 == 3) {
                int i5 = constraintWidget2.x;
                if (i5 == 0 || i5 == 3) {
                    l lVar = constraintWidget2.f;
                    DependencyNode dependencyNode = lVar.h;
                    DependencyNode dependencyNode2 = lVar.i;
                    boolean z = constraintWidget2.Q.f != null;
                    boolean z2 = constraintWidget2.R.f != null;
                    boolean z3 = constraintWidget2.S.f != null;
                    boolean z4 = constraintWidget2.T.f != null;
                    int iY = constraintWidget2.y();
                    if (z && z2 && z3 && z4) {
                        float fX3 = this.b.x();
                        if (dependencyNode.j && dependencyNode2.j) {
                            DependencyNode dependencyNode3 = this.h;
                            if (dependencyNode3.c && this.i.c) {
                                q(k, ((DependencyNode) dependencyNode3.l.get(0)).g + this.h.f, ((DependencyNode) this.i.l.get(0)).g - this.i.f, dependencyNode.g + dependencyNode.f, dependencyNode2.g - dependencyNode2.f, fX3, iY);
                                this.e.d(k[0]);
                                this.b.f.e.d(k[1]);
                                return;
                            }
                            return;
                        }
                        DependencyNode dependencyNode4 = this.h;
                        if (dependencyNode4.j) {
                            DependencyNode dependencyNode5 = this.i;
                            if (dependencyNode5.j) {
                                if (!dependencyNode.c || !dependencyNode2.c) {
                                    return;
                                }
                                q(k, dependencyNode4.g + dependencyNode4.f, dependencyNode5.g - dependencyNode5.f, ((DependencyNode) dependencyNode.l.get(0)).g + dependencyNode.f, ((DependencyNode) dependencyNode2.l.get(0)).g - dependencyNode2.f, fX3, iY);
                                this.e.d(k[0]);
                                this.b.f.e.d(k[1]);
                            }
                        }
                        DependencyNode dependencyNode6 = this.h;
                        if (!dependencyNode6.c || !this.i.c || !dependencyNode.c || !dependencyNode2.c) {
                            return;
                        }
                        q(k, ((DependencyNode) dependencyNode6.l.get(0)).g + this.h.f, ((DependencyNode) this.i.l.get(0)).g - this.i.f, ((DependencyNode) dependencyNode.l.get(0)).g + dependencyNode.f, ((DependencyNode) dependencyNode2.l.get(0)).g - dependencyNode2.f, fX3, iY);
                        this.e.d(k[0]);
                        this.b.f.e.d(k[1]);
                    } else if (z && z3) {
                        if (!this.h.c || !this.i.c) {
                            return;
                        }
                        float fX4 = this.b.x();
                        int i6 = ((DependencyNode) this.h.l.get(0)).g + this.h.f;
                        int i7 = ((DependencyNode) this.i.l.get(0)).g - this.i.f;
                        if (iY == -1 || iY == 0) {
                            int iG3 = g(i7 - i6, 0);
                            int i8 = (int) ((iG3 * fX4) + 0.5f);
                            int iG4 = g(i8, 1);
                            if (i8 != iG4) {
                                iG3 = (int) ((iG4 / fX4) + 0.5f);
                            }
                            this.e.d(iG3);
                            this.b.f.e.d(iG4);
                        } else if (iY == 1) {
                            int iG5 = g(i7 - i6, 0);
                            int i9 = (int) ((iG5 / fX4) + 0.5f);
                            int iG6 = g(i9, 1);
                            if (i9 != iG6) {
                                iG5 = (int) ((iG6 * fX4) + 0.5f);
                            }
                            this.e.d(iG5);
                            this.b.f.e.d(iG6);
                        }
                    } else if (z2 && z4) {
                        if (!dependencyNode.c || !dependencyNode2.c) {
                            return;
                        }
                        float fX5 = this.b.x();
                        int i10 = ((DependencyNode) dependencyNode.l.get(0)).g + dependencyNode.f;
                        int i11 = ((DependencyNode) dependencyNode2.l.get(0)).g - dependencyNode2.f;
                        if (iY == -1) {
                            iG = g(i11 - i10, 1);
                            i = (int) ((iG / fX5) + 0.5f);
                            iG2 = g(i, 0);
                            if (i != iG2) {
                                iG = (int) ((iG2 * fX5) + 0.5f);
                            }
                            this.e.d(iG2);
                            this.b.f.e.d(iG);
                        } else if (iY == 0) {
                            int iG7 = g(i11 - i10, 1);
                            int i12 = (int) ((iG7 * fX5) + 0.5f);
                            int iG8 = g(i12, 0);
                            if (i12 != iG8) {
                                iG7 = (int) ((iG8 / fX5) + 0.5f);
                            }
                            this.e.d(iG8);
                            this.b.f.e.d(iG7);
                        } else if (iY == 1) {
                            iG = g(i11 - i10, 1);
                            i = (int) ((iG / fX5) + 0.5f);
                            iG2 = g(i, 0);
                            if (i != iG2) {
                                iG = (int) ((iG2 * fX5) + 0.5f);
                            }
                            this.e.d(iG2);
                            this.b.f.e.d(iG);
                        }
                    }
                } else {
                    int iY2 = constraintWidget2.y();
                    if (iY2 != -1) {
                        if (iY2 == 0) {
                            ConstraintWidget constraintWidget3 = this.b;
                            fX2 = constraintWidget3.f.e.g / constraintWidget3.x();
                            i2 = (int) (fX2 + 0.5f);
                        } else if (iY2 != 1) {
                            i2 = 0;
                        } else {
                            ConstraintWidget constraintWidget4 = this.b;
                            f = constraintWidget4.f.e.g;
                            fX = constraintWidget4.x();
                        }
                        this.e.d(i2);
                    } else {
                        ConstraintWidget constraintWidget5 = this.b;
                        f = constraintWidget5.f.e.g;
                        fX = constraintWidget5.x();
                    }
                    fX2 = f * fX;
                    i2 = (int) (fX2 + 0.5f);
                    this.e.d(i2);
                }
            }
        }
        DependencyNode dependencyNode7 = this.h;
        if (dependencyNode7.c) {
            DependencyNode dependencyNode8 = this.i;
            if (dependencyNode8.c) {
                if (dependencyNode7.j && dependencyNode8.j && this.e.j) {
                    return;
                }
                if (!this.e.j && this.d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    ConstraintWidget constraintWidget6 = this.b;
                    if (constraintWidget6.w == 0 && !constraintWidget6.k0()) {
                        DependencyNode dependencyNode9 = (DependencyNode) this.h.l.get(0);
                        DependencyNode dependencyNode10 = (DependencyNode) this.i.l.get(0);
                        int i13 = dependencyNode9.g;
                        DependencyNode dependencyNode11 = this.h;
                        int i14 = i13 + dependencyNode11.f;
                        int i15 = dependencyNode10.g + this.i.f;
                        dependencyNode11.d(i14);
                        this.i.d(i15);
                        this.e.d(i15 - i14);
                        return;
                    }
                }
                if (!this.e.j && this.d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && this.a == 1 && this.h.l.size() > 0 && this.i.l.size() > 0) {
                    int iMin = Math.min((((DependencyNode) this.i.l.get(0)).g + this.i.f) - (((DependencyNode) this.h.l.get(0)).g + this.h.f), this.e.m);
                    ConstraintWidget constraintWidget7 = this.b;
                    int i16 = constraintWidget7.A;
                    int iMax = Math.max(constraintWidget7.z, iMin);
                    if (i16 > 0) {
                        iMax = Math.min(i16, iMax);
                    }
                    this.e.d(iMax);
                }
                if (this.e.j) {
                    DependencyNode dependencyNode12 = (DependencyNode) this.h.l.get(0);
                    DependencyNode dependencyNode13 = (DependencyNode) this.i.l.get(0);
                    int i17 = dependencyNode12.g + this.h.f;
                    int i18 = dependencyNode13.g + this.i.f;
                    float fA = this.b.A();
                    if (dependencyNode12 == dependencyNode13) {
                        i17 = dependencyNode12.g;
                        i18 = dependencyNode13.g;
                        fA = 0.5f;
                    }
                    this.h.d((int) (i17 + 0.5f + (((i18 - i17) - this.e.g) * fA)));
                    this.i.d(this.h.g + this.e.g);
                }
            }
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void d() {
        ConstraintWidget constraintWidgetM;
        ConstraintWidget constraintWidgetM2;
        ConstraintWidget constraintWidget = this.b;
        if (constraintWidget.a) {
            this.e.d(constraintWidget.Y());
        }
        if (this.e.j) {
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = this.d;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
            if (dimensionBehaviour == dimensionBehaviour2 && (constraintWidgetM = this.b.M()) != null && (constraintWidgetM.C() == ConstraintWidget.DimensionBehaviour.FIXED || constraintWidgetM.C() == dimensionBehaviour2)) {
                b(this.h, constraintWidgetM.e.h, this.b.Q.f());
                b(this.i, constraintWidgetM.e.i, -this.b.S.f());
                return;
            }
        } else {
            ConstraintWidget.DimensionBehaviour dimensionBehaviourC = this.b.C();
            this.d = dimensionBehaviourC;
            if (dimensionBehaviourC != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
                if (dimensionBehaviourC == dimensionBehaviour3 && (constraintWidgetM2 = this.b.M()) != null && (constraintWidgetM2.C() == ConstraintWidget.DimensionBehaviour.FIXED || constraintWidgetM2.C() == dimensionBehaviour3)) {
                    int iY = (constraintWidgetM2.Y() - this.b.Q.f()) - this.b.S.f();
                    b(this.h, constraintWidgetM2.e.h, this.b.Q.f());
                    b(this.i, constraintWidgetM2.e.i, -this.b.S.f());
                    this.e.d(iY);
                    return;
                }
                if (this.d == ConstraintWidget.DimensionBehaviour.FIXED) {
                    this.e.d(this.b.Y());
                }
            }
        }
        e eVar = this.e;
        if (eVar.j) {
            ConstraintWidget constraintWidget2 = this.b;
            if (constraintWidget2.a) {
                ConstraintAnchor[] constraintAnchorArr = constraintWidget2.Y;
                ConstraintAnchor constraintAnchor = constraintAnchorArr[0];
                ConstraintAnchor constraintAnchor2 = constraintAnchor.f;
                if (constraintAnchor2 != null && constraintAnchorArr[1].f != null) {
                    if (constraintWidget2.k0()) {
                        this.h.f = this.b.Y[0].f();
                        this.i.f = -this.b.Y[1].f();
                        return;
                    }
                    DependencyNode dependencyNodeH = h(this.b.Y[0]);
                    if (dependencyNodeH != null) {
                        b(this.h, dependencyNodeH, this.b.Y[0].f());
                    }
                    DependencyNode dependencyNodeH2 = h(this.b.Y[1]);
                    if (dependencyNodeH2 != null) {
                        b(this.i, dependencyNodeH2, -this.b.Y[1].f());
                    }
                    this.h.b = true;
                    this.i.b = true;
                    return;
                }
                if (constraintAnchor2 != null) {
                    DependencyNode dependencyNodeH3 = h(constraintAnchor);
                    if (dependencyNodeH3 != null) {
                        b(this.h, dependencyNodeH3, this.b.Y[0].f());
                        b(this.i, this.h, this.e.g);
                        return;
                    }
                    return;
                }
                ConstraintAnchor constraintAnchor3 = constraintAnchorArr[1];
                if (constraintAnchor3.f != null) {
                    DependencyNode dependencyNodeH4 = h(constraintAnchor3);
                    if (dependencyNodeH4 != null) {
                        b(this.i, dependencyNodeH4, -this.b.Y[1].f());
                        b(this.h, this.i, -this.e.g);
                        return;
                    }
                    return;
                }
                if ((constraintWidget2 instanceof rw0) || constraintWidget2.M() == null || this.b.q(ConstraintAnchor.Type.CENTER).f != null) {
                    return;
                }
                b(this.h, this.b.M().e.h, this.b.Z());
                b(this.i, this.h, this.e.g);
                return;
            }
        }
        if (this.d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            ConstraintWidget constraintWidget3 = this.b;
            int i = constraintWidget3.w;
            if (i == 2) {
                ConstraintWidget constraintWidgetM3 = constraintWidget3.M();
                if (constraintWidgetM3 != null) {
                    e eVar2 = constraintWidgetM3.f.e;
                    this.e.l.add(eVar2);
                    eVar2.k.add(this.e);
                    e eVar3 = this.e;
                    eVar3.b = true;
                    eVar3.k.add(this.h);
                    this.e.k.add(this.i);
                }
            } else if (i == 3) {
                if (constraintWidget3.x == 3) {
                    this.h.a = this;
                    this.i.a = this;
                    l lVar = constraintWidget3.f;
                    lVar.h.a = this;
                    lVar.i.a = this;
                    eVar.a = this;
                    if (constraintWidget3.m0()) {
                        this.e.l.add(this.b.f.e);
                        this.b.f.e.k.add(this.e);
                        l lVar2 = this.b.f;
                        lVar2.e.a = this;
                        this.e.l.add(lVar2.h);
                        this.e.l.add(this.b.f.i);
                        this.b.f.h.k.add(this.e);
                        this.b.f.i.k.add(this.e);
                    } else if (this.b.k0()) {
                        this.b.f.e.l.add(this.e);
                        this.e.k.add(this.b.f.e);
                    } else {
                        this.b.f.e.l.add(this.e);
                    }
                } else {
                    e eVar4 = constraintWidget3.f.e;
                    eVar.l.add(eVar4);
                    eVar4.k.add(this.e);
                    this.b.f.h.k.add(this.e);
                    this.b.f.i.k.add(this.e);
                    e eVar5 = this.e;
                    eVar5.b = true;
                    eVar5.k.add(this.h);
                    this.e.k.add(this.i);
                    this.h.l.add(this.e);
                    this.i.l.add(this.e);
                }
            }
        }
        ConstraintWidget constraintWidget4 = this.b;
        ConstraintAnchor[] constraintAnchorArr2 = constraintWidget4.Y;
        ConstraintAnchor constraintAnchor4 = constraintAnchorArr2[0];
        ConstraintAnchor constraintAnchor5 = constraintAnchor4.f;
        if (constraintAnchor5 != null && constraintAnchorArr2[1].f != null) {
            if (constraintWidget4.k0()) {
                this.h.f = this.b.Y[0].f();
                this.i.f = -this.b.Y[1].f();
                return;
            }
            DependencyNode dependencyNodeH5 = h(this.b.Y[0]);
            DependencyNode dependencyNodeH6 = h(this.b.Y[1]);
            if (dependencyNodeH5 != null) {
                dependencyNodeH5.b(this);
            }
            if (dependencyNodeH6 != null) {
                dependencyNodeH6.b(this);
            }
            this.j = WidgetRun.RunType.CENTER;
            return;
        }
        if (constraintAnchor5 != null) {
            DependencyNode dependencyNodeH7 = h(constraintAnchor4);
            if (dependencyNodeH7 != null) {
                b(this.h, dependencyNodeH7, this.b.Y[0].f());
                c(this.i, this.h, 1, this.e);
                return;
            }
            return;
        }
        ConstraintAnchor constraintAnchor6 = constraintAnchorArr2[1];
        if (constraintAnchor6.f != null) {
            DependencyNode dependencyNodeH8 = h(constraintAnchor6);
            if (dependencyNodeH8 != null) {
                b(this.i, dependencyNodeH8, -this.b.Y[1].f());
                c(this.h, this.i, -1, this.e);
                return;
            }
            return;
        }
        if ((constraintWidget4 instanceof rw0) || constraintWidget4.M() == null) {
            return;
        }
        b(this.h, this.b.M().e.h, this.b.Z());
        c(this.i, this.h, 1, this.e);
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void e() {
        DependencyNode dependencyNode = this.h;
        if (dependencyNode.j) {
            this.b.q1(dependencyNode.g);
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void f() {
        this.c = null;
        this.h.c();
        this.i.c();
        this.e.c();
        this.g = false;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    boolean m() {
        return this.d != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || this.b.w == 0;
    }

    void r() {
        this.g = false;
        this.h.c();
        this.h.j = false;
        this.i.c();
        this.i.j = false;
        this.e.j = false;
    }

    public String toString() {
        return "HorizontalRun " + this.b.v();
    }
}
