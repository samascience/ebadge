package androidx.preference;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

/* JADX INFO: loaded from: classes.dex */
public class DropDownPreference extends ListPreference {
    private final Context d0;
    private final ArrayAdapter e0;
    private Spinner f0;
    private final AdapterView.OnItemSelectedListener g0;

    class a implements AdapterView.OnItemSelectedListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i, long j) {
            if (i >= 0) {
                String string = DropDownPreference.this.B0()[i].toString();
                if (string.equals(DropDownPreference.this.C0()) || !DropDownPreference.this.a(string)) {
                    return;
                }
                DropDownPreference.this.E0(string);
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    public DropDownPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.dropdownPreferenceStyle);
    }

    private int G0(String str) {
        CharSequence[] charSequenceArrB0 = B0();
        if (str == null || charSequenceArrB0 == null) {
            return -1;
        }
        for (int length = charSequenceArrB0.length - 1; length >= 0; length--) {
            if (charSequenceArrB0[length].equals(str)) {
                return length;
            }
        }
        return -1;
    }

    private void H0() {
        this.e0.clear();
        if (z0() != null) {
            for (CharSequence charSequence : z0()) {
                this.e0.add(charSequence.toString());
            }
        }
    }

    @Override // androidx.preference.Preference
    protected void F() {
        super.F();
        ArrayAdapter arrayAdapter = this.e0;
        if (arrayAdapter != null) {
            arrayAdapter.notifyDataSetChanged();
        }
    }

    protected ArrayAdapter F0() {
        return new ArrayAdapter(this.d0, R.layout.simple_spinner_dropdown_item);
    }

    @Override // androidx.preference.Preference
    public void J(d dVar) {
        Spinner spinner = (Spinner) dVar.itemView.findViewById(R$id.spinner);
        this.f0 = spinner;
        spinner.setAdapter((SpinnerAdapter) this.e0);
        this.f0.setOnItemSelectedListener(this.g0);
        this.f0.setSelection(G0(C0()));
        super.J(dVar);
    }

    @Override // androidx.preference.DialogPreference, androidx.preference.Preference
    protected void K() {
        this.f0.performClick();
    }

    public DropDownPreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public DropDownPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.g0 = new a();
        this.d0 = context;
        this.e0 = F0();
        H0();
    }
}
