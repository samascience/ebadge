package defpackage;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.zzj;

/* JADX INFO: loaded from: classes.dex */
public abstract class gt3 extends qt3 implements fy0 {
    public gt3() {
        super("com.google.android.gms.common.internal.IGmsCallbacks");
    }

    @Override // defpackage.qt3
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            int i3 = parcel.readInt();
            IBinder strongBinder = parcel.readStrongBinder();
            Bundle bundle = (Bundle) vt3.a(parcel, Bundle.CREATOR);
            vt3.b(parcel);
            t(i3, strongBinder, bundle);
        } else if (i == 2) {
            int i4 = parcel.readInt();
            Bundle bundle2 = (Bundle) vt3.a(parcel, Bundle.CREATOR);
            vt3.b(parcel);
            m(i4, bundle2);
        } else {
            if (i != 3) {
                return false;
            }
            int i5 = parcel.readInt();
            IBinder strongBinder2 = parcel.readStrongBinder();
            zzj zzjVar = (zzj) vt3.a(parcel, zzj.CREATOR);
            vt3.b(parcel);
            v(i5, strongBinder2, zzjVar);
        }
        parcel2.writeNoException();
        return true;
    }
}
