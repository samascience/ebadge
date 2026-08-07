package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.internal.c;

/* JADX INFO: loaded from: classes.dex */
public final class yu3 extends c {
    public yu3(Context context, Looper looper, ky kyVar, bc.a aVar, com.google.android.gms.common.api.c.b bVar, com.google.android.gms.common.api.c.InterfaceC0078c interfaceC0078c) {
        super(context, looper, 68, kyVar, bVar, interfaceC0078c);
    }

    @Override // com.google.android.gms.common.internal.b
    protected final String B() {
        return "com.google.android.gms.auth.api.credentials.internal.ICredentialsService";
    }

    @Override // com.google.android.gms.common.internal.b
    protected final String C() {
        return "com.google.android.gms.auth.api.credentials.service.START";
    }

    @Override // com.google.android.gms.common.internal.c, com.google.android.gms.common.internal.b, com.google.android.gms.common.api.a.f
    public final int l() {
        return 12800000;
    }

    @Override // com.google.android.gms.common.internal.b
    protected final /* synthetic */ IInterface r(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
        return iInterfaceQueryLocalInterface instanceof kv3 ? (kv3) iInterfaceQueryLocalInterface : new ov3(iBinder);
    }

    @Override // com.google.android.gms.common.internal.b
    protected final Bundle x() {
        return new Bundle();
    }
}
