package defpackage;

import android.os.SystemClock;
import android.view.Choreographer;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class x6 {
    public static final ThreadLocal g = new ThreadLocal();
    private c d;
    private final ap2 a = new ap2();
    final ArrayList b = new ArrayList();
    private final a c = new a();
    long e = 0;
    private boolean f = false;

    class a {
        a() {
        }

        void a() {
            x6.this.e = SystemClock.uptimeMillis();
            x6 x6Var = x6.this;
            x6Var.c(x6Var.e);
            if (x6.this.b.size() > 0) {
                x6.this.e().a();
            }
        }
    }

    interface b {
        boolean a(long j);
    }

    static abstract class c {
        final a a;

        c(a aVar) {
            this.a = aVar;
        }

        abstract void a();
    }

    private static class d extends c {
        private final Choreographer b;
        private final Choreographer.FrameCallback c;

        class a implements Choreographer.FrameCallback {
            a() {
            }

            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j) {
                d.this.a.a();
            }
        }

        d(a aVar) {
            super(aVar);
            this.b = Choreographer.getInstance();
            this.c = new a();
        }

        @Override // x6.c
        void a() {
            this.b.postFrameCallback(this.c);
        }
    }

    x6() {
    }

    private void b() {
        if (this.f) {
            for (int size = this.b.size() - 1; size >= 0; size--) {
                if (this.b.get(size) == null) {
                    this.b.remove(size);
                }
            }
            this.f = false;
        }
    }

    public static x6 d() {
        ThreadLocal threadLocal = g;
        if (threadLocal.get() == null) {
            threadLocal.set(new x6());
        }
        return (x6) threadLocal.get();
    }

    private boolean f(b bVar, long j) {
        Long l = (Long) this.a.get(bVar);
        if (l == null) {
            return true;
        }
        if (l.longValue() >= j) {
            return false;
        }
        this.a.remove(bVar);
        return true;
    }

    public void a(b bVar, long j) {
        if (this.b.size() == 0) {
            e().a();
        }
        if (!this.b.contains(bVar)) {
            this.b.add(bVar);
        }
        if (j > 0) {
            this.a.put(bVar, Long.valueOf(SystemClock.uptimeMillis() + j));
        }
    }

    void c(long j) {
        long jUptimeMillis = SystemClock.uptimeMillis();
        for (int i = 0; i < this.b.size(); i++) {
            b bVar = (b) this.b.get(i);
            if (bVar != null && f(bVar, jUptimeMillis)) {
                bVar.a(j);
            }
        }
        b();
    }

    c e() {
        if (this.d == null) {
            this.d = new d(this.c);
        }
        return this.d;
    }

    public void g(b bVar) {
        this.a.remove(bVar);
        int iIndexOf = this.b.indexOf(bVar);
        if (iIndexOf >= 0) {
            this.b.set(iIndexOf, null);
            this.f = true;
        }
    }
}
