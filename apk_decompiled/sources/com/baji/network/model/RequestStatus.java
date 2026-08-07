package com.baji.network.model;

import defpackage.vh0;
import kotlin.enums.a;

/* JADX INFO: loaded from: classes.dex */
public enum RequestStatus {
    PENDING,
    LOADING,
    SUCCESS,
    ERROR,
    CANCELLED;

    private static final /* synthetic */ vh0 $ENTRIES = a.a(values());

    public static vh0 getEntries() {
        return $ENTRIES;
    }
}
