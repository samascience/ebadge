package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.lifecycle.k;
import defpackage.db1;
import defpackage.p31;
import defpackage.y70;
import defpackage.zf0;

/* JADX INFO: loaded from: classes.dex */
public final class k implements db1 {
    public static final b i = new b(null);
    private static final k j = new k();
    private int a;
    private int b;
    private Handler e;
    private boolean c = true;
    private boolean d = true;
    private final g f = new g(this);
    private final Runnable g = new Runnable() { // from class: v62
        @Override // java.lang.Runnable
        public final void run() {
            k.i(this.a);
        }
    };
    private final ReportFragment.a h = new d();

    public static final class a {
        public static final a a = new a();

        private a() {
        }

        public static final void a(Activity activity, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
            p31.f(activity, "activity");
            p31.f(activityLifecycleCallbacks, "callback");
            activity.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
    }

    public static final class b {
        public /* synthetic */ b(y70 y70Var) {
            this();
        }

        public final db1 a() {
            return k.j;
        }

        public final void b(Context context) {
            p31.f(context, "context");
            k.j.h(context);
        }

        private b() {
        }
    }

    public static final class c extends zf0 {

        public static final class a extends zf0 {
            final /* synthetic */ k this$0;

            a(k kVar) {
                this.this$0 = kVar;
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPostResumed(Activity activity) {
                p31.f(activity, "activity");
                this.this$0.e();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPostStarted(Activity activity) {
                p31.f(activity, "activity");
                this.this$0.f();
            }
        }

        c() {
        }

        @Override // defpackage.zf0, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            p31.f(activity, "activity");
            if (Build.VERSION.SDK_INT < 29) {
                ReportFragment.b.b(activity).f(k.this.h);
            }
        }

        @Override // defpackage.zf0, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            p31.f(activity, "activity");
            k.this.d();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreCreated(Activity activity, Bundle bundle) {
            p31.f(activity, "activity");
            a.a(activity, new a(k.this));
        }

        @Override // defpackage.zf0, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            p31.f(activity, "activity");
            k.this.g();
        }
    }

    public static final class d implements ReportFragment.a {
        d() {
        }

        @Override // androidx.lifecycle.ReportFragment.a
        public void a() {
        }

        @Override // androidx.lifecycle.ReportFragment.a
        public void b() {
            k.this.e();
        }

        @Override // androidx.lifecycle.ReportFragment.a
        public void onStart() {
            k.this.f();
        }
    }

    private k() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(k kVar) {
        p31.f(kVar, "this$0");
        kVar.j();
        kVar.k();
    }

    public final void d() {
        int i2 = this.b - 1;
        this.b = i2;
        if (i2 == 0) {
            Handler handler = this.e;
            p31.c(handler);
            handler.postDelayed(this.g, 700L);
        }
    }

    public final void e() {
        int i2 = this.b + 1;
        this.b = i2;
        if (i2 == 1) {
            if (this.c) {
                this.f.i(Lifecycle.Event.ON_RESUME);
                this.c = false;
            } else {
                Handler handler = this.e;
                p31.c(handler);
                handler.removeCallbacks(this.g);
            }
        }
    }

    public final void f() {
        int i2 = this.a + 1;
        this.a = i2;
        if (i2 == 1 && this.d) {
            this.f.i(Lifecycle.Event.ON_START);
            this.d = false;
        }
    }

    public final void g() {
        this.a--;
        k();
    }

    @Override // defpackage.db1
    public Lifecycle getLifecycle() {
        return this.f;
    }

    public final void h(Context context) {
        p31.f(context, "context");
        this.e = new Handler();
        this.f.i(Lifecycle.Event.ON_CREATE);
        Context applicationContext = context.getApplicationContext();
        p31.d(applicationContext, "null cannot be cast to non-null type android.app.Application");
        ((Application) applicationContext).registerActivityLifecycleCallbacks(new c());
    }

    public final void j() {
        if (this.b == 0) {
            this.c = true;
            this.f.i(Lifecycle.Event.ON_PAUSE);
        }
    }

    public final void k() {
        if (this.a == 0 && this.c) {
            this.f.i(Lifecycle.Event.ON_STOP);
            this.d = true;
        }
    }
}
