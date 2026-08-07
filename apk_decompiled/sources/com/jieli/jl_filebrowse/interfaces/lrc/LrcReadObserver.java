package com.jieli.jl_filebrowse.interfaces.lrc;

/* JADX INFO: loaded from: classes3.dex */
public interface LrcReadObserver {
    void onLrcReadFailed(int i);

    void onLrcReadStart();

    void onLrcReadStop(String str);
}
