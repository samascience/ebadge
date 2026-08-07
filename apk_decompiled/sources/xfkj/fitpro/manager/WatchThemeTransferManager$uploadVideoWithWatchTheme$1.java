package xfkj.fitpro.manager;

import android.content.Context;
import android.util.Log;
import defpackage.gh3;
import defpackage.h70;
import defpackage.k83;
import defpackage.or0;
import defpackage.x30;
import defpackage.xg3;
import java.util.List;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d;
import kotlinx.coroutines.CoroutineScope;
import xfkj.fitpro.model.sever.body.ClockDialInfoBody;

/* JADX INFO: loaded from: classes4.dex */
@h70(c = "xfkj.fitpro.manager.WatchThemeTransferManager$uploadVideoWithWatchTheme$1", f = "WatchThemeTransferManager.kt", l = {233, 240}, m = "invokeSuspend")
final class WatchThemeTransferManager$uploadVideoWithWatchTheme$1 extends SuspendLambda implements or0 {
    final /* synthetic */ WatchThemeTransferManager.c $callback;
    final /* synthetic */ Context $context;
    final /* synthetic */ String $videoPath;
    Object L$0;
    int label;
    final /* synthetic */ WatchThemeTransferManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WatchThemeTransferManager$uploadVideoWithWatchTheme$1(String str, WatchThemeTransferManager.c cVar, WatchThemeTransferManager watchThemeTransferManager, Context context, x30 x30Var) {
        super(2, x30Var);
        this.$videoPath = str;
        this.$callback = cVar;
        this.this$0 = watchThemeTransferManager;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(Object obj, x30 x30Var) {
        return new WatchThemeTransferManager$uploadVideoWithWatchTheme$1(this.$videoPath, this.$callback, this.this$0, this.$context, x30Var);
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0090 A[Catch: Exception -> 0x0019, TryCatch #0 {Exception -> 0x0019, blocks: (B:7:0x0014, B:33:0x008c, B:35:0x0090, B:37:0x009a, B:39:0x00a8, B:41:0x00b2, B:14:0x0028, B:25:0x006e, B:27:0x0072, B:29:0x007c, B:17:0x002f, B:19:0x0052, B:21:0x005c), top: B:46:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:37:0x009a A[Catch: Exception -> 0x0019, TryCatch #0 {Exception -> 0x0019, blocks: (B:7:0x0014, B:33:0x008c, B:35:0x0090, B:37:0x009a, B:39:0x00a8, B:41:0x00b2, B:14:0x0028, B:25:0x006e, B:27:0x0072, B:29:0x007c, B:17:0x002f, B:19:0x0052, B:21:0x005c), top: B:46:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:39:0x00a8 A[Catch: Exception -> 0x0019, TryCatch #0 {Exception -> 0x0019, blocks: (B:7:0x0014, B:33:0x008c, B:35:0x0090, B:37:0x009a, B:39:0x00a8, B:41:0x00b2, B:14:0x0028, B:25:0x006e, B:27:0x0072, B:29:0x007c, B:17:0x002f, B:19:0x0052, B:21:0x005c), top: B:46:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:41:0x00b2 A[Catch: Exception -> 0x0019, TRY_LEAVE, TryCatch #0 {Exception -> 0x0019, blocks: (B:7:0x0014, B:33:0x008c, B:35:0x0090, B:37:0x009a, B:39:0x00a8, B:41:0x00b2, B:14:0x0028, B:25:0x006e, B:27:0x0072, B:29:0x007c, B:17:0x002f, B:19:0x0052, B:21:0x005c), top: B:46:0x000a }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        ClockDialInfoBody clockDialInfoBody;
        ClockDialInfoBody clockDialInfoBody2;
        xg3 xg3Var;
        List listA;
        gh3 gh3VarN;
        Object objD = a.d();
        int i = this.label;
        try {
            if (i != 0) {
                if (i == 1) {
                    clockDialInfoBody = (ClockDialInfoBody) this.L$0;
                    d.b(obj);
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    clockDialInfoBody2 = (ClockDialInfoBody) this.L$0;
                    d.b(obj);
                }
                xg3Var = (xg3) obj;
                if (xg3Var == null) {
                    this.$callback.a("构建表盘数据失败");
                    return k83.a;
                }
                listA = this.this$0.A();
                gh3VarN = this.this$0.N();
                if (gh3VarN == null) {
                    this.$callback.a("表盘传输工具未初始化");
                    return k83.a;
                }
                this.this$0.U(this.$context, gh3VarN, this.$callback);
                gh3VarN.S(xg3Var, listA, this.this$0.F(clockDialInfoBody2), false);
                Log.d("WatchThemeTransferManager", "视频表盘传输命令已发送");
                return k83.a;
            }
            d.b(obj);
            Log.d("WatchThemeTransferManager", "开始视频表盘传输: " + this.$videoPath);
            this.$callback.c();
            ClockDialInfoBody clockDialInfoBodyJ = this.this$0.J();
            if (clockDialInfoBodyJ == null) {
                this.$callback.a("表盘信息不存在，请重新连接设备");
                return k83.a;
            }
            WatchThemeTransferManager watchThemeTransferManager = this.this$0;
            String str = this.$videoPath;
            this.L$0 = clockDialInfoBodyJ;
            this.label = 1;
            Object objR = watchThemeTransferManager.R(str, this);
            if (objR == objD) {
                return objD;
            }
            clockDialInfoBody = clockDialInfoBodyJ;
            obj = objR;
            String str2 = (String) obj;
            if (str2 == null) {
                this.$callback.a("视频处理失败");
                return k83.a;
            }
            WatchThemeTransferManager watchThemeTransferManager2 = this.this$0;
            Context context = this.$context;
            this.L$0 = clockDialInfoBody;
            this.label = 2;
            obj = watchThemeTransferManager2.C(context, str2, clockDialInfoBody, this);
            if (obj == objD) {
                return objD;
            }
            clockDialInfoBody2 = clockDialInfoBody;
            xg3Var = (xg3) obj;
            if (xg3Var == null) {
                this.$callback.a("构建表盘数据失败");
                return k83.a;
            }
            listA = this.this$0.A();
            gh3VarN = this.this$0.N();
            if (gh3VarN == null) {
                this.$callback.a("表盘传输工具未初始化");
                return k83.a;
            }
            this.this$0.U(this.$context, gh3VarN, this.$callback);
            gh3VarN.S(xg3Var, listA, this.this$0.F(clockDialInfoBody2), false);
            Log.d("WatchThemeTransferManager", "视频表盘传输命令已发送");
            return k83.a;
        } catch (Exception e) {
            Log.e("WatchThemeTransferManager", "视频表盘传输失败: " + e.getMessage(), e);
            this.$callback.a("视频表盘传输失败: " + e.getMessage());
        }
    }

    @Override // defpackage.or0
    public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
        return ((WatchThemeTransferManager$uploadVideoWithWatchTheme$1) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
    }
}
