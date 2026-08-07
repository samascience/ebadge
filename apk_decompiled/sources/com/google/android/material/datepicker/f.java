package com.google.android.material.datepicker;

import android.content.Context;
import com.google.android.material.R$string;
import defpackage.az1;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
abstract class f {
    static az1 a(Long l, Long l2) {
        return b(l, l2, null);
    }

    static az1 b(Long l, Long l2, SimpleDateFormat simpleDateFormat) {
        if (l == null && l2 == null) {
            return az1.a(null, null);
        }
        if (l == null) {
            return az1.a(null, d(l2.longValue(), simpleDateFormat));
        }
        if (l2 == null) {
            return az1.a(d(l.longValue(), simpleDateFormat), null);
        }
        Calendar calendarK = m.k();
        Calendar calendarM = m.m();
        calendarM.setTimeInMillis(l.longValue());
        Calendar calendarM2 = m.m();
        calendarM2.setTimeInMillis(l2.longValue());
        if (simpleDateFormat != null) {
            return az1.a(simpleDateFormat.format(new Date(l.longValue())), simpleDateFormat.format(new Date(l2.longValue())));
        }
        if (calendarM.get(1) == calendarM2.get(1)) {
            return calendarM.get(1) == calendarK.get(1) ? az1.a(g(l.longValue(), Locale.getDefault()), g(l2.longValue(), Locale.getDefault())) : az1.a(g(l.longValue(), Locale.getDefault()), n(l2.longValue(), Locale.getDefault()));
        }
        return az1.a(n(l.longValue(), Locale.getDefault()), n(l2.longValue(), Locale.getDefault()));
    }

    static String c(long j) {
        return d(j, null);
    }

    static String d(long j, SimpleDateFormat simpleDateFormat) {
        if (simpleDateFormat != null) {
            return simpleDateFormat.format(new Date(j));
        }
        return q(j) ? f(j) : m(j);
    }

    static String e(Context context, long j, boolean z, boolean z2, boolean z3) {
        String strJ = j(j);
        if (z) {
            strJ = String.format(context.getString(R$string.mtrl_picker_today_description), strJ);
        }
        if (z2) {
            return String.format(context.getString(R$string.mtrl_picker_start_date_description), strJ);
        }
        return z3 ? String.format(context.getString(R$string.mtrl_picker_end_date_description), strJ) : strJ;
    }

    static String f(long j) {
        return g(j, Locale.getDefault());
    }

    static String g(long j, Locale locale) {
        return m.b(locale).format(new Date(j));
    }

    static String h(long j) {
        return i(j, Locale.getDefault());
    }

    static String i(long j, Locale locale) {
        return m.h(locale).format(new Date(j));
    }

    static String j(long j) {
        return q(j) ? h(j) : o(j);
    }

    static String k(Context context, int i) {
        return m.k().get(1) == i ? String.format(context.getString(R$string.mtrl_picker_navigate_to_current_year_description), Integer.valueOf(i)) : String.format(context.getString(R$string.mtrl_picker_navigate_to_year_description), Integer.valueOf(i));
    }

    static String l(long j) {
        return m.p(Locale.getDefault()).format(new Date(j));
    }

    static String m(long j) {
        return n(j, Locale.getDefault());
    }

    static String n(long j, Locale locale) {
        return m.o(locale).format(new Date(j));
    }

    static String o(long j) {
        return p(j, Locale.getDefault());
    }

    static String p(long j, Locale locale) {
        return m.q(locale).format(new Date(j));
    }

    private static boolean q(long j) {
        Calendar calendarK = m.k();
        Calendar calendarM = m.m();
        calendarM.setTimeInMillis(j);
        return calendarK.get(1) == calendarM.get(1);
    }
}
