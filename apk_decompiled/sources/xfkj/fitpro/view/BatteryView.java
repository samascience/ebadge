package xfkj.fitpro.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import xfkj.fitpro.R$styleable;

/* JADX INFO: loaded from: classes4.dex */
public class BatteryView extends View {
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;

    public BatteryView(Context context) {
        super(context);
        this.a = 100;
    }

    private void a(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(this.e);
        paint.setStyle(Paint.Style.STROKE);
        float f = this.c / 20.0f;
        float f2 = f / 2.0f;
        paint.setStrokeWidth(f);
        canvas.drawRect(new RectF(f2, f2, (this.c - f) - f2, this.d - f2), paint);
        paint.setStrokeWidth(0.0f);
        paint.setStyle(Paint.Style.FILL);
        float f3 = ((this.c - (2.0f * f)) * this.a) / 100.0f;
        if (f3 == 0.0f) {
            f3 = f;
        }
        RectF rectF = new RectF(f, f, f3, this.d - f);
        paint.setColor(this.f);
        canvas.drawRect(rectF, paint);
        paint.setColor(this.g);
        int i = this.c;
        float f4 = i - f;
        int i2 = this.d;
        canvas.drawRect(new RectF(f4, i2 * 0.25f, i, i2 * 0.75f), paint);
    }

    private void b(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(this.e);
        paint.setStyle(Paint.Style.STROKE);
        float f = this.d / 20.0f;
        float f2 = f / 2.0f;
        paint.setStrokeWidth(f);
        int i = (int) (0.5f + f);
        float f3 = i;
        canvas.drawRect(new RectF(f2, f3 + f2, this.c - f2, this.d - f2), paint);
        paint.setStrokeWidth(0.0f);
        RectF rectF = new RectF(f, f3 + f + ((((this.d - i) - f) * (100 - this.a)) / 100.0f), this.c - f, this.d - f);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(rectF, paint);
        int i2 = this.c;
        canvas.drawRect(new RectF(i2 / 4.0f, 0.0f, i2 * 0.75f, f3), paint);
    }

    public int getPower() {
        return this.a;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.b == 0) {
            a(canvas);
        } else {
            b(canvas);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.c = getMeasuredWidth();
        this.d = getMeasuredHeight();
    }

    public void setColor(int i) {
        this.e = i;
        invalidate();
    }

    public void setPower(int i) {
        this.a = i;
        if (i < 0) {
            this.a = 100;
        }
        invalidate();
    }

    public void setmBatteryColor(int i) {
        this.f = i;
    }

    public void setmBatteryHeaderColor(int i) {
        this.g = i;
    }

    public BatteryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 100;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Battery);
        this.e = typedArrayObtainStyledAttributes.getColor(1, -1);
        this.f = typedArrayObtainStyledAttributes.getColor(0, -16777216);
        this.g = typedArrayObtainStyledAttributes.getColor(2, -16777216);
        this.b = typedArrayObtainStyledAttributes.getInt(3, 0);
        this.a = typedArrayObtainStyledAttributes.getInt(4, 100);
        this.c = getMeasuredWidth();
        this.d = getMeasuredHeight();
        typedArrayObtainStyledAttributes.recycle();
    }
}
