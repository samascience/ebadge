package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import defpackage.ky;
import defpackage.mr3;
import defpackage.qr3;
import defpackage.rr3;
import defpackage.wo2;
import defpackage.ys3;
import defpackage.zs3;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/* JADX INFO: loaded from: classes.dex */
public final class d0 implements qr3, zs3 {
    private final Lock c;
    private final Condition d;
    private final Context e;
    private final com.google.android.gms.common.b f;
    private final f0 g;
    final Map h;
    private final ky j;
    private final Map k;
    private final com.google.android.gms.common.api.a.AbstractC0075a l;
    private volatile mr3 m;
    int o;
    final v p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    final rr3 f240q;
    final Map i = new HashMap();
    private ConnectionResult n = null;

    public d0(Context context, v vVar, Lock lock, Looper looper, com.google.android.gms.common.b bVar, Map map, ky kyVar, Map map2, com.google.android.gms.common.api.a.AbstractC0075a abstractC0075a, ArrayList arrayList, rr3 rr3Var) {
        this.e = context;
        this.c = lock;
        this.f = bVar;
        this.h = map;
        this.j = kyVar;
        this.k = map2;
        this.l = abstractC0075a;
        this.p = vVar;
        this.f240q = rr3Var;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((ys3) obj).e(this);
        }
        this.g = new f0(this, looper);
        this.d = lock.newCondition();
        this.m = new u(this);
    }

    @Override // com.google.android.gms.common.api.c.b
    public final void a(int i) {
        this.c.lock();
        try {
            this.m.a(i);
        } finally {
            this.c.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.c.b
    public final void b(Bundle bundle) {
        this.c.lock();
        try {
            this.m.b(bundle);
        } finally {
            this.c.unlock();
        }
    }

    @Override // defpackage.zs3
    public final void c(ConnectionResult connectionResult, com.google.android.gms.common.api.a aVar, boolean z) {
        this.c.lock();
        try {
            this.m.c(connectionResult, aVar, z);
        } finally {
            this.c.unlock();
        }
    }

    @Override // defpackage.qr3
    public final void connect() {
        this.m.connect();
    }

    @Override // defpackage.qr3
    public final b d(b bVar) {
        bVar.p();
        return this.m.d(bVar);
    }

    @Override // defpackage.qr3
    public final void disconnect() {
        if (this.m.disconnect()) {
            this.i.clear();
        }
    }

    @Override // defpackage.qr3
    public final void e(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String strConcat = String.valueOf(str).concat("  ");
        printWriter.append((CharSequence) str).append("mState=").println(this.m);
        for (com.google.android.gms.common.api.a aVar : this.k.keySet()) {
            printWriter.append((CharSequence) str).append((CharSequence) aVar.b()).println(":");
            ((com.google.android.gms.common.api.a.f) this.h.get(aVar.a())).e(strConcat, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // defpackage.qr3
    public final boolean f(wo2 wo2Var) {
        return false;
    }

    @Override // defpackage.qr3
    public final void g() {
    }

    @Override // defpackage.qr3
    public final ConnectionResult h() {
        connect();
        while (i()) {
            try {
                this.d.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return new ConnectionResult(15, null);
            }
        }
        if (isConnected()) {
            return ConnectionResult.e;
        }
        ConnectionResult connectionResult = this.n;
        return connectionResult != null ? connectionResult : new ConnectionResult(13, null);
    }

    public final boolean i() {
        return this.m instanceof j;
    }

    @Override // defpackage.qr3
    public final boolean isConnected() {
        return this.m instanceof g;
    }

    final void k(e0 e0Var) {
        this.g.sendMessage(this.g.obtainMessage(1, e0Var));
    }

    final void l() {
        this.c.lock();
        try {
            this.m = new j(this, this.j, this.k, this.f, this.l, this.c, this.e);
            this.m.e();
            this.d.signalAll();
        } finally {
            this.c.unlock();
        }
    }

    final void n(RuntimeException runtimeException) {
        this.g.sendMessage(this.g.obtainMessage(2, runtimeException));
    }

    final void o() {
        this.c.lock();
        try {
            this.p.B();
            this.m = new g(this);
            this.m.e();
            this.d.signalAll();
        } finally {
            this.c.unlock();
        }
    }

    final void p(ConnectionResult connectionResult) {
        this.c.lock();
        try {
            this.n = connectionResult;
            this.m = new u(this);
            this.m.e();
            this.d.signalAll();
        } finally {
            this.c.unlock();
        }
    }
}
