package defpackage;

import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public abstract class bv3 extends yt3 implements xu3 {
    public bv3() {
        super("com.google.android.gms.auth.api.signin.internal.IRevocationService");
    }

    @Override // defpackage.yt3
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            B();
        } else {
            if (i != 2) {
                return false;
            }
            E();
        }
        return true;
    }
}
