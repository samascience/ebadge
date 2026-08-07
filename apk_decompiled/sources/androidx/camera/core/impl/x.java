package androidx.camera.core.impl;

import android.util.Range;
import android.util.Size;
import defpackage.ie0;

/* JADX INFO: loaded from: classes.dex */
public abstract class x {
    public static final Range a = new Range(0, 0);

    public static abstract class a {
        a() {
        }

        public abstract x a();

        public abstract a b(ie0 ie0Var);

        public abstract a c(Range range);

        public abstract a d(Config config);

        public abstract a e(Size size);
    }

    public static a a(Size size) {
        return new e.b().e(size).c(a).b(ie0.d);
    }

    public abstract ie0 b();

    public abstract Range c();

    public abstract Config d();

    public abstract Size e();

    public abstract a f();
}
