package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import defpackage.a52;
import defpackage.jh2;
import defpackage.qg;

/* JADX INFO: loaded from: classes.dex */
public abstract class b extends BasePendingResult implements qg {
    private final com.google.android.gms.common.api.a.c o;
    private final com.google.android.gms.common.api.a p;

    protected b(com.google.android.gms.common.api.a aVar, com.google.android.gms.common.api.c cVar) {
        super((com.google.android.gms.common.api.c) a52.h(cVar, "GoogleApiClient must not be null"));
        a52.h(aVar, "Api must not be null");
        this.o = aVar.a();
        this.p = aVar;
    }

    private void v(RemoteException remoteException) {
        w(new Status(8, remoteException.getLocalizedMessage(), null));
    }

    @Override // defpackage.qg
    public /* bridge */ /* synthetic */ void a(Object obj) {
        super.j((jh2) obj);
    }

    protected abstract void q(com.google.android.gms.common.api.a.b bVar);

    public final com.google.android.gms.common.api.a r() {
        return this.p;
    }

    public final com.google.android.gms.common.api.a.c s() {
        return this.o;
    }

    protected void t(jh2 jh2Var) {
    }

    public final void u(com.google.android.gms.common.api.a.b bVar) throws DeadObjectException {
        try {
            q(bVar);
        } catch (DeadObjectException e) {
            v(e);
            throw e;
        } catch (RemoteException e2) {
            v(e2);
        }
    }

    public final void w(Status status) {
        a52.b(!status.K0(), "Failed result must not be success");
        jh2 jh2VarG = g(status);
        j(jh2VarG);
        t(jh2VarG);
    }
}
