package defpackage;

import androidx.work.BackoffPolicy;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo$State;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class xk3 {
    private static final String s = fd1.f("WorkSpec");
    public static final wr0 t = new a();
    public String a;
    public WorkInfo$State b;
    public String c;
    public String d;
    public androidx.work.b e;
    public androidx.work.b f;
    public long g;
    public long h;
    public long i;
    public n20 j;
    public int k;
    public BackoffPolicy l;
    public long m;
    public long n;
    public long o;
    public long p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f444q;
    public OutOfQuotaPolicy r;

    class a implements wr0 {
        a() {
        }

        @Override // defpackage.wr0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List apply(List list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            Iterator it = list.iterator();
            if (!it.hasNext()) {
                return arrayList;
            }
            e43.a(it.next());
            throw null;
        }
    }

    public static class b {
        public String a;
        public WorkInfo$State b;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (this.b != bVar.b) {
                return false;
            }
            return this.a.equals(bVar.a);
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }
    }

    public xk3(String str, String str2) {
        this.b = WorkInfo$State.ENQUEUED;
        androidx.work.b bVar = androidx.work.b.c;
        this.e = bVar;
        this.f = bVar;
        this.j = n20.i;
        this.l = BackoffPolicy.EXPONENTIAL;
        this.m = 30000L;
        this.p = -1L;
        this.r = OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST;
        this.a = str;
        this.c = str2;
    }

    public long a() {
        if (c()) {
            return this.n + Math.min(18000000L, this.l == BackoffPolicy.LINEAR ? this.m * ((long) this.k) : (long) Math.scalb(this.m, this.k - 1));
        }
        if (!d()) {
            long jCurrentTimeMillis = this.n;
            if (jCurrentTimeMillis == 0) {
                jCurrentTimeMillis = System.currentTimeMillis();
            }
            return jCurrentTimeMillis + this.g;
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        long j = this.n;
        long j2 = j == 0 ? jCurrentTimeMillis2 + this.g : j;
        long j3 = this.i;
        long j4 = this.h;
        if (j3 != j4) {
            return j2 + j4 + (j == 0 ? j3 * (-1) : 0L);
        }
        return j2 + (j != 0 ? j4 : 0L);
    }

    public boolean b() {
        return !n20.i.equals(this.j);
    }

    public boolean c() {
        return this.b == WorkInfo$State.ENQUEUED && this.k > 0;
    }

    public boolean d() {
        return this.h != 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || xk3.class != obj.getClass()) {
            return false;
        }
        xk3 xk3Var = (xk3) obj;
        if (this.g != xk3Var.g || this.h != xk3Var.h || this.i != xk3Var.i || this.k != xk3Var.k || this.m != xk3Var.m || this.n != xk3Var.n || this.o != xk3Var.o || this.p != xk3Var.p || this.f444q != xk3Var.f444q || !this.a.equals(xk3Var.a) || this.b != xk3Var.b || !this.c.equals(xk3Var.c)) {
            return false;
        }
        String str = this.d;
        if (str == null ? xk3Var.d == null : str.equals(xk3Var.d)) {
            return this.e.equals(xk3Var.e) && this.f.equals(xk3Var.f) && this.j.equals(xk3Var.j) && this.l == xk3Var.l && this.r == xk3Var.r;
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        String str = this.d;
        int iHashCode2 = (((((iHashCode + (str != null ? str.hashCode() : 0)) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31;
        long j = this.g;
        int i = (iHashCode2 + ((int) (j ^ (j >>> 32)))) * 31;
        long j2 = this.h;
        int i2 = (i + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        long j3 = this.i;
        int iHashCode3 = (((((((i2 + ((int) (j3 ^ (j3 >>> 32)))) * 31) + this.j.hashCode()) * 31) + this.k) * 31) + this.l.hashCode()) * 31;
        long j4 = this.m;
        int i3 = (iHashCode3 + ((int) (j4 ^ (j4 >>> 32)))) * 31;
        long j5 = this.n;
        int i4 = (i3 + ((int) (j5 ^ (j5 >>> 32)))) * 31;
        long j6 = this.o;
        int i5 = (i4 + ((int) (j6 ^ (j6 >>> 32)))) * 31;
        long j7 = this.p;
        return ((((i5 + ((int) (j7 ^ (j7 >>> 32)))) * 31) + (this.f444q ? 1 : 0)) * 31) + this.r.hashCode();
    }

    public String toString() {
        return "{WorkSpec: " + this.a + "}";
    }

    public xk3(xk3 xk3Var) {
        this.b = WorkInfo$State.ENQUEUED;
        androidx.work.b bVar = androidx.work.b.c;
        this.e = bVar;
        this.f = bVar;
        this.j = n20.i;
        this.l = BackoffPolicy.EXPONENTIAL;
        this.m = 30000L;
        this.p = -1L;
        this.r = OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST;
        this.a = xk3Var.a;
        this.c = xk3Var.c;
        this.b = xk3Var.b;
        this.d = xk3Var.d;
        this.e = new androidx.work.b(xk3Var.e);
        this.f = new androidx.work.b(xk3Var.f);
        this.g = xk3Var.g;
        this.h = xk3Var.h;
        this.i = xk3Var.i;
        this.j = new n20(xk3Var.j);
        this.k = xk3Var.k;
        this.l = xk3Var.l;
        this.m = xk3Var.m;
        this.n = xk3Var.n;
        this.o = xk3Var.o;
        this.p = xk3Var.p;
        this.f444q = xk3Var.f444q;
        this.r = xk3Var.r;
    }
}
