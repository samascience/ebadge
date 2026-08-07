package com.seeker.luckychart.soft;

import android.content.Context;
import android.graphics.Canvas;
import android.util.DisplayMetrics;
import com.seeker.luckychart.model.ECGPointValue;

/* JADX INFO: loaded from: classes.dex */
public abstract class RealRenderer {
    public Context mContext;
    protected float mDensity;
    public ECGPointValue[] mEcgData;
    protected float mScaleDensity;
    public SoftStrategy mSoftStrategy;

    public RealRenderer(Context context, ECGPointValue[] eCGPointValueArr) {
        this.mContext = context;
        this.mEcgData = eCGPointValueArr;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.mDensity = displayMetrics.density;
        this.mScaleDensity = displayMetrics.scaledDensity;
    }

    public abstract void draw(Canvas canvas);

    void setSoftStrategy(SoftStrategy softStrategy) {
        this.mSoftStrategy = softStrategy;
    }
}
