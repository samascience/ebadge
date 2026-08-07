package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.graphics.Path;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowId;
import android.widget.ListView;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class f53 implements Cloneable {
    private static final Animator[] N = new Animator[0];
    private static final int[] O = {2, 1, 3, 4};
    private static final nz1 P = new a();
    private static ThreadLocal Q = new ThreadLocal();
    private e K;
    private u9 L;
    private ArrayList t;
    private ArrayList u;
    private f[] v;
    private String a = getClass().getName();
    private long b = -1;
    long c = -1;
    private TimeInterpolator d = null;
    ArrayList e = new ArrayList();
    ArrayList f = new ArrayList();
    private ArrayList g = null;
    private ArrayList h = null;
    private ArrayList i = null;
    private ArrayList j = null;
    private ArrayList k = null;
    private ArrayList l = null;
    private ArrayList m = null;
    private ArrayList n = null;
    private ArrayList o = null;
    private t53 p = new t53();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private t53 f331q = new t53();
    q53 r = null;
    private int[] s = O;
    boolean w = false;
    ArrayList x = new ArrayList();
    private Animator[] y = N;
    int z = 0;
    private boolean F = false;
    boolean G = false;
    private f53 H = null;
    private ArrayList I = null;
    ArrayList J = new ArrayList();
    private nz1 M = P;

    class a extends nz1 {
        a() {
        }

        @Override // defpackage.nz1
        public Path a(float f, float f2, float f3, float f4) {
            Path path = new Path();
            path.moveTo(f, f2);
            path.lineTo(f3, f4);
            return path;
        }
    }

    class b extends AnimatorListenerAdapter {
        final /* synthetic */ u9 a;

        b(u9 u9Var) {
            this.a = u9Var;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.a.remove(animator);
            f53.this.x.remove(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            f53.this.x.add(animator);
        }
    }

    class c extends AnimatorListenerAdapter {
        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            f53.this.p();
            animator.removeListener(this);
        }
    }

    private static class d {
        View a;
        String b;
        s53 c;
        WindowId d;
        f53 e;
        Animator f;

        d(View view, String str, f53 f53Var, WindowId windowId, s53 s53Var, Animator animator) {
            this.a = view;
            this.b = str;
            this.c = s53Var;
            this.d = windowId;
            this.e = f53Var;
            this.f = animator;
        }
    }

    public static abstract class e {
    }

    public interface f {
        void a(f53 f53Var);

        void b(f53 f53Var);

        void c(f53 f53Var);

        default void d(f53 f53Var, boolean z) {
            c(f53Var);
        }

        void e(f53 f53Var);

        default void f(f53 f53Var, boolean z) {
            a(f53Var);
        }

        void g(f53 f53Var);
    }

    interface g {
        public static final g a = new g() { // from class: g53
            @Override // f53.g
            public final void c(f53.f fVar, f53 f53Var, boolean z) {
                fVar.f(f53Var, z);
            }
        };
        public static final g b = new g() { // from class: h53
            @Override // f53.g
            public final void c(f53.f fVar, f53 f53Var, boolean z) {
                fVar.d(f53Var, z);
            }
        };
        public static final g c = new g() { // from class: i53
            @Override // f53.g
            public final void c(f53.f fVar, f53 f53Var, boolean z) {
                fVar.g(f53Var);
            }
        };
        public static final g d = new g() { // from class: j53
            @Override // f53.g
            public final void c(f53.f fVar, f53 f53Var, boolean z) {
                fVar.e(f53Var);
            }
        };
        public static final g e = new g() { // from class: k53
            @Override // f53.g
            public final void c(f53.f fVar, f53 f53Var, boolean z) {
                fVar.b(f53Var);
            }
        };

        void c(f fVar, f53 f53Var, boolean z);
    }

    private static boolean I(s53 s53Var, s53 s53Var2, String str) {
        Object obj = s53Var.a.get(str);
        Object obj2 = s53Var2.a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return !obj.equals(obj2);
    }

    private void J(u9 u9Var, u9 u9Var2, SparseArray sparseArray, SparseArray sparseArray2) {
        View view;
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            View view2 = (View) sparseArray.valueAt(i);
            if (view2 != null && H(view2) && (view = (View) sparseArray2.get(sparseArray.keyAt(i))) != null && H(view)) {
                s53 s53Var = (s53) u9Var.get(view2);
                s53 s53Var2 = (s53) u9Var2.get(view);
                if (s53Var != null && s53Var2 != null) {
                    this.t.add(s53Var);
                    this.u.add(s53Var2);
                    u9Var.remove(view2);
                    u9Var2.remove(view);
                }
            }
        }
    }

    private void K(u9 u9Var, u9 u9Var2) {
        s53 s53Var;
        for (int size = u9Var.size() - 1; size >= 0; size--) {
            View view = (View) u9Var.h(size);
            if (view != null && H(view) && (s53Var = (s53) u9Var2.remove(view)) != null && H(s53Var.b)) {
                this.t.add((s53) u9Var.j(size));
                this.u.add(s53Var);
            }
        }
    }

    private void L(u9 u9Var, u9 u9Var2, zd1 zd1Var, zd1 zd1Var2) {
        View view;
        int i = zd1Var.i();
        for (int i2 = 0; i2 < i; i2++) {
            View view2 = (View) zd1Var.j(i2);
            if (view2 != null && H(view2) && (view = (View) zd1Var2.c(zd1Var.e(i2))) != null && H(view)) {
                s53 s53Var = (s53) u9Var.get(view2);
                s53 s53Var2 = (s53) u9Var2.get(view);
                if (s53Var != null && s53Var2 != null) {
                    this.t.add(s53Var);
                    this.u.add(s53Var2);
                    u9Var.remove(view2);
                    u9Var2.remove(view);
                }
            }
        }
    }

    private void M(u9 u9Var, u9 u9Var2, u9 u9Var3, u9 u9Var4) {
        View view;
        int size = u9Var3.size();
        for (int i = 0; i < size; i++) {
            View view2 = (View) u9Var3.l(i);
            if (view2 != null && H(view2) && (view = (View) u9Var4.get(u9Var3.h(i))) != null && H(view)) {
                s53 s53Var = (s53) u9Var.get(view2);
                s53 s53Var2 = (s53) u9Var2.get(view);
                if (s53Var != null && s53Var2 != null) {
                    this.t.add(s53Var);
                    this.u.add(s53Var2);
                    u9Var.remove(view2);
                    u9Var2.remove(view);
                }
            }
        }
    }

    private void N(t53 t53Var, t53 t53Var2) {
        u9 u9Var = new u9(t53Var.a);
        u9 u9Var2 = new u9(t53Var2.a);
        int i = 0;
        while (true) {
            int[] iArr = this.s;
            if (i >= iArr.length) {
                c(u9Var, u9Var2);
                return;
            }
            int i2 = iArr[i];
            if (i2 == 1) {
                K(u9Var, u9Var2);
            } else if (i2 == 2) {
                M(u9Var, u9Var2, t53Var.d, t53Var2.d);
            } else if (i2 == 3) {
                J(u9Var, u9Var2, t53Var.b, t53Var2.b);
            } else if (i2 == 4) {
                L(u9Var, u9Var2, t53Var.c, t53Var2.c);
            }
            i++;
        }
    }

    private void O(f53 f53Var, g gVar, boolean z) {
        f53 f53Var2 = this.H;
        if (f53Var2 != null) {
            f53Var2.O(f53Var, gVar, z);
        }
        ArrayList arrayList = this.I;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        int size = this.I.size();
        f[] fVarArr = this.v;
        if (fVarArr == null) {
            fVarArr = new f[size];
        }
        this.v = null;
        f[] fVarArr2 = (f[]) this.I.toArray(fVarArr);
        for (int i = 0; i < size; i++) {
            gVar.c(fVarArr2[i], f53Var, z);
            fVarArr2[i] = null;
        }
        this.v = fVarArr2;
    }

    private void V(Animator animator, u9 u9Var) {
        if (animator != null) {
            animator.addListener(new b(u9Var));
            e(animator);
        }
    }

    private void c(u9 u9Var, u9 u9Var2) {
        for (int i = 0; i < u9Var.size(); i++) {
            s53 s53Var = (s53) u9Var.l(i);
            if (H(s53Var.b)) {
                this.t.add(s53Var);
                this.u.add(null);
            }
        }
        for (int i2 = 0; i2 < u9Var2.size(); i2++) {
            s53 s53Var2 = (s53) u9Var2.l(i2);
            if (H(s53Var2.b)) {
                this.u.add(s53Var2);
                this.t.add(null);
            }
        }
    }

    private static void d(t53 t53Var, View view, s53 s53Var) {
        t53Var.a.put(view, s53Var);
        int id = view.getId();
        if (id >= 0) {
            if (t53Var.b.indexOfKey(id) >= 0) {
                t53Var.b.put(id, null);
            } else {
                t53Var.b.put(id, view);
            }
        }
        String strJ = be3.J(view);
        if (strJ != null) {
            if (t53Var.d.containsKey(strJ)) {
                t53Var.d.put(strJ, null);
            } else {
                t53Var.d.put(strJ, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (t53Var.c.d(itemIdAtPosition) < 0) {
                    view.setHasTransientState(true);
                    t53Var.c.f(itemIdAtPosition, view);
                    return;
                }
                View view2 = (View) t53Var.c.c(itemIdAtPosition);
                if (view2 != null) {
                    view2.setHasTransientState(false);
                    t53Var.c.f(itemIdAtPosition, null);
                }
            }
        }
    }

    private void g(View view, boolean z) {
        if (view == null) {
            return;
        }
        int id = view.getId();
        ArrayList arrayList = this.i;
        if (arrayList == null || !arrayList.contains(Integer.valueOf(id))) {
            ArrayList arrayList2 = this.j;
            if (arrayList2 == null || !arrayList2.contains(view)) {
                ArrayList arrayList3 = this.k;
                if (arrayList3 != null) {
                    int size = arrayList3.size();
                    for (int i = 0; i < size; i++) {
                        if (((Class) this.k.get(i)).isInstance(view)) {
                            return;
                        }
                    }
                }
                if (view.getParent() instanceof ViewGroup) {
                    s53 s53Var = new s53(view);
                    if (z) {
                        i(s53Var);
                    } else {
                        f(s53Var);
                    }
                    s53Var.c.add(this);
                    h(s53Var);
                    if (z) {
                        d(this.p, view, s53Var);
                    } else {
                        d(this.f331q, view, s53Var);
                    }
                }
                if (view instanceof ViewGroup) {
                    ArrayList arrayList4 = this.m;
                    if (arrayList4 == null || !arrayList4.contains(Integer.valueOf(id))) {
                        ArrayList arrayList5 = this.n;
                        if (arrayList5 == null || !arrayList5.contains(view)) {
                            ArrayList arrayList6 = this.o;
                            if (arrayList6 != null) {
                                int size2 = arrayList6.size();
                                for (int i2 = 0; i2 < size2; i2++) {
                                    if (((Class) this.o.get(i2)).isInstance(view)) {
                                        return;
                                    }
                                }
                            }
                            ViewGroup viewGroup = (ViewGroup) view;
                            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                                g(viewGroup.getChildAt(i3), z);
                            }
                        }
                    }
                }
            }
        }
    }

    private static u9 y() {
        u9 u9Var = (u9) Q.get();
        if (u9Var != null) {
            return u9Var;
        }
        u9 u9Var2 = new u9();
        Q.set(u9Var2);
        return u9Var2;
    }

    public List A() {
        return this.e;
    }

    public List B() {
        return this.g;
    }

    public List C() {
        return this.h;
    }

    public List D() {
        return this.f;
    }

    public String[] E() {
        return null;
    }

    public s53 F(View view, boolean z) {
        q53 q53Var = this.r;
        if (q53Var != null) {
            return q53Var.F(view, z);
        }
        return (s53) (z ? this.p : this.f331q).a.get(view);
    }

    public boolean G(s53 s53Var, s53 s53Var2) {
        if (s53Var == null || s53Var2 == null) {
            return false;
        }
        String[] strArrE = E();
        if (strArrE == null) {
            Iterator it = s53Var.a.keySet().iterator();
            while (it.hasNext()) {
                if (I(s53Var, s53Var2, (String) it.next())) {
                }
            }
            return false;
        }
        for (String str : strArrE) {
            if (!I(s53Var, s53Var2, str)) {
            }
        }
        return false;
        return true;
    }

    boolean H(View view) {
        ArrayList arrayList;
        ArrayList arrayList2;
        int id = view.getId();
        ArrayList arrayList3 = this.i;
        if (arrayList3 != null && arrayList3.contains(Integer.valueOf(id))) {
            return false;
        }
        ArrayList arrayList4 = this.j;
        if (arrayList4 != null && arrayList4.contains(view)) {
            return false;
        }
        ArrayList arrayList5 = this.k;
        if (arrayList5 != null) {
            int size = arrayList5.size();
            for (int i = 0; i < size; i++) {
                if (((Class) this.k.get(i)).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.l != null && be3.J(view) != null && this.l.contains(be3.J(view))) {
            return false;
        }
        if ((this.e.size() == 0 && this.f.size() == 0 && (((arrayList = this.h) == null || arrayList.isEmpty()) && ((arrayList2 = this.g) == null || arrayList2.isEmpty()))) || this.e.contains(Integer.valueOf(id)) || this.f.contains(view)) {
            return true;
        }
        ArrayList arrayList6 = this.g;
        if (arrayList6 != null && arrayList6.contains(be3.J(view))) {
            return true;
        }
        if (this.h != null) {
            for (int i2 = 0; i2 < this.h.size(); i2++) {
                if (((Class) this.h.get(i2)).isInstance(view)) {
                    return true;
                }
            }
        }
        return false;
    }

    void P(g gVar, boolean z) {
        O(this, gVar, z);
    }

    public void Q(View view) {
        if (this.G) {
            return;
        }
        int size = this.x.size();
        Animator[] animatorArr = (Animator[]) this.x.toArray(this.y);
        this.y = N;
        for (int i = size - 1; i >= 0; i--) {
            Animator animator = animatorArr[i];
            animatorArr[i] = null;
            animator.pause();
        }
        this.y = animatorArr;
        P(g.d, false);
        this.F = true;
    }

    void R(ViewGroup viewGroup) {
        d dVar;
        this.t = new ArrayList();
        this.u = new ArrayList();
        N(this.p, this.f331q);
        u9 u9VarY = y();
        int size = u9VarY.size();
        WindowId windowId = viewGroup.getWindowId();
        for (int i = size - 1; i >= 0; i--) {
            Animator animator = (Animator) u9VarY.h(i);
            if (animator != null && (dVar = (d) u9VarY.get(animator)) != null && dVar.a != null && windowId.equals(dVar.d)) {
                s53 s53Var = dVar.c;
                View view = dVar.a;
                s53 s53VarF = F(view, true);
                s53 s53VarT = t(view, true);
                if (s53VarF == null && s53VarT == null) {
                    s53VarT = (s53) this.f331q.a.get(view);
                }
                if ((s53VarF != null || s53VarT != null) && dVar.e.G(s53Var, s53VarT)) {
                    dVar.e.x().getClass();
                    if (animator.isRunning() || animator.isStarted()) {
                        animator.cancel();
                    } else {
                        u9VarY.remove(animator);
                    }
                }
            }
        }
        o(viewGroup, this.p, this.f331q, this.t, this.u);
        W();
    }

    public f53 S(f fVar) {
        f53 f53Var;
        ArrayList arrayList = this.I;
        if (arrayList == null) {
            return this;
        }
        if (!arrayList.remove(fVar) && (f53Var = this.H) != null) {
            f53Var.S(fVar);
        }
        if (this.I.size() == 0) {
            this.I = null;
        }
        return this;
    }

    public f53 T(View view) {
        this.f.remove(view);
        return this;
    }

    public void U(View view) {
        if (this.F) {
            if (!this.G) {
                int size = this.x.size();
                Animator[] animatorArr = (Animator[]) this.x.toArray(this.y);
                this.y = N;
                for (int i = size - 1; i >= 0; i--) {
                    Animator animator = animatorArr[i];
                    animatorArr[i] = null;
                    animator.resume();
                }
                this.y = animatorArr;
                P(g.e, false);
            }
            this.F = false;
        }
    }

    protected void W() {
        d0();
        u9 u9VarY = y();
        for (Animator animator : this.J) {
            if (u9VarY.containsKey(animator)) {
                d0();
                V(animator, u9VarY);
            }
        }
        this.J.clear();
        p();
    }

    public f53 X(long j) {
        this.c = j;
        return this;
    }

    public void Y(e eVar) {
        this.K = eVar;
    }

    public f53 Z(TimeInterpolator timeInterpolator) {
        this.d = timeInterpolator;
        return this;
    }

    public f53 a(f fVar) {
        if (this.I == null) {
            this.I = new ArrayList();
        }
        this.I.add(fVar);
        return this;
    }

    public void a0(nz1 nz1Var) {
        if (nz1Var == null) {
            this.M = P;
        } else {
            this.M = nz1Var;
        }
    }

    public f53 b(View view) {
        this.f.add(view);
        return this;
    }

    public void b0(p53 p53Var) {
    }

    public f53 c0(long j) {
        this.b = j;
        return this;
    }

    protected void cancel() {
        int size = this.x.size();
        Animator[] animatorArr = (Animator[]) this.x.toArray(this.y);
        this.y = N;
        for (int i = size - 1; i >= 0; i--) {
            Animator animator = animatorArr[i];
            animatorArr[i] = null;
            animator.cancel();
        }
        this.y = animatorArr;
        P(g.c, false);
    }

    protected void d0() {
        if (this.z == 0) {
            P(g.a, false);
            this.G = false;
        }
        this.z++;
    }

    protected void e(Animator animator) {
        if (animator == null) {
            p();
            return;
        }
        if (q() >= 0) {
            animator.setDuration(q());
        }
        if (z() >= 0) {
            animator.setStartDelay(z() + animator.getStartDelay());
        }
        if (s() != null) {
            animator.setInterpolator(s());
        }
        animator.addListener(new c());
        animator.start();
    }

    String e0(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(getClass().getSimpleName());
        sb.append("@");
        sb.append(Integer.toHexString(hashCode()));
        sb.append(": ");
        if (this.c != -1) {
            sb.append("dur(");
            sb.append(this.c);
            sb.append(") ");
        }
        if (this.b != -1) {
            sb.append("dly(");
            sb.append(this.b);
            sb.append(") ");
        }
        if (this.d != null) {
            sb.append("interp(");
            sb.append(this.d);
            sb.append(") ");
        }
        if (this.e.size() > 0 || this.f.size() > 0) {
            sb.append("tgts(");
            if (this.e.size() > 0) {
                for (int i = 0; i < this.e.size(); i++) {
                    if (i > 0) {
                        sb.append(", ");
                    }
                    sb.append(this.e.get(i));
                }
            }
            if (this.f.size() > 0) {
                for (int i2 = 0; i2 < this.f.size(); i2++) {
                    if (i2 > 0) {
                        sb.append(", ");
                    }
                    sb.append(this.f.get(i2));
                }
            }
            sb.append(")");
        }
        return sb.toString();
    }

    public abstract void f(s53 s53Var);

    void h(s53 s53Var) {
    }

    public abstract void i(s53 s53Var);

    void j(ViewGroup viewGroup, boolean z) {
        ArrayList arrayList;
        ArrayList arrayList2;
        u9 u9Var;
        k(z);
        if ((this.e.size() > 0 || this.f.size() > 0) && (((arrayList = this.g) == null || arrayList.isEmpty()) && ((arrayList2 = this.h) == null || arrayList2.isEmpty()))) {
            for (int i = 0; i < this.e.size(); i++) {
                View viewFindViewById = viewGroup.findViewById(((Integer) this.e.get(i)).intValue());
                if (viewFindViewById != null) {
                    s53 s53Var = new s53(viewFindViewById);
                    if (z) {
                        i(s53Var);
                    } else {
                        f(s53Var);
                    }
                    s53Var.c.add(this);
                    h(s53Var);
                    if (z) {
                        d(this.p, viewFindViewById, s53Var);
                    } else {
                        d(this.f331q, viewFindViewById, s53Var);
                    }
                }
            }
            for (int i2 = 0; i2 < this.f.size(); i2++) {
                View view = (View) this.f.get(i2);
                s53 s53Var2 = new s53(view);
                if (z) {
                    i(s53Var2);
                } else {
                    f(s53Var2);
                }
                s53Var2.c.add(this);
                h(s53Var2);
                if (z) {
                    d(this.p, view, s53Var2);
                } else {
                    d(this.f331q, view, s53Var2);
                }
            }
        } else {
            g(viewGroup, z);
        }
        if (z || (u9Var = this.L) == null) {
            return;
        }
        int size = u9Var.size();
        ArrayList arrayList3 = new ArrayList(size);
        for (int i3 = 0; i3 < size; i3++) {
            arrayList3.add((View) this.p.d.remove((String) this.L.h(i3)));
        }
        for (int i4 = 0; i4 < size; i4++) {
            View view2 = (View) arrayList3.get(i4);
            if (view2 != null) {
                this.p.d.put((String) this.L.l(i4), view2);
            }
        }
    }

    void k(boolean z) {
        if (z) {
            this.p.a.clear();
            this.p.b.clear();
            this.p.c.a();
        } else {
            this.f331q.a.clear();
            this.f331q.b.clear();
            this.f331q.c.a();
        }
    }

    @Override // 
    /* JADX INFO: renamed from: l */
    public f53 clone() {
        try {
            f53 f53Var = (f53) super.clone();
            f53Var.J = new ArrayList();
            f53Var.p = new t53();
            f53Var.f331q = new t53();
            f53Var.t = null;
            f53Var.u = null;
            f53Var.H = this;
            f53Var.I = null;
            return f53Var;
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    public Animator m(ViewGroup viewGroup, s53 s53Var, s53 s53Var2) {
        return null;
    }

    void o(ViewGroup viewGroup, t53 t53Var, t53 t53Var2, ArrayList arrayList, ArrayList arrayList2) {
        View view;
        Animator animator;
        s53 s53Var;
        Animator animator2;
        s53 s53Var2;
        u9 u9VarY = y();
        SparseIntArray sparseIntArray = new SparseIntArray();
        x().getClass();
        int i = 0;
        for (int size = arrayList.size(); i < size; size = size) {
            s53 s53Var3 = (s53) arrayList.get(i);
            s53 s53Var4 = (s53) arrayList2.get(i);
            if (s53Var3 != null && !s53Var3.c.contains(this)) {
                s53Var3 = null;
            }
            if (s53Var4 != null && !s53Var4.c.contains(this)) {
                s53Var4 = null;
            }
            if ((s53Var3 != null || s53Var4 != null) && (s53Var3 == null || s53Var4 == null || G(s53Var3, s53Var4))) {
                Animator animatorM = m(viewGroup, s53Var3, s53Var4);
                if (animatorM != null) {
                    if (s53Var4 != null) {
                        View view2 = s53Var4.b;
                        String[] strArrE = E();
                        if (strArrE != null && strArrE.length > 0) {
                            s53Var2 = new s53(view2);
                            s53 s53Var5 = (s53) t53Var2.a.get(view2);
                            if (s53Var5 != null) {
                                int i2 = 0;
                                while (i2 < strArrE.length) {
                                    Map map = s53Var2.a;
                                    Animator animator3 = animatorM;
                                    String str = strArrE[i2];
                                    map.put(str, s53Var5.a.get(str));
                                    i2++;
                                    animatorM = animator3;
                                    strArrE = strArrE;
                                }
                            }
                            Animator animator4 = animatorM;
                            int size2 = u9VarY.size();
                            int i3 = 0;
                            while (true) {
                                if (i3 >= size2) {
                                    animator2 = animator4;
                                    break;
                                }
                                d dVar = (d) u9VarY.get((Animator) u9VarY.h(i3));
                                if (dVar.c != null && dVar.a == view2 && dVar.b.equals(u()) && dVar.c.equals(s53Var2)) {
                                    animator2 = null;
                                    break;
                                }
                                i3++;
                            }
                        } else {
                            animator2 = animatorM;
                            s53Var2 = null;
                        }
                        view = view2;
                        animator = animator2;
                        s53Var = s53Var2;
                    } else {
                        view = s53Var3.b;
                        animator = animatorM;
                        s53Var = null;
                    }
                    if (animator != null) {
                        u9VarY.put(animator, new d(view, u(), this, viewGroup.getWindowId(), s53Var, animator));
                        this.J.add(animator);
                    }
                }
                i++;
            }
            i++;
        }
        if (sparseIntArray.size() != 0) {
            for (int i4 = 0; i4 < sparseIntArray.size(); i4++) {
                d dVar2 = (d) u9VarY.get((Animator) this.J.get(sparseIntArray.keyAt(i4)));
                dVar2.f.setStartDelay((((long) sparseIntArray.valueAt(i4)) - Long.MAX_VALUE) + dVar2.f.getStartDelay());
            }
        }
    }

    protected void p() {
        int i = this.z - 1;
        this.z = i;
        if (i == 0) {
            P(g.b, false);
            for (int i2 = 0; i2 < this.p.c.i(); i2++) {
                View view = (View) this.p.c.j(i2);
                if (view != null) {
                    view.setHasTransientState(false);
                }
            }
            for (int i3 = 0; i3 < this.f331q.c.i(); i3++) {
                View view2 = (View) this.f331q.c.j(i3);
                if (view2 != null) {
                    view2.setHasTransientState(false);
                }
            }
            this.G = true;
        }
    }

    public long q() {
        return this.c;
    }

    public e r() {
        return this.K;
    }

    public TimeInterpolator s() {
        return this.d;
    }

    s53 t(View view, boolean z) {
        q53 q53Var = this.r;
        if (q53Var != null) {
            return q53Var.t(view, z);
        }
        ArrayList arrayList = z ? this.t : this.u;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                i = -1;
                break;
            }
            s53 s53Var = (s53) arrayList.get(i);
            if (s53Var == null) {
                return null;
            }
            if (s53Var.b == view) {
                break;
            }
            i++;
        }
        if (i >= 0) {
            return (s53) (z ? this.u : this.t).get(i);
        }
        return null;
    }

    public String toString() {
        return e0(Constants.STR_EMPTY);
    }

    public String u() {
        return this.a;
    }

    public nz1 v() {
        return this.M;
    }

    public p53 w() {
        return null;
    }

    public final f53 x() {
        q53 q53Var = this.r;
        return q53Var != null ? q53Var.x() : this;
    }

    public long z() {
        return this.b;
    }
}
