package defpackage;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public abstract class rv3 extends qt3 implements tv3 {
    public rv3() {
        super("com.google.android.gms.common.internal.ICertData");
    }

    public static tv3 b(IBinder iBinder) {
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ICertData");
        return iInterfaceQueryLocalInterface instanceof tv3 ? (tv3) iInterfaceQueryLocalInterface : new nv3(iBinder);
    }

    @Override // defpackage.qt3
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            py0 py0VarX = x();
            parcel2.writeNoException();
            vt3.c(parcel2, py0VarX);
        } else {
            if (i != 2) {
                return false;
            }
            int iG = G();
            parcel2.writeNoException();
            parcel2.writeInt(iG);
        }
        return true;
    }
}
