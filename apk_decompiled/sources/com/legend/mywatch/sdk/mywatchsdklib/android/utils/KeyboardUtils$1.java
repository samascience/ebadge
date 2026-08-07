package com.legend.mywatch.sdk.mywatchsdklib.android.utils;

import android.os.Bundle;
import android.os.ResultReceiver;
import defpackage.i91;

/* JADX INFO: loaded from: classes3.dex */
class KeyboardUtils$1 extends ResultReceiver {
    @Override // android.os.ResultReceiver
    protected void onReceiveResult(int i, Bundle bundle) {
        if (i == 1 || i == 3) {
            i91.c();
        }
    }
}
