package com.baji.protocol.model;

import defpackage.vh0;
import kotlin.enums.a;

/* JADX INFO: loaded from: classes.dex */
public enum SystemInfoCommand {
    DEVICE_INFO_REQUEST((byte) 0),
    DEVICE_INFO_RESPONSE((byte) 1);

    private static final /* synthetic */ vh0 $ENTRIES = a.a(values());
    private final byte value;

    SystemInfoCommand(byte b) {
        this.value = b;
    }

    public static vh0 getEntries() {
        return $ENTRIES;
    }

    public final byte getValue() {
        return this.value;
    }
}
