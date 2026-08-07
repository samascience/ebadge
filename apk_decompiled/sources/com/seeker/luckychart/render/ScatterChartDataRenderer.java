package com.seeker.luckychart.render;

import android.graphics.PointF;
import com.seeker.luckychart.model.Coordinateport;
import com.seeker.luckychart.model.PointValue;
import com.seeker.luckychart.model.chartdata.ScatterChartData;
import com.seeker.luckychart.model.container.PointContainer;
import com.seeker.luckychart.provider.ChartProvider;
import java.util.Stack;
import org.rajawali3d.materials.Material;
import org.rajawali3d.math.vector.Vector3;
import org.rajawali3d.primitives.Line3D;

/* JADX INFO: loaded from: classes.dex */
public class ScatterChartDataRenderer extends AbstractChartDataRenderer<ScatterChartData> {
    private ScatterChartDataRenderer(ChartProvider<ScatterChartData> chartProvider) {
        super(chartProvider);
    }

    public static ScatterChartDataRenderer create(ChartProvider<ScatterChartData> chartProvider) {
        return new ScatterChartDataRenderer(chartProvider);
    }

    private void drawPoint(PointValue[] pointValueArr, int i, float f) {
        Coordinateport visibleCoorport = this.chartComputator.getVisibleCoorport();
        Stack stack = new Stack();
        for (PointValue pointValue : pointValueArr) {
            if (visibleCoorport.contains(pointValue.getCoorX(), pointValue.getCoorY())) {
                PointF pointFScreenToCartesian = this.chartComputator.screenToCartesian(this.chartComputator.computeRawX(pointValue.getCoorX()), this.chartComputator.computeRawY(pointValue.getCoorY()));
                stack.add(new Vector3(pointFScreenToCartesian.x, pointFScreenToCartesian.y, 0.0d));
            }
        }
        Line3D line3D = new Line3D(stack, f, i);
        line3D.setDrawingMode(0);
        line3D.setMaterial(new Material());
        this.chartComputator.getChartRenderer().getCurrentScene().addChild(line3D);
    }

    @Override // com.seeker.luckychart.render.inters.LuckyRenderer
    public void onChartDataChanged() {
    }

    @Override // com.seeker.luckychart.render.inters.LuckyRenderer
    public void onChartSizeChanged() {
    }

    @Override // com.seeker.luckychart.render.inters.LuckyRenderer
    public void onChartlayoutChanged() {
    }

    @Override // com.seeker.luckychart.render.inters.LuckyDataRenderer
    public void onDataRender() {
        PointContainer pointContainer;
        PointValue[] values;
        if (!checkDataAvailable() || (values = (pointContainer = ((ScatterChartData) this.chartProvider.getChartData()).getDataContainer()[0]).getValues()) == null) {
            return;
        }
        drawPoint(values, pointContainer.getPointColor(), pointContainer.getPointRadius());
    }
}
