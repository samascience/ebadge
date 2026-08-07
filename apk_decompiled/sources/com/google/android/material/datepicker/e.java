package com.google.android.material.datepicker;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import com.google.android.material.R$string;
import com.google.android.material.textfield.TextInputLayout;
import defpackage.l23;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
abstract class e extends l23 {
    private final TextInputLayout a;
    private final String b;
    private final DateFormat c;
    private final CalendarConstraints d;
    private final String e;
    private final Runnable f;
    private Runnable g;
    private int h = 0;

    e(final String str, DateFormat dateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints) {
        this.b = str;
        this.c = dateFormat;
        this.a = textInputLayout;
        this.d = calendarConstraints;
        this.e = textInputLayout.getContext().getString(R$string.mtrl_picker_out_of_range);
        this.f = new Runnable() { // from class: com.google.android.material.datepicker.c
            @Override // java.lang.Runnable
            public final void run() {
                this.a.e(str);
            }
        };
    }

    private Runnable c(final long j) {
        return new Runnable() { // from class: com.google.android.material.datepicker.d
            @Override // java.lang.Runnable
            public final void run() {
                this.a.d(j);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(long j) {
        this.a.setError(String.format(this.e, i(f.c(j))));
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(String str) {
        TextInputLayout textInputLayout = this.a;
        DateFormat dateFormat = this.c;
        Context context = textInputLayout.getContext();
        textInputLayout.setError(context.getString(R$string.mtrl_picker_invalid_format) + "\n" + String.format(context.getString(R$string.mtrl_picker_invalid_format_use), i(str)) + "\n" + String.format(context.getString(R$string.mtrl_picker_invalid_format_example), i(dateFormat.format(new Date(m.k().getTimeInMillis())))));
        f();
    }

    private String i(String str) {
        return str.replace(' ', (char) 160);
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (!Locale.getDefault().getLanguage().equals(Locale.KOREAN.getLanguage()) && editable.length() != 0 && editable.length() < this.b.length() && editable.length() >= this.h) {
            char cCharAt = this.b.charAt(editable.length());
            if (Character.isLetterOrDigit(cCharAt)) {
                return;
            }
            editable.append(cCharAt);
        }
    }

    @Override // defpackage.l23, android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.h = charSequence.length();
    }

    abstract void f();

    abstract void g(Long l);

    public void h(View view, Runnable runnable) {
        view.post(runnable);
    }

    @Override // defpackage.l23, android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.a.removeCallbacks(this.f);
        this.a.removeCallbacks(this.g);
        this.a.setError(null);
        g(null);
        if (TextUtils.isEmpty(charSequence) || charSequence.length() < this.b.length()) {
            return;
        }
        try {
            Date date = this.c.parse(charSequence.toString());
            this.a.setError(null);
            long time = date.getTime();
            if (this.d.g().k0(time) && this.d.n(time)) {
                g(Long.valueOf(date.getTime()));
                return;
            }
            Runnable runnableC = c(time);
            this.g = runnableC;
            h(this.a, runnableC);
        } catch (ParseException unused) {
            h(this.a, this.f);
        }
    }
}
