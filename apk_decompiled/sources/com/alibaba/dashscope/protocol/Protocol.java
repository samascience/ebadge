package com.alibaba.dashscope.protocol;

/* JADX INFO: loaded from: classes.dex */
public enum Protocol {
    HTTP("http"),
    WEBSOCKET("websocket");

    private final String value;

    Protocol(String str) {
        this.value = str;
    }

    public static Protocol of(String str) {
        for (Protocol protocol : values()) {
            if (protocol.getValue().equals(str)) {
                return protocol;
            }
        }
        return null;
    }

    public String getValue() {
        return this.value;
    }
}
