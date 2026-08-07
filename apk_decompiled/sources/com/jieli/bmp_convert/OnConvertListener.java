package com.jieli.bmp_convert;

/* JADX INFO: loaded from: classes3.dex */
public interface OnConvertListener {
    void onStart(String str);

    void onStop(ConvertResult convertResult, String str);

    @Deprecated
    void onStop(boolean z, String str);
}
