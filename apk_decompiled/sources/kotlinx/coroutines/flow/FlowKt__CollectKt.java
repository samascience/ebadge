package kotlinx.coroutines.flow;

import defpackage.h70;
import defpackage.j21;
import defpackage.jn;
import defpackage.k83;
import defpackage.or0;
import defpackage.pr0;
import defpackage.x30;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.internal.NopCollector;

/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class FlowKt__CollectKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__CollectKt$collect$3, reason: invalid class name */
    public static final class AnonymousClass3<T> implements FlowCollector<T> {
        final /* synthetic */ or0 $action;

        public AnonymousClass3(or0 or0Var) {
            this.$action = or0Var;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public Object emit(T t, x30 x30Var) {
            Object objInvoke = this.$action.invoke(t, x30Var);
            return objInvoke == a.d() ? objInvoke : k83.a;
        }

        public Object emit$$forInline(T t, final x30 x30Var) {
            j21.c(4);
            new ContinuationImpl(x30Var) { // from class: kotlinx.coroutines.flow.FlowKt__CollectKt$collect$3$emit$1
                int label;
                /* synthetic */ Object result;

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    this.result = obj;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.emit(null, this);
                }
            };
            j21.c(5);
            this.$action.invoke(t, x30Var);
            return k83.a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__CollectKt$collectIndexed$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements FlowCollector<T> {
        final /* synthetic */ pr0 $action;
        private int index;

        public AnonymousClass2(pr0 pr0Var) {
            this.$action = pr0Var;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public Object emit(T t, x30 x30Var) {
            pr0 pr0Var = this.$action;
            int i = this.index;
            this.index = i + 1;
            if (i < 0) {
                throw new ArithmeticException("Index overflow has happened");
            }
            Object objInvoke = pr0Var.invoke(jn.b(i), t, x30Var);
            return objInvoke == a.d() ? objInvoke : k83.a;
        }

        public Object emit$$forInline(T t, final x30 x30Var) {
            j21.c(4);
            new ContinuationImpl(x30Var) { // from class: kotlinx.coroutines.flow.FlowKt__CollectKt$collectIndexed$2$emit$1
                int label;
                /* synthetic */ Object result;

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    this.result = obj;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.emit(null, this);
                }
            };
            j21.c(5);
            pr0 pr0Var = this.$action;
            int i = this.index;
            this.index = i + 1;
            if (i < 0) {
                throw new ArithmeticException("Index overflow has happened");
            }
            pr0Var.invoke(Integer.valueOf(i), t, x30Var);
            return k83.a;
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__CollectKt$launchIn$1, reason: invalid class name */
    @h70(c = "kotlinx.coroutines.flow.FlowKt__CollectKt$launchIn$1", f = "Collect.kt", l = {50}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements or0 {
        final /* synthetic */ Flow<T> $this_launchIn;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Flow<? extends T> flow, x30 x30Var) {
            super(2, x30Var);
            this.$this_launchIn = flow;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final x30 create(Object obj, x30 x30Var) {
            return new AnonymousClass1(this.$this_launchIn, x30Var);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = a.d();
            int i = this.label;
            if (i == 0) {
                d.b(obj);
                Flow<T> flow = this.$this_launchIn;
                this.label = 1;
                if (FlowKt.collect(flow, this) == objD) {
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
        public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
            return ((AnonymousClass1) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
        }
    }

    public static final Object collect(Flow<?> flow, x30 x30Var) {
        Object objCollect = flow.collect(NopCollector.INSTANCE, x30Var);
        return objCollect == a.d() ? objCollect : k83.a;
    }

    private static final /* synthetic */ <T> Object collect$$forInline(Flow<? extends T> flow, or0 or0Var, x30 x30Var) {
        AnonymousClass3 anonymousClass3 = new AnonymousClass3(or0Var);
        j21.c(0);
        flow.collect(anonymousClass3, x30Var);
        j21.c(1);
        return k83.a;
    }

    public static final <T> Object collectIndexed(Flow<? extends T> flow, pr0 pr0Var, x30 x30Var) {
        Object objCollect = flow.collect(new AnonymousClass2(pr0Var), x30Var);
        return objCollect == a.d() ? objCollect : k83.a;
    }

    private static final <T> Object collectIndexed$$forInline(Flow<? extends T> flow, pr0 pr0Var, x30 x30Var) {
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(pr0Var);
        j21.c(0);
        flow.collect(anonymousClass2, x30Var);
        j21.c(1);
        return k83.a;
    }

    public static final <T> Object collectLatest(Flow<? extends T> flow, or0 or0Var, x30 x30Var) {
        Object objCollect = FlowKt.collect(FlowKt__ContextKt.buffer$default(FlowKt.mapLatest(flow, or0Var), 0, null, 2, null), x30Var);
        return objCollect == a.d() ? objCollect : k83.a;
    }

    public static final <T> Object emitAll(FlowCollector<? super T> flowCollector, Flow<? extends T> flow, x30 x30Var) {
        FlowKt.ensureActive(flowCollector);
        Object objCollect = flow.collect(flowCollector, x30Var);
        return objCollect == a.d() ? objCollect : k83.a;
    }

    public static final <T> Job launchIn(Flow<? extends T> flow, CoroutineScope coroutineScope) {
        return BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(flow, null), 3, null);
    }

    public static final /* synthetic */ <T> Object collect(Flow<? extends T> flow, or0 or0Var, x30 x30Var) {
        Object objCollect = flow.collect(new AnonymousClass3(or0Var), x30Var);
        return objCollect == a.d() ? objCollect : k83.a;
    }
}
