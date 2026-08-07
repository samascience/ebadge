package com.seeker.luckychart.soft;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.seeker.luckychart.model.ECGPointValue;
import com.seeker.luckychart.utils.ChartUtils;

/* JADX INFO: loaded from: classes.dex */
class SoftDataRenderer extends RealRenderer {
    private int dataLeft;
    private int dataRight;
    private Paint linePaint;
    private int rowHeight;
    private Paint timePaint;
    private Transformer transformer;

    SoftDataRenderer(Context context, ECGPointValue[] eCGPointValueArr) {
        super(context, eCGPointValueArr);
        initPaint();
    }

    private void drawRowTime(Canvas canvas, float f, float f2, String str) {
        int iDp2px = ChartUtils.dp2px(this.mDensity, 5.0f);
        Paint.FontMetricsInt fontMetricsInt = this.timePaint.getFontMetricsInt();
        float f3 = iDp2px;
        float f4 = f2 - f3;
        canvas.drawText(str, f + f3, (((f4 + (f4 - ChartUtils.getTextHeight(this.timePaint, str))) - fontMetricsInt.bottom) - fontMetricsInt.top) / 2.0f, this.timePaint);
    }

    private void initPaint() {
        Paint paint = new Paint();
        this.linePaint = paint;
        paint.setAntiAlias(true);
        this.linePaint.setStyle(Paint.Style.STROKE);
        Paint paint2 = this.linePaint;
        Paint.Cap cap = Paint.Cap.ROUND;
        paint2.setStrokeCap(cap);
        this.linePaint.setStrokeWidth(ChartUtils.dp2px(this.mDensity, 2.0f));
        this.linePaint.setColor(-1);
        Paint paint3 = new Paint();
        this.timePaint = paint3;
        paint3.setAntiAlias(true);
        this.timePaint.setStyle(Paint.Style.FILL);
        this.timePaint.setStrokeCap(cap);
        this.timePaint.setTextSize(ChartUtils.sp2px(this.mScaleDensity, 20.0f));
        this.timePaint.setColor(-1);
    }

    @Override // com.seeker.luckychart.soft.RealRenderer
    public void draw(Canvas canvas) {
        this.transformer = this.mSoftStrategy.getTransformer();
        this.dataLeft = this.mSoftStrategy.horizontalPadding();
        this.dataRight = this.mSoftStrategy.pictureWidth() - this.mSoftStrategy.horizontalPadding();
        this.rowHeight = (this.mSoftStrategy.pictureHeight() - (this.mSoftStrategy.VerticalPadding() * 2)) / this.mSoftStrategy.totalRows();
        this.transformer.setVisibleCoorport(0.0f, this.mSoftStrategy.maxDataValueForMv(), this.mSoftStrategy.pointsPerRow(), -this.mSoftStrategy.maxDataValueForMv());
        int i = this.mSoftStrategy.totalRows();
        int i2 = 0;
        while (i2 < i) {
            Transformer transformer = this.transformer;
            int i3 = this.dataLeft;
            int i4 = this.rowHeight;
            int i5 = i2 + 1;
            transformer.setDataContentRect(i3, i2 * i4, this.dataRight, i4 * i5);
            drawRowTime(canvas, this.dataLeft, this.rowHeight * i5, (this.mSoftStrategy.secondsPerRow() * i2) + "s");
            int iPointsPerRow = i2 * this.mSoftStrategy.pointsPerRow();
            int iMin = Math.min(this.mSoftStrategy.pointsPerRow() * i5, this.mEcgData.length);
            int i6 = iPointsPerRow;
            while (i6 < iMin - 1) {
                float fComputeRawX = this.transformer.computeRawX(i6 - iPointsPerRow);
                float fComputeRawY = this.transformer.computeRawY(this.mEcgData[i6].getCoorY());
                i6++;
                float fComputeRawX2 = this.transformer.computeRawX(i6 - iPointsPerRow);
                float fComputeRawY2 = this.transformer.computeRawY(this.mEcgData[i6].getCoorY());
                if (this.transformer.needDraw(fComputeRawY, fComputeRawY2)) {
                    canvas.drawLine(fComputeRawX, fComputeRawY, fComputeRawX2, fComputeRawY2, this.linePaint);
                }
            }
            i2 = i5;
        }
    }
}
