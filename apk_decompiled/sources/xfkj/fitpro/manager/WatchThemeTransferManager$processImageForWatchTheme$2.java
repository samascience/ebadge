package xfkj.fitpro.manager;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import defpackage.h70;
import defpackage.k83;
import defpackage.or0;
import defpackage.x30;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d;
import kotlinx.coroutines.CoroutineScope;
import xfkj.fitpro.model.sever.body.ClockDialInfoBody;
import xfkj.fitpro.utils.JpegRulesChecker;

/* JADX INFO: loaded from: classes4.dex */
@h70(c = "xfkj.fitpro.manager.WatchThemeTransferManager$processImageForWatchTheme$2", f = "WatchThemeTransferManager.kt", l = {633}, m = "invokeSuspend")
final class WatchThemeTransferManager$processImageForWatchTheme$2 extends SuspendLambda implements or0 {
    final /* synthetic */ ClockDialInfoBody $clockDialInfo;
    final /* synthetic */ Context $context;
    final /* synthetic */ String $imagePath;
    byte B$0;
    int label;
    final /* synthetic */ WatchThemeTransferManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WatchThemeTransferManager$processImageForWatchTheme$2(WatchThemeTransferManager watchThemeTransferManager, String str, ClockDialInfoBody clockDialInfoBody, Context context, x30 x30Var) {
        super(2, x30Var);
        this.this$0 = watchThemeTransferManager;
        this.$imagePath = str;
        this.$clockDialInfo = clockDialInfoBody;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(Object obj, x30 x30Var) {
        return new WatchThemeTransferManager$processImageForWatchTheme$2(this.this$0, this.$imagePath, this.$clockDialInfo, this.$context, x30Var);
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00f1 A[Catch: Exception -> 0x0015, TryCatch #0 {Exception -> 0x0015, blocks: (B:6:0x0010, B:35:0x00ec, B:37:0x00f1, B:39:0x0107, B:13:0x0023, B:15:0x002d, B:17:0x0044, B:19:0x0082, B:21:0x0088, B:23:0x0091, B:26:0x00a1, B:28:0x00ab, B:30:0x00c5, B:31:0x00da), top: B:43:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:39:0x0107 A[Catch: Exception -> 0x0015, TRY_LEAVE, TryCatch #0 {Exception -> 0x0015, blocks: (B:6:0x0010, B:35:0x00ec, B:37:0x00f1, B:39:0x0107, B:13:0x0023, B:15:0x002d, B:17:0x0044, B:19:0x0082, B:21:0x0088, B:23:0x0091, B:26:0x00a1, B:28:0x00ab, B:30:0x00c5, B:31:0x00da), top: B:43:0x000a }] */
    /* JADX WARN: Instruction removed from duplicated block: B:37:0x00f1, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:39:0x0107, please report this as an issue */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        byte algorithm;
        byte b;
        String strT;
        Object objD = a.d();
        int i = this.label;
        try {
            if (i == 0) {
                d.b(obj);
                Bitmap bitmapO = this.this$0.O(this.$imagePath);
                if (bitmapO == null) {
                    Log.e("WatchThemeTransferManager", "无法加载原始图片: " + this.$imagePath);
                    return null;
                }
                short width = this.$clockDialInfo.getWidth();
                short height = this.$clockDialInfo.getHeight();
                Log.d("WatchThemeTransferManager", "表盘尺寸: " + ((int) width) + "x" + ((int) height) + ", 算法类型: " + ((int) this.$clockDialInfo.getAlgorithm()));
                Bitmap bitmapH = this.this$0.H(bitmapO, width, height);
                if (bitmapH == null) {
                    Log.e("WatchThemeTransferManager", "图片缩放失败");
                    return null;
                }
                algorithm = this.$clockDialInfo.getAlgorithm();
                if (algorithm == 4) {
                    Log.d("WatchThemeTransferManager", "使用JPEG算法处理图片");
                    strT = this.this$0.T(this.$context, bitmapH);
                    if (strT == null) {
                        return null;
                    }
                    String strD = JpegRulesChecker.a.d(this.$context, strT);
                    if (strD != null) {
                        Log.e("WatchThemeTransferManager", "JPEG 格式检测未通过: " + strD);
                        this.this$0.d = strD;
                        return null;
                    }
                    Log.d("WatchThemeTransferManager", "JPEG 格式检测通过: " + strT);
                } else {
                    WatchThemeTransferManager watchThemeTransferManager = this.this$0;
                    Context context = this.$context;
                    ClockDialInfoBody clockDialInfoBody = this.$clockDialInfo;
                    this.B$0 = algorithm;
                    this.label = 1;
                    obj = watchThemeTransferManager.E(context, bitmapH, clockDialInfoBody, this);
                    if (obj == objD) {
                        return objD;
                    }
                    b = algorithm;
                }
                if (strT == null) {
                    Log.e("WatchThemeTransferManager", "图片处理失败，算法类型: " + ((int) algorithm));
                    return null;
                }
                Log.d("WatchThemeTransferManager", "图片处理完成，算法类型: " + ((int) algorithm) + "，文件路径: " + strT);
                return strT;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b = this.B$0;
            d.b(obj);
            strT = (String) obj;
            algorithm = b;
            if (strT == null) {
                Log.e("WatchThemeTransferManager", "图片处理失败，算法类型: " + ((int) algorithm));
                return null;
            }
            Log.d("WatchThemeTransferManager", "图片处理完成，算法类型: " + ((int) algorithm) + "，文件路径: " + strT);
            return strT;
        } catch (Exception e) {
            Log.e("WatchThemeTransferManager", "处理图片失败: " + e.getMessage(), e);
            return null;
        }
    }

    @Override // defpackage.or0
    public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
        return ((WatchThemeTransferManager$processImageForWatchTheme$2) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
    }
}
