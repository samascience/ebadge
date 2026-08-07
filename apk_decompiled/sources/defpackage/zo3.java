package defpackage;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public final class zo3 {
    private static po3 b = null;
    private static String c = "";
    private final Context a;

    private zo3(Context context) {
        this.a = context.getApplicationContext();
    }

    static String a() {
        if (TextUtils.isEmpty(c)) {
            c = "0newiqr3mini0";
        }
        return c;
    }

    public static String b(Context context) {
        return d(context).c();
    }

    private po3 c() {
        po3 po3VarH = po3.h(this.a);
        boolean z = po3VarH == null;
        if (po3VarH == null) {
            xm3 xm3VarE = xm3.e(this.a);
            if (xm3VarE == null) {
                po3VarH = po3.b(this.a, a());
            } else {
                xm3VarE.k();
                po3VarH = po3.a(xm3VarE);
            }
        }
        if (z) {
            po3VarH.g(this.a);
        }
        xm3.d(this.a);
        return po3VarH;
    }

    private static po3 d(Context context) {
        if (b == null) {
            synchronized (po3.class) {
                try {
                    if (b == null) {
                        b = new zo3(context).c();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }
}
