package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import defpackage.j90;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
class i extends WidgetRun {
    public i(ConstraintWidget constraintWidget) {
        super(constraintWidget);
    }

    private void q(DependencyNode dependencyNode) {
        this.h.k.add(dependencyNode);
        dependencyNode.l.add(this.h);
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, defpackage.j90
    public void a(j90 j90Var) {
        androidx.constraintlayout.core.widgets.a aVar = (androidx.constraintlayout.core.widgets.a) this.b;
        int iZ1 = aVar.z1();
        Iterator it = this.h.l.iterator();
        int i = 0;
        int i2 = -1;
        while (it.hasNext()) {
            int i3 = ((DependencyNode) it.next()).g;
            if (i2 == -1 || i3 < i2) {
                i2 = i3;
            }
            if (i < i3) {
                i = i3;
            }
        }
        if (iZ1 == 0 || iZ1 == 2) {
            this.h.d(i2 + aVar.A1());
        } else {
            this.h.d(i + aVar.A1());
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void d() {
        ConstraintWidget constraintWidget = this.b;
        if (constraintWidget instanceof androidx.constraintlayout.core.widgets.a) {
            this.h.b = true;
            androidx.constraintlayout.core.widgets.a aVar = (androidx.constraintlayout.core.widgets.a) constraintWidget;
            int iZ1 = aVar.z1();
            boolean zY1 = aVar.y1();
            int i = 0;
            if (iZ1 == 0) {
                this.h.e = DependencyNode.Type.LEFT;
                while (i < aVar.W0) {
                    ConstraintWidget constraintWidget2 = aVar.V0[i];
                    if (zY1 || constraintWidget2.X() != 8) {
                        DependencyNode dependencyNode = constraintWidget2.e.h;
                        dependencyNode.k.add(this.h);
                        this.h.l.add(dependencyNode);
                    }
                    i++;
                }
                q(this.b.e.h);
                q(this.b.e.i);
                return;
            }
            if (iZ1 == 1) {
                this.h.e = DependencyNode.Type.RIGHT;
                while (i < aVar.W0) {
                    ConstraintWidget constraintWidget3 = aVar.V0[i];
                    if (zY1 || constraintWidget3.X() != 8) {
                        DependencyNode dependencyNode2 = constraintWidget3.e.i;
                        dependencyNode2.k.add(this.h);
                        this.h.l.add(dependencyNode2);
                    }
                    i++;
                }
                q(this.b.e.h);
                q(this.b.e.i);
                return;
            }
            if (iZ1 == 2) {
                this.h.e = DependencyNode.Type.TOP;
                while (i < aVar.W0) {
                    ConstraintWidget constraintWidget4 = aVar.V0[i];
                    if (zY1 || constraintWidget4.X() != 8) {
                        DependencyNode dependencyNode3 = constraintWidget4.f.h;
                        dependencyNode3.k.add(this.h);
                        this.h.l.add(dependencyNode3);
                    }
                    i++;
                }
                q(this.b.f.h);
                q(this.b.f.i);
                return;
            }
            if (iZ1 != 3) {
                return;
            }
            this.h.e = DependencyNode.Type.BOTTOM;
            while (i < aVar.W0) {
                ConstraintWidget constraintWidget5 = aVar.V0[i];
                if (zY1 || constraintWidget5.X() != 8) {
                    DependencyNode dependencyNode4 = constraintWidget5.f.i;
                    dependencyNode4.k.add(this.h);
                    this.h.l.add(dependencyNode4);
                }
                i++;
            }
            q(this.b.f.h);
            q(this.b.f.i);
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void e() {
        ConstraintWidget constraintWidget = this.b;
        if (constraintWidget instanceof androidx.constraintlayout.core.widgets.a) {
            int iZ1 = ((androidx.constraintlayout.core.widgets.a) constraintWidget).z1();
            if (iZ1 == 0 || iZ1 == 1) {
                this.b.q1(this.h.g);
            } else {
                this.b.r1(this.h.g);
            }
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void f() {
        this.c = null;
        this.h.c();
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    boolean m() {
        return false;
    }
}
