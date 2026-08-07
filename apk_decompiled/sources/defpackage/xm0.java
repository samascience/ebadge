package defpackage;

import java.util.List;
import okio.internal.FileSystem;
import okio.internal.ResourceFileSystem;

/* JADX INFO: loaded from: classes4.dex */
public abstract class xm0 {
    public static final a a = new a(null);
    public static final xm0 b;
    public static final hz1 c;
    public static final xm0 d;

    public static final class a {
        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        private a() {
        }
    }

    static {
        xm0 e81Var;
        try {
            Class.forName("java.nio.file.Files");
            e81Var = new cr1();
        } catch (ClassNotFoundException unused) {
            e81Var = new e81();
        }
        b = e81Var;
        hz1.a aVar = hz1.b;
        String property = System.getProperty("java.io.tmpdir");
        p31.e(property, "getProperty(...)");
        c = hz1.a.e(aVar, property, false, 1, null);
        ClassLoader classLoader = ResourceFileSystem.class.getClassLoader();
        p31.e(classLoader, "getClassLoader(...)");
        d = new ResourceFileSystem(classLoader, false, null, 4, null);
    }

    public abstract List a(hz1 hz1Var);

    public abstract List b(hz1 hz1Var);

    public final lm0 c(hz1 hz1Var) {
        p31.f(hz1Var, "path");
        return FileSystem.b(this, hz1Var);
    }

    public abstract lm0 d(hz1 hz1Var);

    public abstract hm0 e(hz1 hz1Var);
}
