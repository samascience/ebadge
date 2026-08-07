package kotlinx.coroutines.flow;

import defpackage.p31;
import defpackage.yq0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes4.dex */
final class FlowKt__ZipKt$combine$6$1 extends Lambda implements yq0 {
    final /* synthetic */ Flow<T>[] $flowArray;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__ZipKt$combine$6$1(Flow<T>[] flowArr) {
        super(0);
        this.$flowArray = flowArr;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [T[], java.lang.Object[]] */
    @Override // defpackage.yq0
    public final T[] invoke() {
        int length = this.$flowArray.length;
        p31.k(0, "T?");
        return new Object[length];
    }
}
