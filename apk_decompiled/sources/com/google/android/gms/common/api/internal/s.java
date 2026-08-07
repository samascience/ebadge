package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: loaded from: classes.dex */
final class s implements com.google.android.gms.common.api.c.b, com.google.android.gms.common.api.c.InterfaceC0078c {
    private final /* synthetic */ j c;

    private s(j jVar) {
        this.c = jVar;
    }

    @Override // com.google.android.gms.common.api.c.b
    public final void a(int i) {
    }

    @Override // com.google.android.gms.common.api.c.b
    public final void b(Bundle bundle) {
        this.c.k.b(new q(this.c));
    }

    @Override // com.google.android.gms.common.api.c.InterfaceC0078c
    public final void d(ConnectionResult connectionResult) {
        this.c.b.lock();
        try {
            if (this.c.z(connectionResult)) {
                this.c.o();
                this.c.m();
            } else {
                this.c.A(connectionResult);
            }
        } finally {
            this.c.b.unlock();
        }
    }

    /* synthetic */ s(j jVar, k kVar) {
        this(jVar);
    }
}
