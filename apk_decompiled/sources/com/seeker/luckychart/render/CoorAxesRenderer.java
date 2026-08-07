package com.seeker.luckychart.render;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import com.seeker.luckychart.model.ChartAxis;
import com.seeker.luckychart.model.CoorValue;
import com.seeker.luckychart.provider.ChartProvider;
import com.seeker.luckychart.provider.DataProvider;
import com.seeker.luckychart.utils.ChartUtils;
import org.rajawali3d.cameras.Camera2D;
import org.rajawali3d.materials.Material;
import org.rajawali3d.materials.textures.ATexture;
import org.rajawali3d.materials.textures.Texture;
import org.rajawali3d.primitives.Plane;
import org.rajawali3d.scene.Scene;

/* JADX INFO: loaded from: classes.dex */
public class CoorAxesRenderer extends AbstractChartAxesRenderer {
    private static final String TAG = "CoorAxesRenderer";
    private Bitmap axesBitmap;
    private Canvas axesCanvas;
    private Material axesMaterial;
    private Plane axesPlane;
    private Texture axesTexture;

    private CoorAxesRenderer(ChartProvider chartProvider) {
        super(chartProvider);
    }

    public static CoorAxesRenderer create(ChartProvider chartProvider) {
        return new CoorAxesRenderer(chartProvider);
    }

    /* JADX WARN: Code duplicated, block: B:28:0x008e A[PHI: r5 r6
      0x008e: PHI (r5v21 int) = (r5v17 int), (r5v2 int) binds: [B:36:0x00ca, B:27:0x008c] A[DONT_GENERATE, DONT_INLINE]
      0x008e: PHI (r6v19 int) = (r6v17 int), (r6v25 int) binds: [B:36:0x00ca, B:27:0x008c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:29:0x0090 A[PHI: r5 r6
      0x0090: PHI (r5v20 int) = (r5v17 int), (r5v17 int), (r5v2 int), (r5v2 int) binds: [B:34:0x00bd, B:36:0x00ca, B:25:0x007f, B:27:0x008c] A[DONT_GENERATE, DONT_INLINE]
      0x0090: PHI (r6v18 int) = (r6v17 int), (r6v17 int), (r6v25 int), (r6v25 int) binds: [B:34:0x00bd, B:36:0x00ca, B:25:0x007f, B:27:0x008c] A[DONT_GENERATE, DONT_INLINE]] */
    private void drawAxisLabelsAndName(ChartAxis chartAxis, int i) {
        int coorBaseLine;
        int coorBaseLine2;
        CoorValue[] coordinateValues = chartAxis.getCoordinateValues();
        if (coordinateValues == null || coordinateValues.length == 0) {
            return;
        }
        if (isAxisVertical(i)) {
            coorBaseLine2 = (int) chartAxis.getCoorBaseLine();
            coorBaseLine = 0;
        } else {
            coorBaseLine = (int) chartAxis.getCoorBaseLine();
            coorBaseLine2 = 0;
        }
        int maxCoorchars = chartAxis.getMaxCoorchars();
        char[] cArr = new char[maxCoorchars];
        Rect dataContentRect = this.chartComputator.getDataContentRect();
        int length = coordinateValues.length;
        int iRound = coorBaseLine2;
        boolean z = false;
        int i2 = 0;
        while (i2 < length) {
            if (i2 % chartAxis.getModule() == 0) {
                CoorValue coorValue = coordinateValues[i2];
                ChartUtils.copyof(coorValue.getLabelAsChar(), cArr);
                float fMeasureText = ChartUtils.measureText(cArr, chartAxis.getCoorPaint());
                if (i == 1) {
                    coorBaseLine = i2 == 0 ? Math.round(coorValue.getRawValue()) : Math.round(coorValue.getRawValue() + (chartAxis.getCoorHeight() / 2.0f));
                    iRound = Math.round(coorBaseLine2 - fMeasureText);
                    if (coorValue.getRawValue() < dataContentRect.top - 5.0f || coorValue.getRawValue() > dataContentRect.bottom + 5.0f) {
                        z = false;
                    } else {
                        z = true;
                    }
                } else if (i == 4) {
                    iRound = i2 == 0 ? Math.round(coorValue.getRawValue()) : Math.round(coorValue.getRawValue() - (fMeasureText / 2.0f));
                    if (coorValue.getRawValue() < dataContentRect.left - 5.0f || coorValue.getRawValue() > dataContentRect.right + 5.0f) {
                        z = false;
                    } else {
                        z = true;
                    }
                }
                int i3 = iRound;
                boolean z2 = z;
                if (z2) {
                    this.axesCanvas.drawText(cArr, 0, maxCoorchars, i3, coorBaseLine, chartAxis.getCoorPaint());
                }
                iRound = i3;
                z = z2;
            } else {
                i2 = i2;
                length = length;
            }
            i2++;
            length = length;
        }
        Rect dataContentRect2 = this.chartComputator.getDataContentRect();
        String name = chartAxis.getName();
        Paint namePaint = chartAxis.getNamePaint();
        if (TextUtils.isEmpty(name) || namePaint == null) {
            return;
        }
        if (i != 1) {
            if (i != 4) {
                return;
            }
            this.axesCanvas.drawText(name, (int) (dataContentRect2.centerX() - (ChartUtils.measureText(name.toCharArray(), namePaint) / 2.0f)), Math.round(chartAxis.getNameBaseLine()), namePaint);
        } else {
            this.axesCanvas.save();
            this.axesCanvas.rotate(90.0f, dataContentRect2.centerX(), dataContentRect2.centerY());
            this.axesCanvas.translate(dataContentRect2.centerX() - (ChartUtils.measureText(name.toCharArray(), namePaint) / 2.0f), dataContentRect2.centerY() + chartAxis.getCoorHeight());
            this.axesCanvas.drawText(name, (int) chartAxis.getNameBaseLine(), dataContentRect2.centerY(), namePaint);
            this.axesCanvas.restore();
        }
    }

    private void drawAxisLines(ChartAxis chartAxis, int i) {
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float rawValue;
        float rawValue2;
        CoorValue[] coordinateValues;
        Rect dataContentRect = this.chartComputator.getDataContentRect();
        boolean zIsAxisVertical = isAxisVertical(i);
        float f6 = 0.0f;
        if (zIsAxisVertical) {
            float separationLine = chartAxis.getSeparationLine();
            float f7 = dataContentRect.bottom;
            float f8 = dataContentRect.top;
            float f9 = dataContentRect.left;
            rawValue2 = dataContentRect.right;
            f2 = separationLine;
            f3 = f2;
            f4 = f7;
            f5 = f8;
            rawValue = 0.0f;
            f6 = f9;
            f = 0.0f;
        } else {
            float f10 = dataContentRect.left;
            float f11 = dataContentRect.right;
            float separationLine2 = chartAxis.getSeparationLine();
            f = dataContentRect.top;
            f2 = f10;
            f3 = f11;
            f4 = separationLine2;
            f5 = f4;
            rawValue = dataContentRect.bottom;
            rawValue2 = 0.0f;
        }
        Paint lineMajorPaint = chartAxis.getLineMajorPaint();
        if (lineMajorPaint != null) {
            this.axesCanvas.drawLine(f2, f4, f3, f5, lineMajorPaint);
        }
        Paint lineSubPaint = chartAxis.getLineSubPaint();
        if (lineSubPaint == null || (coordinateValues = chartAxis.getCoordinateValues()) == null || coordinateValues.length == 0) {
            return;
        }
        int length = coordinateValues.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 != 0 && i2 % chartAxis.getModule() == 0) {
                CoorValue coorValue = coordinateValues[i2];
                if (zIsAxisVertical) {
                    rawValue = coorValue.getRawValue();
                    f = rawValue;
                } else {
                    rawValue2 = coorValue.getRawValue();
                    f6 = rawValue2;
                }
                this.axesCanvas.drawLine(f6, f, rawValue2, rawValue, lineSubPaint);
            }
        }
    }

    private void prepareAxisToDraw(ChartAxis chartAxis, int i) {
        CoorValue[] coordinateValues = chartAxis.getCoordinateValues();
        if (coordinateValues != null) {
            boolean zIsAxisVertical = isAxisVertical(i);
            for (CoorValue coorValue : coordinateValues) {
                float value = coorValue.getValue();
                coorValue.setRawValue(zIsAxisVertical ? this.chartComputator.computeRawY(value) : this.chartComputator.computeRawX(value));
            }
        }
    }

    @Override // com.seeker.luckychart.render.inters.LuckyAxesRenderer
    public void drawInBackground() {
        DataProvider chartData = this.chartProvider.getChartData();
        if (chartData != null) {
            ChartAxis leftAxis = chartData.getLeftAxis();
            if (leftAxis != null) {
                prepareAxisToDraw(leftAxis, 1);
                drawAxisLines(leftAxis, 1);
            }
            ChartAxis topAxis = chartData.getTopAxis();
            if (topAxis != null) {
                prepareAxisToDraw(topAxis, 2);
                drawAxisLines(topAxis, 2);
            }
            ChartAxis rightAxis = chartData.getRightAxis();
            if (rightAxis != null) {
                prepareAxisToDraw(rightAxis, 3);
                drawAxisLines(rightAxis, 3);
            }
            ChartAxis bottomAxis = chartData.getBottomAxis();
            if (bottomAxis != null) {
                prepareAxisToDraw(bottomAxis, 4);
                drawAxisLines(bottomAxis, 4);
            }
        }
    }

    @Override // com.seeker.luckychart.render.inters.LuckyAxesRenderer
    public void drawInForeground() {
        DataProvider chartData = this.chartProvider.getChartData();
        if (chartData != null) {
            ChartAxis leftAxis = chartData.getLeftAxis();
            if (leftAxis != null) {
                drawAxisLabelsAndName(leftAxis, 1);
            }
            ChartAxis topAxis = chartData.getTopAxis();
            if (topAxis != null) {
                drawAxisLabelsAndName(topAxis, 2);
            }
            ChartAxis rightAxis = chartData.getRightAxis();
            if (rightAxis != null) {
                drawAxisLabelsAndName(rightAxis, 3);
            }
            ChartAxis bottomAxis = chartData.getBottomAxis();
            if (bottomAxis != null) {
                drawAxisLabelsAndName(bottomAxis, 4);
            }
        }
        this.axesTexture.setBitmap(this.axesBitmap);
        this.chartProvider.getChartGlRenderer().getTextureManager().replaceTexture(this.axesTexture);
    }

    @Override // com.seeker.luckychart.render.inters.LuckyRenderer
    public void initScene() {
        Camera2D camera2D = this.chartComputator.getChartRenderer().getCamera2D();
        Plane plane = new Plane((float) camera2D.getWidth(), (float) camera2D.getHeight(), 2, 1);
        this.axesPlane = plane;
        plane.setDoubleSided(true);
        this.axesPlane.setTransparent(true);
        this.axesPlane.isContainer(false);
        Material material = new Material();
        this.axesMaterial = material;
        material.setColorInfluence(0.0f);
        this.axesPlane.setMaterial(this.axesMaterial);
        this.axesCanvas = new Canvas();
    }

    @Override // com.seeker.luckychart.render.AbstractChartAxesRenderer, com.seeker.luckychart.render.inters.LuckyRenderer
    public void onChartDataChanged() {
        super.onChartDataChanged();
        drawInBackground();
        drawInForeground();
    }

    @Override // com.seeker.luckychart.render.AbstractChartAxesRenderer, com.seeker.luckychart.render.inters.LuckyRenderer
    public void onChartSizeChanged() {
        super.onChartSizeChanged();
        Scene currentScene = this.chartProvider.getChartGlRenderer().getCurrentScene();
        currentScene.removeChild(this.axesPlane);
        if (this.axesBitmap == null) {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(this.chartComputator.getChartWidth(), this.chartComputator.getChartHeight(), Bitmap.Config.ARGB_8888);
            this.axesBitmap = bitmapCreateBitmap;
            this.axesCanvas.setBitmap(bitmapCreateBitmap);
            Texture texture = new Texture("bpmTexture", this.axesBitmap);
            this.axesTexture = texture;
            try {
                texture.setMipmap(false);
                this.axesMaterial.addTexture(this.axesTexture);
            } catch (ATexture.TextureException e) {
                e.printStackTrace();
            }
        }
        currentScene.addChildAt(this.axesPlane, 0);
    }
}
