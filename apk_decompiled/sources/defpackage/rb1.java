package defpackage;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
class rb1 implements ub1 {
    List a;
    List b;
    private final boolean c;
    private final AtomicInteger d;
    private final ub1 e = CallbackToFutureAdapter.a(new a());
    CallbackToFutureAdapter.a f;

    class a implements CallbackToFutureAdapter.b {
        a() {
        }

        @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
        public Object a(CallbackToFutureAdapter.a aVar) {
            b52.j(rb1.this.f == null, "The result can only set once!");
            rb1.this.f = aVar;
            return "ListFuture[" + this + "]";
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            rb1 rb1Var = rb1.this;
            rb1Var.b = null;
            rb1Var.a = null;
        }
    }

    class c implements Runnable {
        final /* synthetic */ int a;
        final /* synthetic */ ub1 b;

        c(int i, ub1 ub1Var) {
            this.a = i;
            this.b = ub1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            rb1.this.f(this.a, this.b);
        }
    }

    rb1(List list, boolean z, Executor executor) {
        this.a = (List) b52.g(list);
        this.b = new ArrayList(list.size());
        this.c = z;
        this.d = new AtomicInteger(list.size());
        e(executor);
    }

    private void b() throws InterruptedException {
        List<ub1> list = this.a;
        if (list == null || isDone()) {
            return;
        }
        for (ub1 ub1Var : list) {
            while (!ub1Var.isDone()) {
                try {
                    ub1Var.get();
                } catch (Error e) {
                    throw e;
                } catch (InterruptedException e2) {
                    throw e2;
                } catch (Throwable unused) {
                    if (this.c) {
                        return;
                    }
                }
            }
        }
    }

    private void e(Executor executor) {
        a(new b(), androidx.camera.core.impl.utils.executor.c.b());
        if (this.a.isEmpty()) {
            this.f.c(new ArrayList(this.b));
            return;
        }
        for (int i = 0; i < this.a.size(); i++) {
            this.b.add(null);
        }
        List list = this.a;
        for (int i2 = 0; i2 < list.size(); i2++) {
            ub1 ub1Var = (ub1) list.get(i2);
            ub1Var.a(new c(i2, ub1Var), executor);
        }
    }

    @Override // defpackage.ub1
    public void a(Runnable runnable, Executor executor) {
        this.e.a(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public List get() throws InterruptedException {
        b();
        return (List) this.e.get();
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        List list = this.a;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((ub1) it.next()).cancel(z);
            }
        }
        return this.e.cancel(z);
    }

    @Override // java.util.concurrent.Future
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public List get(long j, TimeUnit timeUnit) {
        return (List) this.e.get(j, timeUnit);
    }

    void f(int i, Future future) {
        List list;
        CallbackToFutureAdapter.a aVar;
        ArrayList arrayList;
        List list2 = this.b;
        if (isDone() || list2 == null) {
            b52.j(this.c, "Future was done before all dependencies completed");
            return;
        }
        try {
            b52.j(future.isDone(), "Tried to set value from future which is not done");
            list2.set(i, os0.m(future));
            int iDecrementAndGet = this.d.decrementAndGet();
            b52.j(iDecrementAndGet >= 0, "Less than 0 remaining futures");
            if (iDecrementAndGet == 0) {
                if (list != null) {
                    aVar = this.f;
                    arrayList = new ArrayList(list);
                    aVar.c(arrayList);
                }
            }
        } catch (RuntimeException e) {
            if (this.c) {
                this.f.f(e);
            }
            int iDecrementAndGet2 = this.d.decrementAndGet();
            b52.j(iDecrementAndGet2 >= 0, "Less than 0 remaining futures");
            if (iDecrementAndGet2 == 0) {
                if (list != null) {
                    aVar = this.f;
                    arrayList = new ArrayList(list);
                }
            }
        } catch (ExecutionException e2) {
            if (this.c) {
                this.f.f(e2.getCause());
            }
            int iDecrementAndGet3 = this.d.decrementAndGet();
            b52.j(iDecrementAndGet3 >= 0, "Less than 0 remaining futures");
            if (iDecrementAndGet3 == 0) {
                if (list != null) {
                    aVar = this.f;
                    arrayList = new ArrayList(list);
                }
            }
        } catch (Error e3) {
            this.f.f(e3);
            int iDecrementAndGet4 = this.d.decrementAndGet();
            b52.j(iDecrementAndGet4 >= 0, "Less than 0 remaining futures");
            if (iDecrementAndGet4 == 0) {
                if (list != null) {
                    aVar = this.f;
                    arrayList = new ArrayList(list);
                }
            }
        } catch (CancellationException unused) {
            if (this.c) {
                cancel(false);
            }
            int iDecrementAndGet5 = this.d.decrementAndGet();
            b52.j(iDecrementAndGet5 >= 0, "Less than 0 remaining futures");
            if (iDecrementAndGet5 == 0) {
                if (list != null) {
                    aVar = this.f;
                    arrayList = new ArrayList(list);
                }
            }
        } finally {
            int iDecrementAndGet6 = this.d.decrementAndGet();
            b52.j(iDecrementAndGet6 >= 0, "Less than 0 remaining futures");
            if (iDecrementAndGet6 == 0) {
                list = this.b;
                if (list != null) {
                    this.f.c(new ArrayList(list));
                } else {
                    b52.i(isDone());
                }
            }
        }
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.e.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.e.isDone();
    }
}
