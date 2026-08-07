package com.alibaba.idst.nui;

/* JADX INFO: loaded from: classes.dex */
public enum INativeStreamInputTtsCallback$StreamInputTtsEvent {
    STREAM_INPUT_TTS_EVENT_SYNTHESIS_STARTED(0),
    STREAM_INPUT_TTS_EVENT_SENTENCE_BEGIN(1),
    STREAM_INPUT_TTS_EVENT_SENTENCE_SYNTHESIS(2),
    STREAM_INPUT_TTS_EVENT_SENTENCE_END(3),
    STREAM_INPUT_TTS_EVENT_SYNTHESIS_COMPLETE(4),
    STREAM_INPUT_TTS_EVENT_TASK_FAILED(5);

    private int code;

    INativeStreamInputTtsCallback$StreamInputTtsEvent(int i) {
        this.code = i;
    }

    public static INativeStreamInputTtsCallback$StreamInputTtsEvent fromInt(int i) {
        if (i == 0) {
            return STREAM_INPUT_TTS_EVENT_SYNTHESIS_STARTED;
        }
        if (i == 1) {
            return STREAM_INPUT_TTS_EVENT_SENTENCE_BEGIN;
        }
        if (i == 2) {
            return STREAM_INPUT_TTS_EVENT_SENTENCE_SYNTHESIS;
        }
        if (i == 3) {
            return STREAM_INPUT_TTS_EVENT_SENTENCE_END;
        }
        if (i != 4) {
            return i != 5 ? STREAM_INPUT_TTS_EVENT_TASK_FAILED : STREAM_INPUT_TTS_EVENT_TASK_FAILED;
        }
        return STREAM_INPUT_TTS_EVENT_SYNTHESIS_COMPLETE;
    }

    public int getCode() {
        return this.code;
    }
}
