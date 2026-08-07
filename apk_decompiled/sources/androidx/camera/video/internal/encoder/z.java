package androidx.camera.video.internal.encoder;

import android.media.MediaCodecInfo;
import defpackage.bh0;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public abstract class z implements bh0 {
    private final MediaCodecInfo a;
    protected final MediaCodecInfo.CodecCapabilities b;

    z(MediaCodecInfo mediaCodecInfo, String str) throws InvalidConfigException {
        this.a = mediaCodecInfo;
        try {
            MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
            Objects.requireNonNull(capabilitiesForType);
            this.b = capabilitiesForType;
        } catch (RuntimeException e) {
            throw new InvalidConfigException("Unable to get CodecCapabilities for mime: " + str, e);
        }
    }
}
