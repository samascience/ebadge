package com.jieli.jl_filebrowse.interfaces;

import com.jieli.jl_filebrowse.bean.FileStruct;

/* JADX INFO: loaded from: classes3.dex */
public interface DeleteCallback {
    void onError(int i, FileStruct fileStruct);

    void onFinish();

    void onSuccess(FileStruct fileStruct);
}
