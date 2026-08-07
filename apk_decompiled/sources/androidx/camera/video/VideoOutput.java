package androidx.camera.video;

import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.Timebase;
import defpackage.g20;
import defpackage.ut1;
import defpackage.yt;

/* JADX INFO: loaded from: classes.dex */
public interface VideoOutput {

    public enum SourceState {
        ACTIVE_STREAMING,
        ACTIVE_NON_STREAMING,
        INACTIVE
    }

    void a(SurfaceRequest surfaceRequest);

    default void b(SurfaceRequest surfaceRequest, Timebase timebase) {
        a(surfaceRequest);
    }

    default ut1 c() {
        return g20.g(null);
    }

    default m0 d(yt ytVar) {
        return m0.a;
    }

    default ut1 e() {
        return StreamInfo.c;
    }

    default void f(SourceState sourceState) {
    }
}
