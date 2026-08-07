package xfkj.fitpro.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.View;
import com.jieli.jl_rcsp.constant.Command;
import com.tencent.connect.common.Constants;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes4.dex */
public class MyView extends View {
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
    private float[] o;
    private float[] p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Paint f418q;
    private float r;
    private int s;
    int t;
    float u;

    class a extends TimerTask {
        final /* synthetic */ Timer a;

        a(Timer timer) {
            this.a = timer;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            MyView.this.r += 1.0f;
            if (MyView.this.r == 100.0f) {
                this.a.cancel();
            }
            MyView.this.postInvalidate();
        }
    }

    public interface b {
    }

    public MyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = 120.0f;
        this.f = 360.0f;
        this.g = 360.0f;
        this.i = 2;
        this.j = new int[]{2, 2, 4, 4, 6, 6, 8, 8, 10};
        this.k = new int[]{10, 10, 8, 8, 6, 6, 4, 4, 2};
        this.l = 0;
        this.m = 0;
        this.t = 0;
        this.u = 360.0f / 100.0f;
        Paint paint = new Paint();
        this.a = paint;
        paint.setColor(-1);
        this.a.setAntiAlias(true);
        this.a.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint();
        this.h = paint2;
        paint2.setARGB(255, 255, 255, 255);
        this.h.setAntiAlias(true);
        Paint paint3 = new Paint();
        this.f418q = paint3;
        paint3.setAntiAlias(true);
        e();
    }

    private void c(Canvas canvas) {
        Paint paint = new Paint();
        paint.setAlpha(50);
        paint.setARGB(50, 236, Command.CMD_PHONE_NUMBER_PLAY_MODE, 243);
        float f = this.c;
        RectF rectF = new RectF(40.0f, 40.0f, (f * 2.0f) - 40.0f, (f * 2.0f) - 40.0f);
        d(canvas);
        canvas.drawArc(rectF, 0.0f, 360.0f, true, paint);
        canvas.drawArc(rectF, 0.0f, 360.0f, false, this.a);
        this.h.setTextAlign(Paint.Align.CENTER);
        this.h.setTextSize(this.s / 2);
        String str = Constants.STR_EMPTY + this.n;
        float f2 = this.c;
        canvas.drawText(str, f2, f2, this.h);
        this.h.setTextSize(this.s / 6);
        this.h.setTextSize(this.s / 6);
        float f3 = this.c;
        canvas.drawText("80", f3, (this.s / 2) + f3, this.h);
    }

    private void d(Canvas canvas) {
        float f = (float) (6.283185307179586d / ((double) this.b));
        int i = 0;
        for (int i2 = 0; i2 < this.b; i2++) {
            this.o[i2] = (float) ((Math.sin((i2 * f) + this.r) * 10.0d) - ((double) this.t));
        }
        for (int i3 = 0; i3 < this.b; i3++) {
            this.p[i3] = (float) ((Math.sin(((i3 * f) + this.r) + 10.0f) * 15.0d) - ((double) this.t));
        }
        canvas.save();
        Path path = new Path();
        this.f418q.setColor(-1);
        path.reset();
        canvas.clipPath(path);
        int i4 = this.b;
        path.addCircle(i4 / 2, i4 / 2, this.s, Path.Direction.CCW);
        canvas.clipPath(path, Region.Op.REPLACE);
        canvas.translate(0.0f, (this.b / 2) + this.s);
        int i5 = 0;
        while (true) {
            int i6 = this.b;
            if (i5 >= i6) {
                break;
            }
            float f2 = i5;
            canvas.drawLine(f2, this.o[i5], f2, i6, this.f418q);
            i5++;
        }
        while (true) {
            int i7 = this.b;
            if (i >= i7) {
                canvas.restore();
                return;
            } else {
                float f3 = i;
                canvas.drawLine(f3, this.p[i], f3, i7, this.f418q);
                i++;
            }
        }
    }

    public void e() {
        Timer timer = new Timer();
        timer.schedule(new a(timer), 500L, 200L);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.d, this.e, this.f, false, this.a);
        c(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.b = Math.min(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        int i3 = this.b;
        this.d = new RectF(0.0f, 0.0f, i3, i3);
        int i4 = this.b;
        this.c = i4 / 2;
        this.s = (i4 / 2) - 45;
        this.o = new float[i4];
        this.p = new float[i4];
        setMeasuredDimension(i4, i4);
    }

    public void setOnAngleColorListener(b bVar) {
    }
}
