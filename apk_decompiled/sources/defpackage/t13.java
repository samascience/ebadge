package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.Log;
import com.google.android.material.R$styleable;

/* JADX INFO: loaded from: classes3.dex */
public class t13 {
    public final ColorStateList a;
    public final ColorStateList b;
    public final ColorStateList c;
    public final String d;
    public final int e;
    public final int f;
    public final boolean g;
    public final float h;
    public final float i;
    public final float j;
    public final boolean k;
    public final float l;
    private ColorStateList m;
    private float n;
    private final int o;
    private boolean p = false;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Typeface f385q;

    class a extends bh2.e {
        final /* synthetic */ v13 a;

        a(v13 v13Var) {
            this.a = v13Var;
        }

        @Override // bh2.e
        /* JADX INFO: renamed from: h */
        public void f(int i) {
            t13.this.p = true;
            this.a.a(i);
        }

        @Override // bh2.e
        /* JADX INFO: renamed from: i */
        public void g(Typeface typeface) {
            t13 t13Var = t13.this;
            t13Var.f385q = Typeface.create(typeface, t13Var.e);
            t13.this.p = true;
            this.a.b(t13.this.f385q, false);
        }
    }

    class b extends v13 {
        final /* synthetic */ Context a;
        final /* synthetic */ TextPaint b;
        final /* synthetic */ v13 c;

        b(Context context, TextPaint textPaint, v13 v13Var) {
            this.a = context;
            this.b = textPaint;
            this.c = v13Var;
        }

        @Override // defpackage.v13
        public void a(int i) {
            this.c.a(i);
        }

        @Override // defpackage.v13
        public void b(Typeface typeface, boolean z) {
            t13.this.p(this.a, this.b, typeface);
            this.c.b(typeface, z);
        }
    }

    public t13(Context context, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i, R$styleable.TextAppearance);
        l(typedArrayObtainStyledAttributes.getDimension(R$styleable.TextAppearance_android_textSize, 0.0f));
        k(sg1.a(context, typedArrayObtainStyledAttributes, R$styleable.TextAppearance_android_textColor));
        this.a = sg1.a(context, typedArrayObtainStyledAttributes, R$styleable.TextAppearance_android_textColorHint);
        this.b = sg1.a(context, typedArrayObtainStyledAttributes, R$styleable.TextAppearance_android_textColorLink);
        this.e = typedArrayObtainStyledAttributes.getInt(R$styleable.TextAppearance_android_textStyle, 0);
        this.f = typedArrayObtainStyledAttributes.getInt(R$styleable.TextAppearance_android_typeface, 1);
        int iG = sg1.g(typedArrayObtainStyledAttributes, R$styleable.TextAppearance_fontFamily, R$styleable.TextAppearance_android_fontFamily);
        this.o = typedArrayObtainStyledAttributes.getResourceId(iG, 0);
        this.d = typedArrayObtainStyledAttributes.getString(iG);
        this.g = typedArrayObtainStyledAttributes.getBoolean(R$styleable.TextAppearance_textAllCaps, false);
        this.c = sg1.a(context, typedArrayObtainStyledAttributes, R$styleable.TextAppearance_android_shadowColor);
        this.h = typedArrayObtainStyledAttributes.getFloat(R$styleable.TextAppearance_android_shadowDx, 0.0f);
        this.i = typedArrayObtainStyledAttributes.getFloat(R$styleable.TextAppearance_android_shadowDy, 0.0f);
        this.j = typedArrayObtainStyledAttributes.getFloat(R$styleable.TextAppearance_android_shadowRadius, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(i, R$styleable.MaterialTextAppearance);
        int i2 = R$styleable.MaterialTextAppearance_android_letterSpacing;
        this.k = typedArrayObtainStyledAttributes2.hasValue(i2);
        this.l = typedArrayObtainStyledAttributes2.getFloat(i2, 0.0f);
        typedArrayObtainStyledAttributes2.recycle();
    }

    private void d() {
        String str;
        if (this.f385q == null && (str = this.d) != null) {
            this.f385q = Typeface.create(str, this.e);
        }
        if (this.f385q == null) {
            int i = this.f;
            if (i == 1) {
                this.f385q = Typeface.SANS_SERIF;
            } else if (i == 2) {
                this.f385q = Typeface.SERIF;
            } else if (i != 3) {
                this.f385q = Typeface.DEFAULT;
            } else {
                this.f385q = Typeface.MONOSPACE;
            }
            this.f385q = Typeface.create(this.f385q, this.e);
        }
    }

    private boolean m(Context context) {
        if (u13.a()) {
            return true;
        }
        int i = this.o;
        return (i != 0 ? bh2.c(context, i) : null) != null;
    }

    public Typeface e() {
        d();
        return this.f385q;
    }

    public Typeface f(Context context) {
        if (this.p) {
            return this.f385q;
        }
        if (!context.isRestricted()) {
            try {
                Typeface typefaceG = bh2.g(context, this.o);
                this.f385q = typefaceG;
                if (typefaceG != null) {
                    this.f385q = Typeface.create(typefaceG, this.e);
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            } catch (Exception e) {
                Log.d("TextAppearance", "Error loading font " + this.d, e);
            }
        }
        d();
        this.p = true;
        return this.f385q;
    }

    public void g(Context context, v13 v13Var) {
        if (m(context)) {
            f(context);
        } else {
            d();
        }
        int i = this.o;
        if (i == 0) {
            this.p = true;
        }
        if (this.p) {
            v13Var.b(this.f385q, true);
            return;
        }
        try {
            bh2.i(context, i, new a(v13Var), null);
        } catch (Resources.NotFoundException unused) {
            this.p = true;
            v13Var.a(1);
        } catch (Exception e) {
            Log.d("TextAppearance", "Error loading font " + this.d, e);
            this.p = true;
            v13Var.a(-3);
        }
    }

    public void h(Context context, TextPaint textPaint, v13 v13Var) {
        p(context, textPaint, e());
        g(context, new b(context, textPaint, v13Var));
    }

    public ColorStateList i() {
        return this.m;
    }

    public float j() {
        return this.n;
    }

    public void k(ColorStateList colorStateList) {
        this.m = colorStateList;
    }

    public void l(float f) {
        this.n = f;
    }

    public void n(Context context, TextPaint textPaint, v13 v13Var) {
        o(context, textPaint, v13Var);
        ColorStateList colorStateList = this.m;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : -16777216);
        float f = this.j;
        float f2 = this.h;
        float f3 = this.i;
        ColorStateList colorStateList2 = this.c;
        textPaint.setShadowLayer(f, f2, f3, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    public void o(Context context, TextPaint textPaint, v13 v13Var) {
        if (m(context)) {
            p(context, textPaint, f(context));
        } else {
            h(context, textPaint, v13Var);
        }
    }

    public void p(Context context, TextPaint textPaint, Typeface typeface) {
        Typeface typefaceA = s73.a(context, typeface);
        if (typefaceA != null) {
            typeface = typefaceA;
        }
        textPaint.setTypeface(typeface);
        int i = this.e & (~typeface.getStyle());
        textPaint.setFakeBoldText((i & 1) != 0);
        textPaint.setTextSkewX((i & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.n);
        if (this.k) {
            textPaint.setLetterSpacing(this.l);
        }
    }
}
