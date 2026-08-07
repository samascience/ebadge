package defpackage;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class p43 {
    private static p43 e;
    private gh a;
    private jh b;
    private uq1 c;
    private uu2 d;

    private p43(Context context, w03 w03Var) {
        Context applicationContext = context.getApplicationContext();
        this.a = new gh(applicationContext, w03Var);
        this.b = new jh(applicationContext, w03Var);
        this.c = new uq1(applicationContext, w03Var);
        this.d = new uu2(applicationContext, w03Var);
    }

    public static synchronized p43 c(Context context, w03 w03Var) {
        try {
            if (e == null) {
                e = new p43(context, w03Var);
            }
        } catch (Throwable th) {
            throw th;
        }
        return e;
    }

    public gh a() {
        return this.a;
    }

    public jh b() {
        return this.b;
    }

    public uq1 d() {
        return this.c;
    }

    public uu2 e() {
        return this.d;
    }
}
