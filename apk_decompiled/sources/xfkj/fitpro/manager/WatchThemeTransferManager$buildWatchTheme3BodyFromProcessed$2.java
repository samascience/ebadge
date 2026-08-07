package xfkj.fitpro.manager;

import android.util.Log;
import defpackage.h70;
import defpackage.k83;
import defpackage.or0;
import defpackage.x30;
import defpackage.xg3;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes4.dex */
@h70(c = "xfkj.fitpro.manager.WatchThemeTransferManager$buildWatchTheme3BodyFromProcessed$2", f = "WatchThemeTransferManager.kt", l = {}, m = "invokeSuspend")
final class WatchThemeTransferManager$buildWatchTheme3BodyFromProcessed$2 extends SuspendLambda implements or0 {
    final /* synthetic */ int $fileType;
    final /* synthetic */ String $processedImagePath;
    int label;
    final /* synthetic */ WatchThemeTransferManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WatchThemeTransferManager$buildWatchTheme3BodyFromProcessed$2(WatchThemeTransferManager watchThemeTransferManager, int i, String str, x30 x30Var) {
        super(2, x30Var);
        this.this$0 = watchThemeTransferManager;
        this.$fileType = i;
        this.$processedImagePath = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(Object obj, x30 x30Var) {
        return new WatchThemeTransferManager$buildWatchTheme3BodyFromProcessed$2(this.this$0, this.$fileType, this.$processedImagePath, x30Var);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        a.d();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        d.b(obj);
        try {
            xg3 xg3VarG = this.this$0.G();
            xg3VarG.o(5538);
            xg3VarG.m(this.$fileType);
            xg3VarG.l(this.$processedImagePath);
            Log.d("WatchThemeTransferManager", "WatchTheme3Body 构建完成（已预处理）, 文件类型: " + this.$fileType + ", 路径: " + this.$processedImagePath);
            return xg3VarG;
        } catch (Exception e) {
            Log.e("WatchThemeTransferManager", "构建 WatchTheme3Body 失败: " + e.getMessage(), e);
            return null;
        }
    }

    @Override // defpackage.or0
    public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
        return ((WatchThemeTransferManager$buildWatchTheme3BodyFromProcessed$2) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
    }
}
