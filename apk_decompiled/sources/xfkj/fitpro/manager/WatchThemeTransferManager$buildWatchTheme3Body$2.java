package xfkj.fitpro.manager;

import android.content.Context;
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
import xfkj.fitpro.model.sever.body.ClockDialInfoBody;

/* JADX INFO: loaded from: classes4.dex */
@h70(c = "xfkj.fitpro.manager.WatchThemeTransferManager$buildWatchTheme3Body$2", f = "WatchThemeTransferManager.kt", l = {493}, m = "invokeSuspend")
final class WatchThemeTransferManager$buildWatchTheme3Body$2 extends SuspendLambda implements or0 {
    final /* synthetic */ ClockDialInfoBody $clockDialInfo;
    final /* synthetic */ Context $context;
    final /* synthetic */ String $imagePath;
    Object L$0;
    int label;
    final /* synthetic */ WatchThemeTransferManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WatchThemeTransferManager$buildWatchTheme3Body$2(WatchThemeTransferManager watchThemeTransferManager, Context context, String str, ClockDialInfoBody clockDialInfoBody, x30 x30Var) {
        super(2, x30Var);
        this.this$0 = watchThemeTransferManager;
        this.$context = context;
        this.$imagePath = str;
        this.$clockDialInfo = clockDialInfoBody;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(Object obj, x30 x30Var) {
        return new WatchThemeTransferManager$buildWatchTheme3Body$2(this.this$0, this.$context, this.$imagePath, this.$clockDialInfo, x30Var);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        xg3 xg3Var;
        Object objD = a.d();
        int i = this.label;
        try {
            if (i == 0) {
                d.b(obj);
                xg3 xg3VarG = this.this$0.G();
                xg3VarG.o(5538);
                WatchThemeTransferManager watchThemeTransferManager = this.this$0;
                Context context = this.$context;
                String str = this.$imagePath;
                ClockDialInfoBody clockDialInfoBody = this.$clockDialInfo;
                this.L$0 = xg3VarG;
                this.label = 1;
                Object objQ = watchThemeTransferManager.Q(context, str, clockDialInfoBody, this);
                if (objQ == objD) {
                    return objD;
                }
                xg3Var = xg3VarG;
                obj = objQ;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                xg3Var = (xg3) this.L$0;
                d.b(obj);
            }
            String str2 = (String) obj;
            if (str2 == null) {
                Log.e("WatchThemeTransferManager", "图片处理失败");
                return null;
            }
            byte algorithm = this.$clockDialInfo.getAlgorithm();
            int iS = this.this$0.S(algorithm);
            xg3Var.m(iS);
            xg3Var.l(str2);
            Log.d("WatchThemeTransferManager", "WatchTheme3Body 构建完成，算法类型: " + ((int) algorithm) + ", 文件类型: " + iS + ", 背景路径: " + str2);
            return xg3Var;
        } catch (Exception e) {
            Log.e("WatchThemeTransferManager", "构建 WatchTheme3Body 失败: " + e.getMessage(), e);
            return null;
        }
    }

    @Override // defpackage.or0
    public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
        return ((WatchThemeTransferManager$buildWatchTheme3Body$2) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
    }
}
