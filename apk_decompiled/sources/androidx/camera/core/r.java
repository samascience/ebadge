package androidx.camera.core;

import defpackage.bs0;
import defpackage.os0;
import defpackage.x01;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
final class r extends p {
    final Executor t;
    private final Object u = new Object();
    v v;
    private b w;

    class a implements bs0 {
        final /* synthetic */ b a;

        a(b bVar) {
            this.a = bVar;
        }

        @Override // defpackage.bs0
        public void a(Throwable th) {
            this.a.close();
        }

        @Override // defpackage.bs0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Void r1) {
        }
    }

    static class b extends l {
        final WeakReference d;

        b(v vVar, r rVar) {
            super(vVar);
            this.d = new WeakReference(rVar);
            n(new l.a() { // from class: androidx.camera.core.s
                @Override // androidx.camera.core.l.a
                public final void b(v vVar2) {
                    this.a.D(vVar2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void D(v vVar) {
            final r rVar = (r) this.d.get();
            if (rVar != null) {
                rVar.t.execute(new Runnable() { // from class: androidx.camera.core.t
                    @Override // java.lang.Runnable
                    public final void run() {
                        rVar.z();
                    }
                });
            }
        }
    }

    r(Executor executor) {
        this.t = executor;
    }

    @Override // androidx.camera.core.p
    v d(x01 x01Var) {
        return x01Var.c();
    }

    @Override // androidx.camera.core.p
    void g() {
        synchronized (this.u) {
            try {
                v vVar = this.v;
                if (vVar != null) {
                    vVar.close();
                    this.v = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.camera.core.p
    void o(v vVar) {
        synchronized (this.u) {
            try {
                if (!this.s) {
                    vVar.close();
                    return;
                }
                if (this.w == null) {
                    b bVar = new b(vVar, this);
                    this.w = bVar;
                    os0.j(e(bVar), new a(bVar), androidx.camera.core.impl.utils.executor.c.b());
                } else {
                    if (vVar.h0().c() <= this.w.h0().c()) {
                        vVar.close();
                    } else {
                        v vVar2 = this.v;
                        if (vVar2 != null) {
                            vVar2.close();
                        }
                        this.v = vVar;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z() {
        synchronized (this.u) {
            try {
                this.w = null;
                v vVar = this.v;
                if (vVar != null) {
                    this.v = null;
                    o(vVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
