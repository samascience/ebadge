package xfkj.fitpro.ui.activities.device.electronicBadgeDevice;

import android.util.Log;
import com.baji.network.manager.AuthManager;
import com.baji.network.model.AiAccessConfigApiResponse;
import com.baji.network.model.NetworkError;
import defpackage.ar0;
import defpackage.c5;
import defpackage.cr2;
import defpackage.d5;
import defpackage.h70;
import defpackage.k83;
import defpackage.or0;
import defpackage.p31;
import defpackage.x30;
import java.util.Locale;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes4.dex */
@h70(c = "xfkj.fitpro.ui.activities.device.electronicBadgeDevice.SimultaneousTranslationActivity$initializeTranslator$1", f = "SimultaneousTranslationActivity.kt", l = {}, m = "invokeSuspend")
final class SimultaneousTranslationActivity$initializeTranslator$1 extends SuspendLambda implements or0 {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SimultaneousTranslationActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SimultaneousTranslationActivity$initializeTranslator$1(SimultaneousTranslationActivity simultaneousTranslationActivity, x30 x30Var) {
        super(2, x30Var);
        this.this$0 = simultaneousTranslationActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:18:0x0065  */
    public static final k83 invokeSuspend$lambda$3(final SimultaneousTranslationActivity simultaneousTranslationActivity, CoroutineScope coroutineScope, AiAccessConfigApiResponse aiAccessConfigApiResponse) {
        Object objM69constructorimpl;
        d5 d5VarA;
        String key;
        String data;
        simultaneousTranslationActivity.o1(aiAccessConfigApiResponse.getLangConfig());
        try {
            Result.a aVar = Result.Companion;
            if (!aiAccessConfigApiResponse.getSuccess() || (key = aiAccessConfigApiResponse.getKey()) == null || kotlin.text.i.Y(key) || (data = aiAccessConfigApiResponse.getData()) == null || kotlin.text.i.Y(data)) {
                d5VarA = null;
            } else {
                Log.i(simultaneousTranslationActivity.K(), "AiAccessConfig 获取到的语言配置: " + aiAccessConfigApiResponse.getLangConfig());
                c5 c5Var = c5.a;
                String key2 = aiAccessConfigApiResponse.getKey();
                p31.c(key2);
                String data2 = aiAccessConfigApiResponse.getData();
                p31.c(data2);
                d5VarA = c5Var.a(key2, data2);
                if (kotlin.text.i.Y(d5VarA.a())) {
                    d5VarA = null;
                }
            }
            objM69constructorimpl = Result.m69constructorimpl(d5VarA);
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            objM69constructorimpl = Result.m69constructorimpl(kotlin.d.a(th));
        }
        d5 d5Var = (d5) (Result.m75isFailureimpl(objM69constructorimpl) ? null : objM69constructorimpl);
        if (d5Var != null) {
            Log.i(simultaneousTranslationActivity.K(), "通过 AiAccessConfig 获取到令牌");
            cr2.a.h(d5Var.b());
            simultaneousTranslationActivity.F = d5Var.a();
            simultaneousTranslationActivity.runOnUiThread(new Runnable() { // from class: xfkj.fitpro.ui.activities.device.electronicBadgeDevice.d
                @Override // java.lang.Runnable
                public final void run() {
                    SimultaneousTranslationActivity$initializeTranslator$1.invokeSuspend$lambda$3$lambda$2(simultaneousTranslationActivity);
                }
            });
        } else {
            Log.w(simultaneousTranslationActivity.K(), "AiAccessConfig 无效或解密失败，尝试回退到同声翻译令牌接口");
            simultaneousTranslationActivity.P1();
        }
        return k83.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$lambda$3$lambda$2(SimultaneousTranslationActivity simultaneousTranslationActivity) {
        simultaneousTranslationActivity.z1(simultaneousTranslationActivity.F);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 invokeSuspend$lambda$4(SimultaneousTranslationActivity simultaneousTranslationActivity, NetworkError networkError) {
        Log.e(simultaneousTranslationActivity.K(), "获取 AiAccessConfig 失败: " + networkError.getErrorMessage() + "，回退到同声翻译令牌接口");
        simultaneousTranslationActivity.P1();
        return k83.a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(Object obj, x30 x30Var) {
        SimultaneousTranslationActivity$initializeTranslator$1 simultaneousTranslationActivity$initializeTranslator$1 = new SimultaneousTranslationActivity$initializeTranslator$1(this.this$0, x30Var);
        simultaneousTranslationActivity$initializeTranslator$1.L$0 = obj;
        return simultaneousTranslationActivity$initializeTranslator$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        kotlin.coroutines.intrinsics.a.d();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        kotlin.d.b(obj);
        final CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        String language = Locale.getDefault().getLanguage();
        Log.i(this.this$0.K(), "initializeTranslator: " + language);
        AuthManager companion = AuthManager.Companion.getInstance();
        p31.c(language);
        final SimultaneousTranslationActivity simultaneousTranslationActivity = this.this$0;
        ar0 ar0Var = new ar0() { // from class: xfkj.fitpro.ui.activities.device.electronicBadgeDevice.e
            @Override // defpackage.ar0
            public final Object invoke(Object obj2) {
                return SimultaneousTranslationActivity$initializeTranslator$1.invokeSuspend$lambda$3(simultaneousTranslationActivity, coroutineScope, (AiAccessConfigApiResponse) obj2);
            }
        };
        final SimultaneousTranslationActivity simultaneousTranslationActivity2 = this.this$0;
        companion.getAiAccessConfig(language, ar0Var, new ar0() { // from class: xfkj.fitpro.ui.activities.device.electronicBadgeDevice.f
            @Override // defpackage.ar0
            public final Object invoke(Object obj2) {
                return SimultaneousTranslationActivity$initializeTranslator$1.invokeSuspend$lambda$4(simultaneousTranslationActivity2, (NetworkError) obj2);
            }
        });
        return k83.a;
    }

    @Override // defpackage.or0
    public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
        return ((SimultaneousTranslationActivity$initializeTranslator$1) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
    }
}
