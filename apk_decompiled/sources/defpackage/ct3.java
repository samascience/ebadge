package defpackage;

import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: loaded from: classes.dex */
public abstract class ct3 implements IInterface {
    private final IBinder c;
    private final String d;

    protected ct3(IBinder iBinder, String str) {
        this.c = iBinder;
        this.d = str;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.c;
    }
}
