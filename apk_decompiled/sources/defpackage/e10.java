package defpackage;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.OnBackPressedDispatcher;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.g;
import androidx.savedstate.a;

/* JADX INFO: loaded from: classes.dex */
public class e10 extends Dialog implements db1, qu1, zj2 {
    private g a;
    private final yj2 b;
    private final OnBackPressedDispatcher c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e10(Context context, int i) {
        super(context, i);
        p31.f(context, "context");
        this.b = yj2.d.a(this);
        this.c = new OnBackPressedDispatcher(new Runnable() { // from class: d10
            @Override // java.lang.Runnable
            public final void run() {
                e10.d(this.a);
            }
        });
    }

    private final g b() {
        g gVar = this.a;
        if (gVar != null) {
            return gVar;
        }
        g gVar2 = new g(this);
        this.a = gVar2;
        return gVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(e10 e10Var) {
        p31.f(e10Var, "this$0");
        super.onBackPressed();
    }

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        p31.f(view, "view");
        c();
        super.addContentView(view, layoutParams);
    }

    public void c() {
        Window window = getWindow();
        p31.c(window);
        View decorView = window.getDecorView();
        p31.e(decorView, "window!!.decorView");
        if3.a(decorView, this);
        Window window2 = getWindow();
        p31.c(window2);
        View decorView2 = window2.getDecorView();
        p31.e(decorView2, "window!!.decorView");
        jf3.a(decorView2, this);
        Window window3 = getWindow();
        p31.c(window3);
        View decorView3 = window3.getDecorView();
        p31.e(decorView3, "window!!.decorView");
        kf3.a(decorView3, this);
    }

    @Override // defpackage.db1
    public Lifecycle getLifecycle() {
        return b();
    }

    @Override // defpackage.qu1
    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.c;
    }

    @Override // defpackage.zj2
    public a getSavedStateRegistry() {
        return this.b.b();
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        this.c.k();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 33) {
            OnBackPressedDispatcher onBackPressedDispatcher = this.c;
            OnBackInvokedDispatcher onBackInvokedDispatcher = getOnBackInvokedDispatcher();
            p31.e(onBackInvokedDispatcher, "onBackInvokedDispatcher");
            onBackPressedDispatcher.n(onBackInvokedDispatcher);
        }
        this.b.d(bundle);
        b().i(Lifecycle.Event.ON_CREATE);
    }

    @Override // android.app.Dialog
    public Bundle onSaveInstanceState() {
        Bundle bundleOnSaveInstanceState = super.onSaveInstanceState();
        p31.e(bundleOnSaveInstanceState, "super.onSaveInstanceState()");
        this.b.e(bundleOnSaveInstanceState);
        return bundleOnSaveInstanceState;
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        b().i(Lifecycle.Event.ON_RESUME);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        b().i(Lifecycle.Event.ON_DESTROY);
        this.a = null;
        super.onStop();
    }

    @Override // android.app.Dialog
    public void setContentView(int i) {
        c();
        super.setContentView(i);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        p31.f(view, "view");
        c();
        super.setContentView(view);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        p31.f(view, "view");
        c();
        super.setContentView(view, layoutParams);
    }
}
