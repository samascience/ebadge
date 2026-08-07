package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.google.android.material.datepicker.DateSelector;
import defpackage.hw1;
import defpackage.nf3;
import java.util.Collection;

/* JADX INFO: loaded from: classes3.dex */
public interface DateSelector<S> extends Parcelable {
    static void V(final EditText... editTextArr) {
        if (editTextArr.length == 0) {
            return;
        }
        View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener() { // from class: v60
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                DateSelector.w(editTextArr, view, z);
            }
        };
        for (EditText editText : editTextArr) {
            editText.setOnFocusChangeListener(onFocusChangeListener);
        }
        final EditText editText2 = editTextArr[0];
        editText2.postDelayed(new Runnable() { // from class: w60
            @Override // java.lang.Runnable
            public final void run() {
                nf3.s(editText2, false);
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ void w(EditText[] editTextArr, View view, boolean z) {
        for (EditText editText : editTextArr) {
            if (editText.hasFocus()) {
                return;
            }
        }
        nf3.n(view, false);
    }

    void A0(long j);

    Collection C();

    View D(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle, CalendarConstraints calendarConstraints, hw1 hw1Var);

    String e0(Context context);

    int j0(Context context);

    boolean m0();

    Collection t0();

    Object w0();

    String y(Context context);
}
