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
public abstract class AppBindingBaseDialogFragment<VB extends ViewDataBinding> extends DialogFragment {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final int f427q;
    protected ViewDataBinding r;
    private View s;
    private a t;
    protected Context u;

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

        public final int a() {
            return this.e;
        }

        public final boolean b() {
            return this.f;
        }

        public final float c() {
            return this.g;
        }

        public final int d() {
            return this.d;
        }

        public final int e() {
            return this.c;
        }

        public final int f() {
            return this.a;
        }

        public final int g() {
            return this.b;
        }

        public final int h() {
            return this.h;
        }

        public final int i() {
            return this.i;
        }

        public final boolean j() {
            return this.j;
        }
    }

    private final WindowManager.LayoutParams P(Window window) {
        WindowManager.LayoutParams attributes = window.getAttributes();
        a aVar = this.t;
        p31.c(aVar);
        attributes.dimAmount = aVar.c();
        a aVar2 = this.t;
        p31.c(aVar2);
        attributes.x = aVar2.h();
        a aVar3 = this.t;
        p31.c(aVar3);
        attributes.y = aVar3.i();
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
        ViewDataBinding viewDataBinding = this.r;
        if (viewDataBinding != null) {
            return viewDataBinding;
        }
        p31.t("mBinding");
        return null;
    }

    protected final void R(ViewDataBinding viewDataBinding) {
        p31.f(viewDataBinding, "<set-?>");
        this.r = viewDataBinding;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        p31.f(context, "context");
        super.onAttach(context);
        this.t = N();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        p31.f(dialogInterface, "dialog");
        super.onCancel(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a aVar = this.t;
        p31.c(aVar);
        K(aVar.f(), R.style.DialogStyle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        p31.f(layoutInflater, "inflater");
        this.u = getActivity();
        R(e.e(getLayoutInflater(), this.f427q, viewGroup, false));
        O(bundle, Q().getRoot());
        View root = Q().getRoot();
        this.s = root;
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
            a aVar = this.t;
            p31.c(aVar);
            dialogB.setCanceledOnTouchOutside(aVar.b());
            a aVar2 = this.t;
            p31.c(aVar2);
            dialogB.setCancelable(aVar2.j());
            Window window = dialogB.getWindow();
            if (window != null) {
                a aVar3 = this.t;
                p31.c(aVar3);
                int iG = aVar3.g();
                a aVar4 = this.t;
                p31.c(aVar4);
                window.setLayout(iG, aVar4.e());
                a aVar5 = this.t;
                p31.c(aVar5);
                window.setGravity(aVar5.d());
                a aVar6 = this.t;
                p31.c(aVar6);
                window.setWindowAnimations(aVar6.a());
                window.setAttributes(P(window));
            }
        }
    }
}
