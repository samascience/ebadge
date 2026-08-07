package xfkj.fitpro.ui.activities.device.electronicBadgeDevice.viewmodel;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.blankj.utilcode.util.g;
import com.legend.smartwatch.electronicbadge.android.R;
import defpackage.h70;
import defpackage.im1;
import defpackage.jn;
import defpackage.k83;
import defpackage.md3;
import defpackage.or0;
import defpackage.p31;
import defpackage.x30;
import java.io.File;
import java.util.Locale;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d;
import kotlin.text.i;
import kotlinx.coroutines.CoroutineScope;
import xfkj.fitpro.ui.activities.device.electronicBadgeDevice.model.VideoInfo;

/* JADX INFO: loaded from: classes4.dex */
@h70(c = "xfkj.fitpro.ui.activities.device.electronicBadgeDevice.viewmodel.VideoPushViewModel$handleSystemGifResult$1", f = "VideoPushViewModel.kt", l = {970}, m = "invokeSuspend")
final class VideoPushViewModel$handleSystemGifResult$1 extends SuspendLambda implements or0 {
    final /* synthetic */ Context $context;
    final /* synthetic */ Uri $uri;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ VideoPushViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    VideoPushViewModel$handleSystemGifResult$1(Uri uri, VideoPushViewModel videoPushViewModel, Context context, x30 x30Var) {
        super(2, x30Var);
        this.$uri = uri;
        this.this$0 = videoPushViewModel;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(Object obj, x30 x30Var) {
        return new VideoPushViewModel$handleSystemGifResult$1(this.$uri, this.this$0, this.$context, x30Var);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        String str;
        File file;
        Object objD = kotlin.coroutines.intrinsics.a.d();
        int i = this.label;
        try {
            if (i == 0) {
                d.b(obj);
                Log.d("VideoPushViewModel", "处理系统相册选择GIF结果: " + this.$uri);
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
                    if (!p31.a(lowerCase, "gif") && !i.u(lowerCase2, ".gif", false, 2, null)) {
                        im1 im1Var = this.this$0.o;
                        String string = this.$context.getString(R.string.please_select_gif);
                        p31.e(string, "getString(...)");
                        im1Var.o(new md3.f(string));
                    } else {
                        if (!this.this$0.t0(this.$uri, this.$context)) {
                            im1 im1Var2 = this.this$0.o;
                            String string2 = this.$context.getString(R.string.gif_file_cannot_access);
                            p31.e(string2, "getString(...)");
                            im1Var2.o(new md3.f(string2));
                            return k83.a;
                        }
                        VideoPushViewModel videoPushViewModel = this.this$0;
                        Uri uri = this.$uri;
                        String name2 = file2.getName();
                        p31.e(name2, "getName(...)");
                        Context context = this.$context;
                        this.L$0 = strT;
                        this.L$1 = file2;
                        this.label = 1;
                        Object objN = videoPushViewModel.N(uri, name2, context, this);
                        if (objN == objD) {
                            return objD;
                        }
                        str = strT;
                        obj = objN;
                        file = file2;
                    }
                    return k83.a;
                }
                im1 im1Var3 = this.this$0.o;
                String string3 = this.$context.getString(R.string.cannot_get_file_path_error);
                p31.e(string3, "getString(...)");
                im1Var3.o(new md3.f(string3));
                return k83.a;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            file = (File) this.L$1;
            str = (String) this.L$0;
            d.b(obj);
            String str2 = (String) obj;
            if (str2 != null && str2.length() != 0) {
                this.this$0.o.o(new md3.e(this.$uri));
                Log.d("VideoPushViewModel", "选择GIF路径: " + str);
                this.this$0.u = true;
                String name3 = file.getName();
                p31.e(name3, "getName(...)");
                this.this$0.o.o(new md3.k(new VideoInfo(str2, name3, this.$uri)));
                jn.b(Log.d("VideoPushViewModel", "GIF文件已准备，启动VideoCutActivity: " + str2));
                return k83.a;
            }
            im1 im1Var4 = this.this$0.o;
            String string4 = this.$context.getString(R.string.gif_file_cannot_process);
            p31.e(string4, "getString(...)");
            im1Var4.o(new md3.f(string4));
            return k83.a;
        } catch (Exception e) {
            Log.e("VideoPushViewModel", "处理系统相册GIF结果失败", e);
            im1 im1Var5 = this.this$0.o;
            String string5 = this.$context.getString(R.string.file_process_failed_retry_error);
            p31.e(string5, "getString(...)");
            im1Var5.o(new md3.f(string5));
        }
    }

    @Override // defpackage.or0
    public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
        return ((VideoPushViewModel$handleSystemGifResult$1) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
    }
}
