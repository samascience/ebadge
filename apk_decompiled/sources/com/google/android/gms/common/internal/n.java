package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import defpackage.fy0;
import defpackage.gy0;

/* JADX INFO: loaded from: classes.dex */
final class n implements gy0 {
    private final IBinder c;

    n(IBinder iBinder) {
        this.c = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.c;
    }

    @Override // defpackage.gy0
    public final void q(fy0 fy0Var, GetServiceRequest getServiceRequest) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            parcelObtain.writeStrongBinder(fy0Var != null ? fy0Var.asBinder() : null);
            if (getServiceRequest != null) {
                parcelObtain.writeInt(1);
                x.a(getServiceRequest, parcelObtain, 0);
            } else {
                parcelObtain.writeInt(0);
            }
            this.c.transact(46, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }
}
