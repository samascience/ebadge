package androidx.appcompat.app;

import android.app.Dialog;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import defpackage.u8;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatDialogFragment extends DialogFragment {
    @Override // androidx.fragment.app.DialogFragment
    public Dialog E(Bundle bundle) {
        return new u8(getContext(), C());
    }

    @Override // androidx.fragment.app.DialogFragment
    public void L(Dialog dialog, int i) {
        if (!(dialog instanceof u8)) {
            super.L(dialog, i);
            return;
        }
        u8 u8Var = (u8) dialog;
        if (i != 1 && i != 2) {
            if (i != 3) {
                return;
            } else {
                dialog.getWindow().addFlags(24);
            }
        }
        u8Var.i(1);
    }
}
