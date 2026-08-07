package com.legend.mywatch.commonlib;

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
import defpackage.wd3;
import defpackage.yd3;

/* JADX INFO: loaded from: classes3.dex */
public abstract class CommonBaseDialogFragment<T extends wd3> extends DialogFragment {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    protected String f284q = getClass().getSimpleName();
    public wd3 r;
    protected View s;
    private a t;
    protected Context u;

    public static class a {
        public int h;
        public int i;
        private int a = 2;
        private int b = -1;
        private int c = -2;
        private int d = 48;
        private int e = R$style.FragmentDialogEmptyAnimation;
        private boolean f = false;
        private float g = 0.5f;
        public boolean j = true;

        public a h(boolean z) {
            this.f = z;
            return this;
        }

        public a i(int i) {
            this.d = i;
            return this;
        }

        public a j(int i) {
            this.b = i;
            return this;
        }
    }

    private WindowManager.LayoutParams P(Window window) {
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = this.t.g;
        a aVar = this.t;
        attributes.x = aVar.h;
        attributes.y = aVar.i;
        return attributes;
    }

    @Override // androidx.fragment.app.DialogFragment
    public void M(FragmentManager fragmentManager, String str) {
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

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.t = N();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        K(this.t.a, R$style.FragmentDialogStyle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.u = getActivity();
        wd3 wd3VarA = yd3.a(this, layoutInflater, viewGroup, false);
        this.r = wd3VarA;
        if (wd3VarA == null) {
            O(bundle, viewGroup);
            return super.onCreateView(layoutInflater, viewGroup, bundle);
        }
        O(bundle, wd3VarA.getRoot());
        View root = this.r.getRoot();
        this.s = root;
        return root;
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
            dialogB.setCanceledOnTouchOutside(this.t.f);
            dialogB.setCancelable(this.t.j);
            Window window = dialogB.getWindow();
            if (window != null) {
                window.setLayout(this.t.b, this.t.c);
                window.setGravity(this.t.d);
                window.setWindowAnimations(this.t.e);
                window.setAttributes(P(window));
            }
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public void y() {
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Dialog dialogB = B();
        if (parentFragmentManager.P0() || dialogB == null || !dialogB.isShowing()) {
            return;
        }
        super.y();
    }
}
