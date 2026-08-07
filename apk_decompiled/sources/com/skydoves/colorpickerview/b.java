package com.skydoves.colorpickerview;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
abstract class b {
    protected static int a(Context context, int i) {
        return (int) ((i * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
