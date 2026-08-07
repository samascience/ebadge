package kotlinx.coroutines.flow;

import defpackage.k83;
import defpackage.or0;
import defpackage.x30;
import kotlin.coroutines.intrinsics.a;

/* JADX INFO: loaded from: classes4.dex */
final class SafeFlow<T> extends AbstractFlow<T> {
    private final or0 block;

    public SafeFlow(or0 or0Var) {
        this.block = or0Var;
    }

    @Override // kotlinx.coroutines.flow.AbstractFlow
    public Object collectSafely(FlowCollector<? super T> flowCollector, x30 x30Var) {
        Object objInvoke = this.block.invoke(flowCollector, x30Var);
        return objInvoke == a.d() ? objInvoke : k83.a;
    }
}
