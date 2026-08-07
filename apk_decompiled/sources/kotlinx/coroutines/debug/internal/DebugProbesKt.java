package kotlinx.coroutines.debug.internal;

import defpackage.x30;

/* JADX INFO: loaded from: classes4.dex */
public final class DebugProbesKt {
    public static final <T> x30 probeCoroutineCreated(x30 x30Var) {
        return DebugProbesImpl.INSTANCE.probeCoroutineCreated$kotlinx_coroutines_core(x30Var);
    }

    public static final void probeCoroutineResumed(x30 x30Var) {
        DebugProbesImpl.INSTANCE.probeCoroutineResumed$kotlinx_coroutines_core(x30Var);
    }

    public static final void probeCoroutineSuspended(x30 x30Var) {
        DebugProbesImpl.INSTANCE.probeCoroutineSuspended$kotlinx_coroutines_core(x30Var);
    }
}
