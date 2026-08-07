package com.luck.picture.lib;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import defpackage.a22;
import defpackage.ol2;
import defpackage.y60;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class PicturePlayAudioActivity extends PictureBaseActivity implements View.OnClickListener {
    private String n;
    private MediaPlayer o;
    private SeekBar p;
    private TextView r;
    private TextView s;
    private TextView t;
    private TextView u;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f291q = false;
    public Runnable v = new b();

    class a implements SeekBar.OnSeekBarChangeListener {
        a() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (z) {
                PicturePlayAudioActivity.this.o.seekTo(i);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (PicturePlayAudioActivity.this.o != null) {
                    PicturePlayAudioActivity.this.u.setText(y60.b(PicturePlayAudioActivity.this.o.getCurrentPosition()));
                    PicturePlayAudioActivity.this.p.setProgress(PicturePlayAudioActivity.this.o.getCurrentPosition());
                    PicturePlayAudioActivity.this.p.setMax(PicturePlayAudioActivity.this.o.getDuration());
                    PicturePlayAudioActivity.this.t.setText(y60.b(PicturePlayAudioActivity.this.o.getDuration()));
                    PicturePlayAudioActivity picturePlayAudioActivity = PicturePlayAudioActivity.this;
                    picturePlayAudioActivity.h.postDelayed(picturePlayAudioActivity.v, 200L);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void s0(String str) {
        this.o = new MediaPlayer();
        try {
            if (a22.h(str)) {
                this.o.setDataSource(N(), Uri.parse(str));
            } else {
                this.o.setDataSource(str);
            }
            this.o.prepare();
            this.o.setLooping(true);
            v0();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t0() {
        s0(this.n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u0() {
        x0(this.n);
    }

    private void v0() {
        MediaPlayer mediaPlayer = this.o;
        if (mediaPlayer != null) {
            this.p.setProgress(mediaPlayer.getCurrentPosition());
            this.p.setMax(this.o.getDuration());
        }
        String string = this.r.getText().toString();
        int i = R$string.picture_play_audio;
        if (string.equals(getString(i))) {
            this.r.setText(getString(R$string.picture_pause_audio));
            this.s.setText(getString(i));
        } else {
            this.r.setText(getString(i));
            this.s.setText(getString(R$string.picture_pause_audio));
        }
        w0();
        if (this.f291q) {
            return;
        }
        this.h.post(this.v);
        this.f291q = true;
    }

    @Override // com.luck.picture.lib.PictureBaseActivity
    public int P() {
        return R$layout.picture_play_audio;
    }

    @Override // com.luck.picture.lib.PictureBaseActivity
    protected void V() {
        super.V();
        this.n = getIntent().getStringExtra("audioPath");
        this.s = (TextView) findViewById(R$id.tv_musicStatus);
        this.u = (TextView) findViewById(R$id.tv_musicTime);
        this.p = (SeekBar) findViewById(R$id.musicSeekBar);
        this.t = (TextView) findViewById(R$id.tv_musicTotal);
        this.r = (TextView) findViewById(R$id.tv_PlayPause);
        TextView textView = (TextView) findViewById(R$id.tv_Stop);
        TextView textView2 = (TextView) findViewById(R$id.tv_Quit);
        this.h.postDelayed(new Runnable() { // from class: b22
            @Override // java.lang.Runnable
            public final void run() {
                this.a.t0();
            }
        }, 30L);
        this.r.setOnClickListener(this);
        textView.setOnClickListener(this);
        textView2.setOnClickListener(this);
        this.p.setOnSeekBarChangeListener(new a());
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

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R$id.tv_PlayPause) {
            v0();
        }
        if (id == R$id.tv_Stop) {
            this.s.setText(getString(R$string.picture_stop_audio));
            this.r.setText(getString(R$string.picture_play_audio));
            x0(this.n);
        }
        if (id == R$id.tv_Quit) {
            this.h.removeCallbacks(this.v);
            this.h.postDelayed(new Runnable() { // from class: c22
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.u0();
                }
            }, 30L);
            try {
                L();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.luck.picture.lib.PictureBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        getWindow().setFlags(1024, 1024);
        super.onCreate(bundle);
    }

    @Override // com.luck.picture.lib.PictureBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (this.o != null) {
            this.h.removeCallbacks(this.v);
            this.o.release();
            this.o = null;
        }
    }

    public void w0() {
        try {
            MediaPlayer mediaPlayer = this.o;
            if (mediaPlayer != null) {
                if (mediaPlayer.isPlaying()) {
                    this.o.pause();
                } else {
                    this.o.start();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void x0(String str) {
        MediaPlayer mediaPlayer = this.o;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.stop();
                this.o.reset();
                if (a22.h(str)) {
                    this.o.setDataSource(N(), Uri.parse(str));
                } else {
                    this.o.setDataSource(str);
                }
                this.o.prepare();
                this.o.seekTo(0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
