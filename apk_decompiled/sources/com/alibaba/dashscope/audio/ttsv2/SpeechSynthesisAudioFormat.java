package com.alibaba.dashscope.audio.ttsv2;

import defpackage.uv2;

/* JADX INFO: loaded from: classes.dex */
public enum SpeechSynthesisAudioFormat {
    DEFAULT("Default", 0, "0", 0),
    WAV_8000HZ_MONO_16BIT("wav", 8000, "mono", 16),
    WAV_16000HZ_MONO_16BIT("wav", 16000, "mono", 16),
    WAV_22050HZ_MONO_16BIT("wav", 22050, "mono", 16),
    WAV_24000HZ_MONO_16BIT("wav", 24000, "mono", 16),
    WAV_44100HZ_MONO_16BIT("wav", 44100, "mono", 16),
    WAV_48000HZ_MONO_16BIT("wav", 48000, "mono", 16),
    MP3_8000HZ_MONO_128KBPS("mp3", 8000, "mono", 128),
    MP3_16000HZ_MONO_128KBPS("mp3", 16000, "mono", 128),
    MP3_22050HZ_MONO_256KBPS("mp3", 22050, "mono", 256),
    MP3_24000HZ_MONO_256KBPS("mp3", 24000, "mono", 256),
    MP3_44100HZ_MONO_256KBPS("mp3", 44100, "mono", 256),
    MP3_48000HZ_MONO_256KBPS("mp3", 48000, "mono", 256),
    PCM_8000HZ_MONO_16BIT("pcm", 8000, "mono", 16),
    PCM_16000HZ_MONO_16BIT("pcm", 16000, "mono", 16),
    PCM_22050HZ_MONO_16BIT("pcm", 22050, "mono", 16),
    PCM_24000HZ_MONO_16BIT("pcm", 24000, "mono", 16),
    PCM_44100HZ_MONO_16BIT("pcm", 44100, "mono", 16),
    PCM_48000HZ_MONO_16BIT("pcm", 48000, "mono", 16),
    OGG_OPUS_8KHZ_MONO_16KBPS("opus", 8000, "mono", 16),
    OGG_OPUS_8KHZ_MONO_32KBPS("opus", 8000, "mono", 32),
    OGG_OPUS_16KHZ_MONO_16KBPS("opus", 16000, "mono", 16),
    OGG_OPUS_16KHZ_MONO_32KBPS("opus", 16000, "mono", 32),
    OGG_OPUS_16KHZ_MONO_64KBPS("opus", 16000, "mono", 64),
    OGG_OPUS_24KHZ_MONO_16KBPS("opus", 24000, "mono", 16),
    OGG_OPUS_24KHZ_MONO_32KBPS("opus", 24000, "mono", 32),
    OGG_OPUS_24KHZ_MONO_64KBPS("opus", 24000, "mono", 64),
    OGG_OPUS_48KHZ_MONO_16KBPS("opus", 48000, "mono", 16),
    OGG_OPUS_48KHZ_MONO_32KBPS("opus", 48000, "mono", 32),
    OGG_OPUS_48KHZ_MONO_64KBPS("opus", 48000, "mono", 64);

    private final int bitRate;
    private final String channels;
    private final String format;
    private final int sampleRate;

    SpeechSynthesisAudioFormat(String str, int i, String str2, int i2) {
        this.format = str;
        this.sampleRate = i;
        this.channels = str2;
        this.bitRate = i2;
    }

    public int getBitRate() {
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
        return uv2.a("%s with %dHz sample rate, %s channel, %s", this.format.toUpperCase(), Integer.valueOf(this.sampleRate), this.channels, Integer.valueOf(this.bitRate));
    }
}
