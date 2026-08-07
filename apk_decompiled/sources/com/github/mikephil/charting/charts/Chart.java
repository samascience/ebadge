package com.github.mikephil.charting.charts;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.tencent.connect.common.Constants;
import defpackage.hx;
import defpackage.hy0;
import defpackage.if1;
import defpackage.ix;
import defpackage.jx;
import defpackage.ky0;
import defpackage.o60;
import defpackage.o90;
import defpackage.qa1;
import defpackage.su1;
import defpackage.ta3;
import defpackage.ue3;
import defpackage.ww0;
import defpackage.wy0;
import defpackage.y80;
import java.util.ArrayList;
import java.util.Iterator;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes.dex */
public abstract class Chart<T extends ix> extends ViewGroup {
    protected ky0 F;
    protected ArrayList G;
    private boolean H;
    protected boolean a;
    protected boolean b;
    private boolean c;
    private float d;
    protected y80 e;
    protected Paint f;
    protected Paint g;
    protected XAxis h;
    protected boolean i;
    protected o90 j;
    protected Legend k;
    protected ChartTouchListener l;
    private String m;
    protected qa1 n;
    protected o60 o;
    protected hy0 p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    protected ue3 f234q;
    protected hx r;
    private float s;
    private float t;
    private float u;
    private float v;
    private boolean w;
    protected ww0[] x;
    protected float y;
    protected boolean z;

    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Chart.this.postInvalidate();
        }
    }

    static /* synthetic */ class b {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[Bitmap.CompressFormat.values().length];
            b = iArr;
            try {
                iArr[Bitmap.CompressFormat.PNG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[Bitmap.CompressFormat.WEBP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[Bitmap.CompressFormat.JPEG.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[Paint.Align.values().length];
            a = iArr2;
            try {
                iArr2[Paint.Align.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[Paint.Align.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public Chart(Context context) {
        super(context);
        this.a = false;
        this.b = true;
        this.c = true;
        this.d = 0.9f;
        this.e = new y80(0);
        this.i = true;
        this.m = "No chart data available.";
        this.f234q = new ue3();
        this.s = 0.0f;
        this.t = 0.0f;
        this.u = 0.0f;
        this.v = 0.0f;
        this.w = false;
        this.y = 0.0f;
        this.z = true;
        this.G = new ArrayList();
        this.H = false;
        e();
    }

    private void i(View view) {
        if (view.getBackground() != null) {
            view.getBackground().setCallback(null);
        }
        if (!(view instanceof ViewGroup)) {
            return;
        }
        int i = 0;
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i >= viewGroup.getChildCount()) {
                viewGroup.removeAllViews();
                return;
            } else {
                i(viewGroup.getChildAt(i));
                i++;
            }
        }
    }

    public void a() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    public void b() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
    }

    public ww0 c(float f, float f2) {
        Log.e("MPAndroidChart", "Can't select by touch. No data set.");
        return null;
    }

    public void d(ww0 ww0Var, boolean z) {
        this.x = null;
        setLastHighlighted(null);
        invalidate();
    }

    protected void e() {
        setWillNotDraw(false);
        this.r = new hx(new a());
        ta3.h(getContext());
        this.y = ta3.c(500.0f);
        this.j = new o90();
        Legend legend = new Legend();
        this.k = legend;
        this.n = new qa1(this.f234q, legend);
        this.h = new XAxis();
        this.f = new Paint(1);
        Paint paint = new Paint(1);
        this.g = paint;
        paint.setColor(Color.rgb(247, Opcodes.ANEWARRAY, 51));
        this.g.setTextAlign(Paint.Align.CENTER);
        this.g.setTextSize(ta3.c(12.0f));
        if (this.a) {
            Log.i(Constants.STR_EMPTY, "Chart.init()");
        }
    }

    public boolean f() {
        return this.c;
    }

    public boolean g() {
        return this.b;
    }

    public hx getAnimator() {
        return this.r;
    }

    public if1 getCenter() {
        return if1.b(getWidth() / 2.0f, getHeight() / 2.0f);
    }

    public if1 getCenterOfView() {
        return getCenter();
    }

    public if1 getCenterOffsets() {
        return this.f234q.n();
    }

    public Bitmap getChartBitmap() {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Drawable background = getBackground();
        if (background != null) {
            background.draw(canvas);
        } else {
            canvas.drawColor(-1);
        }
        draw(canvas);
        return bitmapCreateBitmap;
    }

    public RectF getContentRect() {
        return this.f234q.o();
    }

    public T getData() {
        return null;
    }

    public wy0 getDefaultValueFormatter() {
        return this.e;
    }

    public o90 getDescription() {
        return this.j;
    }

    public float getDragDecelerationFrictionCoef() {
        return this.d;
    }

    public float getExtraBottomOffset() {
        return this.u;
    }

    public float getExtraLeftOffset() {
        return this.v;
    }

    public float getExtraRightOffset() {
        return this.t;
    }

    public float getExtraTopOffset() {
        return this.s;
    }

    public ww0[] getHighlighted() {
        return this.x;
    }

    public hy0 getHighlighter() {
        return this.p;
    }

    public ArrayList<Runnable> getJobs() {
        return this.G;
    }

    public Legend getLegend() {
        return this.k;
    }

    public qa1 getLegendRenderer() {
        return this.n;
    }

    public ky0 getMarker() {
        return this.F;
    }

    @Deprecated
    public ky0 getMarkerView() {
        return getMarker();
    }

    public float getMaxHighlightDistance() {
        return this.y;
    }

    public abstract /* synthetic */ int getMaxVisibleCount();

    public com.github.mikephil.charting.listener.b getOnChartGestureListener() {
        return null;
    }

    public ChartTouchListener getOnTouchListener() {
        return this.l;
    }

    public o60 getRenderer() {
        return this.o;
    }

    public ue3 getViewPortHandler() {
        return this.f234q;
    }

    public XAxis getXAxis() {
        return this.h;
    }

    public float getXChartMax() {
        return this.h.F;
    }

    public float getXChartMin() {
        return this.h.G;
    }

    public float getXRange() {
        return this.h.H;
    }

    public abstract /* synthetic */ float getYChartMax();

    public abstract /* synthetic */ float getYChartMin();

    public float getYMax() {
        throw null;
    }

    public float getYMin() {
        throw null;
    }

    public abstract void h();

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.H) {
            i(this);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (TextUtils.isEmpty(this.m)) {
            return;
        }
        if1 center = getCenter();
        int i = b.a[this.g.getTextAlign().ordinal()];
        if (i == 1) {
            center.c = 0.0f;
            canvas.drawText(this.m, 0.0f, center.d, this.g);
        } else {
            if (i != 2) {
                canvas.drawText(this.m, center.c, center.d, this.g);
                return;
            }
            float f = (float) (((double) center.c) * 2.0d);
            center.c = f;
            canvas.drawText(this.m, f, center.d, this.g);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            getChildAt(i5).layout(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int iC = (int) ta3.c(50.0f);
        setMeasuredDimension(Math.max(getSuggestedMinimumWidth(), View.resolveSize(iC, i)), Math.max(getSuggestedMinimumHeight(), View.resolveSize(iC, i2)));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if (this.a) {
            Log.i("MPAndroidChart", "OnSizeChanged()");
        }
        if (i > 0 && i2 > 0 && i < 10000 && i2 < 10000) {
            if (this.a) {
                Log.i("MPAndroidChart", "Setting chart dimens, width: " + i + ", height: " + i2);
            }
            this.f234q.D(i, i2);
        } else if (this.a) {
            Log.w("MPAndroidChart", "*Avoiding* setting chart dimens! width: " + i + ", height: " + i2);
        }
        h();
        Iterator it = this.G.iterator();
        while (it.hasNext()) {
            post((Runnable) it.next());
        }
        this.G.clear();
        super.onSizeChanged(i, i2, i3, i4);
    }

    public void setData(T t) {
        this.w = false;
    }

    public void setDescription(o90 o90Var) {
        this.j = o90Var;
    }

    public void setDragDecelerationEnabled(boolean z) {
        this.c = z;
    }

    public void setDragDecelerationFrictionCoef(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f >= 1.0f) {
            f = 0.999f;
        }
        this.d = f;
    }

    @Deprecated
    public void setDrawMarkerViews(boolean z) {
        setDrawMarkers(z);
    }

    public void setDrawMarkers(boolean z) {
        this.z = z;
    }

    public void setExtraBottomOffset(float f) {
        this.u = ta3.c(f);
    }

    public void setExtraLeftOffset(float f) {
        this.v = ta3.c(f);
    }

    public void setExtraRightOffset(float f) {
        this.t = ta3.c(f);
    }

    public void setExtraTopOffset(float f) {
        this.s = ta3.c(f);
    }

    public void setHardwareAccelerationEnabled(boolean z) {
        if (z) {
            setLayerType(2, null);
        } else {
            setLayerType(1, null);
        }
    }

    public void setHighlightPerTapEnabled(boolean z) {
        this.b = z;
    }

    public void setHighlighter(jx jxVar) {
        this.p = jxVar;
    }

    protected void setLastHighlighted(ww0[] ww0VarArr) {
        if (ww0VarArr != null && ww0VarArr.length > 0) {
            ww0 ww0Var = ww0VarArr[0];
        }
        this.l.d(null);
    }

    public void setLogEnabled(boolean z) {
        this.a = z;
    }

    public void setMarker(ky0 ky0Var) {
        this.F = ky0Var;
    }

    @Deprecated
    public void setMarkerView(ky0 ky0Var) {
        setMarker(ky0Var);
    }

    public void setMaxHighlightDistance(float f) {
        this.y = ta3.c(f);
    }

    public void setNoDataText(String str) {
        this.m = str;
    }

    public void setNoDataTextAlignment(Paint.Align align) {
        this.g.setTextAlign(align);
    }

    public void setNoDataTextColor(int i) {
        this.g.setColor(i);
    }

    public void setNoDataTextTypeface(Typeface typeface) {
        this.g.setTypeface(typeface);
    }

    public void setOnChartGestureListener(com.github.mikephil.charting.listener.b bVar) {
    }

    public void setOnChartValueSelectedListener(su1 su1Var) {
    }

    public void setOnTouchListener(ChartTouchListener chartTouchListener) {
        this.l = chartTouchListener;
    }

    public void setRenderer(o60 o60Var) {
        if (o60Var != null) {
            this.o = o60Var;
        }
    }

    public void setTouchEnabled(boolean z) {
        this.i = z;
    }

    public void setUnbindEnabled(boolean z) {
        this.H = z;
    }

    public Chart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = false;
        this.b = true;
        this.c = true;
        this.d = 0.9f;
        this.e = new y80(0);
        this.i = true;
        this.m = "No chart data available.";
        this.f234q = new ue3();
        this.s = 0.0f;
        this.t = 0.0f;
        this.u = 0.0f;
        this.v = 0.0f;
        this.w = false;
        this.y = 0.0f;
        this.z = true;
        this.G = new ArrayList();
        this.H = false;
        e();
    }

    public Chart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = false;
        this.b = true;
        this.c = true;
        this.d = 0.9f;
        this.e = new y80(0);
        this.i = true;
        this.m = "No chart data available.";
        this.f234q = new ue3();
        this.s = 0.0f;
        this.t = 0.0f;
        this.u = 0.0f;
        this.v = 0.0f;
        this.w = false;
        this.y = 0.0f;
        this.z = true;
        this.G = new ArrayList();
        this.H = false;
        e();
    }
}
