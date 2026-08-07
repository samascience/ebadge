package defpackage;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;

/* JADX INFO: loaded from: classes3.dex */
public class h43 extends tg1 implements a23.b {
    private static final int W = R$style.Widget_MaterialComponents_Tooltip;
    private static final int X = R$attr.tooltipStyle;
    private final Context F;
    private final Paint.FontMetrics G;
    private final a23 H;
    private final View.OnLayoutChangeListener I;
    private final Rect J;
    private int K;
    private int L;
    private int M;
    private int N;
    private boolean O;
    private int P;
    private int Q;
    private float R;
    private float S;
    private final float T;
    private float U;
    private float V;
    private CharSequence z;

    class a implements View.OnLayoutChangeListener {
        a() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            h43.this.E0(view);
        }
    }

    private h43(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.G = new Paint.FontMetrics();
        a23 a23Var = new a23(this);
        this.H = a23Var;
        this.I = new a();
        this.J = new Rect();
        this.R = 1.0f;
        this.S = 1.0f;
        this.T = 0.5f;
        this.U = 0.5f;
        this.V = 1.0f;
        this.F = context;
        a23Var.g().density = context.getResources().getDisplayMetrics().density;
        a23Var.g().setTextAlign(Paint.Align.CENTER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E0(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        this.Q = iArr[0];
        view.getWindowVisibleDisplayFrame(this.J);
    }

    private float r0() {
        int i;
        if (((this.J.right - getBounds().right) - this.Q) - this.N < 0) {
            i = ((this.J.right - getBounds().right) - this.Q) - this.N;
        } else {
            if (((this.J.left - getBounds().left) - this.Q) + this.N <= 0) {
                return 0.0f;
            }
            i = ((this.J.left - getBounds().left) - this.Q) + this.N;
        }
        return i;
    }

    private float s0() {
        this.H.g().getFontMetrics(this.G);
        Paint.FontMetrics fontMetrics = this.G;
        return (fontMetrics.descent + fontMetrics.ascent) / 2.0f;
    }

    private float t0(Rect rect) {
        return rect.centerY() - s0();
    }

    public static h43 u0(Context context, AttributeSet attributeSet, int i, int i2) {
        h43 h43Var = new h43(context, attributeSet, i, i2);
        h43Var.z0(attributeSet, i, i2);
        return h43Var;
    }

    private ef0 v0() {
        float f = -r0();
        float fWidth = ((float) (((double) getBounds().width()) - (((double) this.P) * Math.sqrt(2.0d)))) / 2.0f;
        return new xt1(new wf1(this.P), Math.min(Math.max(f, -fWidth), fWidth));
    }

    private void x0(Canvas canvas) {
        if (this.z == null) {
            return;
        }
        Rect bounds = getBounds();
        int iT0 = (int) t0(bounds);
        if (this.H.e() != null) {
            this.H.g().drawableState = getState();
            this.H.n(this.F);
            this.H.g().setAlpha((int) (this.V * 255.0f));
        }
        CharSequence charSequence = this.z;
        canvas.drawText(charSequence, 0, charSequence.length(), bounds.centerX(), iT0, this.H.g());
    }

    private float y0() {
        CharSequence charSequence = this.z;
        if (charSequence == null) {
            return 0.0f;
        }
        return this.H.h(charSequence.toString());
    }

    private void z0(AttributeSet attributeSet, int i, int i2) {
        TypedArray typedArrayI = o23.i(this.F, attributeSet, R$styleable.Tooltip, i, i2, new int[0]);
        this.P = this.F.getResources().getDimensionPixelSize(R$dimen.mtrl_tooltip_arrowSize);
        boolean z = typedArrayI.getBoolean(R$styleable.Tooltip_showMarker, true);
        this.O = z;
        if (z) {
            setShapeAppearanceModel(E().v().s(v0()).m());
        } else {
            this.P = 0;
        }
        C0(typedArrayI.getText(R$styleable.Tooltip_android_text));
        t13 t13VarH = sg1.h(this.F, typedArrayI, R$styleable.Tooltip_android_textAppearance);
        if (t13VarH != null) {
            int i3 = R$styleable.Tooltip_android_textColor;
            if (typedArrayI.hasValue(i3)) {
                t13VarH.k(sg1.a(this.F, typedArrayI, i3));
            }
        }
        D0(t13VarH);
        b0(ColorStateList.valueOf(typedArrayI.getColor(R$styleable.Tooltip_backgroundTint, og1.i(pz.k(og1.c(this.F, R.attr.colorBackground, h43.class.getCanonicalName()), 229), pz.k(og1.c(this.F, R$attr.colorOnBackground, h43.class.getCanonicalName()), 153)))));
        l0(ColorStateList.valueOf(og1.c(this.F, R$attr.colorSurface, h43.class.getCanonicalName())));
        this.K = typedArrayI.getDimensionPixelSize(R$styleable.Tooltip_android_padding, 0);
        this.L = typedArrayI.getDimensionPixelSize(R$styleable.Tooltip_android_minWidth, 0);
        this.M = typedArrayI.getDimensionPixelSize(R$styleable.Tooltip_android_minHeight, 0);
        this.N = typedArrayI.getDimensionPixelSize(R$styleable.Tooltip_android_layout_margin, 0);
        typedArrayI.recycle();
    }

    public void A0(View view) {
        if (view == null) {
            return;
        }
        E0(view);
        view.addOnLayoutChangeListener(this.I);
    }

    public void B0(float f) {
        this.U = 1.2f;
        this.R = f;
        this.S = f;
        this.V = y6.b(0.0f, 1.0f, 0.19f, 1.0f, f);
        invalidateSelf();
    }

    public void C0(CharSequence charSequence) {
        if (TextUtils.equals(this.z, charSequence)) {
            return;
        }
        this.z = charSequence;
        this.H.m(true);
        invalidateSelf();
    }

    public void D0(t13 t13Var) {
        this.H.k(t13Var, this.F);
    }

    @Override // a23.b
    public void a() {
        invalidateSelf();
    }

    @Override // defpackage.tg1, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        canvas.save();
        float fR0 = r0();
        float f = (float) (-((((double) this.P) * Math.sqrt(2.0d)) - ((double) this.P)));
        canvas.scale(this.R, this.S, getBounds().left + (getBounds().width() * 0.5f), getBounds().top + (getBounds().height() * this.U));
        canvas.translate(fR0, f);
        super.draw(canvas);
        x0(canvas);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) Math.max(this.H.g().getTextSize(), this.M);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) Math.max((this.K * 2) + y0(), this.L);
    }

    @Override // defpackage.tg1, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.O) {
            setShapeAppearanceModel(E().v().s(v0()).m());
        }
    }

    @Override // defpackage.tg1, android.graphics.drawable.Drawable, a23.b
    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    public void w0(View view) {
        if (view == null) {
            return;
        }
        view.removeOnLayoutChangeListener(this.I);
    }
}
