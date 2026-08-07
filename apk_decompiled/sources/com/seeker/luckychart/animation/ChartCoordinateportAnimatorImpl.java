package com.seeker.luckychart.animation;

import android.animation.Animator;
import android.animation.ValueAnimator;
import com.seeker.luckychart.model.Coordinateport;
import com.seeker.luckychart.provider.ChartProvider;

/* JADX INFO: loaded from: classes.dex */
public class ChartCoordinateportAnimatorImpl implements ChartCoordinateportAnimator, ValueAnimator.AnimatorUpdateListener, Animator.AnimatorListener {
    private ChartAnimationListener animationListener;
    private ValueAnimator animator;
    private final ChartProvider chartProvider;
    private Coordinateport startport = new Coordinateport();
    private Coordinateport targetport = new Coordinateport();
    private Coordinateport newport = new Coordinateport();

    private ChartCoordinateportAnimatorImpl(ChartProvider chartProvider) {
        this.chartProvider = chartProvider;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.animator = valueAnimatorOfFloat;
        valueAnimatorOfFloat.addListener(this);
        this.animator.addUpdateListener(this);
        this.animator.setDuration(300L);
    }

    public static ChartCoordinateportAnimatorImpl create(ChartProvider chartProvider) {
        return new ChartCoordinateportAnimatorImpl(chartProvider);
    }

    @Override // com.seeker.luckychart.animation.ChartCoordinateportAnimator
    public void cancelAnimation() {
        this.animator.cancel();
    }

    @Override // com.seeker.luckychart.animation.ChartCoordinateportAnimator
    public boolean isAnimationStarted() {
        return this.animator.isStarted();
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.chartProvider.setChartVisibleCoordinateport(this.targetport);
        ChartAnimationListener chartAnimationListener = this.animationListener;
        if (chartAnimationListener != null) {
            chartAnimationListener.onAnimationFinished();
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        ChartAnimationListener chartAnimationListener = this.animationListener;
        if (chartAnimationListener != null) {
            chartAnimationListener.onAnimationStarted();
        }
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float animatedFraction = valueAnimator.getAnimatedFraction();
        Coordinateport coordinateport = this.targetport;
        float f = coordinateport.left;
        Coordinateport coordinateport2 = this.startport;
        float f2 = coordinateport2.left;
        float f3 = coordinateport.top;
        float f4 = coordinateport2.top;
        float f5 = coordinateport.right;
        float f6 = coordinateport2.right;
        float f7 = coordinateport.bottom;
        float f8 = coordinateport2.bottom;
        this.newport.set(f2 + ((f - f2) * animatedFraction), f4 + ((f3 - f4) * animatedFraction), f6 + ((f5 - f6) * animatedFraction), f8 + ((f7 - f8) * animatedFraction));
        this.chartProvider.setChartVisibleCoordinateport(this.newport);
    }

    @Override // com.seeker.luckychart.animation.ChartCoordinateportAnimator
    public void setChartAnimationListener(ChartAnimationListener chartAnimationListener) {
        this.animationListener = chartAnimationListener;
    }

    @Override // com.seeker.luckychart.animation.ChartCoordinateportAnimator
    public void startAnimation(Coordinateport coordinateport, Coordinateport coordinateport2, long j) {
        this.startport.set(coordinateport);
        this.targetport.set(coordinateport2);
        this.animator.setDuration(j);
        this.animator.start();
    }
}
