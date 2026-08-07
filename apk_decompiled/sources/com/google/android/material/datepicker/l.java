package com.google.android.material.datepicker;

import java.util.Calendar;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes3.dex */
class l {
    private static final l c = new l(null, null);
    private final Long a;
    private final TimeZone b;

    private l(Long l, TimeZone timeZone) {
        this.a = l;
        this.b = timeZone;
    }

    static l c() {
        return c;
    }

    Calendar a() {
        return b(this.b);
    }

    Calendar b(TimeZone timeZone) {
        Calendar calendar = timeZone == null ? Calendar.getInstance() : Calendar.getInstance(timeZone);
        Long l = this.a;
        if (l != null) {
            calendar.setTimeInMillis(l.longValue());
        }
        return calendar;
    }
}
