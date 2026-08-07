package xfkj.fitpro.ui.activities.device.electronicBadgeDevice;

import defpackage.h70;
import defpackage.k83;
import defpackage.or0;
import defpackage.x30;
import defpackage.yq0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes4.dex */
@h70(c = "xfkj.fitpro.ui.activities.device.electronicBadgeDevice.SimultaneousTranslationActivity$handlePttStop$3", f = "SimultaneousTranslationActivity.kt", l = {}, m = "invokeSuspend")
final class SimultaneousTranslationActivity$handlePttStop$3 extends SuspendLambda implements or0 {
    final /* synthetic */ yq0 $onStopped;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SimultaneousTranslationActivity$handlePttStop$3(yq0 yq0Var, x30 x30Var) {
        super(2, x30Var);
        this.$onStopped = yq0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(Object obj, x30 x30Var) {
        return new SimultaneousTranslationActivity$handlePttStop$3(this.$onStopped, x30Var);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        kotlin.coroutines.intrinsics.a.d();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        kotlin.d.b(obj);
        yq0 yq0Var = this.$onStopped;
        if (yq0Var == null) {
            return null;
        }
        yq0Var.invoke();
        return k83.a;
    }

    @Override // defpackage.or0
    public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
        return ((SimultaneousTranslationActivity$handlePttStop$3) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
    }
}
