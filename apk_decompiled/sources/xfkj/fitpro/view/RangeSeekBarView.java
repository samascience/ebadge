package xfkj.fitpro.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.legend.smartwatch.electronicbadge.android.R;
import com.seeker.luckychart.animation.ChartCoordinateportAnimator;
import defpackage.wa3;

/* JADX INFO: loaded from: classes4.dex */
public class RangeSeekBarView extends View {
    private static final int G = wa3.b(7.0f);
    private static final int H = wa3.b(10.0f);
    private int F;
    private int a;
    private long b;
    private double c;
    private double d;
    private double e;
    private double f;
    private double g;
    private double h;
    private Bitmap i;
    private Bitmap j;
    private Bitmap k;
    private Paint l;
    private Paint m;
    private final Paint n;
    private final Paint o;
    private final Paint p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f420q;
    private float r;
    private final float s;
    private long t;
    private long u;
    private float v;
    private boolean w;
    private double x;
    private boolean y;
    private a z;

    public enum Thumb {
        MIN,
        MAX
    }

    public interface a {
    }

    public RangeSeekBarView(Context context) {
        this(context, null);
    }

    private void a(float f, boolean z, Canvas canvas, boolean z2) {
        Bitmap bitmap;
        if (z) {
            bitmap = this.k;
        } else {
            bitmap = z2 ? this.i : this.j;
        }
        canvas.drawBitmap(bitmap, f - (z2 ? 0 : this.f420q), H, this.l);
    }

    private void b(Canvas canvas) {
        String strA = wa3.a(this.t);
        String strA2 = wa3.a(this.u);
        float height = getHeight() - wa3.b(5.0f);
        float fMeasureText = this.n.measureText(strA);
        float fMeasureText2 = this.o.measureText(strA2);
        float fD = d(this.e);
        float fD2 = d(this.f);
        if (fD + fMeasureText > getWidth()) {
            fD = (getWidth() - fMeasureText) - wa3.b(5.0f);
        }
        if (fD2 - fMeasureText2 < 0.0f) {
            fD2 = fMeasureText2 + wa3.b(5.0f);
        }
        canvas.drawText(strA, fD, height, this.n);
        canvas.drawText(strA2, fD2, height, this.o);
    }

    private void c() {
        Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.ic_video_thumb_handle);
        this.i = bitmapDecodeResource;
        int width = bitmapDecodeResource.getWidth();
        int height = this.i.getHeight();
        int iB = wa3.b(12.5f);
        float fB = (wa3.b(50.0f) * 1.0f) / height;
        Matrix matrix = new Matrix();
        matrix.postScale((iB * 1.0f) / width, fB);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(this.i, 0, 0, width, height, matrix, true);
        this.i = bitmapCreateBitmap;
        this.j = bitmapCreateBitmap;
        this.k = bitmapCreateBitmap;
        this.f420q = iB;
        this.r = iB / 2.0f;
        int color = getContext().getResources().getColor(R.color.shadow_color);
        this.p.setAntiAlias(true);
        this.p.setColor(color);
        this.l = new Paint(1);
        Paint paint = new Paint(1);
        this.m = paint;
        paint.setStyle(Paint.Style.FILL);
        this.m.setColor(this.F);
        this.n.setStrokeWidth(3.0f);
        this.n.setARGB(255, 51, 51, 51);
        this.n.setTextSize(28.0f);
        this.n.setAntiAlias(true);
        this.n.setColor(this.F);
        this.n.setTextAlign(Paint.Align.LEFT);
        this.o.setStrokeWidth(3.0f);
        this.o.setARGB(255, 51, 51, 51);
        this.o.setTextSize(28.0f);
        this.o.setAntiAlias(true);
        this.o.setColor(this.F);
        this.o.setTextAlign(Paint.Align.RIGHT);
    }

    private float d(double d) {
        return (float) (((double) getPaddingLeft()) + (d * ((double) ((getWidth() - getPaddingLeft()) - getPaddingRight()))));
    }

    private long e(double d) {
        double d2 = this.c;
        return (long) (d2 + (d * (this.d - d2)));
    }

    private double g(long j) {
        double d = this.d;
        double d2 = this.c;
        if (0.0d == d - d2) {
            return 0.0d;
        }
        return (j - d2) / (d - d2);
    }

    private int getValueLength() {
        return getWidth() - (this.f420q * 2);
    }

    public void f(long j, long j2) {
        this.t = j / 1000;
        this.u = j2 / 1000;
    }

    public long getSelectedMaxValue() {
        return e(this.h);
    }

    public long getSelectedMinValue() {
        return e(this.g);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float width = getWidth() - getPaddingRight();
        float fD = d(this.e);
        float fD2 = d(this.f);
        Rect rect = new Rect((int) 0.0f, getHeight(), (int) fD, 0);
        Rect rect2 = new Rect((int) fD2, getHeight(), (int) width, 0);
        canvas.drawRect(rect, this.p);
        canvas.drawRect(rect2, this.p);
        float f = this.r;
        float f2 = this.v;
        int i = H;
        canvas.drawRect(fD + f, f2 + i, fD2 - f, f2 + wa3.b(2.0f) + i, this.m);
        float height = (getHeight() - wa3.b(2.0f)) - wa3.b(20.0f);
        float height2 = getHeight() - wa3.b(20.0f);
        float f3 = this.r;
        canvas.drawRect(fD + f3, height, fD2 - f3, height2, this.m);
        a(d(this.e), false, canvas, true);
        a(d(this.f), false, canvas, false);
        b(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(View.MeasureSpec.getMode(i) != 0 ? View.MeasureSpec.getSize(i) : ChartCoordinateportAnimator.FAST_ANIMATION_DURATION, View.MeasureSpec.getMode(i2) != 0 ? View.MeasureSpec.getSize(i2) : 120);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        Bundle bundle = (Bundle) parcelable;
        super.onRestoreInstanceState(bundle.getParcelable("SUPER"));
        this.e = bundle.getDouble("MIN");
        this.f = bundle.getDouble("MAX");
        this.g = bundle.getDouble("MIN_TIME");
        this.h = bundle.getDouble("MAX_TIME");
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("SUPER", super.onSaveInstanceState());
        bundle.putDouble("MIN", this.e);
        bundle.putDouble("MAX", this.f);
        bundle.putDouble("MIN_TIME", this.g);
        bundle.putDouble("MAX_TIME", this.h);
        return bundle;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public void setMaxCaptureDurationSeconds(int i) {
        if (i <= 0) {
            i = 5;
        }
        this.d = ((long) i) * 1000;
        this.f = 1.0d;
        this.h = 1.0d;
        invalidate();
    }

    public void setMinShootTime(long j) {
        this.b = j;
    }

    public void setNormalizedMaxValue(double d) {
        this.f = Math.max(0.0d, Math.min(1.0d, Math.max(d, this.e)));
        invalidate();
    }

    public void setNormalizedMinValue(double d) {
        this.e = Math.max(0.0d, Math.min(1.0d, Math.min(d, this.f)));
        invalidate();
    }

    public void setNotifyWhileDragging(boolean z) {
        this.y = z;
    }

    public void setOnRangeSeekBarChangeListener(a aVar) {
        this.z = aVar;
    }

    public void setSelectedMaxValue(long j) {
        if (0.0d == this.d - this.c) {
            setNormalizedMaxValue(1.0d);
        } else {
            setNormalizedMaxValue(g(j));
        }
    }

    public void setSelectedMinValue(long j) {
        if (0.0d == this.d - this.c) {
            setNormalizedMinValue(0.0d);
        } else {
            setNormalizedMinValue(g(j));
        }
    }

    public void setTouchDown(boolean z) {
        this.w = z;
    }

    public RangeSeekBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RangeSeekBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 255;
        this.b = 5000L;
        this.e = 0.0d;
        this.f = 1.0d;
        this.g = 0.0d;
        this.h = 1.0d;
        this.n = new Paint();
        this.o = new Paint();
        this.p = new Paint();
        this.s = 0.0f;
        this.t = 0L;
        this.u = 0L;
        this.v = 0.0f;
        this.x = 1.0d;
        this.y = false;
        this.F = getContext().getResources().getColor(R.color.white);
        this.c = 0.0d;
        this.d = 5000.0d;
        setFocusable(true);
        setFocusableInTouchMode(true);
        c();
    }
}
