package androidx.camera.video;

import androidx.camera.core.SurfaceRequest;
import defpackage.g20;
import defpackage.ut1;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class StreamInfo {
    static final StreamInfo a = d(0, StreamState.INACTIVE);
    static final Set b = Collections.unmodifiableSet(new HashSet(Arrays.asList(0, -1)));
    static final ut1 c = g20.g(d(0, StreamState.ACTIVE));

    enum StreamState {
        ACTIVE,
        INACTIVE
    }

    StreamInfo() {
    }

    static StreamInfo d(int i, StreamState streamState) {
        return new l(i, streamState, null);
    }

    static StreamInfo e(int i, StreamState streamState, SurfaceRequest.g gVar) {
        return new l(i, streamState, gVar);
    }

    public abstract int a();

    public abstract SurfaceRequest.g b();

    public abstract StreamState c();
}
