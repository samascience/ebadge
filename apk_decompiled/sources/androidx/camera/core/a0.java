package androidx.camera.core;

import androidx.camera.core.a0;
import defpackage.b52;
import defpackage.i33;
import defpackage.rh2;

/* JADX INFO: loaded from: classes.dex */
public interface a0 {
    public static final a0 a = new a0() { // from class: qh2
        @Override // androidx.camera.core.a0
        public final a0.c c(a0.b bVar) {
            return a0.e(bVar);
        }
    };
    public static final a0 b = new androidx.camera.core.impl.i.b(a());
    public static final a0 c = new androidx.camera.core.impl.i(a());

    public static final class a {
        private final a0 a;
        private long b;

        public a(a0 a0Var) {
            this.a = a0Var;
            this.b = a0Var.b();
        }

        public a0 a() {
            a0 a0Var = this.a;
            return a0Var instanceof rh2 ? ((rh2) a0Var).d(this.b) : new i33(this.b, this.a);
        }
    }

    public interface b {
        Throwable a();

        long b();

        int n();
    }

    public static final class c {
        public static final c d = new c(false, 0);
        public static final c e = new c(true);
        public static final c f = new c(true, 100);
        public static c g = new c(false, 0, true);
        private final long a;
        private final boolean b;
        private final boolean c;

        private c(boolean z) {
            this(z, a());
        }

        public static long a() {
            return 500L;
        }

        public long b() {
            return this.a;
        }

        public boolean c() {
            return this.c;
        }

        public boolean d() {
            return this.b;
        }

        private c(boolean z, long j) {
            this(z, j, false);
        }

        private c(boolean z, long j, boolean z2) {
            this.b = z;
            this.a = j;
            if (z2) {
                b52.b(!z, "shouldRetry must be false when completeWithoutFailure is set to true");
            }
            this.c = z2;
        }
    }

    static long a() {
        return 6000L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ c e(b bVar) {
        return c.d;
    }

    default long b() {
        return 0L;
    }

    c c(b bVar);
}
