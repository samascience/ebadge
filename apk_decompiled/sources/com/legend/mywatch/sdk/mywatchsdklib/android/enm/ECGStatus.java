package com.legend.mywatch.sdk.mywatchsdklib.android.enm;

/* JADX INFO: loaded from: classes3.dex */
public enum ECGStatus {
    STOP(0),
    START(1);

    int status;

    ECGStatus(int i) {
        this.status = i;
    }

    public int getStatus() {
        return this.status;
    }
}
