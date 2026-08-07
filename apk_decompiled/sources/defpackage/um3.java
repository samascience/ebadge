package defpackage;

import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes4.dex */
public abstract class um3 {
    public static final byte[] a(String str) {
        p31.f(str, "<this>");
        byte[] bytes = str.getBytes(gx.b);
        p31.e(bytes, "this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    public static final ReentrantLock b() {
        return new ReentrantLock();
    }

    public static final String c(byte[] bArr) {
        p31.f(bArr, "<this>");
        return new String(bArr, gx.b);
    }
}
