package com.seeker.luckychart.provider;

import android.content.Context;
import android.view.View;
import com.seeker.luckychart.computator.ChartComputator;
import com.seeker.luckychart.model.Coordinateport;
import com.seeker.luckychart.provider.DataProvider;

/* JADX INFO: loaded from: classes.dex */
public interface ChartProvider<ChartData extends DataProvider> extends RenderProvider {
    void clearChartData();

    ChartComputator getChartComputator();

    ChartData getChartData();

    Context getContexter();

    View getSelf();

    void setChartData(ChartData chartdata);

    void setChartMaxCoordinateport(Coordinateport coordinateport);

    void setChartVisibleCoordinateport(Coordinateport coordinateport);

    void setChartVisibleCoordinateportWithAnim(Coordinateport coordinateport, long j);

    void setTouchable(boolean z);
}
