package com.seeker.luckychart.strategy;

import com.seeker.luckychart.provider.ChartProvider;
import com.seeker.luckychart.provider.GestureProvider;
import com.seeker.luckychart.strategy.doubletab.DoubleTap;
import com.seeker.luckychart.strategy.doubletab.ECGDoubleTabImpl;
import com.seeker.luckychart.strategy.ecgrender.ECGRenderStrategy;
import com.seeker.luckychart.strategy.ecgrender.ECGRenderStrategyImpl;
import com.seeker.luckychart.strategy.press.ECGLongPressImpl;
import com.seeker.luckychart.strategy.press.LongPress;
import com.seeker.luckychart.strategy.scale.Scaler;
import com.seeker.luckychart.strategy.scroll.ECGScrollerImpl;
import com.seeker.luckychart.strategy.scroll.Scroller;

/* JADX INFO: loaded from: classes.dex */
public class ECGStrategyFactory implements GestureProvider {
    private ChartProvider chartProvider;
    private DoubleTap doubleTap;
    private LongPress longPress;
    private ECGRenderStrategy renderStrategy;
    private Scroller scroller;

    private ECGStrategyFactory(ChartProvider chartProvider) {
        this.chartProvider = chartProvider;
        initStrategies();
    }

    public static ECGStrategyFactory create(ChartProvider chartProvider) {
        return new ECGStrategyFactory(chartProvider);
    }

    private void initStrategies() {
        this.doubleTap = ECGDoubleTabImpl.create(this.chartProvider);
        this.scroller = ECGScrollerImpl.create(this.chartProvider);
        this.longPress = ECGLongPressImpl.create(this.chartProvider);
        this.renderStrategy = ECGRenderStrategyImpl.create();
    }

    @Override // com.seeker.luckychart.provider.GestureProvider
    public DoubleTap getDoubleTab() {
        return this.doubleTap;
    }

    public ECGRenderStrategy getECGRenderStrategy() {
        return this.renderStrategy;
    }

    @Override // com.seeker.luckychart.provider.GestureProvider
    public LongPress getLongpresser() {
        return this.longPress;
    }

    @Override // com.seeker.luckychart.provider.GestureProvider
    public Scaler getScaler() {
        return null;
    }

    @Override // com.seeker.luckychart.provider.GestureProvider
    public Scroller getScrollImpl() {
        return this.scroller;
    }
}
