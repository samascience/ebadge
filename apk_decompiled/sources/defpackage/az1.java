package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class az1 {
    public final Object a;
    public final Object b;

    public az1(Object obj, Object obj2) {
        this.a = obj;
        this.b = obj2;
    }

    public static az1 a(Object obj, Object obj2) {
        return new az1(obj, obj2);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof az1)) {
            return false;
        }
        az1 az1Var = (az1) obj;
        return tt1.a(az1Var.a, this.a) && tt1.a(az1Var.b, this.b);
    }

    public int hashCode() {
        Object obj = this.a;
        int iHashCode = obj == null ? 0 : obj.hashCode();
        Object obj2 = this.b;
        return iHashCode ^ (obj2 != null ? obj2.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + this.a + " " + this.b + "}";
    }
}
