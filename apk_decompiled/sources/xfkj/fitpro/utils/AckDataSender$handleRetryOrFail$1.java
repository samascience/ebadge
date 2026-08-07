package xfkj.fitpro.utils;

import defpackage.h70;
import defpackage.x30;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes4.dex */
@h70(c = "xfkj.fitpro.utils.AckDataSender", f = "AckDataSender.kt", l = {307, 308}, m = "handleRetryOrFail")
final class AckDataSender$handleRetryOrFail$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ a this$0;

    AckDataSender$handleRetryOrFail$1(a aVar, x30 x30Var) {
        super(x30Var);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return a.d(null, 0, 0, 0L, null, null, null, this);
    }
}
