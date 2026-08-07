package defpackage;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public abstract class ut3 implements IInterface {
    private final IBinder c;
    private final String d;

    protected ut3(IBinder iBinder, String str) {
        this.c = iBinder;
        this.d = str;
    }

    protected final Parcel a() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.d);
        return parcelObtain;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.c;
    }

    protected final void b(int i, Parcel parcel) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            this.c.transact(i, parcel, parcelObtain, 0);
            parcelObtain.readException();
        } finally {
            parcel.recycle();
            parcelObtain.recycle();
        }
    }
}
