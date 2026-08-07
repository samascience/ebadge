package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class pg2 {
    private final Class a;
    private final og2[] b;
    private final int c;

    public pg2(Class cls) {
        this(cls, null);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass() == getClass()) {
            pg2 pg2Var = (pg2) obj;
            if (pg2Var.a != this.a) {
                return false;
            }
            og2[] og2VarArr = pg2Var.b;
            og2[] og2VarArr2 = this.b;
            if (og2VarArr2 == null) {
                return og2VarArr == null;
            }
            if (og2VarArr != null && og2VarArr.length == og2VarArr2.length) {
                int length = og2VarArr2.length;
                for (int i = 0; i < length; i++) {
                    if (!this.b[i].equals(og2VarArr[i])) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[CacheKey: ");
        sb.append(this.a.getName());
        sb.append('(');
        if (this.b != null) {
            for (int i = 0; i < this.b.length; i++) {
                if (i > 0) {
                    sb.append(',');
                }
                sb.append(this.b[i]);
            }
        }
        sb.append(")]");
        return sb.toString();
    }

    public pg2(Class cls, og2[] og2VarArr) {
        if (og2VarArr != null && og2VarArr.length == 0) {
            og2VarArr = null;
        }
        this.a = cls;
        this.b = og2VarArr;
        int iHashCode = cls.getName().hashCode();
        this.c = og2VarArr != null ? iHashCode + og2VarArr.length : iHashCode;
    }
}
