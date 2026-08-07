package xfkj.fitpro.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.legend.smartwatch.electronicbadge.android.R;
import xfkj.fitpro.R$styleable;

/* JADX INFO: loaded from: classes4.dex */
public class SignalView extends View {
    private int a;
    private int b;
    private String c;
    private Paint d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private float n;

    public SignalView(Context context) {
        super(context);
    }

    private int a(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode != 1073741824) {
            size = mode == Integer.MIN_VALUE ? Math.min(50, size) : 50;
        }
        this.e = size;
        return size;
    }

    private int b(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return size;
        }
        if (mode == Integer.MIN_VALUE) {
            return Math.min(80, size);
        }
        return 80;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!TextUtils.isEmpty(this.c)) {
            this.d.setColor(this.m);
            this.d.setTextSize(this.n);
            this.d.setStrokeWidth(1.0f);
            this.d.setStyle(Paint.Style.FILL);
            canvas.drawText(this.c, 0.0f, this.n, this.d);
        }
        this.d.setStrokeWidth(this.l);
        int i = 0;
        while (true) {
            int i2 = this.g;
            if (i >= i2) {
                return;
            }
            int i3 = this.b;
            if (i < i3) {
                if (i3 <= i2 / 3) {
                    this.d.setColor(this.h);
                } else if (i3 <= (i2 * 2) / 3) {
                    this.d.setColor(this.i);
                } else {
                    this.d.setColor(this.j);
                }
                this.d.setStyle(Paint.Style.FILL);
            } else {
                this.d.setColor(this.k);
                this.d.setStyle(Paint.Style.FILL);
            }
            int i4 = this.f;
            float f = (i4 * i) + this.a;
            int i5 = this.e;
            float f2 = (float) (((double) ((this.g - i) * i5)) * 0.2d);
            i++;
            canvas.drawRoundRect(new RectF(f, f2, i4 * i, i5), 5.0f, 5.0f, this.d);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(b(i), a(i2));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.e = getHeight();
        this.f = getWidth() / this.g;
    }

    public void setSignalTypeText(String str) {
        this.c = str;
    }

    public void setSignalValue(int i) {
        if (i > this.g) {
            new Throwable("setSignalValue method value error,can not exceed settings value!");
        }
        this.b = i;
        invalidate();
    }

    public SignalView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.SignalView);
        this.g = typedArrayObtainStyledAttributes.getInt(2, 7);
        this.a = typedArrayObtainStyledAttributes.getInt(6, 4);
        this.l = typedArrayObtainStyledAttributes.getInt(1, 1);
        this.k = typedArrayObtainStyledAttributes.getColor(0, getResources().getColor(R.color.black));
        this.h = typedArrayObtainStyledAttributes.getColor(4, getResources().getColor(R.color.black));
        this.i = typedArrayObtainStyledAttributes.getColor(5, getResources().getColor(R.color.black));
        this.j = typedArrayObtainStyledAttributes.getColor(3, getResources().getColor(R.color.black));
        this.m = typedArrayObtainStyledAttributes.getColor(7, getResources().getColor(R.color.black));
        this.n = typedArrayObtainStyledAttributes.getDimension(8, 14.0f);
        typedArrayObtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.d = paint;
        paint.setAntiAlias(true);
    }
}
