package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import defpackage.j90;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class c extends WidgetRun {
    ArrayList k;
    private int l;

    public c(ConstraintWidget constraintWidget, int i) {
        super(constraintWidget);
        this.k = new ArrayList();
        this.f = i;
        q();
    }

    private void q() {
        ConstraintWidget constraintWidget;
        ConstraintWidget constraintWidget2 = this.b;
        ConstraintWidget constraintWidgetN = constraintWidget2.N(this.f);
        while (true) {
            ConstraintWidget constraintWidget3 = constraintWidgetN;
            constraintWidget = constraintWidget2;
            constraintWidget2 = constraintWidget3;
            if (constraintWidget2 == null) {
                break;
            } else {
                constraintWidgetN = constraintWidget2.N(this.f);
            }
        }
        this.b = constraintWidget;
        this.k.add(constraintWidget.P(this.f));
        ConstraintWidget constraintWidgetL = constraintWidget.L(this.f);
        while (constraintWidgetL != null) {
            this.k.add(constraintWidgetL.P(this.f));
            constraintWidgetL = constraintWidgetL.L(this.f);
        }
        for (WidgetRun widgetRun : this.k) {
            int i = this.f;
            if (i == 0) {
                widgetRun.b.c = this;
            } else if (i == 1) {
                widgetRun.b.d = this;
            }
        }
        if (this.f == 0 && ((androidx.constraintlayout.core.widgets.d) this.b.M()).T1() && this.k.size() > 1) {
            ArrayList arrayList = this.k;
            this.b = ((WidgetRun) arrayList.get(arrayList.size() - 1)).b;
        }
        this.l = this.f == 0 ? this.b.B() : this.b.U();
    }

    private ConstraintWidget r() {
        for (int i = 0; i < this.k.size(); i++) {
            WidgetRun widgetRun = (WidgetRun) this.k.get(i);
            if (widgetRun.b.X() != 8) {
                return widgetRun.b;
            }
        }
        return null;
    }

    private ConstraintWidget s() {
        for (int size = this.k.size() - 1; size >= 0; size--) {
            WidgetRun widgetRun = (WidgetRun) this.k.get(size);
            if (widgetRun.b.X() != 8) {
                return widgetRun.b;
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:293:0x00f4 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:62:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:64:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:65:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:67:0x00ec A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:90:0x0153  */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, defpackage.j90
    public void a(j90 j90Var) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        float f;
        boolean z;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        float f2;
        if (this.h.j && this.i.j) {
            ConstraintWidget constraintWidgetM = this.b.M();
            boolean zT1 = constraintWidgetM instanceof androidx.constraintlayout.core.widgets.d ? ((androidx.constraintlayout.core.widgets.d) constraintWidgetM).T1() : false;
            int i14 = this.i.g - this.h.g;
            int size = this.k.size();
            int i15 = 0;
            while (true) {
                i = -1;
                i2 = 8;
                if (i15 >= size) {
                    i15 = -1;
                    break;
                } else if (((WidgetRun) this.k.get(i15)).b.X() != 8) {
                    break;
                } else {
                    i15++;
                }
            }
            int i16 = size - 1;
            for (int i17 = i16; i17 >= 0; i17--) {
                if (((WidgetRun) this.k.get(i17)).b.X() != 8) {
                    i = i17;
                    break;
                }
            }
            int i18 = 0;
            while (true) {
                if (i18 >= 2) {
                    i3 = 0;
                    i4 = 0;
                    i5 = 0;
                    f = 0.0f;
                    break;
                }
                int i19 = 0;
                i4 = 0;
                i5 = 0;
                int i20 = 0;
                f = 0.0f;
                while (i19 < size) {
                    WidgetRun widgetRun = (WidgetRun) this.k.get(i19);
                    if (widgetRun.b.X() != i2) {
                        i20++;
                        if (i19 > 0 && i19 >= i15) {
                            i4 += widgetRun.h.f;
                        }
                        e eVar = widgetRun.e;
                        int i21 = eVar.g;
                        boolean z2 = widgetRun.d != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                        if (z2) {
                            int i22 = this.f;
                            if (i22 == 0 && !widgetRun.b.e.e.j) {
                                return;
                            }
                            if (i22 == 1 && !widgetRun.b.f.e.j) {
                                return;
                            } else {
                                i12 = i21;
                            }
                        } else {
                            i12 = i21;
                            if (widgetRun.a == 1 && i18 == 0) {
                                i13 = eVar.m;
                                i5++;
                            } else {
                                if (eVar.j) {
                                    i13 = i12;
                                }
                                if (z2) {
                                    i4 += i13;
                                } else {
                                    i5++;
                                    f2 = widgetRun.b.N0[this.f];
                                    if (f2 >= 0.0f) {
                                        f += f2;
                                    }
                                }
                                if (i19 >= i16 && i19 < i) {
                                    i4 += -widgetRun.i.f;
                                }
                            }
                            z2 = true;
                            if (z2) {
                                i5++;
                                f2 = widgetRun.b.N0[this.f];
                                if (f2 >= 0.0f) {
                                    f += f2;
                                }
                            } else {
                                i4 += i13;
                            }
                            if (i19 >= i16) {
                            }
                        }
                        i13 = i12;
                        if (z2) {
                            i5++;
                            f2 = widgetRun.b.N0[this.f];
                            if (f2 >= 0.0f) {
                                f += f2;
                            }
                        } else {
                            i4 += i13;
                        }
                        if (i19 >= i16) {
                        }
                    }
                    i19++;
                    i2 = 8;
                }
                if (i4 < i14 || i5 == 0) {
                    i3 = i20;
                    break;
                } else {
                    i18++;
                    i2 = 8;
                }
            }
            int i23 = this.h.g;
            if (zT1) {
                i23 = this.i.g;
            }
            if (i4 > i14) {
                i23 = zT1 ? i23 + ((int) (((i4 - i14) / 2.0f) + 0.5f)) : i23 - ((int) (((i4 - i14) / 2.0f) + 0.5f));
            }
            if (i5 > 0) {
                float f3 = i14 - i4;
                int i24 = (int) ((f3 / i5) + 0.5f);
                int i25 = 0;
                int i26 = 0;
                while (i25 < size) {
                    WidgetRun widgetRun2 = (WidgetRun) this.k.get(i25);
                    int i27 = i24;
                    int i28 = i4;
                    if (widgetRun2.b.X() != 8 && widgetRun2.d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        e eVar2 = widgetRun2.e;
                        if (eVar2.j) {
                            zT1 = zT1;
                            i23 = i23;
                            f3 = f3;
                        } else {
                            int i29 = f > 0.0f ? (int) (((widgetRun2.b.N0[this.f] * f3) / f) + 0.5f) : i27;
                            if (this.f == 0) {
                                ConstraintWidget constraintWidget = widgetRun2.b;
                                i11 = constraintWidget.A;
                                i10 = constraintWidget.z;
                            } else {
                                ConstraintWidget constraintWidget2 = widgetRun2.b;
                                int i30 = constraintWidget2.D;
                                i10 = constraintWidget2.C;
                                i11 = i30;
                            }
                            int iMax = Math.max(i10, widgetRun2.a == 1 ? Math.min(i29, eVar2.m) : i29);
                            if (i11 > 0) {
                                iMax = Math.min(i11, iMax);
                            }
                            if (iMax != i29) {
                                i26++;
                                i29 = iMax;
                            }
                            widgetRun2.e.d(i29);
                        }
                    } else {
                        zT1 = zT1;
                        i23 = i23;
                        f3 = f3;
                    }
                    i25++;
                    i24 = i27;
                    i4 = i28;
                    i23 = i23;
                    f3 = f3;
                    zT1 = zT1;
                    i3 = i3;
                }
                z = zT1;
                i6 = i3;
                i7 = i23;
                int i31 = i4;
                if (i26 > 0) {
                    i5 -= i26;
                    i4 = 0;
                    for (int i32 = 0; i32 < size; i32++) {
                        WidgetRun widgetRun3 = (WidgetRun) this.k.get(i32);
                        if (widgetRun3.b.X() != 8) {
                            if (i32 > 0 && i32 >= i15) {
                                i4 += widgetRun3.h.f;
                            }
                            i4 += widgetRun3.e.g;
                            if (i32 < i16 && i32 < i) {
                                i4 += -widgetRun3.i.f;
                            }
                        }
                    }
                } else {
                    i4 = i31;
                }
                i9 = 2;
                if (this.l == 2 && i26 == 0) {
                    i8 = 0;
                    this.l = 0;
                } else {
                    i8 = 0;
                }
            } else {
                z = zT1;
                i6 = i3;
                i7 = i23;
                i8 = 0;
                i9 = 2;
            }
            if (i4 > i14) {
                this.l = i9;
            }
            if (i6 > 0 && i5 == 0 && i15 == i) {
                this.l = i9;
            }
            int i33 = this.l;
            if (i33 == 1) {
                int i34 = i6;
                int i35 = i34 > 1 ? (i14 - i4) / (i34 - 1) : i34 == 1 ? (i14 - i4) / 2 : i8;
                if (i5 > 0) {
                    i35 = i8;
                }
                int i36 = i7;
                for (int i37 = i8; i37 < size; i37++) {
                    WidgetRun widgetRun4 = (WidgetRun) this.k.get(z ? size - (i37 + 1) : i37);
                    if (widgetRun4.b.X() == 8) {
                        widgetRun4.h.d(i36);
                        widgetRun4.i.d(i36);
                    } else {
                        if (i37 > 0) {
                            i36 = z ? i36 - i35 : i36 + i35;
                        }
                        if (i37 > 0 && i37 >= i15) {
                            i36 = z ? i36 - widgetRun4.h.f : i36 + widgetRun4.h.f;
                        }
                        if (z) {
                            widgetRun4.i.d(i36);
                        } else {
                            widgetRun4.h.d(i36);
                        }
                        e eVar3 = widgetRun4.e;
                        int i38 = eVar3.g;
                        if (widgetRun4.d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun4.a == 1) {
                            i38 = eVar3.m;
                        }
                        i36 = z ? i36 - i38 : i36 + i38;
                        if (z) {
                            widgetRun4.h.d(i36);
                        } else {
                            widgetRun4.i.d(i36);
                        }
                        widgetRun4.g = true;
                        if (i37 < i16 && i37 < i) {
                            i36 = z ? i36 - (-widgetRun4.i.f) : i36 + (-widgetRun4.i.f);
                        }
                    }
                }
                return;
            }
            int i39 = i6;
            if (i33 == 0) {
                int i40 = (i14 - i4) / (i39 + 1);
                if (i5 > 0) {
                    i40 = i8;
                }
                int i41 = i7;
                for (int i42 = i8; i42 < size; i42++) {
                    WidgetRun widgetRun5 = (WidgetRun) this.k.get(z ? size - (i42 + 1) : i42);
                    if (widgetRun5.b.X() == 8) {
                        widgetRun5.h.d(i41);
                        widgetRun5.i.d(i41);
                    } else {
                        int i43 = z ? i41 - i40 : i41 + i40;
                        if (i42 > 0 && i42 >= i15) {
                            i43 = z ? i43 - widgetRun5.h.f : i43 + widgetRun5.h.f;
                        }
                        if (z) {
                            widgetRun5.i.d(i43);
                        } else {
                            widgetRun5.h.d(i43);
                        }
                        e eVar4 = widgetRun5.e;
                        int iMin = eVar4.g;
                        if (widgetRun5.d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun5.a == 1) {
                            iMin = Math.min(iMin, eVar4.m);
                        }
                        i41 = z ? i43 - iMin : i43 + iMin;
                        if (z) {
                            widgetRun5.h.d(i41);
                        } else {
                            widgetRun5.i.d(i41);
                        }
                        if (i42 < i16 && i42 < i) {
                            i41 = z ? i41 - (-widgetRun5.i.f) : i41 + (-widgetRun5.i.f);
                        }
                    }
                }
                return;
            }
            if (i33 == 2) {
                float fA = this.f == 0 ? this.b.A() : this.b.T();
                if (z) {
                    fA = 1.0f - fA;
                }
                int i44 = (int) (((i14 - i4) * fA) + 0.5f);
                if (i44 < 0 || i5 > 0) {
                    i44 = i8;
                }
                int i45 = z ? i7 - i44 : i7 + i44;
                for (int i46 = i8; i46 < size; i46++) {
                    WidgetRun widgetRun6 = (WidgetRun) this.k.get(z ? size - (i46 + 1) : i46);
                    if (widgetRun6.b.X() == 8) {
                        widgetRun6.h.d(i45);
                        widgetRun6.i.d(i45);
                    } else {
                        if (i46 > 0 && i46 >= i15) {
                            i45 = z ? i45 - widgetRun6.h.f : i45 + widgetRun6.h.f;
                        }
                        if (z) {
                            widgetRun6.i.d(i45);
                        } else {
                            widgetRun6.h.d(i45);
                        }
                        e eVar5 = widgetRun6.e;
                        int i47 = eVar5.g;
                        if (widgetRun6.d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun6.a == 1) {
                            i47 = eVar5.m;
                        }
                        i45 = z ? i45 - i47 : i45 + i47;
                        if (z) {
                            widgetRun6.h.d(i45);
                        } else {
                            widgetRun6.i.d(i45);
                        }
                        if (i46 < i16 && i46 < i) {
                            i45 = z ? i45 - (-widgetRun6.i.f) : i45 + (-widgetRun6.i.f);
                        }
                    }
                }
            }
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void d() {
        Iterator it = this.k.iterator();
        while (it.hasNext()) {
            ((WidgetRun) it.next()).d();
        }
        int size = this.k.size();
        if (size < 1) {
            return;
        }
        ConstraintWidget constraintWidget = ((WidgetRun) this.k.get(0)).b;
        ConstraintWidget constraintWidget2 = ((WidgetRun) this.k.get(size - 1)).b;
        if (this.f == 0) {
            ConstraintAnchor constraintAnchor = constraintWidget.Q;
            ConstraintAnchor constraintAnchor2 = constraintWidget2.S;
            DependencyNode dependencyNodeI = i(constraintAnchor, 0);
            int iF = constraintAnchor.f();
            ConstraintWidget constraintWidgetR = r();
            if (constraintWidgetR != null) {
                iF = constraintWidgetR.Q.f();
            }
            if (dependencyNodeI != null) {
                b(this.h, dependencyNodeI, iF);
            }
            DependencyNode dependencyNodeI2 = i(constraintAnchor2, 0);
            int iF2 = constraintAnchor2.f();
            ConstraintWidget constraintWidgetS = s();
            if (constraintWidgetS != null) {
                iF2 = constraintWidgetS.S.f();
            }
            if (dependencyNodeI2 != null) {
                b(this.i, dependencyNodeI2, -iF2);
            }
        } else {
            ConstraintAnchor constraintAnchor3 = constraintWidget.R;
            ConstraintAnchor constraintAnchor4 = constraintWidget2.T;
            DependencyNode dependencyNodeI3 = i(constraintAnchor3, 1);
            int iF3 = constraintAnchor3.f();
            ConstraintWidget constraintWidgetR2 = r();
            if (constraintWidgetR2 != null) {
                iF3 = constraintWidgetR2.R.f();
            }
            if (dependencyNodeI3 != null) {
                b(this.h, dependencyNodeI3, iF3);
            }
            DependencyNode dependencyNodeI4 = i(constraintAnchor4, 1);
            int iF4 = constraintAnchor4.f();
            ConstraintWidget constraintWidgetS2 = s();
            if (constraintWidgetS2 != null) {
                iF4 = constraintWidgetS2.T.f();
            }
            if (dependencyNodeI4 != null) {
                b(this.i, dependencyNodeI4, -iF4);
            }
        }
        this.h.a = this;
        this.i.a = this;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void e() {
        for (int i = 0; i < this.k.size(); i++) {
            ((WidgetRun) this.k.get(i)).e();
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void f() {
        this.c = null;
        Iterator it = this.k.iterator();
        while (it.hasNext()) {
            ((WidgetRun) it.next()).f();
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public long j() {
        int size = this.k.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            WidgetRun widgetRun = (WidgetRun) this.k.get(i);
            j = j + ((long) widgetRun.h.f) + widgetRun.j() + ((long) widgetRun.i.f);
        }
        return j;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    boolean m() {
        int size = this.k.size();
        for (int i = 0; i < size; i++) {
            if (!((WidgetRun) this.k.get(i)).m()) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ChainRun ");
        sb.append(this.f == 0 ? "horizontal : " : "vertical : ");
        for (WidgetRun widgetRun : this.k) {
            sb.append("<");
            sb.append(widgetRun);
            sb.append("> ");
        }
        return sb.toString();
    }
}
