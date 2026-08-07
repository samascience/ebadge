package com.seeker.luckychart.render.ecg;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import com.seeker.luckychart.charts.ECGChartView;
import com.seeker.luckychart.glmodel.ECGLine3D;
import com.seeker.luckychart.model.Coordinateport;
import com.seeker.luckychart.model.ECGPointValue;
import com.seeker.luckychart.model.chartdata.ECGChartData;
import com.seeker.luckychart.model.container.ECGPointContainer;
import com.seeker.luckychart.render.AbstractChartDataRenderer;
import com.seeker.luckychart.strategy.ecgrender.ECGRenderStrategy;
import com.seeker.luckychart.utils.ChartUtils;
import java.util.ArrayList;
import org.rajawali3d.Object3D;
import org.rajawali3d.cameras.Camera2D;
import org.rajawali3d.materials.Material;
import org.rajawali3d.materials.textures.ATexture;
import org.rajawali3d.materials.textures.Texture;
import org.rajawali3d.primitives.Plane;
import org.rajawali3d.scene.Scene;

/* JADX INFO: loaded from: classes.dex */
public class ECGChartDataRender extends AbstractChartDataRenderer<ECGChartData> {
    private float baseLine;
    private Bitmap bitmap;
    private Material bpmMaterial;
    private Plane bpmPlane;
    private Canvas canvas;
    private ECGChartView chartView;
    private Object3D lineContainer;
    private Texture mBpmTexture;
    private Paint paint;

    private ECGChartDataRender(ECGChartView eCGChartView) {
        super(eCGChartView);
        this.chartView = eCGChartView;
    }

    public static ECGChartDataRender create(ECGChartView eCGChartView) {
        return new ECGChartDataRender(eCGChartView);
    }

    private void destroyChild() {
        Scene currentScene = this.chartView.getChartGlRenderer().getCurrentScene();
        ArrayList childrenCopy = currentScene.getChildrenCopy();
        if (childrenCopy.contains(this.lineContainer)) {
            currentScene.removeChild(this.lineContainer);
            this.lineContainer.destroy();
            this.lineContainer = null;
        }
        if (childrenCopy.contains(this.bpmPlane)) {
            currentScene.removeChild(this.bpmPlane);
        }
    }

    private void drawOscillogram(ECGLine3D eCGLine3D, ECGPointValue[] eCGPointValueArr, boolean z, boolean z2, float f, float f2) {
        Coordinateport visibleCoorport = this.chartComputator.getVisibleCoorport();
        ECGRenderStrategy eCGRenderStrategy = this.chartView.getECGRenderStrategy();
        int xTotalPointCounts = eCGRenderStrategy.getXTotalPointCounts();
        int iMax = (int) visibleCoorport.left;
        int i = iMax + xTotalPointCounts;
        int i2 = 0;
        if (i > this.chartComputator.getMaxCoorport().right) {
            i = (int) this.chartComputator.getMaxCoorport().right;
            iMax = Math.max(0, i - xTotalPointCounts);
        }
        float f3 = 0.0f;
        int i3 = iMax;
        float f4 = 0.0f;
        float f5 = 0.0f;
        int i4 = 0;
        while (i3 < i) {
            ECGPointValue eCGPointValue = eCGPointValueArr[i3];
            if (eCGPointValue == null || Float.isNaN(eCGPointValue.getCoorY())) {
                eCGLine3D.addVertexToBuffer(f3, f4, i4, i3 - iMax);
            } else {
                int drawColor = (z || z2) ? eCGPointValue.getDrawColor() : eCGPointValue.getDefaultColor();
                float fComputeRawX = this.chartComputator.computeRawX(i3);
                float fComputeECGRawY = this.chartComputator.computeECGRawY(eCGPointValue.getCoorY(), f2);
                if (!eCGRenderStrategy.isCanLineBound()) {
                    if (fComputeECGRawY > f2) {
                        if (f5 > f2) {
                            drawColor = i2;
                        }
                        f5 = fComputeECGRawY;
                        fComputeECGRawY = f2;
                    } else if (fComputeECGRawY < f) {
                        if (f5 < f) {
                            drawColor = i2;
                        }
                        f5 = fComputeECGRawY;
                        fComputeECGRawY = f;
                    }
                }
                PointF pointFScreenToCartesian = this.chartComputator.screenToCartesian(fComputeRawX, fComputeECGRawY);
                eCGLine3D.addVertexToBuffer(pointFScreenToCartesian.x, pointFScreenToCartesian.y, drawColor, i3 - iMax);
                f3 = pointFScreenToCartesian.x;
                float f6 = pointFScreenToCartesian.y;
                int drawColor2 = eCGPointValue.getDrawColor();
                if (z2 && eCGPointValue.isRPeak()) {
                    this.paint.setColor(eCGPointValue.getDrawColor());
                    this.canvas.drawText(eCGPointValue.getTypeAnno(), fComputeRawX - (this.paint.measureText(eCGPointValue.getTypeAnno()) / 2.0f), this.baseLine + f, this.paint);
                }
                f4 = f6;
                i4 = drawColor2;
            }
            i3++;
            i2 = 0;
        }
        eCGLine3D.updateData();
        if (z2) {
            this.mBpmTexture.setBitmap(this.bitmap);
            this.chartView.getChartGlRenderer().getTextureManager().replaceTexture(this.mBpmTexture);
        }
    }

    private void initAboutRPeak() {
        Paint paint = new Paint(1);
        this.paint = paint;
        paint.setStyle(Paint.Style.FILL);
        float[] markTextStyle = this.chartView.getECGRenderStrategy().getMarkTextStyle();
        this.paint.setTextSize(ChartUtils.applyDimension(2, markTextStyle[0]));
        this.paint.setStrokeWidth(ChartUtils.applyDimension(2, markTextStyle[1]));
        this.paint.setAntiAlias(true);
        Paint.FontMetrics fontMetrics = this.paint.getFontMetrics();
        this.baseLine = ((((int) Math.ceil(fontMetrics.descent - fontMetrics.ascent)) - fontMetrics.bottom) - fontMetrics.top) / 2.0f;
        Camera2D camera2D = this.chartComputator.getChartRenderer().getCamera2D();
        Plane plane = new Plane((float) camera2D.getWidth(), (float) camera2D.getHeight(), 2, 1);
        this.bpmPlane = plane;
        plane.setDoubleSided(true);
        this.bpmPlane.setTransparent(true);
        this.bpmPlane.isContainer(false);
        Material material = new Material();
        this.bpmMaterial = material;
        material.setColorInfluence(0.0f);
        this.bpmPlane.setMaterial(this.bpmMaterial);
        this.canvas = new Canvas();
    }

    private void initEcgLine() {
        this.lineContainer = new Object3D();
        ECGRenderStrategy eCGRenderStrategy = this.chartView.getECGRenderStrategy();
        int ecgLineCount = eCGRenderStrategy.getEcgLineCount();
        for (int i = 0; i < ecgLineCount; i++) {
            this.lineContainer.addChild(new ECGLine3D(eCGRenderStrategy.getXTotalPointCounts()));
        }
    }

    private void prepareEcgLine(ECGPointContainer eCGPointContainer, ECGLine3D eCGLine3D, boolean z) {
        eCGLine3D.setLineThickness(eCGPointContainer.getLineStrokeWidth());
        if (z) {
            this.canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        }
    }

    @Override // com.seeker.luckychart.render.AbstractChartDataRenderer, com.seeker.luckychart.render.inters.LuckyRenderer
    public void initScene() {
        initEcgLine();
        initAboutRPeak();
    }

    @Override // com.seeker.luckychart.render.inters.LuckyRenderer
    public void onChartDataChanged() {
    }

    @Override // com.seeker.luckychart.render.inters.LuckyRenderer
    public void onChartSizeChanged() {
        destroyChild();
        initEcgLine();
        Scene currentScene = this.chartView.getChartGlRenderer().getCurrentScene();
        currentScene.addChild(this.lineContainer);
        if (this.bitmap == null) {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(this.chartComputator.getChartWidth(), this.chartComputator.getChartHeight(), Bitmap.Config.ARGB_8888);
            this.bitmap = bitmapCreateBitmap;
            this.canvas.setBitmap(bitmapCreateBitmap);
            Texture texture = new Texture("bpmTexture", this.bitmap);
            this.mBpmTexture = texture;
            try {
                texture.setMipmap(false);
                this.bpmMaterial.addTexture(this.mBpmTexture);
            } catch (ATexture.TextureException e) {
                e.printStackTrace();
            }
        }
        currentScene.addChild(this.bpmPlane);
    }

    @Override // com.seeker.luckychart.render.inters.LuckyRenderer
    public void onChartlayoutChanged() {
        destroyChild();
        initEcgLine();
        Scene currentScene = this.chartView.getChartGlRenderer().getCurrentScene();
        currentScene.addChild(this.lineContainer);
        currentScene.addChild(this.bpmPlane);
    }

    @Override // com.seeker.luckychart.render.inters.LuckyDataRenderer
    public void onDataRender() {
        if (!checkDataAvailable() || this.lineContainer == null) {
            return;
        }
        ECGPointContainer[] dataContainer = ((ECGChartData) this.chartProvider.getChartData()).getDataContainer();
        ECGRenderStrategy eCGRenderStrategy = this.chartView.getECGRenderStrategy();
        int iMin = Math.min(Math.min(dataContainer.length, eCGRenderStrategy.getEcgLineCount()), this.lineContainer.getNumChildren());
        int i = 0;
        while (i < iMin) {
            ECGPointContainer eCGPointContainer = dataContainer[i];
            ECGLine3D eCGLine3D = (ECGLine3D) this.lineContainer.getChildAt(i);
            prepareEcgLine(eCGPointContainer, eCGLine3D, i == 0);
            ECGPointValue[] values = eCGPointContainer.getValues();
            float f = i;
            float singleEcgChartHeight = (this.chartComputator.getSingleEcgChartHeight() * f) + (eCGRenderStrategy.getEcgPortSpace() * f);
            drawOscillogram(eCGLine3D, values, eCGPointContainer.isDrawNoise(), eCGPointContainer.isDrawRpeak(), singleEcgChartHeight, singleEcgChartHeight + this.chartComputator.getSingleEcgChartHeight());
            i++;
        }
    }
}
