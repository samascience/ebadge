package kotlinx.coroutines.flow;

import defpackage.h70;
import defpackage.k83;
import defpackage.pr0;
import defpackage.x30;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.d;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: loaded from: classes4.dex */
public final class FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1<R> implements Flow<R> {
    final /* synthetic */ Object $initial$inlined;
    final /* synthetic */ pr0 $operation$inlined;
    final /* synthetic */ Flow $this_runningFold$inlined;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1$1, reason: invalid class name */
    @h70(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1", f = "Transform.kt", l = {115, 116}, m = "collect")
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(x30 x30Var) {
            super(x30Var);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1.this.collect(null, this);
        }
    }

    public FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1(Object obj, Flow flow, pr0 pr0Var) {
        this.$initial$inlined = obj;
        this.$this_runningFold$inlined = flow;
        this.$operation$inlined = pr0Var;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.Object] */
    @Override // kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector<? super R> flowCollector, x30 x30Var) throws Throwable {
        AnonymousClass1 anonymousClass1;
        FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1<R> flowKt__TransformKt$runningFold$$inlined$unsafeFlow$1;
        FlowCollector<? super R> flowCollector2;
        Ref$ObjectRef ref$ObjectRef;
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
        if (i2 != 0) {
            if (i2 == 1) {
                ref$ObjectRef = (Ref$ObjectRef) anonymousClass1.L$2;
                flowCollector2 = (FlowCollector) anonymousClass1.L$1;
                flowKt__TransformKt$runningFold$$inlined$unsafeFlow$1 = (FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1) anonymousClass1.L$0;
                d.b(obj);
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d.b(obj);
            }
            return k83.a;
        }
        d.b(obj);
        Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
        ?? r2 = (Object) this.$initial$inlined;
        ref$ObjectRef2.element = r2;
        anonymousClass1.L$0 = this;
        anonymousClass1.L$1 = flowCollector;
        anonymousClass1.L$2 = ref$ObjectRef2;
        anonymousClass1.label = 1;
        if (flowCollector.emit(r2, anonymousClass1) == objD) {
            return objD;
        }
        flowKt__TransformKt$runningFold$$inlined$unsafeFlow$1 = this;
        flowCollector2 = flowCollector;
        ref$ObjectRef = ref$ObjectRef2;
        Flow flow = flowKt__TransformKt$runningFold$$inlined$unsafeFlow$1.$this_runningFold$inlined;
        FlowKt__TransformKt$runningFold$1$1 flowKt__TransformKt$runningFold$1$1 = new FlowKt__TransformKt$runningFold$1$1(ref$ObjectRef, flowKt__TransformKt$runningFold$$inlined$unsafeFlow$1.$operation$inlined, flowCollector2);
        anonymousClass1.L$0 = null;
        anonymousClass1.L$1 = null;
        anonymousClass1.L$2 = null;
        anonymousClass1.label = 2;
        if (flow.collect(flowKt__TransformKt$runningFold$1$1, anonymousClass1) == objD) {
            return objD;
        }
        return k83.a;
    }
}
