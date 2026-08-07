package com.github.mikephil.charting.charts;

import android.content.Context;
import android.util.AttributeSet;
import defpackage.bo;
import defpackage.co;
import defpackage.eo;

/* JADX INFO: loaded from: classes.dex */
public class BubbleChart extends BarLineChartBase<co> implements eo {
    public BubbleChart(Context context) {
        super(context);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    protected void e() {
        super.e();
        this.o = new bo(this, this.r, this.f234q);
    }

    public co getBubbleData() {
        return null;
    }

    public BubbleChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BubbleChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
