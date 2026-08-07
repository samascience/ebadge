package com.seeker.luckychart.model.chartdata;

import com.seeker.luckychart.model.container.ECGPointContainer;

/* JADX INFO: loaded from: classes.dex */
public class ECGChartData extends AbsChartData<ECGPointContainer> {
    private ECGChartData() {
    }

    public static ECGChartData create() {
        return new ECGChartData();
    }

    private ECGChartData(ECGPointContainer... eCGPointContainerArr) {
        super(eCGPointContainerArr);
    }

    public static ECGChartData create(ECGPointContainer... eCGPointContainerArr) {
        return new ECGChartData(eCGPointContainerArr);
    }
}
