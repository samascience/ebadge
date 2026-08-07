package com.google.android.material.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes3.dex */
public class ClippableRoundedCornerLayout extends FrameLayout {
    private Path a;
    private float b;

    public ClippableRoundedCornerLayout(Context context) {
        super(context);
    }

    public void a() {
        this.a = null;
        this.b = 0.0f;
        invalidate();
    }

    public void b(float f, float f2, float f3, float f4, float f5) {
        d(new RectF(f, f2, f3, f4), f5);
    }

    public void c(Rect rect, float f) {
        b(rect.left, rect.top, rect.right, rect.bottom, f);
    }

    public void d(RectF rectF, float f) {
        if (this.a == null) {
            this.a = new Path();
        }
        this.b = f;
        this.a.reset();
        this.a.addRoundRect(rectF, f, f, Path.Direction.CW);
        this.a.close();
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.a == null) {
            super.dispatchDraw(canvas);
            return;
        }
        int iSave = canvas.save();
        canvas.clipPath(this.a);
        super.dispatchDraw(canvas);
        canvas.restoreToCount(iSave);
    }

    public void e(float f) {
        b(getLeft(), getTop(), getRight(), getBottom(), f);
    }

    public float getCornerRadius() {
        return this.b;
    }

    public ClippableRoundedCornerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ClippableRoundedCornerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
