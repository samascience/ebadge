package com.seeker.luckychart.animation;

import com.seeker.luckychart.model.Coordinateport;

/* JADX INFO: loaded from: classes.dex */
public interface ChartCoordinateportAnimator {
    public static final int FAST_ANIMATION_DURATION = 300;

    void cancelAnimation();

    boolean isAnimationStarted();

    void setChartAnimationListener(ChartAnimationListener chartAnimationListener);

    void startAnimation(Coordinateport coordinateport, Coordinateport coordinateport2, long j);
}
