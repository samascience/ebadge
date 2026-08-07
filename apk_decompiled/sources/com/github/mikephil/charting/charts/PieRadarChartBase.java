package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.c;
import defpackage.if1;
import defpackage.ix;
import defpackage.ta3;

/* JADX INFO: loaded from: classes.dex */
public abstract class PieRadarChartBase<T extends ix> extends Chart<T> {
    private float I;
    private float J;
    protected boolean K;
    protected float L;

    public PieRadarChartBase(Context context) {
        super(context);
        this.I = 270.0f;
        this.J = 270.0f;
        this.K = true;
        this.L = 0.0f;
    }

    @Override // android.view.View
    public void computeScroll() {
        ChartTouchListener chartTouchListener = this.l;
        if (chartTouchListener instanceof c) {
            ((c) chartTouchListener).g();
        }
    }

    @Override // com.github.mikephil.charting.charts.Chart
    protected void e() {
        super.e();
        this.l = new c(this);
    }

    public float getDiameter() {
        RectF rectFO = this.f234q.o();
        rectFO.left += getExtraLeftOffset();
        rectFO.top += getExtraTopOffset();
        rectFO.right -= getExtraRightOffset();
        rectFO.bottom -= getExtraBottomOffset();
        return Math.min(rectFO.width(), rectFO.height());
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public int getMaxVisibleCount() {
        throw null;
    }

    public float getMinOffset() {
        return this.L;
    }

    public abstract float getRadius();

    public float getRawRotationAngle() {
        return this.J;
    }

    protected abstract float getRequiredBaseOffset();

    protected abstract float getRequiredLegendOffset();

    public float getRotationAngle() {
        return this.I;
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public float getYChartMax() {
        return 0.0f;
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public float getYChartMin() {
        return 0.0f;
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public void h() {
    }

    public float j(float f, float f2) {
        if1 centerOffsets = getCenterOffsets();
        double d = f - centerOffsets.c;
        double d2 = f2 - centerOffsets.d;
        float degrees = (float) Math.toDegrees(Math.acos(d2 / Math.sqrt((d * d) + (d2 * d2))));
        if (f > centerOffsets.c) {
            degrees = 360.0f - degrees;
        }
        float f3 = degrees + 90.0f;
        if (f3 > 360.0f) {
            f3 -= 360.0f;
        }
        if1.d(centerOffsets);
        return f3;
    }

    public boolean k() {
        return this.K;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ChartTouchListener chartTouchListener;
        return (!this.i || (chartTouchListener = this.l) == null) ? super.onTouchEvent(motionEvent) : chartTouchListener.onTouch(this, motionEvent);
    }

    public void setMinOffset(float f) {
        this.L = f;
    }

    public void setRotationAngle(float f) {
        this.J = f;
        this.I = ta3.g(f);
    }

    public void setRotationEnabled(boolean z) {
        this.K = z;
    }

    public PieRadarChartBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.I = 270.0f;
        this.J = 270.0f;
        this.K = true;
        this.L = 0.0f;
    }

    public PieRadarChartBase(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.I = 270.0f;
        this.J = 270.0f;
        this.K = true;
        this.L = 0.0f;
    }
}
