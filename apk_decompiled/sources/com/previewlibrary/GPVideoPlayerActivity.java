package com.previewlibrary;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Toast;
import android.widget.VideoView;
import com.tencent.open.SocialConstants;

/* JADX INFO: loaded from: classes.dex */
public class GPVideoPlayerActivity extends Activity {
    VideoView a;

    class a implements MediaPlayer.OnErrorListener {
        a() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            Toast.makeText(GPVideoPlayerActivity.this, R$string.Playback_failed, 0).show();
            return false;
        }
    }

    public static void a(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) GPVideoPlayerActivity.class);
        intent.putExtra(SocialConstants.PARAM_URL, str);
        context.startActivity(intent);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_gpvideoplayer);
        VideoView videoView = (VideoView) findViewById(R$id.gpVideo);
        this.a = videoView;
        videoView.setVideoPath(getIntent().getStringExtra(SocialConstants.PARAM_URL));
        this.a.setOnErrorListener(new a());
        this.a.start();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.a.stopPlayback();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.a.pause();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.a.isPlaying()) {
            return;
        }
        this.a.start();
    }
}
