package com.legend.sdk.cameralibray;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
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
import android.widget.TextView;
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
import com.luck.picture.lib.camera.view.CaptureLayout;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.tencent.connect.common.Constants;
import defpackage.a22;
import defpackage.bi1;
import defpackage.cn0;
import defpackage.cw;
import defpackage.db1;
import defpackage.du;
import defpackage.e32;
import defpackage.gy;
import defpackage.ll2;
import defpackage.mz0;
import defpackage.n52;
import defpackage.ol2;
import defpackage.q20;
import defpackage.q30;
import defpackage.r63;
import defpackage.ru0;
import defpackage.s12;
import defpackage.s40;
import defpackage.sm0;
import defpackage.sv2;
import defpackage.tu;
import defpackage.ub1;
import defpackage.vt;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Date;

/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"UnsafeOptInUsageError", "RestrictedApi", "MissingPermission"})
public class MyCameraView extends RelativeLayout {
    private static boolean H;
    private Activity F;
    private final TextureView.SurfaceTextureListener G;
    private int a;
    private PictureSelectionConfig b;
    private PreviewView c;
    private ProcessCameraProvider d;
    private u e;
    private m f;
    private n0 g;
    private Recorder h;
    private k0 i;
    private String j;
    private int k;
    private int l;
    private du m;
    private gy n;
    private mz0 o;
    private j p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private ImageView f288q;
    private ImageView r;
    private ImageView s;
    private CaptureLayout t;
    private MediaPlayer u;
    private TextureView v;
    private long w;
    private s40 x;
    private TextView y;
    private ImageView z;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MyCameraView.this.m0();
        }
    }

    class b implements cw {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void h(w0 w0Var) {
            if (w0Var instanceof w0.a) {
                w0.a aVar = (w0.a) w0Var;
                MyCameraView.this.i = null;
                if (aVar.l()) {
                    if (MyCameraView.this.m != null) {
                        Throwable thI = aVar.i();
                        MyCameraView.this.m.a(aVar.j(), thI != null ? thI.getMessage() : "Video capture error", thI);
                        return;
                    }
                    return;
                }
                Uri uriA = aVar.k().a();
                if (uriA == null && !TextUtils.isEmpty(MyCameraView.this.j)) {
                    uriA = Uri.fromFile(new File(MyCameraView.this.j));
                }
                if (MyCameraView.this.w < (MyCameraView.this.b.K <= 0 ? 1500L : ((long) MyCameraView.this.b.K) * 1000) || uriA == null) {
                    MyCameraView.this.j = null;
                    return;
                }
                String string = uriA.toString();
                PictureSelectionConfig pictureSelectionConfig = MyCameraView.this.b;
                if (!a22.h(string)) {
                    string = uriA.getPath();
                }
                pictureSelectionConfig.Z0 = string;
                MyCameraView.this.v.setVisibility(0);
                MyCameraView.this.c.setVisibility(4);
                if (MyCameraView.this.v.isAvailable()) {
                    MyCameraView myCameraView = MyCameraView.this;
                    myCameraView.i0(myCameraView.b.Z0);
                } else {
                    MyCameraView.this.v.setSurfaceTextureListener(MyCameraView.this.G);
                }
                MyCameraView.this.j = null;
            }
        }

        @Override // defpackage.cw
        public void a(float f) {
        }

        @Override // defpackage.cw
        public void b() {
            if (MyCameraView.this.m != null) {
                MyCameraView.this.m.a(0, "An unknown error", null);
            }
        }

        @Override // defpackage.cw
        public void c(long j) {
            MyCameraView.this.w = j;
            MyCameraView.this.r.setVisibility(0);
            MyCameraView.this.s.setVisibility(0);
            MyCameraView.this.t.r();
            MyCameraView.this.t.setTextWithAnimation(MyCameraView.this.getContext().getString(com.luck.picture.lib.R$string.picture_recording_time_is_short));
            MyCameraView.this.j0();
        }

        @Override // defpackage.cw
        public void d() {
            String strC;
            r rVarK0;
            if (!MyCameraView.this.d.p(MyCameraView.this.g)) {
                MyCameraView.this.P();
            }
            MyCameraView.this.k = 4;
            MyCameraView.this.r.setVisibility(4);
            MyCameraView.this.s.setVisibility(4);
            if (TextUtils.isEmpty(MyCameraView.this.b.K0)) {
                strC = Constants.STR_EMPTY;
            } else {
                boolean zQ = a22.q(MyCameraView.this.b.K0);
                MyCameraView.this.b.K0 = zQ ? sv2.d(MyCameraView.this.b.K0, ".mp4") : MyCameraView.this.b.K0;
                strC = MyCameraView.this.b.b ? MyCameraView.this.b.K0 : sv2.c(MyCameraView.this.b.K0);
            }
            MyCameraView.this.j = null;
            if (ol2.a() && TextUtils.isEmpty(MyCameraView.this.b.W0)) {
                rVarK0 = ((Recorder) MyCameraView.this.g.C0()).l0(MyCameraView.this.getContext(), new bi1.a(MyCameraView.this.getContext().getContentResolver(), MediaStore.Video.Media.EXTERNAL_CONTENT_URI).b(vt.b(strC, MyCameraView.this.b.i)).a());
            } else {
                File fileC = s12.c(MyCameraView.this.getContext(), 2, strC, MyCameraView.this.b.g, MyCameraView.this.b.W0);
                MyCameraView.this.j = fileC.getAbsolutePath();
                MyCameraView.this.b.Z0 = MyCameraView.this.j;
                rVarK0 = ((Recorder) MyCameraView.this.g.C0()).k0(MyCameraView.this.getContext(), new sm0.a(fileC).a());
            }
            if (q30.a(MyCameraView.this.getContext(), "android.permission.RECORD_AUDIO") == 0) {
                rVarK0 = rVarK0.i();
            }
            MyCameraView myCameraView = MyCameraView.this;
            myCameraView.i = rVarK0.h(q30.h(myCameraView.getContext()), new q20() { // from class: com.legend.sdk.cameralibray.e
                @Override // defpackage.q20
                public final void accept(Object obj) {
                    this.a.h((w0) obj);
                }
            });
        }

        @Override // defpackage.cw
        public void e(long j) {
            MyCameraView.this.w = j;
            MyCameraView.this.j0();
        }

        @Override // defpackage.cw
        public void f() {
            MyCameraView.this.h0();
        }
    }

    class c implements r63 {
        c() {
        }

        @Override // defpackage.r63
        public void a() {
            String outputPath = MyCameraView.this.getOutputPath();
            if (MyCameraView.this.X()) {
                MyCameraView myCameraView = MyCameraView.this;
                outputPath = myCameraView.V(myCameraView.F, outputPath);
            } else if (MyCameraView.this.U() && MyCameraView.this.W()) {
                File fileC = cn0.c(MyCameraView.this.getContext(), 1, MyCameraView.this.b.K0, MyCameraView.this.b.f, MyCameraView.this.b.W0);
                if (cn0.b(MyCameraView.this.F, outputPath, fileC.getAbsolutePath())) {
                    outputPath = fileC.getAbsolutePath();
                }
            }
            if (MyCameraView.this.U()) {
                MyCameraView.this.f288q.setVisibility(4);
                if (MyCameraView.this.m != null) {
                    MyCameraView.this.m.b(outputPath);
                }
                ru0.c(MyCameraView.this.getContext(), MyCameraView.this.b.Z0, MyCameraView.this.z);
                return;
            }
            MyCameraView.this.k0();
            if (MyCameraView.this.m != null) {
                MyCameraView.this.m.c(outputPath);
            }
        }

        @Override // defpackage.r63
        public void cancel() {
            MyCameraView.this.d0();
        }
    }

    class d implements gy {
        d() {
        }

        @Override // defpackage.gy
        public void a() {
            if (MyCameraView.this.n != null) {
                MyCameraView.this.n.a();
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
                MyCameraView.this.d = (ProcessCameraProvider) this.a.get();
                MyCameraView.this.O();
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
            MyCameraView myCameraView = MyCameraView.this;
            myCameraView.i0(myCameraView.b.Z0);
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
            MyCameraView myCameraView = MyCameraView.this;
            myCameraView.n0(myCameraView.u.getVideoWidth(), MyCameraView.this.u.getVideoHeight());
        }
    }

    class h implements MediaPlayer.OnPreparedListener {
        h() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            if (MyCameraView.this.u != null) {
                MyCameraView.this.u.start();
            }
        }
    }

    private static class i implements u.f {
        private final WeakReference a;
        private final WeakReference b;
        private final WeakReference c;
        private final WeakReference d;
        private final WeakReference e;
        private final WeakReference f;
        private final WeakReference g;

        public i(ImageView imageView, ImageView imageView2, ImageView imageView3, CaptureLayout captureLayout, mz0 mz0Var, du duVar, PictureSelectionConfig pictureSelectionConfig) {
            this.a = new WeakReference(imageView3);
            this.b = new WeakReference(captureLayout);
            this.c = new WeakReference(mz0Var);
            this.d = new WeakReference(duVar);
            this.e = new WeakReference(pictureSelectionConfig);
            this.f = new WeakReference(imageView);
            this.g = new WeakReference(imageView2);
        }

        @Override // androidx.camera.core.u.f
        public void c(u.h hVar) {
            r63 typeListener;
            MyCameraView.H = false;
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
                ((ImageView) this.a.get()).setVisibility(4);
            }
            if (this.f.get() != null) {
                ((ImageView) this.f.get()).setVisibility(0);
            }
            if (this.g.get() != null) {
                ((ImageView) this.g.get()).setVisibility(0);
            }
            if (this.b.get() == null || (typeListener = ((CaptureLayout) this.b.get()).getTypeListener()) == null) {
                return;
            }
            typeListener.a();
        }

        @Override // androidx.camera.core.u.f
        public void d(ImageCaptureException imageCaptureException) {
            MyCameraView.H = false;
            if (this.b.get() != null) {
                ((CaptureLayout) this.b.get()).setButtonCaptureEnabled(true);
            }
            if (this.d.get() != null) {
                ((du) this.d.get()).a(imageCaptureException.getImageCaptureError(), imageCaptureException.getMessage(), imageCaptureException.getCause());
            }
        }
    }

    public interface j {
        void a();
    }

    public MyCameraView(Context context) {
        super(context);
        this.a = 35;
        this.k = 1;
        this.l = 1;
        this.w = 0L;
        this.G = new f();
        T();
    }

    private int M(int i2, int i3) {
        double dMax = Math.max(i2, i3) / Math.min(i2, i3);
        return Math.abs(dMax - 1.3333333333333333d) <= Math.abs(dMax - 1.7777777777777777d) ? 0 : 1;
    }

    private void N() {
        try {
            int iM = M(ll2.c(getContext()), ll2.b(getContext()));
            tu tuVarA = new tu.a().b(this.l).a();
            n52 n52VarC = new n52.a().j(iM).c();
            this.e = new u.b().f(1).l(iM).c();
            this.f = new m.c().l(iM).f(0).c();
            this.d.t();
            this.d.g((db1) getContext(), tuVarA, n52VarC, this.e, this.f);
            n52VarC.h0(this.c.getSurfaceProvider());
            f0();
            if (this.p != null) {
                postDelayed(new Runnable() { // from class: vm1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.Y();
                    }
                }, 100L);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        PictureSelectionConfig pictureSelectionConfig = this.b;
        if (pictureSelectionConfig == null) {
            return;
        }
        int i2 = pictureSelectionConfig.f298q;
        if (i2 == 259 || i2 == 257) {
            N();
        } else {
            P();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        try {
            tu tuVarA = new tu.a().b(this.l).a();
            n52 n52VarC = new n52.a().c();
            Recorder recorderB = new Recorder.g().d(v.d(s.f)).b();
            this.h = recorderB;
            this.g = n0.d1(recorderB);
            this.d.t();
            this.d.g((db1) getContext(), tuVarA, n52VarC, this.g);
            n52VarC.h0(this.c.getSurfaceProvider());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void S() {
        H = false;
        s40 s40VarC = s40.c();
        this.x = s40VarC;
        s40VarC.f(3500L);
        this.x.d(1000L);
        this.x.e(new s40.a() { // from class: wm1
            @Override // s40.a
            public final void onFinish() {
                this.a.Z();
            }
        });
        this.x.g(new s40.c() { // from class: xm1
            @Override // s40.c
            public final void a(long j2) {
                this.a.a0(j2);
            }
        });
    }

    private void T() {
        S();
        View.inflate(getContext(), R$layout.my_picture_camera_view, this);
        this.F = (Activity) getContext();
        setBackgroundColor(q30.c(getContext(), R$color.picture_color_black));
        this.c = (PreviewView) findViewById(R$id.cameraPreviewView);
        this.v = (TextureView) findViewById(R$id.video_play_preview);
        this.f288q = (ImageView) findViewById(R$id.image_preview);
        this.r = (ImageView) findViewById(R$id.image_switch);
        this.s = (ImageView) findViewById(R$id.image_flash);
        this.t = (CaptureLayout) findViewById(R$id.capture_layout);
        this.y = (TextView) findViewById(R$id.count_down);
        this.r.setImageResource(com.luck.picture.lib.R$drawable.picture_ic_camera);
        ImageView imageView = (ImageView) findViewById(R$id.showpic);
        this.z = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: tm1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.b0(view);
            }
        });
        this.s.setOnClickListener(new View.OnClickListener() { // from class: um1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.c0(view);
            }
        });
        this.t.setDuration(15000);
        this.t.s();
        this.r.setOnClickListener(new a());
        this.t.setCaptureListener(new b());
        this.t.setTypeListener(new c());
        this.t.setLeftClickListener(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean U() {
        return this.k == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String V(Activity activity, String str) {
        try {
            if (!U() || !W()) {
                return str;
            }
            File fileF = cn0.f(activity, false);
            return cn0.b(activity, str, fileF.getAbsolutePath()) ? fileF.getAbsolutePath() : str;
        } catch (Exception e2) {
            e2.printStackTrace();
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean W() {
        return this.l == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean X() {
        return Build.VERSION.SDK_INT >= 29 && TextUtils.isEmpty(this.b.W0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y() {
        j jVar = this.p;
        if (jVar != null) {
            jVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z() {
        try {
            if (this.y == null) {
                return;
            }
            g0();
            this.y.setVisibility(8);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0(long j2) {
        this.y.setText(String.valueOf(j2 / 1000));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(View view) {
        e32.a((Activity) getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0(View view) {
        int i2 = this.a + 1;
        this.a = i2;
        if (i2 > 35) {
            this.a = 33;
        }
        f0();
    }

    private void e0() {
        if (U()) {
            this.f288q.setVisibility(4);
        } else {
            j0();
        }
        this.r.setVisibility(0);
        this.s.setVisibility(0);
        this.c.setVisibility(0);
        this.t.r();
    }

    private void f0() {
        if (this.e == null) {
        }
        switch (this.a) {
            case 33:
                this.s.setImageResource(com.luck.picture.lib.R$drawable.picture_ic_flash_auto);
                this.e.x0(0);
                break;
            case 34:
                this.s.setImageResource(com.luck.picture.lib.R$drawable.picture_ic_flash_on);
                this.e.x0(1);
                break;
            case 35:
                this.s.setImageResource(com.luck.picture.lib.R$drawable.picture_ic_flash_off);
                this.e.x0(2);
                break;
        }
    }

    private void g0() {
        String strC;
        u.g gVarA;
        ProcessCameraProvider processCameraProvider = this.d;
        if (processCameraProvider != null && !processCameraProvider.p(this.e)) {
            N();
        }
        u.d dVar = new u.d();
        dVar.d(W());
        this.k = 1;
        this.t.setButtonCaptureEnabled(false);
        this.r.setVisibility(4);
        this.s.setVisibility(4);
        if (TextUtils.isEmpty(this.b.K0)) {
            strC = Constants.STR_EMPTY;
        } else {
            boolean zQ = a22.q(this.b.K0);
            PictureSelectionConfig pictureSelectionConfig = this.b;
            pictureSelectionConfig.K0 = !zQ ? sv2.d(pictureSelectionConfig.K0, ".jpg") : pictureSelectionConfig.K0;
            PictureSelectionConfig pictureSelectionConfig2 = this.b;
            boolean z = pictureSelectionConfig2.b;
            strC = pictureSelectionConfig2.K0;
            if (!z) {
                strC = sv2.c(strC);
            }
        }
        if (ol2.a() && TextUtils.isEmpty(this.b.W0)) {
            gVarA = new u.g.a(getContext().getContentResolver(), MediaStore.Images.Media.EXTERNAL_CONTENT_URI, vt.a(strC, this.b.i)).b(dVar).a();
        } else {
            Context context = getContext();
            PictureSelectionConfig pictureSelectionConfig3 = this.b;
            gVarA = new u.g.a(s12.c(context, 1, strC, pictureSelectionConfig3.f, pictureSelectionConfig3.W0)).a();
        }
        this.e.t0(gVarA, q30.h(getContext()), new i(this.r, this.s, this.f288q, this.t, this.o, this.m, this.b));
    }

    private String getSandboxCameraOutputPath() {
        File file = new File(getContext().getExternalFilesDir(Constants.STR_EMPTY).getAbsolutePath(), "Sandbox");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath() + File.separator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i0(String str) {
        try {
            MediaPlayer mediaPlayer = this.u;
            if (mediaPlayer == null) {
                this.u = new MediaPlayer();
            } else {
                mediaPlayer.reset();
            }
            if (a22.h(str)) {
                this.u.setDataSource(getContext(), Uri.parse(str));
            } else {
                this.u.setDataSource(str);
            }
            this.u.setSurface(new Surface(this.v.getSurfaceTexture()));
            this.u.setVideoScalingMode(1);
            this.u.setAudioStreamType(3);
            this.u.setOnVideoSizeChangedListener(new g());
            this.u.setOnPreparedListener(new h());
            this.u.setLooping(true);
            this.u.prepareAsync();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j0() {
        k0 k0Var = this.i;
        if (k0Var != null) {
            k0Var.C();
            this.i = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k0() {
        MediaPlayer mediaPlayer = this.u;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            this.u.stop();
            this.u.release();
            this.u = null;
        }
        this.v.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0(float f2, float f3) {
        if (f2 > f3) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) ((f3 / f2) * getWidth()));
            layoutParams.gravity = 17;
            this.v.setLayoutParams(layoutParams);
        }
    }

    public void Q() {
        H = false;
        this.x.a();
    }

    public void R() {
        PictureSelectionConfig pictureSelectionConfigC = PictureSelectionConfig.c();
        this.b = pictureSelectionConfigC;
        this.l = !pictureSelectionConfigC.s ? 1 : 0;
        if (q30.a(getContext(), "android.permission.CAMERA") == 0) {
            ub1 ub1VarL = ProcessCameraProvider.l(getContext());
            ub1VarL.a(new e(ub1VarL), q30.h(getContext()));
        }
    }

    public void d0() {
        k0();
        e0();
    }

    public CaptureLayout getCaptureLayout() {
        return this.t;
    }

    public m getImageAnalysis() {
        return this.f;
    }

    public String getOutputPath() {
        return getSandboxCameraOutputPath() + new Date().getTime() + ".jpg";
    }

    public void h0() {
        if (H) {
            return;
        }
        H = true;
        this.y.setVisibility(0);
        this.x.h();
    }

    public void l0() {
        TextView textView;
        if (!H || ((textView = this.y) != null && textView.getVisibility() == 0)) {
            if (H) {
                Q();
            }
            TextView textView2 = this.y;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            H = true;
            g0();
        }
    }

    public void m0() {
        if (this.b == null) {
            return;
        }
        this.l = this.l == 0 ? 1 : 0;
        O();
    }

    public void setCameraListener(du duVar) {
        this.m = duVar;
    }

    public void setCaptureLoadingColor(int i2) {
        this.t.setCaptureLoadingColor(i2);
    }

    public void setImageCallbackListener(mz0 mz0Var) {
        this.o = mz0Var;
    }

    public void setOnCameraSwitchListener(j jVar) {
        this.p = jVar;
    }

    public void setOnClickListener(gy gyVar) {
        this.n = gyVar;
    }

    public void setRecordVideoMaxTime(int i2) {
        this.t.setDuration(i2 * 1000);
    }

    public void setRecordVideoMinTime(int i2) {
        this.t.setMinDuration(i2 * 1000);
    }

    public MyCameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 35;
        this.k = 1;
        this.l = 1;
        this.w = 0L;
        this.G = new f();
        T();
    }

    public MyCameraView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = 35;
        this.k = 1;
        this.l = 1;
        this.w = 0L;
        this.G = new f();
        T();
    }
}
