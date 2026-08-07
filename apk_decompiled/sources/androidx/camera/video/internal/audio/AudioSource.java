package androidx.camera.video.internal.audio;

import android.content.Context;
import androidx.camera.core.x;
import androidx.camera.video.internal.BufferProvider;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import defpackage.b52;
import defpackage.bs0;
import defpackage.kb;
import defpackage.n21;
import defpackage.os0;
import defpackage.ub1;
import defpackage.ut1;
import java.nio.ByteBuffer;
import java.nio.ShortBuffer;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class AudioSource {
    final Executor a;
    final AtomicReference b;
    final AtomicBoolean c;
    final AudioStream d;
    final f e;
    private final long f;
    InternalState g;
    BufferProvider.State h;
    boolean i;
    Executor j;
    c k;
    BufferProvider l;
    private bs0 m;
    private ut1.a n;
    boolean o;
    private long p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    boolean f159q;
    boolean r;
    private byte[] s;
    double t;
    long u;
    private final int v;

    enum InternalState {
        CONFIGURED,
        STARTED,
        RELEASED
    }

    class a implements ut1.a {
        final /* synthetic */ BufferProvider a;

        a(BufferProvider bufferProvider) {
            this.a = bufferProvider;
        }

        @Override // ut1.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(BufferProvider.State state) {
            Objects.requireNonNull(state);
            if (AudioSource.this.l == this.a) {
                x.a("AudioSource", "Receive BufferProvider state change: " + AudioSource.this.h + " to " + state);
                AudioSource audioSource = AudioSource.this;
                if (audioSource.h != state) {
                    audioSource.h = state;
                    audioSource.S();
                }
            }
        }

        @Override // ut1.a
        public void onError(Throwable th) {
            AudioSource audioSource = AudioSource.this;
            if (audioSource.l == this.a) {
                audioSource.C(th);
            }
        }
    }

    class b implements bs0 {
        final /* synthetic */ BufferProvider a;

        b(BufferProvider bufferProvider) {
            this.a = bufferProvider;
        }

        @Override // defpackage.bs0
        public void a(Throwable th) {
            if (AudioSource.this.l != this.a) {
                return;
            }
            x.a("AudioSource", "Unable to get input buffer, the BufferProvider could be transitioning to INACTIVE state.");
            if (th instanceof IllegalStateException) {
                return;
            }
            AudioSource.this.C(th);
        }

        @Override // defpackage.bs0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(n21 n21Var) {
            AudioSource audioSource = AudioSource.this;
            if (!audioSource.i || audioSource.l != this.a) {
                n21Var.cancel();
                return;
            }
            if (audioSource.o && audioSource.p()) {
                AudioSource.this.J();
            }
            AudioStream audioStreamM = AudioSource.this.m();
            ByteBuffer byteBufferM = n21Var.m();
            AudioStream.b bVar = audioStreamM.read(byteBufferM);
            if (bVar.a() > 0) {
                AudioSource audioSource2 = AudioSource.this;
                if (audioSource2.r) {
                    audioSource2.F(byteBufferM, bVar.a());
                }
                if (AudioSource.this.j != null) {
                    long jB = bVar.b();
                    AudioSource audioSource3 = AudioSource.this;
                    if (jB - audioSource3.u >= 200) {
                        audioSource3.u = bVar.b();
                        AudioSource.this.G(byteBufferM);
                    }
                }
                byteBufferM.limit(byteBufferM.position() + bVar.a());
                n21Var.d(TimeUnit.NANOSECONDS.toMicros(bVar.b()));
                n21Var.c();
            } else {
                x.k("AudioSource", "Unable to read data from AudioStream.");
                n21Var.cancel();
            }
            AudioSource.this.K();
        }
    }

    public interface c {
        void a(boolean z);

        default void b(boolean z) {
        }

        void c(double d);

        void onError(Throwable th);
    }

    class d implements AudioStream.a {
        d() {
        }

        @Override // androidx.camera.video.internal.audio.AudioStream.a
        public void a(boolean z) {
            AudioSource audioSource = AudioSource.this;
            audioSource.f159q = z;
            if (audioSource.g == InternalState.STARTED) {
                audioSource.D();
            }
        }
    }

    public AudioSource(kb kbVar, Executor executor, Context context) {
        this(kbVar, executor, context, new androidx.camera.video.internal.audio.b() { // from class: androidx.camera.video.internal.audio.a
            @Override // androidx.camera.video.internal.audio.b
            public final AudioStream a(kb kbVar2, Context context2) {
                return new c(kbVar2, context2);
            }
        }, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A() {
        int iOrdinal = this.g.ordinal();
        if (iOrdinal == 1) {
            N(InternalState.CONFIGURED);
            S();
        } else {
            if (iOrdinal != 2) {
                return;
            }
            x.k("AudioSource", "AudioSource is released. Calling stop() is a no-op.");
        }
    }

    private void I(BufferProvider bufferProvider) {
        BufferProvider bufferProvider2 = this.l;
        if (bufferProvider2 != null) {
            ut1.a aVar = this.n;
            Objects.requireNonNull(aVar);
            bufferProvider2.e(aVar);
            this.l = null;
            this.n = null;
            this.m = null;
            this.h = BufferProvider.State.INACTIVE;
            S();
        }
        if (bufferProvider != null) {
            this.l = bufferProvider;
            this.n = new a(bufferProvider);
            this.m = new b(bufferProvider);
            BufferProvider.State stateL = l(bufferProvider);
            if (stateL != null) {
                this.h = stateL;
                S();
            }
            this.l.a(this.a, this.n);
        }
    }

    private void P() {
        if (this.i) {
            return;
        }
        try {
            x.a("AudioSource", "startSendingAudio");
            this.d.start();
            this.o = false;
        } catch (AudioStream.AudioStreamException e) {
            x.l("AudioSource", "Failed to start AudioStream", e);
            this.o = true;
            this.e.start();
            this.p = n();
            D();
        }
        this.i = true;
        K();
    }

    private void R() {
        if (this.i) {
            this.i = false;
            x.a("AudioSource", "stopSendingAudio");
            this.d.stop();
        }
    }

    private static BufferProvider.State l(BufferProvider bufferProvider) {
        try {
            ub1 ub1VarD = bufferProvider.d();
            if (ub1VarD.isDone()) {
                return (BufferProvider.State) ub1VarD.get();
            }
            return null;
        } catch (InterruptedException | ExecutionException unused) {
            return null;
        }
    }

    private static long n() {
        return System.nanoTime();
    }

    public static boolean o(int i, int i2, int i3) {
        return androidx.camera.video.internal.audio.c.k(i, i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(boolean z) {
        int iOrdinal = this.g.ordinal();
        if (iOrdinal != 0 && iOrdinal != 1) {
            if (iOrdinal == 2) {
                throw new AssertionError("AudioSource is released");
            }
        } else {
            if (this.r == z) {
                return;
            }
            this.r = z;
            if (this.g == InternalState.STARTED) {
                D();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u(c cVar) {
        cVar.c(this.t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(CallbackToFutureAdapter.a aVar) {
        try {
            int iOrdinal = this.g.ordinal();
            if (iOrdinal == 0 || iOrdinal == 1) {
                I(null);
                this.e.release();
                this.d.release();
                R();
                N(InternalState.RELEASED);
            }
            aVar.c(null);
        } catch (Throwable th) {
            aVar.f(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object w(final CallbackToFutureAdapter.a aVar) {
        this.a.execute(new Runnable() { // from class: vb
            @Override // java.lang.Runnable
            public final void run() {
                this.a.v(aVar);
            }
        });
        return "AudioSource-release";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x(Executor executor, c cVar) {
        int iOrdinal = this.g.ordinal();
        if (iOrdinal == 0) {
            this.j = executor;
            this.k = cVar;
        } else if (iOrdinal == 1 || iOrdinal == 2) {
            throw new AssertionError("The audio recording callback must be registered before the audio source is started.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(BufferProvider bufferProvider) {
        int iOrdinal = this.g.ordinal();
        if (iOrdinal != 0 && iOrdinal != 1) {
            if (iOrdinal == 2) {
                throw new AssertionError("AudioSource is released");
            }
        } else if (this.l != bufferProvider) {
            I(bufferProvider);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z(boolean z) {
        int iOrdinal = this.g.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 2) {
                throw new AssertionError("AudioSource is released");
            }
            return;
        }
        this.b.set(null);
        this.c.set(false);
        N(InternalState.STARTED);
        B(z);
        S();
    }

    public void B(final boolean z) {
        this.a.execute(new Runnable() { // from class: tb
            @Override // java.lang.Runnable
            public final void run() {
                this.a.q(z);
            }
        });
    }

    void C(final Throwable th) {
        Executor executor = this.j;
        final c cVar = this.k;
        if (executor == null || cVar == null) {
            return;
        }
        executor.execute(new Runnable() { // from class: pb
            @Override // java.lang.Runnable
            public final void run() {
                cVar.onError(th);
            }
        });
    }

    void D() {
        Executor executor = this.j;
        final c cVar = this.k;
        if (executor == null || cVar == null) {
            return;
        }
        final boolean z = this.r || this.o || this.f159q;
        if (Objects.equals(this.b.getAndSet(Boolean.valueOf(z)), Boolean.valueOf(z))) {
            return;
        }
        executor.execute(new Runnable() { // from class: ub
            @Override // java.lang.Runnable
            public final void run() {
                cVar.a(z);
            }
        });
    }

    void E(final boolean z) {
        Executor executor = this.j;
        final c cVar = this.k;
        if (executor == null || cVar == null || this.c.getAndSet(z) == z) {
            return;
        }
        executor.execute(new Runnable() { // from class: ob
            @Override // java.lang.Runnable
            public final void run() {
                cVar.b(z);
            }
        });
    }

    void F(ByteBuffer byteBuffer, int i) {
        byte[] bArr = this.s;
        if (bArr == null || bArr.length < i) {
            this.s = new byte[i];
        }
        int iPosition = byteBuffer.position();
        byteBuffer.put(this.s, 0, i);
        byteBuffer.limit(byteBuffer.position()).position(iPosition);
    }

    void G(ByteBuffer byteBuffer) {
        Executor executor = this.j;
        final c cVar = this.k;
        if (this.v == 2) {
            ShortBuffer shortBufferAsShortBuffer = byteBuffer.asShortBuffer();
            double dMax = 0.0d;
            while (shortBufferAsShortBuffer.hasRemaining()) {
                dMax = Math.max(dMax, Math.abs((int) shortBufferAsShortBuffer.get()));
            }
            this.t = dMax / 32767.0d;
            if (executor == null || cVar == null) {
                return;
            }
            executor.execute(new Runnable() { // from class: xb
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.u(cVar);
                }
            });
        }
    }

    public ub1 H() {
        return CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: qb
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
            public final Object a(CallbackToFutureAdapter.a aVar) {
                return this.a.w(aVar);
            }
        });
    }

    void J() {
        b52.i(this.o);
        try {
            this.d.start();
            x.a("AudioSource", "Retry start AudioStream succeed");
            this.e.stop();
            this.o = false;
        } catch (AudioStream.AudioStreamException e) {
            x.l("AudioSource", "Retry start AudioStream failed", e);
            this.p = n();
        }
    }

    void K() {
        BufferProvider bufferProvider = this.l;
        Objects.requireNonNull(bufferProvider);
        ub1 ub1VarC = bufferProvider.c();
        bs0 bs0Var = this.m;
        Objects.requireNonNull(bs0Var);
        os0.j(ub1VarC, bs0Var, this.a);
    }

    public void L(final Executor executor, final c cVar) {
        this.a.execute(new Runnable() { // from class: wb
            @Override // java.lang.Runnable
            public final void run() {
                this.a.x(executor, cVar);
            }
        });
    }

    public void M(final BufferProvider bufferProvider) {
        this.a.execute(new Runnable() { // from class: sb
            @Override // java.lang.Runnable
            public final void run() {
                this.a.y(bufferProvider);
            }
        });
    }

    void N(InternalState internalState) {
        x.a("AudioSource", "Transitioning internal state: " + this.g + " --> " + internalState);
        this.g = internalState;
    }

    public void O(final boolean z) {
        this.a.execute(new Runnable() { // from class: rb
            @Override // java.lang.Runnable
            public final void run() {
                this.a.z(z);
            }
        });
    }

    public void Q() {
        this.a.execute(new Runnable() { // from class: nb
            @Override // java.lang.Runnable
            public final void run() {
                this.a.A();
            }
        });
    }

    void S() {
        if (this.g != InternalState.STARTED) {
            R();
            return;
        }
        boolean z = this.h == BufferProvider.State.ACTIVE;
        E(!z);
        if (z) {
            P();
        } else {
            R();
        }
    }

    AudioStream m() {
        return this.o ? this.e : this.d;
    }

    boolean p() {
        b52.i(this.p > 0);
        return n() - this.p >= this.f;
    }

    AudioSource(kb kbVar, Executor executor, Context context, androidx.camera.video.internal.audio.b bVar, long j) throws AudioSourceAccessException {
        this.b = new AtomicReference(null);
        this.c = new AtomicBoolean(false);
        this.g = InternalState.CONFIGURED;
        this.h = BufferProvider.State.INACTIVE;
        this.u = 0L;
        Executor executorG = androidx.camera.core.impl.utils.executor.c.g(executor);
        this.a = executorG;
        this.f = TimeUnit.MILLISECONDS.toNanos(j);
        try {
            e eVar = new e(bVar.a(kbVar, context), kbVar);
            this.d = eVar;
            eVar.a(new d(), executorG);
            this.e = new f(kbVar);
            this.v = kbVar.b();
        } catch (AudioStream.AudioStreamException | IllegalArgumentException e) {
            throw new AudioSourceAccessException("Unable to create AudioStream", e);
        }
    }
}
