package com.seeker.luckychart.model.container;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbsContainer<Value> {
    private static final int DEFAULT_LINE_COLOR = -16638126;
    private static final float DEFAULT_LINE_STROKEWIDTH = 3.5f;
    private static final int DEFAULT_POINT_COLOR = -16777216;
    private static final float DEFAULT_POINT_RADIUS = 3.0f;
    private Value[] values;
    private int pointColor = DEFAULT_POINT_COLOR;
    private float pointRadius = DEFAULT_POINT_RADIUS;
    private int lineColor = DEFAULT_LINE_COLOR;
    private float lineStrokeWidth = DEFAULT_LINE_STROKEWIDTH;

    AbsContainer() {
    }

    public void clear() {
        this.values = null;
    }

    public int getLineColor() {
        return this.lineColor;
    }

    public float getLineStrokeWidth() {
        return this.lineStrokeWidth;
    }

    public int getPointColor() {
        return this.pointColor;
    }

    public float getPointRadius() {
        return this.pointRadius;
    }

    public Value[] getValues() {
        return this.values;
    }

    public void setLineColor(int i) {
        this.lineColor = i;
    }

    public void setLineStrokeWidth(float f) {
        this.lineStrokeWidth = f;
    }

    public void setPointColor(int i) {
        this.pointColor = i;
    }

    public void setPointRadius(float f) {
        this.pointRadius = f;
    }

    public void setValues(Value[] valueArr) {
        this.values = valueArr;
    }

    public void updateNewValues(Value[] valueArr) {
    }

    AbsContainer(Value[] valueArr) {
        this.values = valueArr;
    }
}
