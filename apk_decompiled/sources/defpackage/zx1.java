package defpackage;

import android.hardware.camera2.params.OutputConfiguration;
import android.os.Build;
import android.view.Surface;

/* JADX INFO: loaded from: classes.dex */
public final class zx1 {
    private final a a;

    interface a {
        Surface a();

        void b(long j);

        void c(Surface surface);

        void d(long j);

        String e();

        void f();

        void g(String str);

        void h(int i);

        Object i();
    }

    public zx1(int i, Surface surface) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 33) {
            this.a = new dy1(i, surface);
        } else if (i2 >= 28) {
            this.a = new cy1(i, surface);
        } else {
            this.a = new by1(i, surface);
        }
    }

    public static zx1 j(Object obj) {
        a aVarK;
        if (obj == null) {
            return null;
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 33) {
            aVarK = dy1.l((OutputConfiguration) obj);
        } else {
            aVarK = i >= 28 ? cy1.k((OutputConfiguration) obj) : by1.j((OutputConfiguration) obj);
        }
        if (aVarK == null) {
            return null;
        }
        return new zx1(aVarK);
    }

    public void a(Surface surface) {
        this.a.c(surface);
    }

    public void b() {
        this.a.f();
    }

    public String c() {
        return this.a.e();
    }

    public Surface d() {
        return this.a.a();
    }

    public void e(long j) {
        this.a.d(j);
    }

    public boolean equals(Object obj) {
        if (obj instanceof zx1) {
            return this.a.equals(((zx1) obj).a);
        }
        return false;
    }

    public void f(int i) {
        this.a.h(i);
    }

    public void g(String str) {
        this.a.g(str);
    }

    public void h(long j) {
        this.a.b(j);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public Object i() {
        return this.a.i();
    }

    private zx1(a aVar) {
        this.a = aVar;
    }
}
