package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.R$id;
import com.google.android.material.R$string;
import com.google.android.material.button.MaterialButtonToggleGroup;
import defpackage.l23;
import defpackage.m2;
import defpackage.nf3;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
class j implements TimePickerView.f, g {
    private final LinearLayout a;
    private final TimeModel b;
    private final TextWatcher c = new a();
    private final TextWatcher d = new b();
    private final ChipTextInputComboView e;
    private final ChipTextInputComboView f;
    private final h g;
    private final EditText h;
    private final EditText i;
    private MaterialButtonToggleGroup j;

    class a extends l23 {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            try {
                if (TextUtils.isEmpty(editable)) {
                    j.this.b.i(0);
                } else {
                    j.this.b.i(Integer.parseInt(editable.toString()));
                }
            } catch (NumberFormatException unused) {
            }
        }
    }

    class b extends l23 {
        b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            try {
                if (TextUtils.isEmpty(editable)) {
                    j.this.b.h(0);
                } else {
                    j.this.b.h(Integer.parseInt(editable.toString()));
                }
            } catch (NumberFormatException unused) {
            }
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            j.this.f(((Integer) view.getTag(R$id.selection_type)).intValue());
        }
    }

    class d extends com.google.android.material.timepicker.a {
        final /* synthetic */ TimeModel b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(Context context, int i, TimeModel timeModel) {
            super(context, i);
            this.b = timeModel;
        }

        @Override // com.google.android.material.timepicker.a, defpackage.t1
        public void onInitializeAccessibilityNodeInfo(View view, m2 m2Var) {
            super.onInitializeAccessibilityNodeInfo(view, m2Var);
            m2Var.n0(view.getResources().getString(this.b.c(), String.valueOf(this.b.d())));
        }
    }

    class e extends com.google.android.material.timepicker.a {
        final /* synthetic */ TimeModel b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(Context context, int i, TimeModel timeModel) {
            super(context, i);
            this.b = timeModel;
        }

        @Override // com.google.android.material.timepicker.a, defpackage.t1
        public void onInitializeAccessibilityNodeInfo(View view, m2 m2Var) {
            super.onInitializeAccessibilityNodeInfo(view, m2Var);
            m2Var.n0(view.getResources().getString(R$string.material_minute_suffix, String.valueOf(this.b.e)));
        }
    }

    public j(LinearLayout linearLayout, TimeModel timeModel) {
        this.a = linearLayout;
        this.b = timeModel;
        Resources resources = linearLayout.getResources();
        ChipTextInputComboView chipTextInputComboView = (ChipTextInputComboView) linearLayout.findViewById(R$id.material_minute_text_input);
        this.e = chipTextInputComboView;
        ChipTextInputComboView chipTextInputComboView2 = (ChipTextInputComboView) linearLayout.findViewById(R$id.material_hour_text_input);
        this.f = chipTextInputComboView2;
        int i = R$id.material_label;
        TextView textView = (TextView) chipTextInputComboView.findViewById(i);
        TextView textView2 = (TextView) chipTextInputComboView2.findViewById(i);
        textView.setText(resources.getString(R$string.material_timepicker_minute));
        textView2.setText(resources.getString(R$string.material_timepicker_hour));
        int i2 = R$id.selection_type;
        chipTextInputComboView.setTag(i2, 12);
        chipTextInputComboView2.setTag(i2, 10);
        if (timeModel.c == 0) {
            n();
        }
        c cVar = new c();
        chipTextInputComboView2.setOnClickListener(cVar);
        chipTextInputComboView.setOnClickListener(cVar);
        chipTextInputComboView2.c(timeModel.e());
        chipTextInputComboView.c(timeModel.f());
        this.h = chipTextInputComboView2.e().getEditText();
        this.i = chipTextInputComboView.e().getEditText();
        this.g = new h(chipTextInputComboView2, chipTextInputComboView, timeModel);
        chipTextInputComboView2.f(new d(linearLayout.getContext(), R$string.material_hour_selection, timeModel));
        chipTextInputComboView.f(new e(linearLayout.getContext(), R$string.material_minute_selection, timeModel));
        i();
    }

    private void e() {
        this.h.addTextChangedListener(this.d);
        this.i.addTextChangedListener(this.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(MaterialButtonToggleGroup materialButtonToggleGroup, int i, boolean z) {
        if (z) {
            this.b.j(i == R$id.material_clock_period_pm_button ? 1 : 0);
        }
    }

    private void k() {
        this.h.removeTextChangedListener(this.d);
        this.i.removeTextChangedListener(this.c);
    }

    private void m(TimeModel timeModel) {
        k();
        Locale locale = this.a.getResources().getConfiguration().locale;
        String str = String.format(locale, "%02d", Integer.valueOf(timeModel.e));
        String str2 = String.format(locale, "%02d", Integer.valueOf(timeModel.d()));
        this.e.g(str);
        this.f.g(str2);
        e();
        o();
    }

    private void n() {
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) this.a.findViewById(R$id.material_clock_period_toggle);
        this.j = materialButtonToggleGroup;
        materialButtonToggleGroup.b(new MaterialButtonToggleGroup.d() { // from class: com.google.android.material.timepicker.i
            @Override // com.google.android.material.button.MaterialButtonToggleGroup.d
            public final void a(MaterialButtonToggleGroup materialButtonToggleGroup2, int i, boolean z) {
                this.a.j(materialButtonToggleGroup2, i, z);
            }
        });
        this.j.setVisibility(0);
        o();
    }

    private void o() {
        MaterialButtonToggleGroup materialButtonToggleGroup = this.j;
        if (materialButtonToggleGroup == null) {
            return;
        }
        materialButtonToggleGroup.e(this.b.g == 0 ? R$id.material_clock_period_am_button : R$id.material_clock_period_pm_button);
    }

    @Override // com.google.android.material.timepicker.g
    public void b() {
        this.a.setVisibility(0);
        f(this.b.f);
    }

    @Override // com.google.android.material.timepicker.g
    public void c() {
        m(this.b);
    }

    @Override // com.google.android.material.timepicker.TimePickerView.f
    public void f(int i) {
        this.b.f = i;
        this.e.setChecked(i == 12);
        this.f.setChecked(i == 10);
        o();
    }

    @Override // com.google.android.material.timepicker.g
    public void g() {
        View focusedChild = this.a.getFocusedChild();
        if (focusedChild != null) {
            nf3.n(focusedChild, false);
        }
        this.a.setVisibility(8);
    }

    public void h() {
        this.e.setChecked(false);
        this.f.setChecked(false);
    }

    public void i() {
        e();
        m(this.b);
        this.g.a();
    }

    public void l() {
        this.e.setChecked(this.b.f == 12);
        this.f.setChecked(this.b.f == 10);
    }
}
