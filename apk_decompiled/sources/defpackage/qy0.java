package defpackage;

import com.fasterxml.jackson.core.JsonFactory;
import com.tencent.connect.common.Constants;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes3.dex */
public abstract class qy0 {
    private static final TimeZone a = TimeZone.getTimeZone("UTC");

    private static boolean a(String str, int i, char c) {
        return i < str.length() && str.charAt(i) == c;
    }

    private static int b(String str, int i) {
        while (i < str.length()) {
            char cCharAt = str.charAt(i);
            if (cCharAt < '0' || cCharAt > '9') {
                return i;
            }
            i++;
        }
        return str.length();
    }

    /* JADX WARN: Code duplicated, block: B:85:0x01d3  */
    /* JADX WARN: Code duplicated, block: B:86:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:89:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:91:0x01f5  */
    /* JADX WARN: Instruction removed from duplicated block: B:86:0x01d5, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:91:0x01f5, please report this as an issue */
    public static Date c(String str, ParsePosition parsePosition) throws ParseException {
        String str2;
        String message;
        int i;
        int i2;
        int i3;
        int iD;
        int length;
        TimeZone timeZone;
        char cCharAt;
        try {
            int index = parsePosition.getIndex();
            int i4 = index + 4;
            int iD2 = d(str, index, i4);
            if (a(str, i4, '-')) {
                i4 = index + 5;
            }
            int i5 = i4 + 2;
            int iD3 = d(str, i4, i5);
            if (a(str, i5, '-')) {
                i5 = i4 + 3;
            }
            int i6 = i5 + 2;
            int iD4 = d(str, i5, i6);
            boolean zA = a(str, i6, 'T');
            if (!zA && str.length() <= i6) {
                GregorianCalendar gregorianCalendar = new GregorianCalendar(iD2, iD3 - 1, iD4);
                gregorianCalendar.setLenient(false);
                parsePosition.setIndex(i6);
                return gregorianCalendar.getTime();
            }
            if (zA) {
                int i7 = i5 + 5;
                int iD5 = d(str, i5 + 3, i7);
                if (a(str, i7, ':')) {
                    i7 = i5 + 6;
                }
                int i8 = i7 + 2;
                int iD6 = d(str, i7, i8);
                if (a(str, i8, ':')) {
                    i8 = i7 + 3;
                }
                if (str.length() <= i8 || (cCharAt = str.charAt(i8)) == 'Z' || cCharAt == '+' || cCharAt == '-') {
                    i2 = iD6;
                    i3 = 0;
                    iD = 0;
                    i6 = i8;
                    i = iD5;
                } else {
                    int i9 = i8 + 2;
                    iD = d(str, i8, i9);
                    if (iD > 59 && iD < 63) {
                        iD = 59;
                    }
                    if (a(str, i9, '.')) {
                        int i10 = i8 + 3;
                        int iB = b(str, i8 + 4);
                        int iMin = Math.min(iB, i8 + 6);
                        int iD7 = d(str, i10, iMin);
                        int i11 = iMin - i10;
                        if (i11 == 1) {
                            iD7 *= 100;
                        } else if (i11 == 2) {
                            iD7 *= 10;
                        }
                        i = iD5;
                        i6 = iB;
                        i2 = iD6;
                        i3 = iD7;
                    } else {
                        i = iD5;
                        i6 = i9;
                        i2 = iD6;
                        i3 = 0;
                    }
                }
            } else {
                i = 0;
                i2 = 0;
                i3 = 0;
                iD = 0;
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
                if (strSubstring.length() < 5) {
                    strSubstring = strSubstring + "00";
                }
                length = i6 + strSubstring.length();
                if ("+0000".equals(strSubstring) || "+00:00".equals(strSubstring)) {
                    timeZone = a;
                } else {
                    String str3 = "GMT" + strSubstring;
                    TimeZone timeZone2 = TimeZone.getTimeZone(str3);
                    String id = timeZone2.getID();
                    if (!id.equals(str3) && !id.replace(":", Constants.STR_EMPTY).equals(str3)) {
                        throw new IndexOutOfBoundsException("Mismatching time zone indicator: " + str3 + " given, resolves to " + timeZone2.getID());
                    }
                    timeZone = timeZone2;
                }
            }
            GregorianCalendar gregorianCalendar2 = new GregorianCalendar(timeZone);
            gregorianCalendar2.setLenient(false);
            gregorianCalendar2.set(1, iD2);
            gregorianCalendar2.set(2, iD3 - 1);
            gregorianCalendar2.set(5, iD4);
            gregorianCalendar2.set(11, i);
            gregorianCalendar2.set(12, i2);
            gregorianCalendar2.set(13, iD);
            gregorianCalendar2.set(14, i3);
            parsePosition.setIndex(length);
            return gregorianCalendar2.getTime();
        } catch (IndexOutOfBoundsException e) {
            e = e;
            if (str == null) {
                str2 = null;
            } else {
                str2 = JsonFactory.DEFAULT_QUOTE_CHAR + str + JsonFactory.DEFAULT_QUOTE_CHAR;
            }
            message = e.getMessage();
            if (message != null || message.isEmpty()) {
                message = "(" + e.getClass().getName() + ")";
            }
            ParseException parseException = new ParseException("Failed to parse date [" + str2 + "]: " + message, parsePosition.getIndex());
            parseException.initCause(e);
            throw parseException;
        } catch (NumberFormatException e2) {
            e = e2;
            if (str == null) {
                str2 = null;
            } else {
                str2 = JsonFactory.DEFAULT_QUOTE_CHAR + str + JsonFactory.DEFAULT_QUOTE_CHAR;
            }
            message = e.getMessage();
            if (message != null) {
                message = "(" + e.getClass().getName() + ")";
            } else {
                message = "(" + e.getClass().getName() + ")";
            }
            ParseException parseException2 = new ParseException("Failed to parse date [" + str2 + "]: " + message, parsePosition.getIndex());
            parseException2.initCause(e);
            throw parseException2;
        } catch (IllegalArgumentException e3) {
            e = e3;
            if (str == null) {
                str2 = null;
            } else {
                str2 = JsonFactory.DEFAULT_QUOTE_CHAR + str + JsonFactory.DEFAULT_QUOTE_CHAR;
            }
            message = e.getMessage();
            if (message != null) {
                message = "(" + e.getClass().getName() + ")";
            } else {
                message = "(" + e.getClass().getName() + ")";
            }
            ParseException parseException3 = new ParseException("Failed to parse date [" + str2 + "]: " + message, parsePosition.getIndex());
            parseException3.initCause(e);
            throw parseException3;
        }
    }

    private static int d(String str, int i, int i2) {
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
