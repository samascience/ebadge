package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import defpackage.be3;
import defpackage.fe3;
import defpackage.m2;
import defpackage.p2;
import lombok.eclipse.Eclipse;

/* JADX INFO: loaded from: classes3.dex */
public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.c {
    fe3 a;
    private boolean b;
    private boolean c;
    private boolean e;
    private float d = 0.0f;
    int f = 2;
    float g = 0.5f;
    float h = 0.0f;
    float i = 0.5f;
    private final fe3.c j = new a();

    class a extends fe3.c {
        private int a;
        private int b = -1;

        a() {
        }

        private boolean n(View view, float f) {
            if (f == 0.0f) {
                return Math.abs(view.getLeft() - this.a) >= Math.round(((float) view.getWidth()) * SwipeDismissBehavior.this.g);
            }
            boolean z = be3.A(view) == 1;
            int i = SwipeDismissBehavior.this.f;
            if (i == 2) {
                return true;
            }
            if (i == 0) {
                if (z) {
                    if (f >= 0.0f) {
                        return false;
                    }
                } else if (f <= 0.0f) {
                    return false;
                }
                return true;
            }
            if (i != 1) {
                return false;
            }
            if (z) {
                if (f <= 0.0f) {
                    return false;
                }
            } else if (f >= 0.0f) {
                return false;
            }
            return true;
        }

        @Override // fe3.c
        public int a(View view, int i, int i2) {
            int width;
            int width2;
            int width3;
            boolean z = be3.A(view) == 1;
            int i3 = SwipeDismissBehavior.this.f;
            if (i3 == 0) {
                if (z) {
                    width = this.a - view.getWidth();
                    width2 = this.a;
                } else {
                    width = this.a;
                    width3 = view.getWidth();
                    width2 = width3 + width;
                }
            } else if (i3 != 1) {
                width = this.a - view.getWidth();
                width2 = view.getWidth() + this.a;
            } else if (z) {
                width = this.a;
                width3 = view.getWidth();
                width2 = width3 + width;
            } else {
                width = this.a - view.getWidth();
                width2 = this.a;
            }
            return SwipeDismissBehavior.L(width, i, width2);
        }

        @Override // fe3.c
        public int b(View view, int i, int i2) {
            return view.getTop();
        }

        @Override // fe3.c
        public int d(View view) {
            return view.getWidth();
        }

        @Override // fe3.c
        public void i(View view, int i) {
            this.b = i;
            this.a = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                SwipeDismissBehavior.this.c = true;
                parent.requestDisallowInterceptTouchEvent(true);
                SwipeDismissBehavior.this.c = false;
            }
        }

        @Override // fe3.c
        public void j(int i) {
            SwipeDismissBehavior.this.getClass();
        }

        @Override // fe3.c
        public void k(View view, int i, int i2, int i3, int i4) {
            float width = view.getWidth() * SwipeDismissBehavior.this.h;
            float width2 = view.getWidth() * SwipeDismissBehavior.this.i;
            float fAbs = Math.abs(i - this.a);
            if (fAbs <= width) {
                view.setAlpha(1.0f);
            } else if (fAbs >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(SwipeDismissBehavior.K(0.0f, 1.0f - SwipeDismissBehavior.N(width, width2, fAbs), 1.0f));
            }
        }

        /* JADX WARN: Code duplicated, block: B:10:0x001d  */
        @Override // fe3.c
        public void l(View view, float f, float f2) {
            int i;
            boolean z;
            this.b = -1;
            int width = view.getWidth();
            if (n(view, f)) {
                if (f >= 0.0f) {
                    int left = view.getLeft();
                    int i2 = this.a;
                    if (left < i2) {
                        i = this.a - width;
                    } else {
                        i = i2 + width;
                    }
                } else {
                    i = this.a - width;
                }
                z = true;
            } else {
                i = this.a;
                z = false;
            }
            if (SwipeDismissBehavior.this.a.P(i, view.getTop())) {
                be3.h0(view, new c(view, z));
            } else if (z) {
                SwipeDismissBehavior.this.getClass();
            }
        }

        @Override // fe3.c
        public boolean m(View view, int i) {
            int i2 = this.b;
            return (i2 == -1 || i2 == i) && SwipeDismissBehavior.this.J(view);
        }
    }

    class b implements p2 {
        b() {
        }

        @Override // defpackage.p2
        public boolean a(View view, p2.a aVar) {
            if (!SwipeDismissBehavior.this.J(view)) {
                return false;
            }
            boolean z = be3.A(view) == 1;
            int i = SwipeDismissBehavior.this.f;
            be3.Z(view, (!(i == 0 && z) && (i != 1 || z)) ? view.getWidth() : -view.getWidth());
            view.setAlpha(0.0f);
            SwipeDismissBehavior.this.getClass();
            return true;
        }
    }

    private class c implements Runnable {
        private final View a;
        private final boolean b;

        c(View view, boolean z) {
            this.a = view;
            this.b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            fe3 fe3Var = SwipeDismissBehavior.this.a;
            if (fe3Var != null && fe3Var.n(true)) {
                be3.h0(this.a, this);
            } else if (this.b) {
                SwipeDismissBehavior.this.getClass();
            }
        }
    }

    static float K(float f, float f2, float f3) {
        return Math.min(Math.max(f, f2), f3);
    }

    static int L(int i, int i2, int i3) {
        return Math.min(Math.max(i, i2), i3);
    }

    private void M(ViewGroup viewGroup) {
        if (this.a == null) {
            this.a = this.e ? fe3.o(viewGroup, this.d, this.j) : fe3.p(viewGroup, this.j);
        }
    }

    static float N(float f, float f2, float f3) {
        return (f3 - f) / (f2 - f);
    }

    private void R(View view) {
        be3.j0(view, Eclipse.HasTypeAnnotations);
        if (J(view)) {
            be3.l0(view, m2.a.y, null, new b());
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean H(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        if (this.a == null) {
            return false;
        }
        if (this.c && motionEvent.getActionMasked() == 3) {
            return true;
        }
        this.a.G(motionEvent);
        return true;
    }

    public boolean J(View view) {
        return true;
    }

    public void O(float f) {
        this.i = K(0.0f, f, 1.0f);
    }

    public void P(float f) {
        this.h = K(0.0f, f, 1.0f);
    }

    public void Q(int i) {
        this.f = i;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean o(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        boolean zF = this.b;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            zF = coordinatorLayout.F(view, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.b = zF;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.b = false;
        }
        if (!zF) {
            return false;
        }
        M(coordinatorLayout);
        return !this.c && this.a.Q(motionEvent);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean p(CoordinatorLayout coordinatorLayout, View view, int i) {
        boolean zP = super.p(coordinatorLayout, view, i);
        if (be3.y(view) == 0) {
            be3.z0(view, 1);
            R(view);
        }
        return zP;
    }
}
