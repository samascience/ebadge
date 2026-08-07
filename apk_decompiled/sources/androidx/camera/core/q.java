package androidx.camera.core;

import defpackage.bs0;
import defpackage.os0;
import defpackage.x01;

/* JADX INFO: loaded from: classes.dex */
final class q extends p {

    class a implements bs0 {
        final /* synthetic */ v a;

        a(v vVar) {
            this.a = vVar;
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

    q() {
    }

    @Override // androidx.camera.core.p
    v d(x01 x01Var) {
        return x01Var.h();
    }

    @Override // androidx.camera.core.p
    void g() {
    }

    @Override // androidx.camera.core.p
    void o(v vVar) {
        os0.j(e(vVar), new a(vVar), androidx.camera.core.impl.utils.executor.c.b());
    }
}
