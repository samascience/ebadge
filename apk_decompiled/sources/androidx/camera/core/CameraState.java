package androidx.camera.core;

/* JADX INFO: loaded from: classes.dex */
public abstract class CameraState {

    public enum ErrorType {
        RECOVERABLE,
        CRITICAL
    }

    public enum Type {
        PENDING_OPEN,
        OPENING,
        OPEN,
        CLOSING,
        CLOSED
    }

    public static abstract class a {
        public static a a(int i) {
            return b(i, null);
        }

        public static a b(int i, Throwable th) {
            return new f(i, th);
        }

        public abstract Throwable c();

        public abstract int d();
    }

    public static CameraState a(Type type) {
        return b(type, null);
    }

    public static CameraState b(Type type, a aVar) {
        return new e(type, aVar);
    }

    public abstract a c();

    public abstract Type d();
}
