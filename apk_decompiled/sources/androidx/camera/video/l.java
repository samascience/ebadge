package androidx.camera.video;

import androidx.camera.core.SurfaceRequest;

/* JADX INFO: loaded from: classes.dex */
final class l extends StreamInfo {
    private final int d;
    private final StreamInfo.StreamState e;
    private final SurfaceRequest.g f;

    l(int i, StreamInfo.StreamState streamState, SurfaceRequest.g gVar) {
        this.d = i;
        if (streamState == null) {
            throw new NullPointerException("Null streamState");
        }
        this.e = streamState;
        this.f = gVar;
    }

    @Override // androidx.camera.video.StreamInfo
    public int a() {
        return this.d;
    }

    @Override // androidx.camera.video.StreamInfo
    public SurfaceRequest.g b() {
        return this.f;
    }

    @Override // androidx.camera.video.StreamInfo
    public StreamInfo.StreamState c() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StreamInfo)) {
            return false;
        }
        StreamInfo streamInfo = (StreamInfo) obj;
        if (this.d == streamInfo.a() && this.e.equals(streamInfo.c())) {
            SurfaceRequest.g gVar = this.f;
            if (gVar == null) {
                if (streamInfo.b() == null) {
                    return true;
                }
            } else if (gVar.equals(streamInfo.b())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (((this.d ^ 1000003) * 1000003) ^ this.e.hashCode()) * 1000003;
        SurfaceRequest.g gVar = this.f;
        return iHashCode ^ (gVar == null ? 0 : gVar.hashCode());
    }

    public String toString() {
        return "StreamInfo{id=" + this.d + ", streamState=" + this.e + ", inProgressTransformationInfo=" + this.f + "}";
    }
}
