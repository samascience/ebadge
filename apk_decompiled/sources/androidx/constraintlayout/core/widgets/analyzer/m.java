package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class m {
    static int g;
    int b;
    int d;
    ArrayList a = new ArrayList();
    boolean c = false;
    ArrayList e = null;
    private int f = -1;

    class a {
        WeakReference a;
        int b;
        int c;
        int d;
        int e;
        int f;
        int g;

        public a(ConstraintWidget constraintWidget, androidx.constraintlayout.core.d dVar, int i) {
            this.a = new WeakReference(constraintWidget);
            this.b = dVar.x(constraintWidget.Q);
            this.c = dVar.x(constraintWidget.R);
            this.d = dVar.x(constraintWidget.S);
            this.e = dVar.x(constraintWidget.T);
            this.f = dVar.x(constraintWidget.U);
            this.g = i;
        }
    }

    public m(int i) {
        int i2 = g;
        g = i2 + 1;
        this.b = i2;
        this.d = i;
    }

    private String e() {
        int i = this.d;
        if (i == 0) {
            return "Horizontal";
        }
        if (i == 1) {
            return "Vertical";
        }
        return i == 2 ? "Both" : "Unknown";
    }

    private int j(androidx.constraintlayout.core.d dVar, ArrayList arrayList, int i) {
        int iX;
        int iX2;
        androidx.constraintlayout.core.widgets.d dVar2 = (androidx.constraintlayout.core.widgets.d) ((ConstraintWidget) arrayList.get(0)).M();
        dVar.D();
        dVar2.g(dVar, false);
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            ((ConstraintWidget) arrayList.get(i2)).g(dVar, false);
        }
        if (i == 0 && dVar2.g1 > 0) {
            androidx.constraintlayout.core.widgets.b.b(dVar2, dVar, arrayList, 0);
        }
        if (i == 1 && dVar2.h1 > 0) {
            androidx.constraintlayout.core.widgets.b.b(dVar2, dVar, arrayList, 1);
        }
        try {
            dVar.z();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.e = new ArrayList();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            this.e.add(new a((ConstraintWidget) arrayList.get(i3), dVar, i));
        }
        if (i == 0) {
            iX = dVar.x(dVar2.Q);
            iX2 = dVar.x(dVar2.S);
            dVar.D();
        } else {
            iX = dVar.x(dVar2.R);
            iX2 = dVar.x(dVar2.T);
            dVar.D();
        }
        return iX2 - iX;
    }

    public boolean a(ConstraintWidget constraintWidget) {
        if (this.a.contains(constraintWidget)) {
            return false;
        }
        this.a.add(constraintWidget);
        return true;
    }

    public void b(ArrayList arrayList) {
        int size = this.a.size();
        if (this.f != -1 && size > 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                m mVar = (m) arrayList.get(i);
                if (this.f == mVar.b) {
                    g(this.d, mVar);
                }
            }
        }
        if (size == 0) {
            arrayList.remove(this);
        }
    }

    public int c() {
        return this.b;
    }

    public int d() {
        return this.d;
    }

    public int f(androidx.constraintlayout.core.d dVar, int i) {
        if (this.a.size() == 0) {
            return 0;
        }
        return j(dVar, this.a, i);
    }

    public void g(int i, m mVar) {
        for (ConstraintWidget constraintWidget : this.a) {
            mVar.a(constraintWidget);
            if (i == 0) {
                constraintWidget.S0 = mVar.c();
            } else {
                constraintWidget.T0 = mVar.c();
            }
        }
        this.f = mVar.b;
    }

    public void h(boolean z) {
        this.c = z;
    }

    public void i(int i) {
        this.d = i;
    }

    public String toString() {
        String str = e() + " [" + this.b + "] <";
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            str = str + " " + ((ConstraintWidget) it.next()).v();
        }
        return str + " >";
    }
}
