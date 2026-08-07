package com.alibaba.dashscope.threads.messages;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public enum ThreadMessage$Status {
    IN_PROGRESS("in_progress"),
    INCOMPLETE("incomplete"),
    COMPLETED("completed");

    private static final Map<String, ThreadMessage$Status> CONSTANTS = new HashMap();
    private final String value;

    static {
        for (ThreadMessage$Status threadMessage$Status : values()) {
            CONSTANTS.put(threadMessage$Status.value, threadMessage$Status);
        }
    }

    ThreadMessage$Status(String str) {
        this.value = str;
    }

    public static ThreadMessage$Status fromValue(String str) {
        ThreadMessage$Status threadMessage$Status = CONSTANTS.get(str);
        if (threadMessage$Status != null) {
            return threadMessage$Status;
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
