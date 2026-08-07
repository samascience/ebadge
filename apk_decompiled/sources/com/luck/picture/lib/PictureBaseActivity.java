package com.luck.picture.lib;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.luck.picture.lib.PictureBaseActivity;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.entity.LocalMediaFolder;
import com.luck.picture.lib.style.PictureCropParameterStyle;
import com.luck.picture.lib.thread.PictureThreadUtils;
import com.tencent.connect.common.Constants;
import defpackage.a22;
import defpackage.b32;
import defpackage.cb;
import defpackage.cy0;
import defpackage.d12;
import defpackage.ew1;
import defpackage.jg3;
import defpackage.ol2;
import defpackage.p33;
import defpackage.pc1;
import defpackage.qc1;
import defpackage.s11;
import defpackage.uu1;
import defpackage.v22;
import defpackage.vt;
import defpackage.w02;
import defpackage.w9;
import defpackage.wz1;
import defpackage.x5;
import defpackage.y12;
import defpackage.z02;
import defpackage.z12;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class PictureBaseActivity extends AppCompatActivity {
    protected PictureSelectionConfig a;
    protected boolean b;
    protected boolean c;
    protected int d;
    protected int e;
    protected z12 f;
    protected View i;
    protected boolean l;
    protected cy0 m;
    protected List g = new ArrayList();
    protected Handler h = new Handler(Looper.getMainLooper());
    protected boolean j = true;
    protected int k = 1;

    class a extends PictureThreadUtils.d {
        final /* synthetic */ List f;

        a(List list) {
            this.f = list;
        }

        @Override // com.luck.picture.lib.thread.PictureThreadUtils.e
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public List d() {
            return com.luck.picture.lib.compress.b.p(PictureBaseActivity.this.N()).w(this.f).t(PictureBaseActivity.this.a.b).B(PictureBaseActivity.this.a.d).y(PictureBaseActivity.this.a.R).s(PictureBaseActivity.this.a.k1).z(PictureBaseActivity.this.a.l).A(PictureBaseActivity.this.a.m).r(PictureBaseActivity.this.a.L).q();
        }

        @Override // com.luck.picture.lib.thread.PictureThreadUtils.e
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(List list) {
            PictureThreadUtils.e(PictureThreadUtils.j());
            PictureBaseActivity.this.b0(list);
        }
    }

    class b implements uu1 {
        final /* synthetic */ List a;

        b(List list) {
            this.a = list;
        }

        @Override // defpackage.uu1
        public void a(List list) {
            PictureBaseActivity.this.b0(list);
        }

        @Override // defpackage.uu1
        public void onError(Throwable th) {
            PictureBaseActivity.this.b0(this.a);
        }

        @Override // defpackage.uu1
        public void onStart() {
        }
    }

    class c extends PictureThreadUtils.d {
        final /* synthetic */ List f;

        c(List list) {
            this.f = list;
        }

        /* JADX WARN: Code duplicated, block: B:31:0x0091  */
        /* JADX WARN: Code duplicated, block: B:33:0x0096  */
        /* JADX WARN: Code duplicated, block: B:34:0x009e  */
        /* JADX WARN: Code duplicated, block: B:41:0x00c5 A[SYNTHETIC] */
        @Override // com.luck.picture.lib.thread.PictureThreadUtils.e
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public List d() {
            boolean z;
            int size = this.f.size();
            for (int i = 0; i < size; i++) {
                LocalMedia localMedia = (LocalMedia) this.f.get(i);
                if (localMedia != null && !TextUtils.isEmpty(localMedia.q())) {
                    if (((localMedia.z() || localMedia.x() || localMedia.E()) ? false : true) && a22.h(localMedia.q())) {
                        if (!a22.l(localMedia.q())) {
                            localMedia.H(x5.a(PictureBaseActivity.this.N(), localMedia.m(), localMedia.q(), localMedia.u(), localMedia.l(), localMedia.n(), PictureBaseActivity.this.a.K0));
                            z = true;
                        }
                        if (PictureBaseActivity.this.a.L0) {
                            localMedia.h0(true);
                            if (z) {
                                localMedia.i0(localMedia.a());
                            } else {
                                localMedia.i0(x5.a(PictureBaseActivity.this.N(), localMedia.m(), localMedia.q(), localMedia.u(), localMedia.l(), localMedia.n(), PictureBaseActivity.this.a.K0));
                            }
                        }
                    } else if (localMedia.z() && localMedia.x()) {
                        localMedia.H(localMedia.c());
                    }
                    z = false;
                    if (PictureBaseActivity.this.a.L0) {
                        localMedia.h0(true);
                        if (z) {
                            localMedia.i0(localMedia.a());
                        } else {
                            localMedia.i0(x5.a(PictureBaseActivity.this.N(), localMedia.m(), localMedia.q(), localMedia.u(), localMedia.l(), localMedia.n(), PictureBaseActivity.this.a.K0));
                        }
                    }
                }
            }
            return this.f;
        }

        @Override // com.luck.picture.lib.thread.PictureThreadUtils.e
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(List list) {
            PictureThreadUtils.e(PictureThreadUtils.j());
            PictureBaseActivity.this.K();
            if (list != null) {
                PictureSelectionConfig pictureSelectionConfig = PictureBaseActivity.this.a;
                if (pictureSelectionConfig.b && pictureSelectionConfig.v == 2) {
                    list.addAll(list.size() > 0 ? list.size() - 1 : 0, PictureBaseActivity.this.g);
                }
                ew1 ew1Var = PictureSelectionConfig.x1;
                if (ew1Var != null) {
                    ew1Var.a(list);
                } else {
                    PictureBaseActivity.this.setResult(-1, v22.h(list));
                }
                PictureBaseActivity.this.L();
            }
        }
    }

    class d implements View.OnClickListener {
        final /* synthetic */ d12 a;

        d(d12 d12Var) {
            this.a = d12Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PictureBaseActivity.this.isFinishing()) {
                return;
            }
            this.a.dismiss();
        }
    }

    private void I(List list) {
        if (this.a.C0) {
            PictureThreadUtils.h(new a(list));
        } else {
            com.luck.picture.lib.compress.b.p(this).w(list).r(this.a.L).t(this.a.b).y(this.a.R).B(this.a.d).s(this.a.k1).z(this.a.l).A(this.a.m).x(new b(list)).u();
        }
    }

    private void S() {
        if (this.a.I0 != null) {
            this.g.clear();
            this.g.addAll(this.a.I0);
        }
        PictureCropParameterStyle pictureCropParameterStyle = PictureSelectionConfig.u1;
        boolean z = this.a.M0;
        this.b = z;
        if (!z) {
            this.b = cb.a(this, R$attr.picture_statusFontColor);
        }
        boolean z2 = this.a.N0;
        this.c = z2;
        if (!z2) {
            this.c = cb.a(this, R$attr.picture_style_numComplete);
        }
        PictureSelectionConfig pictureSelectionConfig = this.a;
        boolean z3 = pictureSelectionConfig.O0;
        pictureSelectionConfig.m0 = z3;
        if (!z3) {
            pictureSelectionConfig.m0 = cb.a(this, R$attr.picture_style_checkNumMode);
        }
        int i = this.a.P0;
        if (i != 0) {
            this.d = i;
        } else {
            this.d = cb.b(this, R$attr.colorPrimary);
        }
        int i2 = this.a.Q0;
        if (i2 != 0) {
            this.e = i2;
        } else {
            this.e = cb.b(this, R$attr.colorPrimaryDark);
        }
        if (this.a.n0) {
            jg3.a().b(N());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int X(LocalMediaFolder localMediaFolder, LocalMediaFolder localMediaFolder2) {
        if (localMediaFolder.d() == null || localMediaFolder2.d() == null) {
            return 0;
        }
        return Integer.compare(localMediaFolder2.g(), localMediaFolder.g());
    }

    private void Y() {
        b32 b32VarA;
        if (PictureSelectionConfig.w1 != null || (b32VarA = w02.b().a()) == null) {
            return;
        }
        PictureSelectionConfig.w1 = b32VarA.a();
    }

    private void Z() {
        b32 b32VarA;
        if (this.a.h1 && PictureSelectionConfig.x1 == null && (b32VarA = w02.b().a()) != null) {
            PictureSelectionConfig.x1 = b32VarA.b();
        }
    }

    private void a0(List list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            LocalMedia localMedia = (LocalMedia) list.get(i);
            if (localMedia != null && !TextUtils.isEmpty(localMedia.q())) {
                if (localMedia.z() && localMedia.x()) {
                    localMedia.H(localMedia.c());
                }
                if (this.a.L0) {
                    localMedia.h0(true);
                    localMedia.i0(localMedia.a());
                }
            }
        }
        PictureSelectionConfig pictureSelectionConfig = this.a;
        if (pictureSelectionConfig.b && pictureSelectionConfig.v == 2) {
            list.addAll(list.size() > 0 ? list.size() - 1 : 0, this.g);
        }
        ew1 ew1Var = PictureSelectionConfig.x1;
        if (ew1Var != null) {
            ew1Var.a(list);
        } else {
            setResult(-1, v22.h(list));
        }
        L();
    }

    private void c0(List list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            LocalMedia localMedia = (LocalMedia) list.get(i);
            if (localMedia != null && !TextUtils.isEmpty(localMedia.q()) && (this.a.L0 || (!localMedia.z() && !localMedia.x() && !localMedia.E()))) {
                l0(list);
                return;
            }
        }
        a0(list);
    }

    private void d0() {
        if (this.a != null) {
            PictureSelectionConfig.a();
            PictureThreadUtils.e(PictureThreadUtils.j());
            w9.c().a();
        }
    }

    private void h0() {
        startActivityForResult(new Intent(this, (Class<?>) PictureCustomCameraActivity.class), 909);
        overridePendingTransition(PictureSelectionConfig.v1.a, R$anim.picture_anim_fade_in);
    }

    private void l0(List list) {
        f0();
        PictureThreadUtils.h(new c(list));
    }

    protected void H(List list) {
        PictureCropParameterStyle pictureCropParameterStyle = PictureSelectionConfig.u1;
        f0();
        I(list);
    }

    protected void J(List list) {
        if (list.size() == 0) {
            LocalMediaFolder localMediaFolder = new LocalMediaFolder();
            localMediaFolder.x(getString(this.a.a == a22.t() ? R$string.picture_all_audio : R$string.picture_camera_roll));
            localMediaFolder.s(Constants.STR_EMPTY);
            localMediaFolder.n(true);
            localMediaFolder.m(-1L);
            localMediaFolder.o(true);
            list.add(localMediaFolder);
        }
    }

    protected void K() {
        if (isFinishing()) {
            return;
        }
        try {
            z12 z12Var = this.f;
            if (z12Var == null || !z12Var.isShowing()) {
                return;
            }
            this.f.dismiss();
        } catch (Exception e) {
            this.f = null;
            e.printStackTrace();
        }
    }

    protected void L() {
        finish();
        if (this.a.b) {
            overridePendingTransition(0, R$anim.picture_anim_fade_out);
            if ((N() instanceof PictureSelectorCameraEmptyActivity) || (N() instanceof PictureCustomCameraActivity)) {
                d0();
                return;
            }
            return;
        }
        overridePendingTransition(0, PictureSelectionConfig.v1.b);
        if (N() instanceof PictureSelectorActivity) {
            d0();
            if (this.a.n0) {
                jg3.a().e();
            }
        }
    }

    protected String M(Intent intent) {
        try {
            Uri data = intent.getData();
            if (data == null) {
                return Constants.STR_EMPTY;
            }
            return a22.h(data.toString()) ? data.toString() : data.getPath();
        } catch (Exception e) {
            e.printStackTrace();
            return Constants.STR_EMPTY;
        }
    }

    protected Context N() {
        return this;
    }

    protected LocalMediaFolder O(String str, String str2, String str3, List list) {
        if (!a22.h(str)) {
            str2 = str;
        }
        File parentFile = new File(str2).getParentFile();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            LocalMediaFolder localMediaFolder = (LocalMediaFolder) it.next();
            if (parentFile != null && localMediaFolder.h().equals(parentFile.getName())) {
                return localMediaFolder;
            }
        }
        LocalMediaFolder localMediaFolder2 = new LocalMediaFolder();
        localMediaFolder2.x(parentFile != null ? parentFile.getName() : Constants.STR_EMPTY);
        localMediaFolder2.s(str);
        localMediaFolder2.t(str3);
        list.add(localMediaFolder2);
        return localMediaFolder2;
    }

    public abstract int P();

    protected void Q(List list) {
        if (this.a.b0) {
            H(list);
        } else {
            b0(list);
        }
    }

    public void R() {
        s11.a(this, this.e, this.d, this.b);
    }

    protected void T() {
        if (this.a.c1) {
            this.m = new qc1(N(), this.a);
        } else {
            this.m = new pc1(N(), this.a);
        }
    }

    protected void U() {
    }

    protected void V() {
    }

    public boolean W() {
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        int i;
        PictureSelectionConfig pictureSelectionConfig = this.a;
        if (pictureSelectionConfig == null || (i = pictureSelectionConfig.V) == -2) {
            super.attachBaseContext(context);
        } else {
            super.attachBaseContext(z02.a(context, i));
        }
    }

    protected void b0(List list) {
        if (ol2.a() && this.a.t) {
            c0(list);
            return;
        }
        K();
        PictureSelectionConfig pictureSelectionConfig = this.a;
        if (pictureSelectionConfig.b && pictureSelectionConfig.v == 2) {
            list.addAll(list.size() > 0 ? list.size() - 1 : 0, this.g);
        }
        if (this.a.L0) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                LocalMedia localMedia = (LocalMedia) list.get(i);
                localMedia.h0(true);
                localMedia.i0(localMedia.q());
            }
        }
        ew1 ew1Var = PictureSelectionConfig.x1;
        if (ew1Var != null) {
            ew1Var.a(list);
        } else {
            setResult(-1, v22.h(list));
        }
        L();
    }

    protected void e0() {
        PictureSelectionConfig pictureSelectionConfig = this.a;
        if (pictureSelectionConfig == null || pictureSelectionConfig.b) {
            return;
        }
        setRequestedOrientation(pictureSelectionConfig.p);
    }

    protected void f0() {
        try {
            if (isFinishing()) {
                return;
            }
            if (this.f == null) {
                this.f = new z12(N());
            }
            if (this.f.isShowing()) {
                this.f.dismiss();
            }
            this.f.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void g0(List list) {
        Collections.sort(list, new Comparator() { // from class: x02
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return PictureBaseActivity.X((LocalMediaFolder) obj, (LocalMediaFolder) obj2);
            }
        });
    }

    public void i0() {
        try {
            if (wz1.a(this, "android.permission.RECORD_AUDIO")) {
                Intent intent = new Intent("android.provider.MediaStore.RECORD_SOUND");
                if (intent.resolveActivity(getPackageManager()) != null) {
                    Uri uriD = vt.d(N(), this.a);
                    if (uriD != null) {
                        intent.putExtra("output", uriD);
                        startActivityForResult(intent, 909);
                    } else {
                        p33.b(N(), "open is audio error，the uri is empty ");
                        if (this.a.b) {
                            L();
                        }
                    }
                } else {
                    p33.b(N(), "System recording is not supported");
                }
            } else {
                wz1.d(this, new String[]{"android.permission.RECORD_AUDIO"}, 3);
            }
        } catch (Exception e) {
            e.printStackTrace();
            p33.b(N(), e.getMessage());
        }
    }

    @Override // android.app.Activity
    public boolean isImmersive() {
        return true;
    }

    protected void j0() {
        if (this.a.Z) {
            h0();
            return;
        }
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        if (intent.resolveActivity(getPackageManager()) != null) {
            Uri uriE = vt.e(N(), this.a);
            if (uriE != null) {
                if (this.a.s) {
                    intent.putExtra("android.intent.extras.CAMERA_FACING", 1);
                }
                intent.putExtra("output", uriE);
                startActivityForResult(intent, 909);
                return;
            }
            p33.b(N(), "open is camera error，the uri is empty ");
            if (this.a.b) {
                L();
            }
        }
    }

    protected void k0() {
        if (this.a.Z) {
            h0();
            return;
        }
        Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
        if (intent.resolveActivity(getPackageManager()) != null) {
            Uri uriF = vt.f(N(), this.a);
            if (uriF == null) {
                p33.b(N(), "open is camera error，the uri is empty ");
                if (this.a.b) {
                    L();
                    return;
                }
                return;
            }
            intent.putExtra("output", uriF);
            if (this.a.s) {
                intent.putExtra("android.intent.extras.CAMERA_FACING", 1);
            }
            intent.putExtra("android.intent.extra.quickCapture", this.a.i1);
            intent.putExtra("android.intent.extra.durationLimit", this.a.J);
            intent.putExtra("android.intent.extra.videoQuality", this.a.F);
            startActivityForResult(intent, 909);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.a.V != -2) {
            y12.d(N(), this.a.V);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        PictureSelectionConfig pictureSelectionConfigC = PictureSelectionConfig.c();
        this.a = pictureSelectionConfigC;
        if (pictureSelectionConfigC.V != -2) {
            y12.d(N(), this.a.V);
        }
        int i = this.a.u;
        if (i == 0) {
            i = R$style.picture_default_style;
        }
        setTheme(i);
        super.onCreate(bundle);
        Y();
        Z();
        if (W()) {
            e0();
        }
        S();
        if (isImmersive()) {
            R();
        }
        int iP = P();
        if (iP != 0) {
            setContentView(iP);
        }
        T();
        V();
        U();
        this.l = false;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        z12 z12Var = this.f;
        if (z12Var != null) {
            z12Var.dismiss();
            this.f = null;
        }
        super.onDestroy();
        this.h.removeCallbacksAndMessages(null);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 3) {
            if (iArr[0] != 0) {
                p33.b(N(), getString(R$string.picture_audio));
                return;
            }
            Intent intent = new Intent("android.provider.MediaStore.RECORD_SOUND");
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(intent, 909);
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.l = true;
        bundle.putParcelable("PictureSelectorConfig", this.a);
    }

    protected void showPromptDialog(String str) {
        if (isFinishing()) {
            return;
        }
        PictureCropParameterStyle pictureCropParameterStyle = PictureSelectionConfig.u1;
        d12 d12Var = new d12(N(), R$layout.picture_prompt_dialog);
        TextView textView = (TextView) d12Var.findViewById(R$id.btnOk);
        ((TextView) d12Var.findViewById(R$id.tv_content)).setText(str);
        textView.setOnClickListener(new d(d12Var));
        d12Var.show();
    }
}
