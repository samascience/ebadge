package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import com.github.mikephil.charting.components.XAxis;
import com.tencent.connect.common.Constants;
import defpackage.if1;
import defpackage.m32;
import defpackage.n32;
import defpackage.o60;
import defpackage.ta3;

/* JADX INFO: loaded from: classes.dex */
public class PieChart extends PieRadarChartBase<Object> {
    private RectF M;
    private boolean N;
    private float[] O;
    private float[] P;
    private boolean Q;
    private boolean R;
    private boolean S;
    private boolean T;
    private CharSequence U;
    private if1 V;
    private float W;
    protected float a0;
    private boolean b0;
    private float c0;
    protected float d0;
    private float e0;

    public PieChart(Context context) {
        super(context);
        this.M = new RectF();
        this.N = true;
        this.O = new float[1];
        this.P = new float[1];
        this.Q = true;
        this.R = false;
        this.S = false;
        this.T = false;
        this.U = Constants.STR_EMPTY;
        this.V = if1.b(0.0f, 0.0f);
        this.W = 50.0f;
        this.a0 = 55.0f;
        this.b0 = true;
        this.c0 = 100.0f;
        this.d0 = 360.0f;
        this.e0 = 0.0f;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.charts.Chart
    protected void e() {
        super.e();
        this.o = new m32(this, this.r, this.f234q);
        this.h = null;
        this.p = new n32(this);
    }

    public float[] getAbsoluteAngles() {
        return this.P;
    }

    public if1 getCenterCircleBox() {
        return if1.b(this.M.centerX(), this.M.centerY());
    }

    public CharSequence getCenterText() {
        return this.U;
    }

    public if1 getCenterTextOffset() {
        if1 if1Var = this.V;
        return if1.b(if1Var.c, if1Var.d);
    }

    public float getCenterTextRadiusPercent() {
        return this.c0;
    }

    public RectF getCircleBox() {
        return this.M;
    }

    public float[] getDrawAngles() {
        return this.O;
    }

    public float getHoleRadius() {
        return this.W;
    }

    public float getMaxAngle() {
        return this.d0;
    }

    public float getMinAngleForSlices() {
        return this.e0;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    public float getRadius() {
        RectF rectF = this.M;
        if (rectF == null) {
            return 0.0f;
        }
        return Math.min(rectF.width() / 2.0f, this.M.height() / 2.0f);
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    protected float getRequiredBaseOffset() {
        return 0.0f;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    protected float getRequiredLegendOffset() {
        return this.n.a().getTextSize() * 2.0f;
    }

    public float getTransparentCircleRadius() {
        return this.a0;
    }

    @Override // com.github.mikephil.charting.charts.Chart
    @Deprecated
    public XAxis getXAxis() {
        throw new RuntimeException("PieChart has no XAxis");
    }

    @Override // com.github.mikephil.charting.charts.Chart, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        o60 o60Var = this.o;
        if (o60Var != null && (o60Var instanceof m32)) {
            ((m32) o60Var).f();
        }
        super.onDetachedFromWindow();
    }

    @Override // com.github.mikephil.charting.charts.Chart, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void setCenterText(CharSequence charSequence) {
        if (charSequence == null) {
            this.U = Constants.STR_EMPTY;
        } else {
            this.U = charSequence;
        }
    }

    public void setCenterTextColor(int i) {
        ((m32) this.o).b().setColor(i);
    }

    public void setCenterTextRadiusPercent(float f) {
        this.c0 = f;
    }

    public void setCenterTextSize(float f) {
        ((m32) this.o).b().setTextSize(ta3.c(f));
    }

    public void setCenterTextSizePixels(float f) {
        ((m32) this.o).b().setTextSize(f);
    }

    public void setCenterTextTypeface(Typeface typeface) {
        ((m32) this.o).b().setTypeface(typeface);
    }

    public void setDrawCenterText(boolean z) {
        this.b0 = z;
    }

    public void setDrawEntryLabels(boolean z) {
        this.N = z;
    }

    public void setDrawHoleEnabled(boolean z) {
        this.Q = z;
    }

    public void setDrawRoundedSlices(boolean z) {
        this.T = z;
    }

    @Deprecated
    public void setDrawSliceText(boolean z) {
        this.N = z;
    }

    public void setDrawSlicesUnderHole(boolean z) {
        this.R = z;
    }

    public void setEntryLabelColor(int i) {
        ((m32) this.o).c().setColor(i);
    }

    public void setEntryLabelTextSize(float f) {
        ((m32) this.o).c().setTextSize(ta3.c(f));
    }

    public void setEntryLabelTypeface(Typeface typeface) {
        ((m32) this.o).c().setTypeface(typeface);
    }

    public void setHoleColor(int i) {
        ((m32) this.o).d().setColor(i);
    }

    public void setHoleRadius(float f) {
        this.W = f;
    }

    public void setMaxAngle(float f) {
        if (f > 360.0f) {
            f = 360.0f;
        }
        if (f < 90.0f) {
            f = 90.0f;
        }
        this.d0 = f;
    }

    public void setMinAngleForSlices(float f) {
        float f2 = this.d0;
        if (f > f2 / 2.0f) {
            f = f2 / 2.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        this.e0 = f;
    }

    public void setTransparentCircleAlpha(int i) {
        ((m32) this.o).e().setAlpha(i);
    }

    public void setTransparentCircleColor(int i) {
        Paint paintE = ((m32) this.o).e();
        int alpha = paintE.getAlpha();
        paintE.setColor(i);
        paintE.setAlpha(alpha);
    }

    public void setTransparentCircleRadius(float f) {
        this.a0 = f;
    }

    public void setUsePercentValues(boolean z) {
        this.S = z;
    }

    public PieChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.M = new RectF();
        this.N = true;
        this.O = new float[1];
        this.P = new float[1];
        this.Q = true;
        this.R = false;
        this.S = false;
        this.T = false;
        this.U = Constants.STR_EMPTY;
        this.V = if1.b(0.0f, 0.0f);
        this.W = 50.0f;
        this.a0 = 55.0f;
        this.b0 = true;
        this.c0 = 100.0f;
        this.d0 = 360.0f;
        this.e0 = 0.0f;
    }

    public PieChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.M = new RectF();
        this.N = true;
        this.O = new float[1];
        this.P = new float[1];
        this.Q = true;
        this.R = false;
        this.S = false;
        this.T = false;
        this.U = Constants.STR_EMPTY;
        this.V = if1.b(0.0f, 0.0f);
        this.W = 50.0f;
        this.a0 = 55.0f;
        this.b0 = true;
        this.c0 = 100.0f;
        this.d0 = 360.0f;
        this.e0 = 0.0f;
    }
}
