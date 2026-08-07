package defpackage;

import android.os.SystemClock;
import androidx.camera.core.impl.utils.executor.c;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class cc1 implements ut1 {
    final im1 a = new im1();
    private final Map b = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    static final class a implements vt1 {
        final AtomicBoolean a = new AtomicBoolean(true);
        final ut1.a b;
        final Executor c;

        a(Executor executor, ut1.a aVar) {
            this.c = executor;
            this.b = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(b bVar) {
            if (this.a.get()) {
                if (bVar.a()) {
                    this.b.a(bVar.d());
                } else {
                    b52.g(bVar.c());
                    this.b.onError(bVar.c());
                }
            }
        }

        void c() {
            this.a.set(false);
        }

        @Override // defpackage.vt1
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void b(final b bVar) {
            this.c.execute(new Runnable() { // from class: bc1
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.d(bVar);
                }
            });
        }
    }

    public static final class b {
        private final Object a;
        private final Throwable b;

        private b(Object obj, Throwable th) {
            this.a = obj;
            this.b = th;
        }

        static b b(Object obj) {
            return new b(obj, null);
        }

        public boolean a() {
            return this.b == null;
        }

        public Throwable c() {
            return this.b;
        }

        public Object d() {
            if (a()) {
                return this.a;
            }
            throw new IllegalStateException("Result contains an error. Does not contain a value.");
        }

        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append("[Result: <");
            if (a()) {
                str = "Value: " + this.a;
            } else {
                str = "Error: " + this.b;
            }
            sb.append(str);
            sb.append(">]");
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(a aVar, a aVar2) {
        if (aVar != null) {
            this.a.n(aVar);
        }
        this.a.j(aVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(CallbackToFutureAdapter.a aVar) {
        b bVar = (b) this.a.f();
        if (bVar == null) {
            aVar.f(new IllegalStateException("Observable has not yet been initialized with a value."));
        } else if (bVar.a()) {
            aVar.c(bVar.d());
        } else {
            b52.g(bVar.c());
            aVar.f(bVar.c());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object k(final CallbackToFutureAdapter.a aVar) {
        c.e().execute(new Runnable() { // from class: ac1
            @Override // java.lang.Runnable
            public final void run() {
                this.a.j(aVar);
            }
        });
        return this + " [fetch@" + SystemClock.uptimeMillis() + "]";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(a aVar) {
        this.a.n(aVar);
    }

    @Override // defpackage.ut1
    public void a(Executor executor, ut1.a aVar) {
        synchronized (this.b) {
            try {
                final a aVar2 = (a) this.b.get(aVar);
                if (aVar2 != null) {
                    aVar2.c();
                }
                final a aVar3 = new a(executor, aVar);
                this.b.put(aVar, aVar3);
                c.e().execute(new Runnable() { // from class: yb1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.i(aVar2, aVar3);
                    }
                });
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.ut1
    public ub1 d() {
        return CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: zb1
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
            public final Object a(CallbackToFutureAdapter.a aVar) {
                return this.a.k(aVar);
            }
        });
    }

    @Override // defpackage.ut1
    public void e(ut1.a aVar) {
        synchronized (this.b) {
            try {
                final a aVar2 = (a) this.b.remove(aVar);
                if (aVar2 != null) {
                    aVar2.c();
                    c.e().execute(new Runnable() { // from class: xb1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.a.l(aVar2);
                        }
                    });
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void m(Object obj) {
        this.a.m(b.b(obj));
    }
}
