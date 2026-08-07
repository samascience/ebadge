package xfkj.fitpro.view;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import xfkj.fitpro.R$styleable;

/* JADX INFO: loaded from: classes4.dex */
public class SmoothRoundProgressBar extends View {
    private int a;
    private int b;
    private int c;
    private int d;
    private Paint e;
    private int[] f;
    private final RectF g;
    private Paint h;

    public SmoothRoundProgressBar(Context context) {
        super(context);
        this.g = new RectF();
        b(context, null);
    }

    private int a(int i) {
        return (int) ((i * getResources().getDisplayMetrics().density) + 0.5f);
    }

    private void b(Context context, AttributeSet attributeSet) {
        this.a = a(7);
        this.b = -1;
        this.c = -3355444;
        this.d = 1200;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.id, R.attr.background, R.attr.layout_width, R.attr.layout_height});
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(2, -1);
        typedArrayObtainStyledAttributes.recycle();
        Log.e("height", "height:" + dimensionPixelSize);
        if (dimensionPixelSize > 0) {
            this.a = (int) (((double) dimensionPixelSize) * 0.1d);
        } else {
            this.a = a(5);
        }
        TypedArray typedArrayObtainStyledAttributes2 = null;
        try {
            typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R$styleable.MyCircleProgressBar);
            this.a = (int) typedArrayObtainStyledAttributes2.getDimension(3, this.a);
            this.b = typedArrayObtainStyledAttributes2.getColor(2, this.b);
            this.c = typedArrayObtainStyledAttributes2.getColor(1, this.c);
            this.d = typedArrayObtainStyledAttributes2.getInteger(0, this.d);
            typedArrayObtainStyledAttributes2.recycle();
            this.f = new int[]{this.b, this.c};
            Paint paint = new Paint();
            this.e = paint;
            paint.setAntiAlias(true);
            this.e.setStrokeWidth(this.a);
            this.e.setStyle(Paint.Style.STROKE);
            this.e.setStrokeJoin(Paint.Join.ROUND);
            this.e.setStrokeCap(Paint.Cap.ROUND);
            this.e.setColor(this.b);
            Paint paint2 = new Paint();
            this.h = paint2;
            paint2.setAntiAlias(true);
            this.h.setColor(this.c);
            this.h.setStyle(Paint.Style.FILL);
        } catch (Throwable th) {
            if (typedArrayObtainStyledAttributes2 != null) {
                typedArrayObtainStyledAttributes2.recycle();
            }
            throw th;
        }
    }

    public int getDuration() {
        return this.d;
    }

    public int getEndColor() {
        return this.c;
    }

    public int getStrokeWidth() {
        return this.a;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        clearAnimation();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        int measuredWidth = getMeasuredWidth() / 2;
        int measuredHeight = getMeasuredHeight() / 2;
        int measuredWidth2 = (getMeasuredWidth() / 2) - (this.a / 2);
        float f = measuredWidth;
        float f2 = measuredHeight;
        canvas.rotate(-90.0f, f, f2);
        this.e.setShader(new SweepGradient(f, f2, this.f, (float[]) null));
        canvas.drawCircle(f, f2, measuredWidth2, this.e);
        canvas.save();
        canvas.drawOval(this.g, this.h);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.g.left = getMeasuredWidth() - this.a;
        this.g.top = (getMeasuredHeight() / 2) - (this.a / 2);
        this.g.right = getMeasuredWidth();
        this.g.bottom = (getMeasuredHeight() / 2) + (this.a / 2);
    }

    public void setDuration(int i) {
        this.d = i;
    }

    public void setEndColor(int i) {
        if (this.c != i) {
            this.c = i;
            this.f = new int[]{this.b, i};
            invalidate();
        }
    }

    public void setStrokeWidth(int i) {
        if (this.a != i) {
            this.a = i;
            this.e.setStrokeWidth(i);
            requestLayout();
        }
    }

    public SmoothRoundProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = new RectF();
        b(context, attributeSet);
    }

    public SmoothRoundProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.g = new RectF();
        b(context, attributeSet);
    }
}
