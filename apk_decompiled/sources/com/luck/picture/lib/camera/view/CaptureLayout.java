package com.luck.picture.lib.camera.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.graphics.BlendModeCompat;
import com.luck.picture.lib.R$string;
import defpackage.bk;
import defpackage.cw;
import defpackage.gy;
import defpackage.ll2;
import defpackage.r63;

/* JADX INFO: loaded from: classes3.dex */
public class CaptureLayout extends FrameLayout {
    private cw a;
    private r63 b;
    private gy c;
    private gy d;
    private ProgressBar e;
    private CaptureButton f;
    private TypeButton g;
    private TypeButton h;
    private ReturnButton i;
    private ImageView j;
    private ImageView k;
    private TextView l;
    private final int m;
    private final int n;
    private final int o;
    private int p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f297q;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            CaptureLayout.this.h.setClickable(true);
            CaptureLayout.this.g.setClickable(true);
        }
    }

    class b implements cw {
        b() {
        }

        @Override // defpackage.cw
        public void a(float f) {
            if (CaptureLayout.this.a != null) {
                CaptureLayout.this.a.a(f);
            }
        }

        @Override // defpackage.cw
        public void b() {
            if (CaptureLayout.this.a != null) {
                CaptureLayout.this.a.b();
            }
        }

        @Override // defpackage.cw
        public void c(long j) {
            if (CaptureLayout.this.a != null) {
                CaptureLayout.this.a.c(j);
            }
        }

        @Override // defpackage.cw
        public void d() {
            if (CaptureLayout.this.a != null) {
                CaptureLayout.this.a.d();
            }
            CaptureLayout.this.s();
        }

        @Override // defpackage.cw
        public void e(long j) {
            if (CaptureLayout.this.a != null) {
                CaptureLayout.this.a.e(j);
            }
            CaptureLayout.this.t();
        }

        @Override // defpackage.cw
        public void f() {
            if (CaptureLayout.this.a != null) {
                CaptureLayout.this.a.f();
            }
            CaptureLayout.this.s();
        }
    }

    class c extends AnimatorListenerAdapter {
        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            CaptureLayout.this.l.setText(CaptureLayout.this.getCaptureTip());
            CaptureLayout.this.l.setAlpha(1.0f);
        }
    }

    public CaptureLayout(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getCaptureTip() {
        int buttonFeatures = this.f.getButtonFeatures();
        if (buttonFeatures != 257) {
            return buttonFeatures != 258 ? getContext().getString(R$string.picture_photo_camera) : getContext().getString(R$string.picture_photo_recording);
        }
        return getContext().getString(R$string.picture_photo_pictures);
    }

    private void l() {
        setWillNotDraw(false);
        this.e = new ProgressBar(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.e.setLayoutParams(layoutParams);
        this.e.setVisibility(8);
        this.f = new CaptureButton(getContext(), this.o);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams2.gravity = 17;
        this.f.setLayoutParams(layoutParams2);
        this.f.setCaptureListener(new b());
        this.h = new TypeButton(getContext(), 1, this.o);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams3.gravity = 16;
        layoutParams3.setMargins((this.m / 4) - (this.o / 2), 0, 0, 0);
        this.h.setLayoutParams(layoutParams3);
        this.h.setOnClickListener(new View.OnClickListener() { // from class: xv
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.m(view);
            }
        });
        this.g = new TypeButton(getContext(), 2, this.o);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams4.gravity = 21;
        layoutParams4.setMargins(0, 0, (this.m / 4) - (this.o / 2), 0);
        this.g.setLayoutParams(layoutParams4);
        this.g.setOnClickListener(new View.OnClickListener() { // from class: yv
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.n(view);
            }
        });
        this.i = new ReturnButton(getContext(), (int) (this.o / 2.5f));
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams5.gravity = 16;
        layoutParams5.setMargins(this.m / 6, 0, 0, 0);
        this.i.setLayoutParams(layoutParams5);
        this.i.setOnClickListener(new View.OnClickListener() { // from class: zv
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.o(view);
            }
        });
        this.j = new ImageView(getContext());
        int i = this.o;
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams((int) (i / 2.5f), (int) (i / 2.5f));
        layoutParams6.gravity = 16;
        layoutParams6.setMargins(this.m / 6, 0, 0, 0);
        this.j.setLayoutParams(layoutParams6);
        this.j.setOnClickListener(new View.OnClickListener() { // from class: aw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.p(view);
            }
        });
        this.k = new ImageView(getContext());
        int i2 = this.o;
        FrameLayout.LayoutParams layoutParams7 = new FrameLayout.LayoutParams((int) (i2 / 2.5f), (int) (i2 / 2.5f));
        layoutParams7.gravity = 21;
        layoutParams7.setMargins(0, 0, this.m / 6, 0);
        this.k.setLayoutParams(layoutParams7);
        this.k.setOnClickListener(new View.OnClickListener() { // from class: bw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.q(view);
            }
        });
        this.l = new TextView(getContext());
        FrameLayout.LayoutParams layoutParams8 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams8.gravity = 1;
        layoutParams8.setMargins(0, 0, 0, 0);
        this.l.setText(getCaptureTip());
        this.l.setTextColor(-1);
        this.l.setGravity(17);
        this.l.setLayoutParams(layoutParams8);
        addView(this.f);
        addView(this.e);
        addView(this.h);
        addView(this.g);
        addView(this.i);
        addView(this.j);
        addView(this.k);
        addView(this.l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(View view) {
        r63 r63Var = this.b;
        if (r63Var != null) {
            r63Var.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n(View view) {
        r63 r63Var = this.b;
        if (r63Var != null) {
            r63Var.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(View view) {
        gy gyVar = this.c;
        if (gyVar != null) {
            gyVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(View view) {
        gy gyVar = this.c;
        if (gyVar != null) {
            gyVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(View view) {
        gy gyVar = this.d;
        if (gyVar != null) {
            gyVar.a();
        }
    }

    public r63 getTypeListener() {
        return this.b;
    }

    public void k() {
        this.k.setVisibility(8);
        this.h.setVisibility(8);
        this.g.setVisibility(8);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.m, this.n);
    }

    public void r() {
        this.f.t();
        this.h.setVisibility(8);
        this.g.setVisibility(8);
        this.f.setVisibility(0);
        this.l.setText(getCaptureTip());
        this.l.setVisibility(0);
        if (this.p != 0) {
            this.j.setVisibility(0);
        } else {
            this.i.setVisibility(0);
        }
        if (this.f297q != 0) {
            this.k.setVisibility(0);
        }
    }

    public void s() {
        this.l.setVisibility(4);
    }

    public void setButtonCaptureEnabled(boolean z) {
        this.e.setVisibility(z ? 8 : 0);
        this.f.setButtonCaptureEnabled(z);
    }

    public void setButtonFeatures(int i) {
        this.f.setButtonFeatures(i);
        this.l.setText(getCaptureTip());
    }

    public void setCaptureListener(cw cwVar) {
        this.a = cwVar;
    }

    public void setCaptureLoadingColor(int i) {
        this.e.getIndeterminateDrawable().setColorFilter(bk.a(i, BlendModeCompat.SRC_IN));
    }

    public void setDuration(int i) {
        this.f.setDuration(i);
    }

    public void setLeftClickListener(gy gyVar) {
        this.c = gyVar;
    }

    public void setMinDuration(int i) {
        this.f.setMinDuration(i);
    }

    public void setRightClickListener(gy gyVar) {
        this.d = gyVar;
    }

    public void setTextWithAnimation(String str) {
        this.l.setText(str);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.l, "alpha", 0.0f, 1.0f, 1.0f, 0.0f);
        objectAnimatorOfFloat.addListener(new c());
        objectAnimatorOfFloat.setDuration(2500L);
        objectAnimatorOfFloat.start();
    }

    public void setTip(String str) {
        this.l.setText(str);
    }

    public void setTypeListener(r63 r63Var) {
        this.b = r63Var;
    }

    public void t() {
        if (this.p != 0) {
            this.j.setVisibility(8);
        } else {
            this.i.setVisibility(8);
        }
        if (this.f297q != 0) {
            this.k.setVisibility(8);
        }
        this.f.setVisibility(8);
        this.h.setVisibility(0);
        this.g.setVisibility(0);
        this.h.setClickable(false);
        this.g.setClickable(false);
        this.j.setVisibility(8);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.h, "translationX", this.m / 4, 0.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.g, "translationX", (-this.m) / 4, 0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        animatorSet.addListener(new a());
        animatorSet.setDuration(500L);
        animatorSet.start();
    }

    public CaptureLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CaptureLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.p = 0;
        this.f297q = 0;
        int iC = ll2.c(getContext());
        if (getResources().getConfiguration().orientation == 1) {
            this.m = iC;
        } else {
            this.m = iC / 2;
        }
        int i2 = (int) (this.m / 4.5f);
        this.o = i2;
        this.n = i2 + ((i2 / 5) * 2) + 100;
        l();
        k();
    }
}
