package xfkj.fitpro.ui.activities.device.electronicBadgeDevice;

import android.util.Log;
import defpackage.h70;
import defpackage.jn;
import defpackage.k83;
import defpackage.or0;
import defpackage.p31;
import defpackage.x30;
import kotlin.UninitializedPropertyAccessException;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: classes4.dex */
@h70(c = "xfkj.fitpro.ui.activities.device.electronicBadgeDevice.SimultaneousTranslationActivity$runTranslatorStopBlocking$2", f = "SimultaneousTranslationActivity.kt", l = {1034}, m = "invokeSuspend")
final class SimultaneousTranslationActivity$runTranslatorStopBlocking$2 extends SuspendLambda implements or0 {
    int label;
    final /* synthetic */ SimultaneousTranslationActivity this$0;

    /* JADX INFO: renamed from: xfkj.fitpro.ui.activities.device.electronicBadgeDevice.SimultaneousTranslationActivity$runTranslatorStopBlocking$2$1, reason: invalid class name */
    @h70(c = "xfkj.fitpro.ui.activities.device.electronicBadgeDevice.SimultaneousTranslationActivity$runTranslatorStopBlocking$2$1", f = "SimultaneousTranslationActivity.kt", l = {1036}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements or0 {
        int label;
        final /* synthetic */ SimultaneousTranslationActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(SimultaneousTranslationActivity simultaneousTranslationActivity, x30 x30Var) {
            super(2, x30Var);
            this.this$0 = simultaneousTranslationActivity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final x30 create(Object obj, x30 x30Var) {
            return new AnonymousClass1(this.this$0, x30Var);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = kotlin.coroutines.intrinsics.a.d();
            int i = this.label;
            try {
                if (i == 0) {
                    kotlin.d.b(obj);
                    SimultaneousTranslator simultaneousTranslator = this.this$0.r;
                    if (simultaneousTranslator == null) {
                        p31.t("translator");
                        simultaneousTranslator = null;
                    }
                    this.label = 1;
                    if (simultaneousTranslator.z(this) == objD) {
                        return objD;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    kotlin.d.b(obj);
                }
                return k83.a;
            } catch (UninitializedPropertyAccessException e) {
                return jn.b(Log.e(this.this$0.K(), "translator未初始化: " + e.getMessage()));
            } catch (Exception e2) {
                return jn.b(Log.e(this.this$0.K(), "停止翻译失败: " + e2.getMessage()));
            }
        }

        @Override // defpackage.or0
        public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
            return ((AnonymousClass1) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SimultaneousTranslationActivity$runTranslatorStopBlocking$2(SimultaneousTranslationActivity simultaneousTranslationActivity, x30 x30Var) {
        super(2, x30Var);
        this.this$0 = simultaneousTranslationActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(Object obj, x30 x30Var) {
        return new SimultaneousTranslationActivity$runTranslatorStopBlocking$2(this.this$0, x30Var);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objD = kotlin.coroutines.intrinsics.a.d();
        int i = this.label;
        if (i == 0) {
            kotlin.d.b(obj);
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, null);
            this.label = 1;
            obj = TimeoutKt.withTimeoutOrNull(5000L, anonymousClass1, this);
            if (obj == objD) {
                return objD;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.d.b(obj);
        }
        return obj;
    }

    @Override // defpackage.or0
    public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
        return ((SimultaneousTranslationActivity$runTranslatorStopBlocking$2) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
    }
}
