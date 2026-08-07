package com.legend.mywatch.sdk.mywatchsdklib.android.enm;

/* JADX INFO: loaded from: classes3.dex */
public enum CallStatusEnm {
    CALL_STATE_IDLE(0),
    CALL_STATE_RINGING(1),
    CALL_STATE_OFFHOOK(2),
    CALL_STATE_DEFAULT(-1);

    private int value;

    CallStatusEnm(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
