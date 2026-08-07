package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.Status;
import defpackage.a52;
import defpackage.jh2;
import defpackage.mh2;
import defpackage.tz1;
import defpackage.vs3;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
@KeepName
public abstract class BasePendingResult<R extends jh2> extends tz1 {
    static final ThreadLocal n = new a1();
    private final a b;
    private final WeakReference c;
    private mh2 f;
    private jh2 h;
    private Status i;
    private volatile boolean j;
    private boolean k;
    private boolean l;
    private final Object a = new Object();
    private final CountDownLatch d = new CountDownLatch(1);
    private final ArrayList e = new ArrayList();
    private final AtomicReference g = new AtomicReference();
    private boolean m = false;

    public static class a extends vs3 {
        public a(Looper looper) {
            super(looper);
        }

        public final void a(mh2 mh2Var, jh2 jh2Var) {
            sendMessage(obtainMessage(1, new Pair(mh2Var, jh2Var)));
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i != 1) {
                if (i == 2) {
                    ((BasePendingResult) message.obj).n(Status.j);
                    return;
                }
                StringBuilder sb = new StringBuilder(45);
                sb.append("Don't know how to handle message: ");
                sb.append(i);
                Log.wtf("BasePendingResult", sb.toString(), new Exception());
                return;
            }
            Pair pair = (Pair) message.obj;
            mh2 mh2Var = (mh2) pair.first;
            jh2 jh2Var = (jh2) pair.second;
            try {
                mh2Var.a(jh2Var);
            } catch (RuntimeException e) {
                BasePendingResult.m(jh2Var);
                throw e;
            }
        }
    }

    protected BasePendingResult(com.google.android.gms.common.api.c cVar) {
        this.b = new a(cVar != null ? cVar.m() : Looper.getMainLooper());
        this.c = new WeakReference(cVar);
    }

    private final jh2 h() {
        jh2 jh2Var;
        synchronized (this.a) {
            a52.j(!this.j, "Result has already been consumed.");
            a52.j(i(), "Result is not ready.");
            jh2Var = this.h;
            this.h = null;
            this.f = null;
            this.j = true;
        }
        r0 r0Var = (r0) this.g.getAndSet(null);
        if (r0Var != null) {
            r0Var.a(this);
        }
        return jh2Var;
    }

    private final void k(jh2 jh2Var) {
        this.h = jh2Var;
        this.d.countDown();
        this.i = this.h.n();
        if (this.k) {
            this.f = null;
        } else if (this.f != null) {
            this.b.removeMessages(2);
            this.b.a(this.f, h());
        }
        ArrayList arrayList = this.e;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((tz1.a) obj).a(this.i);
        }
        this.e.clear();
    }

    public static void m(jh2 jh2Var) {
    }

    @Override // defpackage.tz1
    public final void b(tz1.a aVar) {
        a52.b(aVar != null, "Callback cannot be null.");
        synchronized (this.a) {
            try {
                if (i()) {
                    aVar.a(this.i);
                } else {
                    this.e.add(aVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.tz1
    public void c() {
        synchronized (this.a) {
            try {
                if (!this.k && !this.j) {
                    m(this.h);
                    this.k = true;
                    k(g(Status.k));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.tz1
    public boolean d() {
        boolean z;
        synchronized (this.a) {
            z = this.k;
        }
        return z;
    }

    @Override // defpackage.tz1
    public final void e(mh2 mh2Var) {
        synchronized (this.a) {
            try {
                if (mh2Var == null) {
                    this.f = null;
                    return;
                }
                a52.j(!this.j, "Result has already been consumed.");
                a52.j(true, "Cannot set callbacks if then() has been called.");
                if (d()) {
                    return;
                }
                if (i()) {
                    this.b.a(mh2Var, h());
                } else {
                    this.f = mh2Var;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.tz1
    public final Integer f() {
        return null;
    }

    protected abstract jh2 g(Status status);

    public final boolean i() {
        return this.d.getCount() == 0;
    }

    public final void j(jh2 jh2Var) {
        synchronized (this.a) {
            try {
                if (this.l || this.k) {
                    m(jh2Var);
                    return;
                }
                i();
                a52.j(!i(), "Results have already been set");
                a52.j(!this.j, "Result has already been consumed");
                k(jh2Var);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void l(r0 r0Var) {
        this.g.set(r0Var);
    }

    public final void n(Status status) {
        synchronized (this.a) {
            try {
                if (!i()) {
                    j(g(status));
                    this.l = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean o() {
        boolean zD;
        synchronized (this.a) {
            try {
                if (((com.google.android.gms.common.api.c) this.c.get()) == null || !this.m) {
                    c();
                }
                zD = d();
            } catch (Throwable th) {
                throw th;
            }
        }
        return zD;
    }

    public final void p() {
        this.m = this.m || ((Boolean) n.get()).booleanValue();
    }
}
