package xfkj.fitpro.ui.activities.device.electronicBadgeDevice.viewmodel;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.blankj.utilcode.util.g;
import com.legend.smartwatch.electronicbadge.android.R;
import defpackage.h70;
import defpackage.im1;
import defpackage.k83;
import defpackage.md3;
import defpackage.or0;
import defpackage.p31;
import defpackage.x30;
import java.io.File;
import java.util.Locale;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d;
import kotlinx.coroutines.CoroutineScope;
import xfkj.fitpro.ui.activities.device.electronicBadgeDevice.model.VideoInfo;

/* JADX INFO: loaded from: classes4.dex */
@h70(c = "xfkj.fitpro.ui.activities.device.electronicBadgeDevice.viewmodel.VideoPushViewModel$handleSystemGalleryResult$1", f = "VideoPushViewModel.kt", l = {904}, m = "invokeSuspend")
final class VideoPushViewModel$handleSystemGalleryResult$1 extends SuspendLambda implements or0 {
    final /* synthetic */ Context $context;
    final /* synthetic */ Uri $uri;
    Object L$0;
    int label;
    final /* synthetic */ VideoPushViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    VideoPushViewModel$handleSystemGalleryResult$1(Uri uri, VideoPushViewModel videoPushViewModel, Context context, x30 x30Var) {
        super(2, x30Var);
        this.$uri = uri;
        this.this$0 = videoPushViewModel;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(Object obj, x30 x30Var) {
        return new VideoPushViewModel$handleSystemGalleryResult$1(this.$uri, this.this$0, this.$context, x30Var);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        File file;
        Object objD = kotlin.coroutines.intrinsics.a.d();
        int i = this.label;
        try {
            if (i == 0) {
                d.b(obj);
                Log.d("VideoPushViewModel", "处理系统相册选择结果: " + this.$uri);
                this.this$0.h0();
                String strT = this.this$0.T(this.$uri, this.$context);
                if (strT != null && strT.length() != 0) {
                    File file2 = new File(strT);
                    String strM = g.m(strT);
                    p31.e(strM, "getFileExtension(...)");
                    Locale locale = Locale.ROOT;
                    String lowerCase = strM.toLowerCase(locale);
                    p31.e(lowerCase, "toLowerCase(...)");
                    String name = file2.getName();
                    p31.e(name, "getName(...)");
                    String lowerCase2 = name.toLowerCase(locale);
                    p31.e(lowerCase2, "toLowerCase(...)");
                    Log.d("VideoPushViewModel", "文件信息: 路径=" + strT + ", 扩展名=" + lowerCase + ", 文件名=" + lowerCase2);
                    if (!this.this$0.d0(lowerCase, lowerCase2)) {
                        im1 im1Var = this.this$0.o;
                        String string = this.$context.getString(R.string.please_select_video);
                        p31.e(string, "getString(...)");
                        im1Var.o(new md3.f(string));
                    } else {
                        if (!this.this$0.t0(this.$uri, this.$context)) {
                            im1 im1Var2 = this.this$0.o;
                            String string2 = this.$context.getString(R.string.cannot_access_video_file_error);
                            p31.e(string2, "getString(...)");
                            im1Var2.o(new md3.f(string2));
                            return k83.a;
                        }
                        VideoPushViewModel videoPushViewModel = this.this$0;
                        Uri uri = this.$uri;
                        String name2 = file2.getName();
                        p31.e(name2, "getName(...)");
                        Context context = this.$context;
                        this.L$0 = file2;
                        this.label = 1;
                        obj = videoPushViewModel.N(uri, name2, context, this);
                        if (obj == objD) {
                            return objD;
                        }
                        file = file2;
                    }
                    return k83.a;
                }
                im1 im1Var3 = this.this$0.o;
                String string3 = this.$context.getString(R.string.cannot_get_video_file_path_error_msg);
                p31.e(string3, "getString(...)");
                im1Var3.o(new md3.f(string3));
                return k83.a;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            file = (File) this.L$0;
            d.b(obj);
            String str = (String) obj;
            if (str != null && str.length() != 0) {
                this.this$0.u = false;
                String name3 = file.getName();
                p31.e(name3, "getName(...)");
                this.this$0.o.o(new md3.k(new VideoInfo(str, name3, this.$uri)));
                return k83.a;
            }
            im1 im1Var4 = this.this$0.o;
            String string4 = this.$context.getString(R.string.cannot_process_video_file);
            p31.e(string4, "getString(...)");
            im1Var4.o(new md3.f(string4));
            return k83.a;
        } catch (Exception e) {
            Log.e("VideoPushViewModel", "处理系统相册结果失败", e);
            im1 im1Var5 = this.this$0.o;
            String string5 = this.$context.getString(R.string.file_process_failed_retry);
            p31.e(string5, "getString(...)");
            im1Var5.o(new md3.f(string5));
        }
    }

    @Override // defpackage.or0
    public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
        return ((VideoPushViewModel$handleSystemGalleryResult$1) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
    }
}
