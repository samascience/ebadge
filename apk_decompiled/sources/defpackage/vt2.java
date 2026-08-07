package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class vt2 {
    private long a;
    private int b;
    private float c;
    private float d;
    private long e;
    private double f;
    private double g;
    private double h;

    public vt2(long j, int i, float f, float f2, long j2, double d, double d2, double d3) {
        this.a = j;
        this.b = i;
        this.c = f;
        this.d = f2;
        this.e = j2;
        this.f = d;
        this.g = d2;
        this.h = d3;
    }

    public double a() {
        return this.f;
    }

    public String toString() {
        return "Statistics{sessionId=" + this.a + ", videoFrameNumber=" + this.b + ", videoFps=" + this.c + ", videoQuality=" + this.d + ", size=" + this.e + ", time=" + this.f + ", bitrate=" + this.g + ", speed=" + this.h + '}';
    }
}
