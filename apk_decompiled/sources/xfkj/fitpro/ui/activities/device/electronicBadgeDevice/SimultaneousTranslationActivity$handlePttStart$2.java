package xfkj.fitpro.ui.activities.device.electronicBadgeDevice;

import com.blankj.utilcode.util.ToastUtils;
import com.legend.smartwatch.electronicbadge.android.R;
import defpackage.h70;
import defpackage.k83;
import defpackage.or0;
import defpackage.x30;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes4.dex */
@h70(c = "xfkj.fitpro.ui.activities.device.electronicBadgeDevice.SimultaneousTranslationActivity$handlePttStart$2", f = "SimultaneousTranslationActivity.kt", l = {}, m = "invokeSuspend")
final class SimultaneousTranslationActivity$handlePttStart$2 extends SuspendLambda implements or0 {
    final /* synthetic */ boolean $success;
    int label;
    final /* synthetic */ SimultaneousTranslationActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SimultaneousTranslationActivity$handlePttStart$2(boolean z, SimultaneousTranslationActivity simultaneousTranslationActivity, x30 x30Var) {
        super(2, x30Var);
        this.$success = z;
        this.this$0 = simultaneousTranslationActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(Object obj, x30 x30Var) {
        return new SimultaneousTranslationActivity$handlePttStart$2(this.$success, this.this$0, x30Var);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        kotlin.coroutines.intrinsics.a.d();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        kotlin.d.b(obj);
        if (this.$success) {
            this.this$0.x = true;
            return k83.a;
        }
        ToastUtils.v(this.this$0.getString(R.string.simultaneous_translation_start_failed), new Object[0]);
        if (!this.this$0.z) {
            this.this$0.x2();
        }
        return k83.a;
    }

    @Override // defpackage.or0
    public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
        return ((SimultaneousTranslationActivity$handlePttStart$2) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
    }
}
