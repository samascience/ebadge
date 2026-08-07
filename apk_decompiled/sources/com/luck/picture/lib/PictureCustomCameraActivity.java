package com.luck.picture.lib;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.luck.picture.lib.camera.CustomCameraView;
import com.luck.picture.lib.camera.view.CaptureLayout;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.style.PictureCropParameterStyle;
import defpackage.a22;
import defpackage.d12;
import defpackage.du;
import defpackage.ew1;
import defpackage.gy;
import defpackage.k01;
import defpackage.mz0;
import defpackage.wz1;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class PictureCustomCameraActivity extends PictureSelectorCameraEmptyActivity {
    private static final String p = "PictureCustomCameraActivity";
    private CustomCameraView n;
    protected boolean o;

    class a implements du {
        a() {
        }

        @Override // defpackage.du
        public void a(int i, String str, Throwable th) {
            Log.i(PictureCustomCameraActivity.p, "onError: " + str);
        }

        @Override // defpackage.du
        public void b(String str) {
            PictureCustomCameraActivity.this.a.a1 = a22.w();
            Intent intent = new Intent();
            intent.putExtra("mediaPath", str);
            intent.putExtra("PictureSelectorConfig", PictureCustomCameraActivity.this.a);
            PictureCustomCameraActivity pictureCustomCameraActivity = PictureCustomCameraActivity.this;
            if (pictureCustomCameraActivity.a.b) {
                pictureCustomCameraActivity.n0(intent);
            } else {
                pictureCustomCameraActivity.setResult(-1, intent);
                PictureCustomCameraActivity.this.onBackPressed();
            }
        }

        @Override // defpackage.du
        public void c(String str) {
            PictureCustomCameraActivity.this.a.a1 = a22.y();
            Intent intent = new Intent();
            intent.putExtra("mediaPath", str);
            intent.putExtra("PictureSelectorConfig", PictureCustomCameraActivity.this.a);
            PictureCustomCameraActivity pictureCustomCameraActivity = PictureCustomCameraActivity.this;
            if (pictureCustomCameraActivity.a.b) {
                pictureCustomCameraActivity.n0(intent);
            } else {
                pictureCustomCameraActivity.setResult(-1, intent);
                PictureCustomCameraActivity.this.onBackPressed();
            }
        }
    }

    class b implements gy {
        b() {
        }

        @Override // defpackage.gy
        public void a() {
            PictureCustomCameraActivity.this.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v0(String str, ImageView imageView) {
        k01 k01Var;
        if (this.a == null || (k01Var = PictureSelectionConfig.w1) == null) {
            return;
        }
        k01Var.c(N(), str, imageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w0(d12 d12Var, View view) {
        if (!isFinishing()) {
            d12Var.dismiss();
        }
        ew1 ew1Var = PictureSelectionConfig.x1;
        if (ew1Var != null) {
            ew1Var.onCancel();
        }
        L();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x0(d12 d12Var, View view) {
        if (!isFinishing()) {
            d12Var.dismiss();
        }
        wz1.c(N());
        this.o = true;
    }

    private void y0() {
        Log.i("PictureCustomCamera", "=== 开始请求相机权限 ===");
        Log.i("PictureCustomCamera", "使用沙盒目录保存照片，不需要存储权限");
        if (!wz1.a(this, "android.permission.CAMERA")) {
            Log.i("PictureCustomCamera", "相机权限未授予，请求相机权限");
            wz1.d(this, new String[]{"android.permission.CAMERA"}, 2);
            return;
        }
        Log.i("PictureCustomCamera", "相机权限已授予");
        if (this.a.f298q == 257) {
            Log.i("PictureCustomCamera", "仅拍照模式，初始化相机");
            this.n.O();
        } else if (wz1.a(this, "android.permission.RECORD_AUDIO")) {
            Log.i("PictureCustomCamera", "录音权限已授予，初始化相机");
            this.n.O();
        } else {
            Log.i("PictureCustomCamera", "录音权限未授予，请求录音权限");
            wz1.d(this, new String[]{"android.permission.RECORD_AUDIO"}, 4);
        }
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
        this.n.setImageCallbackListener(new mz0() { // from class: c12
            @Override // defpackage.mz0
            public final void a(String str, ImageView imageView) {
                this.a.v0(str, imageView);
            }
        });
        this.n.setCameraListener(new a());
        this.n.setOnClickListener(new b());
    }

    @Override // com.luck.picture.lib.PictureBaseActivity, android.app.Activity
    public boolean isImmersive() {
        return false;
    }

    @Override // com.luck.picture.lib.PictureSelectorCameraEmptyActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        ew1 ew1Var;
        PictureSelectionConfig pictureSelectionConfig = this.a;
        if (pictureSelectionConfig != null && pictureSelectionConfig.b && (ew1Var = PictureSelectionConfig.x1) != null) {
            ew1Var.onCancel();
        }
        L();
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
        super.onCreate(bundle);
        setContentView(R$layout.picture_custom_camera);
        this.n = (CustomCameraView) findViewById(R$id.cameraView);
        initView();
        y0();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.n.V();
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.luck.picture.lib.PictureSelectorCameraEmptyActivity, com.luck.picture.lib.PictureBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Log.i("PictureCustomCamera", "=== 权限请求结果 ===");
        Log.i("PictureCustomCamera", "requestCode: " + i);
        Log.i("PictureCustomCamera", "permissions: " + Arrays.toString(strArr));
        Log.i("PictureCustomCamera", "grantResults: " + Arrays.toString(iArr));
        if (i == 1) {
            Log.w("PictureCustomCamera", "收到存储权限请求结果，但已不再需要存储权限（使用沙盒目录）");
            if (!wz1.a(this, "android.permission.CAMERA")) {
                wz1.d(this, new String[]{"android.permission.CAMERA"}, 2);
                return;
            }
            Log.i("PictureCustomCamera", "相机权限已授予，初始化相机");
            if (this.a.f298q == 257) {
                this.n.O();
                return;
            } else if (wz1.a(this, "android.permission.RECORD_AUDIO")) {
                this.n.O();
                return;
            } else {
                wz1.d(this, new String[]{"android.permission.RECORD_AUDIO"}, 4);
                return;
            }
        }
        if (i != 2) {
            if (i != 4) {
                return;
            }
            if (iArr.length <= 0 || iArr[0] != 0) {
                z0(false, new String[]{"android.permission.RECORD_AUDIO"}, getString(R$string.picture_audio));
                return;
            } else {
                this.n.O();
                return;
            }
        }
        if (iArr.length <= 0 || iArr[0] != 0) {
            z0(true, new String[]{"android.permission.CAMERA"}, getString(R$string.picture_camera));
        } else if (wz1.a(this, "android.permission.RECORD_AUDIO")) {
            this.n.O();
        } else {
            wz1.d(this, new String[]{"android.permission.RECORD_AUDIO"}, 4);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.o) {
            String str = Build.VERSION.SDK_INT >= 33 ? "android.permission.READ_MEDIA_IMAGES" : "android.permission.READ_EXTERNAL_STORAGE";
            if (!wz1.a(this, str)) {
                z0(false, new String[]{str}, getString(R$string.picture_jurisdiction));
            } else if (!wz1.a(this, "android.permission.CAMERA")) {
                z0(false, new String[]{"android.permission.CAMERA"}, getString(R$string.picture_camera));
            } else if (this.a.f298q == 257 || wz1.a(this, "android.permission.RECORD_AUDIO")) {
                this.n.O();
            } else {
                wz1.d(this, new String[]{"android.permission.RECORD_AUDIO"}, 4);
            }
            this.o = false;
        }
    }

    protected void z0(boolean z, String[] strArr, String str) {
        if (isFinishing()) {
            return;
        }
        PictureCropParameterStyle pictureCropParameterStyle = PictureSelectionConfig.u1;
        final d12 d12Var = new d12(N(), R$layout.picture_wind_base_dialog);
        d12Var.setCancelable(false);
        d12Var.setCanceledOnTouchOutside(false);
        Button button = (Button) d12Var.findViewById(R$id.btn_cancel);
        Button button2 = (Button) d12Var.findViewById(R$id.btn_commit);
        button2.setText(getString(R$string.picture_go_setting));
        TextView textView = (TextView) d12Var.findViewById(R$id.tvTitle);
        TextView textView2 = (TextView) d12Var.findViewById(R$id.tv_content);
        textView.setText(getString(R$string.picture_prompt));
        textView2.setText(str);
        button.setOnClickListener(new View.OnClickListener() { // from class: a12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.w0(d12Var, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: b12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.x0(d12Var, view);
            }
        });
        d12Var.show();
    }
}
