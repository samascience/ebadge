package androidx.constraintlayout.core.widgets;

/* JADX INFO: loaded from: classes.dex */
public class h extends i {
    @Override // androidx.constraintlayout.core.widgets.i
    public void G1(int i, int i2, int i3, int i4) {
        int iD1 = D1() + E1();
        int iF1 = F1() + C1();
        if (this.W0 > 0) {
            iD1 += this.V0[0].Y();
            iF1 += this.V0[0].z();
        }
        int iMax = Math.max(K(), iD1);
        int iMax2 = Math.max(J(), iF1);
        if (i != 1073741824) {
            if (i == Integer.MIN_VALUE) {
                i2 = Math.min(iMax, i2);
            } else {
                i2 = i == 0 ? iMax : 0;
            }
        }
        if (i3 != 1073741824) {
            if (i3 == Integer.MIN_VALUE) {
                i4 = Math.min(iMax2, i4);
            } else {
                i4 = i3 == 0 ? iMax2 : 0;
            }
        }
        L1(i2, i4);
        o1(i2);
        P0(i4);
        K1(this.W0 > 0);
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void g(androidx.constraintlayout.core.d dVar, boolean z) {
        super.g(dVar, z);
        if (this.W0 > 0) {
            ConstraintWidget constraintWidget = this.V0[0];
            constraintWidget.w0();
            ConstraintAnchor.Type type = ConstraintAnchor.Type.LEFT;
            constraintWidget.j(type, this, type);
            ConstraintAnchor.Type type2 = ConstraintAnchor.Type.RIGHT;
            constraintWidget.j(type2, this, type2);
            ConstraintAnchor.Type type3 = ConstraintAnchor.Type.TOP;
            constraintWidget.j(type3, this, type3);
            ConstraintAnchor.Type type4 = ConstraintAnchor.Type.BOTTOM;
            constraintWidget.j(type4, this, type4);
        }
    }
}
