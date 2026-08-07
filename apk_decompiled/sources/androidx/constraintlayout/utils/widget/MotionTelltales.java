package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.ViewParent;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.R$styleable;

/* JADX INFO: loaded from: classes.dex */
public class MotionTelltales extends MockView {
    private Paint l;
    MotionLayout m;
    float[] n;
    Matrix o;
    int p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    int f184q;
    float r;

    public MotionTelltales(Context context) {
        super(context);
        this.l = new Paint();
        this.n = new float[2];
        this.o = new Matrix();
        this.p = 0;
        this.f184q = -65281;
        this.r = 0.25f;
        a(context, null);
    }

    private void a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.MotionTelltales);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == R$styleable.MotionTelltales_telltales_tailColor) {
                    this.f184q = typedArrayObtainStyledAttributes.getColor(index, this.f184q);
                } else if (index == R$styleable.MotionTelltales_telltales_velocityMode) {
                    this.p = typedArrayObtainStyledAttributes.getInt(index, this.p);
                } else if (index == R$styleable.MotionTelltales_telltales_tailScale) {
                    this.r = typedArrayObtainStyledAttributes.getFloat(index, this.r);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        this.l.setColor(this.f184q);
        this.l.setStrokeWidth(5.0f);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // androidx.constraintlayout.utils.widget.MockView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        getMatrix().invert(this.o);
        if (this.m == null) {
            ViewParent parent = getParent();
            if (parent instanceof MotionLayout) {
                this.m = (MotionLayout) parent;
                return;
            }
            return;
        }
        int width = getWidth();
        int height = getHeight();
        float[] fArr = {0.1f, 0.25f, 0.5f, 0.75f, 0.9f};
        for (int i = 0; i < 5; i++) {
            float f = fArr[i];
            for (int i2 = 0; i2 < 5; i2++) {
                float f2 = fArr[i2];
                this.m.o0(this, f2, f, this.n, this.p);
                this.o.mapVectors(this.n);
                float f3 = width * f2;
                float f4 = height * f;
                float[] fArr2 = this.n;
                float f5 = fArr2[0];
                float f6 = this.r;
                float f7 = f4 - (fArr2[1] * f6);
                this.o.mapVectors(fArr2);
                canvas.drawLine(f3, f4, f3 - (f5 * f6), f7, this.l);
            }
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        postInvalidate();
    }

    public void setText(CharSequence charSequence) {
        this.f = charSequence.toString();
        requestLayout();
    }

    public MotionTelltales(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.l = new Paint();
        this.n = new float[2];
        this.o = new Matrix();
        this.p = 0;
        this.f184q = -65281;
        this.r = 0.25f;
        a(context, attributeSet);
    }

    public MotionTelltales(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.l = new Paint();
        this.n = new float[2];
        this.o = new Matrix();
        this.p = 0;
        this.f184q = -65281;
        this.r = 0.25f;
        a(context, attributeSet);
    }
}
