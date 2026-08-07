package androidx.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.IntentSenderRequest;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ReportFragment;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.m;
import androidx.lifecycle.q;
import androidx.lifecycle.r;
import com.baji.protocol.model.ProtocolConstants;
import defpackage.a4;
import defpackage.b4;
import defpackage.db1;
import defpackage.f4;
import defpackage.fm1;
import defpackage.g3;
import defpackage.g4;
import defpackage.hf3;
import defpackage.hm1;
import defpackage.if3;
import defpackage.jf3;
import defpackage.k83;
import defpackage.kf3;
import defpackage.kw1;
import defpackage.l43;
import defpackage.lf3;
import defpackage.li1;
import defpackage.n30;
import defpackage.ne3;
import defpackage.o30;
import defpackage.oi1;
import defpackage.ov1;
import defpackage.q20;
import defpackage.qu1;
import defpackage.s3;
import defpackage.si1;
import defpackage.uv1;
import defpackage.v40;
import defpackage.vu1;
import defpackage.wq0;
import defpackage.x12;
import defpackage.xq0;
import defpackage.xu1;
import defpackage.yj2;
import defpackage.yq0;
import defpackage.zj2;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class ComponentActivity extends androidx.core.app.ComponentActivity implements n30, db1, ne3, androidx.lifecycle.c, zj2, qu1, g4, vu1, kw1, ov1, uv1, li1, xq0 {
    private static final String ACTIVITY_RESULT_TAG = "android:support:activity-result";
    private final ActivityResultRegistry mActivityResultRegistry;
    private int mContentLayoutId;
    private q.b mDefaultFactory;
    private boolean mDispatchingOnMultiWindowModeChanged;
    private boolean mDispatchingOnPictureInPictureModeChanged;
    final wq0 mFullyDrawnReporter;
    private final AtomicInteger mNextLocalRequestCode;
    private OnBackPressedDispatcher mOnBackPressedDispatcher;
    private final CopyOnWriteArrayList<q20> mOnConfigurationChangedListeners;
    private final CopyOnWriteArrayList<q20> mOnMultiWindowModeChangedListeners;
    private final CopyOnWriteArrayList<q20> mOnNewIntentListeners;
    private final CopyOnWriteArrayList<q20> mOnPictureInPictureModeChangedListeners;
    private final CopyOnWriteArrayList<q20> mOnTrimMemoryListeners;
    final f mReportFullyDrawnExecutor;
    final yj2 mSavedStateRegistryController;
    private r mViewModelStore;
    final o30 mContextAwareHelper = new o30();
    private final oi1 mMenuHostHelper = new oi1(new Runnable() { // from class: x00
        @Override // java.lang.Runnable
        public final void run() {
            this.a.invalidateMenu();
        }
    });
    private final androidx.lifecycle.g mLifecycleRegistry = new androidx.lifecycle.g(this);

    class a extends ActivityResultRegistry {

        /* JADX INFO: renamed from: androidx.activity.ComponentActivity$a$a, reason: collision with other inner class name */
        class RunnableC0000a implements Runnable {
            final /* synthetic */ int a;
            final /* synthetic */ b4.a b;

            RunnableC0000a(int i, b4.a aVar) {
                this.a = i;
                this.b = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.c(this.a, this.b.a());
            }
        }

        class b implements Runnable {
            final /* synthetic */ int a;
            final /* synthetic */ IntentSender.SendIntentException b;

            b(int i, IntentSender.SendIntentException sendIntentException) {
                this.a = i;
                this.b = sendIntentException;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.b(this.a, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", this.b));
            }
        }

        a() {
        }

        @Override // androidx.activity.result.ActivityResultRegistry
        public void f(int i, b4 b4Var, Object obj, s3 s3Var) {
            Bundle bundle;
            ComponentActivity componentActivity = ComponentActivity.this;
            b4.a aVarB = b4Var.b(componentActivity, obj);
            if (aVarB != null) {
                new Handler(Looper.getMainLooper()).post(new RunnableC0000a(i, aVarB));
                return;
            }
            Intent intentA = b4Var.a(componentActivity, obj);
            if (intentA.getExtras() != null && intentA.getExtras().getClassLoader() == null) {
                intentA.setExtrasClassLoader(componentActivity.getClassLoader());
            }
            if (intentA.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
                Bundle bundleExtra = intentA.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                intentA.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                bundle = bundleExtra;
            } else {
                bundle = null;
            }
            if ("androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(intentA.getAction())) {
                String[] stringArrayExtra = intentA.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
                if (stringArrayExtra == null) {
                    stringArrayExtra = new String[0];
                }
                g3.s(componentActivity, stringArrayExtra, i);
                return;
            }
            if (!"androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(intentA.getAction())) {
                g3.w(componentActivity, intentA, i, bundle);
                return;
            }
            IntentSenderRequest intentSenderRequest = (IntentSenderRequest) intentA.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
            try {
                g3.x(componentActivity, intentSenderRequest.d(), i, intentSenderRequest.a(), intentSenderRequest.b(), intentSenderRequest.c(), 0, bundle);
            } catch (IntentSender.SendIntentException e) {
                new Handler(Looper.getMainLooper()).post(new b(i, e));
            }
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ComponentActivity.super.onBackPressed();
            } catch (IllegalStateException e) {
                if (!TextUtils.equals(e.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                    throw e;
                }
            } catch (NullPointerException e2) {
                if (!TextUtils.equals(e2.getMessage(), "Attempt to invoke virtual method 'android.os.Handler android.app.FragmentHostCallback.getHandler()' on a null object reference")) {
                    throw e2;
                }
            }
        }
    }

    static class c {
        static void a(View view) {
            view.cancelPendingInputEvents();
        }
    }

    static class d {
        static OnBackInvokedDispatcher a(Activity activity) {
            return activity.getOnBackInvokedDispatcher();
        }
    }

    static final class e {
        Object a;
        r b;

        e() {
        }
    }

    private interface f extends Executor {
        void n();

        void u(View view);
    }

    class g implements f, ViewTreeObserver.OnDrawListener, Runnable {
        Runnable b;
        final long a = SystemClock.uptimeMillis() + ProtocolConstants.CONNECTION_TIMEOUT_MS;
        boolean c = false;

        g() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            Runnable runnable = this.b;
            if (runnable != null) {
                runnable.run();
                this.b = null;
            }
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.b = runnable;
            View decorView = ComponentActivity.this.getWindow().getDecorView();
            if (!this.c) {
                decorView.postOnAnimation(new Runnable() { // from class: androidx.activity.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.b();
                    }
                });
            } else if (Looper.myLooper() == Looper.getMainLooper()) {
                decorView.invalidate();
            } else {
                decorView.postInvalidate();
            }
        }

        @Override // androidx.activity.ComponentActivity.f
        public void n() {
            ComponentActivity.this.getWindow().getDecorView().removeCallbacks(this);
            ComponentActivity.this.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public void onDraw() {
            Runnable runnable = this.b;
            if (runnable == null) {
                if (SystemClock.uptimeMillis() > this.a) {
                    this.c = false;
                    ComponentActivity.this.getWindow().getDecorView().post(this);
                    return;
                }
                return;
            }
            runnable.run();
            this.b = null;
            if (ComponentActivity.this.mFullyDrawnReporter.d()) {
                this.c = false;
                ComponentActivity.this.getWindow().getDecorView().post(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            ComponentActivity.this.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
        }

        @Override // androidx.activity.ComponentActivity.f
        public void u(View view) {
            if (this.c) {
                return;
            }
            this.c = true;
            view.getViewTreeObserver().addOnDrawListener(this);
        }
    }

    public ComponentActivity() {
        yj2 yj2VarA = yj2.a(this);
        this.mSavedStateRegistryController = yj2VarA;
        this.mOnBackPressedDispatcher = null;
        f fVarP = p();
        this.mReportFullyDrawnExecutor = fVarP;
        this.mFullyDrawnReporter = new wq0(fVarP, new yq0() { // from class: y00
            @Override // defpackage.yq0
            public final Object invoke() {
                return this.a.q();
            }
        });
        this.mNextLocalRequestCode = new AtomicInteger();
        this.mActivityResultRegistry = new a();
        this.mOnConfigurationChangedListeners = new CopyOnWriteArrayList<>();
        this.mOnTrimMemoryListeners = new CopyOnWriteArrayList<>();
        this.mOnNewIntentListeners = new CopyOnWriteArrayList<>();
        this.mOnMultiWindowModeChangedListeners = new CopyOnWriteArrayList<>();
        this.mOnPictureInPictureModeChangedListeners = new CopyOnWriteArrayList<>();
        this.mDispatchingOnMultiWindowModeChanged = false;
        this.mDispatchingOnPictureInPictureModeChanged = false;
        if (getLifecycle() == null) {
            throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
        }
        getLifecycle().a(new androidx.lifecycle.f() { // from class: androidx.activity.ComponentActivity.2
            @Override // androidx.lifecycle.f
            public void c(db1 db1Var, Lifecycle.Event event) {
                if (event == Lifecycle.Event.ON_STOP) {
                    Window window = ComponentActivity.this.getWindow();
                    View viewPeekDecorView = window != null ? window.peekDecorView() : null;
                    if (viewPeekDecorView != null) {
                        c.a(viewPeekDecorView);
                    }
                }
            }
        });
        getLifecycle().a(new androidx.lifecycle.f() { // from class: androidx.activity.ComponentActivity.3
            @Override // androidx.lifecycle.f
            public void c(db1 db1Var, Lifecycle.Event event) {
                if (event == Lifecycle.Event.ON_DESTROY) {
                    ComponentActivity.this.mContextAwareHelper.b();
                    if (!ComponentActivity.this.isChangingConfigurations()) {
                        ComponentActivity.this.getViewModelStore().a();
                    }
                    ComponentActivity.this.mReportFullyDrawnExecutor.n();
                }
            }
        });
        getLifecycle().a(new androidx.lifecycle.f() { // from class: androidx.activity.ComponentActivity.4
            @Override // androidx.lifecycle.f
            public void c(db1 db1Var, Lifecycle.Event event) {
                ComponentActivity.this.ensureViewModelStore();
                ComponentActivity.this.getLifecycle().d(this);
            }
        });
        yj2VarA.c();
        SavedStateHandleSupport.c(this);
        getSavedStateRegistry().h(ACTIVITY_RESULT_TAG, new androidx.savedstate.a.c() { // from class: z00
            @Override // androidx.savedstate.a.c
            public final Bundle a() {
                return this.a.r();
            }
        });
        addOnContextAvailableListener(new xu1() { // from class: a10
            @Override // defpackage.xu1
            public final void a(Context context) {
                this.a.s(context);
            }
        });
    }

    private f p() {
        return new g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ k83 q() {
        reportFullyDrawn();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Bundle r() {
        Bundle bundle = new Bundle();
        this.mActivityResultRegistry.h(bundle);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s(Context context) {
        Bundle bundleB = getSavedStateRegistry().b(ACTIVITY_RESULT_TAG);
        if (bundleB != null) {
            this.mActivityResultRegistry.g(bundleB);
        }
    }

    @Override // android.app.Activity
    public void addContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view, @SuppressLint({"UnknownNullness", "MissingNullability"}) ViewGroup.LayoutParams layoutParams) {
        initializeViewTreeOwners();
        this.mReportFullyDrawnExecutor.u(getWindow().getDecorView());
        super.addContentView(view, layoutParams);
    }

    @Override // defpackage.li1
    public void addMenuProvider(si1 si1Var) {
        this.mMenuHostHelper.c(si1Var);
    }

    @Override // defpackage.vu1
    public final void addOnConfigurationChangedListener(q20 q20Var) {
        this.mOnConfigurationChangedListeners.add(q20Var);
    }

    public final void addOnContextAvailableListener(xu1 xu1Var) {
        this.mContextAwareHelper.a(xu1Var);
    }

    @Override // defpackage.ov1
    public final void addOnMultiWindowModeChangedListener(q20 q20Var) {
        this.mOnMultiWindowModeChangedListeners.add(q20Var);
    }

    public final void addOnNewIntentListener(q20 q20Var) {
        this.mOnNewIntentListeners.add(q20Var);
    }

    @Override // defpackage.uv1
    public final void addOnPictureInPictureModeChangedListener(q20 q20Var) {
        this.mOnPictureInPictureModeChangedListeners.add(q20Var);
    }

    @Override // defpackage.kw1
    public final void addOnTrimMemoryListener(q20 q20Var) {
        this.mOnTrimMemoryListeners.add(q20Var);
    }

    void ensureViewModelStore() {
        if (this.mViewModelStore == null) {
            e eVar = (e) getLastNonConfigurationInstance();
            if (eVar != null) {
                this.mViewModelStore = eVar.b;
            }
            if (this.mViewModelStore == null) {
                this.mViewModelStore = new r();
            }
        }
    }

    @Override // defpackage.g4
    public final ActivityResultRegistry getActivityResultRegistry() {
        return this.mActivityResultRegistry;
    }

    @Override // androidx.lifecycle.c
    public v40 getDefaultViewModelCreationExtras() {
        hm1 hm1Var = new hm1();
        if (getApplication() != null) {
            hm1Var.c(q.a.h, getApplication());
        }
        hm1Var.c(SavedStateHandleSupport.a, this);
        hm1Var.c(SavedStateHandleSupport.b, this);
        if (getIntent() != null && getIntent().getExtras() != null) {
            hm1Var.c(SavedStateHandleSupport.c, getIntent().getExtras());
        }
        return hm1Var;
    }

    @Override // androidx.lifecycle.c
    public q.b getDefaultViewModelProviderFactory() {
        if (this.mDefaultFactory == null) {
            this.mDefaultFactory = new m(getApplication(), this, getIntent() != null ? getIntent().getExtras() : null);
        }
        return this.mDefaultFactory;
    }

    public wq0 getFullyDrawnReporter() {
        return this.mFullyDrawnReporter;
    }

    @Deprecated
    public Object getLastCustomNonConfigurationInstance() {
        e eVar = (e) getLastNonConfigurationInstance();
        if (eVar != null) {
            return eVar.a;
        }
        return null;
    }

    @Override // androidx.core.app.ComponentActivity, defpackage.db1
    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Override // defpackage.qu1
    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        if (this.mOnBackPressedDispatcher == null) {
            this.mOnBackPressedDispatcher = new OnBackPressedDispatcher(new b());
            getLifecycle().a(new androidx.lifecycle.f() { // from class: androidx.activity.ComponentActivity.6
                @Override // androidx.lifecycle.f
                public void c(db1 db1Var, Lifecycle.Event event) {
                    if (event != Lifecycle.Event.ON_CREATE || Build.VERSION.SDK_INT < 33) {
                        return;
                    }
                    ComponentActivity.this.mOnBackPressedDispatcher.n(d.a((ComponentActivity) db1Var));
                }
            });
        }
        return this.mOnBackPressedDispatcher;
    }

    @Override // defpackage.zj2
    public final androidx.savedstate.a getSavedStateRegistry() {
        return this.mSavedStateRegistryController.b();
    }

    @Override // defpackage.ne3
    public r getViewModelStore() {
        if (getApplication() == null) {
            throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        }
        ensureViewModelStore();
        return this.mViewModelStore;
    }

    public void initializeViewTreeOwners() {
        if3.a(getWindow().getDecorView(), this);
        lf3.a(getWindow().getDecorView(), this);
        kf3.a(getWindow().getDecorView(), this);
        jf3.a(getWindow().getDecorView(), this);
        hf3.a(getWindow().getDecorView(), this);
    }

    public void invalidateMenu() {
        invalidateOptionsMenu();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (this.mActivityResultRegistry.b(i, i2, intent)) {
            return;
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity
    @Deprecated
    public void onBackPressed() {
        getOnBackPressedDispatcher().k();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Iterator<q20> it = this.mOnConfigurationChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(configuration);
        }
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        this.mSavedStateRegistryController.d(bundle);
        this.mContextAwareHelper.c(this);
        super.onCreate(bundle);
        ReportFragment.e(this);
        int i = this.mContentLayoutId;
        if (i != 0) {
            setContentView(i);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (i != 0) {
            return true;
        }
        super.onCreatePanelMenu(i, menu);
        this.mMenuHostHelper.h(menu, getMenuInflater());
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        if (i == 0) {
            return this.mMenuHostHelper.j(menuItem);
        }
        return false;
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z) {
        if (this.mDispatchingOnMultiWindowModeChanged) {
            return;
        }
        Iterator<q20> it = this.mOnMultiWindowModeChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(new fm1(z));
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(@SuppressLint({"UnknownNullness", "MissingNullability"}) Intent intent) {
        super.onNewIntent(intent);
        Iterator<q20> it = this.mOnNewIntentListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(intent);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        this.mMenuHostHelper.i(menu);
        super.onPanelClosed(i, menu);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z) {
        if (this.mDispatchingOnPictureInPictureModeChanged) {
            return;
        }
        Iterator<q20> it = this.mOnPictureInPictureModeChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(new x12(z));
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i, View view, Menu menu) {
        if (i != 0) {
            return true;
        }
        super.onPreparePanel(i, view, menu);
        this.mMenuHostHelper.k(menu);
        return true;
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (this.mActivityResultRegistry.b(i, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", iArr))) {
            return;
        }
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Deprecated
    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        e eVar;
        Object objOnRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        r rVar = this.mViewModelStore;
        if (rVar == null && (eVar = (e) getLastNonConfigurationInstance()) != null) {
            rVar = eVar.b;
        }
        if (rVar == null && objOnRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        e eVar2 = new e();
        eVar2.a = objOnRetainCustomNonConfigurationInstance;
        eVar2.b = rVar;
        return eVar2;
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        Lifecycle lifecycle = getLifecycle();
        if (lifecycle instanceof androidx.lifecycle.g) {
            ((androidx.lifecycle.g) lifecycle).n(Lifecycle.State.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.e(bundle);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        Iterator<q20> it = this.mOnTrimMemoryListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(Integer.valueOf(i));
        }
    }

    public Context peekAvailableContext() {
        return this.mContextAwareHelper.d();
    }

    public final <I, O> f4 registerForActivityResult(b4 b4Var, ActivityResultRegistry activityResultRegistry, a4 a4Var) {
        return activityResultRegistry.j("activity_rq#" + this.mNextLocalRequestCode.getAndIncrement(), this, b4Var, a4Var);
    }

    @Override // defpackage.li1
    public void removeMenuProvider(si1 si1Var) {
        this.mMenuHostHelper.l(si1Var);
    }

    @Override // defpackage.vu1
    public final void removeOnConfigurationChangedListener(q20 q20Var) {
        this.mOnConfigurationChangedListeners.remove(q20Var);
    }

    @Override // defpackage.n30
    public final void removeOnContextAvailableListener(xu1 xu1Var) {
        this.mContextAwareHelper.e(xu1Var);
    }

    @Override // defpackage.ov1
    public final void removeOnMultiWindowModeChangedListener(q20 q20Var) {
        this.mOnMultiWindowModeChangedListeners.remove(q20Var);
    }

    public final void removeOnNewIntentListener(q20 q20Var) {
        this.mOnNewIntentListeners.remove(q20Var);
    }

    @Override // defpackage.uv1
    public final void removeOnPictureInPictureModeChangedListener(q20 q20Var) {
        this.mOnPictureInPictureModeChangedListeners.remove(q20Var);
    }

    @Override // defpackage.kw1
    public final void removeOnTrimMemoryListener(q20 q20Var) {
        this.mOnTrimMemoryListeners.remove(q20Var);
    }

    @Override // android.app.Activity
    public void reportFullyDrawn() {
        try {
            if (l43.d()) {
                l43.a("reportFullyDrawn() for ComponentActivity");
            }
            super.reportFullyDrawn();
            this.mFullyDrawnReporter.c();
        } finally {
            l43.b();
        }
    }

    @Override // android.app.Activity
    public void setContentView(int i) {
        initializeViewTreeOwners();
        this.mReportFullyDrawnExecutor.u(getWindow().getDecorView());
        super.setContentView(i);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(Intent intent, int i) {
        super.startActivityForResult(intent, i);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }

    public void addMenuProvider(si1 si1Var, db1 db1Var) {
        this.mMenuHostHelper.d(si1Var, db1Var);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        super.startActivityForResult(intent, i, bundle);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }

    @SuppressLint({"LambdaLast"})
    public void addMenuProvider(si1 si1Var, db1 db1Var, Lifecycle.State state) {
        this.mMenuHostHelper.e(si1Var, db1Var, state);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z, Configuration configuration) {
        this.mDispatchingOnMultiWindowModeChanged = true;
        try {
            super.onMultiWindowModeChanged(z, configuration);
            this.mDispatchingOnMultiWindowModeChanged = false;
            Iterator<q20> it = this.mOnMultiWindowModeChangedListeners.iterator();
            while (it.hasNext()) {
                it.next().accept(new fm1(z, configuration));
            }
        } catch (Throwable th) {
            this.mDispatchingOnMultiWindowModeChanged = false;
            throw th;
        }
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z, Configuration configuration) {
        this.mDispatchingOnPictureInPictureModeChanged = true;
        try {
            super.onPictureInPictureModeChanged(z, configuration);
            this.mDispatchingOnPictureInPictureModeChanged = false;
            Iterator<q20> it = this.mOnPictureInPictureModeChangedListeners.iterator();
            while (it.hasNext()) {
                it.next().accept(new x12(z, configuration));
            }
        } catch (Throwable th) {
            this.mDispatchingOnPictureInPictureModeChanged = false;
            throw th;
        }
    }

    public final <I, O> f4 registerForActivityResult(b4 b4Var, a4 a4Var) {
        return registerForActivityResult(b4Var, this.mActivityResultRegistry, a4Var);
    }

    @Override // android.app.Activity
    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view) {
        initializeViewTreeOwners();
        this.mReportFullyDrawnExecutor.u(getWindow().getDecorView());
        super.setContentView(view);
    }

    @Override // android.app.Activity
    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view, @SuppressLint({"UnknownNullness", "MissingNullability"}) ViewGroup.LayoutParams layoutParams) {
        initializeViewTreeOwners();
        this.mReportFullyDrawnExecutor.u(getWindow().getDecorView());
        super.setContentView(view, layoutParams);
    }
}
