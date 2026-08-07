package defpackage;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class xs3 extends dr3 implements ws3 {
    xs3(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.service.ICommonService");
    }

    @Override // defpackage.ws3
    public final void A(rs3 rs3Var) {
        Parcel parcelA = a();
        vr3.c(parcelA, rs3Var);
        d(1, parcelA);
    }
}
