package androidx.lifecycle;

import defpackage.db1;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
class ReflectiveGenericLifecycleObserver implements f {
    private final Object a;
    private final a.C0022a b;

    ReflectiveGenericLifecycleObserver(Object obj) {
        this.a = obj;
        this.b = a.c.c(obj.getClass());
    }

    @Override // androidx.lifecycle.f
    public void c(db1 db1Var, Lifecycle.Event event) {
        this.b.a(db1Var, event, this.a);
    }
}
