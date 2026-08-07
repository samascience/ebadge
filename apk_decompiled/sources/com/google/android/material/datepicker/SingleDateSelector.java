package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.google.android.material.R$attr;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.textfield.TextInputLayout;
import defpackage.gg1;
import defpackage.hw1;
import defpackage.qf1;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: loaded from: classes3.dex */
public class SingleDateSelector implements DateSelector<Long> {
    public static final Parcelable.Creator<SingleDateSelector> CREATOR = new b();
    private CharSequence a;
    private Long b;
    private SimpleDateFormat c;

    class a extends e {
        final /* synthetic */ hw1 i;
        final /* synthetic */ TextInputLayout j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, DateFormat dateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints, hw1 hw1Var, TextInputLayout textInputLayout2) {
            super(str, dateFormat, textInputLayout, calendarConstraints);
            this.i = hw1Var;
            this.j = textInputLayout2;
        }

        @Override // com.google.android.material.datepicker.e
        void f() {
            SingleDateSelector.this.a = this.j.getError();
            this.i.a();
        }

        @Override // com.google.android.material.datepicker.e
        void g(Long l) {
            if (l == null) {
                SingleDateSelector.this.d();
            } else {
                SingleDateSelector.this.A0(l.longValue());
            }
            SingleDateSelector.this.a = null;
            this.i.b(SingleDateSelector.this.w0());
        }
    }

    class b implements Parcelable.Creator {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public SingleDateSelector createFromParcel(Parcel parcel) {
            SingleDateSelector singleDateSelector = new SingleDateSelector();
            singleDateSelector.b = (Long) parcel.readValue(Long.class.getClassLoader());
            return singleDateSelector;
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public SingleDateSelector[] newArray(int i) {
            return new SingleDateSelector[i];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.b = null;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void A0(long j) {
        this.b = Long.valueOf(j);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public Collection C() {
        return new ArrayList();
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public View D(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle, CalendarConstraints calendarConstraints, hw1 hw1Var) {
        View viewInflate = layoutInflater.inflate(R$layout.mtrl_picker_text_input_date, viewGroup, false);
        TextInputLayout textInputLayout = (TextInputLayout) viewInflate.findViewById(R$id.mtrl_picker_text_input_date);
        EditText editText = textInputLayout.getEditText();
        if (qf1.b()) {
            editText.setInputType(17);
        }
        SimpleDateFormat simpleDateFormatF = this.c;
        boolean z = simpleDateFormatF != null;
        if (!z) {
            simpleDateFormatF = m.f();
        }
        SimpleDateFormat simpleDateFormat = simpleDateFormatF;
        String pattern = z ? simpleDateFormat.toPattern() : m.g(viewInflate.getResources(), simpleDateFormat);
        textInputLayout.setPlaceholderText(pattern);
        Long l = this.b;
        if (l != null) {
            editText.setText(simpleDateFormat.format(l));
        }
        editText.addTextChangedListener(new a(pattern, simpleDateFormat, textInputLayout, calendarConstraints, hw1Var, textInputLayout));
        DateSelector.V(editText);
        return viewInflate;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public Long w0() {
        return this.b;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public String e0(Context context) {
        Resources resources = context.getResources();
        Long l = this.b;
        return resources.getString(R$string.mtrl_picker_announce_current_selection, l == null ? resources.getString(R$string.mtrl_picker_announce_current_selection_none) : f.m(l.longValue()));
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int j0(Context context) {
        return gg1.d(context, R$attr.materialCalendarTheme, MaterialDatePicker.class.getCanonicalName());
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public boolean m0() {
        return this.b != null;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public Collection t0() {
        ArrayList arrayList = new ArrayList();
        Long l = this.b;
        if (l != null) {
            arrayList.add(l);
        }
        return arrayList;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.b);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public String y(Context context) {
        Resources resources = context.getResources();
        Long l = this.b;
        if (l == null) {
            return resources.getString(R$string.mtrl_picker_date_header_unselected);
        }
        return resources.getString(R$string.mtrl_picker_date_header_selected, f.m(l.longValue()));
    }
}
