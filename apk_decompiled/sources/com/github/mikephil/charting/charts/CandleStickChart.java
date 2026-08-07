package com.github.mikephil.charting.charts;

import android.content.Context;
import android.util.AttributeSet;
import defpackage.kv;
import defpackage.lv;
import defpackage.mv;

/* JADX INFO: loaded from: classes.dex */
public class CandleStickChart extends BarLineChartBase<kv> implements lv {
    public CandleStickChart(Context context) {
        super(context);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    protected void e() {
        super.e();
        this.o = new mv(this, this.r, this.f234q);
        getXAxis().i(0.5f);
        getXAxis().h(0.5f);
    }

    public kv getCandleData() {
        return null;
    }

    public CandleStickChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CandleStickChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
