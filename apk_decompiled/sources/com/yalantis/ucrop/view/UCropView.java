package com.yalantis.ucrop.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.luck.picture.lib.R$id;
import com.luck.picture.lib.R$layout;
import com.luck.picture.lib.R$styleable;
import defpackage.b50;
import defpackage.ky1;

/* JADX INFO: loaded from: classes3.dex */
public class UCropView extends FrameLayout {
    private GestureCropImageView a;
    private final OverlayView b;

    class a implements b50 {
        a() {
        }

        @Override // defpackage.b50
        public void a(float f) {
            UCropView.this.b.setTargetAspectRatio(f);
        }
    }

    class b implements ky1 {
        b() {
        }

        @Override // defpackage.ky1
        public void a(float f, float f2) {
            UCropView.this.a.m(f, f2);
        }

        @Override // defpackage.ky1
        public void b(RectF rectF) {
            UCropView.this.a.setCropRect(rectF);
        }
    }

    public UCropView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void c() {
        this.a.setCropBoundsChangeListener(new a());
        this.b.setOverlayViewChangeListener(new b());
    }

    public GestureCropImageView getCropImageView() {
        return this.a;
    }

    public OverlayView getOverlayView() {
        return this.b;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public UCropView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R$layout.ucrop_view, (ViewGroup) this, true);
        this.a = (GestureCropImageView) findViewById(R$id.image_view_crop);
        OverlayView overlayView = (OverlayView) findViewById(R$id.view_overlay);
        this.b = overlayView;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ucrop_UCropView);
        overlayView.j(typedArrayObtainStyledAttributes);
        this.a.y(typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
        c();
    }
}
