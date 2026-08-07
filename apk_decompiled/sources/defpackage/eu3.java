package defpackage;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.c;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class eu3 extends c {
    private final GoogleSignInOptions I;

    public eu3(Context context, Looper looper, ky kyVar, GoogleSignInOptions googleSignInOptions, com.google.android.gms.common.api.c.b bVar, com.google.android.gms.common.api.c.InterfaceC0078c interfaceC0078c) {
        super(context, looper, 91, kyVar, bVar, interfaceC0078c);
        googleSignInOptions = googleSignInOptions == null ? new GoogleSignInOptions.a().a() : googleSignInOptions;
        if (!kyVar.d().isEmpty()) {
            GoogleSignInOptions.a aVar = new GoogleSignInOptions.a(googleSignInOptions);
            Iterator it = kyVar.d().iterator();
            while (it.hasNext()) {
                aVar.e((Scope) it.next(), new Scope[0]);
            }
            googleSignInOptions = aVar.a();
        }
        this.I = googleSignInOptions;
    }

    @Override // com.google.android.gms.common.internal.b
    protected final String B() {
        return "com.google.android.gms.auth.api.signin.internal.ISignInService";
    }

    @Override // com.google.android.gms.common.internal.b
    protected final String C() {
        return "com.google.android.gms.auth.api.signin.service.START";
    }

    @Override // com.google.android.gms.common.internal.b, com.google.android.gms.common.api.a.f
    public final boolean f() {
        return true;
    }

    public final GoogleSignInOptions h0() {
        return this.I;
    }

    @Override // com.google.android.gms.common.internal.c, com.google.android.gms.common.internal.b, com.google.android.gms.common.api.a.f
    public final int l() {
        return 12451000;
    }

    @Override // com.google.android.gms.common.internal.b, com.google.android.gms.common.api.a.f
    public final Intent n() {
        return fu3.b(w(), this.I);
    }

    @Override // com.google.android.gms.common.internal.b
    protected final /* synthetic */ IInterface r(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
        return iInterfaceQueryLocalInterface instanceof iv3 ? (iv3) iInterfaceQueryLocalInterface : new jv3(iBinder);
    }
}
