package kotlinx.coroutines.flow;

import defpackage.h70;
import defpackage.k83;
import defpackage.or0;
import defpackage.x30;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;

/* JADX INFO: loaded from: classes4.dex */
@h70(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharingDeferred$1", f = "Share.kt", l = {340}, m = "invokeSuspend")
final class FlowKt__ShareKt$launchSharingDeferred$1 extends SuspendLambda implements or0 {
    final /* synthetic */ CompletableDeferred<StateFlow<T>> $result;
    final /* synthetic */ Flow<T> $upstream;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    FlowKt__ShareKt$launchSharingDeferred$1(Flow<? extends T> flow, CompletableDeferred<StateFlow<T>> completableDeferred, x30 x30Var) {
        super(2, x30Var);
        this.$upstream = flow;
        this.$result = completableDeferred;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(Object obj, x30 x30Var) {
        FlowKt__ShareKt$launchSharingDeferred$1 flowKt__ShareKt$launchSharingDeferred$1 = new FlowKt__ShareKt$launchSharingDeferred$1(this.$upstream, this.$result, x30Var);
        flowKt__ShareKt$launchSharingDeferred$1.L$0 = obj;
        return flowKt__ShareKt$launchSharingDeferred$1;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objD = a.d();
        int i = this.label;
        try {
            if (i == 0) {
                d.b(obj);
                final CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                Flow<T> flow = this.$upstream;
                final CompletableDeferred<StateFlow<T>> completableDeferred = this.$result;
                FlowCollector flowCollector = new FlowCollector() { // from class: kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharingDeferred$1.1
                    /* JADX WARN: Type inference failed for: r4v2, types: [T, kotlinx.coroutines.flow.MutableStateFlow, kotlinx.coroutines.flow.StateFlow] */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(T t, x30 x30Var) {
                        k83 k83Var;
                        MutableStateFlow<T> mutableStateFlow = ref$ObjectRef.element;
                        if (mutableStateFlow != null) {
                            mutableStateFlow.setValue(t);
                            k83Var = k83.a;
                        } else {
                            k83Var = null;
                        }
                        if (k83Var == null) {
                            CoroutineScope coroutineScope2 = coroutineScope;
                            Ref$ObjectRef<MutableStateFlow<T>> ref$ObjectRef2 = ref$ObjectRef;
                            CompletableDeferred<StateFlow<T>> completableDeferred2 = completableDeferred;
                            ?? r4 = (T) StateFlowKt.MutableStateFlow(t);
                            completableDeferred2.complete(new ReadonlyStateFlow(r4, JobKt.getJob(coroutineScope2.getCoroutineContext())));
                            ref$ObjectRef2.element = r4;
                        }
                        return k83.a;
                    }
                };
                this.label = 1;
                if (flow.collect((FlowCollector<? super T>) flowCollector, this) == objD) {
                    return objD;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d.b(obj);
            }
            return k83.a;
        } catch (Throwable th) {
            this.$result.completeExceptionally(th);
            throw th;
        }
    }

    @Override // defpackage.or0
    public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
        return ((FlowKt__ShareKt$launchSharingDeferred$1) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
    }
}
