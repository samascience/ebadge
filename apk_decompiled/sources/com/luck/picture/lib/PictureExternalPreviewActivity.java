package com.luck.picture.lib;

import android.content.ContentValues;
import android.graphics.PointF;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.viewpager.widget.ViewPager;
import com.luck.picture.lib.PictureExternalPreviewActivity;
import com.luck.picture.lib.compress.Checker;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.photoview.PhotoView;
import com.luck.picture.lib.style.PictureCropParameterStyle;
import com.luck.picture.lib.thread.PictureThreadUtils;
import com.luck.picture.lib.widget.PreviewViewPager;
import com.luck.picture.lib.widget.longimage.ImageViewState;
import com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView;
import com.tencent.connect.common.Constants;
import defpackage.a22;
import defpackage.cb;
import defpackage.d12;
import defpackage.db3;
import defpackage.dv1;
import defpackage.gi1;
import defpackage.k01;
import defpackage.ll2;
import defpackage.mw1;
import defpackage.ol2;
import defpackage.p33;
import defpackage.rn;
import defpackage.s12;
import defpackage.vt;
import defpackage.wz1;
import defpackage.y02;
import defpackage.y60;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class PictureExternalPreviewActivity extends PictureBaseActivity implements View.OnClickListener {
    private int n;
    private int o;
    private ImageButton p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private TextView f290q;
    private PreviewViewPager r;
    private final List s = new ArrayList();
    private int t = 0;
    private d u;
    private String v;
    private String w;
    private ImageButton x;
    private View y;

    class a implements ViewPager.j {
        a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageSelected(int i) {
            PictureExternalPreviewActivity.this.f290q.setText(PictureExternalPreviewActivity.this.getString(R$string.picture_preview_image_num, Integer.valueOf(i + 1), Integer.valueOf(PictureExternalPreviewActivity.this.s.size())));
            PictureExternalPreviewActivity.this.t = i;
            PictureExternalPreviewActivity.this.c1();
        }
    }

    class b extends PictureThreadUtils.d {
        b() {
        }

        @Override // com.luck.picture.lib.thread.PictureThreadUtils.e
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public String d() {
            PictureExternalPreviewActivity pictureExternalPreviewActivity = PictureExternalPreviewActivity.this;
            return pictureExternalPreviewActivity.b1(pictureExternalPreviewActivity.v);
        }

        @Override // com.luck.picture.lib.thread.PictureThreadUtils.e
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(String str) {
            PictureThreadUtils.e(PictureThreadUtils.j());
            PictureExternalPreviewActivity.this.W0(str);
            PictureExternalPreviewActivity.this.K();
        }
    }

    class c extends PictureThreadUtils.d {
        final /* synthetic */ Uri f;
        final /* synthetic */ Uri g;

        c(Uri uri, Uri uri2) {
            this.f = uri;
            this.g = uri2;
        }

        @Override // com.luck.picture.lib.thread.PictureThreadUtils.e
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public String d() {
            try {
                return s12.v(y02.a(PictureExternalPreviewActivity.this.N(), this.f), y02.b(PictureExternalPreviewActivity.this.N(), this.g)) ? s12.l(PictureExternalPreviewActivity.this.N(), this.g) : Constants.STR_EMPTY;
            } catch (Exception e) {
                e.printStackTrace();
                return Constants.STR_EMPTY;
            }
        }

        @Override // com.luck.picture.lib.thread.PictureThreadUtils.e
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(String str) {
            PictureThreadUtils.e(PictureThreadUtils.j());
            PictureExternalPreviewActivity.this.W0(str);
        }
    }

    public class d extends androidx.viewpager.widget.a {
        private final SparseArray c = new SparseArray();
        VideoView d = null;

        class a implements dv1 {
            final /* synthetic */ String a;

            a(String str) {
                this.a = str;
            }

            @Override // defpackage.dv1
            public void a() {
                if (TextUtils.equals(this.a, ((LocalMedia) PictureExternalPreviewActivity.this.s.get(PictureExternalPreviewActivity.this.r.getCurrentItem())).q())) {
                    PictureExternalPreviewActivity.this.f0();
                }
            }

            @Override // defpackage.dv1
            public void b() {
                PictureExternalPreviewActivity.this.K();
            }
        }

        public d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void A(View view, float f, float f2) {
            PictureExternalPreviewActivity.this.finish();
            PictureExternalPreviewActivity.this.L0();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void B(View view) {
            PictureExternalPreviewActivity.this.finish();
            PictureExternalPreviewActivity.this.L0();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ boolean C(String str, LocalMedia localMedia, View view) {
            PictureExternalPreviewActivity pictureExternalPreviewActivity = PictureExternalPreviewActivity.this;
            if (pictureExternalPreviewActivity.a.F0) {
                if (wz1.a(pictureExternalPreviewActivity.N(), "android.permission.READ_EXTERNAL_STORAGE")) {
                    PictureExternalPreviewActivity.this.v = str;
                    String strA = (a22.l(str) && TextUtils.isEmpty(localMedia.n())) ? a22.a(localMedia.q()) : localMedia.n();
                    PictureExternalPreviewActivity pictureExternalPreviewActivity2 = PictureExternalPreviewActivity.this;
                    if (a22.o(strA)) {
                        strA = Checker.MIME_TYPE_JPEG;
                    }
                    pictureExternalPreviewActivity2.w = strA;
                    PictureExternalPreviewActivity.this.a1();
                } else {
                    wz1.d(PictureExternalPreviewActivity.this, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 1);
                }
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ boolean D(String str, LocalMedia localMedia, View view) {
            PictureExternalPreviewActivity pictureExternalPreviewActivity = PictureExternalPreviewActivity.this;
            if (pictureExternalPreviewActivity.a.F0) {
                if (wz1.a(pictureExternalPreviewActivity.N(), "android.permission.READ_EXTERNAL_STORAGE")) {
                    PictureExternalPreviewActivity.this.v = str;
                    String strA = (a22.l(str) && TextUtils.isEmpty(localMedia.n())) ? a22.a(localMedia.q()) : localMedia.n();
                    PictureExternalPreviewActivity pictureExternalPreviewActivity2 = PictureExternalPreviewActivity.this;
                    if (a22.o(strA)) {
                        strA = Checker.MIME_TYPE_JPEG;
                    }
                    pictureExternalPreviewActivity2.w = strA;
                    PictureExternalPreviewActivity.this.a1();
                } else {
                    wz1.d(PictureExternalPreviewActivity.this, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 1);
                }
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void E(LocalMedia localMedia, VideoView videoView, String str, PhotoView photoView, SubsamplingScaleImageView subsamplingScaleImageView, ImageView imageView, View view) {
            PictureCropParameterStyle pictureCropParameterStyle = PictureSelectionConfig.u1;
            PictureExternalPreviewActivity.this.X0(videoView, str, photoView, subsamplingScaleImageView, imageView);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void z() {
            this.c.clear();
            G();
        }

        public void F(int i) {
            if (i < this.c.size()) {
                this.c.removeAt(i);
            }
        }

        void G() {
            VideoView videoView = this.d;
            if (videoView != null) {
                try {
                    videoView.stopPlayback();
                } catch (Exception unused) {
                }
                this.d = null;
            }
        }

        @Override // androidx.viewpager.widget.a
        public void a(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
            if (this.c.size() > 20) {
                this.c.remove(i);
            }
        }

        @Override // androidx.viewpager.widget.a
        public int d() {
            return PictureExternalPreviewActivity.this.s.size();
        }

        @Override // androidx.viewpager.widget.a
        public int e(Object obj) {
            return -2;
        }

        @Override // androidx.viewpager.widget.a
        public Object h(ViewGroup viewGroup, int i) {
            final String strC;
            View viewInflate = (View) this.c.get(i);
            if (viewInflate == null) {
                viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.picture_image_preview, viewGroup, false);
                this.c.put(i, viewInflate);
            }
            View view = viewInflate;
            final PhotoView photoView = (PhotoView) view.findViewById(R$id.preview_image);
            final SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) view.findViewById(R$id.longImg);
            final VideoView videoView = (VideoView) view.findViewById(R$id.video_view);
            final ImageView imageView = (ImageView) view.findViewById(R$id.iv_play);
            final LocalMedia localMedia = (LocalMedia) PictureExternalPreviewActivity.this.s.get(i);
            if (PictureExternalPreviewActivity.this.a.n1) {
                float fMin = Math.min(localMedia.u(), localMedia.l());
                float fMax = Math.max(localMedia.l(), localMedia.u());
                if (fMin > 0.0f && fMax > 0.0f) {
                    int iCeil = (int) Math.ceil((fMax * fMin) / fMin);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) photoView.getLayoutParams();
                    layoutParams.width = PictureExternalPreviewActivity.this.n;
                    if (iCeil < PictureExternalPreviewActivity.this.o) {
                        iCeil += PictureExternalPreviewActivity.this.o;
                    }
                    layoutParams.height = iCeil;
                    layoutParams.gravity = 17;
                }
            }
            if (localMedia.z() && !localMedia.x()) {
                strC = localMedia.i();
            } else if (localMedia.x() || (localMedia.z() && localMedia.x())) {
                strC = localMedia.c();
            } else {
                strC = localMedia.E() ? localMedia.a() : localMedia.q();
            }
            boolean zL = a22.l(strC);
            String strA = (zL && TextUtils.isEmpty(localMedia.n())) ? a22.a(localMedia.q()) : localMedia.n();
            boolean zN = a22.n(strA);
            boolean zI = a22.i(strA);
            boolean zJ = gi1.j(localMedia);
            int i2 = 8;
            videoView.setVisibility(8);
            imageView.setVisibility(zN ? 0 : 8);
            if (zN) {
                photoView.setVisibility(0);
                subsamplingScaleImageView.setVisibility(8);
                k01 k01Var = PictureSelectionConfig.w1;
                if (k01Var != null) {
                    if (zL) {
                        k01Var.c(view.getContext(), strC, photoView);
                    } else {
                        k01Var.c(view.getContext(), strC, photoView);
                    }
                }
            } else {
                photoView.setVisibility((!zJ || zI) ? 0 : 8);
                if (zJ && !zI) {
                    i2 = 0;
                }
                subsamplingScaleImageView.setVisibility(i2);
                k01 k01Var2 = PictureSelectionConfig.w1;
                if (k01Var2 != null) {
                    if (zL) {
                        k01Var2.a(view.getContext(), strC, photoView, subsamplingScaleImageView, new a(strC));
                    } else if (zJ) {
                        PictureExternalPreviewActivity.this.K0(a22.h(strC) ? Uri.parse(strC) : Uri.fromFile(new File(strC)), subsamplingScaleImageView);
                    } else {
                        k01Var2.c(view.getContext(), strC, photoView);
                    }
                }
            }
            photoView.setOnViewTapListener(new mw1() { // from class: n12
                @Override // defpackage.mw1
                public final void a(View view2, float f, float f2) {
                    this.a.A(view2, f, f2);
                }
            });
            subsamplingScaleImageView.setOnClickListener(new View.OnClickListener() { // from class: o12
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.a.B(view2);
                }
            });
            if (!zN) {
                subsamplingScaleImageView.setOnLongClickListener(new View.OnLongClickListener() { // from class: p12
                    @Override // android.view.View.OnLongClickListener
                    public final boolean onLongClick(View view2) {
                        return this.a.C(strC, localMedia, view2);
                    }
                });
            }
            if (!zN) {
                photoView.setOnLongClickListener(new View.OnLongClickListener() { // from class: q12
                    @Override // android.view.View.OnLongClickListener
                    public final boolean onLongClick(View view2) {
                        return this.a.D(strC, localMedia, view2);
                    }
                });
            }
            final String str = strC;
            imageView.setOnClickListener(new View.OnClickListener() { // from class: r12
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.a.E(localMedia, videoView, str, photoView, subsamplingScaleImageView, imageView, view2);
                }
            });
            viewGroup.addView(view, 0);
            return view;
        }

        @Override // androidx.viewpager.widget.a
        public boolean i(View view, Object obj) {
            return view == obj;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K0(Uri uri, SubsamplingScaleImageView subsamplingScaleImageView) {
        subsamplingScaleImageView.setQuickScaleEnabled(true);
        subsamplingScaleImageView.setZoomEnabled(true);
        subsamplingScaleImageView.setDoubleTapZoomDuration(100);
        subsamplingScaleImageView.setMinimumScaleType(2);
        subsamplingScaleImageView.setDoubleTapZoomDpi(2);
        subsamplingScaleImageView.E0(com.luck.picture.lib.widget.longimage.a.n(uri), new ImageViewState(0.0f, new PointF(0.0f, 0.0f), 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L0() {
        overridePendingTransition(R$anim.picture_anim_fade_in, PictureSelectionConfig.v1.d);
    }

    private void M0() {
        this.f290q.setText(getString(R$string.picture_preview_image_num, Integer.valueOf(this.t + 1), Integer.valueOf(this.s.size())));
        d dVar = new d();
        this.u = dVar;
        this.r.setAdapter(dVar);
        this.r.setCurrentItem(this.t);
        this.r.c(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N0(VideoView videoView, PhotoView photoView, ImageView imageView) {
        videoView.setVisibility(8);
        photoView.setVisibility(0);
        imageView.setVisibility(0);
        photoView.invalidate();
        d dVar = this.u;
        if (dVar != null) {
            dVar.d = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O0(final VideoView videoView, final PhotoView photoView, final ImageView imageView, MediaPlayer mediaPlayer) {
        videoView.post(new Runnable() { // from class: m12
            @Override // java.lang.Runnable
            public final void run() {
                this.a.N0(videoView, photoView, imageView);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P0(VideoView videoView, PhotoView photoView, ImageView imageView) {
        videoView.setVisibility(8);
        photoView.setVisibility(0);
        imageView.setVisibility(0);
        photoView.invalidate();
        d dVar = this.u;
        if (dVar != null) {
            dVar.d = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean Q0(final VideoView videoView, final PhotoView photoView, final ImageView imageView, MediaPlayer mediaPlayer, int i, int i2) {
        p33.b(N(), "视频播放失败");
        videoView.post(new Runnable() { // from class: k12
            @Override // java.lang.Runnable
            public final void run() {
                this.a.P0(videoView, photoView, imageView);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void R0(VideoView videoView) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) videoView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.gravity = 17;
            videoView.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void S0(final VideoView videoView, MediaPlayer mediaPlayer) {
        videoView.post(new Runnable() { // from class: l12
            @Override // java.lang.Runnable
            public final void run() {
                PictureExternalPreviewActivity.R0(videoView);
            }
        });
        mediaPlayer.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T0(VideoView videoView, PhotoView photoView, ImageView imageView) {
        videoView.setVisibility(8);
        photoView.setVisibility(0);
        imageView.setVisibility(0);
        photoView.invalidate();
        d dVar = this.u;
        if (dVar != null) {
            dVar.d = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U0(d12 d12Var, View view) {
        if (isFinishing()) {
            return;
        }
        d12Var.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V0(d12 d12Var, View view) throws Throwable {
        if (a22.l(this.v)) {
            f0();
            PictureThreadUtils.h(new b());
        } else if (ol2.a()) {
            Z0(a22.h(this.v) ? Uri.parse(this.v) : Uri.fromFile(new File(this.v)));
        } else {
            Y0();
        }
        if (isFinishing()) {
            return;
        }
        d12Var.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W0(String str) {
        if (TextUtils.isEmpty(str)) {
            p33.b(N(), getString(R$string.picture_save_error));
            return;
        }
        new com.luck.picture.lib.a(N(), str, null);
        p33.b(N(), getString(R$string.picture_save_success) + "\n" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X0(final VideoView videoView, String str, final PhotoView photoView, SubsamplingScaleImageView subsamplingScaleImageView, final ImageView imageView) {
        Uri uriFromFile;
        try {
            c1();
            d dVar = this.u;
            if (dVar != null) {
                dVar.d = videoView;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) videoView.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            }
            layoutParams.gravity = 17;
            videoView.setLayoutParams(layoutParams);
            photoView.setVisibility(8);
            subsamplingScaleImageView.setVisibility(8);
            imageView.setVisibility(8);
            videoView.setVisibility(0);
            MediaController mediaController = new MediaController(N());
            mediaController.setAnchorView(videoView);
            videoView.setMediaController(mediaController);
            if (a22.l(str)) {
                uriFromFile = Uri.parse(str);
            } else {
                uriFromFile = (ol2.a() && a22.h(str)) ? Uri.parse(str) : Uri.fromFile(new File(str));
            }
            videoView.setVideoURI(uriFromFile);
            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: g12
                @Override // android.media.MediaPlayer.OnCompletionListener
                public final void onCompletion(MediaPlayer mediaPlayer) {
                    this.a.O0(videoView, photoView, imageView, mediaPlayer);
                }
            });
            videoView.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: h12
                @Override // android.media.MediaPlayer.OnErrorListener
                public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                    return this.a.Q0(videoView, photoView, imageView, mediaPlayer, i, i2);
                }
            });
            videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: i12
                @Override // android.media.MediaPlayer.OnPreparedListener
                public final void onPrepared(MediaPlayer mediaPlayer) {
                    PictureExternalPreviewActivity.S0(videoView, mediaPlayer);
                }
            });
            videoView.requestFocus();
        } catch (Exception e) {
            p33.b(N(), "无法播放视频: " + e.getMessage());
            videoView.post(new Runnable() { // from class: j12
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.T0(videoView, photoView, imageView);
                }
            });
        }
    }

    private void Y0() throws Throwable {
        String absolutePath;
        String strC = a22.c(this.w);
        String externalStorageState = Environment.getExternalStorageState();
        File externalStoragePublicDirectory = externalStorageState.equals("mounted") ? Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM) : N().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        if (externalStoragePublicDirectory != null && !externalStoragePublicDirectory.exists()) {
            externalStoragePublicDirectory.mkdirs();
        }
        if (ol2.a() || !externalStorageState.equals("mounted")) {
            absolutePath = externalStoragePublicDirectory.getAbsolutePath();
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(externalStoragePublicDirectory.getAbsolutePath());
            String str = File.separator;
            sb.append(str);
            sb.append("Camera");
            sb.append(str);
            absolutePath = sb.toString();
        }
        File file = new File(absolutePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, y60.d("IMG_") + strC);
        s12.b(this.v, file2.getAbsolutePath());
        W0(file2.getAbsolutePath());
    }

    private void Z0(Uri uri) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_display_name", y60.d("IMG_"));
        contentValues.put("datetaken", db3.e(Long.valueOf(System.currentTimeMillis())));
        contentValues.put("mime_type", this.w);
        contentValues.put("relative_path", "DCIM/Camera");
        Uri uriInsert = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
        if (uriInsert == null) {
            p33.b(N(), getString(R$string.picture_save_error));
        } else {
            PictureThreadUtils.h(new c(uri, uriInsert));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a1() {
        if (isFinishing() || TextUtils.isEmpty(this.v)) {
            return;
        }
        final d12 d12Var = new d12(N(), R$layout.picture_wind_base_dialog);
        Button button = (Button) d12Var.findViewById(R$id.btn_cancel);
        Button button2 = (Button) d12Var.findViewById(R$id.btn_commit);
        TextView textView = (TextView) d12Var.findViewById(R$id.tvTitle);
        TextView textView2 = (TextView) d12Var.findViewById(R$id.tv_content);
        textView.setText(getString(R$string.picture_prompt));
        textView2.setText(getString(R$string.picture_prompt_content));
        button.setOnClickListener(new View.OnClickListener() { // from class: e12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.U0(d12Var, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: f12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Throwable {
                this.a.V0(d12Var, view);
            }
        });
        d12Var.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c1() {
        d dVar = this.u;
        if (dVar != null) {
            dVar.G();
        }
    }

    @Override // com.luck.picture.lib.PictureBaseActivity
    public int P() {
        return R$layout.picture_activity_external_preview;
    }

    @Override // com.luck.picture.lib.PictureBaseActivity
    public void U() {
        PictureCropParameterStyle pictureCropParameterStyle = PictureSelectionConfig.u1;
        int iB = cb.b(N(), R$attr.picture_ac_preview_title_bg);
        if (iB != 0) {
            this.y.setBackgroundColor(iB);
        } else {
            this.y.setBackgroundColor(this.d);
        }
    }

    @Override // com.luck.picture.lib.PictureBaseActivity
    protected void V() {
        super.V();
        this.y = findViewById(R$id.titleBar);
        this.f290q = (TextView) findViewById(R$id.picture_title);
        this.p = (ImageButton) findViewById(R$id.left_back);
        this.x = (ImageButton) findViewById(R$id.ib_delete);
        this.r = (PreviewViewPager) findViewById(R$id.preview_pager);
        this.t = getIntent().getIntExtra("position", 0);
        this.n = ll2.c(N());
        this.o = ll2.b(N());
        ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("previewSelectList");
        if (parcelableArrayListExtra != null && parcelableArrayListExtra.size() > 0) {
            this.s.addAll(parcelableArrayListExtra);
        }
        this.p.setOnClickListener(this);
        this.x.setOnClickListener(this);
        ImageButton imageButton = this.x;
        PictureCropParameterStyle pictureCropParameterStyle = PictureSelectionConfig.u1;
        imageButton.setVisibility(8);
        M0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v3 */
    public String b1(String str) throws Throwable {
        OutputStream outputStreamB;
        InputStream inputStreamOpenStream;
        Uri uriFromFile;
        String string;
        ?? r1 = 0;
        r1 = 0;
        try {
            try {
                try {
                    if (ol2.a()) {
                        uriFromFile = vt.g(N(), Constants.STR_EMPTY, this.w);
                    } else {
                        String strC = a22.c(this.w);
                        String externalStorageState = Environment.getExternalStorageState();
                        File externalStoragePublicDirectory = externalStorageState.equals("mounted") ? Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM) : N().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
                        if (!externalStoragePublicDirectory.exists()) {
                            externalStoragePublicDirectory.mkdirs();
                        }
                        if (externalStorageState.equals("mounted")) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(externalStoragePublicDirectory.getAbsolutePath());
                            String str2 = File.separator;
                            sb.append(str2);
                            sb.append("Camera");
                            sb.append(str2);
                            string = sb.toString();
                        } else {
                            string = externalStoragePublicDirectory.getAbsolutePath();
                        }
                        File file = new File(string);
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        uriFromFile = Uri.fromFile(new File(file, y60.d("IMG_") + strC));
                    }
                    try {
                        outputStreamB = y02.b(N(), uriFromFile);
                        try {
                            inputStreamOpenStream = new URL(str).openStream();
                            try {
                                if (s12.v(inputStreamOpenStream, outputStreamB)) {
                                    String strL = s12.l(this, uriFromFile);
                                    s12.a(inputStreamOpenStream);
                                    s12.a(outputStreamB);
                                    return strL;
                                }
                            } catch (Exception unused) {
                                if (ol2.a()) {
                                    gi1.c(N(), uriFromFile);
                                }
                            }
                        } catch (Exception unused2) {
                            inputStreamOpenStream = null;
                        } catch (Throwable th) {
                            th = th;
                            s12.a(r1);
                            s12.a(outputStreamB);
                            throw th;
                        }
                    } catch (Exception unused3) {
                        inputStreamOpenStream = null;
                        outputStreamB = null;
                    }
                } catch (Throwable th2) {
                    r1 = str;
                    th = th2;
                }
            } catch (Exception unused4) {
                inputStreamOpenStream = null;
                uriFromFile = null;
                outputStreamB = null;
            }
            s12.a(inputStreamOpenStream);
            s12.a(outputStreamB);
            return null;
        } catch (Throwable th3) {
            th = th3;
            outputStreamB = null;
        }
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        d dVar = this.u;
        if (dVar != null) {
            dVar.z();
        }
        PictureSelectionConfig.a();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (ol2.a()) {
            finishAfterTransition();
        } else {
            super.onBackPressed();
        }
        finish();
        L0();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R$id.left_back) {
            finish();
            L0();
            return;
        }
        if (id != R$id.ib_delete || this.s.size() <= 0) {
            return;
        }
        int currentItem = this.r.getCurrentItem();
        this.s.remove(currentItem);
        this.u.F(currentItem);
        Bundle bundle = new Bundle();
        bundle.putInt("position", currentItem);
        rn.e(N()).a("com.luck.picture.lib.action.delete_preview_position").d(bundle).b();
        if (this.s.size() == 0) {
            onBackPressed();
            return;
        }
        this.f290q.setText(getString(R$string.picture_preview_image_num, Integer.valueOf(this.t + 1), Integer.valueOf(this.s.size())));
        this.t = currentItem;
        this.u.j();
    }

    @Override // com.luck.picture.lib.PictureBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 1) {
            for (int i2 : iArr) {
                if (i2 == 0) {
                    a1();
                } else {
                    p33.b(N(), getString(R$string.picture_jurisdiction));
                }
            }
        }
    }
}
