package com.fasterxml.jackson.databind.util;

import defpackage.ry0;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.GregorianCalendar;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class ISO8601DateFormat extends DateFormat {
    private static final long serialVersionUID = 1;

    public ISO8601DateFormat() {
        ((DateFormat) this).numberFormat = new DecimalFormat();
        ((DateFormat) this).calendar = new GregorianCalendar();
    }

    @Override // java.text.DateFormat, java.text.Format
    public Object clone() {
        return this;
    }

    @Override // java.text.DateFormat
    public StringBuffer format(Date date, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        stringBuffer.append(ry0.b(date));
        return stringBuffer;
    }

    @Override // java.text.DateFormat
    public Date parse(String str, ParsePosition parsePosition) {
        try {
            return ry0.f(str, parsePosition);
        } catch (ParseException unused) {
            return null;
        }
    }

    @Override // java.text.DateFormat
    public Date parse(String str) throws ParseException {
        return ry0.f(str, new ParsePosition(0));
    }
}
