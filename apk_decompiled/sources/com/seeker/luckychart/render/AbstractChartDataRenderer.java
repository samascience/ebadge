package com.seeker.luckychart.render;

import com.seeker.luckychart.computator.ChartComputator;
import com.seeker.luckychart.model.chartdata.AbsChartData;
import com.seeker.luckychart.model.container.AbsContainer;
import com.seeker.luckychart.provider.ChartProvider;
import com.seeker.luckychart.render.inters.LuckyDataRenderer;
import com.seeker.luckychart.utils.ChartLogger;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractChartDataRenderer<ChartData extends AbsChartData> implements LuckyDataRenderer {
    private static final String TAG = "AbstractChartDataRender";
    protected ChartComputator chartComputator;
    protected ChartProvider<ChartData> chartProvider;

    public AbstractChartDataRenderer(ChartProvider<ChartData> chartProvider) {
        this.chartProvider = chartProvider;
        this.chartComputator = chartProvider.getChartComputator();
    }

    public boolean checkDataAvailable() {
        AbsChartData absChartData = (AbsChartData) this.chartProvider.getChartData();
        if (absChartData == null) {
            ChartLogger.wTag(TAG, "checkDataAvailable(),chartData == null.");
            return false;
        }
        AbsContainer[] dataContainer = absChartData.getDataContainer();
        if (dataContainer != null && dataContainer.length != 0) {
            return true;
        }
        ChartLogger.wTag(TAG, "checkDataAvailable(),container == null.");
        return false;
    }

    @Override // com.seeker.luckychart.render.inters.LuckyRenderer
    public void initScene() {
    }
}
