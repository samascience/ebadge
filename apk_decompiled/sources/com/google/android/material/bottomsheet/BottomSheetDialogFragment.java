package com.google.android.material.bottomsheet;

import android.app.Dialog;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatDialogFragment;

/* JADX INFO: loaded from: classes3.dex */
public class BottomSheetDialogFragment extends AppCompatDialogFragment {
    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog E(Bundle bundle) {
        return new a(getContext(), C());
    }
}
