package defpackage;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public abstract class rt2 implements ut1 {
    private final AtomicReference b;
    private final Object a = new Object();
    private int c = 0;
    private boolean d = false;
    private final Map e = new HashMap();
    private final CopyOnWriteArraySet f = new CopyOnWriteArraySet();

    static abstract class a {
        a() {
        }

        static a b(Throwable th) {
            return new pd(th);
        }

        public abstract Throwable a();
    }

    private static final class b implements Runnable {
        private static final Object h = new Object();
        private final Executor a;
        private final ut1.a b;
        private final AtomicReference d;
        private final AtomicBoolean c = new AtomicBoolean(true);
        private Object e = h;
        private int f = -1;
        private boolean g = false;

        b(AtomicReference atomicReference, Executor executor, ut1.a aVar) {
            this.d = atomicReference;
            this.a = executor;
            this.b = aVar;
        }

        void a() {
            this.c.set(false);
        }

        void b(int i) {
            synchronized (this) {
                try {
                    if (this.c.get()) {
                        if (i <= this.f) {
                            return;
                        }
                        this.f = i;
                        if (this.g) {
                            return;
                        }
                        this.g = true;
                        try {
                            this.a.execute(this);
                        } catch (Throwable unused) {
                            synchronized (this) {
                                this.g = false;
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this) {
                try {
                    if (!this.c.get()) {
                        this.g = false;
                        return;
                    }
                    Object obj = this.d.get();
                    int i = this.f;
                    while (true) {
                        if (!Objects.equals(this.e, obj)) {
                            this.e = obj;
                            if (obj instanceof a) {
                                this.b.onError(((a) obj).a());
                            } else {
                                this.b.a(obj);
                            }
                        }
                        synchronized (this) {
                            try {
                                if (i == this.f || !this.c.get()) {
                                    break;
                                    break;
                                } else {
                                    obj = this.d.get();
                                    i = this.f;
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                    this.g = false;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    rt2(Object obj, boolean z) {
        if (!z) {
            this.b = new AtomicReference(obj);
        } else {
            b52.b(obj instanceof Throwable, "Initial errors must be Throwable");
            this.b = new AtomicReference(a.b((Throwable) obj));
        }
    }

    private void b(ut1.a aVar) {
        b bVar = (b) this.e.remove(aVar);
        if (bVar != null) {
            bVar.a();
            this.f.remove(bVar);
        }
    }

    private void g(Object obj) {
        Iterator it;
        int i;
        synchronized (this.a) {
            try {
                if (Objects.equals(this.b.getAndSet(obj), obj)) {
                    return;
                }
                int i2 = this.c + 1;
                this.c = i2;
                if (this.d) {
                    return;
                }
                this.d = true;
                Iterator it2 = this.f.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        ((b) it2.next()).b(i2);
                    } else {
                        synchronized (this.a) {
                            try {
                                if (this.c == i2) {
                                    this.d = false;
                                    return;
                                } else {
                                    it = this.f.iterator();
                                    i = this.c;
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        it2 = it;
                        i2 = i;
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // defpackage.ut1
    public void a(Executor executor, ut1.a aVar) {
        b bVar;
        synchronized (this.a) {
            b(aVar);
            bVar = new b(this.b, executor, aVar);
            this.e.put(aVar, bVar);
            this.f.add(bVar);
        }
        bVar.b(0);
    }

    @Override // defpackage.ut1
    public ub1 d() {
        Object obj = this.b.get();
        return obj instanceof a ? os0.n(((a) obj).a()) : os0.p(obj);
    }

    @Override // defpackage.ut1
    public void e(ut1.a aVar) {
        synchronized (this.a) {
            b(aVar);
        }
    }

    void f(Object obj) {
        g(obj);
    }
}
