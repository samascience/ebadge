package androidx.lifecycle;

import defpackage.k83;
import defpackage.or0;
import defpackage.x30;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class RepeatOnLifecycleKt {
    public static final Object a(Lifecycle lifecycle, Lifecycle.State state, or0 or0Var, x30 x30Var) {
        Object objCoroutineScope;
        if (state != Lifecycle.State.INITIALIZED) {
            return (lifecycle.b() != Lifecycle.State.DESTROYED && (objCoroutineScope = CoroutineScopeKt.coroutineScope(new RepeatOnLifecycleKt$repeatOnLifecycle$3(lifecycle, state, or0Var, null), x30Var)) == kotlin.coroutines.intrinsics.a.d()) ? objCoroutineScope : k83.a;
        }
        throw new IllegalArgumentException("repeatOnLifecycle cannot start work with the INITIALIZED lifecycle state.");
    }
}
