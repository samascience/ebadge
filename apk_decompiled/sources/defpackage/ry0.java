package defpackage;

import com.fasterxml.jackson.core.JsonFactory;
import com.tencent.connect.common.Constants;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Objects;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
public abstract class ry0 {
    private static final TimeZone a = TimeZone.getTimeZone("UTC");

    private static boolean a(String str, int i, char c) {
        return i < str.length() && str.charAt(i) == c;
    }

    public static String b(Date date) {
        return c(date, false, a);
    }

    public static String c(Date date, boolean z, TimeZone timeZone) {
        return d(date, z, timeZone, Locale.US);
    }

    public static String d(Date date, boolean z, TimeZone timeZone, Locale locale) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone, locale);
        gregorianCalendar.setTime(date);
        StringBuilder sb = new StringBuilder(30);
        sb.append(String.format("%04d-%02d-%02dT%02d:%02d:%02d", Integer.valueOf(gregorianCalendar.get(1)), Integer.valueOf(gregorianCalendar.get(2) + 1), Integer.valueOf(gregorianCalendar.get(5)), Integer.valueOf(gregorianCalendar.get(11)), Integer.valueOf(gregorianCalendar.get(12)), Integer.valueOf(gregorianCalendar.get(13))));
        if (z) {
            sb.append(String.format(".%03d", Integer.valueOf(gregorianCalendar.get(14))));
        }
        int offset = timeZone.getOffset(gregorianCalendar.getTimeInMillis());
        if (offset != 0) {
            int i = offset / 60000;
            sb.append(String.format("%c%02d:%02d", Character.valueOf(offset < 0 ? '-' : '+'), Integer.valueOf(Math.abs(i / 60)), Integer.valueOf(Math.abs(i % 60))));
        } else {
            sb.append('Z');
        }
        return sb.toString();
    }

    private static int e(String str, int i) {
        while (i < str.length()) {
            char cCharAt = str.charAt(i);
            if (cCharAt < '0' || cCharAt > '9') {
                return i;
            }
            i++;
        }
        return str.length();
    }

    public static Date f(String str, ParsePosition parsePosition) throws ParseException {
        int i;
        int i2;
        int i3;
        int iG;
        int length;
        TimeZone timeZone;
        char cCharAt;
        Objects.requireNonNull(str);
        try {
            int index = parsePosition.getIndex();
            int i4 = index + 4;
            int iG2 = g(str, index, i4);
            if (a(str, i4, '-')) {
                i4 = index + 5;
            }
            int i5 = i4 + 2;
            int iG3 = g(str, i4, i5);
            if (a(str, i5, '-')) {
                i5 = i4 + 3;
            }
            int i6 = i5 + 2;
            int iG4 = g(str, i5, i6);
            boolean zA = a(str, i6, 'T');
            if (!zA && str.length() <= i6) {
                GregorianCalendar gregorianCalendar = new GregorianCalendar(iG2, iG3 - 1, iG4);
                parsePosition.setIndex(i6);
                return gregorianCalendar.getTime();
            }
            if (zA) {
                int i7 = i5 + 5;
                int iG5 = g(str, i5 + 3, i7);
                if (a(str, i7, ':')) {
                    i7 = i5 + 6;
                }
                int i8 = i7 + 2;
                int iG6 = g(str, i7, i8);
                if (a(str, i8, ':')) {
                    i8 = i7 + 3;
                }
                if (str.length() <= i8 || (cCharAt = str.charAt(i8)) == 'Z' || cCharAt == '+' || cCharAt == '-') {
                    i3 = 0;
                    iG = 0;
                    i2 = iG6;
                    i6 = i8;
                    i = iG5;
                } else {
                    int i9 = i8 + 2;
                    iG = g(str, i8, i9);
                    if (iG > 59 && iG < 63) {
                        iG = 59;
                    }
                    if (a(str, i9, '.')) {
                        int i10 = i8 + 3;
                        int iE = e(str, i8 + 4);
                        int iMin = Math.min(iE, i8 + 6);
                        int iG7 = g(str, i10, iMin);
                        int i11 = iMin - i10;
                        if (i11 == 1) {
                            iG7 *= 100;
                        } else if (i11 == 2) {
                            iG7 *= 10;
                        }
                        i = iG5;
                        i6 = iE;
                        i2 = iG6;
                        i3 = iG7;
                    } else {
                        i = iG5;
                        i6 = i9;
                        i3 = 0;
                        i2 = iG6;
                    }
                }
            } else {
                i = 0;
                i2 = 0;
                i3 = 0;
                iG = 0;
            }
            if (str.length() <= i6) {
                throw new IllegalArgumentException("No time zone indicator");
            }
            char cCharAt2 = str.charAt(i6);
            if (cCharAt2 == 'Z') {
                timeZone = a;
                length = i6 + 1;
            } else {
                if (cCharAt2 != '+' && cCharAt2 != '-') {
                    throw new IndexOutOfBoundsException("Invalid time zone indicator '" + cCharAt2 + "'");
                }
                String strSubstring = str.substring(i6);
                length = i6 + strSubstring.length();
                if ("+0000".equals(strSubstring) || "+00:00".equals(strSubstring)) {
                    timeZone = a;
                } else {
                    String str2 = "GMT" + strSubstring;
                    TimeZone timeZone2 = TimeZone.getTimeZone(str2);
                    String id = timeZone2.getID();
                    if (!id.equals(str2) && !id.replace(":", Constants.STR_EMPTY).equals(str2)) {
                        throw new IndexOutOfBoundsException("Mismatching time zone indicator: " + str2 + " given, resolves to " + timeZone2.getID());
                    }
                    timeZone = timeZone2;
                }
            }
            GregorianCalendar gregorianCalendar2 = new GregorianCalendar(timeZone);
            gregorianCalendar2.setLenient(false);
            gregorianCalendar2.set(1, iG2);
            gregorianCalendar2.set(2, iG3 - 1);
            gregorianCalendar2.set(5, iG4);
            gregorianCalendar2.set(11, i);
            gregorianCalendar2.set(12, i2);
            gregorianCalendar2.set(13, iG);
            gregorianCalendar2.set(14, i3);
            parsePosition.setIndex(length);
            return gregorianCalendar2.getTime();
        } catch (Exception e) {
            String str3 = JsonFactory.DEFAULT_QUOTE_CHAR + str + JsonFactory.DEFAULT_QUOTE_CHAR;
            String message = e.getMessage();
            if (message == null || message.isEmpty()) {
                message = "(" + e.getClass().getName() + ")";
            }
            ParseException parseException = new ParseException("Failed to parse date " + str3 + ": " + message, parsePosition.getIndex());
            parseException.initCause(e);
            throw parseException;
        }
    }

    private static int g(String str, int i, int i2) {
        int i3;
        int i4;
        if (i < 0 || i2 > str.length() || i > i2) {
            throw new NumberFormatException(str);
        }
        if (i < i2) {
            i4 = i + 1;
            int iDigit = Character.digit(str.charAt(i), 10);
            if (iDigit < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i2));
            }
            i3 = -iDigit;
        } else {
            i3 = 0;
            i4 = i;
        }
        while (i4 < i2) {
            int i5 = i4 + 1;
            int iDigit2 = Character.digit(str.charAt(i4), 10);
            if (iDigit2 < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i2));
            }
            i3 = (i3 * 10) - iDigit2;
            i4 = i5;
        }
        return -i3;
    }
}
