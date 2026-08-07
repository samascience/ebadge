package androidx.activity;

import android.os.Build;
import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.OnBackPressedDispatcher;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.f;
import com.tencent.open.SocialConstants;
import defpackage.ar0;
import defpackage.db1;
import defpackage.he;
import defpackage.iv;
import defpackage.k83;
import defpackage.ou1;
import defpackage.p31;
import defpackage.q20;
import defpackage.yq0;
import java.util.Iterator;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes.dex */
public final class OnBackPressedDispatcher {
    private final Runnable a;
    private final q20 b;
    private final kotlin.collections.c c;
    private ou1 d;
    private OnBackInvokedCallback e;
    private OnBackInvokedDispatcher f;
    private boolean g;
    private boolean h;

    private final class LifecycleOnBackPressedCancellable implements f, iv {
        private final Lifecycle a;
        private final ou1 b;
        private iv c;
        final /* synthetic */ OnBackPressedDispatcher d;

        public LifecycleOnBackPressedCancellable(OnBackPressedDispatcher onBackPressedDispatcher, Lifecycle lifecycle, ou1 ou1Var) {
            p31.f(lifecycle, "lifecycle");
            p31.f(ou1Var, "onBackPressedCallback");
            this.d = onBackPressedDispatcher;
            this.a = lifecycle;
            this.b = ou1Var;
            lifecycle.a(this);
        }

        @Override // androidx.lifecycle.f
        public void c(db1 db1Var, Lifecycle.Event event) {
            p31.f(db1Var, SocialConstants.PARAM_SOURCE);
            p31.f(event, "event");
            if (event == Lifecycle.Event.ON_START) {
                this.c = this.d.i(this.b);
                return;
            }
            if (event != Lifecycle.Event.ON_STOP) {
                if (event == Lifecycle.Event.ON_DESTROY) {
                    cancel();
                }
            } else {
                iv ivVar = this.c;
                if (ivVar != null) {
                    ivVar.cancel();
                }
            }
        }

        @Override // defpackage.iv
        public void cancel() {
            this.a.d(this);
            this.b.i(this);
            iv ivVar = this.c;
            if (ivVar != null) {
                ivVar.cancel();
            }
            this.c = null;
        }
    }

    public static final class a {
        public static final a a = new a();

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(yq0 yq0Var) {
            p31.f(yq0Var, "$onBackInvoked");
            yq0Var.invoke();
        }

        public final OnBackInvokedCallback b(final yq0 yq0Var) {
            p31.f(yq0Var, "onBackInvoked");
            return new OnBackInvokedCallback() { // from class: pu1
                public final void onBackInvoked() {
                    OnBackPressedDispatcher.a.c(yq0Var);
                }
            };
        }

        public final void d(Object obj, int i, Object obj2) {
            p31.f(obj, "dispatcher");
            p31.f(obj2, "callback");
            ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(i, (OnBackInvokedCallback) obj2);
        }

        public final void e(Object obj, Object obj2) {
            p31.f(obj, "dispatcher");
            p31.f(obj2, "callback");
            ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
        }
    }

    public static final class b {
        public static final b a = new b();

        public static final class a implements OnBackAnimationCallback {
            final /* synthetic */ ar0 a;
            final /* synthetic */ ar0 b;
            final /* synthetic */ yq0 c;
            final /* synthetic */ yq0 d;

            a(ar0 ar0Var, ar0 ar0Var2, yq0 yq0Var, yq0 yq0Var2) {
                this.a = ar0Var;
                this.b = ar0Var2;
                this.c = yq0Var;
                this.d = yq0Var2;
            }

            public void onBackCancelled() {
                this.d.invoke();
            }

            public void onBackInvoked() {
                this.c.invoke();
            }

            public void onBackProgressed(BackEvent backEvent) {
                p31.f(backEvent, "backEvent");
                this.b.invoke(new he(backEvent));
            }

            public void onBackStarted(BackEvent backEvent) {
                p31.f(backEvent, "backEvent");
                this.a.invoke(new he(backEvent));
            }
        }

        private b() {
        }

        public final OnBackInvokedCallback a(ar0 ar0Var, ar0 ar0Var2, yq0 yq0Var, yq0 yq0Var2) {
            p31.f(ar0Var, "onBackStarted");
            p31.f(ar0Var2, "onBackProgressed");
            p31.f(yq0Var, "onBackInvoked");
            p31.f(yq0Var2, "onBackCancelled");
            return new a(ar0Var, ar0Var2, yq0Var, yq0Var2);
        }
    }

    private final class c implements iv {
        private final ou1 a;
        final /* synthetic */ OnBackPressedDispatcher b;

        public c(OnBackPressedDispatcher onBackPressedDispatcher, ou1 ou1Var) {
            p31.f(ou1Var, "onBackPressedCallback");
            this.b = onBackPressedDispatcher;
            this.a = ou1Var;
        }

        @Override // defpackage.iv
        public void cancel() {
            this.b.c.remove(this.a);
            if (p31.a(this.b.d, this.a)) {
                this.a.c();
                this.b.d = null;
            }
            this.a.i(this);
            yq0 yq0VarB = this.a.b();
            if (yq0VarB != null) {
                yq0VarB.invoke();
            }
            this.a.k(null);
        }
    }

    public OnBackPressedDispatcher(Runnable runnable, q20 q20Var) {
        this.a = runnable;
        this.b = q20Var;
        this.c = new kotlin.collections.c();
        int i = Build.VERSION.SDK_INT;
        if (i >= 33) {
            this.e = i >= 34 ? b.a.a(new ar0() { // from class: androidx.activity.OnBackPressedDispatcher.1
                {
                    super(1);
                }

                @Override // defpackage.ar0
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((he) obj);
                    return k83.a;
                }

                public final void invoke(he heVar) {
                    p31.f(heVar, "backEvent");
                    OnBackPressedDispatcher.this.m(heVar);
                }
            }, new ar0() { // from class: androidx.activity.OnBackPressedDispatcher.2
                {
                    super(1);
                }

                @Override // defpackage.ar0
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((he) obj);
                    return k83.a;
                }

                public final void invoke(he heVar) {
                    p31.f(heVar, "backEvent");
                    OnBackPressedDispatcher.this.l(heVar);
                }
            }, new yq0() { // from class: androidx.activity.OnBackPressedDispatcher.3
                {
                    super(0);
                }

                @Override // defpackage.yq0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m1invoke();
                    return k83.a;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m1invoke() {
                    OnBackPressedDispatcher.this.k();
                }
            }, new yq0() { // from class: androidx.activity.OnBackPressedDispatcher.4
                {
                    super(0);
                }

                @Override // defpackage.yq0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m2invoke();
                    return k83.a;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m2invoke() {
                    OnBackPressedDispatcher.this.j();
                }
            }) : a.a.b(new yq0() { // from class: androidx.activity.OnBackPressedDispatcher.5
                {
                    super(0);
                }

                @Override // defpackage.yq0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m3invoke();
                    return k83.a;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m3invoke() {
                    OnBackPressedDispatcher.this.k();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        Object objPrevious;
        kotlin.collections.c cVar = this.c;
        ListIterator<E> listIterator = cVar.listIterator(cVar.size());
        do {
            if (!listIterator.hasPrevious()) {
                objPrevious = null;
                break;
            }
            objPrevious = listIterator.previous();
        } while (!((ou1) objPrevious).g());
        ou1 ou1Var = (ou1) objPrevious;
        this.d = null;
        if (ou1Var != null) {
            ou1Var.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(he heVar) {
        Object objPrevious;
        kotlin.collections.c cVar = this.c;
        ListIterator<E> listIterator = cVar.listIterator(cVar.size());
        do {
            if (!listIterator.hasPrevious()) {
                objPrevious = null;
                break;
            }
            objPrevious = listIterator.previous();
        } while (!((ou1) objPrevious).g());
        ou1 ou1Var = (ou1) objPrevious;
        if (ou1Var != null) {
            ou1Var.e(heVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(he heVar) {
        Object objPrevious;
        kotlin.collections.c cVar = this.c;
        ListIterator<E> listIterator = cVar.listIterator(cVar.size());
        do {
            if (!listIterator.hasPrevious()) {
                objPrevious = null;
                break;
            }
            objPrevious = listIterator.previous();
        } while (!((ou1) objPrevious).g());
        ou1 ou1Var = (ou1) objPrevious;
        this.d = ou1Var;
        if (ou1Var != null) {
            ou1Var.f(heVar);
        }
    }

    private final void o(boolean z) {
        OnBackInvokedDispatcher onBackInvokedDispatcher = this.f;
        OnBackInvokedCallback onBackInvokedCallback = this.e;
        if (onBackInvokedDispatcher == null || onBackInvokedCallback == null) {
            return;
        }
        if (z && !this.g) {
            a.a.d(onBackInvokedDispatcher, 0, onBackInvokedCallback);
            this.g = true;
        } else {
            if (z || !this.g) {
                return;
            }
            a.a.e(onBackInvokedDispatcher, onBackInvokedCallback);
            this.g = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p() {
        boolean z = this.h;
        kotlin.collections.c cVar = this.c;
        boolean z2 = false;
        if (cVar == null || !cVar.isEmpty()) {
            Iterator<E> it = cVar.iterator();
            while (it.hasNext()) {
                if (((ou1) it.next()).g()) {
                    z2 = true;
                    break;
                }
            }
        }
        this.h = z2;
        if (z2 != z) {
            q20 q20Var = this.b;
            if (q20Var != null) {
                q20Var.accept(Boolean.valueOf(z2));
            }
            if (Build.VERSION.SDK_INT >= 33) {
                o(z2);
            }
        }
    }

    public final void h(db1 db1Var, ou1 ou1Var) {
        p31.f(db1Var, "owner");
        p31.f(ou1Var, "onBackPressedCallback");
        Lifecycle lifecycle = db1Var.getLifecycle();
        if (lifecycle.b() == Lifecycle.State.DESTROYED) {
            return;
        }
        ou1Var.a(new LifecycleOnBackPressedCancellable(this, lifecycle, ou1Var));
        p();
        ou1Var.k(new OnBackPressedDispatcher$addCallback$1(this));
    }

    public final iv i(ou1 ou1Var) {
        p31.f(ou1Var, "onBackPressedCallback");
        this.c.add(ou1Var);
        c cVar = new c(this, ou1Var);
        ou1Var.a(cVar);
        p();
        ou1Var.k(new OnBackPressedDispatcher$addCancellableCallback$1(this));
        return cVar;
    }

    public final void k() {
        Object objPrevious;
        kotlin.collections.c cVar = this.c;
        ListIterator<E> listIterator = cVar.listIterator(cVar.size());
        do {
            if (!listIterator.hasPrevious()) {
                objPrevious = null;
                break;
            }
            objPrevious = listIterator.previous();
        } while (!((ou1) objPrevious).g());
        ou1 ou1Var = (ou1) objPrevious;
        this.d = null;
        if (ou1Var != null) {
            ou1Var.d();
            return;
        }
        Runnable runnable = this.a;
        if (runnable != null) {
            runnable.run();
        }
    }

    public final void n(OnBackInvokedDispatcher onBackInvokedDispatcher) {
        p31.f(onBackInvokedDispatcher, "invoker");
        this.f = onBackInvokedDispatcher;
        o(this.h);
    }

    public OnBackPressedDispatcher(Runnable runnable) {
        this(runnable, null);
    }
}
