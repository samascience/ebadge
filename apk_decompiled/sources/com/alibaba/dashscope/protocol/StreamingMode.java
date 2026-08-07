package com.alibaba.dashscope.protocol;

import io.reactivex.annotations.SchedulerSupport;

/* JADX INFO: loaded from: classes.dex */
public enum StreamingMode {
    NONE(SchedulerSupport.NONE),
    IN("in"),
    OUT("out"),
    DUPLEX("duplex");

    private final String value;

    StreamingMode(String str) {
        this.value = str;
    }

    public static StreamingMode of(String str) {
        for (StreamingMode streamingMode : values()) {
            if (streamingMode.value.equals(str)) {
                return streamingMode;
            }
        }
        return null;
    }

    public String getValue() {
        return this.value;
    }
}
