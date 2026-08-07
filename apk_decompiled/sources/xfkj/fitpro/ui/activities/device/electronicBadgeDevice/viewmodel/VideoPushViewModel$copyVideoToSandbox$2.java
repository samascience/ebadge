package xfkj.fitpro.ui.activities.device.electronicBadgeDevice.viewmodel;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.blankj.utilcode.util.g;
import com.tenmeter.smlibrary.utils.FileUtils;
import defpackage.h70;
import defpackage.k83;
import defpackage.op;
import defpackage.or0;
import defpackage.ty;
import defpackage.x30;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes4.dex */
@h70(c = "xfkj.fitpro.ui.activities.device.electronicBadgeDevice.viewmodel.VideoPushViewModel$copyVideoToSandbox$2", f = "VideoPushViewModel.kt", l = {}, m = "invokeSuspend")
final class VideoPushViewModel$copyVideoToSandbox$2 extends SuspendLambda implements or0 {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $fileName;
    final /* synthetic */ Uri $uri;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    VideoPushViewModel$copyVideoToSandbox$2(String str, Context context, Uri uri, x30 x30Var) {
        super(2, x30Var);
        this.$fileName = str;
        this.$context = context;
        this.$uri = uri;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(Object obj, x30 x30Var) {
        return new VideoPushViewModel$copyVideoToSandbox$2(this.$fileName, this.$context, this.$uri, x30Var);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        kotlin.coroutines.intrinsics.a.d();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        d.b(obj);
        try {
            Log.d("VideoPushViewModel", "开始复制视频到沙盒目录: " + this.$fileName);
            File file = new File(this.$context.getExternalFilesDir(null), "videos");
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, "video_" + System.currentTimeMillis() + FileUtils.FILE_EXTENSION_SEPARATOR + g.m(this.$fileName));
            String absolutePath = file2.getAbsolutePath();
            StringBuilder sb = new StringBuilder();
            sb.append("沙盒文件路径: ");
            sb.append(absolutePath);
            Log.d("VideoPushViewModel", sb.toString());
            InputStream inputStreamOpenInputStream = this.$context.getContentResolver().openInputStream(this.$uri);
            if (inputStreamOpenInputStream == null) {
                Log.e("VideoPushViewModel", "无法打开输入流");
                return null;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            try {
                try {
                    op.b(inputStreamOpenInputStream, fileOutputStream, 0, 2, null);
                    ty.a(fileOutputStream, null);
                    ty.a(inputStreamOpenInputStream, null);
                    if (!file2.exists() || file2.length() <= 0) {
                        Log.e("VideoPushViewModel", "视频复制失败，文件不存在或大小为0");
                        return null;
                    }
                    Log.d("VideoPushViewModel", "视频复制成功: " + file2.getAbsolutePath());
                    Log.d("VideoPushViewModel", "文件大小: " + file2.length() + " bytes");
                    return file2.getAbsolutePath();
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        ty.a(fileOutputStream, th);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                try {
                    throw th3;
                } catch (Throwable th4) {
                    ty.a(inputStreamOpenInputStream, th3);
                    throw th4;
                }
            }
        } catch (Exception e) {
            Log.e("VideoPushViewModel", "复制视频到沙盒失败", e);
            return null;
        }
    }

    @Override // defpackage.or0
    public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
        return ((VideoPushViewModel$copyVideoToSandbox$2) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
    }
}
