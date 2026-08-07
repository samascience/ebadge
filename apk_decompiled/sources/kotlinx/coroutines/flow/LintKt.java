package kotlinx.coroutines.flow;

import defpackage.h70;
import defpackage.j21;
import defpackage.jn;
import defpackage.k83;
import defpackage.or0;
import defpackage.p31;
import defpackage.pr0;
import defpackage.qr0;
import defpackage.x30;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.KotlinNothingValueException;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d;

/* JADX INFO: loaded from: classes4.dex */
public final class LintKt {

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.LintKt$retry$1, reason: invalid class name */
    @h70(c = "kotlinx.coroutines.flow.LintKt$retry$1", f = "Lint.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements or0 {
        int label;

        public AnonymousClass1(x30 x30Var) {
            super(2, x30Var);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final x30 create(Object obj, x30 x30Var) {
            return new AnonymousClass1(x30Var);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            a.d();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            d.b(obj);
            return jn.a(true);
        }

        @Override // defpackage.or0
        public final Object invoke(Throwable th, x30 x30Var) {
            return ((AnonymousClass1) create(th, x30Var)).invokeSuspend(k83.a);
        }
    }

    public static final void cancel(FlowCollector<?> flowCollector, CancellationException cancellationException) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    public static /* synthetic */ void cancel$default(FlowCollector flowCollector, CancellationException cancellationException, int i, Object obj) {
        if ((i & 1) != 0) {
            cancellationException = null;
        }
        cancel(flowCollector, cancellationException);
    }

    public static final <T> Flow<T> cancellable(SharedFlow<? extends T> sharedFlow) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: renamed from: catch, reason: not valid java name */
    private static final <T> Flow<T> m135catch(SharedFlow<? extends T> sharedFlow, pr0 pr0Var) {
        p31.d(sharedFlow, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.catch>");
        return FlowKt.m123catch(sharedFlow, pr0Var);
    }

    public static final <T> Flow<T> conflate(StateFlow<? extends T> stateFlow) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    private static final <T> Object count(SharedFlow<? extends T> sharedFlow, x30 x30Var) {
        p31.d(sharedFlow, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.count>");
        j21.c(0);
        Object objCount = FlowKt.count(sharedFlow, x30Var);
        j21.c(1);
        return objCount;
    }

    public static final <T> Flow<T> distinctUntilChanged(StateFlow<? extends T> stateFlow) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    public static final <T> Flow<T> flowOn(SharedFlow<? extends T> sharedFlow, kotlin.coroutines.d dVar) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    public static final kotlin.coroutines.d getCoroutineContext(FlowCollector<?> flowCollector) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    public static /* synthetic */ void getCoroutineContext$annotations(FlowCollector flowCollector) {
    }

    public static final boolean isActive(FlowCollector<?> flowCollector) {
        FlowKt.noImpl();
        throw new KotlinNothingValueException();
    }

    public static /* synthetic */ void isActive$annotations(FlowCollector flowCollector) {
    }

    private static final <T> Flow<T> retry(SharedFlow<? extends T> sharedFlow, long j, or0 or0Var) {
        p31.d(sharedFlow, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.retry>");
        return FlowKt.retry(sharedFlow, j, or0Var);
    }

    static /* synthetic */ Flow retry$default(SharedFlow sharedFlow, long j, or0 or0Var, int i, Object obj) {
        if ((i & 1) != 0) {
            j = Long.MAX_VALUE;
        }
        if ((i & 2) != 0) {
            or0Var = new AnonymousClass1(null);
        }
        p31.d(sharedFlow, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.retry>");
        return FlowKt.retry(sharedFlow, j, or0Var);
    }

    private static final <T> Flow<T> retryWhen(SharedFlow<? extends T> sharedFlow, qr0 qr0Var) {
        p31.d(sharedFlow, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.retryWhen>");
        return FlowKt.retryWhen(sharedFlow, qr0Var);
    }

    private static final <T> Object toList(SharedFlow<? extends T> sharedFlow, x30 x30Var) {
        p31.d(sharedFlow, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.toList>");
        j21.c(0);
        Object list$default = FlowKt__CollectionKt.toList$default(sharedFlow, null, x30Var, 1, null);
        j21.c(1);
        return list$default;
    }

    private static final <T> Object toSet(SharedFlow<? extends T> sharedFlow, x30 x30Var) {
        p31.d(sharedFlow, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.toSet>");
        j21.c(0);
        Object set$default = FlowKt__CollectionKt.toSet$default(sharedFlow, null, x30Var, 1, null);
        j21.c(1);
        return set$default;
    }

    private static final <T> Object toList(SharedFlow<? extends T> sharedFlow, List<T> list, x30 x30Var) {
        p31.d(sharedFlow, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.toList>");
        j21.c(0);
        FlowKt.toList(sharedFlow, list, x30Var);
        j21.c(1);
        throw new IllegalStateException("this code is supposed to be unreachable");
    }

    private static final <T> Object toSet(SharedFlow<? extends T> sharedFlow, Set<T> set, x30 x30Var) {
        p31.d(sharedFlow, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.toSet>");
        j21.c(0);
        FlowKt.toSet(sharedFlow, set, x30Var);
        j21.c(1);
        throw new IllegalStateException("this code is supposed to be unreachable");
    }
}
