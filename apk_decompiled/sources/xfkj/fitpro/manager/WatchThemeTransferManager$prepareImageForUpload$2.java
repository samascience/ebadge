package xfkj.fitpro.manager;

import android.content.Context;
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
import xfkj.fitpro.model.sever.body.ClockDialInfoBody;

/* JADX INFO: loaded from: classes4.dex */
@h70(c = "xfkj.fitpro.manager.WatchThemeTransferManager$prepareImageForUpload$2", f = "WatchThemeTransferManager.kt", l = {318}, m = "invokeSuspend")
final class WatchThemeTransferManager$prepareImageForUpload$2 extends SuspendLambda implements or0 {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $sourceImagePath;
    Object L$0;
    int label;
    final /* synthetic */ WatchThemeTransferManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WatchThemeTransferManager$prepareImageForUpload$2(WatchThemeTransferManager watchThemeTransferManager, Context context, String str, x30 x30Var) {
        super(2, x30Var);
        this.this$0 = watchThemeTransferManager;
        this.$context = context;
        this.$sourceImagePath = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(Object obj, x30 x30Var) {
        return new WatchThemeTransferManager$prepareImageForUpload$2(this.this$0, this.$context, this.$sourceImagePath, x30Var);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        ClockDialInfoBody clockDialInfoBody;
        Object objD = a.d();
        int i = this.label;
        if (i == 0) {
            d.b(obj);
            ClockDialInfoBody clockDialInfoBodyJ = this.this$0.J();
            if (clockDialInfoBodyJ == null) {
                Log.e("WatchThemeTransferManager", "表盘信息不存在，无法预处理上传图片");
                return null;
            }
            this.this$0.d = null;
            WatchThemeTransferManager watchThemeTransferManager = this.this$0;
            Context context = this.$context;
            String str = this.$sourceImagePath;
            this.L$0 = clockDialInfoBodyJ;
            this.label = 1;
            Object objQ = watchThemeTransferManager.Q(context, str, clockDialInfoBodyJ, this);
            if (objQ == objD) {
                return objD;
            }
            clockDialInfoBody = clockDialInfoBodyJ;
            obj = objQ;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            clockDialInfoBody = (ClockDialInfoBody) this.L$0;
            d.b(obj);
        }
        String str2 = (String) obj;
        if (str2 == null) {
            return null;
        }
        File file = new File(str2);
        if (file.exists() && file.length() > 0) {
            return new WatchThemeTransferManager.b(str2, file.length(), this.this$0.S(clockDialInfoBody.getAlgorithm()));
        }
        Log.e("WatchThemeTransferManager", "预处理上传文件无效: " + str2);
        return null;
    }

    @Override // defpackage.or0
    public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
        return ((WatchThemeTransferManager$prepareImageForUpload$2) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
    }
}
