package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R$styleable;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class MotionHelper extends ConstraintHelper implements MotionLayout.j {
    private boolean j;
    private boolean k;
    private float l;
    protected View[] m;

    public MotionHelper(Context context) {
        super(context);
        this.j = false;
        this.k = false;
    }

    public void A(Canvas canvas) {
    }

    public void B(Canvas canvas) {
    }

    public void C(MotionLayout motionLayout, HashMap map) {
    }

    public void D(View view, float f) {
    }

    public void a(MotionLayout motionLayout, int i, int i2, float f) {
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.j
    public void b(MotionLayout motionLayout, int i, int i2) {
    }

    public void c(MotionLayout motionLayout, int i) {
    }

    public float getProgress() {
        return this.l;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    protected void n(AttributeSet attributeSet) {
        super.n(attributeSet);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.MotionHelper);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == R$styleable.MotionHelper_onShow) {
                    this.j = typedArrayObtainStyledAttributes.getBoolean(index, this.j);
                } else if (index == R$styleable.MotionHelper_onHide) {
                    this.k = typedArrayObtainStyledAttributes.getBoolean(index, this.k);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public void setProgress(float f) {
        this.l = f;
        int i = 0;
        if (this.b > 0) {
            this.m = m((ConstraintLayout) getParent());
            while (i < this.b) {
                D(this.m[i], f);
                i++;
            }
            return;
        }
        ViewGroup viewGroup = (ViewGroup) getParent();
        int childCount = viewGroup.getChildCount();
        while (i < childCount) {
            View childAt = viewGroup.getChildAt(i);
            if (!(childAt instanceof MotionHelper)) {
                D(childAt, f);
            }
            i++;
        }
    }

    public boolean w() {
        return false;
    }

    public boolean x() {
        return this.k;
    }

    public boolean y() {
        return this.j;
    }

    public void z(MotionLayout motionLayout) {
    }

    public MotionHelper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = false;
        this.k = false;
        n(attributeSet);
    }

    public MotionHelper(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.j = false;
        this.k = false;
        n(attributeSet);
    }
}
