package defpackage;

import android.os.Build;
import android.view.View;
import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class jg1 {
    private final d a;
    private final ig1 b;
    private final View c;

    private static class b implements d {
        private OnBackInvokedCallback a;

        private b() {
        }

        @Override // jg1.d
        public void a(View view) {
            OnBackInvokedDispatcher onBackInvokedDispatcherFindOnBackInvokedDispatcher = view.findOnBackInvokedDispatcher();
            if (onBackInvokedDispatcherFindOnBackInvokedDispatcher == null) {
                return;
            }
            onBackInvokedDispatcherFindOnBackInvokedDispatcher.unregisterOnBackInvokedCallback(this.a);
            this.a = null;
        }

        @Override // jg1.d
        public void b(ig1 ig1Var, View view, boolean z) {
            OnBackInvokedDispatcher onBackInvokedDispatcherFindOnBackInvokedDispatcher;
            if (this.a == null && (onBackInvokedDispatcherFindOnBackInvokedDispatcher = view.findOnBackInvokedDispatcher()) != null) {
                OnBackInvokedCallback onBackInvokedCallbackC = c(ig1Var);
                this.a = onBackInvokedCallbackC;
                onBackInvokedDispatcherFindOnBackInvokedDispatcher.registerOnBackInvokedCallback(z ? 1000000 : 0, onBackInvokedCallbackC);
            }
        }

        OnBackInvokedCallback c(final ig1 ig1Var) {
            Objects.requireNonNull(ig1Var);
            return new OnBackInvokedCallback() { // from class: lg1
                public final void onBackInvoked() {
                    ig1Var.a();
                }
            };
        }

        boolean d() {
            return this.a != null;
        }
    }

    private static class c extends b {

        class a implements OnBackAnimationCallback {
            final /* synthetic */ ig1 a;

            a(ig1 ig1Var) {
                this.a = ig1Var;
            }

            public void onBackCancelled() {
                if (c.this.d()) {
                    this.a.d();
                }
            }

            public void onBackInvoked() {
                this.a.a();
            }

            public void onBackProgressed(BackEvent backEvent) {
                if (c.this.d()) {
                    this.a.b(new he(backEvent));
                }
            }

            public void onBackStarted(BackEvent backEvent) {
                if (c.this.d()) {
                    this.a.c(new he(backEvent));
                }
            }
        }

        private c() {
            super();
        }

        @Override // jg1.b
        OnBackInvokedCallback c(ig1 ig1Var) {
            return new a(ig1Var);
        }
    }

    private interface d {
        void a(View view);

        void b(ig1 ig1Var, View view, boolean z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public jg1(View view) {
        this((ig1) view, view);
    }

    private static d a() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 34) {
            return new c();
        }
        if (i >= 33) {
            return new b();
        }
        return null;
    }

    private void d(boolean z) {
        d dVar = this.a;
        if (dVar != null) {
            dVar.b(this.b, this.c, z);
        }
    }

    public boolean b() {
        return this.a != null;
    }

    public void c() {
        d(false);
    }

    public void e() {
        d(true);
    }

    public void f() {
        d dVar = this.a;
        if (dVar != null) {
            dVar.a(this.c);
        }
    }

    public jg1(ig1 ig1Var, View view) {
        this.a = a();
        this.b = ig1Var;
        this.c = view;
    }
}
