package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import defpackage.p62;
import defpackage.vs3;
import defpackage.za1;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public abstract class w0 extends LifecycleCallback implements DialogInterface.OnCancelListener {
    protected volatile boolean b;
    protected final AtomicReference c;
    private final Handler d;
    protected final com.google.android.gms.common.a e;

    protected w0(za1 za1Var) {
        this(za1Var, com.google.android.gms.common.a.n());
    }

    private static int k(x0 x0Var) {
        if (x0Var == null) {
            return -1;
        }
        return x0Var.b();
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void d(int i, int i2, Intent intent) {
        x0 x0Var = (x0) this.c.get();
        boolean z = true;
        if (i != 1) {
            if (i != 2) {
                z = false;
            } else {
                int iG = this.e.g(b());
                z = iG == 0;
                if (x0Var == null) {
                    return;
                }
                if (x0Var.a().F0() == 18 && iG == 18) {
                    return;
                }
            }
        } else if (i2 != -1) {
            if (i2 == 0) {
                x0 x0Var2 = new x0(new ConnectionResult(intent != null ? intent.getIntExtra("<<ResolutionFailureErrorDetail>>", 13) : 13, null), k(x0Var));
                this.c.set(x0Var2);
                x0Var = x0Var2;
            }
            z = false;
        }
        if (z) {
            o();
        } else if (x0Var != null) {
            l(x0Var.a(), x0Var.b());
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void e(Bundle bundle) {
        super.e(bundle);
        if (bundle != null) {
            this.c.set(bundle.getBoolean("resolving_error", false) ? new x0(new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution")), bundle.getInt("failed_client_id", -1)) : null);
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void h(Bundle bundle) {
        super.h(bundle);
        x0 x0Var = (x0) this.c.get();
        if (x0Var != null) {
            bundle.putBoolean("resolving_error", true);
            bundle.putInt("failed_client_id", x0Var.b());
            bundle.putInt("failed_status", x0Var.a().F0());
            bundle.putParcelable("failed_resolution", x0Var.a().H0());
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void i() {
        super.i();
        this.b = true;
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void j() {
        super.j();
        this.b = false;
    }

    protected abstract void l(ConnectionResult connectionResult, int i);

    public final void m(ConnectionResult connectionResult, int i) {
        x0 x0Var = new x0(connectionResult, i);
        if (p62.a(this.c, null, x0Var)) {
            this.d.post(new y0(this, x0Var));
        }
    }

    protected abstract void n();

    protected final void o() {
        this.c.set(null);
        n();
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        l(new ConnectionResult(13, null), k((x0) this.c.get()));
        o();
    }

    private w0(za1 za1Var, com.google.android.gms.common.a aVar) {
        super(za1Var);
        this.c = new AtomicReference(null);
        this.d = new vs3(Looper.getMainLooper());
        this.e = aVar;
    }
}
