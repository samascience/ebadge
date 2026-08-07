package androidx.preference;

import android.content.DialogInterface;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class ListPreferenceDialogFragmentCompat extends PreferenceDialogFragmentCompat {
    private CharSequence[] F;
    int y;
    private CharSequence[] z;

    class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            ListPreferenceDialogFragmentCompat listPreferenceDialogFragmentCompat = ListPreferenceDialogFragmentCompat.this;
            listPreferenceDialogFragmentCompat.y = i;
            listPreferenceDialogFragmentCompat.onClick(dialogInterface, -1);
            dialogInterface.dismiss();
        }
    }

    private ListPreference U() {
        return (ListPreference) N();
    }

    public static ListPreferenceDialogFragmentCompat V(String str) {
        ListPreferenceDialogFragmentCompat listPreferenceDialogFragmentCompat = new ListPreferenceDialogFragmentCompat();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        listPreferenceDialogFragmentCompat.setArguments(bundle);
        return listPreferenceDialogFragmentCompat;
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat
    public void R(boolean z) {
        int i;
        if (!z || (i = this.y) < 0) {
            return;
        }
        String string = this.F[i].toString();
        ListPreference listPreferenceU = U();
        if (listPreferenceU.a(string)) {
            listPreferenceU.E0(string);
        }
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat
    protected void S(androidx.appcompat.app.b.a aVar) {
        super.S(aVar);
        aVar.r(this.z, this.y, new a());
        aVar.p(null, null);
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.y = bundle.getInt("ListPreferenceDialogFragment.index", 0);
            this.z = bundle.getCharSequenceArray("ListPreferenceDialogFragment.entries");
            this.F = bundle.getCharSequenceArray("ListPreferenceDialogFragment.entryValues");
            return;
        }
        ListPreference listPreferenceU = U();
        if (listPreferenceU.z0() == null || listPreferenceU.B0() == null) {
            throw new IllegalStateException("ListPreference requires an entries array and an entryValues array.");
        }
        this.y = listPreferenceU.y0(listPreferenceU.C0());
        this.z = listPreferenceU.z0();
        this.F = listPreferenceU.B0();
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("ListPreferenceDialogFragment.index", this.y);
        bundle.putCharSequenceArray("ListPreferenceDialogFragment.entries", this.z);
        bundle.putCharSequenceArray("ListPreferenceDialogFragment.entryValues", this.F);
    }
}
