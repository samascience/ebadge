package androidx.fragment.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import defpackage.db1;
import defpackage.e10;
import defpackage.if3;
import defpackage.kf3;
import defpackage.lf3;
import defpackage.tp0;
import defpackage.vt1;

/* JADX INFO: loaded from: classes.dex */
public class DialogFragment extends Fragment implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    private Handler a;
    private boolean j;
    private Dialog l;
    private boolean m;
    private boolean n;
    private boolean o;
    private Runnable b = new a();
    private DialogInterface.OnCancelListener c = new b();
    private DialogInterface.OnDismissListener d = new c();
    private int e = 0;
    private int f = 0;
    private boolean g = true;
    private boolean h = true;
    private int i = -1;
    private vt1 k = new d();
    private boolean p = false;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DialogFragment.this.d.onDismiss(DialogFragment.this.l);
        }
    }

    class b implements DialogInterface.OnCancelListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (DialogFragment.this.l != null) {
                DialogFragment dialogFragment = DialogFragment.this;
                dialogFragment.onCancel(dialogFragment.l);
            }
        }
    }

    class c implements DialogInterface.OnDismissListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (DialogFragment.this.l != null) {
                DialogFragment dialogFragment = DialogFragment.this;
                dialogFragment.onDismiss(dialogFragment.l);
            }
        }
    }

    class d implements vt1 {
        d() {
        }

        @Override // defpackage.vt1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(db1 db1Var) {
            if (db1Var == null || !DialogFragment.this.h) {
                return;
            }
            View viewRequireView = DialogFragment.this.requireView();
            if (viewRequireView.getParent() != null) {
                throw new IllegalStateException("DialogFragment can not be attached to a container view");
            }
            if (DialogFragment.this.l != null) {
                if (FragmentManager.I0(3)) {
                    Log.d("FragmentManager", "DialogFragment " + this + " setting the content view on " + DialogFragment.this.l);
                }
                DialogFragment.this.l.setContentView(viewRequireView);
            }
        }
    }

    class e extends tp0 {
        final /* synthetic */ tp0 a;

        e(tp0 tp0Var) {
            this.a = tp0Var;
        }

        @Override // defpackage.tp0
        public View c(int i) {
            return this.a.d() ? this.a.c(i) : DialogFragment.this.F(i);
        }

        @Override // defpackage.tp0
        public boolean d() {
            return this.a.d() || DialogFragment.this.G();
        }
    }

    private void A(boolean z, boolean z2, boolean z3) {
        if (this.n) {
            return;
        }
        this.n = true;
        this.o = false;
        Dialog dialog = this.l;
        if (dialog != null) {
            dialog.setOnDismissListener(null);
            this.l.dismiss();
            if (!z2) {
                if (Looper.myLooper() == this.a.getLooper()) {
                    onDismiss(this.l);
                } else {
                    this.a.post(this.b);
                }
            }
        }
        this.m = true;
        if (this.i >= 0) {
            if (z3) {
                getParentFragmentManager().e1(this.i, 1);
            } else {
                getParentFragmentManager().c1(this.i, 1, z);
            }
            this.i = -1;
            return;
        }
        m mVarP = getParentFragmentManager().p();
        mVarP.s(true);
        mVarP.o(this);
        if (z3) {
            mVarP.j();
        } else if (z) {
            mVarP.i();
        } else {
            mVarP.h();
        }
    }

    private void H(Bundle bundle) {
        if (this.h && !this.p) {
            try {
                this.j = true;
                Dialog dialogE = E(bundle);
                this.l = dialogE;
                if (this.h) {
                    L(dialogE, this.e);
                    Context context = getContext();
                    if (context instanceof Activity) {
                        this.l.setOwnerActivity((Activity) context);
                    }
                    this.l.setCancelable(this.g);
                    this.l.setOnCancelListener(this.c);
                    this.l.setOnDismissListener(this.d);
                    this.p = true;
                } else {
                    this.l = null;
                }
            } finally {
                this.j = false;
            }
        }
    }

    public Dialog B() {
        return this.l;
    }

    public int C() {
        return this.f;
    }

    public boolean D() {
        return this.g;
    }

    public Dialog E(Bundle bundle) {
        if (FragmentManager.I0(3)) {
            Log.d("FragmentManager", "onCreateDialog called for DialogFragment " + this);
        }
        return new e10(requireContext(), C());
    }

    View F(int i) {
        Dialog dialog = this.l;
        if (dialog != null) {
            return dialog.findViewById(i);
        }
        return null;
    }

    boolean G() {
        return this.p;
    }

    public final Dialog I() {
        Dialog dialogB = B();
        if (dialogB != null) {
            return dialogB;
        }
        throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
    }

    public void J(boolean z) {
        this.h = z;
    }

    public void K(int i, int i2) {
        if (FragmentManager.I0(2)) {
            Log.d("FragmentManager", "Setting style and theme for DialogFragment " + this + " to " + i + ", " + i2);
        }
        this.e = i;
        if (i == 2 || i == 3) {
            this.f = R.style.Theme.Panel;
        }
        if (i2 != 0) {
            this.f = i2;
        }
    }

    public void L(Dialog dialog, int i) {
        if (i != 1 && i != 2) {
            if (i != 3) {
                return;
            }
            Window window = dialog.getWindow();
            if (window != null) {
                window.addFlags(24);
            }
        }
        dialog.requestWindowFeature(1);
    }

    public void M(FragmentManager fragmentManager, String str) {
        this.n = false;
        this.o = true;
        m mVarP = fragmentManager.p();
        mVarP.s(true);
        mVarP.d(this, str);
        mVarP.h();
    }

    @Override // androidx.fragment.app.Fragment
    tp0 createFragmentContainer() {
        return new e(super.createFragmentContainer());
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        getViewLifecycleOwnerLiveData().j(this.k);
        if (this.o) {
            return;
        }
        this.n = false;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = new Handler();
        this.h = this.mContainerId == 0;
        if (bundle != null) {
            this.e = bundle.getInt("android:style", 0);
            this.f = bundle.getInt("android:theme", 0);
            this.g = bundle.getBoolean("android:cancelable", true);
            this.h = bundle.getBoolean("android:showsDialog", this.h);
            this.i = bundle.getInt("android:backStackId", -1);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        Dialog dialog = this.l;
        if (dialog != null) {
            this.m = true;
            dialog.setOnDismissListener(null);
            this.l.dismiss();
            if (!this.n) {
                onDismiss(this.l);
            }
            this.l = null;
            this.p = false;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (!this.o && !this.n) {
            this.n = true;
        }
        getViewLifecycleOwnerLiveData().n(this.k);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.m) {
            return;
        }
        if (FragmentManager.I0(3)) {
            Log.d("FragmentManager", "onDismiss called for DialogFragment " + this);
        }
        A(true, true, false);
    }

    @Override // androidx.fragment.app.Fragment
    public LayoutInflater onGetLayoutInflater(Bundle bundle) {
        LayoutInflater layoutInflaterOnGetLayoutInflater = super.onGetLayoutInflater(bundle);
        if (this.h && !this.j) {
            H(bundle);
            if (FragmentManager.I0(2)) {
                Log.d("FragmentManager", "get layout inflater for DialogFragment " + this + " from dialog context");
            }
            Dialog dialog = this.l;
            return dialog != null ? layoutInflaterOnGetLayoutInflater.cloneInContext(dialog.getContext()) : layoutInflaterOnGetLayoutInflater;
        }
        if (FragmentManager.I0(2)) {
            String str = "getting layout inflater for DialogFragment " + this;
            if (this.h) {
                Log.d("FragmentManager", "mCreatingDialog = true: " + str);
            } else {
                Log.d("FragmentManager", "mShowsDialog = false: " + str);
            }
        }
        return layoutInflaterOnGetLayoutInflater;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Dialog dialog = this.l;
        if (dialog != null) {
            Bundle bundleOnSaveInstanceState = dialog.onSaveInstanceState();
            bundleOnSaveInstanceState.putBoolean("android:dialogShowing", false);
            bundle.putBundle("android:savedDialogState", bundleOnSaveInstanceState);
        }
        int i = this.e;
        if (i != 0) {
            bundle.putInt("android:style", i);
        }
        int i2 = this.f;
        if (i2 != 0) {
            bundle.putInt("android:theme", i2);
        }
        boolean z = this.g;
        if (!z) {
            bundle.putBoolean("android:cancelable", z);
        }
        boolean z2 = this.h;
        if (!z2) {
            bundle.putBoolean("android:showsDialog", z2);
        }
        int i3 = this.i;
        if (i3 != -1) {
            bundle.putInt("android:backStackId", i3);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog dialog = this.l;
        if (dialog != null) {
            this.m = false;
            dialog.show();
            View decorView = this.l.getWindow().getDecorView();
            if3.a(decorView, this);
            lf3.a(decorView, this);
            kf3.a(decorView, this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        Dialog dialog = this.l;
        if (dialog != null) {
            dialog.hide();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle bundle) {
        Bundle bundle2;
        super.onViewStateRestored(bundle);
        if (this.l == null || bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
            return;
        }
        this.l.onRestoreInstanceState(bundle2);
    }

    @Override // androidx.fragment.app.Fragment
    void performCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle bundle2;
        super.performCreateView(layoutInflater, viewGroup, bundle);
        if (this.mView != null || this.l == null || bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
            return;
        }
        this.l.onRestoreInstanceState(bundle2);
    }

    public void y() {
        A(false, false, false);
    }

    public void z() {
        A(true, false, false);
    }
}
