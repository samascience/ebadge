package xfkj.fitpro.view;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.legend.smartwatch.electronicbadge.android.R;

/* JADX INFO: loaded from: classes4.dex */
public class WaveProgressView extends View {
    private Paint a;
    private Paint b;
    private Paint c;
    private Paint d;
    private Path e;
    private int f;
    private float g;
    private final int h;
    private int i;
    private int j;
    private float k;
    private int l;
    private int m;
    private final int n;
    private float o;
    private Bitmap p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Canvas f424q;
    private int r;
    private int s;

    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            WaveProgressView.this.i = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            WaveProgressView waveProgressView = WaveProgressView.this;
            waveProgressView.k = waveProgressView.i / WaveProgressView.this.j;
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            WaveProgressView.this.l = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            WaveProgressView waveProgressView = WaveProgressView.this;
            waveProgressView.o = (waveProgressView.l / 100.0f) * WaveProgressView.this.m;
            WaveProgressView.this.postInvalidate();
        }
    }

    class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            WaveProgressView.this.postInvalidate();
        }
    }

    public WaveProgressView(Context context) {
        super(context);
        this.h = 2;
        this.n = 2000;
        l();
    }

    private int i(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private void j(Canvas canvas) {
        int i = this.m;
        this.p = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
        Canvas canvas2 = new Canvas(this.p);
        this.f424q = canvas2;
        int i2 = this.m;
        canvas2.drawCircle(i2 / 2, i2 / 2, (i2 / 2) - this.r, this.b);
        this.f424q.drawPath(p(), this.a);
        canvas.drawBitmap(this.p, 0.0f, 0.0f, (Paint) null);
    }

    private void k(Canvas canvas) {
        Rect rect = new Rect();
        this.d.setTextSize(160.0f);
        String str = this.s + "M";
        this.d.getTextBounds(str, 0, str.length(), rect);
        int iHeight = rect.height();
        canvas.drawText(str, (getWidth() / 2) - (rect.width() / 2), (getHeight() / 2) + (iHeight / 2), this.d);
        this.d.setTextSize(60.0f);
        this.d.getTextBounds("剩余流量", 0, 4, rect);
        canvas.drawText("剩余流量", (getWidth() / 2) - (rect.width() / 2), (getHeight() / 2) - iHeight, this.d);
        this.d.setTextSize(55.0f);
        String str2 = "共" + (this.j / 1024.0f) + "GB";
        this.d.getTextBounds(str2, 0, str2.length(), rect);
        canvas.drawText(str2, (getWidth() / 2) - (rect.width() / 2), (getHeight() / 2) + iHeight + i(getContext(), 25.0f), this.d);
    }

    private void l() {
        Paint paint = new Paint();
        this.a = paint;
        paint.setColor(getResources().getColor(R.color.red));
        this.a.setStyle(Paint.Style.FILL);
        this.a.setAntiAlias(true);
        this.a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        Paint paint2 = new Paint();
        this.b = paint2;
        paint2.setAntiAlias(true);
        this.b.setColor(getResources().getColor(R.color.black));
        Paint paint3 = new Paint();
        this.c = paint3;
        paint3.setAntiAlias(true);
        this.c.setColor(getResources().getColor(R.color.gray));
        this.c.setStyle(Paint.Style.STROKE);
        int i = i(getContext(), 12.0f);
        this.r = i;
        this.c.setStrokeWidth(i);
        Paint paint4 = new Paint();
        this.d = paint4;
        paint4.setColor(getResources().getColor(R.color.white));
        this.d.setAntiAlias(true);
        this.e = new Path();
        n(634, 1024);
    }

    private void o() {
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(100, 0);
        valueAnimatorOfInt.setDuration(2000L);
        valueAnimatorOfInt.setInterpolator(new LinearInterpolator());
        valueAnimatorOfInt.setRepeatCount(-1);
        valueAnimatorOfInt.addUpdateListener(new b());
        valueAnimatorOfInt.start();
    }

    private Path p() {
        this.e.reset();
        this.e.moveTo(-this.o, this.m * (1.0f - this.k));
        for (int i = 0; i < 4; i++) {
            Path path = this.e;
            int i2 = this.f;
            path.rQuadTo(i2 / 2, this.g, i2, 0.0f);
            Path path2 = this.e;
            int i3 = this.f;
            path2.rQuadTo(i3 / 2, -this.g, i3, 0.0f);
        }
        Path path3 = this.e;
        int i4 = this.m;
        path3.lineTo(i4, i4);
        this.e.lineTo(0.0f, this.m);
        this.e.close();
        return this.e;
    }

    public int getNum() {
        return this.s;
    }

    public void m(int i) {
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this, "num", 0, i);
        objectAnimatorOfInt.setDuration(1000L);
        objectAnimatorOfInt.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimatorOfInt.start();
        objectAnimatorOfInt.addUpdateListener(new c());
    }

    public void n(int i, int i2) {
        this.j = i2;
        setProgressAnim(i);
        o();
        m(i);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        j(canvas);
        int i = this.r;
        int i2 = this.m;
        canvas.drawArc(new RectF(i / 2, i / 2, i2 - (i / 2), i2 - (i / 2)), 0.0f, 360.0f, false, this.c);
        k(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f = getMeasuredWidth() / 2;
        this.g = i(getContext(), 18.0f);
        int measuredWidth = getMeasuredWidth();
        this.m = measuredWidth;
        this.o = measuredWidth;
        setMeasuredDimension(measuredWidth, measuredWidth);
    }

    public void setNum(int i) {
        this.s = i;
    }

    public void setProgressAnim(int i) {
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, i);
        valueAnimatorOfInt.setDuration(2000L);
        valueAnimatorOfInt.setInterpolator(new DecelerateInterpolator());
        valueAnimatorOfInt.addUpdateListener(new a());
        valueAnimatorOfInt.start();
    }

    public WaveProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.h = 2;
        this.n = 2000;
        l();
    }
}
