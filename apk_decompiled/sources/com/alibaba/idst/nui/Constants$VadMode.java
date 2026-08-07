package com.alibaba.idst.nui;

/* JADX INFO: loaded from: classes.dex */
public enum Constants$VadMode {
    TYPE_UNKNOWN(-1),
    TYPE_VAD(0),
    TYPE_P2T(1),
    TYPE_KWS(2),
    TYPE_PARALLEL(3),
    TYPE_KWS2PARALLEL(4),
    TYPE_AUTO_CONTINUAL(5),
    TYPE_KWS_CONTINUAL(6),
    TYPE_KWS2TALK(7),
    TYPE_ONLY_KWS(8);

    private int code;

    Constants$VadMode(int i) {
        this.code = i;
    }

    public static Constants$VadMode fromInt(int i) {
        switch (i) {
            case 0:
                return TYPE_VAD;
            case 1:
                return TYPE_P2T;
            case 2:
                return TYPE_KWS;
            case 3:
                return TYPE_PARALLEL;
            case 4:
                return TYPE_KWS2PARALLEL;
            case 5:
                return TYPE_AUTO_CONTINUAL;
            case 6:
                return TYPE_KWS_CONTINUAL;
            case 7:
                return TYPE_KWS2TALK;
            case 8:
                return TYPE_ONLY_KWS;
            default:
                return TYPE_UNKNOWN;
        }
    }

    public int getCode() {
        return this.code;
    }
}
