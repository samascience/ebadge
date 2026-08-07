package defpackage;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.model.layer.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes.dex */
public class ye2 implements wd0, iz1, jv0, tg.a, f91 {
    private final Matrix a = new Matrix();
    private final Path b = new Path();
    private final je1 c;
    private final a d;
    private final String e;
    private final tg f;
    private final tg g;
    private final x43 h;
    private u20 i;

    public ye2(je1 je1Var, a aVar, xe2 xe2Var) {
        this.c = je1Var;
        this.d = aVar;
        this.e = xe2Var.c();
        tg tgVarA = xe2Var.b().a();
        this.f = tgVarA;
        aVar.i(tgVarA);
        tgVarA.a(this);
        tg tgVarA2 = xe2Var.d().a();
        this.g = tgVarA2;
        aVar.i(tgVarA2);
        tgVarA2.a(this);
        x43 x43VarB = xe2Var.e().b();
        this.h = x43VarB;
        x43VarB.a(aVar);
        x43VarB.b(this);
    }

    @Override // tg.a
    public void a() {
        this.c.invalidateSelf();
    }

    @Override // defpackage.s20
    public void b(List list, List list2) {
        this.i.b(list, list2);
    }

    @Override // defpackage.iz1
    public Path c() {
        Path pathC = this.i.c();
        this.b.reset();
        float fFloatValue = ((Float) this.f.h()).floatValue();
        float fFloatValue2 = ((Float) this.g.h()).floatValue();
        for (int i = ((int) fFloatValue) - 1; i >= 0; i--) {
            this.a.set(this.h.f(i + fFloatValue2));
            this.b.addPath(pathC, this.a);
        }
        return this.b;
    }

    @Override // defpackage.wd0
    public void d(RectF rectF, Matrix matrix) {
        this.i.d(rectF, matrix);
    }

    @Override // defpackage.jv0
    public void e(ListIterator listIterator) {
        if (this.i != null) {
            return;
        }
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        ArrayList arrayList = new ArrayList();
        while (listIterator.hasPrevious()) {
            arrayList.add(listIterator.previous());
            listIterator.remove();
        }
        Collections.reverse(arrayList);
        this.i = new u20(this.c, this.d, "Repeater", arrayList, null);
    }

    @Override // defpackage.e91
    public void f(Object obj, re1 re1Var) {
        if (this.h.c(obj, re1Var)) {
            return;
        }
        if (obj == ne1.m) {
            this.f.m(re1Var);
        } else if (obj == ne1.n) {
            this.g.m(re1Var);
        }
    }

    @Override // defpackage.e91
    public void g(d91 d91Var, int i, List list, d91 d91Var2) {
        ok1.l(d91Var, i, list, d91Var2, this);
    }

    @Override // defpackage.s20
    public String getName() {
        return this.e;
    }

    @Override // defpackage.wd0
    public void h(Canvas canvas, Matrix matrix, int i) {
        float fFloatValue = ((Float) this.f.h()).floatValue();
        float fFloatValue2 = ((Float) this.g.h()).floatValue();
        float fFloatValue3 = ((Float) this.h.h().h()).floatValue() / 100.0f;
        float fFloatValue4 = ((Float) this.h.d().h()).floatValue() / 100.0f;
        for (int i2 = ((int) fFloatValue) - 1; i2 >= 0; i2--) {
            this.a.set(matrix);
            float f = i2;
            this.a.preConcat(this.h.f(f + fFloatValue2));
            this.i.h(canvas, this.a, (int) (i * ok1.j(fFloatValue3, fFloatValue4, f / fFloatValue)));
        }
    }
}
