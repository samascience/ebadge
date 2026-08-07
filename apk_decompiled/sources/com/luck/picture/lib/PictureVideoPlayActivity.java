package com.luck.picture.lib;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.style.PictureCropParameterStyle;
import com.luck.picture.lib.style.PictureWindowAnimationStyle;
import com.tencent.connect.share.QzonePublish;
import defpackage.a22;
import defpackage.ol2;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class PictureVideoPlayActivity extends PictureBaseActivity implements MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, View.OnClickListener {
    private String n;
    private ImageButton o;
    private MediaController p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private VideoView f294q;
    private ImageView r;
    private int s = -1;

    class a extends ContextWrapper {
        a(Context context) {
            super(context);
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public Object getSystemService(String str) {
            return "audio".equals(str) ? getApplicationContext().getSystemService(str) : super.getSystemService(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean n0(MediaPlayer mediaPlayer, int i, int i2) {
        if (i != 3) {
            return false;
        }
        this.f294q.setBackgroundColor(0);
        return true;
    }

    @Override // com.luck.picture.lib.PictureBaseActivity
    public int P() {
        return R$layout.picture_activity_video_play;
    }

    @Override // com.luck.picture.lib.PictureBaseActivity
    protected void U() {
        PictureCropParameterStyle pictureCropParameterStyle = PictureSelectionConfig.u1;
    }

    @Override // com.luck.picture.lib.PictureBaseActivity
    protected void V() {
        super.V();
        this.n = getIntent().getStringExtra(QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH);
        boolean booleanExtra = getIntent().getBooleanExtra("isExternalPreviewVideo", false);
        if (TextUtils.isEmpty(this.n)) {
            LocalMedia localMedia = (LocalMedia) getIntent().getParcelableExtra("mediaKey");
            if (localMedia == null || TextUtils.isEmpty(localMedia.q())) {
                finish();
                return;
            }
            this.n = localMedia.q();
        }
        if (TextUtils.isEmpty(this.n)) {
            L();
            return;
        }
        this.o = (ImageButton) findViewById(R$id.pictureLeftBack);
        this.f294q = (VideoView) findViewById(R$id.video_view);
        TextView textView = (TextView) findViewById(R$id.tv_confirm);
        this.f294q.setBackgroundColor(-16777216);
        this.r = (ImageView) findViewById(R$id.iv_play);
        this.p = new MediaController(this);
        this.f294q.setOnCompletionListener(this);
        this.f294q.setOnPreparedListener(this);
        this.f294q.setMediaController(this.p);
        this.o.setOnClickListener(this);
        this.r.setOnClickListener(this);
        textView.setOnClickListener(this);
        PictureSelectionConfig pictureSelectionConfig = this.a;
        textView.setVisibility((pictureSelectionConfig.v == 1 && pictureSelectionConfig.k0 && !booleanExtra) ? 0 : 8);
    }

    @Override // com.luck.picture.lib.PictureBaseActivity
    public boolean W() {
        return false;
    }

    @Override // com.luck.picture.lib.PictureBaseActivity, androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(new a(context));
    }

    @Override // com.luck.picture.lib.PictureBaseActivity, android.app.Activity
    public boolean isImmersive() {
        return false;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        PictureWindowAnimationStyle pictureWindowAnimationStyle = PictureSelectionConfig.v1;
        if (pictureWindowAnimationStyle == null || pictureWindowAnimationStyle.d == 0) {
            L();
        } else {
            finish();
            overridePendingTransition(0, PictureSelectionConfig.v1.d);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R$id.pictureLeftBack) {
            onBackPressed();
            return;
        }
        if (id == R$id.iv_play) {
            this.f294q.start();
            this.r.setVisibility(4);
        } else if (id == R$id.tv_confirm) {
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            arrayList.add((LocalMedia) getIntent().getParcelableExtra("mediaKey"));
            setResult(-1, new Intent().putParcelableArrayListExtra("selectList", arrayList));
            onBackPressed();
        }
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        ImageView imageView = this.r;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    @Override // com.luck.picture.lib.PictureBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        getWindow().addFlags(67108864);
        super.onCreate(bundle);
    }

    @Override // com.luck.picture.lib.PictureBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        this.p = null;
        this.f294q = null;
        this.r = null;
        super.onDestroy();
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        return false;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        this.s = this.f294q.getCurrentPosition();
        this.f294q.stopPlayback();
        super.onPause();
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: j32
            @Override // android.media.MediaPlayer.OnInfoListener
            public final boolean onInfo(MediaPlayer mediaPlayer2, int i, int i2) {
                return this.a.n0(mediaPlayer2, i, i2);
            }
        });
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        int i = this.s;
        if (i >= 0) {
            this.f294q.seekTo(i);
            this.s = -1;
        }
        super.onResume();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        if (ol2.a() && a22.h(this.n)) {
            this.f294q.setVideoURI(Uri.parse(this.n));
        } else {
            this.f294q.setVideoPath(this.n);
        }
        this.f294q.start();
        super.onStart();
    }
}
