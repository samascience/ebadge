package com.seeker.luckychart.wrapper;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import com.seeker.luckychart.model.ChartAxis;
import com.seeker.luckychart.model.CoorValue;
import com.seeker.luckychart.provider.ChartProvider;
import com.seeker.luckychart.utils.ChartUtils;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"ViewConstructor"})
public class LeftAxisView extends View {
    private Rect dataContent;
    private char[] drawed;
    private ChartAxis leftAxis;
    private ChartProvider provider;

    public LeftAxisView(Context context, ChartProvider chartProvider) {
        super(context);
        this.provider = chartProvider;
        ChartAxis leftAxis = chartProvider.getChartData().getLeftAxis();
        this.leftAxis = leftAxis;
        this.drawed = new char[leftAxis.getMaxCoorchars()];
        this.dataContent = chartProvider.getChartComputator().getDataContentRect();
        setBackgroundColor(-1);
    }

    private void drawAxisCoor(Canvas canvas) {
        float rawValue;
        float coorHeight;
        canvas.save();
        CoorValue[] coordinateValues = this.leftAxis.getCoordinateValues();
        float coorBaseLine = this.leftAxis.getCoorBaseLine();
        Paint coorPaint = this.leftAxis.getCoorPaint();
        int length = coordinateValues.length;
        for (int i = 0; i < length; i++) {
            if (i % this.leftAxis.getModule() == 0) {
                CoorValue coorValue = coordinateValues[i];
                ChartUtils.copyof(coorValue.getLabelAsChar(), this.drawed);
                if (i == 0) {
                    rawValue = coorValue.getRawValue();
                    coorHeight = this.leftAxis.getCoorHeight();
                } else {
                    rawValue = coorValue.getRawValue();
                    coorHeight = this.leftAxis.getCoorHeight() / 2.0f;
                }
                float f = (int) (rawValue - coorHeight);
                float fMeasureText = (int) (coorBaseLine - ChartUtils.measureText(this.drawed, coorPaint));
                if (coorValue.getRawValue() >= this.dataContent.top - 5.0f && coorValue.getRawValue() <= this.dataContent.bottom + 5.0f) {
                    char[] cArr = this.drawed;
                    Bitmap bitmapDrawBitmapText = ChartUtils.drawBitmapText(cArr, 0, cArr.length, coorPaint);
                    canvas.drawBitmap(bitmapDrawBitmapText, fMeasureText, f, (Paint) null);
                    bitmapDrawBitmapText.recycle();
                }
            }
        }
        canvas.restore();
    }

    private void drawMajorLine(Canvas canvas) {
        canvas.save();
        canvas.drawLine(this.leftAxis.getSeparationLine(), this.dataContent.bottom, this.leftAxis.getSeparationLine(), this.dataContent.top, this.leftAxis.getLineMajorPaint());
        canvas.restore();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawAxisCoor(canvas);
        drawMajorLine(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension((int) (this.provider.getChartComputator().getDataContentRect().left + (this.provider.getChartData().getLeftAxis().getLineMajorPaint().getStrokeWidth() / 2.0f)), -1);
    }
}
