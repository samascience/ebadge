package com.alibaba.dashscope.common;

/* JADX INFO: loaded from: classes.dex */
public enum TaskGroup {
    AIGC("aigc"),
    EMBEDDINGS("embeddings"),
    AUDIO("audio"),
    NLP("nlp"),
    RERANK("rerank");

    private final String value;

    TaskGroup(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }
}
