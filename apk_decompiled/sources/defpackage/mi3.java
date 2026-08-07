package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import android.view.WindowInsetsAnimation$Callback;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import androidx.core.R$id;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class mi3 {
    private e a;

    public static abstract class b {
        WindowInsets a;
        private final int b;

        public b(int i) {
            this.b = i;
        }

        public final int a() {
            return this.b;
        }

        public abstract void b(mi3 mi3Var);

        public abstract void c(mi3 mi3Var);

        public abstract zi3 d(zi3 zi3Var, List list);

        public abstract a e(mi3 mi3Var, a aVar);
    }

    private static class c extends e {
        private static final Interpolator e = new PathInterpolator(0.0f, 1.1f, 0.0f, 1.0f);
        private static final Interpolator f = new ok0();
        private static final Interpolator g = new DecelerateInterpolator();

        private static class a implements View.OnApplyWindowInsetsListener {
            final b a;
            private zi3 b;

            /* JADX INFO: renamed from: mi3$c$a$a, reason: collision with other inner class name */
            class C0144a implements ValueAnimator.AnimatorUpdateListener {
                final /* synthetic */ mi3 a;
                final /* synthetic */ zi3 b;
                final /* synthetic */ zi3 c;
                final /* synthetic */ int d;
                final /* synthetic */ View e;

                C0144a(mi3 mi3Var, zi3 zi3Var, zi3 zi3Var2, int i, View view) {
                    this.a = mi3Var;
                    this.b = zi3Var;
                    this.c = zi3Var2;
                    this.d = i;
                    this.e = view;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.a.e(valueAnimator.getAnimatedFraction());
                    c.k(this.e, c.o(this.b, this.c, this.a.b(), this.d), Collections.singletonList(this.a));
                }
            }

            class b extends AnimatorListenerAdapter {
                final /* synthetic */ mi3 a;
                final /* synthetic */ View b;

                b(mi3 mi3Var, View view) {
                    this.a = mi3Var;
                    this.b = view;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    this.a.e(1.0f);
                    c.i(this.b, this.a);
                }
            }

            /* JADX INFO: renamed from: mi3$c$a$c, reason: collision with other inner class name */
            class RunnableC0145c implements Runnable {
                final /* synthetic */ View a;
                final /* synthetic */ mi3 b;
                final /* synthetic */ a c;
                final /* synthetic */ ValueAnimator d;

                RunnableC0145c(View view, mi3 mi3Var, a aVar, ValueAnimator valueAnimator) {
                    this.a = view;
                    this.b = mi3Var;
                    this.c = aVar;
                    this.d = valueAnimator;
                }

                @Override // java.lang.Runnable
                public void run() {
                    c.l(this.a, this.b, this.c);
                    this.d.start();
                }
            }

            a(View view, b bVar) {
                this.a = bVar;
                zi3 zi3VarH = be3.H(view);
                this.b = zi3VarH != null ? new zi3.a(zi3VarH).a() : null;
            }

            @Override // android.view.View.OnApplyWindowInsetsListener
            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                int iE;
                if (!view.isLaidOut()) {
                    this.b = zi3.x(windowInsets, view);
                    return c.m(view, windowInsets);
                }
                zi3 zi3VarX = zi3.x(windowInsets, view);
                if (this.b == null) {
                    this.b = be3.H(view);
                }
                if (this.b == null) {
                    this.b = zi3VarX;
                    return c.m(view, windowInsets);
                }
                b bVarN = c.n(view);
                if ((bVarN == null || !Objects.equals(bVarN.a, windowInsets)) && (iE = c.e(zi3VarX, this.b)) != 0) {
                    zi3 zi3Var = this.b;
                    mi3 mi3Var = new mi3(iE, c.g(iE, zi3VarX, zi3Var), 160L);
                    mi3Var.e(0.0f);
                    ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(mi3Var.a());
                    a aVarF = c.f(zi3VarX, zi3Var, iE);
                    c.j(view, mi3Var, windowInsets, false);
                    duration.addUpdateListener(new C0144a(mi3Var, zi3VarX, zi3Var, iE, view));
                    duration.addListener(new b(mi3Var, view));
                    pw1.a(view, new RunnableC0145c(view, mi3Var, aVarF, duration));
                    this.b = zi3VarX;
                    return c.m(view, windowInsets);
                }
                return c.m(view, windowInsets);
            }
        }

        c(int i, Interpolator interpolator, long j) {
            super(i, interpolator, j);
        }

        static int e(zi3 zi3Var, zi3 zi3Var2) {
            int i = 0;
            for (int i2 = 1; i2 <= 256; i2 <<= 1) {
                if (!zi3Var.f(i2).equals(zi3Var2.f(i2))) {
                    i |= i2;
                }
            }
            return i;
        }

        static a f(zi3 zi3Var, zi3 zi3Var2, int i) {
            z21 z21VarF = zi3Var.f(i);
            z21 z21VarF2 = zi3Var2.f(i);
            return new a(z21.b(Math.min(z21VarF.a, z21VarF2.a), Math.min(z21VarF.b, z21VarF2.b), Math.min(z21VarF.c, z21VarF2.c), Math.min(z21VarF.d, z21VarF2.d)), z21.b(Math.max(z21VarF.a, z21VarF2.a), Math.max(z21VarF.b, z21VarF2.b), Math.max(z21VarF.c, z21VarF2.c), Math.max(z21VarF.d, z21VarF2.d)));
        }

        static Interpolator g(int i, zi3 zi3Var, zi3 zi3Var2) {
            if ((i & 8) != 0) {
                return zi3Var.f(zi3.l.a()).d > zi3Var2.f(zi3.l.a()).d ? e : f;
            }
            return g;
        }

        private static View.OnApplyWindowInsetsListener h(View view, b bVar) {
            return new a(view, bVar);
        }

        static void i(View view, mi3 mi3Var) {
            b bVarN = n(view);
            if (bVarN != null) {
                bVarN.b(mi3Var);
                if (bVarN.a() == 0) {
                    return;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    i(viewGroup.getChildAt(i), mi3Var);
                }
            }
        }

        static void j(View view, mi3 mi3Var, WindowInsets windowInsets, boolean z) {
            b bVarN = n(view);
            if (bVarN != null) {
                bVarN.a = windowInsets;
                if (!z) {
                    bVarN.c(mi3Var);
                    z = bVarN.a() == 0;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    j(viewGroup.getChildAt(i), mi3Var, windowInsets, z);
                }
            }
        }

        static void k(View view, zi3 zi3Var, List list) {
            b bVarN = n(view);
            if (bVarN != null) {
                zi3Var = bVarN.d(zi3Var, list);
                if (bVarN.a() == 0) {
                    return;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    k(viewGroup.getChildAt(i), zi3Var, list);
                }
            }
        }

        static void l(View view, mi3 mi3Var, a aVar) {
            b bVarN = n(view);
            if (bVarN != null) {
                bVarN.e(mi3Var, aVar);
                if (bVarN.a() == 0) {
                    return;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    l(viewGroup.getChildAt(i), mi3Var, aVar);
                }
            }
        }

        static WindowInsets m(View view, WindowInsets windowInsets) {
            return view.getTag(R$id.tag_on_apply_window_listener) != null ? windowInsets : view.onApplyWindowInsets(windowInsets);
        }

        static b n(View view) {
            Object tag = view.getTag(R$id.tag_window_insets_animation_callback);
            if (tag instanceof a) {
                return ((a) tag).a;
            }
            return null;
        }

        static zi3 o(zi3 zi3Var, zi3 zi3Var2, float f2, int i) {
            zi3.a aVar = new zi3.a(zi3Var);
            for (int i2 = 1; i2 <= 256; i2 <<= 1) {
                if ((i & i2) == 0) {
                    aVar.b(i2, zi3Var.f(i2));
                } else {
                    z21 z21VarF = zi3Var.f(i2);
                    z21 z21VarF2 = zi3Var2.f(i2);
                    float f3 = 1.0f - f2;
                    aVar.b(i2, zi3.o(z21VarF, (int) (((double) ((z21VarF.a - z21VarF2.a) * f3)) + 0.5d), (int) (((double) ((z21VarF.b - z21VarF2.b) * f3)) + 0.5d), (int) (((double) ((z21VarF.c - z21VarF2.c) * f3)) + 0.5d), (int) (((double) ((z21VarF.d - z21VarF2.d) * f3)) + 0.5d)));
                }
            }
            return aVar.a();
        }

        static void p(View view, b bVar) {
            Object tag = view.getTag(R$id.tag_on_apply_window_listener);
            if (bVar == null) {
                view.setTag(R$id.tag_window_insets_animation_callback, null);
                if (tag == null) {
                    view.setOnApplyWindowInsetsListener(null);
                    return;
                }
                return;
            }
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListenerH = h(view, bVar);
            view.setTag(R$id.tag_window_insets_animation_callback, onApplyWindowInsetsListenerH);
            if (tag == null) {
                view.setOnApplyWindowInsetsListener(onApplyWindowInsetsListenerH);
            }
        }
    }

    private static class e {
        private final int a;
        private float b;
        private final Interpolator c;
        private final long d;

        e(int i, Interpolator interpolator, long j) {
            this.a = i;
            this.c = interpolator;
            this.d = j;
        }

        public long a() {
            return this.d;
        }

        public float b() {
            Interpolator interpolator = this.c;
            return interpolator != null ? interpolator.getInterpolation(this.b) : this.b;
        }

        public int c() {
            return this.a;
        }

        public void d(float f) {
            this.b = f;
        }
    }

    public mi3(int i, Interpolator interpolator, long j) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.a = new d(i, interpolator, j);
        } else {
            this.a = new c(i, interpolator, j);
        }
    }

    static void d(View view, b bVar) {
        if (Build.VERSION.SDK_INT >= 30) {
            d.h(view, bVar);
        } else {
            c.p(view, bVar);
        }
    }

    static mi3 f(WindowInsetsAnimation windowInsetsAnimation) {
        return new mi3(windowInsetsAnimation);
    }

    public long a() {
        return this.a.a();
    }

    public float b() {
        return this.a.b();
    }

    public int c() {
        return this.a.c();
    }

    public void e(float f) {
        this.a.d(f);
    }

    private static class d extends e {
        private final WindowInsetsAnimation e;

        private static class a extends WindowInsetsAnimation$Callback {
            private final b a;
            private List b;
            private ArrayList c;
            private final HashMap d;

            a(b bVar) {
                super(bVar.a());
                this.d = new HashMap();
                this.a = bVar;
            }

            private mi3 a(WindowInsetsAnimation windowInsetsAnimation) {
                mi3 mi3Var = (mi3) this.d.get(windowInsetsAnimation);
                if (mi3Var != null) {
                    return mi3Var;
                }
                mi3 mi3VarF = mi3.f(windowInsetsAnimation);
                this.d.put(windowInsetsAnimation, mi3VarF);
                return mi3VarF;
            }

            public void onEnd(WindowInsetsAnimation windowInsetsAnimation) {
                this.a.b(a(windowInsetsAnimation));
                this.d.remove(windowInsetsAnimation);
            }

            public void onPrepare(WindowInsetsAnimation windowInsetsAnimation) {
                this.a.c(a(windowInsetsAnimation));
            }

            public WindowInsets onProgress(WindowInsets windowInsets, List list) {
                ArrayList arrayList = this.c;
                if (arrayList == null) {
                    ArrayList arrayList2 = new ArrayList(list.size());
                    this.c = arrayList2;
                    this.b = Collections.unmodifiableList(arrayList2);
                } else {
                    arrayList.clear();
                }
                for (int size = list.size() - 1; size >= 0; size--) {
                    WindowInsetsAnimation windowInsetsAnimationA = xi3.a(list.get(size));
                    mi3 mi3VarA = a(windowInsetsAnimationA);
                    mi3VarA.e(windowInsetsAnimationA.getFraction());
                    this.c.add(mi3VarA);
                }
                return this.a.d(zi3.w(windowInsets), this.b).v();
            }

            public WindowInsetsAnimation.Bounds onStart(WindowInsetsAnimation windowInsetsAnimation, WindowInsetsAnimation.Bounds bounds) {
                return this.a.e(a(windowInsetsAnimation), a.d(bounds)).c();
            }
        }

        d(WindowInsetsAnimation windowInsetsAnimation) {
            super(0, null, 0L);
            this.e = windowInsetsAnimation;
        }

        public static WindowInsetsAnimation.Bounds e(a aVar) {
            ui3.a();
            return ti3.a(aVar.a().e(), aVar.b().e());
        }

        public static z21 f(WindowInsetsAnimation.Bounds bounds) {
            return z21.d(bounds.getUpperBound());
        }

        public static z21 g(WindowInsetsAnimation.Bounds bounds) {
            return z21.d(bounds.getLowerBound());
        }

        public static void h(View view, b bVar) {
            view.setWindowInsetsAnimationCallback(bVar != null ? new a(bVar) : null);
        }

        @Override // mi3.e
        public long a() {
            return this.e.getDurationMillis();
        }

        @Override // mi3.e
        public float b() {
            return this.e.getInterpolatedFraction();
        }

        @Override // mi3.e
        public int c() {
            return this.e.getTypeMask();
        }

        @Override // mi3.e
        public void d(float f) {
            this.e.setFraction(f);
        }

        d(int i, Interpolator interpolator, long j) {
            this(si3.a(i, interpolator, j));
        }
    }

    public static final class a {
        private final z21 a;
        private final z21 b;

        public a(z21 z21Var, z21 z21Var2) {
            this.a = z21Var;
            this.b = z21Var2;
        }

        public static a d(WindowInsetsAnimation.Bounds bounds) {
            return new a(bounds);
        }

        public z21 a() {
            return this.a;
        }

        public z21 b() {
            return this.b;
        }

        public WindowInsetsAnimation.Bounds c() {
            return d.e(this);
        }

        public String toString() {
            return "Bounds{lower=" + this.a + " upper=" + this.b + "}";
        }

        private a(WindowInsetsAnimation.Bounds bounds) {
            this.a = d.g(bounds);
            this.b = d.f(bounds);
        }
    }

    private mi3(WindowInsetsAnimation windowInsetsAnimation) {
        this(0, null, 0L);
        if (Build.VERSION.SDK_INT >= 30) {
            this.a = new d(windowInsetsAnimation);
        }
    }
}
