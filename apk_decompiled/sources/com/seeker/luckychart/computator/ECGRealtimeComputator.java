package com.seeker.luckychart.computator;

import com.seeker.luckychart.model.ECGPointValue;
import com.seeker.luckychart.model.chartdata.ECGChartData;
import com.seeker.luckychart.model.container.AbsContainer;
import com.seeker.luckychart.model.container.ECGPointContainer;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes.dex */
public final class ECGRealtimeComputator {
    public static int drawLineColor = -1;
    private ECGChartData defaultChartData;
    private ECGPointContainer[] defaultContainers;
    private Options[] defaultOptions;
    private ECGPointValue[][] defaultRenderPoints;
    private int ecgLineContainerCount;
    private int plotMaxPointCount;
    private int mode = 1;
    private boolean drawNoise = false;
    private boolean drawRPeak = false;
    private final ReentrantLock lock = new ReentrantLock();

    private static class Options {
        int preAppendIndex;
        boolean translateAppended;

        private Options() {
            this.translateAppended = true;
            this.preAppendIndex = 0;
        }

        void reset() {
            this.translateAppended = true;
            this.preAppendIndex = 0;
        }
    }

    private ECGRealtimeComputator() {
    }

    private void checkNull() {
        ECGPointContainer[] eCGPointContainerArr = this.defaultContainers;
        if (eCGPointContainerArr == null || eCGPointContainerArr.length != this.ecgLineContainerCount) {
            this.defaultContainers = new ECGPointContainer[this.ecgLineContainerCount];
            for (int i = 0; i < this.ecgLineContainerCount; i++) {
                this.defaultContainers[i] = ECGPointContainer.create();
            }
        }
        if (this.defaultChartData == null) {
            this.defaultChartData = ECGChartData.create();
        }
        ECGPointValue[][] eCGPointValueArr = this.defaultRenderPoints;
        if (eCGPointValueArr == null || eCGPointValueArr.length != this.ecgLineContainerCount) {
            this.defaultRenderPoints = (ECGPointValue[][]) Array.newInstance((Class<?>) ECGPointValue.class, this.ecgLineContainerCount, this.plotMaxPointCount);
        }
        for (ECGPointContainer eCGPointContainer : this.defaultContainers) {
            eCGPointContainer.setDrawNoise(this.drawNoise);
            eCGPointContainer.setDrawRpeak(this.drawRPeak);
        }
    }

    private void copyFrom(ECGPointValue[] eCGPointValueArr, int i, int i2, ECGPointValue... eCGPointValueArr2) {
        int iMin = Math.min(i2, eCGPointValueArr2.length);
        for (int i3 = 0; i3 < iMin; i3++) {
            int i4 = i + i3;
            if (i4 >= 0 && i4 < eCGPointValueArr.length) {
                ECGPointValue eCGPointValue = eCGPointValueArr[i4];
                if (eCGPointValue == null) {
                    eCGPointValue = new ECGPointValue();
                    eCGPointValueArr[i4] = eCGPointValue;
                }
                eCGPointValue.copyFrom(eCGPointValueArr2[i3]);
            }
            eCGPointValueArr2[i3].init();
        }
    }

    public static ECGRealtimeComputator create() {
        return new ECGRealtimeComputator();
    }

    private void erase(ECGPointValue[] eCGPointValueArr, Options options, ECGPointValue... eCGPointValueArr2) {
        int length = eCGPointValueArr2.length;
        int i = this.plotMaxPointCount;
        if (length >= i) {
            System.arraycopy(eCGPointValueArr2, length - i, eCGPointValueArr, 0, i);
            options.preAppendIndex = 0;
            options.translateAppended = false;
            return;
        }
        int i2 = options.preAppendIndex;
        if (length + i2 <= i) {
            copyFrom(eCGPointValueArr, i2, length, eCGPointValueArr2);
            options.preAppendIndex += length;
            return;
        }
        int i3 = i - i2;
        copyFrom(eCGPointValueArr, i2, i3, (ECGPointValue[]) Arrays.copyOfRange(eCGPointValueArr2, 0, i3));
        int i4 = length - i3;
        copyFrom(eCGPointValueArr, 0, i4, (ECGPointValue[]) Arrays.copyOfRange(eCGPointValueArr2, i3, eCGPointValueArr2.length));
        options.preAppendIndex = i4;
        options.translateAppended = false;
    }

    private void translate(ECGPointValue[] eCGPointValueArr, Options options, ECGPointValue... eCGPointValueArr2) {
        int length = eCGPointValueArr2.length;
        if (!options.translateAppended) {
            int i = this.plotMaxPointCount;
            if (length >= i) {
                System.arraycopy(eCGPointValueArr2, length - i, eCGPointValueArr, 0, i);
                return;
            }
            int i2 = i - length;
            ECGPointValue[] eCGPointValueArr3 = (ECGPointValue[]) Arrays.copyOfRange(eCGPointValueArr, 0, length);
            System.arraycopy(eCGPointValueArr, length, eCGPointValueArr, 0, i2);
            System.arraycopy(eCGPointValueArr3, 0, eCGPointValueArr, i2, length);
            copyFrom(eCGPointValueArr, i2, length, eCGPointValueArr2);
            return;
        }
        int i3 = options.preAppendIndex;
        int i4 = i3 + length;
        int i5 = this.plotMaxPointCount;
        if (i4 <= i5) {
            copyFrom(eCGPointValueArr, i3, length, eCGPointValueArr2);
            options.preAppendIndex += length;
        } else {
            int iMax = Math.max(0, i5 - length);
            copyFrom(eCGPointValueArr, iMax, this.plotMaxPointCount - iMax, eCGPointValueArr2);
            options.preAppendIndex = iMax;
            options.translateAppended = false;
        }
        if (options.translateAppended) {
            return;
        }
        options.preAppendIndex = 0;
    }

    public ECGChartData getDefaultChartData() {
        return this.defaultChartData;
    }

    @Deprecated
    public void repairPointRPeak(int i, int i2, String str, boolean z) {
    }

    public void reset() {
        ECGPointValue[][] eCGPointValueArr = (ECGPointValue[][]) Array.newInstance((Class<?>) ECGPointValue.class, this.ecgLineContainerCount, this.plotMaxPointCount);
        this.defaultRenderPoints = eCGPointValueArr;
        int length = eCGPointValueArr.length;
        for (int i = 0; i < length; i++) {
            ECGPointValue[] eCGPointValueArr2 = this.defaultRenderPoints[i];
            Arrays.fill(eCGPointValueArr2, (Object) null);
            this.defaultContainers[i].setValues(eCGPointValueArr2);
        }
        for (Options options : this.defaultOptions) {
            options.reset();
        }
    }

    public void setDrawNoise(boolean z) {
        this.drawNoise = z;
        checkNull();
    }

    public void setDrawRPeak(boolean z) {
        this.drawRPeak = z;
        checkNull();
    }

    public void setEcgLineContainerCount(int i) {
        this.ecgLineContainerCount = i;
        this.defaultContainers = new ECGPointContainer[i];
        this.defaultOptions = new Options[i];
        for (int i2 = 0; i2 < this.ecgLineContainerCount; i2++) {
            this.defaultContainers[i2] = ECGPointContainer.create();
            this.defaultOptions[i2] = new Options();
        }
        this.defaultChartData = ECGChartData.create(this.defaultContainers);
    }

    public void setMode(int i) {
        if (this.mode != i) {
            this.mode = i;
            reset();
        }
    }

    public void setPlotMaxPointCount(int i) {
        if (this.plotMaxPointCount == i) {
            return;
        }
        this.plotMaxPointCount = i;
        int[] iArr = {this.ecgLineContainerCount, i};
        this.defaultRenderPoints = (ECGPointValue[][]) Array.newInstance((Class<?>) ECGPointValue.class, iArr);
        for (int i2 = 0; i2 < this.ecgLineContainerCount; i2++) {
            this.defaultContainers[i2].setValues(this.defaultRenderPoints[i2]);
        }
    }

    public void updatePointsToRender(int i, ECGPointValue... eCGPointValueArr) {
        if (i >= this.ecgLineContainerCount) {
            throw new ArrayIndexOutOfBoundsException("targetLineIndex(" + i + ") >= ecgLineContainerCount(" + this.ecgLineContainerCount + ")!!");
        }
        try {
            this.lock.lock();
            if (eCGPointValueArr != null && eCGPointValueArr.length > 0) {
                checkNull();
                int i2 = this.mode;
                if (i2 == 1) {
                    translate(this.defaultRenderPoints[i], this.defaultOptions[i], eCGPointValueArr);
                } else if (i2 == 2) {
                    erase(this.defaultRenderPoints[i], this.defaultOptions[i], eCGPointValueArr);
                }
                this.defaultContainers[i].setValues(this.defaultRenderPoints[i]);
                this.defaultChartData.setDataContainer((AbsContainer[]) this.defaultContainers);
            }
        } finally {
            this.lock.unlock();
        }
    }
}
