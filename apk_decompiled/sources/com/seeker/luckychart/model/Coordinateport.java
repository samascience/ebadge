package com.seeker.luckychart.model;

/* JADX INFO: loaded from: classes.dex */
public class Coordinateport {
    public float bottom;
    public float left;
    public float right;
    public float top;

    public Coordinateport() {
    }

    public final float centerX() {
        return (this.right + this.left) / 2.0f;
    }

    public final float centerY() {
        return (this.top + this.bottom) / 2.0f;
    }

    public boolean contains(float f, float f2) {
        return f >= this.left && f <= this.right && f2 >= this.bottom && f2 <= this.top;
    }

    public float getBottom() {
        return this.bottom;
    }

    public float getLeft() {
        return this.left;
    }

    public float getRight() {
        return this.right;
    }

    public float getTop() {
        return this.top;
    }

    public final float height() {
        return this.top - this.bottom;
    }

    public void set(float f, float f2, float f3, float f4) {
        this.left = f;
        this.top = f2;
        this.right = f3;
        this.bottom = f4;
    }

    public void setBottom(float f) {
        this.bottom = f;
    }

    public void setLeft(float f) {
        this.left = f;
    }

    public void setRight(float f) {
        this.right = f;
    }

    public void setTop(float f) {
        this.top = f;
    }

    public String toString() {
        return "Coordinateport{left=" + this.left + ", top=" + this.top + ", right=" + this.right + ", bottom=" + this.bottom + '}';
    }

    public final float width() {
        return this.right - this.left;
    }

    public Coordinateport(float f, float f2, float f3, float f4) {
        set(f, f2, f3, f4);
    }

    public void set(Coordinateport coordinateport) {
        this.left = coordinateport.left;
        this.top = coordinateport.top;
        this.right = coordinateport.right;
        this.bottom = coordinateport.bottom;
    }
}
