package androidx.camera.video.internal.audio;

import java.nio.ByteBuffer;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public interface AudioStream {

    public static class AudioStreamException extends Exception {
        public AudioStreamException() {
        }

        public AudioStreamException(String str) {
            super(str);
        }

        public AudioStreamException(String str, Throwable th) {
            super(str, th);
        }

        public AudioStreamException(Throwable th) {
            super(th);
        }
    }

    public interface a {
        void a(boolean z);
    }

    public static abstract class b {
        public static b c(int i, long j) {
            return new d(i, j);
        }

        public abstract int a();

        public abstract long b();
    }

    void a(a aVar, Executor executor);

    b read(ByteBuffer byteBuffer);

    void release();

    void start();

    void stop();
}
