package defpackage;

import android.media.MediaFormat;
import android.util.Size;
import androidx.camera.core.impl.Timebase;

/* JADX INFO: loaded from: classes.dex */
public abstract class kc3 implements hg0 {

    public static abstract class a {
        a() {
        }

        public abstract kc3 a();

        public abstract a b(int i);

        public abstract a c(int i);

        public abstract a d(oc3 oc3Var);

        public abstract a e(int i);

        public abstract a f(int i);

        public abstract a g(Timebase timebase);

        public abstract a h(String str);

        public abstract a i(int i);

        public abstract a j(Size size);
    }

    kc3() {
    }

    public static a d() {
        return new ud.b().i(-1).f(1).c(2130708361).d(oc3.a);
    }

    @Override // defpackage.hg0
    public MediaFormat a() {
        Size sizeK = k();
        MediaFormat mediaFormatCreateVideoFormat = MediaFormat.createVideoFormat(c(), sizeK.getWidth(), sizeK.getHeight());
        mediaFormatCreateVideoFormat.setInteger("color-format", f());
        mediaFormatCreateVideoFormat.setInteger("bitrate", e());
        mediaFormatCreateVideoFormat.setInteger("frame-rate", h());
        mediaFormatCreateVideoFormat.setInteger("i-frame-interval", i());
        if (j() != -1) {
            mediaFormatCreateVideoFormat.setInteger("profile", j());
        }
        oc3 oc3VarG = g();
        if (oc3VarG.c() != 0) {
            mediaFormatCreateVideoFormat.setInteger("color-standard", oc3VarG.c());
        }
        if (oc3VarG.d() != 0) {
            mediaFormatCreateVideoFormat.setInteger("color-transfer", oc3VarG.d());
        }
        if (oc3VarG.b() != 0) {
            mediaFormatCreateVideoFormat.setInteger("color-range", oc3VarG.b());
        }
        return mediaFormatCreateVideoFormat;
    }

    @Override // defpackage.hg0
    public abstract Timebase b();

    @Override // defpackage.hg0
    public abstract String c();

    public abstract int e();

    public abstract int f();

    public abstract oc3 g();

    public abstract int h();

    public abstract int i();

    public abstract int j();

    public abstract Size k();
}
