package defpackage;

/* JADX INFO: loaded from: classes.dex */
public abstract class jy {
    public static vv0 a(s10 s10Var, String str) {
        if (str == null) {
            str = "https";
        }
        return str.toLowerCase().startsWith("http") ? new cu1(au1.b()) : new gu1(au1.b(), false);
    }

    public static vv0 b(String str) {
        return a(null, str);
    }
}
