package com.seeker.luckychart.charts;

import android.content.Context;
import android.util.AttributeSet;
import com.seeker.luckychart.model.chartdata.ScatterChartData;
import com.seeker.luckychart.render.CoorAxesRenderer;
import com.seeker.luckychart.render.ScatterChartDataRenderer;

/* JADX INFO: loaded from: classes.dex */
public class ScatterChartView extends AbstractChartView<ScatterChartData> {
    public ScatterChartView(Context context) {
        this(context, null);
    }

    @Override // com.seeker.luckychart.provider.ChartProvider
    public ScatterChartView getSelf() {
        return this;
    }

    public ScatterChartView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.seeker.luckychart.provider.RenderProvider
    public CoorAxesRenderer getChartAxesRenderer() {
        return CoorAxesRenderer.create(this);
    }

    @Override // com.seeker.luckychart.provider.RenderProvider
    public ScatterChartDataRenderer getChartDataRenderer() {
        return ScatterChartDataRenderer.create(this);
    }
}
