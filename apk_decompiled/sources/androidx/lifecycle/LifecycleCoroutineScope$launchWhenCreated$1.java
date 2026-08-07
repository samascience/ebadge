package androidx.lifecycle;

import defpackage.h70;
import defpackage.k83;
import defpackage.or0;
import defpackage.x30;
import defpackage.ya1;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes.dex */
@h70(c = "androidx.lifecycle.LifecycleCoroutineScope$launchWhenCreated$1", f = "Lifecycle.kt", l = {337}, m = "invokeSuspend")
final class LifecycleCoroutineScope$launchWhenCreated$1 extends SuspendLambda implements or0 {
    final /* synthetic */ or0 $block;
    int label;
    final /* synthetic */ ya1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LifecycleCoroutineScope$launchWhenCreated$1(ya1 ya1Var, or0 or0Var, x30 x30Var) {
        super(2, x30Var);
        this.this$0 = ya1Var;
        this.$block = or0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(Object obj, x30 x30Var) {
        return new LifecycleCoroutineScope$launchWhenCreated$1(this.this$0, this.$block, x30Var);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objD = kotlin.coroutines.intrinsics.a.d();
        int i = this.label;
        if (i == 0) {
            kotlin.d.b(obj);
            Lifecycle lifecycleA = this.this$0.a();
            or0 or0Var = this.$block;
            this.label = 1;
            if (PausingDispatcherKt.a(lifecycleA, or0Var, this) == objD) {
                return objD;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.d.b(obj);
        }
        return k83.a;
    }

    @Override // defpackage.or0
    public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
        return ((LifecycleCoroutineScope$launchWhenCreated$1) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
    }
}
