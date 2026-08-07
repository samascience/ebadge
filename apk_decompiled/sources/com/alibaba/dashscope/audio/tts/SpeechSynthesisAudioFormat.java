package com.alibaba.dashscope.audio.tts;

/* JADX INFO: loaded from: classes.dex */
public enum SpeechSynthesisAudioFormat {
    PCM("pcm"),
    WAV("wav"),
    MP3("mp3");

    private final String value;

    SpeechSynthesisAudioFormat(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }
}
