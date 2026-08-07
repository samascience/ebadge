package com.seeker.luckychart.soft;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import com.seeker.luckychart.model.ECGPointValue;

/* JADX INFO: loaded from: classes.dex */
public class LuckySoftRenderer {
    public static final float DEFAULT_MAX_VALUE = Float.NaN;
    private RealRenderer mAxesRenderer;
    private RealRenderer mDataRenerer;
    private SoftStrategy mSoftStrategy;
    private Bitmap softwareBitmap;
    private Canvas softwareCanvas;

    private LuckySoftRenderer(Context context, ECGPointValue[] eCGPointValueArr, SoftStrategy softStrategy, RealRenderer realRenderer, RealRenderer realRenderer2) {
        this.mSoftStrategy = softStrategy == null ? new LuckySoftStrategy(eCGPointValueArr.length) : softStrategy;
        this.mDataRenerer = realRenderer == null ? new SoftDataRenderer(context, eCGPointValueArr) : realRenderer;
        this.mAxesRenderer = realRenderer2 == null ? new SoftAxesRenderer(context, eCGPointValueArr) : realRenderer2;
        this.mDataRenerer.setSoftStrategy(this.mSoftStrategy);
        this.mAxesRenderer.setSoftStrategy(this.mSoftStrategy);
    }

    private void initSoft() {
        this.softwareCanvas = new Canvas();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(this.mSoftStrategy.pictureWidth(), this.mSoftStrategy.pictureHeight(), Bitmap.Config.ARGB_8888);
        this.softwareBitmap = bitmapCreateBitmap;
        this.softwareCanvas.setBitmap(bitmapCreateBitmap);
        this.softwareCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
    }

    public static LuckySoftRenderer instantiate(Context context, ECGPointValue[] eCGPointValueArr) {
        return instantiate(context, eCGPointValueArr, null, null, null);
    }

    public LuckySoftRenderer setMaxDataValue(float f) {
        if (!Float.isNaN(f)) {
            SoftStrategy softStrategy = this.mSoftStrategy;
            if (softStrategy instanceof LuckySoftStrategy) {
                ((LuckySoftStrategy) softStrategy).setMaxDataValueForMv(f);
            }
        }
        return this;
    }

    public Bitmap startRender() {
        initSoft();
        this.softwareCanvas.drawColor(Color.parseColor("#1A191F"));
        this.mAxesRenderer.draw(this.softwareCanvas);
        this.mDataRenerer.draw(this.softwareCanvas);
        return this.softwareBitmap;
    }

    public static LuckySoftRenderer instantiate(Context context, ECGPointValue[] eCGPointValueArr, SoftStrategy softStrategy, RealRenderer realRenderer, RealRenderer realRenderer2) {
        return new LuckySoftRenderer(context, eCGPointValueArr, softStrategy, realRenderer, realRenderer2);
    }
}
