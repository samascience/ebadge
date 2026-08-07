package xfkj.fitpro.manager;

import android.util.Log;
import defpackage.h70;
import defpackage.k83;
import defpackage.or0;
import defpackage.x30;
import java.io.File;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes4.dex */
@h70(c = "xfkj.fitpro.manager.WatchThemeTransferManager$processVideoForWatchTheme$2", f = "WatchThemeTransferManager.kt", l = {}, m = "invokeSuspend")
final class WatchThemeTransferManager$processVideoForWatchTheme$2 extends SuspendLambda implements or0 {
    final /* synthetic */ String $videoPath;
    int label;
    final /* synthetic */ WatchThemeTransferManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WatchThemeTransferManager$processVideoForWatchTheme$2(String str, WatchThemeTransferManager watchThemeTransferManager, x30 x30Var) {
        super(2, x30Var);
        this.$videoPath = str;
        this.this$0 = watchThemeTransferManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(Object obj, x30 x30Var) {
        return new WatchThemeTransferManager$processVideoForWatchTheme$2(this.$videoPath, this.this$0, x30Var);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        a.d();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        d.b(obj);
        try {
            if (!new File(this.$videoPath).exists()) {
                Log.e("WatchThemeTransferManager", "视频文件不存在: " + this.$videoPath);
                return null;
            }
            Log.d("WatchThemeTransferManager", "检测到文件类型: " + this.this$0.I(this.$videoPath));
            Log.d("WatchThemeTransferManager", "视频处理完成，文件路径: " + this.$videoPath);
            return this.$videoPath;
        } catch (Exception e) {
            Log.e("WatchThemeTransferManager", "处理视频失败: " + e.getMessage(), e);
            return null;
        }
    }

    @Override // defpackage.or0
    public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
        return ((WatchThemeTransferManager$processVideoForWatchTheme$2) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
    }
}
