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
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.legend.smartwatch.electronicbadge.android.R;

/* JADX INFO: loaded from: classes4.dex */
public abstract class BaseDialogFragment extends DialogFragment {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private a f428q;

    public static class a {
        public int h;
        public int i;
        private int a = 2;
        private int b = -1;
        private int c = -2;
        private int d = 48;
        private int e = R.style.DialogEmptyAnimation;
        private boolean f = false;
        private float g = 0.5f;
        public boolean j = true;

        public a h(int i) {
            this.e = i;
            return this;
        }

        public a i(boolean z) {
            this.f = z;
            return this;
        }

        public a j(float f) {
            this.g = f;
            return this;
        }

        public a k(int i) {
            this.d = i;
            return this;
        }

        public a l(int i) {
            this.b = i;
            return this;
        }
    }

    private WindowManager.LayoutParams Q(Window window) {
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = this.f428q.g;
        a aVar = this.f428q;
        attributes.x = aVar.h;
        attributes.y = aVar.i;
        return attributes;
    }

    @Override // androidx.fragment.app.DialogFragment
    public void M(FragmentManager fragmentManager, String str) {
        if (fragmentManager.H0()) {
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

    public abstract int P();

    protected void R(View view) {
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.f428q = N();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        K(this.f428q.a, R.style.DialogStyle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(P(), viewGroup, false);
        R(viewInflate);
        O(bundle, viewInflate);
        return viewInflate;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog dialogB = B();
        if (dialogB != null) {
            dialogB.setCanceledOnTouchOutside(this.f428q.f);
            dialogB.setCancelable(this.f428q.j);
            Window window = dialogB.getWindow();
            if (window != null) {
                window.setLayout(this.f428q.b, this.f428q.c);
                window.setGravity(this.f428q.d);
                window.setWindowAnimations(this.f428q.e);
                window.setAttributes(Q(window));
            }
        }
    }
}
