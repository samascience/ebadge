package androidx.camera.core.impl;

import android.util.Log;
import android.util.Size;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import defpackage.os0;
import defpackage.ub1;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public abstract class DeferrableSurface {
    public static final Size k = new Size(0, 0);
    private static final boolean l = androidx.camera.core.x.f("DeferrableSurface");
    private static final AtomicInteger m = new AtomicInteger(0);
    private static final AtomicInteger n = new AtomicInteger(0);
    private final Object a;
    private int b;
    private boolean c;
    private CallbackToFutureAdapter.a d;
    private final ub1 e;
    private CallbackToFutureAdapter.a f;
    private final ub1 g;
    private final Size h;
    private final int i;
    Class j;

    public static final class SurfaceClosedException extends Exception {
        DeferrableSurface mDeferrableSurface;

        public SurfaceClosedException(String str, DeferrableSurface deferrableSurface) {
            super(str);
            this.mDeferrableSurface = deferrableSurface;
        }

        public DeferrableSurface getDeferrableSurface() {
            return this.mDeferrableSurface;
        }
    }

    public static final class SurfaceUnavailableException extends Exception {
        public SurfaceUnavailableException(String str) {
            super(str);
        }
    }

    public DeferrableSurface() {
        this(k, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object n(CallbackToFutureAdapter.a aVar) {
        synchronized (this.a) {
            this.d = aVar;
        }
        return "DeferrableSurface-termination(" + this + ")";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object o(CallbackToFutureAdapter.a aVar) {
        synchronized (this.a) {
            this.f = aVar;
        }
        return "DeferrableSurface-close(" + this + ")";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(String str) {
        try {
            this.e.get();
            q("Surface terminated", n.decrementAndGet(), m.get());
        } catch (Exception e) {
            androidx.camera.core.x.c("DeferrableSurface", "Unexpected surface termination for " + this + "\nStack Trace:\n" + str);
            synchronized (this.a) {
                throw new IllegalArgumentException(String.format("DeferrableSurface %s [closed: %b, use_count: %s] terminated with unexpected exception.", this, Boolean.valueOf(this.c), Integer.valueOf(this.b)), e);
            }
        }
    }

    private void q(String str, int i, int i2) {
        if (!l && androidx.camera.core.x.f("DeferrableSurface")) {
            androidx.camera.core.x.a("DeferrableSurface", "DeferrableSurface usage statistics may be inaccurate since debug logging was not enabled at static initialization time. App restart may be required to enable accurate usage statistics.");
        }
        androidx.camera.core.x.a("DeferrableSurface", str + "[total_surfaces=" + i + ", used_surfaces=" + i2 + "](" + this + "}");
    }

    public void d() {
        CallbackToFutureAdapter.a aVar;
        synchronized (this.a) {
            try {
                if (this.c) {
                    aVar = null;
                } else {
                    this.c = true;
                    this.f.c(null);
                    if (this.b == 0) {
                        aVar = this.d;
                        this.d = null;
                    } else {
                        aVar = null;
                    }
                    if (androidx.camera.core.x.f("DeferrableSurface")) {
                        androidx.camera.core.x.a("DeferrableSurface", "surface closed,  useCount=" + this.b + " closed=true " + this);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (aVar != null) {
            aVar.c(null);
        }
    }

    public void e() {
        CallbackToFutureAdapter.a aVar;
        synchronized (this.a) {
            try {
                int i = this.b;
                if (i == 0) {
                    throw new IllegalStateException("Decrementing use count occurs more times than incrementing");
                }
                int i2 = i - 1;
                this.b = i2;
                if (i2 == 0 && this.c) {
                    aVar = this.d;
                    this.d = null;
                } else {
                    aVar = null;
                }
                if (androidx.camera.core.x.f("DeferrableSurface")) {
                    androidx.camera.core.x.a("DeferrableSurface", "use count-1,  useCount=" + this.b + " closed=" + this.c + " " + this);
                    if (this.b == 0) {
                        q("Surface no longer in use", n.get(), m.decrementAndGet());
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (aVar != null) {
            aVar.c(null);
        }
    }

    public ub1 f() {
        return os0.B(this.g);
    }

    public Class g() {
        return this.j;
    }

    public Size h() {
        return this.h;
    }

    public int i() {
        return this.i;
    }

    public final ub1 j() {
        synchronized (this.a) {
            try {
                if (this.c) {
                    return os0.n(new SurfaceClosedException("DeferrableSurface already closed.", this));
                }
                return r();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public ub1 k() {
        return os0.B(this.e);
    }

    public void l() {
        synchronized (this.a) {
            try {
                int i = this.b;
                if (i == 0 && this.c) {
                    throw new SurfaceClosedException("Cannot begin use on a closed surface.", this);
                }
                this.b = i + 1;
                if (androidx.camera.core.x.f("DeferrableSurface")) {
                    if (this.b == 1) {
                        q("New surface in use", n.get(), m.incrementAndGet());
                    }
                    androidx.camera.core.x.a("DeferrableSurface", "use count+1, useCount=" + this.b + " " + this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean m() {
        boolean z;
        synchronized (this.a) {
            z = this.c;
        }
        return z;
    }

    protected abstract ub1 r();

    public void s(Class cls) {
        this.j = cls;
    }

    public DeferrableSurface(Size size, int i) {
        this.a = new Object();
        this.b = 0;
        this.c = false;
        this.h = size;
        this.i = i;
        ub1 ub1VarA = CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: z80
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
            public final Object a(CallbackToFutureAdapter.a aVar) {
                return this.a.n(aVar);
            }
        });
        this.e = ub1VarA;
        this.g = CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: a90
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
            public final Object a(CallbackToFutureAdapter.a aVar) {
                return this.a.o(aVar);
            }
        });
        if (androidx.camera.core.x.f("DeferrableSurface")) {
            q("Surface created", n.incrementAndGet(), m.get());
            final String stackTraceString = Log.getStackTraceString(new Exception());
            ub1VarA.a(new Runnable() { // from class: b90
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.p(stackTraceString);
                }
            }, androidx.camera.core.impl.utils.executor.c.b());
        }
    }
}
