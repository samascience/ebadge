package defpackage;

import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public final class px1 {
    private static final b e = new a();
    private final Object a;
    private final b b;
    private final String c;
    private volatile byte[] d;

    class a implements b {
        a() {
        }

        @Override // px1.b
        public void a(byte[] bArr, Object obj, MessageDigest messageDigest) {
        }
    }

    public interface b {
        void a(byte[] bArr, Object obj, MessageDigest messageDigest);
    }

    private px1(String str, Object obj, b bVar) {
        this.c = z42.b(str);
        this.a = obj;
        this.b = (b) z42.d(bVar);
    }

    public static px1 a(String str, Object obj, b bVar) {
        return new px1(str, obj, bVar);
    }

    private static b b() {
        return e;
    }

    private byte[] d() {
        if (this.d == null) {
            this.d = this.c.getBytes(w81.a);
        }
        return this.d;
    }

    public static px1 e(String str) {
        return new px1(str, null, b());
    }

    public static px1 f(String str, Object obj) {
        return new px1(str, obj, b());
    }

    public Object c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof px1) {
            return this.c.equals(((px1) obj).c);
        }
        return false;
    }

    public void g(Object obj, MessageDigest messageDigest) {
        this.b.a(d(), obj, messageDigest);
    }

    public int hashCode() {
        return this.c.hashCode();
    }

    public String toString() {
        return "Option{key='" + this.c + "'}";
    }
}
