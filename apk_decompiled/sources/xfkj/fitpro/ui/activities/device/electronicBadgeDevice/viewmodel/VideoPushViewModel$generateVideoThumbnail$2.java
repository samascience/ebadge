package xfkj.fitpro.ui.activities.device.electronicBadgeDevice.viewmodel;

import android.util.Log;
import com.arthenica.ffmpegkit.b;
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
@h70(c = "xfkj.fitpro.ui.activities.device.electronicBadgeDevice.viewmodel.VideoPushViewModel$generateVideoThumbnail$2", f = "VideoPushViewModel.kt", l = {}, m = "invokeSuspend")
final class VideoPushViewModel$generateVideoThumbnail$2 extends SuspendLambda implements or0 {
    final /* synthetic */ String $outputPath;
    final /* synthetic */ String $videoPath;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    VideoPushViewModel$generateVideoThumbnail$2(String str, String str2, x30 x30Var) {
        super(2, x30Var);
        this.$videoPath = str;
        this.$outputPath = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(Object obj, x30 x30Var) {
        return new VideoPushViewModel$generateVideoThumbnail$2(this.$videoPath, this.$outputPath, x30Var);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        kotlin.coroutines.intrinsics.a.d();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        d.b(obj);
        boolean z = false;
        try {
            Log.d("VideoPushViewModel", "生成视频缩略图: " + this.$videoPath + " -> " + this.$outputPath);
            yj0 yj0VarB = b.b("-y -i \"" + this.$videoPath + "\" -vframes 1 -q:v 2 -f image2 \"" + this.$outputPath + "\"");
            if (sh2.b(yj0VarB.n())) {
                File file = new File(this.$outputPath);
                if (!file.exists() || file.length() <= 0) {
                    Log.e("VideoPushViewModel", "缩略图文件不存在或为空");
                } else {
                    Log.d("VideoPushViewModel", "缩略图生成成功，文件大小: " + file.length() + " bytes");
                    z = true;
                }
            } else {
                Log.e("VideoPushViewModel", "FFmpeg生成缩略图失败: " + yj0VarB.m());
            }
        } catch (Exception e) {
            Log.e("VideoPushViewModel", "生成缩略图异常", e);
        }
        return jn.a(z);
    }

    @Override // defpackage.or0
    public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
        return ((VideoPushViewModel$generateVideoThumbnail$2) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
    }
}
