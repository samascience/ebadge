package com.seeker.luckychart.strategy.scroll;

import android.graphics.Rect;
import com.seeker.luckychart.computator.ChartComputator;
import com.seeker.luckychart.model.Coordinateport;
import com.seeker.luckychart.provider.ChartProvider;

/* JADX INFO: loaded from: classes.dex */
public class ECGScrollerImpl implements Scroller {
    private ChartProvider chartProvider;
    private ScrollResult scrollResult = new ScrollResult();

    private ECGScrollerImpl(ChartProvider chartProvider) {
        this.chartProvider = chartProvider;
    }

    public static ECGScrollerImpl create(ChartProvider chartProvider) {
        return new ECGScrollerImpl(chartProvider);
    }

    @Override // com.seeker.luckychart.strategy.scroll.Scroller
    public ScrollResult scroll(float f, float f2, float f3, float f4) {
        ChartComputator chartComputator = this.chartProvider.getChartComputator();
        Coordinateport maxCoorport = chartComputator.getMaxCoorport();
        Coordinateport visibleCoorport = chartComputator.getVisibleCoorport();
        Rect dataContentRect = chartComputator.getDataContentRect();
        boolean z = false;
        boolean z2 = visibleCoorport.getLeft() > maxCoorport.getLeft();
        boolean z3 = visibleCoorport.getRight() < maxCoorport.getRight();
        if ((z2 && f3 <= 0.0f) || (z3 && f3 >= 0.0f)) {
            z = true;
        }
        if (z) {
            chartComputator.setViewportTopLeft(visibleCoorport.left + ((f3 * visibleCoorport.width()) / dataContentRect.width()), visibleCoorport.top);
        }
        ScrollResult scrollResult = this.scrollResult;
        scrollResult.canScrollX = z;
        scrollResult.canScroll = z;
        return scrollResult;
    }
}
