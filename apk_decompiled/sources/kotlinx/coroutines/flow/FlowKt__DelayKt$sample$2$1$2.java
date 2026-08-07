package kotlinx.coroutines.flow;

import defpackage.h70;
import defpackage.k83;
import defpackage.or0;
import defpackage.x30;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;

/* JADX INFO: loaded from: classes4.dex */
@h70(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$1$2", f = "Delay.kt", l = {299}, m = "invokeSuspend")
final class FlowKt__DelayKt$sample$2$1$2 extends SuspendLambda implements or0 {
    final /* synthetic */ FlowCollector<T> $downstream;
    final /* synthetic */ Ref$ObjectRef<Object> $lastValue;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    FlowKt__DelayKt$sample$2$1$2(Ref$ObjectRef<Object> ref$ObjectRef, FlowCollector<? super T> flowCollector, x30 x30Var) {
        super(2, x30Var);
        this.$lastValue = ref$ObjectRef;
        this.$downstream = flowCollector;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(Object obj, x30 x30Var) {
        return new FlowKt__DelayKt$sample$2$1$2(this.$lastValue, this.$downstream, x30Var);
    }

    @Override // defpackage.or0
    public final Object invoke(k83 k83Var, x30 x30Var) {
        return ((FlowKt__DelayKt$sample$2$1$2) create(k83Var, x30Var)).invokeSuspend(k83.a);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objD = a.d();
        int i = this.label;
        if (i == 0) {
            d.b(obj);
            Ref$ObjectRef<Object> ref$ObjectRef = this.$lastValue;
            Object obj2 = ref$ObjectRef.element;
            if (obj2 == null) {
                return k83.a;
            }
            ref$ObjectRef.element = null;
            FlowCollector<T> flowCollector = this.$downstream;
            if (obj2 == NullSurrogateKt.NULL) {
                obj2 = null;
            }
            this.label = 1;
            if (flowCollector.emit((T) obj2, this) == objD) {
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
}
