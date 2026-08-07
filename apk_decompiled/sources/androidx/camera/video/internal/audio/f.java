package androidx.camera.video.internal.audio;

import androidx.camera.core.x;
import defpackage.ac;
import defpackage.b52;
import defpackage.kb;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class f implements AudioStream {
    private final AtomicBoolean a = new AtomicBoolean(false);
    private final AtomicBoolean b = new AtomicBoolean(false);
    private final int c;
    private final int d;
    private byte[] e;
    private long f;
    private AudioStream.a g;
    private Executor h;

    public f(kb kbVar) {
        this.c = kbVar.d();
        this.d = kbVar.f();
    }

    private static void c(long j) {
        long jF = j - f();
        if (jF > 0) {
            try {
                Thread.sleep(TimeUnit.NANOSECONDS.toMillis(jF));
            } catch (InterruptedException e) {
                x.l("SilentAudioStream", "Ignore interruption", e);
            }
        }
    }

    private void d() {
        b52.j(!this.b.get(), "AudioStream has been released.");
    }

    private void e() {
        b52.j(this.a.get(), "AudioStream has not been started.");
    }

    private static long f() {
        return System.nanoTime();
    }

    private void h() {
        final AudioStream.a aVar = this.g;
        Executor executor = this.h;
        if (aVar == null || executor == null) {
            return;
        }
        executor.execute(new Runnable() { // from class: zo2
            @Override // java.lang.Runnable
            public final void run() {
                aVar.a(true);
            }
        });
    }

    private void i(ByteBuffer byteBuffer, int i) {
        b52.i(i <= byteBuffer.remaining());
        byte[] bArr = this.e;
        if (bArr == null || bArr.length < i) {
            this.e = new byte[i];
        }
        int iPosition = byteBuffer.position();
        byteBuffer.put(this.e, 0, i).limit(i + iPosition).position(iPosition);
    }

    @Override // androidx.camera.video.internal.audio.AudioStream
    public void a(AudioStream.a aVar, Executor executor) {
        boolean z = true;
        b52.j(!this.a.get(), "AudioStream can not be started when setCallback.");
        d();
        if (aVar != null && executor == null) {
            z = false;
        }
        b52.b(z, "executor can't be null with non-null callback.");
        this.g = aVar;
        this.h = executor;
    }

    @Override // androidx.camera.video.internal.audio.AudioStream
    public AudioStream.b read(ByteBuffer byteBuffer) {
        d();
        e();
        long jG = ac.g(byteBuffer.remaining(), this.c);
        int iE = (int) ac.e(jG, this.c);
        if (iE <= 0) {
            return AudioStream.b.c(0, this.f);
        }
        long jD = this.f + ac.d(jG, this.d);
        c(jD);
        i(byteBuffer, iE);
        AudioStream.b bVarC = AudioStream.b.c(iE, this.f);
        this.f = jD;
        return bVarC;
    }

    @Override // androidx.camera.video.internal.audio.AudioStream
    public void release() {
        this.b.getAndSet(true);
    }

    @Override // androidx.camera.video.internal.audio.AudioStream
    public void start() {
        d();
        if (this.a.getAndSet(true)) {
            return;
        }
        this.f = f();
        h();
    }

    @Override // androidx.camera.video.internal.audio.AudioStream
    public void stop() {
        d();
        this.a.set(false);
    }
}
