package com.alibaba.dashscope.audio.ttsv2.enrollment;

/* JADX INFO: loaded from: classes.dex */
public enum VoiceEnrollmentOperationType {
    CREATE("create_voice"),
    LIST("list_voice"),
    QUERY("query_voice"),
    UPDATE("update_voice"),
    DELETE("delete_voice");

    private final String value;

    VoiceEnrollmentOperationType(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }
}
