package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import defpackage.be3;
import defpackage.mu1;
import defpackage.o23;
import defpackage.zi3;

/* JADX INFO: loaded from: classes3.dex */
public class ScrimInsetsFrameLayout extends FrameLayout {
    Drawable a;
    Rect b;
    private Rect c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;

    class a implements mu1 {
        a() {
        }

        @Override // defpackage.mu1
        public zi3 a(View view, zi3 zi3Var) {
            ScrimInsetsFrameLayout scrimInsetsFrameLayout = ScrimInsetsFrameLayout.this;
            if (scrimInsetsFrameLayout.b == null) {
                scrimInsetsFrameLayout.b = new Rect();
            }
            ScrimInsetsFrameLayout.this.b.set(zi3Var.j(), zi3Var.l(), zi3Var.k(), zi3Var.i());
            ScrimInsetsFrameLayout.this.e(zi3Var);
            ScrimInsetsFrameLayout.this.setWillNotDraw(!zi3Var.m() || ScrimInsetsFrameLayout.this.a == null);
            be3.g0(ScrimInsetsFrameLayout.this);
            return zi3Var.c();
        }
    }

    public ScrimInsetsFrameLayout(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.b == null || this.a == null) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(getScrollX(), getScrollY());
        if (this.d) {
            this.c.set(0, 0, width, this.b.top);
            this.a.setBounds(this.c);
            this.a.draw(canvas);
        }
        if (this.e) {
            this.c.set(0, height - this.b.bottom, width, height);
            this.a.setBounds(this.c);
            this.a.draw(canvas);
        }
        if (this.f) {
            Rect rect = this.c;
            Rect rect2 = this.b;
            rect.set(0, rect2.top, rect2.left, height - rect2.bottom);
            this.a.setBounds(this.c);
            this.a.draw(canvas);
        }
        if (this.g) {
            Rect rect3 = this.c;
            Rect rect4 = this.b;
            rect3.set(width - rect4.right, rect4.top, width, height - rect4.bottom);
            this.a.setBounds(this.c);
            this.a.draw(canvas);
        }
        canvas.restoreToCount(iSave);
    }

    protected void e(zi3 zi3Var) {
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public void setDrawBottomInsetForeground(boolean z) {
        this.e = z;
    }

    public void setDrawLeftInsetForeground(boolean z) {
        this.f = z;
    }

    public void setDrawRightInsetForeground(boolean z) {
        this.g = z;
    }

    public void setDrawTopInsetForeground(boolean z) {
        this.d = z;
    }

    public void setScrimInsetForeground(Drawable drawable) {
        this.a = drawable;
    }

    public ScrimInsetsFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScrimInsetsFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = new Rect();
        this.d = true;
        this.e = true;
        this.f = true;
        this.g = true;
        TypedArray typedArrayI = o23.i(context, attributeSet, R$styleable.ScrimInsetsFrameLayout, i, R$style.Widget_Design_ScrimInsetsFrameLayout, new int[0]);
        this.a = typedArrayI.getDrawable(R$styleable.ScrimInsetsFrameLayout_insetForeground);
        typedArrayI.recycle();
        setWillNotDraw(true);
        be3.E0(this, new a());
    }
}
