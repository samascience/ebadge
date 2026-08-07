package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.app.LocaleManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.app.c;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.g0;
import defpackage.c9;
import defpackage.m8;
import defpackage.r2;
import defpackage.tc1;
import defpackage.u2;
import defpackage.y9;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {
    static ExecutorC0003c a = new ExecutorC0003c(new d());
    private static int b = -100;
    private static tc1 c = null;
    private static tc1 d = null;
    private static Boolean e = null;
    private static boolean f = false;
    private static final y9 g = new y9();
    private static final Object h = new Object();
    private static final Object i = new Object();

    static class a {
        static LocaleList a(String str) {
            return LocaleList.forLanguageTags(str);
        }
    }

    static class b {
        static LocaleList a(Object obj) {
            return ((LocaleManager) obj).getApplicationLocales();
        }

        static void b(Object obj, LocaleList localeList) {
            ((LocaleManager) obj).setApplicationLocales(localeList);
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.c$c, reason: collision with other inner class name */
    static class ExecutorC0003c implements Executor {
        private final Object a = new Object();
        final Queue b = new ArrayDeque();
        final Executor c;
        Runnable d;

        ExecutorC0003c(Executor executor) {
            this.c = executor;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(Runnable runnable) {
            try {
                runnable.run();
            } finally {
                c();
            }
        }

        protected void c() {
            synchronized (this.a) {
                try {
                    Runnable runnable = (Runnable) this.b.poll();
                    this.d = runnable;
                    if (runnable != null) {
                        this.c.execute(runnable);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // java.util.concurrent.Executor
        public void execute(final Runnable runnable) {
            synchronized (this.a) {
                try {
                    this.b.add(new Runnable() { // from class: androidx.appcompat.app.d
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.a.b(runnable);
                        }
                    });
                    if (this.d == null) {
                        c();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    static class d implements Executor {
        d() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            new Thread(runnable).start();
        }
    }

    c() {
    }

    static void F(c cVar) {
        synchronized (h) {
            G(cVar);
        }
    }

    private static void G(c cVar) {
        synchronized (h) {
            try {
                Iterator it = g.iterator();
                while (it.hasNext()) {
                    c cVar2 = (c) ((WeakReference) it.next()).get();
                    if (cVar2 == cVar || cVar2 == null) {
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void I(boolean z) {
        g0.c(z);
    }

    static void R(Context context) {
        if (Build.VERSION.SDK_INT >= 33) {
            ComponentName componentName = new ComponentName(context, "androidx.appcompat.app.AppLocalesMetadataHolderService");
            if (context.getPackageManager().getComponentEnabledSetting(componentName) != 1) {
                if (k().e()) {
                    String strB = c9.b(context);
                    Object systemService = context.getSystemService("locale");
                    if (systemService != null) {
                        b.b(systemService, a.a(strB));
                    }
                }
                context.getPackageManager().setComponentEnabledSetting(componentName, 1, 1);
            }
        }
    }

    static void S(final Context context) {
        if (v(context)) {
            if (Build.VERSION.SDK_INT >= 33) {
                if (f) {
                    return;
                }
                a.execute(new Runnable() { // from class: n8
                    @Override // java.lang.Runnable
                    public final void run() {
                        c.w(context);
                    }
                });
                return;
            }
            synchronized (i) {
                try {
                    tc1 tc1Var = c;
                    if (tc1Var == null) {
                        if (d == null) {
                            d = tc1.b(c9.b(context));
                        }
                        if (d.e()) {
                        } else {
                            c = d;
                        }
                    } else if (!tc1Var.equals(d)) {
                        tc1 tc1Var2 = c;
                        d = tc1Var2;
                        c9.a(context, tc1Var2.g());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    static void d(c cVar) {
        synchronized (h) {
            G(cVar);
            g.add(new WeakReference(cVar));
        }
    }

    public static c h(Activity activity, m8 m8Var) {
        return new AppCompatDelegateImpl(activity, m8Var);
    }

    public static c i(Dialog dialog, m8 m8Var) {
        return new AppCompatDelegateImpl(dialog, m8Var);
    }

    public static tc1 k() {
        if (Build.VERSION.SDK_INT >= 33) {
            Object objP = p();
            if (objP != null) {
                return tc1.h(b.a(objP));
            }
        } else {
            tc1 tc1Var = c;
            if (tc1Var != null) {
                return tc1Var;
            }
        }
        return tc1.d();
    }

    public static int m() {
        return b;
    }

    static Object p() {
        Context contextL;
        Iterator it = g.iterator();
        while (it.hasNext()) {
            c cVar = (c) ((WeakReference) it.next()).get();
            if (cVar != null && (contextL = cVar.l()) != null) {
                return contextL.getSystemService("locale");
            }
        }
        return null;
    }

    static tc1 r() {
        return c;
    }

    static boolean v(Context context) {
        if (e == null) {
            try {
                Bundle bundle = AppLocalesMetadataHolderService.a(context).metaData;
                if (bundle != null) {
                    e = Boolean.valueOf(bundle.getBoolean("autoStoreLocales"));
                }
            } catch (PackageManager.NameNotFoundException unused) {
                Log.d("AppCompatDelegate", "Checking for metadata for AppLocalesMetadataHolderService : Service not found");
                e = Boolean.FALSE;
            }
        }
        return e.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void w(Context context) {
        R(context);
        f = true;
    }

    public abstract void A(Bundle bundle);

    public abstract void B();

    public abstract void C(Bundle bundle);

    public abstract void D();

    public abstract void E();

    public abstract boolean H(int i2);

    public abstract void J(int i2);

    public abstract void K(View view);

    public abstract void L(View view, ViewGroup.LayoutParams layoutParams);

    public void M(OnBackInvokedDispatcher onBackInvokedDispatcher) {
    }

    public abstract void N(Toolbar toolbar);

    public abstract void O(int i2);

    public abstract void P(CharSequence charSequence);

    public abstract u2 Q(u2.a aVar);

    public abstract void e(View view, ViewGroup.LayoutParams layoutParams);

    public void f(Context context) {
    }

    public Context g(Context context) {
        f(context);
        return context;
    }

    public abstract View j(int i2);

    public abstract Context l();

    public abstract r2 n();

    public abstract int o();

    public abstract MenuInflater q();

    public abstract androidx.appcompat.app.a s();

    public abstract void t();

    public abstract void u();

    public abstract void x(Configuration configuration);

    public abstract void y(Bundle bundle);

    public abstract void z();
}
