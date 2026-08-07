package defpackage;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import com.google.android.material.R$styleable;

/* JADX INFO: loaded from: classes3.dex */
public abstract class nf3 {

    class a implements d {
        final /* synthetic */ boolean a;
        final /* synthetic */ boolean b;
        final /* synthetic */ boolean c;
        final /* synthetic */ d d;

        a(boolean z, boolean z2, boolean z3, d dVar) {
            this.a = z;
            this.b = z2;
            this.c = z3;
            this.d = dVar;
        }

        @Override // nf3.d
        public zi3 a(View view, zi3 zi3Var, e eVar) {
            if (this.a) {
                eVar.d += zi3Var.i();
            }
            boolean zO = nf3.o(view);
            if (this.b) {
                if (zO) {
                    eVar.c += zi3Var.j();
                } else {
                    eVar.a += zi3Var.j();
                }
            }
            if (this.c) {
                if (zO) {
                    eVar.a += zi3Var.k();
                } else {
                    eVar.c += zi3Var.k();
                }
            }
            eVar.a(view);
            d dVar = this.d;
            return dVar != null ? dVar.a(view, zi3Var, eVar) : zi3Var;
        }
    }

    class b implements mu1 {
        final /* synthetic */ d a;
        final /* synthetic */ e b;

        b(d dVar, e eVar) {
            this.a = dVar;
            this.b = eVar;
        }

        @Override // defpackage.mu1
        public zi3 a(View view, zi3 zi3Var) {
            return this.a.a(view, zi3Var, new e(this.b));
        }
    }

    class c implements View.OnAttachStateChangeListener {
        c() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            view.removeOnAttachStateChangeListener(this);
            be3.m0(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    public interface d {
        zi3 a(View view, zi3 zi3Var, e eVar);
    }

    public static Rect b(View view, View view2) {
        int[] iArr = new int[2];
        view2.getLocationOnScreen(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr2);
        int i3 = i - iArr2[0];
        int i4 = i2 - iArr2[1];
        return new Rect(i3, i4, view2.getWidth() + i3, view2.getHeight() + i4);
    }

    public static Rect c(View view) {
        return d(view, 0);
    }

    public static Rect d(View view, int i) {
        return new Rect(view.getLeft(), view.getTop() + i, view.getRight(), view.getBottom() + i);
    }

    public static void e(View view, d dVar) {
        be3.E0(view, new b(dVar, new e(be3.F(view), view.getPaddingTop(), be3.E(view), view.getPaddingBottom())));
        r(view);
    }

    public static void f(View view, AttributeSet attributeSet, int i, int i2, d dVar) {
        TypedArray typedArrayObtainStyledAttributes = view.getContext().obtainStyledAttributes(attributeSet, R$styleable.Insets, i, i2);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(R$styleable.Insets_paddingBottomSystemWindowInsets, false);
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.Insets_paddingLeftSystemWindowInsets, false);
        boolean z3 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.Insets_paddingRightSystemWindowInsets, false);
        typedArrayObtainStyledAttributes.recycle();
        e(view, new a(z, z2, z3, dVar));
    }

    public static float g(Context context, int i) {
        return TypedValue.applyDimension(1, i, context.getResources().getDisplayMetrics());
    }

    public static Integer h(View view) {
        ColorStateList colorStateListG = qd0.g(view.getBackground());
        if (colorStateListG != null) {
            return Integer.valueOf(colorStateListG.getDefaultColor());
        }
        return null;
    }

    public static ViewGroup i(View view) {
        if (view == null) {
            return null;
        }
        View rootView = view.getRootView();
        ViewGroup viewGroup = (ViewGroup) rootView.findViewById(R.id.content);
        if (viewGroup != null) {
            return viewGroup;
        }
        if (rootView == view || !(rootView instanceof ViewGroup)) {
            return null;
        }
        return (ViewGroup) rootView;
    }

    public static qe3 j(View view) {
        return l(i(view));
    }

    private static InputMethodManager k(View view) {
        return (InputMethodManager) q30.i(view.getContext(), InputMethodManager.class);
    }

    public static qe3 l(View view) {
        if (view == null) {
            return null;
        }
        return new pe3(view);
    }

    public static float m(View view) {
        float fV = 0.0f;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            fV += be3.v((View) parent);
        }
        return fV;
    }

    public static void n(View view, boolean z) {
        yj3 yj3VarL;
        if (z && (yj3VarL = be3.L(view)) != null) {
            yj3VarL.a(zi3.l.a());
            return;
        }
        InputMethodManager inputMethodManagerK = k(view);
        if (inputMethodManagerK != null) {
            inputMethodManagerK.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static boolean o(View view) {
        return be3.A(view) == 1;
    }

    public static PorterDuff.Mode q(int i, PorterDuff.Mode mode) {
        if (i == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    public static void r(View view) {
        if (be3.S(view)) {
            be3.m0(view);
        } else {
            view.addOnAttachStateChangeListener(new c());
        }
    }

    public static void s(final View view, final boolean z) {
        view.requestFocus();
        view.post(new Runnable() { // from class: mf3
            @Override // java.lang.Runnable
            public final void run() {
                nf3.t(view, z);
            }
        });
    }

    public static void t(View view, boolean z) {
        yj3 yj3VarL;
        if (!z || (yj3VarL = be3.L(view)) == null) {
            k(view).showSoftInput(view, 1);
        } else {
            yj3VarL.e(zi3.l.a());
        }
    }

    public static class e {
        public int a;
        public int b;
        public int c;
        public int d;

        public e(int i, int i2, int i3, int i4) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
        }

        public void a(View view) {
            be3.F0(view, this.a, this.b, this.c, this.d);
        }

        public e(e eVar) {
            this.a = eVar.a;
            this.b = eVar.b;
            this.c = eVar.c;
            this.d = eVar.d;
        }
    }
}
