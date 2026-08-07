package com.baji.network.model;

import defpackage.vh0;
import kotlin.enums.a;

/* JADX INFO: loaded from: classes.dex */
public enum ErrorType {
    NETWORK_ERROR,
    TIMEOUT_ERROR,
    PARSE_ERROR,
    AUTH_ERROR,
    SERVER_ERROR,
    UNKNOWN_ERROR;

    private static final /* synthetic */ vh0 $ENTRIES = a.a(values());

    public static vh0 getEntries() {
        return $ENTRIES;
    }
}
