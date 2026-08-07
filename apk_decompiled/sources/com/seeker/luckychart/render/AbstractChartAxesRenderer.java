package com.seeker.luckychart.render;

import android.graphics.Rect;
import android.text.TextUtils;
import com.seeker.luckychart.computator.ChartComputator;
import com.seeker.luckychart.model.ChartAxis;
import com.seeker.luckychart.model.chartdata.AbsChartData;
import com.seeker.luckychart.provider.ChartProvider;
import com.seeker.luckychart.provider.DataProvider;
import com.seeker.luckychart.render.inters.LuckyAxesRenderer;
import com.seeker.luckychart.utils.ChartUtils;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractChartAxesRenderer<ChartData extends AbsChartData> implements LuckyAxesRenderer {
    protected ChartComputator chartComputator;
    protected ChartProvider<ChartData> chartProvider;

    AbstractChartAxesRenderer(ChartProvider<ChartData> chartProvider) {
        this.chartProvider = chartProvider;
        this.chartComputator = chartProvider.getChartComputator();
    }

    private int getAxisNameMargin(ChartAxis chartAxis) {
        if (TextUtils.isEmpty(chartAxis.getName())) {
            return 0;
        }
        return chartAxis.getNameTextAscent() + chartAxis.getNameTextDescent() + ChartUtils.dp2px(this.chartComputator.getDensity(), chartAxis.getAxisMargin());
    }

    private void initAxis(ChartAxis chartAxis, int i) {
        if (chartAxis == null) {
            return;
        }
        initAxisPaints(chartAxis, i);
        initAxisMargin(chartAxis, i);
        initAxisMeasurements(chartAxis, i);
        initContentRect(chartAxis, i);
    }

    private void initAxisMargin(ChartAxis chartAxis, int i) {
        insetContentRectWithAxesMargins(ChartUtils.dp2px(this.chartComputator.getDensity(), chartAxis.getAxisMargin()) + chartAxis.getCoorDimensionForMargins() + getAxisNameMargin(chartAxis), i);
    }

    private void initAxisMeasurements(ChartAxis chartAxis, int i) {
        int iDp2px = ChartUtils.dp2px(this.chartComputator.getDensity(), chartAxis.getAxisMargin());
        Rect dataContentRect = this.chartComputator.getDataContentRect();
        if (i == 1) {
            chartAxis.setCoorBaseLine(dataContentRect.left - iDp2px);
            chartAxis.setNameBaseLine(((chartAxis.getCoorBaseLine() - iDp2px) - chartAxis.getCoorTextDescent()) - chartAxis.getCoorDimensionForMargins());
            chartAxis.setSeparationLine(dataContentRect.left);
            return;
        }
        if (i == 2) {
            chartAxis.setCoorBaseLine((dataContentRect.top - iDp2px) - chartAxis.getCoorTextDescent());
            chartAxis.setNameBaseLine((chartAxis.getCoorBaseLine() - iDp2px) - chartAxis.getCoorDimensionForMargins());
            chartAxis.setSeparationLine(dataContentRect.top);
        } else if (i == 3) {
            chartAxis.setCoorBaseLine(dataContentRect.right + iDp2px);
            chartAxis.setNameBaseLine(chartAxis.getCoorBaseLine() + iDp2px + chartAxis.getCoorTextAscent() + chartAxis.getCoorDimensionForMargins());
            chartAxis.setSeparationLine(dataContentRect.right);
        } else {
            if (i != 4) {
                return;
            }
            chartAxis.setCoorBaseLine(dataContentRect.bottom + iDp2px + chartAxis.getCoorHeight());
            chartAxis.setNameBaseLine(chartAxis.getCoorBaseLine() + iDp2px + chartAxis.getCoorDimensionForMargins());
            chartAxis.setSeparationLine(dataContentRect.bottom);
        }
    }

    private void initAxisPaints(ChartAxis chartAxis, int i) {
        chartAxis.initFontMetricsInt();
        if (isAxisVertical(i)) {
            chartAxis.setCoorDimensionForMargins(chartAxis.getCoorWidth());
        } else {
            chartAxis.setCoorDimensionForMargins(chartAxis.getCoorTextAscent() + chartAxis.getCoorTextDescent());
        }
    }

    private void initContentRect(ChartAxis chartAxis, int i) {
        if (isAxisVertical(i)) {
            this.chartComputator.insetContentRect(0, chartAxis.getCoorTextAscent(), 0, 0);
        } else {
            this.chartComputator.insetContentRect(0, 0, chartAxis.getCoorWidth() / 2, 0);
        }
    }

    private void insetContentRectWithAxesMargins(int i, int i2) {
        if (i2 == 1) {
            this.chartComputator.insetContentRect(i, 0, 0, 0);
            return;
        }
        if (i2 == 2) {
            this.chartComputator.insetContentRect(0, i, 0, 0);
        } else if (i2 == 3) {
            this.chartComputator.insetContentRect(0, 0, i, 0);
        } else {
            if (i2 != 4) {
                return;
            }
            this.chartComputator.insetContentRect(0, 0, 0, i);
        }
    }

    private void onChanged() {
        DataProvider chartData = this.chartProvider.getChartData();
        if (chartData != null) {
            initAxis(chartData.getLeftAxis(), 1);
            initAxis(chartData.getTopAxis(), 2);
            initAxis(chartData.getRightAxis(), 3);
            initAxis(chartData.getBottomAxis(), 4);
        }
    }

    protected boolean isAxisVertical(int i) {
        if (i == 1 || i == 3) {
            return true;
        }
        if (i == 2 || i == 4) {
            return false;
        }
        throw new IllegalArgumentException("Invalid axis location " + i);
    }

    @Override // com.seeker.luckychart.render.inters.LuckyRenderer
    public void onChartDataChanged() {
        onChanged();
    }

    @Override // com.seeker.luckychart.render.inters.LuckyRenderer
    public void onChartSizeChanged() {
        onChanged();
    }

    @Override // com.seeker.luckychart.render.inters.LuckyRenderer
    public void onChartlayoutChanged() {
        onChanged();
    }
}
