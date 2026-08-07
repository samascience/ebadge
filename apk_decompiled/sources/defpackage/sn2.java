package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import com.google.android.material.R$styleable;

/* JADX INFO: loaded from: classes3.dex */
public class sn2 {
    public static final l40 m = new ue2(0.5f);
    m40 a;
    m40 b;
    m40 c;
    m40 d;
    l40 e;
    l40 f;
    l40 g;
    l40 h;
    ef0 i;
    ef0 j;
    ef0 k;
    ef0 l;

    public interface c {
        l40 a(l40 l40Var);
    }

    public static b a() {
        return new b();
    }

    public static b b(Context context, int i, int i2) {
        return c(context, i, i2, 0);
    }

    private static b c(Context context, int i, int i2, int i3) {
        return d(context, i, i2, new v0(i3));
    }

    private static b d(Context context, int i, int i2, l40 l40Var) {
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i);
        if (i2 != 0) {
            contextThemeWrapper = new ContextThemeWrapper(contextThemeWrapper, i2);
        }
        TypedArray typedArrayObtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(R$styleable.ShapeAppearance);
        try {
            int i3 = typedArrayObtainStyledAttributes.getInt(R$styleable.ShapeAppearance_cornerFamily, 0);
            int i4 = typedArrayObtainStyledAttributes.getInt(R$styleable.ShapeAppearance_cornerFamilyTopLeft, i3);
            int i5 = typedArrayObtainStyledAttributes.getInt(R$styleable.ShapeAppearance_cornerFamilyTopRight, i3);
            int i6 = typedArrayObtainStyledAttributes.getInt(R$styleable.ShapeAppearance_cornerFamilyBottomRight, i3);
            int i7 = typedArrayObtainStyledAttributes.getInt(R$styleable.ShapeAppearance_cornerFamilyBottomLeft, i3);
            l40 l40VarM = m(typedArrayObtainStyledAttributes, R$styleable.ShapeAppearance_cornerSize, l40Var);
            l40 l40VarM2 = m(typedArrayObtainStyledAttributes, R$styleable.ShapeAppearance_cornerSizeTopLeft, l40VarM);
            l40 l40VarM3 = m(typedArrayObtainStyledAttributes, R$styleable.ShapeAppearance_cornerSizeTopRight, l40VarM);
            l40 l40VarM4 = m(typedArrayObtainStyledAttributes, R$styleable.ShapeAppearance_cornerSizeBottomRight, l40VarM);
            return new b().C(i4, l40VarM2).G(i5, l40VarM3).x(i6, l40VarM4).t(i7, m(typedArrayObtainStyledAttributes, R$styleable.ShapeAppearance_cornerSizeBottomLeft, l40VarM));
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static b e(Context context, AttributeSet attributeSet, int i, int i2) {
        return f(context, attributeSet, i, i2, 0);
    }

    public static b f(Context context, AttributeSet attributeSet, int i, int i2, int i3) {
        return g(context, attributeSet, i, i2, new v0(i3));
    }

    public static b g(Context context, AttributeSet attributeSet, int i, int i2, l40 l40Var) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.MaterialShape, i, i2);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R$styleable.MaterialShape_shapeAppearance, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(R$styleable.MaterialShape_shapeAppearanceOverlay, 0);
        typedArrayObtainStyledAttributes.recycle();
        return d(context, resourceId, resourceId2, l40Var);
    }

    private static l40 m(TypedArray typedArray, int i, l40 l40Var) {
        TypedValue typedValuePeekValue = typedArray.peekValue(i);
        if (typedValuePeekValue == null) {
            return l40Var;
        }
        int i2 = typedValuePeekValue.type;
        if (i2 == 5) {
            return new v0(TypedValue.complexToDimensionPixelSize(typedValuePeekValue.data, typedArray.getResources().getDisplayMetrics()));
        }
        return i2 == 6 ? new ue2(typedValuePeekValue.getFraction(1.0f, 1.0f)) : l40Var;
    }

    public ef0 h() {
        return this.k;
    }

    public m40 i() {
        return this.d;
    }

    public l40 j() {
        return this.h;
    }

    public m40 k() {
        return this.c;
    }

    public l40 l() {
        return this.g;
    }

    public ef0 n() {
        return this.l;
    }

    public ef0 o() {
        return this.j;
    }

    public ef0 p() {
        return this.i;
    }

    public m40 q() {
        return this.a;
    }

    public l40 r() {
        return this.e;
    }

    public m40 s() {
        return this.b;
    }

    public l40 t() {
        return this.f;
    }

    public boolean u(RectF rectF) {
        boolean z = this.l.getClass().equals(ef0.class) && this.j.getClass().equals(ef0.class) && this.i.getClass().equals(ef0.class) && this.k.getClass().equals(ef0.class);
        float fA = this.e.a(rectF);
        return z && ((this.f.a(rectF) > fA ? 1 : (this.f.a(rectF) == fA ? 0 : -1)) == 0 && (this.h.a(rectF) > fA ? 1 : (this.h.a(rectF) == fA ? 0 : -1)) == 0 && (this.g.a(rectF) > fA ? 1 : (this.g.a(rectF) == fA ? 0 : -1)) == 0) && ((this.b instanceof ii2) && (this.a instanceof ii2) && (this.c instanceof ii2) && (this.d instanceof ii2));
    }

    public b v() {
        return new b(this);
    }

    public sn2 w(float f) {
        return v().o(f).m();
    }

    public sn2 x(l40 l40Var) {
        return v().p(l40Var).m();
    }

    public sn2 y(c cVar) {
        return v().F(cVar.a(r())).J(cVar.a(t())).w(cVar.a(j())).A(cVar.a(l())).m();
    }

    private sn2(b bVar) {
        this.a = bVar.a;
        this.b = bVar.b;
        this.c = bVar.c;
        this.d = bVar.d;
        this.e = bVar.e;
        this.f = bVar.f;
        this.g = bVar.g;
        this.h = bVar.h;
        this.i = bVar.i;
        this.j = bVar.j;
        this.k = bVar.k;
        this.l = bVar.l;
    }

    public static final class b {
        private m40 a;
        private m40 b;
        private m40 c;
        private m40 d;
        private l40 e;
        private l40 f;
        private l40 g;
        private l40 h;
        private ef0 i;
        private ef0 j;
        private ef0 k;
        private ef0 l;

        public b() {
            this.a = ug1.b();
            this.b = ug1.b();
            this.c = ug1.b();
            this.d = ug1.b();
            this.e = new v0(0.0f);
            this.f = new v0(0.0f);
            this.g = new v0(0.0f);
            this.h = new v0(0.0f);
            this.i = ug1.c();
            this.j = ug1.c();
            this.k = ug1.c();
            this.l = ug1.c();
        }

        private static float n(m40 m40Var) {
            if (m40Var instanceof ii2) {
                return ((ii2) m40Var).a;
            }
            if (m40Var instanceof p50) {
                return ((p50) m40Var).a;
            }
            return -1.0f;
        }

        public b A(l40 l40Var) {
            this.g = l40Var;
            return this;
        }

        public b B(ef0 ef0Var) {
            this.i = ef0Var;
            return this;
        }

        public b C(int i, l40 l40Var) {
            return D(ug1.a(i)).F(l40Var);
        }

        public b D(m40 m40Var) {
            this.a = m40Var;
            float fN = n(m40Var);
            if (fN != -1.0f) {
                E(fN);
            }
            return this;
        }

        public b E(float f) {
            this.e = new v0(f);
            return this;
        }

        public b F(l40 l40Var) {
            this.e = l40Var;
            return this;
        }

        public b G(int i, l40 l40Var) {
            return H(ug1.a(i)).J(l40Var);
        }

        public b H(m40 m40Var) {
            this.b = m40Var;
            float fN = n(m40Var);
            if (fN != -1.0f) {
                I(fN);
            }
            return this;
        }

        public b I(float f) {
            this.f = new v0(f);
            return this;
        }

        public b J(l40 l40Var) {
            this.f = l40Var;
            return this;
        }

        public sn2 m() {
            return new sn2(this);
        }

        public b o(float f) {
            return E(f).I(f).z(f).v(f);
        }

        public b p(l40 l40Var) {
            return F(l40Var).J(l40Var).A(l40Var).w(l40Var);
        }

        public b q(int i, float f) {
            return r(ug1.a(i)).o(f);
        }

        public b r(m40 m40Var) {
            return D(m40Var).H(m40Var).y(m40Var).u(m40Var);
        }

        public b s(ef0 ef0Var) {
            this.k = ef0Var;
            return this;
        }

        public b t(int i, l40 l40Var) {
            return u(ug1.a(i)).w(l40Var);
        }

        public b u(m40 m40Var) {
            this.d = m40Var;
            float fN = n(m40Var);
            if (fN != -1.0f) {
                v(fN);
            }
            return this;
        }

        public b v(float f) {
            this.h = new v0(f);
            return this;
        }

        public b w(l40 l40Var) {
            this.h = l40Var;
            return this;
        }

        public b x(int i, l40 l40Var) {
            return y(ug1.a(i)).A(l40Var);
        }

        public b y(m40 m40Var) {
            this.c = m40Var;
            float fN = n(m40Var);
            if (fN != -1.0f) {
                z(fN);
            }
            return this;
        }

        public b z(float f) {
            this.g = new v0(f);
            return this;
        }

        public b(sn2 sn2Var) {
            this.a = ug1.b();
            this.b = ug1.b();
            this.c = ug1.b();
            this.d = ug1.b();
            this.e = new v0(0.0f);
            this.f = new v0(0.0f);
            this.g = new v0(0.0f);
            this.h = new v0(0.0f);
            this.i = ug1.c();
            this.j = ug1.c();
            this.k = ug1.c();
            this.l = ug1.c();
            this.a = sn2Var.a;
            this.b = sn2Var.b;
            this.c = sn2Var.c;
            this.d = sn2Var.d;
            this.e = sn2Var.e;
            this.f = sn2Var.f;
            this.g = sn2Var.g;
            this.h = sn2Var.h;
            this.i = sn2Var.i;
            this.j = sn2Var.j;
            this.k = sn2Var.k;
            this.l = sn2Var.l;
        }
    }

    public sn2() {
        this.a = ug1.b();
        this.b = ug1.b();
        this.c = ug1.b();
        this.d = ug1.b();
        this.e = new v0(0.0f);
        this.f = new v0(0.0f);
        this.g = new v0(0.0f);
        this.h = new v0(0.0f);
        this.i = ug1.c();
        this.j = ug1.c();
        this.k = ug1.c();
        this.l = ug1.c();
    }
}
