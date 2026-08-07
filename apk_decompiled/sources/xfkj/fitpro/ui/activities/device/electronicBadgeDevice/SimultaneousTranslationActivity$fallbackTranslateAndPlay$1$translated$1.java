package xfkj.fitpro.ui.activities.device.electronicBadgeDevice;

import defpackage.h70;
import defpackage.k83;
import defpackage.or0;
import defpackage.x30;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes4.dex */
@h70(c = "xfkj.fitpro.ui.activities.device.electronicBadgeDevice.SimultaneousTranslationActivity$fallbackTranslateAndPlay$1$translated$1", f = "SimultaneousTranslationActivity.kt", l = {}, m = "invokeSuspend")
final class SimultaneousTranslationActivity$fallbackTranslateAndPlay$1$translated$1 extends SuspendLambda implements or0 {
    final /* synthetic */ String $source;
    final /* synthetic */ String $target;
    final /* synthetic */ String $text;
    int label;
    final /* synthetic */ SimultaneousTranslationActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SimultaneousTranslationActivity$fallbackTranslateAndPlay$1$translated$1(SimultaneousTranslationActivity simultaneousTranslationActivity, String str, String str2, String str3, x30 x30Var) {
        super(2, x30Var);
        this.this$0 = simultaneousTranslationActivity;
        this.$text = str;
        this.$source = str2;
        this.$target = str3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(Object obj, x30 x30Var) {
        return new SimultaneousTranslationActivity$fallbackTranslateAndPlay$1$translated$1(this.this$0, this.$text, this.$source, this.$target, x30Var);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        kotlin.coroutines.intrinsics.a.d();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        kotlin.d.b(obj);
        return this.this$0.c3(this.$text, this.$source, this.$target);
    }

    @Override // defpackage.or0
    public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
        return ((SimultaneousTranslationActivity$fallbackTranslateAndPlay$1$translated$1) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
    }
}
