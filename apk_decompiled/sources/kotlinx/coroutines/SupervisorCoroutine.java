package kotlinx.coroutines;

import defpackage.x30;
import kotlin.coroutines.d;
import kotlinx.coroutines.internal.ScopeCoroutine;

/* JADX INFO: loaded from: classes4.dex */
final class SupervisorCoroutine<T> extends ScopeCoroutine<T> {
    public SupervisorCoroutine(d dVar, x30 x30Var) {
        super(dVar, x30Var);
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean childCancelled(Throwable th) {
        return false;
    }
}
