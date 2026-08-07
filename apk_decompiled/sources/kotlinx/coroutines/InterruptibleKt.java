package kotlinx.coroutines;

import defpackage.h70;
import defpackage.k83;
import defpackage.or0;
import defpackage.x30;
import defpackage.yq0;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d;

/* JADX INFO: loaded from: classes4.dex */
public final class InterruptibleKt {
    private static final int FINISHED = 1;
    private static final int INTERRUPTED = 3;
    private static final int INTERRUPTING = 2;
    private static final int WORKING = 0;

    /* JADX INFO: renamed from: kotlinx.coroutines.InterruptibleKt$runInterruptible$2, reason: invalid class name */
    @h70(c = "kotlinx.coroutines.InterruptibleKt$runInterruptible$2", f = "Interruptible.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass2 extends SuspendLambda implements or0 {
        final /* synthetic */ yq0 $block;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(yq0 yq0Var, x30 x30Var) {
            super(2, x30Var);
            this.$block = yq0Var;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final x30 create(Object obj, x30 x30Var) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$block, x30Var);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            kotlin.coroutines.intrinsics.a.d();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            d.b(obj);
            return InterruptibleKt.runInterruptibleInExpectedContext(((CoroutineScope) this.L$0).getCoroutineContext(), this.$block);
        }

        @Override // defpackage.or0
        public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
            return ((AnonymousClass2) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
        }
    }

    public static final <T> Object runInterruptible(kotlin.coroutines.d dVar, yq0 yq0Var, x30 x30Var) {
        return BuildersKt.withContext(dVar, new AnonymousClass2(yq0Var, null), x30Var);
    }

    public static /* synthetic */ Object runInterruptible$default(kotlin.coroutines.d dVar, yq0 yq0Var, x30 x30Var, int i, Object obj) {
        if ((i & 1) != 0) {
            dVar = EmptyCoroutineContext.INSTANCE;
        }
        return runInterruptible(dVar, yq0Var, x30Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> T runInterruptibleInExpectedContext(kotlin.coroutines.d dVar, yq0 yq0Var) throws Throwable {
        try {
            ThreadState threadState = new ThreadState(JobKt.getJob(dVar));
            threadState.setup();
            try {
                return (T) yq0Var.invoke();
            } finally {
                threadState.clearInterrupt();
            }
        } catch (InterruptedException e) {
            throw new CancellationException("Blocking call was interrupted due to parent cancellation").initCause(e);
        }
    }
}
