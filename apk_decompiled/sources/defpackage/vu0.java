package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class vu0 {
    private final String a;
    private final String b;

    public vu0(String str) {
        this(str, null);
    }

    public vu0(String str, String str2) {
        a52.h(str, "log tag cannot be null");
        a52.c(str.length() <= 23, "tag \"%s\" is longer than the %d character maximum", str, 23);
        this.a = str;
        if (str2 == null || str2.length() <= 0) {
            this.b = null;
        } else {
            this.b = str2;
        }
    }
}
