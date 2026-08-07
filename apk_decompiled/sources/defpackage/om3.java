package defpackage;

/* JADX INFO: loaded from: classes4.dex */
public class om3 {
    private String a = "-";
    private String b = "-";
    private long c = -1;
    private String d = "-";

    public String a() {
        return this.b;
    }

    public String b() {
        return this.a;
    }

    public long c() {
        return this.c;
    }

    public String d() {
        return this.d;
    }

    public void e(String str) {
        this.b = str;
    }

    public void f(String str) {
        this.a = str;
    }

    public void g(long j) {
        this.c = j;
    }

    public void h(String str) {
        this.d = str;
    }

    public String toString() {
        return "_3GenOtaFlashInfo{name='" + this.a + "', address='" + this.b + "', svnVersion=" + this.c + ", svnVersionDate='" + this.d + "'}";
    }
}
