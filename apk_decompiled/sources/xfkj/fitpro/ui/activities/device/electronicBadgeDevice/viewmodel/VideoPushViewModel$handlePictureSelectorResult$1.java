package xfkj.fitpro.ui.activities.device.electronicBadgeDevice.viewmodel;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.blankj.utilcode.util.g;
import com.legend.smartwatch.electronicbadge.android.R;
import com.luck.picture.lib.entity.LocalMedia;
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
@h70(c = "xfkj.fitpro.ui.activities.device.electronicBadgeDevice.viewmodel.VideoPushViewModel$handlePictureSelectorResult$1", f = "VideoPushViewModel.kt", l = {1051, 1076, 1106, 1132}, m = "invokeSuspend")
final class VideoPushViewModel$handlePictureSelectorResult$1 extends SuspendLambda implements or0 {
    final /* synthetic */ Context $context;
    final /* synthetic */ LocalMedia $localMedia;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ VideoPushViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    VideoPushViewModel$handlePictureSelectorResult$1(LocalMedia localMedia, VideoPushViewModel videoPushViewModel, Context context, x30 x30Var) {
        super(2, x30Var);
        this.$localMedia = localMedia;
        this.this$0 = videoPushViewModel;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(Object obj, x30 x30Var) {
        return new VideoPushViewModel$handlePictureSelectorResult$1(this.$localMedia, this.this$0, this.$context, x30Var);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        String strT;
        File file;
        Object objN;
        String lowerCase;
        Object objN2;
        Object objN3;
        Uri uriFromFile;
        Object objN4;
        File file2;
        String str;
        String str2;
        String str3;
        String str4;
        Object objD = kotlin.coroutines.intrinsics.a.d();
        int i = this.label;
        try {
            if (i != 0) {
                if (i == 1) {
                    uriFromFile = (Uri) this.L$1;
                    file2 = (File) this.L$0;
                    d.b(obj);
                    objN4 = obj;
                    str = (String) objN4;
                    if (str != null && str.length() != 0) {
                        this.this$0.u = false;
                        String name = file2.getName();
                        p31.e(name, "getName(...)");
                        p31.c(uriFromFile);
                        this.this$0.o.o(new md3.k(new VideoInfo(str, name, uriFromFile)));
                    }
                    im1 im1Var = this.this$0.o;
                    String string = this.$context.getString(R.string.cannot_process_video_file);
                    p31.e(string, "getString(...)");
                    im1Var.o(new md3.f(string));
                    return k83.a;
                }
                if (i == 2) {
                    File file3 = (File) this.L$0;
                    d.b(obj);
                    file = file3;
                    objN = obj;
                    str2 = (String) objN;
                    if (str2 != null && str2.length() != 0) {
                        this.this$0.u = true;
                        String name2 = file.getName();
                        p31.e(name2, "getName(...)");
                        Uri uriFromFile2 = Uri.fromFile(file);
                        p31.e(uriFromFile2, "fromFile(...)");
                        this.this$0.o.o(new md3.k(new VideoInfo(str2, name2, uriFromFile2)));
                        jn.b(Log.d("VideoPushViewModel", "GIF文件已准备，启动VideoCutActivity: " + str2));
                    }
                    im1 im1Var2 = this.this$0.o;
                    String string2 = this.$context.getString(R.string.gif_file_cannot_process);
                    p31.e(string2, "getString(...)");
                    im1Var2.o(new md3.f(string2));
                    return k83.a;
                }
                if (i == 3) {
                    File file4 = (File) this.L$0;
                    d.b(obj);
                    file = file4;
                    objN3 = obj;
                    str3 = (String) objN3;
                    if (str3 != null && str3.length() != 0) {
                        String name3 = file.getName();
                        p31.e(name3, "getName(...)");
                        Uri uriFromFile3 = Uri.fromFile(file);
                        p31.e(uriFromFile3, "fromFile(...)");
                        this.this$0.o.o(new md3.k(new VideoInfo(str3, name3, uriFromFile3)));
                    }
                    im1 im1Var3 = this.this$0.o;
                    String string3 = this.$context.getString(R.string.cannot_process_video_file_error);
                    p31.e(string3, "getString(...)");
                    im1Var3.o(new md3.f(string3));
                    return k83.a;
                }
                if (i != 4) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                File file5 = (File) this.L$0;
                d.b(obj);
                file = file5;
                objN2 = obj;
                str4 = (String) objN2;
                if (str4 != null && str4.length() != 0) {
                    this.this$0.u = true;
                    String name4 = file.getName();
                    p31.e(name4, "getName(...)");
                    Uri uriFromFile4 = Uri.fromFile(file);
                    p31.e(uriFromFile4, "fromFile(...)");
                    this.this$0.o.o(new md3.k(new VideoInfo(str4, name4, uriFromFile4)));
                    jn.b(Log.d("VideoPushViewModel", "通过MIME类型识别为GIF，启动VideoCutActivity: " + str4));
                }
                im1 im1Var4 = this.this$0.o;
                String string4 = this.$context.getString(R.string.gif_file_cannot_process);
                p31.e(string4, "getString(...)");
                im1Var4.o(new md3.f(string4));
                return k83.a;
            }
            d.b(obj);
            Log.d("VideoPushViewModel", "PictureSelector 返回结果: " + this.$localMedia.q());
            this.this$0.h0();
            String strI = this.$localMedia.i();
            if (strI == null && (strI = this.$localMedia.c()) == null) {
                strI = this.$localMedia.q();
            }
            if (strI != null && strI.length() != 0) {
                if (i.G(strI, "content://", false, 2, null)) {
                    VideoPushViewModel videoPushViewModel = this.this$0;
                    Uri uri = Uri.parse(strI);
                    p31.e(uri, "parse(...)");
                    strT = videoPushViewModel.T(uri, this.$context);
                } else {
                    strT = strI;
                }
                if (strT != null && strT.length() != 0) {
                    file = new File(strT);
                    String strM = g.m(strT);
                    p31.e(strM, "getFileExtension(...)");
                    Locale locale = Locale.ROOT;
                    String lowerCase2 = strM.toLowerCase(locale);
                    p31.e(lowerCase2, "toLowerCase(...)");
                    String name5 = file.getName();
                    p31.e(name5, "getName(...)");
                    String lowerCase3 = name5.toLowerCase(locale);
                    p31.e(lowerCase3, "toLowerCase(...)");
                    if (this.this$0.d0(lowerCase2, lowerCase3)) {
                        if (file.exists() && file.canRead()) {
                            uriFromFile = Uri.fromFile(file);
                            VideoPushViewModel videoPushViewModel2 = this.this$0;
                            p31.c(uriFromFile);
                            String name6 = file.getName();
                            p31.e(name6, "getName(...)");
                            Context context = this.$context;
                            this.L$0 = file;
                            this.L$1 = uriFromFile;
                            this.label = 1;
                            objN4 = videoPushViewModel2.N(uriFromFile, name6, context, this);
                            if (objN4 == objD) {
                                return objD;
                            }
                            file2 = file;
                            str = (String) objN4;
                            if (str != null) {
                                this.this$0.u = false;
                                String name7 = file2.getName();
                                p31.e(name7, "getName(...)");
                                p31.c(uriFromFile);
                                this.this$0.o.o(new md3.k(new VideoInfo(str, name7, uriFromFile)));
                            }
                            im1 im1Var5 = this.this$0.o;
                            String string5 = this.$context.getString(R.string.cannot_process_video_file);
                            p31.e(string5, "getString(...)");
                            im1Var5.o(new md3.f(string5));
                            return k83.a;
                        }
                        im1 im1Var6 = this.this$0.o;
                        String string6 = this.$context.getString(R.string.video_file_cannot_access_error);
                        p31.e(string6, "getString(...)");
                        im1Var6.o(new md3.f(string6));
                        return k83.a;
                    }
                    if (p31.a(lowerCase2, "gif") || i.u(lowerCase3, ".gif", false, 2, null)) {
                        Uri uriFromFile5 = Uri.fromFile(file);
                        im1 im1Var7 = this.this$0.o;
                        p31.c(uriFromFile5);
                        im1Var7.o(new md3.e(uriFromFile5));
                        Log.d("VideoPushViewModel", "选择GIF路径: " + strI);
                        VideoPushViewModel videoPushViewModel3 = this.this$0;
                        Uri uriFromFile6 = Uri.fromFile(file);
                        p31.e(uriFromFile6, "fromFile(...)");
                        String name8 = file.getName();
                        p31.e(name8, "getName(...)");
                        Context context2 = this.$context;
                        this.L$0 = file;
                        this.label = 2;
                        objN = videoPushViewModel3.N(uriFromFile6, name8, context2, this);
                        if (objN == objD) {
                            return objD;
                        }
                        str2 = (String) objN;
                        if (str2 != null) {
                            this.this$0.u = true;
                            String name9 = file.getName();
                            p31.e(name9, "getName(...)");
                            Uri uriFromFile7 = Uri.fromFile(file);
                            p31.e(uriFromFile7, "fromFile(...)");
                            this.this$0.o.o(new md3.k(new VideoInfo(str2, name9, uriFromFile7)));
                            jn.b(Log.d("VideoPushViewModel", "GIF文件已准备，启动VideoCutActivity: " + str2));
                        }
                        im1 im1Var8 = this.this$0.o;
                        String string7 = this.$context.getString(R.string.gif_file_cannot_process);
                        p31.e(string7, "getString(...)");
                        im1Var8.o(new md3.f(string7));
                        return k83.a;
                    }
                    String strN = this.$localMedia.n();
                    if (strN != null) {
                        lowerCase = strN.toLowerCase(locale);
                        p31.e(lowerCase, "toLowerCase(...)");
                    } else {
                        lowerCase = null;
                    }
                    if (lowerCase != null && i.G(lowerCase, "video/", false, 2, null)) {
                        if (file.exists() && file.canRead()) {
                            Uri uriFromFile8 = Uri.fromFile(file);
                            VideoPushViewModel videoPushViewModel4 = this.this$0;
                            p31.c(uriFromFile8);
                            String name10 = file.getName();
                            p31.e(name10, "getName(...)");
                            Context context3 = this.$context;
                            this.L$0 = file;
                            this.label = 3;
                            objN3 = videoPushViewModel4.N(uriFromFile8, name10, context3, this);
                            if (objN3 == objD) {
                                return objD;
                            }
                            str3 = (String) objN3;
                            if (str3 != null) {
                                String name11 = file.getName();
                                p31.e(name11, "getName(...)");
                                Uri uriFromFile9 = Uri.fromFile(file);
                                p31.e(uriFromFile9, "fromFile(...)");
                                this.this$0.o.o(new md3.k(new VideoInfo(str3, name11, uriFromFile9)));
                            }
                            im1 im1Var9 = this.this$0.o;
                            String string8 = this.$context.getString(R.string.cannot_process_video_file_error);
                            p31.e(string8, "getString(...)");
                            im1Var9.o(new md3.f(string8));
                            return k83.a;
                        }
                        im1 im1Var10 = this.this$0.o;
                        String string9 = this.$context.getString(R.string.video_file_cannot_access);
                        p31.e(string9, "getString(...)");
                        im1Var10.o(new md3.f(string9));
                        return k83.a;
                    }
                    if (p31.a(lowerCase, "image/gif")) {
                        Uri uriFromFile10 = Uri.fromFile(file);
                        im1 im1Var11 = this.this$0.o;
                        p31.c(uriFromFile10);
                        im1Var11.o(new md3.e(uriFromFile10));
                        Log.d("VideoPushViewModel", "通过MIME类型识别为GIF: " + strI);
                        VideoPushViewModel videoPushViewModel5 = this.this$0;
                        Uri uriFromFile11 = Uri.fromFile(file);
                        p31.e(uriFromFile11, "fromFile(...)");
                        String name12 = file.getName();
                        p31.e(name12, "getName(...)");
                        Context context4 = this.$context;
                        this.L$0 = file;
                        this.label = 4;
                        objN2 = videoPushViewModel5.N(uriFromFile11, name12, context4, this);
                        if (objN2 == objD) {
                            return objD;
                        }
                        str4 = (String) objN2;
                        if (str4 != null) {
                            this.this$0.u = true;
                            String name13 = file.getName();
                            p31.e(name13, "getName(...)");
                            Uri uriFromFile12 = Uri.fromFile(file);
                            p31.e(uriFromFile12, "fromFile(...)");
                            this.this$0.o.o(new md3.k(new VideoInfo(str4, name13, uriFromFile12)));
                            jn.b(Log.d("VideoPushViewModel", "通过MIME类型识别为GIF，启动VideoCutActivity: " + str4));
                        }
                        im1 im1Var12 = this.this$0.o;
                        String string10 = this.$context.getString(R.string.gif_file_cannot_process);
                        p31.e(string10, "getString(...)");
                        im1Var12.o(new md3.f(string10));
                        return k83.a;
                    }
                    im1 im1Var13 = this.this$0.o;
                    String string11 = this.$context.getString(R.string.unsupported_file_format_select_video_gif);
                    p31.e(string11, "getString(...)");
                    im1Var13.o(new md3.f(string11));
                }
                im1 im1Var14 = this.this$0.o;
                String string12 = this.$context.getString(R.string.cannot_get_real_file_path_error_msg);
                p31.e(string12, "getString(...)");
                im1Var14.o(new md3.f(string12));
                return k83.a;
            }
            im1 im1Var15 = this.this$0.o;
            String string13 = this.$context.getString(R.string.file_path_get_failed_error);
            p31.e(string13, "getString(...)");
            im1Var15.o(new md3.f(string13));
            return k83.a;
        } catch (Exception e) {
            Log.e("VideoPushViewModel", "处理 PictureSelector 结果失败", e);
            im1 im1Var16 = this.this$0.o;
            String string14 = this.$context.getString(R.string.file_process_failed_retry_error);
            p31.e(string14, "getString(...)");
            im1Var16.o(new md3.f(string14));
        }
        return k83.a;
    }

    @Override // defpackage.or0
    public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
        return ((VideoPushViewModel$handlePictureSelectorResult$1) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
    }
}
