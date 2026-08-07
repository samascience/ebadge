package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import defpackage.c53;
import defpackage.cx0;
import defpackage.d53;
import defpackage.dx0;
import defpackage.ex0;
import defpackage.ml3;
import defpackage.rl3;
import defpackage.ta3;
import defpackage.ww0;

/* JADX INFO: loaded from: classes.dex */
public class HorizontalBarChart extends BarChart {
    private RectF x0;
    protected float[] y0;

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

    public HorizontalBarChart(Context context) {
        super(context);
        this.x0 = new RectF();
        this.y0 = new float[2];
    }

    @Override // com.github.mikephil.charting.charts.BarChart, com.github.mikephil.charting.charts.Chart
    public ww0 c(float f, float f2) {
        if (!this.a) {
            return null;
        }
        Log.e("MPAndroidChart", "Can't select by touch. No data set.");
        return null;
    }

    @Override // com.github.mikephil.charting.charts.BarChart, com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    protected void e() {
        this.f234q = new ex0();
        super.e();
        this.g0 = new d53(this.f234q);
        this.h0 = new d53(this.f234q);
        this.o = new cx0(this, this.r, this.f234q);
        setHighlighter(new dx0(this));
        this.e0 = new rl3(this.f234q, this.c0, this.g0);
        this.f0 = new rl3(this.f234q, this.d0, this.h0);
        this.i0 = new ml3(this.f234q, this.h, this.g0, this);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase
    public float getHighestVisibleX() {
        m(YAxis.AxisDependency.LEFT).a(this.f234q.h(), this.f234q.j(), this.r0);
        return (float) Math.min(this.h.F, this.r0.d);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase
    public float getLowestVisibleX() {
        m(YAxis.AxisDependency.LEFT).a(this.f234q.h(), this.f234q.f(), this.q0);
        return (float) Math.max(this.h.G, this.q0.d);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase
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
        if (i == 1) {
            int i2 = a.b[this.k.d().ordinal()];
            if (i2 == 1) {
                rectF.left += Math.min(this.k.w, this.f234q.m() * this.k.e()) + this.k.a();
                return;
            }
            if (i2 == 2) {
                rectF.right += Math.min(this.k.w, this.f234q.m() * this.k.e()) + this.k.a();
                return;
            }
            if (i2 != 3) {
                return;
            }
            int i3 = a.a[this.k.g().ordinal()];
            if (i3 == 1) {
                rectF.top += Math.min(this.k.x, this.f234q.l() * this.k.e()) + this.k.b();
                return;
            } else {
                if (i3 != 2) {
                    return;
                }
                rectF.bottom += Math.min(this.k.x, this.f234q.l() * this.k.e()) + this.k.b();
                return;
            }
        }
        if (i != 2) {
            return;
        }
        int i4 = a.a[this.k.g().ordinal()];
        if (i4 == 1) {
            rectF.top += Math.min(this.k.x, this.f234q.l() * this.k.e()) + this.k.b();
            if (this.c0.c() && this.c0.g()) {
                rectF.top += this.c0.m(this.e0.a());
                return;
            }
            return;
        }
        if (i4 != 2) {
            return;
        }
        rectF.bottom += Math.min(this.k.x, this.f234q.l() * this.k.e()) + this.k.b();
        if (this.d0.c() && this.d0.g()) {
            rectF.bottom += this.d0.m(this.f0.a());
        }
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase
    public void k() {
        j(this.x0);
        RectF rectF = this.x0;
        float f = rectF.left + 0.0f;
        float fM = rectF.top + 0.0f;
        float f2 = rectF.right + 0.0f;
        float fM2 = rectF.bottom + 0.0f;
        if (this.c0.p()) {
            fM += this.c0.m(this.e0.a());
        }
        if (this.d0.p()) {
            fM2 += this.d0.m(this.f0.a());
        }
        XAxis xAxis = this.h;
        float f3 = xAxis.M;
        if (xAxis.c()) {
            if (this.h.j() == XAxis.XAxisPosition.BOTTOM) {
                f += f3;
            } else if (this.h.j() == XAxis.XAxisPosition.TOP) {
                f2 += f3;
            } else if (this.h.j() == XAxis.XAxisPosition.BOTH_SIDED) {
                f += f3;
                f2 += f3;
            }
        }
        float extraTopOffset = fM + getExtraTopOffset();
        float extraRightOffset = f2 + getExtraRightOffset();
        float extraBottomOffset = fM2 + getExtraBottomOffset();
        float extraLeftOffset = f + getExtraLeftOffset();
        float fC = ta3.c(this.a0);
        this.f234q.C(Math.max(fC, extraLeftOffset), Math.max(fC, extraTopOffset), Math.max(fC, extraRightOffset), Math.max(fC, extraBottomOffset));
        if (this.a) {
            Log.i("MPAndroidChart", "offsetLeft: " + extraLeftOffset + ", offsetTop: " + extraTopOffset + ", offsetRight: " + extraRightOffset + ", offsetBottom: " + extraBottomOffset);
            StringBuilder sb = new StringBuilder();
            sb.append("Content: ");
            sb.append(this.f234q.o().toString());
            Log.i("MPAndroidChart", sb.toString());
        }
        y();
        z();
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase
    public void setVisibleXRangeMaximum(float f) {
        this.f234q.J(this.h.H / f);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase
    public void setVisibleXRangeMinimum(float f) {
        this.f234q.H(this.h.H / f);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase
    protected void z() {
        c53 c53Var = this.h0;
        YAxis yAxis = this.d0;
        float f = yAxis.G;
        float f2 = yAxis.H;
        XAxis xAxis = this.h;
        c53Var.e(f, f2, xAxis.H, xAxis.G);
        c53 c53Var2 = this.g0;
        YAxis yAxis2 = this.c0;
        float f3 = yAxis2.G;
        float f4 = yAxis2.H;
        XAxis xAxis2 = this.h;
        c53Var2.e(f3, f4, xAxis2.H, xAxis2.G);
    }

    public HorizontalBarChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.x0 = new RectF();
        this.y0 = new float[2];
    }

    public HorizontalBarChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.x0 = new RectF();
        this.y0 = new float[2];
    }
}
