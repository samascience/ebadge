package xfkj.fitpro.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.legend.smartwatch.electronicbadge.android.R;
import defpackage.nc0;
import defpackage.u73;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes4.dex */
public class SportsCircleProgressBars extends View {
    private Paint a;
    private Paint b;
    private float c;
    private float d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    float j;
    private int[] k;
    private int[] l;

    public SportsCircleProgressBars(Context context) {
        super(context);
        this.e = -90;
        this.i = 100;
        this.j = 10.0f;
        this.k = new int[]{u73.a(R.color.sports_pb_bg_color1), u73.a(R.color.sports_pb_bg_color3), u73.a(R.color.sports_pb_bg_color2)};
        this.l = new int[]{u73.a(R.color.sports_pb_progress_color1), u73.a(R.color.sports_pb_progress_color3), u73.a(R.color.sports_pb_progress_color2)};
        b(context, null);
    }

    private float a(int i, int i2) {
        return (i2 * 1.0f) / i;
    }

    private void b(Context context, AttributeSet attributeSet) {
        float fA = nc0.a(2.0f, getContext());
        Paint paint = new Paint();
        this.a = paint;
        paint.setColor(Opcodes.V_PREVIEW);
        Paint paint2 = this.a;
        Paint.Style style = Paint.Style.STROKE;
        paint2.setStyle(style);
        this.a.setAntiAlias(true);
        this.a.setStrokeWidth(fA);
        Paint paint3 = new Paint();
        this.b = paint3;
        paint3.setColor(-16776961);
        this.b.setStyle(style);
        this.b.setAntiAlias(true);
        this.b.setStrokeCap(Paint.Cap.ROUND);
        this.b.setStrokeWidth(fA);
    }

    private int c(int i, int i2) {
        if (i == 1073741824) {
            return i2;
        }
        if (i == Integer.MIN_VALUE) {
            return Math.min(i2, 200);
        }
        return 0;
    }

    private float getRatio1() {
        return (this.f / (this.i * 1.0f)) * 360.0f;
    }

    private float getRatio2() {
        return (this.g / (this.i * 1.0f)) * 360.0f;
    }

    private float getRatio3() {
        return (this.h / (this.i * 1.0f)) * 360.0f;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float strokeWidth = this.a.getStrokeWidth() / 2.0f;
        float width = getWidth() - strokeWidth;
        float width2 = (getWidth() / 2.0f) - strokeWidth;
        this.a.setColor(this.k[2]);
        this.b.setColor(this.l[2]);
        RectF rectF = new RectF(strokeWidth, strokeWidth, width, width);
        float f = -174;
        float f2 = Opcodes.JSR;
        canvas.drawArc(rectF, f, f2, false, this.a);
        canvas.drawArc(rectF, f, f2 * a(this.i, this.f), false, this.b);
        this.a.setColor(this.k[1]);
        this.b.setColor(this.l[1]);
        float f3 = Opcodes.FRETURN;
        canvas.drawArc(rectF, f3, -168, false, this.a);
        canvas.drawArc(rectF, f3, -(f2 * a(this.i, this.g)), false, this.b);
        float f4 = this.j;
        float f5 = strokeWidth + f4;
        float f6 = width - f4;
        this.a.setColor(this.k[0]);
        this.b.setColor(this.l[0]);
        canvas.drawCircle(this.c, this.d, width2 - f4, this.a);
        canvas.drawArc(new RectF(f5, f5, f6, f6), this.e, getRatio3(), false, this.b);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int iMin = Math.min(c(View.MeasureSpec.getMode(i), View.MeasureSpec.getSize(i)), c(View.MeasureSpec.getMode(i2), View.MeasureSpec.getSize(i2)));
        setMeasuredDimension(iMin, iMin);
        float f = iMin / 2.0f;
        this.c = f;
        this.d = f;
    }

    public void setProgress1(int i) {
        this.f = i;
        invalidate();
    }

    public void setProgress2(int i) {
        this.g = i;
        invalidate();
    }

    public void setProgress3(int i) {
        this.h = i;
        invalidate();
    }

    public SportsCircleProgressBars(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = -90;
        this.i = 100;
        this.j = 10.0f;
        this.k = new int[]{u73.a(R.color.sports_pb_bg_color1), u73.a(R.color.sports_pb_bg_color3), u73.a(R.color.sports_pb_bg_color2)};
        this.l = new int[]{u73.a(R.color.sports_pb_progress_color1), u73.a(R.color.sports_pb_progress_color3), u73.a(R.color.sports_pb_progress_color2)};
        b(context, attributeSet);
    }

    public SportsCircleProgressBars(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = -90;
        this.i = 100;
        this.j = 10.0f;
        this.k = new int[]{u73.a(R.color.sports_pb_bg_color1), u73.a(R.color.sports_pb_bg_color3), u73.a(R.color.sports_pb_bg_color2)};
        this.l = new int[]{u73.a(R.color.sports_pb_progress_color1), u73.a(R.color.sports_pb_progress_color3), u73.a(R.color.sports_pb_progress_color2)};
    }
}
