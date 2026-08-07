package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public final class t0 extends z {
    private final b b;

    public t0(int i, b bVar) {
        super(i);
        this.b = bVar;
    }

    @Override // com.google.android.gms.common.api.internal.z
    public final void b(Status status) {
        this.b.w(status);
    }

    @Override // com.google.android.gms.common.api.internal.z
    public final void c(c.a aVar) throws DeadObjectException {
        try {
            this.b.u(aVar.o());
        } catch (RuntimeException e) {
            e(e);
        }
    }

    @Override // com.google.android.gms.common.api.internal.z
    public final void d(e eVar, boolean z) {
        eVar.b(this.b, z);
    }

    @Override // com.google.android.gms.common.api.internal.z
    public final void e(RuntimeException runtimeException) {
        String simpleName = runtimeException.getClass().getSimpleName();
        String localizedMessage = runtimeException.getLocalizedMessage();
        StringBuilder sb = new StringBuilder(simpleName.length() + 2 + String.valueOf(localizedMessage).length());
        sb.append(simpleName);
        sb.append(": ");
        sb.append(localizedMessage);
        this.b.w(new Status(10, sb.toString()));
    }
}
