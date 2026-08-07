package kotlinx.coroutines.flow;

import defpackage.ar0;
import defpackage.h70;
import defpackage.k83;
import defpackage.x30;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.internal.Symbol;

/* JADX INFO: loaded from: classes4.dex */
@h70(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$1", f = "Delay.kt", l = {232}, m = "invokeSuspend")
final class FlowKt__DelayKt$debounceInternal$1$3$1 extends SuspendLambda implements ar0 {
    final /* synthetic */ FlowCollector<T> $downstream;
    final /* synthetic */ Ref$ObjectRef<Object> $lastValue;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    FlowKt__DelayKt$debounceInternal$1$3$1(FlowCollector<? super T> flowCollector, Ref$ObjectRef<Object> ref$ObjectRef, x30 x30Var) {
        super(1, x30Var);
        this.$downstream = flowCollector;
        this.$lastValue = ref$ObjectRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(x30 x30Var) {
        return new FlowKt__DelayKt$debounceInternal$1$3$1(this.$downstream, this.$lastValue, x30Var);
    }

    @Override // defpackage.ar0
    public final Object invoke(x30 x30Var) {
        return ((FlowKt__DelayKt$debounceInternal$1$3$1) create(x30Var)).invokeSuspend(k83.a);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objD = a.d();
        int i = this.label;
        if (i == 0) {
            d.b(obj);
            FlowCollector<T> flowCollector = this.$downstream;
            Symbol symbol = NullSurrogateKt.NULL;
            Object obj2 = this.$lastValue.element;
            if (obj2 == symbol) {
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
        this.$lastValue.element = null;
        return k83.a;
    }
}
