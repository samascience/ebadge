package com.seeker.luckychart.provider;

import com.seeker.luckychart.model.ChartAxis;

/* JADX INFO: loaded from: classes.dex */
public interface AxisProvider {
    ChartAxis getBottomAxis();

    ChartAxis getLeftAxis();

    ChartAxis getRightAxis();

    ChartAxis getTopAxis();

    void setBottomAxis(ChartAxis chartAxis);

    void setLeftAxis(ChartAxis chartAxis);

    void setRightAxis(ChartAxis chartAxis);

    void setTopAxis(ChartAxis chartAxis);
}
