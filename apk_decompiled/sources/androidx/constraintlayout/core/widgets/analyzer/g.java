package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import defpackage.sw0;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class g {
    public static m a(ConstraintWidget constraintWidget, int i, ArrayList arrayList, m mVar) {
        int iW1;
        int i2 = i == 0 ? constraintWidget.S0 : constraintWidget.T0;
        if (i2 != -1 && (mVar == null || i2 != mVar.b)) {
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                m mVar2 = (m) arrayList.get(i3);
                if (mVar2.c() == i2) {
                    if (mVar != null) {
                        mVar.g(i, mVar2);
                        arrayList.remove(mVar);
                    }
                    mVar = mVar2;
                    break;
                }
            }
        } else if (i2 != -1) {
            return mVar;
        }
        if (mVar == null) {
            if ((constraintWidget instanceof sw0) && (iW1 = ((sw0) constraintWidget).w1(i)) != -1) {
                for (int i4 = 0; i4 < arrayList.size(); i4++) {
                    m mVar3 = (m) arrayList.get(i4);
                    if (mVar3.c() == iW1) {
                        mVar = mVar3;
                        break;
                    }
                }
            }
            if (mVar == null) {
                mVar = new m(i);
            }
            arrayList.add(mVar);
        }
        if (mVar.a(constraintWidget)) {
            if (constraintWidget instanceof androidx.constraintlayout.core.widgets.f) {
                androidx.constraintlayout.core.widgets.f fVar = (androidx.constraintlayout.core.widgets.f) constraintWidget;
                fVar.v1().c(fVar.w1() == 0 ? 1 : 0, arrayList, mVar);
            }
            if (i == 0) {
                constraintWidget.S0 = mVar.c();
                constraintWidget.Q.c(i, arrayList, mVar);
                constraintWidget.S.c(i, arrayList, mVar);
            } else {
                constraintWidget.T0 = mVar.c();
                constraintWidget.R.c(i, arrayList, mVar);
                constraintWidget.U.c(i, arrayList, mVar);
                constraintWidget.T.c(i, arrayList, mVar);
            }
            constraintWidget.X.c(i, arrayList, mVar);
        }
        return mVar;
    }

    private static m b(ArrayList arrayList, int i) {
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            m mVar = (m) arrayList.get(i2);
            if (i == mVar.b) {
                return mVar;
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:176:0x0348  */
    public static boolean c(androidx.constraintlayout.core.widgets.d dVar, b.InterfaceC0013b interfaceC0013b) {
        m mVar;
        boolean z;
        boolean z2;
        m mVar2;
        ArrayList arrayListV1 = dVar.v1();
        int size = arrayListV1.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            ConstraintWidget constraintWidget = (ConstraintWidget) arrayListV1.get(i2);
            if (!d(dVar.C(), dVar.V(), constraintWidget.C(), constraintWidget.V()) || (constraintWidget instanceof androidx.constraintlayout.core.widgets.e)) {
                return false;
            }
        }
        int i3 = 0;
        ArrayList arrayList = null;
        ArrayList<sw0> arrayList2 = null;
        ArrayList arrayList3 = null;
        ArrayList<sw0> arrayList4 = null;
        ArrayList arrayList5 = null;
        ArrayList arrayList6 = null;
        while (i3 < size) {
            ConstraintWidget constraintWidget2 = (ConstraintWidget) arrayListV1.get(i3);
            if (!d(dVar.C(), dVar.V(), constraintWidget2.C(), constraintWidget2.V())) {
                androidx.constraintlayout.core.widgets.d.W1(i, constraintWidget2, interfaceC0013b, dVar.z1, b.a.k);
            }
            boolean z3 = constraintWidget2 instanceof androidx.constraintlayout.core.widgets.f;
            if (z3) {
                androidx.constraintlayout.core.widgets.f fVar = (androidx.constraintlayout.core.widgets.f) constraintWidget2;
                if (fVar.w1() == 0) {
                    if (arrayList3 == null) {
                        arrayList3 = new ArrayList();
                    }
                    arrayList3.add(fVar);
                }
                if (fVar.w1() == 1) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(fVar);
                }
            }
            if (constraintWidget2 instanceof sw0) {
                if (constraintWidget2 instanceof androidx.constraintlayout.core.widgets.a) {
                    androidx.constraintlayout.core.widgets.a aVar = (androidx.constraintlayout.core.widgets.a) constraintWidget2;
                    if (aVar.B1() == 0) {
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList();
                        }
                        arrayList2.add(aVar);
                    }
                    if (aVar.B1() == 1) {
                        if (arrayList4 == null) {
                            arrayList4 = new ArrayList();
                        }
                        arrayList4.add(aVar);
                    }
                } else {
                    sw0 sw0Var = (sw0) constraintWidget2;
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                    }
                    arrayList2.add(sw0Var);
                    if (arrayList4 == null) {
                        arrayList4 = new ArrayList();
                    }
                    arrayList4.add(sw0Var);
                }
            }
            if (constraintWidget2.Q.f == null && constraintWidget2.S.f == null && !z3 && !(constraintWidget2 instanceof androidx.constraintlayout.core.widgets.a)) {
                if (arrayList5 == null) {
                    arrayList5 = new ArrayList();
                }
                arrayList5.add(constraintWidget2);
            }
            if (constraintWidget2.R.f == null && constraintWidget2.T.f == null && constraintWidget2.U.f == null && !z3 && !(constraintWidget2 instanceof androidx.constraintlayout.core.widgets.a)) {
                if (arrayList6 == null) {
                    arrayList6 = new ArrayList();
                }
                arrayList6.add(constraintWidget2);
            }
            i3++;
            i = 0;
        }
        ArrayList<m> arrayList7 = new ArrayList();
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                a((androidx.constraintlayout.core.widgets.f) it.next(), 0, arrayList7, null);
            }
        }
        int i4 = 0;
        m mVar3 = null;
        if (arrayList2 != null) {
            for (sw0 sw0Var2 : arrayList2) {
                m mVarA = a(sw0Var2, i4, arrayList7, mVar3);
                sw0Var2.v1(arrayList7, i4, mVarA);
                mVarA.b(arrayList7);
                i4 = 0;
                mVar3 = null;
            }
        }
        ConstraintAnchor constraintAnchorQ = dVar.q(ConstraintAnchor.Type.LEFT);
        if (constraintAnchorQ.d() != null) {
            Iterator it2 = constraintAnchorQ.d().iterator();
            while (it2.hasNext()) {
                a(((ConstraintAnchor) it2.next()).d, 0, arrayList7, null);
            }
        }
        ConstraintAnchor constraintAnchorQ2 = dVar.q(ConstraintAnchor.Type.RIGHT);
        if (constraintAnchorQ2.d() != null) {
            Iterator it3 = constraintAnchorQ2.d().iterator();
            while (it3.hasNext()) {
                a(((ConstraintAnchor) it3.next()).d, 0, arrayList7, null);
            }
        }
        ConstraintAnchor constraintAnchorQ3 = dVar.q(ConstraintAnchor.Type.CENTER);
        if (constraintAnchorQ3.d() != null) {
            Iterator it4 = constraintAnchorQ3.d().iterator();
            while (it4.hasNext()) {
                a(((ConstraintAnchor) it4.next()).d, 0, arrayList7, null);
            }
        }
        m mVar4 = null;
        if (arrayList5 != null) {
            Iterator it5 = arrayList5.iterator();
            while (it5.hasNext()) {
                a((ConstraintWidget) it5.next(), 0, arrayList7, null);
            }
        }
        if (arrayList3 != null) {
            Iterator it6 = arrayList3.iterator();
            while (it6.hasNext()) {
                a((androidx.constraintlayout.core.widgets.f) it6.next(), 1, arrayList7, null);
            }
        }
        int i5 = 1;
        if (arrayList4 != null) {
            for (sw0 sw0Var3 : arrayList4) {
                m mVarA2 = a(sw0Var3, i5, arrayList7, mVar4);
                sw0Var3.v1(arrayList7, i5, mVarA2);
                mVarA2.b(arrayList7);
                i5 = 1;
                mVar4 = null;
            }
        }
        ConstraintAnchor constraintAnchorQ4 = dVar.q(ConstraintAnchor.Type.TOP);
        if (constraintAnchorQ4.d() != null) {
            Iterator it7 = constraintAnchorQ4.d().iterator();
            while (it7.hasNext()) {
                a(((ConstraintAnchor) it7.next()).d, 1, arrayList7, null);
            }
        }
        ConstraintAnchor constraintAnchorQ5 = dVar.q(ConstraintAnchor.Type.BASELINE);
        if (constraintAnchorQ5.d() != null) {
            Iterator it8 = constraintAnchorQ5.d().iterator();
            while (it8.hasNext()) {
                a(((ConstraintAnchor) it8.next()).d, 1, arrayList7, null);
            }
        }
        ConstraintAnchor constraintAnchorQ6 = dVar.q(ConstraintAnchor.Type.BOTTOM);
        if (constraintAnchorQ6.d() != null) {
            Iterator it9 = constraintAnchorQ6.d().iterator();
            while (it9.hasNext()) {
                a(((ConstraintAnchor) it9.next()).d, 1, arrayList7, null);
            }
        }
        ConstraintAnchor constraintAnchorQ7 = dVar.q(ConstraintAnchor.Type.CENTER);
        if (constraintAnchorQ7.d() != null) {
            Iterator it10 = constraintAnchorQ7.d().iterator();
            while (it10.hasNext()) {
                a(((ConstraintAnchor) it10.next()).d, 1, arrayList7, null);
            }
        }
        if (arrayList6 != null) {
            Iterator it11 = arrayList6.iterator();
            while (it11.hasNext()) {
                a((ConstraintWidget) it11.next(), 1, arrayList7, null);
            }
        }
        for (int i6 = 0; i6 < size; i6++) {
            ConstraintWidget constraintWidget3 = (ConstraintWidget) arrayListV1.get(i6);
            if (constraintWidget3.u0()) {
                m mVarB = b(arrayList7, constraintWidget3.S0);
                m mVarB2 = b(arrayList7, constraintWidget3.T0);
                if (mVarB != null && mVarB2 != null) {
                    mVarB.g(0, mVarB2);
                    mVarB2.i(2);
                    arrayList7.remove(mVarB);
                }
            }
        }
        if (arrayList7.size() <= 1) {
            return false;
        }
        if (dVar.C() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
            mVar = null;
            int i7 = 0;
            for (m mVar5 : arrayList7) {
                if (mVar5.d() != 1) {
                    mVar5.h(false);
                    int iF = mVar5.f(dVar.O1(), 0);
                    if (iF > i7) {
                        mVar = mVar5;
                        i7 = iF;
                    }
                }
            }
            if (mVar != null) {
                dVar.T0(ConstraintWidget.DimensionBehaviour.FIXED);
                dVar.o1(i7);
                mVar.h(true);
            } else {
                mVar = null;
            }
        } else {
            mVar = null;
        }
        if (dVar.V() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
            m mVar6 = null;
            int i8 = 0;
            for (m mVar7 : arrayList7) {
                if (mVar7.d() != 0) {
                    mVar7.h(false);
                    int iF2 = mVar7.f(dVar.O1(), 1);
                    if (iF2 > i8) {
                        mVar6 = mVar7;
                        i8 = iF2;
                    }
                }
            }
            z = false;
            z2 = true;
            if (mVar6 != null) {
                dVar.k1(ConstraintWidget.DimensionBehaviour.FIXED);
                dVar.P0(i8);
                mVar6.h(true);
                mVar2 = mVar6;
            }
            return (mVar == null || mVar2 != null) ? z2 : z;
        }
        z = false;
        z2 = true;
        mVar2 = null;
        if (mVar == null) {
        }
    }

    public static boolean d(ConstraintWidget.DimensionBehaviour dimensionBehaviour, ConstraintWidget.DimensionBehaviour dimensionBehaviour2, ConstraintWidget.DimensionBehaviour dimensionBehaviour3, ConstraintWidget.DimensionBehaviour dimensionBehaviour4) {
        ConstraintWidget.DimensionBehaviour dimensionBehaviour5;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour6;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour7 = ConstraintWidget.DimensionBehaviour.FIXED;
        return (dimensionBehaviour3 == dimensionBehaviour7 || dimensionBehaviour3 == (dimensionBehaviour6 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || (dimensionBehaviour3 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && dimensionBehaviour != dimensionBehaviour6)) || (dimensionBehaviour4 == dimensionBehaviour7 || dimensionBehaviour4 == (dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || (dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && dimensionBehaviour2 != dimensionBehaviour5));
    }
}
