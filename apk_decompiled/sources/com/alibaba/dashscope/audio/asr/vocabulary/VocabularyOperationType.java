package com.alibaba.dashscope.audio.asr.vocabulary;

/* JADX INFO: loaded from: classes.dex */
public enum VocabularyOperationType {
    CREATE("create_vocabulary"),
    LIST("list_vocabulary"),
    QUERY("query_vocabulary"),
    UPDATE("update_vocabulary"),
    DELETE("delete_vocabulary");

    private final String value;

    VocabularyOperationType(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }
}
