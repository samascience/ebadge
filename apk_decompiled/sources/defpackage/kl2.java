package defpackage;

import androidx.camera.core.u;
import androidx.camera.core.x;

/* JADX INFO: loaded from: classes.dex */
public final class kl2 implements u.i {
    public static final a e = new a(null);
    private final u.i a;
    private final Object b;
    private boolean c;
    private u.j d;

    public static final class a {
        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        public final kl2 a(u.i iVar) {
            return new kl2(iVar, null);
        }

        private a() {
        }
    }

    public /* synthetic */ kl2(u.i iVar, y70 y70Var) {
        this(iVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(kl2 kl2Var) {
        p31.f(kl2Var, "this$0");
        synchronized (kl2Var.b) {
            try {
                if (kl2Var.d == null) {
                    x.k("ScreenFlashWrapper", "apply: pendingListener is null!");
                }
                kl2Var.e();
                k83 k83Var = k83.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void d() {
        k83 k83Var;
        synchronized (this.b) {
            try {
                if (this.c) {
                    u.i iVar = this.a;
                    if (iVar != null) {
                        iVar.clear();
                        k83Var = k83.a;
                    } else {
                        k83Var = null;
                    }
                    if (k83Var == null) {
                        x.c("ScreenFlashWrapper", "completePendingScreenFlashClear: screenFlash is null!");
                    }
                } else {
                    x.k("ScreenFlashWrapper", "completePendingScreenFlashClear: none pending!");
                }
                this.c = false;
                k83 k83Var2 = k83.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void e() {
        synchronized (this.b) {
            try {
                u.j jVar = this.d;
                if (jVar != null) {
                    jVar.a();
                }
                this.d = null;
                k83 k83Var = k83.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static final kl2 g(u.i iVar) {
        return e.a(iVar);
    }

    @Override // androidx.camera.core.u.i
    public void a(long j, u.j jVar) {
        k83 k83Var;
        p31.f(jVar, "screenFlashListener");
        synchronized (this.b) {
            this.c = true;
            this.d = jVar;
            k83 k83Var2 = k83.a;
        }
        u.i iVar = this.a;
        if (iVar != null) {
            iVar.a(j, new u.j() { // from class: jl2
                @Override // androidx.camera.core.u.j
                public final void a() {
                    kl2.c(this.a);
                }
            });
            k83Var = k83.a;
        } else {
            k83Var = null;
        }
        if (k83Var == null) {
            x.c("ScreenFlashWrapper", "apply: screenFlash is null!");
            e();
        }
    }

    @Override // androidx.camera.core.u.i
    public void clear() {
        d();
    }

    public final void f() {
        e();
        d();
    }

    public final u.i h() {
        return this.a;
    }

    private kl2(u.i iVar) {
        this.a = iVar;
        this.b = new Object();
    }
}
