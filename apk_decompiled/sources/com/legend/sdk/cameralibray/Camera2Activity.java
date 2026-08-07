package com.legend.sdk.cameralibray;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.camera.core.m;
import cn.bertsir.zbar.Qr.Config;
import com.legend.mywatch.sdk.mywatchsdklib.android.enm.DeviceControlAppEnum;
import com.luck.picture.lib.PictureBaseActivity;
import com.luck.picture.lib.PictureSelectorCameraEmptyActivity;
import com.luck.picture.lib.camera.view.CaptureLayout;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.style.PictureCropParameterStyle;
import com.tencent.connect.common.Constants;
import defpackage.a22;
import defpackage.az2;
import defpackage.b62;
import defpackage.cu;
import defpackage.d12;
import defpackage.du;
import defpackage.e20;
import defpackage.ei0;
import defpackage.ew1;
import defpackage.ez;
import defpackage.gy;
import defpackage.k01;
import defpackage.mz0;
import defpackage.ng;
import defpackage.p52;
import defpackage.qm2;
import defpackage.rq;
import defpackage.v22;
import defpackage.wz1;
import defpackage.x90;
import defpackage.yc1;
import defpackage.zi2;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: loaded from: classes3.dex */
public class Camera2Activity extends PictureSelectorCameraEmptyActivity {
    private static final String F = "Camera2Activity";
    private MyCameraView n;
    protected boolean o;
    private boolean p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private b62 f287q;
    private Handler s;
    private Runnable u;
    private long v;
    private boolean w;
    private Runnable x;
    private boolean y;
    private int z;
    private boolean r = false;
    private boolean t = false;

    class a implements p52 {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void i(int i, String str) {
            if (i == 1001) {
                Log.w(Camera2Activity.F, "实时预览错误: " + str);
                return;
            }
            Log.d(Camera2Activity.F, "实时预览错误: " + str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void j() {
            Log.d(Camera2Activity.F, "实时预览已开始");
            Camera2Activity.this.w = true;
            Camera2Activity.this.v = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void k() {
            if (!Camera2Activity.this.k1()) {
                Camera2Activity.this.u = null;
                return;
            }
            Log.d(Camera2Activity.F, "设备结束预览会话，退出相机页面");
            Camera2Activity.this.p = true;
            Camera2Activity.this.u = null;
            Camera2Activity.this.finish();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void l() {
            Log.d(Camera2Activity.F, "实时预览已停止");
            if (Camera2Activity.this.u != null) {
                Camera2Activity.this.s.removeCallbacks(Camera2Activity.this.u);
            }
            Camera2Activity.this.u = new Runnable() { // from class: com.legend.sdk.cameralibray.c
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.k();
                }
            };
            Camera2Activity.this.s.postDelayed(Camera2Activity.this.u, 800L);
        }

        @Override // defpackage.p52
        public void a(int i, int i2, int i3, int i4, byte[] bArr, double d) {
        }

        @Override // defpackage.p52
        public void b() {
            Camera2Activity.this.s.post(new Runnable() { // from class: com.legend.sdk.cameralibray.d
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.j();
                }
            });
        }

        @Override // defpackage.p52
        public void c(int i) {
        }

        @Override // defpackage.p52
        public void d() {
            Camera2Activity.this.s.post(new Runnable() { // from class: com.legend.sdk.cameralibray.b
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.l();
                }
            });
        }

        @Override // defpackage.p52
        public void onError(final int i, final String str) {
            Camera2Activity.this.s.post(new Runnable() { // from class: com.legend.sdk.cameralibray.a
                @Override // java.lang.Runnable
                public final void run() {
                    Camera2Activity.a.i(i, str);
                }
            });
        }
    }

    class b implements du {
        b() {
        }

        @Override // defpackage.du
        public void a(int i, String str, Throwable th) {
            Log.i(Camera2Activity.F, "onError: " + str);
        }

        @Override // defpackage.du
        public void b(String str) {
            ((PictureBaseActivity) Camera2Activity.this).a.a1 = a22.w();
            Intent intent = new Intent();
            intent.putExtra("mediaPath", str);
            intent.putExtra("PictureSelectorConfig", ((PictureBaseActivity) Camera2Activity.this).a);
            Camera2Activity.this.n0(intent);
        }

        @Override // defpackage.du
        public void c(String str) {
            ((PictureBaseActivity) Camera2Activity.this).a.a1 = a22.y();
            Intent intent = new Intent();
            intent.putExtra("mediaPath", str);
            intent.putExtra("PictureSelectorConfig", ((PictureBaseActivity) Camera2Activity.this).a);
            if (((PictureBaseActivity) Camera2Activity.this).a.b) {
                Camera2Activity.this.n0(intent);
            } else {
                Camera2Activity.this.setResult(-1, intent);
                Camera2Activity.this.onBackPressed();
            }
        }
    }

    class c implements gy {
        c() {
        }

        @Override // defpackage.gy
        public void a() {
            Camera2Activity.this.onBackPressed();
        }
    }

    static /* synthetic */ class d {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[DeviceControlAppEnum.values().length];
            a = iArr;
            try {
                iArr[DeviceControlAppEnum.TAKE_PHOTO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[DeviceControlAppEnum.EXIT_REMOTE_CAMERA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private void S0() {
        Runnable runnable = this.u;
        if (runnable != null) {
            this.s.removeCallbacks(runnable);
            this.u = null;
        }
    }

    private void T0() {
        Runnable runnable = this.x;
        if (runnable != null) {
            this.s.removeCallbacks(runnable);
            this.x = null;
        }
    }

    private String U0(String str) {
        if (str == null || str.isEmpty()) {
            return Constants.STR_EMPTY;
        }
        int iLastIndexOf = str.lastIndexOf(47);
        if (iLastIndexOf >= 0 && iLastIndexOf < str.length() - 1) {
            str = str.substring(iLastIndexOf + 1);
        }
        int iLastIndexOf2 = str.lastIndexOf(46);
        if (iLastIndexOf2 <= 0) {
            return str;
        }
        String strSubstring = str.substring(0, iLastIndexOf2);
        String strSubstring2 = str.substring(iLastIndexOf2);
        int iLastIndexOf3 = strSubstring.lastIndexOf(95);
        if (iLastIndexOf3 <= 0 || iLastIndexOf3 >= strSubstring.length() - 1 || !strSubstring.substring(iLastIndexOf3 + 1).matches("\\d+")) {
            return str;
        }
        return strSubstring.substring(0, iLastIndexOf3) + strSubstring2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V0(String str, ImageView imageView) {
        k01 k01Var;
        if (this.a == null || (k01Var = PictureSelectionConfig.w1) == null) {
            return;
        }
        k01Var.c(N(), str, imageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W0() {
        m imageAnalysis = this.n.getImageAnalysis();
        if (imageAnalysis == null || !this.f287q.y()) {
            return;
        }
        this.f287q.E(imageAnalysis);
        Log.d(F, "相机切换后，已更新ImageAnalysis引用");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X0() {
        if (!this.r || this.f287q == null) {
            return;
        }
        Log.d(F, "相机切换完成，重新设置实时预览");
        this.s.postDelayed(new Runnable() { // from class: xq
            @Override // java.lang.Runnable
            public final void run() {
                this.a.W0();
            }
        }, 150L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z0() {
        m imageAnalysis = this.n.getImageAnalysis();
        if (imageAnalysis == null || !this.t) {
            return;
        }
        if (this.f287q.y()) {
            Log.d(F, "延迟恢复实时预览（设备已主动发送START响应）");
            this.f287q.E(imageAnalysis);
        } else {
            Log.d(F, "延迟恢复实时预览");
            this.f287q.H(imageAnalysis);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c1() {
        this.x = null;
        if (this.f287q == null || !cu.d()) {
            return;
        }
        yc1.a(F, "实时预览暂停");
        this.f287q.D();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d1(d12 d12Var, View view) {
        if (!isFinishing()) {
            d12Var.dismiss();
        }
        wz1.c(N());
        this.o = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e1(d12 d12Var, View view) {
        if (!isFinishing()) {
            d12Var.dismiss();
        }
        ew1 ew1Var = PictureSelectionConfig.x1;
        if (ew1Var != null) {
            ew1Var.onCancel();
        }
        L();
    }

    private List g1(List list) {
        String str = F;
        StringBuilder sb = new StringBuilder();
        sb.append("removeDuplicates: 开始去重，输入数量=");
        sb.append(list != null ? list.size() : 0);
        Log.d(str, sb.toString());
        if (ez.a(list)) {
            Log.d(str, "removeDuplicates: 输入列表为空，直接返回");
            return list;
        }
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (int i = 0; i < list.size(); i++) {
            LocalMedia localMedia = (LocalMedia) list.get(i);
            if (localMedia == null) {
                Log.d(F, "removeDuplicates: 图片[" + i + "] 为 null，跳过");
            } else {
                String strQ = localMedia.q();
                String strS = (strQ == null || strQ.isEmpty()) ? localMedia.s() : strQ;
                String str2 = F;
                Log.d(str2, "removeDuplicates: 图片[" + i + "] path=" + strQ + ", realPath=" + localMedia.s() + ", 最终使用路径=" + strS);
                if (strS == null || strS.isEmpty()) {
                    Log.d(str2, "removeDuplicates: 图片[" + i + "] 路径为空，跳过");
                } else {
                    String strU0 = U0(strS);
                    Log.d(str2, "removeDuplicates: 图片[" + i + "] 基础文件名=" + strU0);
                    boolean zContains = hashSet.contains(strS);
                    boolean zContains2 = hashSet2.contains(strU0);
                    if (zContains) {
                        Log.d(str2, "removeDuplicates: 图片[" + i + "] 路径重复，跳过: " + strS);
                    } else if (zContains2) {
                        Log.d(str2, "removeDuplicates: 图片[" + i + "] 文件名模式重复（可能是同一张图片的副本），跳过: " + strS);
                    } else {
                        hashSet.add(strS);
                        hashSet2.add(strU0);
                        arrayList.add(localMedia);
                        Log.d(str2, "removeDuplicates: 图片[" + i + "] 添加到唯一列表: " + strS);
                    }
                }
            }
        }
        Log.d(F, "removeDuplicates: 去重完成，输出数量=" + arrayList.size() + ", 路径集合大小=" + hashSet.size());
        return arrayList;
    }

    private void h1() {
        if (!wz1.a(this, "android.permission.CAMERA")) {
            wz1.d(this, new String[]{"android.permission.CAMERA"}, 2);
            return;
        }
        this.n.R();
        if (this.r) {
            this.s.postDelayed(new Runnable() { // from class: uq
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.b1();
                }
            }, 300L);
        }
    }

    private void i1() {
        Runnable runnable = this.x;
        if (runnable != null) {
            this.s.removeCallbacks(runnable);
        }
        Runnable runnable2 = new Runnable() { // from class: tq
            @Override // java.lang.Runnable
            public final void run() {
                this.a.c1();
            }
        };
        this.x = runnable2;
        this.s.postDelayed(runnable2, 2000L);
    }

    private void j1() {
        b62 b62Var = this.f287q;
        if (b62Var == null) {
            return;
        }
        b62Var.F(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean k1() {
        b62 b62Var;
        return (isFinishing() || (b62Var = this.f287q) == null || b62Var.y() || this.t || System.currentTimeMillis() < this.v) ? false : true;
    }

    private void m1() {
        this.v = System.currentTimeMillis() + 3500;
        S0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: n1, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public void f1() {
        if (!this.r || this.f287q == null) {
            Log.d(F, "tryAutoStartRealtimePreview: 实时预览不支持或PreviewManager未初始化");
            return;
        }
        if (e20.d != 1 || !zi2.i()) {
            Log.d(F, "tryAutoStartRealtimePreview: 蓝牙未连接，跳过自动启动实时预览");
            return;
        }
        m imageAnalysis = this.n.getImageAnalysis();
        if (imageAnalysis == null) {
            Log.d(F, "tryAutoStartRealtimePreview: ImageAnalysis实例未获取到，延迟200ms后重试");
            this.s.postDelayed(new Runnable() { // from class: oq
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.f1();
                }
            }, 200L);
            return;
        }
        boolean zY = this.f287q.y();
        String str = F;
        Log.d(str, "tryAutoStartRealtimePreview: 检查预览状态, isPreviewing=" + zY);
        if (zY) {
            Log.d(str, "tryAutoStartRealtimePreview: 设备已主动发送START响应，调用setImageAnalysisAndStart()");
            this.f287q.E(imageAnalysis);
        } else {
            Log.d(str, "tryAutoStartRealtimePreview: App主动启动，调用startPreview()发送START指令");
            this.f287q.H(imageAnalysis);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o1() {
        if (this.y) {
            if (wz1.a(this, "android.permission.CAMERA")) {
                MyCameraView myCameraView = this.n;
                if (myCameraView == null) {
                    return;
                }
                this.y = false;
                this.z = 0;
                myCameraView.h0();
                return;
            }
            int i = this.z + 1;
            this.z = i;
            if (i <= 20) {
                this.s.postDelayed(new rq(this), 300L);
            } else {
                this.y = false;
                this.z = 0;
            }
        }
    }

    @Override // com.luck.picture.lib.PictureBaseActivity
    protected void L() {
    }

    protected void initView() {
        int i = this.a.J;
        if (i > 0) {
            this.n.setRecordVideoMaxTime(i);
        }
        int i2 = this.a.K;
        if (i2 > 0) {
            this.n.setRecordVideoMinTime(i2);
        }
        this.n.setCaptureLoadingColor(this.a.r);
        CaptureLayout captureLayout = this.n.getCaptureLayout();
        if (captureLayout != null) {
            captureLayout.setButtonFeatures(this.a.f298q);
        }
        this.n.setImageCallbackListener(new mz0() { // from class: nq
            @Override // defpackage.mz0
            public final void a(String str, ImageView imageView) {
                this.a.V0(str, imageView);
            }
        });
        this.n.setCameraListener(new b());
        this.n.setOnClickListener(new c());
    }

    @Override // com.luck.picture.lib.PictureBaseActivity, android.app.Activity
    public boolean isImmersive() {
        return false;
    }

    @Override // com.luck.picture.lib.PictureBaseActivity
    protected void j0() {
    }

    protected void l1(boolean z, String[] strArr, String str) {
        if (isFinishing()) {
            return;
        }
        PictureCropParameterStyle pictureCropParameterStyle = PictureSelectionConfig.u1;
        final d12 d12Var = new d12(N(), com.luck.picture.lib.R$layout.picture_wind_base_dialog);
        d12Var.setCancelable(false);
        d12Var.setCanceledOnTouchOutside(false);
        Button button = (Button) d12Var.findViewById(com.luck.picture.lib.R$id.btn_cancel);
        Button button2 = (Button) d12Var.findViewById(com.luck.picture.lib.R$id.btn_commit);
        button2.setText(getString(com.luck.picture.lib.R$string.picture_go_setting));
        TextView textView = (TextView) d12Var.findViewById(com.luck.picture.lib.R$id.tvTitle);
        TextView textView2 = (TextView) d12Var.findViewById(com.luck.picture.lib.R$id.tv_content);
        textView.setText(getString(com.luck.picture.lib.R$string.picture_prompt));
        textView2.setText(str);
        button.setOnClickListener(new View.OnClickListener() { // from class: vq
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.e1(d12Var, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: wq
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.d1(d12Var, view);
            }
        });
        d12Var.show();
    }

    @Override // com.luck.picture.lib.PictureSelectorCameraEmptyActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        List listG1;
        if (i == 188) {
            if (i2 != -1 || intent == null) {
                String str = F;
                StringBuilder sb = new StringBuilder();
                sb.append("onActivityResult: resultCode=");
                sb.append(i2);
                sb.append(", data=");
                sb.append(intent != null ? "not null" : "null");
                Log.d(str, sb.toString());
                return;
            }
            String str2 = F;
            Log.d(str2, "onActivityResult: 开始处理系统相册结果");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onActivityResult: data.getData()=");
            sb2.append(intent.getData() != null ? intent.getData().toString() : "null");
            Log.d(str2, sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append("onActivityResult: data.getClipData()=");
            sb3.append(intent.getClipData() != null ? "not null, count=" + intent.getClipData().getItemCount() : "null");
            Log.d(str2, sb3.toString());
            PictureSelectionConfig pictureSelectionConfigC = PictureSelectionConfig.c();
            if (pictureSelectionConfigC != null) {
                List listC = az2.c(this, intent, pictureSelectionConfigC);
                StringBuilder sb4 = new StringBuilder();
                sb4.append("onActivityResult: SystemAlbumResultHandler 返回结果数量=");
                sb4.append(listC != null ? listC.size() : 0);
                Log.d(str2, sb4.toString());
                if (listC != null && !listC.isEmpty()) {
                    for (int i3 = 0; i3 < listC.size(); i3++) {
                        LocalMedia localMedia = (LocalMedia) listC.get(i3);
                        Log.d(F, "onActivityResult: 图片[" + i3 + "] path=" + localMedia.q() + ", realPath=" + localMedia.s() + ", compressPath=" + localMedia.c() + ", cutPath=" + localMedia.i());
                    }
                }
                if (!ez.a(listC)) {
                    if (pictureSelectionConfigC.v != 1 || listC.size() <= 1) {
                        listG1 = g1(listC);
                    } else {
                        Log.d(F, "onActivityResult: 单选模式检测到多张图片(" + listC.size() + "张)，只取第一张");
                        listG1 = new ArrayList();
                        listG1.add((LocalMedia) listC.get(0));
                    }
                    String str3 = F;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("onActivityResult: 去重后结果数量=");
                    sb5.append(listG1 != null ? listG1.size() : 0);
                    Log.d(str3, sb5.toString());
                    if (listG1 != null && !listG1.isEmpty()) {
                        for (int i4 = 0; i4 < listG1.size(); i4++) {
                            LocalMedia localMedia2 = (LocalMedia) listG1.get(i4);
                            Log.d(F, "onActivityResult: 去重后图片[" + i4 + "] path=" + localMedia2.q() + ", realPath=" + localMedia2.s());
                        }
                    }
                    if (ez.a(listG1)) {
                        return;
                    }
                    Log.d(F, "onActivityResult: 调用预览，图片数量=" + listG1.size());
                    v22.a(this).b(0, listG1, 0);
                    return;
                }
            }
            String str4 = F;
            Log.d(str4, "onActivityResult: 回退到原有逻辑");
            List listE = v22.e(intent);
            StringBuilder sb6 = new StringBuilder();
            sb6.append("onActivityResult: PictureSelector.obtainMultipleResult 返回数量=");
            sb6.append(listE != null ? listE.size() : 0);
            Log.d(str4, sb6.toString());
            if (ez.a(listE)) {
                return;
            }
            List listG2 = g1(listE);
            StringBuilder sb7 = new StringBuilder();
            sb7.append("onActivityResult: 回退逻辑去重后数量=");
            sb7.append(listG2 != null ? listG2.size() : 0);
            Log.d(str4, sb7.toString());
            if (ez.a(listG2)) {
                return;
            }
            Log.d(str4, "onActivityResult: 调用预览，图片数量=" + listG2.size());
            v22.a(this).b(0, listG2, 0);
        }
    }

    @Override // com.luck.picture.lib.PictureSelectorCameraEmptyActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        ew1 ew1Var;
        super.onBackPressed();
        PictureSelectionConfig pictureSelectionConfig = this.a;
        if (pictureSelectionConfig != null && pictureSelectionConfig.b && (ew1Var = PictureSelectionConfig.x1) != null) {
            ew1Var.onCancel();
        }
        finish();
    }

    @Override // com.luck.picture.lib.PictureSelectorCameraEmptyActivity, com.luck.picture.lib.PictureBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        getWindow().setFlags(1024, 1024);
        getWindow().setFlags(67108864, 67108864);
        getWindow().setFlags(134217728, 134217728);
        if (Build.VERSION.SDK_INT >= 28) {
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            getWindow().setAttributes(attributes);
        }
        getWindow().addFlags(128);
        PictureSelectionConfig pictureSelectionConfigB = PictureSelectionConfig.b();
        this.a = pictureSelectionConfigB;
        pictureSelectionConfigB.Z = true;
        pictureSelectionConfigB.p = 1;
        pictureSelectionConfigB.f298q = Config.Y_DENSITY;
        pictureSelectionConfigB.n0 = true;
        pictureSelectionConfigB.V = -1;
        pictureSelectionConfigB.o0 = false;
        super.onCreate(bundle);
        setContentView(R$layout.my_picture_custom_camera);
        this.n = (MyCameraView) findViewById(R$id.cameraView);
        this.y = getIntent() != null && getIntent().getBooleanExtra("extra_remote_shutter_on_open", false);
        initView();
        this.s = new Handler(Looper.getMainLooper());
        MyCameraView myCameraView = this.n;
        if (myCameraView != null) {
            myCameraView.setOnCameraSwitchListener(new MyCameraView.j() { // from class: qq
                @Override // com.legend.sdk.cameralibray.MyCameraView.j
                public final void a() {
                    this.a.X0();
                }
            });
        }
        boolean zE = cu.e();
        this.r = zE;
        if (zE) {
            this.f287q = b62.t();
            j1();
            Log.d(F, "设备支持实时预览功能，已初始化PreviewManager");
        } else {
            Log.d(F, "设备不支持实时预览功能，跳过初始化");
        }
        h1();
        this.p = false;
        ei0.a(this);
        if (this.y) {
            this.s.postDelayed(new rq(this), 800L);
        }
    }

    @Override // com.luck.picture.lib.PictureBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        this.n.Q();
        ei0.b(this);
        T0();
        S0();
        if (this.r && this.f287q != null && this.w) {
            Log.d(F, "Activity销毁，停止实时预览");
            this.f287q.I();
        }
        this.t = false;
        this.v = 0L;
        this.w = false;
        super.onDestroy();
        if (this.p || e20.d != 1) {
            return;
        }
        e20.a.K(qm2.B(false), "关闭拍照功能");
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.n.d0();
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(ng ngVar) {
        if (ngVar instanceof x90) {
            int i = d.a[((x90) ngVar).a().ordinal()];
            if (i != 1) {
                if (i != 2) {
                    return;
                }
                yc1.a(F, "接收关闭拍照页面命令--");
                this.p = true;
                finish();
                return;
            }
            String str = F;
            yc1.a(str, "接收开启拍照页面命令--");
            MyCameraView myCameraView = this.n;
            if (myCameraView != null) {
                if (!this.r) {
                    myCameraView.h0();
                    return;
                }
                yc1.a(str, "实时预览");
                m1();
                i1();
                this.n.l0();
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        b62 b62Var;
        super.onPause();
        if (this.r && (b62Var = this.f287q) != null) {
            boolean zY = b62Var.y();
            this.t = zY;
            if (zY) {
                Log.d(F, "Activity暂停，记录预览状态（不停止预览）");
            }
        }
        S0();
    }

    @Override // com.luck.picture.lib.PictureSelectorCameraEmptyActivity, com.luck.picture.lib.PictureBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i != 2) {
            return;
        }
        if (iArr.length <= 0 || iArr[0] != 0) {
            l1(true, new String[]{"android.permission.CAMERA"}, getString(com.luck.picture.lib.R$string.picture_camera));
            return;
        }
        this.n.R();
        if (this.r) {
            this.s.postDelayed(new Runnable() { // from class: sq
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.Y0();
                }
            }, 300L);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.r && this.f287q != null && this.t) {
            if (e20.d == 1 && zi2.i()) {
                m imageAnalysis = this.n.getImageAnalysis();
                if (imageAnalysis == null) {
                    this.s.postDelayed(new Runnable() { // from class: mq
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.a.Z0();
                        }
                    }, 200L);
                } else if (this.f287q.y()) {
                    Log.d(F, "恢复实时预览（设备已主动发送START响应）");
                    this.f287q.E(imageAnalysis);
                } else {
                    Log.d(F, "恢复实时预览");
                    this.f287q.H(imageAnalysis);
                }
            } else {
                Log.d(F, "蓝牙未连接，无法恢复实时预览");
            }
            this.t = false;
        }
        if (this.o) {
            if (!wz1.a(this, "android.permission.CAMERA")) {
                l1(false, new String[]{"android.permission.CAMERA"}, getString(com.luck.picture.lib.R$string.picture_camera));
            } else if (this.a.f298q == 257) {
                this.n.R();
                if (this.r) {
                    this.s.postDelayed(new Runnable() { // from class: pq
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.a.a1();
                        }
                    }, 300L);
                }
            }
            this.o = false;
        }
    }
}
