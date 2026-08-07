package androidx.camera.video;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {
    private static final Set a = Collections.unmodifiableSet(new HashSet(Arrays.asList(2, 3, 4)));

    b() {
    }

    static b d(int i, Throwable th, double d) {
        return new d(i, d, th);
    }

    abstract double a();

    public abstract int b();

    public abstract Throwable c();
}
