package androidx.preference;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class MultiSelectListPreferenceDialogFragment extends PreferenceDialogFragment {
    Set i = new HashSet();
    boolean j;
    CharSequence[] k;
    CharSequence[] l;

    class a implements DialogInterface.OnMultiChoiceClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnMultiChoiceClickListener
        public void onClick(DialogInterface dialogInterface, int i, boolean z) {
            if (z) {
                MultiSelectListPreferenceDialogFragment multiSelectListPreferenceDialogFragment = MultiSelectListPreferenceDialogFragment.this;
                multiSelectListPreferenceDialogFragment.j = multiSelectListPreferenceDialogFragment.i.add(multiSelectListPreferenceDialogFragment.l[i].toString()) | multiSelectListPreferenceDialogFragment.j;
            } else {
                MultiSelectListPreferenceDialogFragment multiSelectListPreferenceDialogFragment2 = MultiSelectListPreferenceDialogFragment.this;
                multiSelectListPreferenceDialogFragment2.j = multiSelectListPreferenceDialogFragment2.i.remove(multiSelectListPreferenceDialogFragment2.l[i].toString()) | multiSelectListPreferenceDialogFragment2.j;
            }
        }
    }

    @Deprecated
    public MultiSelectListPreferenceDialogFragment() {
    }

    private MultiSelectListPreference h() {
        return (MultiSelectListPreference) a();
    }

    public static MultiSelectListPreferenceDialogFragment i(String str) {
        MultiSelectListPreferenceDialogFragment multiSelectListPreferenceDialogFragment = new MultiSelectListPreferenceDialogFragment();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        multiSelectListPreferenceDialogFragment.setArguments(bundle);
        return multiSelectListPreferenceDialogFragment;
    }

    @Override // androidx.preference.PreferenceDialogFragment
    public void e(boolean z) {
        MultiSelectListPreference multiSelectListPreferenceH = h();
        if (z && this.j) {
            Set set = this.i;
            if (multiSelectListPreferenceH.a(set)) {
                multiSelectListPreferenceH.B0(set);
            }
        }
        this.j = false;
    }

    @Override // androidx.preference.PreferenceDialogFragment
    protected void f(AlertDialog.Builder builder) {
        super.f(builder);
        int length = this.l.length;
        boolean[] zArr = new boolean[length];
        for (int i = 0; i < length; i++) {
            zArr[i] = this.i.contains(this.l[i].toString());
        }
        builder.setMultiChoiceItems(this.k, zArr, new a());
    }

    @Override // androidx.preference.PreferenceDialogFragment, android.app.DialogFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.i.clear();
            this.i.addAll(bundle.getStringArrayList("MultiSelectListPreferenceDialogFragment.values"));
            this.j = bundle.getBoolean("MultiSelectListPreferenceDialogFragment.changed", false);
            this.k = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragment.entries");
            this.l = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragment.entryValues");
            return;
        }
        MultiSelectListPreference multiSelectListPreferenceH = h();
        if (multiSelectListPreferenceH.y0() == null || multiSelectListPreferenceH.z0() == null) {
            throw new IllegalStateException("MultiSelectListPreference requires an entries array and an entryValues array.");
        }
        this.i.clear();
        this.i.addAll(multiSelectListPreferenceH.A0());
        this.j = false;
        this.k = multiSelectListPreferenceH.y0();
        this.l = multiSelectListPreferenceH.z0();
    }

    @Override // androidx.preference.PreferenceDialogFragment, android.app.DialogFragment, android.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList("MultiSelectListPreferenceDialogFragment.values", new ArrayList<>(this.i));
        bundle.putBoolean("MultiSelectListPreferenceDialogFragment.changed", this.j);
        bundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragment.entries", this.k);
        bundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragment.entryValues", this.l);
    }
}
