package com.google.android.gms.common;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import defpackage.a52;

/* JADX INFO: loaded from: classes.dex */
public class SupportErrorDialogFragment extends DialogFragment {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Dialog f238q = null;
    private DialogInterface.OnCancelListener r = null;

    public static SupportErrorDialogFragment N(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        SupportErrorDialogFragment supportErrorDialogFragment = new SupportErrorDialogFragment();
        Dialog dialog2 = (Dialog) a52.h(dialog, "Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        supportErrorDialogFragment.f238q = dialog2;
        if (onCancelListener != null) {
            supportErrorDialogFragment.r = onCancelListener;
        }
        return supportErrorDialogFragment;
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog E(Bundle bundle) {
        if (this.f238q == null) {
            J(false);
        }
        return this.f238q;
    }

    @Override // androidx.fragment.app.DialogFragment
    public void M(FragmentManager fragmentManager, String str) {
        super.M(fragmentManager, str);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.r;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }
}
