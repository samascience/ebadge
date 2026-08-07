package defpackage;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.signin.internal.zah;

/* JADX INFO: loaded from: classes.dex */
public final class ls3 extends dr3 implements js3 {
    ls3(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.signin.internal.ISignInService");
    }

    @Override // defpackage.js3
    public final void h(int i) {
        Parcel parcelA = a();
        parcelA.writeInt(i);
        c(7, parcelA);
    }

    @Override // defpackage.js3
    public final void p(f fVar, int i, boolean z) {
        Parcel parcelA = a();
        vr3.c(parcelA, fVar);
        parcelA.writeInt(i);
        vr3.a(parcelA, z);
        c(9, parcelA);
    }

    @Override // defpackage.js3
    public final void y(zah zahVar, es3 es3Var) {
        Parcel parcelA = a();
        vr3.d(parcelA, zahVar);
        vr3.c(parcelA, es3Var);
        c(12, parcelA);
    }
}
