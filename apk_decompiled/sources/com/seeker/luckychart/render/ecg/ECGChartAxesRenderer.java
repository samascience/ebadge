package com.seeker.luckychart.render.ecg;

import android.graphics.PointF;
import com.seeker.luckychart.charts.ECGChartView;
import com.seeker.luckychart.computator.ChartComputator;
import com.seeker.luckychart.glmodel.ECGLine;
import com.seeker.luckychart.render.inters.LuckyAxesRenderer;
import com.seeker.luckychart.strategy.ecgrender.ECGRenderStrategy;
import java.util.Stack;
import org.rajawali3d.materials.Material;
import org.rajawali3d.math.vector.Vector3;
import org.rajawali3d.scene.Scene;

/* JADX INFO: loaded from: classes.dex */
public class ECGChartAxesRenderer implements LuckyAxesRenderer {
    private ECGChartView chartView;
    private ECGLine innerLine;
    private Stack<Vector3> innerVectors;
    private ECGLine outLine;
    private Stack<Vector3> outVectors;

    private ECGChartAxesRenderer(ECGChartView eCGChartView) {
        this.chartView = eCGChartView;
    }

    public static ECGChartAxesRenderer create(ECGChartView eCGChartView) {
        return new ECGChartAxesRenderer(eCGChartView);
    }

    private void destroyChild() {
        Scene currentScene = this.chartView.getChartGlRenderer().getCurrentScene();
        this.outVectors.clear();
        this.innerVectors.clear();
        this.outLine.destroy();
        this.innerLine.destroy();
        currentScene.removeChild(this.outLine);
        currentScene.removeChild(this.innerLine);
        this.innerVectors = null;
        this.outVectors = null;
        this.innerLine = null;
        this.outLine = null;
    }

    private void drawHCellLine(float f) {
        int i;
        float f2;
        ECGRenderStrategy eCGRenderStrategy = this.chartView.getECGRenderStrategy();
        int yCellCounts = eCGRenderStrategy.getYCellCounts();
        int innerCellCounts = eCGRenderStrategy.getInnerCellCounts();
        float cellWidth = eCGRenderStrategy.getCellWidth();
        ChartComputator chartComputator = this.chartView.getChartComputator();
        float fWidth = chartComputator.getChartContentRect().width();
        int i2 = 0;
        while (i2 < yCellCounts + 1) {
            float f3 = (i2 * cellWidth) + f;
            if (i2 == 0) {
                float outerThinkLineWidth = f3 + (eCGRenderStrategy.getOuterThinkLineWidth() / 2.0f);
                PointF pointFScreenToCartesian = chartComputator.screenToCartesian(0.0f, outerThinkLineWidth);
                i = innerCellCounts;
                f2 = cellWidth;
                this.outVectors.add(new Vector3(pointFScreenToCartesian.x, pointFScreenToCartesian.y, 0.0d));
                PointF pointFScreenToCartesian2 = chartComputator.screenToCartesian(fWidth, outerThinkLineWidth);
                this.outVectors.add(new Vector3(pointFScreenToCartesian2.x, pointFScreenToCartesian2.y, 0.0d));
            } else {
                i = innerCellCounts;
                f2 = cellWidth;
                if (i2 == yCellCounts) {
                    float outerThinkLineWidth2 = f3 - (eCGRenderStrategy.getOuterThinkLineWidth() / 2.0f);
                    PointF pointFScreenToCartesian3 = chartComputator.screenToCartesian(0.0f, outerThinkLineWidth2);
                    this.outVectors.add(new Vector3(pointFScreenToCartesian3.x, pointFScreenToCartesian3.y, 0.0d));
                    PointF pointFScreenToCartesian4 = chartComputator.screenToCartesian(fWidth, outerThinkLineWidth2);
                    this.outVectors.add(new Vector3(pointFScreenToCartesian4.x, pointFScreenToCartesian4.y, 0.0d));
                } else if (i2 % i == 0) {
                    PointF pointFScreenToCartesian5 = chartComputator.screenToCartesian(0.0f, f3);
                    this.outVectors.add(new Vector3(pointFScreenToCartesian5.x, pointFScreenToCartesian5.y, 0.0d));
                    PointF pointFScreenToCartesian6 = chartComputator.screenToCartesian(fWidth, f3);
                    this.outVectors.add(new Vector3(pointFScreenToCartesian6.x, pointFScreenToCartesian6.y, 0.0d));
                } else {
                    PointF pointFScreenToCartesian7 = chartComputator.screenToCartesian(0.0f, f3);
                    this.innerVectors.add(new Vector3(pointFScreenToCartesian7.x, pointFScreenToCartesian7.y, 0.0d));
                    PointF pointFScreenToCartesian8 = chartComputator.screenToCartesian(fWidth, f3);
                    this.innerVectors.add(new Vector3(pointFScreenToCartesian8.x, pointFScreenToCartesian8.y, 0.0d));
                }
            }
            i2++;
            innerCellCounts = i;
            cellWidth = f2;
        }
    }

    private void drawVCellLine(float f, float f2) {
        ECGRenderStrategy eCGRenderStrategy;
        int i;
        ECGRenderStrategy eCGRenderStrategy2 = this.chartView.getECGRenderStrategy();
        int xCellCounts = eCGRenderStrategy2.getXCellCounts();
        int innerCellCounts = eCGRenderStrategy2.getInnerCellCounts();
        float cellWidth = eCGRenderStrategy2.getCellWidth();
        ChartComputator chartComputator = this.chartView.getChartComputator();
        int i2 = 0;
        while (i2 < xCellCounts + 1) {
            float outerThinkLineWidth = i2 * cellWidth;
            if (i2 == 0) {
                float outerThinkLineWidth2 = outerThinkLineWidth + (eCGRenderStrategy2.getOuterThinkLineWidth() / 2.0f);
                PointF pointFScreenToCartesian = chartComputator.screenToCartesian(outerThinkLineWidth2, f);
                eCGRenderStrategy = eCGRenderStrategy2;
                i = xCellCounts;
                this.outVectors.add(new Vector3(pointFScreenToCartesian.x, pointFScreenToCartesian.y, 0.0d));
                PointF pointFScreenToCartesian2 = chartComputator.screenToCartesian(outerThinkLineWidth2, f2);
                this.outVectors.add(new Vector3(pointFScreenToCartesian2.x, pointFScreenToCartesian2.y, 0.0d));
            } else {
                eCGRenderStrategy = eCGRenderStrategy2;
                i = xCellCounts;
                if (i2 % innerCellCounts == 0) {
                    if (i2 == i) {
                        outerThinkLineWidth -= eCGRenderStrategy.getOuterThinkLineWidth() / 2.0f;
                    }
                    PointF pointFScreenToCartesian3 = chartComputator.screenToCartesian(outerThinkLineWidth, f);
                    i = i;
                    this.outVectors.add(new Vector3(pointFScreenToCartesian3.x, pointFScreenToCartesian3.y, 0.0d));
                    PointF pointFScreenToCartesian4 = chartComputator.screenToCartesian(outerThinkLineWidth, f2);
                    this.outVectors.add(new Vector3(pointFScreenToCartesian4.x, pointFScreenToCartesian4.y, 0.0d));
                } else {
                    PointF pointFScreenToCartesian5 = chartComputator.screenToCartesian(outerThinkLineWidth, f);
                    this.innerVectors.add(new Vector3(pointFScreenToCartesian5.x, pointFScreenToCartesian5.y, 0.0d));
                    PointF pointFScreenToCartesian6 = chartComputator.screenToCartesian(outerThinkLineWidth, f2);
                    this.innerVectors.add(new Vector3(pointFScreenToCartesian6.x, pointFScreenToCartesian6.y, 0.0d));
                }
            }
            i2++;
            innerCellCounts = innerCellCounts;
            eCGRenderStrategy2 = eCGRenderStrategy;
            xCellCounts = i;
        }
    }

    @Override // com.seeker.luckychart.render.inters.LuckyAxesRenderer
    public void drawInBackground() {
        ECGRenderStrategy eCGRenderStrategy = this.chartView.getECGRenderStrategy();
        int ecgLineCount = eCGRenderStrategy.getEcgLineCount();
        float ecgPortSpace = eCGRenderStrategy.getEcgPortSpace();
        float singleEcgChartHeight = this.chartView.getChartComputator().getSingleEcgChartHeight();
        for (int i = 0; i < ecgLineCount; i++) {
            float f = (ecgPortSpace + singleEcgChartHeight) * i;
            drawHCellLine(f);
            drawVCellLine(f, (eCGRenderStrategy.getYCellCounts() * eCGRenderStrategy.getCellWidth()) + f);
        }
        this.outLine.setPoints(this.outVectors);
        this.innerLine.setPoints(this.innerVectors);
        this.chartView.getChartGlRenderer().getCurrentScene().addChild(this.innerLine.init());
        this.chartView.getChartGlRenderer().getCurrentScene().addChild(this.outLine.init());
    }

    @Override // com.seeker.luckychart.render.inters.LuckyAxesRenderer
    public void drawInForeground() {
    }

    @Override // com.seeker.luckychart.render.inters.LuckyRenderer
    public void initScene() {
        ECGLine eCGLineCreate = ECGLine.create(1);
        this.outLine = eCGLineCreate;
        eCGLineCreate.setLineThickness(this.chartView.getECGRenderStrategy().getOuterThinkLineWidth());
        this.outLine.setColor(this.chartView.getECGRenderStrategy().getOuterColor());
        this.outLine.setMaterial(new Material());
        this.outVectors = new Stack<>();
        ECGLine eCGLineCreate2 = ECGLine.create(1);
        this.innerLine = eCGLineCreate2;
        eCGLineCreate2.setLineThickness(this.chartView.getECGRenderStrategy().getInnerThinkLineWidth());
        this.innerLine.setColor(this.chartView.getECGRenderStrategy().getInnerColor());
        this.innerLine.setMaterial(new Material());
        this.innerVectors = new Stack<>();
    }

    @Override // com.seeker.luckychart.render.inters.LuckyRenderer
    public void onChartDataChanged() {
    }

    @Override // com.seeker.luckychart.render.inters.LuckyRenderer
    public void onChartSizeChanged() {
        destroyChild();
        initScene();
        drawInBackground();
    }

    @Override // com.seeker.luckychart.render.inters.LuckyRenderer
    public void onChartlayoutChanged() {
        destroyChild();
        initScene();
        drawInBackground();
    }
}
