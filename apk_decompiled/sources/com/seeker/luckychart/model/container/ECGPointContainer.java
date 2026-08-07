package com.seeker.luckychart.model.container;

import com.seeker.luckychart.model.ECGPointValue;

/* JADX INFO: loaded from: classes.dex */
public class ECGPointContainer extends AbsContainer<ECGPointValue> {
    private int destIndex;
    private boolean drawNoise;
    private boolean drawRpeak;

    private ECGPointContainer(ECGPointValue[] eCGPointValueArr) {
        super(eCGPointValueArr);
        this.destIndex = 0;
    }

    public static ECGPointContainer create() {
        return new ECGPointContainer();
    }

    public int getValidCount() {
        return this.destIndex;
    }

    public boolean isDrawNoise() {
        return this.drawNoise;
    }

    public boolean isDrawRpeak() {
        return this.drawRpeak;
    }

    public void setDrawNoise(boolean z) {
        this.drawNoise = z;
    }

    public void setDrawRpeak(boolean z) {
        this.drawRpeak = z;
    }

    public static ECGPointContainer create(ECGPointValue[] eCGPointValueArr) {
        return new ECGPointContainer(eCGPointValueArr);
    }

    @Override // com.seeker.luckychart.model.container.AbsContainer
    public void updateNewValues(ECGPointValue[] eCGPointValueArr) {
        if (eCGPointValueArr == null || eCGPointValueArr.length == 0) {
            return;
        }
        int length = eCGPointValueArr.length;
        ECGPointValue[] values = getValues();
        int length2 = values.length;
        int i = this.destIndex;
        if (i + length <= length2) {
            System.arraycopy(eCGPointValueArr, 0, values, i, length);
            this.destIndex += length;
        } else {
            int i2 = (i + length) - length2;
            System.arraycopy(values, i2, values, 0, length2 - i2);
            System.arraycopy(eCGPointValueArr, 0, values, length2 - length, length);
            this.destIndex = length2;
        }
    }

    private ECGPointContainer() {
        this.destIndex = 0;
    }
}
