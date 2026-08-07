package xfkj.fitpro.manager;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.blankj.utilcode.util.ImageUtils;
import com.legend.mywatch.sdk.realtimepreview.image.TurboJpegCompressor;
import com.legend.smartwatch.electronicbadge.android.R;
import com.tencent.connect.common.Constants;
import com.tencent.connect.share.QzonePublish;
import defpackage.ga2;
import defpackage.gh3;
import defpackage.mh3;
import defpackage.my;
import defpackage.p31;
import defpackage.vh0;
import defpackage.x30;
import defpackage.xg3;
import defpackage.y70;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.b0;
import kotlin.collections.j;
import kotlin.text.i;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import xfkj.fitpro.db.DBHelper;
import xfkj.fitpro.manager.WatchThemeTransferManager;
import xfkj.fitpro.model.sever.body.ClockDialInfoBody;

/* JADX INFO: loaded from: classes4.dex */
public final class WatchThemeTransferManager {
    public static final a g = new a(null);
    private static volatile WatchThemeTransferManager h;
    private final Handler a;
    private volatile c b;
    private volatile Context c;
    private volatile String d;
    private boolean e;
    private final e f;

    public enum FileType {
        IMAGE,
        VIDEO;

        private static final /* synthetic */ vh0 $ENTRIES = kotlin.enums.a.a(values());

        public static vh0 getEntries() {
            return $ENTRIES;
        }
    }

    public static final class a {
        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        public final WatchThemeTransferManager a() {
            WatchThemeTransferManager watchThemeTransferManager = WatchThemeTransferManager.h;
            if (watchThemeTransferManager == null) {
                synchronized (this) {
                    watchThemeTransferManager = WatchThemeTransferManager.h;
                    if (watchThemeTransferManager == null) {
                        watchThemeTransferManager = new WatchThemeTransferManager(null);
                        WatchThemeTransferManager.h = watchThemeTransferManager;
                    }
                }
            }
            return watchThemeTransferManager;
        }

        private a() {
        }
    }

    public static final class b {
        private final String a;
        private final long b;
        private final int c;

        public b(String str, long j, int i) {
            p31.f(str, "filePath");
            this.a = str;
            this.b = j;
            this.c = i;
        }

        public final String a() {
            return this.a;
        }

        public final long b() {
            return this.b;
        }

        public final int c() {
            return this.c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return p31.a(this.a, bVar.a) && this.b == bVar.b && this.c == bVar.c;
        }

        public int hashCode() {
            return (((this.a.hashCode() * 31) + Long.hashCode(this.b)) * 31) + Integer.hashCode(this.c);
        }

        public String toString() {
            return "PreparedUploadImage(filePath=" + this.a + ", fileSizeBytes=" + this.b + ", fileType=" + this.c + ")";
        }
    }

    public interface c {
        void a(String str);

        void b();

        void c();

        void d(int i);
    }

    public /* synthetic */ class d {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[FileType.values().length];
            try {
                iArr[FileType.IMAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FileType.VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    public static final class e implements gh3.a {
        e() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void i(WatchThemeTransferManager watchThemeTransferManager) {
            c cVar = watchThemeTransferManager.b;
            if (cVar != null) {
                cVar.c();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void j(WatchThemeTransferManager watchThemeTransferManager, int i) {
            c cVar = watchThemeTransferManager.b;
            if (cVar != null) {
                cVar.d(i);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void k(WatchThemeTransferManager watchThemeTransferManager, String str) {
            c cVar = watchThemeTransferManager.b;
            watchThemeTransferManager.b = null;
            if (cVar != null) {
                cVar.a(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void l(WatchThemeTransferManager watchThemeTransferManager) {
            c cVar = watchThemeTransferManager.b;
            watchThemeTransferManager.b = null;
            if (cVar != null) {
                cVar.b();
            }
        }

        @Override // gh3.a
        public void a(mh3 mh3Var, xg3 xg3Var) {
            final String strK;
            p31.f(mh3Var, "p0");
            p31.f(xg3Var, "p1");
            Context context = WatchThemeTransferManager.this.c;
            int iA = mh3Var.a();
            if (context != null) {
                strK = WatchThemeTransferManager.this.K(context, iA);
            } else {
                strK = "表盘升级失败，错误码: " + iA;
            }
            Log.e("WatchThemeTransferManager", "表盘升级失败，错误码: " + iA + ", 错误信息: " + strK);
            Handler handler = WatchThemeTransferManager.this.a;
            final WatchThemeTransferManager watchThemeTransferManager = WatchThemeTransferManager.this;
            handler.post(new Runnable() { // from class: jh3
                @Override // java.lang.Runnable
                public final void run() {
                    WatchThemeTransferManager.e.k(watchThemeTransferManager, strK);
                }
            });
        }

        @Override // gh3.a
        public void b(int i) {
            final int iG = ga2.g(i / 10, 0, 100);
            Log.d("WatchThemeTransferManager", "表盘升级进度: " + iG + "% (原始值: " + i + ")");
            Handler handler = WatchThemeTransferManager.this.a;
            final WatchThemeTransferManager watchThemeTransferManager = WatchThemeTransferManager.this;
            handler.post(new Runnable() { // from class: kh3
                @Override // java.lang.Runnable
                public final void run() {
                    WatchThemeTransferManager.e.j(watchThemeTransferManager, iG);
                }
            });
        }

        @Override // gh3.a
        public void c() {
            Log.d("WatchThemeTransferManager", "表盘升级开始");
            Handler handler = WatchThemeTransferManager.this.a;
            final WatchThemeTransferManager watchThemeTransferManager = WatchThemeTransferManager.this;
            handler.post(new Runnable() { // from class: ih3
                @Override // java.lang.Runnable
                public final void run() {
                    WatchThemeTransferManager.e.i(watchThemeTransferManager);
                }
            });
        }

        @Override // gh3.a
        public void d(xg3 xg3Var) {
            p31.f(xg3Var, "watch3");
            Log.d("WatchThemeTransferManager", "表盘升级成功");
            Handler handler = WatchThemeTransferManager.this.a;
            final WatchThemeTransferManager watchThemeTransferManager = WatchThemeTransferManager.this;
            handler.post(new Runnable() { // from class: lh3
                @Override // java.lang.Runnable
                public final void run() {
                    WatchThemeTransferManager.e.l(watchThemeTransferManager);
                }
            });
        }
    }

    public /* synthetic */ WatchThemeTransferManager(y70 y70Var) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List A() {
        return j.j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object B(Context context, String str, ClockDialInfoBody clockDialInfoBody, x30 x30Var) {
        return BuildersKt.withContext(Dispatchers.getIO(), new WatchThemeTransferManager$buildWatchTheme3Body$2(this, context, str, clockDialInfoBody, null), x30Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object C(Context context, String str, ClockDialInfoBody clockDialInfoBody, x30 x30Var) {
        return BuildersKt.withContext(Dispatchers.getIO(), new WatchThemeTransferManager$buildWatchTheme3BodyForVideo$2(this, str, null), x30Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object D(String str, int i, x30 x30Var) {
        return BuildersKt.withContext(Dispatchers.getIO(), new WatchThemeTransferManager$buildWatchTheme3BodyFromProcessed$2(this, i, str, null), x30Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object E(Context context, Bitmap bitmap, ClockDialInfoBody clockDialInfoBody, x30 x30Var) {
        return BuildersKt.withContext(Dispatchers.getIO(), new WatchThemeTransferManager$convertBitmapOfJIELI$2(bitmap, clockDialInfoBody, context, null), x30Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final my F(ClockDialInfoBody clockDialInfoBody) {
        my myVar = new my();
        myVar.t(clockDialInfoBody.getDevId());
        myVar.w(clockDialInfoBody.getMainModel());
        myVar.x(clockDialInfoBody.getMchModel());
        myVar.u(clockDialInfoBody.getGrade());
        myVar.z(clockDialInfoBody.getScreenType());
        myVar.F(clockDialInfoBody.getWidth());
        myVar.v(clockDialInfoBody.getHeight());
        myVar.r(clockDialInfoBody.getConfig());
        myVar.q(clockDialInfoBody.getAlgorithm());
        myVar.C(clockDialInfoBody.getVersionCode());
        myVar.s(clockDialInfoBody.getCustomer());
        myVar.y(clockDialInfoBody.getPictureNums());
        myVar.E(clockDialInfoBody.getWatchThemeVersion());
        myVar.D(clockDialInfoBody.getWatchThemeShortPkgLenght());
        myVar.B(clockDialInfoBody.getThumbWidth());
        myVar.A(clockDialInfoBody.getThumbHeight());
        return myVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final xg3 G() {
        return new xg3();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap H(Bitmap bitmap, int i, int i2) {
        try {
            Log.d("WatchThemeTransferManager", "原始图片尺寸: " + bitmap.getWidth() + "x" + bitmap.getHeight() + ", 目标尺寸: " + i + "x" + i2);
            Bitmap bitmapE = ImageUtils.e(bitmap, i, i2);
            if (bitmapE == null) {
                Log.e("WatchThemeTransferManager", "图片缩放失败");
                return null;
            }
            Log.d("WatchThemeTransferManager", "图片缩放完成: " + bitmapE.getWidth() + "x" + bitmapE.getHeight());
            return bitmapE;
        } catch (Exception e2) {
            Log.e("WatchThemeTransferManager", "缩放图片失败: " + e2.getMessage(), e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FileType I(String str) {
        String strL = L(new File(str));
        Set setF = b0.f("jpg", "jpeg", "png", "gif", "bmp", "webp", "bin");
        Set setF2 = b0.f("mp4", "avi", "mov", "wmv", "flv", "mkv");
        if (setF.contains(strL)) {
            return FileType.IMAGE;
        }
        if (setF2.contains(strL)) {
            return FileType.VIDEO;
        }
        Log.w("WatchThemeTransferManager", "未知文件类型: " + strL + "，默认为图片");
        return FileType.IMAGE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ClockDialInfoBody J() {
        try {
            return DBHelper.getClockDialInfo();
        } catch (Exception e2) {
            Log.e("WatchThemeTransferManager", "获取表盘信息失败: " + e2.getMessage(), e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String K(Context context, int i) {
        switch (i) {
            case 0:
                String string = context.getString(R.string.watch_theme_error_waiting_upgrade);
                p31.e(string, "getString(...)");
                return string;
            case 1:
                String string2 = context.getString(R.string.watch_theme_error_verification_failed);
                p31.e(string2, "getString(...)");
                return string2;
            case 2:
                String string3 = context.getString(R.string.watch_theme_error_upgrade_success);
                p31.e(string3, "getString(...)");
                return string3;
            case 3:
                String string4 = context.getString(R.string.watch_theme_error_low_battery);
                p31.e(string4, "getString(...)");
                return string4;
            case 4:
                String string5 = context.getString(R.string.watch_theme_error_charging);
                p31.e(string5, "getString(...)");
                return string5;
            case 5:
                String string6 = context.getString(R.string.watch_theme_error_insufficient_space);
                p31.e(string6, "getString(...)");
                return string6;
            case 6:
                String string7 = context.getString(R.string.watch_theme_error_exceed_limit);
                p31.e(string7, "getString(...)");
                return string7;
            case 7:
                String string8 = context.getString(R.string.watch_theme_error_duplicate_upgrade);
                p31.e(string8, "getString(...)");
                return string8;
            case 8:
                String string9 = context.getString(R.string.watch_theme_error_theme_id_not_found);
                p31.e(string9, "getString(...)");
                return string9;
            case 9:
                String string10 = context.getString(R.string.watch_theme_error_upgrade_too_frequent);
                p31.e(string10, "getString(...)");
                return string10;
            default:
                switch (i) {
                    case 1000:
                        String string11 = context.getString(R.string.watch_theme_error_updating);
                        p31.e(string11, "getString(...)");
                        return string11;
                    case 1001:
                        String string12 = context.getString(R.string.watch_theme_error_timeout);
                        p31.e(string12, "getString(...)");
                        return string12;
                    case 1002:
                        String string13 = context.getString(R.string.watch_theme_error_retry_timeout);
                        p31.e(string13, "getString(...)");
                        return string13;
                    case 1003:
                        String string14 = context.getString(R.string.watch_theme_error_verification_error);
                        p31.e(string14, "getString(...)");
                        return string14;
                    case 1004:
                        String string15 = context.getString(R.string.watch_theme_error_image_firmware_not_exist);
                        p31.e(string15, "getString(...)");
                        return string15;
                    case 1005:
                        String string16 = context.getString(R.string.watch_theme_error_font_firmware_not_exist);
                        p31.e(string16, "getString(...)");
                        return string16;
                    case 1006:
                        String string17 = context.getString(R.string.watch_theme_error_device_disconnected);
                        p31.e(string17, "getString(...)");
                        return string17;
                    case 1007:
                        String string18 = context.getString(R.string.watch_theme_error_unknown);
                        p31.e(string18, "getString(...)");
                        return string18;
                    case 1008:
                        String string19 = context.getString(R.string.watch_theme_error_battery_low);
                        p31.e(string19, "getString(...)");
                        return string19;
                    case 1009:
                        String string20 = context.getString(R.string.watch_theme_error_charging_status);
                        p31.e(string20, "getString(...)");
                        return string20;
                    case 1010:
                        String string21 = context.getString(R.string.watch_theme_error_space_insufficient);
                        p31.e(string21, "getString(...)");
                        return string21;
                    case 1011:
                        String string22 = context.getString(R.string.watch_theme_error_theme_limit_exceeded);
                        p31.e(string22, "getString(...)");
                        return string22;
                    case 1012:
                        String string23 = context.getString(R.string.watch_theme_error_duplicate_upgrade_local);
                        p31.e(string23, "getString(...)");
                        return string23;
                    case 1013:
                        String string24 = context.getString(R.string.watch_theme_error_theme_id_not_found_local);
                        p31.e(string24, "getString(...)");
                        return string24;
                    case 1014:
                        String string25 = context.getString(R.string.watch_theme_error_upgrade_stopped);
                        p31.e(string25, "getString(...)");
                        return string25;
                    case 1015:
                        String string26 = context.getString(R.string.watch_theme_error_upgrade_too_frequent_local);
                        p31.e(string26, "getString(...)");
                        return string26;
                    default:
                        String string27 = context.getString(R.string.watch_theme_error_unknown_with_code, Integer.valueOf(i));
                        p31.e(string27, "getString(...)");
                        return string27;
                }
        }
    }

    private final String L(File file) {
        String name = file.getName();
        p31.c(name);
        int iB0 = i.b0(name, '.', 0, false, 6, null);
        if (iB0 <= 0 || iB0 >= name.length() - 1) {
            return Constants.STR_EMPTY;
        }
        String strSubstring = name.substring(iB0 + 1);
        p31.e(strSubstring, "substring(...)");
        String lowerCase = strSubstring.toLowerCase(Locale.ROOT);
        p31.e(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final gh3 N() {
        try {
            return gh3.o();
        } catch (Exception e2) {
            Log.e("WatchThemeTransferManager", "获取 WatchTheme3Tools 实例失败: " + e2.getMessage(), e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap O(String str) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                Log.e("WatchThemeTransferManager", "图片文件不存在: " + str);
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(fileInputStream);
            fileInputStream.close();
            if (bitmapDecodeStream == null) {
                Log.e("WatchThemeTransferManager", "无法解码图片: " + str);
            }
            return bitmapDecodeStream;
        } catch (Exception e2) {
            Log.e("WatchThemeTransferManager", "加载图片失败: " + e2.getMessage(), e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object Q(Context context, String str, ClockDialInfoBody clockDialInfoBody, x30 x30Var) {
        return BuildersKt.withContext(Dispatchers.getIO(), new WatchThemeTransferManager$processImageForWatchTheme$2(this, str, clockDialInfoBody, context, null), x30Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object R(String str, x30 x30Var) {
        return BuildersKt.withContext(Dispatchers.getIO(), new WatchThemeTransferManager$processVideoForWatchTheme$2(str, this, null), x30Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int S(byte b2) {
        if (b2 == 4) {
            return 2;
        }
        if (b2 != 3 && b2 != 0) {
            Log.w("WatchThemeTransferManager", "未知算法类型: " + ((int) b2) + "，默认文件类型为 BMP");
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String T(Context context, Bitmap bitmap) throws Throwable {
        try {
            File file = new File(context.getExternalFilesDir(null), "watch_theme_jpeg_" + System.currentTimeMillis() + ".jpg");
            byte[] bArrCompressBitmap = TurboJpegCompressor.compressBitmap(bitmap, new TurboJpegCompressor.CompressConfig(50));
            if (bArrCompressBitmap != null && bArrCompressBitmap.length != 0) {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                fileOutputStream.write(bArrCompressBitmap);
                fileOutputStream.flush();
                fileOutputStream.close();
                if (!file.exists() || file.length() <= 0) {
                    Log.e("WatchThemeTransferManager", "JPEG文件保存失败，文件不存在或大小为0");
                    return null;
                }
                Log.d("WatchThemeTransferManager", "JPEG文件保存成功（使用TurboJpegCompressor，质量=50）: " + file.getAbsolutePath() + ", 大小: " + file.length() + " bytes");
                return file.getAbsolutePath();
            }
            Log.e("WatchThemeTransferManager", "TurboJpegCompressor转换失败，返回null");
            return null;
        } catch (Exception e2) {
            Log.e("WatchThemeTransferManager", "保存JPEG文件失败: " + e2.getMessage(), e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U(Context context, gh3 gh3Var, c cVar) {
        try {
            Log.d("WatchThemeTransferManager", "设置表盘传输状态监听器");
            this.b = cVar;
            this.c = context;
            if (this.e) {
                Log.d("WatchThemeTransferManager", "复用已有表盘传输状态监听器，已更新当前回调");
            } else {
                gh3Var.i(this.f);
                this.e = true;
                Log.d("WatchThemeTransferManager", "表盘传输状态监听器已注册");
            }
        } catch (Exception e2) {
            Log.e("WatchThemeTransferManager", "设置表盘传输状态监听器失败: " + e2.getMessage(), e2);
            this.b = null;
            cVar.a("设置状态监听器失败: " + e2.getMessage());
        }
    }

    public final String M() {
        return this.d;
    }

    public final Object P(Context context, String str, x30 x30Var) {
        return BuildersKt.withContext(Dispatchers.getIO(), new WatchThemeTransferManager$prepareImageForUpload$2(this, context, str, null), x30Var);
    }

    public final void V(Context context, String str, c cVar) {
        p31.f(context, "context");
        p31.f(str, "filePath");
        p31.f(cVar, "callback");
        FileType fileTypeI = I(str);
        Log.d("WatchThemeTransferManager", "检测到文件类型: " + fileTypeI + ", 文件路径: " + str);
        int i = d.a[fileTypeI.ordinal()];
        if (i == 1) {
            W(context, str, cVar);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            Y(context, str, cVar);
        }
    }

    public final void W(Context context, String str, c cVar) {
        p31.f(context, "context");
        p31.f(str, "imagePath");
        p31.f(cVar, "callback");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new WatchThemeTransferManager$uploadImageWithWatchTheme$1(str, cVar, this, context, null), 3, null);
    }

    public final void X(Context context, b bVar, c cVar) {
        p31.f(context, "context");
        p31.f(bVar, "prepared");
        p31.f(cVar, "callback");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new WatchThemeTransferManager$uploadPreparedImageWithWatchTheme$1(bVar, cVar, this, context, null), 3, null);
    }

    public final void Y(Context context, String str, c cVar) {
        p31.f(context, "context");
        p31.f(str, QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH);
        p31.f(cVar, "callback");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new WatchThemeTransferManager$uploadVideoWithWatchTheme$1(str, cVar, this, context, null), 3, null);
    }

    private WatchThemeTransferManager() {
        this.a = new Handler(Looper.getMainLooper());
        this.f = new e();
    }
}
