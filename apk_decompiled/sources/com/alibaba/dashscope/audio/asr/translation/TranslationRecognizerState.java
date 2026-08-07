package com.alibaba.dashscope.audio.asr.translation;

/* JADX INFO: loaded from: classes.dex */
public enum TranslationRecognizerState {
    IDLE("idle"),
    SPEECH_TRANSLATION_STARTED("speech_translation_started");

    private final String value;

    TranslationRecognizerState(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }
}
