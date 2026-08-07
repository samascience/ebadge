package com.luck.picture.lib;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import com.jieli.jl_rcsp.constant.WatchConstant;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.style.PictureCropParameterStyle;
import com.tencent.connect.common.Constants;
import com.yalantis.ucrop.b;
import defpackage.a22;
import defpackage.db3;
import defpackage.ew1;
import defpackage.g5;
import defpackage.gi1;
import defpackage.ol2;
import defpackage.p33;
import defpackage.q30;
import defpackage.qh1;
import defpackage.s11;
import defpackage.s12;
import defpackage.si;
import defpackage.t73;
import defpackage.vt;
import defpackage.wz1;
import defpackage.y02;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class PictureSelectorCameraEmptyActivity extends PictureBaseActivity {
    private void i() {
        if (wz1.a(this, "android.permission.CAMERA")) {
            q0();
        } else {
            wz1.d(this, new String[]{"android.permission.CAMERA"}, 2);
        }
    }

    private void m0(LocalMedia localMedia) {
        boolean zM = a22.m(localMedia.n());
        PictureSelectionConfig pictureSelectionConfig = this.a;
        if (pictureSelectionConfig.o0 && !pictureSelectionConfig.L0 && zM) {
            String str = pictureSelectionConfig.Z0;
            pictureSelectionConfig.Y0 = str;
            t73.b(this, str, localMedia.n(), localMedia.u(), localMedia.l());
        } else if (pictureSelectionConfig.b0 && zM) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(localMedia);
            H(arrayList);
        } else {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(localMedia);
            b0(arrayList2);
        }
    }

    private void o0() {
        Window window = getWindow();
        window.setGravity(51);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.x = 0;
        attributes.y = 0;
        attributes.height = 1;
        attributes.width = 1;
        window.setAttributes(attributes);
    }

    private void q0() {
        int i = this.a.a;
        if (i == 0 || i == 1) {
            j0();
        } else if (i == 2) {
            k0();
        } else {
            if (i != 3) {
                return;
            }
            i0();
        }
    }

    @Override // com.luck.picture.lib.PictureBaseActivity
    public int P() {
        return R$layout.picture_empty;
    }

    @Override // com.luck.picture.lib.PictureBaseActivity
    public void R() {
        int i = R$color.picture_color_transparent;
        s11.a(this, q30.c(this, i), q30.c(this, i), this.b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n0(Intent intent) {
        String strB;
        int iF;
        try {
            if (this.a.a == a22.t()) {
                this.a.a1 = a22.t();
                this.a.Z0 = M(intent);
                if (TextUtils.isEmpty(this.a.Z0)) {
                    return;
                }
                if (ol2.b()) {
                    try {
                        Uri uriC = vt.c(N(), TextUtils.isEmpty(this.a.k) ? this.a.e : this.a.k);
                        if (uriC != null) {
                            s12.v(y02.a(this, Uri.parse(this.a.Z0)), y02.b(this, uriC));
                            this.a.Z0 = uriC.toString();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            if (TextUtils.isEmpty(this.a.Z0)) {
                return;
            }
            LocalMedia localMedia = new LocalMedia();
            if (a22.h(this.a.Z0)) {
                String strL = s12.l(N(), Uri.parse(this.a.Z0));
                File file = new File(strL);
                strB = a22.b(strL, this.a.a1);
                localMedia.q0(file.length());
                localMedia.Y(file.getName());
                if (a22.m(strB)) {
                    qh1 qh1VarG = gi1.g(N(), this.a.Z0);
                    localMedia.r0(qh1VarG.c());
                    localMedia.Z(qh1VarG.b());
                } else if (a22.n(strB)) {
                    qh1 qh1VarH = gi1.h(N(), this.a.Z0);
                    localMedia.r0(qh1VarH.c());
                    localMedia.Z(qh1VarH.b());
                    localMedia.W(qh1VarH.a());
                } else if (a22.k(strB)) {
                    localMedia.W(gi1.d(N(), this.a.Z0).a());
                }
                int iLastIndexOf = TextUtils.isEmpty(this.a.Z0) ? 0 : this.a.Z0.lastIndexOf(WatchConstant.FAT_FS_ROOT) + 1;
                localMedia.b0(iLastIndexOf > 0 ? db3.c(this.a.Z0.substring(iLastIndexOf)) : System.currentTimeMillis());
                localMedia.p0(strL);
                String stringExtra = intent != null ? intent.getStringExtra("mediaPath") : null;
                localMedia.H(a22.h(stringExtra) ? null : stringExtra);
                localMedia.I(g5.a(N(), file, Constants.STR_EMPTY));
                localMedia.U(file.lastModified() / 1000);
            } else {
                File file2 = new File(this.a.Z0);
                PictureSelectionConfig pictureSelectionConfig = this.a;
                strB = a22.b(pictureSelectionConfig.Z0, pictureSelectionConfig.a1);
                localMedia.q0(file2.length());
                localMedia.Y(file2.getName());
                if (a22.m(strB)) {
                    Context contextN = N();
                    PictureSelectionConfig pictureSelectionConfig2 = this.a;
                    si.d(contextN, pictureSelectionConfig2.j1, pictureSelectionConfig2.Z0);
                    qh1 qh1VarG2 = gi1.g(N(), this.a.Z0);
                    localMedia.r0(qh1VarG2.c());
                    localMedia.Z(qh1VarG2.b());
                } else if (a22.n(strB)) {
                    qh1 qh1VarH2 = gi1.h(N(), this.a.Z0);
                    localMedia.r0(qh1VarH2.c());
                    localMedia.Z(qh1VarH2.b());
                    localMedia.W(qh1VarH2.a());
                } else if (a22.k(strB)) {
                    localMedia.W(gi1.d(N(), this.a.Z0).a());
                }
                localMedia.b0(System.currentTimeMillis());
                localMedia.p0(this.a.Z0);
                String stringExtra2 = intent != null ? intent.getStringExtra("mediaPath") : null;
                if (ol2.a()) {
                    if (TextUtils.isEmpty(stringExtra2) || a22.h(stringExtra2)) {
                        localMedia.H(this.a.Z0);
                    } else {
                        localMedia.H(stringExtra2);
                    }
                }
                localMedia.I(g5.a(N(), file2, this.a.W0));
                localMedia.U(file2.lastModified() / 1000);
            }
            localMedia.n0(this.a.Z0);
            localMedia.d0(strB);
            PictureSelectionConfig pictureSelectionConfig3 = this.a;
            localMedia.l0(g5.b(pictureSelectionConfig3.Z0, strB, pictureSelectionConfig3.W0));
            localMedia.K(this.a.a);
            m0(localMedia);
            if (ol2.a()) {
                if (a22.n(localMedia.n()) && a22.h(this.a.Z0)) {
                    if (this.a.t1) {
                        new a(N(), localMedia.s());
                        return;
                    } else {
                        sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(new File(localMedia.s()))));
                        return;
                    }
                }
                return;
            }
            if (this.a.t1) {
                new a(N(), this.a.Z0);
            } else {
                sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(new File(this.a.Z0))));
            }
            if (!a22.m(localMedia.n()) || (iF = gi1.f(N())) == -1) {
                return;
            }
            gi1.k(N(), iF);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        Throwable th;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 69) {
                p0(intent);
                return;
            } else {
                if (i != 909) {
                    return;
                }
                n0(intent);
                return;
            }
        }
        if (i2 != 0) {
            if (i2 != 96 || intent == null || (th = (Throwable) intent.getSerializableExtra("com.yalantis.ucrop.Error")) == null) {
                return;
            }
            p33.b(N(), th.getMessage());
            return;
        }
        ew1 ew1Var = PictureSelectionConfig.x1;
        if (ew1Var != null) {
            ew1Var.onCancel();
        }
        if (i == 909) {
            gi1.b(this, this.a.Z0);
        }
        L();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (ol2.a()) {
            finishAfterTransition();
        } else {
            super.onBackPressed();
        }
        L();
    }

    @Override // com.luck.picture.lib.PictureBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        PictureSelectionConfig pictureSelectionConfig = this.a;
        if (pictureSelectionConfig == null) {
            L();
            return;
        }
        if (pictureSelectionConfig.Z) {
            return;
        }
        o0();
        if (bundle == null) {
            Log.i("PictureSelectorCamera", "=== 系统相机模式 ===");
            Log.i("PictureSelectorCamera", "使用沙盒目录保存照片，不需要存储权限");
            PictureCropParameterStyle pictureCropParameterStyle = PictureSelectionConfig.u1;
            Log.i("PictureSelectorCamera", "使用系统相机，调用拍照");
            i();
        }
    }

    @Override // com.luck.picture.lib.PictureBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        Log.i("PictureSelectorCamera", "=== 权限请求结果 ===");
        Log.i("PictureSelectorCamera", "requestCode: " + i);
        Log.i("PictureSelectorCamera", "permissions: " + Arrays.toString(strArr));
        Log.i("PictureSelectorCamera", "grantResults: " + Arrays.toString(iArr));
        if (i == 1) {
            Log.w("PictureSelectorCamera", "收到存储权限请求结果，但已不再需要存储权限（使用沙盒目录）");
            PictureCropParameterStyle pictureCropParameterStyle = PictureSelectionConfig.u1;
            Log.i("PictureSelectorCamera", "直接调用拍照");
            i();
            return;
        }
        if (i != 2) {
            return;
        }
        Log.i("PictureSelectorCamera", "相机权限请求结果");
        if (iArr.length > 0 && iArr[0] == 0) {
            Log.i("PictureSelectorCamera", "相机权限已授予，调用拍照");
            i();
        } else {
            Log.w("PictureSelectorCamera", "相机权限被拒绝");
            L();
            p33.b(N(), getString(R$string.picture_camera));
        }
    }

    protected void p0(Intent intent) {
        if (intent == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Uri uriD = b.d(intent);
        if (uriD == null) {
            return;
        }
        String path = uriD.getPath();
        boolean zIsEmpty = TextUtils.isEmpty(path);
        PictureSelectionConfig pictureSelectionConfig = this.a;
        LocalMedia localMediaG = LocalMedia.G(pictureSelectionConfig.Z0, pictureSelectionConfig.f0 ? 1 : 0, pictureSelectionConfig.a);
        if (ol2.a()) {
            int iLastIndexOf = TextUtils.isEmpty(this.a.Z0) ? 0 : this.a.Z0.lastIndexOf(WatchConstant.FAT_FS_ROOT) + 1;
            localMediaG.b0(iLastIndexOf > 0 ? db3.c(this.a.Z0.substring(iLastIndexOf)) : System.currentTimeMillis());
            localMediaG.H(path);
        } else {
            localMediaG.b0(System.currentTimeMillis());
        }
        localMediaG.S(!zIsEmpty);
        localMediaG.T(path);
        localMediaG.d0(a22.a(path));
        localMediaG.O(intent.getIntExtra("com.yalantis.ucrop.ImageWidth", 0));
        localMediaG.N(intent.getIntExtra("com.yalantis.ucrop.ImageHeight", 0));
        localMediaG.P(intent.getIntExtra("com.yalantis.ucrop.OffsetX", 0));
        localMediaG.Q(intent.getIntExtra("com.yalantis.ucrop.OffsetY", 0));
        localMediaG.R(intent.getFloatExtra("com.yalantis.ucrop.CropAspectRatio", 0.0f));
        localMediaG.X(intent.getBooleanExtra("com.yalantis.ucrop.EditorImage", false));
        if (a22.h(localMediaG.q())) {
            localMediaG.p0(s12.l(N(), Uri.parse(localMediaG.q())));
            if (a22.n(localMediaG.n())) {
                qh1 qh1VarH = gi1.h(N(), localMediaG.q());
                localMediaG.r0(qh1VarH.c());
                localMediaG.Z(qh1VarH.b());
            } else if (a22.m(localMediaG.n())) {
                qh1 qh1VarG = gi1.g(N(), localMediaG.q());
                localMediaG.r0(qh1VarG.c());
                localMediaG.Z(qh1VarG.b());
            }
        } else {
            localMediaG.p0(localMediaG.q());
            if (a22.n(localMediaG.n())) {
                qh1 qh1VarH2 = gi1.h(N(), localMediaG.q());
                localMediaG.r0(qh1VarH2.c());
                localMediaG.Z(qh1VarH2.b());
            } else if (a22.m(localMediaG.n())) {
                qh1 qh1VarG2 = gi1.g(N(), localMediaG.q());
                localMediaG.r0(qh1VarG2.c());
                localMediaG.Z(qh1VarG2.b());
            }
        }
        File file = new File(localMediaG.s());
        localMediaG.q0(file.length());
        localMediaG.Y(file.getName());
        arrayList.add(localMediaG);
        Q(arrayList);
    }
}
