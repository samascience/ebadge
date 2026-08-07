package androidx.preference;

import android.content.DialogInterface;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class MultiSelectListPreferenceDialogFragmentCompat extends PreferenceDialogFragmentCompat {
    CharSequence[] F;
    CharSequence[] G;
    Set y = new HashSet();
    boolean z;

    class a implements DialogInterface.OnMultiChoiceClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnMultiChoiceClickListener
        public void onClick(DialogInterface dialogInterface, int i, boolean z) {
            if (z) {
                MultiSelectListPreferenceDialogFragmentCompat multiSelectListPreferenceDialogFragmentCompat = MultiSelectListPreferenceDialogFragmentCompat.this;
                multiSelectListPreferenceDialogFragmentCompat.z = multiSelectListPreferenceDialogFragmentCompat.y.add(multiSelectListPreferenceDialogFragmentCompat.G[i].toString()) | multiSelectListPreferenceDialogFragmentCompat.z;
            } else {
                MultiSelectListPreferenceDialogFragmentCompat multiSelectListPreferenceDialogFragmentCompat2 = MultiSelectListPreferenceDialogFragmentCompat.this;
                multiSelectListPreferenceDialogFragmentCompat2.z = multiSelectListPreferenceDialogFragmentCompat2.y.remove(multiSelectListPreferenceDialogFragmentCompat2.G[i].toString()) | multiSelectListPreferenceDialogFragmentCompat2.z;
            }
        }
    }

    private MultiSelectListPreference U() {
        return (MultiSelectListPreference) N();
    }

    public static MultiSelectListPreferenceDialogFragmentCompat V(String str) {
        MultiSelectListPreferenceDialogFragmentCompat multiSelectListPreferenceDialogFragmentCompat = new MultiSelectListPreferenceDialogFragmentCompat();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        multiSelectListPreferenceDialogFragmentCompat.setArguments(bundle);
        return multiSelectListPreferenceDialogFragmentCompat;
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat
    public void R(boolean z) {
        if (z && this.z) {
            MultiSelectListPreference multiSelectListPreferenceU = U();
            if (multiSelectListPreferenceU.a(this.y)) {
                multiSelectListPreferenceU.B0(this.y);
            }
        }
        this.z = false;
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat
    protected void S(androidx.appcompat.app.b.a aVar) {
        super.S(aVar);
        int length = this.G.length;
        boolean[] zArr = new boolean[length];
        for (int i = 0; i < length; i++) {
            zArr[i] = this.y.contains(this.G[i].toString());
        }
        aVar.j(this.F, zArr, new a());
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.y.clear();
            this.y.addAll(bundle.getStringArrayList("MultiSelectListPreferenceDialogFragmentCompat.values"));
            this.z = bundle.getBoolean("MultiSelectListPreferenceDialogFragmentCompat.changed", false);
            this.F = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entries");
            this.G = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entryValues");
            return;
        }
        MultiSelectListPreference multiSelectListPreferenceU = U();
        if (multiSelectListPreferenceU.y0() == null || multiSelectListPreferenceU.z0() == null) {
            throw new IllegalStateException("MultiSelectListPreference requires an entries array and an entryValues array.");
        }
        this.y.clear();
        this.y.addAll(multiSelectListPreferenceU.A0());
        this.z = false;
        this.F = multiSelectListPreferenceU.y0();
        this.G = multiSelectListPreferenceU.z0();
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList("MultiSelectListPreferenceDialogFragmentCompat.values", new ArrayList<>(this.y));
        bundle.putBoolean("MultiSelectListPreferenceDialogFragmentCompat.changed", this.z);
        bundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entries", this.F);
        bundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entryValues", this.G);
    }
}
