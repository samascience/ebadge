package androidx.preference;

import android.R;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/* JADX INFO: loaded from: classes.dex */
public class EditTextPreferenceDialogFragmentCompat extends PreferenceDialogFragmentCompat {
    private EditText y;
    private CharSequence z;

    private EditTextPreference U() {
        return (EditTextPreference) N();
    }

    public static EditTextPreferenceDialogFragmentCompat V(String str) {
        EditTextPreferenceDialogFragmentCompat editTextPreferenceDialogFragmentCompat = new EditTextPreferenceDialogFragmentCompat();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        editTextPreferenceDialogFragmentCompat.setArguments(bundle);
        return editTextPreferenceDialogFragmentCompat;
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat
    protected boolean O() {
        return true;
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat
    protected void P(View view) {
        super.P(view);
        EditText editText = (EditText) view.findViewById(R.id.edit);
        this.y = editText;
        if (editText == null) {
            throw new IllegalStateException("Dialog view must contain an EditText with id @android:id/edit");
        }
        editText.requestFocus();
        this.y.setText(this.z);
        EditText editText2 = this.y;
        editText2.setSelection(editText2.getText().length());
        U().y0();
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat
    public void R(boolean z) {
        if (z) {
            String string = this.y.getText().toString();
            EditTextPreference editTextPreferenceU = U();
            if (editTextPreferenceU.a(string)) {
                editTextPreferenceU.A0(string);
            }
        }
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            this.z = U().z0();
        } else {
            this.z = bundle.getCharSequence("EditTextPreferenceDialogFragment.text");
        }
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putCharSequence("EditTextPreferenceDialogFragment.text", this.z);
    }
}
