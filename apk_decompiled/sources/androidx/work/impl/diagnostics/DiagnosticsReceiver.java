package androidx.work.impl.diagnostics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.impl.workers.DiagnosticsWorker;
import defpackage.fd1;
import defpackage.mk3;
import defpackage.qw1;

/* JADX INFO: loaded from: classes.dex */
public class DiagnosticsReceiver extends BroadcastReceiver {
    private static final String a = fd1.f("DiagnosticsRcvr");

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        fd1.c().a(a, "Requesting diagnostics", new Throwable[0]);
        try {
            mk3.c(context).a(qw1.d(DiagnosticsWorker.class));
        } catch (IllegalStateException e) {
            fd1.c().b(a, "WorkManager is not initialized", e);
        }
    }
}
