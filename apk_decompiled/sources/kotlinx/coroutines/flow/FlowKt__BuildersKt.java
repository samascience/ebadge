package kotlinx.coroutines.flow;

import defpackage.ar0;
import defpackage.e31;
import defpackage.k83;
import defpackage.or0;
import defpackage.rm2;
import defpackage.x30;
import defpackage.xd1;
import defpackage.yq0;
import java.util.Iterator;
import kotlin.coroutines.intrinsics.a;

/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class FlowKt__BuildersKt {
    public static final <T> Flow<T> asFlow(final yq0 yq0Var) {
        return new Flow<T>() { // from class: kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$1
            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super T> flowCollector, x30 x30Var) {
                Object objEmit = flowCollector.emit(yq0Var.invoke(), x30Var);
                return objEmit == a.d() ? objEmit : k83.a;
            }
        };
    }

    public static final <T> Flow<T> callbackFlow(or0 or0Var) {
        return new CallbackFlowBuilder(or0Var, null, 0, null, 14, null);
    }

    public static final <T> Flow<T> channelFlow(or0 or0Var) {
        return new ChannelFlowBuilder(or0Var, null, 0, null, 14, null);
    }

    public static final <T> Flow<T> emptyFlow() {
        return EmptyFlow.INSTANCE;
    }

    public static final <T> Flow<T> flow(or0 or0Var) {
        return new SafeFlow(or0Var);
    }

    public static final <T> Flow<T> flowOf(T... tArr) {
        return new FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1(tArr);
    }

    public static final <T> Flow<T> asFlow(ar0 ar0Var) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2(ar0Var);
    }

    public static final <T> Flow<T> flowOf(final T t) {
        return new Flow<T>() { // from class: kotlinx.coroutines.flow.FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$2
            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super T> flowCollector, x30 x30Var) {
                Object objEmit = flowCollector.emit((Object) t, x30Var);
                return objEmit == a.d() ? objEmit : k83.a;
            }
        };
    }

    public static final <T> Flow<T> asFlow(Iterable<? extends T> iterable) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3(iterable);
    }

    public static final <T> Flow<T> asFlow(Iterator<? extends T> it) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$4(it);
    }

    public static final <T> Flow<T> asFlow(rm2 rm2Var) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$5(rm2Var);
    }

    public static final <T> Flow<T> asFlow(T[] tArr) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$6(tArr);
    }

    public static final Flow<Integer> asFlow(int[] iArr) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$7(iArr);
    }

    public static final Flow<Long> asFlow(long[] jArr) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8(jArr);
    }

    public static final Flow<Integer> asFlow(e31 e31Var) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$9(e31Var);
    }

    public static final Flow<Long> asFlow(xd1 xd1Var) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$10(xd1Var);
    }
}
