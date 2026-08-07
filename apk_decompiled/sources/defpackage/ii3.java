package defpackage;

import androidx.constraintlayout.core.c;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class ii3 extends ConstraintWidget {
    public ArrayList V0 = new ArrayList();

    public void b(ConstraintWidget constraintWidget) {
        this.V0.add(constraintWidget);
        if (constraintWidget.M() != null) {
            ((ii3) constraintWidget.M()).x1(constraintWidget);
        }
        constraintWidget.g1(this);
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void v0() {
        this.V0.clear();
        super.v0();
    }

    public ArrayList v1() {
        return this.V0;
    }

    public abstract void w1();

    public void x1(ConstraintWidget constraintWidget) {
        this.V0.remove(constraintWidget);
        constraintWidget.v0();
    }

    public void y1() {
        this.V0.clear();
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void z0(c cVar) {
        super.z0(cVar);
        int size = this.V0.size();
        for (int i = 0; i < size; i++) {
            ((ConstraintWidget) this.V0.get(i)).z0(cVar);
        }
    }
}
