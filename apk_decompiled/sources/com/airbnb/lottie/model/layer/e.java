package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import defpackage.d91;
import defpackage.je1;
import defpackage.u20;
import defpackage.zn2;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class e extends a {
    private final u20 w;

    e(je1 je1Var, Layer layer) {
        super(je1Var, layer);
        u20 u20Var = new u20(je1Var, this, new zn2("__container", layer.l()));
        this.w = u20Var;
        u20Var.b(Collections.emptyList(), Collections.emptyList());
    }

    @Override // com.airbnb.lottie.model.layer.a, defpackage.wd0
    public void d(RectF rectF, Matrix matrix) {
        super.d(rectF, matrix);
        this.w.d(rectF, this.m);
    }

    @Override // com.airbnb.lottie.model.layer.a
    void n(Canvas canvas, Matrix matrix, int i) {
        this.w.h(canvas, matrix, i);
    }

    @Override // com.airbnb.lottie.model.layer.a
    protected void w(d91 d91Var, int i, List list, d91 d91Var2) {
        this.w.g(d91Var, i, list, d91Var2);
    }
}
