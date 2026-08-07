package com.seeker.luckychart.soft;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import com.seeker.luckychart.model.ECGPointValue;
import com.seeker.luckychart.utils.ChartUtils;

/* JADX INFO: loaded from: classes.dex */
class SoftAxesRenderer extends RealRenderer {
    private static final int LINE_COLOR = Color.parseColor("#434141");
    private Paint cellPaint;
    private Paint pointPaint;
    private Paint rowPaint;

    SoftAxesRenderer(Context context, ECGPointValue[] eCGPointValueArr) {
        super(context, eCGPointValueArr);
        initPaint();
    }

    private void drawHorizontalLine(Canvas canvas, int i, int i2, int i3, int i4) {
        int iPixelPerCell = this.mSoftStrategy.pixelPerCell();
        int i5 = (i4 - i3) / iPixelPerCell;
        for (int i6 = 0; i6 <= i5; i6++) {
            if (i6 == 0) {
                float f = i3;
                canvas.drawLine(i, (this.rowPaint.getStrokeWidth() / 2.0f) + f, i2, (this.rowPaint.getStrokeWidth() / 2.0f) + f, this.rowPaint);
            } else if (i6 == i5) {
                float f2 = i4;
                canvas.drawLine(i, f2 - (this.rowPaint.getStrokeWidth() / 2.0f), i2, f2 - (this.rowPaint.getStrokeWidth() / 2.0f), this.rowPaint);
            } else if (i6 % (this.mSoftStrategy.cellCountPerGrid() * this.mSoftStrategy.gridCountPerRow()) == 0) {
                float f3 = (i6 * iPixelPerCell) + i3;
                canvas.drawLine(i, f3, i2, f3, this.rowPaint);
            } else if (i6 % this.mSoftStrategy.cellCountPerGrid() == 0) {
                float f4 = (i6 * iPixelPerCell) + i3;
                canvas.drawLine(i, f4, i2, f4, this.cellPaint);
            } else {
                drawHorizontalPoint(canvas, (i6 * iPixelPerCell) + i3, i, i2);
            }
        }
    }

    private void drawHorizontalPoint(Canvas canvas, float f, int i, int i2) {
        int iPixelPerCell = this.mSoftStrategy.pixelPerCell();
        int i3 = (i2 - i) / iPixelPerCell;
        for (int i4 = 0; i4 <= i3; i4++) {
            if (i4 % this.mSoftStrategy.cellCountPerGrid() != 0 && i4 != i3) {
                canvas.drawPoint((i4 * iPixelPerCell) + i, f, this.pointPaint);
            }
        }
    }

    private void drawVerticalLine(Canvas canvas, int i, int i2, int i3, int i4) {
        int iPixelPerCell = this.mSoftStrategy.pixelPerCell();
        int i5 = (i2 - i) / iPixelPerCell;
        for (int i6 = 0; i6 <= i5; i6++) {
            if (i6 == 0) {
                float f = i;
                canvas.drawLine(f, i3, f, i4, this.rowPaint);
            } else if (i6 == i5) {
                float f2 = i2;
                canvas.drawLine(f2, i3, f2, i4, this.rowPaint);
            } else if (i6 % this.mSoftStrategy.cellCountPerGrid() == 0) {
                float f3 = (i6 * iPixelPerCell) + i;
                canvas.drawLine(f3, i3, f3, i4, this.cellPaint);
            }
        }
    }

    private void initPaint() {
        Paint paint = new Paint();
        this.rowPaint = paint;
        paint.setAntiAlias(true);
        this.rowPaint.setColor(0);
        this.rowPaint.setStrokeWidth(ChartUtils.dp2px(this.mDensity, 2.0f));
        Paint paint2 = new Paint();
        this.cellPaint = paint2;
        paint2.setAntiAlias(true);
        Paint paint3 = this.cellPaint;
        int i = LINE_COLOR;
        paint3.setColor(i);
        this.cellPaint.setAlpha(200);
        this.cellPaint.setStrokeWidth(ChartUtils.dp2px(this.mDensity, 0.5f));
        Paint paint4 = new Paint();
        this.pointPaint = paint4;
        paint4.setAntiAlias(true);
        this.pointPaint.setColor(i);
        this.pointPaint.setAlpha(200);
        this.pointPaint.setStrokeWidth(2.0f);
    }

    @Override // com.seeker.luckychart.soft.RealRenderer
    public void draw(Canvas canvas) {
        int iHorizontalPadding = this.mSoftStrategy.horizontalPadding();
        int iPictureWidth = this.mSoftStrategy.pictureWidth() - this.mSoftStrategy.horizontalPadding();
        int iVerticalPadding = this.mSoftStrategy.VerticalPadding();
        int iPictureHeight = this.mSoftStrategy.pictureHeight() - this.mSoftStrategy.VerticalPadding();
        drawHorizontalLine(canvas, iHorizontalPadding, iPictureWidth, iVerticalPadding, iPictureHeight);
        drawVerticalLine(canvas, iHorizontalPadding, iPictureWidth, iVerticalPadding, iPictureHeight);
    }
}
