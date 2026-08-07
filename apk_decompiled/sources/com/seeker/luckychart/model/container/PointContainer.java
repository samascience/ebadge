package com.seeker.luckychart.model.container;

import com.seeker.luckychart.model.PointValue;

/* JADX INFO: loaded from: classes.dex */
public class PointContainer extends AbsContainer<PointValue> {
    private static final int SHAPE_CIRCLE = 1;
    private static final int SHAPE_SQUARE = 2;
    private int pointShape;

    private PointContainer() {
        this.pointShape = 1;
    }

    public static PointContainer create() {
        return new PointContainer();
    }

    public int getPointShape() {
        return this.pointShape;
    }

    public void setPointShape(int i) {
        this.pointShape = i;
    }

    public static PointContainer create(PointValue[] pointValueArr) {
        return new PointContainer(pointValueArr);
    }

    private PointContainer(PointValue[] pointValueArr) {
        super(pointValueArr);
        this.pointShape = 1;
    }
}
