package kotlin.coroutines.intrinsics;

import defpackage.ar0;
import defpackage.p31;
import defpackage.x30;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes4.dex */
public final class IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$2 extends ContinuationImpl {
    final /* synthetic */ ar0 $block;
    private int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$2(x30 x30Var, d dVar, ar0 ar0Var) {
        super(x30Var, dVar);
        this.$block = ar0Var;
        p31.d(x30Var, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    protected Object invokeSuspend(Object obj) throws Throwable {
        int i = this.label;
        if (i == 0) {
            this.label = 1;
            kotlin.d.b(obj);
            return this.$block.invoke(this);
        }
        if (i != 1) {
            throw new IllegalStateException("This coroutine had already completed");
        }
        this.label = 2;
        kotlin.d.b(obj);
        return obj;
    }
}
