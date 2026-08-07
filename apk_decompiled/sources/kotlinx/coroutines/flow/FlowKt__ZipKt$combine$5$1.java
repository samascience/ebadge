package kotlinx.coroutines.flow;

import defpackage.p31;
import defpackage.yq0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes4.dex */
final class FlowKt__ZipKt$combine$5$1 extends Lambda implements yq0 {
    final /* synthetic */ Flow<T>[] $flows;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__ZipKt$combine$5$1(Flow<? extends T>[] flowArr) {
        super(0);
        this.$flows = flowArr;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [T[], java.lang.Object[]] */
    @Override // defpackage.yq0
    public final T[] invoke() {
        int length = this.$flows.length;
        p31.k(0, "T?");
        return new Object[length];
    }
}
