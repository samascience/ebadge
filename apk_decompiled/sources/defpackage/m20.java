package defpackage;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class m20 {
    private static final String f = fd1.f("ConstraintTracker");
    protected final w03 a;
    protected final Context b;
    private final Object c = new Object();
    private final Set d = new LinkedHashSet();
    Object e;

    class a implements Runnable {
        final /* synthetic */ List a;

        a(List list) {
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                ((l20) it.next()).a(m20.this.e);
            }
        }
    }

    m20(Context context, w03 w03Var) {
        this.b = context.getApplicationContext();
        this.a = w03Var;
    }

    public void a(l20 l20Var) {
        synchronized (this.c) {
            try {
                if (this.d.add(l20Var)) {
                    if (this.d.size() == 1) {
                        this.e = b();
                        fd1.c().a(f, String.format("%s: initial state = %s", getClass().getSimpleName(), this.e), new Throwable[0]);
                        e();
                    }
                    l20Var.a(this.e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public abstract Object b();

    public void c(l20 l20Var) {
        synchronized (this.c) {
            try {
                if (this.d.remove(l20Var) && this.d.isEmpty()) {
                    f();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void d(Object obj) {
        synchronized (this.c) {
            try {
                Object obj2 = this.e;
                if (obj2 != obj && (obj2 == null || !obj2.equals(obj))) {
                    this.e = obj;
                    this.a.a().execute(new a(new ArrayList(this.d)));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public abstract void e();

    public abstract void f();
}
