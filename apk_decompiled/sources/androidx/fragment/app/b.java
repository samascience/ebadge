package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import defpackage.b52;
import defpackage.be3;
import defpackage.ge3;
import defpackage.jv;
import defpackage.pw1;
import defpackage.u9;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class b extends SpecialEffectsController {

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[SpecialEffectsController.Operation.State.values().length];
            a = iArr;
            try {
                iArr[SpecialEffectsController.Operation.State.GONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[SpecialEffectsController.Operation.State.INVISIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[SpecialEffectsController.Operation.State.REMOVED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[SpecialEffectsController.Operation.State.VISIBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.b$b, reason: collision with other inner class name */
    class RunnableC0020b implements Runnable {
        final /* synthetic */ List a;
        final /* synthetic */ SpecialEffectsController.Operation b;

        RunnableC0020b(List list, SpecialEffectsController.Operation operation) {
            this.a = list;
            this.b = operation;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a.contains(this.b)) {
                this.a.remove(this.b);
                b.this.s(this.b);
            }
        }
    }

    class c extends AnimatorListenerAdapter {
        final /* synthetic */ ViewGroup a;
        final /* synthetic */ View b;
        final /* synthetic */ boolean c;
        final /* synthetic */ SpecialEffectsController.Operation d;
        final /* synthetic */ k e;

        c(ViewGroup viewGroup, View view, boolean z, SpecialEffectsController.Operation operation, k kVar) {
            this.a = viewGroup;
            this.b = view;
            this.c = z;
            this.d = operation;
            this.e = kVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.a.endViewTransition(this.b);
            if (this.c) {
                this.d.e().applyState(this.b);
            }
            this.e.a();
            if (FragmentManager.I0(2)) {
                Log.v("FragmentManager", "Animator from operation " + this.d + " has ended.");
            }
        }
    }

    class d implements jv.a {
        final /* synthetic */ Animator a;
        final /* synthetic */ SpecialEffectsController.Operation b;

        d(Animator animator, SpecialEffectsController.Operation operation) {
            this.a = animator;
            this.b = operation;
        }

        @Override // jv.a
        public void onCancel() {
            this.a.end();
            if (FragmentManager.I0(2)) {
                Log.v("FragmentManager", "Animator from operation " + this.b + " has been canceled.");
            }
        }
    }

    class e implements Animation.AnimationListener {
        final /* synthetic */ SpecialEffectsController.Operation a;
        final /* synthetic */ ViewGroup b;
        final /* synthetic */ View c;
        final /* synthetic */ k d;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e eVar = e.this;
                eVar.b.endViewTransition(eVar.c);
                e.this.d.a();
            }
        }

        e(SpecialEffectsController.Operation operation, ViewGroup viewGroup, View view, k kVar) {
            this.a = operation;
            this.b = viewGroup;
            this.c = view;
            this.d = kVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.b.post(new a());
            if (FragmentManager.I0(2)) {
                Log.v("FragmentManager", "Animation from operation " + this.a + " has ended.");
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            if (FragmentManager.I0(2)) {
                Log.v("FragmentManager", "Animation from operation " + this.a + " has reached onAnimationStart.");
            }
        }
    }

    class f implements jv.a {
        final /* synthetic */ View a;
        final /* synthetic */ ViewGroup b;
        final /* synthetic */ k c;
        final /* synthetic */ SpecialEffectsController.Operation d;

        f(View view, ViewGroup viewGroup, k kVar, SpecialEffectsController.Operation operation) {
            this.a = view;
            this.b = viewGroup;
            this.c = kVar;
            this.d = operation;
        }

        @Override // jv.a
        public void onCancel() {
            this.a.clearAnimation();
            this.b.endViewTransition(this.a);
            this.c.a();
            if (FragmentManager.I0(2)) {
                Log.v("FragmentManager", "Animation from operation " + this.d + " has been cancelled.");
            }
        }
    }

    class g implements Runnable {
        final /* synthetic */ SpecialEffectsController.Operation a;
        final /* synthetic */ SpecialEffectsController.Operation b;
        final /* synthetic */ boolean c;
        final /* synthetic */ u9 d;

        g(SpecialEffectsController.Operation operation, SpecialEffectsController.Operation operation2, boolean z, u9 u9Var) {
            this.a = operation;
            this.b = operation2;
            this.c = z;
            this.d = u9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            n.a(this.a.f(), this.b.f(), this.c, this.d, false);
        }
    }

    class h implements Runnable {
        final /* synthetic */ p a;
        final /* synthetic */ View b;
        final /* synthetic */ Rect c;

        h(p pVar, View view, Rect rect) {
            this.a = pVar;
            this.b = view;
            this.c = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.h(this.b, this.c);
        }
    }

    class i implements Runnable {
        final /* synthetic */ ArrayList a;

        i(ArrayList arrayList) {
            this.a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            n.d(this.a, 4);
        }
    }

    class j implements Runnable {
        final /* synthetic */ m a;
        final /* synthetic */ SpecialEffectsController.Operation b;

        j(m mVar, SpecialEffectsController.Operation operation) {
            this.a = mVar;
            this.b = operation;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.a();
            if (FragmentManager.I0(2)) {
                Log.v("FragmentManager", "Transition for operation " + this.b + "has completed");
            }
        }
    }

    private static class k extends l {
        private boolean c;
        private boolean d;
        private androidx.fragment.app.c.a e;

        k(SpecialEffectsController.Operation operation, jv jvVar, boolean z) {
            super(operation, jvVar);
            this.d = false;
            this.c = z;
        }

        androidx.fragment.app.c.a e(Context context) {
            if (this.d) {
                return this.e;
            }
            androidx.fragment.app.c.a aVarB = androidx.fragment.app.c.b(context, b().f(), b().e() == SpecialEffectsController.Operation.State.VISIBLE, this.c);
            this.e = aVarB;
            this.d = true;
            return aVarB;
        }
    }

    private static class l {
        private final SpecialEffectsController.Operation a;
        private final jv b;

        l(SpecialEffectsController.Operation operation, jv jvVar) {
            this.a = operation;
            this.b = jvVar;
        }

        void a() {
            this.a.d(this.b);
        }

        SpecialEffectsController.Operation b() {
            return this.a;
        }

        jv c() {
            return this.b;
        }

        boolean d() {
            SpecialEffectsController.Operation.State state;
            SpecialEffectsController.Operation.State stateFrom = SpecialEffectsController.Operation.State.from(this.a.f().mView);
            SpecialEffectsController.Operation.State stateE = this.a.e();
            return stateFrom == stateE || !(stateFrom == (state = SpecialEffectsController.Operation.State.VISIBLE) || stateE == state);
        }
    }

    private static class m extends l {
        private final Object c;
        private final boolean d;
        private final Object e;

        m(SpecialEffectsController.Operation operation, jv jvVar, boolean z, boolean z2) {
            super(operation, jvVar);
            if (operation.e() == SpecialEffectsController.Operation.State.VISIBLE) {
                this.c = z ? operation.f().getReenterTransition() : operation.f().getEnterTransition();
                this.d = z ? operation.f().getAllowReturnTransitionOverlap() : operation.f().getAllowEnterTransitionOverlap();
            } else {
                this.c = z ? operation.f().getReturnTransition() : operation.f().getExitTransition();
                this.d = true;
            }
            if (!z2) {
                this.e = null;
            } else if (z) {
                this.e = operation.f().getSharedElementReturnTransition();
            } else {
                this.e = operation.f().getSharedElementEnterTransition();
            }
        }

        private p f(Object obj) {
            if (obj == null) {
                return null;
            }
            p pVar = n.a;
            if (pVar != null && pVar.e(obj)) {
                return pVar;
            }
            p pVar2 = n.b;
            if (pVar2 != null && pVar2.e(obj)) {
                return pVar2;
            }
            throw new IllegalArgumentException("Transition " + obj + " for fragment " + b().f() + " is not a valid framework Transition or AndroidX Transition");
        }

        p e() {
            p pVarF = f(this.c);
            p pVarF2 = f(this.e);
            if (pVarF == null || pVarF2 == null || pVarF == pVarF2) {
                return pVarF != null ? pVarF : pVarF2;
            }
            throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + b().f() + " returned Transition " + this.c + " which uses a different Transition  type than its shared element transition " + this.e);
        }

        public Object g() {
            return this.e;
        }

        Object h() {
            return this.c;
        }

        public boolean i() {
            return this.e != null;
        }

        boolean j() {
            return this.d;
        }
    }

    b(ViewGroup viewGroup) {
        super(viewGroup);
    }

    private void w(List list, List list2, boolean z, Map map) {
        int i2;
        boolean z2;
        Context context;
        View view;
        int i3;
        SpecialEffectsController.Operation operation;
        ViewGroup viewGroupM = m();
        Context context2 = viewGroupM.getContext();
        ArrayList<k> arrayList = new ArrayList();
        Iterator it = list.iterator();
        boolean z3 = false;
        while (true) {
            i2 = 2;
            if (!it.hasNext()) {
                break;
            }
            k kVar = (k) it.next();
            if (kVar.d()) {
                kVar.a();
            } else {
                androidx.fragment.app.c.a aVarE = kVar.e(context2);
                if (aVarE == null) {
                    kVar.a();
                } else {
                    Animator animator = aVarE.b;
                    if (animator == null) {
                        arrayList.add(kVar);
                    } else {
                        SpecialEffectsController.Operation operationB = kVar.b();
                        Fragment fragmentF = operationB.f();
                        if (Boolean.TRUE.equals(map.get(operationB))) {
                            if (FragmentManager.I0(2)) {
                                Log.v("FragmentManager", "Ignoring Animator set on " + fragmentF + " as this Fragment was involved in a Transition.");
                            }
                            kVar.a();
                        } else {
                            boolean z4 = operationB.e() == SpecialEffectsController.Operation.State.GONE;
                            if (z4) {
                                list2.remove(operationB);
                            }
                            View view2 = fragmentF.mView;
                            viewGroupM.startViewTransition(view2);
                            animator.addListener(new c(viewGroupM, view2, z4, operationB, kVar));
                            animator.setTarget(view2);
                            animator.start();
                            if (FragmentManager.I0(2)) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("Animator from operation ");
                                operation = operationB;
                                sb.append(operation);
                                sb.append(" has started.");
                                Log.v("FragmentManager", sb.toString());
                            } else {
                                operation = operationB;
                            }
                            kVar.c().b(new d(animator, operation));
                            z3 = true;
                        }
                    }
                }
            }
        }
        for (k kVar2 : arrayList) {
            SpecialEffectsController.Operation operationB2 = kVar2.b();
            Fragment fragmentF2 = operationB2.f();
            if (z) {
                if (FragmentManager.I0(i2)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + fragmentF2 + " as Animations cannot run alongside Transitions.");
                }
                kVar2.a();
            } else if (z3) {
                if (FragmentManager.I0(i2)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + fragmentF2 + " as Animations cannot run alongside Animators.");
                }
                kVar2.a();
            } else {
                View view3 = fragmentF2.mView;
                Animation animation = (Animation) b52.g(((androidx.fragment.app.c.a) b52.g(kVar2.e(context2))).a);
                if (operationB2.e() != SpecialEffectsController.Operation.State.REMOVED) {
                    view3.startAnimation(animation);
                    kVar2.a();
                    z2 = z3;
                    context = context2;
                    i3 = i2;
                    view = view3;
                } else {
                    viewGroupM.startViewTransition(view3);
                    androidx.fragment.app.c.b bVar = new androidx.fragment.app.c.b(animation, viewGroupM, view3);
                    z2 = z3;
                    context = context2;
                    view = view3;
                    bVar.setAnimationListener(new e(operationB2, viewGroupM, view3, kVar2));
                    view.startAnimation(bVar);
                    i3 = 2;
                    if (FragmentManager.I0(2)) {
                        Log.v("FragmentManager", "Animation from operation " + operationB2 + " has started.");
                    }
                }
                kVar2.c().b(new f(view, viewGroupM, kVar2, operationB2));
                i2 = i3;
                z3 = z2;
                context2 = context;
            }
        }
    }

    private Map x(List list, List list2, boolean z, SpecialEffectsController.Operation operation, SpecialEffectsController.Operation operation2) {
        String str;
        String str2;
        String str3;
        View view;
        Object obj;
        ArrayList arrayList;
        Object obj2;
        ArrayList arrayList2;
        HashMap map;
        View view2;
        Object objK;
        ArrayList arrayList3;
        SpecialEffectsController.Operation operation3;
        HashMap map2;
        SpecialEffectsController.Operation operation4;
        View view3;
        View view4;
        SpecialEffectsController.Operation operation5 = operation;
        SpecialEffectsController.Operation operation6 = operation2;
        HashMap map3 = new HashMap();
        Iterator it = list.iterator();
        p pVar = null;
        while (it.hasNext()) {
            m mVar = (m) it.next();
            if (!mVar.d()) {
                p pVarE = mVar.e();
                if (pVar == null) {
                    pVar = pVarE;
                } else if (pVarE != null && pVar != pVarE) {
                    throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + mVar.b().f() + " returned Transition " + mVar.h() + " which uses a different Transition  type than other Fragments.");
                }
            }
        }
        if (pVar == null) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                m mVar2 = (m) it2.next();
                map3.put(mVar2.b(), Boolean.FALSE);
                mVar2.a();
            }
            return map3;
        }
        View view5 = new View(m().getContext());
        Rect rect = new Rect();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        u9 u9Var = new u9();
        Iterator it3 = list.iterator();
        Object obj3 = null;
        View view6 = null;
        boolean z2 = false;
        while (true) {
            str = "FragmentManager";
            if (!it3.hasNext()) {
                break;
            }
            m mVar3 = (m) it3.next();
            if (!mVar3.i() || operation5 == null || operation6 == null) {
                arrayList3 = arrayList5;
                operation3 = operation5;
                map2 = map3;
                View view7 = view5;
                operation4 = operation6;
                view3 = view7;
                view6 = view6;
            } else {
                Object objU = pVar.u(pVar.f(mVar3.g()));
                ArrayList<String> sharedElementSourceNames = operation2.f().getSharedElementSourceNames();
                ArrayList<String> sharedElementSourceNames2 = operation.f().getSharedElementSourceNames();
                ArrayList<String> sharedElementTargetNames = operation.f().getSharedElementTargetNames();
                View view8 = view6;
                int i2 = 0;
                while (i2 < sharedElementTargetNames.size()) {
                    int iIndexOf = sharedElementSourceNames.indexOf(sharedElementTargetNames.get(i2));
                    ArrayList<String> arrayList6 = sharedElementTargetNames;
                    if (iIndexOf != -1) {
                        sharedElementSourceNames.set(iIndexOf, sharedElementSourceNames2.get(i2));
                    }
                    i2++;
                    sharedElementTargetNames = arrayList6;
                }
                ArrayList<String> sharedElementTargetNames2 = operation2.f().getSharedElementTargetNames();
                if (z == 0) {
                    operation.f().getExitTransitionCallback();
                    operation2.f().getEnterTransitionCallback();
                } else {
                    operation.f().getEnterTransitionCallback();
                    operation2.f().getExitTransitionCallback();
                }
                int i3 = 0;
                for (int size = sharedElementSourceNames.size(); i3 < size; size = size) {
                    u9Var.put(sharedElementSourceNames.get(i3), sharedElementTargetNames2.get(i3));
                    i3++;
                }
                if (FragmentManager.I0(2)) {
                    Log.v("FragmentManager", ">>> entering view names <<<");
                    for (Iterator<String> it4 = sharedElementTargetNames2.iterator(); it4.hasNext(); it4 = it4) {
                        Log.v("FragmentManager", "Name: " + it4.next());
                    }
                    Log.v("FragmentManager", ">>> exiting view names <<<");
                    for (Iterator<String> it5 = sharedElementSourceNames.iterator(); it5.hasNext(); it5 = it5) {
                        Log.v("FragmentManager", "Name: " + it5.next());
                    }
                }
                u9 u9Var2 = new u9();
                u(u9Var2, operation.f().mView);
                u9Var2.p(sharedElementSourceNames);
                u9Var.p(u9Var2.keySet());
                u9 u9Var3 = new u9();
                u(u9Var3, operation2.f().mView);
                u9Var3.p(sharedElementTargetNames2);
                u9Var3.p(u9Var.values());
                n.c(u9Var, u9Var3);
                v(u9Var2, u9Var.keySet());
                v(u9Var3, u9Var.values());
                if (u9Var.isEmpty()) {
                    arrayList4.clear();
                    arrayList5.clear();
                    arrayList3 = arrayList5;
                    operation3 = operation5;
                    view3 = view5;
                    view6 = view8;
                    obj3 = null;
                    operation4 = operation2;
                    map2 = map3;
                } else {
                    n.a(operation2.f(), operation.f(), z, u9Var2, true);
                    HashMap map4 = map3;
                    View view9 = view5;
                    ArrayList arrayList7 = arrayList5;
                    pw1.a(m(), new g(operation2, operation, z, u9Var3));
                    arrayList4.addAll(u9Var2.values());
                    if (sharedElementSourceNames.isEmpty()) {
                        view6 = view8;
                    } else {
                        view6 = (View) u9Var2.get((String) sharedElementSourceNames.get(0));
                        pVar.p(objU, view6);
                    }
                    arrayList3 = arrayList7;
                    arrayList3.addAll(u9Var3.values());
                    if (!sharedElementTargetNames2.isEmpty() && (view4 = (View) u9Var3.get((String) sharedElementTargetNames2.get(0))) != null) {
                        pw1.a(m(), new h(pVar, view4, rect));
                        z2 = true;
                    }
                    pVar.s(objU, view9, arrayList4);
                    view3 = view9;
                    pVar.n(objU, null, null, null, null, objU, arrayList3);
                    Boolean bool = Boolean.TRUE;
                    operation3 = operation;
                    map2 = map4;
                    map2.put(operation3, bool);
                    operation4 = operation2;
                    map2.put(operation4, bool);
                    obj3 = objU;
                }
            }
            operation5 = operation3;
            arrayList4 = arrayList4;
            rect = rect;
            map3 = map2;
            u9Var = u9Var;
            arrayList5 = arrayList3;
            pVar = pVar;
            SpecialEffectsController.Operation operation7 = operation4;
            view5 = view3;
            operation6 = operation7;
        }
        View view10 = view6;
        u9 u9Var4 = u9Var;
        ArrayList arrayList8 = arrayList5;
        SpecialEffectsController.Operation operation8 = operation5;
        ArrayList arrayList9 = arrayList4;
        Rect rect2 = rect;
        p pVar2 = pVar;
        HashMap map5 = map3;
        View view11 = view5;
        SpecialEffectsController.Operation operation9 = operation6;
        View view12 = view11;
        ArrayList arrayList10 = new ArrayList();
        Iterator it6 = list.iterator();
        Object obj4 = null;
        Object objK2 = null;
        while (it6.hasNext()) {
            m mVar4 = (m) it6.next();
            if (mVar4.d()) {
                map5.put(mVar4.b(), Boolean.FALSE);
                mVar4.a();
            } else {
                Object objF = pVar2.f(mVar4.h());
                SpecialEffectsController.Operation operationB = mVar4.b();
                boolean z3 = obj3 != null && (operationB == operation8 || operationB == operation9);
                if (objF == null) {
                    if (!z3) {
                        map5.put(operationB, Boolean.FALSE);
                        mVar4.a();
                    }
                    arrayList2 = arrayList8;
                    str3 = str;
                    arrayList = arrayList9;
                    view = view12;
                    objK = obj4;
                    map = map5;
                    view2 = view10;
                } else {
                    str3 = str;
                    ArrayList arrayList11 = new ArrayList();
                    Object obj5 = obj4;
                    t(arrayList11, operationB.f().mView);
                    if (z3) {
                        if (operationB == operation8) {
                            arrayList11.removeAll(arrayList9);
                        } else {
                            arrayList11.removeAll(arrayList8);
                        }
                    }
                    if (arrayList11.isEmpty()) {
                        pVar2.a(objF, view12);
                        arrayList2 = arrayList8;
                        arrayList = arrayList9;
                        view = view12;
                        obj2 = objK2;
                        map = map5;
                        obj = obj5;
                    } else {
                        pVar2.b(objF, arrayList11);
                        view = view12;
                        obj = obj5;
                        arrayList = arrayList9;
                        obj2 = objK2;
                        arrayList2 = arrayList8;
                        map = map5;
                        pVar2.n(objF, objF, arrayList11, null, null, null, null);
                        if (operationB.e() == SpecialEffectsController.Operation.State.GONE) {
                            list2.remove(operationB);
                            ArrayList arrayList12 = new ArrayList(arrayList11);
                            arrayList12.remove(operationB.f().mView);
                            pVar2.m(objF, operationB.f().mView, arrayList12);
                            pw1.a(m(), new i(arrayList11));
                        }
                    }
                    if (operationB.e() == SpecialEffectsController.Operation.State.VISIBLE) {
                        arrayList10.addAll(arrayList11);
                        if (z2) {
                            pVar2.o(objF, rect2);
                        }
                        view2 = view10;
                    } else {
                        view2 = view10;
                        pVar2.p(objF, view2);
                    }
                    map.put(operationB, Boolean.TRUE);
                    if (mVar4.j()) {
                        objK2 = pVar2.k(obj2, objF, null);
                        objK = obj;
                    } else {
                        objK = pVar2.k(obj, objF, null);
                        objK2 = obj2;
                    }
                }
                operation9 = operation2;
                map5 = map;
                obj4 = objK;
                view10 = view2;
                str = str3;
                view12 = view;
                arrayList9 = arrayList;
                arrayList8 = arrayList2;
            }
        }
        ArrayList<View> arrayList13 = arrayList8;
        String str4 = str;
        ArrayList<View> arrayList14 = arrayList9;
        HashMap map6 = map5;
        Object objJ = pVar2.j(objK2, obj4, obj3);
        if (objJ == null) {
            return map6;
        }
        Iterator it7 = list.iterator();
        while (it7.hasNext()) {
            m mVar5 = (m) it7.next();
            if (!mVar5.d()) {
                Object objH = mVar5.h();
                SpecialEffectsController.Operation operationB2 = mVar5.b();
                HashMap map7 = map6;
                boolean z4 = obj3 != null && (operationB2 == operation8 || operationB2 == operation2);
                if (objH == null && !z4) {
                    str2 = str4;
                } else if (be3.T(m())) {
                    str2 = str4;
                    pVar2.q(mVar5.b().f(), objJ, mVar5.c(), new j(mVar5, operationB2));
                } else {
                    if (FragmentManager.I0(2)) {
                        str2 = str4;
                        Log.v(str2, "SpecialEffectsController: Container " + m() + " has not been laid out. Completing operation " + operationB2);
                    } else {
                        str2 = str4;
                    }
                    mVar5.a();
                }
                map6 = map7;
                str4 = str2;
            }
        }
        HashMap map8 = map6;
        String str5 = str4;
        if (!be3.T(m())) {
            return map8;
        }
        n.d(arrayList10, 4);
        ArrayList arrayListL = pVar2.l(arrayList13);
        if (FragmentManager.I0(2)) {
            Log.v(str5, ">>>>> Beginning transition <<<<<");
            Log.v(str5, ">>>>> SharedElementFirstOutViews <<<<<");
            for (View view13 : arrayList14) {
                Log.v(str5, "View: " + view13 + " Name: " + be3.J(view13));
            }
            Log.v(str5, ">>>>> SharedElementLastInViews <<<<<");
            for (View view14 : arrayList13) {
                Log.v(str5, "View: " + view14 + " Name: " + be3.J(view14));
            }
        }
        pVar2.c(m(), objJ);
        pVar2.r(m(), arrayList14, arrayList13, arrayListL, u9Var4);
        n.d(arrayList10, 0);
        pVar2.t(obj3, arrayList14, arrayList13);
        return map8;
    }

    private void y(List list) {
        Fragment fragmentF = ((SpecialEffectsController.Operation) list.get(list.size() - 1)).f();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            SpecialEffectsController.Operation operation = (SpecialEffectsController.Operation) it.next();
            operation.f().mAnimationInfo.c = fragmentF.mAnimationInfo.c;
            operation.f().mAnimationInfo.d = fragmentF.mAnimationInfo.d;
            operation.f().mAnimationInfo.e = fragmentF.mAnimationInfo.e;
            operation.f().mAnimationInfo.f = fragmentF.mAnimationInfo.f;
        }
    }

    /* JADX WARN: Code duplicated, block: B:29:0x00a8  */
    @Override // androidx.fragment.app.SpecialEffectsController
    void f(List list, boolean z) {
        Iterator it = list.iterator();
        SpecialEffectsController.Operation operation = null;
        SpecialEffectsController.Operation operation2 = null;
        while (it.hasNext()) {
            SpecialEffectsController.Operation operation3 = (SpecialEffectsController.Operation) it.next();
            SpecialEffectsController.Operation.State stateFrom = SpecialEffectsController.Operation.State.from(operation3.f().mView);
            int i2 = a.a[operation3.e().ordinal()];
            if (i2 == 1 || i2 == 2 || i2 == 3) {
                if (stateFrom == SpecialEffectsController.Operation.State.VISIBLE && operation == null) {
                    operation = operation3;
                }
            } else if (i2 == 4 && stateFrom != SpecialEffectsController.Operation.State.VISIBLE) {
                operation2 = operation3;
            }
        }
        if (FragmentManager.I0(2)) {
            Log.v("FragmentManager", "Executing operations from " + operation + " to " + operation2);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList(list);
        y(list);
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            SpecialEffectsController.Operation operation4 = (SpecialEffectsController.Operation) it2.next();
            jv jvVar = new jv();
            operation4.j(jvVar);
            arrayList.add(new k(operation4, jvVar, z));
            jv jvVar2 = new jv();
            operation4.j(jvVar2);
            boolean z2 = false;
            if (z) {
                if (operation4 == operation) {
                    z2 = true;
                }
            } else if (operation4 == operation2) {
                z2 = true;
            }
            arrayList2.add(new m(operation4, jvVar2, z, z2));
            operation4.a(new RunnableC0020b(arrayList3, operation4));
        }
        Map mapX = x(arrayList2, arrayList3, z, operation, operation2);
        w(arrayList, arrayList3, mapX.containsValue(Boolean.TRUE), mapX);
        Iterator it3 = arrayList3.iterator();
        while (it3.hasNext()) {
            s((SpecialEffectsController.Operation) it3.next());
        }
        arrayList3.clear();
        if (FragmentManager.I0(2)) {
            Log.v("FragmentManager", "Completed executing operations from " + operation + " to " + operation2);
        }
    }

    void s(SpecialEffectsController.Operation operation) {
        operation.e().applyState(operation.f().mView);
    }

    void t(ArrayList arrayList, View view) {
        if (!(view instanceof ViewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(view);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (ge3.a(viewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(viewGroup);
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt.getVisibility() == 0) {
                t(arrayList, childAt);
            }
        }
    }

    void u(Map map, View view) {
        String strJ = be3.J(view);
        if (strJ != null) {
            map.put(strJ, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (childAt.getVisibility() == 0) {
                    u(map, childAt);
                }
            }
        }
    }

    void v(u9 u9Var, Collection collection) {
        Iterator it = u9Var.entrySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(be3.J((View) ((Map.Entry) it.next()).getValue()))) {
                it.remove();
            }
        }
    }
}
