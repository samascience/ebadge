package xfkj.fitpro.ui.activities.device.electronicBadgeDevice;

import android.util.Log;
import com.tencent.connect.common.Constants;
import defpackage.h70;
import defpackage.k83;
import defpackage.or0;
import defpackage.x30;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: classes4.dex */
@h70(c = "xfkj.fitpro.ui.activities.device.electronicBadgeDevice.SimultaneousTranslationActivity$fallbackTranslateAndPlay$1", f = "SimultaneousTranslationActivity.kt", l = {1099, 1110}, m = "invokeSuspend")
final class SimultaneousTranslationActivity$fallbackTranslateAndPlay$1 extends SuspendLambda implements or0 {
    final /* synthetic */ String $source;
    final /* synthetic */ String $target;
    final /* synthetic */ String $text;
    int label;
    final /* synthetic */ SimultaneousTranslationActivity this$0;

    /* JADX INFO: renamed from: xfkj.fitpro.ui.activities.device.electronicBadgeDevice.SimultaneousTranslationActivity$fallbackTranslateAndPlay$1$1, reason: invalid class name */
    @h70(c = "xfkj.fitpro.ui.activities.device.electronicBadgeDevice.SimultaneousTranslationActivity$fallbackTranslateAndPlay$1$1", f = "SimultaneousTranslationActivity.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements or0 {
        final /* synthetic */ String $text;
        final /* synthetic */ String $translated;
        int label;
        final /* synthetic */ SimultaneousTranslationActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(SimultaneousTranslationActivity simultaneousTranslationActivity, String str, String str2, x30 x30Var) {
            super(2, x30Var);
            this.this$0 = simultaneousTranslationActivity;
            this.$text = str;
            this.$translated = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final x30 create(Object obj, x30 x30Var) {
            return new AnonymousClass1(this.this$0, this.$text, this.$translated, x30Var);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            kotlin.coroutines.intrinsics.a.d();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.d.b(obj);
            if (!this.this$0.f2()) {
                return k83.a;
            }
            Log.i(this.this$0.K(), "兜底翻译成功: " + this.$text + " -> " + this.$translated);
            this.this$0.y1(this.$text, this.$translated);
            return k83.a;
        }

        @Override // defpackage.or0
        public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
            return ((AnonymousClass1) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SimultaneousTranslationActivity$fallbackTranslateAndPlay$1(SimultaneousTranslationActivity simultaneousTranslationActivity, String str, String str2, String str3, x30 x30Var) {
        super(2, x30Var);
        this.this$0 = simultaneousTranslationActivity;
        this.$text = str;
        this.$source = str2;
        this.$target = str3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(Object obj, x30 x30Var) {
        return new SimultaneousTranslationActivity$fallbackTranslateAndPlay$1(this.this$0, this.$text, this.$source, this.$target, x30Var);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objD = kotlin.coroutines.intrinsics.a.d();
        int i = this.label;
        String str = Constants.STR_EMPTY;
        try {
            if (i != 0) {
                if (i == 1) {
                    kotlin.d.b(obj);
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    kotlin.d.b(obj);
                }
                return k83.a;
            }
            kotlin.d.b(obj);
            SimultaneousTranslationActivity$fallbackTranslateAndPlay$1$translated$1 simultaneousTranslationActivity$fallbackTranslateAndPlay$1$translated$1 = new SimultaneousTranslationActivity$fallbackTranslateAndPlay$1$translated$1(this.this$0, this.$text, this.$source, this.$target, null);
            this.label = 1;
            obj = TimeoutKt.withTimeoutOrNull(5000L, simultaneousTranslationActivity$fallbackTranslateAndPlay$1$translated$1, this);
            if (obj == objD) {
                return objD;
            }
            String str2 = (String) obj;
            if (str2 != null) {
                str = str2;
            }
        } catch (Exception e) {
            Log.e(this.this$0.K(), "兜底翻译失败: " + e.getMessage());
        }
        if (!kotlin.text.i.Y(str)) {
            MainCoroutineDispatcher main = Dispatchers.getMain();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$text, str, null);
            this.label = 2;
            if (BuildersKt.withContext(main, anonymousClass1, this) == objD) {
                return objD;
            }
            return k83.a;
        }
        Log.w(this.this$0.K(), "兜底翻译无结果，放弃: " + this.$text);
        return k83.a;
    }

    @Override // defpackage.or0
    public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
        return ((SimultaneousTranslationActivity$fallbackTranslateAndPlay$1) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
    }
}
