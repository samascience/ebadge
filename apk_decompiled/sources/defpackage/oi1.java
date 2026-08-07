package defpackage;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.f;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class oi1 {
    private final Runnable a;
    private final CopyOnWriteArrayList b = new CopyOnWriteArrayList();
    private final Map c = new HashMap();

    private static class a {
        final Lifecycle a;
        private f b;

        a(Lifecycle lifecycle, f fVar) {
            this.a = lifecycle;
            this.b = fVar;
            lifecycle.a(fVar);
        }

        void a() {
            this.a.d(this.b);
            this.b = null;
        }
    }

    public oi1(Runnable runnable) {
        this.a = runnable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(si1 si1Var, db1 db1Var, Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_DESTROY) {
            l(si1Var);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(Lifecycle.State state, si1 si1Var, db1 db1Var, Lifecycle.Event event) {
        if (event == Lifecycle.Event.upTo(state)) {
            c(si1Var);
            return;
        }
        if (event == Lifecycle.Event.ON_DESTROY) {
            l(si1Var);
        } else if (event == Lifecycle.Event.downFrom(state)) {
            this.b.remove(si1Var);
            this.a.run();
        }
    }

    public void c(si1 si1Var) {
        this.b.add(si1Var);
        this.a.run();
    }

    public void d(final si1 si1Var, db1 db1Var) {
        c(si1Var);
        Lifecycle lifecycle = db1Var.getLifecycle();
        a aVar = (a) this.c.remove(si1Var);
        if (aVar != null) {
            aVar.a();
        }
        this.c.put(si1Var, new a(lifecycle, new f() { // from class: ni1
            @Override // androidx.lifecycle.f
            public final void c(db1 db1Var2, Lifecycle.Event event) {
                this.a.f(si1Var, db1Var2, event);
            }
        }));
    }

    public void e(final si1 si1Var, db1 db1Var, final Lifecycle.State state) {
        Lifecycle lifecycle = db1Var.getLifecycle();
        a aVar = (a) this.c.remove(si1Var);
        if (aVar != null) {
            aVar.a();
        }
        this.c.put(si1Var, new a(lifecycle, new f() { // from class: mi1
            @Override // androidx.lifecycle.f
            public final void c(db1 db1Var2, Lifecycle.Event event) {
                this.a.g(state, si1Var, db1Var2, event);
            }
        }));
    }

    public void h(Menu menu, MenuInflater menuInflater) {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((si1) it.next()).c(menu, menuInflater);
        }
    }

    public void i(Menu menu) {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((si1) it.next()).b(menu);
        }
    }

    public boolean j(MenuItem menuItem) {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            if (((si1) it.next()).a(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void k(Menu menu) {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((si1) it.next()).d(menu);
        }
    }

    public void l(si1 si1Var) {
        this.b.remove(si1Var);
        a aVar = (a) this.c.remove(si1Var);
        if (aVar != null) {
            aVar.a();
        }
        this.a.run();
    }
}
