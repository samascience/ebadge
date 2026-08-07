package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import defpackage.je1;

/* JADX INFO: loaded from: classes.dex */
public class d extends a {
    d(je1 je1Var, Layer layer) {
        super(je1Var, layer);
    }

    @Override // com.airbnb.lottie.model.layer.a, defpackage.wd0
    public void d(RectF rectF, Matrix matrix) {
        super.d(rectF, matrix);
        rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
    }

    @Override // com.airbnb.lottie.model.layer.a
    void n(Canvas canvas, Matrix matrix, int i) {
    }
}
