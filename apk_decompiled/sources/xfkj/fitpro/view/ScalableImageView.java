package xfkj.fitpro.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.animation.ScaleAnimation;
import androidx.appcompat.widget.AppCompatImageView;
import defpackage.p31;
import defpackage.y70;
import xfkj.fitpro.R$styleable;

/* JADX INFO: loaded from: classes4.dex */
public final class ScalableImageView extends AppCompatImageView {
    private float d;
    private float e;
    private final long f;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ScalableImageView(Context context) {
        this(context, null, 0, 6, null);
        p31.f(context, "context");
    }

    private final void c() {
        float f = this.d;
        float f2 = this.e;
        ScaleAnimation scaleAnimation = new ScaleAnimation(f, f2, f, f2, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(this.f);
        scaleAnimation.setFillAfter(true);
        startAnimation(scaleAnimation);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        clearAnimation();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ScalableImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        p31.f(context, "context");
    }

    public /* synthetic */ ScalableImageView(Context context, AttributeSet attributeSet, int i, int i2, y70 y70Var) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScalableImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        p31.f(context, "context");
        this.d = 0.5f;
        this.e = 1.0f;
        this.f = 2000L;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ScalableImageView);
            p31.e(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
            setImageResource(typedArrayObtainStyledAttributes.getResourceId(2, 0));
            this.d = typedArrayObtainStyledAttributes.getFloat(0, 0.5f);
            this.e = typedArrayObtainStyledAttributes.getFloat(1, 1.0f);
            typedArrayObtainStyledAttributes.recycle();
        }
        c();
    }
}
