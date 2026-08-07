package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class c52 {
    public String a;
    public Long b;

    public c52(String str, boolean z) {
        this(str, z ? 1L : 0L);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c52)) {
            return false;
        }
        c52 c52Var = (c52) obj;
        if (!this.a.equals(c52Var.a)) {
            return false;
        }
        Long l = this.b;
        Long l2 = c52Var.b;
        if (l != null) {
            return l.equals(l2);
        }
        return l2 == null;
    }

    public int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        Long l = this.b;
        return iHashCode + (l != null ? l.hashCode() : 0);
    }

    public c52(String str, long j) {
        this.a = str;
        this.b = Long.valueOf(j);
    }
}
