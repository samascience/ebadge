package com.google.android.material.datepicker;

import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import defpackage.hw1;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class MaterialTextInputPicker<S> extends j {
    private int b;
    private DateSelector c;
    private CalendarConstraints d;

    class a extends hw1 {
        a() {
        }

        @Override // defpackage.hw1
        public void a() {
            Iterator it = MaterialTextInputPicker.this.a.iterator();
            while (it.hasNext()) {
                ((hw1) it.next()).a();
            }
        }

        @Override // defpackage.hw1
        public void b(Object obj) {
            Iterator it = MaterialTextInputPicker.this.a.iterator();
            while (it.hasNext()) {
                ((hw1) it.next()).b(obj);
            }
        }
    }

    static MaterialTextInputPicker x(DateSelector dateSelector, int i, CalendarConstraints calendarConstraints) {
        MaterialTextInputPicker materialTextInputPicker = new MaterialTextInputPicker();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i);
        bundle.putParcelable("DATE_SELECTOR_KEY", dateSelector);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints);
        materialTextInputPicker.setArguments(bundle);
        return materialTextInputPicker;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.b = bundle.getInt("THEME_RES_ID_KEY");
        this.c = (DateSelector) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.d = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.c.D(layoutInflater.cloneInContext(new ContextThemeWrapper(getContext(), this.b)), viewGroup, bundle, this.d, new a());
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.b);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.c);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.d);
    }
}
