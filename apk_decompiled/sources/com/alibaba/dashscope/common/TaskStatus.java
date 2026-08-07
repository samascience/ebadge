package com.alibaba.dashscope.common;

import kotlinx.coroutines.debug.internal.DebugCoroutineInfoImplKt;

/* JADX INFO: loaded from: classes.dex */
public enum TaskStatus {
    PENDING("PENDING"),
    SUSPENDED(DebugCoroutineInfoImplKt.SUSPENDED),
    SUCCEEDED("SUCCEEDED"),
    CANCELED("CANCELED"),
    RUNNING(DebugCoroutineInfoImplKt.RUNNING),
    FAILED("FAILED"),
    UNKNOWN("UNKNOWN");

    private final String value;

    TaskStatus(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }
}
