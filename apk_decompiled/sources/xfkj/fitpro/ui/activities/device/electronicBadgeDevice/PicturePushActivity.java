package xfkj.fitpro.ui.activities.device.electronicBadgeDevice;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import androidx.activity.result.ActivityResult;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baji.protocol.BajiProtocolManager;
import com.baji.protocol.event.FileTransferCompleteEvent;
import com.baji.protocol.event.FileTransferErrorEvent;
import com.baji.protocol.event.FileTransferProgressEvent;
import com.baji.protocol.event.FileTransferStatusEvent;
import com.baji.protocol.model.TransferProgress;
import com.baji.protocol.model.TransferStatus;
import com.baji.protocol.model.TransferStatusInfo;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.jieli.jl_rcsp.constant.WatchConstant;
import com.legend.smartwatch.app.base.acitivity.BaseMvvmActivity;
import com.legend.smartwatch.electronicbadge.android.R;
import com.luck.picture.lib.entity.LocalMedia;
import defpackage.a4;
import defpackage.ar0;
import defpackage.aw2;
import defpackage.cb0;
import defpackage.e4;
import defpackage.f4;
import defpackage.g02;
import defpackage.k5;
import defpackage.k83;
import defpackage.kr0;
import defpackage.of2;
import defpackage.p31;
import defpackage.py;
import defpackage.r22;
import defpackage.s22;
import defpackage.sg3;
import defpackage.t3;
import defpackage.v22;
import defpackage.vt1;
import defpackage.xr0;
import defpackage.xv2;
import defpackage.y70;
import defpackage.y93;
import defpackage.yv2;
import defpackage.zl;
import java.io.File;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import xfkj.fitpro.model.sever.body.ClockDialInfoBody;
import xfkj.fitpro.ui.activities.device.electronicBadgeDevice.PicturePushActivity;
import xfkj.fitpro.ui.activities.device.electronicBadgeDevice.viewmodel.PicturePushViewModel;

/* JADX INFO: loaded from: classes4.dex */
public final class PicturePushActivity extends BaseMvvmActivity<t3, PicturePushViewModel> {
    public static final a s = new a(null);
    private f4 m;
    private f4 n;
    private File o;
    private yv2 p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private y93 f398q;
    private File r;

    public static final class a {
        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        private a() {
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[TransferStatus.values().length];
            try {
                iArr[TransferStatus.COMPLETED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TransferStatus.FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    public static final class c implements k5.a {
        c() {
        }

        @Override // k5.a
        public void a(aw2 aw2Var) {
            p31.f(aw2Var, "styleItem");
            Log.d(PicturePushActivity.this.K(), "收到样式点击事件: " + aw2Var.e() + ", 类型: " + aw2Var.h() + ", 选中: " + aw2Var.k());
            PicturePushActivity.n0(PicturePushActivity.this).Z(new r22.e(aw2Var));
        }
    }

    public static final class d implements PermissionUtils.b {
        d() {
        }

        @Override // com.blankj.utilcode.util.PermissionUtils.b
        public void onDenied() {
            ToastUtils.v(PicturePushActivity.this.getString(R.string.permission_refuse_tips), new Object[0]);
        }

        @Override // com.blankj.utilcode.util.PermissionUtils.b
        public void onGranted() {
            PicturePushActivity.this.X0();
        }
    }

    static final class e implements vt1, xr0 {
        private final /* synthetic */ ar0 a;

        e(ar0 ar0Var) {
            p31.f(ar0Var, "function");
            this.a = ar0Var;
        }

        @Override // defpackage.xr0
        public final kr0 a() {
            return this.a;
        }

        @Override // defpackage.vt1
        public final /* synthetic */ void b(Object obj) {
            this.a.invoke(obj);
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof vt1) && (obj instanceof xr0)) {
                return p31.a(a(), ((xr0) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }
    }

    public static final class f implements ViewTreeObserver.OnGlobalLayoutListener {
        final /* synthetic */ ImageView a;
        final /* synthetic */ PicturePushActivity b;

        f(ImageView imageView, PicturePushActivity picturePushActivity) {
            this.a = imageView;
            this.b = picturePushActivity;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (this.a.getWidth() <= 0 || this.a.getHeight() <= 0) {
                return;
            }
            this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            this.b.M0();
        }
    }

    public static final class g extends ViewOutlineProvider {
        g() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            p31.f(view, "view");
            p31.f(outline, "outline");
            outline.setRect(0, 0, view.getWidth(), view.getHeight());
        }
    }

    public static final class h extends ViewOutlineProvider {
        h() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            p31.f(view, "view");
            p31.f(outline, "outline");
            int iMin = Math.min(view.getWidth(), view.getHeight());
            int width = (view.getWidth() - iMin) / 2;
            int height = (view.getHeight() - iMin) / 2;
            outline.setOval(width, height, width + iMin, iMin + height);
        }
    }

    public PicturePushActivity() {
        super(R.layout.activity_picture_push);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A0(PicturePushActivity picturePushActivity, View view) {
        ((PicturePushViewModel) picturePushActivity.Y()).Z(r22.j.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B0(PicturePushActivity picturePushActivity, View view) {
        ((PicturePushViewModel) picturePushActivity.Y()).Z(r22.d.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C0(PicturePushActivity picturePushActivity, View view) {
        s22 s22Var = (s22) ((PicturePushViewModel) picturePushActivity.Y()).X().f();
        if (s22Var == null || !s22Var.m()) {
            ((PicturePushViewModel) picturePushActivity.Y()).Z(r22.l.a);
        } else {
            ToastUtils.v(picturePushActivity.getString(R.string.picture_crop_size_prompt), new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D0(PicturePushActivity picturePushActivity, View view) {
        ((PicturePushViewModel) picturePushActivity.Y()).s0();
    }

    private final void E0() {
        this.m = registerForActivityResult(new e4(), new a4() { // from class: n22
            @Override // defpackage.a4
            public final void a(Object obj) {
                PicturePushActivity.F0(this.a, (ActivityResult) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F0(PicturePushActivity picturePushActivity, ActivityResult activityResult) {
        p31.f(activityResult, "result");
        if (activityResult.b() != -1) {
            Log.d(picturePushActivity.K(), "用户取消了系统相册选择");
            return;
        }
        Intent intentA = activityResult.a();
        if (intentA == null) {
            Log.w(picturePushActivity.K(), "系统相册选择返回的数据为空");
            ToastUtils.v(picturePushActivity.getString(R.string.image_get_failed), new Object[0]);
            return;
        }
        Uri data = intentA.getData();
        if (data == null) {
            Log.w(picturePushActivity.K(), "系统相册选择返回的 URI 为空");
            ToastUtils.v(picturePushActivity.getString(R.string.image_get_failed), new Object[0]);
            return;
        }
        Log.d(picturePushActivity.K(), "系统相册选择返回 URI: " + data);
        ((PicturePushViewModel) picturePushActivity.Y()).e0(picturePushActivity, data);
    }

    private final void G0() {
        this.n = registerForActivityResult(new e4(), new a4() { // from class: o22
            @Override // defpackage.a4
            public final void a(Object obj) {
                PicturePushActivity.H0(this.a, (ActivityResult) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H0(PicturePushActivity picturePushActivity, ActivityResult activityResult) {
        p31.f(activityResult, "result");
        if (activityResult.b() != -1) {
            Log.d(picturePushActivity.K(), "用户取消了系统相机拍照");
            File file = picturePushActivity.o;
            if (file != null && file.exists()) {
                file.delete();
            }
            picturePushActivity.o = null;
            return;
        }
        File file2 = picturePushActivity.o;
        if (file2 != null) {
            Log.d(picturePushActivity.K(), "系统相机拍照成功，文件: " + file2.getAbsolutePath());
            ((PicturePushViewModel) picturePushActivity.Y()).f0(picturePushActivity, file2);
        } else {
            Log.w(picturePushActivity.K(), "系统相机拍照成功，但照片文件为空");
            ToastUtils.v(picturePushActivity.getString(R.string.image_get_failed), new Object[0]);
        }
        picturePushActivity.o = null;
    }

    private final void I0() {
        ((PicturePushViewModel) Y()).T().i(this, new e(new ar0() { // from class: m22
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return PicturePushActivity.J0(this.a, (r22) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 J0(PicturePushActivity picturePushActivity, r22 r22Var) {
        if (r22Var != null) {
            picturePushActivity.u0(r22Var);
            ((PicturePushViewModel) picturePushActivity.Y()).G();
        }
        return k83.a;
    }

    private final void K0() {
        ((PicturePushViewModel) Y()).X().i(this, new e(new ar0() { // from class: p22
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return PicturePushActivity.L0(this.a, (s22) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 L0(PicturePushActivity picturePushActivity, s22 s22Var) {
        if (s22Var != null) {
            picturePushActivity.d1(s22Var);
            picturePushActivity.e1(s22Var);
            picturePushActivity.b1(s22Var);
            picturePushActivity.W0(s22Var);
            picturePushActivity.a1(s22Var);
            picturePushActivity.c1(s22Var);
            if ((s22Var.e() != null || s22Var.f() != null) && s22Var.h() == null) {
                picturePushActivity.S0();
            }
        }
        return k83.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M0() {
        s22 s22Var = (s22) ((PicturePushViewModel) Y()).X().f();
        if (s22Var == null) {
            return;
        }
        if (s22Var.e() == null && s22Var.f() == null) {
            ((PicturePushViewModel) Y()).H();
            return;
        }
        File fileN0 = N0();
        if (fileN0 == null) {
            Log.w(K(), "刷新待上传文件大小失败：合成图片未生成");
            return;
        }
        PicturePushViewModel picturePushViewModel = (PicturePushViewModel) Y();
        String absolutePath = fileN0.getAbsolutePath();
        p31.e(absolutePath, "getAbsolutePath(...)");
        picturePushViewModel.r0(this, absolutePath);
    }

    private final File N0() {
        Bitmap bitmapR0 = r0();
        if (bitmapR0 == null) {
            return null;
        }
        return R0(bitmapR0);
    }

    private final void O0() {
        S0();
    }

    private final void P0() {
        g02.n(null, new DialogInterface.OnClickListener() { // from class: h22
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                PicturePushActivity.Q0(this.a, dialogInterface, i);
            }
        }, getString(R.string.take_picture), getString(R.string.camera_permission));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q0(PicturePushActivity picturePushActivity, DialogInterface dialogInterface, int i) {
        PermissionUtils.y("android.permission.CAMERA").m(picturePushActivity.new d()).z();
    }

    private final File R0(Bitmap bitmap) {
        try {
            File file = this.r;
            if (file != null) {
                if (!file.exists()) {
                    file = null;
                }
                if (file != null) {
                    file.delete();
                }
            }
            File file2 = new File(getExternalFilesDir(null), "composite_upload_" + System.currentTimeMillis() + ".jpg");
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            this.r = file2;
            Log.d(K(), "合成上传文件已保存: " + file2.getAbsolutePath() + ", 大小: " + file2.length() + " bytes");
            return file2;
        } catch (Exception e2) {
            Log.e(K(), "保存合成图片失败", e2);
            ToastUtils.v(getString(R.string.image_save_failed), new Object[0]);
            return null;
        }
    }

    private final void S0() {
        final ImageView imageView = ((t3) I()).J;
        p31.e(imageView, "ivPreviewPicture");
        imageView.post(new Runnable() { // from class: g22
            @Override // java.lang.Runnable
            public final void run() {
                PicturePushActivity.T0(imageView, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T0(ImageView imageView, PicturePushActivity picturePushActivity) {
        if (imageView.getWidth() <= 0 || imageView.getHeight() <= 0) {
            imageView.getViewTreeObserver().addOnGlobalLayoutListener(new f(imageView, picturePushActivity));
        } else {
            picturePushActivity.M0();
        }
    }

    private final void U0() {
        ClockDialInfoBody clockDialInfoBodyA = py.a.a();
        int screenType = clockDialInfoBodyA != null ? clockDialInfoBodyA.getScreenType() : 1;
        final boolean z = screenType == 0;
        boolean z2 = screenType == 1;
        Log.d(K(), "设置预览形状 - screenType: " + screenType + ", 方屏: " + z + ", 圆屏: " + z2);
        ((t3) I()).Q.post(new Runnable() { // from class: q22
            @Override // java.lang.Runnable
            public final void run() {
                PicturePushActivity.V0(z, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V0(boolean z, PicturePushActivity picturePushActivity) {
        ((t3) picturePushActivity.I()).Q.setBackgroundResource(z ? R.drawable.bg_preview_square : R.drawable.bg_preview_circle);
        ViewOutlineProvider gVar = z ? new g() : new h();
        ImageView imageView = ((t3) picturePushActivity.I()).J;
        imageView.setOutlineProvider(gVar);
        imageView.setClipToOutline(true);
        ImageView imageView2 = ((t3) picturePushActivity.I()).L;
        imageView2.setOutlineProvider(gVar);
        imageView2.setClipToOutline(true);
        ImageView imageView3 = ((t3) picturePushActivity.I()).G;
        imageView3.setOutlineProvider(gVar);
        imageView3.setClipToOutline(true);
        Log.d(picturePushActivity.K(), "预览形状设置完成 - " + (z ? "方形" : "圆形"));
    }

    private final void W0(s22 s22Var) {
        String strD = s22Var.d();
        if (strD != null) {
            ToastUtils.v(strD, new Object[0]);
            ((PicturePushViewModel) Y()).Z(r22.a.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X0() {
        Pair pairM = ((PicturePushViewModel) Y()).M(this);
        if (pairM != null) {
            Intent intent = (Intent) pairM.component1();
            this.o = (File) pairM.component2();
            try {
                f4 f4Var = this.n;
                if (f4Var == null) {
                    p31.t("systemCameraLauncher");
                    f4Var = null;
                }
                f4Var.a(intent);
            } catch (Exception e2) {
                Log.e(K(), "启动系统相机失败", e2);
                ToastUtils.v("无法打开相机，请检查权限设置", new Object[0]);
                this.o = null;
            }
        }
    }

    private final void Y0() {
        Intent intentL = ((PicturePushViewModel) Y()).L();
        if (intentL != null) {
            try {
                f4 f4Var = this.m;
                if (f4Var == null) {
                    p31.t("systemAlbumLauncher");
                    f4Var = null;
                }
                f4Var.a(intentL);
            } catch (Exception e2) {
                Log.e(K(), "启动系统相册失败", e2);
                ToastUtils.v(getString(R.string.cannot_open_album), new Object[0]);
            }
        }
    }

    private final void a1(s22 s22Var) {
        String string;
        if (s22Var.o()) {
            string = getString(R.string.device_remaining_space_loading);
        } else if (s22Var.c() != null) {
            cb0 cb0Var = cb0.a;
            string = getString(R.string.device_remaining_space, cb0Var.a(cb0Var.b(s22Var.c().longValue())));
        } else {
            string = getString(R.string.device_remaining_space_unknown);
        }
        p31.c(string);
        ((t3) I()).M.setText(string);
        ((t3) I()).O.setEnabled(!s22Var.o());
    }

    private final void b1(s22 s22Var) {
        ((t3) I()).N.setRefreshing(s22Var.n());
        ((t3) I()).F.setEnabled(!s22Var.n() && (s22Var.e() != null || s22Var.f() != null));
    }

    private final void c1(s22 s22Var) {
        Long lH = s22Var.h();
        if (lH == null) {
            ((t3) I()).P.setVisibility(8);
            return;
        }
        ((t3) I()).P.setVisibility(0);
        ((t3) I()).P.setText(getString(R.string.picture_selected_size, cb0.a.a(lH.longValue())));
        ((t3) I()).P.setTextColor(s22Var.m() ? getColor(R.color.red) : getColor(R.color.black));
    }

    private final void d1(s22 s22Var) {
        String strK = K();
        aw2 aw2VarG = s22Var.g();
        String strE = aw2VarG != null ? aw2VarG.e() : null;
        aw2 aw2VarI = s22Var.i();
        Log.d(strK, "更新预览图片 - 边框: " + strE + ", 贴纸: " + (aw2VarI != null ? aw2VarI.e() : null));
        Bitmap bitmapE = s22Var.e();
        if (bitmapE != null) {
            ((t3) I()).J.setImageBitmap(bitmapE);
        } else {
            Uri uriF = s22Var.f();
            if (uriF != null) {
                ((t3) I()).J.setImageURI(uriF);
            }
        }
        aw2 aw2VarI2 = s22Var.i();
        if (aw2VarI2 != null) {
            Log.d(K(), "显示贴纸: " + aw2VarI2.e());
            ImageView imageView = ((t3) I()).L;
            p31.e(imageView, "ivStickerOverlay");
            f1(imageView, aw2VarI2);
        } else {
            Log.d(K(), "隐藏贴纸覆盖层");
            ((t3) I()).L.setVisibility(8);
        }
        aw2 aw2VarG2 = s22Var.g();
        if (aw2VarG2 == null) {
            Log.d(K(), "隐藏边框覆盖层");
            ((t3) I()).G.setVisibility(8);
            return;
        }
        Log.d(K(), "显示边框: " + aw2VarG2.e());
        ImageView imageView2 = ((t3) I()).G;
        p31.e(imageView2, "ivBorderOverlay");
        f1(imageView2, aw2VarG2);
    }

    private final void e1(s22 s22Var) {
        yv2 yv2Var = this.p;
        if (yv2Var != null) {
            yv2Var.d().clear();
            Iterator it = s22Var.k().iterator();
            while (it.hasNext()) {
                yv2Var.d().add((xv2) it.next());
            }
            yv2Var.notifyDataSetChanged();
        }
    }

    private final void f1(ImageView imageView, aw2 aw2Var) {
        Log.d(K(), "更新样式覆盖层: " + aw2Var.e() + ", URL: " + aw2Var.d() + ", 本地资源: " + aw2Var.j());
        imageView.setVisibility(0);
        if (!aw2Var.j()) {
            Log.d(K(), "加载网络图片: " + aw2Var.d());
            p31.c(((com.bumptech.glide.e) ((com.bumptech.glide.e) com.bumptech.glide.a.v(this).r(aw2Var.d()).U(R.mipmap.eqt_watch)).h(R.mipmap.eqt_watch)).a(of2.j0()).u0(imageView));
            return;
        }
        Integer numF = aw2Var.f();
        if (numF == null) {
            Log.w(K(), "本地资源ID为null");
            return;
        }
        Log.d(K(), "设置本地资源: " + numF);
        imageView.setImageResource(numF.intValue());
    }

    public static final /* synthetic */ PicturePushViewModel n0(PicturePushActivity picturePushActivity) {
        return (PicturePushViewModel) picturePushActivity.Y();
    }

    private final Bitmap r0() {
        try {
            ImageView imageView = ((t3) I()).J;
            p31.e(imageView, "ivPreviewPicture");
            int width = imageView.getWidth();
            int height = imageView.getHeight();
            if (width <= 0 || height <= 0) {
                s22 s22Var = (s22) ((PicturePushViewModel) Y()).X().f();
                Bitmap bitmapE = s22Var != null ? s22Var.e() : null;
                if (bitmapE == null || bitmapE.getWidth() <= 0 || bitmapE.getHeight() <= 0) {
                    Log.w(K(), "预览图区域尺寸无效: " + width + "x" + height);
                    return null;
                }
                Log.d(K(), "预览 View 未布局，使用 Bitmap 尺寸合成: " + bitmapE.getWidth() + "x" + bitmapE.getHeight());
                width = bitmapE.getWidth();
                height = bitmapE.getHeight();
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            Bitmap bitmapT0 = t0();
            if (bitmapT0 != null) {
                canvas.drawBitmap(bitmapT0, (Rect) null, new Rect(0, 0, width, height), new Paint());
            }
            s22 s22Var2 = (s22) ((PicturePushViewModel) Y()).X().f();
            aw2 aw2VarI = s22Var2 != null ? s22Var2.i() : null;
            if (aw2VarI != null) {
                s0(canvas, aw2VarI, width, height);
            }
            s22 s22Var3 = (s22) ((PicturePushViewModel) Y()).X().f();
            aw2 aw2VarG = s22Var3 != null ? s22Var3.g() : null;
            if (aw2VarG != null) {
                s0(canvas, aw2VarG, width, height);
            }
            Log.d(K(), "预览图合成完成: " + width + "x" + height);
            return bitmapCreateBitmap;
        } catch (Exception e2) {
            Log.e(K(), "合成预览图失败", e2);
            return null;
        }
    }

    private final void s0(Canvas canvas, aw2 aw2Var, int i, int i2) {
        try {
            if (aw2Var.j()) {
                Integer numF = aw2Var.f();
                if (numF != null) {
                    Drawable drawable = getResources().getDrawable(numF.intValue(), null);
                    drawable.setBounds(0, 0, i, i2);
                    drawable.draw(canvas);
                }
            } else {
                Log.w(K(), "网络图片样式暂不支持在合成中绘制");
            }
        } catch (Exception e2) {
            Log.e(K(), "绘制样式覆盖层失败: " + aw2Var.e(), e2);
        }
    }

    private final Bitmap t0() {
        s22 s22Var = (s22) ((PicturePushViewModel) Y()).X().f();
        Bitmap bitmapCreateBitmap = null;
        if (s22Var == null) {
            return null;
        }
        Bitmap bitmapE = s22Var.e();
        if (bitmapE != null) {
            return bitmapE;
        }
        Drawable drawable = ((t3) I()).J.getDrawable();
        if (drawable != null) {
            bitmapCreateBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            p31.e(bitmapCreateBitmap, "createBitmap(...)");
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
        }
        return bitmapCreateBitmap;
    }

    private final void u0(r22 r22Var) {
        if (r22Var instanceof r22.j) {
            Z0();
            return;
        }
        if (r22Var instanceof r22.d) {
            Y0();
            return;
        }
        if (r22Var instanceof r22.l) {
            x0();
            return;
        }
        if (r22Var instanceof r22.c) {
            O0();
            return;
        }
        if (r22Var instanceof r22.e) {
            s22 s22Var = (s22) ((PicturePushViewModel) Y()).X().f();
            if (s22Var != null) {
                d1(s22Var);
                return;
            }
            return;
        }
        if (r22Var instanceof r22.b) {
            return;
        }
        if (r22Var instanceof r22.f) {
            ToastUtils.v(((r22.f) r22Var).a(), new Object[0]);
            return;
        }
        if (r22Var instanceof r22.a) {
            return;
        }
        y93 y93Var = null;
        if (r22Var instanceof r22.h) {
            y93 y93Var2 = this.f398q;
            if (y93Var2 == null) {
                p31.t("uploadProgressUi");
            } else {
                y93Var = y93Var2;
            }
            r22.h hVar = (r22.h) r22Var;
            y93Var.g(hVar.a(), hVar.b());
            return;
        }
        if (r22Var instanceof r22.k) {
            y93 y93Var3 = this.f398q;
            if (y93Var3 == null) {
                p31.t("uploadProgressUi");
            } else {
                y93Var = y93Var3;
            }
            r22.k kVar = (r22.k) r22Var;
            y93Var.j(kVar.b(), kVar.a());
            return;
        }
        if (r22Var instanceof r22.i) {
            y93 y93Var4 = this.f398q;
            if (y93Var4 == null) {
                p31.t("uploadProgressUi");
            } else {
                y93Var = y93Var4;
            }
            y93Var.i();
            return;
        }
        if (!(r22Var instanceof r22.g)) {
            throw new NoWhenBranchMatchedException();
        }
        y93 y93Var5 = this.f398q;
        if (y93Var5 == null) {
            p31.t("uploadProgressUi");
        } else {
            y93Var = y93Var5;
        }
        y93Var.h(((r22.g) r22Var).a());
    }

    private final void v0(LocalMedia localMedia) {
        try {
            Log.d(K(), "PictureSelector 返回结果: " + localMedia.q());
            String strI = localMedia.i();
            if (strI == null && (strI = localMedia.c()) == null) {
                strI = localMedia.q();
            }
            if (strI != null && strI.length() != 0) {
                Log.d(K(), "使用图片路径: " + strI);
                PicturePushViewModel.c0((PicturePushViewModel) Y(), strI, null, 2, null);
                return;
            }
            Log.w(K(), "图片路径为空");
            ToastUtils.v(getString(R.string.image_get_failed), new Object[0]);
        } catch (Exception e2) {
            Log.e(K(), "处理 PictureSelector 结果失败", e2);
            ToastUtils.v(getString(R.string.image_process_failed), new Object[0]);
        }
    }

    private final void w0(Intent intent) {
        try {
            if (intent == null) {
                Log.e(K(), "UCrop 返回数据为空");
                ToastUtils.v(getString(R.string.image_crop_failed), new Object[0]);
                return;
            }
            Uri uriD = com.yalantis.ucrop.b.d(intent);
            if (uriD == null) {
                Log.e(K(), "UCrop 返回结果为空");
                ToastUtils.v(getString(R.string.image_crop_failed), new Object[0]);
                return;
            }
            String path = uriD.getPath();
            Log.d(K(), "UCrop 裁剪完成: " + path);
            if (path != null && new File(path).exists()) {
                ((PicturePushViewModel) Y()).g0(this, path);
                return;
            }
            Log.e(K(), "裁剪后的图片文件不存在: " + path);
            ToastUtils.v(getString(R.string.image_crop_failed), new Object[0]);
        } catch (Exception e2) {
            Log.e(K(), "处理 UCrop 结果失败", e2);
            ToastUtils.v(getString(R.string.image_process_failed), new Object[0]);
        }
    }

    private final void x0() {
        s22 s22Var = (s22) ((PicturePushViewModel) Y()).X().f();
        if (s22Var == null) {
            return;
        }
        if (s22Var.e() == null && s22Var.f() == null) {
            ToastUtils.v(getString(R.string.please_select_image_first), new Object[0]);
        } else if (s22Var.m()) {
            ToastUtils.v(getString(R.string.picture_crop_size_prompt), new Object[0]);
        } else {
            ((t3) I()).J.post(new Runnable() { // from class: f22
                @Override // java.lang.Runnable
                public final void run() {
                    PicturePushActivity.y0(this.a);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y0(PicturePushActivity picturePushActivity) {
        File fileN0 = picturePushActivity.N0();
        if (fileN0 == null) {
            return;
        }
        PicturePushViewModel picturePushViewModel = (PicturePushViewModel) picturePushActivity.Y();
        String absolutePath = fileN0.getAbsolutePath();
        p31.e(absolutePath, "getAbsolutePath(...)");
        picturePushViewModel.o0(picturePushActivity, absolutePath);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z0(PicturePushActivity picturePushActivity, View view) {
        picturePushActivity.finish();
    }

    public final void Z0() {
        if (PermissionUtils.t("android.permission.CAMERA")) {
            X0();
        } else {
            P0();
        }
    }

    @Override // com.legend.smartwatch.app.base.acitivity.BaseActivity
    public void initData(Bundle bundle) {
        E0();
        G0();
        this.f398q = new y93(this);
        this.p = new yv2(new ArrayList());
        ((t3) I()).z.setLayoutManager(new LinearLayoutManager(this, 1, false));
        ((t3) I()).z.setAdapter(this.p);
        yv2 yv2Var = this.p;
        if (yv2Var != null) {
            yv2Var.h(new c());
        }
        BajiProtocolManager bajiProtocolManagerI = zl.a.i();
        if (bajiProtocolManagerI != null) {
            ((PicturePushViewModel) Y()).t0(bajiProtocolManagerI);
            Log.d(K(), "蓝牙协议管理器设置成功");
        } else {
            Log.w(K(), "蓝牙协议管理器未初始化");
            ToastUtils.v(getString(R.string.bluetooth_not_initialized), new Object[0]);
        }
        K0();
        I0();
        U0();
        ((PicturePushViewModel) Y()).s0();
    }

    @Override // com.legend.smartwatch.app.base.acitivity.BaseActivity
    public void initListener() {
        ((t3) I()).I.setOnClickListener(new View.OnClickListener() { // from class: e22
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PicturePushActivity.z0(this.a, view);
            }
        });
        ((t3) I()).H.setOnClickListener(new View.OnClickListener() { // from class: i22
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PicturePushActivity.A0(this.a, view);
            }
        });
        ((t3) I()).K.setOnClickListener(new View.OnClickListener() { // from class: j22
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PicturePushActivity.B0(this.a, view);
            }
        });
        ((t3) I()).F.setOnClickListener(new View.OnClickListener() { // from class: k22
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PicturePushActivity.C0(this.a, view);
            }
        });
        ((t3) I()).O.setOnClickListener(new View.OnClickListener() { // from class: l22
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PicturePushActivity.D0(this.a, view);
            }
        });
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            if (i2 != 96) {
                return;
            }
            Serializable serializableExtra = intent != null ? intent.getSerializableExtra("com.yalantis.ucrop.Error") : null;
            Log.e(K(), "UCrop 裁剪失败", serializableExtra instanceof Throwable ? (Throwable) serializableExtra : null);
            ToastUtils.v(getString(R.string.image_crop_failed), new Object[0]);
            return;
        }
        if (i == 69) {
            w0(intent);
            return;
        }
        if (i != 188) {
            return;
        }
        List listE = v22.e(intent);
        p31.c(listE);
        if (listE.isEmpty()) {
            return;
        }
        LocalMedia localMedia = (LocalMedia) listE.get(0);
        p31.c(localMedia);
        v0(localMedia);
    }

    @Override // com.legend.smartwatch.app.base.acitivity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        y93 y93Var = this.f398q;
        if (y93Var == null) {
            p31.t("uploadProgressUi");
            y93Var = null;
        }
        y93Var.d();
        super.onDestroy();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onFileTransferComplete(FileTransferCompleteEvent fileTransferCompleteEvent) {
        p31.f(fileTransferCompleteEvent, "event");
        if (((PicturePushViewModel) Y()).j0()) {
            return;
        }
        Log.d(K(), "文件传输完成: " + fileTransferCompleteEvent.getFileInfo().getFileName());
        s22 s22Var = (s22) ((PicturePushViewModel) Y()).X().f();
        if (s22Var != null) {
            ((PicturePushViewModel) Y()).X().o(s22Var.a((16335 & 1) != 0 ? s22Var.a : null, (16335 & 2) != 0 ? s22Var.b : null, (16335 & 4) != 0 ? s22Var.c : null, (16335 & 8) != 0 ? s22Var.d : null, (16335 & 16) != 0 ? s22Var.e : false, (16335 & 32) != 0 ? s22Var.f : null, (16335 & 64) != 0 ? s22Var.g : null, (16335 & 128) != 0 ? s22Var.h : null, (16335 & 256) != 0 ? s22Var.i : null, (16335 & 512) != 0 ? s22Var.j : null, (16335 & 1024) != 0 ? s22Var.k : false, (16335 & 2048) != 0 ? s22Var.l : null, (16335 & 4096) != 0 ? s22Var.m : null, (16335 & 8192) != 0 ? s22Var.n : false));
        }
        y93 y93Var = this.f398q;
        if (y93Var == null) {
            p31.t("uploadProgressUi");
            y93Var = null;
        }
        y93Var.i();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onFileTransferError(FileTransferErrorEvent fileTransferErrorEvent) {
        p31.f(fileTransferErrorEvent, "event");
        if (((PicturePushViewModel) Y()).j0()) {
            return;
        }
        Log.e(K(), "文件传输错误: " + fileTransferErrorEvent.getErrorCode() + ", 消息: " + fileTransferErrorEvent.getErrorMessage());
        s22 s22Var = (s22) ((PicturePushViewModel) Y()).X().f();
        if (s22Var != null) {
            ((PicturePushViewModel) Y()).X().o(s22Var.a((16335 & 1) != 0 ? s22Var.a : null, (16335 & 2) != 0 ? s22Var.b : null, (16335 & 4) != 0 ? s22Var.c : null, (16335 & 8) != 0 ? s22Var.d : null, (16335 & 16) != 0 ? s22Var.e : false, (16335 & 32) != 0 ? s22Var.f : null, (16335 & 64) != 0 ? s22Var.g : null, (16335 & 128) != 0 ? s22Var.h : null, (16335 & 256) != 0 ? s22Var.i : null, (16335 & 512) != 0 ? s22Var.j : null, (16335 & 1024) != 0 ? s22Var.k : false, (16335 & 2048) != 0 ? s22Var.l : null, (16335 & 4096) != 0 ? s22Var.m : null, (16335 & 8192) != 0 ? s22Var.n : false));
        }
        y93 y93Var = this.f398q;
        if (y93Var == null) {
            p31.t("uploadProgressUi");
            y93Var = null;
        }
        y93Var.h(fileTransferErrorEvent.getErrorMessage());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onFileTransferProgress(FileTransferProgressEvent fileTransferProgressEvent) {
        p31.f(fileTransferProgressEvent, "event");
        if (((PicturePushViewModel) Y()).j0()) {
            return;
        }
        TransferProgress progress = fileTransferProgressEvent.getProgress();
        Log.d(K(), "文件传输进度: " + progress.getProgressPercent() + "%, 已传输: " + progress.getTransferredBytes() + WatchConstant.FAT_FS_ROOT + progress.getTotalBytes());
        y93 y93Var = this.f398q;
        if (y93Var == null) {
            p31.t("uploadProgressUi");
            y93Var = null;
        }
        y93Var.j(progress.getProgressPercent(), getString(R.string.transfer_progress, Integer.valueOf(progress.getProgressPercent())));
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onFileTransferStatus(FileTransferStatusEvent fileTransferStatusEvent) {
        p31.f(fileTransferStatusEvent, "event");
        if (((PicturePushViewModel) Y()).j0()) {
            return;
        }
        TransferStatusInfo statusInfo = fileTransferStatusEvent.getStatusInfo();
        Log.d(K(), "文件传输状态: " + statusInfo.getStatus() + ", 文件ID: " + statusInfo.getFileId());
        int i = b.a[statusInfo.getStatus().ordinal()];
        y93 y93Var = null;
        if (i == 1) {
            s22 s22Var = (s22) ((PicturePushViewModel) Y()).X().f();
            if (s22Var != null) {
                ((PicturePushViewModel) Y()).X().o(s22Var.a((16335 & 1) != 0 ? s22Var.a : null, (16335 & 2) != 0 ? s22Var.b : null, (16335 & 4) != 0 ? s22Var.c : null, (16335 & 8) != 0 ? s22Var.d : null, (16335 & 16) != 0 ? s22Var.e : false, (16335 & 32) != 0 ? s22Var.f : null, (16335 & 64) != 0 ? s22Var.g : null, (16335 & 128) != 0 ? s22Var.h : null, (16335 & 256) != 0 ? s22Var.i : null, (16335 & 512) != 0 ? s22Var.j : null, (16335 & 1024) != 0 ? s22Var.k : false, (16335 & 2048) != 0 ? s22Var.l : null, (16335 & 4096) != 0 ? s22Var.m : null, (16335 & 8192) != 0 ? s22Var.n : false));
            }
            y93 y93Var2 = this.f398q;
            if (y93Var2 == null) {
                p31.t("uploadProgressUi");
            } else {
                y93Var = y93Var2;
            }
            y93Var.i();
            return;
        }
        if (i != 2) {
            Log.d(K(), "文件传输状态: " + statusInfo.getStatus());
            return;
        }
        s22 s22Var2 = (s22) ((PicturePushViewModel) Y()).X().f();
        if (s22Var2 != null) {
            ((PicturePushViewModel) Y()).X().o(s22Var2.a((16335 & 1) != 0 ? s22Var2.a : null, (16335 & 2) != 0 ? s22Var2.b : null, (16335 & 4) != 0 ? s22Var2.c : null, (16335 & 8) != 0 ? s22Var2.d : null, (16335 & 16) != 0 ? s22Var2.e : false, (16335 & 32) != 0 ? s22Var2.f : null, (16335 & 64) != 0 ? s22Var2.g : null, (16335 & 128) != 0 ? s22Var2.h : null, (16335 & 256) != 0 ? s22Var2.i : null, (16335 & 512) != 0 ? s22Var2.j : null, (16335 & 1024) != 0 ? s22Var2.k : false, (16335 & 2048) != 0 ? s22Var2.l : null, (16335 & 4096) != 0 ? s22Var2.m : null, (16335 & 8192) != 0 ? s22Var2.n : false));
        }
        y93 y93Var3 = this.f398q;
        if (y93Var3 == null) {
            p31.t("uploadProgressUi");
        } else {
            y93Var = y93Var3;
        }
        String string = getString(R.string.transfer_failed);
        p31.e(string, "getString(...)");
        y93Var.h(string);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onWatchRemainEvent(sg3 sg3Var) {
        p31.f(sg3Var, "event");
        ((PicturePushViewModel) Y()).i0(sg3Var);
    }
}
