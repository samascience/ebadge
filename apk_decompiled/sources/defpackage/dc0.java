package defpackage;

import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public abstract class dc0 implements yb0.a {
    private final long a;
    private final a b;

    public interface a {
        File a();
    }

    public dc0(a aVar, long j) {
        this.a = j;
        this.b = aVar;
    }

    @Override // yb0.a
    public yb0 a() {
        File fileA = this.b.a();
        if (fileA == null) {
            return null;
        }
        if (fileA.isDirectory() || fileA.mkdirs()) {
            return ec0.c(fileA, this.a);
        }
        return null;
    }
}
