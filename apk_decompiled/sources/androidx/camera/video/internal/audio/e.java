package androidx.camera.video.internal.audio;

import androidx.camera.core.x;
import defpackage.ac;
import defpackage.b52;
import defpackage.kb;
import java.nio.ByteBuffer;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class e implements AudioStream {
    private final AudioStream g;
    private final int h;
    private final int i;
    private final int j;
    private int l;
    private final AtomicBoolean a = new AtomicBoolean(false);
    private final AtomicBoolean b = new AtomicBoolean(false);
    private final Queue c = new ConcurrentLinkedQueue();
    private final Executor d = androidx.camera.core.impl.utils.executor.c.g(androidx.camera.core.impl.utils.executor.c.a());
    private final Object e = new Object();
    private a f = null;
    private final AtomicBoolean k = new AtomicBoolean(false);

    private static class a {
        private final int a;
        private final int b;
        private final ByteBuffer c;
        private long d;

        a(ByteBuffer byteBuffer, AudioStream.b bVar, int i, int i2) {
            byteBuffer.rewind();
            int iLimit = byteBuffer.limit() - byteBuffer.position();
            if (iLimit == bVar.a()) {
                this.a = i;
                this.b = i2;
                this.c = byteBuffer;
                this.d = bVar.b();
                return;
            }
            throw new IllegalStateException("Byte buffer size is not match with packet info: " + iLimit + " != " + bVar.a());
        }

        public int a() {
            return this.c.remaining();
        }

        public AudioStream.b b(ByteBuffer byteBuffer) {
            int iRemaining;
            long j = this.d;
            int iPosition = this.c.position();
            int iPosition2 = byteBuffer.position();
            if (this.c.remaining() > byteBuffer.remaining()) {
                iRemaining = byteBuffer.remaining();
                this.d += ac.d(ac.g(iRemaining, this.a), this.b);
                ByteBuffer byteBufferDuplicate = this.c.duplicate();
                byteBufferDuplicate.position(iPosition).limit(iPosition + iRemaining);
                byteBuffer.put(byteBufferDuplicate).limit(iPosition2 + iRemaining).position(iPosition2);
            } else {
                iRemaining = this.c.remaining();
                byteBuffer.put(this.c).limit(iPosition2 + iRemaining).position(iPosition2);
            }
            this.c.position(iPosition + iRemaining);
            return AudioStream.b.c(iRemaining, j);
        }
    }

    public e(AudioStream audioStream, kb kbVar) {
        this.g = audioStream;
        int iD = kbVar.d();
        this.h = iD;
        int iF = kbVar.f();
        this.i = iF;
        b52.b(((long) iD) > 0, "mBytesPerFrame must be greater than 0.");
        b52.b(((long) iF) > 0, "mSampleRate must be greater than 0.");
        this.j = 500;
        this.l = iD * 1024;
    }

    private void h() {
        b52.j(!this.b.get(), "AudioStream has been released.");
    }

    private void i() {
        b52.j(this.a.get(), "AudioStream has not been started.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (this.k.get()) {
            ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(this.l);
            a aVar = new a(byteBufferAllocateDirect, this.g.read(byteBufferAllocateDirect), this.h, this.i);
            int i = this.j;
            synchronized (this.e) {
                try {
                    this.c.offer(aVar);
                    while (this.c.size() > i) {
                        this.c.poll();
                        x.k("BufferedAudioStream", "Drop audio data due to full of queue.");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (this.k.get()) {
                this.d.execute(new Runnable() { // from class: oo
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.j();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k() {
        this.k.set(false);
        this.g.release();
        synchronized (this.e) {
            this.f = null;
            this.c.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(AudioStream.a aVar, Executor executor) {
        this.g.a(aVar, executor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m() {
        try {
            this.g.start();
            p();
        } catch (AudioStream.AudioStreamException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n() {
        this.k.set(false);
        this.g.stop();
        synchronized (this.e) {
            this.f = null;
            this.c.clear();
        }
    }

    private void p() {
        if (this.k.getAndSet(true)) {
            return;
        }
        j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public void o(int i) {
        int i2 = this.l;
        if (i2 == i) {
            return;
        }
        int i3 = this.h;
        this.l = (i / i3) * i3;
        x.a("BufferedAudioStream", "Update buffer size from " + i2 + " to " + this.l);
    }

    private void r(final int i) {
        this.d.execute(new Runnable() { // from class: no
            @Override // java.lang.Runnable
            public final void run() {
                this.a.o(i);
            }
        });
    }

    @Override // androidx.camera.video.internal.audio.AudioStream
    public void a(final AudioStream.a aVar, final Executor executor) {
        boolean z = true;
        b52.j(!this.a.get(), "AudioStream can not be started when setCallback.");
        h();
        if (aVar != null && executor == null) {
            z = false;
        }
        b52.b(z, "executor can't be null with non-null callback.");
        this.d.execute(new Runnable() { // from class: lo
            @Override // java.lang.Runnable
            public final void run() {
                this.a.l(aVar, executor);
            }
        });
    }

    @Override // androidx.camera.video.internal.audio.AudioStream
    public AudioStream.b read(ByteBuffer byteBuffer) {
        boolean z;
        h();
        i();
        r(byteBuffer.remaining());
        AudioStream.b bVarC = AudioStream.b.c(0, 0L);
        do {
            synchronized (this.e) {
                try {
                    a aVar = this.f;
                    this.f = null;
                    if (aVar == null) {
                        aVar = (a) this.c.poll();
                    }
                    if (aVar != null) {
                        bVarC = aVar.b(byteBuffer);
                        if (aVar.a() > 0) {
                            this.f = aVar;
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            z = bVarC.a() <= 0 && this.a.get() && !this.b.get();
            if (z) {
                try {
                    Thread.sleep(1L);
                } catch (InterruptedException e) {
                    x.l("BufferedAudioStream", "Interruption while waiting for audio data", e);
                }
            }
        } while (z);
        return bVarC;
    }

    @Override // androidx.camera.video.internal.audio.AudioStream
    public void release() {
        if (this.b.getAndSet(true)) {
            return;
        }
        this.d.execute(new Runnable() { // from class: po
            @Override // java.lang.Runnable
            public final void run() {
                this.a.k();
            }
        });
    }

    @Override // androidx.camera.video.internal.audio.AudioStream
    public void start() throws AudioStream.AudioStreamException {
        h();
        if (this.a.getAndSet(true)) {
            return;
        }
        FutureTask futureTask = new FutureTask(new Runnable() { // from class: mo
            @Override // java.lang.Runnable
            public final void run() {
                this.a.m();
            }
        }, null);
        this.d.execute(futureTask);
        try {
            futureTask.get();
        } catch (InterruptedException | ExecutionException e) {
            this.a.set(false);
            throw new AudioStream.AudioStreamException(e);
        }
    }

    @Override // androidx.camera.video.internal.audio.AudioStream
    public void stop() {
        h();
        if (this.a.getAndSet(false)) {
            this.d.execute(new Runnable() { // from class: ko
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.n();
                }
            });
        }
    }
}
