package androidx.camera.video.internal.encoder;

import android.media.MediaCodecInfo;
import android.util.Range;
import androidx.camera.video.internal.encoder.c0;
import defpackage.az;
import defpackage.kc3;
import defpackage.pc3;
import defpackage.rc3;
import defpackage.wr0;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class c0 extends z implements pc3 {
    public static final wr0 d = new wr0() { // from class: qc3
        @Override // defpackage.wr0
        public final Object apply(Object obj) {
            return c0.m((kc3) obj);
        }
    };
    private final MediaCodecInfo.VideoCapabilities c;

    c0(MediaCodecInfo mediaCodecInfo, String str) {
        super(mediaCodecInfo, str);
        MediaCodecInfo.VideoCapabilities videoCapabilities = this.b.getVideoCapabilities();
        Objects.requireNonNull(videoCapabilities);
        this.c = videoCapabilities;
    }

    public static c0 l(kc3 kc3Var) {
        return new c0(az.c(kc3Var), kc3Var.c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ pc3 m(kc3 kc3Var) {
        try {
            return rc3.l(l(kc3Var), null);
        } catch (InvalidConfigException e) {
            androidx.camera.core.x.l("VideoEncoderInfoImpl", "Unable to find a VideoEncoderInfoImpl", e);
            return null;
        }
    }

    private static IllegalArgumentException n(Throwable th) {
        return th instanceof IllegalArgumentException ? (IllegalArgumentException) th : new IllegalArgumentException(th);
    }

    @Override // defpackage.pc3
    public int b() {
        return this.c.getWidthAlignment();
    }

    @Override // defpackage.pc3
    public Range c() {
        return this.c.getBitrateRange();
    }

    @Override // defpackage.pc3
    public boolean d() {
        return true;
    }

    @Override // defpackage.pc3
    public Range e(int i) {
        try {
            return this.c.getSupportedWidthsFor(i);
        } catch (Throwable th) {
            throw n(th);
        }
    }

    @Override // defpackage.pc3
    public Range f(int i) {
        try {
            return this.c.getSupportedHeightsFor(i);
        } catch (Throwable th) {
            throw n(th);
        }
    }

    @Override // defpackage.pc3
    public int g() {
        return this.c.getHeightAlignment();
    }

    @Override // defpackage.pc3
    public Range h() {
        return this.c.getSupportedWidths();
    }

    @Override // defpackage.pc3
    public boolean i(int i, int i2) {
        return this.c.isSizeSupported(i, i2);
    }

    @Override // defpackage.pc3
    public Range j() {
        return this.c.getSupportedHeights();
    }
}
