package kotlinx.coroutines.channels;

import defpackage.ar0;
import defpackage.or0;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.d;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.ObsoleteCoroutinesApi;

/* JADX INFO: loaded from: classes4.dex */
public final class ActorKt {
    @ObsoleteCoroutinesApi
    public static final <E> SendChannel<E> actor(CoroutineScope coroutineScope, d dVar, int i, CoroutineStart coroutineStart, ar0 ar0Var, or0 or0Var) {
        d dVarNewCoroutineContext = CoroutineContextKt.newCoroutineContext(coroutineScope, dVar);
        Channel channelChannel$default = ChannelKt.Channel$default(i, null, null, 6, null);
        ActorCoroutine lazyActorCoroutine = coroutineStart.isLazy() ? new LazyActorCoroutine(dVarNewCoroutineContext, channelChannel$default, or0Var) : new ActorCoroutine(dVarNewCoroutineContext, channelChannel$default, true);
        if (ar0Var != null) {
            ((JobSupport) lazyActorCoroutine).invokeOnCompletion(ar0Var);
        }
        ((AbstractCoroutine) lazyActorCoroutine).start(coroutineStart, lazyActorCoroutine, or0Var);
        return (SendChannel<E>) lazyActorCoroutine;
    }

    public static /* synthetic */ SendChannel actor$default(CoroutineScope coroutineScope, d dVar, int i, CoroutineStart coroutineStart, ar0 ar0Var, or0 or0Var, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            dVar = EmptyCoroutineContext.INSTANCE;
        }
        d dVar2 = dVar;
        if ((i2 & 2) != 0) {
            i = 0;
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        CoroutineStart coroutineStart2 = coroutineStart;
        if ((i2 & 8) != 0) {
            ar0Var = null;
        }
        return actor(coroutineScope, dVar2, i3, coroutineStart2, ar0Var, or0Var);
    }
}
