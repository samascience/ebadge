package com.seeker.luckychart.model;

/* JADX INFO: loaded from: classes.dex */
public class PointValue implements IValueChanged {
    protected float coorX;
    protected float coorY;
    protected float diffX;
    protected float diffY;
    public boolean isIdle;
    protected float originX;
    protected float originY;

    public PointValue() {
        this.isIdle = true;
        this.coorY = Float.NaN;
    }

    private PointValue set(float f, float f2) {
        this.coorX = f;
        this.coorY = f2;
        this.originX = f;
        this.originY = f2;
        return this;
    }

    public void copyFrom(PointValue pointValue) {
        this.coorX = pointValue.coorX;
        this.coorY = pointValue.coorY;
        this.originX = pointValue.originX;
        this.originY = pointValue.originY;
        this.diffX = pointValue.diffX;
        this.diffY = pointValue.diffY;
    }

    @Override // com.seeker.luckychart.model.IValueChanged
    public void finish() {
        set(this.originX + this.diffX, this.originY + this.diffY);
    }

    public float getCoorX() {
        return this.coorX;
    }

    public float getCoorY() {
        return this.coorY;
    }

    public void init() {
        this.coorX = 0.0f;
        this.coorY = 0.0f;
        this.originX = 0.0f;
        this.originY = 0.0f;
        this.diffX = 0.0f;
        this.diffY = 0.0f;
    }

    public void setCoorX(float f) {
        this.coorX = f;
    }

    public void setCoorY(float f) {
        this.coorY = f;
    }

    public PointValue setTarget(float f, float f2) {
        this.diffX = f - this.originX;
        this.diffY = f2 - this.originY;
        return this;
    }

    public String toString() {
        return "{coorX=" + this.coorX + ", coorY=" + this.coorY + ", originX=" + this.originX + ", originY=" + this.originY + ", diffX=" + this.diffX + ", diffY=" + this.diffY + '}';
    }

    @Override // com.seeker.luckychart.model.IValueChanged
    public void update(float f) {
        this.coorX = this.originX + (this.diffX * f);
        this.coorY = this.originY + (this.diffY * f);
    }

    public PointValue(float f, float f2) {
        this.isIdle = true;
        set(f, f2);
    }
}
