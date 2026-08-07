package defpackage;

import com.tencent.connect.common.Constants;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class hi1 {
    static final Class[] c = new Class[0];
    final String a;
    final Class[] b;

    public hi1(Method method) {
        this(method.getName(), method.getParameterTypes());
    }

    public int a() {
        return this.b.length;
    }

    public String b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != hi1.class) {
            return false;
        }
        hi1 hi1Var = (hi1) obj;
        if (!this.a.equals(hi1Var.a)) {
            return false;
        }
        Class[] clsArr = hi1Var.b;
        int length = this.b.length;
        if (clsArr.length != length) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (clsArr[i] != this.b[i]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return this.a.hashCode() + this.b.length;
    }

    public String toString() {
        return this.a + "(" + this.b.length + "-args)";
    }

    public hi1(Constructor constructor) {
        this(Constants.STR_EMPTY, constructor.getParameterTypes());
    }

    public hi1(String str, Class[] clsArr) {
        this.a = str;
        this.b = clsArr == null ? c : clsArr;
    }
}
