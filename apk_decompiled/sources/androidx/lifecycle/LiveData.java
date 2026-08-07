package androidx.lifecycle;

import defpackage.db1;
import defpackage.l9;
import defpackage.lj2;
import defpackage.vt1;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class LiveData {
    static final Object k = new Object();
    final Object a;
    private lj2 b;
    int c;
    private boolean d;
    private volatile Object e;
    volatile Object f;
    private int g;
    private boolean h;
    private boolean i;
    private final Runnable j;

    class LifecycleBoundObserver extends androidx.lifecycle.LiveData.c implements f {
        final db1 e;

        LifecycleBoundObserver(db1 db1Var, vt1 vt1Var) {
            super(vt1Var);
            this.e = db1Var;
        }

        void b() {
            this.e.getLifecycle().d(this);
        }

        @Override // androidx.lifecycle.f
        public void c(db1 db1Var, Lifecycle.Event event) {
            Lifecycle.State stateB = this.e.getLifecycle().b();
            if (stateB == Lifecycle.State.DESTROYED) {
                LiveData.this.n(this.a);
                return;
            }
            Lifecycle.State state = null;
            while (state != stateB) {
                a(f());
                state = stateB;
                stateB = this.e.getLifecycle().b();
            }
        }

        boolean e(db1 db1Var) {
            return this.e == db1Var;
        }

        boolean f() {
            return this.e.getLifecycle().b().isAtLeast(Lifecycle.State.STARTED);
        }
    }

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            synchronized (LiveData.this.a) {
                obj = LiveData.this.f;
                LiveData.this.f = LiveData.k;
            }
            LiveData.this.o(obj);
        }
    }

    private class b extends c {
        b(vt1 vt1Var) {
            super(vt1Var);
        }

        @Override // androidx.lifecycle.LiveData.c
        boolean f() {
            return true;
        }
    }

    private abstract class c {
        final vt1 a;
        boolean b;
        int c = -1;

        c(vt1 vt1Var) {
            this.a = vt1Var;
        }

        void a(boolean z) {
            if (z == this.b) {
                return;
            }
            this.b = z;
            LiveData.this.c(z ? 1 : -1);
            if (this.b) {
                LiveData.this.e(this);
            }
        }

        void b() {
        }

        boolean e(db1 db1Var) {
            return false;
        }

        abstract boolean f();
    }

    public LiveData(Object obj) {
        this.a = new Object();
        this.b = new lj2();
        this.c = 0;
        this.f = k;
        this.j = new a();
        this.e = obj;
        this.g = 0;
    }

    static void b(String str) {
        if (l9.g().b()) {
            return;
        }
        throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
    }

    private void d(c cVar) {
        if (cVar.b) {
            if (!cVar.f()) {
                cVar.a(false);
                return;
            }
            int i = cVar.c;
            int i2 = this.g;
            if (i >= i2) {
                return;
            }
            cVar.c = i2;
            cVar.a.b(this.e);
        }
    }

    void c(int i) {
        int i2 = this.c;
        this.c = i + i2;
        if (this.d) {
            return;
        }
        this.d = true;
        while (true) {
            try {
                int i3 = this.c;
                if (i2 == i3) {
                    this.d = false;
                    return;
                }
                boolean z = i2 == 0 && i3 > 0;
                boolean z2 = i2 > 0 && i3 == 0;
                if (z) {
                    k();
                } else if (z2) {
                    l();
                }
                i2 = i3;
            } catch (Throwable th) {
                this.d = false;
                throw th;
            }
        }
    }

    void e(c cVar) {
        if (this.h) {
            this.i = true;
            return;
        }
        this.h = true;
        do {
            this.i = false;
            if (cVar != null) {
                d(cVar);
                cVar = null;
            } else {
                lj2.d dVarC = this.b.c();
                while (dVarC.hasNext()) {
                    d((c) ((Map.Entry) dVarC.next()).getValue());
                    if (this.i) {
                        break;
                    }
                }
            }
        } while (this.i);
        this.h = false;
    }

    public Object f() {
        Object obj = this.e;
        if (obj != k) {
            return obj;
        }
        return null;
    }

    int g() {
        return this.g;
    }

    public boolean h() {
        return this.c > 0;
    }

    public void i(db1 db1Var, vt1 vt1Var) {
        b("observe");
        if (db1Var.getLifecycle().b() == Lifecycle.State.DESTROYED) {
            return;
        }
        LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(db1Var, vt1Var);
        c cVar = (c) this.b.f(vt1Var, lifecycleBoundObserver);
        if (cVar != null && !cVar.e(db1Var)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (cVar != null) {
            return;
        }
        db1Var.getLifecycle().a(lifecycleBoundObserver);
    }

    public void j(vt1 vt1Var) {
        b("observeForever");
        b bVar = new b(vt1Var);
        c cVar = (c) this.b.f(vt1Var, bVar);
        if (cVar instanceof LifecycleBoundObserver) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (cVar != null) {
            return;
        }
        bVar.a(true);
    }

    protected void k() {
    }

    protected void l() {
    }

    protected void m(Object obj) {
        boolean z;
        synchronized (this.a) {
            z = this.f == k;
            this.f = obj;
        }
        if (z) {
            l9.g().c(this.j);
        }
    }

    public void n(vt1 vt1Var) {
        b("removeObserver");
        c cVar = (c) this.b.g(vt1Var);
        if (cVar == null) {
            return;
        }
        cVar.b();
        cVar.a(false);
    }

    protected void o(Object obj) {
        b("setValue");
        this.g++;
        this.e = obj;
        e(null);
    }

    public LiveData() {
        this.a = new Object();
        this.b = new lj2();
        this.c = 0;
        Object obj = k;
        this.f = obj;
        this.j = new a();
        this.e = obj;
        this.g = -1;
    }
}
