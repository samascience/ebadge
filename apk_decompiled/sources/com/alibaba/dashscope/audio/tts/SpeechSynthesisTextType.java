package com.alibaba.dashscope.audio.tts;

/* JADX INFO: loaded from: classes.dex */
public enum SpeechSynthesisTextType {
    PLAIN_TEXT("PlainText"),
    SSML("SSML");

    private final String value;

    SpeechSynthesisTextType(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }
}
