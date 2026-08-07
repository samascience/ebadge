package com.alibaba.dashscope.app;

/* JADX INFO: loaded from: classes.dex */
public enum FlowStreamMode {
    FULL_THOUGHTS("full_thoughts"),
    AGENT_FORMAT("agent_format"),
    MESSAGE_FORMAT("message_format"),
    MESSAGE_FORMAT_PLUS("message_format_plus");

    private final String value;

    FlowStreamMode(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }
}
