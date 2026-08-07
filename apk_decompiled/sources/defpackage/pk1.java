package defpackage;

import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class pk1 {
    int a;
    byte[] b;

    public pk1(int i, byte[] bArr) {
        this.a = i;
        this.b = bArr;
    }

    public byte[] a() {
        return this.b;
    }

    public int b() {
        return this.a;
    }

    public String toString() {
        return "MixStyleModel{mixType=" + this.a + ", configs=" + Arrays.toString(this.b) + '}';
    }
}
