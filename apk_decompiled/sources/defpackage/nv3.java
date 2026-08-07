package defpackage;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class nv3 extends dt3 implements tv3 {
    nv3(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ICertData");
    }

    @Override // defpackage.tv3
    public final int G() {
        Parcel parcelA = a(2, b());
        int i = parcelA.readInt();
        parcelA.recycle();
        return i;
    }

    @Override // defpackage.tv3
    public final py0 x() {
        Parcel parcelA = a(1, b());
        py0 py0VarB = py0.a.b(parcelA.readStrongBinder());
        parcelA.recycle();
        return py0VarB;
    }
}
