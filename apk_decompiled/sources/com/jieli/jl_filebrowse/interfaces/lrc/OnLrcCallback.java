package com.jieli.jl_filebrowse.interfaces.lrc;

/* JADX INFO: loaded from: classes3.dex */
public interface OnLrcCallback {
    void onLrcDataReceive(byte[] bArr);

    void onLrcReadFailed(int i);

    void onLrcReadStart();

    void onLrcReadStop();
}
