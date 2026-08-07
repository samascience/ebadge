package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.common.internal.c;

/* JADX INFO: loaded from: classes.dex */
public final class mt3 extends c {
    private final Bundle I;

    public mt3(Context context, Looper looper, ky kyVar, lc lcVar, com.google.android.gms.common.api.c.b bVar, com.google.android.gms.common.api.c.InterfaceC0078c interfaceC0078c) {
        super(context, looper, 16, kyVar, bVar, interfaceC0078c);
        this.I = new Bundle();
    }

    @Override // com.google.android.gms.common.internal.b
    protected final String B() {
        return "com.google.android.gms.auth.api.internal.IAuthService";
    }

    @Override // com.google.android.gms.common.internal.b
    protected final String C() {
        return "com.google.android.gms.auth.service.START";
    }

    @Override // com.google.android.gms.common.internal.c, com.google.android.gms.common.internal.b, com.google.android.gms.common.api.a.f
    public final int l() {
        return 12451000;
    }

    @Override // com.google.android.gms.common.internal.b, com.google.android.gms.common.api.a.f
    public final boolean o() {
        ky kyVarC0 = c0();
        return (TextUtils.isEmpty(kyVarC0.b()) || kyVarC0.e(kc.c).isEmpty()) ? false : true;
    }

    @Override // com.google.android.gms.common.internal.b
    protected final /* synthetic */ IInterface r(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.internal.IAuthService");
        return iInterfaceQueryLocalInterface instanceof nt3 ? (nt3) iInterfaceQueryLocalInterface : new ot3(iBinder);
    }

    @Override // com.google.android.gms.common.internal.b
    protected final Bundle x() {
        return this.I;
    }
}
