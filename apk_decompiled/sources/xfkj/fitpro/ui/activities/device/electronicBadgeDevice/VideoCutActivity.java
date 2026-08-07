package xfkj.fitpro.ui.activities.device.electronicBadgeDevice;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.RectF;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.jieli.jl_rcsp.constant.WatchConstant;
import com.jieli.jl_rcsp.constant.WatchError;
import com.legend.smartwatch.electronicbadge.android.R;
import com.tencent.connect.common.Constants;
import defpackage.ac0;
import defpackage.ad1;
import defpackage.j33;
import defpackage.nq0;
import defpackage.py;
import defpackage.rb0;
import defpackage.s23;
import defpackage.sh2;
import defpackage.vt2;
import defpackage.wa3;
import defpackage.wt2;
import defpackage.yj0;
import defpackage.zc1;
import defpackage.zj0;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;
import java.util.Timer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import xfkj.fitpro.model.sever.body.ClockDialInfoBody;
import xfkj.fitpro.ui.activities.device.electronicBadgeDevice.model.VideoInfo;
import xfkj.fitpro.view.RangeSeekBarView;
import xfkj.fitpro.view.VideoCropOverlayView;

/* JADX INFO: loaded from: classes4.dex */
public class VideoCutActivity extends AppCompatActivity {
    private String b;
    private nq0 i;
    private String p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private RangeSeekBarView f402q;
    private TextView r;
    private RecyclerView s;
    private VideoView t;
    private ImageView u;
    private VideoCropOverlayView v;
    private int a = 5;
    private VideoInfo c = null;
    private MediaPlayer d = null;
    private int e = 0;
    private final ArrayList f = new ArrayList();
    private int g = wa3.b(35.0f);
    private int h = wa3.b(50.0f);
    private long j = 0;
    private long k = 5000;
    private int l = 0;
    private Timer m = null;
    private j33 n = null;
    private AlertDialog o = null;
    private boolean w = false;
    private long x = 0;
    private int y = 0;
    private int z = 0;
    private float F = 0.0f;
    private float G = 0.0f;
    private float H = 0.0f;
    private float I = 0.0f;
    private int J = 0;
    private int K = 10;
    private int L = 1;
    private Boolean M = null;

    class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            VideoCutActivity.this.l = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
            Log.d("sssssssssssssssssssVideoCutActivity", " mFirstPosition = " + VideoCutActivity.this.l);
            VideoCutActivity videoCutActivity = VideoCutActivity.this;
            videoCutActivity.j = videoCutActivity.f402q.getSelectedMinValue() + (((long) VideoCutActivity.this.l) * 1000);
            VideoCutActivity videoCutActivity2 = VideoCutActivity.this;
            videoCutActivity2.k = videoCutActivity2.f402q.getSelectedMaxValue() + (((long) VideoCutActivity.this.l) * 1000);
            VideoCutActivity.this.f402q.f(VideoCutActivity.this.j, VideoCutActivity.this.k);
            VideoCutActivity.this.f402q.invalidate();
            VideoCutActivity.this.V0();
        }
    }

    class b implements zj0 {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(yj0 yj0Var) {
            try {
                String strM = yj0Var.m();
                boolean z = strM != null && (strM.contains("h264_mediacodec") || strM.contains("hevc_mediacodec") || strM.contains("mediacodec"));
                VideoCutActivity.this.M = Boolean.valueOf(z);
                Log.d("sssssssssssssssssssVideoCutActivity", "=== FFmpeg硬件加速检测结果 ===");
                StringBuilder sb = new StringBuilder();
                sb.append("硬件加速支持: ");
                sb.append(z ? "✓ 可用" : "✗ 不可用");
                Log.d("sssssssssssssssssssVideoCutActivity", sb.toString());
                if (strM != null) {
                    Log.d("sssssssssssssssssssVideoCutActivity", "检测输出: " + strM.substring(0, Math.min(200, strM.length())));
                }
                if (z) {
                    VideoCutActivity.this.s0();
                }
            } catch (Exception e) {
                Log.e("sssssssssssssssssssVideoCutActivity", "检查解码器时出错", e);
                VideoCutActivity.this.M = Boolean.FALSE;
            }
        }

        @Override // defpackage.zj0
        public void a(final yj0 yj0Var) {
            VideoCutActivity.this.runOnUiThread(new Runnable() { // from class: xfkj.fitpro.ui.activities.device.electronicBadgeDevice.l
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.c(yj0Var);
                }
            });
        }
    }

    class c implements zj0 {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void c(yj0 yj0Var) {
            try {
                String strM = yj0Var.m();
                boolean z = strM != null && strM.contains("mediacodec");
                StringBuilder sb = new StringBuilder();
                sb.append("硬件编码器支持: ");
                sb.append(z ? "✓ 可用" : "✗ 不可用（不影响，我们使用MJPEG软件编码）");
                Log.d("sssssssssssssssssssVideoCutActivity", sb.toString());
                if (strM == null || !z) {
                    return;
                }
                Log.d("sssssssssssssssssssVideoCutActivity", "编码器输出: " + strM.substring(0, Math.min(200, strM.length())));
            } catch (Exception e) {
                Log.w("sssssssssssssssssssVideoCutActivity", "检查编码器时出错", e);
            }
        }

        @Override // defpackage.zj0
        public void a(final yj0 yj0Var) {
            VideoCutActivity.this.runOnUiThread(new Runnable() { // from class: xfkj.fitpro.ui.activities.device.electronicBadgeDevice.m
                @Override // java.lang.Runnable
                public final void run() {
                    VideoCutActivity.c.c(yj0Var);
                }
            });
        }
    }

    class d implements zj0 {
        final /* synthetic */ String a;
        final /* synthetic */ Runnable b;

        d(String str, Runnable runnable) {
            this.a = str;
            this.b = runnable;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(yj0 yj0Var, String str, Runnable runnable) {
            try {
                if (!sh2.b(yj0Var.n())) {
                    Log.w("sssssssssssssssssssVideoCutActivity", "FFprobe获取GIF时长失败，尝试使用FFmpeg获取");
                    VideoCutActivity.this.z0(str, runnable);
                    return;
                }
                String strM = yj0Var.m();
                if (strM == null || strM.trim().isEmpty()) {
                    Log.w("sssssssssssssssssssVideoCutActivity", "FFprobe输出为空，尝试使用FFmpeg获取");
                    VideoCutActivity.this.z0(str, runnable);
                    return;
                }
                try {
                    double d = Double.parseDouble(strM.trim());
                    VideoCutActivity.this.x = (long) (1000.0d * d);
                    Log.d("sssssssssssssssssssVideoCutActivity", "GIF时长获取成功: " + VideoCutActivity.this.x + "ms (" + d + "s)");
                    if (VideoCutActivity.this.x > ((long) VideoCutActivity.this.a) * 1000) {
                        VideoCutActivity videoCutActivity = VideoCutActivity.this;
                        videoCutActivity.x = ((long) videoCutActivity.a) * 1000;
                        Log.d("sssssssssssssssssssVideoCutActivity", "GIF时长超过5秒，限制为5秒");
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                } catch (NumberFormatException e) {
                    Log.e("sssssssssssssssssssVideoCutActivity", "解析GIF时长失败: " + strM, e);
                    VideoCutActivity.this.z0(str, runnable);
                }
            } catch (Exception e2) {
                Log.e("sssssssssssssssssssVideoCutActivity", "处理GIF时长结果失败", e2);
                VideoCutActivity videoCutActivity2 = VideoCutActivity.this;
                videoCutActivity2.x = ((long) videoCutActivity2.a) * 1000;
                if (runnable != null) {
                    runnable.run();
                }
            }
        }

        @Override // defpackage.zj0
        public void a(final yj0 yj0Var) {
            VideoCutActivity videoCutActivity = VideoCutActivity.this;
            final String str = this.a;
            final Runnable runnable = this.b;
            videoCutActivity.runOnUiThread(new Runnable() { // from class: xfkj.fitpro.ui.activities.device.electronicBadgeDevice.n
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.c(yj0Var, str, runnable);
                }
            });
        }
    }

    class e implements zj0 {
        final /* synthetic */ Runnable a;

        e(Runnable runnable) {
            this.a = runnable;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(yj0 yj0Var, Runnable runnable) {
            try {
                String strM = yj0Var.m();
                if (strM != null) {
                    Matcher matcher = Pattern.compile("Duration: (\\d{2}):(\\d{2}):(\\d{2})\\.(\\d{2})").matcher(strM);
                    if (matcher.find()) {
                        String strGroup = matcher.group(1);
                        Objects.requireNonNull(strGroup);
                        int i = Integer.parseInt(strGroup);
                        String strGroup2 = matcher.group(2);
                        Objects.requireNonNull(strGroup2);
                        int i2 = Integer.parseInt(strGroup2);
                        String strGroup3 = matcher.group(3);
                        Objects.requireNonNull(strGroup3);
                        int i3 = Integer.parseInt(strGroup3);
                        String strGroup4 = matcher.group(4);
                        Objects.requireNonNull(strGroup4);
                        VideoCutActivity.this.x = (long) ((((double) ((i * 3600) + (i2 * 60) + i3)) + (((double) Integer.parseInt(strGroup4)) / 100.0d)) * 1000.0d);
                        Log.d("sssssssssssssssssssVideoCutActivity", "从FFmpeg输出解析GIF时长成功: " + VideoCutActivity.this.x + "ms");
                    } else {
                        Log.w("sssssssssssssssssssVideoCutActivity", "无法从FFmpeg输出中解析时长，使用默认值5秒");
                        VideoCutActivity videoCutActivity = VideoCutActivity.this;
                        videoCutActivity.x = ((long) videoCutActivity.a) * 1000;
                    }
                } else {
                    Log.w("sssssssssssssssssssVideoCutActivity", "FFmpeg输出为空，使用默认值5秒");
                    VideoCutActivity videoCutActivity2 = VideoCutActivity.this;
                    videoCutActivity2.x = ((long) videoCutActivity2.a) * 1000;
                }
                if (VideoCutActivity.this.x > ((long) VideoCutActivity.this.a) * 1000) {
                    VideoCutActivity videoCutActivity3 = VideoCutActivity.this;
                    videoCutActivity3.x = ((long) videoCutActivity3.a) * 1000;
                }
                if (runnable != null) {
                    runnable.run();
                }
            } catch (Exception e) {
                Log.e("sssssssssssssssssssVideoCutActivity", "解析FFmpeg输出失败", e);
                VideoCutActivity videoCutActivity4 = VideoCutActivity.this;
                videoCutActivity4.x = ((long) videoCutActivity4.a) * 1000;
                if (runnable != null) {
                    runnable.run();
                }
            }
        }

        @Override // defpackage.zj0
        public void a(final yj0 yj0Var) {
            VideoCutActivity videoCutActivity = VideoCutActivity.this;
            final Runnable runnable = this.a;
            videoCutActivity.runOnUiThread(new Runnable() { // from class: xfkj.fitpro.ui.activities.device.electronicBadgeDevice.o
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.c(yj0Var, runnable);
                }
            });
        }
    }

    class f implements zj0 {
        final /* synthetic */ int a;
        final /* synthetic */ String b;
        final /* synthetic */ int c;

        f(int i, String str, int i2) {
            this.a = i;
            this.b = str;
            this.c = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(yj0 yj0Var, int i, String str, int i2) {
            try {
                if (!VideoCutActivity.this.isFinishing() && !VideoCutActivity.this.isDestroyed()) {
                    if (!sh2.b(yj0Var.n())) {
                        Log.e("sssssssssssssssssssVideoCutActivity", " 获取帧错误 time = " + i + ", error = " + yj0Var.m());
                        VideoCutActivity.this.F0(i2);
                        return;
                    }
                    Log.d("sssssssssssssssssssVideoCutActivity", " 完成 time = " + i);
                    if (i == 0) {
                        for (int i3 = 0; i3 < VideoCutActivity.this.e; i3++) {
                            VideoCutActivity.this.f.add(str);
                        }
                        VideoCutActivity.this.i.g(VideoCutActivity.this.f);
                    } else {
                        VideoCutActivity.this.f.set(i, str);
                        VideoCutActivity.this.i.f(i, str);
                    }
                    VideoCutActivity.this.F0(i2);
                    return;
                }
                Log.w("sssssssssssssssssssVideoCutActivity", "Activity已销毁，取消获取帧回调");
            } catch (Exception e) {
                Log.e("sssssssssssssssssssVideoCutActivity", "获取帧完成回调中出错", e);
                VideoCutActivity.this.F0(i2);
            }
        }

        @Override // defpackage.zj0
        public void a(final yj0 yj0Var) {
            VideoCutActivity videoCutActivity = VideoCutActivity.this;
            final int i = this.a;
            final String str = this.b;
            final int i2 = this.c;
            videoCutActivity.runOnUiThread(new Runnable() { // from class: xfkj.fitpro.ui.activities.device.electronicBadgeDevice.p
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.c(yj0Var, i, str, i2);
                }
            });
        }
    }

    class g implements zj0 {
        final /* synthetic */ String a;

        g(String str) {
            this.a = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(yj0 yj0Var, String str) throws Throwable {
            try {
                if (!VideoCutActivity.this.isFinishing() && !VideoCutActivity.this.isDestroyed()) {
                    if (VideoCutActivity.this.o != null && VideoCutActivity.this.o.isShowing()) {
                        VideoCutActivity.this.o.dismiss();
                    }
                    if (!sh2.b(yj0Var.n())) {
                        String strM = yj0Var.m();
                        Log.e("sssssssssssssssssssVideoCutActivity", " 截取失败: " + strM + ", error: " + yj0Var.k());
                        VideoCutActivity videoCutActivity = VideoCutActivity.this;
                        Toast.makeText(videoCutActivity, videoCutActivity.getString(R.string.video_cut_failed, strM), 0).show();
                        VideoCutActivity.this.finish();
                        return;
                    }
                    File file = new File(str);
                    if (!file.exists()) {
                        Log.e("sssssssssssssssssssVideoCutActivity", " 输出文件不存在: " + str);
                        VideoCutActivity videoCutActivity2 = VideoCutActivity.this;
                        Toast.makeText(videoCutActivity2, videoCutActivity2.getString(R.string.video_cut_failed_file_not_exist), 0).show();
                        VideoCutActivity.this.finish();
                        return;
                    }
                    Log.d("sssssssssssssssssssVideoCutActivity", " 完成截取 outfile = " + str);
                    Log.d("sssssssssssssssssssVideoCutActivity", " 文件大小: " + file.length() + " bytes");
                    int iU0 = VideoCutActivity.this.u0(str);
                    Log.d("sssssssssssssssssssVideoCutActivity", "检测到的dwSuggestedBufferSize: " + iU0 + " bytes (限制: 20k = " + WatchError.ERR_NETWORK_OTA_UNKNOWN + " bytes)");
                    if (iU0 <= 0 || iU0 < 20480) {
                        Intent intent = new Intent();
                        intent.putExtra("trimmed_video_path", str);
                        VideoCutActivity.this.setResult(-1, intent);
                        VideoCutActivity.this.finish();
                        return;
                    }
                    if (VideoCutActivity.this.J >= 3 || VideoCutActivity.this.K >= 31) {
                        Log.e("sssssssssssssssssssVideoCutActivity", "达到最大重试次数(3)或质量上限(31)，缓冲区大小仍超过20k (" + (iU0 / 1024) + "KB)");
                        if (VideoCutActivity.this.o != null && VideoCutActivity.this.o.isShowing()) {
                            VideoCutActivity.this.o.dismiss();
                        }
                        VideoCutActivity videoCutActivity3 = VideoCutActivity.this;
                        Toast.makeText(videoCutActivity3, videoCutActivity3.getString(R.string.video_file_too_large), 1).show();
                        VideoCutActivity.this.finish();
                        return;
                    }
                    VideoCutActivity.this.J++;
                    int iMin = Math.min(((VideoCutActivity.this.J - 1) * 2) + 5, 31 - VideoCutActivity.this.K);
                    VideoCutActivity videoCutActivity4 = VideoCutActivity.this;
                    videoCutActivity4.K = Math.min(31, videoCutActivity4.K + iMin);
                    Log.w("sssssssssssssssssssVideoCutActivity", "缓冲区大小超过20k (" + (iU0 / 1024) + "KB)，降低质量重试。当前质量: " + VideoCutActivity.this.K + "，重试次数: " + VideoCutActivity.this.J + WatchConstant.FAT_FS_ROOT + 3);
                    if (file.delete()) {
                        Log.d("sssssssssssssssssssVideoCutActivity", "已删除文件，准备重新转换");
                    }
                    if (VideoCutActivity.this.o != null && VideoCutActivity.this.o.isShowing()) {
                        VideoCutActivity.this.o.dismiss();
                    }
                    VideoCutActivity.this.X0();
                    return;
                }
                Log.w("sssssssssssssssssssVideoCutActivity", "Activity已销毁，取消完成回调");
            } catch (Exception e) {
                Log.e("sssssssssssssssssssVideoCutActivity", "完成回调中出错", e);
            }
        }

        @Override // defpackage.zj0
        public void a(final yj0 yj0Var) {
            VideoCutActivity videoCutActivity = VideoCutActivity.this;
            final String str = this.a;
            videoCutActivity.runOnUiThread(new Runnable() { // from class: xfkj.fitpro.ui.activities.device.electronicBadgeDevice.q
                @Override // java.lang.Runnable
                public final void run() throws Throwable {
                    this.a.c(yj0Var, str);
                }
            });
        }
    }

    class h implements ad1 {
        h() {
        }

        @Override // defpackage.ad1
        public void a(zc1 zc1Var) {
            Log.d("sssssssssssssssssssVideoCutActivity", "FFmpeg log: " + zc1Var.a());
        }
    }

    class i implements wt2 {
        i() {
        }

        @Override // defpackage.wt2
        public void a(vt2 vt2Var) {
            Log.d("sssssssssssssssssssVideoCutActivity", " 截取进度: " + vt2Var.a() + "ms");
        }
    }

    private String A0() {
        Boolean bool = this.M;
        if (bool != null && !bool.booleanValue()) {
            Log.d("sssssssssssssssssssVideoCutActivity", "硬件加速不可用，使用软件解码");
            return Constants.STR_EMPTY;
        }
        if (this.M == null) {
            Log.d("sssssssssssssssssssVideoCutActivity", "硬件加速状态未检测完成，尝试使用硬件加速（FFmpeg会自动回退）");
            return "-hwaccel mediacodec ";
        }
        Log.d("sssssssssssssssssssVideoCutActivity", "硬件加速可用，使用硬件解码加速");
        return "-hwaccel mediacodec ";
    }

    private int B0(int i2) {
        if (i2 != 1) {
            return i2 != 3 ? 29 : 27;
        }
        return 31;
    }

    private int C0(int i2) {
        return i2 != 3 ? 3 : 4;
    }

    private String E0() {
        try {
            ClockDialInfoBody clockDialInfoBodyA = py.a.a();
            if (clockDialInfoBodyA == null) {
                Log.w("sssssssssssssssssssVideoCutActivity", "表盘信息不存在，使用默认分辨率");
                Log.d("sssssssssssssssssssVideoCutActivity", "默认视频分辨率: 320x384");
                return "320x384";
            }
            short width = clockDialInfoBodyA.getWidth();
            short height = clockDialInfoBodyA.getHeight();
            String str = ((int) width) + "x" + ((int) height);
            Log.d("sssssssssssssssssssVideoCutActivity", "=== 视频分辨率设置 ===");
            Log.d("sssssssssssssssssssVideoCutActivity", "从表盘信息获取分辨率: " + str);
            Log.d("sssssssssssssssssssVideoCutActivity", "设备屏幕尺寸: " + ((int) width) + "x" + ((int) height));
            StringBuilder sb = new StringBuilder();
            sb.append("设备ID: ");
            sb.append(clockDialInfoBodyA.getDevId());
            Log.d("sssssssssssssssssssVideoCutActivity", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("屏幕类型: ");
            sb2.append(clockDialInfoBodyA.getScreenType() == 0 ? "方屏" : "圆屏");
            Log.d("sssssssssssssssssssVideoCutActivity", sb2.toString());
            return str;
        } catch (Exception e2) {
            Log.e("sssssssssssssssssssVideoCutActivity", "获取表盘信息失败，使用默认分辨率", e2);
            Log.d("sssssssssssssssssssVideoCutActivity", "异常情况使用默认视频分辨率: 320x384");
            return "320x384";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0(int i2) {
        if (i2 >= this.e) {
            return;
        }
        String str = this.p + File.separator + i2 + ".jpg";
        String strX0 = x0();
        String strB = this.c.b();
        if (strB == null || strB.startsWith("content://")) {
            Log.e("sssssssssssssssssssVideoCutActivity", "FFmpeg 无法处理 Content URI: " + strB);
            return;
        }
        String str2 = String.format("-y %s-ss %d -i \"%s\" -frames:v 1 -f image2 -s %s \"%s\"", A0(), Integer.valueOf(i2), strB, strX0, str);
        int i3 = i2 + 1;
        if (isFinishing() || isDestroyed()) {
            Log.w("sssssssssssssssssssVideoCutActivity", "Activity已销毁，取消获取帧");
        } else {
            com.arthenica.ffmpegkit.b.c(str2, new f(i2, str, i3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G0() {
        VideoView videoView;
        float f2;
        if (this.v == null || (videoView = this.t) == null || this.y <= 0 || this.z <= 0) {
            Log.w("sssssssssssssssssssVideoCutActivity", "无法初始化裁剪框：视图或视频尺寸无效");
            return;
        }
        int[] iArr = new int[2];
        videoView.getLocationOnScreen(iArr);
        int i2 = iArr[0];
        int i3 = iArr[1];
        final int width = this.t.getWidth();
        final int height = this.t.getHeight();
        int[] iArr2 = new int[2];
        this.v.getLocationOnScreen(iArr2);
        float f3 = i2 - iArr2[0];
        float f4 = i3 - iArr2[1];
        float f5 = width + f3;
        float f6 = height + f4;
        Log.d("sssssssssssssssssssVideoCutActivity", "=== 裁剪框初始化 ===");
        Log.d("sssssssssssssssssssVideoCutActivity", "视频预览位置: (" + f3 + ", " + f4 + ") - (" + f5 + ", " + f6 + ")");
        StringBuilder sb = new StringBuilder();
        sb.append("视频预览尺寸: ");
        sb.append(width);
        sb.append("x");
        sb.append(height);
        Log.d("sssssssssssssssssssVideoCutActivity", sb.toString());
        this.v.k(f3, f4, f5, f6);
        ClockDialInfoBody clockDialInfoBodyA = py.a.a();
        if (clockDialInfoBodyA != null) {
            short width2 = clockDialInfoBodyA.getWidth();
            short height2 = clockDialInfoBodyA.getHeight();
            f2 = width2 / height2;
            Log.d("sssssssssssssssssssVideoCutActivity", "目标宽高比: " + f2 + " (" + ((int) width2) + "x" + ((int) height2) + ")");
        } else {
            f2 = 1.0f;
        }
        this.v.setAspectRatio(f2);
        this.v.setOnCropChangeListener(new VideoCropOverlayView.a() { // from class: ic3
            @Override // xfkj.fitpro.view.VideoCropOverlayView.a
            public final void a(RectF rectF, float f7, float f8, float f9, float f10) {
                this.a.N0(width, height, rectF, f7, f8, f9, f10);
            }
        });
    }

    private void H0() {
        RecyclerView recyclerView = this.s;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(this, 0, false));
            this.s.setAdapter(this.i);
            this.s.addOnScrollListener(new a());
        }
    }

    private void I0(String str, Uri uri) {
        Log.d("sssssssssssssssssssVideoCutActivity", "=== GIF文件处理 ===");
        VideoView videoView = this.t;
        if (videoView != null) {
            videoView.setVisibility(8);
        }
        ImageView imageView = this.u;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        if (this.u != null && uri != null) {
            ((com.bumptech.glide.e) com.bumptech.glide.a.v(this).l().x0(uri).f(ac0.b)).u0(this.u);
            Log.d("sssssssssssssssssssVideoCutActivity", "GIF预览加载完成");
        }
        y0(str, new Runnable() { // from class: cc3
            @Override // java.lang.Runnable
            public final void run() {
                this.a.O0();
            }
        });
    }

    private void J0() {
        RangeSeekBarView rangeSeekBarView = this.f402q;
        if (rangeSeekBarView != null) {
            rangeSeekBarView.setSelectedMinValue(this.j);
            this.f402q.setSelectedMaxValue(this.k);
            this.f402q.f(this.j, this.k);
            this.f402q.setNotifyWhileDragging(true);
            this.f402q.setOnRangeSeekBarChangeListener(new RangeSeekBarView.a() { // from class: hc3
            });
        }
    }

    private void K0() {
        VideoInfo videoInfo = this.c;
        if (videoInfo == null) {
            Log.e("sssssssssssssssssssVideoCutActivity", "VideoInfo为空");
            Toast.makeText(this, getString(R.string.video_resource_invalid), 0).show();
            finish();
            return;
        }
        try {
            String strB = videoInfo.b();
            Log.d("sssssssssssssssssssVideoCutActivity", "=== 文件信息 ===");
            Log.d("sssssssssssssssssssVideoCutActivity", "文件路径: " + strB);
            Log.d("sssssssssssssssssssVideoCutActivity", "文件名称: " + this.c.a());
            Log.d("sssssssssssssssssssVideoCutActivity", "文件URI: " + this.c.c());
            File file = new File(strB);
            if (!file.exists()) {
                Log.e("sssssssssssssssssssVideoCutActivity", "文件不存在: " + strB);
                Toast.makeText(this, getString(R.string.video_file_not_exist), 0).show();
                finish();
                return;
            }
            Log.d("sssssssssssssssssssVideoCutActivity", "文件大小: " + file.length() + " bytes");
            StringBuilder sb = new StringBuilder();
            sb.append("文件可读: ");
            sb.append(file.canRead());
            Log.d("sssssssssssssssssssVideoCutActivity", sb.toString());
            this.w = M0(strB);
            Log.d("sssssssssssssssssssVideoCutActivity", "是否为GIF文件: " + this.w);
            if (this.w) {
                I0(strB, this.c.c());
            } else {
                L0(strB, this.c.c());
            }
        } catch (Exception e2) {
            Log.e("sssssssssssssssssssVideoCutActivity", "初始化文件失败", e2);
            Toast.makeText(this, getString(R.string.video_init_failed, e2.getMessage()), 0).show();
            finish();
        }
    }

    private void L0(String str, Uri uri) {
        if (this.t == null) {
            Log.e("sssssssssssssssssssVideoCutActivity", "VideoView为空");
            Toast.makeText(this, getString(R.string.video_resource_invalid), 0).show();
            finish();
            return;
        }
        Log.d("sssssssssssssssssssVideoCutActivity", "=== 视频文件处理 ===");
        ImageView imageView = this.u;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        VideoView videoView = this.t;
        if (videoView != null) {
            videoView.setVisibility(0);
        }
        if (uri == null || !uri.toString().startsWith("content://")) {
            Log.d("sssssssssssssssssssVideoCutActivity", "使用文件路径播放视频: " + str);
            this.t.setVideoPath(str);
        } else {
            Log.d("sssssssssssssssssssVideoCutActivity", "使用 Content URI 播放视频: " + uri);
            this.t.setVideoURI(uri);
        }
        this.t.requestFocus();
        this.t.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: dc3
            @Override // android.media.MediaPlayer.OnErrorListener
            public final boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                return this.a.P0(mediaPlayer, i2, i3);
            }
        });
        this.t.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: ec3
            @Override // android.media.MediaPlayer.OnCompletionListener
            public final void onCompletion(MediaPlayer mediaPlayer) {
                Log.d("sssssssssssssssssssVideoCutActivity", "视频播放完成");
            }
        });
        this.t.start();
        W0();
        this.t.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: fc3
            @Override // android.media.MediaPlayer.OnPreparedListener
            public final void onPrepared(MediaPlayer mediaPlayer) {
                this.a.R0(mediaPlayer);
            }
        });
    }

    private boolean M0(String str) {
        if (str == null) {
            return false;
        }
        return str.toLowerCase().endsWith(".gif");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N0(int i2, int i3, RectF rectF, float f2, float f3, float f4, float f5) {
        float f6 = this.y / i2;
        float f7 = this.z / i3;
        this.F = f2 * f6;
        this.G = f3 * f7;
        this.H = f6 * f4;
        this.I = f7 * f5;
        Log.d("sssssssssssssssssssVideoCutActivity", "裁剪区域变化 - 预览坐标: (" + f2 + ", " + f3 + ") 尺寸: " + f4 + "x" + f5);
        Log.d("sssssssssssssssssssVideoCutActivity", "裁剪区域变化 - 原始坐标: (" + this.F + ", " + this.G + ") 尺寸: " + this.H + "x" + this.I);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O0() {
        Log.d("sssssssssssssssssssVideoCutActivity", "GIF时长: " + this.x + "ms");
        int iCeil = (int) Math.ceil(((double) this.x) / 1000.0d);
        int i2 = this.a;
        if (iCeil > i2) {
            iCeil = i2;
        }
        this.e = iCeil;
        this.k = ((long) i2) * 1000;
        Log.d("sssssssssssssssssssVideoCutActivity", "GIF时长: " + (this.x / 1000.0f) + "s，使用固定5秒范围进行预览和裁剪");
        J0();
        o0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean P0(MediaPlayer mediaPlayer, int i2, int i3) {
        Log.e("sssssssssssssssssssVideoCutActivity", "视频播放错误: what=" + i2 + ", extra=" + i3);
        Toast.makeText(this, getString(R.string.video_playback_failed), 0).show();
        finish();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R0(MediaPlayer mediaPlayer) {
        Log.d("sssssssssssssssssssVideoCutActivity", "视频准备完成，时长: " + mediaPlayer.getDuration() + "ms");
        this.d = mediaPlayer;
        this.y = mediaPlayer.getVideoWidth();
        this.z = mediaPlayer.getVideoHeight();
        Log.d("sssssssssssssssssssVideoCutActivity", "视频原始尺寸: " + this.y + "x" + this.z);
        this.t.post(new Runnable() { // from class: gc3
            @Override // java.lang.Runnable
            public final void run() {
                this.a.G0();
            }
        });
        J0();
        o0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S0() {
        int width = this.f402q.getWidth() / this.a;
        this.g = width;
        this.i.e(width);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T0(View view) {
        this.J = 0;
        this.K = B0(this.L);
        X0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U0() {
        try {
            File[] fileArrListFiles = new File(this.p).listFiles();
            if (fileArrListFiles != null) {
                for (File file : fileArrListFiles) {
                    if (file.exists()) {
                        file.delete();
                    }
                }
            }
        } catch (Exception e2) {
            Log.e("sssssssssssssssssssVideoCutActivity", "清理临时文件时出错", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V0() {
        try {
            MediaPlayer mediaPlayer = this.d;
            if (mediaPlayer != null) {
                mediaPlayer.seekTo(this.j, 3);
            } else {
                this.t.seekTo((int) this.j);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void W0() {
        if (this.m == null) {
            this.m = new Timer();
            j33 j33Var = new j33(this);
            this.n = j33Var;
            this.m.schedule(j33Var, 0L, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X0() {
        this.o = rb0.a(this);
        File file = new File(this.b);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = this.b + wa3.c(this.c.a()) + "_trim.avi";
        float f2 = this.j / 1000.0f;
        float f3 = this.k / 1000.0f;
        float f4 = f3 - f2;
        String strE0 = E0();
        String[] strArrSplit = strE0.split("x");
        String str2 = strArrSplit[0];
        String str3 = strArrSplit[1];
        String strB = this.c.b();
        if (strB == null || strB.startsWith("content://")) {
            Log.e("sssssssssssssssssssVideoCutActivity", "FFmpeg 无法处理 Content URI: " + strB);
            Toast.makeText(this, getString(R.string.video_format_not_supported), 0).show();
            finish();
            return;
        }
        String strQ0 = q0(f2, strB, f4, strE0, str2, str3, str);
        StringBuilder sb = new StringBuilder();
        sb.append("=== ");
        sb.append(this.w ? "GIF" : "视频");
        sb.append("裁剪信息 ===");
        Log.d("sssssssssssssssssssVideoCutActivity", sb.toString());
        Log.d("sssssssssssssssssssVideoCutActivity", "输入文件: " + strB);
        Log.d("sssssssssssssssssssVideoCutActivity", "输出路径: " + str);
        Log.d("sssssssssssssssssssVideoCutActivity", "裁剪时间: " + f2 + "s - " + f3 + "s (时长: " + f4 + "s)");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("视频尺寸: ");
        sb2.append(strE0);
        Log.d("sssssssssssssssssssVideoCutActivity", sb2.toString());
        Log.d("sssssssssssssssssssVideoCutActivity", "编码设置: MJPEG编码, " + C0(this.L) + "fps, q:v=" + B0(this.L) + ", 16kHz单声道音频, 高压缩参数");
        StringBuilder sb3 = new StringBuilder();
        sb3.append("预计文件大小: 约");
        sb3.append((int) (f4 * 18.0f));
        sb3.append("KB (5秒视频约90KB, 不含PCM音频)");
        Log.d("sssssssssssssssssssVideoCutActivity", sb3.toString());
        Log.d("sssssssssssssssssssVideoCutActivity", "FFmpeg命令: " + strQ0);
        try {
            if (!isFinishing() && !isDestroyed()) {
                Log.d("sssssssssssssssssssVideoCutActivity", "开始执行FFmpeg命令: " + strQ0);
                com.arthenica.ffmpegkit.b.d(strQ0, new g(str), new h(), new i());
                return;
            }
            Log.w("sssssssssssssssssssVideoCutActivity", "Activity已销毁，取消视频裁剪");
        } catch (Exception e2) {
            Log.e("sssssssssssssssssssVideoCutActivity", "启动视频裁剪时出错", e2);
            AlertDialog alertDialog = this.o;
            if (alertDialog != null && alertDialog.isShowing()) {
                this.o.dismiss();
            }
            Toast.makeText(this, getString(R.string.video_cut_start_failed), 0).show();
            finish();
        }
    }

    private void o0() {
        if (this.w) {
            Log.d("sssssssssssssssssssVideoCutActivity", "GIF帧数: " + this.e);
        } else {
            VideoView videoView = this.t;
            if (videoView != null) {
                this.e = videoView.getDuration() / 1000;
                Log.d("sssssssssssssssssssVideoCutActivity", "视频帧数: " + this.e);
            } else {
                Log.e("sssssssssssssssssssVideoCutActivity", "VideoView为空，无法获取视频时长");
                this.e = this.a;
            }
        }
        File file = new File(this.p);
        if (!file.exists()) {
            file.mkdirs();
        }
        F0(0);
    }

    private String p0() {
        return w0(this.L).replaceFirst("-q:v \\d+", "-q:v " + this.K).replaceAll("-b:a \\S+\\s*", Constants.STR_EMPTY) + " -c:a pcm_s16le -ar 16000 -ac 1";
    }

    /* JADX WARN: Code duplicated, block: B:45:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:58:0x0265  */
    /* JADX WARN: Code duplicated, block: B:60:0x026d  */
    /* JADX WARN: Code duplicated, block: B:62:0x0275  */
    /* JADX WARN: Code duplicated, block: B:63:0x0297  */
    /* JADX WARN: Instruction removed from duplicated block: B:62:0x0275, please report this as an issue */
    private String q0(float f2, String str, float f3, String str2, String str3, String str4, String str5) {
        Object obj;
        long j;
        float f4;
        String str6;
        Object obj2;
        try {
            ClockDialInfoBody clockDialInfoBodyA = py.a.a();
            int screenType = clockDialInfoBodyA != null ? clockDialInfoBodyA.getScreenType() : 0;
            int iC0 = C0(this.L);
            if (this.w || this.H <= 0.0f || this.I <= 0.0f || this.y <= 0 || this.z <= 0) {
                str6 = screenType == 0 ? String.format("scale=%s:%s:force_original_aspect_ratio=increase,crop=%s:%s:(iw-%s)/2:(ih-%s)/2,fps=%d", str3, str4, str3, str4, str3, str4, Integer.valueOf(iC0)) : String.format("scale=%s:%s:force_original_aspect_ratio=increase,crop=%s:%s:(iw-%s)/2:(ih-%s)/2,fps=%d", str3, str4, str3, str4, str3, str4, Integer.valueOf(iC0));
                Log.d("sssssssssssssssssssVideoCutActivity", "=== FFmpeg命令构建（默认裁剪） ===");
                StringBuilder sb = new StringBuilder();
                sb.append("文件类型: ");
                sb.append(this.w ? "GIF" : "视频");
                Log.d("sssssssssssssssssssVideoCutActivity", sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("屏幕类型: ");
                sb2.append(screenType == 0 ? "方屏" : "圆屏");
                Log.d("sssssssssssssssssssVideoCutActivity", sb2.toString());
            } else {
                int iRound = Math.round(this.F);
                int iRound2 = Math.round(this.G);
                int iRound3 = Math.round(this.H);
                int iRound4 = Math.round(this.I);
                int iMax = Math.max(0, Math.min(iRound, this.y - 1));
                int iMax2 = Math.max(0, Math.min(iRound2, this.z - 1));
                int iMax3 = Math.max(1, Math.min(iRound3, this.y - iMax));
                int iMax4 = Math.max(1, Math.min(iRound4, this.z - iMax2));
                str6 = String.format("crop=%d:%d:%d:%d,scale=%s:%s:force_original_aspect_ratio=decrease,pad=%s:%s:(ow-iw)/2:(oh-ih)/2,fps=%d", Integer.valueOf(iMax3), Integer.valueOf(iMax4), Integer.valueOf(iMax), Integer.valueOf(iMax2), str3, str4, str3, str4, Integer.valueOf(iC0));
                Log.d("sssssssssssssssssssVideoCutActivity", "=== FFmpeg命令构建（用户裁剪） ===");
                Log.d("sssssssssssssssssssVideoCutActivity", "用户裁剪区域: (" + iMax + ", " + iMax2 + ") 尺寸: " + iMax3 + "x" + iMax4);
            }
            if (this.w) {
                long j2 = this.x;
                if (j2 > 0) {
                    float f5 = j2 / 1000.0f;
                    if (f3 > f5) {
                        int iCeil = (int) Math.ceil(f3 / f5);
                        Log.d("sssssssssssssssssssVideoCutActivity", "=== GIF循环播放设置 ===");
                        Log.d("sssssssssssssssssssVideoCutActivity", "GIF时长: " + f5 + "s");
                        Log.d("sssssssssssssssssssVideoCutActivity", "目标时长: " + f3 + "s");
                        Log.d("sssssssssssssssssssVideoCutActivity", "需要循环次数: " + iCeil + "次");
                        Log.d("sssssssssssssssssssVideoCutActivity", "使用 -stream_loop -1 参数让GIF循环播放");
                        obj2 = "-stream_loop -1 ";
                    } else {
                        Log.d("sssssssssssssssssssVideoCutActivity", "GIF时长足够，无需循环播放");
                        obj2 = Constants.STR_EMPTY;
                    }
                } else {
                    obj2 = Constants.STR_EMPTY;
                }
            } else {
                obj2 = Constants.STR_EMPTY;
            }
            String strA0 = A0();
            String strP0 = p0();
            String str7 = String.format(Locale.ROOT, "-y %s%s-ss %.2f -i \"%s\" -t %.2f -vf \"%s\" -c:v mjpeg -vtag mjpg -pix_fmt yuvj420p %s -coder 1 -flags +loop+global_header -pred 1 -qmin 27 -qmax 31 -vsync cfr -video_track_timescale %d -packetsize 4096 -f avi \"%s\"", strA0, obj2, Float.valueOf(f2), str, Float.valueOf(f3), str6, strP0, Integer.valueOf(iC0), str5);
            Log.d("sssssssssssssssssssVideoCutActivity", "压缩级别: " + this.L + ", 编码参数: " + strP0);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("目标尺寸: ");
            try {
                sb3.append(str3);
                sb3.append("x");
                try {
                    sb3.append(str4);
                    Log.d("sssssssssssssssssssVideoCutActivity", sb3.toString());
                    Log.d("sssssssssssssssssssVideoCutActivity", "视频滤镜: " + str6);
                    Log.d("sssssssssssssssssssVideoCutActivity", "完整命令: " + str7);
                    return str7;
                } catch (Exception e2) {
                    e = e2;
                    Log.e("sssssssssssssssssssVideoCutActivity", "构建FFmpeg命令失败，使用默认命令", e);
                    if (this.w) {
                        j = this.x;
                        if (j > 0) {
                            f4 = j / 1000.0f;
                            if (f3 > f4) {
                                Log.d("sssssssssssssssssssVideoCutActivity", "异常处理：GIF需要循环播放，时长: " + f4 + "s, 目标: " + f3 + "s");
                                obj = "-stream_loop -1 ";
                            } else {
                                obj = Constants.STR_EMPTY;
                            }
                        } else {
                            obj = Constants.STR_EMPTY;
                        }
                    } else {
                        obj = Constants.STR_EMPTY;
                    }
                    String strA1 = A0();
                    String strP1 = p0();
                    int iC1 = C0(this.L);
                    return String.format(Locale.ROOT, "-y %s%s-ss %.2f -i \"%s\" -t %.2f -vf \"scale=%s:force_original_aspect_ratio=decrease,pad=%s:%s:(ow-iw)/2:(oh-ih)/2:color=black,fps=%d\" -c:v mjpeg -vtag mjpg -pix_fmt yuvj420p %s -coder 1 -flags +loop+global_header -pred 1 -qmin 27 -qmax 31 -vsync cfr -video_track_timescale %d -packetsize 4096 -f avi \"%s\"", strA1, obj, Float.valueOf(f2), str, Float.valueOf(f3), str2, str3, str4, Integer.valueOf(iC1), strP1, Integer.valueOf(iC1), str5);
                }
            } catch (Exception e3) {
                e = e3;
                Log.e("sssssssssssssssssssVideoCutActivity", "构建FFmpeg命令失败，使用默认命令", e);
                if (this.w) {
                    j = this.x;
                    if (j > 0) {
                        f4 = j / 1000.0f;
                        if (f3 > f4) {
                            Log.d("sssssssssssssssssssVideoCutActivity", "异常处理：GIF需要循环播放，时长: " + f4 + "s, 目标: " + f3 + "s");
                            obj = "-stream_loop -1 ";
                        } else {
                            obj = Constants.STR_EMPTY;
                        }
                    } else {
                        obj = Constants.STR_EMPTY;
                    }
                } else {
                    obj = Constants.STR_EMPTY;
                }
                String strA2 = A0();
                String strP2 = p0();
                int iC2 = C0(this.L);
                return String.format(Locale.ROOT, "-y %s%s-ss %.2f -i \"%s\" -t %.2f -vf \"scale=%s:force_original_aspect_ratio=decrease,pad=%s:%s:(ow-iw)/2:(oh-ih)/2:color=black,fps=%d\" -c:v mjpeg -vtag mjpg -pix_fmt yuvj420p %s -coder 1 -flags +loop+global_header -pred 1 -qmin 27 -qmax 31 -vsync cfr -video_track_timescale %d -packetsize 4096 -f avi \"%s\"", strA2, obj, Float.valueOf(f2), str, Float.valueOf(f3), str2, str3, str4, Integer.valueOf(iC2), strP2, Integer.valueOf(iC2), str5);
            }
        } catch (Exception e4) {
            e = e4;
        }
    }

    private void r0() {
        com.arthenica.ffmpegkit.b.c("-hide_banner -decoders | grep mediacodec", new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0() {
        com.arthenica.ffmpegkit.b.c("-hide_banner -encoders | grep mediacodec", new c());
    }

    private void t0() {
        Log.d("sssssssssssssssssssVideoCutActivity", "=== 开始检测FFmpeg硬件加速支持 ===");
        r0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:102:0x02d9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:103:0x02db  */
    /* JADX WARN: Code duplicated, block: B:191:0x0320 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:91:0x0285 A[Catch: all -> 0x0060, Exception -> 0x0299, TryCatch #0 {all -> 0x0060, blocks: (B:4:0x0011, B:6:0x0051, B:16:0x0069, B:17:0x0070, B:20:0x007c, B:22:0x0093, B:23:0x0097, B:25:0x00bd, B:27:0x00c3, B:29:0x00c9, B:31:0x00cd, B:33:0x00d3, B:35:0x00db, B:37:0x00e1, B:41:0x00eb, B:45:0x010a, B:47:0x0110, B:49:0x0118, B:51:0x0120, B:53:0x0126, B:55:0x0169, B:56:0x019f, B:58:0x01a3, B:60:0x01ad, B:62:0x01b1, B:64:0x01c8, B:66:0x01ce, B:70:0x01ea, B:73:0x01f2, B:75:0x01fa, B:89:0x025b, B:91:0x0285, B:95:0x029d, B:99:0x02b4, B:110:0x0320, B:105:0x02df, B:109:0x02fc, B:83:0x022c, B:86:0x023d, B:88:0x024c, B:113:0x033b, B:115:0x034e, B:116:0x0359, B:118:0x0361, B:120:0x0367, B:122:0x036f, B:124:0x0377, B:126:0x037d, B:127:0x0395, B:131:0x03b6, B:132:0x03bc, B:129:0x039a), top: B:154:0x0011 }] */
    /* JADX WARN: Code duplicated, block: B:94:0x029b  */
    /* JADX WARN: Instruction removed from duplicated block: B:91:0x0285, please report this as an issue */
    public int u0(String str) throws Throwable {
        Throwable th;
        String str2;
        String str3;
        int i2;
        int i3;
        String str4;
        String str5;
        char c2;
        int i4;
        String str6;
        String str7;
        int i5;
        String str8;
        RandomAccessFile randomAccessFile = null;
        try {
            try {
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(str, "r");
                try {
                    try {
                        long length = randomAccessFile2.length();
                        Log.d("sssssssssssssssssssVideoCutActivity", "=== 开始检测AVI文件缓冲区大小 ===");
                        Log.d("sssssssssssssssssssVideoCutActivity", "文件路径: " + str);
                        Log.d("sssssssssssssssssssVideoCutActivity", "文件大小: " + length + " bytes");
                        byte[] bArr = new byte[4096];
                        int i6 = randomAccessFile2.read(bArr);
                        if (i6 < 100) {
                            Log.w("sssssssssssssssssssVideoCutActivity", "文件头太短，无法读取dwSuggestedBufferSize");
                            try {
                                randomAccessFile2.close();
                            } catch (Exception e2) {
                                Log.e("sssssssssssssssssssVideoCutActivity", "关闭文件失败", e2);
                            }
                            return -1;
                        }
                        StringBuilder sb = new StringBuilder();
                        int i7 = 0;
                        while (true) {
                            str2 = "\n";
                            str3 = "%02X ";
                            if (i7 >= Math.min(64, i6)) {
                                break;
                            }
                            sb.append(String.format("%02X ", Byte.valueOf(bArr[i7])));
                            i7++;
                            if (i7 % 16 == 0) {
                                sb.append("\n");
                            }
                        }
                        Log.d("sssssssssssssssssssVideoCutActivity", "文件头前64字节（十六进制）:\n" + sb.toString());
                        int i8 = 32;
                        Log.d("sssssssssssssssssssVideoCutActivity", "是否为AVI文件: " + (bArr[0] == 82 && bArr[1] == 73 && bArr[2] == 70 && bArr[3] == 70 && bArr[8] == 65 && bArr[9] == 86 && bArr[10] == 73 && bArr[11] == 32));
                        int i9 = 0;
                        int i10 = 0;
                        int i11 = -1;
                        while (true) {
                            i2 = i6 - 4;
                            if (i10 >= i2) {
                                break;
                            }
                            if (bArr[i10] == 115 && bArr[i10 + 1] == 116 && bArr[i10 + 2] == 114 && bArr[i10 + 3] == 104) {
                                int i12 = i9 + 1;
                                Log.d("sssssssssssssssssssVideoCutActivity", "找到strh块 #" + i12 + "，文件偏移: 0x" + Integer.toHexString(i10) + " (" + i10 + ")");
                                int i13 = i10 + 8;
                                int[] iArr = {44, 40, 36, i8};
                                int i14 = i10 + 4;
                                if (i10 + 8 <= i6) {
                                    Log.d("sssssssssssssssssssVideoCutActivity", "  strh块大小: " + ((bArr[i14] & 255) | ((bArr[i10 + 5] & 255) << 8) | ((bArr[i10 + 6] & 255) << 16) | ((bArr[i10 + 7] & 255) << 24)) + " bytes");
                                }
                                if (i10 + 72 <= i6) {
                                    StringBuilder sb2 = new StringBuilder();
                                    int i15 = 0;
                                    for (int i16 = 64; i15 < i16; i16 = 64) {
                                        int i17 = i13 + i15;
                                        if (i17 >= i6) {
                                            break;
                                        }
                                        sb2.append(String.format(str3, Byte.valueOf(bArr[i17])));
                                        i15++;
                                        if (i15 % 16 == 0) {
                                            sb2.append(str2);
                                        }
                                    }
                                    Log.d("sssssssssssssssssssVideoCutActivity", "  strh块数据部分前64字节:\n" + sb2.toString());
                                }
                                int i18 = 0;
                                while (i18 < 4) {
                                    int i19 = iArr[i18];
                                    int i20 = i10 + i19;
                                    if (i20 + 4 <= i6) {
                                        try {
                                            i4 = i6;
                                            try {
                                                i5 = (bArr[i20] & 255) | ((bArr[i20 + 1] & 255) << 8) | ((bArr[i20 + 2] & 255) << 16) | ((bArr[i20 + 3] & 255) << 24);
                                                str6 = str2;
                                                str7 = str3;
                                                try {
                                                    StringBuilder sb3 = new StringBuilder();
                                                    sb3.append("  strh偏移 +0x");
                                                    sb3.append(Integer.toHexString(i19));
                                                    sb3.append(" (绝对偏移 0x");
                                                    sb3.append(Integer.toHexString(i20));
                                                    sb3.append(") 处的值: ");
                                                    sb3.append(i5);
                                                    sb3.append(" bytes (");
                                                    if (i5 > 0) {
                                                        str8 = (i5 / 1024) + " KB";
                                                    } else {
                                                        str8 = "0";
                                                    }
                                                    sb3.append(str8);
                                                    sb3.append(")");
                                                    Log.d("sssssssssssssssssssVideoCutActivity", sb3.toString());
                                                    if (i5 < 1024 && i5 < 10485760) {
                                                        Log.d("sssssssssssssssssssVideoCutActivity", "  ✓ 找到有效的dwSuggestedBufferSize: " + i5 + " bytes (" + (i5 / 1024) + " KB)");
                                                        if (i5 > i11) {
                                                            i11 = i5;
                                                        }
                                                    } else if (i5 <= 0 && i5 < 52428800) {
                                                        Log.d("sssssssssssssssssssVideoCutActivity", "  ? 读取到值但可能不是dwSuggestedBufferSize: " + i5 + " bytes");
                                                    }
                                                } catch (Exception e3) {
                                                    e = e3;
                                                    Log.w("sssssssssssssssssssVideoCutActivity", "  读取偏移 +0x" + Integer.toHexString(i19) + " 时出错: " + e.getMessage());
                                                }
                                            } catch (Exception e4) {
                                                e = e4;
                                                str6 = str2;
                                                str7 = str3;
                                                Log.w("sssssssssssssssssssVideoCutActivity", "  读取偏移 +0x" + Integer.toHexString(i19) + " 时出错: " + e.getMessage());
                                                i18++;
                                                str2 = str6;
                                                i6 = i4;
                                                str3 = str7;
                                            }
                                        } catch (Exception e5) {
                                            e = e5;
                                            i4 = i6;
                                        }
                                    } else {
                                        i4 = i6;
                                        String str9 = str2;
                                        str7 = str3;
                                        try {
                                            randomAccessFile2.seek(i20);
                                            byte[] bArr2 = new byte[4];
                                            if (randomAccessFile2.read(bArr2) != 4) {
                                                str6 = str9;
                                            } else {
                                                str6 = str9;
                                                i5 = (bArr2[0] & 255) | ((bArr2[1] & 255) << 8) | ((bArr2[2] & 255) << 16) | ((bArr2[3] & 255) << 24);
                                                StringBuilder sb4 = new StringBuilder();
                                                sb4.append("  strh偏移 +0x");
                                                sb4.append(Integer.toHexString(i19));
                                                sb4.append(" (绝对偏移 0x");
                                                sb4.append(Integer.toHexString(i20));
                                                sb4.append(") 处的值: ");
                                                sb4.append(i5);
                                                sb4.append(" bytes (");
                                                if (i5 > 0) {
                                                    str8 = (i5 / 1024) + " KB";
                                                } else {
                                                    str8 = "0";
                                                }
                                                sb4.append(str8);
                                                sb4.append(")");
                                                Log.d("sssssssssssssssssssVideoCutActivity", sb4.toString());
                                                if (i5 < 1024) {
                                                    if (i5 <= 0) {
                                                    }
                                                } else if (i5 <= 0) {
                                                }
                                            }
                                        } catch (Exception e6) {
                                            e = e6;
                                            str6 = str9;
                                            Log.w("sssssssssssssssssssVideoCutActivity", "  读取偏移 +0x" + Integer.toHexString(i19) + " 时出错: " + e.getMessage());
                                            i18++;
                                            str2 = str6;
                                            i6 = i4;
                                            str3 = str7;
                                        }
                                    }
                                    i18++;
                                    str2 = str6;
                                    i6 = i4;
                                    str3 = str7;
                                }
                                i3 = i6;
                                str4 = str2;
                                str5 = str3;
                                c2 = 2;
                                i9 = i12;
                            } else {
                                i3 = i6;
                                str4 = str2;
                                str5 = str3;
                                c2 = 2;
                            }
                            i10++;
                            str2 = str4;
                            i6 = i3;
                            str3 = str5;
                            i8 = 32;
                        }
                        if (i9 == 0) {
                            Log.w("sssssssssssssssssssVideoCutActivity", "未找到任何strh块！");
                            Log.d("sssssssssssssssssssVideoCutActivity", "查找其他可能的块标识...");
                            for (int i21 = 0; i21 < Math.min(512, i2); i21++) {
                                if (bArr[i21] == 97 && bArr[i21 + 1] == 118 && bArr[i21 + 2] == 105 && bArr[i21 + 3] == 104) {
                                    Log.d("sssssssssssssssssssVideoCutActivity", "找到avih块，偏移: 0x" + Integer.toHexString(i21));
                                }
                            }
                        } else {
                            Log.d("sssssssssssssssssssVideoCutActivity", "共找到 " + i9 + " 个strh块");
                        }
                        if (i11 == -1) {
                            Log.w("sssssssssssssssssssVideoCutActivity", "未找到有效的dwSuggestedBufferSize值");
                        } else {
                            Log.d("sssssssssssssssssssVideoCutActivity", "最终检测到的最大dwSuggestedBufferSize: " + i11 + " bytes (" + (i11 / 1024) + " KB)");
                        }
                        try {
                            randomAccessFile2.close();
                        } catch (Exception e7) {
                            Log.e("sssssssssssssssssssVideoCutActivity", "关闭文件失败", e7);
                        }
                        return i11;
                    } catch (Throwable th2) {
                        th = th2;
                        randomAccessFile = randomAccessFile2;
                        if (randomAccessFile == null) {
                            throw th;
                        }
                        try {
                            randomAccessFile.close();
                            throw th;
                        } catch (Exception e8) {
                            Log.e("sssssssssssssssssssVideoCutActivity", "关闭文件失败", e8);
                            throw th;
                        }
                    }
                } catch (Exception e9) {
                    e = e9;
                    randomAccessFile = randomAccessFile2;
                    Log.e("sssssssssssssssssssVideoCutActivity", "读取AVI文件dwSuggestedBufferSize失败", e);
                    if (randomAccessFile == null) {
                        return -1;
                    }
                    try {
                        randomAccessFile.close();
                        return -1;
                    } catch (Exception e10) {
                        Log.e("sssssssssssssssssssVideoCutActivity", "关闭文件失败", e10);
                        return -1;
                    }
                }
            } catch (Exception e11) {
                e = e11;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private String v0() {
        if (this.b == null) {
            File externalFilesDir = getExternalFilesDir(null);
            if (externalFilesDir == null) {
                externalFilesDir = getCacheDir();
            }
            StringBuilder sb = new StringBuilder();
            sb.append(externalFilesDir.getAbsolutePath());
            String str = File.separator;
            sb.append(str);
            sb.append("videoCut");
            sb.append(str);
            this.b = sb.toString();
        }
        return this.b;
    }

    private String w0(int i2) {
        if (i2 != 1) {
            return (i2 == 2 || i2 != 3) ? "-q:v 29 -b:v 50k -b:a 48k -r 3" : "-q:v 27 -b:v 65k -b:a 64k -r 4";
        }
        return "-q:v 31 -b:v 35k -b:a 32k -r 3";
    }

    private String x0() {
        try {
            ClockDialInfoBody clockDialInfoBodyA = py.a.a();
            if (clockDialInfoBodyA == null) {
                Log.w("sssssssssssssssssssVideoCutActivity", "表盘信息不存在，使用默认帧尺寸");
                Log.d("sssssssssssssssssssVideoCutActivity", "默认帧尺寸: 320x384");
                return "320x384";
            }
            short width = clockDialInfoBodyA.getWidth();
            short height = clockDialInfoBodyA.getHeight();
            String str = ((int) width) + "x" + ((int) height);
            Log.d("sssssssssssssssssssVideoCutActivity", "=== 帧尺寸设置 ===");
            Log.d("sssssssssssssssssssVideoCutActivity", "从表盘信息获取帧尺寸: " + str);
            Log.d("sssssssssssssssssssVideoCutActivity", "设备屏幕尺寸: " + ((int) width) + "x" + ((int) height));
            return str;
        } catch (Exception e2) {
            Log.e("sssssssssssssssssssVideoCutActivity", "获取表盘信息失败，使用默认帧尺寸", e2);
            Log.d("sssssssssssssssssssVideoCutActivity", "异常情况使用默认帧尺寸: 320x384");
            return "320x384";
        }
    }

    private void y0(String str, Runnable runnable) {
        Log.d("sssssssssssssssssssVideoCutActivity", "开始获取GIF时长: " + str);
        com.arthenica.ffmpegkit.b.c(String.format("-i \"%s\"", str), new d(str, runnable));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0(String str, Runnable runnable) {
        Log.d("sssssssssssssssssssVideoCutActivity", "使用FFmpeg获取GIF时长: " + str);
        com.arthenica.ffmpegkit.b.c(String.format("-i \"%s\"", str), new e(runnable));
    }

    public void D0() {
        try {
            int currentPosition = this.t.getCurrentPosition();
            Log.d("sssssssssssssssssssVideoCutActivity", "currentPosition = " + currentPosition + " mMaxTime = " + this.k);
            if (currentPosition >= this.k) {
                V0();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_video_cut);
        this.f402q = (RangeSeekBarView) findViewById(R.id.mRangeSeekBarView);
        this.r = (TextView) findViewById(R.id.mTvOk);
        this.s = (RecyclerView) findViewById(R.id.mRecyclerView);
        this.t = (VideoView) findViewById(R.id.mVideoView);
        this.u = (ImageView) findViewById(R.id.mGifImageView);
        this.v = (VideoCropOverlayView) findViewById(R.id.mCropOverlayView);
        this.c = (VideoInfo) getIntent().getParcelableExtra("path");
        int intExtra = getIntent().getIntExtra("extra_max_capture_duration", 5);
        if (intExtra > 0) {
            this.a = intExtra;
            this.k = ((long) intExtra) * 1000;
        }
        int intExtra2 = getIntent().getIntExtra("extra_compression_level", 1);
        this.L = intExtra2;
        if (intExtra2 < 1 || intExtra2 > 3) {
            this.L = 1;
        }
        this.K = B0(this.L);
        this.b = v0();
        StringBuilder sb = new StringBuilder();
        sb.append(this.b);
        VideoInfo videoInfo = this.c;
        sb.append(wa3.c(videoInfo != null ? videoInfo.a() : null));
        this.p = sb.toString();
        this.i = new nq0();
        RangeSeekBarView rangeSeekBarView = this.f402q;
        if (rangeSeekBarView != null) {
            rangeSeekBarView.setMaxCaptureDurationSeconds(this.a);
            this.f402q.post(new Runnable() { // from class: zb3
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.S0();
                }
            });
        }
        TextView textView = this.r;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: ac3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.T0(view);
                }
            });
        }
        H0();
        K0();
        t0();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        Timer timer = this.m;
        if (timer != null) {
            timer.cancel();
            this.m = null;
        }
        j33 j33Var = this.n;
        if (j33Var != null) {
            j33Var.cancel();
            this.n = null;
        }
        s23.c().a(new Runnable() { // from class: bc3
            @Override // java.lang.Runnable
            public final void run() {
                this.a.U0();
            }
        });
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        Log.d("sssssssssssssssssssVideoCutActivity", "Activity进入后台，暂停视频播放");
        VideoView videoView = this.t;
        if (videoView != null && videoView.isPlaying()) {
            this.t.pause();
        }
        Timer timer = this.m;
        if (timer != null) {
            timer.cancel();
            this.m = null;
        }
        j33 j33Var = this.n;
        if (j33Var != null) {
            j33Var.cancel();
            this.n = null;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        Log.d("sssssssssssssssssssVideoCutActivity", "Activity回到前台，恢复视频播放");
        if (this.m == null) {
            this.m = new Timer();
            j33 j33Var = new j33(this);
            this.n = j33Var;
            this.m.schedule(j33Var, 0L, 100L);
        }
        VideoView videoView = this.t;
        if (videoView == null || videoView.isPlaying()) {
            return;
        }
        try {
            VideoInfo videoInfo = this.c;
            if (videoInfo != null) {
                String strB = videoInfo.b();
                Uri uriC = this.c.c();
                if (uriC == null || !uriC.toString().startsWith("content://")) {
                    this.t.setVideoPath(strB);
                } else {
                    this.t.setVideoURI(uriC);
                }
                this.t.seekTo((int) this.j);
                this.t.start();
                Log.d("sssssssssssssssssssVideoCutActivity", "视频已恢复播放，位置: " + this.j + "ms");
            }
        } catch (Exception e2) {
            Log.e("sssssssssssssssssssVideoCutActivity", "恢复视频播放失败", e2);
        }
    }
}
