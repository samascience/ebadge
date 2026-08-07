package com.seeker.luckychart.gesture;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;

/* JADX INFO: loaded from: classes.dex */
public class ChartGestureDetector extends GestureDetector {
    private OnGestureUpListener upListener;

    public static class ChartSimpleOnGestureListener extends GestureDetector.SimpleOnGestureListener implements OnGestureUpListener {
        private boolean isFling = false;

        @Override // com.seeker.luckychart.gesture.ChartGestureDetector.OnGestureUpListener
        public void onActionUp(MotionEvent motionEvent) {
            if (this.isFling) {
                return;
            }
            onUpWithoutFling(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            this.isFling = false;
            return super.onDown(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            this.isFling = true;
            return super.onFling(motionEvent, motionEvent2, f, f2);
        }

        public void onUpWithoutFling(MotionEvent motionEvent) {
        }
    }

    public interface OnGestureUpListener {
        void onActionUp(MotionEvent motionEvent);
    }

    public ChartGestureDetector(Context context, ChartSimpleOnGestureListener chartSimpleOnGestureListener) {
        super(context, chartSimpleOnGestureListener);
        this.upListener = chartSimpleOnGestureListener;
    }

    @Override // android.view.GestureDetector
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
        if (this.upListener != null && motionEvent.getAction() == 1) {
            this.upListener.onActionUp(motionEvent);
        }
        return zOnTouchEvent;
    }

    public ChartGestureDetector(Context context, ChartSimpleOnGestureListener chartSimpleOnGestureListener, Handler handler) {
        super(context, chartSimpleOnGestureListener, handler);
        this.upListener = chartSimpleOnGestureListener;
    }

    public ChartGestureDetector(Context context, ChartSimpleOnGestureListener chartSimpleOnGestureListener, Handler handler, boolean z) {
        super(context, chartSimpleOnGestureListener, handler, z);
        this.upListener = chartSimpleOnGestureListener;
    }
}
