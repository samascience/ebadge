package com.baji.protocol.model;

import defpackage.vh0;
import kotlin.enums.a;

/* JADX INFO: loaded from: classes.dex */
public enum ModuleId {
    FILE_TRANSFER((byte) 1),
    MEDIA_MANAGEMENT((byte) 2),
    SYSTEM_INFO((byte) 3);

    private static final /* synthetic */ vh0 $ENTRIES = a.a(values());
    private final byte value;

    ModuleId(byte b) {
        this.value = b;
    }

    public static vh0 getEntries() {
        return $ENTRIES;
    }

    public final byte getValue() {
        return this.value;
    }
}
