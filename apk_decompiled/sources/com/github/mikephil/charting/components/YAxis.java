package com.github.mikephil.charting.components;

import android.graphics.Paint;
import defpackage.ta3;
import defpackage.yd;

/* JADX INFO: loaded from: classes.dex */
public class YAxis extends yd {
    private AxisDependency W;
    private boolean K = true;
    private boolean L = true;
    protected boolean M = false;
    protected boolean N = false;
    private boolean O = false;
    private boolean P = false;
    protected int Q = -7829368;
    protected float R = 1.0f;
    protected float S = 10.0f;
    protected float T = 10.0f;
    private YAxisLabelPosition U = YAxisLabelPosition.OUTSIDE_CHART;
    private float V = 0.0f;
    protected float X = 0.0f;
    protected float Y = Float.POSITIVE_INFINITY;

    public enum AxisDependency {
        LEFT,
        RIGHT
    }

    public enum YAxisLabelPosition {
        OUTSIDE_CHART,
        INSIDE_CHART
    }

    public YAxis(AxisDependency axisDependency) {
        this.W = axisDependency;
        this.c = 0.0f;
    }

    public YAxisLabelPosition j() {
        return this.U;
    }

    public float k() {
        return this.Y;
    }

    public float l() {
        return this.X;
    }

    public float m(Paint paint) {
        paint.setTextSize(this.e);
        return ta3.a(paint, e()) + (b() * 2.0f);
    }

    public float n(Paint paint) {
        paint.setTextSize(this.e);
        float fB = ta3.b(paint, e()) + (a() * 2.0f);
        float fL = l();
        float fK = k();
        if (fL > 0.0f) {
            fL = ta3.c(fL);
        }
        if (fK > 0.0f && fK != Float.POSITIVE_INFINITY) {
            fK = ta3.c(fK);
        }
        if (fK <= 0.0d) {
            fK = fB;
        }
        return Math.max(fL, Math.min(fB, fK));
    }

    public boolean o() {
        return this.M;
    }

    public boolean p() {
        return c() && g() && j() == YAxisLabelPosition.OUTSIDE_CHART;
    }

    public void q(float f) {
        this.V = f;
    }
}
