package com.seeker.luckychart.computator;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import com.seeker.luckychart.charts.AbstractChartView;
import com.seeker.luckychart.model.Coordinateport;
import com.seeker.luckychart.strategy.ecgrender.ECGRenderStrategy;
import org.rajawali3d.cameras.Camera2D;

/* JADX INFO: loaded from: classes.dex */
public final class ChartComputator {
    protected static final float DEFAULT_MAXIMUM_ZOOM = 20.0f;
    private AbstractChartView.LuckyChartRenderer chartRenderer;
    private int deviceMin;
    private float mDensity;
    private float mScaledDensity;
    private float minViewportHeight;
    private float minViewportWidth;
    private ECGRenderStrategy renderStrategy;
    private int chartWidth = -1;
    private int chartHeight = -1;
    private Rect chartContentRect = new Rect();
    private Rect dataContentRect = new Rect();
    private Coordinateport maxCoorport = new Coordinateport();
    private Coordinateport visibleCoorport = new Coordinateport();
    private float maxZoom = DEFAULT_MAXIMUM_ZOOM;
    private final PointF pointF = new PointF();

    private ChartComputator(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.mDensity = displayMetrics.density;
        this.mScaledDensity = displayMetrics.scaledDensity;
        this.deviceMin = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
    }

    private void computeMinimumWidthAndHeight() {
        this.minViewportWidth = this.maxCoorport.width() / this.maxZoom;
        this.minViewportHeight = this.maxCoorport.height() / this.maxZoom;
    }

    private void constrainViewport(float f, float f2, float f3, float f4) {
        float f5 = f3 - f;
        float f6 = this.minViewportWidth;
        if (f5 < f6) {
            f3 = f + f6;
            Coordinateport coordinateport = this.maxCoorport;
            float f7 = coordinateport.left;
            if (f < f7) {
                f3 = f7 + f6;
                f = f7;
            } else {
                float f8 = coordinateport.right;
                if (f3 > f8) {
                    f = f8 - f6;
                    f3 = f8;
                }
            }
        }
        float f9 = f2 - f4;
        float f10 = this.minViewportHeight;
        if (f9 < f10) {
            f4 = f2 - f10;
            Coordinateport coordinateport2 = this.maxCoorport;
            float f11 = coordinateport2.top;
            if (f2 > f11) {
                f4 = f11 - f10;
                f2 = f11;
            } else {
                float f12 = coordinateport2.bottom;
                if (f4 < f12) {
                    f2 = f12 + f10;
                    f4 = f12;
                }
            }
        }
        this.visibleCoorport.left = Math.max(this.maxCoorport.left, f);
        this.visibleCoorport.top = Math.min(this.maxCoorport.top, f2);
        this.visibleCoorport.right = Math.min(this.maxCoorport.right, f3);
        this.visibleCoorport.bottom = Math.max(this.maxCoorport.bottom, f4);
    }

    public static ChartComputator create(Context context) {
        return new ChartComputator(context);
    }

    public final float computeECGRawY(float f, float f2) {
        float singleEcgChartHeight = getSingleEcgChartHeight();
        Coordinateport coordinateport = this.visibleCoorport;
        return f2 - ((f - coordinateport.bottom) * (singleEcgChartHeight / coordinateport.height()));
    }

    public final float computeRawX(float f) {
        return this.dataContentRect.left + ((f - this.visibleCoorport.left) * (this.dataContentRect.width() / this.visibleCoorport.width()));
    }

    public final float computeRawY(float f) {
        return this.dataContentRect.bottom - ((f - this.visibleCoorport.bottom) * (this.dataContentRect.height() / this.visibleCoorport.height()));
    }

    public void computeScrollSurfaceSize(Point point) {
        point.set((int) ((this.maxCoorport.width() * this.dataContentRect.width()) / this.visibleCoorport.width()), (int) ((this.maxCoorport.height() * this.dataContentRect.height()) / this.visibleCoorport.height()));
    }

    public boolean computeVitual(float f, float f2, PointF pointF) {
        if (!this.dataContentRect.contains((int) f, (int) f2)) {
            return false;
        }
        Coordinateport coordinateport = this.visibleCoorport;
        float fWidth = coordinateport.left + (((f - this.dataContentRect.left) * coordinateport.width()) / this.dataContentRect.width());
        Coordinateport coordinateport2 = this.visibleCoorport;
        pointF.set(fWidth, coordinateport2.bottom + (((f2 - this.dataContentRect.bottom) * coordinateport2.height()) / (-this.dataContentRect.height())));
        return true;
    }

    public void gain(float f, float f2) {
        Coordinateport coordinateport = this.visibleCoorport;
        coordinateport.top = f;
        coordinateport.bottom = f2;
        Coordinateport coordinateport2 = this.maxCoorport;
        coordinateport2.top = f;
        coordinateport2.bottom = f2;
    }

    public Rect getChartContentRect() {
        return this.chartContentRect;
    }

    public int getChartHeight() {
        return this.chartHeight;
    }

    public AbstractChartView.LuckyChartRenderer getChartRenderer() {
        return this.chartRenderer;
    }

    public int getChartWidth() {
        return this.chartWidth;
    }

    public Rect getDataContentRect() {
        return this.dataContentRect;
    }

    public float getDensity() {
        return this.mDensity;
    }

    public int getDeviceMin() {
        return this.deviceMin;
    }

    public Coordinateport getMaxCoorport() {
        return this.maxCoorport;
    }

    public float getMinViewportHeight() {
        return this.minViewportHeight;
    }

    public float getMinViewportWidth() {
        return this.minViewportWidth;
    }

    public float getScaledDensity() {
        return this.mScaledDensity;
    }

    public float getSingleEcgChartHeight() {
        float fHeight = getChartContentRect().height();
        float ecgPortSpace = this.renderStrategy.getEcgPortSpace();
        int ecgLineCount = this.renderStrategy.getEcgLineCount();
        return (fHeight - (ecgPortSpace * (ecgLineCount - 1))) / ecgLineCount;
    }

    public Coordinateport getVisibleCoorport() {
        return this.visibleCoorport;
    }

    public void insetContentRect(int i, int i2, int i3, int i4) {
        Rect rect = this.dataContentRect;
        rect.left += i;
        rect.top += i2;
        rect.right -= i3;
        rect.bottom -= i4;
    }

    public boolean onChartSizeChanged(int i, int i2) {
        return (this.chartWidth == i && this.chartHeight == i2) ? false : true;
    }

    public void scale(Coordinateport coordinateport) {
        float fCenterX = this.visibleCoorport.centerX();
        float fWidth = coordinateport.width() / 2.0f;
        this.visibleCoorport.set(Math.max(fCenterX - fWidth, 0.0f), coordinateport.top, Math.min(fCenterX + fWidth, this.maxCoorport.right), coordinateport.bottom);
        Coordinateport coordinateport2 = this.maxCoorport;
        coordinateport2.top = coordinateport.top;
        coordinateport2.bottom = coordinateport.bottom;
    }

    public final PointF screenToCartesian(float f, float f2) {
        Camera2D camera2D = this.chartRenderer.getCamera2D();
        float width = (float) camera2D.getWidth();
        float height = (float) camera2D.getHeight();
        this.pointF.x = ((f / this.chartRenderer.getViewportWidth()) * width) - (width / 2.0f);
        this.pointF.y = (((this.chartRenderer.getViewportHeight() - f2) / this.chartRenderer.getViewportHeight()) * height) - (height / 2.0f);
        return this.pointF;
    }

    public void setChartFactSize(int i, int i2) {
        this.chartWidth = i;
        this.chartHeight = i2;
        this.chartContentRect.set(0, 0, i, i2);
        this.dataContentRect.set(this.chartContentRect);
    }

    public void setChartRenderer(AbstractChartView.LuckyChartRenderer luckyChartRenderer) {
        this.chartRenderer = luckyChartRenderer;
    }

    public void setMaxCoorport(Coordinateport coordinateport) {
        this.maxCoorport.set(coordinateport);
        computeMinimumWidthAndHeight();
    }

    public void setProgress(float f) {
        float fWidth = (this.maxCoorport.width() - this.visibleCoorport.width()) * f;
        this.visibleCoorport.width();
        setViewportTopLeft(fWidth, this.visibleCoorport.top);
    }

    public void setRenderStrategy(ECGRenderStrategy eCGRenderStrategy) {
        this.renderStrategy = eCGRenderStrategy;
    }

    public void setViewportTopLeft(float f, float f2) {
        float fWidth = this.visibleCoorport.width();
        float fHeight = this.visibleCoorport.height();
        Coordinateport coordinateport = this.maxCoorport;
        float fMax = Math.max(coordinateport.left, Math.min(f, coordinateport.right - fWidth));
        Coordinateport coordinateport2 = this.maxCoorport;
        float fMax2 = Math.max(coordinateport2.bottom + fHeight, Math.min(f2, coordinateport2.top));
        constrainViewport(fMax, fMax2, fWidth + fMax, fMax2 - fHeight);
    }

    public void setVisibleCoorport(Coordinateport coordinateport) {
        this.visibleCoorport.set(coordinateport);
    }

    public void setVisibleCoorport(float f, float f2, float f3, float f4) {
        constrainViewport(f, f2, f3, f4);
    }
}
