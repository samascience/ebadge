package androidx.databinding;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class c implements Cloneable {
    private List a = new ArrayList();
    private long b = 0;
    private long[] c;
    private int d;
    private final a e;

    public static abstract class a {
        public abstract void a(Object obj, Object obj2, int i, Object obj3);
    }

    public c(a aVar) {
        this.e = aVar;
    }

    private boolean c(int i) {
        int i2;
        if (i < 64) {
            return ((1 << i) & this.b) != 0;
        }
        long[] jArr = this.c;
        if (jArr != null && (i2 = (i / 64) - 1) < jArr.length) {
            return ((1 << (i % 64)) & jArr[i2]) != 0;
        }
        return false;
    }

    private void e(Object obj, int i, Object obj2, int i2, int i3, long j) {
        long j2 = 1;
        while (i2 < i3) {
            if ((j & j2) == 0) {
                this.e.a(this.a.get(i2), obj, i, obj2);
            }
            j2 <<= 1;
            i2++;
        }
    }

    private void f(Object obj, int i, Object obj2) {
        e(obj, i, obj2, 0, Math.min(64, this.a.size()), this.b);
    }

    private void g(Object obj, int i, Object obj2) {
        int size = this.a.size();
        long[] jArr = this.c;
        int length = jArr == null ? -1 : jArr.length - 1;
        h(obj, i, obj2, length);
        e(obj, i, obj2, (length + 2) * 64, size, 0L);
    }

    private void h(Object obj, int i, Object obj2, int i2) {
        if (i2 < 0) {
            f(obj, i, obj2);
            return;
        }
        long j = this.c[i2];
        int i3 = (i2 + 1) * 64;
        int iMin = Math.min(this.a.size(), i3 + 64);
        h(obj, i, obj2, i2 - 1);
        e(obj, i, obj2, i3, iMin, j);
    }

    private void j(int i, long j) {
        long j2 = Long.MIN_VALUE;
        for (int i2 = i + 63; i2 >= i; i2--) {
            if ((j & j2) != 0) {
                this.a.remove(i2);
            }
            j2 >>>= 1;
        }
    }

    private void k(int i) {
        if (i < 64) {
            this.b = (1 << i) | this.b;
            return;
        }
        int i2 = (i / 64) - 1;
        long[] jArr = this.c;
        if (jArr == null) {
            this.c = new long[this.a.size() / 64];
        } else if (jArr.length <= i2) {
            long[] jArr2 = new long[this.a.size() / 64];
            long[] jArr3 = this.c;
            System.arraycopy(jArr3, 0, jArr2, 0, jArr3.length);
            this.c = jArr2;
        }
        long j = 1 << (i % 64);
        long[] jArr4 = this.c;
        jArr4[i2] = j | jArr4[i2];
    }

    public synchronized void a(Object obj) {
        try {
            if (obj == null) {
                throw new IllegalArgumentException("callback cannot be null");
            }
            int iLastIndexOf = this.a.lastIndexOf(obj);
            if (iLastIndexOf < 0 || c(iLastIndexOf)) {
                this.a.add(obj);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public synchronized c clone() {
        c cVar;
        CloneNotSupportedException e;
        try {
            cVar = (c) super.clone();
            try {
                cVar.b = 0L;
                cVar.c = null;
                cVar.d = 0;
                cVar.a = new ArrayList();
                int size = this.a.size();
                for (int i = 0; i < size; i++) {
                    if (!c(i)) {
                        cVar.a.add(this.a.get(i));
                    }
                }
            } catch (CloneNotSupportedException e2) {
                e = e2;
                e.printStackTrace();
            }
        } catch (CloneNotSupportedException e3) {
            cVar = null;
            e = e3;
        }
        return cVar;
    }

    public synchronized void d(Object obj, int i, Object obj2) {
        try {
            this.d++;
            g(obj, i, obj2);
            int i2 = this.d - 1;
            this.d = i2;
            if (i2 == 0) {
                long[] jArr = this.c;
                if (jArr != null) {
                    for (int length = jArr.length - 1; length >= 0; length--) {
                        long j = this.c[length];
                        if (j != 0) {
                            j((length + 1) * 64, j);
                            this.c[length] = 0;
                        }
                    }
                }
                long j2 = this.b;
                if (j2 != 0) {
                    j(0, j2);
                    this.b = 0L;
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void i(Object obj) {
        try {
            if (this.d == 0) {
                this.a.remove(obj);
            } else {
                int iLastIndexOf = this.a.lastIndexOf(obj);
                if (iLastIndexOf >= 0) {
                    k(iLastIndexOf);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
