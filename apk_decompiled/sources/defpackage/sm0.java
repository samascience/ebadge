package defpackage;

import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public final class sm0 extends fy1 {
    private final b b;

    public static final class a extends fy1.a {
        private final b.a b;

        public a(File file) {
            super(new dd.b());
            b52.h(file, "File can't be null.");
            b.a aVar = (b.a) this.a;
            this.b = aVar;
            aVar.d(file);
        }

        public sm0 a() {
            return new sm0(this.b.c());
        }
    }

    static abstract class b extends fy1.b {

        static abstract class a extends fy1.b.a {
            a() {
            }

            abstract b c();

            abstract a d(File file);
        }

        b() {
        }

        abstract File d();
    }

    sm0(b bVar) {
        super(bVar);
        this.b = bVar;
    }

    public File d() {
        return this.b.d();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof sm0) {
            return this.b.equals(((sm0) obj).b);
        }
        return false;
    }

    public int hashCode() {
        return this.b.hashCode();
    }

    public String toString() {
        return this.b.toString().replaceFirst("FileOutputOptionsInternal", "FileOutputOptions");
    }
}
