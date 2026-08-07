package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.lifecycle.Lifecycle;
import defpackage.fc1;
import defpackage.g3;
import defpackage.g4;
import defpackage.iq0;
import defpackage.kw1;
import defpackage.li1;
import defpackage.mo2;
import defpackage.ne3;
import defpackage.ov1;
import defpackage.q20;
import defpackage.qu1;
import defpackage.si1;
import defpackage.uv1;
import defpackage.vu1;
import defpackage.xu1;
import defpackage.zj2;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public class FragmentActivity extends ComponentActivity implements g3.e {
    static final String LIFECYCLE_TAG = "android:support:lifecycle";
    boolean mCreated;
    boolean mResumed;
    final d mFragments = d.b(new a());
    final androidx.lifecycle.g mFragmentLifecycleRegistry = new androidx.lifecycle.g(this);
    boolean mStopped = true;

    class a extends f implements vu1, kw1, ov1, uv1, ne3, qu1, g4, zj2, iq0, li1 {
        public a() {
            super(FragmentActivity.this);
        }

        @Override // defpackage.iq0
        public void a(FragmentManager fragmentManager, Fragment fragment) {
            FragmentActivity.this.onAttachFragment(fragment);
        }

        @Override // defpackage.li1
        public void addMenuProvider(si1 si1Var) {
            FragmentActivity.this.addMenuProvider(si1Var);
        }

        @Override // defpackage.vu1
        public void addOnConfigurationChangedListener(q20 q20Var) {
            FragmentActivity.this.addOnConfigurationChangedListener(q20Var);
        }

        @Override // defpackage.ov1
        public void addOnMultiWindowModeChangedListener(q20 q20Var) {
            FragmentActivity.this.addOnMultiWindowModeChangedListener(q20Var);
        }

        @Override // defpackage.uv1
        public void addOnPictureInPictureModeChangedListener(q20 q20Var) {
            FragmentActivity.this.addOnPictureInPictureModeChangedListener(q20Var);
        }

        @Override // defpackage.kw1
        public void addOnTrimMemoryListener(q20 q20Var) {
            FragmentActivity.this.addOnTrimMemoryListener(q20Var);
        }

        @Override // defpackage.tp0
        public View c(int i) {
            return FragmentActivity.this.findViewById(i);
        }

        @Override // defpackage.tp0
        public boolean d() {
            Window window = FragmentActivity.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        @Override // defpackage.g4
        public ActivityResultRegistry getActivityResultRegistry() {
            return FragmentActivity.this.getActivityResultRegistry();
        }

        @Override // defpackage.db1
        public Lifecycle getLifecycle() {
            return FragmentActivity.this.mFragmentLifecycleRegistry;
        }

        @Override // defpackage.qu1
        public OnBackPressedDispatcher getOnBackPressedDispatcher() {
            return FragmentActivity.this.getOnBackPressedDispatcher();
        }

        @Override // defpackage.zj2
        public androidx.savedstate.a getSavedStateRegistry() {
            return FragmentActivity.this.getSavedStateRegistry();
        }

        @Override // defpackage.ne3
        public androidx.lifecycle.r getViewModelStore() {
            return FragmentActivity.this.getViewModelStore();
        }

        @Override // androidx.fragment.app.f
        public void h(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            FragmentActivity.this.dump(str, fileDescriptor, printWriter, strArr);
        }

        @Override // androidx.fragment.app.f
        public LayoutInflater j() {
            return FragmentActivity.this.getLayoutInflater().cloneInContext(FragmentActivity.this);
        }

        @Override // androidx.fragment.app.f
        public boolean l(String str) {
            return g3.v(FragmentActivity.this, str);
        }

        @Override // androidx.fragment.app.f
        public void o() {
            p();
        }

        public void p() {
            FragmentActivity.this.invalidateOptionsMenu();
        }

        @Override // androidx.fragment.app.f
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public FragmentActivity i() {
            return FragmentActivity.this;
        }

        @Override // defpackage.li1
        public void removeMenuProvider(si1 si1Var) {
            FragmentActivity.this.removeMenuProvider(si1Var);
        }

        @Override // defpackage.vu1
        public void removeOnConfigurationChangedListener(q20 q20Var) {
            FragmentActivity.this.removeOnConfigurationChangedListener(q20Var);
        }

        @Override // defpackage.ov1
        public void removeOnMultiWindowModeChangedListener(q20 q20Var) {
            FragmentActivity.this.removeOnMultiWindowModeChangedListener(q20Var);
        }

        @Override // defpackage.uv1
        public void removeOnPictureInPictureModeChangedListener(q20 q20Var) {
            FragmentActivity.this.removeOnPictureInPictureModeChangedListener(q20Var);
        }

        @Override // defpackage.kw1
        public void removeOnTrimMemoryListener(q20 q20Var) {
            FragmentActivity.this.removeOnTrimMemoryListener(q20Var);
        }
    }

    public FragmentActivity() {
        x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A(Intent intent) {
        this.mFragments.m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B(Context context) {
        this.mFragments.a(null);
    }

    private static boolean C(FragmentManager fragmentManager, Lifecycle.State state) {
        boolean zC = false;
        for (Fragment fragment : fragmentManager.u0()) {
            if (fragment != null) {
                if (fragment.getHost() != null) {
                    zC |= C(fragment.getChildFragmentManager(), state);
                }
                q qVar = fragment.mViewLifecycleOwner;
                if (qVar != null && qVar.getLifecycle().b().isAtLeast(Lifecycle.State.STARTED)) {
                    fragment.mViewLifecycleOwner.f(state);
                    zC = true;
                }
                if (fragment.mLifecycleRegistry.b().isAtLeast(Lifecycle.State.STARTED)) {
                    fragment.mLifecycleRegistry.n(state);
                    zC = true;
                }
            }
        }
        return zC;
    }

    private void x() {
        getSavedStateRegistry().h(LIFECYCLE_TAG, new androidx.savedstate.a.c() { // from class: pp0
            @Override // androidx.savedstate.a.c
            public final Bundle a() {
                return this.a.y();
            }
        });
        addOnConfigurationChangedListener(new q20() { // from class: qp0
            @Override // defpackage.q20
            public final void accept(Object obj) {
                this.a.z((Configuration) obj);
            }
        });
        addOnNewIntentListener(new q20() { // from class: rp0
            @Override // defpackage.q20
            public final void accept(Object obj) {
                this.a.A((Intent) obj);
            }
        });
        addOnContextAvailableListener(new xu1() { // from class: sp0
            @Override // defpackage.xu1
            public final void a(Context context) {
                this.a.B(context);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Bundle y() {
        markFragmentsCreated();
        this.mFragmentLifecycleRegistry.i(Lifecycle.Event.ON_STOP);
        return new Bundle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z(Configuration configuration) {
        this.mFragments.m();
    }

    final View dispatchFragmentsOnCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.mFragments.n(view, str, context, attributeSet);
    }

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        if (shouldDumpInternalState(strArr)) {
            printWriter.print(str);
            printWriter.print("Local FragmentActivity ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(" State:");
            String str2 = str + "  ";
            printWriter.print(str2);
            printWriter.print("mCreated=");
            printWriter.print(this.mCreated);
            printWriter.print(" mResumed=");
            printWriter.print(this.mResumed);
            printWriter.print(" mStopped=");
            printWriter.print(this.mStopped);
            if (getApplication() != null) {
                fc1.b(this).a(str2, fileDescriptor, printWriter, strArr);
            }
            this.mFragments.l().X(str, fileDescriptor, printWriter, strArr);
        }
    }

    public FragmentManager getSupportFragmentManager() {
        return this.mFragments.l();
    }

    @Deprecated
    public fc1 getSupportLoaderManager() {
        return fc1.b(this);
    }

    void markFragmentsCreated() {
        while (C(getSupportFragmentManager(), Lifecycle.State.CREATED)) {
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        this.mFragments.m();
        super.onActivityResult(i, i2, intent);
    }

    @Deprecated
    public void onAttachFragment(Fragment fragment) {
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mFragmentLifecycleRegistry.i(Lifecycle.Event.ON_CREATE);
        this.mFragments.e();
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View viewDispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(view, str, context, attributeSet);
        return viewDispatchFragmentsOnCreateView == null ? super.onCreateView(view, str, context, attributeSet) : viewDispatchFragmentsOnCreateView;
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.mFragments.f();
        this.mFragmentLifecycleRegistry.i(Lifecycle.Event.ON_DESTROY);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        if (i == 6) {
            return this.mFragments.d(menuItem);
        }
        return false;
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mResumed = false;
        this.mFragments.g();
        this.mFragmentLifecycleRegistry.i(Lifecycle.Event.ON_PAUSE);
    }

    @Override // android.app.Activity
    protected void onPostResume() {
        super.onPostResume();
        onResumeFragments();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.mFragments.m();
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // android.app.Activity
    protected void onResume() {
        this.mFragments.m();
        super.onResume();
        this.mResumed = true;
        this.mFragments.k();
    }

    protected void onResumeFragments() {
        this.mFragmentLifecycleRegistry.i(Lifecycle.Event.ON_RESUME);
        this.mFragments.h();
    }

    @Override // android.app.Activity
    protected void onStart() {
        this.mFragments.m();
        super.onStart();
        this.mStopped = false;
        if (!this.mCreated) {
            this.mCreated = true;
            this.mFragments.c();
        }
        this.mFragments.k();
        this.mFragmentLifecycleRegistry.i(Lifecycle.Event.ON_START);
        this.mFragments.i();
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.mFragments.m();
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        this.mStopped = true;
        markFragmentsCreated();
        this.mFragments.j();
        this.mFragmentLifecycleRegistry.i(Lifecycle.Event.ON_STOP);
    }

    public void setEnterSharedElementCallback(mo2 mo2Var) {
        g3.t(this, mo2Var);
    }

    public void setExitSharedElementCallback(mo2 mo2Var) {
        g3.u(this, mo2Var);
    }

    public void startActivityFromFragment(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i) {
        startActivityFromFragment(fragment, intent, i, (Bundle) null);
    }

    @Deprecated
    public void startIntentSenderFromFragment(Fragment fragment, @SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        if (i == -1) {
            g3.x(this, intentSender, i, intent, i2, i3, i4, bundle);
        } else {
            fragment.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
        }
    }

    public void supportFinishAfterTransition() {
        g3.o(this);
    }

    @Deprecated
    public void supportInvalidateOptionsMenu() {
        invalidateOptionsMenu();
    }

    public void supportPostponeEnterTransition() {
        g3.q(this);
    }

    public void supportStartPostponedEnterTransition() {
        g3.y(this);
    }

    @Override // g3.e
    @Deprecated
    public final void validateRequestPermissionsRequestCode(int i) {
    }

    public void startActivityFromFragment(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i, Bundle bundle) {
        if (i == -1) {
            g3.w(this, intent, -1, bundle);
        } else {
            fragment.startActivityForResult(intent, i, bundle);
        }
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View viewDispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(null, str, context, attributeSet);
        return viewDispatchFragmentsOnCreateView == null ? super.onCreateView(str, context, attributeSet) : viewDispatchFragmentsOnCreateView;
    }
}
