package androidx.databinding;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.Choreographer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.library.R$id;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LiveData;
import defpackage.cb1;
import defpackage.db1;
import defpackage.e43;
import defpackage.vt1;
import defpackage.w50;
import defpackage.wd3;
import defpackage.yv1;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public abstract class ViewDataBinding extends androidx.databinding.a implements wd3 {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final int f191q = 8;
    private final Runnable a;
    private boolean b;
    private boolean c;
    private androidx.databinding.m[] d;
    private final View e;
    private androidx.databinding.c f;
    private boolean g;
    private Choreographer h;
    private final Choreographer.FrameCallback i;
    private Handler j;
    private ViewDataBinding k;
    private db1 l;
    private OnStartListener m;
    private boolean n;
    protected boolean o;
    static int p = Build.VERSION.SDK_INT;
    private static final boolean r = true;
    private static final androidx.databinding.d s = new a();
    private static final androidx.databinding.d t = new b();
    private static final androidx.databinding.d u = new c();
    private static final androidx.databinding.d v = new d();
    private static final androidx.databinding.c.a w = new e();
    private static final ReferenceQueue x = new ReferenceQueue();
    private static final View.OnAttachStateChangeListener y = new f();

    static class OnStartListener implements cb1 {
        final WeakReference a;

        /* synthetic */ OnStartListener(ViewDataBinding viewDataBinding, a aVar) {
            this(viewDataBinding);
        }

        @androidx.lifecycle.j(Lifecycle.Event.ON_START)
        public void onStart() {
            ViewDataBinding viewDataBinding = (ViewDataBinding) this.a.get();
            if (viewDataBinding != null) {
                viewDataBinding.j();
            }
        }

        private OnStartListener(ViewDataBinding viewDataBinding) {
            this.a = new WeakReference(viewDataBinding);
        }
    }

    class a implements androidx.databinding.d {
        a() {
        }

        @Override // androidx.databinding.d
        public androidx.databinding.m a(ViewDataBinding viewDataBinding, int i, ReferenceQueue referenceQueue) {
            return new m(viewDataBinding, i, referenceQueue).d();
        }
    }

    class b implements androidx.databinding.d {
        b() {
        }

        @Override // androidx.databinding.d
        public androidx.databinding.m a(ViewDataBinding viewDataBinding, int i, ReferenceQueue referenceQueue) {
            return new k(viewDataBinding, i, referenceQueue).h();
        }
    }

    class c implements androidx.databinding.d {
        c() {
        }

        @Override // androidx.databinding.d
        public androidx.databinding.m a(ViewDataBinding viewDataBinding, int i, ReferenceQueue referenceQueue) {
            return new l(viewDataBinding, i, referenceQueue).c();
        }
    }

    class d implements androidx.databinding.d {
        d() {
        }

        @Override // androidx.databinding.d
        public androidx.databinding.m a(ViewDataBinding viewDataBinding, int i, ReferenceQueue referenceQueue) {
            return new j(viewDataBinding, i, referenceQueue).e();
        }
    }

    class e extends androidx.databinding.c.a {
        e() {
        }

        @Override // androidx.databinding.c.a
        public /* bridge */ /* synthetic */ void a(Object obj, Object obj2, int i, Object obj3) {
            e43.a(obj);
            b(null, (ViewDataBinding) obj2, i, (Void) obj3);
        }

        public void b(yv1 yv1Var, ViewDataBinding viewDataBinding, int i, Void r4) {
            if (i == 1 || i == 2 || i == 3) {
                throw null;
            }
        }
    }

    class f implements View.OnAttachStateChangeListener {
        f() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            ViewDataBinding.k(view).a.run();
            view.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this) {
                ViewDataBinding.this.b = false;
            }
            ViewDataBinding.v();
            if (ViewDataBinding.this.e.isAttachedToWindow()) {
                ViewDataBinding.this.j();
            } else {
                ViewDataBinding.this.e.removeOnAttachStateChangeListener(ViewDataBinding.y);
                ViewDataBinding.this.e.addOnAttachStateChangeListener(ViewDataBinding.y);
            }
        }
    }

    class h implements Choreographer.FrameCallback {
        h() {
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            ViewDataBinding.this.a.run();
        }
    }

    protected static class i {
    }

    private static class j implements vt1, androidx.databinding.j {
        final androidx.databinding.m a;
        WeakReference b = null;

        public j(ViewDataBinding viewDataBinding, int i, ReferenceQueue referenceQueue) {
            this.a = new androidx.databinding.m(viewDataBinding, i, this, referenceQueue);
        }

        private db1 d() {
            WeakReference weakReference = this.b;
            if (weakReference == null) {
                return null;
            }
            return (db1) weakReference.get();
        }

        @Override // androidx.databinding.j
        public void a(db1 db1Var) {
            db1 db1VarD = d();
            LiveData liveData = (LiveData) this.a.b();
            if (liveData != null) {
                if (db1VarD != null) {
                    liveData.n(this);
                }
                if (db1Var != null) {
                    liveData.i(db1Var, this);
                }
            }
            if (db1Var != null) {
                this.b = new WeakReference(db1Var);
            }
        }

        @Override // defpackage.vt1
        public void b(Object obj) {
            ViewDataBinding viewDataBindingA = this.a.a();
            if (viewDataBindingA != null) {
                androidx.databinding.m mVar = this.a;
                viewDataBindingA.n(mVar.b, mVar.b(), 0);
            }
        }

        @Override // androidx.databinding.j
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void addListener(LiveData liveData) {
            db1 db1VarD = d();
            if (db1VarD != null) {
                liveData.i(db1VarD, this);
            }
        }

        public androidx.databinding.m e() {
            return this.a;
        }

        @Override // androidx.databinding.j
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void removeListener(LiveData liveData) {
            liveData.n(this);
        }
    }

    private static class k extends androidx.databinding.h.a implements androidx.databinding.j {
        final androidx.databinding.m a;

        public k(ViewDataBinding viewDataBinding, int i, ReferenceQueue referenceQueue) {
            this.a = new androidx.databinding.m(viewDataBinding, i, this, referenceQueue);
        }

        @Override // androidx.databinding.j
        public void a(db1 db1Var) {
        }

        @Override // androidx.databinding.h.a
        public void b(androidx.databinding.h hVar) {
            androidx.databinding.h hVar2;
            ViewDataBinding viewDataBindingA = this.a.a();
            if (viewDataBindingA != null && (hVar2 = (androidx.databinding.h) this.a.b()) == hVar) {
                viewDataBindingA.n(this.a.b, hVar2, 0);
            }
        }

        @Override // androidx.databinding.h.a
        public void c(androidx.databinding.h hVar, int i, int i2) {
            b(hVar);
        }

        @Override // androidx.databinding.h.a
        public void d(androidx.databinding.h hVar, int i, int i2) {
            b(hVar);
        }

        @Override // androidx.databinding.h.a
        public void e(androidx.databinding.h hVar, int i, int i2, int i3) {
            b(hVar);
        }

        @Override // androidx.databinding.h.a
        public void f(androidx.databinding.h hVar, int i, int i2) {
            b(hVar);
        }

        @Override // androidx.databinding.j
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void addListener(androidx.databinding.h hVar) {
            hVar.addOnListChangedCallback(this);
        }

        public androidx.databinding.m h() {
            return this.a;
        }

        @Override // androidx.databinding.j
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public void removeListener(androidx.databinding.h hVar) {
            hVar.removeOnListChangedCallback(this);
        }
    }

    private static class l extends androidx.databinding.i.a implements androidx.databinding.j {
        final androidx.databinding.m a;

        public l(ViewDataBinding viewDataBinding, int i, ReferenceQueue referenceQueue) {
            this.a = new androidx.databinding.m(viewDataBinding, i, this, referenceQueue);
        }

        @Override // androidx.databinding.j
        public void a(db1 db1Var) {
        }

        @Override // androidx.databinding.j
        public /* bridge */ /* synthetic */ void addListener(Object obj) {
            e43.a(obj);
            b(null);
        }

        public void b(androidx.databinding.i iVar) {
            iVar.a(this);
        }

        public androidx.databinding.m c() {
            return this.a;
        }

        public void d(androidx.databinding.i iVar) {
            iVar.b(this);
        }

        @Override // androidx.databinding.j
        public /* bridge */ /* synthetic */ void removeListener(Object obj) {
            e43.a(obj);
            d(null);
        }
    }

    private static class m extends androidx.databinding.g.a implements androidx.databinding.j {
        final androidx.databinding.m a;

        public m(ViewDataBinding viewDataBinding, int i, ReferenceQueue referenceQueue) {
            this.a = new androidx.databinding.m(viewDataBinding, i, this, referenceQueue);
        }

        @Override // androidx.databinding.j
        public void a(db1 db1Var) {
        }

        @Override // androidx.databinding.g.a
        public void b(androidx.databinding.g gVar, int i) {
            ViewDataBinding viewDataBindingA = this.a.a();
            if (viewDataBindingA != null && ((androidx.databinding.g) this.a.b()) == gVar) {
                viewDataBindingA.n(this.a.b, gVar, i);
            }
        }

        @Override // androidx.databinding.j
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void addListener(androidx.databinding.g gVar) {
            gVar.addOnPropertyChangedCallback(this);
        }

        public androidx.databinding.m d() {
            return this.a;
        }

        @Override // androidx.databinding.j
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void removeListener(androidx.databinding.g gVar) {
            gVar.removeOnPropertyChangedCallback(this);
        }
    }

    protected ViewDataBinding(w50 w50Var, View view, int i2) {
        this.a = new g();
        this.b = false;
        this.c = false;
        this.d = new androidx.databinding.m[i2];
        this.e = view;
        if (Looper.myLooper() == null) {
            throw new IllegalStateException("DataBinding must be created in view's UI Thread");
        }
        if (r) {
            this.h = Choreographer.getInstance();
            this.i = new h();
        } else {
            this.i = null;
            this.j = new Handler(Looper.myLooper());
        }
    }

    protected static ViewDataBinding f(Object obj, View view, int i2) {
        g(obj);
        return androidx.databinding.e.a(null, view, i2);
    }

    private static w50 g(Object obj) {
        if (obj == null) {
            return null;
        }
        throw new IllegalArgumentException("The provided bindingComponent parameter must be an instance of DataBindingComponent. See  https://issuetracker.google.com/issues/116541301 for details of why this parameter is not defined as DataBindingComponent");
    }

    private void i() {
        if (this.g) {
            z();
            return;
        }
        if (o()) {
            this.g = true;
            this.c = false;
            androidx.databinding.c cVar = this.f;
            if (cVar != null) {
                cVar.d(this, 1, null);
                if (this.c) {
                    this.f.d(this, 2, null);
                }
            }
            if (!this.c) {
                h();
                androidx.databinding.c cVar2 = this.f;
                if (cVar2 != null) {
                    cVar2.d(this, 3, null);
                }
            }
            this.g = false;
        }
    }

    static ViewDataBinding k(View view) {
        if (view != null) {
            return (ViewDataBinding) view.getTag(R$id.dataBinding);
        }
        return null;
    }

    public static int l() {
        return p;
    }

    protected static int m(View view, int i2) {
        return view.getContext().getColor(i2);
    }

    protected static ViewDataBinding p(LayoutInflater layoutInflater, int i2, ViewGroup viewGroup, boolean z, Object obj) {
        g(obj);
        return androidx.databinding.e.f(layoutInflater, i2, viewGroup, z, null);
    }

    private static boolean q(String str, int i2) {
        int length = str.length();
        if (length == i2) {
            return false;
        }
        while (i2 < length) {
            if (!Character.isDigit(str.charAt(i2))) {
                return false;
            }
            i2++;
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0052  */
    private static void r(w50 w50Var, View view, Object[] objArr, i iVar, SparseIntArray sparseIntArray, boolean z) {
        int id;
        int i2;
        if (k(view) != null) {
            return;
        }
        Object tag = view.getTag();
        String str = tag instanceof String ? (String) tag : null;
        boolean z2 = true;
        if (z && str != null && str.startsWith("layout")) {
            int iLastIndexOf = str.lastIndexOf(95);
            if (iLastIndexOf > 0) {
                int i3 = iLastIndexOf + 1;
                if (q(str, i3)) {
                    int iU = u(str, i3);
                    if (objArr[iU] == null) {
                        objArr[iU] = view;
                    }
                } else {
                    z2 = false;
                }
            } else {
                z2 = false;
            }
        } else if (str == null || !str.startsWith("binding_")) {
            z2 = false;
        } else {
            int iU2 = u(str, f191q);
            if (objArr[iU2] == null) {
                objArr[iU2] = view;
            }
        }
        if (!z2 && (id = view.getId()) > 0 && sparseIntArray != null && (i2 = sparseIntArray.get(id, -1)) >= 0 && objArr[i2] == null) {
            objArr[i2] = view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                r(w50Var, viewGroup.getChildAt(i4), objArr, iVar, sparseIntArray, false);
            }
        }
    }

    protected static Object[] s(w50 w50Var, View view, int i2, i iVar, SparseIntArray sparseIntArray) {
        Object[] objArr = new Object[i2];
        r(w50Var, view, objArr, iVar, sparseIntArray, true);
        return objArr;
    }

    private static int u(String str, int i2) {
        int length = str.length();
        int iCharAt = 0;
        while (i2 < length) {
            iCharAt = (iCharAt * 10) + (str.charAt(i2) - '0');
            i2++;
        }
        return iCharAt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void v() {
        while (true) {
            Reference referencePoll = x.poll();
            if (referencePoll == null) {
                return;
            }
            if (referencePoll instanceof androidx.databinding.m) {
                ((androidx.databinding.m) referencePoll).e();
            }
        }
    }

    public void A(db1 db1Var) {
        if (db1Var instanceof Fragment) {
            Log.w("DataBinding", "Setting the fragment as the LifecycleOwner might cause memory leaks because views lives shorter than the Fragment. Consider using Fragment's view lifecycle");
        }
        db1 db1Var2 = this.l;
        if (db1Var2 == db1Var) {
            return;
        }
        if (db1Var2 != null) {
            db1Var2.getLifecycle().d(this.m);
        }
        this.l = db1Var;
        if (db1Var != null) {
            if (this.m == null) {
                this.m = new OnStartListener(this, null);
            }
            db1Var.getLifecycle().a(this.m);
        }
        for (androidx.databinding.m mVar : this.d) {
            if (mVar != null) {
                mVar.c(db1Var);
            }
        }
    }

    protected void B(View view) {
        view.setTag(R$id.dataBinding, this);
    }

    protected boolean E(int i2) {
        androidx.databinding.m mVar = this.d[i2];
        if (mVar != null) {
            return mVar.e();
        }
        return false;
    }

    protected boolean F(int i2, LiveData liveData) {
        this.n = true;
        try {
            return G(i2, liveData, v);
        } finally {
            this.n = false;
        }
    }

    protected boolean G(int i2, Object obj, androidx.databinding.d dVar) {
        if (obj == null) {
            return E(i2);
        }
        androidx.databinding.m mVar = this.d[i2];
        if (mVar == null) {
            x(i2, obj, dVar);
            return true;
        }
        if (mVar.b() == obj) {
            return false;
        }
        E(i2);
        x(i2, obj, dVar);
        return true;
    }

    @Override // defpackage.wd3
    public View getRoot() {
        return this.e;
    }

    protected abstract void h();

    public void j() {
        ViewDataBinding viewDataBinding = this.k;
        if (viewDataBinding == null) {
            i();
        } else {
            viewDataBinding.j();
        }
    }

    protected void n(int i2, Object obj, int i3) {
        if (this.n || this.o || !t(i2, obj, i3)) {
            return;
        }
        z();
    }

    public abstract boolean o();

    protected abstract boolean t(int i2, Object obj, int i3);

    protected void x(int i2, Object obj, androidx.databinding.d dVar) {
        if (obj == null) {
            return;
        }
        androidx.databinding.m mVarA = this.d[i2];
        if (mVarA == null) {
            mVarA = dVar.a(this, i2, x);
            this.d[i2] = mVarA;
            db1 db1Var = this.l;
            if (db1Var != null) {
                mVarA.c(db1Var);
            }
        }
        mVarA.d(obj);
    }

    protected void z() {
        ViewDataBinding viewDataBinding = this.k;
        if (viewDataBinding != null) {
            viewDataBinding.z();
            return;
        }
        db1 db1Var = this.l;
        if (db1Var == null || db1Var.getLifecycle().b().isAtLeast(Lifecycle.State.STARTED)) {
            synchronized (this) {
                try {
                    if (this.b) {
                        return;
                    }
                    this.b = true;
                    if (r) {
                        this.h.postFrameCallback(this.i);
                    } else {
                        this.j.post(this.a);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    protected ViewDataBinding(Object obj, View view, int i2) {
        this((w50) null, view, i2);
        g(obj);
    }
}
