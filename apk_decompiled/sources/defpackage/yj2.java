package defpackage;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.savedstate.Recreator;

/* JADX INFO: loaded from: classes.dex */
public final class yj2 {
    public static final a d = new a(null);
    private final zj2 a;
    private final androidx.savedstate.a b;
    private boolean c;

    public static final class a {
        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        public final yj2 a(zj2 zj2Var) {
            p31.f(zj2Var, "owner");
            return new yj2(zj2Var, null);
        }

        private a() {
        }
    }

    public /* synthetic */ yj2(zj2 zj2Var, y70 y70Var) {
        this(zj2Var);
    }

    public static final yj2 a(zj2 zj2Var) {
        return d.a(zj2Var);
    }

    public final androidx.savedstate.a b() {
        return this.b;
    }

    public final void c() {
        Lifecycle lifecycle = this.a.getLifecycle();
        if (lifecycle.b() != Lifecycle.State.INITIALIZED) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
        }
        lifecycle.a(new Recreator(this.a));
        this.b.e(lifecycle);
        this.c = true;
    }

    public final void d(Bundle bundle) {
        if (!this.c) {
            c();
        }
        Lifecycle lifecycle = this.a.getLifecycle();
        if (!lifecycle.b().isAtLeast(Lifecycle.State.STARTED)) {
            this.b.f(bundle);
            return;
        }
        throw new IllegalStateException(("performRestore cannot be called when owner is " + lifecycle.b()).toString());
    }

    public final void e(Bundle bundle) {
        p31.f(bundle, "outBundle");
        this.b.g(bundle);
    }

    private yj2(zj2 zj2Var) {
        this.a = zj2Var;
        this.b = new androidx.savedstate.a();
    }
}
