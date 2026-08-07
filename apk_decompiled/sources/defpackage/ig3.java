package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.R$id;

/* JADX INFO: loaded from: classes.dex */
public abstract class ig3 extends f53 {
    private static final String[] S = {"android:visibility:visibility", "android:visibility:parent"};
    private int R = 3;

    private static class a extends AnimatorListenerAdapter implements f53.f {
        private final View a;
        private final int b;
        private final ViewGroup c;
        private final boolean d;
        private boolean e;
        boolean f = false;

        a(View view, int i, boolean z) {
            this.a = view;
            this.b = i;
            this.c = (ViewGroup) view.getParent();
            this.d = z;
            i(true);
        }

        private void h() {
            if (!this.f) {
                of3.f(this.a, this.b);
                ViewGroup viewGroup = this.c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            i(false);
        }

        private void i(boolean z) {
            ViewGroup viewGroup;
            if (!this.d || this.e == z || (viewGroup = this.c) == null) {
                return;
            }
            this.e = z;
            he3.b(viewGroup, z);
        }

        @Override // f53.f
        public void a(f53 f53Var) {
        }

        @Override // f53.f
        public void b(f53 f53Var) {
            i(true);
            if (this.f) {
                return;
            }
            of3.f(this.a, 0);
        }

        @Override // f53.f
        public void c(f53 f53Var) {
            f53Var.S(this);
        }

        @Override // f53.f
        public void e(f53 f53Var) {
            i(false);
            if (this.f) {
                return;
            }
            of3.f(this.a, this.b);
        }

        @Override // f53.f
        public void g(f53 f53Var) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            h();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z) {
            if (z) {
                return;
            }
            h();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator, boolean z) {
            if (z) {
                of3.f(this.a, 0);
                ViewGroup viewGroup = this.c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
        }
    }

    private class b extends AnimatorListenerAdapter implements f53.f {
        private final ViewGroup a;
        private final View b;
        private final View c;
        private boolean d = true;

        b(ViewGroup viewGroup, View view, View view2) {
            this.a = viewGroup;
            this.b = view;
            this.c = view2;
        }

        private void h() {
            this.c.setTag(R$id.save_overlay_view, null);
            this.a.getOverlay().remove(this.b);
            this.d = false;
        }

        @Override // f53.f
        public void a(f53 f53Var) {
        }

        @Override // f53.f
        public void b(f53 f53Var) {
        }

        @Override // f53.f
        public void c(f53 f53Var) {
            f53Var.S(this);
        }

        @Override // f53.f
        public void e(f53 f53Var) {
        }

        @Override // f53.f
        public void g(f53 f53Var) {
            if (this.d) {
                h();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            h();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator animator) {
            this.a.getOverlay().remove(this.b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator animator) {
            if (this.b.getParent() == null) {
                this.a.getOverlay().add(this.b);
            } else {
                ig3.this.cancel();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator, boolean z) {
            if (z) {
                this.c.setTag(R$id.save_overlay_view, this.b);
                this.a.getOverlay().add(this.b);
                this.d = true;
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z) {
            if (z) {
                return;
            }
            h();
        }
    }

    private static class c {
        boolean a;
        boolean b;
        int c;
        int d;
        ViewGroup e;
        ViewGroup f;

        c() {
        }
    }

    private void f0(s53 s53Var) {
        s53Var.a.put("android:visibility:visibility", Integer.valueOf(s53Var.b.getVisibility()));
        s53Var.a.put("android:visibility:parent", s53Var.b.getParent());
        int[] iArr = new int[2];
        s53Var.b.getLocationOnScreen(iArr);
        s53Var.a.put("android:visibility:screenLocation", iArr);
    }

    private c g0(s53 s53Var, s53 s53Var2) {
        c cVar = new c();
        cVar.a = false;
        cVar.b = false;
        if (s53Var == null || !s53Var.a.containsKey("android:visibility:visibility")) {
            cVar.c = -1;
            cVar.e = null;
        } else {
            cVar.c = ((Integer) s53Var.a.get("android:visibility:visibility")).intValue();
            cVar.e = (ViewGroup) s53Var.a.get("android:visibility:parent");
        }
        if (s53Var2 == null || !s53Var2.a.containsKey("android:visibility:visibility")) {
            cVar.d = -1;
            cVar.f = null;
        } else {
            cVar.d = ((Integer) s53Var2.a.get("android:visibility:visibility")).intValue();
            cVar.f = (ViewGroup) s53Var2.a.get("android:visibility:parent");
        }
        if (s53Var != null && s53Var2 != null) {
            int i = cVar.c;
            int i2 = cVar.d;
            if (i == i2 && cVar.e == cVar.f) {
                return cVar;
            }
            if (i != i2) {
                if (i == 0) {
                    cVar.b = false;
                    cVar.a = true;
                } else if (i2 == 0) {
                    cVar.b = true;
                    cVar.a = true;
                }
            } else if (cVar.f == null) {
                cVar.b = false;
                cVar.a = true;
            } else if (cVar.e == null) {
                cVar.b = true;
                cVar.a = true;
            }
        } else if (s53Var == null && cVar.d == 0) {
            cVar.b = true;
            cVar.a = true;
        } else if (s53Var2 == null && cVar.c == 0) {
            cVar.b = false;
            cVar.a = true;
        }
        return cVar;
    }

    @Override // defpackage.f53
    public String[] E() {
        return S;
    }

    @Override // defpackage.f53
    public boolean G(s53 s53Var, s53 s53Var2) {
        if (s53Var == null && s53Var2 == null) {
            return false;
        }
        if (s53Var != null && s53Var2 != null && s53Var2.a.containsKey("android:visibility:visibility") != s53Var.a.containsKey("android:visibility:visibility")) {
            return false;
        }
        c cVarG0 = g0(s53Var, s53Var2);
        if (cVarG0.a) {
            return cVarG0.c == 0 || cVarG0.d == 0;
        }
        return false;
    }

    @Override // defpackage.f53
    public void f(s53 s53Var) {
        f0(s53Var);
    }

    public Animator h0(ViewGroup viewGroup, s53 s53Var, int i, s53 s53Var2, int i2) {
        if ((this.R & 1) != 1 || s53Var2 == null) {
            return null;
        }
        if (s53Var == null) {
            View view = (View) s53Var2.b.getParent();
            if (g0(t(view, false), F(view, false)).a) {
                return null;
            }
        }
        return i0(viewGroup, s53Var2.b, s53Var, s53Var2);
    }

    @Override // defpackage.f53
    public void i(s53 s53Var) {
        f0(s53Var);
    }

    public abstract Animator i0(ViewGroup viewGroup, View view, s53 s53Var, s53 s53Var2);

    /* JADX WARN: Code duplicated, block: B:23:0x0040  */
    public Animator j0(ViewGroup viewGroup, s53 s53Var, int i, s53 s53Var2, int i2) {
        View view;
        boolean z;
        boolean z2;
        View view2;
        if ((this.R & 2) != 2 || s53Var == null) {
            return null;
        }
        View view3 = s53Var.b;
        View viewA = s53Var2 != null ? s53Var2.b : null;
        int i3 = R$id.save_overlay_view;
        View view4 = (View) view3.getTag(i3);
        if (view4 != null) {
            view2 = null;
            z2 = true;
        } else {
            if (viewA == null || viewA.getParent() == null) {
                if (viewA != null) {
                    view = null;
                    z = false;
                } else {
                    viewA = null;
                    view = null;
                    z = true;
                }
            } else if (i2 == 4 || view3 == viewA) {
                view = viewA;
                z = false;
                viewA = null;
            } else {
                viewA = null;
                view = null;
                z = true;
            }
            if (z) {
                if (view3.getParent() != null) {
                    if (view3.getParent() instanceof View) {
                        View view5 = (View) view3.getParent();
                        if (g0(F(view5, true), t(view5, true)).a) {
                            int id = view5.getId();
                            if (view5.getParent() != null || id == -1 || viewGroup.findViewById(id) == null || !this.w) {
                            }
                        } else {
                            viewA = r53.a(viewGroup, view3, view5);
                        }
                    }
                    z2 = false;
                    View view6 = view;
                    view4 = viewA;
                    view2 = view6;
                }
                view2 = view;
                z2 = false;
                view4 = view3;
            } else {
                z2 = false;
                View view7 = view;
                view4 = viewA;
                view2 = view7;
            }
        }
        if (view4 == null) {
            if (view2 == null) {
                return null;
            }
            int visibility = view2.getVisibility();
            of3.f(view2, 0);
            Animator animatorK0 = k0(viewGroup, view2, s53Var, s53Var2);
            if (animatorK0 != null) {
                a aVar = new a(view2, i2, true);
                animatorK0.addListener(aVar);
                x().a(aVar);
            } else {
                of3.f(view2, visibility);
            }
            return animatorK0;
        }
        if (!z2) {
            int[] iArr = (int[]) s53Var.a.get("android:visibility:screenLocation");
            int i4 = iArr[0];
            int i5 = iArr[1];
            int[] iArr2 = new int[2];
            viewGroup.getLocationOnScreen(iArr2);
            view4.offsetLeftAndRight((i4 - iArr2[0]) - view4.getLeft());
            view4.offsetTopAndBottom((i5 - iArr2[1]) - view4.getTop());
            viewGroup.getOverlay().add(view4);
        }
        Animator animatorK1 = k0(viewGroup, view4, s53Var, s53Var2);
        if (!z2) {
            if (animatorK1 == null) {
                viewGroup.getOverlay().remove(view4);
            } else {
                view3.setTag(i3, view4);
                b bVar = new b(viewGroup, view4, view3);
                animatorK1.addListener(bVar);
                animatorK1.addPauseListener(bVar);
                x().a(bVar);
            }
        }
        return animatorK1;
    }

    public abstract Animator k0(ViewGroup viewGroup, View view, s53 s53Var, s53 s53Var2);

    public void l0(int i) {
        if ((i & (-4)) != 0) {
            throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
        }
        this.R = i;
    }

    @Override // defpackage.f53
    public Animator m(ViewGroup viewGroup, s53 s53Var, s53 s53Var2) {
        c cVarG0 = g0(s53Var, s53Var2);
        if (!cVarG0.a) {
            return null;
        }
        if (cVarG0.e == null && cVarG0.f == null) {
            return null;
        }
        return cVarG0.b ? h0(viewGroup, s53Var, cVarG0.c, s53Var2, cVarG0.d) : j0(viewGroup, s53Var, cVarG0.c, s53Var2, cVarG0.d);
    }
}
