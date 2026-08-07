package com.alibaba.idst.nui;

/* JADX INFO: loaded from: classes.dex */
public enum INativeTtsCallback$TtsCacheEvent {
    TTS_CACHE_EVENT_START(0),
    TTS_CACHE_EVENT_END(1),
    TTS_CACHE_EVENT_CANCEL(2),
    TTS_CACHE_EVENT_DELETE(3),
    TTS_CACHE_EVENT_ERROR(4);

    private int code;

    INativeTtsCallback$TtsCacheEvent(int i) {
        this.code = i;
    }

    public static INativeTtsCallback$TtsCacheEvent fromInt(int i) {
        if (i == 0) {
            return TTS_CACHE_EVENT_START;
        }
        if (i == 1) {
            return TTS_CACHE_EVENT_END;
        }
        if (i != 2) {
            return i != 3 ? TTS_CACHE_EVENT_ERROR : TTS_CACHE_EVENT_DELETE;
        }
        return TTS_CACHE_EVENT_CANCEL;
    }

    public int getCode() {
        return this.code;
    }
}
