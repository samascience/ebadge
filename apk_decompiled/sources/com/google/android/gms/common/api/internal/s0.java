package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import defpackage.v03;

/* JADX INFO: loaded from: classes.dex */
abstract class s0 extends n0 {
    protected final v03 b;

    public s0(int i, v03 v03Var) {
        super(i);
        this.b = v03Var;
    }

    @Override // com.google.android.gms.common.api.internal.z
    public void b(Status status) {
        this.b.d(new ApiException(status));
    }

    @Override // com.google.android.gms.common.api.internal.z
    public final void c(c.a aVar) throws DeadObjectException {
        try {
            i(aVar);
        } catch (DeadObjectException e) {
            b(z.a(e));
            throw e;
        } catch (RemoteException e2) {
            b(z.a(e2));
        } catch (RuntimeException e3) {
            e(e3);
        }
    }

    @Override // com.google.android.gms.common.api.internal.z
    public void e(RuntimeException runtimeException) {
        this.b.d(runtimeException);
    }

    protected abstract void i(c.a aVar);
}
