package defpackage;

/* JADX INFO: loaded from: classes4.dex */
public class tf2 {
    private boolean a;
    private String b;
    private String c;
    private String d;
    private int e = -1;
    private int f = -1;
    private int g = -1;
    private String h = "null";
    private long i = -1;
    private String j = "null";
    private long k;
    private long l;

    tf2(boolean z, String str, String str2, String str3) {
        this.a = z;
        this.b = str;
        this.c = str2;
        this.d = str3;
    }

    public int a() {
        return this.f;
    }

    public long b() {
        return this.i;
    }

    public int c() {
        return this.g;
    }

    public int d() {
        return this.e;
    }

    public String e() {
        return this.j;
    }

    public long f() {
        return this.l;
    }

    public long g() {
        return this.k;
    }

    public String h() {
        return this.h;
    }

    public boolean i() {
        return this.a;
    }

    public void j(int i) {
        this.f = i;
    }

    public void k(long j) {
        this.i = j;
    }

    public void l(int i) {
        this.g = i;
    }

    public void m(int i) {
        this.e = i;
    }

    public void n(String str) {
        this.j = str;
    }

    public void o(long j) {
        this.l = j;
    }

    public void p(long j) {
        this.k = j;
    }

    public void q(String str) {
        this.h = str;
    }

    public String r() {
        return "ResResult{isSuccessful=" + this.a + ", rcvOtaFlag='" + this.b + "', resultCode='" + this.c + "', resultCodeMean='" + this.d + "', buckSize=" + this.f + "', packetMaxLen=" + this.g + '}';
    }

    public String s() {
        return "ResResult{isSuccessful=" + this.a + ", rcvOtaFlag='" + this.b + "', resultCode='" + this.c + "', resultCodeMean='" + this.d + "', flashCheckSum=" + this.i + '}';
    }

    public String t() {
        return "ResResult{isSuccessful=" + this.a + ", rcvOtaFlag='" + this.b + "', resultCode='" + this.c + "', resultCodeMean='" + this.d + ", updateFlashMode='" + this.j + "', upgradeFlashLength='" + this.k + "', upgradeFlashCheckSum='" + this.l + "'}";
    }

    public String toString() {
        return "ResResult{isSuccessful=" + this.a + ", rcvOtaFlag='" + this.b + "', resultCode='" + this.c + "', resultCodeMean='" + this.d + "'}";
    }

    public String u() {
        return "ResResult{isSuccessful=" + this.a + ", rcvOtaFlag='" + this.b + "', resultCode='" + this.c + "', resultCodeMean='" + this.d + "', protocolVerCode=" + this.e + '}';
    }

    public String v() {
        return "ResResult{isSuccessful=" + this.a + ", rcvOtaFlag='" + this.b + "', resultCode='" + this.c + "', resultCodeMean='" + this.d + ", updateFlashMode='" + this.j + "'}";
    }

    public String w() {
        return "ResResult{isSuccessful=" + this.a + ", rcvOtaFlag='" + this.b + "', resultCode='" + this.c + "', resultCodeMean='" + this.d + '}';
    }

    public String x() {
        return "ResResult{isSuccessful=" + this.a + ", rcvOtaFlag='" + this.b + "', resultCode='" + this.c + "', resultCodeMean='" + this.d + "', workMode='" + this.h + "'}";
    }
}
