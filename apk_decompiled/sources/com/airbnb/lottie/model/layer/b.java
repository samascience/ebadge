package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import defpackage.bb3;
import defpackage.d91;
import defpackage.fe1;
import defpackage.g6;
import defpackage.je1;
import defpackage.ne1;
import defpackage.o91;
import defpackage.re1;
import defpackage.tg;
import defpackage.zd1;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class b extends com.airbnb.lottie.model.layer.a {
    private tg w;
    private final List x;
    private final RectF y;
    private final RectF z;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Layer.MatteType.values().length];
            a = iArr;
            try {
                iArr[Layer.MatteType.Add.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Layer.MatteType.Invert.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public b(je1 je1Var, Layer layer, List list, fe1 fe1Var) {
        int i;
        com.airbnb.lottie.model.layer.a aVar;
        super(je1Var, layer);
        this.x = new ArrayList();
        this.y = new RectF();
        this.z = new RectF();
        g6 g6VarS = layer.s();
        if (g6VarS != null) {
            tg tgVarA = g6VarS.a();
            this.w = tgVarA;
            i(tgVarA);
            this.w.a(this);
        } else {
            this.w = null;
        }
        zd1 zd1Var = new zd1(fe1Var.j().size());
        int size = list.size() - 1;
        com.airbnb.lottie.model.layer.a aVar2 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            Layer layer2 = (Layer) list.get(size);
            com.airbnb.lottie.model.layer.a aVarO = com.airbnb.lottie.model.layer.a.o(layer2, je1Var, fe1Var);
            if (aVarO != null) {
                zd1Var.f(aVarO.p().b(), aVarO);
                if (aVar2 != null) {
                    aVar2.y(aVarO);
                    aVar2 = null;
                } else {
                    this.x.add(0, aVarO);
                    int i2 = a.a[layer2.f().ordinal()];
                    if (i2 == 1 || i2 == 2) {
                        aVar2 = aVarO;
                    }
                }
            }
            size--;
        }
        for (i = 0; i < zd1Var.i(); i++) {
            com.airbnb.lottie.model.layer.a aVar3 = (com.airbnb.lottie.model.layer.a) zd1Var.c(zd1Var.e(i));
            if (aVar3 != null && (aVar = (com.airbnb.lottie.model.layer.a) zd1Var.c(aVar3.p().h())) != null) {
                aVar3.z(aVar);
            }
        }
    }

    @Override // com.airbnb.lottie.model.layer.a
    public void A(float f) {
        super.A(f);
        if (this.w != null) {
            f = ((long) (((Float) this.w.h()).floatValue() * 1000.0f)) / this.n.j().d();
        }
        if (this.o.t() != 0.0f) {
            f /= this.o.t();
        }
        float fP = f - this.o.p();
        for (int size = this.x.size() - 1; size >= 0; size--) {
            ((com.airbnb.lottie.model.layer.a) this.x.get(size)).A(fP);
        }
    }

    @Override // com.airbnb.lottie.model.layer.a, defpackage.wd0
    public void d(RectF rectF, Matrix matrix) {
        super.d(rectF, matrix);
        this.y.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.x.size() - 1; size >= 0; size--) {
            ((com.airbnb.lottie.model.layer.a) this.x.get(size)).d(this.y, this.m);
            if (rectF.isEmpty()) {
                rectF.set(this.y);
            } else {
                rectF.set(Math.min(rectF.left, this.y.left), Math.min(rectF.top, this.y.top), Math.max(rectF.right, this.y.right), Math.max(rectF.bottom, this.y.bottom));
            }
        }
    }

    @Override // com.airbnb.lottie.model.layer.a, defpackage.e91
    public void f(Object obj, re1 re1Var) {
        super.f(obj, re1Var);
        if (obj == ne1.w) {
            if (re1Var == null) {
                this.w = null;
                return;
            }
            bb3 bb3Var = new bb3(re1Var);
            this.w = bb3Var;
            i(bb3Var);
        }
    }

    @Override // com.airbnb.lottie.model.layer.a
    void n(Canvas canvas, Matrix matrix, int i) {
        o91.a("CompositionLayer#draw");
        canvas.save();
        this.z.set(0.0f, 0.0f, this.o.j(), this.o.i());
        matrix.mapRect(this.z);
        for (int size = this.x.size() - 1; size >= 0; size--) {
            if (!this.z.isEmpty() ? canvas.clipRect(this.z) : true) {
                ((com.airbnb.lottie.model.layer.a) this.x.get(size)).h(canvas, matrix, i);
            }
        }
        canvas.restore();
        o91.c("CompositionLayer#draw");
    }

    @Override // com.airbnb.lottie.model.layer.a
    protected void w(d91 d91Var, int i, List list, d91 d91Var2) {
        for (int i2 = 0; i2 < this.x.size(); i2++) {
            ((com.airbnb.lottie.model.layer.a) this.x.get(i2)).g(d91Var, i, list, d91Var2);
        }
    }
}
