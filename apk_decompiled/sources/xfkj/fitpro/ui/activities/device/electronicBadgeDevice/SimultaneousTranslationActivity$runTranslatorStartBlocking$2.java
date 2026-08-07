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
@h70(c = "xfkj.fitpro.ui.activities.device.electronicBadgeDevice.SimultaneousTranslationActivity$runTranslatorStartBlocking$2", f = "SimultaneousTranslationActivity.kt", l = {1047}, m = "invokeSuspend")
final class SimultaneousTranslationActivity$runTranslatorStartBlocking$2 extends SuspendLambda implements or0 {
    int label;
    final /* synthetic */ SimultaneousTranslationActivity this$0;

    /* JADX INFO: renamed from: xfkj.fitpro.ui.activities.device.electronicBadgeDevice.SimultaneousTranslationActivity$runTranslatorStartBlocking$2$1, reason: invalid class name */
    @h70(c = "xfkj.fitpro.ui.activities.device.electronicBadgeDevice.SimultaneousTranslationActivity$runTranslatorStartBlocking$2$1", f = "SimultaneousTranslationActivity.kt", l = {1049}, m = "invokeSuspend")
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
            boolean zBooleanValue = false;
            try {
                if (i == 0) {
                    kotlin.d.b(obj);
                    SimultaneousTranslator simultaneousTranslator = this.this$0.r;
                    String str = null;
                    if (simultaneousTranslator == null) {
                        p31.t("translator");
                        simultaneousTranslator = null;
                    }
                    String str2 = this.this$0.s;
                    if (str2 == null) {
                        p31.t("sourceLanguage");
                        str2 = null;
                    }
                    String str3 = this.this$0.t;
                    if (str3 == null) {
                        p31.t("targetLanguage");
                    } else {
                        str = str3;
                    }
                    this.label = 1;
                    obj = simultaneousTranslator.y(str2, str, this);
                    if (obj == objD) {
                        return objD;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    kotlin.d.b(obj);
                }
                zBooleanValue = ((Boolean) obj).booleanValue();
            } catch (UninitializedPropertyAccessException e) {
                Log.e(this.this$0.K(), "translator未初始化: " + e.getMessage());
            } catch (Exception e2) {
                Log.e(this.this$0.K(), "PTT 启动翻译失败: " + e2.getMessage());
            }
            return jn.a(zBooleanValue);
        }

        @Override // defpackage.or0
        public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
            return ((AnonymousClass1) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SimultaneousTranslationActivity$runTranslatorStartBlocking$2(SimultaneousTranslationActivity simultaneousTranslationActivity, x30 x30Var) {
        super(2, x30Var);
        this.this$0 = simultaneousTranslationActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(Object obj, x30 x30Var) {
        return new SimultaneousTranslationActivity$runTranslatorStartBlocking$2(this.this$0, x30Var);
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
        return jn.a(p31.a(obj, jn.a(true)));
    }

    @Override // defpackage.or0
    public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
        return ((SimultaneousTranslationActivity$runTranslatorStartBlocking$2) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
    }
}
