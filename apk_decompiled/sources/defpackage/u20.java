package defpackage;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.model.layer.a;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class u20 implements wd0, iz1, tg.a, e91 {
    private final Matrix a;
    private final Path b;
    private final RectF c;
    private final String d;
    private final List e;
    private final je1 f;
    private List g;
    private x43 h;

    public u20(je1 je1Var, a aVar, zn2 zn2Var) {
        this(je1Var, aVar, zn2Var.c(), e(je1Var, aVar, zn2Var.b()), i(zn2Var.b()));
    }

    private static List e(je1 je1Var, a aVar, List list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            s20 s20VarA = ((j30) list.get(i)).a(je1Var, aVar);
            if (s20VarA != null) {
                arrayList.add(s20VarA);
            }
        }
        return arrayList;
    }

    static s6 i(List list) {
        for (int i = 0; i < list.size(); i++) {
            j30 j30Var = (j30) list.get(i);
            if (j30Var instanceof s6) {
                return (s6) j30Var;
            }
        }
        return null;
    }

    @Override // tg.a
    public void a() {
        this.f.invalidateSelf();
    }

    @Override // defpackage.s20
    public void b(List list, List list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.e.size());
        arrayList.addAll(list);
        for (int size = this.e.size() - 1; size >= 0; size--) {
            s20 s20Var = (s20) this.e.get(size);
            s20Var.b(arrayList, this.e.subList(0, size));
            arrayList.add(s20Var);
        }
    }

    @Override // defpackage.iz1
    public Path c() {
        this.a.reset();
        x43 x43Var = this.h;
        if (x43Var != null) {
            this.a.set(x43Var.e());
        }
        this.b.reset();
        for (int size = this.e.size() - 1; size >= 0; size--) {
            s20 s20Var = (s20) this.e.get(size);
            if (s20Var instanceof iz1) {
                this.b.addPath(((iz1) s20Var).c(), this.a);
            }
        }
        return this.b;
    }

    @Override // defpackage.wd0
    public void d(RectF rectF, Matrix matrix) {
        this.a.set(matrix);
        x43 x43Var = this.h;
        if (x43Var != null) {
            this.a.preConcat(x43Var.e());
        }
        this.c.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.e.size() - 1; size >= 0; size--) {
            s20 s20Var = (s20) this.e.get(size);
            if (s20Var instanceof wd0) {
                ((wd0) s20Var).d(this.c, this.a);
                if (rectF.isEmpty()) {
                    rectF.set(this.c);
                } else {
                    rectF.set(Math.min(rectF.left, this.c.left), Math.min(rectF.top, this.c.top), Math.max(rectF.right, this.c.right), Math.max(rectF.bottom, this.c.bottom));
                }
            }
        }
    }

    @Override // defpackage.e91
    public void f(Object obj, re1 re1Var) {
        x43 x43Var = this.h;
        if (x43Var != null) {
            x43Var.c(obj, re1Var);
        }
    }

    @Override // defpackage.e91
    public void g(d91 d91Var, int i, List list, d91 d91Var2) {
        if (d91Var.g(getName(), i)) {
            if (!"__container".equals(getName())) {
                d91Var2 = d91Var2.a(getName());
                if (d91Var.c(getName(), i)) {
                    list.add(d91Var2.i(this));
                }
            }
            if (d91Var.h(getName(), i)) {
                int iE = i + d91Var.e(getName(), i);
                for (int i2 = 0; i2 < this.e.size(); i2++) {
                    s20 s20Var = (s20) this.e.get(i2);
                    if (s20Var instanceof e91) {
                        ((e91) s20Var).g(d91Var, iE, list, d91Var2);
                    }
                }
            }
        }
    }

    @Override // defpackage.s20
    public String getName() {
        return this.d;
    }

    @Override // defpackage.wd0
    public void h(Canvas canvas, Matrix matrix, int i) {
        this.a.set(matrix);
        x43 x43Var = this.h;
        if (x43Var != null) {
            this.a.preConcat(x43Var.e());
            i = (int) ((((((Integer) this.h.g().h()).intValue() / 100.0f) * i) / 255.0f) * 255.0f);
        }
        for (int size = this.e.size() - 1; size >= 0; size--) {
            Object obj = this.e.get(size);
            if (obj instanceof wd0) {
                ((wd0) obj).h(canvas, this.a, i);
            }
        }
    }

    List j() {
        if (this.g == null) {
            this.g = new ArrayList();
            for (int i = 0; i < this.e.size(); i++) {
                s20 s20Var = (s20) this.e.get(i);
                if (s20Var instanceof iz1) {
                    this.g.add((iz1) s20Var);
                }
            }
        }
        return this.g;
    }

    Matrix k() {
        x43 x43Var = this.h;
        if (x43Var != null) {
            return x43Var.e();
        }
        this.a.reset();
        return this.a;
    }

    u20(je1 je1Var, a aVar, String str, List list, s6 s6Var) {
        this.a = new Matrix();
        this.b = new Path();
        this.c = new RectF();
        this.d = str;
        this.f = je1Var;
        this.e = list;
        if (s6Var != null) {
            x43 x43VarB = s6Var.b();
            this.h = x43VarB;
            x43VarB.a(aVar);
            this.h.b(this);
        }
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            s20 s20Var = (s20) list.get(size);
            if (s20Var instanceof jv0) {
                arrayList.add((jv0) s20Var);
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ((jv0) arrayList.get(size2)).e(list.listIterator(list.size()));
        }
    }
}
