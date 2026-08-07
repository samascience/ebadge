package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import defpackage.a52;

/* JADX INFO: loaded from: classes.dex */
public final class t extends m {
    public final IBinder g;
    final /* synthetic */ b h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(b bVar, int i, IBinder iBinder, Bundle bundle) {
        super(bVar, i, bundle);
        this.h = bVar;
        this.g = iBinder;
    }

    @Override // com.google.android.gms.common.internal.m
    protected final void f(ConnectionResult connectionResult) {
        if (this.h.v != null) {
            this.h.v.d(connectionResult);
        }
        this.h.G(connectionResult);
    }

    @Override // com.google.android.gms.common.internal.m
    protected final boolean g() {
        try {
            IBinder iBinder = this.g;
            a52.g(iBinder);
            String interfaceDescriptor = iBinder.getInterfaceDescriptor();
            if (!this.h.B().equals(interfaceDescriptor)) {
                Log.w("GmsClient", "service descriptor mismatch: " + this.h.B() + " vs. " + interfaceDescriptor);
                return false;
            }
            IInterface iInterfaceR = this.h.r(this.g);
            if (iInterfaceR == null || !(b.Z(this.h, 2, 4, iInterfaceR) || b.Z(this.h, 3, 4, iInterfaceR))) {
                return false;
            }
            this.h.z = null;
            Bundle bundleD = this.h.d();
            b bVar = this.h;
            if (bVar.u == null) {
                return true;
            }
            bVar.u.b(bundleD);
            return true;
        } catch (RemoteException unused) {
            Log.w("GmsClient", "service probably died");
            return false;
        }
    }
}
