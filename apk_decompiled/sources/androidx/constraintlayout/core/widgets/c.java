package androidx.constraintlayout.core.widgets;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class c {
    protected ConstraintWidget a;
    protected ConstraintWidget b;
    protected ConstraintWidget c;
    protected ConstraintWidget d;
    protected ConstraintWidget e;
    protected ConstraintWidget f;
    protected ConstraintWidget g;
    protected ArrayList h;
    protected int i;
    protected int j;
    protected float k = 0.0f;
    int l;
    int m;
    int n;
    boolean o;
    private int p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f165q;
    protected boolean r;
    protected boolean s;
    protected boolean t;
    protected boolean u;
    private boolean v;

    public c(ConstraintWidget constraintWidget, int i, boolean z) {
        this.a = constraintWidget;
        this.p = i;
        this.f165q = z;
    }

    private void b() {
        int i = this.p * 2;
        ConstraintWidget constraintWidget = this.a;
        this.o = true;
        ConstraintWidget constraintWidget2 = constraintWidget;
        boolean z = false;
        while (!z) {
            this.i++;
            ConstraintWidget[] constraintWidgetArr = constraintWidget.P0;
            int i2 = this.p;
            ConstraintWidget constraintWidget3 = null;
            constraintWidgetArr[i2] = null;
            constraintWidget.O0[i2] = null;
            if (constraintWidget.X() != 8) {
                this.l++;
                ConstraintWidget.DimensionBehaviour dimensionBehaviourW = constraintWidget.w(this.p);
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (dimensionBehaviourW != dimensionBehaviour) {
                    this.m += constraintWidget.G(this.p);
                }
                int iF = this.m + constraintWidget.Y[i].f();
                this.m = iF;
                int i3 = i + 1;
                this.m = iF + constraintWidget.Y[i3].f();
                int iF2 = this.n + constraintWidget.Y[i].f();
                this.n = iF2;
                this.n = iF2 + constraintWidget.Y[i3].f();
                if (this.b == null) {
                    this.b = constraintWidget;
                }
                this.d = constraintWidget;
                ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget.b0;
                int i4 = this.p;
                if (dimensionBehaviourArr[i4] == dimensionBehaviour) {
                    int i5 = constraintWidget.y[i4];
                    if (i5 == 0 || i5 == 3 || i5 == 2) {
                        this.j++;
                        float f = constraintWidget.N0[i4];
                        if (f > 0.0f) {
                            this.k += f;
                        }
                        if (c(constraintWidget, i4)) {
                            if (f < 0.0f) {
                                this.r = true;
                            } else {
                                this.s = true;
                            }
                            if (this.h == null) {
                                this.h = new ArrayList();
                            }
                            this.h.add(constraintWidget);
                        }
                        if (this.f == null) {
                            this.f = constraintWidget;
                        }
                        ConstraintWidget constraintWidget4 = this.g;
                        if (constraintWidget4 != null) {
                            constraintWidget4.O0[this.p] = constraintWidget;
                        }
                        this.g = constraintWidget;
                    }
                    if (this.p == 0) {
                        if (constraintWidget.w != 0 || constraintWidget.z != 0 || constraintWidget.A != 0) {
                            this.o = false;
                        }
                    } else if (constraintWidget.x != 0 || constraintWidget.C != 0 || constraintWidget.D != 0) {
                        this.o = false;
                    }
                    if (constraintWidget.f0 != 0.0f) {
                        this.o = false;
                        this.u = true;
                    }
                }
            }
            if (constraintWidget2 != constraintWidget) {
                constraintWidget2.P0[this.p] = constraintWidget;
            }
            ConstraintAnchor constraintAnchor = constraintWidget.Y[i + 1].f;
            if (constraintAnchor != null) {
                ConstraintWidget constraintWidget5 = constraintAnchor.d;
                ConstraintAnchor constraintAnchor2 = constraintWidget5.Y[i].f;
                if (constraintAnchor2 != null && constraintAnchor2.d == constraintWidget) {
                    constraintWidget3 = constraintWidget5;
                }
            }
            if (constraintWidget3 == null) {
                constraintWidget3 = constraintWidget;
                z = true;
            }
            constraintWidget2 = constraintWidget;
            constraintWidget = constraintWidget3;
        }
        ConstraintWidget constraintWidget6 = this.b;
        if (constraintWidget6 != null) {
            this.m -= constraintWidget6.Y[i].f();
        }
        ConstraintWidget constraintWidget7 = this.d;
        if (constraintWidget7 != null) {
            this.m -= constraintWidget7.Y[i + 1].f();
        }
        this.c = constraintWidget;
        if (this.p == 0 && this.f165q) {
            this.e = constraintWidget;
        } else {
            this.e = this.a;
        }
        this.t = this.s && this.r;
    }

    private static boolean c(ConstraintWidget constraintWidget, int i) {
        int i2;
        return constraintWidget.X() != 8 && constraintWidget.b0[i] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && ((i2 = constraintWidget.y[i]) == 0 || i2 == 3);
    }

    public void a() {
        if (!this.v) {
            b();
        }
        this.v = true;
    }
}
