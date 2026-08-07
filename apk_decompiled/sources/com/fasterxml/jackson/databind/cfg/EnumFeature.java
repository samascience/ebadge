package com.fasterxml.jackson.databind.cfg;

import defpackage.u60;

/* JADX INFO: loaded from: classes.dex */
public enum EnumFeature implements u60 {
    BOGUS_FEATURE(false);

    private static final int FEATURE_INDEX = 0;
    private final boolean _enabledByDefault;
    private final int _mask = 1 << ordinal();

    EnumFeature(boolean z) {
        this._enabledByDefault = z;
    }

    @Override // defpackage.c41
    public boolean enabledByDefault() {
        return this._enabledByDefault;
    }

    @Override // defpackage.c41
    public boolean enabledIn(int i) {
        return (i & this._mask) != 0;
    }

    @Override // defpackage.u60
    public int featureIndex() {
        return 0;
    }

    @Override // defpackage.c41
    public int getMask() {
        return this._mask;
    }
}
