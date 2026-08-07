package xfkj.fitpro.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.blankj.utilcode.util.ImageUtils;
import com.blankj.utilcode.util.d;
import com.legend.smartwatch.electronicbadge.android.R;

/* JADX INFO: loaded from: classes4.dex */
public class WaterProgress extends View {
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
    private Canvas f423q;
    private int r;
    private int s;
    private Bitmap t;

    public WaterProgress(Context context) {
        super(context);
        this.h = 2;
        this.n = 2000;
        e();
    }

    private int c(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private void d(Canvas canvas) {
        this.t = Bitmap.createBitmap(this.p.getWidth(), this.p.getHeight(), Bitmap.Config.ARGB_8888);
        this.f423q = new Canvas(this.t);
        Paint paint = new Paint();
        paint.setStrokeWidth(20.0f);
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        paint.setColor(Color.parseColor("#e1edfc"));
        paint.setAntiAlias(true);
        int iC = d.c(10.0f);
        int iC2 = d.c(11.0f) + iC;
        int strokeWidth = (int) paint.getStrokeWidth();
        int strokeWidth2 = (int) paint.getStrokeWidth();
        int width = this.t.getWidth();
        int height = this.t.getHeight();
        int[] iArr = {iC, 0};
        int[] iArr2 = {width - iC, 0};
        int[] iArr3 = {width - iC2, height};
        int[] iArr4 = {iC2, height};
        Path path = new Path();
        path.moveTo(iArr[0], iArr[1] + strokeWidth);
        path.lineTo(iArr4[0], iArr4[1] - strokeWidth2);
        path.lineTo(iArr3[0], iArr3[1] - strokeWidth2);
        path.lineTo(iArr2[0], iArr2[1] + strokeWidth);
        canvas.drawPath(path, paint);
        this.f423q.drawPath(path, this.b);
        this.f423q.drawPath(j(), this.a);
        canvas.drawBitmap(this.t, 0.0f, 0.0f, (Paint) null);
        Paint paint2 = new Paint();
        paint2.setColor(-1);
        paint2.setStyle(style);
        paint2.setStrokeWidth(15.0f);
        paint2.setStrokeCap(Paint.Cap.ROUND);
        int i = width / 8;
        int i2 = height / 3;
        int[] iArr5 = {iArr[0] + i, iArr[1] + i2};
        int[] iArr6 = {(iArr4[0] + i) - 20, iArr4[1] - i2};
        canvas.drawLine(iArr5[0], iArr5[1], iArr6[0], iArr6[1], paint2);
    }

    private void e() {
        this.p = ImageUtils.a(R.mipmap.ysjl_biz);
        Paint paint = new Paint();
        this.a = paint;
        paint.setColor(Color.parseColor("#FFB6D7F8"));
        this.a.setStyle(Paint.Style.FILL);
        this.a.setAntiAlias(true);
        this.a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        Paint paint2 = new Paint();
        this.b = paint2;
        paint2.setAntiAlias(true);
        this.b.setColor(Color.parseColor("#f8fcff"));
        Paint paint3 = new Paint();
        this.c = paint3;
        paint3.setAntiAlias(true);
        this.c.setColor(getResources().getColor(R.color.gray));
        this.c.setStyle(Paint.Style.STROKE);
        int iC = c(getContext(), 12.0f);
        this.r = iC;
        this.c.setStrokeWidth(iC);
        Paint paint4 = new Paint();
        this.d = paint4;
        paint4.setColor(getResources().getColor(R.color.white));
        this.d.setAntiAlias(true);
        this.e = new Path();
        h(634, 1024);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(ValueAnimator valueAnimator) {
        int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.i = iIntValue;
        this.k = iIntValue / this.j;
        postInvalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(ValueAnimator valueAnimator) {
        if (this.k > 0.0f) {
            int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            this.l = iIntValue;
            this.o = (iIntValue / 100.0f) * this.m;
            postInvalidate();
        }
    }

    private void i() {
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(100, 0);
        valueAnimatorOfInt.setDuration(2000L);
        valueAnimatorOfInt.setInterpolator(new LinearInterpolator());
        valueAnimatorOfInt.setRepeatCount(-1);
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: oh3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.a.g(valueAnimator);
            }
        });
        valueAnimatorOfInt.start();
    }

    private Path j() {
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

    public void h(int i, int i2) {
        this.j = i2;
        setProgressAnim(i);
        i();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        d(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int width = this.p.getWidth();
        int height = this.p.getHeight();
        this.f = width / 2;
        this.g = c(getContext(), 15.0f);
        this.m = height;
        this.o = width - 50;
        setMeasuredDimension(height, height);
    }

    public void setNum(int i) {
        this.s = i;
    }

    public void setProgressAnim(int i) {
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, i);
        valueAnimatorOfInt.setDuration(2000L);
        valueAnimatorOfInt.setInterpolator(new DecelerateInterpolator());
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: nh3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.a.f(valueAnimator);
            }
        });
        valueAnimatorOfInt.start();
    }

    public WaterProgress(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.h = 2;
        this.n = 2000;
        e();
    }
}
