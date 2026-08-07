package androidx.fragment.app;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.SavedStateHandleSupport;
import defpackage.hm1;
import defpackage.ne3;
import defpackage.v40;
import defpackage.yj2;
import defpackage.zj2;

/* JADX INFO: loaded from: classes.dex */
class q implements androidx.lifecycle.c, zj2, ne3 {
    private final Fragment a;
    private final androidx.lifecycle.r b;
    private androidx.lifecycle.q.b c;
    private androidx.lifecycle.g d = null;
    private yj2 e = null;

    q(Fragment fragment, androidx.lifecycle.r rVar) {
        this.a = fragment;
        this.b = rVar;
    }

    void a(Lifecycle.Event event) {
        this.d.i(event);
    }

    void b() {
        if (this.d == null) {
            this.d = new androidx.lifecycle.g(this);
            yj2 yj2VarA = yj2.a(this);
            this.e = yj2VarA;
            yj2VarA.c();
            SavedStateHandleSupport.c(this);
        }
    }

    boolean c() {
        return this.d != null;
    }

    void d(Bundle bundle) {
        this.e.d(bundle);
    }

    void e(Bundle bundle) {
        this.e.e(bundle);
    }

    void f(Lifecycle.State state) {
        this.d.n(state);
    }

    @Override // androidx.lifecycle.c
    public v40 getDefaultViewModelCreationExtras() {
        Application application;
        Context applicationContext = this.a.requireContext().getApplicationContext();
        while (true) {
            if (!(applicationContext instanceof ContextWrapper)) {
                application = null;
                break;
            }
            if (applicationContext instanceof Application) {
                application = (Application) applicationContext;
                break;
            }
            applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
        }
        hm1 hm1Var = new hm1();
        if (application != null) {
            hm1Var.c(androidx.lifecycle.q.a.h, application);
        }
        hm1Var.c(SavedStateHandleSupport.a, this);
        hm1Var.c(SavedStateHandleSupport.b, this);
        if (this.a.getArguments() != null) {
            hm1Var.c(SavedStateHandleSupport.c, this.a.getArguments());
        }
        return hm1Var;
    }

    @Override // androidx.lifecycle.c
    public androidx.lifecycle.q.b getDefaultViewModelProviderFactory() {
        Application application;
        androidx.lifecycle.q.b defaultViewModelProviderFactory = this.a.getDefaultViewModelProviderFactory();
        if (!defaultViewModelProviderFactory.equals(this.a.mDefaultFactory)) {
            this.c = defaultViewModelProviderFactory;
            return defaultViewModelProviderFactory;
        }
        if (this.c == null) {
            Context applicationContext = this.a.requireContext().getApplicationContext();
            while (true) {
                if (!(applicationContext instanceof ContextWrapper)) {
                    application = null;
                    break;
                }
                if (applicationContext instanceof Application) {
                    application = (Application) applicationContext;
                    break;
                }
                applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
            }
            this.c = new androidx.lifecycle.m(application, this, this.a.getArguments());
        }
        return this.c;
    }

    @Override // defpackage.db1
    public Lifecycle getLifecycle() {
        b();
        return this.d;
    }

    @Override // defpackage.zj2
    public androidx.savedstate.a getSavedStateRegistry() {
        b();
        return this.e.b();
    }

    @Override // defpackage.ne3
    public androidx.lifecycle.r getViewModelStore() {
        b();
        return this.b;
    }
}
