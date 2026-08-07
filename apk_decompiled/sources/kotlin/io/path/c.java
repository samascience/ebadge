package kotlin.io.path;

import defpackage.p31;
import java.nio.file.Path;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
final class c {
    private final Path a;
    private final Object b;
    private final c c;
    private Iterator d;

    public c(Path path, Object obj, c cVar) {
        p31.f(path, "path");
        this.a = path;
        this.b = obj;
        this.c = cVar;
    }

    public final Iterator a() {
        return this.d;
    }

    public final Object b() {
        return this.b;
    }

    public final c c() {
        return this.c;
    }

    public final Path d() {
        return this.a;
    }

    public final void e(Iterator it) {
        this.d = it;
    }
}
