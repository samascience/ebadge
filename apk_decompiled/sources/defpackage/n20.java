package defpackage;

import androidx.work.NetworkType;

/* JADX INFO: loaded from: classes.dex */
public final class n20 {
    public static final n20 i = new a().a();
    private NetworkType a;
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;
    private long f;
    private long g;
    private m30 h;

    public static final class a {
        boolean a = false;
        boolean b = false;
        NetworkType c = NetworkType.NOT_REQUIRED;
        boolean d = false;
        boolean e = false;
        long f = -1;
        long g = -1;
        m30 h = new m30();

        public n20 a() {
            return new n20(this);
        }
    }

    public n20() {
        this.a = NetworkType.NOT_REQUIRED;
        this.f = -1L;
        this.g = -1L;
        this.h = new m30();
    }

    public m30 a() {
        return this.h;
    }

    public NetworkType b() {
        return this.a;
    }

    public long c() {
        return this.f;
    }

    public long d() {
        return this.g;
    }

    public boolean e() {
        return this.h.c() > 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || n20.class != obj.getClass()) {
            return false;
        }
        n20 n20Var = (n20) obj;
        if (this.b == n20Var.b && this.c == n20Var.c && this.d == n20Var.d && this.e == n20Var.e && this.f == n20Var.f && this.g == n20Var.g && this.a == n20Var.a) {
            return this.h.equals(n20Var.h);
        }
        return false;
    }

    public boolean f() {
        return this.d;
    }

    public boolean g() {
        return this.b;
    }

    public boolean h() {
        return this.c;
    }

    public int hashCode() {
        int iHashCode = ((((((((this.a.hashCode() * 31) + (this.b ? 1 : 0)) * 31) + (this.c ? 1 : 0)) * 31) + (this.d ? 1 : 0)) * 31) + (this.e ? 1 : 0)) * 31;
        long j = this.f;
        int i2 = (iHashCode + ((int) (j ^ (j >>> 32)))) * 31;
        long j2 = this.g;
        return ((i2 + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.h.hashCode();
    }

    public boolean i() {
        return this.e;
    }

    public void j(m30 m30Var) {
        this.h = m30Var;
    }

    public void k(NetworkType networkType) {
        this.a = networkType;
    }

    public void l(boolean z) {
        this.d = z;
    }

    public void m(boolean z) {
        this.b = z;
    }

    public void n(boolean z) {
        this.c = z;
    }

    public void o(boolean z) {
        this.e = z;
    }

    public void p(long j) {
        this.f = j;
    }

    public void q(long j) {
        this.g = j;
    }

    n20(a aVar) {
        this.a = NetworkType.NOT_REQUIRED;
        this.f = -1L;
        this.g = -1L;
        this.h = new m30();
        this.b = aVar.a;
        this.c = aVar.b;
        this.a = aVar.c;
        this.d = aVar.d;
        this.e = aVar.e;
        this.h = aVar.h;
        this.f = aVar.f;
        this.g = aVar.g;
    }

    public n20(n20 n20Var) {
        this.a = NetworkType.NOT_REQUIRED;
        this.f = -1L;
        this.g = -1L;
        this.h = new m30();
        this.b = n20Var.b;
        this.c = n20Var.c;
        this.a = n20Var.a;
        this.d = n20Var.d;
        this.e = n20Var.e;
        this.h = n20Var.h;
    }
}
