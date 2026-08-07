package com.alibaba.dashscope.embeddings;

/* JADX INFO: loaded from: classes.dex */
public enum TextEmbeddingParam$OutputType {
    DENSE("dense"),
    SPARSE("sparse"),
    DENSE_AND_SPARSE("dense&sparse");

    private final String value;

    TextEmbeddingParam$OutputType(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }
}
