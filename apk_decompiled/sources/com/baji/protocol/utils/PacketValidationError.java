package com.baji.protocol.utils;

import defpackage.vh0;
import kotlin.enums.a;

/* JADX INFO: loaded from: classes.dex */
public enum PacketValidationError {
    NONE,
    INVALID_FORMAT,
    PACKET_TOO_LARGE,
    INVALID_START_MARKER,
    INVALID_PRODUCT_ID,
    INVALID_LENGTH;

    private static final /* synthetic */ vh0 $ENTRIES = a.a(values());

    public static vh0 getEntries() {
        return $ENTRIES;
    }
}
