package com.github.mikephil.charting.listener;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.github.mikephil.charting.charts.Chart;
import defpackage.ww0;

/* JADX INFO: loaded from: classes.dex */
public abstract class ChartTouchListener extends GestureDetector.SimpleOnGestureListener implements View.OnTouchListener {
    protected ChartGesture a = ChartGesture.NONE;
    protected int b = 0;
    protected ww0 c;
    protected GestureDetector d;
    protected Chart e;

    public enum ChartGesture {
        NONE,
        DRAG,
        X_ZOOM,
        Y_ZOOM,
        PINCH_ZOOM,
        ROTATE,
        SINGLE_TAP,
        DOUBLE_TAP,
        LONG_PRESS,
        FLING
    }

    public ChartTouchListener(Chart chart) {
        this.e = chart;
        this.d = new GestureDetector(chart.getContext(), this);
    }

    protected static float a(float f, float f2, float f3, float f4) {
        float f5 = f - f2;
        float f6 = f3 - f4;
        return (float) Math.sqrt((f5 * f5) + (f6 * f6));
    }

    public void b(MotionEvent motionEvent) {
        this.e.getOnChartGestureListener();
    }

    protected void c(ww0 ww0Var, MotionEvent motionEvent) {
        this.e.d(null, true);
    }

    public void d(ww0 ww0Var) {
    }

    public void e(MotionEvent motionEvent) {
        this.e.getOnChartGestureListener();
    }
}
