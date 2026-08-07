package com.seeker.luckychart.gesture;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.OverScroller;
import com.seeker.luckychart.computator.ChartComputator;
import com.seeker.luckychart.model.Coordinateport;
import com.seeker.luckychart.provider.ChartProvider;
import com.seeker.luckychart.strategy.doubletab.DoubleTap;
import com.seeker.luckychart.strategy.press.LongPress;
import com.seeker.luckychart.strategy.scale.Scaler;
import com.seeker.luckychart.strategy.scroll.ScrollResult;
import com.seeker.luckychart.strategy.scroll.Scroller;

/* JADX INFO: loaded from: classes.dex */
public class ChartGestureHelper {
    private static final int GESTURE_DOUBLETAB = 1;
    private static final int GESTURE_LONGPRESS = 2;
    private static final int GESTURE_NONE = -1;
    private static final int GESTURE_SCROLL = 0;
    private ChartComputator chartComputator;
    private ChartProvider chartProvider;
    private OverScroller scroller;
    private ScrollResult scrollResult = new ScrollResult();
    private Point surfaceSizeBuffer = new Point();
    private int gestureMode = -1;
    private Coordinateport scrollPort = new Coordinateport();

    ChartGestureHelper(ChartProvider chartProvider) {
        this.chartProvider = chartProvider;
        this.chartComputator = chartProvider.getChartComputator();
        this.scroller = new OverScroller(chartProvider.getContexter());
    }

    public boolean computeScrollOffset() {
        if (!this.scroller.computeScrollOffset()) {
            return false;
        }
        Coordinateport maxCoorport = this.chartComputator.getMaxCoorport();
        this.chartComputator.computeScrollSurfaceSize(this.surfaceSizeBuffer);
        this.chartComputator.setViewportTopLeft(maxCoorport.left + ((maxCoorport.width() * this.scroller.getCurrX()) / this.surfaceSizeBuffer.x), maxCoorport.top - ((maxCoorport.height() * this.scroller.getCurrY()) / this.surfaceSizeBuffer.y));
        return true;
    }

    public boolean doubleTap(MotionEvent motionEvent) {
        this.gestureMode = 1;
        DoubleTap doubleTab = this.chartProvider.getDoubleTab();
        return doubleTab != null && doubleTab.doubleTap(motionEvent);
    }

    public void longPressed(MotionEvent motionEvent) {
        this.gestureMode = 2;
        LongPress longpresser = this.chartProvider.getLongpresser();
        if (longpresser != null) {
            longpresser.longPressed(motionEvent);
        }
    }

    public void onUp(MotionEvent motionEvent) {
        LongPress longpresser;
        if (this.gestureMode == 2 && (longpresser = this.chartProvider.getLongpresser()) != null) {
            longpresser.finish(motionEvent);
        }
    }

    public boolean prepareWithDownAction() {
        if (!this.scroller.isFinished()) {
            this.scroller.abortAnimation();
        }
        this.scrollPort.set(this.chartComputator.getVisibleCoorport());
        this.gestureMode = -1;
        return true;
    }

    public boolean scale(ScaleGestureDetector scaleGestureDetector) {
        Scaler scaler = this.chartProvider.getScaler();
        return scaler != null && scaler.scale(scaleGestureDetector);
    }

    public ScrollResult scroll(float f, float f2, float f3, float f4) {
        this.gestureMode = 0;
        Scroller scrollImpl = this.chartProvider.getScrollImpl();
        return scrollImpl == null ? this.scrollResult : scrollImpl.scroll(f, f2, f3, f4);
    }
}
