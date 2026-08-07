package kotlinx.coroutines.flow.internal;

import defpackage.j21;
import defpackage.k83;
import defpackage.or0;
import defpackage.p31;
import defpackage.x30;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.internal.ScopeCoroutine;

/* JADX INFO: loaded from: classes4.dex */
public final class SafeCollector_commonKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.SafeCollector_commonKt$unsafeFlow$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Flow<T> {
        final /* synthetic */ or0 $block;

        public AnonymousClass1(or0 or0Var) {
            this.$block = or0Var;
        }

        @Override // kotlinx.coroutines.flow.Flow
        public Object collect(FlowCollector<? super T> flowCollector, x30 x30Var) {
            Object objInvoke = this.$block.invoke(flowCollector, x30Var);
            return objInvoke == a.d() ? objInvoke : k83.a;
        }

        public Object collect$$forInline(FlowCollector<? super T> flowCollector, final x30 x30Var) {
            j21.c(4);
            new ContinuationImpl(x30Var) { // from class: kotlinx.coroutines.flow.internal.SafeCollector_commonKt$unsafeFlow$1$collect$1
                int label;
                /* synthetic */ Object result;

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    this.result = obj;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.collect(null, this);
                }
            };
            j21.c(5);
            this.$block.invoke(flowCollector, x30Var);
            return k83.a;
        }
    }

    public static final void checkContext(final SafeCollector<?> safeCollector, d dVar) {
        if (((Number) dVar.fold(0, new or0() { // from class: kotlinx.coroutines.flow.internal.SafeCollector_commonKt$checkContext$result$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // defpackage.or0
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return invoke(((Number) obj).intValue(), (d.b) obj2);
            }

            public final Integer invoke(int i, d.b bVar) {
                d.c key = bVar.getKey();
                d.b bVar2 = safeCollector.collectContext.get(key);
                if (key != Job.Key) {
                    return Integer.valueOf(bVar != bVar2 ? Integer.MIN_VALUE : i + 1);
                }
                Job job = (Job) bVar2;
                p31.d(bVar, "null cannot be cast to non-null type kotlinx.coroutines.Job");
                Job jobTransitiveCoroutineParent = SafeCollector_commonKt.transitiveCoroutineParent((Job) bVar, job);
                if (jobTransitiveCoroutineParent == job) {
                    if (job != null) {
                        i++;
                    }
                    return Integer.valueOf(i);
                }
                throw new IllegalStateException(("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of " + jobTransitiveCoroutineParent + ", expected child of " + job + ".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'").toString());
            }
        })).intValue() == safeCollector.collectContextSize) {
            return;
        }
        throw new IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + safeCollector.collectContext + ",\n\t\tbut emission happened in " + dVar + ".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
    }

    public static final Job transitiveCoroutineParent(Job job, Job job2) {
        while (job != null) {
            if (job == job2 || !(job instanceof ScopeCoroutine)) {
                return job;
            }
            job = job.getParent();
        }
        return null;
    }

    public static final <T> Flow<T> unsafeFlow(or0 or0Var) {
        return new AnonymousClass1(or0Var);
    }
}
