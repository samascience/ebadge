package xfkj.fitpro.ui.activities.device.electronicBadgeDevice.viewmodel;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import androidx.lifecycle.p;
import com.arthenica.ffmpegkit.b;
import com.blankj.utilcode.util.n;
import defpackage.ar0;
import defpackage.dn0;
import defpackage.h70;
import defpackage.k83;
import defpackage.or0;
import defpackage.p31;
import defpackage.x30;
import defpackage.yj0;
import defpackage.zj0;
import java.io.File;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes4.dex */
@h70(c = "xfkj.fitpro.ui.activities.device.electronicBadgeDevice.viewmodel.VideoPushViewModel$convertAviToGif$1", f = "VideoPushViewModel.kt", l = {}, m = "invokeSuspend")
final class VideoPushViewModel$convertAviToGif$1 extends SuspendLambda implements or0 {
    final /* synthetic */ Uri $aviUri;
    final /* synthetic */ ar0 $callback;
    final /* synthetic */ Context $context;
    int label;
    final /* synthetic */ VideoPushViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    VideoPushViewModel$convertAviToGif$1(Uri uri, ar0 ar0Var, Context context, VideoPushViewModel videoPushViewModel, x30 x30Var) {
        super(2, x30Var);
        this.$aviUri = uri;
        this.$callback = ar0Var;
        this.$context = context;
        this.this$0 = videoPushViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$lambda$0(VideoPushViewModel videoPushViewModel, String str, ar0 ar0Var, yj0 yj0Var) {
        BuildersKt__Builders_commonKt.launch$default(p.a(videoPushViewModel), null, null, new VideoPushViewModel$convertAviToGif$1$1$1(yj0Var, str, ar0Var, null), 3, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(Object obj, x30 x30Var) {
        return new VideoPushViewModel$convertAviToGif$1(this.$aviUri, this.$callback, this.$context, this.this$0, x30Var);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        String absolutePath;
        kotlin.coroutines.intrinsics.a.d();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        d.b(obj);
        try {
            if (!p31.a(this.$aviUri.getScheme(), "file")) {
                File fileE = n.e(this.$aviUri);
                absolutePath = fileE != null ? fileE.getAbsolutePath() : null;
                if (absolutePath != null) {
                    if (absolutePath.length() == 0) {
                    }
                }
                Log.e("VideoPushViewModel", "无法获取AVI文件路径: " + this.$aviUri);
                this.$callback.invoke(null);
                return k83.a;
            }
            absolutePath = this.$aviUri.getPath();
            File file = new File(absolutePath);
            if (!file.exists()) {
                Log.e("VideoPushViewModel", "AVI文件不存在: " + absolutePath);
                this.$callback.invoke(null);
                return k83.a;
            }
            final String absolutePath2 = new File(this.$context.getCacheDir(), dn0.c(file) + "_preview.gif").getAbsolutePath();
            File file2 = new File(absolutePath2);
            if (file2.exists() && file2.length() > 0) {
                if (file2.lastModified() >= file.lastModified()) {
                    Log.d("VideoPushViewModel", "使用缓存的GIF文件: " + absolutePath2 + " (大小: " + file2.length() + " bytes)");
                    this.$callback.invoke(Uri.fromFile(file2));
                    return k83.a;
                }
                Log.d("VideoPushViewModel", "AVI文件已更新，需要重新转换GIF");
            }
            Log.d("VideoPushViewModel", "开始将AVI转换为GIF: " + absolutePath + " -> " + absolutePath2);
            final VideoPushViewModel videoPushViewModel = this.this$0;
            final ar0 ar0Var = this.$callback;
            b.c("-y -i \"" + absolutePath + "\" -t 3 -vf \"fps=2,scale=200:-1\" -loop 0 \"" + absolutePath2 + "\"", new zj0() { // from class: xfkj.fitpro.ui.activities.device.electronicBadgeDevice.viewmodel.a
                @Override // defpackage.zj0
                public final void a(yj0 yj0Var) {
                    VideoPushViewModel$convertAviToGif$1.invokeSuspend$lambda$0(videoPushViewModel, absolutePath2, ar0Var, yj0Var);
                }
            });
            return k83.a;
        } catch (Exception e) {
            Log.e("VideoPushViewModel", "AVI转GIF异常", e);
            this.$callback.invoke(null);
        }
    }

    @Override // defpackage.or0
    public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
        return ((VideoPushViewModel$convertAviToGif$1) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
    }
}
