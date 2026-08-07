package androidx.camera.video;

import defpackage.q20;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public abstract class p {

    public static abstract class a {
        a() {
        }

        public abstract p a();

        public a b(q20 q20Var) {
            x0.a aVarF = c().f();
            q20Var.accept(aVarF);
            f(aVarF.a());
            return this;
        }

        abstract x0 c();

        public abstract a d(androidx.camera.video.a aVar);

        public abstract a e(int i);

        public abstract a f(x0 x0Var);
    }

    p() {
    }

    public static a a() {
        return new f.b().e(-1).d(androidx.camera.video.a.a().a()).f(x0.a().a());
    }

    public static String e(int i) {
        return i != 1 ? "audio/mp4a-latm" : "audio/vorbis";
    }

    public static int f(int i) {
        return Objects.equals(e(i), "audio/mp4a-latm") ? 2 : -1;
    }

    static int g(int i) {
        return i != 1 ? 0 : 1;
    }

    public static String h(int i) {
        return i != 1 ? "video/avc" : "video/x-vnd.on2.vp8";
    }

    public abstract androidx.camera.video.a b();

    public abstract int c();

    public abstract x0 d();

    public abstract a i();
}
