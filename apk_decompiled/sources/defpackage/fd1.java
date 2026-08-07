package defpackage;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public abstract class fd1 {
    private static fd1 a = null;
    private static final int b = 20;

    public static class a extends fd1 {
        private int c;

        public a(int i) {
            super(i);
            this.c = i;
        }

        @Override // defpackage.fd1
        public void a(String str, String str2, Throwable... thArr) {
            if (this.c <= 3) {
                if (thArr == null || thArr.length < 1) {
                    Log.d(str, str2);
                } else {
                    Log.d(str, str2, thArr[0]);
                }
            }
        }

        @Override // defpackage.fd1
        public void b(String str, String str2, Throwable... thArr) {
            if (this.c <= 6) {
                if (thArr == null || thArr.length < 1) {
                    Log.e(str, str2);
                } else {
                    Log.e(str, str2, thArr[0]);
                }
            }
        }

        @Override // defpackage.fd1
        public void d(String str, String str2, Throwable... thArr) {
            if (this.c <= 4) {
                if (thArr == null || thArr.length < 1) {
                    Log.i(str, str2);
                } else {
                    Log.i(str, str2, thArr[0]);
                }
            }
        }

        @Override // defpackage.fd1
        public void g(String str, String str2, Throwable... thArr) {
            if (this.c <= 2) {
                if (thArr == null || thArr.length < 1) {
                    Log.v(str, str2);
                } else {
                    Log.v(str, str2, thArr[0]);
                }
            }
        }

        @Override // defpackage.fd1
        public void h(String str, String str2, Throwable... thArr) {
            if (this.c <= 5) {
                if (thArr == null || thArr.length < 1) {
                    Log.w(str, str2);
                } else {
                    Log.w(str, str2, thArr[0]);
                }
            }
        }
    }

    public fd1(int i) {
    }

    public static synchronized fd1 c() {
        try {
            if (a == null) {
                a = new a(3);
            }
        } catch (Throwable th) {
            throw th;
        }
        return a;
    }

    public static synchronized void e(fd1 fd1Var) {
        a = fd1Var;
    }

    public static String f(String str) {
        int length = str.length();
        StringBuilder sb = new StringBuilder(23);
        sb.append("WM-");
        int i = b;
        if (length >= i) {
            sb.append(str.substring(0, i));
        } else {
            sb.append(str);
        }
        return sb.toString();
    }

    public abstract void a(String str, String str2, Throwable... thArr);

    public abstract void b(String str, String str2, Throwable... thArr);

    public abstract void d(String str, String str2, Throwable... thArr);

    public abstract void g(String str, String str2, Throwable... thArr);

    public abstract void h(String str, String str2, Throwable... thArr);
}
