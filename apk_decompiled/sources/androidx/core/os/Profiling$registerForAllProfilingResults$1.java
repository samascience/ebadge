package androidx.core.os;

import android.content.Context;
import android.os.ProfilingManager;
import android.os.ProfilingResult;
import defpackage.h70;
import defpackage.k83;
import defpackage.or0;
import defpackage.p31;
import defpackage.u72;
import defpackage.v72;
import defpackage.x30;
import defpackage.yq0;
import java.util.concurrent.Executor;
import java.util.function.Consumer;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;

/* JADX INFO: loaded from: classes.dex */
@h70(c = "androidx.core.os.Profiling$registerForAllProfilingResults$1", f = "Profiling.kt", l = {79}, m = "invokeSuspend")
final class Profiling$registerForAllProfilingResults$1 extends SuspendLambda implements or0 {
    final /* synthetic */ Context $context;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Profiling$registerForAllProfilingResults$1(Context context, x30 x30Var) {
        super(2, x30Var);
        this.$context = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$lambda$0(ProducerScope producerScope, ProfilingResult profilingResult) {
        p31.e(profilingResult, "result");
        producerScope.mo92trySendJP2dKIU(profilingResult);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(Object obj, x30 x30Var) {
        Profiling$registerForAllProfilingResults$1 profiling$registerForAllProfilingResults$1 = new Profiling$registerForAllProfilingResults$1(this.$context, x30Var);
        profiling$registerForAllProfilingResults$1.L$0 = obj;
        return profiling$registerForAllProfilingResults$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objD = kotlin.coroutines.intrinsics.a.d();
        int i = this.label;
        if (i == 0) {
            d.b(obj);
            final ProducerScope producerScope = (ProducerScope) this.L$0;
            final Consumer consumer = new Consumer() { // from class: androidx.core.os.a
                @Override // java.util.function.Consumer
                public final void accept(Object obj2) {
                    Profiling$registerForAllProfilingResults$1.invokeSuspend$lambda$0(producerScope, (ProfilingResult) obj2);
                }
            };
            final ProfilingManager profilingManagerA = v72.a(this.$context.getSystemService(u72.a()));
            profilingManagerA.registerForAllProfilingResults(new Executor() { // from class: androidx.core.os.b
                @Override // java.util.concurrent.Executor
                public final void execute(Runnable runnable) {
                    runnable.run();
                }
            }, consumer);
            yq0 yq0Var = new yq0() { // from class: androidx.core.os.Profiling$registerForAllProfilingResults$1.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // defpackage.yq0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m7invoke();
                    return k83.a;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m7invoke() {
                    profilingManagerA.unregisterForAllProfilingResults(consumer);
                }
            };
            this.label = 1;
            if (ProduceKt.awaitClose(producerScope, yq0Var, this) == objD) {
                return objD;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            d.b(obj);
        }
        return k83.a;
    }

    @Override // defpackage.or0
    public final Object invoke(ProducerScope<? super ProfilingResult> producerScope, x30 x30Var) {
        return ((Profiling$registerForAllProfilingResults$1) create(producerScope, x30Var)).invokeSuspend(k83.a);
    }
}
