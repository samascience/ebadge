package com.alibaba.idst.nui;

/* JADX INFO: loaded from: classes.dex */
public enum Constants$NuiVprEvent {
    EVENT_VPR_NONE(0),
    EVENT_VPR_REGISTER_START(1),
    EVENT_VPR_REGISTER_DONE(2),
    EVENT_VPR_REGISTER_FAILED(3),
    EVENT_VPR_UPDATE_START(4),
    EVENT_VPR_UPDATE_DONE(5),
    EVENT_VPR_UPDATE_FAIL(6),
    EVENT_VPR_DELETE_DONE(7),
    EVENT_VPR_DELETE_FAIL(8),
    DEFAULT_ERROR(9);

    private int code;

    Constants$NuiVprEvent(int i) {
        this.code = i;
    }

    public static Constants$NuiVprEvent fromInt(int i) {
        switch (i) {
            case 0:
                return EVENT_VPR_NONE;
            case 1:
                return EVENT_VPR_REGISTER_START;
            case 2:
                return EVENT_VPR_REGISTER_DONE;
            case 3:
                return EVENT_VPR_REGISTER_FAILED;
            case 4:
                return EVENT_VPR_UPDATE_START;
            case 5:
                return EVENT_VPR_UPDATE_DONE;
            case 6:
                return EVENT_VPR_UPDATE_FAIL;
            case 7:
                return EVENT_VPR_DELETE_DONE;
            case 8:
                return EVENT_VPR_DELETE_FAIL;
            default:
                return DEFAULT_ERROR;
        }
    }

    public int getCode() {
        return this.code;
    }
}
