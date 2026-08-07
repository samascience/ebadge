package defpackage;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public class ci2 implements rw2, qw2 {
    static final TreeMap i = new TreeMap();
    private volatile String a;
    final long[] b;
    final double[] c;
    final String[] d;
    final byte[][] e;
    private final int[] f;
    final int g;
    int h;

    private ci2(int i2) {
        this.g = i2;
        int i3 = i2 + 1;
        this.f = new int[i3];
        this.b = new long[i3];
        this.c = new double[i3];
        this.d = new String[i3];
        this.e = new byte[i3][];
    }

    private static void C() {
        TreeMap treeMap = i;
        if (treeMap.size() <= 15) {
            return;
        }
        int size = treeMap.size() - 10;
        Iterator it = treeMap.descendingKeySet().iterator();
        while (true) {
            int i2 = size - 1;
            if (size <= 0) {
                return;
            }
            it.next();
            it.remove();
            size = i2;
        }
    }

    public static ci2 w(String str, int i2) {
        TreeMap treeMap = i;
        synchronized (treeMap) {
            try {
                Map.Entry entryCeilingEntry = treeMap.ceilingEntry(Integer.valueOf(i2));
                if (entryCeilingEntry == null) {
                    ci2 ci2Var = new ci2(i2);
                    ci2Var.y(str, i2);
                    return ci2Var;
                }
                treeMap.remove(entryCeilingEntry.getKey());
                ci2 ci2Var2 = (ci2) entryCeilingEntry.getValue();
                ci2Var2.y(str, i2);
                return ci2Var2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void D() {
        TreeMap treeMap = i;
        synchronized (treeMap) {
            treeMap.put(Integer.valueOf(this.g), this);
            C();
        }
    }

    @Override // defpackage.qw2
    public void R(int i2, byte[] bArr) {
        this.f[i2] = 5;
        this.e[i2] = bArr;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // defpackage.qw2
    public void f(int i2, String str) {
        this.f[i2] = 4;
        this.d[i2] = str;
    }

    @Override // defpackage.qw2
    public void h(int i2, double d) {
        this.f[i2] = 3;
        this.c[i2] = d;
    }

    @Override // defpackage.qw2
    public void i(int i2, long j) {
        this.f[i2] = 2;
        this.b[i2] = j;
    }

    @Override // defpackage.qw2
    public void l0(int i2) {
        this.f[i2] = 1;
    }

    @Override // defpackage.rw2
    public String n() {
        return this.a;
    }

    @Override // defpackage.rw2
    public void u(qw2 qw2Var) {
        for (int i2 = 1; i2 <= this.h; i2++) {
            int i3 = this.f[i2];
            if (i3 == 1) {
                qw2Var.l0(i2);
            } else if (i3 == 2) {
                qw2Var.i(i2, this.b[i2]);
            } else if (i3 == 3) {
                qw2Var.h(i2, this.c[i2]);
            } else if (i3 == 4) {
                qw2Var.f(i2, this.d[i2]);
            } else if (i3 == 5) {
                qw2Var.R(i2, this.e[i2]);
            }
        }
    }

    void y(String str, int i2) {
        this.a = str;
        this.h = i2;
    }
}
