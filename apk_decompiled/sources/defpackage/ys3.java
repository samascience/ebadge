package defpackage;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.c;

/* JADX INFO: loaded from: classes.dex */
public final class ys3 implements c.b, c.InterfaceC0078c {
    public final a c;
    private final boolean d;
    private zs3 e;

    public ys3(a aVar, boolean z) {
        this.c = aVar;
        this.d = z;
    }

    private final void f() {
        a52.h(this.e, "Callbacks must be attached to a ClientConnectionHelper instance before connecting the client.");
    }

    @Override // com.google.android.gms.common.api.c.b
    public final void a(int i) {
        f();
        this.e.a(i);
    }

    @Override // com.google.android.gms.common.api.c.b
    public final void b(Bundle bundle) {
        f();
        this.e.b(bundle);
    }

    @Override // com.google.android.gms.common.api.c.InterfaceC0078c
    public final void d(ConnectionResult connectionResult) {
        f();
        this.e.c(connectionResult, this.c, this.d);
    }

    public final void e(zs3 zs3Var) {
        this.e = zs3Var;
    }
}
