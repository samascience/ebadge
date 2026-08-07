package androidx.camera.video.internal.encoder;

import android.media.MediaCodecInfo;
import defpackage.bh0;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class a extends z implements bh0 {
    private final MediaCodecInfo.AudioCapabilities c;

    a(MediaCodecInfo mediaCodecInfo, String str) {
        super(mediaCodecInfo, str);
        MediaCodecInfo.AudioCapabilities audioCapabilities = this.b.getAudioCapabilities();
        Objects.requireNonNull(audioCapabilities);
        this.c = audioCapabilities;
    }
}
