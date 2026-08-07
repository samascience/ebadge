package kotlinx.coroutines.flow;

import defpackage.ar0;
import defpackage.or0;
import defpackage.p31;
import defpackage.p63;

/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class FlowKt__DistinctKt {
    private static final ar0 defaultKeySelector = new ar0() { // from class: kotlinx.coroutines.flow.FlowKt__DistinctKt$defaultKeySelector$1
        @Override // defpackage.ar0
        public final Object invoke(Object obj) {
            return obj;
        }
    };
    private static final or0 defaultAreEquivalent = new or0() { // from class: kotlinx.coroutines.flow.FlowKt__DistinctKt$defaultAreEquivalent$1
        @Override // defpackage.or0
        public final Boolean invoke(Object obj, Object obj2) {
            return Boolean.valueOf(p31.a(obj, obj2));
        }
    };

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Flow<T> distinctUntilChanged(Flow<? extends T> flow) {
        return flow instanceof StateFlow ? flow : distinctUntilChangedBy$FlowKt__DistinctKt(flow, defaultKeySelector, defaultAreEquivalent);
    }

    public static final <T, K> Flow<T> distinctUntilChangedBy(Flow<? extends T> flow, ar0 ar0Var) {
        return distinctUntilChangedBy$FlowKt__DistinctKt(flow, ar0Var, defaultAreEquivalent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> Flow<T> distinctUntilChangedBy$FlowKt__DistinctKt(Flow<? extends T> flow, ar0 ar0Var, or0 or0Var) {
        if (flow instanceof DistinctFlowImpl) {
            DistinctFlowImpl distinctFlowImpl = (DistinctFlowImpl) flow;
            if (distinctFlowImpl.keySelector == ar0Var && distinctFlowImpl.areEquivalent == or0Var) {
                return flow;
            }
        }
        return new DistinctFlowImpl(flow, ar0Var, or0Var);
    }

    public static final <T> Flow<T> distinctUntilChanged(Flow<? extends T> flow, or0 or0Var) {
        ar0 ar0Var = defaultKeySelector;
        p31.d(or0Var, "null cannot be cast to non-null type kotlin.Function2<kotlin.Any?, kotlin.Any?, kotlin.Boolean>");
        return distinctUntilChangedBy$FlowKt__DistinctKt(flow, ar0Var, (or0) p63.a(or0Var, 2));
    }
}
