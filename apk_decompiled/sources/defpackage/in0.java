package defpackage;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.model.layer.a;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class in0 implements wd0, tg.a, f91 {
    private final Path a;
    private final Paint b;
    private final a c;
    private final String d;
    private final List e;
    private final tg f;
    private final tg g;
    private tg h;
    private final je1 i;

    public in0(je1 je1Var, a aVar, xn2 xn2Var) {
        Path path = new Path();
        this.a = path;
        this.b = new Paint(1);
        this.e = new ArrayList();
        this.c = aVar;
        this.d = xn2Var.d();
        this.i = je1Var;
        if (xn2Var.b() == null || xn2Var.e() == null) {
            this.f = null;
            this.g = null;
            return;
        }
        path.setFillType(xn2Var.c());
        tg tgVarA = xn2Var.b().a();
        this.f = tgVarA;
        tgVarA.a(this);
        aVar.i(tgVarA);
        tg tgVarA2 = xn2Var.e().a();
        this.g = tgVarA2;
        tgVarA2.a(this);
        aVar.i(tgVarA2);
    }

    @Override // tg.a
    public void a() {
        this.i.invalidateSelf();
    }

    @Override // defpackage.s20
    public void b(List list, List list2) {
        for (int i = 0; i < list2.size(); i++) {
            s20 s20Var = (s20) list2.get(i);
            if (s20Var instanceof iz1) {
                this.e.add((iz1) s20Var);
            }
        }
    }

    @Override // defpackage.wd0
    public void d(RectF rectF, Matrix matrix) {
        this.a.reset();
        for (int i = 0; i < this.e.size(); i++) {
            this.a.addPath(((iz1) this.e.get(i)).c(), matrix);
        }
        this.a.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // defpackage.e91
    public void f(Object obj, re1 re1Var) {
        if (obj == ne1.a) {
            this.f.m(re1Var);
            return;
        }
        if (obj == ne1.d) {
            this.g.m(re1Var);
            return;
        }
        if (obj == ne1.x) {
            if (re1Var == null) {
                this.h = null;
                return;
            }
            bb3 bb3Var = new bb3(re1Var);
            this.h = bb3Var;
            bb3Var.a(this);
            this.c.i(this.h);
        }
    }

    @Override // defpackage.e91
    public void g(d91 d91Var, int i, List list, d91 d91Var2) {
        ok1.l(d91Var, i, list, d91Var2, this);
    }

    @Override // defpackage.s20
    public String getName() {
        return this.d;
    }

    @Override // defpackage.wd0
    public void h(Canvas canvas, Matrix matrix, int i) {
        o91.a("FillContent#draw");
        this.b.setColor(((Integer) this.f.h()).intValue());
        this.b.setAlpha(ok1.c((int) ((((i / 255.0f) * ((Integer) this.g.h()).intValue()) / 100.0f) * 255.0f), 0, 255));
        tg tgVar = this.h;
        if (tgVar != null) {
            this.b.setColorFilter((ColorFilter) tgVar.h());
        }
        this.a.reset();
        for (int i2 = 0; i2 < this.e.size(); i2++) {
            this.a.addPath(((iz1) this.e.get(i2)).c(), matrix);
        }
        canvas.drawPath(this.a, this.b);
        o91.c("FillContent#draw");
    }
}
