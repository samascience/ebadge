package defpackage;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class o53 {
    private static f53 a = new sc();
    private static ThreadLocal b = new ThreadLocal();
    static ArrayList c = new ArrayList();

    private static class a implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {
        f53 a;
        ViewGroup b;

        /* JADX INFO: renamed from: o53$a$a, reason: collision with other inner class name */
        class C0150a extends n53 {
            final /* synthetic */ u9 a;

            C0150a(u9 u9Var) {
                this.a = u9Var;
            }

            @Override // f53.f
            public void c(f53 f53Var) {
                ((ArrayList) this.a.get(a.this.b)).remove(f53Var);
                f53Var.S(this);
            }
        }

        a(f53 f53Var, ViewGroup viewGroup) {
            this.a = f53Var;
            this.b = viewGroup;
        }

        private void a() {
            this.b.getViewTreeObserver().removeOnPreDrawListener(this);
            this.b.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            a();
            if (!o53.c.remove(this.b)) {
                return true;
            }
            u9 u9VarB = o53.b();
            ArrayList arrayList = (ArrayList) u9VarB.get(this.b);
            ArrayList arrayList2 = null;
            if (arrayList == null) {
                arrayList = new ArrayList();
                u9VarB.put(this.b, arrayList);
            } else if (arrayList.size() > 0) {
                arrayList2 = new ArrayList(arrayList);
            }
            arrayList.add(this.a);
            this.a.a(new C0150a(u9VarB));
            this.a.j(this.b, false);
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((f53) it.next()).U(this.b);
                }
            }
            this.a.R(this.b);
            return true;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            a();
            o53.c.remove(this.b);
            ArrayList arrayList = (ArrayList) o53.b().get(this.b);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((f53) it.next()).U(this.b);
                }
            }
            this.a.k(true);
        }
    }

    public static void a(ViewGroup viewGroup, f53 f53Var) {
        if (c.contains(viewGroup) || !viewGroup.isLaidOut()) {
            return;
        }
        c.add(viewGroup);
        if (f53Var == null) {
            f53Var = a;
        }
        f53 f53VarClone = f53Var.clone();
        d(viewGroup, f53VarClone);
        qk2.b(viewGroup, null);
        c(viewGroup, f53VarClone);
    }

    static u9 b() {
        u9 u9Var;
        WeakReference weakReference = (WeakReference) b.get();
        if (weakReference != null && (u9Var = (u9) weakReference.get()) != null) {
            return u9Var;
        }
        u9 u9Var2 = new u9();
        b.set(new WeakReference(u9Var2));
        return u9Var2;
    }

    private static void c(ViewGroup viewGroup, f53 f53Var) {
        if (f53Var == null || viewGroup == null) {
            return;
        }
        a aVar = new a(f53Var, viewGroup);
        viewGroup.addOnAttachStateChangeListener(aVar);
        viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
    }

    private static void d(ViewGroup viewGroup, f53 f53Var) {
        ArrayList arrayList = (ArrayList) b().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((f53) it.next()).Q(viewGroup);
            }
        }
        if (f53Var != null) {
            f53Var.j(viewGroup, true);
        }
        qk2.a(viewGroup);
    }
}
