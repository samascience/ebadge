package com.seeker.luckychart.charts;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import com.seeker.luckychart.R;
import com.seeker.luckychart.computator.ECGRealtimeComputator;
import com.seeker.luckychart.model.Coordinateport;
import com.seeker.luckychart.model.ECGPointValue;
import com.seeker.luckychart.model.chartdata.ECGChartData;
import com.seeker.luckychart.model.container.ECGPointContainer;
import com.seeker.luckychart.render.ecg.ECGChartAxesRenderer;
import com.seeker.luckychart.render.ecg.ECGChartDataRender;
import com.seeker.luckychart.render.inters.LuckyAxesRenderer;
import com.seeker.luckychart.render.inters.LuckyDataRenderer;
import com.seeker.luckychart.strategy.ECGStrategyFactory;
import com.seeker.luckychart.strategy.doubletab.DoubleTap;
import com.seeker.luckychart.strategy.ecgrender.ECGRenderStrategy;
import com.seeker.luckychart.strategy.press.LongPress;
import com.seeker.luckychart.strategy.scale.Scaler;
import com.seeker.luckychart.strategy.scroll.Scroller;

/* JADX INFO: loaded from: classes.dex */
public class ECGChartView extends AbstractChartView<ECGChartData> implements RealTime {
    private Boolean canScaleOrGain;
    private Coordinateport defaultCoordinateport;
    private ECGStrategyFactory gestureFactory;
    private int[] measureResult;
    private ECGRealtimeComputator realtimeComputator;
    private ECGRenderStrategy renderStrategy;
    private OnVisibleCoorPortChangedListener visibleCoorPortChangedListener;

    public interface OnVisibleCoorPortChangedListener {
        void onChanged(Coordinateport coordinateport, Coordinateport coordinateport2);
    }

    public ECGChartView(Context context) {
        this(context, null);
    }

    private void applyAttributes(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ECGChartView);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i);
            if (index == R.styleable.ECGChartView_isTouchable) {
                setTouchable(typedArrayObtainStyledAttributes.getBoolean(index, false));
            } else if (index == R.styleable.ECGChartView_yOuterCellCounts) {
                this.renderStrategy.setYOuterCellCounts(typedArrayObtainStyledAttributes.getInt(index, 8));
            } else if (index == R.styleable.ECGChartView_ecgLineCount) {
                this.renderStrategy.setEcgLineCount(typedArrayObtainStyledAttributes.getInt(index, 1));
            } else if (index == R.styleable.ECGChartView_ecgportSpace) {
                this.renderStrategy.setEcgPortSpace(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 30));
            } else if (index == R.styleable.ECGChartView_markTextStyle) {
                this.renderStrategy.setMarkTextStyle(typedArrayObtainStyledAttributes.getString(index));
            } else if (index == R.styleable.ECGChartView_canLineBound) {
                this.renderStrategy.setCanLineBound(typedArrayObtainStyledAttributes.getBoolean(index, false));
            } else if (index == R.styleable.ECGChartView_ecgOuterColor) {
                this.renderStrategy.setOutColor(typedArrayObtainStyledAttributes.getColor(index, Color.parseColor("#FF434141")));
            } else if (index == R.styleable.ECGChartView_ecgInnerColor) {
                this.renderStrategy.setInnerColor(typedArrayObtainStyledAttributes.getColor(index, 0));
            } else if (index == R.styleable.ECGChartView_ecgBackgroundColor) {
                this.backgroundColor = typedArrayObtainStyledAttributes.getColor(index, Color.parseColor("#1C1B21"));
                getChartGlRenderer().getCurrentScene().setBackgroundColor(this.backgroundColor);
            } else if (index == R.styleable.ECGChartView_ecgDrawColor) {
                ECGRealtimeComputator.drawLineColor = typedArrayObtainStyledAttributes.getColor(index, -1);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    private void layoutChanged() {
        LuckyAxesRenderer luckyAxesRenderer = this.axesRenderer;
        if (luckyAxesRenderer != null) {
            luckyAxesRenderer.onChartlayoutChanged();
        }
        LuckyDataRenderer luckyDataRenderer = this.dataRenderer;
        if (luckyDataRenderer != null) {
            luckyDataRenderer.onChartlayoutChanged();
        }
        applyRenderUpdate();
    }

    @Override // com.seeker.luckychart.charts.AbstractChartView
    public void applyRenderUpdate() {
        synchronized (this.canScaleOrGain) {
            try {
                if (this.canScaleOrGain.booleanValue()) {
                    this.canScaleOrGain = Boolean.FALSE;
                    super.applyRenderUpdate();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void gainDown() {
        synchronized (this.canScaleOrGain) {
            try {
                if (this.canScaleOrGain.booleanValue()) {
                    ECGRenderStrategy eCGRenderStrategy = this.renderStrategy;
                    if (eCGRenderStrategy.gain(eCGRenderStrategy.getYCellCountsPerMv() - 1)) {
                        this.chartComputator.gain(this.renderStrategy.getYMaxMvs() / 2.0f, (-this.renderStrategy.getYMaxMvs()) / 2.0f);
                        layoutChanged();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void gainUp() {
        synchronized (this.canScaleOrGain) {
            try {
                if (this.canScaleOrGain.booleanValue()) {
                    ECGRenderStrategy eCGRenderStrategy = this.renderStrategy;
                    if (eCGRenderStrategy.gain(eCGRenderStrategy.getYCellCountsPerMv() + 1)) {
                        this.chartComputator.gain(this.renderStrategy.getYMaxMvs() / 2.0f, (-this.renderStrategy.getYMaxMvs()) / 2.0f);
                        layoutChanged();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.seeker.luckychart.charts.AbstractChartView, com.seeker.luckychart.provider.GestureProvider
    public DoubleTap getDoubleTab() {
        return this.gestureFactory.getDoubleTab();
    }

    public ECGRenderStrategy getECGRenderStrategy() {
        return this.renderStrategy;
    }

    @Override // com.seeker.luckychart.charts.AbstractChartView, com.seeker.luckychart.provider.GestureProvider
    public LongPress getLongpresser() {
        return this.gestureFactory.getLongpresser();
    }

    @Override // com.seeker.luckychart.charts.AbstractChartView, com.seeker.luckychart.provider.GestureProvider
    public Scaler getScaler() {
        return this.gestureFactory.getScaler();
    }

    @Override // com.seeker.luckychart.charts.AbstractChartView, com.seeker.luckychart.provider.GestureProvider
    public Scroller getScrollImpl() {
        return this.gestureFactory.getScrollImpl();
    }

    @Override // com.seeker.luckychart.provider.ChartProvider
    public ECGChartView getSelf() {
        return this;
    }

    public void initDefaultChartData(final boolean z, final boolean z2) {
        post(new Runnable() { // from class: com.seeker.luckychart.charts.ECGChartView.1
            @Override // java.lang.Runnable
            public void run() {
                ECGChartView.this.realtimeComputator.setPlotMaxPointCount(ECGChartView.this.renderStrategy.getXTotalPointCounts());
                ECGChartView eCGChartView = ECGChartView.this;
                eCGChartView.setChartData(eCGChartView.realtimeComputator.getDefaultChartData());
                ECGChartView.this.realtimeComputator.setDrawRPeak(z);
                ECGChartView.this.realtimeComputator.setDrawNoise(z2);
            }
        });
    }

    @Override // com.seeker.luckychart.charts.AbstractChartView
    public void onAsyRenderUpdateLagWork() {
        if (this.visibleCoorPortChangedListener != null) {
            this.visibleCoorPortChangedListener.onChanged(this.chartComputator.getVisibleCoorport(), this.chartComputator.getMaxCoorport());
        }
        synchronized (this.canScaleOrGain) {
            this.canScaleOrGain = Boolean.TRUE;
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        ECGRenderStrategy eCGRenderStrategy = this.renderStrategy;
        eCGRenderStrategy.onViewMeasured(measuredWidth, getMeasuredHeight(), this.measureResult);
        int ecgLineCount = eCGRenderStrategy.getEcgLineCount();
        int[] iArr = this.measureResult;
        setMeasuredDimension(iArr[0], (int) ((iArr[1] * ecgLineCount) + ((ecgLineCount - 1) * eCGRenderStrategy.getEcgPortSpace())));
        this.defaultCoordinateport.set(0.0f, eCGRenderStrategy.getYMaxMvs() / 2.0f, eCGRenderStrategy.getXTotalPointCounts(), (-eCGRenderStrategy.getYMaxMvs()) / 2.0f);
        setChartVisibleCoordinateport(this.defaultCoordinateport);
        setChartMaxCoordinateport(this.defaultCoordinateport);
    }

    @Override // com.seeker.luckychart.charts.RealTime
    @Deprecated
    public void repairPointRPeak(int i, int i2, String str, boolean z) {
    }

    public void reset() {
        this.realtimeComputator.reset();
    }

    public void scaleDown() {
        synchronized (this.canScaleOrGain) {
            try {
                if (this.canScaleOrGain.booleanValue()) {
                    ECGRenderStrategy eCGRenderStrategy = this.renderStrategy;
                    if (eCGRenderStrategy.scale(eCGRenderStrategy.getYOuterCellCount() + 2)) {
                        this.defaultCoordinateport.set(0.0f, this.renderStrategy.getYMaxMvs() / 2.0f, this.renderStrategy.getXTotalPointCounts(), (-this.renderStrategy.getYMaxMvs()) / 2.0f);
                        this.chartComputator.scale(this.defaultCoordinateport);
                        layoutChanged();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void scaleUp() {
        synchronized (this.canScaleOrGain) {
            try {
                if (this.canScaleOrGain.booleanValue()) {
                    ECGRenderStrategy eCGRenderStrategy = this.renderStrategy;
                    if (eCGRenderStrategy.scale(eCGRenderStrategy.getYOuterCellCount() - 2)) {
                        this.defaultCoordinateport.set(0.0f, this.renderStrategy.getYMaxMvs() / 2.0f, this.renderStrategy.getXTotalPointCounts(), (-this.renderStrategy.getYMaxMvs()) / 2.0f);
                        this.chartComputator.scale(this.defaultCoordinateport);
                        layoutChanged();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setDrawNoise(boolean z) {
        this.realtimeComputator.setDrawNoise(z);
    }

    public void setDrawRPeak(boolean z) {
        this.realtimeComputator.setDrawRPeak(z);
    }

    public void setMode(int i) {
        this.realtimeComputator.setMode(i);
    }

    public void setOnVisibleCoorPortChangedListener(OnVisibleCoorPortChangedListener onVisibleCoorPortChangedListener) {
        this.visibleCoorPortChangedListener = onVisibleCoorPortChangedListener;
    }

    public void setProgress(float f) {
        this.chartComputator.setProgress(f);
        applyRenderUpdate();
    }

    public void updatePointsToRender(int i, ECGPointValue... eCGPointValueArr) {
        this.realtimeComputator.updatePointsToRender(i, eCGPointValueArr);
    }

    public ECGChartView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.defaultCoordinateport = new Coordinateport();
        this.measureResult = new int[2];
        this.canScaleOrGain = Boolean.TRUE;
        this.realtimeComputator = ECGRealtimeComputator.create();
        ECGStrategyFactory eCGStrategyFactoryCreate = ECGStrategyFactory.create(this);
        this.gestureFactory = eCGStrategyFactoryCreate;
        this.renderStrategy = eCGStrategyFactoryCreate.getECGRenderStrategy();
        applyAttributes(context, attributeSet);
        this.chartComputator.setRenderStrategy(this.renderStrategy);
        this.realtimeComputator.setEcgLineContainerCount(this.renderStrategy.getEcgLineCount());
    }

    @Override // com.seeker.luckychart.provider.RenderProvider
    public ECGChartAxesRenderer getChartAxesRenderer() {
        return ECGChartAxesRenderer.create(this);
    }

    @Override // com.seeker.luckychart.provider.RenderProvider
    public ECGChartDataRender getChartDataRenderer() {
        return ECGChartDataRender.create(this);
    }

    @Override // com.seeker.luckychart.charts.AbstractChartView, com.seeker.luckychart.provider.ChartProvider
    public void setChartData(ECGChartData eCGChartData) {
        ECGPointContainer[] dataContainer = eCGChartData.getDataContainer();
        if (dataContainer != null && dataContainer.length > 0) {
            int iMax = 0;
            for (ECGPointContainer eCGPointContainer : dataContainer) {
                ECGPointValue[] values = eCGPointContainer.getValues();
                if (values != null) {
                    iMax = Math.max(iMax, values.length);
                }
            }
            this.chartComputator.getMaxCoorport().right = iMax;
            this.chartComputator.getVisibleCoorport().left = 0.0f;
            this.chartComputator.getVisibleCoorport().right = this.renderStrategy.getXTotalPointCounts();
        }
        super.setChartData(eCGChartData);
    }

    public void updatePointsToRender(ECGPointValue[]... eCGPointValueArr) {
        int length = eCGPointValueArr.length;
        for (int i = 0; i < length; i++) {
            this.realtimeComputator.updatePointsToRender(i, eCGPointValueArr[i]);
        }
    }
}
