package defpackage;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.g;
import androidx.constraintlayout.core.widgets.analyzer.m;
import androidx.constraintlayout.core.widgets.d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class sw0 extends ConstraintWidget implements rw0 {
    public ConstraintWidget[] V0 = new ConstraintWidget[4];
    public int W0 = 0;

    @Override // defpackage.rw0
    public void a() {
        this.W0 = 0;
        Arrays.fill(this.V0, (Object) null);
    }

    @Override // defpackage.rw0
    public void b(ConstraintWidget constraintWidget) {
        if (constraintWidget == this || constraintWidget == null) {
            return;
        }
        int i = this.W0 + 1;
        ConstraintWidget[] constraintWidgetArr = this.V0;
        if (i > constraintWidgetArr.length) {
            this.V0 = (ConstraintWidget[]) Arrays.copyOf(constraintWidgetArr, constraintWidgetArr.length * 2);
        }
        ConstraintWidget[] constraintWidgetArr2 = this.V0;
        int i2 = this.W0;
        constraintWidgetArr2[i2] = constraintWidget;
        this.W0 = i2 + 1;
    }

    public void c(d dVar) {
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void n(ConstraintWidget constraintWidget, HashMap map) {
        super.n(constraintWidget, map);
        sw0 sw0Var = (sw0) constraintWidget;
        this.W0 = 0;
        int i = sw0Var.W0;
        for (int i2 = 0; i2 < i; i2++) {
            b((ConstraintWidget) map.get(sw0Var.V0[i2]));
        }
    }

    public void v1(ArrayList arrayList, int i, m mVar) {
        for (int i2 = 0; i2 < this.W0; i2++) {
            mVar.a(this.V0[i2]);
        }
        for (int i3 = 0; i3 < this.W0; i3++) {
            g.a(this.V0[i3], i, arrayList, mVar);
        }
    }

    public int w1(int i) {
        int i2;
        int i3;
        for (int i4 = 0; i4 < this.W0; i4++) {
            ConstraintWidget constraintWidget = this.V0[i4];
            if (i == 0 && (i3 = constraintWidget.S0) != -1) {
                return i3;
            }
            if (i == 1 && (i2 = constraintWidget.T0) != -1) {
                return i2;
            }
        }
        return -1;
    }
}
