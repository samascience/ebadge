package kotlin.coroutines.intrinsics;

import defpackage.p31;
import defpackage.x30;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes4.dex */
public final class IntrinsicsKt__IntrinsicsJvmKt$createSimpleCoroutineForSuspendFunction$2 extends ContinuationImpl {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    IntrinsicsKt__IntrinsicsJvmKt$createSimpleCoroutineForSuspendFunction$2(x30 x30Var, d dVar) {
        super(x30Var, dVar);
        p31.d(x30Var, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    protected Object invokeSuspend(Object obj) throws Throwable {
        kotlin.d.b(obj);
        return obj;
    }
}
