package defpackage;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class vn2 {
    private final List a;
    private PointF b;
    private boolean c;

    public vn2(PointF pointF, boolean z, List list) {
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
        this.b = pointF;
        this.c = z;
        arrayList.addAll(list);
    }

    private void e(float f, float f2) {
        if (this.b == null) {
            this.b = new PointF();
        }
        this.b.set(f, f2);
    }

    public List a() {
        return this.a;
    }

    public PointF b() {
        return this.b;
    }

    public void c(vn2 vn2Var, vn2 vn2Var2, float f) {
        if (this.b == null) {
            this.b = new PointF();
        }
        this.c = vn2Var.d() || vn2Var2.d();
        if (vn2Var.a().size() != vn2Var2.a().size()) {
            o91.d("Curves must have the same number of control points. Shape 1: " + vn2Var.a().size() + "\tShape 2: " + vn2Var2.a().size());
        }
        if (this.a.isEmpty()) {
            int iMin = Math.min(vn2Var.a().size(), vn2Var2.a().size());
            for (int i = 0; i < iMin; i++) {
                this.a.add(new d50());
            }
        }
        PointF pointFB = vn2Var.b();
        PointF pointFB2 = vn2Var2.b();
        e(ok1.j(pointFB.x, pointFB2.x, f), ok1.j(pointFB.y, pointFB2.y, f));
        for (int size = this.a.size() - 1; size >= 0; size--) {
            d50 d50Var = (d50) vn2Var.a().get(size);
            d50 d50Var2 = (d50) vn2Var2.a().get(size);
            PointF pointFA = d50Var.a();
            PointF pointFB3 = d50Var.b();
            PointF pointFC = d50Var.c();
            PointF pointFA2 = d50Var2.a();
            PointF pointFB4 = d50Var2.b();
            PointF pointFC2 = d50Var2.c();
            ((d50) this.a.get(size)).d(ok1.j(pointFA.x, pointFA2.x, f), ok1.j(pointFA.y, pointFA2.y, f));
            ((d50) this.a.get(size)).e(ok1.j(pointFB3.x, pointFB4.x, f), ok1.j(pointFB3.y, pointFB4.y, f));
            ((d50) this.a.get(size)).f(ok1.j(pointFC.x, pointFC2.x, f), ok1.j(pointFC.y, pointFC2.y, f));
        }
    }

    public boolean d() {
        return this.c;
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.a.size() + "closed=" + this.c + '}';
    }

    public vn2() {
        this.a = new ArrayList();
    }
}
