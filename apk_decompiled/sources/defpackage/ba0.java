package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public class ba0 extends ng {
    private String a;
    private String b;
    private String c;

    public String a() {
        return this.b;
    }

    public String b() {
        return this.c;
    }

    public String c() {
        return this.a;
    }

    public void d(String str) {
        this.b = str;
    }

    public void e(String str) {
        this.c = str;
    }

    public void f(String str) {
        this.a = str;
    }

    public String toString() {
        return "DeviceHardInfoEvent{led='" + this.a + "', gsensor='" + this.b + "', heart='" + this.c + "'}";
    }
}
