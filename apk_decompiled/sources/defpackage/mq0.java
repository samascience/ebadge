package defpackage;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.p;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class mq0 extends p {

    class a extends f53.e {
        final /* synthetic */ Rect a;

        a(Rect rect) {
            this.a = rect;
        }
    }

    class b implements f53.f {
        final /* synthetic */ View a;
        final /* synthetic */ ArrayList b;

        b(View view, ArrayList arrayList) {
            this.a = view;
            this.b = arrayList;
        }

        @Override // f53.f
        public void a(f53 f53Var) {
            f53Var.S(this);
            f53Var.a(this);
        }

        @Override // f53.f
        public void b(f53 f53Var) {
        }

        @Override // f53.f
        public void c(f53 f53Var) {
            f53Var.S(this);
            this.a.setVisibility(8);
            int size = this.b.size();
            for (int i = 0; i < size; i++) {
                ((View) this.b.get(i)).setVisibility(0);
            }
        }

        @Override // f53.f
        public void e(f53 f53Var) {
        }

        @Override // f53.f
        public void g(f53 f53Var) {
        }
    }

    class c extends n53 {
        final /* synthetic */ Object a;
        final /* synthetic */ ArrayList b;
        final /* synthetic */ Object c;
        final /* synthetic */ ArrayList d;
        final /* synthetic */ Object e;
        final /* synthetic */ ArrayList f;

        c(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.a = obj;
            this.b = arrayList;
            this.c = obj2;
            this.d = arrayList2;
            this.e = obj3;
            this.f = arrayList3;
        }

        @Override // defpackage.n53, f53.f
        public void a(f53 f53Var) {
            Object obj = this.a;
            if (obj != null) {
                mq0.this.y(obj, this.b, null);
            }
            Object obj2 = this.c;
            if (obj2 != null) {
                mq0.this.y(obj2, this.d, null);
            }
            Object obj3 = this.e;
            if (obj3 != null) {
                mq0.this.y(obj3, this.f, null);
            }
        }

        @Override // f53.f
        public void c(f53 f53Var) {
            f53Var.S(this);
        }
    }

    class d implements f53.f {
        final /* synthetic */ Runnable a;

        d(Runnable runnable) {
            this.a = runnable;
        }

        @Override // f53.f
        public void a(f53 f53Var) {
        }

        @Override // f53.f
        public void b(f53 f53Var) {
        }

        @Override // f53.f
        public void c(f53 f53Var) {
            this.a.run();
        }

        @Override // f53.f
        public void e(f53 f53Var) {
        }

        @Override // f53.f
        public void g(f53 f53Var) {
        }
    }

    class e extends f53.e {
        final /* synthetic */ Rect a;

        e(Rect rect) {
            this.a = rect;
        }
    }

    private static boolean w(f53 f53Var) {
        return (p.i(f53Var.A()) && p.i(f53Var.B()) && p.i(f53Var.C())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void x(Runnable runnable, f53 f53Var, Runnable runnable2) {
        if (runnable != null) {
            runnable.run();
        } else {
            f53Var.cancel();
            runnable2.run();
        }
    }

    @Override // androidx.fragment.app.p
    public void a(Object obj, View view) {
        if (obj != null) {
            ((f53) obj).b(view);
        }
    }

    @Override // androidx.fragment.app.p
    public void b(Object obj, ArrayList arrayList) {
        f53 f53Var = (f53) obj;
        if (f53Var == null) {
            return;
        }
        int i = 0;
        if (f53Var instanceof q53) {
            q53 q53Var = (q53) f53Var;
            int iK0 = q53Var.k0();
            while (i < iK0) {
                b(q53Var.j0(i), arrayList);
                i++;
            }
            return;
        }
        if (w(f53Var) || !p.i(f53Var.D())) {
            return;
        }
        int size = arrayList.size();
        while (i < size) {
            f53Var.b((View) arrayList.get(i));
            i++;
        }
    }

    @Override // androidx.fragment.app.p
    public void c(ViewGroup viewGroup, Object obj) {
        o53.a(viewGroup, (f53) obj);
    }

    @Override // androidx.fragment.app.p
    public boolean e(Object obj) {
        return obj instanceof f53;
    }

    @Override // androidx.fragment.app.p
    public Object f(Object obj) {
        if (obj != null) {
            return ((f53) obj).clone();
        }
        return null;
    }

    @Override // androidx.fragment.app.p
    public Object j(Object obj, Object obj2, Object obj3) {
        f53 f53VarP0 = (f53) obj;
        f53 f53Var = (f53) obj2;
        f53 f53Var2 = (f53) obj3;
        if (f53VarP0 != null && f53Var != null) {
            f53VarP0 = new q53().h0(f53VarP0).h0(f53Var).p0(1);
        } else if (f53VarP0 == null) {
            f53VarP0 = f53Var != null ? f53Var : null;
        }
        if (f53Var2 == null) {
            return f53VarP0;
        }
        q53 q53Var = new q53();
        if (f53VarP0 != null) {
            q53Var.h0(f53VarP0);
        }
        q53Var.h0(f53Var2);
        return q53Var;
    }

    @Override // androidx.fragment.app.p
    public Object k(Object obj, Object obj2, Object obj3) {
        q53 q53Var = new q53();
        if (obj != null) {
            q53Var.h0((f53) obj);
        }
        if (obj2 != null) {
            q53Var.h0((f53) obj2);
        }
        if (obj3 != null) {
            q53Var.h0((f53) obj3);
        }
        return q53Var;
    }

    @Override // androidx.fragment.app.p
    public void m(Object obj, View view, ArrayList arrayList) {
        ((f53) obj).a(new b(view, arrayList));
    }

    @Override // androidx.fragment.app.p
    public void n(Object obj, Object obj2, ArrayList arrayList, Object obj3, ArrayList arrayList2, Object obj4, ArrayList arrayList3) {
        ((f53) obj).a(new c(obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    @Override // androidx.fragment.app.p
    public void o(Object obj, Rect rect) {
        if (obj != null) {
            ((f53) obj).Y(new e(rect));
        }
    }

    @Override // androidx.fragment.app.p
    public void p(Object obj, View view) {
        if (view != null) {
            Rect rect = new Rect();
            h(view, rect);
            ((f53) obj).Y(new a(rect));
        }
    }

    @Override // androidx.fragment.app.p
    public void q(Fragment fragment, Object obj, jv jvVar, Runnable runnable) {
        z(fragment, obj, jvVar, null, runnable);
    }

    @Override // androidx.fragment.app.p
    public void s(Object obj, View view, ArrayList arrayList) {
        q53 q53Var = (q53) obj;
        List listD = q53Var.D();
        listD.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            p.d(listD, (View) arrayList.get(i));
        }
        listD.add(view);
        arrayList.add(view);
        b(q53Var, arrayList);
    }

    @Override // androidx.fragment.app.p
    public void t(Object obj, ArrayList arrayList, ArrayList arrayList2) {
        q53 q53Var = (q53) obj;
        if (q53Var != null) {
            q53Var.D().clear();
            q53Var.D().addAll(arrayList2);
            y(q53Var, arrayList, arrayList2);
        }
    }

    @Override // androidx.fragment.app.p
    public Object u(Object obj) {
        if (obj == null) {
            return null;
        }
        q53 q53Var = new q53();
        q53Var.h0((f53) obj);
        return q53Var;
    }

    public void y(Object obj, ArrayList arrayList, ArrayList arrayList2) {
        f53 f53Var = (f53) obj;
        int i = 0;
        if (f53Var instanceof q53) {
            q53 q53Var = (q53) f53Var;
            int iK0 = q53Var.k0();
            while (i < iK0) {
                y(q53Var.j0(i), arrayList, arrayList2);
                i++;
            }
            return;
        }
        if (w(f53Var)) {
            return;
        }
        List listD = f53Var.D();
        if (listD.size() == arrayList.size() && listD.containsAll(arrayList)) {
            int size = arrayList2 == null ? 0 : arrayList2.size();
            while (i < size) {
                f53Var.b((View) arrayList2.get(i));
                i++;
            }
            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                f53Var.T((View) arrayList.get(size2));
            }
        }
    }

    public void z(Fragment fragment, Object obj, jv jvVar, final Runnable runnable, final Runnable runnable2) {
        final f53 f53Var = (f53) obj;
        jvVar.b(new jv.a() { // from class: lq0
            @Override // jv.a
            public final void onCancel() {
                mq0.x(runnable, f53Var, runnable2);
            }
        });
        f53Var.a(new d(runnable2));
    }
}
