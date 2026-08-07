package defpackage;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public abstract class wk3 {
    private UUID a;
    private xk3 b;
    private Set c;

    public static abstract class a {
        xk3 c;
        Class e;
        boolean a = false;
        Set d = new HashSet();
        UUID b = UUID.randomUUID();

        a(Class cls) {
            this.e = cls;
            this.c = new xk3(this.b.toString(), cls.getName());
            a(cls.getName());
        }

        public final a a(String str) {
            this.d.add(str);
            return d();
        }

        public final wk3 b() {
            wk3 wk3VarC = c();
            n20 n20Var = this.c.j;
            boolean z = n20Var.e() || n20Var.f() || n20Var.g() || n20Var.h();
            xk3 xk3Var = this.c;
            if (xk3Var.f444q) {
                if (z) {
                    throw new IllegalArgumentException("Expedited jobs only support network and storage constraints");
                }
                if (xk3Var.g > 0) {
                    throw new IllegalArgumentException("Expedited jobs cannot be delayed");
                }
            }
            this.b = UUID.randomUUID();
            xk3 xk3Var2 = new xk3(this.c);
            this.c = xk3Var2;
            xk3Var2.a = this.b.toString();
            return wk3VarC;
        }

        abstract wk3 c();

        abstract a d();
    }

    protected wk3(UUID uuid, xk3 xk3Var, Set set) {
        this.a = uuid;
        this.b = xk3Var;
        this.c = set;
    }

    public String a() {
        return this.a.toString();
    }

    public Set b() {
        return this.c;
    }

    public xk3 c() {
        return this.b;
    }
}
