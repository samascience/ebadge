package xfkj.fitpro.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.connect.common.Constants;
import defpackage.kr2;
import org.objectweb.asm.Opcodes;
import xfkj.fitpro.R$styleable;

/* JADX INFO: loaded from: classes4.dex */
public class QQSportView extends View {
    private Context a;
    private int b;
    private int c;
    private float d;
    private int e;
    private float f;
    private Paint g;
    private Paint h;
    private Paint i;
    private Paint j;
    private int k;
    private int l;

    public QQSportView(Context context) {
        this(context, null);
    }

    private void a() {
        Paint paint = new Paint();
        this.g = paint;
        paint.setAntiAlias(true);
        this.g.setStrokeWidth(this.d);
        this.g.setColor(this.b);
        Paint paint2 = this.g;
        Paint.Style style = Paint.Style.STROKE;
        paint2.setStyle(style);
        Paint paint3 = this.g;
        Paint.Cap cap = Paint.Cap.ROUND;
        paint3.setStrokeCap(cap);
        Paint paint4 = new Paint();
        this.h = paint4;
        paint4.setAntiAlias(true);
        this.h.setStrokeWidth(this.d);
        this.h.setColor(this.c);
        this.h.setStyle(style);
        this.h.setStrokeCap(cap);
        Paint paint5 = new Paint();
        this.i = paint5;
        paint5.setAntiAlias(true);
        this.i.setColor(-7829368);
        this.i.setStyle(style);
        this.i.setTextSize(kr2.a(16.0f));
        Paint paint6 = new Paint();
        this.j = paint6;
        paint6.setAntiAlias(true);
        this.j.setColor(this.e);
        this.j.setStyle(style);
        this.j.setTextSize(this.f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f = this.d;
        RectF rectF = new RectF(f / 2.0f, f / 2.0f, getWidth() - (this.d / 2.0f), getHeight() - (this.d / 2.0f));
        canvas.drawArc(rectF, 135.0f, 270.0f, false, this.g);
        int i = this.k;
        if (i <= 0) {
            return;
        }
        canvas.drawArc(rectF, 135.0f, (this.l / i) * 270.0f, false, this.h);
        Rect rect = new Rect();
        this.i.getTextBounds("今日步数", 0, 4, rect);
        int width = (getWidth() / 2) - (rect.width() / 2);
        Paint.FontMetricsInt fontMetricsInt = this.i.getFontMetricsInt();
        int i2 = fontMetricsInt.bottom;
        canvas.drawText("今日步数", width, (getHeight() / 3) + (((i2 - fontMetricsInt.top) / 2) - i2), this.i);
        String str = this.l + Constants.STR_EMPTY;
        Rect rect2 = new Rect();
        this.j.getTextBounds(str, 0, str.length(), rect2);
        int width2 = (getWidth() / 2) - (rect2.width() / 2);
        Paint.FontMetricsInt fontMetricsInt2 = this.j.getFontMetricsInt();
        int i3 = fontMetricsInt2.bottom;
        canvas.drawText(str, width2, (int) ((((double) getHeight()) / 1.5d) + ((double) (((i3 - fontMetricsInt2.top) / 2) - i3))), this.j);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i) > View.MeasureSpec.getSize(i2) ? View.MeasureSpec.getSize(i2) : View.MeasureSpec.getSize(i);
        setMeasuredDimension(size, size);
    }

    public void setCurrent(int i) {
        this.l = i;
        invalidate();
    }

    public void setInPaintColor(int i) {
        this.c = i;
        a();
        invalidate();
    }

    public void setMaxNum(int i) {
        this.k = i;
    }

    public void setOutPaintColor(int i) {
        this.b = i;
        a();
        invalidate();
    }

    public void setWidth(int i) {
        this.d = i;
        a();
        invalidate();
    }

    public QQSportView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QQSportView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = -16776961;
        this.c = Opcodes.V_PREVIEW;
        this.e = Opcodes.V_PREVIEW;
        this.k = 10000;
        this.l = 0;
        this.a = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.QQSportView);
        this.b = typedArrayObtainStyledAttributes.getColor(2, this.b);
        this.c = typedArrayObtainStyledAttributes.getColor(1, this.c);
        this.d = typedArrayObtainStyledAttributes.getDimension(0, kr2.a(10.0f));
        this.e = typedArrayObtainStyledAttributes.getColor(3, this.e);
        this.f = typedArrayObtainStyledAttributes.getDimension(4, kr2.a(40.0f));
        typedArrayObtainStyledAttributes.recycle();
        a();
    }
}
