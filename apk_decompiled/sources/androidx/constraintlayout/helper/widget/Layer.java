package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R$styleable;

/* JADX INFO: loaded from: classes.dex */
public class Layer extends ConstraintHelper {
    private boolean F;
    private float j;
    private float k;
    private float l;
    ConstraintLayout m;
    private float n;
    private float o;
    protected float p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    protected float f169q;
    protected float r;
    protected float s;
    protected float t;
    protected float u;
    boolean v;
    View[] w;
    private float x;
    private float y;
    private boolean z;

    public Layer(Context context) {
        super(context);
        this.j = Float.NaN;
        this.k = Float.NaN;
        this.l = Float.NaN;
        this.n = 1.0f;
        this.o = 1.0f;
        this.p = Float.NaN;
        this.f169q = Float.NaN;
        this.r = Float.NaN;
        this.s = Float.NaN;
        this.t = Float.NaN;
        this.u = Float.NaN;
        this.v = true;
        this.w = null;
        this.x = 0.0f;
        this.y = 0.0f;
    }

    private void x() {
        int i;
        if (this.m == null || (i = this.b) == 0) {
            return;
        }
        View[] viewArr = this.w;
        if (viewArr == null || viewArr.length != i) {
            this.w = new View[i];
        }
        for (int i2 = 0; i2 < this.b; i2++) {
            this.w[i2] = this.m.i(this.a[i2]);
        }
    }

    private void y() {
        if (this.m == null) {
            return;
        }
        if (this.w == null) {
            x();
        }
        w();
        double radians = Float.isNaN(this.l) ? 0.0d : Math.toRadians(this.l);
        float fSin = (float) Math.sin(radians);
        float fCos = (float) Math.cos(radians);
        float f = this.n;
        float f2 = f * fCos;
        float f3 = this.o;
        float f4 = (-f3) * fSin;
        float f5 = f * fSin;
        float f6 = f3 * fCos;
        for (int i = 0; i < this.b; i++) {
            View view = this.w[i];
            int left = (view.getLeft() + view.getRight()) / 2;
            int top = (view.getTop() + view.getBottom()) / 2;
            float f7 = left - this.p;
            float f8 = top - this.f169q;
            float f9 = (((f2 * f7) + (f4 * f8)) - f7) + this.x;
            float f10 = (((f7 * f5) + (f6 * f8)) - f8) + this.y;
            view.setTranslationX(f9);
            view.setTranslationY(f10);
            view.setScaleY(this.o);
            view.setScaleX(this.n);
            if (!Float.isNaN(this.l)) {
                view.setRotation(this.l);
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    protected void i(ConstraintLayout constraintLayout) {
        h(constraintLayout);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    protected void n(AttributeSet attributeSet) {
        super.n(attributeSet);
        this.e = false;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_Layout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == R$styleable.ConstraintLayout_Layout_android_visibility) {
                    this.z = true;
                } else if (index == R$styleable.ConstraintLayout_Layout_android_elevation) {
                    this.F = true;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.m = (ConstraintLayout) getParent();
        if (this.z || this.F) {
            int visibility = getVisibility();
            float elevation = getElevation();
            for (int i = 0; i < this.b; i++) {
                View viewI = this.m.i(this.a[i]);
                if (viewI != null) {
                    if (this.z) {
                        viewI.setVisibility(visibility);
                    }
                    if (this.F && elevation > 0.0f) {
                        viewI.setTranslationZ(viewI.getTranslationZ() + elevation);
                    }
                }
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void q(ConstraintLayout constraintLayout) {
        x();
        this.p = Float.NaN;
        this.f169q = Float.NaN;
        ConstraintWidget constraintWidgetB = ((ConstraintLayout.b) getLayoutParams()).b();
        constraintWidgetB.o1(0);
        constraintWidgetB.P0(0);
        w();
        layout(((int) this.t) - getPaddingLeft(), ((int) this.u) - getPaddingTop(), ((int) this.r) + getPaddingRight(), ((int) this.s) + getPaddingBottom());
        y();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void s(ConstraintLayout constraintLayout) {
        this.m = constraintLayout;
        float rotation = getRotation();
        if (rotation != 0.0f) {
            this.l = rotation;
        } else {
            if (Float.isNaN(this.l)) {
                return;
            }
            this.l = rotation;
        }
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        g();
    }

    @Override // android.view.View
    public void setPivotX(float f) {
        this.j = f;
        y();
    }

    @Override // android.view.View
    public void setPivotY(float f) {
        this.k = f;
        y();
    }

    @Override // android.view.View
    public void setRotation(float f) {
        this.l = f;
        y();
    }

    @Override // android.view.View
    public void setScaleX(float f) {
        this.n = f;
        y();
    }

    @Override // android.view.View
    public void setScaleY(float f) {
        this.o = f;
        y();
    }

    @Override // android.view.View
    public void setTranslationX(float f) {
        this.x = f;
        y();
    }

    @Override // android.view.View
    public void setTranslationY(float f) {
        this.y = f;
        y();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        g();
    }

    protected void w() {
        if (this.m == null) {
            return;
        }
        if (this.v || Float.isNaN(this.p) || Float.isNaN(this.f169q)) {
            if (!Float.isNaN(this.j) && !Float.isNaN(this.k)) {
                this.f169q = this.k;
                this.p = this.j;
                return;
            }
            View[] viewArrM = m(this.m);
            int left = viewArrM[0].getLeft();
            int top = viewArrM[0].getTop();
            int right = viewArrM[0].getRight();
            int bottom = viewArrM[0].getBottom();
            for (int i = 0; i < this.b; i++) {
                View view = viewArrM[i];
                left = Math.min(left, view.getLeft());
                top = Math.min(top, view.getTop());
                right = Math.max(right, view.getRight());
                bottom = Math.max(bottom, view.getBottom());
            }
            this.r = right;
            this.s = bottom;
            this.t = left;
            this.u = top;
            if (Float.isNaN(this.j)) {
                this.p = (left + right) / 2;
            } else {
                this.p = this.j;
            }
            if (Float.isNaN(this.k)) {
                this.f169q = (top + bottom) / 2;
            } else {
                this.f169q = this.k;
            }
        }
    }

    public Layer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = Float.NaN;
        this.k = Float.NaN;
        this.l = Float.NaN;
        this.n = 1.0f;
        this.o = 1.0f;
        this.p = Float.NaN;
        this.f169q = Float.NaN;
        this.r = Float.NaN;
        this.s = Float.NaN;
        this.t = Float.NaN;
        this.u = Float.NaN;
        this.v = true;
        this.w = null;
        this.x = 0.0f;
        this.y = 0.0f;
    }

    public Layer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.j = Float.NaN;
        this.k = Float.NaN;
        this.l = Float.NaN;
        this.n = 1.0f;
        this.o = 1.0f;
        this.p = Float.NaN;
        this.f169q = Float.NaN;
        this.r = Float.NaN;
        this.s = Float.NaN;
        this.t = Float.NaN;
        this.u = Float.NaN;
        this.v = true;
        this.w = null;
        this.x = 0.0f;
        this.y = 0.0f;
    }
}
