package com.seeker.luckychart.strategy.doubletab;

import android.view.MotionEvent;
import com.seeker.luckychart.provider.ChartProvider;

/* JADX INFO: loaded from: classes.dex */
public class ECGDoubleTabImpl implements DoubleTap {
    private ChartProvider chartProvider;

    private ECGDoubleTabImpl(ChartProvider chartProvider) {
        this.chartProvider = chartProvider;
    }

    public static ECGDoubleTabImpl create(ChartProvider chartProvider) {
        return new ECGDoubleTabImpl(chartProvider);
    }

    @Override // com.seeker.luckychart.strategy.doubletab.DoubleTap
    public boolean doubleTap(MotionEvent motionEvent) {
        this.chartProvider.getSelf();
        return true;
    }
}
