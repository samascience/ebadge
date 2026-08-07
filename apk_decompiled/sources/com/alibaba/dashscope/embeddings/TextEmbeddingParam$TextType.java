package com.alibaba.dashscope.embeddings;

/* JADX INFO: loaded from: classes.dex */
public enum TextEmbeddingParam$TextType {
    QUERY("query"),
    DOCUMENT("document");

    private final String value;

    TextEmbeddingParam$TextType(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }
}
