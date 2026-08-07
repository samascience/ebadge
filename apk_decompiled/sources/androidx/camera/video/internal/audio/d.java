package androidx.camera.video.internal.audio;

/* JADX INFO: loaded from: classes.dex */
final class d extends AudioStream.b {
    private final int a;
    private final long b;

    d(int i, long j) {
        this.a = i;
        this.b = j;
    }

    @Override // androidx.camera.video.internal.audio.AudioStream.b
    public int a() {
        return this.a;
    }

    @Override // androidx.camera.video.internal.audio.AudioStream.b
    public long b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AudioStream.b)) {
            return false;
        }
        AudioStream.b bVar = (AudioStream.b) obj;
        return this.a == bVar.a() && this.b == bVar.b();
    }

    public int hashCode() {
        int i = (this.a ^ 1000003) * 1000003;
        long j = this.b;
        return i ^ ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        return "PacketInfo{sizeInBytes=" + this.a + ", timestampNs=" + this.b + "}";
    }
}
