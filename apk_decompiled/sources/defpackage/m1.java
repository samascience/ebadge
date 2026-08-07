package defpackage;

import org.greenrobot.greendao.DaoException;

/* JADX INFO: loaded from: classes4.dex */
abstract class m1 {
    protected final y0 a;
    protected final o31 b;
    protected final String c;
    protected final String[] d;
    protected final Thread e = Thread.currentThread();

    protected m1(y0 y0Var, String str, String[] strArr) {
        this.a = y0Var;
        this.b = new o31(y0Var);
        this.c = str;
        this.d = strArr;
    }

    protected static String[] c(Object[] objArr) {
        int length = objArr.length;
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            Object obj = objArr[i];
            if (obj != null) {
                strArr[i] = obj.toString();
            } else {
                strArr[i] = null;
            }
        }
        return strArr;
    }

    protected void a() {
        if (Thread.currentThread() != this.e) {
            throw new DaoException("Method may be called only in owner thread, use forCurrentThread to get an instance for this thread");
        }
    }

    public m1 b(int i, Object obj) {
        a();
        if (obj != null) {
            this.d[i] = obj.toString();
        } else {
            this.d[i] = null;
        }
        return this;
    }
}
