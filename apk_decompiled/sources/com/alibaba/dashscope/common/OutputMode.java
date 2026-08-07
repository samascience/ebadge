package com.alibaba.dashscope.common;

/* JADX INFO: loaded from: classes.dex */
public enum OutputMode {
    ACCUMULATE("accumulate"),
    DIVIDE("divide");

    private final String value;

    OutputMode(String str) {
        this.value = str;
    }

    public static OutputMode of(String str) {
        for (OutputMode outputMode : values()) {
            if (outputMode.value.equals(str)) {
                return outputMode;
            }
        }
        return null;
    }

    public String getValue() {
        return this.value;
    }
}
