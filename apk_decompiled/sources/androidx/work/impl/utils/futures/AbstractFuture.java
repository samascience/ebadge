package androidx.work.impl.utils.futures;

import defpackage.q1;
import defpackage.ub1;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractFuture implements ub1 {
    static final boolean d = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
    private static final Logger e = Logger.getLogger(AbstractFuture.class.getName());
    static final b f;
    private static final Object g;
    volatile Object a;
    volatile d b;
    volatile h c;

    private static final class Failure {
        static final Failure b = new Failure(new Throwable("Failure occurred while trying to finish a future.") { // from class: androidx.work.impl.utils.futures.AbstractFuture.Failure.1
            @Override // java.lang.Throwable
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        });
        final Throwable a;

        Failure(Throwable th) {
            this.a = (Throwable) AbstractFuture.e(th);
        }
    }

    private static abstract class b {
        private b() {
        }

        abstract boolean a(AbstractFuture abstractFuture, d dVar, d dVar2);

        abstract boolean b(AbstractFuture abstractFuture, Object obj, Object obj2);

        abstract boolean c(AbstractFuture abstractFuture, h hVar, h hVar2);

        abstract void d(h hVar, h hVar2);

        abstract void e(h hVar, Thread thread);
    }

    private static final class c {
        static final c c;
        static final c d;
        final boolean a;
        final Throwable b;

        static {
            if (AbstractFuture.d) {
                d = null;
                c = null;
            } else {
                d = new c(false, null);
                c = new c(true, null);
            }
        }

        c(boolean z, Throwable th) {
            this.a = z;
            this.b = th;
        }
    }

    private static final class d {
        static final d d = new d(null, null);
        final Runnable a;
        final Executor b;
        d c;

        d(Runnable runnable, Executor executor) {
            this.a = runnable;
            this.b = executor;
        }
    }

    private static final class e extends b {
        final AtomicReferenceFieldUpdater a;
        final AtomicReferenceFieldUpdater b;
        final AtomicReferenceFieldUpdater c;
        final AtomicReferenceFieldUpdater d;
        final AtomicReferenceFieldUpdater e;

        e(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
            super();
            this.a = atomicReferenceFieldUpdater;
            this.b = atomicReferenceFieldUpdater2;
            this.c = atomicReferenceFieldUpdater3;
            this.d = atomicReferenceFieldUpdater4;
            this.e = atomicReferenceFieldUpdater5;
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.b
        boolean a(AbstractFuture abstractFuture, d dVar, d dVar2) {
            return q1.a(this.d, abstractFuture, dVar, dVar2);
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.b
        boolean b(AbstractFuture abstractFuture, Object obj, Object obj2) {
            return q1.a(this.e, abstractFuture, obj, obj2);
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.b
        boolean c(AbstractFuture abstractFuture, h hVar, h hVar2) {
            return q1.a(this.c, abstractFuture, hVar, hVar2);
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.b
        void d(h hVar, h hVar2) {
            this.b.lazySet(hVar, hVar2);
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.b
        void e(h hVar, Thread thread) {
            this.a.lazySet(hVar, thread);
        }
    }

    private static final class f implements Runnable {
        final AbstractFuture a;
        final ub1 b;

        f(AbstractFuture abstractFuture, ub1 ub1Var) {
            this.a = abstractFuture;
            this.b = ub1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a.a != this) {
                return;
            }
            if (AbstractFuture.f.b(this.a, this, AbstractFuture.j(this.b))) {
                AbstractFuture.g(this.a);
            }
        }
    }

    private static final class g extends b {
        g() {
            super();
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.b
        boolean a(AbstractFuture abstractFuture, d dVar, d dVar2) {
            synchronized (abstractFuture) {
                try {
                    if (abstractFuture.b != dVar) {
                        return false;
                    }
                    abstractFuture.b = dVar2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.b
        boolean b(AbstractFuture abstractFuture, Object obj, Object obj2) {
            synchronized (abstractFuture) {
                try {
                    if (abstractFuture.a != obj) {
                        return false;
                    }
                    abstractFuture.a = obj2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.b
        boolean c(AbstractFuture abstractFuture, h hVar, h hVar2) {
            synchronized (abstractFuture) {
                try {
                    if (abstractFuture.c != hVar) {
                        return false;
                    }
                    abstractFuture.c = hVar2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.b
        void d(h hVar, h hVar2) {
            hVar.b = hVar2;
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.b
        void e(h hVar, Thread thread) {
            hVar.a = thread;
        }
    }

    private static final class h {
        static final h c = new h(false);
        volatile Thread a;
        volatile h b;

        h(boolean z) {
        }

        void a(h hVar) {
            AbstractFuture.f.d(this, hVar);
        }

        void b() {
            Thread thread = this.a;
            if (thread != null) {
                this.a = null;
                LockSupport.unpark(thread);
            }
        }

        h() {
            AbstractFuture.f.e(this, Thread.currentThread());
        }
    }

    static {
        b gVar;
        try {
            gVar = new e(AtomicReferenceFieldUpdater.newUpdater(h.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(h.class, h.class, "b"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, h.class, "c"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, d.class, "b"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Object.class, "a"));
            th = null;
        } catch (Throwable th) {
            th = th;
            gVar = new g();
        }
        f = gVar;
        if (th != null) {
            e.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        g = new Object();
    }

    protected AbstractFuture() {
    }

    private void b(StringBuilder sb) {
        try {
            Object objK = k(this);
            sb.append("SUCCESS, result=[");
            sb.append(s(objK));
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (RuntimeException e2) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e2.getClass());
            sb.append(" thrown from get()]");
        } catch (ExecutionException e3) {
            sb.append("FAILURE, cause=[");
            sb.append(e3.getCause());
            sb.append("]");
        }
    }

    private static CancellationException d(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    static Object e(Object obj) {
        obj.getClass();
        return obj;
    }

    private d f(d dVar) {
        d dVar2;
        do {
            dVar2 = this.b;
        } while (!f.a(this, dVar2, d.d));
        d dVar3 = dVar;
        d dVar4 = dVar2;
        while (dVar4 != null) {
            d dVar5 = dVar4.c;
            dVar4.c = dVar3;
            dVar3 = dVar4;
            dVar4 = dVar5;
        }
        return dVar3;
    }

    static void g(AbstractFuture abstractFuture) {
        d dVar = null;
        while (true) {
            abstractFuture.n();
            abstractFuture.c();
            d dVarF = abstractFuture.f(dVar);
            while (dVarF != null) {
                dVar = dVarF.c;
                Runnable runnable = dVarF.a;
                if (runnable instanceof f) {
                    f fVar = (f) runnable;
                    abstractFuture = fVar.a;
                    if (abstractFuture.a == fVar) {
                        if (f.b(abstractFuture, fVar, j(fVar.b))) {
                        }
                    } else {
                        continue;
                    }
                } else {
                    h(runnable, dVarF.b);
                }
                dVarF = dVar;
            }
            return;
        }
    }

    private static void h(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e2) {
            e.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e2);
        }
    }

    private Object i(Object obj) throws ExecutionException {
        if (obj instanceof c) {
            throw d("Task was cancelled.", ((c) obj).b);
        }
        if (obj instanceof Failure) {
            throw new ExecutionException(((Failure) obj).a);
        }
        if (obj == g) {
            return null;
        }
        return obj;
    }

    static Object j(ub1 ub1Var) {
        if (ub1Var instanceof AbstractFuture) {
            Object obj = ((AbstractFuture) ub1Var).a;
            if (!(obj instanceof c)) {
                return obj;
            }
            c cVar = (c) obj;
            if (cVar.a) {
                return cVar.b != null ? new c(false, cVar.b) : c.d;
            }
            return obj;
        }
        boolean zIsCancelled = ub1Var.isCancelled();
        if ((!d) && zIsCancelled) {
            return c.d;
        }
        try {
            Object objK = k(ub1Var);
            return objK == null ? g : objK;
        } catch (CancellationException e2) {
            if (zIsCancelled) {
                return new c(false, e2);
            }
            return new Failure(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + ub1Var, e2));
        } catch (ExecutionException e3) {
            return new Failure(e3.getCause());
        } catch (Throwable th) {
            return new Failure(th);
        }
    }

    private static Object k(Future future) {
        Object obj;
        boolean z = false;
        while (true) {
            try {
                obj = future.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return obj;
    }

    private void n() {
        h hVar;
        do {
            hVar = this.c;
        } while (!f.c(this, hVar, h.c));
        while (hVar != null) {
            hVar.b();
            hVar = hVar.b;
        }
    }

    private void o(h hVar) {
        hVar.a = null;
        while (true) {
            h hVar2 = this.c;
            if (hVar2 == h.c) {
                return;
            }
            h hVar3 = null;
            while (hVar2 != null) {
                h hVar4 = hVar2.b;
                if (hVar2.a != null) {
                    hVar3 = hVar2;
                } else if (hVar3 != null) {
                    hVar3.b = hVar4;
                    if (hVar3.a == null) {
                    }
                } else if (!f.c(this, hVar2, hVar4)) {
                }
                hVar2 = hVar4;
            }
            return;
        }
    }

    private String s(Object obj) {
        return obj == this ? "this future" : String.valueOf(obj);
    }

    @Override // defpackage.ub1
    public final void a(Runnable runnable, Executor executor) {
        e(runnable);
        e(executor);
        d dVar = this.b;
        if (dVar != d.d) {
            d dVar2 = new d(runnable, executor);
            do {
                dVar2.c = dVar;
                if (f.a(this, dVar, dVar2)) {
                    return;
                } else {
                    dVar = this.b;
                }
            } while (dVar != d.d);
        }
        h(runnable, executor);
    }

    protected void c() {
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        c cVar;
        Object obj = this.a;
        if (!(obj == null) && !(obj instanceof f)) {
            return false;
        }
        if (d) {
            cVar = new c(z, new CancellationException("Future.cancel() was called."));
        } else {
            cVar = z ? c.c : c.d;
        }
        AbstractFuture abstractFuture = this;
        boolean z2 = false;
        while (true) {
            if (f.b(abstractFuture, obj, cVar)) {
                if (z) {
                    abstractFuture.l();
                }
                g(abstractFuture);
                if (!(obj instanceof f)) {
                    return true;
                }
                ub1 ub1Var = ((f) obj).b;
                if (!(ub1Var instanceof AbstractFuture)) {
                    ub1Var.cancel(z);
                    return true;
                }
                abstractFuture = (AbstractFuture) ub1Var;
                obj = abstractFuture.a;
                if (!(obj == null) && !(obj instanceof f)) {
                    return true;
                }
                z2 = true;
            } else {
                obj = abstractFuture.a;
                if (!(obj instanceof f)) {
                    return z2;
                }
            }
        }
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        long nanos = timeUnit.toNanos(j);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.a;
        if ((obj != null) && (!(obj instanceof f))) {
            return i(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            h hVar = this.c;
            if (hVar != h.c) {
                h hVar2 = new h();
                while (true) {
                    hVar2.a(hVar);
                    if (f.c(this, hVar, hVar2)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                o(hVar2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.a;
                            if ((obj2 != null) && (!(obj2 instanceof f))) {
                                return i(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        o(hVar2);
                        break;
                    }
                    hVar = this.c;
                    if (hVar == h.c) {
                    }
                }
            }
            return i(this.a);
        }
        while (nanos > 0) {
            Object obj3 = this.a;
            if ((obj3 != null) && (!(obj3 instanceof f))) {
                return i(obj3);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = jNanoTime - System.nanoTime();
        }
        String string = toString();
        String string2 = timeUnit.toString();
        Locale locale = Locale.ROOT;
        String lowerCase = string2.toLowerCase(locale);
        String str = "Waited " + j + " " + timeUnit.toString().toLowerCase(locale);
        if (nanos + 1000 < 0) {
            String str2 = str + " (plus ";
            long j2 = -nanos;
            long jConvert = timeUnit.convert(j2, TimeUnit.NANOSECONDS);
            long nanos2 = j2 - timeUnit.toNanos(jConvert);
            boolean z = jConvert == 0 || nanos2 > 1000;
            if (jConvert > 0) {
                String str3 = str2 + jConvert + " " + lowerCase;
                if (z) {
                    str3 = str3 + ",";
                }
                str2 = str3 + " ";
            }
            if (z) {
                str2 = str2 + nanos2 + " nanoseconds ";
            }
            str = str2 + "delay)";
        }
        if (isDone()) {
            throw new TimeoutException(str + " but future completed as timeout expired");
        }
        throw new TimeoutException(str + " for " + string);
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.a instanceof c;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        Object obj = this.a;
        return (!(obj instanceof f)) & (obj != null);
    }

    protected void l() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected String m() {
        Object obj = this.a;
        if (obj instanceof f) {
            return "setFuture=[" + s(((f) obj).b) + "]";
        }
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    protected boolean p(Object obj) {
        if (obj == null) {
            obj = g;
        }
        if (!f.b(this, null, obj)) {
            return false;
        }
        g(this);
        return true;
    }

    protected boolean q(Throwable th) {
        if (!f.b(this, null, new Failure((Throwable) e(th)))) {
            return false;
        }
        g(this);
        return true;
    }

    protected boolean r(ub1 ub1Var) {
        Failure failure;
        e(ub1Var);
        Object obj = this.a;
        if (obj == null) {
            if (ub1Var.isDone()) {
                if (!f.b(this, null, j(ub1Var))) {
                    return false;
                }
                g(this);
                return true;
            }
            f fVar = new f(this, ub1Var);
            if (f.b(this, null, fVar)) {
                try {
                    ub1Var.a(fVar, DirectExecutor.INSTANCE);
                } catch (Throwable th) {
                    try {
                        failure = new Failure(th);
                    } catch (Throwable unused) {
                        failure = Failure.b;
                    }
                    f.b(this, fVar, failure);
                }
                return true;
            }
            obj = this.a;
        }
        if (obj instanceof c) {
            ub1Var.cancel(((c) obj).a);
        }
        return false;
    }

    public String toString() {
        String strM;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (isCancelled()) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            b(sb);
        } else {
            try {
                strM = m();
            } catch (RuntimeException e2) {
                strM = "Exception thrown from implementation: " + e2.getClass();
            }
            if (strM != null && !strM.isEmpty()) {
                sb.append("PENDING, info=[");
                sb.append(strM);
                sb.append("]");
            } else if (isDone()) {
                b(sb);
            } else {
                sb.append("PENDING");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override // java.util.concurrent.Future
    public final Object get() throws InterruptedException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.a;
            if ((obj2 != null) & (!(obj2 instanceof f))) {
                return i(obj2);
            }
            h hVar = this.c;
            if (hVar != h.c) {
                h hVar2 = new h();
                do {
                    hVar2.a(hVar);
                    if (f.c(this, hVar, hVar2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.a;
                            } else {
                                o(hVar2);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof f))));
                        return i(obj);
                    }
                    hVar = this.c;
                } while (hVar != h.c);
            }
            return i(this.a);
        }
        throw new InterruptedException();
    }
}
