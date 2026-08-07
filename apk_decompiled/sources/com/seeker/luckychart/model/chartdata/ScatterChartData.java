package com.seeker.luckychart.model.chartdata;

import com.seeker.luckychart.model.container.PointContainer;

/* JADX INFO: loaded from: classes.dex */
public class ScatterChartData extends AbsChartData<PointContainer> {
    private ScatterChartData() {
    }

    public static ScatterChartData create() {
        return new ScatterChartData();
    }

    private ScatterChartData(PointContainer pointContainer) {
        super(pointContainer);
    }

    public static ScatterChartData create(PointContainer pointContainer) {
        return new ScatterChartData(pointContainer);
    }
}
