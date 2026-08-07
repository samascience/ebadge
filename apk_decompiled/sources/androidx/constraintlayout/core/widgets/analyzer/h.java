package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import defpackage.j90;

/* JADX INFO: loaded from: classes.dex */
class h extends WidgetRun {
    public h(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        constraintWidget.e.f();
        constraintWidget.f.f();
        this.f = ((androidx.constraintlayout.core.widgets.f) constraintWidget).w1();
    }

    private void q(DependencyNode dependencyNode) {
        this.h.k.add(dependencyNode);
        dependencyNode.l.add(this.h);
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, defpackage.j90
    public void a(j90 j90Var) {
        DependencyNode dependencyNode = this.h;
        if (dependencyNode.c && !dependencyNode.j) {
            this.h.d((int) ((((DependencyNode) dependencyNode.l.get(0)).g * ((androidx.constraintlayout.core.widgets.f) this.b).z1()) + 0.5f));
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void d() {
        androidx.constraintlayout.core.widgets.f fVar = (androidx.constraintlayout.core.widgets.f) this.b;
        int iX1 = fVar.x1();
        int iY1 = fVar.y1();
        fVar.z1();
        if (fVar.w1() == 1) {
            if (iX1 != -1) {
                this.h.l.add(this.b.c0.e.h);
                this.b.c0.e.h.k.add(this.h);
                this.h.f = iX1;
            } else if (iY1 != -1) {
                this.h.l.add(this.b.c0.e.i);
                this.b.c0.e.i.k.add(this.h);
                this.h.f = -iY1;
            } else {
                DependencyNode dependencyNode = this.h;
                dependencyNode.b = true;
                dependencyNode.l.add(this.b.c0.e.i);
                this.b.c0.e.i.k.add(this.h);
            }
            q(this.b.e.h);
            q(this.b.e.i);
            return;
        }
        if (iX1 != -1) {
            this.h.l.add(this.b.c0.f.h);
            this.b.c0.f.h.k.add(this.h);
            this.h.f = iX1;
        } else if (iY1 != -1) {
            this.h.l.add(this.b.c0.f.i);
            this.b.c0.f.i.k.add(this.h);
            this.h.f = -iY1;
        } else {
            DependencyNode dependencyNode2 = this.h;
            dependencyNode2.b = true;
            dependencyNode2.l.add(this.b.c0.f.i);
            this.b.c0.f.i.k.add(this.h);
        }
        q(this.b.f.h);
        q(this.b.f.i);
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void e() {
        if (((androidx.constraintlayout.core.widgets.f) this.b).w1() == 1) {
            this.b.q1(this.h.g);
        } else {
            this.b.r1(this.h.g);
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void f() {
        this.h.c();
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    boolean m() {
        return false;
    }
}
