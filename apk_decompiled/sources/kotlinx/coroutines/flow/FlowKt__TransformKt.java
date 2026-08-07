package kotlinx.coroutines.flow;

import defpackage.b21;
import defpackage.h70;
import defpackage.h81;
import defpackage.j21;
import defpackage.k83;
import defpackage.or0;
import defpackage.p31;
import defpackage.pr0;
import defpackage.x30;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.d;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;

/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class FlowKt__TransformKt {
    public static final <T> Flow<T> filter(Flow<? extends T> flow, or0 or0Var) {
        return new FlowKt__TransformKt$filter$$inlined$unsafeTransform$1(flow, or0Var);
    }

    public static final /* synthetic */ <R> Flow<R> filterIsInstance(Flow<?> flow) {
        p31.j();
        return new FlowKt__TransformKt$filterIsInstance$$inlined$filter$1(flow);
    }

    public static final <T> Flow<T> filterNot(Flow<? extends T> flow, or0 or0Var) {
        return new FlowKt__TransformKt$filterNot$$inlined$unsafeTransform$1(flow, or0Var);
    }

    public static final <T> Flow<T> filterNotNull(final Flow<? extends T> flow) {
        return new Flow<T>() { // from class: kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1

            /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2$1, reason: invalid class name */
                @h70(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2", f = "Transform.kt", l = {223}, m = "emit")
                public static final class AnonymousClass1 extends ContinuationImpl {
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

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(T t, x30 x30Var) throws Throwable {
                    AnonymousClass1 anonymousClass1;
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
                    Object obj = anonymousClass1.result;
                    Object objD = a.d();
                    int i2 = anonymousClass1.label;
                    if (i2 == 0) {
                        d.b(obj);
                        FlowCollector flowCollector = this.$this_unsafeFlow;
                        if (t != null) {
                            anonymousClass1.label = 1;
                            if (flowCollector.emit(t, anonymousClass1) == objD) {
                                return objD;
                            }
                        }
                    } else {
                        if (i2 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        d.b(obj);
                    }
                    return k83.a;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector, x30 x30Var) {
                Object objCollect = flow.collect(new AnonymousClass2(flowCollector), x30Var);
                return objCollect == a.d() ? objCollect : k83.a;
            }
        };
    }

    public static final <T, R> Flow<R> map(Flow<? extends T> flow, or0 or0Var) {
        return new FlowKt__TransformKt$map$$inlined$unsafeTransform$1(flow, or0Var);
    }

    public static final <T, R> Flow<R> mapNotNull(Flow<? extends T> flow, or0 or0Var) {
        return new FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1(flow, or0Var);
    }

    public static final <T> Flow<T> onEach(final Flow<? extends T> flow, final or0 or0Var) {
        return new Flow<T>() { // from class: kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1

            /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ or0 $action$inlined;
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1, reason: invalid class name */
                @h70(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2", f = "Transform.kt", l = {223, 224}, m = "emit")
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    Object L$1;
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
                    this.$action$inlined = or0Var;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(T t, x30 x30Var) throws Throwable {
                    AnonymousClass1 anonymousClass1;
                    Object obj;
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
                            FlowCollector flowCollector2 = (FlowCollector) anonymousClass1.L$1;
                            obj = anonymousClass1.L$0;
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
                    or0 or0Var = this.$action$inlined;
                    anonymousClass1.L$0 = t;
                    anonymousClass1.L$1 = flowCollector3;
                    anonymousClass1.label = 1;
                    j21.c(6);
                    Object objInvoke = or0Var.invoke(t, anonymousClass1);
                    j21.c(7);
                    if (objInvoke == objD) {
                        return objD;
                    }
                    obj = t;
                    flowCollector = flowCollector3;
                    anonymousClass1.L$0 = null;
                    anonymousClass1.L$1 = null;
                    anonymousClass1.label = 2;
                    if (flowCollector.emit(obj, anonymousClass1) == objD) {
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
        };
    }

    public static final <T, R> Flow<R> runningFold(Flow<? extends T> flow, R r, pr0 pr0Var) {
        return new FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1(r, flow, pr0Var);
    }

    public static final <T> Flow<T> runningReduce(final Flow<? extends T> flow, final pr0 pr0Var) {
        return new Flow<T>() { // from class: kotlinx.coroutines.flow.FlowKt__TransformKt$runningReduce$$inlined$unsafeFlow$1
            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super T> flowCollector, x30 x30Var) {
                Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                ref$ObjectRef.element = (T) NullSurrogateKt.NULL;
                Object objCollect = flow.collect(new FlowKt__TransformKt$runningReduce$1$1(ref$ObjectRef, pr0Var, flowCollector), x30Var);
                return objCollect == a.d() ? objCollect : k83.a;
            }
        };
    }

    public static final <T, R> Flow<R> scan(Flow<? extends T> flow, R r, pr0 pr0Var) {
        return FlowKt.runningFold(flow, r, pr0Var);
    }

    public static final <T> Flow<b21> withIndex(final Flow<? extends T> flow) {
        return new Flow<b21>() { // from class: kotlinx.coroutines.flow.FlowKt__TransformKt$withIndex$$inlined$unsafeFlow$1
            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super b21> flowCollector, x30 x30Var) {
                Object objCollect = flow.collect(new FlowKt__TransformKt$withIndex$1$1(flowCollector, new Ref$IntRef()), x30Var);
                return objCollect == a.d() ? objCollect : k83.a;
            }
        };
    }

    public static final <R> Flow<R> filterIsInstance(final Flow<?> flow, final h81 h81Var) {
        return (Flow<R>) new Flow<Object>() { // from class: kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$2

            /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$2$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ h81 $klass$inlined;
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$2$2$1, reason: invalid class name */
                @h70(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$2$2", f = "Transform.kt", l = {223}, m = "emit")
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    Object L$1;
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

                public AnonymousClass2(FlowCollector flowCollector, h81 h81Var) {
                    this.$this_unsafeFlow = flowCollector;
                    this.$klass$inlined = h81Var;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(Object obj, x30 x30Var) throws Throwable {
                    AnonymousClass1 anonymousClass1;
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
                    if (i2 == 0) {
                        d.b(obj2);
                        FlowCollector flowCollector = this.$this_unsafeFlow;
                        if (this.$klass$inlined.b(obj)) {
                            anonymousClass1.label = 1;
                            if (flowCollector.emit(obj, anonymousClass1) == objD) {
                                return objD;
                            }
                        }
                    } else {
                        if (i2 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        d.b(obj2);
                    }
                    return k83.a;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super Object> flowCollector, x30 x30Var) {
                Object objCollect = flow.collect(new AnonymousClass2(flowCollector, h81Var), x30Var);
                return objCollect == a.d() ? objCollect : k83.a;
            }
        };
    }
}
