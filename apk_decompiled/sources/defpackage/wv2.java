package defpackage;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.model.layer.a;

/* JADX INFO: loaded from: classes.dex */
public class wv2 extends yg {
    private final a o;
    private final String p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final tg f393q;
    private tg r;

    public wv2(je1 je1Var, a aVar, ShapeStroke shapeStroke) {
        super(je1Var, aVar, shapeStroke.b().toPaintCap(), shapeStroke.e().toPaintJoin(), shapeStroke.g(), shapeStroke.i(), shapeStroke.j(), shapeStroke.f(), shapeStroke.d());
        this.o = aVar;
        this.p = shapeStroke.h();
        tg tgVarA = shapeStroke.c().a();
        this.f393q = tgVarA;
        tgVarA.a(this);
        aVar.i(tgVarA);
    }

    @Override // defpackage.yg, defpackage.e91
    public void f(Object obj, re1 re1Var) {
        super.f(obj, re1Var);
        if (obj == ne1.b) {
            this.f393q.m(re1Var);
            return;
        }
        if (obj == ne1.x) {
            if (re1Var == null) {
                this.r = null;
                return;
            }
            bb3 bb3Var = new bb3(re1Var);
            this.r = bb3Var;
            bb3Var.a(this);
            this.o.i(this.f393q);
        }
    }

    @Override // defpackage.s20
    public String getName() {
        return this.p;
    }

    @Override // defpackage.yg, defpackage.wd0
    public void h(Canvas canvas, Matrix matrix, int i) {
        this.i.setColor(((Integer) this.f393q.h()).intValue());
        tg tgVar = this.r;
        if (tgVar != null) {
            this.i.setColorFilter((ColorFilter) tgVar.h());
        }
        super.h(canvas, matrix, i);
    }
}
