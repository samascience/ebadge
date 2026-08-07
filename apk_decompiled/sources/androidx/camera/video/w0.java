package androidx.camera.video;

import defpackage.b52;
import defpackage.fy1;

/* JADX INFO: loaded from: classes.dex */
public abstract class w0 {
    private final fy1 a;
    private final l0 b;

    public static final class a extends w0 {
        private final q c;
        private final int d;
        private final Throwable e;

        a(fy1 fy1Var, l0 l0Var, q qVar, int i, Throwable th) {
            super(fy1Var, l0Var);
            this.c = qVar;
            this.d = i;
            this.e = th;
        }

        static String h(int i) {
            switch (i) {
                case 0:
                    return "ERROR_NONE";
                case 1:
                    return "ERROR_UNKNOWN";
                case 2:
                    return "ERROR_FILE_SIZE_LIMIT_REACHED";
                case 3:
                    return "ERROR_INSUFFICIENT_STORAGE";
                case 4:
                    return "ERROR_SOURCE_INACTIVE";
                case 5:
                    return "ERROR_INVALID_OUTPUT_OPTIONS";
                case 6:
                    return "ERROR_ENCODING_FAILED";
                case 7:
                    return "ERROR_RECORDER_ERROR";
                case 8:
                    return "ERROR_NO_VALID_DATA";
                case 9:
                    return "ERROR_DURATION_LIMIT_REACHED";
                case 10:
                    return "ERROR_RECORDING_GARBAGE_COLLECTED";
                default:
                    return "Unknown(" + i + ")";
            }
        }

        public Throwable i() {
            return this.e;
        }

        public int j() {
            return this.d;
        }

        public q k() {
            return this.c;
        }

        public boolean l() {
            return this.d != 0;
        }
    }

    public static final class b extends w0 {
        b(fy1 fy1Var, l0 l0Var) {
            super(fy1Var, l0Var);
        }
    }

    public static final class c extends w0 {
        c(fy1 fy1Var, l0 l0Var) {
            super(fy1Var, l0Var);
        }
    }

    public static final class d extends w0 {
        d(fy1 fy1Var, l0 l0Var) {
            super(fy1Var, l0Var);
        }
    }

    public static final class e extends w0 {
        e(fy1 fy1Var, l0 l0Var) {
            super(fy1Var, l0Var);
        }
    }

    w0(fy1 fy1Var, l0 l0Var) {
        this.a = (fy1) b52.g(fy1Var);
        this.b = (l0) b52.g(l0Var);
    }

    static a a(fy1 fy1Var, l0 l0Var, q qVar) {
        return new a(fy1Var, l0Var, qVar, 0, null);
    }

    static a b(fy1 fy1Var, l0 l0Var, q qVar, int i, Throwable th) {
        b52.b(i != 0, "An error type is required.");
        return new a(fy1Var, l0Var, qVar, i, th);
    }

    static b d(fy1 fy1Var, l0 l0Var) {
        return new b(fy1Var, l0Var);
    }

    static c e(fy1 fy1Var, l0 l0Var) {
        return new c(fy1Var, l0Var);
    }

    static d f(fy1 fy1Var, l0 l0Var) {
        return new d(fy1Var, l0Var);
    }

    static e g(fy1 fy1Var, l0 l0Var) {
        return new e(fy1Var, l0Var);
    }

    public fy1 c() {
        return this.a;
    }
}
