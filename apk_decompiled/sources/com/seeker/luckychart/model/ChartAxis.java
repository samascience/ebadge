package com.seeker.luckychart.model;

import android.graphics.Paint;
import com.seeker.luckychart.utils.ChartUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public class ChartAxis {
    public static final int BOTTOM = 4;
    private static final float DEFAULT_AXIS_MARGIN_DP = 2.0f;
    public static final int LEFT = 1;
    public static final int RIGHT = 3;
    public static final int TOP = 2;
    private float coorBaseLine;
    private int coorDimensionForMargins;
    private int coorHeight;
    private Paint coorPaint;
    private int coorTextAscent;
    private int coorTextBottom;
    private int coorTextDescent;
    private int coorTextTop;
    private int coorWidth;
    private CoorValue[] coordinateValues;
    private Paint lineMajorPaint;
    private Paint lineSubPaint;
    private String name;
    private float nameBaseLine;
    private Paint namePaint;
    private int nameTextAscent;
    private int nameTextDescent;
    private float separationLine;
    private float axisMargin = 2.0f;
    private Paint.FontMetrics fontMetrics = new Paint.FontMetrics();
    private int maxCoorchars = 5;
    private int module = 1;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Location {
    }

    public float getAxisMargin() {
        return this.axisMargin;
    }

    public float getCoorBaseLine() {
        return this.coorBaseLine;
    }

    public int getCoorDimensionForMargins() {
        return this.coorDimensionForMargins;
    }

    public int getCoorHeight() {
        return this.coorHeight;
    }

    public Paint getCoorPaint() {
        return this.coorPaint;
    }

    public int getCoorTextAscent() {
        return this.coorTextAscent;
    }

    public int getCoorTextBottom() {
        return this.coorTextBottom;
    }

    public int getCoorTextDescent() {
        return this.coorTextDescent;
    }

    public int getCoorTextTop() {
        return this.coorTextTop;
    }

    public int getCoorWidth() {
        return this.coorWidth;
    }

    public CoorValue[] getCoordinateValues() {
        return this.coordinateValues;
    }

    public Paint getLineMajorPaint() {
        return this.lineMajorPaint;
    }

    public Paint getLineSubPaint() {
        return this.lineSubPaint;
    }

    public int getMaxCoorchars() {
        return this.maxCoorchars;
    }

    public int getModule() {
        return this.module;
    }

    public String getName() {
        return this.name;
    }

    public float getNameBaseLine() {
        return this.nameBaseLine;
    }

    public Paint getNamePaint() {
        return this.namePaint;
    }

    public int getNameTextAscent() {
        return this.nameTextAscent;
    }

    public int getNameTextDescent() {
        return this.nameTextDescent;
    }

    public float getSeparationLine() {
        return this.separationLine;
    }

    public void initFontMetricsInt() {
        Paint paint = this.coorPaint;
        if (paint == null) {
            throw new NullPointerException("have you set draw coor paint?");
        }
        paint.getFontMetrics(this.fontMetrics);
        this.coorTextAscent = (int) Math.abs(this.fontMetrics.ascent);
        this.coorTextDescent = (int) Math.abs(this.fontMetrics.descent);
        this.coorWidth = (int) this.coorPaint.measureText(ChartUtils.VALUEWIDTHCHARS, 0, this.maxCoorchars);
        Paint.FontMetrics fontMetrics = this.fontMetrics;
        this.coorHeight = (int) Math.floor(fontMetrics.descent - fontMetrics.ascent);
        Paint.FontMetrics fontMetrics2 = this.fontMetrics;
        this.coorTextTop = (int) fontMetrics2.top;
        this.coorTextBottom = (int) fontMetrics2.bottom;
        Paint paint2 = this.namePaint;
        if (paint2 != null) {
            paint2.getFontMetrics(fontMetrics2);
            this.nameTextAscent = (int) Math.abs(this.fontMetrics.ascent);
            this.nameTextDescent = (int) Math.abs(this.fontMetrics.descent);
        }
    }

    public void setAxisMargin(float f) {
        this.axisMargin = f;
    }

    public void setCoorBaseLine(float f) {
        this.coorBaseLine = f;
    }

    public void setCoorDimensionForMargins(int i) {
        this.coorDimensionForMargins = i;
    }

    public void setCoorPaint(Paint paint) {
        this.coorPaint = paint;
    }

    public void setCoordinateValues(CoorValue[] coorValueArr) {
        this.coordinateValues = coorValueArr;
    }

    public void setLineMajorPaint(Paint paint) {
        this.lineMajorPaint = paint;
    }

    public void setLineSubPaint(Paint paint) {
        this.lineSubPaint = paint;
    }

    public void setMaxCoorchars(int i) {
        this.maxCoorchars = i;
    }

    public void setModule(int i) {
        this.module = i;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNameBaseLine(float f) {
        this.nameBaseLine = f;
    }

    public void setNamePaint(Paint paint) {
        this.namePaint = paint;
    }

    public void setSeparationLine(float f) {
        this.separationLine = f;
    }
}
