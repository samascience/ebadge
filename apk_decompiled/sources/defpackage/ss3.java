package defpackage;

import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public abstract class ss3 extends jr3 implements rs3 {
    public ss3() {
        super("com.google.android.gms.common.internal.service.ICommonCallbacks");
    }

    @Override // defpackage.jr3
    protected boolean H(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        n(parcel.readInt());
        parcel2.writeNoException();
        return true;
    }
}
