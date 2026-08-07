package com.alibaba.dashscope.audio.ttsv2;

/* JADX INFO: loaded from: classes.dex */
public enum SpeechSynthesisState {
    IDLE("idle"),
    TTS_STARTED("stream_input_tts_started");

    private final String value;

    SpeechSynthesisState(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }
}
