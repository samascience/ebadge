package com.alibaba.dashscope.common;

/* JADX INFO: loaded from: classes.dex */
public enum Function {
    GENERATION("generation"),
    IMAGE_SYNTHESIS("image-synthesis"),
    TEXT_EMBEDDING("text-embedding"),
    MULTIMODAL_EMBEDDING("multimodal-embedding"),
    SPEECH_SYNTHESIZER("SpeechSynthesizer"),
    TRANSCRIPTION("transcription"),
    RECOGNITION("recognition"),
    SPEECH_TRANSLATION("recognition"),
    UNDERSTANDING("understanding");

    private final String value;

    Function(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }
}
