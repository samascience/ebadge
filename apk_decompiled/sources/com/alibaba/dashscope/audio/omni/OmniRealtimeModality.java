package com.alibaba.dashscope.audio.omni;

/* JADX INFO: loaded from: classes.dex */
public enum OmniRealtimeModality {
    TEXT("text"),
    AUDIO("audio");

    private final String name;

    OmniRealtimeModality(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.name;
    }
}
