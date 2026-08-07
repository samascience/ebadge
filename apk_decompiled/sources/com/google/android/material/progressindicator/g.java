package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/* JADX INFO: loaded from: classes3.dex */
abstract class g {
    com.google.android.material.progressindicator.a a;

    protected static class a {
        float a;
        float b;
        int c;
        int d;

        protected a() {
        }
    }

    public g(com.google.android.material.progressindicator.a aVar) {
        this.a = aVar;
    }

    abstract void a(Canvas canvas, Rect rect, float f, boolean z, boolean z2);

    abstract void b(Canvas canvas, Paint paint, int i, int i2);

    abstract void c(Canvas canvas, Paint paint, a aVar, int i);

    abstract void d(Canvas canvas, Paint paint, float f, float f2, int i, int i2, int i3);

    abstract int e();

    abstract int f();

    void g(Canvas canvas, Rect rect, float f, boolean z, boolean z2) {
        this.a.e();
        a(canvas, rect, f, z, z2);
    }
}
