package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.textfield.TextInputLayout;
import defpackage.az1;
import defpackage.gg1;
import defpackage.hw1;
import defpackage.qf1;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: loaded from: classes3.dex */
public class RangeDateSelector implements DateSelector<az1> {
    public static final Parcelable.Creator<RangeDateSelector> CREATOR = new c();
    private CharSequence a;
    private String b;
    private final String c = " ";
    private Long d = null;
    private Long e = null;
    private Long f = null;
    private Long g = null;
    private SimpleDateFormat h;

    class a extends e {
        final /* synthetic */ TextInputLayout i;
        final /* synthetic */ TextInputLayout j;
        final /* synthetic */ hw1 k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, DateFormat dateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints, TextInputLayout textInputLayout2, TextInputLayout textInputLayout3, hw1 hw1Var) {
            super(str, dateFormat, textInputLayout, calendarConstraints);
            this.i = textInputLayout2;
            this.j = textInputLayout3;
            this.k = hw1Var;
        }

        @Override // com.google.android.material.datepicker.e
        void f() {
            RangeDateSelector.this.f = null;
            RangeDateSelector.this.k(this.i, this.j, this.k);
        }

        @Override // com.google.android.material.datepicker.e
        void g(Long l) {
            RangeDateSelector.this.f = l;
            RangeDateSelector.this.k(this.i, this.j, this.k);
        }
    }

    class b extends e {
        final /* synthetic */ TextInputLayout i;
        final /* synthetic */ TextInputLayout j;
        final /* synthetic */ hw1 k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, DateFormat dateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints, TextInputLayout textInputLayout2, TextInputLayout textInputLayout3, hw1 hw1Var) {
            super(str, dateFormat, textInputLayout, calendarConstraints);
            this.i = textInputLayout2;
            this.j = textInputLayout3;
            this.k = hw1Var;
        }

        @Override // com.google.android.material.datepicker.e
        void f() {
            RangeDateSelector.this.g = null;
            RangeDateSelector.this.k(this.i, this.j, this.k);
        }

        @Override // com.google.android.material.datepicker.e
        void g(Long l) {
            RangeDateSelector.this.g = l;
            RangeDateSelector.this.k(this.i, this.j, this.k);
        }
    }

    class c implements Parcelable.Creator {
        c() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public RangeDateSelector createFromParcel(Parcel parcel) {
            RangeDateSelector rangeDateSelector = new RangeDateSelector();
            rangeDateSelector.d = (Long) parcel.readValue(Long.class.getClassLoader());
            rangeDateSelector.e = (Long) parcel.readValue(Long.class.getClassLoader());
            return rangeDateSelector;
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public RangeDateSelector[] newArray(int i) {
            return new RangeDateSelector[i];
        }
    }

    private void f(TextInputLayout textInputLayout, TextInputLayout textInputLayout2) {
        if (textInputLayout.getError() != null && this.b.contentEquals(textInputLayout.getError())) {
            textInputLayout.setError(null);
        }
        if (textInputLayout2.getError() == null || !" ".contentEquals(textInputLayout2.getError())) {
            return;
        }
        textInputLayout2.setError(null);
    }

    private boolean h(long j, long j2) {
        return j <= j2;
    }

    private void i(TextInputLayout textInputLayout, TextInputLayout textInputLayout2) {
        textInputLayout.setError(this.b);
        textInputLayout2.setError(" ");
    }

    private void j(TextInputLayout textInputLayout, TextInputLayout textInputLayout2) {
        if (!TextUtils.isEmpty(textInputLayout.getError())) {
            this.a = textInputLayout.getError();
        } else if (TextUtils.isEmpty(textInputLayout2.getError())) {
            this.a = null;
        } else {
            this.a = textInputLayout2.getError();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(TextInputLayout textInputLayout, TextInputLayout textInputLayout2, hw1 hw1Var) {
        Long l = this.f;
        if (l == null || this.g == null) {
            f(textInputLayout, textInputLayout2);
            hw1Var.a();
        } else if (h(l.longValue(), this.g.longValue())) {
            this.d = this.f;
            this.e = this.g;
            hw1Var.b(w0());
        } else {
            i(textInputLayout, textInputLayout2);
            hw1Var.a();
        }
        j(textInputLayout, textInputLayout2);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void A0(long j) {
        Long l = this.d;
        if (l == null) {
            this.d = Long.valueOf(j);
        } else if (this.e == null && h(l.longValue(), j)) {
            this.e = Long.valueOf(j);
        } else {
            this.e = null;
            this.d = Long.valueOf(j);
        }
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public Collection C() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new az1(this.d, this.e));
        return arrayList;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public View D(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle, CalendarConstraints calendarConstraints, hw1 hw1Var) {
        View viewInflate = layoutInflater.inflate(R$layout.mtrl_picker_text_input_date_range, viewGroup, false);
        TextInputLayout textInputLayout = (TextInputLayout) viewInflate.findViewById(R$id.mtrl_picker_text_input_range_start);
        TextInputLayout textInputLayout2 = (TextInputLayout) viewInflate.findViewById(R$id.mtrl_picker_text_input_range_end);
        EditText editText = textInputLayout.getEditText();
        EditText editText2 = textInputLayout2.getEditText();
        if (qf1.b()) {
            editText.setInputType(17);
            editText2.setInputType(17);
        }
        this.b = viewInflate.getResources().getString(R$string.mtrl_picker_invalid_range);
        SimpleDateFormat simpleDateFormatF = this.h;
        boolean z = simpleDateFormatF != null;
        if (!z) {
            simpleDateFormatF = m.f();
        }
        SimpleDateFormat simpleDateFormat = simpleDateFormatF;
        Long l = this.d;
        if (l != null) {
            editText.setText(simpleDateFormat.format(l));
            this.f = this.d;
        }
        Long l2 = this.e;
        if (l2 != null) {
            editText2.setText(simpleDateFormat.format(l2));
            this.g = this.e;
        }
        String pattern = z ? simpleDateFormat.toPattern() : m.g(viewInflate.getResources(), simpleDateFormat);
        textInputLayout.setPlaceholderText(pattern);
        textInputLayout2.setPlaceholderText(pattern);
        editText.addTextChangedListener(new a(pattern, simpleDateFormat, textInputLayout, calendarConstraints, textInputLayout, textInputLayout2, hw1Var));
        editText2.addTextChangedListener(new b(pattern, simpleDateFormat, textInputLayout2, calendarConstraints, textInputLayout, textInputLayout2, hw1Var));
        DateSelector.V(editText, editText2);
        return viewInflate;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public String e0(Context context) {
        Resources resources = context.getResources();
        az1 az1VarA = f.a(this.d, this.e);
        Object obj = az1VarA.a;
        String string = obj == null ? resources.getString(R$string.mtrl_picker_announce_current_selection_none) : (String) obj;
        Object obj2 = az1VarA.b;
        return resources.getString(R$string.mtrl_picker_announce_current_range_selection, string, obj2 == null ? resources.getString(R$string.mtrl_picker_announce_current_selection_none) : (String) obj2);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public az1 w0() {
        return new az1(this.d, this.e);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int j0(Context context) {
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return gg1.d(context, Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels) > resources.getDimensionPixelSize(R$dimen.mtrl_calendar_maximum_default_fullscreen_minor_axis) ? R$attr.materialCalendarTheme : R$attr.materialCalendarFullscreenTheme, MaterialDatePicker.class.getCanonicalName());
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public boolean m0() {
        Long l = this.d;
        return (l == null || this.e == null || !h(l.longValue(), this.e.longValue())) ? false : true;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public Collection t0() {
        ArrayList arrayList = new ArrayList();
        Long l = this.d;
        if (l != null) {
            arrayList.add(l);
        }
        Long l2 = this.e;
        if (l2 != null) {
            arrayList.add(l2);
        }
        return arrayList;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.d);
        parcel.writeValue(this.e);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public String y(Context context) {
        Resources resources = context.getResources();
        Long l = this.d;
        if (l == null && this.e == null) {
            return resources.getString(R$string.mtrl_picker_range_header_unselected);
        }
        Long l2 = this.e;
        if (l2 == null) {
            return resources.getString(R$string.mtrl_picker_range_header_only_start_selected, f.c(l.longValue()));
        }
        if (l == null) {
            return resources.getString(R$string.mtrl_picker_range_header_only_end_selected, f.c(l2.longValue()));
        }
        az1 az1VarA = f.a(l, l2);
        return resources.getString(R$string.mtrl_picker_range_header_selected, az1VarA.a, az1VarA.b);
    }
}
