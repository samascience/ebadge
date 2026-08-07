package defpackage;

import android.content.Context;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes.dex */
public final class o30 {
    private final Set a = new CopyOnWriteArraySet();
    private volatile Context b;

    public final void a(xu1 xu1Var) {
        p31.f(xu1Var, "listener");
        Context context = this.b;
        if (context != null) {
            xu1Var.a(context);
        }
        this.a.add(xu1Var);
    }

    public final void b() {
        this.b = null;
    }

    public final void c(Context context) {
        p31.f(context, "context");
        this.b = context;
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((xu1) it.next()).a(context);
        }
    }

    public final Context d() {
        return this.b;
    }

    public final void e(xu1 xu1Var) {
        p31.f(xu1Var, "listener");
        this.a.remove(xu1Var);
    }
}
