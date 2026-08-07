package com.alibaba.dashscope.audio.omni;

import defpackage.uv2;

/* JADX INFO: loaded from: classes.dex */
public enum OmniRealtimeAudioFormat {
    PCM_16000HZ_MONO_16BIT("pcm", 16000, "mono", "16bit"),
    PCM_24000HZ_MONO_16BIT("pcm", 24000, "mono", "16bit");

    private final String bitRate;
    private final String channels;
    private final String format;
    private final int sampleRate;

    OmniRealtimeAudioFormat(String str, int i, String str2, String str3) {
        this.format = str;
        this.sampleRate = i;
        this.channels = str2;
        this.bitRate = str3;
    }

    public String getBitRate() {
        return this.bitRate;
    }

    public String getChannels() {
        return this.channels;
    }

    public String getFormat() {
        return this.format;
    }

    public int getSampleRate() {
        return this.sampleRate;
    }

    @Override // java.lang.Enum
    public String toString() {
        return uv2.a("%s with %dHz sample rate, %s channel, %s", this.format.toUpperCase(), Integer.valueOf(this.sampleRate), this.channels, this.bitRate);
    }
}
