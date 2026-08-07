package com.baji.protocol.event;

import defpackage.ng;

/* JADX INFO: loaded from: classes.dex */
public abstract class BajiBaseEvent extends ng {
    private long eventTimestamp = System.currentTimeMillis();

    public abstract String getEventDescription();

    public final long getEventTimestamp() {
        return this.eventTimestamp;
    }

    public abstract String getEventType();

    public final void setEventTimestamp(long j) {
        this.eventTimestamp = j;
    }
}
