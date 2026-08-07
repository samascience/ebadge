package androidx.lifecycle;

import defpackage.im1;
import defpackage.lj2;
import defpackage.vt1;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class i extends im1 {
    private lj2 l = new lj2();

    private static class a implements vt1 {
        final LiveData a;
        final vt1 b;
        int c = -1;

        a(LiveData liveData, vt1 vt1Var) {
            this.a = liveData;
            this.b = vt1Var;
        }

        void a() {
            this.a.j(this);
        }

        @Override // defpackage.vt1
        public void b(Object obj) {
            if (this.c != this.a.g()) {
                this.c = this.a.g();
                this.b.b(obj);
            }
        }

        void c() {
            this.a.n(this);
        }
    }

    @Override // androidx.lifecycle.LiveData
    protected void k() {
        Iterator it = this.l.iterator();
        while (it.hasNext()) {
            ((a) ((Map.Entry) it.next()).getValue()).a();
        }
    }

    @Override // androidx.lifecycle.LiveData
    protected void l() {
        Iterator it = this.l.iterator();
        while (it.hasNext()) {
            ((a) ((Map.Entry) it.next()).getValue()).c();
        }
    }

    public void p(LiveData liveData, vt1 vt1Var) {
        if (liveData == null) {
            throw new NullPointerException("source cannot be null");
        }
        a aVar = new a(liveData, vt1Var);
        a aVar2 = (a) this.l.f(liveData, aVar);
        if (aVar2 != null && aVar2.b != vt1Var) {
            throw new IllegalArgumentException("This source was already added with the different observer");
        }
        if (aVar2 == null && h()) {
            aVar.a();
        }
    }

    public void q(LiveData liveData) {
        a aVar = (a) this.l.g(liveData);
        if (aVar != null) {
            aVar.c();
        }
    }
}
