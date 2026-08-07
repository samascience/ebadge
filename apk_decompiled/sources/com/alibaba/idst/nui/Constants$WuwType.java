package com.alibaba.idst.nui;

/* JADX INFO: loaded from: classes.dex */
public enum Constants$WuwType {
    TYPE_UNKNOWN(-1),
    TYPE_MAIN(0),
    TYPE_ACTION(1),
    TYPE_PREFIX(2),
    TYPE_DANAMIC(3),
    TYPE_ONESHOT(4);

    private int code;

    Constants$WuwType(int i) {
        this.code = i;
    }

    public static Constants$WuwType fromInt(int i) {
        if (i == -1) {
            return TYPE_UNKNOWN;
        }
        if (i == 0) {
            return TYPE_MAIN;
        }
        if (i == 1) {
            return TYPE_ACTION;
        }
        if (i == 2) {
            return TYPE_PREFIX;
        }
        if (i != 3) {
            return i != 4 ? TYPE_UNKNOWN : TYPE_ONESHOT;
        }
        return TYPE_DANAMIC;
    }

    public int getCode() {
        return this.code;
    }
}
