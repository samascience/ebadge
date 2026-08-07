package com.seeker.luckychart.strategy.ecgrender;

/* JADX INFO: loaded from: classes.dex */
public interface ECGRenderStrategy {
    public static final int DEFAULT_INNER_CELLCOUNTS = 5;
    public static final int INNER_COLOR = 0;
    public static final float INNER_STROKE_WIDTH = 1.0f;
    public static final int OUTER_COLOR = -12369599;
    public static final float OUTER_STROKE_WIDTH = 2.0f;
    public static final int POINTCOUNTS_PERCELL = 10;
    public static final int TOTALCELLS_PERMV = 10;

    boolean gain(int i);

    float getCellWidth();

    int getEcgLineCount();

    float getEcgPortSpace();

    int getInnerCellCounts();

    int getInnerColor();

    float getInnerThinkLineWidth();

    float[] getMarkTextStyle();

    int getOuterColor();

    float getOuterThinkLineWidth();

    int getXCellCounts();

    int getXTotalPointCounts();

    int getYCellCounts();

    int getYCellCountsPerMv();

    float getYMaxMvs();

    int getYOuterCellCount();

    boolean isCanLineBound();

    void onViewMeasured(int i, int i2, int[] iArr);

    boolean scale(int i);

    void setCanLineBound(boolean z);

    void setEcgLineCount(int i);

    void setEcgPortSpace(float f);

    void setInnerColor(int i);

    void setMarkTextStyle(String str);

    void setOutColor(int i);

    void setYOuterCellCounts(int i);
}
