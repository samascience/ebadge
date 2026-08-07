package com.google.android.gms.common.api;

import com.tencent.connect.common.Constants;

/* JADX INFO: loaded from: classes.dex */
public class ApiException extends Exception {

    @Deprecated
    protected final Status mStatus;

    public ApiException(Status status) {
        super(status.H0() + ": " + (status.I0() != null ? status.I0() : Constants.STR_EMPTY));
        this.mStatus = status;
    }

    public Status getStatus() {
        return this.mStatus;
    }

    public int getStatusCode() {
        return this.mStatus.H0();
    }

    @Deprecated
    public String getStatusMessage() {
        return this.mStatus.I0();
    }
}
