package io.microshow.rxffmpeg.player;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import defpackage.my0;
import defpackage.qw0;

/* JADX INFO: loaded from: classes4.dex */
public class RxFFmpegPlayerView extends FrameLayout {
    public PlayerCoreType a;
    private Context b;
    private MeasureHelper c;
    private FrameLayout d;
    private TextureView e;
    private int f;

    public enum PlayerCoreType {
        PCT_RXFFMPEG_PLAYER,
        PCT_SYSTEM_MEDIA_PLAYER
    }

    class a extends MeasureHelper {
        a(View view) {
            super(view);
        }

        @Override // io.microshow.rxffmpeg.player.MeasureHelper
        public boolean d() {
            return RxFFmpegPlayerView.this.f == 1;
        }
    }

    public RxFFmpegPlayerView(Context context) {
        this(context, null);
    }

    private void d() {
        FrameLayout frameLayout = new FrameLayout(this.b);
        this.d = frameLayout;
        frameLayout.setBackgroundColor(-16777216);
        addView(this.d, new FrameLayout.LayoutParams(-1, -1));
    }

    public boolean b() {
        ViewGroup viewGroupG;
        if (this.f == 1 || (viewGroupG = qw0.g(this.b, true)) == null) {
            return false;
        }
        removeView(this.d);
        viewGroupG.addView(this.d, new FrameLayout.LayoutParams(-1, -1));
        this.f = 1;
        return true;
    }

    public boolean c() {
        ViewGroup viewGroupG;
        if (this.f != 1 || (viewGroupG = qw0.g(this.b, false)) == null) {
            return false;
        }
        viewGroupG.removeView(this.d);
        addView(this.d, new FrameLayout.LayoutParams(-1, -1));
        this.f = 0;
        return false;
    }

    public boolean e() {
        return this.f == 1;
    }

    public boolean f() {
        return false;
    }

    public void g() {
    }

    public FrameLayout getContainerView() {
        return this.d;
    }

    public int getMuteSolo() {
        return 0;
    }

    public TextureView getTextureView() {
        return this.e;
    }

    public int getVolume() {
        return 100;
    }

    public void h() {
    }

    public void i() {
    }

    public boolean j() {
        return e() ? c() : b();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        MeasureHelper measureHelper = this.c;
        if (measureHelper != null) {
            measureHelper.g(this.e, this.d);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int[] iArrA = this.c.a(getMeasuredWidth(), getMeasuredHeight());
        setMeasuredDimension(iArrA[0], iArrA[1]);
    }

    public void setFitModel(MeasureHelper.FitModel fitModel) {
        MeasureHelper measureHelper = this.c;
        if (measureHelper == null || fitModel == null) {
            return;
        }
        measureHelper.f(fitModel);
        this.c.e();
    }

    public void setMuteSolo(int i) {
    }

    public void setOnCompleteListener(my0 my0Var) {
    }

    public void setPlayerBackgroundColor(int i) {
        FrameLayout frameLayout = this.d;
        if (frameLayout != null) {
            frameLayout.setBackgroundColor(i);
        }
    }

    public void setTextureViewEnabledTouch(boolean z) {
        TextureView textureView = this.e;
        if (textureView == null || !(textureView instanceof ScaleTextureView)) {
            return;
        }
        ((ScaleTextureView) textureView).setEnabledTouch(z);
    }

    public void setVolume(int i) {
    }

    public RxFFmpegPlayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = PlayerCoreType.PCT_RXFFMPEG_PLAYER;
        this.f = 0;
        this.b = context;
        this.c = new a(this);
        d();
        setKeepScreenOn(true);
    }
}
