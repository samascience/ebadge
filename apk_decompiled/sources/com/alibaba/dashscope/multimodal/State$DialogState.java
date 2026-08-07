package com.alibaba.dashscope.multimodal;

/* JADX INFO: loaded from: classes.dex */
public enum State$DialogState {
    IDLE("Idle"),
    LISTENING("Listening"),
    THINKING("Thinking"),
    RESPONDING("Responding");

    private final String value;

    State$DialogState(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }
}
