package defpackage;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.common.internal.c;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.signin.internal.zah;
import com.google.android.gms.signin.internal.zaj;

/* JADX INFO: loaded from: classes.dex */
public class vo2 extends c implements ds3 {
    private final boolean I;
    private final ky J;
    private final Bundle K;
    private Integer L;

    private vo2(Context context, Looper looper, boolean z, ky kyVar, Bundle bundle, com.google.android.gms.common.api.c.b bVar, com.google.android.gms.common.api.c.InterfaceC0078c interfaceC0078c) {
        super(context, looper, 44, kyVar, bVar, interfaceC0078c);
        this.I = true;
        this.J = kyVar;
        this.K = bundle;
        this.L = kyVar.f();
    }

    public static Bundle h0(ky kyVar) {
        xo2 xo2VarK = kyVar.k();
        Integer numF = kyVar.f();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", kyVar.a());
        if (numF != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", numF.intValue());
        }
        if (xo2VarK != null) {
            bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", xo2VarK.g());
            bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", xo2VarK.f());
            bundle.putString("com.google.android.gms.signin.internal.serverClientId", xo2VarK.d());
            bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
            bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", xo2VarK.e());
            bundle.putString("com.google.android.gms.signin.internal.hostedDomain", xo2VarK.b());
            bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", xo2VarK.h());
            if (xo2VarK.a() != null) {
                bundle.putLong("com.google.android.gms.signin.internal.authApiSignInModuleVersion", xo2VarK.a().longValue());
            }
            if (xo2VarK.c() != null) {
                bundle.putLong("com.google.android.gms.signin.internal.realClientLibraryVersion", xo2VarK.c().longValue());
            }
        }
        return bundle;
    }

    @Override // com.google.android.gms.common.internal.b
    protected String B() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    @Override // com.google.android.gms.common.internal.b
    protected String C() {
        return "com.google.android.gms.signin.service.START";
    }

    @Override // defpackage.ds3
    public final void a(f fVar, boolean z) {
        try {
            ((js3) A()).p(fVar, this.L.intValue(), z);
        } catch (RemoteException unused) {
            Log.w("SignInClientImpl", "Remote service probably died when saveDefaultAccount is called");
        }
    }

    @Override // defpackage.ds3
    public final void b(es3 es3Var) {
        a52.h(es3Var, "Expecting a valid ISignInCallbacks");
        try {
            Account accountC = this.J.c();
            ((js3) A()).y(new zah(new ResolveAccountRequest(accountC, this.L.intValue(), "<<default account>>".equals(accountC.name) ? su2.b(w()).c() : null)), es3Var);
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                es3Var.g(new zaj(8));
            } catch (RemoteException unused) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e);
            }
        }
    }

    @Override // defpackage.ds3
    public final void c() {
        try {
            ((js3) A()).h(this.L.intValue());
        } catch (RemoteException unused) {
            Log.w("SignInClientImpl", "Remote service probably died when clearAccountFromSessionStore is called");
        }
    }

    @Override // defpackage.ds3
    public final void connect() {
        i(new b.d());
    }

    @Override // com.google.android.gms.common.internal.c, com.google.android.gms.common.internal.b, com.google.android.gms.common.api.a.f
    public int l() {
        return 12451000;
    }

    @Override // com.google.android.gms.common.internal.b, com.google.android.gms.common.api.a.f
    public boolean o() {
        return this.I;
    }

    @Override // com.google.android.gms.common.internal.b
    protected /* synthetic */ IInterface r(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        return iInterfaceQueryLocalInterface instanceof js3 ? (js3) iInterfaceQueryLocalInterface : new ls3(iBinder);
    }

    @Override // com.google.android.gms.common.internal.b
    protected Bundle x() {
        if (!w().getPackageName().equals(this.J.i())) {
            this.K.putString("com.google.android.gms.signin.internal.realClientPackageName", this.J.i());
        }
        return this.K;
    }

    public vo2(Context context, Looper looper, boolean z, ky kyVar, xo2 xo2Var, com.google.android.gms.common.api.c.b bVar, com.google.android.gms.common.api.c.InterfaceC0078c interfaceC0078c) {
        this(context, looper, true, kyVar, h0(kyVar), bVar, interfaceC0078c);
    }
}
