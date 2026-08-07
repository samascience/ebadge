package com.github.mikephil.charting.charts;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.listener.ChartTouchListener;
import defpackage.by0;
import defpackage.c53;
import defpackage.hf1;
import defpackage.jx;
import defpackage.ll3;
import defpackage.ql3;
import defpackage.ta3;
import defpackage.ue3;
import defpackage.uf;
import defpackage.vf;
import defpackage.zu1;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"RtlHardcoded"})
public abstract class BarLineChartBase<T extends uf> extends Chart<T> implements vf {
    protected int I;
    protected boolean J;
    protected boolean K;
    protected boolean L;
    protected boolean M;
    private boolean N;
    private boolean O;
    private boolean P;
    private boolean Q;
    protected Paint R;
    protected Paint S;
    protected boolean T;
    protected boolean U;
    protected boolean V;
    protected boolean W;
    protected float a0;
    protected boolean b0;
    protected YAxis c0;
    protected YAxis d0;
    protected ql3 e0;
    protected ql3 f0;
    protected c53 g0;
    protected c53 h0;
    protected ll3 i0;
    private long j0;
    private long k0;
    private RectF l0;
    protected Matrix m0;
    protected Matrix n0;
    private boolean o0;
    protected float[] p0;
    protected hf1 q0;
    protected hf1 r0;
    protected float[] s0;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;
        static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[Legend.LegendOrientation.values().length];
            c = iArr;
            try {
                iArr[Legend.LegendOrientation.VERTICAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                c[Legend.LegendOrientation.HORIZONTAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[Legend.LegendHorizontalAlignment.values().length];
            b = iArr2;
            try {
                iArr2[Legend.LegendHorizontalAlignment.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[Legend.LegendHorizontalAlignment.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[Legend.LegendHorizontalAlignment.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr3 = new int[Legend.LegendVerticalAlignment.values().length];
            a = iArr3;
            try {
                iArr3[Legend.LegendVerticalAlignment.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[Legend.LegendVerticalAlignment.BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public BarLineChartBase(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.I = 100;
        this.J = false;
        this.K = false;
        this.L = true;
        this.M = true;
        this.N = true;
        this.O = true;
        this.P = true;
        this.Q = true;
        this.T = false;
        this.U = false;
        this.V = false;
        this.W = true;
        this.a0 = 15.0f;
        this.b0 = false;
        this.j0 = 0L;
        this.k0 = 0L;
        this.l0 = new RectF();
        this.m0 = new Matrix();
        this.n0 = new Matrix();
        this.o0 = false;
        this.p0 = new float[2];
        this.q0 = hf1.b(0.0d, 0.0d);
        this.r0 = hf1.b(0.0d, 0.0d);
        this.s0 = new float[2];
    }

    @Override // android.view.View
    public void computeScroll() {
        ChartTouchListener chartTouchListener = this.l;
        if (chartTouchListener instanceof com.github.mikephil.charting.listener.a) {
            ((com.github.mikephil.charting.listener.a) chartTouchListener).f();
        }
    }

    @Override // com.github.mikephil.charting.charts.Chart
    protected void e() {
        super.e();
        this.c0 = new YAxis(YAxis.AxisDependency.LEFT);
        this.d0 = new YAxis(YAxis.AxisDependency.RIGHT);
        this.g0 = new c53(this.f234q);
        this.h0 = new c53(this.f234q);
        this.e0 = new ql3(this.f234q, this.c0, this.g0);
        this.f0 = new ql3(this.f234q, this.d0, this.h0);
        this.i0 = new ll3(this.f234q, this.h, this.g0);
        setHighlighter(new jx(this));
        this.l = new com.github.mikephil.charting.listener.a(this, this.f234q.p(), 3.0f);
        Paint paint = new Paint();
        this.R = paint;
        paint.setStyle(Paint.Style.FILL);
        this.R.setColor(Color.rgb(240, 240, 240));
        Paint paint2 = new Paint();
        this.S = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.S.setColor(-16777216);
        this.S.setStrokeWidth(ta3.c(1.0f));
    }

    public YAxis getAxisLeft() {
        return this.c0;
    }

    public YAxis getAxisRight() {
        return this.d0;
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public /* bridge */ /* synthetic */ uf getData() {
        super.getData();
        return null;
    }

    public zu1 getDrawListener() {
        return null;
    }

    public float getHighestVisibleX() {
        m(YAxis.AxisDependency.LEFT).a(this.f234q.i(), this.f234q.f(), this.r0);
        return (float) Math.min(this.h.F, this.r0.c);
    }

    public float getLowestVisibleX() {
        m(YAxis.AxisDependency.LEFT).a(this.f234q.h(), this.f234q.f(), this.q0);
        return (float) Math.max(this.h.G, this.q0.c);
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public int getMaxVisibleCount() {
        return this.I;
    }

    public float getMinOffset() {
        return this.a0;
    }

    public ql3 getRendererLeftYAxis() {
        return this.e0;
    }

    public ql3 getRendererRightYAxis() {
        return this.f0;
    }

    public ll3 getRendererXAxis() {
        return this.i0;
    }

    @Override // android.view.View
    public float getScaleX() {
        ue3 ue3Var = this.f234q;
        if (ue3Var == null) {
            return 1.0f;
        }
        return ue3Var.q();
    }

    @Override // android.view.View
    public float getScaleY() {
        ue3 ue3Var = this.f234q;
        if (ue3Var == null) {
            return 1.0f;
        }
        return ue3Var.r();
    }

    public float getVisibleXRange() {
        return Math.abs(getHighestVisibleX() - getLowestVisibleX());
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public float getYChartMax() {
        return Math.max(this.c0.F, this.d0.F);
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public float getYChartMin() {
        return Math.min(this.c0.G, this.d0.G);
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public void h() {
        if (this.a) {
            Log.i("MPAndroidChart", "Preparing... DATA NOT SET.");
        }
    }

    protected void j(RectF rectF) {
        rectF.left = 0.0f;
        rectF.right = 0.0f;
        rectF.top = 0.0f;
        rectF.bottom = 0.0f;
        Legend legend = this.k;
        if (legend == null || !legend.c() || this.k.h()) {
            return;
        }
        int i = a.c[this.k.f().ordinal()];
        if (i != 1) {
            if (i != 2) {
                return;
            }
            int i2 = a.a[this.k.g().ordinal()];
            if (i2 == 1) {
                rectF.top += Math.min(this.k.x, this.f234q.l() * this.k.e()) + this.k.b();
                return;
            } else {
                if (i2 != 2) {
                    return;
                }
                rectF.bottom += Math.min(this.k.x, this.f234q.l() * this.k.e()) + this.k.b();
                return;
            }
        }
        int i3 = a.b[this.k.d().ordinal()];
        if (i3 == 1) {
            rectF.left += Math.min(this.k.w, this.f234q.m() * this.k.e()) + this.k.a();
            return;
        }
        if (i3 == 2) {
            rectF.right += Math.min(this.k.w, this.f234q.m() * this.k.e()) + this.k.a();
            return;
        }
        if (i3 != 3) {
            return;
        }
        int i4 = a.a[this.k.g().ordinal()];
        if (i4 == 1) {
            rectF.top += Math.min(this.k.x, this.f234q.l() * this.k.e()) + this.k.b();
        } else {
            if (i4 != 2) {
                return;
            }
            rectF.bottom += Math.min(this.k.x, this.f234q.l() * this.k.e()) + this.k.b();
        }
    }

    public void k() {
        if (!this.o0) {
            j(this.l0);
            RectF rectF = this.l0;
            float fN = rectF.left + 0.0f;
            float f = rectF.top + 0.0f;
            float fN2 = rectF.right + 0.0f;
            float f2 = rectF.bottom + 0.0f;
            if (this.c0.p()) {
                fN += this.c0.n(this.e0.a());
            }
            if (this.d0.p()) {
                fN2 += this.d0.n(this.f0.a());
            }
            if (this.h.c() && this.h.g()) {
                XAxis xAxis = this.h;
                float fB = xAxis.N + xAxis.b();
                if (this.h.j() == XAxis.XAxisPosition.BOTTOM) {
                    f2 += fB;
                } else if (this.h.j() == XAxis.XAxisPosition.TOP) {
                    f += fB;
                } else if (this.h.j() == XAxis.XAxisPosition.BOTH_SIDED) {
                    f2 += fB;
                    f += fB;
                }
            }
            float extraTopOffset = f + getExtraTopOffset();
            float extraRightOffset = fN2 + getExtraRightOffset();
            float extraBottomOffset = f2 + getExtraBottomOffset();
            float extraLeftOffset = fN + getExtraLeftOffset();
            float fC = ta3.c(this.a0);
            this.f234q.C(Math.max(fC, extraLeftOffset), Math.max(fC, extraTopOffset), Math.max(fC, extraRightOffset), Math.max(fC, extraBottomOffset));
            if (this.a) {
                Log.i("MPAndroidChart", "offsetLeft: " + extraLeftOffset + ", offsetTop: " + extraTopOffset + ", offsetRight: " + extraRightOffset + ", offsetBottom: " + extraBottomOffset);
                StringBuilder sb = new StringBuilder();
                sb.append("Content: ");
                sb.append(this.f234q.o().toString());
                Log.i("MPAndroidChart", sb.toString());
            }
        }
        y();
        z();
    }

    public by0 l(float f, float f2) {
        c(f, f2);
        return null;
    }

    public c53 m(YAxis.AxisDependency axisDependency) {
        return axisDependency == YAxis.AxisDependency.LEFT ? this.g0 : this.h0;
    }

    public boolean n() {
        return this.f234q.s();
    }

    public boolean o() {
        return this.c0.o() || this.d0.o();
    }

    @Override // com.github.mikephil.charting.charts.Chart, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // com.github.mikephil.charting.charts.Chart, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        float[] fArr = this.s0;
        fArr[1] = 0.0f;
        fArr[0] = 0.0f;
        if (this.b0) {
            fArr[0] = this.f234q.h();
            this.s0[1] = this.f234q.j();
            m(YAxis.AxisDependency.LEFT).b(this.s0);
        }
        super.onSizeChanged(i, i2, i3, i4);
        if (this.b0) {
            m(YAxis.AxisDependency.LEFT).c(this.s0);
            this.f234q.e(this.s0, this);
        } else {
            ue3 ue3Var = this.f234q;
            ue3Var.B(ue3Var.p(), this, true);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return false;
    }

    public boolean p() {
        return this.L;
    }

    public boolean q() {
        return this.N || this.O;
    }

    public boolean r() {
        return this.N;
    }

    public boolean s() {
        return this.O;
    }

    public void setAutoScaleMinMaxEnabled(boolean z) {
        this.J = z;
    }

    public void setBorderColor(int i) {
        this.S.setColor(i);
    }

    public void setBorderWidth(float f) {
        this.S.setStrokeWidth(ta3.c(f));
    }

    public void setClipDataToContent(boolean z) {
        this.W = z;
    }

    public void setClipValuesToContent(boolean z) {
        this.V = z;
    }

    public void setDoubleTapToZoomEnabled(boolean z) {
        this.L = z;
    }

    public void setDragEnabled(boolean z) {
        this.N = z;
        this.O = z;
    }

    public void setDragOffsetX(float f) {
        this.f234q.E(f);
    }

    public void setDragOffsetY(float f) {
        this.f234q.F(f);
    }

    public void setDragXEnabled(boolean z) {
        this.N = z;
    }

    public void setDragYEnabled(boolean z) {
        this.O = z;
    }

    public void setDrawBorders(boolean z) {
        this.U = z;
    }

    public void setDrawGridBackground(boolean z) {
        this.T = z;
    }

    public void setGridBackgroundColor(int i) {
        this.R.setColor(i);
    }

    public void setHighlightPerDragEnabled(boolean z) {
        this.M = z;
    }

    public void setKeepPositionOnRotation(boolean z) {
        this.b0 = z;
    }

    public void setMaxVisibleValueCount(int i) {
        this.I = i;
    }

    public void setMinOffset(float f) {
        this.a0 = f;
    }

    public void setOnDrawListener(zu1 zu1Var) {
    }

    public void setPinchZoom(boolean z) {
        this.K = z;
    }

    public void setRendererLeftYAxis(ql3 ql3Var) {
        this.e0 = ql3Var;
    }

    public void setRendererRightYAxis(ql3 ql3Var) {
        this.f0 = ql3Var;
    }

    public void setScaleEnabled(boolean z) {
        this.P = z;
        this.Q = z;
    }

    public void setScaleXEnabled(boolean z) {
        this.P = z;
    }

    public void setScaleYEnabled(boolean z) {
        this.Q = z;
    }

    public void setVisibleXRangeMaximum(float f) {
        this.f234q.I(this.h.H / f);
    }

    public void setVisibleXRangeMinimum(float f) {
        this.f234q.G(this.h.H / f);
    }

    public void setXAxisRenderer(ll3 ll3Var) {
        this.i0 = ll3Var;
    }

    public boolean t() {
        return this.f234q.t();
    }

    public boolean u() {
        return this.M;
    }

    public boolean v() {
        return this.K;
    }

    public boolean w() {
        return this.P;
    }

    public boolean x() {
        return this.Q;
    }

    protected void y() {
        this.h0.d(this.d0.o());
        this.g0.d(this.c0.o());
    }

    protected void z() {
        if (this.a) {
            Log.i("MPAndroidChart", "Preparing Value-Px Matrix, xmin: " + this.h.G + ", xmax: " + this.h.F + ", xdelta: " + this.h.H);
        }
        c53 c53Var = this.h0;
        XAxis xAxis = this.h;
        float f = xAxis.G;
        float f2 = xAxis.H;
        YAxis yAxis = this.d0;
        c53Var.e(f, f2, yAxis.H, yAxis.G);
        c53 c53Var2 = this.g0;
        XAxis xAxis2 = this.h;
        float f3 = xAxis2.G;
        float f4 = xAxis2.H;
        YAxis yAxis2 = this.c0;
        c53Var2.e(f3, f4, yAxis2.H, yAxis2.G);
    }

    public BarLineChartBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.I = 100;
        this.J = false;
        this.K = false;
        this.L = true;
        this.M = true;
        this.N = true;
        this.O = true;
        this.P = true;
        this.Q = true;
        this.T = false;
        this.U = false;
        this.V = false;
        this.W = true;
        this.a0 = 15.0f;
        this.b0 = false;
        this.j0 = 0L;
        this.k0 = 0L;
        this.l0 = new RectF();
        this.m0 = new Matrix();
        this.n0 = new Matrix();
        this.o0 = false;
        this.p0 = new float[2];
        this.q0 = hf1.b(0.0d, 0.0d);
        this.r0 = hf1.b(0.0d, 0.0d);
        this.s0 = new float[2];
    }

    public BarLineChartBase(Context context) {
        super(context);
        this.I = 100;
        this.J = false;
        this.K = false;
        this.L = true;
        this.M = true;
        this.N = true;
        this.O = true;
        this.P = true;
        this.Q = true;
        this.T = false;
        this.U = false;
        this.V = false;
        this.W = true;
        this.a0 = 15.0f;
        this.b0 = false;
        this.j0 = 0L;
        this.k0 = 0L;
        this.l0 = new RectF();
        this.m0 = new Matrix();
        this.n0 = new Matrix();
        this.o0 = false;
        this.p0 = new float[2];
        this.q0 = hf1.b(0.0d, 0.0d);
        this.r0 = hf1.b(0.0d, 0.0d);
        this.s0 = new float[2];
    }
}
