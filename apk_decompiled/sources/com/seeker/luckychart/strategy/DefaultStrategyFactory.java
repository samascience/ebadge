package com.seeker.luckychart.strategy;

import com.seeker.luckychart.provider.ChartProvider;
import com.seeker.luckychart.provider.GestureProvider;
import com.seeker.luckychart.strategy.doubletab.DefaultDoubleTabImpl;
import com.seeker.luckychart.strategy.doubletab.DoubleTap;
import com.seeker.luckychart.strategy.press.DefaultLongPressImpl;
import com.seeker.luckychart.strategy.press.LongPress;
import com.seeker.luckychart.strategy.scale.DefaultScaler;
import com.seeker.luckychart.strategy.scale.Scaler;
import com.seeker.luckychart.strategy.scroll.DefaultScrollerImpl;
import com.seeker.luckychart.strategy.scroll.Scroller;

/* JADX INFO: loaded from: classes.dex */
public class DefaultStrategyFactory implements GestureProvider {
    private ChartProvider chartProvider;
    private DoubleTap doubleTap;
    private LongPress longPress;
    private Scaler scaler;
    private Scroller scroller;

    private DefaultStrategyFactory(ChartProvider chartProvider) {
        this.chartProvider = chartProvider;
        initStrategies();
    }

    public static DefaultStrategyFactory create(ChartProvider chartProvider) {
        return new DefaultStrategyFactory(chartProvider);
    }

    private void initStrategies() {
        this.doubleTap = DefaultDoubleTabImpl.create(this.chartProvider);
        this.scroller = DefaultScrollerImpl.create(this.chartProvider);
        this.longPress = DefaultLongPressImpl.create(this.chartProvider);
        this.scaler = DefaultScaler.create(this.chartProvider);
    }

    @Override // com.seeker.luckychart.provider.GestureProvider
    public DoubleTap getDoubleTab() {
        return this.doubleTap;
    }

    @Override // com.seeker.luckychart.provider.GestureProvider
    public LongPress getLongpresser() {
        return this.longPress;
    }

    @Override // com.seeker.luckychart.provider.GestureProvider
    public Scaler getScaler() {
        return this.scaler;
    }

    @Override // com.seeker.luckychart.provider.GestureProvider
    public Scroller getScrollImpl() {
        return this.scroller;
    }
}
