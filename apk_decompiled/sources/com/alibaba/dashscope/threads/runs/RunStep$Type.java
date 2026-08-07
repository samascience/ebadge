package com.alibaba.dashscope.threads.runs;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public enum RunStep$Type {
    MESSAGE_CREATION("message_creation"),
    TOOL_CALLS("tool_calls");

    private static final Map<String, RunStep$Type> CONSTANTS = new HashMap();
    private final String value;

    static {
        for (RunStep$Type runStep$Type : values()) {
            CONSTANTS.put(runStep$Type.value, runStep$Type);
        }
    }

    RunStep$Type(String str) {
        this.value = str;
    }

    public static RunStep$Type fromValue(String str) {
        RunStep$Type runStep$Type = CONSTANTS.get(str);
        if (runStep$Type != null) {
            return runStep$Type;
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
