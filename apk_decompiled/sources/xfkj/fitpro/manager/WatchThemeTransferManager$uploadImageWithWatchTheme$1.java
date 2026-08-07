package xfkj.fitpro.manager;

import android.content.Context;
import android.util.Log;
import com.legend.smartwatch.electronicbadge.android.R;
import defpackage.gh3;
import defpackage.h70;
import defpackage.k83;
import defpackage.or0;
import defpackage.p31;
import defpackage.x30;
import defpackage.xg3;
import java.util.List;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d;
import kotlinx.coroutines.CoroutineScope;
import xfkj.fitpro.model.sever.body.ClockDialInfoBody;

/* JADX INFO: loaded from: classes4.dex */
@h70(c = "xfkj.fitpro.manager.WatchThemeTransferManager$uploadImageWithWatchTheme$1", f = "WatchThemeTransferManager.kt", l = {412}, m = "invokeSuspend")
final class WatchThemeTransferManager$uploadImageWithWatchTheme$1 extends SuspendLambda implements or0 {
    final /* synthetic */ WatchThemeTransferManager.c $callback;
    final /* synthetic */ Context $context;
    final /* synthetic */ String $imagePath;
    Object L$0;
    int label;
    final /* synthetic */ WatchThemeTransferManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WatchThemeTransferManager$uploadImageWithWatchTheme$1(String str, WatchThemeTransferManager.c cVar, WatchThemeTransferManager watchThemeTransferManager, Context context, x30 x30Var) {
        super(2, x30Var);
        this.$imagePath = str;
        this.$callback = cVar;
        this.this$0 = watchThemeTransferManager;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(Object obj, x30 x30Var) {
        return new WatchThemeTransferManager$uploadImageWithWatchTheme$1(this.$imagePath, this.$callback, this.this$0, this.$context, x30Var);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        ClockDialInfoBody clockDialInfoBody;
        Object objD = a.d();
        int i = this.label;
        try {
            if (i == 0) {
                d.b(obj);
                Log.d("WatchThemeTransferManager", "开始表盘传输: " + this.$imagePath);
                this.$callback.c();
                ClockDialInfoBody clockDialInfoBodyJ = this.this$0.J();
                if (clockDialInfoBodyJ == null) {
                    this.$callback.a("表盘信息不存在，请重新连接设备");
                    return k83.a;
                }
                this.this$0.d = null;
                WatchThemeTransferManager watchThemeTransferManager = this.this$0;
                Context context = this.$context;
                String str = this.$imagePath;
                this.L$0 = clockDialInfoBodyJ;
                this.label = 1;
                Object objB = watchThemeTransferManager.B(context, str, clockDialInfoBodyJ, this);
                if (objB == objD) {
                    return objD;
                }
                clockDialInfoBody = clockDialInfoBodyJ;
                obj = objB;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                clockDialInfoBody = (ClockDialInfoBody) this.L$0;
                d.b(obj);
            }
            xg3 xg3Var = (xg3) obj;
            if (xg3Var == null) {
                WatchThemeTransferManager.c cVar = this.$callback;
                String string = this.this$0.d;
                if (string == null) {
                    string = this.$context.getString(R.string.watch_theme_build_failed);
                    p31.e(string, "getString(...)");
                }
                cVar.a(string);
                return k83.a;
            }
            List listA = this.this$0.A();
            gh3 gh3VarN = this.this$0.N();
            if (gh3VarN == null) {
                this.$callback.a("表盘传输工具未初始化");
                return k83.a;
            }
            this.this$0.U(this.$context, gh3VarN, this.$callback);
            gh3VarN.S(xg3Var, listA, this.this$0.F(clockDialInfoBody), false);
            Log.d("WatchThemeTransferManager", "表盘传输命令已发送");
            return k83.a;
        } catch (Exception e) {
            Log.e("WatchThemeTransferManager", "表盘传输失败: " + e.getMessage(), e);
            this.$callback.a("表盘传输失败: " + e.getMessage());
        }
    }

    @Override // defpackage.or0
    public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
        return ((WatchThemeTransferManager$uploadImageWithWatchTheme$1) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
    }
}
