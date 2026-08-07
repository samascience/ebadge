package com.seeker.luckychart.gesture;

import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ViewParent;
import com.seeker.luckychart.provider.ChartProvider;

/* JADX INFO: loaded from: classes.dex */
public class ChartTouchHandler extends AbstractTouchHandler {
    private boolean canAnswerScroll;
    private ChartGestureDetector gestureDetector;
    private ScaleGestureDetector scaleGestureDetector;

    private class ChartGestureListener extends ChartGestureDetector.ChartSimpleOnGestureListener {
        ChartGestureListener() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            return ChartTouchHandler.this.chartGestureHelper.doubleTap(motionEvent);
        }

        @Override // com.seeker.luckychart.gesture.ChartGestureDetector.ChartSimpleOnGestureListener, android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            super.onDown(motionEvent);
            return ChartTouchHandler.this.chartGestureHelper.prepareWithDownAction();
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            ChartTouchHandler.this.chartGestureHelper.longPressed(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return ChartTouchHandler.this.canAnswerScroll && ChartTouchHandler.this.chartGestureHelper.scroll(motionEvent2.getX(), motionEvent2.getY(), f, f2).canScroll && ChartTouchHandler.this.canScroll();
        }

        @Override // com.seeker.luckychart.gesture.ChartGestureDetector.ChartSimpleOnGestureListener
        public void onUpWithoutFling(MotionEvent motionEvent) {
            ChartTouchHandler.this.chartGestureHelper.onUp(motionEvent);
        }
    }

    private class ChartScaleGestureListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private ChartScaleGestureListener() {
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            return ChartTouchHandler.this.chartGestureHelper.scale(scaleGestureDetector);
        }
    }

    public ChartTouchHandler(ChartProvider chartProvider) {
        super(chartProvider);
        this.canAnswerScroll = true;
        this.gestureDetector = new ChartGestureDetector(chartProvider.getContexter(), new ChartGestureListener());
        this.scaleGestureDetector = new ScaleGestureDetector(chartProvider.getContexter(), new ChartScaleGestureListener());
    }

    @Override // com.seeker.luckychart.gesture.AbstractTouchHandler
    public boolean computeScroll() {
        return this.chartGestureHelper.computeScrollOffset();
    }

    @Override // com.seeker.luckychart.gesture.AbstractTouchHandler
    public boolean handleTouchEvent(MotionEvent motionEvent, ViewParent viewParent) {
        int action = motionEvent.getAction() & 255;
        if (action == 5) {
            this.canAnswerScroll = false;
        } else if (action == 0) {
            this.canAnswerScroll = true;
        }
        boolean z = this.scaleGestureDetector.onTouchEvent(motionEvent) || this.gestureDetector.onTouchEvent(motionEvent);
        if (this.scaleGestureDetector.isInProgress()) {
            allowParentInterceptTouchEvent(viewParent, true);
        }
        return z;
    }
}
