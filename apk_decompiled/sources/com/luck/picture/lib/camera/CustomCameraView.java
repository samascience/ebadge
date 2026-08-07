package com.luck.picture.lib.camera;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.m;
import androidx.camera.core.u;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.video.Recorder;
import androidx.camera.video.k0;
import androidx.camera.video.n0;
import androidx.camera.video.r;
import androidx.camera.video.s;
import androidx.camera.video.v;
import androidx.camera.video.w0;
import androidx.camera.view.PreviewView;
import com.luck.picture.lib.R$color;
import com.luck.picture.lib.R$drawable;
import com.luck.picture.lib.R$id;
import com.luck.picture.lib.R$layout;
import com.luck.picture.lib.R$string;
import com.luck.picture.lib.camera.view.CaptureLayout;
import com.luck.picture.lib.compress.Checker;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.tencent.connect.common.Constants;
import defpackage.a22;
import defpackage.cn0;
import defpackage.cv;
import defpackage.cw;
import defpackage.db1;
import defpackage.du;
import defpackage.gy;
import defpackage.ll2;
import defpackage.mz0;
import defpackage.n52;
import defpackage.q20;
import defpackage.q30;
import defpackage.r63;
import defpackage.s12;
import defpackage.sm0;
import defpackage.sv2;
import defpackage.tu;
import defpackage.ub1;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"UnsafeOptInUsageError", "MissingPermission"})
public class CustomCameraView extends RelativeLayout {
    private int a;
    private PictureSelectionConfig b;
    private PreviewView c;
    private ProcessCameraProvider d;
    private u e;
    private n0 f;
    private Recorder g;
    private k0 h;
    private String i;
    private int j;
    private int k;
    private du l;
    private gy m;
    private mz0 n;
    private ImageView o;
    private ImageView p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private ImageView f295q;
    private CaptureLayout r;
    private MediaPlayer s;
    private TextureView t;
    private long u;
    private Activity v;
    private final TextureView.SurfaceTextureListener w;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CustomCameraView.this.c0();
        }
    }

    class b implements cw {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void h(w0 w0Var) {
            if (w0Var instanceof w0.a) {
                w0.a aVar = (w0.a) w0Var;
                CustomCameraView.this.h = null;
                if (aVar.l()) {
                    if (CustomCameraView.this.l != null) {
                        Throwable thI = aVar.i();
                        CustomCameraView.this.l.a(aVar.j(), thI != null ? thI.getMessage() : "Video capture error", thI);
                    }
                    CustomCameraView.this.i = null;
                    return;
                }
                Uri uriA = aVar.k().a();
                if (uriA == null && !TextUtils.isEmpty(CustomCameraView.this.i)) {
                    uriA = Uri.fromFile(new File(CustomCameraView.this.i));
                }
                if (CustomCameraView.this.u < (CustomCameraView.this.b.K <= 0 ? 1500L : ((long) CustomCameraView.this.b.K) * 1000) || uriA == null) {
                    CustomCameraView.this.i = null;
                    return;
                }
                String string = uriA.toString();
                PictureSelectionConfig pictureSelectionConfig = CustomCameraView.this.b;
                if (!a22.h(string)) {
                    string = uriA.getPath();
                }
                pictureSelectionConfig.Z0 = string;
                CustomCameraView.this.t.setVisibility(0);
                CustomCameraView.this.c.setVisibility(4);
                if (CustomCameraView.this.t.isAvailable()) {
                    CustomCameraView customCameraView = CustomCameraView.this;
                    customCameraView.Z(customCameraView.b.Z0);
                } else {
                    CustomCameraView.this.t.setSurfaceTextureListener(CustomCameraView.this.w);
                }
                CustomCameraView.this.i = null;
            }
        }

        @Override // defpackage.cw
        public void a(float f) {
        }

        @Override // defpackage.cw
        public void b() {
            if (CustomCameraView.this.l != null) {
                CustomCameraView.this.l.a(0, "An unknown error", null);
            }
        }

        @Override // defpackage.cw
        public void c(long j) {
            CustomCameraView.this.u = j;
            CustomCameraView.this.p.setVisibility(0);
            CustomCameraView.this.f295q.setVisibility(0);
            CustomCameraView.this.r.r();
            CustomCameraView.this.r.setTextWithAnimation(CustomCameraView.this.getContext().getString(R$string.picture_recording_time_is_short));
            CustomCameraView.this.a0();
        }

        @Override // defpackage.cw
        public void d() {
            String strC;
            if (!CustomCameraView.this.d.p(CustomCameraView.this.f)) {
                CustomCameraView.this.M();
            }
            CustomCameraView.this.j = 4;
            CustomCameraView.this.p.setVisibility(4);
            CustomCameraView.this.f295q.setVisibility(4);
            if (TextUtils.isEmpty(CustomCameraView.this.b.K0)) {
                strC = Constants.STR_EMPTY;
            } else {
                boolean zQ = a22.q(CustomCameraView.this.b.K0);
                CustomCameraView.this.b.K0 = zQ ? sv2.d(CustomCameraView.this.b.K0, ".mp4") : CustomCameraView.this.b.K0;
                strC = CustomCameraView.this.b.b ? CustomCameraView.this.b.K0 : sv2.c(CustomCameraView.this.b.K0);
            }
            CustomCameraView.this.i = null;
            File fileC = s12.c(CustomCameraView.this.getContext(), 2, strC, CustomCameraView.this.b.g, CustomCameraView.this.b.W0);
            CustomCameraView.this.i = fileC.getAbsolutePath();
            r rVarK0 = ((Recorder) CustomCameraView.this.f.C0()).k0(CustomCameraView.this.getContext(), new sm0.a(fileC).a());
            if (q30.a(CustomCameraView.this.getContext(), "android.permission.RECORD_AUDIO") == 0) {
                rVarK0 = rVarK0.i();
            }
            CustomCameraView customCameraView = CustomCameraView.this;
            customCameraView.h = rVarK0.h(q30.h(customCameraView.getContext()), new q20() { // from class: com.luck.picture.lib.camera.a
                @Override // defpackage.q20
                public final void accept(Object obj) {
                    this.a.h((w0) obj);
                }
            });
        }

        @Override // defpackage.cw
        public void e(long j) {
            CustomCameraView.this.u = j;
            CustomCameraView.this.a0();
        }

        @Override // defpackage.cw
        public void f() {
            String strC;
            if (!CustomCameraView.this.d.p(CustomCameraView.this.e)) {
                CustomCameraView.this.K();
            }
            new u.d().d(CustomCameraView.this.S());
            CustomCameraView.this.j = 1;
            CustomCameraView.this.r.setButtonCaptureEnabled(false);
            CustomCameraView.this.p.setVisibility(4);
            CustomCameraView.this.f295q.setVisibility(4);
            if (TextUtils.isEmpty(CustomCameraView.this.b.K0)) {
                strC = Constants.STR_EMPTY;
            } else {
                boolean zQ = a22.q(CustomCameraView.this.b.K0);
                CustomCameraView.this.b.K0 = !zQ ? sv2.d(CustomCameraView.this.b.K0, ".jpg") : CustomCameraView.this.b.K0;
                strC = CustomCameraView.this.b.b ? CustomCameraView.this.b.K0 : sv2.c(CustomCameraView.this.b.K0);
            }
            CustomCameraView.this.e.t0(new u.g.a(s12.c(CustomCameraView.this.getContext(), 1, strC, CustomCameraView.this.b.f, CustomCameraView.this.b.W0)).a(), q30.h(CustomCameraView.this.getContext()), new i(CustomCameraView.this.o, CustomCameraView.this.r, CustomCameraView.this.n, CustomCameraView.this.l, CustomCameraView.this.b));
        }
    }

    class c implements r63 {
        c() {
        }

        @Override // defpackage.r63
        public void a() {
            String strN = CustomCameraView.N(CustomCameraView.this.v.getIntent());
            if (CustomCameraView.this.T()) {
                CustomCameraView customCameraView = CustomCameraView.this;
                strN = customCameraView.R(customCameraView.v, strN);
            } else if (CustomCameraView.this.Q() && CustomCameraView.this.S()) {
                File fileC = cn0.c(CustomCameraView.this.getContext(), 1, CustomCameraView.this.b.K0, CustomCameraView.this.b.f, CustomCameraView.this.b.W0);
                if (cn0.b(CustomCameraView.this.v, strN, fileC.getAbsolutePath())) {
                    strN = fileC.getAbsolutePath();
                }
            }
            if (CustomCameraView.this.Q()) {
                CustomCameraView.this.o.setVisibility(4);
                if (CustomCameraView.this.l != null) {
                    CustomCameraView.this.l.b(strN);
                    return;
                }
                return;
            }
            CustomCameraView.this.b0();
            if (CustomCameraView.this.l != null) {
                CustomCameraView.this.l.c(strN);
            }
        }

        @Override // defpackage.r63
        public void cancel() {
            CustomCameraView.this.V();
        }
    }

    class d implements gy {
        d() {
        }

        @Override // defpackage.gy
        public void a() {
            if (CustomCameraView.this.m != null) {
                CustomCameraView.this.m.a();
            }
        }
    }

    class e implements Runnable {
        final /* synthetic */ ub1 a;

        e(ub1 ub1Var) {
            this.a = ub1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                CustomCameraView.this.d = (ProcessCameraProvider) this.a.get();
                CustomCameraView.this.L();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class f implements TextureView.SurfaceTextureListener {
        f() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            CustomCameraView customCameraView = CustomCameraView.this;
            customCameraView.Z(customCameraView.b.Z0);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    class g implements MediaPlayer.OnVideoSizeChangedListener {
        g() {
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            CustomCameraView customCameraView = CustomCameraView.this;
            customCameraView.d0(customCameraView.s.getVideoWidth(), CustomCameraView.this.s.getVideoHeight());
        }
    }

    class h implements MediaPlayer.OnPreparedListener {
        h() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            if (CustomCameraView.this.s != null) {
                CustomCameraView.this.s.start();
            }
        }
    }

    private static class i implements u.f {
        private final WeakReference a;
        private final WeakReference b;
        private final WeakReference c;
        private final WeakReference d;
        private final WeakReference e;

        public i(ImageView imageView, CaptureLayout captureLayout, mz0 mz0Var, du duVar, PictureSelectionConfig pictureSelectionConfig) {
            this.a = new WeakReference(imageView);
            this.b = new WeakReference(captureLayout);
            this.c = new WeakReference(mz0Var);
            this.d = new WeakReference(duVar);
            this.e = new WeakReference(pictureSelectionConfig);
        }

        @Override // androidx.camera.core.u.f
        public void c(u.h hVar) {
            if (hVar.a() == null) {
                return;
            }
            Uri uriA = hVar.a();
            String string = uriA.toString();
            if (this.e.get() != null) {
                ((PictureSelectionConfig) this.e.get()).Z0 = a22.h(string) ? string : uriA.getPath();
            }
            if (this.b.get() != null) {
                ((CaptureLayout) this.b.get()).setButtonCaptureEnabled(true);
            }
            if (this.c.get() != null && this.a.get() != null) {
                ((mz0) this.c.get()).a(string, (ImageView) this.a.get());
            }
            if (this.a.get() != null) {
                ((ImageView) this.a.get()).setVisibility(0);
            }
            if (this.b.get() != null) {
                ((CaptureLayout) this.b.get()).t();
            }
        }

        @Override // androidx.camera.core.u.f
        public void d(ImageCaptureException imageCaptureException) {
            if (this.b.get() != null) {
                ((CaptureLayout) this.b.get()).setButtonCaptureEnabled(true);
            }
            if (this.d.get() != null) {
                ((du) this.d.get()).a(imageCaptureException.getImageCaptureError(), imageCaptureException.getMessage(), imageCaptureException.getCause());
            }
        }
    }

    public CustomCameraView(Context context) {
        super(context);
        this.a = 35;
        this.j = 1;
        this.k = 1;
        this.u = 0L;
        this.w = new f();
        P();
    }

    private int J(int i2, int i3) {
        double dMax = Math.max(i2, i3) / Math.min(i2, i3);
        return Math.abs(dMax - 1.3333333333333333d) <= Math.abs(dMax - 1.7777777777777777d) ? 0 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        try {
            int iJ = J(ll2.c(getContext()), ll2.b(getContext()));
            tu tuVarA = new tu.a().b(this.k).a();
            n52 n52VarC = new n52.a().j(iJ).c();
            this.e = new u.b().f(1).l(iJ).c();
            m mVarC = new m.c().l(iJ).c();
            this.d.t();
            this.d.g((db1) getContext(), tuVarA, n52VarC, this.e, mVarC);
            n52VarC.h0(this.c.getSurfaceProvider());
            Y();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        int i2 = this.b.f298q;
        if (i2 == 259 || i2 == 257) {
            K();
        } else {
            M();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        try {
            tu tuVarA = new tu.a().b(this.k).a();
            n52 n52VarC = new n52.a().c();
            Recorder recorderB = new Recorder.g().d(v.d(s.f)).b();
            this.g = recorderB;
            this.f = n0.d1(recorderB);
            this.d.t();
            this.d.g((db1) getContext(), tuVarA, n52VarC, this.f);
            n52VarC.h0(this.c.getSurfaceProvider());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static String N(Intent intent) {
        Uri uri = (Uri) intent.getParcelableExtra("output");
        if (uri == null) {
            return Constants.STR_EMPTY;
        }
        return cn0.i(uri.toString()) ? uri.toString() : uri.getPath();
    }

    private void P() {
        View.inflate(getContext(), R$layout.picture_camera_view, this);
        this.v = (Activity) getContext();
        setBackgroundColor(q30.c(getContext(), R$color.picture_color_black));
        this.c = (PreviewView) findViewById(R$id.cameraPreviewView);
        this.t = (TextureView) findViewById(R$id.video_play_preview);
        this.o = (ImageView) findViewById(R$id.image_preview);
        this.p = (ImageView) findViewById(R$id.image_switch);
        this.f295q = (ImageView) findViewById(R$id.image_flash);
        this.r = (CaptureLayout) findViewById(R$id.capture_layout);
        this.p.setImageResource(R$drawable.picture_ic_camera);
        this.f295q.setOnClickListener(new View.OnClickListener() { // from class: k50
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.U(view);
            }
        });
        this.r.setDuration(15000);
        this.p.setOnClickListener(new a());
        this.r.setCaptureListener(new b());
        this.r.setTypeListener(new c());
        this.r.setLeftClickListener(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Q() {
        return this.j == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String R(Activity activity, String str) {
        Uri uriInsert;
        try {
            if (Q() && S()) {
                File fileF = cn0.f(activity, false);
                if (cn0.b(activity, str, fileF.getAbsolutePath())) {
                    str = fileF.getAbsolutePath();
                }
            }
            if (Q()) {
                uriInsert = getContext().getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, cv.a(this.b.K0, Checker.MIME_TYPE_JPEG));
            } else {
                uriInsert = getContext().getContentResolver().insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, cv.b(this.b.K0, Checker.MIME_TYPE_JPEG));
            }
            if (uriInsert == null) {
                return str;
            }
            if (cn0.j(new FileInputStream(str), getContext().getContentResolver().openOutputStream(uriInsert))) {
                cn0.g(getContext(), str);
                W(activity.getIntent(), uriInsert);
                return uriInsert.toString();
            }
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean S() {
        return this.k == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean T() {
        return Build.VERSION.SDK_INT >= 29 && TextUtils.isEmpty(this.b.W0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U(View view) {
        int i2 = this.a + 1;
        this.a = i2;
        if (i2 > 35) {
            this.a = 33;
        }
        Y();
    }

    public static void W(Intent intent, Uri uri) {
        intent.putExtra("output", uri);
    }

    private void X() {
        if (Q()) {
            this.o.setVisibility(4);
        } else {
            a0();
        }
        this.p.setVisibility(0);
        this.f295q.setVisibility(0);
        this.c.setVisibility(0);
        this.r.r();
    }

    private void Y() {
        if (this.e == null) {
        }
        switch (this.a) {
            case 33:
                this.f295q.setImageResource(R$drawable.picture_ic_flash_auto);
                this.e.x0(0);
                break;
            case 34:
                this.f295q.setImageResource(R$drawable.picture_ic_flash_on);
                this.e.x0(1);
                break;
            case 35:
                this.f295q.setImageResource(R$drawable.picture_ic_flash_off);
                this.e.x0(2);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(String str) {
        try {
            MediaPlayer mediaPlayer = this.s;
            if (mediaPlayer == null) {
                this.s = new MediaPlayer();
            } else {
                mediaPlayer.reset();
            }
            if (a22.h(str)) {
                this.s.setDataSource(getContext(), Uri.parse(str));
            } else {
                this.s.setDataSource(str);
            }
            this.s.setSurface(new Surface(this.t.getSurfaceTexture()));
            this.s.setVideoScalingMode(1);
            this.s.setAudioStreamType(3);
            this.s.setOnVideoSizeChangedListener(new g());
            this.s.setOnPreparedListener(new h());
            this.s.setLooping(true);
            this.s.prepareAsync();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a0() {
        k0 k0Var = this.h;
        if (k0Var != null) {
            k0Var.C();
            this.h = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0() {
        MediaPlayer mediaPlayer = this.s;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            this.s.stop();
            this.s.release();
            this.s = null;
        }
        this.t.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0(float f2, float f3) {
        if (f2 > f3) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) ((f3 / f2) * getWidth()));
            layoutParams.gravity = 17;
            this.t.setLayoutParams(layoutParams);
        }
    }

    public void O() {
        PictureSelectionConfig pictureSelectionConfigC = PictureSelectionConfig.c();
        this.b = pictureSelectionConfigC;
        this.k = !pictureSelectionConfigC.s ? 1 : 0;
        if (q30.a(getContext(), "android.permission.CAMERA") == 0) {
            ub1 ub1VarL = ProcessCameraProvider.l(getContext());
            ub1VarL.a(new e(ub1VarL), q30.h(getContext()));
        }
    }

    public void V() {
        b0();
        X();
    }

    public void c0() {
        this.k = this.k == 0 ? 1 : 0;
        L();
    }

    public CaptureLayout getCaptureLayout() {
        return this.r;
    }

    public void setCameraListener(du duVar) {
        this.l = duVar;
    }

    public void setCaptureLoadingColor(int i2) {
        this.r.setCaptureLoadingColor(i2);
    }

    public void setImageCallbackListener(mz0 mz0Var) {
        this.n = mz0Var;
    }

    public void setOnClickListener(gy gyVar) {
        this.m = gyVar;
    }

    public void setRecordVideoMaxTime(int i2) {
        this.r.setDuration(i2 * 1000);
    }

    public void setRecordVideoMinTime(int i2) {
        this.r.setMinDuration(i2 * 1000);
    }

    public CustomCameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 35;
        this.j = 1;
        this.k = 1;
        this.u = 0L;
        this.w = new f();
        P();
    }

    public CustomCameraView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = 35;
        this.j = 1;
        this.k = 1;
        this.u = 0L;
        this.w = new f();
        P();
    }
}
