package defpackage;

import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;

/* JADX INFO: loaded from: classes.dex */
public abstract class er3 {
    private static final a.g a;
    private static final a.g b;
    public static final a.AbstractC0075a c;
    private static final a.AbstractC0075a d;
    private static final Scope e;
    private static final Scope f;
    public static final a g;
    private static final a h;

    static {
        a.g gVar = new a.g();
        a = gVar;
        a.g gVar2 = new a.g();
        b = gVar2;
        kr3 kr3Var = new kr3();
        c = kr3Var;
        wr3 wr3Var = new wr3();
        d = wr3Var;
        e = new Scope("profile");
        f = new Scope("email");
        g = new a("SignIn.API", kr3Var, gVar);
        h = new a("SignIn.INTERNAL_API", wr3Var, gVar2);
    }
}
