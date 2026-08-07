package xfkj.fitpro.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.legend.smartwatch.electronicbadge.android.R;
import defpackage.p31;

/* JADX INFO: loaded from: classes4.dex */
public abstract class BindingBaseDialogFragment<VB extends ViewDataBinding> extends DialogFragment {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final int f429q;
    private String r;
    protected ViewDataBinding s;
    private View t;
    private a u;
    protected Context v;

    public static final class a {
        private boolean f;
        private int h;
        private int i;
        private int a = 2;
        private int b = -1;
        private int c = -2;
        private int d = 48;
        private int e = R.style.DialogEmptyAnimation;
        private float g = 0.5f;
        private boolean j = true;

        public final a a(boolean z) {
            this.f = z;
            return this;
        }

        public final int b() {
            return this.e;
        }

        public final boolean c() {
            return this.f;
        }

        public final float d() {
            return this.g;
        }

        public final int e() {
            return this.d;
        }

        public final int f() {
            return this.c;
        }

        public final int g() {
            return this.a;
        }

        public final int h() {
            return this.b;
        }

        public final int i() {
            return this.h;
        }

        public final int j() {
            return this.i;
        }

        public final a k(int i) {
            this.d = i;
            return this;
        }

        public final boolean l() {
            return this.j;
        }

        public final a m(int i) {
            this.b = i;
            return this;
        }
    }

    public BindingBaseDialogFragment(int i) {
        this.f429q = i;
        String simpleName = getClass().getSimpleName();
        p31.e(simpleName, "getSimpleName(...)");
        this.r = simpleName;
    }

    private final WindowManager.LayoutParams P(Window window) {
        WindowManager.LayoutParams attributes = window.getAttributes();
        a aVar = this.u;
        p31.c(aVar);
        attributes.dimAmount = aVar.d();
        a aVar2 = this.u;
        p31.c(aVar2);
        attributes.x = aVar2.i();
        a aVar3 = this.u;
        p31.c(aVar3);
        attributes.y = aVar3.j();
        p31.c(attributes);
        return attributes;
    }

    @Override // androidx.fragment.app.DialogFragment
    public void M(FragmentManager fragmentManager, String str) {
        p31.f(fragmentManager, "manager");
        if (fragmentManager.H0() || fragmentManager.P0()) {
            return;
        }
        try {
            fragmentManager.p().o(this).h();
            super.M(fragmentManager, str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected a N() {
        return new a();
    }

    public abstract void O(Bundle bundle, View view);

    protected final ViewDataBinding Q() {
        ViewDataBinding viewDataBinding = this.s;
        if (viewDataBinding != null) {
            return viewDataBinding;
        }
        p31.t("mBinding");
        return null;
    }

    protected final void R(ViewDataBinding viewDataBinding) {
        p31.f(viewDataBinding, "<set-?>");
        this.s = viewDataBinding;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        p31.f(context, "context");
        super.onAttach(context);
        this.u = N();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        p31.f(dialogInterface, "dialog");
        super.onCancel(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a aVar = this.u;
        p31.c(aVar);
        K(aVar.g(), R.style.DialogStyle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        p31.f(layoutInflater, "inflater");
        this.v = getActivity();
        R(e.e(getLayoutInflater(), this.f429q, viewGroup, false));
        O(bundle, Q().getRoot());
        View root = Q().getRoot();
        this.t = root;
        return root;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        p31.f(dialogInterface, "dialog");
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog dialogB = B();
        if (dialogB != null) {
            a aVar = this.u;
            p31.c(aVar);
            dialogB.setCanceledOnTouchOutside(aVar.c());
            a aVar2 = this.u;
            p31.c(aVar2);
            dialogB.setCancelable(aVar2.l());
            Window window = dialogB.getWindow();
            if (window != null) {
                a aVar3 = this.u;
                p31.c(aVar3);
                int iH = aVar3.h();
                a aVar4 = this.u;
                p31.c(aVar4);
                window.setLayout(iH, aVar4.f());
                a aVar5 = this.u;
                p31.c(aVar5);
                window.setGravity(aVar5.e());
                a aVar6 = this.u;
                p31.c(aVar6);
                window.setWindowAnimations(aVar6.b());
                window.setAttributes(P(window));
            }
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public void y() {
        FragmentManager parentFragmentManager = getParentFragmentManager();
        p31.e(parentFragmentManager, "getParentFragmentManager(...)");
        if (parentFragmentManager.P0()) {
            return;
        }
        super.y();
    }
}
