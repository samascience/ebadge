package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public class cj0 {
    private int a;
    private int b;
    private int c;

    public cj0(int i, int i2, int i3) {
        this.a = i;
        this.b = i2;
        this.c = i3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        cj0 cj0Var = (cj0) obj;
        return this.a == cj0Var.a && this.b == cj0Var.b && this.c == cj0Var.c;
    }

    public int hashCode() {
        return (((this.a * 31) + this.b) * 31) + this.c;
    }
}
