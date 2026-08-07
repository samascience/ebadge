package androidx.camera.video.internal.encoder;

import android.view.Surface;
import androidx.camera.video.internal.BufferProvider;
import defpackage.bh0;
import defpackage.gg0;
import defpackage.ub1;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public interface c {

    public interface a extends b, BufferProvider {
    }

    public interface b {
    }

    /* JADX INFO: renamed from: androidx.camera.video.internal.encoder.c$c, reason: collision with other inner class name */
    public interface InterfaceC0011c extends b {

        /* JADX INFO: renamed from: androidx.camera.video.internal.encoder.c$c$a */
        public interface a {
            void a(Surface surface);
        }

        void b(Executor executor, a aVar);
    }

    void a(long j);

    b b();

    bh0 c();

    ub1 d();

    void e(gg0 gg0Var, Executor executor);

    void f();

    int g();

    void pause();

    void release();

    void start();
}
