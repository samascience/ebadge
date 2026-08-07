package xfkj.fitpro.ui.activities.device.electronicBadgeDevice;

import defpackage.h70;
import defpackage.x30;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes4.dex */
@h70(c = "xfkj.fitpro.ui.activities.device.electronicBadgeDevice.SimultaneousTranslationActivity", f = "SimultaneousTranslationActivity.kt", l = {1016, 1018, 1019}, m = "handlePttStart")
final class SimultaneousTranslationActivity$handlePttStart$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SimultaneousTranslationActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SimultaneousTranslationActivity$handlePttStart$1(SimultaneousTranslationActivity simultaneousTranslationActivity, x30 x30Var) {
        super(x30Var);
        this.this$0 = simultaneousTranslationActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.X1(this);
    }
}
