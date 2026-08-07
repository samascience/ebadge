package xfkj.fitpro.ui.activities.device.electronicBadgeDevice.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.lifecycle.p;
import com.baji.network.BadgeApiManager;
import com.baji.network.model.BadgeImage;
import com.baji.network.model.NetworkError;
import com.baji.protocol.BajiProtocolManager;
import com.blankj.utilcode.util.g;
import com.fasterxml.jackson.core.JsonPointer;
import com.legend.smartwatch.electronicbadge.android.R;
import com.luck.picture.lib.compress.Checker;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.tenmeter.smlibrary.utils.FileUtils;
import defpackage.ar0;
import defpackage.aw2;
import defpackage.cb0;
import defpackage.im1;
import defpackage.k83;
import defpackage.o00;
import defpackage.op;
import defpackage.p31;
import defpackage.py;
import defpackage.r22;
import defpackage.rv2;
import defpackage.s22;
import defpackage.sg3;
import defpackage.ty;
import defpackage.x30;
import defpackage.xv2;
import defpackage.y70;
import defpackage.zi2;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Pair;
import kotlin.collections.j;
import kotlin.d;
import kotlin.text.i;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import xfkj.fitpro.manager.WatchThemeTransferManager;
import xfkj.fitpro.model.sever.body.ClockDialInfoBody;
import xfkj.fitpro.ui.activities.device.electronicBadgeDevice.viewmodel.PicturePushViewModel;

/* JADX INFO: loaded from: classes4.dex */
public final class PicturePushViewModel extends com.legend.smartwatch.app.base.viewmodel.a {
    public static final a y = new a(null);
    private final im1 m;
    private final im1 n;
    private final im1 o;
    private final im1 p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final BadgeApiManager f404q;
    private BajiProtocolManager r;
    private final WatchThemeTransferManager s;
    private volatile boolean t;
    private boolean u;
    private Job v;
    private Job w;
    private String x;

    public static final class a {
        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        private a() {
        }
    }

    public static final class b implements WatchThemeTransferManager.c {
        b() {
        }

        @Override // xfkj.fitpro.manager.WatchThemeTransferManager.c
        public void a(String str) {
            p31.f(str, "errorMessage");
            com.legend.smartwatch.app.base.viewmodel.a.k(PicturePushViewModel.this, "表盘传输失败: " + str, null, 2, null);
            PicturePushViewModel.this.t = false;
            s22 s22Var = (s22) PicturePushViewModel.this.m.f();
            if (s22Var == null) {
                s22Var = new s22(null, null, null, null, false, null, null, null, null, null, false, null, null, false, 16383, null);
            }
            PicturePushViewModel.this.m.m(s22Var.a((16335 & 1) != 0 ? s22Var.a : null, (16335 & 2) != 0 ? s22Var.b : null, (16335 & 4) != 0 ? s22Var.c : null, (16335 & 8) != 0 ? s22Var.d : null, (16335 & 16) != 0 ? s22Var.e : false, (16335 & 32) != 0 ? s22Var.f : str, (16335 & 64) != 0 ? s22Var.g : null, (16335 & 128) != 0 ? s22Var.h : null, (16335 & 256) != 0 ? s22Var.i : null, (16335 & 512) != 0 ? s22Var.j : null, (16335 & 1024) != 0 ? s22Var.k : false, (16335 & 2048) != 0 ? s22Var.l : null, (16335 & 4096) != 0 ? s22Var.m : null, (16335 & 8192) != 0 ? s22Var.n : false));
            PicturePushViewModel.this.o.o(new r22.g(str));
        }

        @Override // xfkj.fitpro.manager.WatchThemeTransferManager.c
        public void b() {
            PicturePushViewModel.this.i("表盘传输成功");
            PicturePushViewModel.this.t = false;
            s22 s22Var = (s22) PicturePushViewModel.this.m.f();
            if (s22Var == null) {
                s22Var = new s22(null, null, null, null, false, null, null, null, null, null, false, null, null, false, 16383, null);
            }
            s22 s22Var2 = s22Var;
            PicturePushViewModel.this.m.m(s22Var2.a((16335 & 1) != 0 ? s22Var2.a : null, (16335 & 2) != 0 ? s22Var2.b : null, (16335 & 4) != 0 ? s22Var2.c : null, (16335 & 8) != 0 ? s22Var2.d : null, (16335 & 16) != 0 ? s22Var2.e : false, (16335 & 32) != 0 ? s22Var2.f : null, (16335 & 64) != 0 ? s22Var2.g : null, (16335 & 128) != 0 ? s22Var2.h : null, (16335 & 256) != 0 ? s22Var2.i : null, (16335 & 512) != 0 ? s22Var2.j : null, (16335 & 1024) != 0 ? s22Var2.k : false, (16335 & 2048) != 0 ? s22Var2.l : null, (16335 & 4096) != 0 ? s22Var2.m : null, (16335 & 8192) != 0 ? s22Var2.n : false));
            PicturePushViewModel.this.o.o(r22.i.a);
        }

        @Override // xfkj.fitpro.manager.WatchThemeTransferManager.c
        public void c() {
            PicturePushViewModel.this.i("表盘传输开始");
            im1 im1Var = PicturePushViewModel.this.o;
            String strD = rv2.d(R.string.connecting_device);
            p31.e(strD, "getString(...)");
            im1Var.o(new r22.k(0, strD));
        }

        @Override // xfkj.fitpro.manager.WatchThemeTransferManager.c
        public void d(int i) {
            PicturePushViewModel.this.i("表盘传输进度: " + i + "%");
            im1 im1Var = PicturePushViewModel.this.o;
            String strE = rv2.e(R.string.upload_progress, Integer.valueOf(i));
            p31.e(strE, "getString(...)");
            im1Var.o(new r22.k(i, strE));
        }
    }

    public static final class c implements Comparator {
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return o00.a(Integer.valueOf(((xv2) obj).e()), Integer.valueOf(((xv2) obj2).e()));
        }
    }

    public PicturePushViewModel() {
        im1 im1Var = new im1(new s22(null, null, null, null, false, null, null, null, null, null, false, null, null, false, 16383, null));
        this.m = im1Var;
        this.n = im1Var;
        im1 im1Var2 = new im1();
        this.o = im1Var2;
        this.p = im1Var2;
        this.f404q = BadgeApiManager.Companion.getInstance();
        this.s = WatchThemeTransferManager.g.a();
        Z(r22.b.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final s22 E(s22 s22Var, String str, long j, Context context) {
        Long lValueOf;
        Long lC = s22Var.c();
        if (lC != null) {
            lValueOf = Long.valueOf(cb0.a.b(lC.longValue()));
        } else {
            lValueOf = null;
        }
        boolean z = lValueOf != null && j > lValueOf.longValue();
        if (z && context != null) {
            cb0 cb0Var = cb0.a;
            String string = context.getString(R.string.picture_exceeds_remaining_space, cb0Var.a(lValueOf.longValue()), cb0Var.a(j));
            p31.e(string, "getString(...)");
            u0(string);
        }
        return s22Var.a((16335 & 1) != 0 ? s22Var.a : null, (16335 & 2) != 0 ? s22Var.b : null, (16335 & 4) != 0 ? s22Var.c : null, (16335 & 8) != 0 ? s22Var.d : null, (16335 & 16) != 0 ? s22Var.e : false, (16335 & 32) != 0 ? s22Var.f : null, (16335 & 64) != 0 ? s22Var.g : null, (16335 & 128) != 0 ? s22Var.h : null, (16335 & 256) != 0 ? s22Var.i : null, (16335 & 512) != 0 ? s22Var.j : null, (16335 & 1024) != 0 ? s22Var.k : false, (16335 & 2048) != 0 ? s22Var.l : str, (16335 & 4096) != 0 ? s22Var.m : Long.valueOf(j), (16335 & 8192) != 0 ? s22Var.n : z);
    }

    private final void F() {
        s22 s22Var = (s22) this.m.f();
        if (s22Var == null) {
            s22Var = new s22(null, null, null, null, false, null, null, null, null, null, false, null, null, false, 16383, null);
        }
        s22 s22Var2 = s22Var;
        this.m.m(s22Var2.a((16335 & 1) != 0 ? s22Var2.a : null, (16335 & 2) != 0 ? s22Var2.b : null, (16335 & 4) != 0 ? s22Var2.c : null, (16335 & 8) != 0 ? s22Var2.d : null, (16335 & 16) != 0 ? s22Var2.e : false, (16335 & 32) != 0 ? s22Var2.f : null, (16335 & 64) != 0 ? s22Var2.g : null, (16335 & 128) != 0 ? s22Var2.h : null, (16335 & 256) != 0 ? s22Var2.i : null, (16335 & 512) != 0 ? s22Var2.j : null, (16335 & 1024) != 0 ? s22Var2.k : false, (16335 & 2048) != 0 ? s22Var2.l : null, (16335 & 4096) != 0 ? s22Var2.m : null, (16335 & 8192) != 0 ? s22Var2.n : false));
    }

    private final List I(List list) {
        ArrayList arrayList = new ArrayList(j.t(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            BadgeImage badgeImage = (BadgeImage) it.next();
            arrayList.add(new aw2(badgeImage.getId(), badgeImage.getUrl(), badgeImage.getTypeDescription(), false, badgeImage.getType(), 8, null));
        }
        return arrayList;
    }

    private final String J(Activity activity, Uri uri, String str) {
        try {
            i("开始复制图片到沙盒目录: " + str);
            File file = new File(activity.getExternalFilesDir(null), "images");
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, "image_" + System.currentTimeMillis() + FileUtils.FILE_EXTENSION_SEPARATOR + g.m(str));
            String absolutePath = file2.getAbsolutePath();
            StringBuilder sb = new StringBuilder();
            sb.append("沙盒文件路径: ");
            sb.append(absolutePath);
            i(sb.toString());
            InputStream inputStreamOpenInputStream = activity.getContentResolver().openInputStream(uri);
            if (inputStreamOpenInputStream == null) {
                com.legend.smartwatch.app.base.viewmodel.a.k(this, "无法打开输入流", null, 2, null);
                return null;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            try {
                try {
                    op.b(inputStreamOpenInputStream, fileOutputStream, 0, 2, null);
                    ty.a(fileOutputStream, null);
                    ty.a(inputStreamOpenInputStream, null);
                    if (!file2.exists() || file2.length() <= 0) {
                        com.legend.smartwatch.app.base.viewmodel.a.k(this, "图片复制失败，文件不存在或大小为0", null, 2, null);
                        return null;
                    }
                    i("图片复制成功: " + file2.getAbsolutePath());
                    i("文件大小: " + file2.length() + " bytes");
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
            j("复制图片到沙盒失败", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    public final Object K(Bitmap bitmap, aw2 aw2Var, x30 x30Var) throws Throwable {
        PicturePushViewModel$createCompositeBitmap$1 picturePushViewModel$createCompositeBitmap$1;
        Bitmap bitmap2;
        if (x30Var instanceof PicturePushViewModel$createCompositeBitmap$1) {
            picturePushViewModel$createCompositeBitmap$1 = (PicturePushViewModel$createCompositeBitmap$1) x30Var;
            int i = picturePushViewModel$createCompositeBitmap$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                picturePushViewModel$createCompositeBitmap$1.label = i - Integer.MIN_VALUE;
            } else {
                picturePushViewModel$createCompositeBitmap$1 = new PicturePushViewModel$createCompositeBitmap$1(this, x30Var);
            }
        } else {
            picturePushViewModel$createCompositeBitmap$1 = new PicturePushViewModel$createCompositeBitmap$1(this, x30Var);
        }
        PicturePushViewModel$createCompositeBitmap$1 picturePushViewModel$createCompositeBitmap$2 = picturePushViewModel$createCompositeBitmap$1;
        Object obj = picturePushViewModel$createCompositeBitmap$2.result;
        Object objD = kotlin.coroutines.intrinsics.a.d();
        int i2 = picturePushViewModel$createCompositeBitmap$2.label;
        if (i2 == 0) {
            d.b(obj);
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            p31.e(bitmapCreateBitmap, "createBitmap(...)");
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            canvas.drawBitmap(bitmap, (Rect) null, new Rect(0, 0, width, height), new Paint());
            if (aw2Var.j()) {
                if (aw2Var.f() == null) {
                    return bitmapCreateBitmap;
                }
                l("本地资源合成需要在Activity中处理");
                return bitmapCreateBitmap;
            }
            String strD = aw2Var.d();
            picturePushViewModel$createCompositeBitmap$2.L$0 = bitmapCreateBitmap;
            picturePushViewModel$createCompositeBitmap$2.label = 1;
            if (k0(canvas, strD, width, height, picturePushViewModel$createCompositeBitmap$2) == objD) {
                return objD;
            }
            bitmap2 = bitmapCreateBitmap;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            bitmap2 = (Bitmap) picturePushViewModel$createCompositeBitmap$2.L$0;
            d.b(obj);
        }
        return bitmap2;
    }

    private final WatchThemeTransferManager.c N() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O() {
        String str = this.x;
        if (str == null || str.length() == 0) {
            return;
        }
        try {
            new File(str).delete();
        } catch (Exception e) {
            l("删除旧预处理文件失败: " + e.getMessage());
        }
        this.x = null;
    }

    private final String P(Activity activity, String str, Pair pair) {
        Bitmap.CompressFormat compressFormat;
        try {
            Pair pairW = W(str);
            i("裁剪输出尺寸检查: " + pairW.getFirst() + "x" + pairW.getSecond() + ", 目标: " + pair.getFirst() + "x" + pair.getSecond());
            if (((Number) pairW.getFirst()).intValue() >= ((Number) pair.getFirst()).intValue() && ((Number) pairW.getSecond()).intValue() >= ((Number) pair.getSecond()).intValue()) {
                i("输出尺寸已符合要求，无需后处理");
                return str;
            }
            float fMax = Math.max(((Number) pair.getFirst()).intValue() / ((Number) pairW.getFirst()).floatValue(), ((Number) pair.getSecond()).intValue() / ((Number) pairW.getSecond()).floatValue());
            i("需要放大裁剪输出: " + pairW.getFirst() + "x" + pairW.getSecond() + " -> scale: " + fMax);
            Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(str);
            if (bitmapDecodeFile == null) {
                com.legend.smartwatch.app.base.viewmodel.a.k(this, "无法加载裁剪后的图片: " + str, null, 2, null);
                return str;
            }
            int iFloatValue = (int) (((Number) pairW.getFirst()).floatValue() * fMax);
            int iFloatValue2 = (int) (((Number) pairW.getSecond()).floatValue() * fMax);
            i("开始放大裁剪输出: " + pairW.getFirst() + "x" + pairW.getSecond() + " -> " + iFloatValue + "x" + iFloatValue2);
            Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapDecodeFile, iFloatValue, iFloatValue2, true);
            p31.e(bitmapCreateScaledBitmap, "createScaledBitmap(...)");
            bitmapDecodeFile.recycle();
            String strM = g.m(str);
            p31.c(strM);
            String lowerCase = strM.toLowerCase(Locale.ROOT);
            p31.e(lowerCase, "toLowerCase(...)");
            if (p31.a(lowerCase, "png")) {
                compressFormat = Bitmap.CompressFormat.PNG;
            } else {
                compressFormat = p31.a(lowerCase, "webp") ? Bitmap.CompressFormat.WEBP : Bitmap.CompressFormat.JPEG;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(new File(str));
            bitmapCreateScaledBitmap.compress(compressFormat, 100, fileOutputStream);
            fileOutputStream.close();
            bitmapCreateScaledBitmap.recycle();
            i("裁剪输出后处理完成: " + iFloatValue + "x" + iFloatValue2);
            return str;
        } catch (Exception e) {
            j("裁剪输出后处理失败: " + e.getMessage(), e);
            return str;
        }
    }

    private final void Q() {
        try {
            PictureSelectionConfig pictureSelectionConfigC = PictureSelectionConfig.c();
            if (pictureSelectionConfigC.N == 0 && pictureSelectionConfigC.O == 0) {
                Pair pairS = S();
                pictureSelectionConfigC.N = ((Number) pairS.getFirst()).intValue();
                pictureSelectionConfigC.O = ((Number) pairS.getSecond()).intValue();
                pictureSelectionConfigC.P = ((Number) pairS.getFirst()).intValue();
                pictureSelectionConfigC.Q = ((Number) pairS.getSecond()).intValue();
                pictureSelectionConfigC.o0 = true;
                pictureSelectionConfigC.p0 = true;
                pictureSelectionConfigC.w0 = true;
                pictureSelectionConfigC.x0 = false;
                pictureSelectionConfigC.r0 = false;
                pictureSelectionConfigC.y0 = false;
                pictureSelectionConfigC.G = 90;
                pictureSelectionConfigC.q0 = true;
                pictureSelectionConfigC.A0 = true;
                pictureSelectionConfigC.z0 = true;
                i("Picture 库配置已初始化: " + pairS.getFirst() + "x" + pairS.getSecond());
            }
        } catch (Exception e) {
            j("初始化 Picture 库配置失败", e);
        }
    }

    private final void R() {
        Job job = this.v;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.u = false;
        im1 im1Var = this.m;
        s22 s22Var = (s22) im1Var.f();
        if (s22Var == null) {
            s22Var = new s22(null, null, null, null, false, null, null, null, null, null, false, null, null, false, 16383, null);
        }
        s22 s22Var2 = s22Var;
        im1Var.m(s22Var2.a((16335 & 1) != 0 ? s22Var2.a : null, (16335 & 2) != 0 ? s22Var2.b : null, (16335 & 4) != 0 ? s22Var2.c : null, (16335 & 8) != 0 ? s22Var2.d : null, (16335 & 16) != 0 ? s22Var2.e : false, (16335 & 32) != 0 ? s22Var2.f : null, (16335 & 64) != 0 ? s22Var2.g : null, (16335 & 128) != 0 ? s22Var2.h : null, (16335 & 256) != 0 ? s22Var2.i : null, (16335 & 512) != 0 ? s22Var2.j : null, (16335 & 1024) != 0 ? s22Var2.k : false, (16335 & 2048) != 0 ? s22Var2.l : null, (16335 & 4096) != 0 ? s22Var2.m : null, (16335 & 8192) != 0 ? s22Var2.n : false));
    }

    private final String U(Activity activity, Uri uri) {
        String string;
        String path;
        int iB0;
        int columnIndex;
        try {
            Cursor cursorQuery = activity.getContentResolver().query(uri, null, null, null, null);
            if (cursorQuery != null) {
                Cursor cursor = cursorQuery;
                try {
                    Cursor cursor2 = cursor;
                    string = (!cursor2.moveToFirst() || (columnIndex = cursor2.getColumnIndex("_display_name")) < 0) ? null : cursor2.getString(columnIndex);
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
            } else {
                string = null;
            }
            if ((string != null && string.length() != 0) || (path = uri.getPath()) == null || (iB0 = i.b0(path, JsonPointer.SEPARATOR, 0, false, 6, null)) < 0 || iB0 >= path.length() - 1) {
                return string;
            }
            String strSubstring = path.substring(iB0 + 1);
            p31.e(strSubstring, "substring(...)");
            return strSubstring;
        } catch (Exception e) {
            j("获取文件名失败", e);
            return null;
        }
    }

    private final String V(int i) {
        if (i == 1) {
            return "边框";
        }
        if (i != 2) {
            return i != 3 ? "其他样式" : "时间样式";
        }
        return "创意贴纸";
    }

    private final Pair W(String str) {
        Pair pair;
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            int i = options.outWidth;
            int i2 = options.outHeight;
            i("图片尺寸解析: " + i + "x" + i2);
            if (i <= 0 || i2 <= 0) {
                l("无法获取图片尺寸，使用默认值");
                pair = new Pair(1080, 1080);
            } else {
                pair = new Pair(Integer.valueOf(i), Integer.valueOf(i2));
            }
            return pair;
        } catch (Exception e) {
            j("获取图片尺寸失败", e);
            return new Pair(1080, 1080);
        }
    }

    private final List Y(List list) {
        ArrayList arrayList = new ArrayList();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : list) {
            Integer numValueOf = Integer.valueOf(((aw2) obj).g());
            Object arrayList2 = linkedHashMap.get(numValueOf);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                linkedHashMap.put(numValueOf, arrayList2);
            }
            ((List) arrayList2).add(obj);
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            int iIntValue = ((Number) entry.getKey()).intValue();
            xv2 xv2Var = new xv2(iIntValue, V(iIntValue), (List) entry.getValue());
            if (xv2Var.f()) {
                arrayList.add(xv2Var);
            }
        }
        return j.U(arrayList, new c());
    }

    private final void a0(NetworkError networkError, String str) {
        s22 s22Var = (s22) this.m.f();
        if (s22Var == null) {
            s22Var = new s22(null, null, null, null, false, null, null, null, null, null, false, null, null, false, 16383, null);
        }
        s22 s22Var2 = s22Var;
        String errorMessage = networkError.getErrorMessage();
        if (errorMessage == null) {
            errorMessage = str;
        }
        com.legend.smartwatch.app.base.viewmodel.a.k(this, "网络错误: " + errorMessage, null, 2, null);
        this.m.m(s22Var2.a((16335 & 1) != 0 ? s22Var2.a : null, (16335 & 2) != 0 ? s22Var2.b : null, (16335 & 4) != 0 ? s22Var2.c : null, (16335 & 8) != 0 ? s22Var2.d : null, (16335 & 16) != 0 ? s22Var2.e : false, (16335 & 32) != 0 ? s22Var2.f : errorMessage, (16335 & 64) != 0 ? s22Var2.g : null, (16335 & 128) != 0 ? s22Var2.h : null, (16335 & 256) != 0 ? s22Var2.i : null, (16335 & 512) != 0 ? s22Var2.j : null, (16335 & 1024) != 0 ? s22Var2.k : false, (16335 & 2048) != 0 ? s22Var2.l : null, (16335 & 4096) != 0 ? s22Var2.m : null, (16335 & 8192) != 0 ? s22Var2.n : false));
    }

    public static /* synthetic */ void c0(PicturePushViewModel picturePushViewModel, String str, Context context, int i, Object obj) {
        if ((i & 2) != 0) {
            context = null;
        }
        picturePushViewModel.b0(str, context);
    }

    private final void d0(aw2 aw2Var) {
        List listR;
        s22 s22VarA;
        List listR2;
        List listR3;
        s22 s22Var = (s22) this.m.f();
        if (s22Var == null) {
            s22Var = new s22(null, null, null, null, false, null, null, null, null, null, false, null, null, false, 16383, null);
        }
        s22 s22Var2 = s22Var;
        i("处理样式选择: " + aw2Var.e() + ", 类型: " + aw2Var.h() + ", 当前选中: " + aw2Var.k());
        if (aw2Var.i()) {
            List listY0 = y0(s22Var2.k(), aw2Var);
            aw2 aw2VarG = s22Var2.g();
            boolean zA = p31.a(aw2VarG != null ? aw2VarG.c() : null, aw2Var.c());
            aw2 aw2Var2 = zA ? null : aw2Var;
            if (zA) {
                List listJ = s22Var2.j();
                ArrayList arrayList = new ArrayList();
                for (Object obj : listJ) {
                    if (!((aw2) obj).i()) {
                        arrayList.add(obj);
                    }
                }
                listR3 = arrayList;
            } else {
                List listJ2 = s22Var2.j();
                ArrayList arrayList2 = new ArrayList();
                for (Object obj2 : listJ2) {
                    if (!((aw2) obj2).i()) {
                        arrayList2.add(obj2);
                    }
                }
                listR3 = j.R(arrayList2, aw2Var);
            }
            s22VarA = s22Var2.a((16335 & 1) != 0 ? s22Var2.a : null, (16335 & 2) != 0 ? s22Var2.b : null, (16335 & 4) != 0 ? s22Var2.c : null, (16335 & 8) != 0 ? s22Var2.d : listY0, (16335 & 16) != 0 ? s22Var2.e : false, (16335 & 32) != 0 ? s22Var2.f : null, (16335 & 64) != 0 ? s22Var2.g : listR3, (16335 & 128) != 0 ? s22Var2.h : aw2Var2, (16335 & 256) != 0 ? s22Var2.i : null, (16335 & 512) != 0 ? s22Var2.j : null, (16335 & 1024) != 0 ? s22Var2.k : false, (16335 & 2048) != 0 ? s22Var2.l : null, (16335 & 4096) != 0 ? s22Var2.m : null, (16335 & 8192) != 0 ? s22Var2.n : false);
        } else if (aw2Var.l()) {
            List listY1 = y0(s22Var2.k(), aw2Var);
            aw2 aw2VarI = s22Var2.i();
            boolean zA2 = p31.a(aw2VarI != null ? aw2VarI.c() : null, aw2Var.c());
            aw2 aw2Var3 = zA2 ? null : aw2Var;
            if (zA2) {
                List listJ3 = s22Var2.j();
                ArrayList arrayList3 = new ArrayList();
                for (Object obj3 : listJ3) {
                    if (!((aw2) obj3).l()) {
                        arrayList3.add(obj3);
                    }
                }
                listR2 = arrayList3;
            } else {
                List listJ4 = s22Var2.j();
                ArrayList arrayList4 = new ArrayList();
                for (Object obj4 : listJ4) {
                    if (!((aw2) obj4).l()) {
                        arrayList4.add(obj4);
                    }
                }
                listR2 = j.R(arrayList4, aw2Var);
            }
            s22VarA = s22Var2.a((16335 & 1) != 0 ? s22Var2.a : null, (16335 & 2) != 0 ? s22Var2.b : null, (16335 & 4) != 0 ? s22Var2.c : null, (16335 & 8) != 0 ? s22Var2.d : listY1, (16335 & 16) != 0 ? s22Var2.e : false, (16335 & 32) != 0 ? s22Var2.f : null, (16335 & 64) != 0 ? s22Var2.g : listR2, (16335 & 128) != 0 ? s22Var2.h : null, (16335 & 256) != 0 ? s22Var2.i : aw2Var3, (16335 & 512) != 0 ? s22Var2.j : null, (16335 & 1024) != 0 ? s22Var2.k : false, (16335 & 2048) != 0 ? s22Var2.l : null, (16335 & 4096) != 0 ? s22Var2.m : null, (16335 & 8192) != 0 ? s22Var2.n : false);
        } else {
            List listY2 = y0(s22Var2.k(), aw2Var);
            if (aw2Var.k()) {
                List listJ5 = s22Var2.j();
                ArrayList arrayList5 = new ArrayList();
                for (Object obj5 : listJ5) {
                    if (!p31.a(((aw2) obj5).c(), aw2Var.c())) {
                        arrayList5.add(obj5);
                    }
                }
                listR = arrayList5;
            } else {
                listR = j.R(s22Var2.j(), aw2Var);
            }
            s22VarA = s22Var2.a((16335 & 1) != 0 ? s22Var2.a : null, (16335 & 2) != 0 ? s22Var2.b : null, (16335 & 4) != 0 ? s22Var2.c : null, (16335 & 8) != 0 ? s22Var2.d : listY2, (16335 & 16) != 0 ? s22Var2.e : false, (16335 & 32) != 0 ? s22Var2.f : null, (16335 & 64) != 0 ? s22Var2.g : listR, (16335 & 128) != 0 ? s22Var2.h : null, (16335 & 256) != 0 ? s22Var2.i : null, (16335 & 512) != 0 ? s22Var2.j : null, (16335 & 1024) != 0 ? s22Var2.k : false, (16335 & 2048) != 0 ? s22Var2.l : null, (16335 & 4096) != 0 ? s22Var2.m : null, (16335 & 8192) != 0 ? s22Var2.n : false);
        }
        this.m.m(s22VarA);
        i("选择样式完成: " + aw2Var.e() + ", 类型: " + aw2Var.h() + ", 选中: " + (!aw2Var.k()));
        aw2 aw2VarG2 = s22VarA.g();
        String strE = aw2VarG2 != null ? aw2VarG2.e() : null;
        aw2 aw2VarI2 = s22VarA.i();
        i("更新后状态 - 边框: " + strE + ", 贴纸: " + (aw2VarI2 != null ? aw2VarI2.e() : null));
        this.o.o(r22.c.a);
    }

    private final void h0() {
        s22 s22Var = (s22) this.m.f();
        if (s22Var == null) {
            s22Var = new s22(null, null, null, null, false, null, null, null, null, null, false, null, null, false, 16383, null);
        }
        if (s22Var.e() != null || s22Var.f() != null) {
            this.o.o(r22.l.a);
            i("触发图片上传事件");
        } else {
            String strD = rv2.d(R.string.select_image_prompt);
            p31.e(strD, "getString(...)");
            u0(strD);
        }
    }

    private final Object k0(Canvas canvas, String str, int i, int i2, x30 x30Var) {
        l("网络图片合成需要在Activity中处理");
        return k83.a;
    }

    private final void l0() {
        final s22 s22Var = (s22) this.m.f();
        if (s22Var == null) {
            s22Var = new s22(null, null, null, null, false, null, null, null, null, null, false, null, null, false, 16383, null);
        }
        s22 s22Var2 = s22Var;
        this.m.m(s22Var2.a((16335 & 1) != 0 ? s22Var2.a : null, (16335 & 2) != 0 ? s22Var2.b : null, (16335 & 4) != 0 ? s22Var2.c : null, (16335 & 8) != 0 ? s22Var2.d : null, (16335 & 16) != 0 ? s22Var2.e : true, (16335 & 32) != 0 ? s22Var2.f : null, (16335 & 64) != 0 ? s22Var2.g : null, (16335 & 128) != 0 ? s22Var2.h : null, (16335 & 256) != 0 ? s22Var2.i : null, (16335 & 512) != 0 ? s22Var2.j : null, (16335 & 1024) != 0 ? s22Var2.k : false, (16335 & 2048) != 0 ? s22Var2.l : null, (16335 & 4096) != 0 ? s22Var2.m : null, (16335 & 8192) != 0 ? s22Var2.n : false));
        this.f404q.getBadgeImageList(new ar0() { // from class: t22
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return PicturePushViewModel.m0(this.a, s22Var, (List) obj);
            }
        }, new ar0() { // from class: u22
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return PicturePushViewModel.n0(this.a, (NetworkError) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 m0(PicturePushViewModel picturePushViewModel, s22 s22Var, List list) {
        p31.f(list, "allImages");
        List listI = picturePushViewModel.I(list);
        List listY = picturePushViewModel.Y(listI);
        picturePushViewModel.m.m(s22Var.a((16335 & 1) != 0 ? s22Var.a : null, (16335 & 2) != 0 ? s22Var.b : null, (16335 & 4) != 0 ? s22Var.c : null, (16335 & 8) != 0 ? s22Var.d : listY, (16335 & 16) != 0 ? s22Var.e : false, (16335 & 32) != 0 ? s22Var.f : null, (16335 & 64) != 0 ? s22Var.g : null, (16335 & 128) != 0 ? s22Var.h : null, (16335 & 256) != 0 ? s22Var.i : null, (16335 & 512) != 0 ? s22Var.j : null, (16335 & 1024) != 0 ? s22Var.k : false, (16335 & 2048) != 0 ? s22Var.l : null, (16335 & 4096) != 0 ? s22Var.m : null, (16335 & 8192) != 0 ? s22Var.n : false));
        picturePushViewModel.i("样式数据加载完成，共" + listI.size() + "个样式，分为" + listY.size() + "个分组");
        return k83.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 n0(PicturePushViewModel picturePushViewModel, NetworkError networkError) {
        p31.f(networkError, "error");
        picturePushViewModel.a0(networkError, "加载样式数据失败");
        return k83.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object p0(Context context, String str, boolean z, x30 x30Var) {
        return BuildersKt.withContext(Dispatchers.getIO(), new PicturePushViewModel$prepareUploadFromComposite$2(this, context, str, z, null), x30Var);
    }

    private final String q0(Activity activity, String str, Pair pair, Pair pair2) {
        Bitmap.CompressFormat compressFormat;
        try {
            int iFloatValue = (int) (((Number) pair2.getFirst()).floatValue() * 2.0f);
            int iFloatValue2 = (int) (((Number) pair2.getSecond()).floatValue() * 2.0f);
            if (((Number) pair.getFirst()).intValue() >= iFloatValue && ((Number) pair.getSecond()).intValue() >= iFloatValue2) {
                i("图片尺寸足够，无需预处理: " + pair.getFirst() + "x" + pair.getSecond() + ", 最小需要: " + iFloatValue + "x" + iFloatValue2);
                return null;
            }
            float fMax = Math.max(iFloatValue / ((Number) pair.getFirst()).floatValue(), iFloatValue2 / ((Number) pair.getSecond()).floatValue());
            if (fMax <= 1.0f) {
                i("图片不需要放大，scale: " + fMax);
                return null;
            }
            i("图片需要放大: " + pair.getFirst() + "x" + pair.getSecond() + " -> scale: " + fMax + ", 目标: " + iFloatValue + "x" + iFloatValue2);
            Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(str);
            if (bitmapDecodeFile == null) {
                com.legend.smartwatch.app.base.viewmodel.a.k(this, "无法加载原始图片: " + str, null, 2, null);
                return null;
            }
            int iFloatValue3 = (int) (((Number) pair.getFirst()).floatValue() * fMax);
            int iFloatValue4 = (int) (((Number) pair.getSecond()).floatValue() * fMax);
            i("开始放大图片: " + pair.getFirst() + "x" + pair.getSecond() + " -> " + iFloatValue3 + "x" + iFloatValue4);
            Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapDecodeFile, iFloatValue3, iFloatValue4, true);
            p31.e(bitmapCreateScaledBitmap, "createScaledBitmap(...)");
            bitmapDecodeFile.recycle();
            File file = new File(activity.getExternalFilesDir(null), "preprocess");
            if (!file.exists()) {
                file.mkdirs();
            }
            String strM = g.m(str);
            File file2 = new File(file, "preprocess_" + System.currentTimeMillis() + FileUtils.FILE_EXTENSION_SEPARATOR + strM);
            p31.c(strM);
            String lowerCase = strM.toLowerCase(Locale.ROOT);
            p31.e(lowerCase, "toLowerCase(...)");
            if (p31.a(lowerCase, "png")) {
                compressFormat = Bitmap.CompressFormat.PNG;
            } else {
                compressFormat = p31.a(lowerCase, "webp") ? Bitmap.CompressFormat.WEBP : Bitmap.CompressFormat.JPEG;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            bitmapCreateScaledBitmap.compress(compressFormat, 95, fileOutputStream);
            fileOutputStream.close();
            bitmapCreateScaledBitmap.recycle();
            i("图片预处理完成: " + iFloatValue3 + "x" + iFloatValue4 + ", 保存到: " + file2.getAbsolutePath());
            return file2.getAbsolutePath();
        } catch (Exception e) {
            j("图片预处理失败: " + e.getMessage(), e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u0(String str) {
        s22 s22Var = (s22) this.m.f();
        if (s22Var == null) {
            s22Var = new s22(null, null, null, null, false, null, null, null, null, null, false, null, null, false, 16383, null);
        }
        s22 s22Var2 = s22Var;
        this.m.m(s22Var2.a((16335 & 1) != 0 ? s22Var2.a : null, (16335 & 2) != 0 ? s22Var2.b : null, (16335 & 4) != 0 ? s22Var2.c : null, (16335 & 8) != 0 ? s22Var2.d : null, (16335 & 16) != 0 ? s22Var2.e : false, (16335 & 32) != 0 ? s22Var2.f : str, (16335 & 64) != 0 ? s22Var2.g : null, (16335 & 128) != 0 ? s22Var2.h : null, (16335 & 256) != 0 ? s22Var2.i : null, (16335 & 512) != 0 ? s22Var2.j : null, (16335 & 1024) != 0 ? s22Var2.k : false, (16335 & 2048) != 0 ? s22Var2.l : null, (16335 & 4096) != 0 ? s22Var2.m : null, (16335 & 8192) != 0 ? s22Var2.n : false));
    }

    private final void v0(Activity activity, String str, String str2, Pair pair, Pair pair2) {
        try {
            i("启动自定义 UCrop 裁剪");
            String strQ0 = q0(activity, str, pair, pair2);
            if (strQ0 != null) {
                str = strQ0;
            }
            Pair pairW = strQ0 != null ? W(str) : pair;
            if (strQ0 != null) {
                i("使用预处理后的图片: " + str + ", 尺寸: " + pairW.getFirst() + "x" + pairW.getSecond());
            }
            File file = new File(activity.getExternalFilesDir(null), "crop");
            if (!file.exists()) {
                file.mkdirs();
            }
            String strC = i.C(str2, "image/", FileUtils.FILE_EXTENSION_SEPARATOR, false, 4, null);
            File file2 = new File(file, "crop_" + System.currentTimeMillis() + strC);
            Uri uriFromFile = Uri.fromFile(new File(str));
            Uri uriFromFile2 = Uri.fromFile(file2);
            com.yalantis.ucrop.b.a aVar = new com.yalantis.ucrop.b.a();
            aVar.k(100);
            aVar.u(false);
            aVar.r(true);
            aVar.J("图片裁剪");
            aVar.E(true);
            aVar.D(true);
            aVar.F(true);
            aVar.G(false);
            aVar.h(false);
            aVar.s(true);
            aVar.t(1);
            aVar.l(true);
            aVar.q(true);
            aVar.L(((Number) pair2.getFirst()).intValue(), ((Number) pair2.getSecond()).intValue());
            aVar.M(((Number) pair2.getFirst()).intValue(), ((Number) pair2.getSecond()).intValue());
            aVar.x(((Number) pairW.getFirst()).intValue());
            aVar.w(((Number) pairW.getSecond()).intValue());
            aVar.y(2048);
            aVar.z(3.0f);
            aVar.h(true);
            aVar.g(1, 2, 3);
            aVar.v(200);
            i("UCrop 配置:");
            i("  原始输入尺寸: " + pair.getFirst() + "x" + pair.getSecond());
            i("  实际输入尺寸: " + pairW.getFirst() + "x" + pairW.getSecond());
            i("  目标尺寸: " + pair2.getFirst() + "x" + pair2.getSecond());
            i("  宽高比: " + pair2.getFirst() + ":" + pair2.getSecond());
            i("  缩放启用: true");
            i("  旋转启用: true");
            i("  自由裁剪: true");
            i("  最大位图大小: 2048");
            i("  最大缩放倍数: 3.0x");
            i("  允许手势: 缩放+旋转+宽高比");
            i("  动画持续时间: 200ms");
            if (strQ0 != null) {
                i("  已预处理: 是");
            }
            com.yalantis.ucrop.b bVarN = com.yalantis.ucrop.b.e(uriFromFile, uriFromFile2).n(aVar);
            p31.d(activity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
            bVarN.h((AppCompatActivity) activity);
        } catch (Exception e) {
            j("启动自定义 UCrop 失败", e);
            Z(new r22.f("图片裁剪启动失败，请重试"));
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:31:0x00bd  */
    private final void w0(Activity activity, String str) {
        String str2;
        String str3;
        String str4;
        try {
            i("开始使用 Picture 库裁剪图片: " + str);
            if (!new File(str).exists()) {
                com.legend.smartwatch.app.base.viewmodel.a.k(this, "沙盒图片文件不存在: " + str, null, 2, null);
                Z(new r22.f("图片文件不存在"));
                return;
            }
            Pair pairW = W(str);
            i("图片实际尺寸: " + pairW.getFirst() + "x" + pairW.getSecond());
            String strM = g.m(str);
            p31.c(strM);
            String lowerCase = strM.toLowerCase(Locale.ROOT);
            p31.e(lowerCase, "toLowerCase(...)");
            switch (lowerCase.hashCode()) {
                case 97669:
                    if (!lowerCase.equals("bmp")) {
                        str2 = Checker.MIME_TYPE_JPEG;
                    } else {
                        str3 = "image/bmp";
                        str2 = str3;
                    }
                    break;
                case 102340:
                    if (!lowerCase.equals("gif")) {
                        str2 = Checker.MIME_TYPE_JPEG;
                    } else {
                        str3 = "image/gif";
                        str2 = str3;
                    }
                    break;
                case 105441:
                    str4 = "jpg";
                    lowerCase.equals(str4);
                    str2 = Checker.MIME_TYPE_JPEG;
                    break;
                case 111145:
                    if (!lowerCase.equals("png")) {
                        str2 = Checker.MIME_TYPE_JPEG;
                    } else {
                        str3 = "image/png";
                        str2 = str3;
                    }
                    break;
                case 3268712:
                    str4 = "jpeg";
                    lowerCase.equals(str4);
                    str2 = Checker.MIME_TYPE_JPEG;
                    break;
                case 3645340:
                    if (!lowerCase.equals("webp")) {
                        str2 = Checker.MIME_TYPE_JPEG;
                    } else {
                        str3 = "image/webp";
                        str2 = str3;
                    }
                    break;
                default:
                    str2 = Checker.MIME_TYPE_JPEG;
                    break;
            }
            i("文件扩展名: " + strM + ", MIME类型: " + str2);
            Q();
            Pair pairS = S();
            i("目标裁剪尺寸: " + pairS.getFirst() + "x" + pairS.getSecond());
            v0(activity, str, str2, pairW, pairS);
        } catch (Exception e) {
            j("启动 Picture 库裁剪失败", e);
            Z(new r22.f("图片裁剪失败，请重试"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x0(Context context, WatchThemeTransferManager.b bVar) {
        im1 im1Var = this.m;
        s22 s22Var = (s22) im1Var.f();
        if (s22Var == null) {
            s22Var = new s22(null, null, null, null, false, null, null, null, null, null, false, null, null, false, 16383, null);
        }
        s22 s22Var2 = s22Var;
        im1Var.m(s22Var2.a((16335 & 1) != 0 ? s22Var2.a : null, (16335 & 2) != 0 ? s22Var2.b : null, (16335 & 4) != 0 ? s22Var2.c : null, (16335 & 8) != 0 ? s22Var2.d : null, (16335 & 16) != 0 ? s22Var2.e : true, (16335 & 32) != 0 ? s22Var2.f : null, (16335 & 64) != 0 ? s22Var2.g : null, (16335 & 128) != 0 ? s22Var2.h : null, (16335 & 256) != 0 ? s22Var2.i : null, (16335 & 512) != 0 ? s22Var2.j : null, (16335 & 1024) != 0 ? s22Var2.k : false, (16335 & 2048) != 0 ? s22Var2.l : null, (16335 & 4096) != 0 ? s22Var2.m : null, (16335 & 8192) != 0 ? s22Var2.n : false));
        this.t = true;
        im1 im1Var2 = this.o;
        String strD = rv2.d(R.string.preparing_for_upload);
        p31.e(strD, "getString(...)");
        im1Var2.o(new r22.h(strD, 0));
        this.s.X(context, bVar, N());
    }

    private final List y0(List list, aw2 aw2Var) {
        ArrayList arrayList = new ArrayList(j.t(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            xv2 xv2Var = (xv2) it.next();
            List<aw2> listC = xv2Var.c();
            ArrayList arrayList2 = new ArrayList(j.t(listC, 10));
            for (aw2 aw2VarB : listC) {
                if (p31.a(aw2VarB.c(), aw2Var.c())) {
                    aw2VarB = aw2.b(aw2VarB, null, null, null, aw2Var.k(), 0, 23, null);
                } else if (aw2Var.i() && aw2VarB.i()) {
                    aw2VarB = aw2.b(aw2VarB, null, null, null, false, 0, 23, null);
                } else if (aw2Var.l() && aw2VarB.l()) {
                    aw2VarB = aw2.b(aw2VarB, null, null, null, false, 0, 23, null);
                }
                arrayList2.add(aw2VarB);
            }
            arrayList.add(xv2.b(xv2Var, 0, null, arrayList2, 3, null));
        }
        return arrayList;
    }

    public final void G() {
        this.o.o(null);
    }

    public final void H() {
        s22 s22Var = (s22) this.m.f();
        if (s22Var == null) {
            return;
        }
        if (s22Var.l() == null && s22Var.h() == null) {
            return;
        }
        String strL = s22Var.l();
        if (strL == null) {
            strL = this.x;
        }
        this.x = strL;
        O();
        this.m.m(s22Var.a((16335 & 1) != 0 ? s22Var.a : null, (16335 & 2) != 0 ? s22Var.b : null, (16335 & 4) != 0 ? s22Var.c : null, (16335 & 8) != 0 ? s22Var.d : null, (16335 & 16) != 0 ? s22Var.e : false, (16335 & 32) != 0 ? s22Var.f : null, (16335 & 64) != 0 ? s22Var.g : null, (16335 & 128) != 0 ? s22Var.h : null, (16335 & 256) != 0 ? s22Var.i : null, (16335 & 512) != 0 ? s22Var.j : null, (16335 & 1024) != 0 ? s22Var.k : false, (16335 & 2048) != 0 ? s22Var.l : null, (16335 & 4096) != 0 ? s22Var.m : null, (16335 & 8192) != 0 ? s22Var.n : false));
    }

    public final Intent L() {
        Intent intent;
        try {
            i("创建系统相册选择 Intent");
            if (Build.VERSION.SDK_INT >= 35) {
                i("使用 Intent.ACTION_GET_CONTENT (Android 16+)");
                intent = new Intent("android.intent.action.GET_CONTENT");
                intent.setType("image/*");
                intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", false);
                intent.addCategory("android.intent.category.OPENABLE");
            } else {
                i("使用 Intent.ACTION_PICK (Android 16 以下)");
                intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                intent.setType("image/*");
                intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", false);
            }
            return intent;
        } catch (Exception e) {
            j("无法创建系统相册 Intent", e);
            Z(new r22.f("无法打开相册，请检查权限设置"));
            return null;
        }
    }

    public final Pair M(Activity activity) {
        p31.f(activity, "activity");
        try {
            i("创建系统相机拍照 Intent");
            File file = new File(activity.getExternalFilesDir(null), "images");
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, "camera_" + System.currentTimeMillis() + ".jpg");
            i("临时照片文件路径: " + file2.getAbsolutePath());
            Uri uriH = FileProvider.h(activity, activity.getPackageName() + ".fileprovider", file2);
            p31.e(uriH, "getUriForFile(...)");
            i("照片 URI: " + uriH);
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            intent.putExtra("output", uriH);
            intent.addFlags(1);
            intent.addFlags(2);
            i("系统相机 Intent 创建成功");
            return new Pair(intent, file2);
        } catch (Exception e) {
            j("无法创建系统相机 Intent", e);
            Z(new r22.f("无法打开相机，请检查权限设置"));
            return null;
        }
    }

    public final Pair S() {
        Pair pair;
        try {
            ClockDialInfoBody clockDialInfoBodyA = py.a.a();
            if (clockDialInfoBodyA != null) {
                short width = clockDialInfoBodyA.getWidth();
                short height = clockDialInfoBodyA.getHeight();
                i("=== 图片裁剪尺寸设置 ===");
                i("从表盘信息获取尺寸: " + ((int) width) + "x" + ((int) height));
                i("设备屏幕尺寸: " + ((int) width) + "x" + ((int) height));
                String devId = clockDialInfoBodyA.getDevId();
                StringBuilder sb = new StringBuilder();
                sb.append("设备ID: ");
                sb.append(devId);
                i(sb.toString());
                i("屏幕类型: " + (clockDialInfoBodyA.getScreenType() == 0 ? "方屏" : "圆屏"));
                pair = new Pair(Integer.valueOf(width), Integer.valueOf(height));
            } else {
                l("表盘信息不存在，使用默认裁剪尺寸");
                pair = new Pair(320, 384);
                i("默认裁剪尺寸: " + pair.getFirst() + "x" + pair.getSecond());
            }
            return pair;
        } catch (Exception e) {
            com.legend.smartwatch.app.base.viewmodel.a.k(this, "获取表盘信息失败，使用默认裁剪尺寸: " + e.getMessage(), null, 2, null);
            Pair pair2 = new Pair(320, 384);
            i("异常情况使用默认裁剪尺寸: " + pair2.getFirst() + "x" + pair2.getSecond());
            return pair2;
        }
    }

    public final im1 T() {
        return this.p;
    }

    public final im1 X() {
        return this.n;
    }

    public final void Z(r22 r22Var) {
        p31.f(r22Var, "event");
        if (r22Var instanceof r22.j) {
            this.o.o(r22.j.a);
            return;
        }
        if (r22Var instanceof r22.d) {
            this.o.o(r22.d.a);
            return;
        }
        if (r22Var instanceof r22.l) {
            h0();
            return;
        }
        if (r22Var instanceof r22.e) {
            d0(((r22.e) r22Var).a());
            return;
        }
        if (r22Var instanceof r22.b) {
            l0();
            return;
        }
        if (r22Var instanceof r22.f) {
            u0(((r22.f) r22Var).a());
        } else if (r22Var instanceof r22.a) {
            F();
        } else {
            this.o.o(r22Var);
        }
    }

    public final void b0(String str, Context context) {
        PicturePushViewModel picturePushViewModel = this;
        p31.f(str, "imagePath");
        try {
            picturePushViewModel.i("处理图片选择结果: " + str);
            if (str.length() == 0) {
                picturePushViewModel.l("图片路径为空");
                picturePushViewModel.u0("图片获取失败，请重试");
                return;
            }
            Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(str);
            if (bitmapDecodeFile == null) {
                picturePushViewModel.l("无法解析图片文件");
                picturePushViewModel.u0("图片解析失败，请重试");
                return;
            }
            s22 s22Var = (s22) picturePushViewModel.m.f();
            if (s22Var == null) {
                s22Var = new s22(null, null, null, null, false, null, null, null, null, null, false, null, null, false, 16383, null);
            }
            try {
                picturePushViewModel.m.o(s22Var.a((16335 & 1) != 0 ? s22Var.a : bitmapDecodeFile, (16335 & 2) != 0 ? s22Var.b : null, (16335 & 4) != 0 ? s22Var.c : null, (16335 & 8) != 0 ? s22Var.d : null, (16335 & 16) != 0 ? s22Var.e : false, (16335 & 32) != 0 ? s22Var.f : null, (16335 & 64) != 0 ? s22Var.g : null, (16335 & 128) != 0 ? s22Var.h : null, (16335 & 256) != 0 ? s22Var.i : null, (16335 & 512) != 0 ? s22Var.j : null, (16335 & 1024) != 0 ? s22Var.k : false, (16335 & 2048) != 0 ? s22Var.l : null, (16335 & 4096) != 0 ? s22Var.m : null, (16335 & 8192) != 0 ? s22Var.n : false));
                this.o.o(r22.c.a);
                i("图片设置成功: " + bitmapDecodeFile.getWidth() + "x" + bitmapDecodeFile.getHeight());
            } catch (Exception e) {
                e = e;
                picturePushViewModel = this;
                com.legend.smartwatch.app.base.viewmodel.a.k(picturePushViewModel, "处理图片选择结果失败: " + e.getMessage(), null, 2, null);
                picturePushViewModel.u0("图片处理失败，请重试");
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    @Override // com.legend.smartwatch.app.base.viewmodel.a, androidx.lifecycle.o
    protected void d() {
        Job job = this.v;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.t = false;
        super.d();
    }

    /* JADX WARN: Code duplicated, block: B:24:0x010a A[Catch: Exception -> 0x0029, TryCatch #0 {Exception -> 0x0029, blocks: (B:3:0x000c, B:8:0x002c, B:10:0x008d, B:12:0x009f, B:14:0x00ae, B:16:0x00bd, B:18:0x00cc, B:20:0x00db, B:23:0x00eb, B:24:0x010a, B:26:0x0110, B:27:0x0128), top: B:32:0x000c }] */
    /* JADX WARN: Code duplicated, block: B:26:0x0110 A[Catch: Exception -> 0x0029, TryCatch #0 {Exception -> 0x0029, blocks: (B:3:0x000c, B:8:0x002c, B:10:0x008d, B:12:0x009f, B:14:0x00ae, B:16:0x00bd, B:18:0x00cc, B:20:0x00db, B:23:0x00eb, B:24:0x010a, B:26:0x0110, B:27:0x0128), top: B:32:0x000c }] */
    /* JADX WARN: Code duplicated, block: B:27:0x0128 A[Catch: Exception -> 0x0029, TRY_LEAVE, TryCatch #0 {Exception -> 0x0029, blocks: (B:3:0x000c, B:8:0x002c, B:10:0x008d, B:12:0x009f, B:14:0x00ae, B:16:0x00bd, B:18:0x00cc, B:20:0x00db, B:23:0x00eb, B:24:0x010a, B:26:0x0110, B:27:0x0128), top: B:32:0x000c }] */
    /* JADX WARN: Instruction removed from duplicated block: B:26:0x0110, please report this as an issue */
    public final void e0(Activity activity, Uri uri) {
        String strJ;
        p31.f(activity, "activity");
        p31.f(uri, "uri");
        try {
            i("系统相册选择结果: " + uri);
            String strU = U(activity, uri);
            if (strU == null) {
                strU = "image.jpg";
            }
            String strM = g.m(strU);
            i("文件信息:");
            i("  原始URI: " + uri);
            i("  文件名: " + strU);
            i("  文件扩展名: " + strM);
            if (j.m("jpg", "jpeg", "png", "gif", "bmp", "webp").contains(strM)) {
                strJ = J(activity, uri, strU);
                if (strJ != null) {
                    i("图片已拷贝到沙盒: " + strJ);
                    w0(activity, strJ);
                } else {
                    com.legend.smartwatch.app.base.viewmodel.a.k(this, "图片拷贝到沙盒失败", null, 2, null);
                    Z(new r22.f("图片处理失败，请重试"));
                }
            } else {
                Locale locale = Locale.ROOT;
                String lowerCase = strU.toLowerCase(locale);
                p31.e(lowerCase, "toLowerCase(...)");
                if (i.u(lowerCase, ".jpg", false, 2, null)) {
                    strJ = J(activity, uri, strU);
                    if (strJ != null) {
                        i("图片已拷贝到沙盒: " + strJ);
                        w0(activity, strJ);
                    } else {
                        com.legend.smartwatch.app.base.viewmodel.a.k(this, "图片拷贝到沙盒失败", null, 2, null);
                        Z(new r22.f("图片处理失败，请重试"));
                    }
                } else {
                    String lowerCase2 = strU.toLowerCase(locale);
                    p31.e(lowerCase2, "toLowerCase(...)");
                    if (i.u(lowerCase2, ".jpeg", false, 2, null)) {
                        strJ = J(activity, uri, strU);
                        if (strJ != null) {
                            i("图片已拷贝到沙盒: " + strJ);
                            w0(activity, strJ);
                        } else {
                            com.legend.smartwatch.app.base.viewmodel.a.k(this, "图片拷贝到沙盒失败", null, 2, null);
                            Z(new r22.f("图片处理失败，请重试"));
                        }
                    } else {
                        String lowerCase3 = strU.toLowerCase(locale);
                        p31.e(lowerCase3, "toLowerCase(...)");
                        if (i.u(lowerCase3, ".png", false, 2, null)) {
                            strJ = J(activity, uri, strU);
                            if (strJ != null) {
                                i("图片已拷贝到沙盒: " + strJ);
                                w0(activity, strJ);
                            } else {
                                com.legend.smartwatch.app.base.viewmodel.a.k(this, "图片拷贝到沙盒失败", null, 2, null);
                                Z(new r22.f("图片处理失败，请重试"));
                            }
                        } else {
                            String lowerCase4 = strU.toLowerCase(locale);
                            p31.e(lowerCase4, "toLowerCase(...)");
                            if (i.u(lowerCase4, ".gif", false, 2, null)) {
                                strJ = J(activity, uri, strU);
                                if (strJ != null) {
                                    i("图片已拷贝到沙盒: " + strJ);
                                    w0(activity, strJ);
                                } else {
                                    com.legend.smartwatch.app.base.viewmodel.a.k(this, "图片拷贝到沙盒失败", null, 2, null);
                                    Z(new r22.f("图片处理失败，请重试"));
                                }
                            } else {
                                String lowerCase5 = strU.toLowerCase(locale);
                                p31.e(lowerCase5, "toLowerCase(...)");
                                if (i.u(lowerCase5, ".bmp", false, 2, null)) {
                                    strJ = J(activity, uri, strU);
                                    if (strJ != null) {
                                        i("图片已拷贝到沙盒: " + strJ);
                                        w0(activity, strJ);
                                    } else {
                                        com.legend.smartwatch.app.base.viewmodel.a.k(this, "图片拷贝到沙盒失败", null, 2, null);
                                        Z(new r22.f("图片处理失败，请重试"));
                                    }
                                } else {
                                    String lowerCase6 = strU.toLowerCase(locale);
                                    p31.e(lowerCase6, "toLowerCase(...)");
                                    if (i.u(lowerCase6, ".webp", false, 2, null)) {
                                        strJ = J(activity, uri, strU);
                                        if (strJ != null) {
                                            i("图片已拷贝到沙盒: " + strJ);
                                            w0(activity, strJ);
                                        } else {
                                            com.legend.smartwatch.app.base.viewmodel.a.k(this, "图片拷贝到沙盒失败", null, 2, null);
                                            Z(new r22.f("图片处理失败，请重试"));
                                        }
                                    } else {
                                        l("不是支持的图片文件: 扩展名=" + strM);
                                        Z(new r22.f("请选择支持的图片文件"));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            j("处理系统相册结果失败", e);
            Z(new r22.f("文件处理失败，请重试"));
        }
    }

    public final void f0(Activity activity, File file) {
        p31.f(activity, "activity");
        p31.f(file, "photoFile");
        try {
            i("处理系统相机拍照结果: " + file.getAbsolutePath());
            if (!file.exists()) {
                com.legend.smartwatch.app.base.viewmodel.a.k(this, "拍照文件不存在: " + file.getAbsolutePath(), null, 2, null);
                Z(new r22.f("拍照失败，文件不存在"));
                return;
            }
            if (file.length() == 0) {
                com.legend.smartwatch.app.base.viewmodel.a.k(this, "拍照文件大小为0: " + file.getAbsolutePath(), null, 2, null);
                Z(new r22.f("拍照失败，文件为空"));
                return;
            }
            i("拍照文件大小: " + file.length() + " bytes");
            String absolutePath = file.getAbsolutePath();
            p31.e(absolutePath, "getAbsolutePath(...)");
            w0(activity, absolutePath);
        } catch (Exception e) {
            j("处理系统相机拍照结果失败", e);
            Z(new r22.f("图片处理失败，请重试"));
        }
    }

    public final void g0(Activity activity, String str) {
        p31.f(activity, "activity");
        p31.f(str, "imagePath");
        try {
            i("UCrop 裁剪完成: " + str);
            if (str.length() <= 0 || !new File(str).exists()) {
                com.legend.smartwatch.app.base.viewmodel.a.k(this, "裁剪后的图片文件不存在: " + str, null, 2, null);
                Z(new r22.f("图片裁剪失败，请重试"));
            } else {
                File file = new File(str);
                if (file.length() > 0) {
                    i("裁剪后图片大小: " + file.length() + " bytes");
                    b0(P(activity, str, S()), activity);
                } else {
                    com.legend.smartwatch.app.base.viewmodel.a.k(this, "裁剪后的图片文件为空", null, 2, null);
                    Z(new r22.f("图片裁剪失败，文件为空"));
                }
            }
        } catch (Exception e) {
            j("处理 UCrop 结果失败", e);
            Z(new r22.f("图片处理失败，请重试"));
        }
    }

    public final void i0(sg3 sg3Var) {
        p31.f(sg3Var, "event");
        if (this.u) {
            Job job = this.v;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            this.u = false;
            long jA = sg3Var.a();
            s22 s22Var = (s22) this.m.f();
            if (s22Var == null) {
                s22Var = new s22(null, null, null, null, false, null, null, null, null, null, false, null, null, false, 16383, null);
            }
            s22 s22Var2 = s22Var;
            Long lH = s22Var2.h();
            this.m.m(s22Var2.a((16335 & 1) != 0 ? s22Var2.a : null, (16335 & 2) != 0 ? s22Var2.b : null, (16335 & 4) != 0 ? s22Var2.c : null, (16335 & 8) != 0 ? s22Var2.d : null, (16335 & 16) != 0 ? s22Var2.e : false, (16335 & 32) != 0 ? s22Var2.f : null, (16335 & 64) != 0 ? s22Var2.g : null, (16335 & 128) != 0 ? s22Var2.h : null, (16335 & 256) != 0 ? s22Var2.i : null, (16335 & 512) != 0 ? s22Var2.j : Long.valueOf(jA), (16335 & 1024) != 0 ? s22Var2.k : false, (16335 & 2048) != 0 ? s22Var2.l : null, (16335 & 4096) != 0 ? s22Var2.m : null, (16335 & 8192) != 0 ? s22Var2.n : lH != null && lH.longValue() > cb0.a.b(jA)));
        }
    }

    public final boolean j0() {
        return this.t;
    }

    public final void o0(Context context, String str) {
        p31.f(context, "context");
        p31.f(str, "compositePath");
        BuildersKt__Builders_commonKt.launch$default(p.a(this), null, null, new PicturePushViewModel$prepareAndUploadWithComposite$1(this, context, str, null), 3, null);
    }

    public final void r0(Context context, String str) {
        p31.f(context, "context");
        p31.f(str, "compositePath");
        Job job = this.w;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.w = BuildersKt__Builders_commonKt.launch$default(p.a(this), null, null, new PicturePushViewModel$refreshUploadFileInfoFromComposite$1(this, context, str, null), 3, null);
    }

    public final void s0() {
        if (!zi2.i()) {
            this.u = false;
            Job job = this.v;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            im1 im1Var = this.m;
            s22 s22Var = (s22) im1Var.f();
            if (s22Var == null) {
                s22Var = new s22(null, null, null, null, false, null, null, null, null, null, false, null, null, false, 16383, null);
            }
            s22 s22Var2 = s22Var;
            im1Var.m(s22Var2.a((16335 & 1) != 0 ? s22Var2.a : null, (16335 & 2) != 0 ? s22Var2.b : null, (16335 & 4) != 0 ? s22Var2.c : null, (16335 & 8) != 0 ? s22Var2.d : null, (16335 & 16) != 0 ? s22Var2.e : false, (16335 & 32) != 0 ? s22Var2.f : null, (16335 & 64) != 0 ? s22Var2.g : null, (16335 & 128) != 0 ? s22Var2.h : null, (16335 & 256) != 0 ? s22Var2.i : null, (16335 & 512) != 0 ? s22Var2.j : null, (16335 & 1024) != 0 ? s22Var2.k : false, (16335 & 2048) != 0 ? s22Var2.l : null, (16335 & 4096) != 0 ? s22Var2.m : null, (16335 & 8192) != 0 ? s22Var2.n : false));
            String strD = rv2.d(R.string.bluetooth_not_connected);
            p31.e(strD, "getString(...)");
            u0(strD);
            return;
        }
        Job job2 = this.v;
        if (job2 != null) {
            Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
        }
        this.u = true;
        im1 im1Var2 = this.m;
        s22 s22Var3 = (s22) im1Var2.f();
        if (s22Var3 == null) {
            s22Var3 = new s22(null, null, null, null, false, null, null, null, null, null, false, null, null, false, 16383, null);
        }
        s22 s22Var4 = s22Var3;
        im1Var2.m(s22Var4.a((16335 & 1) != 0 ? s22Var4.a : null, (16335 & 2) != 0 ? s22Var4.b : null, (16335 & 4) != 0 ? s22Var4.c : null, (16335 & 8) != 0 ? s22Var4.d : null, (16335 & 16) != 0 ? s22Var4.e : false, (16335 & 32) != 0 ? s22Var4.f : null, (16335 & 64) != 0 ? s22Var4.g : null, (16335 & 128) != 0 ? s22Var4.h : null, (16335 & 256) != 0 ? s22Var4.i : null, (16335 & 512) != 0 ? s22Var4.j : null, (16335 & 1024) != 0 ? s22Var4.k : true, (16335 & 2048) != 0 ? s22Var4.l : null, (16335 & 4096) != 0 ? s22Var4.m : null, (16335 & 8192) != 0 ? s22Var4.n : false));
        try {
            byte[] bArrJ = zi2.j();
            if (bArrJ != null && bArrJ.length != 0) {
                zi2.e().K(bArrJ, "获取表盘剩余空间");
                this.v = BuildersKt__Builders_commonKt.launch$default(p.a(this), null, null, new PicturePushViewModel$requestDeviceFreeStorage$1(this, null), 3, null);
                return;
            }
            R();
            String strD2 = rv2.d(R.string.device_storage_fetch_failed);
            p31.e(strD2, "getString(...)");
            u0(strD2);
        } catch (Exception e) {
            com.legend.smartwatch.app.base.viewmodel.a.k(this, "获取表盘剩余空间失败: " + e.getMessage(), null, 2, null);
            R();
            String strD3 = rv2.d(R.string.device_storage_fetch_failed);
            p31.e(strD3, "getString(...)");
            u0(strD3);
        }
    }

    public final void t0(BajiProtocolManager bajiProtocolManager) {
        this.r = bajiProtocolManager;
    }

    public final boolean z0(Context context, long j) {
        p31.f(context, "context");
        s22 s22Var = (s22) this.m.f();
        if (s22Var == null) {
            s22Var = new s22(null, null, null, null, false, null, null, null, null, null, false, null, null, false, 16383, null);
        }
        Long lC = s22Var.c();
        if (lC == null) {
            return true;
        }
        long jLongValue = lC.longValue();
        cb0 cb0Var = cb0.a;
        long jB = cb0Var.b(jLongValue);
        if (j <= jB) {
            return true;
        }
        String string = context.getString(R.string.picture_exceeds_remaining_space, cb0Var.a(jB), cb0Var.a(j));
        p31.e(string, "getString(...)");
        u0(string);
        return false;
    }
}
