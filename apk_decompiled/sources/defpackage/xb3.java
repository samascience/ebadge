package defpackage;

import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.d0;
import androidx.camera.core.impl.r;
import androidx.camera.core.impl.u;
import androidx.camera.video.VideoOutput;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class xb3 implements d0, r, p23 {
    public static final Config.a J = Config.a.a("camerax.video.VideoCapture.videoOutput", VideoOutput.class);
    public static final Config.a K = Config.a.a("camerax.video.VideoCapture.videoEncoderInfoFinder", wr0.class);
    public static final Config.a L = Config.a.a("camerax.video.VideoCapture.forceEnableSurfaceProcessing", Boolean.class);
    private final u I;

    public xb3(u uVar) {
        b52.a(uVar.b(J));
        this.I = uVar;
    }

    public wr0 Y() {
        wr0 wr0Var = (wr0) a(K);
        Objects.requireNonNull(wr0Var);
        return wr0Var;
    }

    public VideoOutput Z() {
        VideoOutput videoOutput = (VideoOutput) a(J);
        Objects.requireNonNull(videoOutput);
        return videoOutput;
    }

    public boolean a0() {
        Boolean bool = (Boolean) f(L, Boolean.FALSE);
        Objects.requireNonNull(bool);
        return bool.booleanValue();
    }

    @Override // androidx.camera.core.impl.w
    public Config n() {
        return this.I;
    }

    @Override // androidx.camera.core.impl.q
    public int p() {
        return 34;
    }
}
