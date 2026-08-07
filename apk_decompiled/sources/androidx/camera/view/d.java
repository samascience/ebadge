package androidx.camera.view;

import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.x;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import defpackage.ab;
import defpackage.as;
import defpackage.bs0;
import defpackage.cs;
import defpackage.cs0;
import defpackage.im1;
import defpackage.os0;
import defpackage.ub1;
import defpackage.ut1;
import defpackage.wr0;
import defpackage.yt;
import defpackage.zt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class d implements ut1.a {
    private final zt a;
    private final im1 b;
    private PreviewView.StreamState c;
    private final i d;
    ub1 e;
    private boolean f = false;

    class a implements bs0 {
        final /* synthetic */ List a;
        final /* synthetic */ yt b;

        a(List list, yt ytVar) {
            this.a = list;
            this.b = ytVar;
        }

        @Override // defpackage.bs0
        public void a(Throwable th) {
            d.this.e = null;
            if (this.a.isEmpty()) {
                return;
            }
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                ((zt) this.b).o((as) it.next());
            }
            this.a.clear();
        }

        @Override // defpackage.bs0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Void r2) {
            d.this.e = null;
        }
    }

    class b extends as {
        final /* synthetic */ CallbackToFutureAdapter.a a;
        final /* synthetic */ yt b;

        b(CallbackToFutureAdapter.a aVar, yt ytVar) {
            this.a = aVar;
            this.b = ytVar;
        }

        @Override // defpackage.as
        public void b(int i, cs csVar) {
            this.a.c(null);
            ((zt) this.b).o(this);
        }
    }

    d(zt ztVar, im1 im1Var, i iVar) {
        this.a = ztVar;
        this.b = im1Var;
        this.d = iVar;
        synchronized (this) {
            this.c = (PreviewView.StreamState) im1Var.f();
        }
    }

    private void e() {
        ub1 ub1Var = this.e;
        if (ub1Var != null) {
            ub1Var.cancel(false);
            this.e = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ub1 g(Void r1) {
        return this.d.i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Void h(Void r1) {
        l(PreviewView.StreamState.STREAMING);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object i(yt ytVar, List list, CallbackToFutureAdapter.a aVar) {
        b bVar = new b(aVar, ytVar);
        list.add(bVar);
        ((zt) ytVar).g(androidx.camera.core.impl.utils.executor.c.b(), bVar);
        return "waitForCaptureResult";
    }

    private void k(yt ytVar) {
        l(PreviewView.StreamState.IDLE);
        ArrayList arrayList = new ArrayList();
        cs0 cs0VarE = cs0.b(m(ytVar, arrayList)).f(new ab() { // from class: androidx.camera.view.a
            @Override // defpackage.ab
            public final ub1 apply(Object obj) {
                return this.a.g((Void) obj);
            }
        }, androidx.camera.core.impl.utils.executor.c.b()).e(new wr0() { // from class: androidx.camera.view.b
            @Override // defpackage.wr0
            public final Object apply(Object obj) {
                return this.a.h((Void) obj);
            }
        }, androidx.camera.core.impl.utils.executor.c.b());
        this.e = cs0VarE;
        os0.j(cs0VarE, new a(arrayList, ytVar), androidx.camera.core.impl.utils.executor.c.b());
    }

    private ub1 m(final yt ytVar, final List list) {
        return CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: androidx.camera.view.c
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
            public final Object a(CallbackToFutureAdapter.a aVar) {
                return this.a.i(ytVar, list, aVar);
            }
        });
    }

    void f() {
        e();
    }

    @Override // ut1.a
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public void a(CameraInternal.State state) {
        if (state == CameraInternal.State.CLOSING || state == CameraInternal.State.CLOSED || state == CameraInternal.State.RELEASING || state == CameraInternal.State.RELEASED) {
            l(PreviewView.StreamState.IDLE);
            if (this.f) {
                this.f = false;
                e();
                return;
            }
            return;
        }
        if ((state == CameraInternal.State.OPENING || state == CameraInternal.State.OPEN || state == CameraInternal.State.PENDING_OPEN) && !this.f) {
            k(this.a);
            this.f = true;
        }
    }

    void l(PreviewView.StreamState streamState) {
        synchronized (this) {
            try {
                if (this.c.equals(streamState)) {
                    return;
                }
                this.c = streamState;
                x.a("StreamStateObserver", "Update Preview stream state to " + streamState);
                this.b.m(streamState);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // ut1.a
    public void onError(Throwable th) {
        f();
        l(PreviewView.StreamState.IDLE);
    }
}
