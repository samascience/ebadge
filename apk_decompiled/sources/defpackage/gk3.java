package defpackage;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class gk3 implements k20.a {
    private static final String d = fd1.f("WorkConstraintsTracker");
    private final fk3 a;
    private final k20[] b;
    private final Object c;

    public gk3(Context context, w03 w03Var, fk3 fk3Var) {
        Context applicationContext = context.getApplicationContext();
        this.a = fk3Var;
        this.b = new k20[]{new fh(applicationContext, w03Var), new ih(applicationContext, w03Var), new tu2(applicationContext, w03Var), new do1(applicationContext, w03Var), new vq1(applicationContext, w03Var), new mq1(applicationContext, w03Var), new lq1(applicationContext, w03Var)};
        this.c = new Object();
    }

    @Override // k20.a
    public void a(List list) {
        synchronized (this.c) {
            try {
                ArrayList arrayList = new ArrayList();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    if (c(str)) {
                        fd1.c().a(d, String.format("Constraints met for %s", str), new Throwable[0]);
                        arrayList.add(str);
                    }
                }
                fk3 fk3Var = this.a;
                if (fk3Var != null) {
                    fk3Var.f(arrayList);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // k20.a
    public void b(List list) {
        synchronized (this.c) {
            try {
                fk3 fk3Var = this.a;
                if (fk3Var != null) {
                    fk3Var.b(list);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean c(String str) {
        synchronized (this.c) {
            try {
                for (k20 k20Var : this.b) {
                    if (k20Var.d(str)) {
                        fd1.c().a(d, String.format("Work %s constrained by %s", str, k20Var.getClass().getSimpleName()), new Throwable[0]);
                        return false;
                    }
                }
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void d(Iterable iterable) {
        synchronized (this.c) {
            try {
                for (k20 k20Var : this.b) {
                    k20Var.g(null);
                }
                for (k20 k20Var2 : this.b) {
                    k20Var2.e(iterable);
                }
                for (k20 k20Var3 : this.b) {
                    k20Var3.g(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void e() {
        synchronized (this.c) {
            try {
                for (k20 k20Var : this.b) {
                    k20Var.f();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
