package com.fasterxml.jackson.core;

import defpackage.c41;

/* JADX INFO: loaded from: classes.dex */
public enum StreamWriteCapability implements c41 {
    CAN_WRITE_BINARY_NATIVELY(false),
    CAN_WRITE_FORMATTED_NUMBERS(false);

    private final boolean _defaultState;
    private final int _mask = 1 << ordinal();

    StreamWriteCapability(boolean z) {
        this._defaultState = z;
    }

    @Override // defpackage.c41
    public boolean enabledByDefault() {
        return this._defaultState;
    }

    @Override // defpackage.c41
    public boolean enabledIn(int i) {
        return (i & this._mask) != 0;
    }

    @Override // defpackage.c41
    public int getMask() {
        return this._mask;
    }
}
