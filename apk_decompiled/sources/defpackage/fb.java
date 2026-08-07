package defpackage;

import android.media.MediaFormat;
import androidx.camera.core.impl.Timebase;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public abstract class fb implements hg0 {

    public static abstract class a {
        a() {
        }

        abstract fb a();

        public fb b() {
            fb fbVarA = a();
            if (Objects.equals(fbVarA.c(), "audio/mp4a-latm") && fbVarA.g() == -1) {
                throw new IllegalArgumentException("Encoder mime set to AAC, but no AAC profile was provided.");
            }
            return fbVarA;
        }

        public abstract a c(int i);

        public abstract a d(int i);

        public abstract a e(Timebase timebase);

        public abstract a f(String str);

        public abstract a g(int i);

        public abstract a h(int i);
    }

    fb() {
    }

    public static a d() {
        return new tc.b().g(-1);
    }

    @Override // defpackage.hg0
    public MediaFormat a() {
        MediaFormat mediaFormatCreateAudioFormat = MediaFormat.createAudioFormat(c(), h(), f());
        mediaFormatCreateAudioFormat.setInteger("bitrate", e());
        if (g() != -1) {
            if (c().equals("audio/mp4a-latm")) {
                mediaFormatCreateAudioFormat.setInteger("aac-profile", g());
            } else {
                mediaFormatCreateAudioFormat.setInteger("profile", g());
            }
        }
        return mediaFormatCreateAudioFormat;
    }

    @Override // defpackage.hg0
    public abstract Timebase b();

    @Override // defpackage.hg0
    public abstract String c();

    public abstract int e();

    public abstract int f();

    public abstract int g();

    public abstract int h();
}
