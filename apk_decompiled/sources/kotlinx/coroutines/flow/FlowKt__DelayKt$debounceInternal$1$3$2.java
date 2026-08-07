package kotlinx.coroutines.flow;

import com.jieli.jl_rcsp.constant.Command;
import defpackage.h70;
import defpackage.k83;
import defpackage.or0;
import defpackage.x30;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;

/* JADX INFO: loaded from: classes4.dex */
@h70(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$2", f = "Delay.kt", l = {Command.CMD_NOTIFY_FILE_STRUCTURE_CHANGE}, m = "invokeSuspend")
final class FlowKt__DelayKt$debounceInternal$1$3$2 extends SuspendLambda implements or0 {
    final /* synthetic */ FlowCollector<T> $downstream;
    final /* synthetic */ Ref$ObjectRef<Object> $lastValue;
    /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    FlowKt__DelayKt$debounceInternal$1$3$2(Ref$ObjectRef<Object> ref$ObjectRef, FlowCollector<? super T> flowCollector, x30 x30Var) {
        super(2, x30Var);
        this.$lastValue = ref$ObjectRef;
        this.$downstream = flowCollector;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(Object obj, x30 x30Var) {
        FlowKt__DelayKt$debounceInternal$1$3$2 flowKt__DelayKt$debounceInternal$1$3$2 = new FlowKt__DelayKt$debounceInternal$1$3$2(this.$lastValue, this.$downstream, x30Var);
        flowKt__DelayKt$debounceInternal$1$3$2.L$0 = obj;
        return flowKt__DelayKt$debounceInternal$1$3$2;
    }

    @Override // defpackage.or0
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return m131invokeWpGqRn0(((ChannelResult) obj).m114unboximpl(), (x30) obj2);
    }

    /* JADX INFO: renamed from: invoke-WpGqRn0, reason: not valid java name */
    public final Object m131invokeWpGqRn0(Object obj, x30 x30Var) {
        return ((FlowKt__DelayKt$debounceInternal$1$3$2) create(ChannelResult.m102boximpl(obj), x30Var)).invokeSuspend(k83.a);
    }

    /* JADX WARN: Type inference failed for: r7v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Ref$ObjectRef<Object> ref$ObjectRef;
        Ref$ObjectRef<Object> ref$ObjectRef2;
        Object objD = a.d();
        int i = this.label;
        if (i == 0) {
            d.b(obj);
            ?? M114unboximpl = ((ChannelResult) this.L$0).m114unboximpl();
            ref$ObjectRef = this.$lastValue;
            boolean z = M114unboximpl instanceof ChannelResult.Failed;
            if (!z) {
                ref$ObjectRef.element = M114unboximpl;
            }
            FlowCollector<T> flowCollector = this.$downstream;
            if (z) {
                Throwable thM106exceptionOrNullimpl = ChannelResult.m106exceptionOrNullimpl(M114unboximpl);
                if (thM106exceptionOrNullimpl != null) {
                    throw thM106exceptionOrNullimpl;
                }
                Object obj2 = ref$ObjectRef.element;
                if (obj2 != null) {
                    if (obj2 == NullSurrogateKt.NULL) {
                        obj2 = null;
                    }
                    this.L$0 = M114unboximpl;
                    this.L$1 = ref$ObjectRef;
                    this.label = 1;
                    if (flowCollector.emit((T) obj2, this) == objD) {
                        return objD;
                    }
                    ref$ObjectRef2 = ref$ObjectRef;
                }
                ref$ObjectRef.element = NullSurrogateKt.DONE;
            }
            return k83.a;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ref$ObjectRef2 = (Ref$ObjectRef) this.L$1;
        d.b(obj);
        ref$ObjectRef = ref$ObjectRef2;
        ref$ObjectRef.element = NullSurrogateKt.DONE;
        return k83.a;
    }
}
