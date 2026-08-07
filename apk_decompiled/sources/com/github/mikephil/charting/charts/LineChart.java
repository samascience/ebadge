package com.github.mikephil.charting.charts;

import android.content.Context;
import android.util.AttributeSet;
import defpackage.hb1;
import defpackage.ib1;
import defpackage.jb1;
import defpackage.o60;

/* JADX INFO: loaded from: classes.dex */
public class LineChart extends BarLineChartBase<ib1> implements jb1 {
    public LineChart(Context context) {
        super(context);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    protected void e() {
        super.e();
        this.o = new hb1(this, this.r, this.f234q);
    }

    public ib1 getLineData() {
        return null;
    }

    @Override // com.github.mikephil.charting.charts.Chart, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        o60 o60Var = this.o;
        if (o60Var != null && (o60Var instanceof hb1)) {
            ((hb1) o60Var).b();
        }
        super.onDetachedFromWindow();
    }

    public LineChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LineChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
