package androidx.databinding;

import defpackage.db1;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
class m extends WeakReference {
    private final j a;
    protected final int b;
    private Object c;

    public m(ViewDataBinding viewDataBinding, int i, j jVar, ReferenceQueue referenceQueue) {
        super(viewDataBinding, referenceQueue);
        this.b = i;
        this.a = jVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected ViewDataBinding a() {
        ViewDataBinding viewDataBinding = (ViewDataBinding) get();
        if (viewDataBinding == null) {
            e();
        }
        return viewDataBinding;
    }

    public Object b() {
        return this.c;
    }

    public void c(db1 db1Var) {
        this.a.a(db1Var);
    }

    public void d(Object obj) {
        e();
        this.c = obj;
        if (obj != null) {
            this.a.addListener(obj);
        }
    }

    public boolean e() {
        boolean z;
        Object obj = this.c;
        if (obj != null) {
            this.a.removeListener(obj);
            z = true;
        } else {
            z = false;
        }
        this.c = null;
        return z;
    }
}
