package defpackage;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public abstract class dr3 implements IInterface {
    private final IBinder c;
    private final String d;

    protected dr3(IBinder iBinder, String str) {
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

    protected final Parcel b(int i, Parcel parcel) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            try {
                this.c.transact(i, parcel, parcelObtain, 0);
                parcelObtain.readException();
                parcel.recycle();
                return parcelObtain;
            } catch (RuntimeException e) {
                parcelObtain.recycle();
                throw e;
            }
        } catch (Throwable th) {
            parcel.recycle();
            throw th;
        }
    }

    protected final void c(int i, Parcel parcel) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            this.c.transact(i, parcel, parcelObtain, 0);
            parcelObtain.readException();
        } finally {
            parcel.recycle();
            parcelObtain.recycle();
        }
    }

    protected final void d(int i, Parcel parcel) {
        try {
            this.c.transact(1, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
