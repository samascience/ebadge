package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class k20 implements l20 {
    private final List a = new ArrayList();
    private Object b;
    private m20 c;
    private a d;

    public interface a {
        void a(List list);

        void b(List list);
    }

    k20(m20 m20Var) {
        this.c = m20Var;
    }

    private void h(a aVar, Object obj) {
        if (this.a.isEmpty() || aVar == null) {
            return;
        }
        if (obj == null || c(obj)) {
            aVar.b(this.a);
        } else {
            aVar.a(this.a);
        }
    }

    @Override // defpackage.l20
    public void a(Object obj) {
        this.b = obj;
        h(this.d, obj);
    }

    abstract boolean b(xk3 xk3Var);

    abstract boolean c(Object obj);

    public boolean d(String str) {
        Object obj = this.b;
        return obj != null && c(obj) && this.a.contains(str);
    }

    public void e(Iterable iterable) {
        this.a.clear();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            xk3 xk3Var = (xk3) it.next();
            if (b(xk3Var)) {
                this.a.add(xk3Var.a);
            }
        }
        if (this.a.isEmpty()) {
            this.c.c(this);
        } else {
            this.c.a(this);
        }
        h(this.d, this.b);
    }

    public void f() {
        if (this.a.isEmpty()) {
            return;
        }
        this.a.clear();
        this.c.c(this);
    }

    public void g(a aVar) {
        if (this.d != aVar) {
            this.d = aVar;
            h(aVar, this.b);
        }
    }
}
