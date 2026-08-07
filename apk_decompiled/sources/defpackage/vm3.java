package defpackage;

import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public abstract class vm3 {
    public static final String a(char c) {
        String strValueOf = String.valueOf(c);
        p31.d(strValueOf, "null cannot be cast to non-null type java.lang.String");
        Locale locale = Locale.ROOT;
        String upperCase = strValueOf.toUpperCase(locale);
        p31.e(upperCase, "toUpperCase(...)");
        if (upperCase.length() <= 1) {
            return String.valueOf(Character.toTitleCase(c));
        }
        if (c == 329) {
            return upperCase;
        }
        char cCharAt = upperCase.charAt(0);
        p31.d(upperCase, "null cannot be cast to non-null type java.lang.String");
        String strSubstring = upperCase.substring(1);
        p31.e(strSubstring, "substring(...)");
        p31.d(strSubstring, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = strSubstring.toLowerCase(locale);
        p31.e(lowerCase, "toLowerCase(...)");
        return cCharAt + lowerCase;
    }
}
