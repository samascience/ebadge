package defpackage;

/* JADX INFO: loaded from: classes4.dex */
public class nr1 {
    final String a;
    final Object[] b;
    final Throwable c;

    public nr1(String str, Object[] objArr, Throwable th) {
        this.a = str;
        this.b = objArr;
        this.c = th;
    }

    public static Throwable c(Object[] objArr) {
        if (objArr != null && objArr.length != 0) {
            Object obj = objArr[objArr.length - 1];
            if (obj instanceof Throwable) {
                return (Throwable) obj;
            }
        }
        return null;
    }

    public static nr1 d(md1 md1Var) {
        return e(md1Var.a(), md1Var.b(), md1Var.e());
    }

    public static nr1 e(String str, Object[] objArr, Throwable th) {
        if (th != null) {
            return new nr1(str, objArr, th);
        }
        if (objArr == null || objArr.length == 0) {
            return new nr1(str, objArr, th);
        }
        Throwable thC = c(objArr);
        return thC != null ? new nr1(str, fj1.q(objArr), thC) : new nr1(str, objArr);
    }

    public static Object[] f(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            throw new IllegalStateException("non-sensical empty or null argument array");
        }
        int length = objArr.length - 1;
        Object[] objArr2 = new Object[length];
        if (length > 0) {
            System.arraycopy(objArr, 0, objArr2, 0, length);
        }
        return objArr2;
    }

    public Object[] a() {
        return this.b;
    }

    public String b() {
        return this.a;
    }

    public nr1(String str, Object[] objArr) {
        this(str, objArr, null);
    }
}
