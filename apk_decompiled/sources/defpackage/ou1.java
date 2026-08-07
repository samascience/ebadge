package defpackage;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class ou1 {
    private boolean a;
    private final CopyOnWriteArrayList b = new CopyOnWriteArrayList();
    private yq0 c;

    public ou1(boolean z) {
        this.a = z;
    }

    public final void a(iv ivVar) {
        p31.f(ivVar, "cancellable");
        this.b.add(ivVar);
    }

    public final yq0 b() {
        return this.c;
    }

    public void c() {
    }

    public abstract void d();

    public void e(he heVar) {
        p31.f(heVar, "backEvent");
    }

    public void f(he heVar) {
        p31.f(heVar, "backEvent");
    }

    public final boolean g() {
        return this.a;
    }

    public final void h() {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((iv) it.next()).cancel();
        }
    }

    public final void i(iv ivVar) {
        p31.f(ivVar, "cancellable");
        this.b.remove(ivVar);
    }

    public final void j(boolean z) {
        this.a = z;
        yq0 yq0Var = this.c;
        if (yq0Var != null) {
            yq0Var.invoke();
        }
    }

    public final void k(yq0 yq0Var) {
        this.c = yq0Var;
    }
}
