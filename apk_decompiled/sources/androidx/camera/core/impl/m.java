package androidx.camera.core.impl;

import androidx.camera.core.impl.m;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import defpackage.b52;
import defpackage.bs0;
import defpackage.os0;
import defpackage.ub1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
public abstract class m {

    class a implements bs0 {
        final /* synthetic */ boolean a;
        final /* synthetic */ CallbackToFutureAdapter.a b;

        a(boolean z, CallbackToFutureAdapter.a aVar) {
            this.a = z;
            this.b = aVar;
        }

        @Override // defpackage.bs0
        public void a(Throwable th) {
            if (th instanceof TimeoutException) {
                this.b.f(th);
            } else {
                this.b.c(Collections.emptyList());
            }
        }

        @Override // defpackage.bs0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(List list) {
            b52.g(list);
            ArrayList arrayList = new ArrayList(list);
            if (this.a) {
                arrayList.removeAll(Collections.singleton(null));
            }
            this.b.c(arrayList);
        }
    }

    public static void c(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((DeferrableSurface) it.next()).e();
        }
    }

    public static void d(List list) throws DeferrableSurface.SurfaceClosedException {
        if (list.isEmpty()) {
            return;
        }
        int i = 0;
        do {
            try {
                ((DeferrableSurface) list.get(i)).l();
                i++;
            } catch (DeferrableSurface.SurfaceClosedException e) {
                for (int i2 = i - 1; i2 >= 0; i2--) {
                    ((DeferrableSurface) list.get(i2)).e();
                }
                throw e;
            }
        } while (i < list.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object f(final ub1 ub1Var, Executor executor, boolean z, Collection collection, CallbackToFutureAdapter.a aVar) {
        aVar.a(new Runnable() { // from class: d90
            @Override // java.lang.Runnable
            public final void run() {
                ub1Var.cancel(true);
            }
        }, executor);
        os0.j(ub1Var, new a(z, aVar), executor);
        return "surfaceList[" + collection + "]";
    }

    public static ub1 g(final Collection collection, final boolean z, long j, final Executor executor, ScheduledExecutorService scheduledExecutorService) {
        ArrayList arrayList = new ArrayList();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(os0.B(((DeferrableSurface) it.next()).j()));
        }
        final ub1 ub1VarZ = os0.z(j, scheduledExecutorService, os0.F(arrayList));
        return CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: c90
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
            public final Object a(CallbackToFutureAdapter.a aVar) {
                return m.f(ub1VarZ, executor, z, collection, aVar);
            }
        });
    }
}
