package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import defpackage.nj2;
import defpackage.py0;
import defpackage.rt1;
import defpackage.rv3;

/* JADX INFO: loaded from: classes.dex */
public final class zzs extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzs> CREATOR = new s();
    private final String a;
    private final l b;
    private final boolean c;
    private final boolean d;

    zzs(String str, IBinder iBinder, boolean z, boolean z2) {
        this.a = str;
        m mVar = null;
        if (iBinder != null) {
            try {
                py0 py0VarX = rv3.b(iBinder).x();
                byte[] bArr = py0VarX == null ? null : (byte[]) rt1.c(py0VarX);
                if (bArr != null) {
                    mVar = new m(bArr);
                } else {
                    Log.e("GoogleCertificatesQuery", "Could not unwrap certificate");
                }
            } catch (RemoteException e) {
                Log.e("GoogleCertificatesQuery", "Could not unwrap certificate", e);
            }
        }
        this.b = mVar;
        this.c = z;
        this.d = z2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = nj2.a(parcel);
        nj2.o(parcel, 1, this.a, false);
        l lVar = this.b;
        if (lVar == null) {
            Log.w("GoogleCertificatesQuery", "certificate binder is null");
            lVar = null;
        }
        nj2.g(parcel, 2, lVar, false);
        nj2.c(parcel, 3, this.c);
        nj2.c(parcel, 4, this.d);
        nj2.b(parcel, iA);
    }
}
