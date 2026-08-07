package com.seeker.luckychart.strategy.scale;

import android.graphics.PointF;
import android.view.ScaleGestureDetector;
import com.seeker.luckychart.computator.ChartComputator;
import com.seeker.luckychart.provider.ChartProvider;

/* JADX INFO: loaded from: classes.dex */
public class DefaultScaler implements Scaler {
    private ChartComputator chartComputator;
    private PointF viewportFocus = new PointF();

    private DefaultScaler(ChartProvider chartProvider) {
        this.chartComputator = chartProvider.getChartComputator();
    }

    public static DefaultScaler create(ChartProvider chartProvider) {
        return new DefaultScaler(chartProvider);
    }

    @Override // com.seeker.luckychart.strategy.scale.Scaler
    public boolean scale(ScaleGestureDetector scaleGestureDetector) {
        float focusX = scaleGestureDetector.getFocusX();
        float focusY = scaleGestureDetector.getFocusY();
        if (!this.chartComputator.computeVitual(focusX, focusY, this.viewportFocus)) {
            return false;
        }
        float scaleFactor = 2.0f - scaleGestureDetector.getScaleFactor();
        if (Float.isInfinite(scaleFactor)) {
            scaleFactor = 1.0f;
        }
        float fWidth = this.chartComputator.getVisibleCoorport().width() * scaleFactor;
        float fHeight = this.chartComputator.getVisibleCoorport().height() * scaleFactor;
        float fWidth2 = this.viewportFocus.x - ((focusX - this.chartComputator.getDataContentRect().left) * (fWidth / this.chartComputator.getDataContentRect().width()));
        float fHeight2 = this.viewportFocus.y + ((focusY - this.chartComputator.getDataContentRect().top) * (fHeight / this.chartComputator.getDataContentRect().height()));
        this.chartComputator.setVisibleCoorport(fWidth2, fHeight2, fWidth + fWidth2, fHeight2 - fHeight);
        return true;
    }
}
