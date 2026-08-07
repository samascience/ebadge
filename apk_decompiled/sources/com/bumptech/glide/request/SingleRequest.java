package com.bumptech.glide.request;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.h;
import com.tencent.connect.common.Constants;
import defpackage.cd1;
import defpackage.ed0;
import defpackage.ef2;
import defpackage.hr2;
import defpackage.if2;
import defpackage.j03;
import defpackage.m53;
import defpackage.na3;
import defpackage.qg2;
import defpackage.sg2;
import defpackage.tt2;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class SingleRequest implements ef2, hr2, sg2 {
    private static final boolean D = Log.isLoggable("Request", 2);
    private int A;
    private boolean B;
    private RuntimeException C;
    private final String a;
    private final tt2 b;
    private final Object c;
    private final if2 d;
    private final RequestCoordinator e;
    private final Context f;
    private final com.bumptech.glide.c g;
    private final Object h;
    private final Class i;
    private final a j;
    private final int k;
    private final int l;
    private final Priority m;
    private final j03 n;
    private final List o;
    private final m53 p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Executor f227q;
    private qg2 r;
    private h.d s;
    private long t;
    private volatile h u;
    private Status v;
    private Drawable w;
    private Drawable x;
    private Drawable y;
    private int z;

    private enum Status {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CLEARED
    }

    private SingleRequest(Context context, com.bumptech.glide.c cVar, Object obj, Object obj2, Class cls, a aVar, int i, int i2, Priority priority, j03 j03Var, if2 if2Var, List list, RequestCoordinator requestCoordinator, h hVar, m53 m53Var, Executor executor) {
        this.a = D ? String.valueOf(super.hashCode()) : null;
        this.b = tt2.a();
        this.c = obj;
        this.f = context;
        this.g = cVar;
        this.h = obj2;
        this.i = cls;
        this.j = aVar;
        this.k = i;
        this.l = i2;
        this.m = priority;
        this.n = j03Var;
        this.d = if2Var;
        this.o = list;
        this.e = requestCoordinator;
        this.u = hVar;
        this.p = m53Var;
        this.f227q = executor;
        this.v = Status.PENDING;
        if (this.C == null && cVar.g().a(com.bumptech.glide.b.c.class)) {
            this.C = new RuntimeException("Glide request origin trace");
        }
    }

    private void A() {
        if (l()) {
            Drawable drawableP = this.h == null ? p() : null;
            if (drawableP == null) {
                drawableP = o();
            }
            if (drawableP == null) {
                drawableP = q();
            }
            this.n.e(drawableP);
        }
    }

    private void h() {
        if (this.B) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    private boolean k() {
        RequestCoordinator requestCoordinator = this.e;
        return requestCoordinator == null || requestCoordinator.d(this);
    }

    private boolean l() {
        RequestCoordinator requestCoordinator = this.e;
        return requestCoordinator == null || requestCoordinator.g(this);
    }

    private boolean m() {
        RequestCoordinator requestCoordinator = this.e;
        return requestCoordinator == null || requestCoordinator.h(this);
    }

    private void n() {
        h();
        this.b.c();
        this.n.d(this);
        h.d dVar = this.s;
        if (dVar != null) {
            dVar.a();
            this.s = null;
        }
    }

    private Drawable o() {
        if (this.w == null) {
            Drawable drawableL = this.j.l();
            this.w = drawableL;
            if (drawableL == null && this.j.k() > 0) {
                this.w = s(this.j.k());
            }
        }
        return this.w;
    }

    private Drawable p() {
        if (this.y == null) {
            Drawable drawableM = this.j.m();
            this.y = drawableM;
            if (drawableM == null && this.j.o() > 0) {
                this.y = s(this.j.o());
            }
        }
        return this.y;
    }

    private Drawable q() {
        if (this.x == null) {
            Drawable drawableT = this.j.t();
            this.x = drawableT;
            if (drawableT == null && this.j.u() > 0) {
                this.x = s(this.j.u());
            }
        }
        return this.x;
    }

    private boolean r() {
        RequestCoordinator requestCoordinator = this.e;
        return requestCoordinator == null || !requestCoordinator.getRoot().b();
    }

    private Drawable s(int i) {
        return ed0.a(this.g, i, this.j.z() != null ? this.j.z() : this.f.getTheme());
    }

    private void t(String str) {
        Log.v("Request", str + " this: " + this.a);
    }

    private static int u(int i, float f) {
        return i == Integer.MIN_VALUE ? i : Math.round(f * i);
    }

    private void v() {
        RequestCoordinator requestCoordinator = this.e;
        if (requestCoordinator != null) {
            requestCoordinator.a(this);
        }
    }

    private void w() {
        RequestCoordinator requestCoordinator = this.e;
        if (requestCoordinator != null) {
            requestCoordinator.c(this);
        }
    }

    public static SingleRequest x(Context context, com.bumptech.glide.c cVar, Object obj, Object obj2, Class cls, a aVar, int i, int i2, Priority priority, j03 j03Var, if2 if2Var, List list, RequestCoordinator requestCoordinator, h hVar, m53 m53Var, Executor executor) {
        return new SingleRequest(context, cVar, obj, obj2, cls, aVar, i, i2, priority, j03Var, if2Var, list, requestCoordinator, hVar, m53Var, executor);
    }

    private void y(GlideException glideException, int i) {
        boolean zOnLoadFailed;
        this.b.c();
        synchronized (this.c) {
            try {
                glideException.setOrigin(this.C);
                int iH = this.g.h();
                if (iH <= i) {
                    Log.w("Glide", "Load failed for " + this.h + " with size [" + this.z + "x" + this.A + "]", glideException);
                    if (iH <= 4) {
                        glideException.logRootCauses("Glide");
                    }
                }
                this.s = null;
                this.v = Status.FAILED;
                boolean z = true;
                this.B = true;
                try {
                    List list = this.o;
                    if (list != null) {
                        Iterator it = list.iterator();
                        zOnLoadFailed = false;
                        while (it.hasNext()) {
                            zOnLoadFailed |= ((if2) it.next()).onLoadFailed(glideException, this.h, this.n, r());
                        }
                    } else {
                        zOnLoadFailed = false;
                    }
                    if2 if2Var = this.d;
                    if (if2Var == null || !if2Var.onLoadFailed(glideException, this.h, this.n, r())) {
                        z = false;
                    }
                    if (!(zOnLoadFailed | z)) {
                        A();
                    }
                    this.B = false;
                    v();
                } catch (Throwable th) {
                    this.B = false;
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private void z(qg2 qg2Var, Object obj, DataSource dataSource, boolean z) {
        boolean zOnResourceReady;
        boolean zR = r();
        this.v = Status.COMPLETE;
        this.r = qg2Var;
        if (this.g.h() <= 3) {
            Log.d("Glide", "Finished loading " + obj.getClass().getSimpleName() + " from " + dataSource + " for " + this.h + " with size [" + this.z + "x" + this.A + "] in " + cd1.a(this.t) + " ms");
        }
        boolean z2 = true;
        this.B = true;
        try {
            List list = this.o;
            if (list != null) {
                Iterator it = list.iterator();
                zOnResourceReady = false;
                while (it.hasNext()) {
                    zOnResourceReady |= ((if2) it.next()).onResourceReady(obj, this.h, this.n, dataSource, zR);
                }
            } else {
                zOnResourceReady = false;
            }
            if2 if2Var = this.d;
            if (if2Var == null || !if2Var.onResourceReady(obj, this.h, this.n, dataSource, zR)) {
                z2 = false;
            }
            if (!(z2 | zOnResourceReady)) {
                this.n.b(obj, this.p.a(dataSource, zR));
            }
            this.B = false;
            w();
        } catch (Throwable th) {
            this.B = false;
            throw th;
        }
    }

    @Override // defpackage.sg2
    public void a(GlideException glideException) {
        y(glideException, 5);
    }

    @Override // defpackage.ef2
    public boolean b() {
        boolean z;
        synchronized (this.c) {
            z = this.v == Status.COMPLETE;
        }
        return z;
    }

    @Override // defpackage.sg2
    public void c(qg2 qg2Var, DataSource dataSource, boolean z) {
        this.b.c();
        qg2 qg2Var2 = null;
        try {
            synchronized (this.c) {
                try {
                    this.s = null;
                    if (qg2Var == null) {
                        a(new GlideException("Expected to receive a Resource<R> with an object of " + this.i + " inside, but instead got null."));
                        return;
                    }
                    Object obj = qg2Var.get();
                    try {
                        if (obj != null && this.i.isAssignableFrom(obj.getClass())) {
                            if (m()) {
                                z(qg2Var, obj, dataSource, z);
                                return;
                            }
                            this.r = null;
                            this.v = Status.COMPLETE;
                            this.u.k(qg2Var);
                            return;
                        }
                        this.r = null;
                        StringBuilder sb = new StringBuilder();
                        sb.append("Expected to receive an object of ");
                        sb.append(this.i);
                        sb.append(" but instead got ");
                        sb.append(obj != null ? obj.getClass() : Constants.STR_EMPTY);
                        sb.append("{");
                        sb.append(obj);
                        sb.append("} inside Resource{");
                        sb.append(qg2Var);
                        sb.append("}.");
                        sb.append(obj != null ? Constants.STR_EMPTY : " To indicate failure return a null Resource object, rather than a Resource object containing null data.");
                        a(new GlideException(sb.toString()));
                        this.u.k(qg2Var);
                    } catch (Throwable th) {
                        qg2Var2 = qg2Var;
                        th = th;
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } catch (Throwable th3) {
            if (qg2Var2 != null) {
                this.u.k(qg2Var2);
            }
            throw th3;
        }
    }

    @Override // defpackage.ef2
    public void clear() {
        synchronized (this.c) {
            try {
                h();
                this.b.c();
                Status status = this.v;
                Status status2 = Status.CLEARED;
                if (status == status2) {
                    return;
                }
                n();
                qg2 qg2Var = this.r;
                if (qg2Var != null) {
                    this.r = null;
                } else {
                    qg2Var = null;
                }
                if (k()) {
                    this.n.h(q());
                }
                this.v = status2;
                if (qg2Var != null) {
                    this.u.k(qg2Var);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.hr2
    public void d(int i, int i2) throws Throwable {
        Object obj;
        this.b.c();
        Object obj2 = this.c;
        synchronized (obj2) {
            try {
                try {
                    boolean z = D;
                    if (z) {
                        t("Got onSizeReady in " + cd1.a(this.t));
                    }
                    if (this.v == Status.WAITING_FOR_SIZE) {
                        Status status = Status.RUNNING;
                        this.v = status;
                        float fY = this.j.y();
                        this.z = u(i, fY);
                        this.A = u(i2, fY);
                        if (z) {
                            t("finished setup for calling load in " + cd1.a(this.t));
                        }
                        obj = obj2;
                        try {
                            this.s = this.u.f(this.g, this.h, this.j.x(), this.z, this.A, this.j.w(), this.i, this.m, this.j.j(), this.j.A(), this.j.K(), this.j.G(), this.j.q(), this.j.E(), this.j.C(), this.j.B(), this.j.p(), this, this.f227q);
                            if (this.v != status) {
                                this.s = null;
                            }
                            if (z) {
                                t("finished onSizeReady in " + cd1.a(this.t));
                            }
                        } catch (Throwable th) {
                            th = th;
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                obj = obj2;
            }
        }
    }

    @Override // defpackage.ef2
    public void e() {
        synchronized (this.c) {
            try {
                h();
                this.b.c();
                this.t = cd1.b();
                if (this.h == null) {
                    if (na3.s(this.k, this.l)) {
                        this.z = this.k;
                        this.A = this.l;
                    }
                    y(new GlideException("Received null model"), p() == null ? 5 : 3);
                    return;
                }
                Status status = this.v;
                Status status2 = Status.RUNNING;
                if (status == status2) {
                    throw new IllegalArgumentException("Cannot restart a running request");
                }
                if (status == Status.COMPLETE) {
                    c(this.r, DataSource.MEMORY_CACHE, false);
                    return;
                }
                Status status3 = Status.WAITING_FOR_SIZE;
                this.v = status3;
                if (na3.s(this.k, this.l)) {
                    d(this.k, this.l);
                } else {
                    this.n.a(this);
                }
                Status status4 = this.v;
                if ((status4 == status2 || status4 == status3) && l()) {
                    this.n.f(q());
                }
                if (D) {
                    t("finished run method in " + cd1.a(this.t));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.ef2
    public boolean f(ef2 ef2Var) {
        int i;
        int i2;
        Object obj;
        Class cls;
        a aVar;
        Priority priority;
        int size;
        int i3;
        int i4;
        Object obj2;
        Class cls2;
        a aVar2;
        Priority priority2;
        int size2;
        if (!(ef2Var instanceof SingleRequest)) {
            return false;
        }
        synchronized (this.c) {
            try {
                i = this.k;
                i2 = this.l;
                obj = this.h;
                cls = this.i;
                aVar = this.j;
                priority = this.m;
                List list = this.o;
                size = list != null ? list.size() : 0;
            } catch (Throwable th) {
                throw th;
            }
        }
        SingleRequest singleRequest = (SingleRequest) ef2Var;
        synchronized (singleRequest.c) {
            try {
                i3 = singleRequest.k;
                i4 = singleRequest.l;
                obj2 = singleRequest.h;
                cls2 = singleRequest.i;
                aVar2 = singleRequest.j;
                priority2 = singleRequest.m;
                List list2 = singleRequest.o;
                size2 = list2 != null ? list2.size() : 0;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return i == i3 && i2 == i4 && na3.b(obj, obj2) && cls.equals(cls2) && aVar.equals(aVar2) && priority == priority2 && size == size2;
    }

    @Override // defpackage.sg2
    public Object g() {
        this.b.c();
        return this.c;
    }

    @Override // defpackage.ef2
    public boolean i() {
        boolean z;
        synchronized (this.c) {
            z = this.v == Status.CLEARED;
        }
        return z;
    }

    @Override // defpackage.ef2
    public boolean isRunning() {
        boolean z;
        synchronized (this.c) {
            try {
                Status status = this.v;
                z = status == Status.RUNNING || status == Status.WAITING_FOR_SIZE;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    @Override // defpackage.ef2
    public boolean j() {
        boolean z;
        synchronized (this.c) {
            z = this.v == Status.COMPLETE;
        }
        return z;
    }

    @Override // defpackage.ef2
    public void pause() {
        synchronized (this.c) {
            try {
                if (isRunning()) {
                    clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
