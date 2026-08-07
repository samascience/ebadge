package defpackage;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

/* JADX INFO: loaded from: classes.dex */
public final class jv3 extends ut3 implements iv3 {
    jv3(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.signin.internal.ISignInService");
    }

    @Override // defpackage.iv3
    public final void w(ev3 ev3Var, GoogleSignInOptions googleSignInOptions) {
        Parcel parcelA = a();
        bu3.b(parcelA, ev3Var);
        bu3.c(parcelA, googleSignInOptions);
        b(103, parcelA);
    }
}
