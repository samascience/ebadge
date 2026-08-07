package com.seeker.luckychart.soft;

import androidx.recyclerview.widget.ItemTouchHelper;

/* JADX INFO: loaded from: classes.dex */
public class LuckySoftStrategy implements SoftStrategy {
    private float maxDataValueForMv = 1.5f;
    private int pointCount;

    public LuckySoftStrategy(int i) {
        this.pointCount = i;
    }

    @Override // com.seeker.luckychart.soft.SoftStrategy
    public int VerticalPadding() {
        return 0;
    }

    @Override // com.seeker.luckychart.soft.SoftStrategy
    public int cellCountPerGrid() {
        return 5;
    }

    @Override // com.seeker.luckychart.soft.SoftStrategy
    public int cellCountsPerMv() {
        return 10;
    }

    @Override // com.seeker.luckychart.soft.SoftStrategy
    public Transformer getTransformer() {
        return new Transformer() { // from class: com.seeker.luckychart.soft.LuckySoftStrategy.1
        };
    }

    @Override // com.seeker.luckychart.soft.SoftStrategy
    public int gridCountPerRow() {
        float f = this.maxDataValueForMv;
        if (f > 2.0f) {
            return 10;
        }
        return f > 1.5f ? 8 : 6;
    }

    @Override // com.seeker.luckychart.soft.SoftStrategy
    public int horizontalPadding() {
        return 20;
    }

    @Override // com.seeker.luckychart.soft.SoftStrategy
    public float maxDataValueForMv() {
        return this.maxDataValueForMv;
    }

    @Override // com.seeker.luckychart.soft.SoftStrategy
    public int pictureHeight() {
        return (pixelPerCell() * cellCountPerGrid() * gridCountPerRow() * totalRows()) + (VerticalPadding() * 2);
    }

    @Override // com.seeker.luckychart.soft.SoftStrategy
    public int pictureWidth() {
        return Math.round((pointsPerRow() * pixelPerPoint()) + (horizontalPadding() * 2));
    }

    @Override // com.seeker.luckychart.soft.SoftStrategy
    public int pixelPerCell() {
        return 10;
    }

    @Override // com.seeker.luckychart.soft.SoftStrategy
    public float pixelPerPoint() {
        return 1.0f;
    }

    @Override // com.seeker.luckychart.soft.SoftStrategy
    public int pointsPerRow() {
        return pointsPerSecond() * secondsPerRow();
    }

    @Override // com.seeker.luckychart.soft.SoftStrategy
    public int pointsPerSecond() {
        return ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION;
    }

    @Override // com.seeker.luckychart.soft.SoftStrategy
    public int secondsPerRow() {
        return 10;
    }

    public void setMaxDataValueForMv(float f) {
        this.maxDataValueForMv = f;
    }

    @Override // com.seeker.luckychart.soft.SoftStrategy
    public int totalRows() {
        return this.pointCount % pointsPerRow() == 0 ? this.pointCount / pointsPerRow() : (this.pointCount / pointsPerRow()) + 1;
    }
}
