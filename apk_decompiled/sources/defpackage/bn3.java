package defpackage;

import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class bn3 {
    public int a;
    public long b;
    public int c;
    public int d;
    public int e;
    public int f;
    public long g;
    public int h;
    public char i;
    public int j;
    public int k;
    public int l;
    public String m;
    public String n;
    private boolean o;

    public bn3() {
        this.a = -1;
        this.b = -1L;
        this.c = -1;
        this.d = -1;
        this.e = Integer.MAX_VALUE;
        this.f = Integer.MAX_VALUE;
        this.g = 0L;
        this.h = -1;
        this.i = '0';
        this.j = Integer.MAX_VALUE;
        this.k = 0;
        this.l = 0;
        this.m = null;
        this.n = null;
        this.o = false;
        this.g = System.currentTimeMillis();
    }

    public boolean a() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = this.g;
        return jCurrentTimeMillis - j > 0 && jCurrentTimeMillis - j < 3000;
    }

    public boolean b(bn3 bn3Var) {
        return this.a == bn3Var.a && this.b == bn3Var.b && this.d == bn3Var.d && this.c == bn3Var.c;
    }

    public boolean c() {
        return this.a > -1 && this.b > 0;
    }

    public boolean d() {
        return this.a == -1 && this.b == -1 && this.d == -1 && this.c == -1;
    }

    public boolean e() {
        return this.a > -1 && this.b > -1 && this.d == -1 && this.c == -1;
    }

    public boolean f() {
        return this.a > -1 && this.b > -1 && this.d > -1 && this.c > -1;
    }

    public void g() {
        this.o = true;
    }

    public String h() {
        return String.format(Locale.CHINA, "%d|%d|%d|%d", Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.a), Long.valueOf(this.b));
    }

    public String i() {
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append("&nw=");
        stringBuffer.append(this.i);
        stringBuffer.append(String.format(Locale.CHINA, "&cl=%d|%d|%d|%d&cl_s=%d&clp=%d", Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.a), Long.valueOf(this.b), Integer.valueOf(this.h), Integer.valueOf(this.k)));
        stringBuffer.append("&cl_t=");
        stringBuffer.append(this.g);
        if (this.j != Integer.MAX_VALUE) {
            stringBuffer.append("&cl_cs=");
            stringBuffer.append(this.j);
        }
        if (this.o) {
            stringBuffer.append("&newcl=1");
        }
        stringBuffer.append("&cl_api=");
        stringBuffer.append(this.l);
        if (this.n != null) {
            stringBuffer.append("&clnrs=");
            stringBuffer.append(this.n);
        }
        stringBuffer.append("&cl_list=");
        stringBuffer.append(so3.y());
        return stringBuffer.toString();
    }

    public String j() {
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append("&nw2=");
        stringBuffer.append(this.i);
        stringBuffer.append(String.format(Locale.CHINA, "&cl2=%d|%d|%d|%d&cl_s2=%d&clp2=%d&cl_t2=%d", Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.a), Long.valueOf(this.b), Integer.valueOf(this.h), Integer.valueOf(this.k), Long.valueOf(this.g)));
        if (this.j != Integer.MAX_VALUE) {
            stringBuffer.append("&cl_cs2=");
            stringBuffer.append(this.j);
        }
        if (this.n != null) {
            stringBuffer.append("&clnrs2=");
            stringBuffer.append(this.n);
        }
        return stringBuffer.toString();
    }

    public bn3(int i, long j, int i2, int i3, int i4, char c, int i5) {
        this.e = Integer.MAX_VALUE;
        this.f = Integer.MAX_VALUE;
        this.g = 0L;
        this.j = Integer.MAX_VALUE;
        this.k = 0;
        this.l = 0;
        this.m = null;
        this.n = null;
        this.o = false;
        this.a = i;
        this.b = j;
        this.c = i2;
        this.d = i3;
        this.h = i4;
        this.i = c;
        this.g = System.currentTimeMillis();
        this.j = i5;
    }

    public bn3(bn3 bn3Var) {
        this(bn3Var.a, bn3Var.b, bn3Var.c, bn3Var.d, bn3Var.h, bn3Var.i, bn3Var.j);
        this.g = bn3Var.g;
        this.m = bn3Var.m;
        this.k = bn3Var.k;
        this.n = bn3Var.n;
        this.l = bn3Var.l;
    }
}
