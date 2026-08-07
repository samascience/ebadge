package com.airbnb.lottie.model.content;

import defpackage.i6;
import defpackage.n6;

/* JADX INFO: loaded from: classes.dex */
public class Mask {
    private final MaskMode a;
    private final n6 b;
    private final i6 c;

    public enum MaskMode {
        MaskModeAdd,
        MaskModeSubtract,
        MaskModeIntersect
    }

    public Mask(MaskMode maskMode, n6 n6Var, i6 i6Var) {
        this.a = maskMode;
        this.b = n6Var;
        this.c = i6Var;
    }

    public MaskMode a() {
        return this.a;
    }

    public n6 b() {
        return this.b;
    }

    public i6 c() {
        return this.c;
    }
}
