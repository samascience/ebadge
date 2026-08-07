package com.seeker.luckychart.model.chartdata;

import com.seeker.luckychart.model.ChartAxis;
import com.seeker.luckychart.model.container.AbsContainer;
import com.seeker.luckychart.provider.DataProvider;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbsChartData<Container extends AbsContainer> implements DataProvider<Container> {
    private ChartAxis bottomAxis;
    private Container[] containers;
    private ChartAxis leftAxis;
    private ChartAxis rightAxis;
    private ChartAxis topAxis;

    AbsChartData() {
    }

    @Override // com.seeker.luckychart.provider.DataProvider
    public void clear() {
        Container[] containerArr = this.containers;
        if (containerArr != null) {
            for (Container container : containerArr) {
                container.clear();
            }
        }
    }

    @Override // com.seeker.luckychart.provider.AxisProvider
    public ChartAxis getBottomAxis() {
        return this.bottomAxis;
    }

    @Override // com.seeker.luckychart.provider.AxisProvider
    public ChartAxis getLeftAxis() {
        return this.leftAxis;
    }

    @Override // com.seeker.luckychart.provider.AxisProvider
    public ChartAxis getRightAxis() {
        return this.rightAxis;
    }

    @Override // com.seeker.luckychart.provider.AxisProvider
    public ChartAxis getTopAxis() {
        return this.topAxis;
    }

    @Override // com.seeker.luckychart.provider.AxisProvider
    public void setBottomAxis(ChartAxis chartAxis) {
        this.bottomAxis = chartAxis;
    }

    @Override // com.seeker.luckychart.provider.AxisProvider
    public void setLeftAxis(ChartAxis chartAxis) {
        this.leftAxis = chartAxis;
    }

    @Override // com.seeker.luckychart.provider.AxisProvider
    public void setRightAxis(ChartAxis chartAxis) {
        this.rightAxis = chartAxis;
    }

    @Override // com.seeker.luckychart.provider.AxisProvider
    public void setTopAxis(ChartAxis chartAxis) {
        this.topAxis = chartAxis;
    }

    @SafeVarargs
    AbsChartData(Container... containerArr) {
        this.containers = containerArr;
    }

    @Override // com.seeker.luckychart.provider.DataProvider
    public boolean containDataContainer(Container container) {
        Container[] containerArr = this.containers;
        if (containerArr != null && containerArr.length != 0) {
            for (Container container2 : containerArr) {
                if (container2.hashCode() == container.hashCode()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.seeker.luckychart.provider.DataProvider
    public Container[] getDataContainer() {
        return this.containers;
    }

    @Override // com.seeker.luckychart.provider.DataProvider
    @SafeVarargs
    public final void setDataContainer(Container... containerArr) {
        this.containers = containerArr;
    }
}
