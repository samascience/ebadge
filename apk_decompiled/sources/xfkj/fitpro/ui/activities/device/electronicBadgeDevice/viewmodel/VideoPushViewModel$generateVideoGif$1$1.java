package xfkj.fitpro.ui.activities.device.electronicBadgeDevice.viewmodel;

import android.util.Log;
import defpackage.ar0;
import defpackage.h70;
import defpackage.jn;
import defpackage.k83;
import defpackage.or0;
import defpackage.sh2;
import defpackage.x30;
import defpackage.yj0;
import java.io.File;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes4.dex */
@h70(c = "xfkj.fitpro.ui.activities.device.electronicBadgeDevice.viewmodel.VideoPushViewModel$generateVideoGif$1$1", f = "VideoPushViewModel.kt", l = {}, m = "invokeSuspend")
final class VideoPushViewModel$generateVideoGif$1$1 extends SuspendLambda implements or0 {
    final /* synthetic */ ar0 $callback;
    final /* synthetic */ String $outputPath;
    final /* synthetic */ yj0 $session;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    VideoPushViewModel$generateVideoGif$1$1(yj0 yj0Var, String str, ar0 ar0Var, x30 x30Var) {
        super(2, x30Var);
        this.$session = yj0Var;
        this.$outputPath = str;
        this.$callback = ar0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(Object obj, x30 x30Var) {
        return new VideoPushViewModel$generateVideoGif$1$1(this.$session, this.$outputPath, this.$callback, x30Var);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        kotlin.coroutines.intrinsics.a.d();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        d.b(obj);
        if (sh2.b(this.$session.n())) {
            File file = new File(this.$outputPath);
            if (!file.exists() || file.length() <= 0) {
                Log.e("VideoPushViewModel", "GIF文件不存在或为空");
                this.$callback.invoke(jn.a(false));
            } else {
                Log.d("VideoPushViewModel", "GIF预览生成成功，文件大小: " + file.length() + " bytes");
                this.$callback.invoke(jn.a(true));
            }
        } else {
            Log.e("VideoPushViewModel", "FFmpeg生成GIF失败: " + this.$session.m());
            this.$callback.invoke(jn.a(false));
        }
        return k83.a;
    }

    @Override // defpackage.or0
    public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
        return ((VideoPushViewModel$generateVideoGif$1$1) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
    }
}
