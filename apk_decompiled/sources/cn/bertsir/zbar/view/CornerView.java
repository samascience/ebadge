package cn.bertsir.zbar.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import cn.bertsir.zbar.R$color;
import cn.bertsir.zbar.R$styleable;

/* JADX INFO: loaded from: classes.dex */
public class CornerView extends View {
    private Paint a;
    private Canvas b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;

    public CornerView(Context context) {
        super(context, null);
        this.c = 0;
        this.d = 0;
    }

    public int a(int i) {
        return (int) (((double) (i * getContext().getResources().getDisplayMetrics().density)) + 0.5d);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i = this.g;
        if (i == 0) {
            canvas.drawLine(0.0f, 0.0f, this.c, 0.0f, this.a);
            canvas.drawLine(0.0f, 0.0f, 0.0f, this.d, this.a);
            return;
        }
        if (i == 1) {
            canvas.drawLine(0.0f, 0.0f, 0.0f, this.d, this.a);
            int i2 = this.d;
            canvas.drawLine(0.0f, i2, this.c, i2, this.a);
        } else if (i == 2) {
            canvas.drawLine(0.0f, 0.0f, this.c, 0.0f, this.a);
            int i3 = this.c;
            canvas.drawLine(i3, 0.0f, i3, this.d, this.a);
        } else {
            if (i != 3) {
                return;
            }
            int i4 = this.c;
            canvas.drawLine(i4, 0.0f, i4, this.d, this.a);
            int i5 = this.d;
            canvas.drawLine(0.0f, i5, this.c, i5, this.a);
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
        this.a.setColor(i);
        invalidate();
    }

    public void setLineWidth(int i) {
        int iA = a(i);
        this.f = iA;
        this.a.setStrokeWidth(iA);
        invalidate();
    }

    public CornerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = 0;
        this.d = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CornerView);
        this.e = typedArrayObtainStyledAttributes.getColor(R$styleable.CornerView_corner_color, getResources().getColor(R$color.common_color));
        this.f = (int) typedArrayObtainStyledAttributes.getDimension(R$styleable.CornerView_corner_width, 10.0f);
        this.g = typedArrayObtainStyledAttributes.getInt(R$styleable.CornerView_corner_gravity, 1);
        typedArrayObtainStyledAttributes.recycle();
        this.a = new Paint();
        this.b = new Canvas();
        this.a.setStyle(Paint.Style.FILL);
        this.a.setStrokeWidth(this.f);
        this.a.setColor(this.e);
        this.a.setAntiAlias(true);
    }
}
