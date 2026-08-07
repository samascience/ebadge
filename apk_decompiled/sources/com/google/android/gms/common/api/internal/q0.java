package com.google.android.gms.common.api.internal;

import android.os.IBinder;
import defpackage.e43;
import defpackage.yr3;
import java.lang.ref.WeakReference;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
final class q0 implements IBinder.DeathRecipient, r0 {
    private final WeakReference a;
    private final WeakReference b;
    private final WeakReference c;

    private q0(BasePendingResult basePendingResult, yr3 yr3Var, IBinder iBinder) {
        this.b = new WeakReference(yr3Var);
        this.a = new WeakReference(basePendingResult);
        this.c = new WeakReference(iBinder);
    }

    private final void b() {
        e43.a(this.b.get());
        IBinder iBinder = (IBinder) this.c.get();
        if (iBinder != null) {
            try {
                iBinder.unlinkToDeath(this, 0);
            } catch (NoSuchElementException unused) {
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.r0
    public final void a(BasePendingResult basePendingResult) {
        b();
    }

    @Override // android.os.IBinder.DeathRecipient
    public final void binderDied() {
        b();
    }

    /* synthetic */ q0(BasePendingResult basePendingResult, yr3 yr3Var, IBinder iBinder, p0 p0Var) {
        this(basePendingResult, null, iBinder);
    }
}
