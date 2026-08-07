package kotlinx.coroutines.flow;

import defpackage.h70;
import defpackage.j21;
import defpackage.k83;
import defpackage.or0;
import defpackage.pr0;
import defpackage.x30;
import java.util.NoSuchElementException;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.d;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.flow.internal.AbortFlowException;
import kotlinx.coroutines.flow.internal.FlowExceptions_commonKt;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class FlowKt__ReduceKt {

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$first$1, reason: invalid class name */
    @h70(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", l = {Opcodes.INVOKESPECIAL}, m = "first")
    static final class AnonymousClass1<T> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(x30 x30Var) {
            super(x30Var);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt.first(null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$first$3, reason: invalid class name */
    @h70(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", l = {Opcodes.INVOKESPECIAL}, m = "first")
    static final class AnonymousClass3<T> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass3(x30 x30Var) {
            super(x30Var);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt.first(null, null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$1, reason: invalid class name and case insensitive filesystem */
    @h70(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", l = {Opcodes.INVOKESPECIAL}, m = "firstOrNull")
    static final class C02421<T> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C02421(x30 x30Var) {
            super(x30Var);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt.firstOrNull(null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$3, reason: invalid class name and case insensitive filesystem */
    @h70(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", l = {Opcodes.INVOKESPECIAL}, m = "firstOrNull")
    static final class C02433<T> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C02433(x30 x30Var) {
            super(x30Var);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt.firstOrNull(null, null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$1, reason: invalid class name and case insensitive filesystem */
    @h70(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", l = {44}, m = "fold")
    static final class C02441<T, R> extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C02441(x30 x30Var) {
            super(x30Var);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt__ReduceKt.fold(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements FlowCollector {
        final /* synthetic */ Ref$ObjectRef<R> $accumulator;
        final /* synthetic */ pr0 $operation;

        public AnonymousClass2(Ref$ObjectRef<R> ref$ObjectRef, pr0 pr0Var) {
            this.$accumulator = ref$ObjectRef;
            this.$operation = pr0Var;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(T t, x30 x30Var) throws Throwable {
            FlowKt__ReduceKt$fold$2$emit$1 flowKt__ReduceKt$fold$2$emit$1;
            Ref$ObjectRef ref$ObjectRef;
            if (x30Var instanceof FlowKt__ReduceKt$fold$2$emit$1) {
                flowKt__ReduceKt$fold$2$emit$1 = (FlowKt__ReduceKt$fold$2$emit$1) x30Var;
                int i = flowKt__ReduceKt$fold$2$emit$1.label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    flowKt__ReduceKt$fold$2$emit$1.label = i - Integer.MIN_VALUE;
                } else {
                    flowKt__ReduceKt$fold$2$emit$1 = new FlowKt__ReduceKt$fold$2$emit$1(this, x30Var);
                }
            } else {
                flowKt__ReduceKt$fold$2$emit$1 = new FlowKt__ReduceKt$fold$2$emit$1(this, x30Var);
            }
            T t2 = (T) flowKt__ReduceKt$fold$2$emit$1.result;
            Object objD = a.d();
            int i2 = flowKt__ReduceKt$fold$2$emit$1.label;
            if (i2 == 0) {
                d.b(t2);
                Ref$ObjectRef ref$ObjectRef2 = this.$accumulator;
                pr0 pr0Var = this.$operation;
                T t3 = ref$ObjectRef2.element;
                flowKt__ReduceKt$fold$2$emit$1.L$0 = ref$ObjectRef2;
                flowKt__ReduceKt$fold$2$emit$1.label = 1;
                Object objInvoke = pr0Var.invoke(t3, t, flowKt__ReduceKt$fold$2$emit$1);
                if (objInvoke == objD) {
                    return objD;
                }
                t2 = (T) objInvoke;
                ref$ObjectRef = ref$ObjectRef2;
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ref$ObjectRef = (Ref$ObjectRef) flowKt__ReduceKt$fold$2$emit$1.L$0;
                d.b(t2);
            }
            ref$ObjectRef.element = t2;
            return k83.a;
        }

        public final Object emit$$forInline(T t, x30 x30Var) {
            j21.c(4);
            new FlowKt__ReduceKt$fold$2$emit$1(this, x30Var);
            j21.c(5);
            Ref$ObjectRef<R> ref$ObjectRef = this.$accumulator;
            ref$ObjectRef.element = (T) this.$operation.invoke(ref$ObjectRef.element, t, x30Var);
            return k83.a;
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$last$1, reason: invalid class name and case insensitive filesystem */
    @h70(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", l = {155}, m = "last")
    static final class C02451<T> extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C02451(x30 x30Var) {
            super(x30Var);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt.last(null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$lastOrNull$1, reason: invalid class name and case insensitive filesystem */
    @h70(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", l = {Opcodes.GOTO}, m = "lastOrNull")
    static final class C02471<T> extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C02471(x30 x30Var) {
            super(x30Var);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt.lastOrNull(null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$1, reason: invalid class name and case insensitive filesystem */
    @h70(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", l = {22}, m = "reduce")
    static final class C02491<S, T extends S> extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C02491(x30 x30Var) {
            super(x30Var);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt.reduce(null, null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$2, reason: invalid class name and case insensitive filesystem */
    static final class C02502<T> implements FlowCollector {
        final /* synthetic */ Ref$ObjectRef<Object> $accumulator;
        final /* synthetic */ pr0 $operation;

        C02502(Ref$ObjectRef<Object> ref$ObjectRef, pr0 pr0Var) {
            this.$accumulator = ref$ObjectRef;
            this.$operation = pr0Var;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(T t, x30 x30Var) throws Throwable {
            FlowKt__ReduceKt$reduce$2$emit$1 flowKt__ReduceKt$reduce$2$emit$1;
            Ref$ObjectRef<Object> ref$ObjectRef;
            Ref$ObjectRef<Object> ref$ObjectRef2;
            if (x30Var instanceof FlowKt__ReduceKt$reduce$2$emit$1) {
                flowKt__ReduceKt$reduce$2$emit$1 = (FlowKt__ReduceKt$reduce$2$emit$1) x30Var;
                int i = flowKt__ReduceKt$reduce$2$emit$1.label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    flowKt__ReduceKt$reduce$2$emit$1.label = i - Integer.MIN_VALUE;
                } else {
                    flowKt__ReduceKt$reduce$2$emit$1 = new FlowKt__ReduceKt$reduce$2$emit$1(this, x30Var);
                }
            } else {
                flowKt__ReduceKt$reduce$2$emit$1 = new FlowKt__ReduceKt$reduce$2$emit$1(this, x30Var);
            }
            Object obj = flowKt__ReduceKt$reduce$2$emit$1.result;
            Object objD = a.d();
            int i2 = flowKt__ReduceKt$reduce$2$emit$1.label;
            if (i2 == 0) {
                d.b(obj);
                ref$ObjectRef = this.$accumulator;
                Object obj2 = ref$ObjectRef.element;
                if (obj2 != NullSurrogateKt.NULL) {
                    pr0 pr0Var = this.$operation;
                    flowKt__ReduceKt$reduce$2$emit$1.L$0 = ref$ObjectRef;
                    flowKt__ReduceKt$reduce$2$emit$1.label = 1;
                    Object objInvoke = pr0Var.invoke(obj2, t, flowKt__ReduceKt$reduce$2$emit$1);
                    if (objInvoke == objD) {
                        return objD;
                    }
                    obj = objInvoke;
                    ref$ObjectRef2 = ref$ObjectRef;
                }
                ref$ObjectRef.element = t;
                return k83.a;
            }
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ref$ObjectRef2 = (Ref$ObjectRef) flowKt__ReduceKt$reduce$2$emit$1.L$0;
            d.b(obj);
            Object obj3 = obj;
            ref$ObjectRef = ref$ObjectRef2;
            t = (T) obj3;
            ref$ObjectRef.element = t;
            return k83.a;
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$single$1, reason: invalid class name and case insensitive filesystem */
    @h70(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", l = {57}, m = "single")
    static final class C02511<T> extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C02511(x30 x30Var) {
            super(x30Var);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt.single(null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$singleOrNull$1, reason: invalid class name and case insensitive filesystem */
    @h70(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", l = {Opcodes.INVOKESPECIAL}, m = "singleOrNull")
    static final class C02531<T> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C02531(x30 x30Var) {
            super(x30Var);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt.singleOrNull(null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final <T> Object first(Flow<? extends T> flow, x30 x30Var) throws Throwable {
        AnonymousClass1 anonymousClass1;
        Ref$ObjectRef ref$ObjectRef;
        AbortFlowException e;
        FlowCollector<T> flowCollector;
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
            final Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            ref$ObjectRef2.element = (T) NullSurrogateKt.NULL;
            FlowCollector<T> flowCollector2 = new FlowCollector<T>() { // from class: kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public Object emit(T t, x30 x30Var2) {
                    ref$ObjectRef2.element = t;
                    throw new AbortFlowException(this);
                }
            };
            try {
                anonymousClass1.L$0 = ref$ObjectRef2;
                anonymousClass1.L$1 = flowCollector2;
                anonymousClass1.label = 1;
                if (flow.collect(flowCollector2, anonymousClass1) == objD) {
                    return objD;
                }
                ref$ObjectRef = ref$ObjectRef2;
            } catch (AbortFlowException e2) {
                ref$ObjectRef = ref$ObjectRef2;
                e = e2;
                flowCollector = flowCollector2;
                FlowExceptions_commonKt.checkOwnership(e, flowCollector);
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            flowCollector = (FlowKt__ReduceKt$first$$inlined$collectWhile$1) anonymousClass1.L$1;
            ref$ObjectRef = (Ref$ObjectRef) anonymousClass1.L$0;
            try {
                d.b(obj);
            } catch (AbortFlowException e3) {
                e = e3;
                FlowExceptions_commonKt.checkOwnership(e, flowCollector);
            }
        }
        T t = ref$ObjectRef.element;
        if (t != NullSurrogateKt.NULL) {
            return t;
        }
        throw new NoSuchElementException("Expected at least one element");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final <T> Object firstOrNull(Flow<? extends T> flow, x30 x30Var) throws Throwable {
        C02421 c02421;
        Ref$ObjectRef ref$ObjectRef;
        AbortFlowException e;
        FlowCollector<T> flowCollector;
        if (x30Var instanceof C02421) {
            c02421 = (C02421) x30Var;
            int i = c02421.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c02421.label = i - Integer.MIN_VALUE;
            } else {
                c02421 = new C02421(x30Var);
            }
        } else {
            c02421 = new C02421(x30Var);
        }
        Object obj = c02421.result;
        Object objD = a.d();
        int i2 = c02421.label;
        if (i2 == 0) {
            d.b(obj);
            final Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            FlowCollector<T> flowCollector2 = new FlowCollector<T>() { // from class: kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public Object emit(T t, x30 x30Var2) {
                    ref$ObjectRef2.element = t;
                    throw new AbortFlowException(this);
                }
            };
            try {
                c02421.L$0 = ref$ObjectRef2;
                c02421.L$1 = flowCollector2;
                c02421.label = 1;
                if (flow.collect(flowCollector2, c02421) == objD) {
                    return objD;
                }
                ref$ObjectRef = ref$ObjectRef2;
            } catch (AbortFlowException e2) {
                ref$ObjectRef = ref$ObjectRef2;
                e = e2;
                flowCollector = flowCollector2;
                FlowExceptions_commonKt.checkOwnership(e, flowCollector);
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            flowCollector = (FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$1) c02421.L$1;
            ref$ObjectRef = (Ref$ObjectRef) c02421.L$0;
            try {
                d.b(obj);
            } catch (AbortFlowException e3) {
                e = e3;
                FlowExceptions_commonKt.checkOwnership(e, flowCollector);
            }
        }
        return ref$ObjectRef.element;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, R> Object fold(Flow<? extends T> flow, R r, pr0 pr0Var, x30 x30Var) throws Throwable {
        C02441 c02441;
        Ref$ObjectRef ref$ObjectRef;
        if (x30Var instanceof C02441) {
            c02441 = (C02441) x30Var;
            int i = c02441.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c02441.label = i - Integer.MIN_VALUE;
            } else {
                c02441 = new C02441(x30Var);
            }
        } else {
            c02441 = new C02441(x30Var);
        }
        Object obj = c02441.result;
        Object objD = a.d();
        int i2 = c02441.label;
        if (i2 == 0) {
            d.b(obj);
            Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            ref$ObjectRef2.element = r;
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(ref$ObjectRef2, pr0Var);
            c02441.L$0 = ref$ObjectRef2;
            c02441.label = 1;
            if (flow.collect(anonymousClass2, c02441) == objD) {
                return objD;
            }
            ref$ObjectRef = ref$ObjectRef2;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ref$ObjectRef = (Ref$ObjectRef) c02441.L$0;
            d.b(obj);
        }
        return ref$ObjectRef.element;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T, R> Object fold$$forInline(Flow<? extends T> flow, R r, pr0 pr0Var, x30 x30Var) {
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = r;
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(ref$ObjectRef, pr0Var);
        j21.c(0);
        flow.collect(anonymousClass2, x30Var);
        j21.c(1);
        return ref$ObjectRef.element;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final <T> Object last(Flow<? extends T> flow, x30 x30Var) throws Throwable {
        C02451 c02451;
        Ref$ObjectRef ref$ObjectRef;
        if (x30Var instanceof C02451) {
            c02451 = (C02451) x30Var;
            int i = c02451.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c02451.label = i - Integer.MIN_VALUE;
            } else {
                c02451 = new C02451(x30Var);
            }
        } else {
            c02451 = new C02451(x30Var);
        }
        Object obj = c02451.result;
        Object objD = a.d();
        int i2 = c02451.label;
        if (i2 == 0) {
            d.b(obj);
            final Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            ref$ObjectRef2.element = (T) NullSurrogateKt.NULL;
            FlowCollector<? super Object> flowCollector = new FlowCollector() { // from class: kotlinx.coroutines.flow.FlowKt__ReduceKt.last.2
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(T t, x30 x30Var2) {
                    ref$ObjectRef2.element = t;
                    return k83.a;
                }
            };
            c02451.L$0 = ref$ObjectRef2;
            c02451.label = 1;
            if (flow.collect(flowCollector, c02451) == objD) {
                return objD;
            }
            ref$ObjectRef = ref$ObjectRef2;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ref$ObjectRef = (Ref$ObjectRef) c02451.L$0;
            d.b(obj);
        }
        T t = ref$ObjectRef.element;
        if (t != NullSurrogateKt.NULL) {
            return t;
        }
        throw new NoSuchElementException("Expected at least one element");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final <T> Object lastOrNull(Flow<? extends T> flow, x30 x30Var) throws Throwable {
        C02471 c02471;
        Ref$ObjectRef ref$ObjectRef;
        if (x30Var instanceof C02471) {
            c02471 = (C02471) x30Var;
            int i = c02471.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c02471.label = i - Integer.MIN_VALUE;
            } else {
                c02471 = new C02471(x30Var);
            }
        } else {
            c02471 = new C02471(x30Var);
        }
        Object obj = c02471.result;
        Object objD = a.d();
        int i2 = c02471.label;
        if (i2 == 0) {
            d.b(obj);
            final Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            FlowCollector<? super Object> flowCollector = new FlowCollector() { // from class: kotlinx.coroutines.flow.FlowKt__ReduceKt.lastOrNull.2
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(T t, x30 x30Var2) {
                    ref$ObjectRef2.element = t;
                    return k83.a;
                }
            };
            c02471.L$0 = ref$ObjectRef2;
            c02471.label = 1;
            if (flow.collect(flowCollector, c02471) == objD) {
                return objD;
            }
            ref$ObjectRef = ref$ObjectRef2;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ref$ObjectRef = (Ref$ObjectRef) c02471.L$0;
            d.b(obj);
        }
        return ref$ObjectRef.element;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, kotlinx.coroutines.internal.Symbol] */
    public static final <S, T extends S> Object reduce(Flow<? extends T> flow, pr0 pr0Var, x30 x30Var) throws Throwable {
        C02491 c02491;
        Ref$ObjectRef ref$ObjectRef;
        if (x30Var instanceof C02491) {
            c02491 = (C02491) x30Var;
            int i = c02491.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c02491.label = i - Integer.MIN_VALUE;
            } else {
                c02491 = new C02491(x30Var);
            }
        } else {
            c02491 = new C02491(x30Var);
        }
        Object obj = c02491.result;
        Object objD = a.d();
        int i2 = c02491.label;
        if (i2 == 0) {
            d.b(obj);
            Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            ref$ObjectRef2.element = NullSurrogateKt.NULL;
            C02502 c02502 = new C02502(ref$ObjectRef2, pr0Var);
            c02491.L$0 = ref$ObjectRef2;
            c02491.label = 1;
            if (flow.collect(c02502, c02491) == objD) {
                return objD;
            }
            ref$ObjectRef = ref$ObjectRef2;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ref$ObjectRef = (Ref$ObjectRef) c02491.L$0;
            d.b(obj);
        }
        T t = ref$ObjectRef.element;
        if (t != NullSurrogateKt.NULL) {
            return t;
        }
        throw new NoSuchElementException("Empty flow can't be reduced");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final <T> Object single(Flow<? extends T> flow, x30 x30Var) throws Throwable {
        C02511 c02511;
        Ref$ObjectRef ref$ObjectRef;
        if (x30Var instanceof C02511) {
            c02511 = (C02511) x30Var;
            int i = c02511.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c02511.label = i - Integer.MIN_VALUE;
            } else {
                c02511 = new C02511(x30Var);
            }
        } else {
            c02511 = new C02511(x30Var);
        }
        Object obj = c02511.result;
        Object objD = a.d();
        int i2 = c02511.label;
        if (i2 == 0) {
            d.b(obj);
            final Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            ref$ObjectRef2.element = (T) NullSurrogateKt.NULL;
            FlowCollector<? super Object> flowCollector = new FlowCollector() { // from class: kotlinx.coroutines.flow.FlowKt__ReduceKt.single.2
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(T t, x30 x30Var2) {
                    Ref$ObjectRef<Object> ref$ObjectRef3 = ref$ObjectRef2;
                    if (ref$ObjectRef3.element != NullSurrogateKt.NULL) {
                        throw new IllegalArgumentException("Flow has more than one element");
                    }
                    ref$ObjectRef3.element = t;
                    return k83.a;
                }
            };
            c02511.L$0 = ref$ObjectRef2;
            c02511.label = 1;
            if (flow.collect(flowCollector, c02511) == objD) {
                return objD;
            }
            ref$ObjectRef = ref$ObjectRef2;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ref$ObjectRef = (Ref$ObjectRef) c02511.L$0;
            d.b(obj);
        }
        T t = ref$ObjectRef.element;
        if (t != NullSurrogateKt.NULL) {
            return t;
        }
        throw new NoSuchElementException("Flow is empty");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final <T> Object singleOrNull(Flow<? extends T> flow, x30 x30Var) throws Throwable {
        C02531 c02531;
        Ref$ObjectRef ref$ObjectRef;
        AbortFlowException e;
        FlowCollector<T> flowCollector;
        if (x30Var instanceof C02531) {
            c02531 = (C02531) x30Var;
            int i = c02531.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c02531.label = i - Integer.MIN_VALUE;
            } else {
                c02531 = new C02531(x30Var);
            }
        } else {
            c02531 = new C02531(x30Var);
        }
        Object obj = c02531.result;
        Object objD = a.d();
        int i2 = c02531.label;
        if (i2 == 0) {
            d.b(obj);
            final Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            ref$ObjectRef2.element = (T) NullSurrogateKt.NULL;
            FlowCollector<T> flowCollector2 = new FlowCollector<T>() { // from class: kotlinx.coroutines.flow.FlowKt__ReduceKt$singleOrNull$$inlined$collectWhile$1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public Object emit(T t, x30 x30Var2) {
                    Ref$ObjectRef ref$ObjectRef3 = ref$ObjectRef2;
                    T t2 = ref$ObjectRef3.element;
                    T t3 = (T) NullSurrogateKt.NULL;
                    if (t2 == t3) {
                        ref$ObjectRef3.element = t;
                        return k83.a;
                    }
                    ref$ObjectRef3.element = t3;
                    throw new AbortFlowException(this);
                }
            };
            try {
                c02531.L$0 = ref$ObjectRef2;
                c02531.L$1 = flowCollector2;
                c02531.label = 1;
                if (flow.collect(flowCollector2, c02531) == objD) {
                    return objD;
                }
                ref$ObjectRef = ref$ObjectRef2;
            } catch (AbortFlowException e2) {
                ref$ObjectRef = ref$ObjectRef2;
                e = e2;
                flowCollector = flowCollector2;
                FlowExceptions_commonKt.checkOwnership(e, flowCollector);
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            flowCollector = (FlowKt__ReduceKt$singleOrNull$$inlined$collectWhile$1) c02531.L$1;
            ref$ObjectRef = (Ref$ObjectRef) c02531.L$0;
            try {
                d.b(obj);
            } catch (AbortFlowException e3) {
                e = e3;
                FlowExceptions_commonKt.checkOwnership(e, flowCollector);
            }
        }
        T t = ref$ObjectRef.element;
        if (t == NullSurrogateKt.NULL) {
            return null;
        }
        return t;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final <T> Object first(Flow<? extends T> flow, or0 or0Var, x30 x30Var) throws Throwable {
        AnonymousClass3 anonymousClass3;
        or0 or0Var2;
        Ref$ObjectRef ref$ObjectRef;
        AbortFlowException e;
        FlowKt__ReduceKt$first$$inlined$collectWhile$2 flowKt__ReduceKt$first$$inlined$collectWhile$2;
        if (x30Var instanceof AnonymousClass3) {
            anonymousClass3 = (AnonymousClass3) x30Var;
            int i = anonymousClass3.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass3.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass3 = new AnonymousClass3(x30Var);
            }
        } else {
            anonymousClass3 = new AnonymousClass3(x30Var);
        }
        Object obj = anonymousClass3.result;
        Object objD = a.d();
        int i2 = anonymousClass3.label;
        if (i2 == 0) {
            d.b(obj);
            Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            ref$ObjectRef2.element = (T) NullSurrogateKt.NULL;
            FlowKt__ReduceKt$first$$inlined$collectWhile$2 flowKt__ReduceKt$first$$inlined$collectWhile$3 = new FlowKt__ReduceKt$first$$inlined$collectWhile$2(or0Var, ref$ObjectRef2);
            try {
                anonymousClass3.L$0 = or0Var;
                anonymousClass3.L$1 = ref$ObjectRef2;
                anonymousClass3.L$2 = flowKt__ReduceKt$first$$inlined$collectWhile$3;
                anonymousClass3.label = 1;
                if (flow.collect(flowKt__ReduceKt$first$$inlined$collectWhile$3, anonymousClass3) == objD) {
                    return objD;
                }
                or0Var2 = or0Var;
                ref$ObjectRef = ref$ObjectRef2;
            } catch (AbortFlowException e2) {
                or0Var2 = or0Var;
                ref$ObjectRef = ref$ObjectRef2;
                e = e2;
                flowKt__ReduceKt$first$$inlined$collectWhile$2 = flowKt__ReduceKt$first$$inlined$collectWhile$3;
                FlowExceptions_commonKt.checkOwnership(e, flowKt__ReduceKt$first$$inlined$collectWhile$2);
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            flowKt__ReduceKt$first$$inlined$collectWhile$2 = (FlowKt__ReduceKt$first$$inlined$collectWhile$2) anonymousClass3.L$2;
            ref$ObjectRef = (Ref$ObjectRef) anonymousClass3.L$1;
            or0Var2 = (or0) anonymousClass3.L$0;
            try {
                d.b(obj);
            } catch (AbortFlowException e3) {
                e = e3;
                FlowExceptions_commonKt.checkOwnership(e, flowKt__ReduceKt$first$$inlined$collectWhile$2);
            }
        }
        T t = ref$ObjectRef.element;
        if (t != NullSurrogateKt.NULL) {
            return t;
        }
        throw new NoSuchElementException("Expected at least one element matching the predicate " + or0Var2);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final <T> Object firstOrNull(Flow<? extends T> flow, or0 or0Var, x30 x30Var) throws Throwable {
        C02433 c02433;
        Ref$ObjectRef ref$ObjectRef;
        AbortFlowException e;
        FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2 flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2;
        if (x30Var instanceof C02433) {
            c02433 = (C02433) x30Var;
            int i = c02433.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c02433.label = i - Integer.MIN_VALUE;
            } else {
                c02433 = new C02433(x30Var);
            }
        } else {
            c02433 = new C02433(x30Var);
        }
        Object obj = c02433.result;
        Object objD = a.d();
        int i2 = c02433.label;
        if (i2 == 0) {
            d.b(obj);
            Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2 flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$3 = new FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2(or0Var, ref$ObjectRef2);
            try {
                c02433.L$0 = ref$ObjectRef2;
                c02433.L$1 = flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$3;
                c02433.label = 1;
                if (flow.collect(flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$3, c02433) == objD) {
                    return objD;
                }
                ref$ObjectRef = ref$ObjectRef2;
            } catch (AbortFlowException e2) {
                ref$ObjectRef = ref$ObjectRef2;
                e = e2;
                flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2 = flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$3;
                FlowExceptions_commonKt.checkOwnership(e, flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2);
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2 = (FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2) c02433.L$1;
            ref$ObjectRef = (Ref$ObjectRef) c02433.L$0;
            try {
                d.b(obj);
            } catch (AbortFlowException e3) {
                e = e3;
                FlowExceptions_commonKt.checkOwnership(e, flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2);
            }
        }
        return ref$ObjectRef.element;
    }
}
