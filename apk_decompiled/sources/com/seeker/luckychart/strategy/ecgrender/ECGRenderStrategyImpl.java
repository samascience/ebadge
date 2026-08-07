package com.seeker.luckychart.strategy.ecgrender;

import android.text.TextUtils;
import com.seeker.luckychart.utils.ChartLogger;

/* JADX INFO: loaded from: classes.dex */
public class ECGRenderStrategyImpl implements ECGRenderStrategy {
    private static final int DEFAULT_CELLPIXEL = 10;
    private static final int DEFAULT_MAX_OUTERCELL_COUNT = 20;
    public static final int DEFAULT_OUTER_CELLCOUNTS_Y = 8;
    private int measuredHeight;
    private int measuredWith;
    private int xCellCounts;
    private float cellPixel = 10.0f;
    private int yOuterCellCounts = 8;
    private int defaultYOuterCellCounts = 8;
    private int yCellCountsPerMV = 10;
    private boolean hasMeasured = false;
    private int ecgLineCount = 1;
    private float ecgportSpace = 30.0f;
    private float[] markTextStyle = {14.0f, 4.0f};
    private boolean canLineBound = false;
    private int outColor = ECGRenderStrategy.OUTER_COLOR;
    private int innerColor = 0;

    private ECGRenderStrategyImpl() {
    }

    public static ECGRenderStrategy create() {
        return new ECGRenderStrategyImpl();
    }

    private int defaultXMaxCellCounts() {
        return getInnerCellCounts() * 20;
    }

    @Override // com.seeker.luckychart.strategy.ecgrender.ECGRenderStrategy
    public boolean gain(int i) {
        if (i > 20 || i < 5) {
            return false;
        }
        this.yCellCountsPerMV = i;
        return true;
    }

    @Override // com.seeker.luckychart.strategy.ecgrender.ECGRenderStrategy
    public float getCellWidth() {
        return this.cellPixel;
    }

    @Override // com.seeker.luckychart.strategy.ecgrender.ECGRenderStrategy
    public int getEcgLineCount() {
        return this.ecgLineCount;
    }

    @Override // com.seeker.luckychart.strategy.ecgrender.ECGRenderStrategy
    public float getEcgPortSpace() {
        return this.ecgportSpace;
    }

    @Override // com.seeker.luckychart.strategy.ecgrender.ECGRenderStrategy
    public int getInnerCellCounts() {
        return 5;
    }

    @Override // com.seeker.luckychart.strategy.ecgrender.ECGRenderStrategy
    public int getInnerColor() {
        return this.innerColor;
    }

    @Override // com.seeker.luckychart.strategy.ecgrender.ECGRenderStrategy
    public float getInnerThinkLineWidth() {
        return 1.0f;
    }

    @Override // com.seeker.luckychart.strategy.ecgrender.ECGRenderStrategy
    public float[] getMarkTextStyle() {
        return this.markTextStyle;
    }

    @Override // com.seeker.luckychart.strategy.ecgrender.ECGRenderStrategy
    public int getOuterColor() {
        return this.outColor;
    }

    @Override // com.seeker.luckychart.strategy.ecgrender.ECGRenderStrategy
    public float getOuterThinkLineWidth() {
        return 2.0f;
    }

    @Override // com.seeker.luckychart.strategy.ecgrender.ECGRenderStrategy
    public int getXCellCounts() {
        return this.xCellCounts;
    }

    @Override // com.seeker.luckychart.strategy.ecgrender.ECGRenderStrategy
    public int getXTotalPointCounts() {
        return this.xCellCounts * 10;
    }

    @Override // com.seeker.luckychart.strategy.ecgrender.ECGRenderStrategy
    public int getYCellCounts() {
        return this.yOuterCellCounts * getInnerCellCounts();
    }

    @Override // com.seeker.luckychart.strategy.ecgrender.ECGRenderStrategy
    public int getYCellCountsPerMv() {
        return this.yCellCountsPerMV;
    }

    @Override // com.seeker.luckychart.strategy.ecgrender.ECGRenderStrategy
    public float getYMaxMvs() {
        return (getYCellCounts() * 1.0f) / this.yCellCountsPerMV;
    }

    @Override // com.seeker.luckychart.strategy.ecgrender.ECGRenderStrategy
    public int getYOuterCellCount() {
        return this.yOuterCellCounts;
    }

    @Override // com.seeker.luckychart.strategy.ecgrender.ECGRenderStrategy
    public boolean isCanLineBound() {
        return this.canLineBound;
    }

    @Override // com.seeker.luckychart.strategy.ecgrender.ECGRenderStrategy
    public void onViewMeasured(int i, int i2, int[] iArr) {
        if (!this.hasMeasured) {
            float f = i;
            int cellWidth = (int) (f / getCellWidth());
            this.xCellCounts = cellWidth;
            if (cellWidth > defaultXMaxCellCounts()) {
                int iDefaultXMaxCellCounts = defaultXMaxCellCounts();
                this.xCellCounts = iDefaultXMaxCellCounts;
                this.cellPixel = (f * 1.0f) / iDefaultXMaxCellCounts;
            }
            this.hasMeasured = true;
        }
        int cellWidth2 = (int) (this.xCellCounts * getCellWidth());
        this.measuredWith = cellWidth2;
        iArr[0] = cellWidth2;
        int yCellCounts = (int) (getYCellCounts() * getCellWidth());
        this.measuredHeight = yCellCounts;
        iArr[1] = yCellCounts;
        ChartLogger.d("onViewMeasured() called: xCellCounts = " + this.xCellCounts + ",cellPixel = " + this.cellPixel + ",width = " + iArr[0] + ",height = " + iArr[1] + ",measuredWithSize = " + i + ",measuredHeightSize = " + i2);
    }

    @Override // com.seeker.luckychart.strategy.ecgrender.ECGRenderStrategy
    public boolean scale(int i) {
        int i2 = this.defaultYOuterCellCounts;
        if (i < i2 / 2 || i > ((double) i2) * 1.5d) {
            return false;
        }
        this.yOuterCellCounts = i;
        float yCellCounts = (this.measuredHeight * 1.0f) / getYCellCounts();
        this.cellPixel = yCellCounts;
        this.xCellCounts = (int) (this.measuredWith / yCellCounts);
        return true;
    }

    @Override // com.seeker.luckychart.strategy.ecgrender.ECGRenderStrategy
    public void setCanLineBound(boolean z) {
        this.canLineBound = z;
    }

    @Override // com.seeker.luckychart.strategy.ecgrender.ECGRenderStrategy
    public void setEcgLineCount(int i) {
        this.ecgLineCount = i;
    }

    @Override // com.seeker.luckychart.strategy.ecgrender.ECGRenderStrategy
    public void setEcgPortSpace(float f) {
        this.ecgportSpace = f;
    }

    @Override // com.seeker.luckychart.strategy.ecgrender.ECGRenderStrategy
    public void setInnerColor(int i) {
        this.innerColor = i;
    }

    @Override // com.seeker.luckychart.strategy.ecgrender.ECGRenderStrategy
    public void setMarkTextStyle(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String[] strArrSplit = str.split(",");
        if (strArrSplit.length > 0) {
            this.markTextStyle[0] = Float.parseFloat(strArrSplit[0]);
        }
        if (strArrSplit.length > 1) {
            this.markTextStyle[1] = Float.parseFloat(strArrSplit[1]);
        }
    }

    @Override // com.seeker.luckychart.strategy.ecgrender.ECGRenderStrategy
    public void setOutColor(int i) {
        this.outColor = i;
    }

    @Override // com.seeker.luckychart.strategy.ecgrender.ECGRenderStrategy
    public void setYOuterCellCounts(int i) {
        this.yOuterCellCounts = i;
        this.defaultYOuterCellCounts = i;
    }
}
