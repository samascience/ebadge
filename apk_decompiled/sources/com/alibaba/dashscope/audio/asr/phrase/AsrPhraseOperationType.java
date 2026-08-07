package com.alibaba.dashscope.audio.asr.phrase;

/* JADX INFO: loaded from: classes.dex */
public enum AsrPhraseOperationType {
    CREATE("Create"),
    UPDATE("Update"),
    DELETE("Delete"),
    QUERY("Query"),
    LIST("List");

    private final String value;

    AsrPhraseOperationType(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }
}
