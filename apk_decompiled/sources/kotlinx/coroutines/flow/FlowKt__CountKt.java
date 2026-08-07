package kotlinx.coroutines.flow;

import defpackage.h70;
import defpackage.jn;
import defpackage.k83;
import defpackage.or0;
import defpackage.x30;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.d;
import kotlin.jvm.internal.Ref$IntRef;

/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class FlowKt__CountKt {

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__CountKt$count$1, reason: invalid class name */
    @h70(c = "kotlinx.coroutines.flow.FlowKt__CountKt", f = "Count.kt", l = {17}, m = "count")
    static final class AnonymousClass1<T> extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(x30 x30Var) {
            super(x30Var);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt.count(null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__CountKt$count$3, reason: invalid class name */
    @h70(c = "kotlinx.coroutines.flow.FlowKt__CountKt", f = "Count.kt", l = {29}, m = "count")
    static final class AnonymousClass3<T> extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass3(x30 x30Var) {
            super(x30Var);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt.count(null, null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__CountKt$count$4, reason: invalid class name */
    static final class AnonymousClass4<T> implements FlowCollector {
        final /* synthetic */ Ref$IntRef $i;
        final /* synthetic */ or0 $predicate;

        AnonymousClass4(or0 or0Var, Ref$IntRef ref$IntRef) {
            this.$predicate = or0Var;
            this.$i = ref$IntRef;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(T t, x30 x30Var) throws Throwable {
            FlowKt__CountKt$count$4$emit$1 flowKt__CountKt$count$4$emit$1;
            AnonymousClass4<T> anonymousClass4;
            if (x30Var instanceof FlowKt__CountKt$count$4$emit$1) {
                flowKt__CountKt$count$4$emit$1 = (FlowKt__CountKt$count$4$emit$1) x30Var;
                int i = flowKt__CountKt$count$4$emit$1.label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    flowKt__CountKt$count$4$emit$1.label = i - Integer.MIN_VALUE;
                } else {
                    flowKt__CountKt$count$4$emit$1 = new FlowKt__CountKt$count$4$emit$1(this, x30Var);
                }
            } else {
                flowKt__CountKt$count$4$emit$1 = new FlowKt__CountKt$count$4$emit$1(this, x30Var);
            }
            Object objInvoke = flowKt__CountKt$count$4$emit$1.result;
            Object objD = a.d();
            int i2 = flowKt__CountKt$count$4$emit$1.label;
            if (i2 == 0) {
                d.b(objInvoke);
                or0 or0Var = this.$predicate;
                flowKt__CountKt$count$4$emit$1.L$0 = this;
                flowKt__CountKt$count$4$emit$1.label = 1;
                objInvoke = or0Var.invoke(t, flowKt__CountKt$count$4$emit$1);
                if (objInvoke == objD) {
                    return objD;
                }
                anonymousClass4 = this;
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                anonymousClass4 = (AnonymousClass4) flowKt__CountKt$count$4$emit$1.L$0;
                d.b(objInvoke);
            }
            if (((Boolean) objInvoke).booleanValue()) {
                anonymousClass4.$i.element++;
            }
            return k83.a;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final <T> Object count(Flow<? extends T> flow, x30 x30Var) throws Throwable {
        AnonymousClass1 anonymousClass1;
        Ref$IntRef ref$IntRef;
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
            final Ref$IntRef ref$IntRef2 = new Ref$IntRef();
            FlowCollector<? super Object> flowCollector = new FlowCollector() { // from class: kotlinx.coroutines.flow.FlowKt__CountKt.count.2
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(T t, x30 x30Var2) {
                    ref$IntRef2.element++;
                    return k83.a;
                }
            };
            anonymousClass1.L$0 = ref$IntRef2;
            anonymousClass1.label = 1;
            if (flow.collect(flowCollector, anonymousClass1) == objD) {
                return objD;
            }
            ref$IntRef = ref$IntRef2;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ref$IntRef = (Ref$IntRef) anonymousClass1.L$0;
            d.b(obj);
        }
        return jn.b(ref$IntRef.element);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final <T> Object count(Flow<? extends T> flow, or0 or0Var, x30 x30Var) throws Throwable {
        AnonymousClass3 anonymousClass3;
        Ref$IntRef ref$IntRef;
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
            Ref$IntRef ref$IntRef2 = new Ref$IntRef();
            AnonymousClass4 anonymousClass4 = new AnonymousClass4(or0Var, ref$IntRef2);
            anonymousClass3.L$0 = ref$IntRef2;
            anonymousClass3.label = 1;
            if (flow.collect(anonymousClass4, anonymousClass3) == objD) {
                return objD;
            }
            ref$IntRef = ref$IntRef2;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ref$IntRef = (Ref$IntRef) anonymousClass3.L$0;
            d.b(obj);
        }
        return jn.b(ref$IntRef.element);
    }
}
