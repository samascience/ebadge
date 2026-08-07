package com.alibaba.dashscope.audio.asr.recognition;

/* JADX INFO: loaded from: classes.dex */
public enum RecognitionState {
    IDLE("idle"),
    RECOGNITION_STARTED("recognition_started");

    private final String value;

    RecognitionState(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }
}
