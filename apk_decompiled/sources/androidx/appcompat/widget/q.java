package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.appcompat.R$styleable;
import defpackage.be3;
import defpackage.bh2;
import defpackage.d73;
import defpackage.ff0;
import defpackage.j23;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
class q {
    private final TextView a;
    private c0 b;
    private c0 c;
    private c0 d;
    private c0 e;
    private c0 f;
    private c0 g;
    private c0 h;
    private final r i;
    private int j = 0;
    private int k = -1;
    private Typeface l;
    private boolean m;

    class a extends bh2.e {
        final /* synthetic */ int a;
        final /* synthetic */ int b;
        final /* synthetic */ WeakReference c;

        a(int i, int i2, WeakReference weakReference) {
            this.a = i;
            this.b = i2;
            this.c = weakReference;
        }

        @Override // bh2.e
        /* JADX INFO: renamed from: h */
        public void f(int i) {
        }

        @Override // bh2.e
        /* JADX INFO: renamed from: i */
        public void g(Typeface typeface) {
            int i;
            if (Build.VERSION.SDK_INT >= 28 && (i = this.a) != -1) {
                typeface = e.a(typeface, i, (this.b & 2) != 0);
            }
            q.this.n(this.c, typeface);
        }
    }

    class b implements Runnable {
        final /* synthetic */ TextView a;
        final /* synthetic */ Typeface b;
        final /* synthetic */ int c;

        b(TextView textView, Typeface typeface, int i) {
            this.a = textView;
            this.b = typeface;
            this.c = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.setTypeface(this.b, this.c);
        }
    }

    static class c {
        static LocaleList a(String str) {
            return LocaleList.forLanguageTags(str);
        }

        static void b(TextView textView, LocaleList localeList) {
            textView.setTextLocales(localeList);
        }
    }

    static class d {
        static int a(TextView textView) {
            return textView.getAutoSizeStepGranularity();
        }

        static void b(TextView textView, int i, int i2, int i3, int i4) {
            textView.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
        }

        static void c(TextView textView, int[] iArr, int i) {
            textView.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
        }

        static boolean d(TextView textView, String str) {
            return textView.setFontVariationSettings(str);
        }
    }

    static class e {
        static Typeface a(Typeface typeface, int i, boolean z) {
            return Typeface.create(typeface, i, z);
        }
    }

    q(TextView textView) {
        this.a = textView;
        this.i = new r(textView);
    }

    private void B(int i, float f) {
        this.i.t(i, f);
    }

    private void C(Context context, e0 e0Var) {
        String strO;
        this.j = e0Var.k(R$styleable.TextAppearance_android_textStyle, this.j);
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            int iK = e0Var.k(R$styleable.TextAppearance_android_textFontWeight, -1);
            this.k = iK;
            if (iK != -1) {
                this.j &= 2;
            }
        }
        int i2 = R$styleable.TextAppearance_android_fontFamily;
        if (!e0Var.s(i2) && !e0Var.s(R$styleable.TextAppearance_fontFamily)) {
            int i3 = R$styleable.TextAppearance_android_typeface;
            if (e0Var.s(i3)) {
                this.m = false;
                int iK2 = e0Var.k(i3, 1);
                if (iK2 == 1) {
                    this.l = Typeface.SANS_SERIF;
                    return;
                } else if (iK2 == 2) {
                    this.l = Typeface.SERIF;
                    return;
                } else {
                    if (iK2 != 3) {
                        return;
                    }
                    this.l = Typeface.MONOSPACE;
                    return;
                }
            }
            return;
        }
        this.l = null;
        int i4 = R$styleable.TextAppearance_fontFamily;
        if (e0Var.s(i4)) {
            i2 = i4;
        }
        int i5 = this.k;
        int i6 = this.j;
        if (!context.isRestricted()) {
            try {
                Typeface typefaceJ = e0Var.j(i2, this.j, new a(i5, i6, new WeakReference(this.a)));
                if (typefaceJ != null) {
                    if (i < 28 || this.k == -1) {
                        this.l = typefaceJ;
                    } else {
                        this.l = e.a(Typeface.create(typefaceJ, 0), this.k, (this.j & 2) != 0);
                    }
                }
                this.m = this.l == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.l != null || (strO = e0Var.o(i2)) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 28 || this.k == -1) {
            this.l = Typeface.create(strO, this.j);
        } else {
            this.l = e.a(Typeface.create(strO, 0), this.k, (this.j & 2) != 0);
        }
    }

    private void a(Drawable drawable, c0 c0Var) {
        if (drawable == null || c0Var == null) {
            return;
        }
        g.i(drawable, c0Var, this.a.getDrawableState());
    }

    private static c0 d(Context context, g gVar, int i) {
        ColorStateList colorStateListF = gVar.f(context, i);
        if (colorStateListF == null) {
            return null;
        }
        c0 c0Var = new c0();
        c0Var.d = true;
        c0Var.a = colorStateListF;
        return c0Var;
    }

    private void y(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        if (drawable5 != null || drawable6 != null) {
            Drawable[] compoundDrawablesRelative = this.a.getCompoundDrawablesRelative();
            if (drawable5 == null) {
                drawable5 = compoundDrawablesRelative[0];
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative[1];
            }
            if (drawable6 == null) {
                drawable6 = compoundDrawablesRelative[2];
            }
            TextView textView = this.a;
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative[3];
            }
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable5, drawable2, drawable6, drawable4);
            return;
        }
        if (drawable == null && drawable2 == null && drawable3 == null && drawable4 == null) {
            return;
        }
        Drawable[] compoundDrawablesRelative2 = this.a.getCompoundDrawablesRelative();
        Drawable drawable7 = compoundDrawablesRelative2[0];
        if (drawable7 != null || compoundDrawablesRelative2[2] != null) {
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative2[1];
            }
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative2[3];
            }
            this.a.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable7, drawable2, compoundDrawablesRelative2[2], drawable4);
            return;
        }
        Drawable[] compoundDrawables = this.a.getCompoundDrawables();
        TextView textView2 = this.a;
        if (drawable == null) {
            drawable = compoundDrawables[0];
        }
        if (drawable2 == null) {
            drawable2 = compoundDrawables[1];
        }
        if (drawable3 == null) {
            drawable3 = compoundDrawables[2];
        }
        if (drawable4 == null) {
            drawable4 = compoundDrawables[3];
        }
        textView2.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    private void z() {
        c0 c0Var = this.h;
        this.b = c0Var;
        this.c = c0Var;
        this.d = c0Var;
        this.e = c0Var;
        this.f = c0Var;
        this.g = c0Var;
    }

    void A(int i, float f) {
        if (h0.c || l()) {
            return;
        }
        B(i, f);
    }

    void b() {
        if (this.b != null || this.c != null || this.d != null || this.e != null) {
            Drawable[] compoundDrawables = this.a.getCompoundDrawables();
            a(compoundDrawables[0], this.b);
            a(compoundDrawables[1], this.c);
            a(compoundDrawables[2], this.d);
            a(compoundDrawables[3], this.e);
        }
        if (this.f == null && this.g == null) {
            return;
        }
        Drawable[] compoundDrawablesRelative = this.a.getCompoundDrawablesRelative();
        a(compoundDrawablesRelative[0], this.f);
        a(compoundDrawablesRelative[2], this.g);
    }

    void c() {
        this.i.a();
    }

    int e() {
        return this.i.f();
    }

    int f() {
        return this.i.g();
    }

    int g() {
        return this.i.h();
    }

    int[] h() {
        return this.i.i();
    }

    int i() {
        return this.i.j();
    }

    ColorStateList j() {
        c0 c0Var = this.h;
        if (c0Var != null) {
            return c0Var.a;
        }
        return null;
    }

    PorterDuff.Mode k() {
        c0 c0Var = this.h;
        if (c0Var != null) {
            return c0Var.b;
        }
        return null;
    }

    boolean l() {
        return this.i.n();
    }

    /* JADX WARN: Code duplicated, block: B:123:0x026f  */
    /* JADX WARN: Code duplicated, block: B:125:0x0276  */
    /* JADX WARN: Code duplicated, block: B:128:0x027f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:129:0x0281  */
    /* JADX WARN: Code duplicated, block: B:130:0x0288  */
    /* JADX WARN: Code duplicated, block: B:132:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:27:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:43:0x00ff  */
    void m(AttributeSet attributeSet, int i) {
        boolean zA;
        boolean z;
        String strO;
        String strO2;
        float f;
        int iA;
        Context context = this.a.getContext();
        g gVarB = g.b();
        int[] iArr = R$styleable.AppCompatTextHelper;
        e0 e0VarV = e0.v(context, attributeSet, iArr, i, 0);
        TextView textView = this.a;
        be3.n0(textView, textView.getContext(), iArr, attributeSet, e0VarV.r(), i, 0);
        int iN = e0VarV.n(R$styleable.AppCompatTextHelper_android_textAppearance, -1);
        int i2 = R$styleable.AppCompatTextHelper_android_drawableLeft;
        if (e0VarV.s(i2)) {
            this.b = d(context, gVarB, e0VarV.n(i2, 0));
        }
        int i3 = R$styleable.AppCompatTextHelper_android_drawableTop;
        if (e0VarV.s(i3)) {
            this.c = d(context, gVarB, e0VarV.n(i3, 0));
        }
        int i4 = R$styleable.AppCompatTextHelper_android_drawableRight;
        if (e0VarV.s(i4)) {
            this.d = d(context, gVarB, e0VarV.n(i4, 0));
        }
        int i5 = R$styleable.AppCompatTextHelper_android_drawableBottom;
        if (e0VarV.s(i5)) {
            this.e = d(context, gVarB, e0VarV.n(i5, 0));
        }
        int i6 = R$styleable.AppCompatTextHelper_android_drawableStart;
        if (e0VarV.s(i6)) {
            this.f = d(context, gVarB, e0VarV.n(i6, 0));
        }
        int i7 = R$styleable.AppCompatTextHelper_android_drawableEnd;
        if (e0VarV.s(i7)) {
            this.g = d(context, gVarB, e0VarV.n(i7, 0));
        }
        e0VarV.x();
        boolean z2 = this.a.getTransformationMethod() instanceof PasswordTransformationMethod;
        boolean z3 = true;
        if (iN != -1) {
            e0 e0VarT = e0.t(context, iN, R$styleable.TextAppearance);
            if (z2) {
                zA = false;
                z = false;
            } else {
                int i8 = R$styleable.TextAppearance_textAllCaps;
                if (e0VarT.s(i8)) {
                    zA = e0VarT.a(i8, false);
                    z = true;
                } else {
                    zA = false;
                    z = false;
                }
            }
            C(context, e0VarT);
            int i9 = R$styleable.TextAppearance_textLocale;
            strO = e0VarT.s(i9) ? e0VarT.o(i9) : null;
            int i10 = R$styleable.TextAppearance_fontVariationSettings;
            strO2 = e0VarT.s(i10) ? e0VarT.o(i10) : null;
            e0VarT.x();
        } else {
            zA = false;
            z = false;
            strO = null;
            strO2 = null;
        }
        e0 e0VarV2 = e0.v(context, attributeSet, R$styleable.TextAppearance, i, 0);
        if (z2) {
            z3 = z;
        } else {
            int i11 = R$styleable.TextAppearance_textAllCaps;
            if (e0VarV2.s(i11)) {
                zA = e0VarV2.a(i11, false);
            } else {
                z3 = z;
            }
        }
        int i12 = Build.VERSION.SDK_INT;
        int i13 = R$styleable.TextAppearance_textLocale;
        if (e0VarV2.s(i13)) {
            strO = e0VarV2.o(i13);
        }
        int i14 = R$styleable.TextAppearance_fontVariationSettings;
        if (e0VarV2.s(i14)) {
            strO2 = e0VarV2.o(i14);
        }
        if (i12 >= 28) {
            int i15 = R$styleable.TextAppearance_android_textSize;
            if (e0VarV2.s(i15) && e0VarV2.f(i15, -1) == 0) {
                this.a.setTextSize(0, 0.0f);
            }
        }
        C(context, e0VarV2);
        e0VarV2.x();
        if (!z2 && z3) {
            s(zA);
        }
        Typeface typeface = this.l;
        if (typeface != null) {
            if (this.k == -1) {
                this.a.setTypeface(typeface, this.j);
            } else {
                this.a.setTypeface(typeface);
            }
        }
        if (strO2 != null) {
            d.d(this.a, strO2);
        }
        if (strO != null) {
            c.b(this.a, c.a(strO));
        }
        this.i.o(attributeSet, i);
        if (h0.c && this.i.j() != 0) {
            int[] iArrI = this.i.i();
            if (iArrI.length > 0) {
                if (d.a(this.a) != -1.0f) {
                    d.b(this.a, this.i.g(), this.i.f(), this.i.h(), 0);
                } else {
                    d.c(this.a, iArrI, 0);
                }
            }
        }
        e0 e0VarU = e0.u(context, attributeSet, R$styleable.AppCompatTextView);
        int iN2 = e0VarU.n(R$styleable.AppCompatTextView_drawableLeftCompat, -1);
        Drawable drawableC = iN2 != -1 ? gVarB.c(context, iN2) : null;
        int iN3 = e0VarU.n(R$styleable.AppCompatTextView_drawableTopCompat, -1);
        Drawable drawableC2 = iN3 != -1 ? gVarB.c(context, iN3) : null;
        int iN4 = e0VarU.n(R$styleable.AppCompatTextView_drawableRightCompat, -1);
        Drawable drawableC3 = iN4 != -1 ? gVarB.c(context, iN4) : null;
        int iN5 = e0VarU.n(R$styleable.AppCompatTextView_drawableBottomCompat, -1);
        Drawable drawableC4 = iN5 != -1 ? gVarB.c(context, iN5) : null;
        int iN6 = e0VarU.n(R$styleable.AppCompatTextView_drawableStartCompat, -1);
        Drawable drawableC5 = iN6 != -1 ? gVarB.c(context, iN6) : null;
        int iN7 = e0VarU.n(R$styleable.AppCompatTextView_drawableEndCompat, -1);
        y(drawableC, drawableC2, drawableC3, drawableC4, drawableC5, iN7 != -1 ? gVarB.c(context, iN7) : null);
        int i16 = R$styleable.AppCompatTextView_drawableTint;
        if (e0VarU.s(i16)) {
            j23.h(this.a, e0VarU.c(i16));
        }
        int i17 = R$styleable.AppCompatTextView_drawableTintMode;
        if (e0VarU.s(i17)) {
            j23.i(this.a, s.e(e0VarU.k(i17, -1), null));
        }
        int iF = e0VarU.f(R$styleable.AppCompatTextView_firstBaselineToTopHeight, -1);
        int iF2 = e0VarU.f(R$styleable.AppCompatTextView_lastBaselineToBottomHeight, -1);
        int i18 = R$styleable.AppCompatTextView_lineHeight;
        if (e0VarU.s(i18)) {
            TypedValue typedValueW = e0VarU.w(i18);
            if (typedValueW == null || typedValueW.type != 5) {
                f = e0VarU.f(i18, -1);
            } else {
                iA = d73.a(typedValueW.data);
                f = TypedValue.complexToFloat(typedValueW.data);
            }
            e0VarU.x();
            if (iF != -1) {
                j23.k(this.a, iF);
            }
            if (iF2 != -1) {
                j23.l(this.a, iF2);
            }
            if (f != -1.0f) {
                if (iA == -1) {
                    j23.m(this.a, (int) f);
                } else {
                    j23.n(this.a, iA, f);
                }
            }
        }
        f = -1.0f;
        iA = -1;
        e0VarU.x();
        if (iF != -1) {
            j23.k(this.a, iF);
        }
        if (iF2 != -1) {
            j23.l(this.a, iF2);
        }
        if (f != -1.0f) {
            if (iA == -1) {
                j23.m(this.a, (int) f);
            } else {
                j23.n(this.a, iA, f);
            }
        }
    }

    void n(WeakReference weakReference, Typeface typeface) {
        if (this.m) {
            this.l = typeface;
            TextView textView = (TextView) weakReference.get();
            if (textView != null) {
                if (textView.isAttachedToWindow()) {
                    textView.post(new b(textView, typeface, this.j));
                } else {
                    textView.setTypeface(typeface, this.j);
                }
            }
        }
    }

    void o(boolean z, int i, int i2, int i3, int i4) {
        if (h0.c) {
            return;
        }
        c();
    }

    void p() {
        b();
    }

    void q(Context context, int i) {
        String strO;
        e0 e0VarT = e0.t(context, i, R$styleable.TextAppearance);
        int i2 = R$styleable.TextAppearance_textAllCaps;
        if (e0VarT.s(i2)) {
            s(e0VarT.a(i2, false));
        }
        int i3 = R$styleable.TextAppearance_android_textSize;
        if (e0VarT.s(i3) && e0VarT.f(i3, -1) == 0) {
            this.a.setTextSize(0, 0.0f);
        }
        C(context, e0VarT);
        int i4 = R$styleable.TextAppearance_fontVariationSettings;
        if (e0VarT.s(i4) && (strO = e0VarT.o(i4)) != null) {
            d.d(this.a, strO);
        }
        e0VarT.x();
        Typeface typeface = this.l;
        if (typeface != null) {
            this.a.setTypeface(typeface, this.j);
        }
    }

    void r(TextView textView, InputConnection inputConnection, EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT >= 30 || inputConnection == null) {
            return;
        }
        ff0.e(editorInfo, textView.getText());
    }

    void s(boolean z) {
        this.a.setAllCaps(z);
    }

    void t(int i, int i2, int i3, int i4) {
        this.i.p(i, i2, i3, i4);
    }

    void u(int[] iArr, int i) {
        this.i.q(iArr, i);
    }

    void v(int i) {
        this.i.r(i);
    }

    void w(ColorStateList colorStateList) {
        if (this.h == null) {
            this.h = new c0();
        }
        c0 c0Var = this.h;
        c0Var.a = colorStateList;
        c0Var.d = colorStateList != null;
        z();
    }

    void x(PorterDuff.Mode mode) {
        if (this.h == null) {
            this.h = new c0();
        }
        c0 c0Var = this.h;
        c0Var.b = mode;
        c0Var.c = mode != null;
        z();
    }
}
