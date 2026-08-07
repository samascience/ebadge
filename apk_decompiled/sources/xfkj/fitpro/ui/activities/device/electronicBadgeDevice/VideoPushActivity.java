package xfkj.fitpro.ui.activities.device.electronicBadgeDevice;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.VideoView;
import androidx.activity.result.ActivityResult;
import androidx.appcompat.widget.AppCompatButton;
import com.baji.protocol.BajiProtocolManager;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.legend.smartwatch.app.base.acitivity.BaseMvvmActivity;
import com.legend.smartwatch.electronicbadge.android.R;
import com.luck.picture.lib.entity.LocalMedia;
import defpackage.a4;
import defpackage.ar0;
import defpackage.cb0;
import defpackage.e4;
import defpackage.f4;
import defpackage.g02;
import defpackage.i02;
import defpackage.if2;
import defpackage.j03;
import defpackage.k83;
import defpackage.ke2;
import defpackage.kr0;
import defpackage.md3;
import defpackage.n4;
import defpackage.nd3;
import defpackage.of2;
import defpackage.p31;
import defpackage.py;
import defpackage.sg3;
import defpackage.v22;
import defpackage.vt1;
import defpackage.xr0;
import defpackage.y93;
import defpackage.zl;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.NoWhenBranchMatchedException;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import xfkj.fitpro.model.sever.body.ClockDialInfoBody;
import xfkj.fitpro.ui.activities.device.electronicBadgeDevice.VideoPushActivity;
import xfkj.fitpro.ui.activities.device.electronicBadgeDevice.viewmodel.VideoPushViewModel;

/* JADX INFO: loaded from: classes4.dex */
public final class VideoPushActivity extends BaseMvvmActivity<n4, VideoPushViewModel> {
    private final int m;
    private final int n;
    private final int o;
    private final int p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private y93 f403q;
    private final f4 r;
    private final f4 s;

    public static final class a implements if2 {
        a() {
        }

        @Override // defpackage.if2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean onResourceReady(Drawable drawable, Object obj, j03 j03Var, DataSource dataSource, boolean z) {
            p31.f(obj, "model");
            p31.f(j03Var, "target");
            p31.f(dataSource, "dataSource");
            Log.d(VideoPushActivity.this.K(), "GIF加载成功");
            return false;
        }

        @Override // defpackage.if2
        public boolean onLoadFailed(GlideException glideException, Object obj, j03 j03Var, boolean z) {
            p31.f(obj, "model");
            p31.f(j03Var, "target");
            Log.e(VideoPushActivity.this.K(), "GIF加载失败", glideException);
            VideoPushActivity.this.Z0();
            return true;
        }
    }

    public static final class b implements if2 {
        b() {
        }

        @Override // defpackage.if2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean onResourceReady(Drawable drawable, Object obj, j03 j03Var, DataSource dataSource, boolean z) {
            p31.f(obj, "model");
            p31.f(j03Var, "target");
            p31.f(dataSource, "dataSource");
            Log.d(VideoPushActivity.this.K(), "文件加载成功");
            return false;
        }

        @Override // defpackage.if2
        public boolean onLoadFailed(GlideException glideException, Object obj, j03 j03Var, boolean z) {
            p31.f(obj, "model");
            p31.f(j03Var, "target");
            Log.e(VideoPushActivity.this.K(), "文件加载失败: ", glideException);
            VideoPushActivity.this.Z0();
            return true;
        }
    }

    public static final class c implements PermissionUtils.b {
        c() {
        }

        @Override // com.blankj.utilcode.util.PermissionUtils.b
        public void onDenied() {
            ToastUtils.v(VideoPushActivity.this.getString(R.string.permission_refuse_tips), new Object[0]);
        }

        @Override // com.blankj.utilcode.util.PermissionUtils.b
        public void onGranted() {
            Log.d(VideoPushActivity.this.K(), "相机权限获取成功");
        }
    }

    public static final class d implements PermissionUtils.b {
        final /* synthetic */ int b;

        d(int i) {
            this.b = i;
        }

        @Override // com.blankj.utilcode.util.PermissionUtils.b
        public void onDenied() {
            Log.w(VideoPushActivity.this.K(), "媒体权限被拒绝");
            ToastUtils.v(VideoPushActivity.this.getString(R.string.media_permission_required), new Object[0]);
        }

        @Override // com.blankj.utilcode.util.PermissionUtils.b
        public void onGranted() {
            Log.d(VideoPushActivity.this.K(), "媒体权限获取成功");
            int i = this.b;
            if (i == 1) {
                VideoPushActivity.this.c1();
            } else if (i == 2) {
                VideoPushActivity.this.b1();
            }
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

    public static final class f extends ViewOutlineProvider {
        f() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            p31.f(view, "view");
            p31.f(outline, "outline");
            outline.setRect(0, 0, view.getWidth(), view.getHeight());
        }
    }

    public static final class g extends ViewOutlineProvider {
        g() {
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

    public VideoPushActivity() {
        super(R.layout.activity_video_push);
        this.m = 1003;
        this.n = 1002;
        this.o = 1004;
        this.p = 1005;
        f4 f4VarRegisterForActivityResult = registerForActivityResult(new e4(), new a4() { // from class: jd3
            @Override // defpackage.a4
            public final void a(Object obj) {
                VideoPushActivity.f1(this.a, (ActivityResult) obj);
            }
        });
        p31.e(f4VarRegisterForActivityResult, "registerForActivityResult(...)");
        this.r = f4VarRegisterForActivityResult;
        f4 f4VarRegisterForActivityResult2 = registerForActivityResult(new e4(), new a4() { // from class: kd3
            @Override // defpackage.a4
            public final void a(Object obj) {
                VideoPushActivity.e1(this.a, (ActivityResult) obj);
            }
        });
        p31.e(f4VarRegisterForActivityResult2, "registerForActivityResult(...)");
        this.s = f4VarRegisterForActivityResult2;
    }

    private final void A0(md3 md3Var) {
        if (md3Var instanceof md3.d) {
            ((VideoPushViewModel) Y()).W(md3.l.a);
            return;
        }
        if (md3Var instanceof md3.c) {
            ((VideoPushViewModel) Y()).W(md3.j.a);
            return;
        }
        if (md3Var instanceof md3.p) {
            ((VideoPushViewModel) Y()).r0(this);
            return;
        }
        if (md3Var instanceof md3.e) {
            md3.e eVar = (md3.e) md3Var;
            Log.d(K(), "收到SetPreviewUri事件: " + eVar.a());
            y0(eVar.a());
            return;
        }
        if (md3Var instanceof md3.f) {
            ToastUtils.v(((md3.f) md3Var).a(), new Object[0]);
            return;
        }
        if (md3Var instanceof md3.a) {
            return;
        }
        if (md3Var instanceof md3.o) {
            ToastUtils.v(getString(R.string.upload_success), new Object[0]);
            return;
        }
        if (md3Var instanceof md3.m) {
            ToastUtils.v(getString(R.string.upload_failed, ((md3.m) md3Var).a()), new Object[0]);
            return;
        }
        if (md3Var instanceof md3.b) {
            Q0(((md3.b) md3Var).a());
            return;
        }
        y93 y93Var = null;
        if (md3Var instanceof md3.n) {
            y93 y93Var2 = this.f403q;
            if (y93Var2 == null) {
                p31.t("uploadProgressUi");
            } else {
                y93Var = y93Var2;
            }
            md3.n nVar = (md3.n) md3Var;
            y93Var.j(nVar.b(), nVar.a());
            return;
        }
        if (md3Var instanceof md3.h) {
            y93 y93Var3 = this.f403q;
            if (y93Var3 == null) {
                p31.t("uploadProgressUi");
            } else {
                y93Var = y93Var3;
            }
            md3.h hVar = (md3.h) md3Var;
            y93Var.g(hVar.a(), hVar.b());
            return;
        }
        if (md3Var instanceof md3.i) {
            y93 y93Var4 = this.f403q;
            if (y93Var4 == null) {
                p31.t("uploadProgressUi");
            } else {
                y93Var = y93Var4;
            }
            y93Var.i();
            return;
        }
        if (md3Var instanceof md3.g) {
            y93 y93Var5 = this.f403q;
            if (y93Var5 == null) {
                p31.t("uploadProgressUi");
            } else {
                y93Var = y93Var5;
            }
            y93Var.h(((md3.g) md3Var).a());
            return;
        }
        if (!(md3Var instanceof md3.k)) {
            if (md3Var instanceof md3.j) {
                g1();
                return;
            } else {
                if (!(md3Var instanceof md3.l)) {
                    throw new NoWhenBranchMatchedException();
                }
                h1();
                return;
            }
        }
        ((VideoPushViewModel) Y()).J();
        Intent intent = new Intent(this, (Class<?>) VideoCutActivity.class);
        intent.putExtra("path", ((md3.k) md3Var).a());
        intent.putExtra("extra_max_capture_duration", ((VideoPushViewModel) Y()).U());
        intent.putExtra("extra_compression_level", ((VideoPushViewModel) Y()).R());
        Log.d(K(), "启动视频裁剪Activity，裁剪时长: " + ((VideoPushViewModel) Y()).U() + "秒，压缩级别: " + ((VideoPushViewModel) Y()).R());
        startActivityForResult(intent, this.m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B0(VideoPushActivity videoPushActivity, View view) {
        videoPushActivity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C0(VideoPushActivity videoPushActivity, View view) {
        videoPushActivity.i1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D0(VideoPushActivity videoPushActivity, View view) {
        videoPushActivity.b1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E0(VideoPushActivity videoPushActivity, View view) {
        nd3 nd3Var = (nd3) ((VideoPushViewModel) videoPushActivity.Y()).V().f();
        if (nd3Var == null || !nd3Var.o()) {
            ((VideoPushViewModel) videoPushActivity.Y()).W(new md3.p(videoPushActivity));
        } else {
            ToastUtils.v(videoPushActivity.getString(R.string.video_crop_size_prompt), new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F0(VideoPushActivity videoPushActivity, View view) {
        ((VideoPushViewModel) videoPushActivity.Y()).f0();
    }

    private final void G0() {
        ((VideoPushViewModel) Y()).S().i(this, new e(new ar0() { // from class: id3
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return VideoPushActivity.H0(this.a, (md3) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 H0(VideoPushActivity videoPushActivity, md3 md3Var) {
        if (md3Var != null) {
            Log.d(videoPushActivity.K(), "收到事件: " + ke2.b(md3Var.getClass()).a());
            videoPushActivity.A0(md3Var);
            ((VideoPushViewModel) videoPushActivity.Y()).I();
        }
        return k83.a;
    }

    private final void I0() {
        ((VideoPushViewModel) Y()).V().i(this, new e(new ar0() { // from class: uc3
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return VideoPushActivity.J0(this.a, (nd3) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 J0(VideoPushActivity videoPushActivity, nd3 nd3Var) {
        if (nd3Var != null) {
            videoPushActivity.l1(nd3Var);
            videoPushActivity.k1(nd3Var);
            videoPushActivity.a1(nd3Var);
            videoPushActivity.j1(nd3Var);
            videoPushActivity.m1(nd3Var);
        }
        return k83.a;
    }

    private final void K0(Uri uri) {
        try {
            Log.d(K(), "播放视频预览: " + uri);
            String string = uri.toString();
            p31.e(string, "toString(...)");
            String lowerCase = string.toLowerCase(Locale.ROOT);
            p31.e(lowerCase, "toLowerCase(...)");
            if (kotlin.text.i.u(lowerCase, ".avi", false, 2, null)) {
                Log.d(K(), "检测到AVI文件，直接转换为GIF预览（避免兼容性问题）");
                w0(uri);
                return;
            }
            ((n4) I()).M.setVisibility(8);
            ((n4) I()).L.setVisibility(0);
            final VideoView videoView = ((n4) I()).L;
            p31.e(videoView, "ivVideoPreview");
            videoView.setVideoURI(uri);
            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: yc3
                @Override // android.media.MediaPlayer.OnCompletionListener
                public final void onCompletion(MediaPlayer mediaPlayer) {
                    VideoPushActivity.L0(videoView, mediaPlayer);
                }
            });
            videoView.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: zc3
                @Override // android.media.MediaPlayer.OnErrorListener
                public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                    return VideoPushActivity.M0(this.a, mediaPlayer, i, i2);
                }
            });
            videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: ad3
                @Override // android.media.MediaPlayer.OnPreparedListener
                public final void onPrepared(MediaPlayer mediaPlayer) {
                    VideoPushActivity.N0(this.a, videoView, mediaPlayer);
                }
            });
            videoView.requestFocus();
        } catch (Exception e2) {
            Log.e(K(), "播放视频预览失败", e2);
            Z0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L0(VideoView videoView, MediaPlayer mediaPlayer) {
        videoView.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean M0(VideoPushActivity videoPushActivity, MediaPlayer mediaPlayer, int i, int i2) {
        Log.e(videoPushActivity.K(), "视频播放错误: what=" + i + ", extra=" + i2);
        videoPushActivity.Z0();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N0(VideoPushActivity videoPushActivity, VideoView videoView, MediaPlayer mediaPlayer) {
        Log.d(videoPushActivity.K(), "视频准备完成");
        videoView.start();
        Log.d(videoPushActivity.K(), "视频预览播放已启动");
    }

    private final void O0() {
        g02.n(null, new DialogInterface.OnClickListener() { // from class: bd3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                VideoPushActivity.P0(this.a, dialogInterface, i);
            }
        }, getString(R.string.take_picture), getString(R.string.camera_permission));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P0(VideoPushActivity videoPushActivity, DialogInterface dialogInterface, int i) {
        PermissionUtils.y("android.permission.CAMERA").m(videoPushActivity.new c()).z();
    }

    private final void Q0(String str) {
        int iHashCode = str.hashCode();
        if (iHashCode != -406040016) {
            if (iHashCode == 463403621) {
                if (str.equals("android.permission.CAMERA")) {
                    O0();
                    return;
                }
                return;
            } else if (iHashCode != 710297143 || !str.equals("android.permission.READ_MEDIA_VIDEO")) {
                return;
            }
        } else if (!str.equals("android.permission.READ_EXTERNAL_STORAGE")) {
            return;
        }
        R0(1);
    }

    private final void R0(final int i) {
        final String[] strArr;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 35) {
            strArr = new String[]{"android.permission.READ_MEDIA_IMAGES", "android.permission.READ_MEDIA_VIDEO", "android.permission.READ_MEDIA_AUDIO"};
        } else {
            strArr = i2 >= 33 ? new String[]{"android.permission.READ_MEDIA_IMAGES", "android.permission.READ_MEDIA_VIDEO"} : new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};
        }
        g02.n(null, new DialogInterface.OnClickListener() { // from class: cd3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                VideoPushActivity.S0(strArr, this, i, dialogInterface, i3);
            }
        }, getString(R.string.abulm), getString(R.string.album_permission_required_for_video));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S0(String[] strArr, VideoPushActivity videoPushActivity, int i, DialogInterface dialogInterface, int i2) {
        PermissionUtils.y((String[]) Arrays.copyOf(strArr, strArr.length)).m(videoPushActivity.new d(i)).z();
    }

    private final void T0() {
        ClockDialInfoBody clockDialInfoBodyA = py.a.a();
        int screenType = clockDialInfoBodyA != null ? clockDialInfoBodyA.getScreenType() : 1;
        final boolean z = screenType == 0;
        boolean z2 = screenType == 1;
        Log.d(K(), "设置预览形状 - screenType: " + screenType + ", 方屏: " + z + ", 圆屏: " + z2);
        ((n4) I()).O.post(new Runnable() { // from class: ld3
            @Override // java.lang.Runnable
            public final void run() {
                VideoPushActivity.U0(z, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U0(boolean z, VideoPushActivity videoPushActivity) {
        ((n4) videoPushActivity.I()).O.setBackgroundResource(z ? R.drawable.bg_preview_square : R.drawable.bg_preview_circle);
        ViewOutlineProvider fVar = z ? new f() : new g();
        VideoView videoView = ((n4) videoPushActivity.I()).L;
        videoView.setOutlineProvider(fVar);
        videoView.setClipToOutline(true);
        ImageView imageView = ((n4) videoPushActivity.I()).M;
        imageView.setOutlineProvider(fVar);
        imageView.setClipToOutline(true);
        Log.d(videoPushActivity.K(), "预览形状设置完成 - " + (z ? "方形" : "圆形"));
    }

    private final void V0() {
        ((VideoPushViewModel) Y()).i0(1);
        ((n4) I()).W.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: vc3
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                VideoPushActivity.W0(this.a, radioGroup, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W0(VideoPushActivity videoPushActivity, RadioGroup radioGroup, int i) {
        int i2 = 1;
        switch (i) {
            case R.id.rb_high_quality /* 2131297101 */:
                i2 = 3;
                break;
            case R.id.rb_medium_quality /* 2131297104 */:
                i2 = 2;
                break;
        }
        ((VideoPushViewModel) videoPushActivity.Y()).i0(i2);
        Log.d(videoPushActivity.K(), "视频压缩级别: " + i2);
    }

    private final void X0() {
        ((VideoPushViewModel) Y()).m0(5);
        ((n4) I()).X.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: wc3
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                VideoPushActivity.Y0(this.a, radioGroup, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y0(VideoPushActivity videoPushActivity, RadioGroup radioGroup, int i) {
        int i2 = 5;
        switch (i) {
            case R.id.rb_fifteen_seconds /* 2131297099 */:
                i2 = 15;
                break;
            case R.id.rb_ten_seconds /* 2131297106 */:
                i2 = 10;
                break;
        }
        ((VideoPushViewModel) videoPushActivity.Y()).m0(i2);
        Log.d(videoPushActivity.K(), "视频裁剪时长: " + i2 + "秒");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z0() {
        try {
            ((n4) I()).L.setVisibility(8);
            ((n4) I()).M.setVisibility(0);
        } catch (Exception e2) {
            Log.e(K(), "显示默认预览图标失败", e2);
        }
    }

    private final void a1(nd3 nd3Var) {
        String strE = nd3Var.e();
        if (strE != null) {
            ToastUtils.v(strE, new Object[0]);
            ((VideoPushViewModel) Y()).W(md3.a.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b1() {
        Intent intentO = ((VideoPushViewModel) Y()).O();
        if (intentO != null) {
            try {
                if (Build.VERSION.SDK_INT >= 35) {
                    this.s.a(intentO);
                } else {
                    startActivityForResult(intentO, this.p);
                }
            } catch (Exception e2) {
                Log.e(K(), "启动系统 GIF 选择失败", e2);
                ToastUtils.v(getString(R.string.cannot_open_album), new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c1() {
        d1();
    }

    private final void d1() {
        Intent intentP = ((VideoPushViewModel) Y()).P();
        if (intentP != null) {
            try {
                if (Build.VERSION.SDK_INT >= 35) {
                    this.r.a(intentP);
                } else {
                    startActivityForResult(intentP, this.o);
                }
            } catch (Exception e2) {
                Log.e(K(), "启动系统视频选择失败", e2);
                ToastUtils.v(getString(R.string.cannot_open_album), new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e1(VideoPushActivity videoPushActivity, ActivityResult activityResult) {
        Intent intentA;
        Uri data;
        if (activityResult.b() != -1 || (intentA = activityResult.a()) == null || (data = intentA.getData()) == null) {
            return;
        }
        ((VideoPushViewModel) videoPushActivity.Y()).Z(data, videoPushActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f1(VideoPushActivity videoPushActivity, ActivityResult activityResult) {
        Intent intentA;
        Uri data;
        if (activityResult.b() != -1 || (intentA = activityResult.a()) == null || (data = intentA.getData()) == null) {
            return;
        }
        ((VideoPushViewModel) videoPushActivity.Y()).Y(data, videoPushActivity);
    }

    private final void g1() {
        if (PermissionUtils.t(i02.a().b())) {
            b1();
        } else {
            R0(2);
        }
    }

    private final void h1() {
        if (PermissionUtils.t(i02.a().b())) {
            c1();
        } else {
            R0(1);
        }
    }

    private final void i1() {
        d1();
    }

    private final void j1(nd3 nd3Var) {
        String string;
        if (nd3Var.n()) {
            string = getString(R.string.device_remaining_space_loading);
        } else if (nd3Var.d() != null) {
            cb0 cb0Var = cb0.a;
            string = getString(R.string.device_remaining_space, cb0Var.a(cb0Var.b(nd3Var.d().longValue())));
        } else {
            string = getString(R.string.device_remaining_space_unknown);
        }
        p31.c(string);
        ((n4) I()).F.setText(string);
        ((n4) I()).V.setEnabled(!nd3Var.n());
    }

    private final void k1(nd3 nd3Var) {
        String string;
        String strC;
        ((n4) I()).c0.setRefreshing(nd3Var.m());
        ((n4) I()).z.setEnabled((nd3Var.m() || (!nd3Var.p() && !nd3Var.l()) || (strC = nd3Var.c()) == null || strC.length() == 0) ? false : true);
        if (nd3Var.m()) {
            return;
        }
        AppCompatButton appCompatButton = ((n4) I()).z;
        if (nd3Var.i()) {
            string = getString(R.string.upload_success);
        } else if (nd3Var.p()) {
            string = getString(R.string.upload_avi_video);
        } else {
            string = nd3Var.l() ? getString(R.string.upload_gif_file) : getString(R.string.please_complete_video_processing);
        }
        appCompatButton.setText(string);
    }

    private final void l1(nd3 nd3Var) {
        Uri uriG = nd3Var.g();
        if (uriG != null) {
            y0(uriG);
        } else {
            Z0();
        }
    }

    private final void m1(nd3 nd3Var) {
        Long lH = nd3Var.h();
        if (lH == null) {
            ((n4) I()).b0.setVisibility(8);
            return;
        }
        ((n4) I()).b0.setVisibility(0);
        ((n4) I()).b0.setText(getString(R.string.video_crop_size, cb0.a.a(lH.longValue())));
        ((n4) I()).b0.setTextColor(nd3Var.o() ? getColor(R.color.red) : getColor(R.color.black));
    }

    private final void w0(Uri uri) {
        Log.d(K(), "开始将AVI转换为GIF: " + uri);
        ((VideoPushViewModel) Y()).K(uri, this, new ar0() { // from class: xc3
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return VideoPushActivity.x0(this.a, (Uri) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 x0(VideoPushActivity videoPushActivity, Uri uri) {
        if (uri != null) {
            Log.d(videoPushActivity.K(), "AVI转GIF成功，显示GIF: " + uri);
            ((n4) videoPushActivity.I()).L.setVisibility(8);
            ((n4) videoPushActivity.I()).M.setVisibility(0);
            com.bumptech.glide.a.v(videoPushActivity).q(uri).w0(videoPushActivity.new a()).a(videoPushActivity.z0()).u0(((n4) videoPushActivity.I()).M);
        } else {
            Log.e(videoPushActivity.K(), "AVI转GIF失败，显示默认预览");
            videoPushActivity.Z0();
        }
        return k83.a;
    }

    private final void y0(Uri uri) {
        try {
            Log.d(K(), "显示视频预览: " + uri);
            String string = uri.toString();
            p31.e(string, "toString(...)");
            String lowerCase = string.toLowerCase(Locale.ROOT);
            p31.e(lowerCase, "toLowerCase(...)");
            if (kotlin.text.i.u(lowerCase, ".avi", false, 2, null)) {
                Log.d(K(), "检测到AVI文件，直接转换为GIF预览");
                w0(uri);
                return;
            }
            if (!kotlin.text.i.u(lowerCase, ".mp4", false, 2, null) && !kotlin.text.i.u(lowerCase, ".mov", false, 2, null) && !kotlin.text.i.u(lowerCase, ".mkv", false, 2, null) && !kotlin.text.i.u(lowerCase, ".wmv", false, 2, null) && !kotlin.text.i.u(lowerCase, ".flv", false, 2, null) && !kotlin.text.i.u(lowerCase, ".webm", false, 2, null) && !kotlin.text.i.M(lowerCase, "video", false, 2, null)) {
                ((n4) I()).L.setVisibility(8);
                ((n4) I()).M.setVisibility(0);
                com.bumptech.glide.a.v(this).q(uri).w0(new b()).a(z0()).u0(((n4) I()).M);
                Log.d(K(), "文件预览设置完成 - 使用 Glide 加载到 ImageView");
                return;
            }
            K0(uri);
        } catch (Exception e2) {
            Log.e(K(), "Error displaying video preview: " + e2.getMessage());
            Z0();
        }
    }

    private final of2 z0() {
        of2 of2VarJ0 = of2.j0();
        p31.e(of2VarJ0, "centerCropTransform(...)");
        return of2VarJ0;
    }

    @Override // com.legend.smartwatch.app.base.acitivity.BaseActivity
    public void initData(Bundle bundle) {
        this.f403q = new y93(this);
        ((n4) I()).K((VideoPushViewModel) Y());
        BajiProtocolManager bajiProtocolManagerI = zl.a.i();
        if (bajiProtocolManagerI != null) {
            ((VideoPushViewModel) Y()).l0(bajiProtocolManagerI);
            Log.d(K(), "蓝牙协议管理器设置成功");
        } else {
            Log.w(K(), "蓝牙协议管理器未初始化");
            ToastUtils.v(getString(R.string.bluetooth_not_initialized_restart), new Object[0]);
        }
        I0();
        G0();
        T0();
        Z0();
        ((VideoPushViewModel) Y()).f0();
    }

    @Override // com.legend.smartwatch.app.base.acitivity.BaseActivity
    public void initListener() {
        ((n4) I()).N.setOnClickListener(new View.OnClickListener() { // from class: dd3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoPushActivity.B0(this.a, view);
            }
        });
        ((n4) I()).K.setOnClickListener(new View.OnClickListener() { // from class: ed3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoPushActivity.C0(this.a, view);
            }
        });
        ((n4) I()).J.setOnClickListener(new View.OnClickListener() { // from class: fd3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoPushActivity.D0(this.a, view);
            }
        });
        ((n4) I()).z.setOnClickListener(new View.OnClickListener() { // from class: gd3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoPushActivity.E0(this.a, view);
            }
        });
        X0();
        V0();
        ((n4) I()).V.setOnClickListener(new View.OnClickListener() { // from class: hd3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoPushActivity.F0(this.a, view);
            }
        });
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        Uri data;
        Uri data2;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == this.o) {
                if (intent == null || (data2 = intent.getData()) == null) {
                    return;
                }
                ((VideoPushViewModel) Y()).Y(data2, this);
                return;
            }
            if (i == this.p) {
                if (intent == null || (data = intent.getData()) == null) {
                    return;
                }
                ((VideoPushViewModel) Y()).Z(data, this);
                return;
            }
            if (i == 188) {
                List listE = v22.e(intent);
                p31.c(listE);
                if (listE.isEmpty()) {
                    return;
                }
                LocalMedia localMedia = (LocalMedia) listE.get(0);
                VideoPushViewModel videoPushViewModel = (VideoPushViewModel) Y();
                p31.c(localMedia);
                videoPushViewModel.X(localMedia, this);
                return;
            }
            if (i == this.m) {
                String stringExtra = intent != null ? intent.getStringExtra("trimmed_video_path") : null;
                if (stringExtra != null && stringExtra.length() != 0) {
                    ((VideoPushViewModel) Y()).b0(stringExtra, this);
                } else {
                    Log.w(K(), "未获取到裁剪后的视频路径");
                    ToastUtils.v(getString(R.string.video_crop_failed), new Object[0]);
                }
            }
        }
    }

    @Override // com.legend.smartwatch.app.base.acitivity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        y93 y93Var = this.f403q;
        if (y93Var == null) {
            p31.t("uploadProgressUi");
            y93Var = null;
        }
        y93Var.d();
        try {
            VideoView videoView = ((n4) I()).L;
            p31.e(videoView, "ivVideoPreview");
            videoView.stopPlayback();
        } catch (Exception e2) {
            Log.e(K(), "停止视频播放失败", e2);
        }
        ((VideoPushViewModel) Y()).g0();
        ((VideoPushViewModel) Y()).G(this);
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        try {
            VideoView videoView = ((n4) I()).L;
            p31.e(videoView, "ivVideoPreview");
            if (videoView.isPlaying()) {
                videoView.pause();
            }
        } catch (Exception e2) {
            Log.e(K(), "暂停视频播放失败", e2);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        try {
            VideoView videoView = ((n4) I()).L;
            p31.e(videoView, "ivVideoPreview");
            if (videoView.isPlaying()) {
                return;
            }
            videoView.start();
        } catch (Exception e2) {
            Log.e(K(), "恢复视频播放失败", e2);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onWatchRemainEvent(sg3 sg3Var) {
        p31.f(sg3Var, "event");
        Log.d(K(), "收到表盘剩余空间: " + sg3Var.a() + " bytes");
        ((VideoPushViewModel) Y()).c0(sg3Var);
    }
}
