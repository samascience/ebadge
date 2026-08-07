package androidx.constraintlayout.core.widgets;

/* JADX INFO: loaded from: classes.dex */
public abstract class g {
    static boolean[] a = new boolean[3];

    static void a(d dVar, androidx.constraintlayout.core.d dVar2, ConstraintWidget constraintWidget) {
        constraintWidget.t = -1;
        constraintWidget.u = -1;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = dVar.b0[0];
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (dimensionBehaviour != dimensionBehaviour2 && constraintWidget.b0[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            int i = constraintWidget.Q.g;
            int iY = dVar.Y() - constraintWidget.S.g;
            ConstraintAnchor constraintAnchor = constraintWidget.Q;
            constraintAnchor.i = dVar2.q(constraintAnchor);
            ConstraintAnchor constraintAnchor2 = constraintWidget.S;
            constraintAnchor2.i = dVar2.q(constraintAnchor2);
            dVar2.f(constraintWidget.Q.i, i);
            dVar2.f(constraintWidget.S.i, iY);
            constraintWidget.t = 2;
            constraintWidget.S0(i, iY);
        }
        if (dVar.b0[1] == dimensionBehaviour2 || constraintWidget.b0[1] != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            return;
        }
        int i2 = constraintWidget.R.g;
        int iZ = dVar.z() - constraintWidget.T.g;
        ConstraintAnchor constraintAnchor3 = constraintWidget.R;
        constraintAnchor3.i = dVar2.q(constraintAnchor3);
        ConstraintAnchor constraintAnchor4 = constraintWidget.T;
        constraintAnchor4.i = dVar2.q(constraintAnchor4);
        dVar2.f(constraintWidget.R.i, i2);
        dVar2.f(constraintWidget.T.i, iZ);
        if (constraintWidget.n0 > 0 || constraintWidget.X() == 8) {
            ConstraintAnchor constraintAnchor5 = constraintWidget.U;
            constraintAnchor5.i = dVar2.q(constraintAnchor5);
            dVar2.f(constraintWidget.U.i, constraintWidget.n0 + i2);
        }
        constraintWidget.u = 2;
        constraintWidget.j1(i2, iZ);
    }

    public static final boolean b(int i, int i2) {
        return (i & i2) == i2;
    }
}
