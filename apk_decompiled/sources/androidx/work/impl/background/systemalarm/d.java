package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import defpackage.dl3;
import defpackage.fd1;
import defpackage.fk3;
import defpackage.gk3;
import defpackage.lg3;
import defpackage.xk3;
import defpackage.yi0;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class d implements fk3, yi0, dl3.b {
    private static final String j = fd1.f("DelayMetCommandHandler");
    private final Context a;
    private final int b;
    private final String c;
    private final e d;
    private final gk3 e;
    private PowerManager.WakeLock h;
    private boolean i = false;
    private int g = 0;
    private final Object f = new Object();

    d(Context context, int i, String str, e eVar) {
        this.a = context;
        this.b = i;
        this.d = eVar;
        this.c = str;
        this.e = new gk3(context, eVar.f(), this);
    }

    private void d() {
        synchronized (this.f) {
            try {
                this.e.e();
                this.d.h().c(this.c);
                PowerManager.WakeLock wakeLock = this.h;
                if (wakeLock != null && wakeLock.isHeld()) {
                    fd1.c().a(j, String.format("Releasing wakelock %s for WorkSpec %s", this.h, this.c), new Throwable[0]);
                    this.h.release();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void g() {
        synchronized (this.f) {
            try {
                if (this.g < 2) {
                    this.g = 2;
                    fd1 fd1VarC = fd1.c();
                    String str = j;
                    fd1VarC.a(str, String.format("Stopping work for WorkSpec %s", this.c), new Throwable[0]);
                    Intent intentF = b.f(this.a, this.c);
                    e eVar = this.d;
                    eVar.k(new e.b(eVar, intentF, this.b));
                    if (this.d.e().g(this.c)) {
                        fd1.c().a(str, String.format("WorkSpec %s needs to be rescheduled", this.c), new Throwable[0]);
                        Intent intentE = b.e(this.a, this.c);
                        e eVar2 = this.d;
                        eVar2.k(new e.b(eVar2, intentE, this.b));
                    } else {
                        fd1.c().a(str, String.format("Processor does not have WorkSpec %s. No need to reschedule ", this.c), new Throwable[0]);
                    }
                } else {
                    fd1.c().a(j, String.format("Already stopped work for %s", this.c), new Throwable[0]);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // dl3.b
    public void a(String str) {
        fd1.c().a(j, String.format("Exceeded time limits on execution for %s", str), new Throwable[0]);
        g();
    }

    @Override // defpackage.fk3
    public void b(List list) {
        g();
    }

    @Override // defpackage.yi0
    public void c(String str, boolean z) {
        fd1.c().a(j, String.format("onExecuted %s, %s", str, Boolean.valueOf(z)), new Throwable[0]);
        d();
        if (z) {
            Intent intentE = b.e(this.a, this.c);
            e eVar = this.d;
            eVar.k(new e.b(eVar, intentE, this.b));
        }
        if (this.i) {
            Intent intentA = b.a(this.a);
            e eVar2 = this.d;
            eVar2.k(new e.b(eVar2, intentA, this.b));
        }
    }

    void e() {
        this.h = lg3.b(this.a, String.format("%s (%s)", this.c, Integer.valueOf(this.b)));
        fd1 fd1VarC = fd1.c();
        String str = j;
        fd1VarC.a(str, String.format("Acquiring wakelock %s for WorkSpec %s", this.h, this.c), new Throwable[0]);
        this.h.acquire();
        xk3 xk3VarM = this.d.g().n().k().m(this.c);
        if (xk3VarM == null) {
            g();
            return;
        }
        boolean zB = xk3VarM.b();
        this.i = zB;
        if (zB) {
            this.e.d(Collections.singletonList(xk3VarM));
        } else {
            fd1.c().a(str, String.format("No constraints for %s", this.c), new Throwable[0]);
            f(Collections.singletonList(this.c));
        }
    }

    @Override // defpackage.fk3
    public void f(List list) {
        if (list.contains(this.c)) {
            synchronized (this.f) {
                try {
                    if (this.g == 0) {
                        this.g = 1;
                        fd1.c().a(j, String.format("onAllConstraintsMet for %s", this.c), new Throwable[0]);
                        if (this.d.e().j(this.c)) {
                            this.d.h().b(this.c, 600000L, this);
                        } else {
                            d();
                        }
                    } else {
                        fd1.c().a(j, String.format("Already started work for %s", this.c), new Throwable[0]);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
