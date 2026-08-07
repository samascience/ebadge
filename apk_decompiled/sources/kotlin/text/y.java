package kotlin.text;

import defpackage.ga2;
import defpackage.p31;
import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes4.dex */
public abstract class y extends x {
    public static final String P0(String str, int i) {
        p31.f(str, "<this>");
        if (i >= 0) {
            String strSubstring = str.substring(ga2.d(i, str.length()));
            p31.e(strSubstring, "substring(...)");
            return strSubstring;
        }
        throw new IllegalArgumentException(("Requested character count " + i + " is less than zero.").toString());
    }

    public static String Q0(String str, int i) {
        p31.f(str, "<this>");
        if (i >= 0) {
            return i.S0(str, ga2.b(str.length() - i, 0));
        }
        throw new IllegalArgumentException(("Requested character count " + i + " is less than zero.").toString());
    }

    public static char R0(CharSequence charSequence) {
        p31.f(charSequence, "<this>");
        if (charSequence.length() != 0) {
            return charSequence.charAt(w.Q(charSequence));
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    public static String S0(String str, int i) {
        p31.f(str, "<this>");
        if (i >= 0) {
            String strSubstring = str.substring(0, ga2.d(i, str.length()));
            p31.e(strSubstring, "substring(...)");
            return strSubstring;
        }
        throw new IllegalArgumentException(("Requested character count " + i + " is less than zero.").toString());
    }
}
