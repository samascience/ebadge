package androidx.camera.video;

import android.util.Range;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public abstract class x0 {
    public static final Range a = new Range(0, Integer.MAX_VALUE);
    public static final Range b = new Range(0, Integer.MAX_VALUE);
    public static final v c;

    public static abstract class a {
        a() {
        }

        public abstract x0 a();

        abstract a b(int i);

        public abstract a c(Range range);

        public abstract a d(Range range);

        public abstract a e(v vVar);
    }

    static {
        s sVar = s.c;
        c = v.f(Arrays.asList(sVar, s.b, s.a), o.a(sVar));
    }

    x0() {
    }

    public static a a() {
        return new m.b().e(c).d(a).c(b).b(-1);
    }

    abstract int b();

    public abstract Range c();

    public abstract Range d();

    public abstract v e();

    public abstract a f();
}
