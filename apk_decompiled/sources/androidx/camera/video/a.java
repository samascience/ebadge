package androidx.camera.video;

import android.util.Range;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static final Range a = new Range(0, Integer.MAX_VALUE);
    public static final Range b = new Range(0, Integer.MAX_VALUE);
    public static final a c = a().c(0).a();

    /* JADX INFO: renamed from: androidx.camera.video.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0009a {
        AbstractC0009a() {
        }

        public abstract a a();

        public abstract AbstractC0009a b(Range range);

        public abstract AbstractC0009a c(int i);

        public abstract AbstractC0009a d(Range range);

        public abstract AbstractC0009a e(int i);
    }

    a() {
    }

    public static AbstractC0009a a() {
        return new c.b().f(-1).e(-1).c(-1).b(a).d(b);
    }

    public abstract Range b();

    public abstract int c();

    public abstract Range d();

    public abstract int e();

    public abstract int f();
}
