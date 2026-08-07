package com.alibaba.dashscope.common;

/* JADX INFO: loaded from: classes.dex */
public enum Role {
    USER("user"),
    ASSISTANT("assistant"),
    BOT("bot"),
    SYSTEM("system"),
    ATTACHMENT("attachment"),
    TOOL("tool");

    private final String value;

    Role(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }
}
