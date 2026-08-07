package io.microshow.rxffmpeg.player;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes4.dex */
public abstract class RxFFmpegPlayerController extends FrameLayout {
    protected RxFFmpegPlayerView a;

    public RxFFmpegPlayerController(Context context) {
        super(context);
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(getLayoutId(), (ViewGroup) this, true);
        c();
    }

    protected abstract void b();

    protected abstract void c();

    protected abstract int getLayoutId();

    public void setPlayerView(RxFFmpegPlayerView rxFFmpegPlayerView) {
        if (rxFFmpegPlayerView != null) {
            this.a = rxFFmpegPlayerView;
            b();
        }
    }
}
