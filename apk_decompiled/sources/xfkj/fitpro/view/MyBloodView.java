package xfkj.fitpro.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.connect.common.Constants;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes4.dex */
public class MyBloodView extends View {
    private Paint a;
    private int b;
    private float c;
    private RectF d;
    private float e;
    private float f;
    private float g;
    Paint h;
    int i;
    private int[] j;
    private int[] k;
    private int l;
    private int m;
    private int n;
    private int o;
    private float[] p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private float[] f415q;
    private Paint r;
    private float s;
    private int t;
    int u;

    class a extends TimerTask {
        final /* synthetic */ Timer a;

        a(Timer timer) {
            this.a = timer;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            MyBloodView.this.s += 1.0f;
            if (MyBloodView.this.s == 100.0f) {
                this.a.cancel();
            }
            MyBloodView.this.postInvalidate();
        }
    }

    public MyBloodView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = 120.0f;
        this.f = 360.0f;
        this.g = 360.0f;
        this.i = 2;
        this.j = new int[]{2, 2, 4, 4, 6, 6, 8, 8, 10, 10, 12, 12};
        this.k = new int[]{12, 12, 10, 10, 8, 8, 6, 6, 4, 4, 2};
        this.l = 0;
        this.m = 0;
        this.u = 0;
        Paint paint = new Paint();
        this.a = paint;
        paint.setColor(-16777216);
        this.a.setAntiAlias(true);
        this.a.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint();
        this.h = paint2;
        paint2.setARGB(255, 255, 255, 255);
        this.h.setAntiAlias(true);
        Paint paint3 = new Paint();
        this.r = paint3;
        paint3.setAntiAlias(true);
        e();
    }

    private void c(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.parseColor("#619e96"));
        float f = this.c;
        canvas.drawArc(new RectF(45.0f, 45.0f, (f * 2.0f) - 45.0f, (f * 2.0f) - 45.0f), 0.0f, 360.0f, true, paint);
        d(canvas);
        this.h.setTextAlign(Paint.Align.CENTER);
        this.h.setTextSize(this.t / 3);
        this.h.setColor(Color.parseColor("#F76B1C"));
        this.h.setTypeface(Typeface.defaultFromStyle(1));
        String str = Constants.STR_EMPTY + this.n;
        float f2 = this.c;
        canvas.drawText(str, f2, f2, this.h);
        String str2 = Constants.STR_EMPTY + this.o;
        float f3 = this.c;
        canvas.drawText(str2, f3, (this.t / 2) + f3, this.h);
    }

    private void d(Canvas canvas) {
        float f = (float) (6.283185307179586d / ((double) this.b));
        int i = 0;
        for (int i2 = 0; i2 < this.b; i2++) {
            this.p[i2] = (float) ((Math.sin((i2 * f) + this.s) * 10.0d) - ((double) this.u));
        }
        for (int i3 = 0; i3 < this.b; i3++) {
            this.f415q[i3] = (float) ((Math.sin(((i3 * f) + this.s) + 10.0f) * 15.0d) - ((double) this.u));
        }
        canvas.save();
        Path path = new Path();
        path.reset();
        canvas.clipPath(path);
        int i4 = this.b;
        path.addCircle(i4 / 2, i4 / 2, this.t, Path.Direction.CCW);
        canvas.clipPath(path, Region.Op.REPLACE);
        canvas.translate(0.0f, (this.b / 2) + this.t);
        this.r.setColor(Color.parseColor("#aaaaaa"));
        int i5 = 0;
        while (true) {
            int i6 = this.b;
            if (i5 >= i6) {
                break;
            }
            float f2 = i5;
            canvas.drawLine(f2, this.p[i5], f2, i6, this.r);
            i5++;
        }
        this.r.setColor(-1);
        while (true) {
            int i7 = this.b;
            if (i >= i7) {
                canvas.restore();
                return;
            } else {
                float f3 = i;
                canvas.drawLine(f3, this.f415q[i], f3, i7, this.r);
                i++;
            }
        }
    }

    public void e() {
        Timer timer = new Timer();
        timer.schedule(new a(timer), 800L, 500L);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.a.setColor(Color.parseColor("#c9d0c0"));
        this.a.setStrokeWidth(80.0f);
        canvas.drawArc(this.d, this.e, this.f, false, this.a);
        c(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.b = Math.min(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        int i3 = this.b;
        this.d = new RectF(45.0f, 45.0f, i3 - 45, i3 - 45);
        int i4 = this.b;
        this.c = i4 / 2;
        this.t = (i4 / 2) - 45;
        this.p = new float[i4];
        this.f415q = new float[i4];
        setMeasuredDimension(i4, i4);
    }
}
