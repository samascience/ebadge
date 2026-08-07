package com.alibaba.dashscope.threads.runs;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public enum Run$Status {
    queued("queued"),
    IN_PROGRESS("in_progress"),
    REQUIRES_ACTION("requires_action"),
    CANCELLING("cancelling"),
    CANCELLED("cancelled"),
    FAILED("failed"),
    COMPLETED("completed"),
    EXPIRED("expired");

    private static final Map<String, Run$Status> CONSTANTS = new HashMap();
    private final String value;

    static {
        for (Run$Status run$Status : values()) {
            CONSTANTS.put(run$Status.value, run$Status);
        }
    }

    Run$Status(String str) {
        this.value = str;
    }

    public static Run$Status fromValue(String str) {
        Run$Status run$Status = CONSTANTS.get(str);
        if (run$Status != null) {
            return run$Status;
        }
        throw new IllegalArgumentException(str);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public String value() {
        return this.value;
    }
}
