package com.github.mikephil.charting.charts;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import defpackage.qf;
import defpackage.rf;
import defpackage.sf;
import defpackage.tf;
import defpackage.ww0;

/* JADX INFO: loaded from: classes.dex */
public class BarChart extends BarLineChartBase<rf> implements sf {
    protected boolean t0;
    private boolean u0;
    private boolean v0;
    private boolean w0;

    public BarChart(Context context) {
        super(context);
        this.t0 = false;
        this.u0 = true;
        this.v0 = false;
        this.w0 = false;
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public ww0 c(float f, float f2) {
        Log.e("MPAndroidChart", "Can't select by touch. No data set.");
        return null;
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    protected void e() {
        super.e();
        this.o = new qf(this, this.r, this.f234q);
        setHighlighter(new tf(this));
        getXAxis().i(0.5f);
        getXAxis().h(0.5f);
    }

    @Override // defpackage.sf
    public rf getBarData() {
        return null;
    }

    public void setDrawBarShadow(boolean z) {
        this.v0 = z;
    }

    public void setDrawValueAboveBar(boolean z) {
        this.u0 = z;
    }

    public void setFitBars(boolean z) {
        this.w0 = z;
    }

    public void setHighlightFullBarEnabled(boolean z) {
        this.t0 = z;
    }

    public BarChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.t0 = false;
        this.u0 = true;
        this.v0 = false;
        this.w0 = false;
    }

    public BarChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.t0 = false;
        this.u0 = true;
        this.v0 = false;
        this.w0 = false;
    }
}
