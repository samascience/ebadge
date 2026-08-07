package com.github.mikephil.charting.components;

import android.graphics.DashPathEffect;
import defpackage.b10;
import defpackage.ta3;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Legend extends b10 {
    private a[] g = new a[0];
    private boolean h = false;
    private LegendHorizontalAlignment i = LegendHorizontalAlignment.LEFT;
    private LegendVerticalAlignment j = LegendVerticalAlignment.BOTTOM;
    private LegendOrientation k = LegendOrientation.HORIZONTAL;
    private boolean l = false;
    private LegendDirection m = LegendDirection.LEFT_TO_RIGHT;
    private LegendForm n = LegendForm.SQUARE;
    private float o = 8.0f;
    private float p = 3.0f;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private DashPathEffect f235q = null;
    private float r = 6.0f;
    private float s = 0.0f;
    private float t = 5.0f;
    private float u = 3.0f;
    private float v = 0.95f;
    public float w = 0.0f;
    public float x = 0.0f;
    public float y = 0.0f;
    public float z = 0.0f;
    private boolean A = false;
    private List B = new ArrayList(16);
    private List C = new ArrayList(16);
    private List D = new ArrayList(16);

    public enum LegendDirection {
        LEFT_TO_RIGHT,
        RIGHT_TO_LEFT
    }

    public enum LegendForm {
        NONE,
        EMPTY,
        DEFAULT,
        SQUARE,
        CIRCLE,
        LINE
    }

    public enum LegendHorizontalAlignment {
        LEFT,
        CENTER,
        RIGHT
    }

    public enum LegendOrientation {
        HORIZONTAL,
        VERTICAL
    }

    public enum LegendVerticalAlignment {
        TOP,
        CENTER,
        BOTTOM
    }

    public Legend() {
        this.e = ta3.c(10.0f);
        this.b = ta3.c(5.0f);
        this.c = ta3.c(3.0f);
    }

    public LegendHorizontalAlignment d() {
        return this.i;
    }

    public float e() {
        return this.v;
    }

    public LegendOrientation f() {
        return this.k;
    }

    public LegendVerticalAlignment g() {
        return this.j;
    }

    public boolean h() {
        return this.l;
    }
}
