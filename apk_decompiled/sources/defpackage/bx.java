package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.R$id;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class bx extends f53 {
    private static final String[] S = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    private static final Property T = new a(PointF.class, "topLeft");
    private static final Property U = new b(PointF.class, "bottomRight");
    private static final Property V = new c(PointF.class, "bottomRight");
    private static final Property W = new d(PointF.class, "topLeft");
    private static final Property X = new e(PointF.class, "position");
    private static final ee2 Y = new ee2();
    private boolean R = false;

    class a extends Property {
        a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(i iVar) {
            return null;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(i iVar, PointF pointF) {
            iVar.c(pointF);
        }
    }

    class b extends Property {
        b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(i iVar) {
            return null;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(i iVar, PointF pointF) {
            iVar.a(pointF);
        }
    }

    class c extends Property {
        c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            of3.d(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }
    }

    class d extends Property {
        d(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            of3.d(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }
    }

    class e extends Property {
        e(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            int iRound = Math.round(pointF.x);
            int iRound2 = Math.round(pointF.y);
            of3.d(view, iRound, iRound2, view.getWidth() + iRound, view.getHeight() + iRound2);
        }
    }

    class f extends AnimatorListenerAdapter {
        final /* synthetic */ i a;
        private final i mViewBounds;

        f(i iVar) {
            this.a = iVar;
            this.mViewBounds = iVar;
        }
    }

    private static class g extends AnimatorListenerAdapter implements f53.f {
        private final View a;
        private final Rect b;
        private final boolean c;
        private final Rect d;
        private final boolean e;
        private final int f;
        private final int g;
        private final int h;
        private final int i;
        private final int j;
        private final int k;
        private final int l;
        private final int m;
        private boolean n;

        g(View view, Rect rect, boolean z, Rect rect2, boolean z2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.a = view;
            this.b = rect;
            this.c = z;
            this.d = rect2;
            this.e = z2;
            this.f = i;
            this.g = i2;
            this.h = i3;
            this.i = i4;
            this.j = i5;
            this.k = i6;
            this.l = i7;
            this.m = i8;
        }

        @Override // f53.f
        public void a(f53 f53Var) {
        }

        @Override // f53.f
        public void b(f53 f53Var) {
            View view = this.a;
            int i = R$id.transition_clip;
            Rect rect = (Rect) view.getTag(i);
            this.a.setTag(i, null);
            this.a.setClipBounds(rect);
        }

        @Override // f53.f
        public void c(f53 f53Var) {
        }

        @Override // f53.f
        public void e(f53 f53Var) {
            this.a.setTag(R$id.transition_clip, this.a.getClipBounds());
            this.a.setClipBounds(this.e ? null : this.d);
        }

        @Override // f53.f
        public void g(f53 f53Var) {
            this.n = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            onAnimationEnd(animator, false);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            onAnimationStart(animator, false);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z) {
            if (this.n) {
                return;
            }
            Rect rect = null;
            if (z) {
                if (!this.c) {
                    rect = this.b;
                }
            } else if (!this.e) {
                rect = this.d;
            }
            this.a.setClipBounds(rect);
            if (z) {
                of3.d(this.a, this.f, this.g, this.h, this.i);
            } else {
                of3.d(this.a, this.j, this.k, this.l, this.m);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator, boolean z) {
            int iMax = Math.max(this.h - this.f, this.l - this.j);
            int iMax2 = Math.max(this.i - this.g, this.m - this.k);
            int i = z ? this.j : this.f;
            int i2 = z ? this.k : this.g;
            of3.d(this.a, i, i2, iMax + i, iMax2 + i2);
            this.a.setClipBounds(z ? this.d : this.b);
        }
    }

    private static class h extends n53 {
        boolean a = false;
        final ViewGroup b;

        h(ViewGroup viewGroup) {
            this.b = viewGroup;
        }

        @Override // defpackage.n53, f53.f
        public void b(f53 f53Var) {
            he3.b(this.b, true);
        }

        @Override // f53.f
        public void c(f53 f53Var) {
            if (!this.a) {
                he3.b(this.b, false);
            }
            f53Var.S(this);
        }

        @Override // defpackage.n53, f53.f
        public void e(f53 f53Var) {
            he3.b(this.b, false);
        }

        @Override // defpackage.n53, f53.f
        public void g(f53 f53Var) {
            he3.b(this.b, false);
            this.a = true;
        }
    }

    private static class i {
        private int a;
        private int b;
        private int c;
        private int d;
        private final View e;
        private int f;
        private int g;

        i(View view) {
            this.e = view;
        }

        private void b() {
            of3.d(this.e, this.a, this.b, this.c, this.d);
            this.f = 0;
            this.g = 0;
        }

        void a(PointF pointF) {
            this.c = Math.round(pointF.x);
            this.d = Math.round(pointF.y);
            int i = this.g + 1;
            this.g = i;
            if (this.f == i) {
                b();
            }
        }

        void c(PointF pointF) {
            this.a = Math.round(pointF.x);
            this.b = Math.round(pointF.y);
            int i = this.f + 1;
            this.f = i;
            if (i == this.g) {
                b();
            }
        }
    }

    private void f0(s53 s53Var) {
        View view = s53Var.b;
        if (!view.isLaidOut() && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        s53Var.a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        s53Var.a.put("android:changeBounds:parent", s53Var.b.getParent());
        if (this.R) {
            s53Var.a.put("android:changeBounds:clip", view.getClipBounds());
        }
    }

    @Override // defpackage.f53
    public String[] E() {
        return S;
    }

    @Override // defpackage.f53
    public void f(s53 s53Var) {
        f0(s53Var);
    }

    @Override // defpackage.f53
    public void i(s53 s53Var) {
        Rect rect;
        f0(s53Var);
        if (!this.R || (rect = (Rect) s53Var.b.getTag(R$id.transition_clip)) == null) {
            return;
        }
        s53Var.a.put("android:changeBounds:clip", rect);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.f53
    public Animator m(ViewGroup viewGroup, s53 s53Var, s53 s53Var2) {
        int i2;
        View view;
        int i3;
        ObjectAnimator objectAnimatorOfObject;
        Animator animatorC;
        if (s53Var == null || s53Var2 == null) {
            return null;
        }
        Map map = s53Var.a;
        Map map2 = s53Var2.a;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view2 = s53Var2.b;
        Rect rect = (Rect) s53Var.a.get("android:changeBounds:bounds");
        Rect rect2 = (Rect) s53Var2.a.get("android:changeBounds:bounds");
        int i4 = rect.left;
        int i5 = rect2.left;
        int i6 = rect.top;
        int i7 = rect2.top;
        int i8 = rect.right;
        int i9 = rect2.right;
        int i10 = rect.bottom;
        int i11 = rect2.bottom;
        int i12 = i8 - i4;
        int i13 = i10 - i6;
        int i14 = i9 - i5;
        int i15 = i11 - i7;
        Rect rect3 = (Rect) s53Var.a.get("android:changeBounds:clip");
        Rect rect4 = (Rect) s53Var2.a.get("android:changeBounds:clip");
        if ((i12 == 0 || i13 == 0) && (i14 == 0 || i15 == 0)) {
            i2 = 0;
        } else {
            i2 = (i4 == i5 && i6 == i7) ? 0 : 1;
            if (i8 != i9 || i10 != i11) {
                i2++;
            }
        }
        if ((rect3 != null && !rect3.equals(rect4)) || (rect3 == null && rect4 != null)) {
            i2++;
        }
        if (i2 <= 0) {
            return null;
        }
        if (this.R) {
            view = view2;
            of3.d(view, i4, i6, Math.max(i12, i14) + i4, i6 + Math.max(i13, i15));
            ObjectAnimator objectAnimatorA = (i4 == i5 && i6 == i7) ? null : ht1.a(view, X, v().a(i4, i6, i5, i7));
            boolean z = rect3 == null;
            if (z) {
                i3 = 0;
                rect3 = new Rect(0, 0, i12, i13);
            } else {
                i3 = 0;
            }
            Rect rect5 = rect3;
            int i16 = rect4 == null ? 1 : i3;
            Rect rect6 = i16 != 0 ? new Rect(i3, i3, i14, i15) : rect4;
            if (rect5.equals(rect6)) {
                objectAnimatorOfObject = null;
            } else {
                view.setClipBounds(rect5);
                objectAnimatorOfObject = ObjectAnimator.ofObject(view, "clipBounds", Y, rect5, rect6);
                g gVar = new g(view, rect5, z, rect6, i16, i4, i6, i8, i10, i5, i7, i9, i11);
                objectAnimatorOfObject.addListener(gVar);
                a(gVar);
            }
            animatorC = r53.c(objectAnimatorA, objectAnimatorOfObject);
        } else {
            view = view2;
            of3.d(view, i4, i6, i8, i10);
            if (i2 != 2) {
                animatorC = (i4 == i5 && i6 == i7) ? ht1.a(view, V, v().a(i8, i10, i9, i11)) : ht1.a(view, W, v().a(i4, i6, i5, i7));
            } else if (i12 == i14 && i13 == i15) {
                animatorC = ht1.a(view, X, v().a(i4, i6, i5, i7));
            } else {
                i iVar = new i(view);
                ObjectAnimator objectAnimatorA2 = ht1.a(iVar, T, v().a(i4, i6, i5, i7));
                ObjectAnimator objectAnimatorA3 = ht1.a(iVar, U, v().a(i8, i10, i9, i11));
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(objectAnimatorA2, objectAnimatorA3);
                animatorSet.addListener(new f(iVar));
                animatorC = animatorSet;
            }
        }
        if (view.getParent() instanceof ViewGroup) {
            ViewGroup viewGroup4 = (ViewGroup) view.getParent();
            he3.b(viewGroup4, true);
            x().a(new h(viewGroup4));
        }
        return animatorC;
    }
}
