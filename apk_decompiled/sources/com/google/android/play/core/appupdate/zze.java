package com.google.android.play.core.appupdate;

import android.os.Bundle;
import android.os.ResultReceiver;
import defpackage.v03;

/* JADX INFO: loaded from: classes3.dex */
final class zze extends ResultReceiver {
    final /* synthetic */ v03 a;

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i, Bundle bundle) {
        if (i == 1) {
            this.a.e(-1);
        } else if (i != 2) {
            this.a.e(1);
        } else {
            this.a.e(0);
        }
    }
}
