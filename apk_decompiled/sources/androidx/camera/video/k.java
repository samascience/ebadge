package androidx.camera.video;

/* JADX INFO: loaded from: classes.dex */
final class k extends l0 {
    private final long a;
    private final long b;
    private final b c;

    k(long j, long j2, b bVar) {
        this.a = j;
        this.b = j2;
        if (bVar == null) {
            throw new NullPointerException("Null audioStats");
        }
        this.c = bVar;
    }

    @Override // androidx.camera.video.l0
    public b a() {
        return this.c;
    }

    @Override // androidx.camera.video.l0
    public long b() {
        return this.b;
    }

    @Override // androidx.camera.video.l0
    public long c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof l0)) {
            return false;
        }
        l0 l0Var = (l0) obj;
        return this.a == l0Var.c() && this.b == l0Var.b() && this.c.equals(l0Var.a());
    }

    public int hashCode() {
        long j = this.a;
        int i = (((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003;
        long j2 = this.b;
        return ((i ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003) ^ this.c.hashCode();
    }

    public String toString() {
        return "RecordingStats{recordedDurationNanos=" + this.a + ", numBytesRecorded=" + this.b + ", audioStats=" + this.c + "}";
    }
}
