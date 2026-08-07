package defpackage;

/* JADX INFO: loaded from: classes4.dex */
public class uz2 {
    private final r60 a;
    private final String b;
    private final String[] c;
    private final String[] d;
    private s60 e;
    private s60 f;
    private s60 g;
    private s60 h;
    private s60 i;
    private volatile String j;
    private volatile String k;
    private volatile String l;

    public uz2(r60 r60Var, String str, String[] strArr, String[] strArr2) {
        this.a = r60Var;
        this.b = str;
        this.c = strArr;
        this.d = strArr2;
    }

    public s60 a() {
        if (this.i == null) {
            this.i = this.a.g(ht2.i(this.b));
        }
        return this.i;
    }

    public s60 b() {
        if (this.h == null) {
            s60 s60VarG = this.a.g(ht2.j(this.b, this.d));
            synchronized (this) {
                try {
                    if (this.h == null) {
                        this.h = s60VarG;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (this.h != s60VarG) {
                s60VarG.close();
            }
        }
        return this.h;
    }

    public s60 c() {
        if (this.f == null) {
            s60 s60VarG = this.a.g(ht2.k("INSERT OR REPLACE INTO ", this.b, this.c));
            synchronized (this) {
                try {
                    if (this.f == null) {
                        this.f = s60VarG;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (this.f != s60VarG) {
                s60VarG.close();
            }
        }
        return this.f;
    }

    public s60 d() {
        if (this.e == null) {
            s60 s60VarG = this.a.g(ht2.k("INSERT INTO ", this.b, this.c));
            synchronized (this) {
                try {
                    if (this.e == null) {
                        this.e = s60VarG;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (this.e != s60VarG) {
                s60VarG.close();
            }
        }
        return this.e;
    }

    public String e() {
        if (this.j == null) {
            this.j = ht2.l(this.b, "T", this.c, false);
        }
        return this.j;
    }

    public String f() {
        if (this.k == null) {
            StringBuilder sb = new StringBuilder(e());
            sb.append("WHERE ");
            ht2.e(sb, "T", this.d);
            this.k = sb.toString();
        }
        return this.k;
    }

    public String g() {
        if (this.l == null) {
            this.l = e() + "WHERE ROWID=?";
        }
        return this.l;
    }

    public s60 h() {
        if (this.g == null) {
            s60 s60VarG = this.a.g(ht2.m(this.b, this.c, this.d));
            synchronized (this) {
                try {
                    if (this.g == null) {
                        this.g = s60VarG;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (this.g != s60VarG) {
                s60VarG.close();
            }
        }
        return this.g;
    }
}
