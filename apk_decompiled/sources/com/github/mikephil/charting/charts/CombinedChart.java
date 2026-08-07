package com.github.mikephil.charting.charts;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import defpackage.co;
import defpackage.e43;
import defpackage.ib1;
import defpackage.ix;
import defpackage.kv;
import defpackage.mk2;
import defpackage.qz;
import defpackage.rf;
import defpackage.tz;
import defpackage.uz;
import defpackage.vz;
import defpackage.ww0;

/* JADX INFO: loaded from: classes.dex */
public class CombinedChart extends BarLineChartBase<tz> implements uz {
    private boolean t0;
    protected boolean u0;
    private boolean v0;
    protected DrawOrder[] w0;

    public enum DrawOrder {
        BAR,
        BUBBLE,
        LINE,
        CANDLE,
        SCATTER
    }

    public CombinedChart(Context context) {
        super(context);
        this.t0 = true;
        this.u0 = false;
        this.v0 = false;
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public ww0 c(float f, float f2) {
        Log.e("MPAndroidChart", "Can't select by touch. No data set.");
        return null;
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    protected void e() {
        super.e();
        this.w0 = new DrawOrder[]{DrawOrder.BAR, DrawOrder.BUBBLE, DrawOrder.LINE, DrawOrder.CANDLE, DrawOrder.SCATTER};
        setHighlighter(new vz(this, this));
        setHighlightFullBarEnabled(true);
        this.o = new qz(this, this.r, this.f234q);
    }

    @Override // defpackage.sf
    public rf getBarData() {
        return null;
    }

    public co getBubbleData() {
        return null;
    }

    public kv getCandleData() {
        return null;
    }

    public tz getCombinedData() {
        return null;
    }

    public DrawOrder[] getDrawOrder() {
        return this.w0;
    }

    public ib1 getLineData() {
        return null;
    }

    public mk2 getScatterData() {
        return null;
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public /* bridge */ /* synthetic */ void setData(ix ixVar) {
        e43.a(ixVar);
        setData((tz) null);
    }

    public void setDrawBarShadow(boolean z) {
        this.v0 = z;
    }

    public void setDrawOrder(DrawOrder[] drawOrderArr) {
        if (drawOrderArr == null || drawOrderArr.length <= 0) {
            return;
        }
        this.w0 = drawOrderArr;
    }

    public void setDrawValueAboveBar(boolean z) {
        this.t0 = z;
    }

    public void setHighlightFullBarEnabled(boolean z) {
        this.u0 = z;
    }

    public void setData(tz tzVar) {
        super.setData(tzVar);
        setHighlighter(new vz(this, this));
        ((qz) this.o).b();
        this.o.a();
    }

    public CombinedChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.t0 = true;
        this.u0 = false;
        this.v0 = false;
    }

    public CombinedChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.t0 = true;
        this.u0 = false;
        this.v0 = false;
    }
}
