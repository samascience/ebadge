package com.tenmeter.smlibrary.listener;

/* JADX INFO: loaded from: classes3.dex */
public interface IDownloadLister {
    void onError(String str);

    void onFinish(String str);

    void onProgress(long j, int i);

    void onStart();
}
