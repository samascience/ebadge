package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class gz2 {
    public final String a;
    public final int b;

    public gz2(String str, int i) {
        this.a = str;
        this.b = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof gz2)) {
            return false;
        }
        gz2 gz2Var = (gz2) obj;
        if (this.b != gz2Var.b) {
            return false;
        }
        return this.a.equals(gz2Var.a);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b;
    }
}
