package androidx.camera.video;

import defpackage.fy1;
import defpackage.q20;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
final class j extends Recorder.h {
    private final fy1 g;
    private final Executor h;
    private final q20 i;
    private final boolean j;
    private final boolean k;
    private final long l;

    j(fy1 fy1Var, Executor executor, q20 q20Var, boolean z, boolean z2, long j) {
        if (fy1Var == null) {
            throw new NullPointerException("Null getOutputOptions");
        }
        this.g = fy1Var;
        this.h = executor;
        this.i = q20Var;
        this.j = z;
        this.k = z2;
        this.l = j;
    }

    @Override // androidx.camera.video.Recorder.h
    boolean A0() {
        return this.k;
    }

    public boolean equals(Object obj) {
        Executor executor;
        q20 q20Var;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Recorder.h)) {
            return false;
        }
        Recorder.h hVar = (Recorder.h) obj;
        return this.g.equals(hVar.k0()) && ((executor = this.h) != null ? executor.equals(hVar.g0()) : hVar.g0() == null) && ((q20Var = this.i) != null ? q20Var.equals(hVar.j0()) : hVar.j0() == null) && this.j == hVar.t0() && this.k == hVar.A0() && this.l == hVar.m0();
    }

    @Override // androidx.camera.video.Recorder.h
    Executor g0() {
        return this.h;
    }

    public int hashCode() {
        int iHashCode = (this.g.hashCode() ^ 1000003) * 1000003;
        Executor executor = this.h;
        int iHashCode2 = (iHashCode ^ (executor == null ? 0 : executor.hashCode())) * 1000003;
        q20 q20Var = this.i;
        int iHashCode3 = (((iHashCode2 ^ (q20Var != null ? q20Var.hashCode() : 0)) * 1000003) ^ (this.j ? 1231 : 1237)) * 1000003;
        int i = this.k ? 1231 : 1237;
        long j = this.l;
        return ((iHashCode3 ^ i) * 1000003) ^ ((int) (j ^ (j >>> 32)));
    }

    @Override // androidx.camera.video.Recorder.h
    q20 j0() {
        return this.i;
    }

    @Override // androidx.camera.video.Recorder.h
    fy1 k0() {
        return this.g;
    }

    @Override // androidx.camera.video.Recorder.h
    long m0() {
        return this.l;
    }

    @Override // androidx.camera.video.Recorder.h
    boolean t0() {
        return this.j;
    }

    public String toString() {
        return "RecordingRecord{getOutputOptions=" + this.g + ", getCallbackExecutor=" + this.h + ", getEventListener=" + this.i + ", hasAudioEnabled=" + this.j + ", isPersistent=" + this.k + ", getRecordingId=" + this.l + "}";
    }
}
