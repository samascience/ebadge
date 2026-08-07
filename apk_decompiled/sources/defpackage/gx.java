package defpackage;

import com.tencent.connect.common.Constants;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes4.dex */
public final class gx {
    public static final gx a = new gx();
    public static final Charset b;
    public static final Charset c;
    public static final Charset d;
    public static final Charset e;
    public static final Charset f;
    public static final Charset g;
    private static volatile Charset h;
    private static volatile Charset i;

    static {
        Charset charsetForName = Charset.forName(Constants.ENC_UTF_8);
        p31.e(charsetForName, "forName(...)");
        b = charsetForName;
        Charset charsetForName2 = Charset.forName("UTF-16");
        p31.e(charsetForName2, "forName(...)");
        c = charsetForName2;
        Charset charsetForName3 = Charset.forName("UTF-16BE");
        p31.e(charsetForName3, "forName(...)");
        d = charsetForName3;
        Charset charsetForName4 = Charset.forName("UTF-16LE");
        p31.e(charsetForName4, "forName(...)");
        e = charsetForName4;
        Charset charsetForName5 = Charset.forName("US-ASCII");
        p31.e(charsetForName5, "forName(...)");
        f = charsetForName5;
        Charset charsetForName6 = Charset.forName("ISO-8859-1");
        p31.e(charsetForName6, "forName(...)");
        g = charsetForName6;
    }

    private gx() {
    }

    public final Charset a() {
        Charset charset = i;
        if (charset != null) {
            return charset;
        }
        Charset charsetForName = Charset.forName("UTF-32BE");
        p31.e(charsetForName, "forName(...)");
        i = charsetForName;
        return charsetForName;
    }

    public final Charset b() {
        Charset charset = h;
        if (charset != null) {
            return charset;
        }
        Charset charsetForName = Charset.forName("UTF-32LE");
        p31.e(charsetForName, "forName(...)");
        h = charsetForName;
        return charsetForName;
    }
}
