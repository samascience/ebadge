package androidx.lifecycle;

import defpackage.or0;
import defpackage.x30;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes.dex */
public abstract class PausingDispatcherKt {
    public static final Object a(Lifecycle lifecycle, or0 or0Var, x30 x30Var) {
        return d(lifecycle, Lifecycle.State.CREATED, or0Var, x30Var);
    }

    public static final Object b(Lifecycle lifecycle, or0 or0Var, x30 x30Var) {
        return d(lifecycle, Lifecycle.State.RESUMED, or0Var, x30Var);
    }

    public static final Object c(Lifecycle lifecycle, or0 or0Var, x30 x30Var) {
        return d(lifecycle, Lifecycle.State.STARTED, or0Var, x30Var);
    }

    public static final Object d(Lifecycle lifecycle, Lifecycle.State state, or0 or0Var, x30 x30Var) {
        return BuildersKt.withContext(Dispatchers.getMain().getImmediate(), new PausingDispatcherKt$whenStateAtLeast$2(lifecycle, state, or0Var, null), x30Var);
    }
}
