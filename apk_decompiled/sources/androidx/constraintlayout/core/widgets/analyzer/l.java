package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import defpackage.j90;
import defpackage.rw0;

/* JADX INFO: loaded from: classes.dex */
public class l extends WidgetRun {
    public DependencyNode k;
    e l;

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

    public l(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        DependencyNode dependencyNode = new DependencyNode(this);
        this.k = dependencyNode;
        this.l = null;
        this.h.e = DependencyNode.Type.TOP;
        this.i.e = DependencyNode.Type.BOTTOM;
        dependencyNode.e = DependencyNode.Type.BASELINE;
        this.f = 1;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, defpackage.j90
    public void a(j90 j90Var) {
        float f;
        float fX;
        float fX2;
        int i;
        int i2 = a.a[this.j.ordinal()];
        if (i2 == 1) {
            p(j90Var);
        } else if (i2 == 2) {
            o(j90Var);
        } else if (i2 == 3) {
            ConstraintWidget constraintWidget = this.b;
            n(j90Var, constraintWidget.R, constraintWidget.T, 1);
            return;
        }
        e eVar = this.e;
        if (eVar.c && !eVar.j && this.d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            ConstraintWidget constraintWidget2 = this.b;
            int i3 = constraintWidget2.x;
            if (i3 == 2) {
                ConstraintWidget constraintWidgetM = constraintWidget2.M();
                if (constraintWidgetM != null) {
                    e eVar2 = constraintWidgetM.f.e;
                    if (eVar2.j) {
                        this.e.d((int) ((eVar2.g * this.b.E) + 0.5f));
                    }
                }
            } else if (i3 == 3 && constraintWidget2.e.e.j) {
                int iY = constraintWidget2.y();
                if (iY != -1) {
                    if (iY == 0) {
                        ConstraintWidget constraintWidget3 = this.b;
                        fX2 = constraintWidget3.e.e.g * constraintWidget3.x();
                        i = (int) (fX2 + 0.5f);
                    } else if (iY != 1) {
                        i = 0;
                    } else {
                        ConstraintWidget constraintWidget4 = this.b;
                        f = constraintWidget4.e.e.g;
                        fX = constraintWidget4.x();
                    }
                    this.e.d(i);
                } else {
                    ConstraintWidget constraintWidget5 = this.b;
                    f = constraintWidget5.e.e.g;
                    fX = constraintWidget5.x();
                }
                fX2 = f / fX;
                i = (int) (fX2 + 0.5f);
                this.e.d(i);
            }
        }
        DependencyNode dependencyNode = this.h;
        if (dependencyNode.c) {
            DependencyNode dependencyNode2 = this.i;
            if (dependencyNode2.c) {
                if (dependencyNode.j && dependencyNode2.j && this.e.j) {
                    return;
                }
                if (!this.e.j && this.d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    ConstraintWidget constraintWidget6 = this.b;
                    if (constraintWidget6.w == 0 && !constraintWidget6.m0()) {
                        DependencyNode dependencyNode3 = (DependencyNode) this.h.l.get(0);
                        DependencyNode dependencyNode4 = (DependencyNode) this.i.l.get(0);
                        int i4 = dependencyNode3.g;
                        DependencyNode dependencyNode5 = this.h;
                        int i5 = i4 + dependencyNode5.f;
                        int i6 = dependencyNode4.g + this.i.f;
                        dependencyNode5.d(i5);
                        this.i.d(i6);
                        this.e.d(i6 - i5);
                        return;
                    }
                }
                if (!this.e.j && this.d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && this.a == 1 && this.h.l.size() > 0 && this.i.l.size() > 0) {
                    DependencyNode dependencyNode6 = (DependencyNode) this.h.l.get(0);
                    int i7 = (((DependencyNode) this.i.l.get(0)).g + this.i.f) - (dependencyNode6.g + this.h.f);
                    e eVar3 = this.e;
                    int i8 = eVar3.m;
                    if (i7 < i8) {
                        eVar3.d(i7);
                    } else {
                        eVar3.d(i8);
                    }
                }
                if (this.e.j && this.h.l.size() > 0 && this.i.l.size() > 0) {
                    DependencyNode dependencyNode7 = (DependencyNode) this.h.l.get(0);
                    DependencyNode dependencyNode8 = (DependencyNode) this.i.l.get(0);
                    int i9 = dependencyNode7.g + this.h.f;
                    int i10 = dependencyNode8.g + this.i.f;
                    float fT = this.b.T();
                    if (dependencyNode7 == dependencyNode8) {
                        i9 = dependencyNode7.g;
                        i10 = dependencyNode8.g;
                        fT = 0.5f;
                    }
                    this.h.d((int) (i9 + 0.5f + (((i10 - i9) - this.e.g) * fT)));
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
            this.e.d(constraintWidget.z());
        }
        if (!this.e.j) {
            this.d = this.b.V();
            if (this.b.b0()) {
                this.l = new androidx.constraintlayout.core.widgets.analyzer.a(this);
            }
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = this.d;
            if (dimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && (constraintWidgetM2 = this.b.M()) != null && constraintWidgetM2.V() == ConstraintWidget.DimensionBehaviour.FIXED) {
                    int iZ = (constraintWidgetM2.z() - this.b.R.f()) - this.b.T.f();
                    b(this.h, constraintWidgetM2.f.h, this.b.R.f());
                    b(this.i, constraintWidgetM2.f.i, -this.b.T.f());
                    this.e.d(iZ);
                    return;
                }
                if (this.d == ConstraintWidget.DimensionBehaviour.FIXED) {
                    this.e.d(this.b.z());
                }
            }
        } else if (this.d == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && (constraintWidgetM = this.b.M()) != null && constraintWidgetM.V() == ConstraintWidget.DimensionBehaviour.FIXED) {
            b(this.h, constraintWidgetM.f.h, this.b.R.f());
            b(this.i, constraintWidgetM.f.i, -this.b.T.f());
            return;
        }
        e eVar = this.e;
        boolean z = eVar.j;
        if (z) {
            ConstraintWidget constraintWidget2 = this.b;
            if (constraintWidget2.a) {
                ConstraintAnchor[] constraintAnchorArr = constraintWidget2.Y;
                ConstraintAnchor constraintAnchor = constraintAnchorArr[2];
                ConstraintAnchor constraintAnchor2 = constraintAnchor.f;
                if (constraintAnchor2 != null && constraintAnchorArr[3].f != null) {
                    if (constraintWidget2.m0()) {
                        this.h.f = this.b.Y[2].f();
                        this.i.f = -this.b.Y[3].f();
                    } else {
                        DependencyNode dependencyNodeH = h(this.b.Y[2]);
                        if (dependencyNodeH != null) {
                            b(this.h, dependencyNodeH, this.b.Y[2].f());
                        }
                        DependencyNode dependencyNodeH2 = h(this.b.Y[3]);
                        if (dependencyNodeH2 != null) {
                            b(this.i, dependencyNodeH2, -this.b.Y[3].f());
                        }
                        this.h.b = true;
                        this.i.b = true;
                    }
                    if (this.b.b0()) {
                        b(this.k, this.h, this.b.r());
                        return;
                    }
                    return;
                }
                if (constraintAnchor2 != null) {
                    DependencyNode dependencyNodeH3 = h(constraintAnchor);
                    if (dependencyNodeH3 != null) {
                        b(this.h, dependencyNodeH3, this.b.Y[2].f());
                        b(this.i, this.h, this.e.g);
                        if (this.b.b0()) {
                            b(this.k, this.h, this.b.r());
                            return;
                        }
                        return;
                    }
                    return;
                }
                ConstraintAnchor constraintAnchor3 = constraintAnchorArr[3];
                if (constraintAnchor3.f != null) {
                    DependencyNode dependencyNodeH4 = h(constraintAnchor3);
                    if (dependencyNodeH4 != null) {
                        b(this.i, dependencyNodeH4, -this.b.Y[3].f());
                        b(this.h, this.i, -this.e.g);
                    }
                    if (this.b.b0()) {
                        b(this.k, this.h, this.b.r());
                        return;
                    }
                    return;
                }
                ConstraintAnchor constraintAnchor4 = constraintAnchorArr[4];
                if (constraintAnchor4.f != null) {
                    DependencyNode dependencyNodeH5 = h(constraintAnchor4);
                    if (dependencyNodeH5 != null) {
                        b(this.k, dependencyNodeH5, 0);
                        b(this.h, this.k, -this.b.r());
                        b(this.i, this.h, this.e.g);
                        return;
                    }
                    return;
                }
                if ((constraintWidget2 instanceof rw0) || constraintWidget2.M() == null || this.b.q(ConstraintAnchor.Type.CENTER).f != null) {
                    return;
                }
                b(this.h, this.b.M().f.h, this.b.a0());
                b(this.i, this.h, this.e.g);
                if (this.b.b0()) {
                    b(this.k, this.h, this.b.r());
                    return;
                }
                return;
            }
        }
        if (z || this.d != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            eVar.b(this);
        } else {
            ConstraintWidget constraintWidget3 = this.b;
            int i = constraintWidget3.x;
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
            } else if (i == 3 && !constraintWidget3.m0()) {
                ConstraintWidget constraintWidget4 = this.b;
                if (constraintWidget4.w != 3) {
                    e eVar4 = constraintWidget4.e.e;
                    this.e.l.add(eVar4);
                    eVar4.k.add(this.e);
                    e eVar5 = this.e;
                    eVar5.b = true;
                    eVar5.k.add(this.h);
                    this.e.k.add(this.i);
                }
            }
        }
        ConstraintWidget constraintWidget5 = this.b;
        ConstraintAnchor[] constraintAnchorArr2 = constraintWidget5.Y;
        ConstraintAnchor constraintAnchor5 = constraintAnchorArr2[2];
        ConstraintAnchor constraintAnchor6 = constraintAnchor5.f;
        if (constraintAnchor6 != null && constraintAnchorArr2[3].f != null) {
            if (constraintWidget5.m0()) {
                this.h.f = this.b.Y[2].f();
                this.i.f = -this.b.Y[3].f();
            } else {
                DependencyNode dependencyNodeH6 = h(this.b.Y[2]);
                DependencyNode dependencyNodeH7 = h(this.b.Y[3]);
                if (dependencyNodeH6 != null) {
                    dependencyNodeH6.b(this);
                }
                if (dependencyNodeH7 != null) {
                    dependencyNodeH7.b(this);
                }
                this.j = WidgetRun.RunType.CENTER;
            }
            if (this.b.b0()) {
                c(this.k, this.h, 1, this.l);
            }
        } else if (constraintAnchor6 != null) {
            DependencyNode dependencyNodeH8 = h(constraintAnchor5);
            if (dependencyNodeH8 != null) {
                b(this.h, dependencyNodeH8, this.b.Y[2].f());
                c(this.i, this.h, 1, this.e);
                if (this.b.b0()) {
                    c(this.k, this.h, 1, this.l);
                }
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = this.d;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (dimensionBehaviour2 == dimensionBehaviour3 && this.b.x() > 0.0f) {
                    j jVar = this.b.e;
                    if (jVar.d == dimensionBehaviour3) {
                        jVar.e.k.add(this.e);
                        this.e.l.add(this.b.e.e);
                        this.e.a = this;
                    }
                }
            }
        } else {
            ConstraintAnchor constraintAnchor7 = constraintAnchorArr2[3];
            if (constraintAnchor7.f != null) {
                DependencyNode dependencyNodeH9 = h(constraintAnchor7);
                if (dependencyNodeH9 != null) {
                    b(this.i, dependencyNodeH9, -this.b.Y[3].f());
                    c(this.h, this.i, -1, this.e);
                    if (this.b.b0()) {
                        c(this.k, this.h, 1, this.l);
                    }
                }
            } else {
                ConstraintAnchor constraintAnchor8 = constraintAnchorArr2[4];
                if (constraintAnchor8.f != null) {
                    DependencyNode dependencyNodeH10 = h(constraintAnchor8);
                    if (dependencyNodeH10 != null) {
                        b(this.k, dependencyNodeH10, 0);
                        c(this.h, this.k, -1, this.l);
                        c(this.i, this.h, 1, this.e);
                    }
                } else if (!(constraintWidget5 instanceof rw0) && constraintWidget5.M() != null) {
                    b(this.h, this.b.M().f.h, this.b.a0());
                    c(this.i, this.h, 1, this.e);
                    if (this.b.b0()) {
                        c(this.k, this.h, 1, this.l);
                    }
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = this.d;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                    if (dimensionBehaviour4 == dimensionBehaviour5 && this.b.x() > 0.0f) {
                        j jVar2 = this.b.e;
                        if (jVar2.d == dimensionBehaviour5) {
                            jVar2.e.k.add(this.e);
                            this.e.l.add(this.b.e.e);
                            this.e.a = this;
                        }
                    }
                }
            }
        }
        if (this.e.l.size() == 0) {
            this.e.c = true;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void e() {
        DependencyNode dependencyNode = this.h;
        if (dependencyNode.j) {
            this.b.r1(dependencyNode.g);
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void f() {
        this.c = null;
        this.h.c();
        this.i.c();
        this.k.c();
        this.e.c();
        this.g = false;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    boolean m() {
        return this.d != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || this.b.x == 0;
    }

    void q() {
        this.g = false;
        this.h.c();
        this.h.j = false;
        this.i.c();
        this.i.j = false;
        this.k.c();
        this.k.j = false;
        this.e.j = false;
    }

    public String toString() {
        return "VerticalRun " + this.b.v();
    }
}
