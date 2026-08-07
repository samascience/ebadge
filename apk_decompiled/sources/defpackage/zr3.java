package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.signin.internal.zaj;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zr3 extends xr3 implements c.b, c.InterfaceC0078c {
    private static a.AbstractC0075a j = er3.c;
    private final Context c;
    private final Handler d;
    private final a.AbstractC0075a e;
    private Set f;
    private ky g;
    private ds3 h;
    private cs3 i;

    public zr3(Context context, Handler handler, ky kyVar) {
        this(context, handler, kyVar, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N(zaj zajVar) {
        ConnectionResult connectionResultF0 = zajVar.F0();
        if (connectionResultF0.J0()) {
            ResolveAccountResponse resolveAccountResponseG0 = zajVar.G0();
            ConnectionResult connectionResultG0 = resolveAccountResponseG0.G0();
            if (!connectionResultG0.J0()) {
                String strValueOf = String.valueOf(connectionResultG0);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 48);
                sb.append("Sign-in succeeded with resolve account failure: ");
                sb.append(strValueOf);
                Log.wtf("SignInCoordinator", sb.toString(), new Exception());
                this.i.c(connectionResultG0);
                this.h.disconnect();
                return;
            }
            this.i.b(resolveAccountResponseG0.F0(), this.f);
        } else {
            this.i.c(connectionResultF0);
        }
        this.h.disconnect();
    }

    public final void K(cs3 cs3Var) {
        ds3 ds3Var = this.h;
        if (ds3Var != null) {
            ds3Var.disconnect();
        }
        this.g.l(Integer.valueOf(System.identityHashCode(this)));
        a.AbstractC0075a abstractC0075a = this.e;
        Context context = this.c;
        Looper looper = this.d.getLooper();
        ky kyVar = this.g;
        this.h = (ds3) abstractC0075a.c(context, looper, kyVar, kyVar.k(), this, this);
        this.i = cs3Var;
        Set set = this.f;
        if (set == null || set.isEmpty()) {
            this.d.post(new as3(this));
        } else {
            this.h.connect();
        }
    }

    public final ds3 L() {
        return this.h;
    }

    public final void M() {
        ds3 ds3Var = this.h;
        if (ds3Var != null) {
            ds3Var.disconnect();
        }
    }

    @Override // com.google.android.gms.common.api.c.b
    public final void a(int i) {
        this.h.disconnect();
    }

    @Override // com.google.android.gms.common.api.c.b
    public final void b(Bundle bundle) {
        this.h.b(this);
    }

    @Override // com.google.android.gms.common.api.c.InterfaceC0078c
    public final void d(ConnectionResult connectionResult) {
        this.i.c(connectionResult);
    }

    @Override // defpackage.es3
    public final void g(zaj zajVar) {
        this.d.post(new bs3(this, zajVar));
    }

    public zr3(Context context, Handler handler, ky kyVar, a.AbstractC0075a abstractC0075a) {
        this.c = context;
        this.d = handler;
        this.g = (ky) a52.h(kyVar, "ClientSettings must not be null");
        this.f = kyVar.j();
        this.e = abstractC0075a;
    }
}
