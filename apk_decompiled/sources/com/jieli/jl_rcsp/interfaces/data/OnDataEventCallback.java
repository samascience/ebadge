package com.jieli.jl_rcsp.interfaces.data;

import com.jieli.jl_rcsp.model.base.BaseError;

/* JADX INFO: loaded from: classes3.dex */
public interface OnDataEventCallback {
    void onBegin(int i);

    void onError(BaseError baseError);

    void onProgress(float f);

    void onStop(int i, byte[] bArr);
}
