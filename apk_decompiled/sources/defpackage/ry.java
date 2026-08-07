package defpackage;

import android.os.Build;
import android.util.CloseGuard;

/* JADX INFO: loaded from: classes.dex */
public final class ry {
    private final b a;

    static final class a implements b {
        private final CloseGuard a = new CloseGuard();

        a() {
        }

        @Override // ry.b
        public void a() {
            this.a.warnIfOpen();
        }

        @Override // ry.b
        public void b(String str) {
            this.a.open(str);
        }

        @Override // ry.b
        public void close() {
            this.a.close();
        }
    }

    private interface b {
        void a();

        void b(String str);

        void close();
    }

    static final class c implements b {
        c() {
        }

        @Override // ry.b
        public void a() {
        }

        @Override // ry.b
        public void b(String str) {
            b52.h(str, "CloseMethodName must not be null.");
        }

        @Override // ry.b
        public void close() {
        }
    }

    private ry(b bVar) {
        this.a = bVar;
    }

    public static ry b() {
        return Build.VERSION.SDK_INT >= 30 ? new ry(new a()) : new ry(new c());
    }

    public void a() {
        this.a.close();
    }

    public void c(String str) {
        this.a.b(str);
    }

    public void d() {
        this.a.a();
    }
}
