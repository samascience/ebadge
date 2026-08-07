package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.github.mikephil.charting.components.YAxis;
import defpackage.ca2;
import defpackage.da2;
import defpackage.nl3;
import defpackage.sl3;
import defpackage.ta3;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes.dex */
public class RadarChart extends PieRadarChartBase<Object> {
    private float M;
    private float N;
    private int O;
    private int P;
    private int Q;
    private boolean R;
    private int S;
    private YAxis T;
    protected sl3 U;
    protected nl3 V;

    public RadarChart(Context context) {
        super(context);
        this.M = 2.5f;
        this.N = 1.5f;
        this.O = Color.rgb(122, 122, 122);
        this.P = Color.rgb(122, 122, 122);
        this.Q = Opcodes.FCMPG;
        this.R = true;
        this.S = 0;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.charts.Chart
    protected void e() {
        super.e();
        YAxis yAxis = new YAxis(YAxis.AxisDependency.LEFT);
        this.T = yAxis;
        yAxis.q(10.0f);
        this.M = ta3.c(1.5f);
        this.N = ta3.c(0.75f);
        this.o = new ca2(this, this.r, this.f234q);
        this.U = new sl3(this.f234q, this.T, this);
        this.V = new nl3(this.f234q, this.h, this);
        this.p = new da2(this);
    }

    public float getFactor() {
        RectF rectFO = this.f234q.o();
        return Math.min(rectFO.width() / 2.0f, rectFO.height() / 2.0f) / this.T.H;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    public float getRadius() {
        RectF rectFO = this.f234q.o();
        return Math.min(rectFO.width() / 2.0f, rectFO.height() / 2.0f);
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    protected float getRequiredBaseOffset() {
        return (this.h.c() && this.h.g()) ? this.h.M : ta3.c(10.0f);
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    protected float getRequiredLegendOffset() {
        return this.n.a().getTextSize() * 4.0f;
    }

    public int getSkipWebLineCount() {
        return this.S;
    }

    public float getSliceAngle() {
        throw null;
    }

    public int getWebAlpha() {
        return this.Q;
    }

    public int getWebColor() {
        return this.O;
    }

    public int getWebColorInner() {
        return this.P;
    }

    public float getWebLineWidth() {
        return this.M;
    }

    public float getWebLineWidthInner() {
        return this.N;
    }

    public YAxis getYAxis() {
        return this.T;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.charts.Chart
    public float getYChartMax() {
        return this.T.F;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.charts.Chart
    public float getYChartMin() {
        return this.T.G;
    }

    public float getYRange() {
        return this.T.H;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.charts.Chart
    public void h() {
    }

    @Override // com.github.mikephil.charting.charts.Chart, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void setDrawWeb(boolean z) {
        this.R = z;
    }

    public void setSkipWebLineCount(int i) {
        this.S = Math.max(0, i);
    }

    public void setWebAlpha(int i) {
        this.Q = i;
    }

    public void setWebColor(int i) {
        this.O = i;
    }

    public void setWebColorInner(int i) {
        this.P = i;
    }

    public void setWebLineWidth(float f) {
        this.M = ta3.c(f);
    }

    public void setWebLineWidthInner(float f) {
        this.N = ta3.c(f);
    }

    public RadarChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.M = 2.5f;
        this.N = 1.5f;
        this.O = Color.rgb(122, 122, 122);
        this.P = Color.rgb(122, 122, 122);
        this.Q = Opcodes.FCMPG;
        this.R = true;
        this.S = 0;
    }

    public RadarChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.M = 2.5f;
        this.N = 1.5f;
        this.O = Color.rgb(122, 122, 122);
        this.P = Color.rgb(122, 122, 122);
        this.Q = Opcodes.FCMPG;
        this.R = true;
        this.S = 0;
    }
}
