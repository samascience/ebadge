package defpackage;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.internal.c;

/* JADX INFO: loaded from: classes.dex */
public final class ps3 extends c {
    public ps3(Context context, Looper looper, ky kyVar, com.google.android.gms.common.api.c.b bVar, com.google.android.gms.common.api.c.InterfaceC0078c interfaceC0078c) {
        super(context, looper, 39, kyVar, bVar, interfaceC0078c);
    }

    @Override // com.google.android.gms.common.internal.b
    protected final String B() {
        return "com.google.android.gms.common.internal.service.ICommonService";
    }

    @Override // com.google.android.gms.common.internal.b
    public final String C() {
        return "com.google.android.gms.common.service.START";
    }

    @Override // com.google.android.gms.common.internal.b
    protected final /* synthetic */ IInterface r(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.service.ICommonService");
        return iInterfaceQueryLocalInterface instanceof ws3 ? (ws3) iInterfaceQueryLocalInterface : new xs3(iBinder);
    }
}
