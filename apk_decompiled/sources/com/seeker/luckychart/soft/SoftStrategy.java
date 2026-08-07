package com.seeker.luckychart.soft;

/* JADX INFO: loaded from: classes.dex */
public interface SoftStrategy {
    int VerticalPadding();

    int cellCountPerGrid();

    int cellCountsPerMv();

    Transformer getTransformer();

    int gridCountPerRow();

    int horizontalPadding();

    float maxDataValueForMv();

    int pictureHeight();

    int pictureWidth();

    int pixelPerCell();

    float pixelPerPoint();

    int pointsPerRow();

    int pointsPerSecond();

    int secondsPerRow();

    int totalRows();
}
