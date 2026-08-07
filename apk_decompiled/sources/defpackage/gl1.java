package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class gl1 {
    private Class a;
    private Class b;
    private Class c;

    public gl1() {
    }

    public void a(Class cls, Class cls2, Class cls3) {
        this.a = cls;
        this.b = cls2;
        this.c = cls3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        gl1 gl1Var = (gl1) obj;
        return this.a.equals(gl1Var.a) && this.b.equals(gl1Var.b) && na3.c(this.c, gl1Var.c);
    }

    public int hashCode() {
        int iHashCode = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        Class cls = this.c;
        return iHashCode + (cls != null ? cls.hashCode() : 0);
    }

    public String toString() {
        return "MultiClassKey{first=" + this.a + ", second=" + this.b + '}';
    }

    public gl1(Class cls, Class cls2, Class cls3) {
        a(cls, cls2, cls3);
    }
}
