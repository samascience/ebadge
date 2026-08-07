package com.github.mikephil.charting.components;

import defpackage.ta3;
import defpackage.yd;

/* JADX INFO: loaded from: classes.dex */
public class XAxis extends yd {
    public int K = 1;
    public int L = 1;
    public int M = 1;
    public int N = 1;
    protected float O = 0.0f;
    private boolean P = false;
    private XAxisPosition Q = XAxisPosition.TOP;

    public enum XAxisPosition {
        TOP,
        BOTTOM,
        BOTH_SIDED,
        TOP_INSIDE,
        BOTTOM_INSIDE
    }

    public XAxis() {
        this.c = ta3.c(4.0f);
    }

    public XAxisPosition j() {
        return this.Q;
    }
}
