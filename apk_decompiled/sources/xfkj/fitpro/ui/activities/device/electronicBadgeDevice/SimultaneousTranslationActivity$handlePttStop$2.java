package xfkj.fitpro.ui.activities.device.electronicBadgeDevice;

import defpackage.h70;
import defpackage.k83;
import defpackage.or0;
import defpackage.x30;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes4.dex */
@h70(c = "xfkj.fitpro.ui.activities.device.electronicBadgeDevice.SimultaneousTranslationActivity$handlePttStop$2", f = "SimultaneousTranslationActivity.kt", l = {}, m = "invokeSuspend")
final class SimultaneousTranslationActivity$handlePttStop$2 extends SuspendLambda implements or0 {
    final /* synthetic */ boolean $fromUserRelease;
    int label;
    final /* synthetic */ SimultaneousTranslationActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SimultaneousTranslationActivity$handlePttStop$2(SimultaneousTranslationActivity simultaneousTranslationActivity, boolean z, x30 x30Var) {
        super(2, x30Var);
        this.this$0 = simultaneousTranslationActivity;
        this.$fromUserRelease = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(Object obj, x30 x30Var) {
        return new SimultaneousTranslationActivity$handlePttStop$2(this.this$0, this.$fromUserRelease, x30Var);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        kotlin.coroutines.intrinsics.a.d();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        kotlin.d.b(obj);
        this.this$0.x = false;
        if (!this.this$0.z) {
            this.this$0.x2();
        }
        if (this.$fromUserRelease) {
            this.this$0.m2();
        }
        return k83.a;
    }

    @Override // defpackage.or0
    public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
        return ((SimultaneousTranslationActivity$handlePttStop$2) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
    }
}
