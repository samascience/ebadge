package xfkj.fitpro.ui.activities.device.electronicBadgeDevice.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.util.Log;
import androidx.lifecycle.p;
import com.baji.network.config.NetworkConfig;
import com.baji.protocol.BajiProtocolManager;
import com.blankj.utilcode.util.g;
import com.blankj.utilcode.util.n;
import com.legend.mywatch.sdk.mywatchsdklib.android.bluetooth.CommandPool;
import com.legend.smartwatch.electronicbadge.android.R;
import com.luck.picture.lib.entity.LocalMedia;
import com.tencent.connect.common.Constants;
import com.tencent.connect.share.QzonePublish;
import com.tenmeter.smlibrary.utils.FileUtils;
import defpackage.ar0;
import defpackage.cb0;
import defpackage.dn0;
import defpackage.im1;
import defpackage.k83;
import defpackage.md3;
import defpackage.nd3;
import defpackage.p31;
import defpackage.sg3;
import defpackage.t9;
import defpackage.ty;
import defpackage.u73;
import defpackage.x30;
import defpackage.y70;
import defpackage.yj0;
import defpackage.zi2;
import defpackage.zj0;
import java.io.File;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.j;
import kotlin.text.i;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import lombok.eclipse.Eclipse;
import org.objectweb.asm.Opcodes;
import xfkj.fitpro.manager.WatchThemeTransferManager;
import xfkj.fitpro.ui.activities.device.electronicBadgeDevice.viewmodel.VideoPushViewModel;

/* JADX INFO: loaded from: classes4.dex */
public final class VideoPushViewModel extends com.legend.smartwatch.app.base.viewmodel.a {
    public static final a x = new a(null);
    private final im1 m;
    private final im1 n;
    private final im1 o;
    private final im1 p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private BajiProtocolManager f405q;
    private boolean r;
    private Job s;
    private final WatchThemeTransferManager t;
    private boolean u;
    private int v;
    private int w;

    public static final class a {
        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class b {
        private final boolean a;
        private final String b;

        public b(boolean z, String str) {
            p31.f(str, "errorMessage");
            this.a = z;
            this.b = str;
        }

        public final String a() {
            return this.b;
        }

        public final boolean b() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.a == bVar.a && p31.a(this.b, bVar.b);
        }

        public int hashCode() {
            return (Boolean.hashCode(this.a) * 31) + this.b.hashCode();
        }

        public String toString() {
            return "FileValidationResult(isValid=" + this.a + ", errorMessage=" + this.b + ")";
        }
    }

    public static final class c implements WatchThemeTransferManager.c {
        final /* synthetic */ String a;
        final /* synthetic */ String b;
        final /* synthetic */ Context c;
        final /* synthetic */ long d;
        final /* synthetic */ VideoPushViewModel e;
        final /* synthetic */ nd3 f;

        c(String str, String str2, Context context, long j, VideoPushViewModel videoPushViewModel, nd3 nd3Var) {
            this.a = str;
            this.b = str2;
            this.c = context;
            this.d = j;
            this.e = videoPushViewModel;
            this.f = nd3Var;
        }

        @Override // xfkj.fitpro.manager.WatchThemeTransferManager.c
        public void a(String str) {
            p31.f(str, "errorMessage");
            this.e.o.o(new md3.g(str));
            nd3 nd3Var = this.f;
            this.e.m.o(nd3Var.a((4194299 & 1) != 0 ? nd3Var.a : null, (4194299 & 2) != 0 ? nd3Var.b : false, (4194299 & 4) != 0 ? nd3Var.c : false, (4194299 & 8) != 0 ? nd3Var.d : false, (4194299 & 16) != 0 ? nd3Var.e : null, (4194299 & 32) != 0 ? nd3Var.f : 0L, (4194299 & 64) != 0 ? nd3Var.g : 0L, (4194299 & 128) != 0 ? nd3Var.h : null, (4194299 & 256) != 0 ? nd3Var.i : false, (4194299 & 512) != 0 ? nd3Var.j : null, (4194299 & 1024) != 0 ? nd3Var.k : 0L, (4194299 & 2048) != 0 ? nd3Var.l : 0L, (4194299 & 4096) != 0 ? nd3Var.m : false, (4194299 & 8192) != 0 ? nd3Var.n : false, (4194299 & 16384) != 0 ? nd3Var.o : null, (4194299 & 32768) != 0 ? nd3Var.p : false, (4194299 & 65536) != 0 ? nd3Var.f362q : false, (4194299 & Opcodes.ACC_DEPRECATED) != 0 ? nd3Var.r : null, (4194299 & Opcodes.ASM4) != 0 ? nd3Var.s : false, (4194299 & Opcodes.ASM8) != 0 ? nd3Var.t : null, (4194299 & Eclipse.HasTypeAnnotations) != 0 ? nd3Var.u : null, (4194299 & 2097152) != 0 ? nd3Var.v : false));
            VideoPushViewModel videoPushViewModel = this.e;
            String string = this.c.getString(R.string.upload_failed_format_msg, this.a, str);
            p31.e(string, "getString(...)");
            videoPushViewModel.o0(string);
            Log.e("VideoPushViewModel", this.a + "上传失败: " + str);
        }

        @Override // xfkj.fitpro.manager.WatchThemeTransferManager.c
        public void b() {
            this.e.o.o(md3.i.a);
            nd3 nd3Var = this.f;
            this.e.m.o(nd3Var.a((4194299 & 1) != 0 ? nd3Var.a : null, (4194299 & 2) != 0 ? nd3Var.b : false, (4194299 & 4) != 0 ? nd3Var.c : false, (4194299 & 8) != 0 ? nd3Var.d : true, (4194299 & 16) != 0 ? nd3Var.e : null, (4194299 & 32) != 0 ? nd3Var.f : 0L, (4194299 & 64) != 0 ? nd3Var.g : this.d, (4194299 & 128) != 0 ? nd3Var.h : this.b, (4194299 & 256) != 0 ? nd3Var.i : false, (4194299 & 512) != 0 ? nd3Var.j : null, (4194299 & 1024) != 0 ? nd3Var.k : 0L, (4194299 & 2048) != 0 ? nd3Var.l : 0L, (4194299 & 4096) != 0 ? nd3Var.m : false, (4194299 & 8192) != 0 ? nd3Var.n : false, (4194299 & 16384) != 0 ? nd3Var.o : null, (4194299 & 32768) != 0 ? nd3Var.p : false, (4194299 & 65536) != 0 ? nd3Var.f362q : false, (4194299 & Opcodes.ACC_DEPRECATED) != 0 ? nd3Var.r : null, (4194299 & Opcodes.ASM4) != 0 ? nd3Var.s : false, (4194299 & Opcodes.ASM8) != 0 ? nd3Var.t : null, (4194299 & Eclipse.HasTypeAnnotations) != 0 ? nd3Var.u : null, (4194299 & 2097152) != 0 ? nd3Var.v : false));
            Log.d("VideoPushViewModel", this.a + "上传成功: " + this.b);
        }

        @Override // xfkj.fitpro.manager.WatchThemeTransferManager.c
        public void c() {
            Log.d("VideoPushViewModel", this.a + "传输开始: " + this.b);
            CommandPool.n(3);
        }

        @Override // xfkj.fitpro.manager.WatchThemeTransferManager.c
        public void d(int i) {
            long j = 1024;
            String string = this.c.getString(R.string.transfer_progress_format_with_size_msg, Integer.valueOf(i), Long.valueOf((this.d / j) / j));
            p31.e(string, "getString(...)");
            this.e.o.o(new md3.n(i, string));
            Log.d("VideoPushViewModel", this.a + "上传进度: " + i + "%");
        }
    }

    public VideoPushViewModel() {
        im1 im1Var = new im1(new nd3(null, false, false, false, null, 0L, 0L, null, false, null, 0L, 0L, false, false, null, false, false, null, false, null, null, false, 4194303, null));
        this.m = im1Var;
        this.n = im1Var;
        im1 im1Var2 = new im1();
        this.o = im1Var2;
        this.p = im1Var2;
        this.t = WatchThemeTransferManager.g.a();
        this.v = 5;
        this.w = 1;
    }

    private final nd3 F(nd3 nd3Var, String str, long j, Context context) {
        Long lValueOf;
        Long lD = nd3Var.d();
        if (lD != null) {
            lValueOf = Long.valueOf(cb0.a.b(lD.longValue()));
        } else {
            lValueOf = null;
        }
        boolean z = lValueOf != null && j > lValueOf.longValue();
        if (z && lValueOf != null) {
            im1 im1Var = this.o;
            cb0 cb0Var = cb0.a;
            String string = context.getString(R.string.video_exceeds_remaining_space, cb0Var.a(lValueOf.longValue()), cb0Var.a(j));
            p31.e(string, "getString(...)");
            im1Var.o(new md3.f(string));
        }
        return nd3Var.a((4194299 & 1) != 0 ? nd3Var.a : null, (4194299 & 2) != 0 ? nd3Var.b : false, (4194299 & 4) != 0 ? nd3Var.c : false, (4194299 & 8) != 0 ? nd3Var.d : false, (4194299 & 16) != 0 ? nd3Var.e : null, (4194299 & 32) != 0 ? nd3Var.f : 0L, (4194299 & 64) != 0 ? nd3Var.g : j, (4194299 & 128) != 0 ? nd3Var.h : null, (4194299 & 256) != 0 ? nd3Var.i : false, (4194299 & 512) != 0 ? nd3Var.j : null, (4194299 & 1024) != 0 ? nd3Var.k : 0L, (4194299 & 2048) != 0 ? nd3Var.l : 0L, (4194299 & 4096) != 0 ? nd3Var.m : false, (4194299 & 8192) != 0 ? nd3Var.n : false, (4194299 & 16384) != 0 ? nd3Var.o : null, (4194299 & 32768) != 0 ? nd3Var.p : false, (4194299 & 65536) != 0 ? nd3Var.f362q : false, (4194299 & Opcodes.ACC_DEPRECATED) != 0 ? nd3Var.r : null, (4194299 & Opcodes.ASM4) != 0 ? nd3Var.s : false, (4194299 & Opcodes.ASM8) != 0 ? nd3Var.t : str, (4194299 & Eclipse.HasTypeAnnotations) != 0 ? nd3Var.u : Long.valueOf(j), (4194299 & 2097152) != 0 ? nd3Var.v : z);
    }

    private final void H() {
        nd3 nd3Var = (nd3) this.m.f();
        if (nd3Var == null) {
            nd3Var = new nd3(null, false, false, false, null, 0L, 0L, null, false, null, 0L, 0L, false, false, null, false, false, null, false, null, null, false, 4194303, null);
        }
        nd3 nd3Var2 = nd3Var;
        this.m.o(nd3Var2.a((4194299 & 1) != 0 ? nd3Var2.a : null, (4194299 & 2) != 0 ? nd3Var2.b : false, (4194299 & 4) != 0 ? nd3Var2.c : false, (4194299 & 8) != 0 ? nd3Var2.d : false, (4194299 & 16) != 0 ? nd3Var2.e : null, (4194299 & 32) != 0 ? nd3Var2.f : 0L, (4194299 & 64) != 0 ? nd3Var2.g : 0L, (4194299 & 128) != 0 ? nd3Var2.h : null, (4194299 & 256) != 0 ? nd3Var2.i : false, (4194299 & 512) != 0 ? nd3Var2.j : null, (4194299 & 1024) != 0 ? nd3Var2.k : 0L, (4194299 & 2048) != 0 ? nd3Var2.l : 0L, (4194299 & 4096) != 0 ? nd3Var2.m : false, (4194299 & 8192) != 0 ? nd3Var2.n : false, (4194299 & 16384) != 0 ? nd3Var2.o : null, (4194299 & 32768) != 0 ? nd3Var2.p : false, (4194299 & 65536) != 0 ? nd3Var2.f362q : false, (4194299 & Opcodes.ACC_DEPRECATED) != 0 ? nd3Var2.r : null, (4194299 & Opcodes.ASM4) != 0 ? nd3Var2.s : false, (4194299 & Opcodes.ASM8) != 0 ? nd3Var2.t : null, (4194299 & Eclipse.HasTypeAnnotations) != 0 ? nd3Var2.u : null, (4194299 & 2097152) != 0 ? nd3Var2.v : false));
    }

    private final void L(String str, final String str2) {
        try {
            Log.d("VideoPushViewModel", "开始将AVI转换为MP4: " + str + " -> " + str2);
            com.arthenica.ffmpegkit.b.c("-y -i \"" + str + "\" -c:v libx264 -preset fast -crf 23 -pix_fmt yuv420p -c:a aac -b:a 64k -f mp4 \"" + str2 + "\"", new zj0() { // from class: od3
                @Override // defpackage.zj0
                public final void a(yj0 yj0Var) {
                    VideoPushViewModel.M(this.a, str2, yj0Var);
                }
            });
        } catch (Exception e) {
            Log.e("VideoPushViewModel", "AVI转MP4异常", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(VideoPushViewModel videoPushViewModel, String str, yj0 yj0Var) {
        BuildersKt__Builders_commonKt.launch$default(p.a(videoPushViewModel), null, null, new VideoPushViewModel$convertAviToMp4$1$1(yj0Var, str, videoPushViewModel, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object N(Uri uri, String str, Context context, x30 x30Var) {
        return BuildersKt.withContext(Dispatchers.getIO(), new VideoPushViewModel$copyVideoToSandbox$2(str, context, uri, null), x30Var);
    }

    private final void Q() {
        Job job = this.s;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.r = false;
        im1 im1Var = this.m;
        nd3 nd3Var = (nd3) im1Var.f();
        if (nd3Var == null) {
            nd3Var = new nd3(null, false, false, false, null, 0L, 0L, null, false, null, 0L, 0L, false, false, null, false, false, null, false, null, null, false, 4194303, null);
        }
        nd3 nd3Var2 = nd3Var;
        im1Var.o(nd3Var2.a((4194299 & 1) != 0 ? nd3Var2.a : null, (4194299 & 2) != 0 ? nd3Var2.b : false, (4194299 & 4) != 0 ? nd3Var2.c : false, (4194299 & 8) != 0 ? nd3Var2.d : false, (4194299 & 16) != 0 ? nd3Var2.e : null, (4194299 & 32) != 0 ? nd3Var2.f : 0L, (4194299 & 64) != 0 ? nd3Var2.g : 0L, (4194299 & 128) != 0 ? nd3Var2.h : null, (4194299 & 256) != 0 ? nd3Var2.i : false, (4194299 & 512) != 0 ? nd3Var2.j : null, (4194299 & 1024) != 0 ? nd3Var2.k : 0L, (4194299 & 2048) != 0 ? nd3Var2.l : 0L, (4194299 & 4096) != 0 ? nd3Var2.m : false, (4194299 & 8192) != 0 ? nd3Var2.n : false, (4194299 & 16384) != 0 ? nd3Var2.o : null, (4194299 & 32768) != 0 ? nd3Var2.p : false, (4194299 & 65536) != 0 ? nd3Var2.f362q : false, (4194299 & Opcodes.ACC_DEPRECATED) != 0 ? nd3Var2.r : null, (4194299 & Opcodes.ASM4) != 0 ? nd3Var2.s : false, (4194299 & Opcodes.ASM8) != 0 ? nd3Var2.t : null, (4194299 & Eclipse.HasTypeAnnotations) != 0 ? nd3Var2.u : null, (4194299 & 2097152) != 0 ? nd3Var2.v : false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String T(Uri uri, Context context) {
        int columnIndex;
        String string;
        int columnIndex2;
        String string2;
        String path;
        try {
            Log.d("VideoPushViewModel", "尝试获取真实文件路径: " + uri);
            if (p31.a(uri.getScheme(), "file") && (path = uri.getPath()) != null && new File(path).exists()) {
                Log.d("VideoPushViewModel", "从 file:// URI 获取到路径: " + path);
                return path;
            }
            Cursor cursorQuery = context.getContentResolver().query(uri, null, null, null, null);
            if (cursorQuery != null) {
                Cursor cursor = cursorQuery;
                try {
                    Cursor cursor2 = cursor;
                    if (cursor2.moveToFirst() && (columnIndex2 = cursor2.getColumnIndex("_data")) >= 0 && (string2 = cursor2.getString(columnIndex2)) != null && new File(string2).exists()) {
                        Log.d("VideoPushViewModel", "从视频媒体库获取到路径: " + string2);
                        ty.a(cursor, null);
                        return string2;
                    }
                    k83 k83Var = k83.a;
                    ty.a(cursor, null);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        ty.a(cursor, th);
                        throw th2;
                    }
                }
            }
            Cursor cursorQuery2 = context.getContentResolver().query(uri, null, null, null, null);
            if (cursorQuery2 != null) {
                Cursor cursor3 = cursorQuery2;
                try {
                    Cursor cursor4 = cursor3;
                    if (cursor4.moveToFirst() && (columnIndex = cursor4.getColumnIndex("_data")) >= 0 && (string = cursor4.getString(columnIndex)) != null && new File(string).exists()) {
                        Log.d("VideoPushViewModel", "从图片媒体库获取到路径: " + string);
                        ty.a(cursor3, null);
                        return string;
                    }
                    k83 k83Var2 = k83.a;
                    ty.a(cursor3, null);
                } catch (Throwable th3) {
                    try {
                        throw th3;
                    } catch (Throwable th4) {
                        ty.a(cursor3, th3);
                        throw th4;
                    }
                }
            }
            File fileL = g.l(uri.toString());
            if (fileL != null && fileL.exists()) {
                Log.d("VideoPushViewModel", "通过 FileUtils 获取到路径: " + fileL);
                return fileL.getAbsolutePath();
            }
            File fileE = n.e(uri);
            if (fileE == null || !g.o(fileE)) {
                Log.w("VideoPushViewModel", "无法获取真实文件路径: " + uri);
                return null;
            }
            Log.d("VideoPushViewModel", "通过 UriUtils.uri2File 获取到路径: " + fileL);
            return fileE.getAbsolutePath();
        } catch (Exception e) {
            Log.e("VideoPushViewModel", "获取真实文件路径失败", e);
        }
    }

    private final void a0(Context context) {
        nd3 nd3Var = (nd3) this.m.f();
        if (nd3Var == null) {
            return;
        }
        if (nd3Var.g() == null) {
            String string = context.getString(R.string.please_select_video_first_error);
            p31.e(string, "getString(...)");
            o0(string);
            return;
        }
        if (nd3Var.m()) {
            String string2 = context.getString(R.string.uploading_please_wait_error);
            p31.e(string2, "getString(...)");
            o0(string2);
        } else if (nd3Var.i()) {
            String string3 = context.getString(R.string.file_already_uploaded_error);
            p31.e(string3, "getString(...)");
            o0(string3);
        } else {
            if (nd3Var.k() != null) {
                p0(nd3Var.k(), context);
                return;
            }
            String string4 = context.getString(R.string.cannot_get_file_path_error_msg);
            p31.e(string4, "getString(...)");
            o0(string4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean d0(String str, String str2) {
        List listM = j.m("mp4", "avi", "mov", "mkv", "wmv", "flv", "webm");
        if (!listM.contains(str)) {
            if (listM.isEmpty()) {
                return false;
            }
            Iterator it = listM.iterator();
            while (it.hasNext()) {
                if (i.u(str2, FileUtils.FILE_EXTENSION_SEPARATOR + ((String) it.next()), false, 2, null)) {
                }
            }
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h0() {
        Log.d("VideoPushViewModel", "重置上传状态");
        nd3 nd3Var = (nd3) this.m.f();
        if (nd3Var == null) {
            return;
        }
        this.m.o(nd3Var.a((4194299 & 1) != 0 ? nd3Var.a : null, (4194299 & 2) != 0 ? nd3Var.b : false, (4194299 & 4) != 0 ? nd3Var.c : false, (4194299 & 8) != 0 ? nd3Var.d : false, (4194299 & 16) != 0 ? nd3Var.e : null, (4194299 & 32) != 0 ? nd3Var.f : 0L, (4194299 & 64) != 0 ? nd3Var.g : 0L, (4194299 & 128) != 0 ? nd3Var.h : null, (4194299 & 256) != 0 ? nd3Var.i : false, (4194299 & 512) != 0 ? nd3Var.j : null, (4194299 & 1024) != 0 ? nd3Var.k : 0L, (4194299 & 2048) != 0 ? nd3Var.l : 0L, (4194299 & 4096) != 0 ? nd3Var.m : false, (4194299 & 8192) != 0 ? nd3Var.n : false, (4194299 & 16384) != 0 ? nd3Var.o : null, (4194299 & 32768) != 0 ? nd3Var.p : false, (4194299 & 65536) != 0 ? nd3Var.f362q : false, (4194299 & Opcodes.ACC_DEPRECATED) != 0 ? nd3Var.r : null, (4194299 & Opcodes.ASM4) != 0 ? nd3Var.s : false, (4194299 & Opcodes.ASM8) != 0 ? nd3Var.t : null, (4194299 & Eclipse.HasTypeAnnotations) != 0 ? nd3Var.u : null, (4194299 & 2097152) != 0 ? nd3Var.v : false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j0(boolean z) {
        nd3 nd3Var = (nd3) this.m.f();
        if (nd3Var == null) {
            nd3Var = new nd3(null, false, false, false, null, 0L, 0L, null, false, null, 0L, 0L, false, false, null, false, false, null, false, null, null, false, 4194303, null);
        }
        nd3 nd3Var2 = nd3Var;
        this.m.o(nd3Var2.a((4194299 & 1) != 0 ? nd3Var2.a : null, (4194299 & 2) != 0 ? nd3Var2.b : false, (4194299 & 4) != 0 ? nd3Var2.c : z, (4194299 & 8) != 0 ? nd3Var2.d : false, (4194299 & 16) != 0 ? nd3Var2.e : null, (4194299 & 32) != 0 ? nd3Var2.f : 0L, (4194299 & 64) != 0 ? nd3Var2.g : 0L, (4194299 & 128) != 0 ? nd3Var2.h : null, (4194299 & 256) != 0 ? nd3Var2.i : false, (4194299 & 512) != 0 ? nd3Var2.j : null, (4194299 & 1024) != 0 ? nd3Var2.k : 0L, (4194299 & 2048) != 0 ? nd3Var2.l : 0L, (4194299 & 4096) != 0 ? nd3Var2.m : false, (4194299 & 8192) != 0 ? nd3Var2.n : false, (4194299 & 16384) != 0 ? nd3Var2.o : null, (4194299 & 32768) != 0 ? nd3Var2.p : false, (4194299 & 65536) != 0 ? nd3Var2.f362q : false, (4194299 & Opcodes.ACC_DEPRECATED) != 0 ? nd3Var2.r : null, (4194299 & Opcodes.ASM4) != 0 ? nd3Var2.s : false, (4194299 & Opcodes.ASM8) != 0 ? nd3Var2.t : null, (4194299 & Eclipse.HasTypeAnnotations) != 0 ? nd3Var2.u : null, (4194299 & 2097152) != 0 ? nd3Var2.v : false));
    }

    private final void k0(Uri uri) {
        nd3 nd3Var = (nd3) this.m.f();
        if (nd3Var == null) {
            nd3Var = new nd3(null, false, false, false, null, 0L, 0L, null, false, null, 0L, 0L, false, false, null, false, false, null, false, null, null, false, 4194303, null);
        }
        nd3 nd3Var2 = nd3Var;
        this.m.o(nd3Var2.a((4194299 & 1) != 0 ? nd3Var2.a : uri, (4194299 & 2) != 0 ? nd3Var2.b : true, (4194299 & 4) != 0 ? nd3Var2.c : false, (4194299 & 8) != 0 ? nd3Var2.d : false, (4194299 & 16) != 0 ? nd3Var2.e : null, (4194299 & 32) != 0 ? nd3Var2.f : 0L, (4194299 & 64) != 0 ? nd3Var2.g : 0L, (4194299 & 128) != 0 ? nd3Var2.h : null, (4194299 & 256) != 0 ? nd3Var2.i : false, (4194299 & 512) != 0 ? nd3Var2.j : null, (4194299 & 1024) != 0 ? nd3Var2.k : 0L, (4194299 & 2048) != 0 ? nd3Var2.l : 0L, (4194299 & 4096) != 0 ? nd3Var2.m : false, (4194299 & 8192) != 0 ? nd3Var2.n : false, (4194299 & 16384) != 0 ? nd3Var2.o : null, (4194299 & 32768) != 0 ? nd3Var2.p : false, (4194299 & 65536) != 0 ? nd3Var2.f362q : false, (4194299 & Opcodes.ACC_DEPRECATED) != 0 ? nd3Var2.r : null, (4194299 & Opcodes.ASM4) != 0 ? nd3Var2.s : false, (4194299 & Opcodes.ASM8) != 0 ? nd3Var2.t : null, (4194299 & Eclipse.HasTypeAnnotations) != 0 ? nd3Var2.u : null, (4194299 & 2097152) != 0 ? nd3Var2.v : false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o0(String str) {
        nd3 nd3Var = (nd3) this.m.f();
        if (nd3Var == null) {
            nd3Var = new nd3(null, false, false, false, null, 0L, 0L, null, false, null, 0L, 0L, false, false, null, false, false, null, false, null, null, false, 4194303, null);
        }
        nd3 nd3Var2 = nd3Var;
        this.m.o(nd3Var2.a((4194299 & 1) != 0 ? nd3Var2.a : null, (4194299 & 2) != 0 ? nd3Var2.b : false, (4194299 & 4) != 0 ? nd3Var2.c : false, (4194299 & 8) != 0 ? nd3Var2.d : false, (4194299 & 16) != 0 ? nd3Var2.e : str, (4194299 & 32) != 0 ? nd3Var2.f : 0L, (4194299 & 64) != 0 ? nd3Var2.g : 0L, (4194299 & 128) != 0 ? nd3Var2.h : null, (4194299 & 256) != 0 ? nd3Var2.i : false, (4194299 & 512) != 0 ? nd3Var2.j : null, (4194299 & 1024) != 0 ? nd3Var2.k : 0L, (4194299 & 2048) != 0 ? nd3Var2.l : 0L, (4194299 & 4096) != 0 ? nd3Var2.m : false, (4194299 & 8192) != 0 ? nd3Var2.n : false, (4194299 & 16384) != 0 ? nd3Var2.o : null, (4194299 & 32768) != 0 ? nd3Var2.p : false, (4194299 & 65536) != 0 ? nd3Var2.f362q : false, (4194299 & Opcodes.ACC_DEPRECATED) != 0 ? nd3Var2.r : null, (4194299 & Opcodes.ASM4) != 0 ? nd3Var2.s : false, (4194299 & Opcodes.ASM8) != 0 ? nd3Var2.t : null, (4194299 & Eclipse.HasTypeAnnotations) != 0 ? nd3Var2.u : null, (4194299 & 2097152) != 0 ? nd3Var2.v : false));
    }

    private final void p0(String str, Context context) {
        j0(true);
        BuildersKt__Builders_commonKt.launch$default(p.a(this), null, null, new VideoPushViewModel$startUploadProcess$1(this, str, context, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b s0(String str, Context context) {
        File file = new File(str);
        if (!file.exists()) {
            String string = context.getString(R.string.file_not_exist_error);
            p31.e(string, "getString(...)");
            return new b(false, string);
        }
        long length = file.length();
        if (length == 0) {
            String string2 = context.getString(R.string.file_is_empty_error);
            p31.e(string2, "getString(...)");
            return new b(false, string2);
        }
        if (length > NetworkConfig.DEFAULT_MAX_FILE_SIZE) {
            String string3 = context.getString(R.string.file_too_large_error);
            p31.e(string3, "getString(...)");
            return new b(false, string3);
        }
        String lowerCase = dn0.b(file).toLowerCase(Locale.ROOT);
        p31.e(lowerCase, "toLowerCase(...)");
        if (j.m("mp4", "avi", "mov", "wmv", "flv", "mkv", "gif").contains(lowerCase)) {
            return new b(true, Constants.STR_EMPTY);
        }
        String string4 = context.getString(R.string.unsupported_file_format_error, lowerCase);
        p31.e(string4, "getString(...)");
        return new b(false, string4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean t0(Uri uri, Context context) {
        try {
            InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
            if (inputStreamOpenInputStream != null) {
                inputStreamOpenInputStream.close();
            }
            return inputStreamOpenInputStream != null;
        } catch (Exception e) {
            Log.e("VideoPushViewModel", "文件访问验证失败", e);
            return false;
        }
    }

    public final void G(Context context) {
        p31.f(context, "context");
        try {
            File file = new File(context.getExternalFilesDir(null), "video_previews");
            if (file.exists()) {
                File[] fileArrListFiles = file.listFiles();
                if (fileArrListFiles != null) {
                    Iterator itA = t9.a(fileArrListFiles);
                    while (itA.hasNext()) {
                        File file2 = (File) itA.next();
                        if (file2.exists()) {
                            file2.delete();
                        }
                    }
                }
                Log.d("VideoPushViewModel", "预览文件清理完成");
            }
        } catch (Exception e) {
            Log.e("VideoPushViewModel", "清理预览文件失败", e);
        }
    }

    public final void I() {
        this.o.o(null);
    }

    public final void J() {
        nd3 nd3Var = (nd3) this.m.f();
        if (nd3Var == null) {
            return;
        }
        if (nd3Var.h() == null && nd3Var.j() == null && !nd3Var.o()) {
            return;
        }
        this.m.o(nd3Var.a((4194299 & 1) != 0 ? nd3Var.a : null, (4194299 & 2) != 0 ? nd3Var.b : false, (4194299 & 4) != 0 ? nd3Var.c : false, (4194299 & 8) != 0 ? nd3Var.d : false, (4194299 & 16) != 0 ? nd3Var.e : null, (4194299 & 32) != 0 ? nd3Var.f : 0L, (4194299 & 64) != 0 ? nd3Var.g : 0L, (4194299 & 128) != 0 ? nd3Var.h : null, (4194299 & 256) != 0 ? nd3Var.i : false, (4194299 & 512) != 0 ? nd3Var.j : null, (4194299 & 1024) != 0 ? nd3Var.k : 0L, (4194299 & 2048) != 0 ? nd3Var.l : 0L, (4194299 & 4096) != 0 ? nd3Var.m : false, (4194299 & 8192) != 0 ? nd3Var.n : false, (4194299 & 16384) != 0 ? nd3Var.o : null, (4194299 & 32768) != 0 ? nd3Var.p : false, (4194299 & 65536) != 0 ? nd3Var.f362q : false, (4194299 & Opcodes.ACC_DEPRECATED) != 0 ? nd3Var.r : null, (4194299 & Opcodes.ASM4) != 0 ? nd3Var.s : false, (4194299 & Opcodes.ASM8) != 0 ? nd3Var.t : null, (4194299 & Eclipse.HasTypeAnnotations) != 0 ? nd3Var.u : null, (4194299 & 2097152) != 0 ? nd3Var.v : false));
    }

    public final void K(Uri uri, Context context, ar0 ar0Var) {
        p31.f(uri, "aviUri");
        p31.f(context, "context");
        p31.f(ar0Var, "callback");
        BuildersKt__Builders_commonKt.launch$default(p.a(this), null, null, new VideoPushViewModel$convertAviToGif$1(uri, ar0Var, context, this, null), 3, null);
    }

    public final Intent O() {
        Intent intent;
        try {
            Log.d("VideoPushViewModel", "创建系统 GIF 选择 Intent");
            if (Build.VERSION.SDK_INT >= 35) {
                Log.d("VideoPushViewModel", "使用 Intent.ACTION_GET_CONTENT (Android 16+)");
                intent = new Intent("android.intent.action.GET_CONTENT");
                intent.setType("image/gif");
                intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", false);
                intent.addCategory("android.intent.category.OPENABLE");
            } else {
                Log.d("VideoPushViewModel", "使用 Intent.ACTION_PICK (Android 16 以下)");
                intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                intent.setType("image/gif");
                intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", false);
            }
            return intent;
        } catch (Exception e) {
            Log.e("VideoPushViewModel", "无法创建系统 GIF 选择 Intent", e);
            im1 im1Var = this.o;
            String strB = u73.b(R.string.gif_picker_error_tips);
            p31.e(strB, "getString(...)");
            im1Var.o(new md3.f(strB));
            return null;
        }
    }

    public final Intent P() {
        Intent intent;
        try {
            Log.d("VideoPushViewModel", "创建系统视频选择 Intent");
            if (Build.VERSION.SDK_INT >= 35) {
                Log.d("VideoPushViewModel", "使用 Intent.ACTION_GET_CONTENT (Android 16+)");
                intent = new Intent("android.intent.action.GET_CONTENT");
                intent.setType("video/*");
                intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", false);
                intent.addCategory("android.intent.category.OPENABLE");
            } else {
                Log.d("VideoPushViewModel", "使用 Intent.ACTION_PICK (Android 16 以下)");
                intent = new Intent("android.intent.action.PICK", MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
                intent.setType("video/*");
                intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", false);
            }
            return intent;
        } catch (Exception e) {
            Log.e("VideoPushViewModel", "无法创建系统视频选择 Intent", e);
            im1 im1Var = this.o;
            String strB = u73.b(R.string.video_picker_error_tips);
            p31.e(strB, "getString(...)");
            im1Var.o(new md3.f(strB));
            return null;
        }
    }

    public final int R() {
        return this.w;
    }

    public final im1 S() {
        return this.p;
    }

    public final int U() {
        return this.v;
    }

    public final im1 V() {
        return this.n;
    }

    public final void W(md3 md3Var) {
        p31.f(md3Var, "event");
        if (md3Var instanceof md3.d) {
            this.o.o(md3.d.a);
            return;
        }
        if (md3Var instanceof md3.c) {
            this.o.o(md3.c.a);
            return;
        }
        if (md3Var instanceof md3.p) {
            a0(((md3.p) md3Var).a());
            return;
        }
        if (md3Var instanceof md3.e) {
            k0(((md3.e) md3Var).a());
            return;
        }
        if (md3Var instanceof md3.f) {
            o0(((md3.f) md3Var).a());
            return;
        }
        if (md3Var instanceof md3.a) {
            H();
            return;
        }
        if (md3Var instanceof md3.o) {
            nd3 nd3Var = (nd3) this.m.f();
            if (nd3Var == null) {
                nd3Var = new nd3(null, false, false, false, null, 0L, 0L, null, false, null, 0L, 0L, false, false, null, false, false, null, false, null, null, false, 4194303, null);
            }
            nd3 nd3Var2 = nd3Var;
            this.m.o(nd3Var2.a((4194299 & 1) != 0 ? nd3Var2.a : null, (4194299 & 2) != 0 ? nd3Var2.b : false, (4194299 & 4) != 0 ? nd3Var2.c : false, (4194299 & 8) != 0 ? nd3Var2.d : true, (4194299 & 16) != 0 ? nd3Var2.e : null, (4194299 & 32) != 0 ? nd3Var2.f : 0L, (4194299 & 64) != 0 ? nd3Var2.g : 0L, (4194299 & 128) != 0 ? nd3Var2.h : null, (4194299 & 256) != 0 ? nd3Var2.i : false, (4194299 & 512) != 0 ? nd3Var2.j : null, (4194299 & 1024) != 0 ? nd3Var2.k : 0L, (4194299 & 2048) != 0 ? nd3Var2.l : 0L, (4194299 & 4096) != 0 ? nd3Var2.m : false, (4194299 & 8192) != 0 ? nd3Var2.n : false, (4194299 & 16384) != 0 ? nd3Var2.o : null, (4194299 & 32768) != 0 ? nd3Var2.p : false, (4194299 & 65536) != 0 ? nd3Var2.f362q : false, (4194299 & Opcodes.ACC_DEPRECATED) != 0 ? nd3Var2.r : null, (4194299 & Opcodes.ASM4) != 0 ? nd3Var2.s : false, (4194299 & Opcodes.ASM8) != 0 ? nd3Var2.t : null, (4194299 & Eclipse.HasTypeAnnotations) != 0 ? nd3Var2.u : null, (4194299 & 2097152) != 0 ? nd3Var2.v : false));
            return;
        }
        if (md3Var instanceof md3.m) {
            j0(false);
            o0(((md3.m) md3Var).a());
            return;
        }
        if (md3Var instanceof md3.b) {
            this.o.o(new md3.b(((md3.b) md3Var).a()));
            return;
        }
        if (md3Var instanceof md3.n) {
            this.o.o(md3Var);
            return;
        }
        if (md3Var instanceof md3.h) {
            this.o.o(md3Var);
            return;
        }
        if (md3Var instanceof md3.i) {
            this.o.o(md3Var);
            return;
        }
        if (md3Var instanceof md3.g) {
            this.o.o(md3Var);
            return;
        }
        if (md3Var instanceof md3.k) {
            this.o.o(new md3.k(((md3.k) md3Var).a()));
        } else if (md3Var instanceof md3.j) {
            this.o.o(md3.j.a);
        } else {
            if (!(md3Var instanceof md3.l)) {
                throw new NoWhenBranchMatchedException();
            }
            this.o.o(md3.l.a);
        }
    }

    public final void X(LocalMedia localMedia, Context context) {
        p31.f(localMedia, "localMedia");
        p31.f(context, "context");
        BuildersKt__Builders_commonKt.launch$default(p.a(this), null, null, new VideoPushViewModel$handlePictureSelectorResult$1(localMedia, this, context, null), 3, null);
    }

    public final void Y(Uri uri, Context context) {
        p31.f(uri, "uri");
        p31.f(context, "context");
        BuildersKt__Builders_commonKt.launch$default(p.a(this), null, null, new VideoPushViewModel$handleSystemGalleryResult$1(uri, this, context, null), 3, null);
    }

    public final void Z(Uri uri, Context context) {
        p31.f(uri, "uri");
        p31.f(context, "context");
        BuildersKt__Builders_commonKt.launch$default(p.a(this), null, null, new VideoPushViewModel$handleSystemGifResult$1(uri, this, context, null), 3, null);
    }

    public final void b0(String str, Context context) {
        p31.f(str, "trimmedVideoPath");
        p31.f(context, "context");
        Log.d("VideoPushViewModel", "视频裁剪完成，输出为AVI格式: " + str);
        File file = new File(str);
        if (!file.exists()) {
            Log.e("VideoPushViewModel", "裁剪后的AVI文件不存在: " + str);
            im1 im1Var = this.o;
            String string = context.getString(R.string.video_crop_failed_file_not_exist);
            p31.e(string, "getString(...)");
            im1Var.o(new md3.f(string));
            return;
        }
        Log.d("VideoPushViewModel", "裁剪后的AVI文件信息:");
        Log.d("VideoPushViewModel", "  文件路径: " + str);
        Log.d("VideoPushViewModel", "  文件大小: " + file.length() + " bytes");
        Log.d("VideoPushViewModel", "  文件最后修改时间: " + file.lastModified());
        Log.d("VideoPushViewModel", "  文件可读: " + file.canRead());
        Log.d("VideoPushViewModel", "  文件可写: " + file.canWrite());
        long length = file.length();
        nd3 nd3Var = (nd3) this.m.f();
        if (nd3Var == null) {
            return;
        }
        Uri uriFromFile = Uri.fromFile(file);
        nd3 nd3VarF = F(nd3Var, str, length, context);
        boolean z = this.u;
        this.m.o(nd3VarF.a((4194299 & 1) != 0 ? nd3VarF.a : uriFromFile, (4194299 & 2) != 0 ? nd3VarF.b : true, (4194299 & 4) != 0 ? nd3VarF.c : false, (4194299 & 8) != 0 ? nd3VarF.d : false, (4194299 & 16) != 0 ? nd3VarF.e : null, (4194299 & 32) != 0 ? nd3VarF.f : 0L, (4194299 & 64) != 0 ? nd3VarF.g : 0L, (4194299 & 128) != 0 ? nd3VarF.h : str, (4194299 & 256) != 0 ? nd3VarF.i : true, (4194299 & 512) != 0 ? nd3VarF.j : str, (4194299 & 1024) != 0 ? nd3VarF.k : 0L, (4194299 & 2048) != 0 ? nd3VarF.l : 0L, (4194299 & 4096) != 0 ? nd3VarF.m : !z, (4194299 & 8192) != 0 ? nd3VarF.n : z, (4194299 & 16384) != 0 ? nd3VarF.o : str, (4194299 & 32768) != 0 ? nd3VarF.p : false, (4194299 & 65536) != 0 ? nd3VarF.f362q : false, (4194299 & Opcodes.ACC_DEPRECATED) != 0 ? nd3VarF.r : null, (4194299 & Opcodes.ASM4) != 0 ? nd3VarF.s : false, (4194299 & Opcodes.ASM8) != 0 ? nd3VarF.t : null, (4194299 & Eclipse.HasTypeAnnotations) != 0 ? nd3VarF.u : null, (4194299 & 2097152) != 0 ? nd3VarF.v : false));
        im1 im1Var2 = this.o;
        p31.c(uriFromFile);
        im1Var2.o(new md3.e(uriFromFile));
        L(str, i.A(str, ".avi", ".mp4", true));
        BuildersKt__Builders_commonKt.launch$default(p.a(this), null, null, new VideoPushViewModel$handleVideoTrimResult$1(this, context, null), 3, null);
    }

    public final void c0(sg3 sg3Var) {
        p31.f(sg3Var, "event");
        if (this.r) {
            Job job = this.s;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            this.r = false;
            long jA = sg3Var.a();
            nd3 nd3Var = (nd3) this.m.f();
            if (nd3Var == null) {
                nd3Var = new nd3(null, false, false, false, null, 0L, 0L, null, false, null, 0L, 0L, false, false, null, false, false, null, false, null, null, false, 4194303, null);
            }
            nd3 nd3Var2 = nd3Var;
            Long lH = nd3Var2.h();
            this.m.o(nd3Var2.a((4194299 & 1) != 0 ? nd3Var2.a : null, (4194299 & 2) != 0 ? nd3Var2.b : false, (4194299 & 4) != 0 ? nd3Var2.c : false, (4194299 & 8) != 0 ? nd3Var2.d : false, (4194299 & 16) != 0 ? nd3Var2.e : null, (4194299 & 32) != 0 ? nd3Var2.f : 0L, (4194299 & 64) != 0 ? nd3Var2.g : 0L, (4194299 & 128) != 0 ? nd3Var2.h : null, (4194299 & 256) != 0 ? nd3Var2.i : false, (4194299 & 512) != 0 ? nd3Var2.j : null, (4194299 & 1024) != 0 ? nd3Var2.k : 0L, (4194299 & 2048) != 0 ? nd3Var2.l : 0L, (4194299 & 4096) != 0 ? nd3Var2.m : false, (4194299 & 8192) != 0 ? nd3Var2.n : false, (4194299 & 16384) != 0 ? nd3Var2.o : null, (4194299 & 32768) != 0 ? nd3Var2.p : false, (4194299 & 65536) != 0 ? nd3Var2.f362q : false, (4194299 & Opcodes.ACC_DEPRECATED) != 0 ? nd3Var2.r : Long.valueOf(jA), (4194299 & Opcodes.ASM4) != 0 ? nd3Var2.s : false, (4194299 & Opcodes.ASM8) != 0 ? nd3Var2.t : null, (4194299 & Eclipse.HasTypeAnnotations) != 0 ? nd3Var2.u : null, (4194299 & 2097152) != 0 ? nd3Var2.v : lH != null && lH.longValue() > cb0.a.b(jA)));
            Log.d(h(), "表盘剩余空间: " + jA + " bytes");
        }
    }

    @Override // com.legend.smartwatch.app.base.viewmodel.a, androidx.lifecycle.o
    protected void d() {
        Job job = this.s;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        super.d();
    }

    public final void e0(String str, Context context) {
        p31.f(str, "filePath");
        p31.f(context, "context");
        File file = new File(str);
        if (file.exists() && file.length() > 0) {
            nd3 nd3Var = (nd3) this.m.f();
            if (nd3Var == null) {
                nd3Var = new nd3(null, false, false, false, null, 0L, 0L, null, false, null, 0L, 0L, false, false, null, false, false, null, false, null, null, false, 4194303, null);
            }
            this.m.o(F(nd3Var, str, file.length(), context));
            return;
        }
        Log.w(h(), "待上传视频文件无效: " + str);
        J();
    }

    public final void f0() {
        if (!zi2.i()) {
            this.r = false;
            Job job = this.s;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            im1 im1Var = this.m;
            nd3 nd3Var = (nd3) im1Var.f();
            if (nd3Var == null) {
                nd3Var = new nd3(null, false, false, false, null, 0L, 0L, null, false, null, 0L, 0L, false, false, null, false, false, null, false, null, null, false, 4194303, null);
            }
            nd3 nd3Var2 = nd3Var;
            im1Var.o(nd3Var2.a((4194299 & 1) != 0 ? nd3Var2.a : null, (4194299 & 2) != 0 ? nd3Var2.b : false, (4194299 & 4) != 0 ? nd3Var2.c : false, (4194299 & 8) != 0 ? nd3Var2.d : false, (4194299 & 16) != 0 ? nd3Var2.e : null, (4194299 & 32) != 0 ? nd3Var2.f : 0L, (4194299 & 64) != 0 ? nd3Var2.g : 0L, (4194299 & 128) != 0 ? nd3Var2.h : null, (4194299 & 256) != 0 ? nd3Var2.i : false, (4194299 & 512) != 0 ? nd3Var2.j : null, (4194299 & 1024) != 0 ? nd3Var2.k : 0L, (4194299 & 2048) != 0 ? nd3Var2.l : 0L, (4194299 & 4096) != 0 ? nd3Var2.m : false, (4194299 & 8192) != 0 ? nd3Var2.n : false, (4194299 & 16384) != 0 ? nd3Var2.o : null, (4194299 & 32768) != 0 ? nd3Var2.p : false, (4194299 & 65536) != 0 ? nd3Var2.f362q : false, (4194299 & Opcodes.ACC_DEPRECATED) != 0 ? nd3Var2.r : null, (4194299 & Opcodes.ASM4) != 0 ? nd3Var2.s : false, (4194299 & Opcodes.ASM8) != 0 ? nd3Var2.t : null, (4194299 & Eclipse.HasTypeAnnotations) != 0 ? nd3Var2.u : null, (4194299 & 2097152) != 0 ? nd3Var2.v : false));
            String strB = u73.b(R.string.bluetooth_not_connected);
            p31.e(strB, "getString(...)");
            o0(strB);
            return;
        }
        Job job2 = this.s;
        if (job2 != null) {
            Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
        }
        this.r = true;
        im1 im1Var2 = this.m;
        nd3 nd3Var3 = (nd3) im1Var2.f();
        if (nd3Var3 == null) {
            nd3Var3 = new nd3(null, false, false, false, null, 0L, 0L, null, false, null, 0L, 0L, false, false, null, false, false, null, false, null, null, false, 4194303, null);
        }
        nd3 nd3Var4 = nd3Var3;
        im1Var2.o(nd3Var4.a((4194299 & 1) != 0 ? nd3Var4.a : null, (4194299 & 2) != 0 ? nd3Var4.b : false, (4194299 & 4) != 0 ? nd3Var4.c : false, (4194299 & 8) != 0 ? nd3Var4.d : false, (4194299 & 16) != 0 ? nd3Var4.e : null, (4194299 & 32) != 0 ? nd3Var4.f : 0L, (4194299 & 64) != 0 ? nd3Var4.g : 0L, (4194299 & 128) != 0 ? nd3Var4.h : null, (4194299 & 256) != 0 ? nd3Var4.i : false, (4194299 & 512) != 0 ? nd3Var4.j : null, (4194299 & 1024) != 0 ? nd3Var4.k : 0L, (4194299 & 2048) != 0 ? nd3Var4.l : 0L, (4194299 & 4096) != 0 ? nd3Var4.m : false, (4194299 & 8192) != 0 ? nd3Var4.n : false, (4194299 & 16384) != 0 ? nd3Var4.o : null, (4194299 & 32768) != 0 ? nd3Var4.p : false, (4194299 & 65536) != 0 ? nd3Var4.f362q : false, (4194299 & Opcodes.ACC_DEPRECATED) != 0 ? nd3Var4.r : null, (4194299 & Opcodes.ASM4) != 0 ? nd3Var4.s : true, (4194299 & Opcodes.ASM8) != 0 ? nd3Var4.t : null, (4194299 & Eclipse.HasTypeAnnotations) != 0 ? nd3Var4.u : null, (4194299 & 2097152) != 0 ? nd3Var4.v : false));
        try {
            byte[] bArrJ = zi2.j();
            if (bArrJ != null && bArrJ.length != 0) {
                zi2.e().K(bArrJ, "获取表盘剩余空间");
                this.s = BuildersKt__Builders_commonKt.launch$default(p.a(this), null, null, new VideoPushViewModel$requestDeviceFreeStorage$1(this, null), 3, null);
                Log.d(h(), "已发送获取表盘剩余空间命令");
                return;
            }
            Q();
            String strB2 = u73.b(R.string.device_storage_fetch_failed);
            p31.e(strB2, "getString(...)");
            o0(strB2);
        } catch (Exception e) {
            Log.e(h(), "获取表盘剩余空间失败: " + e.getMessage(), e);
            Q();
            String strB3 = u73.b(R.string.device_storage_fetch_failed);
            p31.e(strB3, "getString(...)");
            o0(strB3);
        }
    }

    public final void g0() {
        this.m.o(new nd3(null, false, false, false, null, 0L, 0L, null, false, null, 0L, 0L, false, false, null, false, false, null, false, null, null, false, 4194303, null));
        this.o.o(null);
    }

    public final void i0(int i) {
        if (i != 1 && i != 2 && i != 3) {
            i = 1;
        }
        this.w = i;
    }

    public final void l0(BajiProtocolManager bajiProtocolManager) {
        this.f405q = bajiProtocolManager;
    }

    public final void m0(int i) {
        Integer numValueOf = Integer.valueOf(i);
        if (numValueOf.intValue() <= 0) {
            numValueOf = null;
        }
        this.v = numValueOf != null ? numValueOf.intValue() : 5;
    }

    public final void n0(String str) {
        p31.f(str, QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH);
        nd3 nd3Var = (nd3) this.m.f();
        if (nd3Var == null) {
            return;
        }
        this.m.o(nd3Var.a((4194299 & 1) != 0 ? nd3Var.a : null, (4194299 & 2) != 0 ? nd3Var.b : false, (4194299 & 4) != 0 ? nd3Var.c : false, (4194299 & 8) != 0 ? nd3Var.d : false, (4194299 & 16) != 0 ? nd3Var.e : null, (4194299 & 32) != 0 ? nd3Var.f : 0L, (4194299 & 64) != 0 ? nd3Var.g : 0L, (4194299 & 128) != 0 ? nd3Var.h : str, (4194299 & 256) != 0 ? nd3Var.i : false, (4194299 & 512) != 0 ? nd3Var.j : null, (4194299 & 1024) != 0 ? nd3Var.k : 0L, (4194299 & 2048) != 0 ? nd3Var.l : 0L, (4194299 & 4096) != 0 ? nd3Var.m : false, (4194299 & 8192) != 0 ? nd3Var.n : false, (4194299 & 16384) != 0 ? nd3Var.o : null, (4194299 & 32768) != 0 ? nd3Var.p : false, (4194299 & 65536) != 0 ? nd3Var.f362q : false, (4194299 & Opcodes.ACC_DEPRECATED) != 0 ? nd3Var.r : null, (4194299 & Opcodes.ASM4) != 0 ? nd3Var.s : false, (4194299 & Opcodes.ASM8) != 0 ? nd3Var.t : null, (4194299 & Eclipse.HasTypeAnnotations) != 0 ? nd3Var.u : null, (4194299 & 2097152) != 0 ? nd3Var.v : false));
    }

    public final void q0(Context context, String str) {
        p31.f(context, "context");
        p31.f(str, QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH);
        nd3 nd3Var = (nd3) this.m.f();
        if (nd3Var == null) {
            return;
        }
        Log.d("VideoPushViewModel", "uploadVideoWithWatchTheme - 当前状态:");
        Log.d("VideoPushViewModel", "  hasPreview: " + nd3Var.f());
        Log.d("VideoPushViewModel", "  videoPath: " + str);
        if (!nd3Var.f()) {
            Log.e("VideoPushViewModel", "hasPreview 检查失败");
            String string = context.getString(R.string.please_select_video_first_error);
            p31.e(string, "getString(...)");
            o0(string);
            return;
        }
        File file = new File(str);
        if (!file.exists()) {
            String string2 = context.getString(R.string.video_file_not_exist_error, str);
            p31.e(string2, "getString(...)");
            o0(string2);
            return;
        }
        long length = file.length();
        if (length == 0) {
            String string3 = context.getString(R.string.video_file_is_empty_error);
            p31.e(string3, "getString(...)");
            o0(string3);
            return;
        }
        if (u0(context, length)) {
            e0(str, context);
            String lowerCase = dn0.b(file).toLowerCase(Locale.ROOT);
            p31.e(lowerCase, "toLowerCase(...)");
            List listM = j.m("mp4", "avi", "mov", "wmv", "flv", "mkv");
            List listE = j.e("gif");
            List listQ = j.Q(listM, listE);
            if (!listQ.contains(lowerCase)) {
                String string4 = context.getString(R.string.unsupported_file_format_with_supported_error, lowerCase, j.N(listQ, ", ", null, null, 0, null, null, 62, null));
                p31.e(string4, "getString(...)");
                o0(string4);
                return;
            }
            String string5 = listE.contains(lowerCase) ? context.getString(R.string.gif_type_name) : context.getString(R.string.video_type_name);
            p31.c(string5);
            long j = 1024;
            Log.d("VideoPushViewModel", "开始上传" + string5 + ": " + str + ", 大小: " + ((length / j) / j) + "MB");
            this.m.o(nd3Var.a((4194299 & 1) != 0 ? nd3Var.a : null, (4194299 & 2) != 0 ? nd3Var.b : false, (4194299 & 4) != 0 ? nd3Var.c : true, (4194299 & 8) != 0 ? nd3Var.d : false, (4194299 & 16) != 0 ? nd3Var.e : null, (4194299 & 32) != 0 ? nd3Var.f : 0L, (4194299 & 64) != 0 ? nd3Var.g : 0L, (4194299 & 128) != 0 ? nd3Var.h : null, (4194299 & 256) != 0 ? nd3Var.i : false, (4194299 & 512) != 0 ? nd3Var.j : null, (4194299 & 1024) != 0 ? nd3Var.k : 0L, (4194299 & 2048) != 0 ? nd3Var.l : 0L, (4194299 & 4096) != 0 ? nd3Var.m : false, (4194299 & 8192) != 0 ? nd3Var.n : false, (4194299 & 16384) != 0 ? nd3Var.o : null, (4194299 & 32768) != 0 ? nd3Var.p : false, (4194299 & 65536) != 0 ? nd3Var.f362q : false, (4194299 & Opcodes.ACC_DEPRECATED) != 0 ? nd3Var.r : null, (4194299 & Opcodes.ASM4) != 0 ? nd3Var.s : false, (4194299 & Opcodes.ASM8) != 0 ? nd3Var.t : null, (4194299 & Eclipse.HasTypeAnnotations) != 0 ? nd3Var.u : null, (4194299 & 2097152) != 0 ? nd3Var.v : false));
            im1 im1Var = this.o;
            String string6 = context.getString(R.string.uploading_format_msg, string5);
            p31.e(string6, "getString(...)");
            im1Var.o(new md3.h(string6, 0));
            this.t.Y(context, str, new c(string5, str, context, length, this, nd3Var));
        }
    }

    public final void r0(Context context) {
        String strC;
        p31.f(context, "context");
        nd3 nd3Var = (nd3) this.m.f();
        if (nd3Var == null) {
            return;
        }
        Log.d("VideoPushViewModel", "validateAndUploadVideo - 当前状态:");
        Log.d("VideoPushViewModel", "  hasPreview: " + nd3Var.f());
        Log.d("VideoPushViewModel", "  isVideoConverted: " + nd3Var.p());
        Log.d("VideoPushViewModel", "  convertedVideoPath (AVI用于上传): " + nd3Var.c());
        Log.d("VideoPushViewModel", "  previewUri (MP4用于预览): " + nd3Var.g());
        Log.d("VideoPushViewModel", "  videoPath: " + nd3Var.k());
        if (!nd3Var.p() || (strC = nd3Var.c()) == null || strC.length() == 0) {
            Log.e("VideoPushViewModel", "视频转换状态检查失败");
            im1 im1Var = this.o;
            String string = context.getString(R.string.please_complete_video_crop_conversion_error);
            p31.e(string, "getString(...)");
            im1Var.o(new md3.f(string));
            return;
        }
        String strC2 = nd3Var.c();
        p31.c(strC2);
        if (!new File(strC2).exists()) {
            im1 im1Var2 = this.o;
            String string2 = context.getString(R.string.avi_video_not_exist_error);
            p31.e(string2, "getString(...)");
            im1Var2.o(new md3.f(string2));
            return;
        }
        e0(strC2, context);
        nd3 nd3Var2 = (nd3) this.m.f();
        if (nd3Var2 == null || nd3Var2.o()) {
            return;
        }
        String lowerCase = strC2.toLowerCase(Locale.ROOT);
        p31.e(lowerCase, "toLowerCase(...)");
        if (i.u(lowerCase, ".avi", false, 2, null)) {
            n0(strC2);
            q0(context, strC2);
        } else {
            im1 im1Var3 = this.o;
            String string3 = context.getString(R.string.video_format_error_msg);
            p31.e(string3, "getString(...)");
            im1Var3.o(new md3.f(string3));
        }
    }

    public final boolean u0(Context context, long j) {
        p31.f(context, "context");
        nd3 nd3Var = (nd3) this.m.f();
        if (nd3Var == null) {
            nd3Var = new nd3(null, false, false, false, null, 0L, 0L, null, false, null, 0L, 0L, false, false, null, false, false, null, false, null, null, false, 4194303, null);
        }
        Long lD = nd3Var.d();
        if (lD == null) {
            return true;
        }
        long jLongValue = lD.longValue();
        cb0 cb0Var = cb0.a;
        long jB = cb0Var.b(jLongValue);
        if (j <= jB) {
            return true;
        }
        im1 im1Var = this.o;
        String string = context.getString(R.string.video_exceeds_remaining_space, cb0Var.a(jB), cb0Var.a(j));
        p31.e(string, "getString(...)");
        im1Var.o(new md3.f(string));
        return false;
    }
}
