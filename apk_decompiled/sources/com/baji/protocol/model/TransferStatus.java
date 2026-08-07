package com.baji.protocol.model;

import defpackage.vh0;
import kotlin.enums.a;

/* JADX INFO: loaded from: classes.dex */
public enum TransferStatus {
    IDLE((byte) 0),
    PREPARING((byte) 1),
    TRANSFERRING((byte) 2),
    PAUSED((byte) 3),
    COMPLETED((byte) 4),
    FAILED((byte) 5),
    CANCELLED((byte) 6);

    private static final /* synthetic */ vh0 $ENTRIES = a.a(values());
    private final byte value;

    TransferStatus(byte b) {
        this.value = b;
    }

    public static vh0 getEntries() {
        return $ENTRIES;
    }

    public final byte getValue() {
        return this.value;
    }
}
