package io.microshow.rxffmpeg.player;

import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import defpackage.qw0;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MeasureHelper {
    private WeakReference a;
    private a b;
    private int c;
    private FitModel d = FitModel.FM_DEFAULT;

    public enum FitModel {
        FM_DEFAULT,
        FM_FULL_SCREEN_WIDTH,
        FM_FULL_SCREEN_HEIGHT,
        FM_WH_16X9
    }

    public static class a {
        private int a;
        private int b;
        private float c;

        public a(int i, int i2, float f) {
            this.a = i;
            this.b = i2;
            this.c = f;
        }

        public float a() {
            return this.c;
        }

        public int b() {
            return this.b;
        }

        public int c() {
            return this.a;
        }
    }

    public MeasureHelper(View view) {
        this.a = new WeakReference(view);
    }

    public int[] a(int i, int i2) {
        FitModel fitModel = this.d;
        if (fitModel == FitModel.FM_DEFAULT || fitModel == FitModel.FM_FULL_SCREEN_HEIGHT) {
            i2 = this.c;
        }
        return new int[]{i, i2};
    }

    public a b() {
        return this.b;
    }

    public View c() {
        View view;
        WeakReference weakReference = this.a;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return null;
        }
        return view;
    }

    public abstract boolean d();

    public void e() {
        View viewC = c();
        if (viewC instanceof RxFFmpegPlayerView) {
            RxFFmpegPlayerView rxFFmpegPlayerView = (RxFFmpegPlayerView) viewC;
            int iD = qw0.d(viewC.getContext());
            int i = (iD * 9) / 16;
            h(new a(iD, i, iD / i));
            g(rxFFmpegPlayerView.getTextureView(), rxFFmpegPlayerView.getContainerView());
        }
    }

    public void f(FitModel fitModel) {
        this.d = fitModel;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0051  */
    public void g(TextureView textureView, FrameLayout frameLayout) {
        int i;
        if (textureView == null || frameLayout == null || b() == null) {
            return;
        }
        int iC = b().c();
        int iB = b().b();
        b().a();
        float f = iC / iB;
        int iD = qw0.d(c().getContext());
        if (!d()) {
            FitModel fitModel = this.d;
            if (fitModel == FitModel.FM_FULL_SCREEN_WIDTH) {
                i = (int) (iD / f);
            } else if (fitModel == FitModel.FM_FULL_SCREEN_HEIGHT) {
                iD = qw0.b(c().getContext());
            } else if (fitModel == FitModel.FM_WH_16X9) {
                iD = (iD * 9) / 16;
            } else if (iC > iB) {
                i = (int) (iD / f);
            } else if (iC >= iB) {
                i = iD;
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iD, i);
            layoutParams.gravity = 17;
            textureView.setLayoutParams(layoutParams);
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(qw0.d(c().getContext()), i));
            this.c = i;
            c().requestLayout();
        }
        iD = qw0.c(c().getContext());
        int i2 = iD;
        iD = (int) (iD * f);
        i = i2;
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(iD, i);
        layoutParams2.gravity = 17;
        textureView.setLayoutParams(layoutParams2);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(qw0.d(c().getContext()), i));
        this.c = i;
        c().requestLayout();
    }

    public void h(a aVar) {
        this.b = aVar;
    }
}
