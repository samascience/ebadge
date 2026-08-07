package defpackage;

import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public abstract class qe2 {
    private static final ap2 a = new ap2();

    public static boolean a(CharSequence charSequence) {
        return b("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$", charSequence);
    }

    public static boolean b(String str, CharSequence charSequence) {
        return charSequence != null && charSequence.length() > 0 && Pattern.matches(str, charSequence);
    }
}
