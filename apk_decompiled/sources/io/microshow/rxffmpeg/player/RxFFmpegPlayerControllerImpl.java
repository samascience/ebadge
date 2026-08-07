package io.microshow.rxffmpeg.player;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import defpackage.my0;
import io.microshow.rxffmpeg.R$id;
import io.microshow.rxffmpeg.R$layout;
import io.microshow.rxffmpeg.R$mipmap;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes4.dex */
public class RxFFmpegPlayerControllerImpl extends RxFFmpegPlayerController {
    private TextView b;
    private SeekBar c;
    private ProgressBar d;
    private View e;
    private ImageView f;
    private View g;
    private ImageView h;
    private boolean i;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            RxFFmpegPlayerControllerImpl.this.a.h();
            RxFFmpegPlayerControllerImpl.this.g.setVisibility(8);
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            RxFFmpegPlayerView rxFFmpegPlayerView = RxFFmpegPlayerControllerImpl.this.a;
            if (rxFFmpegPlayerView != null) {
                rxFFmpegPlayerView.j();
            }
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            RxFFmpegPlayerControllerImpl.this.e();
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            RxFFmpegPlayerView rxFFmpegPlayerView = RxFFmpegPlayerControllerImpl.this.a;
            if (rxFFmpegPlayerView != null) {
                if (rxFFmpegPlayerView.f()) {
                    RxFFmpegPlayerControllerImpl.this.a.g();
                } else {
                    RxFFmpegPlayerControllerImpl.this.a.i();
                }
            }
        }
    }

    public static class e implements my0 {
        private WeakReference a;

        e(RxFFmpegPlayerControllerImpl rxFFmpegPlayerControllerImpl) {
            this.a = new WeakReference(rxFFmpegPlayerControllerImpl);
        }
    }

    public RxFFmpegPlayerControllerImpl(Context context) {
        super(context);
        this.i = false;
    }

    @Override // io.microshow.rxffmpeg.player.RxFFmpegPlayerController
    public void b() {
        new e(this);
        throw null;
    }

    @Override // io.microshow.rxffmpeg.player.RxFFmpegPlayerController
    public void c() {
        this.e = findViewById(R$id.bottomPanel);
        this.c = (SeekBar) findViewById(R$id.progress_view);
        this.b = (TextView) findViewById(R$id.time_view);
        this.d = (ProgressBar) findViewById(R$id.progressBar);
        this.f = (ImageView) findViewById(R$id.iv_play);
        View viewFindViewById = findViewById(R$id.repeatPlay);
        this.g = viewFindViewById;
        viewFindViewById.setOnClickListener(new a());
        findViewById(R$id.iv_fullscreen).setOnClickListener(new b());
        ImageView imageView = (ImageView) findViewById(R$id.iv_mute);
        this.h = imageView;
        imageView.setOnClickListener(new c());
        this.f.setOnClickListener(new d());
    }

    public void e() {
        RxFFmpegPlayerView rxFFmpegPlayerView = this.a;
        if (rxFFmpegPlayerView != null) {
            if (rxFFmpegPlayerView.getVolume() == 0) {
                this.a.setVolume(100);
                this.h.setImageResource(R$mipmap.rxffmpeg_player_unmute);
            } else {
                this.a.setVolume(0);
                this.h.setImageResource(R$mipmap.rxffmpeg_player_mute);
            }
        }
    }

    @Override // io.microshow.rxffmpeg.player.RxFFmpegPlayerController
    public int getLayoutId() {
        return R$layout.rxffmpeg_player_controller;
    }
}
