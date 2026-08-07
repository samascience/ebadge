package kotlin.coroutines;

import defpackage.or0;
import defpackage.p31;
import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public final class EmptyCoroutineContext implements d, Serializable {
    public static final EmptyCoroutineContext INSTANCE = new EmptyCoroutineContext();
    private static final long serialVersionUID = 0;

    private EmptyCoroutineContext() {
    }

    private final Object readResolve() {
        return INSTANCE;
    }

    @Override // kotlin.coroutines.d
    public <R> R fold(R r, or0 or0Var) {
        p31.f(or0Var, "operation");
        return r;
    }

    @Override // kotlin.coroutines.d
    public <E extends d.b> E get(d.c cVar) {
        p31.f(cVar, "key");
        return null;
    }

    public int hashCode() {
        return 0;
    }

    @Override // kotlin.coroutines.d
    public d minusKey(d.c cVar) {
        p31.f(cVar, "key");
        return this;
    }

    @Override // kotlin.coroutines.d
    public d plus(d dVar) {
        p31.f(dVar, "context");
        return dVar;
    }

    public String toString() {
        return "EmptyCoroutineContext";
    }
}
