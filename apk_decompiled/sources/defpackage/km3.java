package defpackage;

/* JADX INFO: loaded from: classes4.dex */
public abstract class km3 {
    protected String a;
    protected int b;
    protected String c;
    protected byte[] d;
    protected int e;
    protected int f;

    public int a() {
        return this.e;
    }

    public int b() {
        return this.f;
    }

    public byte[] c() {
        return this.d;
    }

    public void d(int i) {
        this.f = i;
    }

    public String toString() {
        return "name: " + this.a + ", type: " + this.b + ", value: " + c() + ", detail: " + this.c;
    }
}
