package defpackage;

/* JADX INFO: loaded from: classes4.dex */
public class nm3 {
    private long a;
    private long b;
    private long c;
    private long d;

    public nm3(long j, long j2, long j3, long j4) {
        this.a = j;
        this.b = j2;
        this.c = j3;
        this.d = j4;
    }

    public long a() {
        return this.d;
    }

    public long b() {
        return this.c;
    }

    public long c() {
        return this.b;
    }

    public long d() {
        return this.a;
    }

    public String toString() {
        return "FlashCheckSumInfo{startLine=" + this.a + ", endLine=" + this.b + ", dataLength=" + this.c + ", checkSum=" + this.d + '}';
    }
}
