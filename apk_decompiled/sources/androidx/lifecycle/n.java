package androidx.lifecycle;

import android.os.Handler;
import defpackage.db1;
import defpackage.p31;

/* JADX INFO: loaded from: classes.dex */
public class n {
    private final g a;
    private final Handler b;
    private a c;

    public static final class a implements Runnable {
        private final g a;
        private final Lifecycle.Event b;
        private boolean c;

        public a(g gVar, Lifecycle.Event event) {
            p31.f(gVar, "registry");
            p31.f(event, "event");
            this.a = gVar;
            this.b = event;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.c) {
                return;
            }
            this.a.i(this.b);
            this.c = true;
        }
    }

    public n(db1 db1Var) {
        p31.f(db1Var, "provider");
        this.a = new g(db1Var);
        this.b = new Handler();
    }

    private final void f(Lifecycle.Event event) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.run();
        }
        a aVar2 = new a(this.a, event);
        this.c = aVar2;
        Handler handler = this.b;
        p31.c(aVar2);
        handler.postAtFrontOfQueue(aVar2);
    }

    public Lifecycle a() {
        return this.a;
    }

    public void b() {
        f(Lifecycle.Event.ON_START);
    }

    public void c() {
        f(Lifecycle.Event.ON_CREATE);
    }

    public void d() {
        f(Lifecycle.Event.ON_STOP);
        f(Lifecycle.Event.ON_DESTROY);
    }

    public void e() {
        f(Lifecycle.Event.ON_START);
    }
}
