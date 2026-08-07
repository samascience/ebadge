package kotlinx.coroutines;

import defpackage.or0;
import defpackage.x30;
import kotlin.coroutines.d;

/* JADX INFO: loaded from: classes4.dex */
public final class BuildersKt {
    public static final <T> Deferred<T> async(CoroutineScope coroutineScope, d dVar, CoroutineStart coroutineStart, or0 or0Var) {
        return BuildersKt__Builders_commonKt.async(coroutineScope, dVar, coroutineStart, or0Var);
    }

    public static final <T> Object invoke(CoroutineDispatcher coroutineDispatcher, or0 or0Var, x30 x30Var) {
        return BuildersKt__Builders_commonKt.invoke(coroutineDispatcher, or0Var, x30Var);
    }

    public static final Job launch(CoroutineScope coroutineScope, d dVar, CoroutineStart coroutineStart, or0 or0Var) {
        return BuildersKt__Builders_commonKt.launch(coroutineScope, dVar, coroutineStart, or0Var);
    }

    public static final <T> T runBlocking(d dVar, or0 or0Var) throws InterruptedException {
        return (T) BuildersKt__BuildersKt.runBlocking(dVar, or0Var);
    }

    public static final <T> Object withContext(d dVar, or0 or0Var, x30 x30Var) throws Throwable {
        return BuildersKt__Builders_commonKt.withContext(dVar, or0Var, x30Var);
    }
}
