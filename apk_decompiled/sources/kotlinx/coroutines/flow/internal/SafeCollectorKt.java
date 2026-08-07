package kotlinx.coroutines.flow.internal;

import defpackage.p31;
import defpackage.p63;
import defpackage.pr0;

/* JADX INFO: loaded from: classes4.dex */
public final class SafeCollectorKt {
    private static final pr0 emitFun;

    static {
        SafeCollectorKt$emitFun$1 safeCollectorKt$emitFun$1 = SafeCollectorKt$emitFun$1.INSTANCE;
        p31.d(safeCollectorKt$emitFun$1, "null cannot be cast to non-null type kotlin.Function3<kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>, kotlin.Any?, kotlin.coroutines.Continuation<kotlin.Unit>, kotlin.Any?>");
        emitFun = (pr0) p63.a(safeCollectorKt$emitFun$1, 3);
    }

    private static /* synthetic */ void getEmitFun$annotations() {
    }
}
