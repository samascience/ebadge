package androidx.camera.video.internal.encoder;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Range;
import android.view.Surface;
import androidx.camera.core.impl.Timebase;
import androidx.camera.video.internal.BufferProvider;
import androidx.camera.video.internal.encoder.EncoderImpl;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import defpackage.az;
import defpackage.b52;
import defpackage.bh0;
import defpackage.bs0;
import defpackage.bv;
import defpackage.c33;
import defpackage.ch0;
import defpackage.fb;
import defpackage.gg0;
import defpackage.hg0;
import defpackage.ib;
import defpackage.kc3;
import defpackage.l70;
import defpackage.n21;
import defpackage.nu2;
import defpackage.os0;
import defpackage.pc3;
import defpackage.qz2;
import defpackage.sc3;
import defpackage.td3;
import defpackage.ub1;
import defpackage.ut1;
import defpackage.va0;
import defpackage.yo2;
import defpackage.yx1;
import defpackage.zy;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public class EncoderImpl implements androidx.camera.video.internal.encoder.c {
    private static final Range E = Range.create(Long.MAX_VALUE, Long.MAX_VALUE);
    private Future D;
    final String a;
    final boolean c;
    private final MediaFormat d;
    final MediaCodec e;
    final androidx.camera.video.internal.encoder.c.b f;
    private final bh0 g;
    final Executor h;
    private final ub1 i;
    private final CallbackToFutureAdapter.a j;
    final Timebase p;
    InternalState t;
    final Object b = new Object();
    final Queue k = new ArrayDeque();
    private final Queue l = new ArrayDeque();
    private final Set m = new HashSet();
    final Set n = new HashSet();
    final Deque o = new ArrayDeque();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    final c33 f160q = new qz2();
    gg0 r = gg0.a;
    Executor s = androidx.camera.core.impl.utils.executor.c.b();
    Range u = E;
    long v = 0;
    boolean w = false;
    Long x = null;
    Future y = null;
    private d z = null;
    private boolean A = false;
    private boolean B = false;
    boolean C = false;

    enum InternalState {
        CONFIGURED,
        STARTED,
        PAUSED,
        STOPPING,
        PENDING_START,
        PENDING_START_PAUSED,
        PENDING_RELEASE,
        ERROR,
        RELEASED
    }

    class a implements bs0 {

        /* JADX INFO: renamed from: androidx.camera.video.internal.encoder.EncoderImpl$a$a, reason: collision with other inner class name */
        class C0010a implements bs0 {
            C0010a() {
            }

            @Override // defpackage.bs0
            public void a(Throwable th) {
                if (th instanceof MediaCodec.CodecException) {
                    EncoderImpl.this.H((MediaCodec.CodecException) th);
                } else {
                    EncoderImpl.this.G(0, th.getMessage(), th);
                }
            }

            @Override // defpackage.bs0
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void onSuccess(Void r1) {
            }
        }

        a() {
        }

        @Override // defpackage.bs0
        public void a(Throwable th) {
            EncoderImpl.this.G(0, "Unable to acquire InputBuffer.", th);
        }

        @Override // defpackage.bs0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(n21 n21Var) {
            n21Var.d(EncoderImpl.this.E());
            n21Var.b(true);
            n21Var.c();
            os0.j(n21Var.a(), new C0010a(), EncoderImpl.this.h);
        }
    }

    private static class b {
        static Surface a() {
            return MediaCodec.createPersistentInputSurface();
        }

        static void b(MediaCodec mediaCodec, Surface surface) {
            mediaCodec.setInputSurface(surface);
        }
    }

    class c implements androidx.camera.video.internal.encoder.c.a {
        private final Map a = new LinkedHashMap();
        private BufferProvider.State b = BufferProvider.State.INACTIVE;
        private final List c = new ArrayList();

        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
        public void q(ub1 ub1Var) {
            if (ub1Var.cancel(true)) {
                return;
            }
            b52.i(ub1Var.isDone());
            try {
                ((n21) ub1Var.get()).cancel();
            } catch (InterruptedException | CancellationException | ExecutionException e) {
                androidx.camera.core.x.k(EncoderImpl.this.a, "Unable to cancel the input buffer: " + e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void r(ub1 ub1Var) {
            this.c.remove(ub1Var);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void s(CallbackToFutureAdapter.a aVar) {
            BufferProvider.State state = this.b;
            if (state == BufferProvider.State.ACTIVE) {
                final ub1 ub1VarB = EncoderImpl.this.B();
                os0.C(ub1VarB, aVar);
                aVar.a(new Runnable() { // from class: androidx.camera.video.internal.encoder.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.q(ub1VarB);
                    }
                }, androidx.camera.core.impl.utils.executor.c.b());
                this.c.add(ub1VarB);
                ub1VarB.a(new Runnable() { // from class: androidx.camera.video.internal.encoder.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.r(ub1VarB);
                    }
                }, EncoderImpl.this.h);
                return;
            }
            if (state == BufferProvider.State.INACTIVE) {
                aVar.f(new IllegalStateException("BufferProvider is not active."));
                return;
            }
            aVar.f(new IllegalStateException("Unknown state: " + this.b));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Object t(final CallbackToFutureAdapter.a aVar) {
            EncoderImpl.this.h.execute(new Runnable() { // from class: androidx.camera.video.internal.encoder.n
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.s(aVar);
                }
            });
            return "acquireBuffer";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void v(final ut1.a aVar, Executor executor) {
            this.a.put((ut1.a) b52.g(aVar), (Executor) b52.g(executor));
            final BufferProvider.State state = this.b;
            executor.execute(new Runnable() { // from class: androidx.camera.video.internal.encoder.l
                @Override // java.lang.Runnable
                public final void run() {
                    aVar.a(state);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void w(CallbackToFutureAdapter.a aVar) {
            aVar.c(this.b);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Object x(final CallbackToFutureAdapter.a aVar) {
            EncoderImpl.this.h.execute(new Runnable() { // from class: androidx.camera.video.internal.encoder.k
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.w(aVar);
                }
            });
            return "fetchData";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void y(ut1.a aVar) {
            this.a.remove(b52.g(aVar));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void z(Map.Entry entry, BufferProvider.State state) {
            ((ut1.a) entry.getKey()).a(state);
        }

        void A(boolean z) {
            final BufferProvider.State state = z ? BufferProvider.State.ACTIVE : BufferProvider.State.INACTIVE;
            if (this.b == state) {
                return;
            }
            this.b = state;
            if (state == BufferProvider.State.INACTIVE) {
                Iterator it = this.c.iterator();
                while (it.hasNext()) {
                    ((ub1) it.next()).cancel(true);
                }
                this.c.clear();
            }
            for (final Map.Entry entry : this.a.entrySet()) {
                try {
                    ((Executor) entry.getValue()).execute(new Runnable() { // from class: androidx.camera.video.internal.encoder.i
                        @Override // java.lang.Runnable
                        public final void run() {
                            EncoderImpl.c.z(entry, state);
                        }
                    });
                } catch (RejectedExecutionException e) {
                    androidx.camera.core.x.d(EncoderImpl.this.a, "Unable to post to the supplied executor.", e);
                }
            }
        }

        @Override // defpackage.ut1
        public void a(final Executor executor, final ut1.a aVar) {
            EncoderImpl.this.h.execute(new Runnable() { // from class: androidx.camera.video.internal.encoder.g
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.v(aVar, executor);
                }
            });
        }

        @Override // androidx.camera.video.internal.BufferProvider
        public ub1 c() {
            return CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: androidx.camera.video.internal.encoder.j
                @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
                public final Object a(CallbackToFutureAdapter.a aVar) {
                    return this.a.t(aVar);
                }
            });
        }

        @Override // defpackage.ut1
        public ub1 d() {
            return CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: androidx.camera.video.internal.encoder.h
                @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
                public final Object a(CallbackToFutureAdapter.a aVar) {
                    return this.a.x(aVar);
                }
            });
        }

        @Override // defpackage.ut1
        public void e(final ut1.a aVar) {
            EncoderImpl.this.h.execute(new Runnable() { // from class: androidx.camera.video.internal.encoder.m
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.y(aVar);
                }
            });
        }
    }

    class d extends MediaCodec.Callback {
        private final td3 a;
        private boolean b;
        private boolean c = false;
        private boolean d = false;
        private boolean e = false;
        private long f = 0;
        private long g = 0;
        private boolean h = false;
        private boolean i = false;
        private boolean j = false;

        class a implements bs0 {
            final /* synthetic */ androidx.camera.video.internal.encoder.b a;

            a(androidx.camera.video.internal.encoder.b bVar) {
                this.a = bVar;
            }

            @Override // defpackage.bs0
            public void a(Throwable th) {
                EncoderImpl.this.n.remove(this.a);
                if (th instanceof MediaCodec.CodecException) {
                    EncoderImpl.this.H((MediaCodec.CodecException) th);
                } else {
                    EncoderImpl.this.G(0, th.getMessage(), th);
                }
            }

            @Override // defpackage.bs0
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void onSuccess(Void r2) {
                EncoderImpl.this.n.remove(this.a);
            }
        }

        d() {
            this.b = true;
            if (EncoderImpl.this.c) {
                this.a = new td3(EncoderImpl.this.f160q, EncoderImpl.this.p, (bv) va0.a(bv.class));
            } else {
                this.a = null;
            }
            zy zyVar = (zy) va0.a(zy.class);
            if (zyVar == null || !zyVar.g(EncoderImpl.this.d.getString("mime"))) {
                return;
            }
            this.b = false;
        }

        private boolean i(MediaCodec.BufferInfo bufferInfo) {
            if (this.e) {
                androidx.camera.core.x.a(EncoderImpl.this.a, "Drop buffer by already reach end of stream.");
                return false;
            }
            if (bufferInfo.size <= 0) {
                androidx.camera.core.x.a(EncoderImpl.this.a, "Drop buffer by invalid buffer size.");
                return false;
            }
            if ((bufferInfo.flags & 2) != 0) {
                androidx.camera.core.x.a(EncoderImpl.this.a, "Drop buffer by codec config.");
                return false;
            }
            td3 td3Var = this.a;
            if (td3Var != null) {
                bufferInfo.presentationTimeUs = td3Var.b(bufferInfo.presentationTimeUs);
            }
            long j = bufferInfo.presentationTimeUs;
            if (j <= this.f) {
                androidx.camera.core.x.a(EncoderImpl.this.a, "Drop buffer by out of order buffer from MediaCodec.");
                return false;
            }
            this.f = j;
            if (!EncoderImpl.this.u.contains(Long.valueOf(j))) {
                androidx.camera.core.x.a(EncoderImpl.this.a, "Drop buffer by not in start-stop range.");
                EncoderImpl encoderImpl = EncoderImpl.this;
                if (encoderImpl.w && bufferInfo.presentationTimeUs >= ((Long) encoderImpl.u.getUpper()).longValue()) {
                    Future future = EncoderImpl.this.y;
                    if (future != null) {
                        future.cancel(true);
                    }
                    EncoderImpl.this.x = Long.valueOf(bufferInfo.presentationTimeUs);
                    EncoderImpl.this.k0();
                    EncoderImpl.this.w = false;
                }
                return false;
            }
            if (x(bufferInfo)) {
                androidx.camera.core.x.a(EncoderImpl.this.a, "Drop buffer by pause.");
                return false;
            }
            if (EncoderImpl.this.F(bufferInfo) <= this.g) {
                androidx.camera.core.x.a(EncoderImpl.this.a, "Drop buffer by adjusted time is less than the last sent time.");
                if (EncoderImpl.this.c && EncoderImpl.M(bufferInfo)) {
                    this.i = true;
                }
                return false;
            }
            if (!this.d && !this.i && EncoderImpl.this.c) {
                this.i = true;
            }
            if (this.i) {
                if (!EncoderImpl.M(bufferInfo)) {
                    androidx.camera.core.x.a(EncoderImpl.this.a, "Drop buffer by not a key frame.");
                    EncoderImpl.this.g0();
                    return false;
                }
                this.i = false;
            }
            return true;
        }

        private boolean j(MediaCodec.BufferInfo bufferInfo) {
            return EncoderImpl.J(bufferInfo) || (this.b && k(bufferInfo));
        }

        private boolean k(MediaCodec.BufferInfo bufferInfo) {
            EncoderImpl encoderImpl = EncoderImpl.this;
            return encoderImpl.C && bufferInfo.presentationTimeUs > ((Long) encoderImpl.u.getUpper()).longValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void l(MediaCodec.CodecException codecException) {
            switch (EncoderImpl.this.t) {
                case CONFIGURED:
                case ERROR:
                case RELEASED:
                    return;
                case STARTED:
                case PAUSED:
                case STOPPING:
                case PENDING_START:
                case PENDING_START_PAUSED:
                case PENDING_RELEASE:
                    EncoderImpl.this.H(codecException);
                    return;
                default:
                    throw new IllegalStateException("Unknown state: " + EncoderImpl.this.t);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void m(int i) {
            if (this.j) {
                androidx.camera.core.x.k(EncoderImpl.this.a, "Receives input frame after codec is reset.");
                return;
            }
            switch (EncoderImpl.this.t) {
                case CONFIGURED:
                case ERROR:
                case RELEASED:
                    return;
                case STARTED:
                case PAUSED:
                case STOPPING:
                case PENDING_START:
                case PENDING_START_PAUSED:
                case PENDING_RELEASE:
                    EncoderImpl.this.k.offer(Integer.valueOf(i));
                    EncoderImpl.this.d0();
                    return;
                default:
                    throw new IllegalStateException("Unknown state: " + EncoderImpl.this.t);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void n(MediaCodec.BufferInfo bufferInfo, MediaCodec mediaCodec, int i) {
            final gg0 gg0Var;
            Executor executor;
            if (this.j) {
                androidx.camera.core.x.k(EncoderImpl.this.a, "Receives frame after codec is reset.");
                return;
            }
            switch (EncoderImpl.this.t) {
                case CONFIGURED:
                case ERROR:
                case RELEASED:
                    return;
                case STARTED:
                case PAUSED:
                case STOPPING:
                case PENDING_START:
                case PENDING_START_PAUSED:
                case PENDING_RELEASE:
                    synchronized (EncoderImpl.this.b) {
                        EncoderImpl encoderImpl = EncoderImpl.this;
                        gg0Var = encoderImpl.r;
                        executor = encoderImpl.s;
                        break;
                    }
                    if (!this.c) {
                        this.c = true;
                        try {
                            Objects.requireNonNull(gg0Var);
                            executor.execute(new Runnable() { // from class: zg0
                                @Override // java.lang.Runnable
                                public final void run() {
                                    gg0Var.a();
                                }
                            });
                        } catch (RejectedExecutionException e) {
                            androidx.camera.core.x.d(EncoderImpl.this.a, "Unable to post to the supplied executor.", e);
                        }
                        break;
                    }
                    if (!i(bufferInfo)) {
                        try {
                            EncoderImpl.this.e.releaseOutputBuffer(i, false);
                        } catch (MediaCodec.CodecException e2) {
                            EncoderImpl.this.H(e2);
                            return;
                        }
                        break;
                    } else {
                        if (!this.d) {
                            this.d = true;
                            androidx.camera.core.x.a(EncoderImpl.this.a, "data timestampUs = " + bufferInfo.presentationTimeUs + ", data timebase = " + EncoderImpl.this.p + ", current system uptimeMs = " + SystemClock.uptimeMillis() + ", current system realtimeMs = " + SystemClock.elapsedRealtime());
                        }
                        MediaCodec.BufferInfo bufferInfoU = u(bufferInfo);
                        this.g = bufferInfoU.presentationTimeUs;
                        try {
                            v(new androidx.camera.video.internal.encoder.b(mediaCodec, i, bufferInfoU), gg0Var, executor);
                        } catch (MediaCodec.CodecException e3) {
                            EncoderImpl.this.H(e3);
                            return;
                        }
                        break;
                    }
                    if (this.e || !j(bufferInfo)) {
                        return;
                    }
                    t();
                    return;
                default:
                    throw new IllegalStateException("Unknown state: " + EncoderImpl.this.t);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ MediaFormat o(MediaFormat mediaFormat) {
            return mediaFormat;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void p(gg0 gg0Var, final MediaFormat mediaFormat) {
            gg0Var.e(new yx1() { // from class: androidx.camera.video.internal.encoder.x
                @Override // defpackage.yx1
                public final MediaFormat a() {
                    return EncoderImpl.d.o(mediaFormat);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void q(final MediaFormat mediaFormat) {
            final gg0 gg0Var;
            Executor executor;
            if (this.j) {
                androidx.camera.core.x.k(EncoderImpl.this.a, "Receives onOutputFormatChanged after codec is reset.");
                return;
            }
            switch (EncoderImpl.this.t) {
                case CONFIGURED:
                case ERROR:
                case RELEASED:
                    return;
                case STARTED:
                case PAUSED:
                case STOPPING:
                case PENDING_START:
                case PENDING_START_PAUSED:
                case PENDING_RELEASE:
                    synchronized (EncoderImpl.this.b) {
                        EncoderImpl encoderImpl = EncoderImpl.this;
                        gg0Var = encoderImpl.r;
                        executor = encoderImpl.s;
                        break;
                    }
                    try {
                        executor.execute(new Runnable() { // from class: androidx.camera.video.internal.encoder.u
                            @Override // java.lang.Runnable
                            public final void run() {
                                EncoderImpl.d.p(gg0Var, mediaFormat);
                            }
                        });
                        return;
                    } catch (RejectedExecutionException e) {
                        androidx.camera.core.x.d(EncoderImpl.this.a, "Unable to post to the supplied executor.", e);
                        return;
                    }
                default:
                    throw new IllegalStateException("Unknown state: " + EncoderImpl.this.t);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void r(Executor executor, final gg0 gg0Var) {
            if (EncoderImpl.this.t == InternalState.ERROR) {
                return;
            }
            try {
                Objects.requireNonNull(gg0Var);
                executor.execute(new Runnable() { // from class: yg0
                    @Override // java.lang.Runnable
                    public final void run() {
                        gg0Var.c();
                    }
                });
            } catch (RejectedExecutionException e) {
                androidx.camera.core.x.d(EncoderImpl.this.a, "Unable to post to the supplied executor.", e);
            }
        }

        private MediaCodec.BufferInfo u(MediaCodec.BufferInfo bufferInfo) {
            long jF = EncoderImpl.this.F(bufferInfo);
            if (bufferInfo.presentationTimeUs == jF) {
                return bufferInfo;
            }
            b52.i(jF > this.g);
            MediaCodec.BufferInfo bufferInfo2 = new MediaCodec.BufferInfo();
            bufferInfo2.set(bufferInfo.offset, bufferInfo.size, jF, bufferInfo.flags);
            return bufferInfo2;
        }

        private void v(final androidx.camera.video.internal.encoder.b bVar, final gg0 gg0Var, Executor executor) {
            EncoderImpl.this.n.add(bVar);
            os0.j(bVar.u(), new a(bVar), EncoderImpl.this.h);
            try {
                executor.execute(new Runnable() { // from class: androidx.camera.video.internal.encoder.w
                    @Override // java.lang.Runnable
                    public final void run() {
                        gg0Var.d(bVar);
                    }
                });
            } catch (RejectedExecutionException e) {
                androidx.camera.core.x.d(EncoderImpl.this.a, "Unable to post to the supplied executor.", e);
                bVar.close();
            }
        }

        private boolean x(MediaCodec.BufferInfo bufferInfo) {
            Executor executor;
            final gg0 gg0Var;
            EncoderImpl.this.o0(bufferInfo.presentationTimeUs);
            boolean zL = EncoderImpl.this.L(bufferInfo.presentationTimeUs);
            boolean z = this.h;
            if (!z && zL) {
                androidx.camera.core.x.a(EncoderImpl.this.a, "Switch to pause state");
                this.h = true;
                synchronized (EncoderImpl.this.b) {
                    EncoderImpl encoderImpl = EncoderImpl.this;
                    executor = encoderImpl.s;
                    gg0Var = encoderImpl.r;
                }
                Objects.requireNonNull(gg0Var);
                executor.execute(new Runnable() { // from class: ah0
                    @Override // java.lang.Runnable
                    public final void run() {
                        gg0Var.f();
                    }
                });
                EncoderImpl encoderImpl2 = EncoderImpl.this;
                if (encoderImpl2.t == InternalState.PAUSED && ((encoderImpl2.c || va0.a(ib.class) == null) && (!EncoderImpl.this.c || va0.a(sc3.class) == null))) {
                    androidx.camera.video.internal.encoder.c.b bVar = EncoderImpl.this.f;
                    if (bVar instanceof c) {
                        ((c) bVar).A(false);
                    }
                    EncoderImpl.this.i0(true);
                }
                EncoderImpl.this.x = Long.valueOf(bufferInfo.presentationTimeUs);
                EncoderImpl encoderImpl3 = EncoderImpl.this;
                if (encoderImpl3.w) {
                    Future future = encoderImpl3.y;
                    if (future != null) {
                        future.cancel(true);
                    }
                    EncoderImpl.this.k0();
                    EncoderImpl.this.w = false;
                }
            } else if (z && !zL) {
                androidx.camera.core.x.a(EncoderImpl.this.a, "Switch to resume state");
                this.h = false;
                if (EncoderImpl.this.c && !EncoderImpl.M(bufferInfo)) {
                    this.i = true;
                }
            }
            return this.h;
        }

        @Override // android.media.MediaCodec.Callback
        public void onError(MediaCodec mediaCodec, final MediaCodec.CodecException codecException) {
            EncoderImpl.this.h.execute(new Runnable() { // from class: androidx.camera.video.internal.encoder.s
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.l(codecException);
                }
            });
        }

        @Override // android.media.MediaCodec.Callback
        public void onInputBufferAvailable(MediaCodec mediaCodec, final int i) {
            EncoderImpl.this.h.execute(new Runnable() { // from class: androidx.camera.video.internal.encoder.q
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.m(i);
                }
            });
        }

        @Override // android.media.MediaCodec.Callback
        public void onOutputBufferAvailable(final MediaCodec mediaCodec, final int i, final MediaCodec.BufferInfo bufferInfo) {
            EncoderImpl.this.h.execute(new Runnable() { // from class: androidx.camera.video.internal.encoder.r
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.n(bufferInfo, mediaCodec, i);
                }
            });
        }

        @Override // android.media.MediaCodec.Callback
        public void onOutputFormatChanged(MediaCodec mediaCodec, final MediaFormat mediaFormat) {
            EncoderImpl.this.h.execute(new Runnable() { // from class: androidx.camera.video.internal.encoder.t
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.q(mediaFormat);
                }
            });
        }

        void t() {
            EncoderImpl encoderImpl;
            final gg0 gg0Var;
            final Executor executor;
            if (this.e) {
                return;
            }
            this.e = true;
            if (EncoderImpl.this.D != null) {
                EncoderImpl.this.D.cancel(false);
                EncoderImpl.this.D = null;
            }
            synchronized (EncoderImpl.this.b) {
                encoderImpl = EncoderImpl.this;
                gg0Var = encoderImpl.r;
                executor = encoderImpl.s;
            }
            encoderImpl.n0(new Runnable() { // from class: androidx.camera.video.internal.encoder.v
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.r(executor, gg0Var);
                }
            });
        }

        void w() {
            this.j = true;
        }
    }

    class e implements androidx.camera.video.internal.encoder.c.InterfaceC0011c {
        private Surface b;
        private androidx.camera.video.internal.encoder.c.InterfaceC0011c.a d;
        private Executor e;
        private final Object a = new Object();
        private final Set c = new HashSet();

        e() {
        }

        private void d(Executor executor, final androidx.camera.video.internal.encoder.c.InterfaceC0011c.a aVar, final Surface surface) {
            try {
                executor.execute(new Runnable() { // from class: androidx.camera.video.internal.encoder.y
                    @Override // java.lang.Runnable
                    public final void run() {
                        aVar.a(surface);
                    }
                });
            } catch (RejectedExecutionException e) {
                androidx.camera.core.x.d(EncoderImpl.this.a, "Unable to post to the supplied executor.", e);
            }
        }

        @Override // androidx.camera.video.internal.encoder.c.InterfaceC0011c
        public void b(Executor executor, androidx.camera.video.internal.encoder.c.InterfaceC0011c.a aVar) {
            Surface surface;
            synchronized (this.a) {
                this.d = (androidx.camera.video.internal.encoder.c.InterfaceC0011c.a) b52.g(aVar);
                this.e = (Executor) b52.g(executor);
                surface = this.b;
            }
            if (surface != null) {
                d(executor, aVar, surface);
            }
        }

        void e() {
            Surface surface;
            HashSet hashSet;
            synchronized (this.a) {
                surface = this.b;
                this.b = null;
                hashSet = new HashSet(this.c);
                this.c.clear();
            }
            if (surface != null) {
                surface.release();
            }
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                ((Surface) it.next()).release();
            }
        }

        void f() {
            Surface surfaceCreateInputSurface;
            androidx.camera.video.internal.encoder.c.InterfaceC0011c.a aVar;
            Executor executor;
            ch0 ch0Var = (ch0) va0.a(ch0.class);
            synchronized (this.a) {
                try {
                    if (ch0Var == null) {
                        if (this.b == null) {
                            surfaceCreateInputSurface = b.a();
                            this.b = surfaceCreateInputSurface;
                        } else {
                            surfaceCreateInputSurface = null;
                        }
                        b.b(EncoderImpl.this.e, this.b);
                    } else {
                        Surface surface = this.b;
                        if (surface != null) {
                            this.c.add(surface);
                        }
                        surfaceCreateInputSurface = EncoderImpl.this.e.createInputSurface();
                        this.b = surfaceCreateInputSurface;
                    }
                    aVar = this.d;
                    executor = this.e;
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (surfaceCreateInputSurface == null || aVar == null || executor == null) {
                return;
            }
            d(executor, aVar, surfaceCreateInputSurface);
        }
    }

    public EncoderImpl(Executor executor, hg0 hg0Var) throws InvalidConfigException {
        b52.g(executor);
        b52.g(hg0Var);
        MediaCodec mediaCodecA = az.a(hg0Var);
        this.e = mediaCodecA;
        MediaCodecInfo codecInfo = mediaCodecA.getCodecInfo();
        this.h = androidx.camera.core.impl.utils.executor.c.g(executor);
        MediaFormat mediaFormatA = hg0Var.a();
        this.d = mediaFormatA;
        Timebase timebaseB = hg0Var.b();
        this.p = timebaseB;
        if (hg0Var instanceof fb) {
            this.a = "AudioEncoder";
            this.c = false;
            this.f = new c();
            this.g = new androidx.camera.video.internal.encoder.a(codecInfo, hg0Var.c());
        } else {
            if (!(hg0Var instanceof kc3)) {
                throw new InvalidConfigException("Unknown encoder config type");
            }
            this.a = "VideoEncoder";
            this.c = true;
            this.f = new e();
            c0 c0Var = new c0(codecInfo, hg0Var.c());
            D(c0Var, mediaFormatA);
            this.g = c0Var;
        }
        androidx.camera.core.x.a(this.a, "mInputTimebase = " + timebaseB);
        androidx.camera.core.x.a(this.a, "mMediaFormat = " + mediaFormatA);
        try {
            h0();
            final AtomicReference atomicReference = new AtomicReference();
            this.i = os0.B(CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: rg0
                @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
                public final Object a(CallbackToFutureAdapter.a aVar) {
                    return EncoderImpl.S(atomicReference, aVar);
                }
            }));
            this.j = (CallbackToFutureAdapter.a) b52.g((CallbackToFutureAdapter.a) atomicReference.get());
            j0(InternalState.CONFIGURED);
        } catch (MediaCodec.CodecException e2) {
            throw new InvalidConfigException(e2);
        }
    }

    private void C() {
        if (va0.a(yo2.class) != null) {
            final d dVar = this.z;
            final Executor executor = this.h;
            Future future = this.D;
            if (future != null) {
                future.cancel(false);
            }
            this.D = androidx.camera.core.impl.utils.executor.c.e().schedule(new Runnable() { // from class: androidx.camera.video.internal.encoder.d
                @Override // java.lang.Runnable
                public final void run() {
                    EncoderImpl.P(executor, dVar);
                }
            }, 1000L, TimeUnit.MILLISECONDS);
        }
    }

    private void D(pc3 pc3Var, MediaFormat mediaFormat) {
        b52.i(this.c);
        if (mediaFormat.containsKey("bitrate")) {
            int integer = mediaFormat.getInteger("bitrate");
            int iIntValue = ((Integer) pc3Var.c().clamp(Integer.valueOf(integer))).intValue();
            if (integer != iIntValue) {
                mediaFormat.setInteger("bitrate", iIntValue);
                androidx.camera.core.x.a(this.a, "updated bitrate from " + integer + " to " + iIntValue);
            }
        }
    }

    static boolean J(MediaCodec.BufferInfo bufferInfo) {
        return (bufferInfo.flags & 4) != 0;
    }

    private boolean K() {
        return va0.a(nu2.class) != null;
    }

    static boolean M(MediaCodec.BufferInfo bufferInfo) {
        return (bufferInfo.flags & 1) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object N(AtomicReference atomicReference, CallbackToFutureAdapter.a aVar) {
        atomicReference.set(aVar);
        return "acquireInputBuffer";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O(CallbackToFutureAdapter.a aVar) {
        this.l.remove(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void P(Executor executor, final d dVar) {
        Objects.requireNonNull(dVar);
        executor.execute(new Runnable() { // from class: androidx.camera.video.internal.encoder.e
            @Override // java.lang.Runnable
            public final void run() {
                dVar.t();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R(b0 b0Var) {
        this.m.remove(b0Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object S(AtomicReference atomicReference, CallbackToFutureAdapter.a aVar) {
        atomicReference.set(aVar);
        return "mReleasedFuture";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void T(gg0 gg0Var, int i, String str, Throwable th) {
        gg0Var.b(new EncodeException(i, str, th));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U(long j) {
        switch (this.t) {
            case CONFIGURED:
            case PAUSED:
            case STOPPING:
            case PENDING_START_PAUSED:
            case ERROR:
                return;
            case STARTED:
                androidx.camera.core.x.a(this.a, "Pause on " + l70.c(j));
                this.o.addLast(Range.create(Long.valueOf(j), Long.MAX_VALUE));
                j0(InternalState.PAUSED);
                return;
            case PENDING_START:
                j0(InternalState.PENDING_START_PAUSED);
                return;
            case PENDING_RELEASE:
            case RELEASED:
                throw new IllegalStateException("Encoder is released");
            default:
                throw new IllegalStateException("Unknown state: " + this.t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V() {
        switch (this.t) {
            case CONFIGURED:
            case STARTED:
            case PAUSED:
            case ERROR:
                f0();
                return;
            case STOPPING:
            case PENDING_START:
            case PENDING_START_PAUSED:
                j0(InternalState.PENDING_RELEASE);
                return;
            case PENDING_RELEASE:
            case RELEASED:
                return;
            default:
                throw new IllegalStateException("Unknown state: " + this.t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W() {
        int iOrdinal = this.t.ordinal();
        if (iOrdinal == 1) {
            g0();
        } else if (iOrdinal == 6 || iOrdinal == 8) {
            throw new IllegalStateException("Encoder is released");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X() {
        this.B = true;
        if (this.A) {
            this.e.stop();
            h0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y(long j) {
        switch (this.t) {
            case CONFIGURED:
                this.x = null;
                androidx.camera.core.x.a(this.a, "Start on " + l70.c(j));
                try {
                    if (this.A) {
                        h0();
                    }
                    this.u = Range.create(Long.valueOf(j), Long.MAX_VALUE);
                    this.e.start();
                    androidx.camera.video.internal.encoder.c.b bVar = this.f;
                    if (bVar instanceof c) {
                        ((c) bVar).A(true);
                    }
                    j0(InternalState.STARTED);
                    return;
                } catch (MediaCodec.CodecException e2) {
                    H(e2);
                    return;
                }
            case STARTED:
            case PENDING_START:
            case ERROR:
                return;
            case PAUSED:
                this.x = null;
                Range range = (Range) this.o.removeLast();
                b52.j(range != null && ((Long) range.getUpper()).longValue() == Long.MAX_VALUE, "There should be a \"pause\" before \"resume\"");
                Long l = (Long) range.getLower();
                long jLongValue = l.longValue();
                this.o.addLast(Range.create(l, Long.valueOf(j)));
                androidx.camera.core.x.a(this.a, "Resume on " + l70.c(j) + "\nPaused duration = " + l70.c(j - jLongValue));
                if ((this.c || va0.a(ib.class) == null) && (!this.c || va0.a(sc3.class) == null)) {
                    i0(false);
                    androidx.camera.video.internal.encoder.c.b bVar2 = this.f;
                    if (bVar2 instanceof c) {
                        ((c) bVar2).A(true);
                    }
                }
                if (this.c) {
                    g0();
                }
                j0(InternalState.STARTED);
                return;
            case STOPPING:
            case PENDING_START_PAUSED:
                j0(InternalState.PENDING_START);
                return;
            case PENDING_RELEASE:
            case RELEASED:
                throw new IllegalStateException("Encoder is released");
            default:
                throw new IllegalStateException("Unknown state: " + this.t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z() {
        if (this.w) {
            androidx.camera.core.x.k(this.a, "The data didn't reach the expected timestamp before timeout, stop the codec.");
            this.x = null;
            k0();
            this.w = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0() {
        this.h.execute(new Runnable() { // from class: mg0
            @Override // java.lang.Runnable
            public final void run() {
                this.a.Z();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(long j, long j2) {
        switch (this.t) {
            case CONFIGURED:
            case STOPPING:
            case ERROR:
                return;
            case STARTED:
            case PAUSED:
                InternalState internalState = this.t;
                j0(InternalState.STOPPING);
                Long l = (Long) this.u.getLower();
                long jLongValue = l.longValue();
                if (jLongValue == Long.MAX_VALUE) {
                    throw new AssertionError("There should be a \"start\" before \"stop\"");
                }
                if (j == -1) {
                    j = j2;
                } else if (j < jLongValue) {
                    androidx.camera.core.x.k(this.a, "The expected stop time is less than the start time. Use current time as stop time.");
                    j = j2;
                }
                if (j < jLongValue) {
                    throw new AssertionError("The start time should be before the stop time.");
                }
                this.u = Range.create(l, Long.valueOf(j));
                androidx.camera.core.x.a(this.a, "Stop on " + l70.c(j));
                if (internalState == InternalState.PAUSED && this.x != null) {
                    k0();
                    return;
                } else {
                    this.w = true;
                    this.y = androidx.camera.core.impl.utils.executor.c.e().schedule(new Runnable() { // from class: lg0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.a.a0();
                        }
                    }, 1000L, TimeUnit.MILLISECONDS);
                    return;
                }
            case PENDING_START:
            case PENDING_START_PAUSED:
                j0(InternalState.CONFIGURED);
                return;
            case PENDING_RELEASE:
            case RELEASED:
                throw new IllegalStateException("Encoder is released");
            default:
                throw new IllegalStateException("Unknown state: " + this.t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0(List list, Runnable runnable) {
        if (this.t != InternalState.ERROR) {
            if (!list.isEmpty()) {
                androidx.camera.core.x.a(this.a, "encoded data and input buffers are returned");
            }
            if (!(this.f instanceof e) || this.B || K()) {
                this.e.stop();
            } else {
                this.e.flush();
                this.A = true;
            }
        }
        if (runnable != null) {
            runnable.run();
        }
        I();
    }

    private void f0() {
        if (this.A) {
            this.e.stop();
            this.A = false;
        }
        this.e.release();
        androidx.camera.video.internal.encoder.c.b bVar = this.f;
        if (bVar instanceof e) {
            ((e) bVar).e();
        }
        j0(InternalState.RELEASED);
        this.j.c(null);
    }

    private void h0() {
        this.u = E;
        this.v = 0L;
        this.o.clear();
        this.k.clear();
        Iterator it = this.l.iterator();
        while (it.hasNext()) {
            ((CallbackToFutureAdapter.a) it.next()).d();
        }
        this.l.clear();
        this.e.reset();
        this.A = false;
        this.B = false;
        this.C = false;
        this.w = false;
        Future future = this.y;
        if (future != null) {
            future.cancel(true);
            this.y = null;
        }
        Future future2 = this.D;
        if (future2 != null) {
            future2.cancel(false);
            this.D = null;
        }
        d dVar = this.z;
        if (dVar != null) {
            dVar.w();
        }
        d dVar2 = new d();
        this.z = dVar2;
        this.e.setCallback(dVar2);
        this.e.configure(this.d, (Surface) null, (MediaCrypto) null, 1);
        androidx.camera.video.internal.encoder.c.b bVar = this.f;
        if (bVar instanceof e) {
            ((e) bVar).f();
        }
    }

    private void j0(InternalState internalState) {
        if (this.t == internalState) {
            return;
        }
        androidx.camera.core.x.a(this.a, "Transitioning encoder internal state: " + this.t + " --> " + internalState);
        this.t = internalState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l0() {
        os0.j(B(), new a(), this.h);
    }

    ub1 B() {
        switch (this.t) {
            case CONFIGURED:
                return os0.n(new IllegalStateException("Encoder is not started yet."));
            case STARTED:
            case PAUSED:
            case STOPPING:
            case PENDING_START:
            case PENDING_START_PAUSED:
            case PENDING_RELEASE:
                final AtomicReference atomicReference = new AtomicReference();
                ub1 ub1VarA = CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: og0
                    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
                    public final Object a(CallbackToFutureAdapter.a aVar) {
                        return EncoderImpl.N(atomicReference, aVar);
                    }
                });
                final CallbackToFutureAdapter.a aVar = (CallbackToFutureAdapter.a) b52.g((CallbackToFutureAdapter.a) atomicReference.get());
                this.l.offer(aVar);
                aVar.a(new Runnable() { // from class: pg0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.O(aVar);
                    }
                }, this.h);
                d0();
                return ub1VarA;
            case ERROR:
                return os0.n(new IllegalStateException("Encoder is in error state."));
            case RELEASED:
                return os0.n(new IllegalStateException("Encoder is released."));
            default:
                throw new IllegalStateException("Unknown state: " + this.t);
        }
    }

    long E() {
        return this.f160q.a();
    }

    long F(MediaCodec.BufferInfo bufferInfo) {
        long j = this.v;
        return j > 0 ? bufferInfo.presentationTimeUs - j : bufferInfo.presentationTimeUs;
    }

    void G(final int i, final String str, final Throwable th) {
        switch (this.t) {
            case CONFIGURED:
                Q(i, str, th);
                h0();
                break;
            case STARTED:
            case PAUSED:
            case STOPPING:
            case PENDING_START:
            case PENDING_START_PAUSED:
            case PENDING_RELEASE:
                j0(InternalState.ERROR);
                n0(new Runnable() { // from class: tg0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.Q(i, str, th);
                    }
                });
                break;
            case ERROR:
                androidx.camera.core.x.l(this.a, "Get more than one error: " + str + "(" + i + ")", th);
                break;
        }
    }

    void H(MediaCodec.CodecException codecException) {
        G(1, codecException.getMessage(), codecException);
    }

    void I() {
        InternalState internalState = this.t;
        if (internalState == InternalState.PENDING_RELEASE) {
            f0();
            return;
        }
        if (!this.A) {
            h0();
        }
        j0(InternalState.CONFIGURED);
        if (internalState == InternalState.PENDING_START || internalState == InternalState.PENDING_START_PAUSED) {
            start();
            if (internalState == InternalState.PENDING_START_PAUSED) {
                pause();
            }
        }
    }

    boolean L(long j) {
        for (Range range : this.o) {
            if (range.contains(Long.valueOf(j))) {
                return true;
            }
            if (j < ((Long) range.getLower()).longValue()) {
                break;
            }
        }
        return false;
    }

    @Override // androidx.camera.video.internal.encoder.c
    public void a(final long j) {
        final long jE = E();
        this.h.execute(new Runnable() { // from class: xg0
            @Override // java.lang.Runnable
            public final void run() {
                this.a.b0(j, jE);
            }
        });
    }

    @Override // androidx.camera.video.internal.encoder.c
    public androidx.camera.video.internal.encoder.c.b b() {
        return this.f;
    }

    @Override // androidx.camera.video.internal.encoder.c
    public bh0 c() {
        return this.g;
    }

    @Override // androidx.camera.video.internal.encoder.c
    public ub1 d() {
        return this.i;
    }

    void d0() {
        while (!this.l.isEmpty() && !this.k.isEmpty()) {
            CallbackToFutureAdapter.a aVar = (CallbackToFutureAdapter.a) this.l.poll();
            Objects.requireNonNull(aVar);
            Integer num = (Integer) this.k.poll();
            Objects.requireNonNull(num);
            try {
                final b0 b0Var = new b0(this.e, num.intValue());
                if (aVar.c(b0Var)) {
                    this.m.add(b0Var);
                    b0Var.a().a(new Runnable() { // from class: androidx.camera.video.internal.encoder.f
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.a.R(b0Var);
                        }
                    }, this.h);
                } else {
                    b0Var.cancel();
                }
            } catch (MediaCodec.CodecException e2) {
                H(e2);
                return;
            }
        }
    }

    @Override // androidx.camera.video.internal.encoder.c
    public void e(gg0 gg0Var, Executor executor) {
        synchronized (this.b) {
            this.r = gg0Var;
            this.s = executor;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
    public void Q(final int i, final String str, final Throwable th) {
        final gg0 gg0Var;
        Executor executor;
        synchronized (this.b) {
            gg0Var = this.r;
            executor = this.s;
        }
        try {
            executor.execute(new Runnable() { // from class: ug0
                @Override // java.lang.Runnable
                public final void run() {
                    EncoderImpl.T(gg0Var, i, str, th);
                }
            });
        } catch (RejectedExecutionException e2) {
            androidx.camera.core.x.d(this.a, "Unable to post to the supplied executor.", e2);
        }
    }

    @Override // androidx.camera.video.internal.encoder.c
    public void f() {
        this.h.execute(new Runnable() { // from class: ng0
            @Override // java.lang.Runnable
            public final void run() {
                this.a.W();
            }
        });
    }

    @Override // androidx.camera.video.internal.encoder.c
    public int g() {
        if (this.d.containsKey("bitrate")) {
            return this.d.getInteger("bitrate");
        }
        return 0;
    }

    void g0() {
        Bundle bundle = new Bundle();
        bundle.putInt("request-sync", 0);
        this.e.setParameters(bundle);
    }

    void i0(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putInt("drop-input-frames", z ? 1 : 0);
        this.e.setParameters(bundle);
    }

    void k0() {
        androidx.camera.core.x.a(this.a, "signalCodecStop");
        androidx.camera.video.internal.encoder.c.b bVar = this.f;
        if (bVar instanceof c) {
            ((c) bVar).A(false);
            ArrayList arrayList = new ArrayList();
            Iterator it = this.m.iterator();
            while (it.hasNext()) {
                arrayList.add(((n21) it.next()).a());
            }
            os0.F(arrayList).a(new Runnable() { // from class: kg0
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.l0();
                }
            }, this.h);
            return;
        }
        if (bVar instanceof e) {
            try {
                C();
                this.e.signalEndOfInputStream();
                this.C = true;
            } catch (MediaCodec.CodecException e2) {
                H(e2);
            }
        }
    }

    public void m0() {
        this.h.execute(new Runnable() { // from class: vg0
            @Override // java.lang.Runnable
            public final void run() {
                this.a.X();
            }
        });
    }

    void n0(final Runnable runnable) {
        androidx.camera.core.x.a(this.a, "stopMediaCodec");
        final ArrayList arrayList = new ArrayList();
        Iterator it = this.n.iterator();
        while (it.hasNext()) {
            arrayList.add(((androidx.camera.video.internal.encoder.b) it.next()).u());
        }
        Iterator it2 = this.m.iterator();
        while (it2.hasNext()) {
            arrayList.add(((n21) it2.next()).a());
        }
        if (!arrayList.isEmpty()) {
            androidx.camera.core.x.a(this.a, "Waiting for resources to return. encoded data = " + this.n.size() + ", input buffers = " + this.m.size());
        }
        os0.F(arrayList).a(new Runnable() { // from class: wg0
            @Override // java.lang.Runnable
            public final void run() {
                this.a.c0(arrayList, runnable);
            }
        }, this.h);
    }

    void o0(long j) {
        while (!this.o.isEmpty()) {
            Range range = (Range) this.o.getFirst();
            if (j <= ((Long) range.getUpper()).longValue()) {
                return;
            }
            this.o.removeFirst();
            this.v += ((Long) range.getUpper()).longValue() - ((Long) range.getLower()).longValue();
            androidx.camera.core.x.a(this.a, "Total paused duration = " + l70.c(this.v));
        }
    }

    @Override // androidx.camera.video.internal.encoder.c
    public void pause() {
        final long jE = E();
        this.h.execute(new Runnable() { // from class: jg0
            @Override // java.lang.Runnable
            public final void run() {
                this.a.U(jE);
            }
        });
    }

    @Override // androidx.camera.video.internal.encoder.c
    public void release() {
        this.h.execute(new Runnable() { // from class: sg0
            @Override // java.lang.Runnable
            public final void run() {
                this.a.V();
            }
        });
    }

    @Override // androidx.camera.video.internal.encoder.c
    public void start() {
        final long jE = E();
        this.h.execute(new Runnable() { // from class: qg0
            @Override // java.lang.Runnable
            public final void run() {
                this.a.Y(jE);
            }
        });
    }
}
