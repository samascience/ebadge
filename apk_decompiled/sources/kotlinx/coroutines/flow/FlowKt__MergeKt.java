package kotlinx.coroutines.flow;

import com.jieli.jl_rcsp.constant.Command;
import defpackage.h70;
import defpackage.j21;
import defpackage.k83;
import defpackage.or0;
import defpackage.pr0;
import defpackage.x30;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.FlowPreview;
import kotlinx.coroutines.flow.internal.ChannelFlowMerge;
import kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest;
import kotlinx.coroutines.flow.internal.ChannelLimitedFlowMerge;
import kotlinx.coroutines.internal.SystemPropsKt;

/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class FlowKt__MergeKt {
    private static final int DEFAULT_CONCURRENCY = SystemPropsKt.systemProp(FlowKt.DEFAULT_CONCURRENCY_PROPERTY_NAME, 16, 1, Integer.MAX_VALUE);

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapLatest$1, reason: invalid class name */
    @h70(c = "kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapLatest$1", f = "Merge.kt", l = {193, 193}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements pr0 {
        final /* synthetic */ or0 $transform;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(or0 or0Var, x30 x30Var) {
            super(3, x30Var);
            this.$transform = or0Var;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            FlowCollector flowCollector;
            Object objD = a.d();
            int i = this.label;
            if (i != 0) {
                if (i == 1) {
                    flowCollector = (FlowCollector) this.L$0;
                    d.b(obj);
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    d.b(obj);
                }
                return k83.a;
            }
            d.b(obj);
            flowCollector = (FlowCollector) this.L$0;
            Object obj2 = this.L$1;
            or0 or0Var = this.$transform;
            this.L$0 = flowCollector;
            this.label = 1;
            obj = or0Var.invoke(obj2, this);
            if (obj == objD) {
                return objD;
            }
            this.L$0 = null;
            this.label = 2;
            if (FlowKt.emitAll(flowCollector, (Flow) obj, this) == objD) {
                return objD;
            }
            return k83.a;
        }

        public final Object invokeSuspend$$forInline(Object obj) {
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            Flow flow = (Flow) this.$transform.invoke(this.L$1, this);
            j21.c(0);
            FlowKt.emitAll(flowCollector, flow, this);
            j21.c(1);
            return k83.a;
        }

        @Override // defpackage.pr0
        public final Object invoke(FlowCollector<? super R> flowCollector, T t, x30 x30Var) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$transform, x30Var);
            anonymousClass1.L$0 = flowCollector;
            anonymousClass1.L$1 = t;
            return anonymousClass1.invokeSuspend(k83.a);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__MergeKt$mapLatest$1, reason: invalid class name and case insensitive filesystem */
    @h70(c = "kotlinx.coroutines.flow.FlowKt__MergeKt$mapLatest$1", f = "Merge.kt", l = {Command.CMD_GET_DEVICE_CONFIG_INFO, Command.CMD_GET_DEVICE_CONFIG_INFO}, m = "invokeSuspend")
    static final class C02391 extends SuspendLambda implements pr0 {
        final /* synthetic */ or0 $transform;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02391(or0 or0Var, x30 x30Var) {
            super(3, x30Var);
            this.$transform = or0Var;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            FlowCollector flowCollector;
            Object objD = a.d();
            int i = this.label;
            if (i != 0) {
                if (i == 1) {
                    flowCollector = (FlowCollector) this.L$0;
                    d.b(obj);
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    d.b(obj);
                }
                return k83.a;
            }
            d.b(obj);
            flowCollector = (FlowCollector) this.L$0;
            Object obj2 = this.L$1;
            or0 or0Var = this.$transform;
            this.L$0 = flowCollector;
            this.label = 1;
            obj = or0Var.invoke(obj2, this);
            if (obj == objD) {
                return objD;
            }
            this.L$0 = null;
            this.label = 2;
            if (flowCollector.emit(obj, this) == objD) {
                return objD;
            }
            return k83.a;
        }

        @Override // defpackage.pr0
        public final Object invoke(FlowCollector<? super R> flowCollector, T t, x30 x30Var) {
            C02391 c02391 = new C02391(this.$transform, x30Var);
            c02391.L$0 = flowCollector;
            c02391.L$1 = t;
            return c02391.invokeSuspend(k83.a);
        }
    }

    @ExperimentalCoroutinesApi
    public static final <T, R> Flow<R> flatMapConcat(final Flow<? extends T> flow, final or0 or0Var) {
        return FlowKt.flattenConcat(new Flow<Flow<? extends R>>() { // from class: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1

            /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ or0 $transform$inlined;

                /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2$1, reason: invalid class name */
                @h70(c = "kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2", f = "Merge.kt", l = {223, 223}, m = "emit")
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(x30 x30Var) {
                        super(x30Var);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, or0 or0Var) {
                    this.$this_unsafeFlow = flowCollector;
                    this.$transform$inlined = or0Var;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(Object obj, x30 x30Var) throws Throwable {
                    AnonymousClass1 anonymousClass1;
                    FlowCollector flowCollector;
                    if (x30Var instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) x30Var;
                        int i = anonymousClass1.label;
                        if ((i & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i - Integer.MIN_VALUE;
                        } else {
                            anonymousClass1 = new AnonymousClass1(x30Var);
                        }
                    } else {
                        anonymousClass1 = new AnonymousClass1(x30Var);
                    }
                    Object obj2 = anonymousClass1.result;
                    Object objD = a.d();
                    int i2 = anonymousClass1.label;
                    if (i2 != 0) {
                        if (i2 == 1) {
                            FlowCollector flowCollector2 = (FlowCollector) anonymousClass1.L$0;
                            d.b(obj2);
                            flowCollector = flowCollector2;
                        } else {
                            if (i2 != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            d.b(obj2);
                        }
                        return k83.a;
                    }
                    d.b(obj2);
                    FlowCollector flowCollector3 = this.$this_unsafeFlow;
                    or0 or0Var = this.$transform$inlined;
                    anonymousClass1.L$0 = flowCollector3;
                    anonymousClass1.label = 1;
                    Object objInvoke = or0Var.invoke(obj, anonymousClass1);
                    if (objInvoke == objD) {
                        return objD;
                    }
                    obj2 = objInvoke;
                    flowCollector = flowCollector3;
                    anonymousClass1.L$0 = null;
                    anonymousClass1.label = 2;
                    if (flowCollector.emit(obj2, anonymousClass1) == objD) {
                        return objD;
                    }
                    return k83.a;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector, x30 x30Var) {
                Object objCollect = flow.collect(new AnonymousClass2(flowCollector, or0Var), x30Var);
                return objCollect == a.d() ? objCollect : k83.a;
            }
        });
    }

    @ExperimentalCoroutinesApi
    public static final <T, R> Flow<R> flatMapLatest(Flow<? extends T> flow, or0 or0Var) {
        return FlowKt.transformLatest(flow, new AnonymousClass1(or0Var, null));
    }

    @ExperimentalCoroutinesApi
    public static final <T, R> Flow<R> flatMapMerge(final Flow<? extends T> flow, int i, final or0 or0Var) {
        return FlowKt.flattenMerge(new Flow<Flow<? extends R>>() { // from class: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1

            /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ or0 $transform$inlined;

                /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2$1, reason: invalid class name */
                @h70(c = "kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2", f = "Merge.kt", l = {223, 223}, m = "emit")
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(x30 x30Var) {
                        super(x30Var);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, or0 or0Var) {
                    this.$this_unsafeFlow = flowCollector;
                    this.$transform$inlined = or0Var;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(Object obj, x30 x30Var) throws Throwable {
                    AnonymousClass1 anonymousClass1;
                    FlowCollector flowCollector;
                    if (x30Var instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) x30Var;
                        int i = anonymousClass1.label;
                        if ((i & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i - Integer.MIN_VALUE;
                        } else {
                            anonymousClass1 = new AnonymousClass1(x30Var);
                        }
                    } else {
                        anonymousClass1 = new AnonymousClass1(x30Var);
                    }
                    Object obj2 = anonymousClass1.result;
                    Object objD = a.d();
                    int i2 = anonymousClass1.label;
                    if (i2 != 0) {
                        if (i2 == 1) {
                            FlowCollector flowCollector2 = (FlowCollector) anonymousClass1.L$0;
                            d.b(obj2);
                            flowCollector = flowCollector2;
                        } else {
                            if (i2 != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            d.b(obj2);
                        }
                        return k83.a;
                    }
                    d.b(obj2);
                    FlowCollector flowCollector3 = this.$this_unsafeFlow;
                    or0 or0Var = this.$transform$inlined;
                    anonymousClass1.L$0 = flowCollector3;
                    anonymousClass1.label = 1;
                    Object objInvoke = or0Var.invoke(obj, anonymousClass1);
                    if (objInvoke == objD) {
                        return objD;
                    }
                    obj2 = objInvoke;
                    flowCollector = flowCollector3;
                    anonymousClass1.L$0 = null;
                    anonymousClass1.label = 2;
                    if (flowCollector.emit(obj2, anonymousClass1) == objD) {
                        return objD;
                    }
                    return k83.a;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector, x30 x30Var) {
                Object objCollect = flow.collect(new AnonymousClass2(flowCollector, or0Var), x30Var);
                return objCollect == a.d() ? objCollect : k83.a;
            }
        }, i);
    }

    public static /* synthetic */ Flow flatMapMerge$default(Flow flow, int i, or0 or0Var, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = DEFAULT_CONCURRENCY;
        }
        return FlowKt.flatMapMerge(flow, i, or0Var);
    }

    @ExperimentalCoroutinesApi
    public static final <T> Flow<T> flattenConcat(final Flow<? extends Flow<? extends T>> flow) {
        return new Flow<T>() { // from class: kotlinx.coroutines.flow.FlowKt__MergeKt$flattenConcat$$inlined$unsafeFlow$1
            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super T> flowCollector, x30 x30Var) {
                Object objCollect = flow.collect(new FlowKt__MergeKt$flattenConcat$1$1(flowCollector), x30Var);
                return objCollect == a.d() ? objCollect : k83.a;
            }
        };
    }

    @ExperimentalCoroutinesApi
    public static final <T> Flow<T> flattenMerge(Flow<? extends Flow<? extends T>> flow, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException(("Expected positive concurrency level, but had " + i).toString());
        }
        if (i == 1) {
            return FlowKt.flattenConcat(flow);
        }
        return new ChannelFlowMerge(flow, i, null, 0, null, 28, null);
    }

    public static /* synthetic */ Flow flattenMerge$default(Flow flow, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = DEFAULT_CONCURRENCY;
        }
        return FlowKt.flattenMerge(flow, i);
    }

    public static final int getDEFAULT_CONCURRENCY() {
        return DEFAULT_CONCURRENCY;
    }

    @FlowPreview
    public static /* synthetic */ void getDEFAULT_CONCURRENCY$annotations() {
    }

    @FlowPreview
    public static /* synthetic */ void getDEFAULT_CONCURRENCY_PROPERTY_NAME$annotations() {
    }

    @ExperimentalCoroutinesApi
    public static final <T, R> Flow<R> mapLatest(Flow<? extends T> flow, or0 or0Var) {
        return FlowKt.transformLatest(flow, new C02391(or0Var, null));
    }

    public static final <T> Flow<T> merge(Iterable<? extends Flow<? extends T>> iterable) {
        return new ChannelLimitedFlowMerge(iterable, null, 0, null, 14, null);
    }

    @ExperimentalCoroutinesApi
    public static final <T, R> Flow<R> transformLatest(Flow<? extends T> flow, pr0 pr0Var) {
        return new ChannelFlowTransformLatest(pr0Var, flow, null, 0, null, 28, null);
    }

    public static final <T> Flow<T> merge(Flow<? extends T>... flowArr) {
        return FlowKt.merge(kotlin.collections.d.q(flowArr));
    }
}
