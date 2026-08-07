package defpackage;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.SignInButtonConfig;

/* JADX INFO: loaded from: classes.dex */
public final class os3 extends dr3 implements sy0 {
    os3(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ISignInButtonCreator");
    }

    @Override // defpackage.sy0
    public final py0 r(py0 py0Var, SignInButtonConfig signInButtonConfig) {
        Parcel parcelA = a();
        vr3.c(parcelA, py0Var);
        vr3.d(parcelA, signInButtonConfig);
        Parcel parcelB = b(2, parcelA);
        py0 py0VarB = py0.a.b(parcelB.readStrongBinder());
        parcelB.recycle();
        return py0VarB;
    }
}
