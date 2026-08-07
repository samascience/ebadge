package com.seeker.luckychart.gesture;

import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import com.seeker.luckychart.provider.ChartProvider;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractTouchHandler {
    private static final int SCROLL_CHILD = 3;
    private static final int SCROLL_IDLE = 0;
    private static final int SCROLL_PARENT = 2;
    private static final int SCROLL_PREPARE = 1;
    protected ChartGestureHelper chartGestureHelper;
    protected float mLastTouchX;
    protected float mLastTouchY;
    private int mTouchSlop;
    private int scrollType = 0;

    public AbstractTouchHandler(ChartProvider chartProvider) {
        this.mTouchSlop = ViewConfiguration.get(chartProvider.getContexter()).getScaledTouchSlop();
        this.chartGestureHelper = new ChartGestureHelper(chartProvider);
    }

    protected void allowParentInterceptTouchEvent(ViewParent viewParent, boolean z) {
        if (viewParent != null) {
            viewParent.requestDisallowInterceptTouchEvent(z);
        }
    }

    public boolean canScroll() {
        int i = this.scrollType;
        return (2 == i || 1 == i) ? false : true;
    }

    public abstract boolean computeScroll();

    public void dispatchTouchEvent(MotionEvent motionEvent, ViewParent viewParent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.scrollType = 1;
            this.mLastTouchX = x;
            this.mLastTouchY = y;
            return;
        }
        if (actionMasked != 2) {
            if (actionMasked != 3) {
                allowParentInterceptTouchEvent(viewParent, false);
            }
        } else if (1 == this.scrollType) {
            float fAbs = Math.abs(x - this.mLastTouchX);
            float fAbs2 = Math.abs(y - this.mLastTouchY);
            if (fAbs > fAbs2 && Math.abs(fAbs) > this.mTouchSlop) {
                this.scrollType = 3;
                allowParentInterceptTouchEvent(viewParent, true);
            } else {
                if (fAbs >= fAbs2 || Math.abs(fAbs) <= this.mTouchSlop) {
                    return;
                }
                this.scrollType = 2;
                allowParentInterceptTouchEvent(viewParent, false);
            }
        }
    }

    public abstract boolean handleTouchEvent(MotionEvent motionEvent, ViewParent viewParent);
}
