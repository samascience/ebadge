package com.legend.mywatch.sdk.mywatchsdklib.android.utils;

import android.app.Application;
import androidx.core.content.FileProvider;

/* JADX INFO: loaded from: classes3.dex */
public class UtilsFileProvider extends FileProvider {
    @Override // androidx.core.content.FileProvider, android.content.ContentProvider
    public boolean onCreate() {
        i.b((Application) getContext().getApplicationContext());
        return true;
    }
}
