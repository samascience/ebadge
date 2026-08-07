package com.alibaba.idst.nui;

/* JADX INFO: loaded from: classes.dex */
public enum INativeTtsCallback$TtsEvent {
    TTS_EVENT_START(0),
    TTS_EVENT_END(1),
    TTS_EVENT_CANCEL(2),
    TTS_EVENT_PAUSE(3),
    TTS_EVENT_RESUME(4),
    TTS_EVENT_ERROR(5);

    private int code;

    INativeTtsCallback$TtsEvent(int i) {
        this.code = i;
    }

    public static INativeTtsCallback$TtsEvent fromInt(int i) {
        if (i == 0) {
            return TTS_EVENT_START;
        }
        if (i == 1) {
            return TTS_EVENT_END;
        }
        if (i == 2) {
            return TTS_EVENT_CANCEL;
        }
        if (i != 3) {
            return i != 4 ? TTS_EVENT_ERROR : TTS_EVENT_RESUME;
        }
        return TTS_EVENT_PAUSE;
    }

    public int getCode() {
        return this.code;
    }
}
