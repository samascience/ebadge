package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R$id;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import defpackage.bd0;
import defpackage.be3;
import defpackage.c7;
import defpackage.ch1;
import defpackage.cl1;
import defpackage.dl1;
import defpackage.m9;
import defpackage.n42;
import defpackage.nx;
import defpackage.y6;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {
    private final Rect c;
    private final RectF d;
    private final RectF e;
    private final int[] f;
    private float g;
    private float h;

    class a extends AnimatorListenerAdapter {
        final /* synthetic */ boolean a;
        final /* synthetic */ View b;
        final /* synthetic */ View c;

        a(boolean z, View view, View view2) {
            this.a = z;
            this.b = view;
            this.c = view2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.a) {
                return;
            }
            this.b.setVisibility(4);
            this.c.setAlpha(1.0f);
            this.c.setVisibility(0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.a) {
                this.b.setVisibility(0);
                this.c.setAlpha(0.0f);
                this.c.setVisibility(4);
            }
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ View a;

        b(View view) {
            this.a = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.a.invalidate();
        }
    }

    class c extends AnimatorListenerAdapter {
        final /* synthetic */ com.google.android.material.circularreveal.c a;
        final /* synthetic */ Drawable b;

        c(com.google.android.material.circularreveal.c cVar, Drawable drawable) {
            this.a = cVar;
            this.b = drawable;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.a.setCircularRevealOverlayDrawable(null);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.a.setCircularRevealOverlayDrawable(this.b);
        }
    }

    class d extends AnimatorListenerAdapter {
        final /* synthetic */ com.google.android.material.circularreveal.c a;

        d(com.google.android.material.circularreveal.c cVar) {
            this.a = cVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            com.google.android.material.circularreveal.c.e revealInfo = this.a.getRevealInfo();
            revealInfo.c = Float.MAX_VALUE;
            this.a.setRevealInfo(revealInfo);
        }
    }

    protected static class e {
        public cl1 a;
        public n42 b;

        protected e() {
        }
    }

    public FabTransformationBehavior() {
        this.c = new Rect();
        this.d = new RectF();
        this.e = new RectF();
        this.f = new int[2];
    }

    private ViewGroup O(View view) {
        View viewFindViewById = view.findViewById(R$id.mtrl_child_content_container);
        if (viewFindViewById != null) {
            return j0(viewFindViewById);
        }
        return ((view instanceof TransformationChildLayout) || (view instanceof TransformationChildCard)) ? j0(((ViewGroup) view).getChildAt(0)) : j0(view);
    }

    private void P(View view, e eVar, dl1 dl1Var, dl1 dl1Var2, float f, float f2, float f3, float f4, RectF rectF) {
        float fW = W(eVar, dl1Var, f, f3);
        float fW2 = W(eVar, dl1Var2, f2, f4);
        Rect rect = this.c;
        view.getWindowVisibleDisplayFrame(rect);
        RectF rectF2 = this.d;
        rectF2.set(rect);
        RectF rectF3 = this.e;
        X(view, rectF3);
        rectF3.offset(fW, fW2);
        rectF3.intersect(rectF2);
        rectF.set(rectF3);
    }

    private void Q(View view, RectF rectF) {
        X(view, rectF);
        rectF.offset(this.g, this.h);
    }

    private Pair R(float f, float f2, boolean z, e eVar) {
        dl1 dl1VarH;
        dl1 dl1VarH2;
        if (f == 0.0f || f2 == 0.0f) {
            dl1VarH = eVar.a.h("translationXLinear");
            dl1VarH2 = eVar.a.h("translationYLinear");
        } else if ((!z || f2 >= 0.0f) && (z || f2 <= 0.0f)) {
            dl1VarH = eVar.a.h("translationXCurveDownwards");
            dl1VarH2 = eVar.a.h("translationYCurveDownwards");
        } else {
            dl1VarH = eVar.a.h("translationXCurveUpwards");
            dl1VarH2 = eVar.a.h("translationYCurveUpwards");
        }
        return new Pair(dl1VarH, dl1VarH2);
    }

    private float S(View view, View view2, n42 n42Var) {
        RectF rectF = this.d;
        RectF rectF2 = this.e;
        Q(view, rectF);
        X(view2, rectF2);
        rectF2.offset(-U(view, view2, n42Var), 0.0f);
        return rectF.centerX() - rectF2.left;
    }

    private float T(View view, View view2, n42 n42Var) {
        RectF rectF = this.d;
        RectF rectF2 = this.e;
        Q(view, rectF);
        X(view2, rectF2);
        rectF2.offset(0.0f, -V(view, view2, n42Var));
        return rectF.centerY() - rectF2.top;
    }

    private float U(View view, View view2, n42 n42Var) {
        float fCenterX;
        float fCenterX2;
        float f;
        RectF rectF = this.d;
        RectF rectF2 = this.e;
        Q(view, rectF);
        X(view2, rectF2);
        int i = n42Var.a & 7;
        if (i == 1) {
            fCenterX = rectF2.centerX();
            fCenterX2 = rectF.centerX();
        } else {
            if (i != 3) {
                if (i != 5) {
                    f = 0.0f;
                } else {
                    fCenterX = rectF2.right;
                    fCenterX2 = rectF.right;
                }
                return f + n42Var.b;
            }
            fCenterX = rectF2.left;
            fCenterX2 = rectF.left;
        }
        f = fCenterX - fCenterX2;
        return f + n42Var.b;
    }

    private float V(View view, View view2, n42 n42Var) {
        float fCenterY;
        float fCenterY2;
        float f;
        RectF rectF = this.d;
        RectF rectF2 = this.e;
        Q(view, rectF);
        X(view2, rectF2);
        int i = n42Var.a & 112;
        if (i == 16) {
            fCenterY = rectF2.centerY();
            fCenterY2 = rectF.centerY();
        } else {
            if (i != 48) {
                if (i != 80) {
                    f = 0.0f;
                } else {
                    fCenterY = rectF2.bottom;
                    fCenterY2 = rectF.bottom;
                }
                return f + n42Var.c;
            }
            fCenterY = rectF2.top;
            fCenterY2 = rectF.top;
        }
        f = fCenterY - fCenterY2;
        return f + n42Var.c;
    }

    private float W(e eVar, dl1 dl1Var, float f, float f2) {
        long jC = dl1Var.c();
        long jD = dl1Var.d();
        dl1 dl1VarH = eVar.a.h("expansion");
        return y6.a(f, f2, dl1Var.e().getInterpolation((((dl1VarH.c() + dl1VarH.d()) + 17) - jC) / jD));
    }

    private void X(View view, RectF rectF) {
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        int[] iArr = this.f;
        view.getLocationInWindow(iArr);
        rectF.offsetTo(iArr[0], iArr[1]);
        rectF.offset((int) (-view.getTranslationX()), (int) (-view.getTranslationY()));
    }

    private void Y(View view, View view2, boolean z, boolean z2, e eVar, List list, List list2) {
        ViewGroup viewGroupO;
        ObjectAnimator objectAnimatorOfFloat;
        if (view2 instanceof ViewGroup) {
            if (((view2 instanceof com.google.android.material.circularreveal.c) && com.google.android.material.circularreveal.b.j == 0) || (viewGroupO = O(view2)) == null) {
                return;
            }
            if (z) {
                if (!z2) {
                    nx.a.set(viewGroupO, Float.valueOf(0.0f));
                }
                objectAnimatorOfFloat = ObjectAnimator.ofFloat(viewGroupO, (Property<ViewGroup, Float>) nx.a, 1.0f);
            } else {
                objectAnimatorOfFloat = ObjectAnimator.ofFloat(viewGroupO, (Property<ViewGroup, Float>) nx.a, 0.0f);
            }
            eVar.a.h("contentFade").a(objectAnimatorOfFloat);
            list.add(objectAnimatorOfFloat);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void Z(View view, View view2, boolean z, boolean z2, e eVar, List list, List list2) {
        ObjectAnimator objectAnimatorOfInt;
        if (view2 instanceof com.google.android.material.circularreveal.c) {
            com.google.android.material.circularreveal.c cVar = (com.google.android.material.circularreveal.c) view2;
            int iH0 = h0(view);
            int i = 16777215 & iH0;
            if (z) {
                if (!z2) {
                    cVar.setCircularRevealScrimColor(iH0);
                }
                objectAnimatorOfInt = ObjectAnimator.ofInt(cVar, (Property<com.google.android.material.circularreveal.c, Integer>) com.google.android.material.circularreveal.c.d.a, i);
            } else {
                objectAnimatorOfInt = ObjectAnimator.ofInt(cVar, (Property<com.google.android.material.circularreveal.c, Integer>) com.google.android.material.circularreveal.c.d.a, iH0);
            }
            objectAnimatorOfInt.setEvaluator(m9.b());
            eVar.a.h("color").a(objectAnimatorOfInt);
            list.add(objectAnimatorOfInt);
        }
    }

    private void a0(View view, View view2, boolean z, e eVar, List list) {
        float fU = U(view, view2, eVar.b);
        float fV = V(view, view2, eVar.b);
        Pair pairR = R(fU, fV, z, eVar);
        dl1 dl1Var = (dl1) pairR.first;
        dl1 dl1Var2 = (dl1) pairR.second;
        Property property = View.TRANSLATION_X;
        if (!z) {
            fU = this.g;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, fU);
        Property property2 = View.TRANSLATION_Y;
        if (!z) {
            fV = this.h;
        }
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, (Property<View, Float>) property2, fV);
        dl1Var.a(objectAnimatorOfFloat);
        dl1Var2.a(objectAnimatorOfFloat2);
        list.add(objectAnimatorOfFloat);
        list.add(objectAnimatorOfFloat2);
    }

    private void b0(View view, View view2, boolean z, boolean z2, e eVar, List list, List list2) {
        ObjectAnimator objectAnimatorOfFloat;
        float fV = be3.v(view2) - be3.v(view);
        if (z) {
            if (!z2) {
                view2.setTranslationZ(-fV);
            }
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Z, 0.0f);
        } else {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Z, -fV);
        }
        eVar.a.h("elevation").a(objectAnimatorOfFloat);
        list.add(objectAnimatorOfFloat);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void c0(View view, View view2, boolean z, boolean z2, e eVar, float f, float f2, List list, List list2) {
        Animator animatorA;
        if (view2 instanceof com.google.android.material.circularreveal.c) {
            com.google.android.material.circularreveal.c cVar = (com.google.android.material.circularreveal.c) view2;
            float fS = S(view, view2, eVar.b);
            float fT = T(view, view2, eVar.b);
            ((FloatingActionButton) view).i(this.c);
            float fWidth = this.c.width() / 2.0f;
            dl1 dl1VarH = eVar.a.h("expansion");
            if (z) {
                if (!z2) {
                    cVar.setRevealInfo(new com.google.android.material.circularreveal.c.e(fS, fT, fWidth));
                }
                if (z2) {
                    fWidth = cVar.getRevealInfo().c;
                }
                animatorA = com.google.android.material.circularreveal.a.a(cVar, fS, fT, ch1.b(fS, fT, 0.0f, 0.0f, f, f2));
                animatorA.addListener(new d(cVar));
                f0(view2, dl1VarH.c(), (int) fS, (int) fT, fWidth, list);
            } else {
                float f3 = cVar.getRevealInfo().c;
                Animator animatorA2 = com.google.android.material.circularreveal.a.a(cVar, fS, fT, fWidth);
                int i = (int) fS;
                int i2 = (int) fT;
                f0(view2, dl1VarH.c(), i, i2, f3, list);
                e0(view2, dl1VarH.c(), dl1VarH.d(), eVar.a.i(), i, i2, fWidth, list);
                animatorA = animatorA2;
            }
            dl1VarH.a(animatorA);
            list.add(animatorA);
            list2.add(com.google.android.material.circularreveal.a.b(cVar));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void d0(View view, View view2, boolean z, boolean z2, e eVar, List list, List list2) {
        ObjectAnimator objectAnimatorOfInt;
        if ((view2 instanceof com.google.android.material.circularreveal.c) && (view instanceof ImageView)) {
            com.google.android.material.circularreveal.c cVar = (com.google.android.material.circularreveal.c) view2;
            Drawable drawable = ((ImageView) view).getDrawable();
            if (drawable == null) {
                return;
            }
            drawable.mutate();
            if (z) {
                if (!z2) {
                    drawable.setAlpha(255);
                }
                objectAnimatorOfInt = ObjectAnimator.ofInt(drawable, (Property<Drawable, Integer>) bd0.b, 0);
            } else {
                objectAnimatorOfInt = ObjectAnimator.ofInt(drawable, (Property<Drawable, Integer>) bd0.b, 255);
            }
            objectAnimatorOfInt.addUpdateListener(new b(view2));
            eVar.a.h("iconFade").a(objectAnimatorOfInt);
            list.add(objectAnimatorOfInt);
            list2.add(new c(cVar, drawable));
        }
    }

    private void e0(View view, long j, long j2, long j3, int i, int i2, float f, List list) {
        long j4 = j + j2;
        if (j4 < j3) {
            Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(view, i, i2, f, f);
            animatorCreateCircularReveal.setStartDelay(j4);
            animatorCreateCircularReveal.setDuration(j3 - j4);
            list.add(animatorCreateCircularReveal);
        }
    }

    private void f0(View view, long j, int i, int i2, float f, List list) {
        if (j > 0) {
            Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(view, i, i2, f, f);
            animatorCreateCircularReveal.setStartDelay(0L);
            animatorCreateCircularReveal.setDuration(j);
            list.add(animatorCreateCircularReveal);
        }
    }

    private void g0(View view, View view2, boolean z, boolean z2, e eVar, List list, List list2, RectF rectF) {
        ObjectAnimator objectAnimatorOfFloat;
        ObjectAnimator objectAnimatorOfFloat2;
        float fU = U(view, view2, eVar.b);
        float fV = V(view, view2, eVar.b);
        Pair pairR = R(fU, fV, z, eVar);
        dl1 dl1Var = (dl1) pairR.first;
        dl1 dl1Var2 = (dl1) pairR.second;
        if (z) {
            if (!z2) {
                view2.setTranslationX(-fU);
                view2.setTranslationY(-fV);
            }
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_X, 0.0f);
            objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Y, 0.0f);
            P(view2, eVar, dl1Var, dl1Var2, -fU, -fV, 0.0f, 0.0f, rectF);
        } else {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_X, -fU);
            objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Y, -fV);
        }
        dl1Var.a(objectAnimatorOfFloat);
        dl1Var2.a(objectAnimatorOfFloat2);
        list.add(objectAnimatorOfFloat);
        list.add(objectAnimatorOfFloat2);
    }

    private int h0(View view) {
        ColorStateList colorStateListS = be3.s(view);
        if (colorStateListS != null) {
            return colorStateListS.getColorForState(view.getDrawableState(), colorStateListS.getDefaultColor());
        }
        return 0;
    }

    private ViewGroup j0(View view) {
        if (view instanceof ViewGroup) {
            return (ViewGroup) view;
        }
        return null;
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    protected AnimatorSet N(View view, View view2, boolean z, boolean z2) {
        e eVarI0 = i0(view2.getContext(), z);
        if (z) {
            this.g = view.getTranslationX();
            this.h = view.getTranslationY();
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        b0(view, view2, z, z2, eVarI0, arrayList, arrayList2);
        RectF rectF = this.d;
        g0(view, view2, z, z2, eVarI0, arrayList, arrayList2, rectF);
        float fWidth = rectF.width();
        float fHeight = rectF.height();
        a0(view, view2, z, eVarI0, arrayList);
        d0(view, view2, z, z2, eVarI0, arrayList, arrayList2);
        c0(view, view2, z, z2, eVarI0, fWidth, fHeight, arrayList, arrayList2);
        Z(view, view2, z, z2, eVarI0, arrayList, arrayList2);
        Y(view, view2, z, z2, eVarI0, arrayList, arrayList2);
        AnimatorSet animatorSet = new AnimatorSet();
        c7.a(animatorSet, arrayList);
        animatorSet.addListener(new a(z, view2, view));
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            animatorSet.addListener((Animator.AnimatorListener) arrayList2.get(i));
        }
        return animatorSet;
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean i(CoordinatorLayout coordinatorLayout, View view, View view2) {
        if (view.getVisibility() == 8) {
            throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
        }
        if (!(view2 instanceof FloatingActionButton)) {
            return false;
        }
        int expandedComponentIdHint = ((FloatingActionButton) view2).getExpandedComponentIdHint();
        return expandedComponentIdHint == 0 || expandedComponentIdHint == view.getId();
    }

    protected abstract e i0(Context context, boolean z);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void k(CoordinatorLayout.f fVar) {
        if (fVar.h == 0) {
            fVar.h = 80;
        }
    }

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = new Rect();
        this.d = new RectF();
        this.e = new RectF();
        this.f = new int[2];
    }
}
