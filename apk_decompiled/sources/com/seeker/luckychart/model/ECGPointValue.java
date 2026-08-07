package com.seeker.luckychart.model;

import android.graphics.Color;
import com.seeker.luckychart.computator.ECGRealtimeComputator;
import com.tencent.connect.common.Constants;

/* JADX INFO: loaded from: classes.dex */
public class ECGPointValue extends PointValue implements Cloneable {
    private static final int DEFAULT_COLOR = Color.parseColor("#021F52");
    public static float INVALID_Y = Float.NaN;
    private int index;
    private boolean isNewStart;
    private boolean isNoise;
    private boolean isRPeak;
    private String typeAnno;
    private int drawColor = DEFAULT_COLOR;
    private int type = Integer.MIN_VALUE;

    public void copyFrom(ECGPointValue eCGPointValue) {
        super.copyFrom((PointValue) eCGPointValue);
        this.isNewStart = eCGPointValue.isNewStart;
        this.isNoise = eCGPointValue.isNoise;
        this.isRPeak = eCGPointValue.isRPeak;
        this.type = eCGPointValue.type;
        this.typeAnno = eCGPointValue.typeAnno;
        this.index = eCGPointValue.index;
        this.drawColor = ECGRealtimeComputator.drawLineColor;
    }

    public int getDefaultColor() {
        return DEFAULT_COLOR;
    }

    public int getDrawColor() {
        return this.drawColor;
    }

    public int getIndex() {
        return this.index;
    }

    public int getType() {
        return this.type;
    }

    public String getTypeAnno() {
        return this.typeAnno;
    }

    @Override // com.seeker.luckychart.model.PointValue
    public void init() {
        super.init();
        this.isNewStart = false;
        this.isNoise = false;
        this.isRPeak = false;
        this.type = Integer.MIN_VALUE;
        this.typeAnno = Constants.STR_EMPTY;
        this.index = 0;
        this.isIdle = true;
        this.drawColor = DEFAULT_COLOR;
    }

    public boolean isNewStart() {
        return this.isNewStart;
    }

    public boolean isNoise() {
        return this.isNoise;
    }

    public boolean isRPeak() {
        return this.isRPeak;
    }

    public void setDrawColor(int i) {
        this.drawColor = i;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public void setNewStart(boolean z) {
        this.isNewStart = z;
    }

    public void setNoise(boolean z) {
        this.isNoise = z;
    }

    public void setRPeak(boolean z) {
        this.isRPeak = z;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void setTypeAnno(String str) {
        this.typeAnno = str;
    }
}
