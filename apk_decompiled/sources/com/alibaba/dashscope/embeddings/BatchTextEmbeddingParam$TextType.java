package com.alibaba.dashscope.embeddings;

/* JADX INFO: loaded from: classes.dex */
public enum BatchTextEmbeddingParam$TextType {
    QUERY("query"),
    DOCUMENT("document");

    private final String value;

    BatchTextEmbeddingParam$TextType(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }
}
