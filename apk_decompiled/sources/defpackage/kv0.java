package defpackage;

import android.content.Context;
import android.text.TextUtils;
import androidx.work.WorkInfo$State;
import androidx.work.a;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class kv0 implements rk2, fk3, yi0 {
    private static final String i = fd1.f("GreedyScheduler");
    private final Context a;
    private final nk3 b;
    private final gk3 c;
    private g90 e;
    private boolean f;
    Boolean h;
    private final Set d = new HashSet();
    private final Object g = new Object();

    public kv0(Context context, a aVar, w03 w03Var, nk3 nk3Var) {
        this.a = context;
        this.b = nk3Var;
        this.c = new gk3(context, w03Var, this);
        this.e = new g90(this, aVar.k());
    }

    private void g() {
        this.h = Boolean.valueOf(z62.b(this.a, this.b.h()));
    }

    private void h() {
        if (this.f) {
            return;
        }
        this.b.l().d(this);
        this.f = true;
    }

    private void i(String str) {
        synchronized (this.g) {
            try {
                for (xk3 xk3Var : this.d) {
                    if (xk3Var.a.equals(str)) {
                        fd1.c().a(i, String.format("Stopping tracking for %s", str), new Throwable[0]);
                        this.d.remove(xk3Var);
                        this.c.d(this.d);
                        break;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.rk2
    public boolean a() {
        return false;
    }

    @Override // defpackage.fk3
    public void b(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            fd1.c().a(i, String.format("Constraints not met: Cancelling work ID %s", str), new Throwable[0]);
            this.b.w(str);
        }
    }

    @Override // defpackage.yi0
    public void c(String str, boolean z) {
        i(str);
    }

    @Override // defpackage.rk2
    public void d(String str) {
        if (this.h == null) {
            g();
        }
        if (!this.h.booleanValue()) {
            fd1.c().d(i, "Ignoring schedule request in non-main process", new Throwable[0]);
            return;
        }
        h();
        fd1.c().a(i, String.format("Cancelling work ID %s", str), new Throwable[0]);
        g90 g90Var = this.e;
        if (g90Var != null) {
            g90Var.b(str);
        }
        this.b.w(str);
    }

    @Override // defpackage.rk2
    public void e(xk3... xk3VarArr) {
        if (this.h == null) {
            g();
        }
        if (!this.h.booleanValue()) {
            fd1.c().d(i, "Ignoring schedule request in a secondary process", new Throwable[0]);
            return;
        }
        h();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (xk3 xk3Var : xk3VarArr) {
            long jA = xk3Var.a();
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (xk3Var.b == WorkInfo$State.ENQUEUED) {
                if (jCurrentTimeMillis < jA) {
                    g90 g90Var = this.e;
                    if (g90Var != null) {
                        g90Var.a(xk3Var);
                    }
                } else if (!xk3Var.b()) {
                    fd1.c().a(i, String.format("Starting work for %s", xk3Var.a), new Throwable[0]);
                    this.b.t(xk3Var.a);
                } else if (xk3Var.j.h()) {
                    fd1.c().a(i, String.format("Ignoring WorkSpec %s, Requires device idle.", xk3Var), new Throwable[0]);
                } else if (xk3Var.j.e()) {
                    fd1.c().a(i, String.format("Ignoring WorkSpec %s, Requires ContentUri triggers.", xk3Var), new Throwable[0]);
                } else {
                    hashSet.add(xk3Var);
                    hashSet2.add(xk3Var.a);
                }
            }
        }
        synchronized (this.g) {
            try {
                if (!hashSet.isEmpty()) {
                    fd1.c().a(i, String.format("Starting tracking for [%s]", TextUtils.join(",", hashSet2)), new Throwable[0]);
                    this.d.addAll(hashSet);
                    this.c.d(this.d);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.fk3
    public void f(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            fd1.c().a(i, String.format("Constraints met: Scheduling work ID %s", str), new Throwable[0]);
            this.b.t(str);
        }
    }
}
