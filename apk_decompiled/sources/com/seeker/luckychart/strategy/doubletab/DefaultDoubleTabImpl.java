package com.seeker.luckychart.strategy.doubletab;

import android.view.MotionEvent;
import com.seeker.luckychart.provider.ChartProvider;

/* JADX INFO: loaded from: classes.dex */
public class DefaultDoubleTabImpl implements DoubleTap {
    private ChartProvider chartProvider;

    private DefaultDoubleTabImpl(ChartProvider chartProvider) {
        this.chartProvider = chartProvider;
    }

    public static DefaultDoubleTabImpl create(ChartProvider chartProvider) {
        return new DefaultDoubleTabImpl(chartProvider);
    }

    @Override // com.seeker.luckychart.strategy.doubletab.DoubleTap
    public boolean doubleTap(MotionEvent motionEvent) {
        return true;
    }
}
