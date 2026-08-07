package xfkj.fitpro.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.blankj.utilcode.util.d;
import com.tencent.connect.common.Constants;
import defpackage.ov;
import org.objectweb.asm.Opcodes;
import xfkj.fitpro.R$styleable;

/* JADX INFO: loaded from: classes4.dex */
public class PolygonView extends View {
    private Paint a;
    private int b;
    private int c;
    private int d;
    private boolean e;
    private int f;
    private boolean g;
    private Paint h;
    private int i;
    private float j;
    private String k;

    public PolygonView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(Canvas canvas) {
        int i = this.f;
        canvas.drawCircle(i, i, i, this.a);
    }

    private void b(Canvas canvas) {
        RectF rectF = new RectF();
        rectF.left = 0.0f;
        rectF.top = 0.0f;
        int i = this.f;
        rectF.right = i * 2;
        rectF.bottom = i * 2;
        canvas.drawRoundRect(rectF, 5.0f, 5.0f, this.a);
    }

    private void c(Canvas canvas) {
        if (this.g) {
            b(canvas);
        } else {
            a(canvas);
        }
    }

    private void d(Canvas canvas) {
        int[] iArrA = ov.a(this.h, this.k);
        String str = this.k;
        int i = this.f;
        canvas.drawText(str, i - (iArrA[0] / 2), i + ((iArrA[1] / 2) / 2), this.h);
    }

    private void e(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.PolygonView);
        if (typedArrayObtainStyledAttributes != null) {
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == 5) {
                    this.b = typedArrayObtainStyledAttributes.getInt(5, 10);
                } else if (index == 1) {
                    this.c = typedArrayObtainStyledAttributes.getColor(1, -1);
                } else if (index == 0) {
                    this.d = typedArrayObtainStyledAttributes.getColor(0, -1);
                } else if (index == 4) {
                    this.e = typedArrayObtainStyledAttributes.getBoolean(4, false);
                } else if (index == 3) {
                    this.f = typedArrayObtainStyledAttributes.getInteger(4, 50);
                } else if (index == 2) {
                    this.g = typedArrayObtainStyledAttributes.getBoolean(2, false);
                }
            }
        }
        Paint paint = new Paint();
        this.a = paint;
        paint.setColor(this.c);
        this.a.setAntiAlias(true);
        if (this.e) {
            this.a.setStyle(Paint.Style.STROKE);
        }
        this.a.setStrokeWidth(this.b);
        Paint paint2 = new Paint();
        this.h = paint2;
        paint2.setAntiAlias(true);
        this.h.setColor(this.i);
        this.h.setTextSize(this.j);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        c(canvas);
        d(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = this.f;
        setMeasuredDimension(i3 * 2, i3 * 2);
    }

    public void setBorderColor(int i) {
        this.d = i;
        invalidate();
    }

    public void setFillColor(int i) {
        this.c = i;
        this.a.setColor(i);
        invalidate();
    }

    public void setRadius(int i) {
        this.f = i;
        invalidate();
    }

    public void setRect(boolean z) {
        this.g = z;
        invalidate();
    }

    public void setShowStroke(boolean z) {
        this.e = z;
        invalidate();
    }

    public void setStrokeWidth(int i) {
        this.b = i;
        invalidate();
    }

    public void setTextColor(int i) {
        this.h.setColor(i);
        invalidate();
    }

    public void setTextContent(String str) {
        this.k = str;
        invalidate();
    }

    public void setTextSize(float f) {
        this.h.setTextSize(f);
        invalidate();
    }

    public PolygonView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = 20;
        this.c = Opcodes.V_PREVIEW;
        this.d = -1;
        this.e = false;
        this.f = 50;
        this.g = false;
        this.i = -16777216;
        this.j = d.g(12.0f);
        this.k = Constants.STR_EMPTY;
        e(context, attributeSet);
    }
}
