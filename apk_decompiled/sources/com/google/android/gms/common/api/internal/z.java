package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import android.os.TransactionTooLargeException;
import com.google.android.gms.common.api.Status;
import defpackage.x32;

/* JADX INFO: loaded from: classes.dex */
public abstract class z {
    private final int a;

    public z(int i) {
        this.a = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Status a(RemoteException remoteException) {
        StringBuilder sb = new StringBuilder();
        if (x32.b() && (remoteException instanceof TransactionTooLargeException)) {
            sb.append("TransactionTooLargeException: ");
        }
        sb.append(remoteException.getLocalizedMessage());
        return new Status(8, sb.toString());
    }

    public abstract void b(Status status);

    public abstract void c(c.a aVar);

    public abstract void d(e eVar, boolean z);

    public abstract void e(RuntimeException runtimeException);
}
