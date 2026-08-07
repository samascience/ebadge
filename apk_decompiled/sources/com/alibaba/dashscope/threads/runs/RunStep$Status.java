package com.alibaba.dashscope.threads.runs;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public enum RunStep$Status {
    IN_PROGRESS("in_progress"),
    CANCELLED("cancelled"),
    FAILED("failed"),
    COMPLETED("completed"),
    EXPIRED("expired");

    private static final Map<String, RunStep$Status> CONSTANTS = new HashMap();
    private final String value;

    static {
        for (RunStep$Status runStep$Status : values()) {
            CONSTANTS.put(runStep$Status.value, runStep$Status);
        }
    }

    RunStep$Status(String str) {
        this.value = str;
    }

    public static RunStep$Status fromValue(String str) {
        RunStep$Status runStep$Status = CONSTANTS.get(str);
        if (runStep$Status != null) {
            return runStep$Status;
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
