package androidx.camera.video;

import android.content.ContentValues;
import android.content.Context;
import android.location.Location;
import android.media.MediaMuxer;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Pair;
import android.util.Range;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.Timebase;
import androidx.camera.video.Recorder;
import androidx.camera.video.internal.audio.AudioSource;
import androidx.camera.video.internal.audio.AudioSourceAccessException;
import androidx.camera.video.internal.encoder.EncodeException;
import androidx.camera.video.internal.encoder.EncoderImpl;
import androidx.camera.video.internal.encoder.InvalidConfigException;
import androidx.camera.video.internal.encoder.c;
import androidx.camera.video.x0;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import defpackage.b52;
import defpackage.bi1;
import defpackage.bs0;
import defpackage.c70;
import defpackage.ch0;
import defpackage.dg0;
import defpackage.eb;
import defpackage.fy1;
import defpackage.gg0;
import defpackage.ho;
import defpackage.ie0;
import defpackage.ig0;
import defpackage.jb;
import defpackage.jy1;
import defpackage.kb;
import defpackage.l70;
import defpackage.om1;
import defpackage.os0;
import defpackage.pc3;
import defpackage.q20;
import defpackage.q40;
import defpackage.r7;
import defpackage.rt2;
import defpackage.ry;
import defpackage.sm0;
import defpackage.ub1;
import defpackage.ut1;
import defpackage.va0;
import defpackage.vd3;
import defpackage.x9;
import defpackage.xh2;
import defpackage.yt;
import defpackage.yx1;
import defpackage.zt;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class Recorder implements VideoOutput {
    private static final Set i0 = Collections.unmodifiableSet(EnumSet.of(State.PENDING_RECORDING, State.PENDING_PAUSED));
    private static final Set j0 = Collections.unmodifiableSet(EnumSet.of(State.CONFIGURING, State.IDLING, State.RESETTING, State.STOPPING, State.ERROR));
    public static final v k0;
    private static final x0 l0;
    private static final p m0;
    private static final Exception n0;
    static final ig0 o0;
    private static final Executor p0;
    static int q0;
    static long r0;
    Surface A;
    MediaMuxer B;
    final om1 C;
    AudioSource D;
    androidx.camera.video.internal.encoder.c E;
    yx1 F;
    androidx.camera.video.internal.encoder.c G;
    yx1 H;
    AudioState I;
    Uri J;
    long K;
    long L;
    long M;
    int N;
    Range O;
    long P;
    long Q;
    long R;
    long S;
    long T;
    int U;
    Throwable V;
    dg0 W;
    final xh2 X;
    Throwable Y;
    boolean Z;
    private final om1 a;
    VideoOutput.SourceState a0;
    private final Executor b;
    ScheduledFuture b0;
    private final Executor c;
    private boolean c0;
    final Executor d;
    VideoEncoderSession d0;
    private final ig0 e;
    VideoEncoderSession e0;
    private final ig0 f;
    double f0;
    private final Object g = new Object();
    private boolean g0;
    private final boolean h;
    private i h0;
    private final int i;
    private State j;
    private State k;
    int l;
    h m;
    h n;
    private long o;
    h p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    boolean f158q;
    private SurfaceRequest.g r;
    private SurfaceRequest.g s;
    private vd3 t;
    final List u;
    Integer v;
    Integer w;
    SurfaceRequest x;
    Timebase y;
    Surface z;

    enum AudioState {
        INITIALIZING,
        IDLING,
        DISABLED,
        ENABLED,
        ERROR_ENCODER,
        ERROR_SOURCE
    }

    enum State {
        CONFIGURING,
        PENDING_RECORDING,
        PENDING_PAUSED,
        IDLING,
        RECORDING,
        PAUSED,
        STOPPING,
        RESETTING,
        ERROR
    }

    class a implements bs0 {
        final /* synthetic */ VideoEncoderSession a;

        a(VideoEncoderSession videoEncoderSession) {
            this.a = videoEncoderSession;
        }

        @Override // defpackage.bs0
        public void a(Throwable th) {
            androidx.camera.core.x.a("Recorder", "Error in ReadyToReleaseFuture: " + th);
        }

        @Override // defpackage.bs0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(androidx.camera.video.internal.encoder.c cVar) {
            androidx.camera.video.internal.encoder.c cVar2;
            androidx.camera.core.x.a("Recorder", "VideoEncoder can be released: " + cVar);
            if (cVar == null) {
                return;
            }
            ScheduledFuture scheduledFuture = Recorder.this.b0;
            if (scheduledFuture != null && scheduledFuture.cancel(false) && (cVar2 = Recorder.this.E) != null && cVar2 == cVar) {
                Recorder.a0(cVar2);
            }
            Recorder recorder = Recorder.this;
            recorder.e0 = this.a;
            recorder.w0(null);
            Recorder recorder2 = Recorder.this;
            recorder2.o0(4, null, recorder2.L());
        }
    }

    class b implements bs0 {
        final /* synthetic */ AudioSource a;

        b(AudioSource audioSource) {
            this.a = audioSource;
        }

        @Override // defpackage.bs0
        public void a(Throwable th) {
            androidx.camera.core.x.a("Recorder", String.format("An error occurred while attempting to release audio source: 0x%x", Integer.valueOf(this.a.hashCode())));
        }

        @Override // defpackage.bs0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Void r2) {
            androidx.camera.core.x.a("Recorder", String.format("Released audio source successfully: 0x%x", Integer.valueOf(this.a.hashCode())));
        }
    }

    class c implements gg0 {
        final /* synthetic */ CallbackToFutureAdapter.a b;
        final /* synthetic */ h c;

        c(CallbackToFutureAdapter.a aVar, h hVar) {
            this.b = aVar;
            this.c = hVar;
        }

        @Override // defpackage.gg0
        public void a() {
        }

        @Override // defpackage.gg0
        public void b(EncodeException encodeException) {
            this.b.f(encodeException);
        }

        @Override // defpackage.gg0
        public void c() {
            this.b.c(null);
        }

        @Override // defpackage.gg0
        public void d(dg0 dg0Var) {
            boolean z;
            Recorder recorder = Recorder.this;
            if (recorder.B != null) {
                try {
                    recorder.O0(dg0Var, this.c);
                    if (dg0Var != null) {
                        dg0Var.close();
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    if (dg0Var != null) {
                        try {
                            dg0Var.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            }
            if (recorder.f158q) {
                androidx.camera.core.x.a("Recorder", "Drop video data since recording is stopping.");
                dg0Var.close();
                return;
            }
            dg0 dg0Var2 = recorder.W;
            if (dg0Var2 != null) {
                dg0Var2.close();
                Recorder.this.W = null;
                z = true;
            } else {
                z = false;
            }
            if (!dg0Var.Q()) {
                if (z) {
                    androidx.camera.core.x.a("Recorder", "Dropped cached keyframe since we have new video data and have not yet received audio data.");
                }
                androidx.camera.core.x.a("Recorder", "Dropped video data since muxer has not yet started and data is not a keyframe.");
                Recorder.this.E.f();
                dg0Var.close();
                return;
            }
            Recorder recorder2 = Recorder.this;
            recorder2.W = dg0Var;
            if (!recorder2.J() || !Recorder.this.X.isEmpty()) {
                androidx.camera.core.x.a("Recorder", "Received video keyframe. Starting muxer...");
                Recorder.this.z0(this.c);
            } else if (z) {
                androidx.camera.core.x.a("Recorder", "Replaced cached video keyframe with newer keyframe.");
            } else {
                androidx.camera.core.x.a("Recorder", "Cached video keyframe while we wait for first audio sample before starting muxer.");
            }
        }

        @Override // defpackage.gg0
        public void e(yx1 yx1Var) {
            Recorder.this.F = yx1Var;
        }
    }

    class d implements AudioSource.c {
        final /* synthetic */ q20 a;

        d(q20 q20Var) {
            this.a = q20Var;
        }

        @Override // androidx.camera.video.internal.audio.AudioSource.c
        public void a(boolean z) {
            Recorder recorder = Recorder.this;
            if (recorder.Z != z) {
                recorder.Z = z;
                recorder.L0();
            } else {
                androidx.camera.core.x.k("Recorder", "Audio source silenced transitions to the same state " + z);
            }
        }

        @Override // androidx.camera.video.internal.audio.AudioSource.c
        public void c(double d) {
            Recorder.this.f0 = d;
        }

        @Override // androidx.camera.video.internal.audio.AudioSource.c
        public void onError(Throwable th) {
            androidx.camera.core.x.d("Recorder", "Error occurred after audio source started.", th);
            if (th instanceof AudioSourceAccessException) {
                this.a.accept(th);
            }
        }
    }

    class e implements gg0 {
        final /* synthetic */ CallbackToFutureAdapter.a b;
        final /* synthetic */ q20 c;
        final /* synthetic */ h d;

        e(CallbackToFutureAdapter.a aVar, q20 q20Var, h hVar) {
            this.b = aVar;
            this.c = q20Var;
            this.d = hVar;
        }

        @Override // defpackage.gg0
        public void a() {
        }

        @Override // defpackage.gg0
        public void b(EncodeException encodeException) {
            if (Recorder.this.Y == null) {
                this.c.accept(encodeException);
            }
        }

        @Override // defpackage.gg0
        public void c() {
            this.b.c(null);
        }

        @Override // defpackage.gg0
        public void d(dg0 dg0Var) {
            Recorder recorder = Recorder.this;
            if (recorder.I == AudioState.DISABLED) {
                dg0Var.close();
                throw new AssertionError("Audio is not enabled but audio encoded data is being produced.");
            }
            if (recorder.B == null) {
                if (recorder.f158q) {
                    androidx.camera.core.x.a("Recorder", "Drop audio data since recording is stopping.");
                } else {
                    recorder.X.b(new ho(dg0Var));
                    if (Recorder.this.W != null) {
                        androidx.camera.core.x.a("Recorder", "Received audio data. Starting muxer...");
                        Recorder.this.z0(this.d);
                    } else {
                        androidx.camera.core.x.a("Recorder", "Cached audio data while we wait for video keyframe before starting muxer.");
                    }
                }
                dg0Var.close();
                return;
            }
            try {
                recorder.N0(dg0Var, this.d);
                if (dg0Var != null) {
                    dg0Var.close();
                }
            } catch (Throwable th) {
                if (dg0Var != null) {
                    try {
                        dg0Var.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }

        @Override // defpackage.gg0
        public void e(yx1 yx1Var) {
            Recorder.this.H = yx1Var;
        }
    }

    class f implements bs0 {
        f() {
        }

        @Override // defpackage.bs0
        public void a(Throwable th) {
            b52.j(Recorder.this.p != null, "In-progress recording shouldn't be null");
            if (Recorder.this.p.A0()) {
                return;
            }
            androidx.camera.core.x.a("Recorder", "Encodings end with error: " + th);
            Recorder recorder = Recorder.this;
            recorder.A(recorder.B == null ? 8 : 6, th);
        }

        @Override // defpackage.bs0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(List list) {
            androidx.camera.core.x.a("Recorder", "Encodings end successfully.");
            Recorder recorder = Recorder.this;
            recorder.A(recorder.U, recorder.V);
        }
    }

    public static final class g {
        private final p.a a;
        private int b = 0;
        private Executor c = null;
        private ig0 d;
        private ig0 e;

        public g() {
            ig0 ig0Var = Recorder.o0;
            this.d = ig0Var;
            this.e = ig0Var;
            this.a = p.a();
        }

        public Recorder b() {
            return new Recorder(this.c, this.a.a(), this.b, this.d, this.e);
        }

        public g d(final v vVar) {
            b52.h(vVar, "The specified quality selector can't be null.");
            this.a.b(new q20() { // from class: ce2
                @Override // defpackage.q20
                public final void accept(Object obj) {
                    ((x0.a) obj).e(vVar);
                }
            });
            return this;
        }
    }

    static abstract class h implements AutoCloseable {
        private final ry a = ry.b();
        private final AtomicBoolean b = new AtomicBoolean(false);
        private final AtomicReference c = new AtomicReference(null);
        private final AtomicReference d = new AtomicReference(null);
        private final AtomicReference e = new AtomicReference(new q20() { // from class: androidx.camera.video.e0
            @Override // defpackage.q20
            public final void accept(Object obj) {
                Recorder.h.J0((Uri) obj);
            }
        });
        private final AtomicBoolean f = new AtomicBoolean(false);

        class a implements c {
            final /* synthetic */ Context a;

            a(Context context) {
                this.a = context;
            }

            @Override // androidx.camera.video.Recorder.h.c
            public AudioSource a(kb kbVar, Executor executor) {
                return new AudioSource(kbVar, executor, this.a);
            }
        }

        class b implements c {
            b() {
            }

            @Override // androidx.camera.video.Recorder.h.c
            public AudioSource a(kb kbVar, Executor executor) {
                return new AudioSource(kbVar, executor, null);
            }
        }

        private interface c {
            AudioSource a(kb kbVar, Executor executor);
        }

        /* JADX INFO: Access modifiers changed from: private */
        interface d {
            MediaMuxer a(int i, q20 q20Var);
        }

        h() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ MediaMuxer F0(fy1 fy1Var, ParcelFileDescriptor parcelFileDescriptor, int i, q20 q20Var) throws IOException {
            Object objFromFile;
            MediaMuxer mediaMuxer;
            Uri uri = Uri.EMPTY;
            if (fy1Var instanceof sm0) {
                File fileD = ((sm0) fy1Var).d();
                if (!jy1.a(fileD)) {
                    androidx.camera.core.x.k("Recorder", "Failed to create folder for " + fileD.getAbsolutePath());
                }
                mediaMuxer = new MediaMuxer(fileD.getAbsolutePath(), i);
                objFromFile = Uri.fromFile(fileD);
            } else {
                if (!(fy1Var instanceof bi1)) {
                    throw new AssertionError("Invalid output options type: " + fy1Var.getClass().getSimpleName());
                }
                bi1 bi1Var = (bi1) fy1Var;
                ContentValues contentValues = new ContentValues(bi1Var.f());
                if (Build.VERSION.SDK_INT >= 29) {
                    contentValues.put("is_pending", (Integer) 1);
                }
                try {
                    Uri uriInsert = bi1Var.e().insert(bi1Var.d(), contentValues);
                    if (uriInsert == null) {
                        throw new IOException("Unable to create MediaStore entry.");
                    }
                    ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = bi1Var.e().openFileDescriptor(uriInsert, "rw");
                    MediaMuxer mediaMuxerA = r7.a(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor(), i);
                    parcelFileDescriptorOpenFileDescriptor.close();
                    objFromFile = uriInsert;
                    mediaMuxer = mediaMuxerA;
                } catch (RuntimeException e) {
                    throw new IOException("Unable to create MediaStore entry by " + e, e);
                }
            }
            q20Var.accept(objFromFile);
            return mediaMuxer;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void G0(bi1 bi1Var, Uri uri) {
            if (uri.equals(Uri.EMPTY)) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("is_pending", (Integer) 0);
            bi1Var.e().update(uri, contentValues, null, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void H0(String str, Uri uri) {
            if (uri == null) {
                androidx.camera.core.x.c("Recorder", String.format("File scanning operation failed [path: %s]", str));
            } else {
                androidx.camera.core.x.a("Recorder", String.format("File scan completed successfully [path: %s, URI: %s]", str, uri));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void I0(bi1 bi1Var, Context context, Uri uri) throws Throwable {
            if (uri.equals(Uri.EMPTY)) {
                return;
            }
            String strB = jy1.b(bi1Var.e(), uri, "_data");
            if (strB != null) {
                MediaScannerConnection.scanFile(context, new String[]{strB}, null, new MediaScannerConnection.OnScanCompletedListener() { // from class: androidx.camera.video.g0
                    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
                    public final void onScanCompleted(String str, Uri uri2) {
                        Recorder.h.H0(str, uri2);
                    }
                });
                return;
            }
            androidx.camera.core.x.a("Recorder", "Skipping media scanner scan. Unable to retrieve file path from URI: " + uri);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void J0(Uri uri) {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void K0(w0 w0Var) {
            j0().accept(w0Var);
        }

        private void a0(q20 q20Var, Uri uri) {
            if (q20Var != null) {
                this.a.a();
                q20Var.accept(uri);
            } else {
                throw new AssertionError("Recording " + this + " has already been finalized");
            }
        }

        static h e0(r rVar, long j) {
            return new j(rVar.d(), rVar.c(), rVar.b(), rVar.f(), rVar.g(), j);
        }

        abstract boolean A0();

        AudioSource L0(kb kbVar, Executor executor) {
            if (!t0()) {
                throw new AssertionError("Recording does not have audio enabled. Unable to create audio source for recording " + this);
            }
            c cVar = (c) this.d.getAndSet(null);
            if (cVar != null) {
                return cVar.a(kbVar, executor);
            }
            throw new AssertionError("One-time audio source creation has already occurred for recording " + this);
        }

        MediaMuxer M0(int i, q20 q20Var) throws IOException {
            if (!this.b.get()) {
                throw new AssertionError("Recording " + this + " has not been initialized");
            }
            d dVar = (d) this.c.getAndSet(null);
            if (dVar == null) {
                throw new AssertionError("One-time media muxer creation has already occurred for recording " + this);
            }
            try {
                return dVar.a(i, q20Var);
            } catch (RuntimeException e) {
                throw new IOException("Failed to create MediaMuxer by " + e, e);
            }
        }

        void N0(final w0 w0Var) {
            if (!Objects.equals(w0Var.c(), k0())) {
                throw new AssertionError("Attempted to update event listener with event from incorrect recording [Recording: " + w0Var.c() + ", Expected: " + k0() + "]");
            }
            String str = "Sending VideoRecordEvent " + w0Var.getClass().getSimpleName();
            if (w0Var instanceof w0.a) {
                w0.a aVar = (w0.a) w0Var;
                if (aVar.l()) {
                    str = str + String.format(" [error: %s]", w0.a.h(aVar.j()));
                }
            }
            androidx.camera.core.x.a("Recorder", str);
            if (g0() == null || j0() == null) {
                return;
            }
            try {
                g0().execute(new Runnable() { // from class: androidx.camera.video.f0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.K0(w0Var);
                    }
                });
            } catch (RejectedExecutionException e) {
                androidx.camera.core.x.d("Recorder", "The callback executor is invalid.", e);
            }
        }

        void V(Uri uri) {
            if (this.b.get()) {
                a0((q20) this.e.getAndSet(null), uri);
            }
        }

        @Override // java.lang.AutoCloseable
        public void close() {
            V(Uri.EMPTY);
        }

        protected void finalize() throws Throwable {
            try {
                this.a.d();
                q20 q20Var = (q20) this.e.getAndSet(null);
                if (q20Var != null) {
                    a0(q20Var, Uri.EMPTY);
                }
            } finally {
                super.finalize();
            }
        }

        abstract Executor g0();

        abstract q20 j0();

        abstract fy1 k0();

        abstract long m0();

        abstract boolean t0();

        /* JADX WARN: Multi-variable type inference failed */
        void w0(final Context context) {
            if (this.b.getAndSet(true)) {
                throw new AssertionError("Recording " + this + " has already been initialized");
            }
            final fy1 fy1VarK0 = k0();
            this.a.c("finalizeRecording");
            q20 q20Var = null;
            final Object[] objArr = 0 == true ? 1 : 0;
            this.c.set(new d() { // from class: androidx.camera.video.b0
                @Override // androidx.camera.video.Recorder.h.d
                public final MediaMuxer a(int i, q20 q20Var2) {
                    return Recorder.h.F0(fy1VarK0, objArr, i, q20Var2);
                }
            });
            if (t0()) {
                if (Build.VERSION.SDK_INT >= 31) {
                    this.d.set(new a(context));
                } else {
                    this.d.set(new b());
                }
            }
            if (fy1VarK0 instanceof bi1) {
                final bi1 bi1Var = (bi1) fy1VarK0;
                q20Var = Build.VERSION.SDK_INT >= 29 ? new q20() { // from class: androidx.camera.video.c0
                    @Override // defpackage.q20
                    public final void accept(Object obj) {
                        Recorder.h.G0(bi1Var, (Uri) obj);
                    }
                } : new q20() { // from class: androidx.camera.video.d0
                    @Override // defpackage.q20
                    public final void accept(Object obj) throws Throwable {
                        Recorder.h.I0(bi1Var, context, (Uri) obj);
                    }
                };
            }
            if (q20Var != null) {
                this.e.set(q20Var);
            }
        }

        boolean y0() {
            return this.f.get();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class i {
        private final SurfaceRequest a;
        private final Timebase b;
        private final int c;
        private boolean d = false;
        private int e = 0;
        private ScheduledFuture f = null;

        class a implements bs0 {
            final /* synthetic */ VideoEncoderSession a;

            a(VideoEncoderSession videoEncoderSession) {
                this.a = videoEncoderSession;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void c() {
                if (i.this.d) {
                    return;
                }
                androidx.camera.core.x.a("Recorder", "Retry setupVideo #" + i.this.e);
                i iVar = i.this;
                iVar.l(iVar.a, i.this.b);
            }

            @Override // defpackage.bs0
            public void a(Throwable th) {
                androidx.camera.core.x.l("Recorder", "VideoEncoder Setup error: " + th, th);
                if (i.this.e >= i.this.c) {
                    Recorder.this.c0(th);
                    return;
                }
                i.e(i.this);
                i.this.f = Recorder.t0(new Runnable() { // from class: androidx.camera.video.i0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.c();
                    }
                }, Recorder.this.d, Recorder.r0, TimeUnit.MILLISECONDS);
            }

            @Override // defpackage.bs0
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public void onSuccess(androidx.camera.video.internal.encoder.c cVar) {
                androidx.camera.core.x.a("Recorder", "VideoEncoder is created. " + cVar);
                if (cVar == null) {
                    return;
                }
                b52.i(Recorder.this.d0 == this.a);
                b52.i(Recorder.this.E == null);
                Recorder.this.i0(this.a);
                Recorder.this.b0();
            }
        }

        i(SurfaceRequest surfaceRequest, Timebase timebase, int i) {
            this.a = surfaceRequest;
            this.b = timebase;
            this.c = i;
        }

        static /* synthetic */ int e(i iVar) {
            int i = iVar.e;
            iVar.e = i + 1;
            return i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void k(SurfaceRequest surfaceRequest, Timebase timebase) {
            if (!surfaceRequest.r() && (!Recorder.this.d0.n(surfaceRequest) || Recorder.this.L())) {
                ig0 ig0Var = Recorder.this.e;
                Recorder recorder = Recorder.this;
                VideoEncoderSession videoEncoderSession = new VideoEncoderSession(ig0Var, recorder.d, recorder.c);
                Recorder recorder2 = Recorder.this;
                ub1 ub1VarI = videoEncoderSession.i(surfaceRequest, timebase, (p) recorder2.E(recorder2.C), Recorder.this.t);
                Recorder.this.d0 = videoEncoderSession;
                os0.j(ub1VarI, new a(videoEncoderSession), Recorder.this.d);
                return;
            }
            androidx.camera.core.x.k("Recorder", "Ignore the SurfaceRequest " + surfaceRequest + " isServiced: " + surfaceRequest.r() + " VideoEncoderSession: " + Recorder.this.d0 + " has been configured with a persistent in-progress recording.");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void l(final SurfaceRequest surfaceRequest, final Timebase timebase) {
            Recorder.this.s0().a(new Runnable() { // from class: androidx.camera.video.h0
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.k(surfaceRequest, timebase);
                }
            }, Recorder.this.d);
        }

        void j() {
            if (this.d) {
                return;
            }
            this.d = true;
            ScheduledFuture scheduledFuture = this.f;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
                this.f = null;
            }
        }

        void m() {
            l(this.a, this.b);
        }
    }

    static {
        s sVar = s.c;
        v vVarF = v.f(Arrays.asList(sVar, s.b, s.a), o.a(sVar));
        k0 = vVarF;
        x0 x0VarA = x0.a().e(vVarF).b(-1).a();
        l0 = x0VarA;
        m0 = p.a().e(-1).f(x0VarA).a();
        n0 = new RuntimeException("The video frame producer became inactive before any data was received.");
        o0 = new ig0() { // from class: xd2
            @Override // defpackage.ig0
            public final c a(Executor executor, hg0 hg0Var) {
                return new EncoderImpl(executor, hg0Var);
            }
        };
        p0 = androidx.camera.core.impl.utils.executor.c.g(androidx.camera.core.impl.utils.executor.c.d());
        q0 = 3;
        r0 = 1000L;
    }

    Recorder(Executor executor, p pVar, int i2, ig0 ig0Var, ig0 ig0Var2) {
        this.h = va0.a(ch0.class) != null;
        this.j = State.CONFIGURING;
        this.k = null;
        this.l = 0;
        this.m = null;
        this.n = null;
        this.o = 0L;
        this.p = null;
        this.f158q = false;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = new ArrayList();
        this.v = null;
        this.w = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = null;
        this.H = null;
        this.I = AudioState.INITIALIZING;
        this.J = Uri.EMPTY;
        this.K = 0L;
        this.L = 0L;
        this.M = Long.MAX_VALUE;
        this.N = 0;
        this.O = null;
        this.P = Long.MAX_VALUE;
        this.Q = Long.MAX_VALUE;
        this.R = Long.MAX_VALUE;
        this.S = 0L;
        this.T = 0L;
        this.U = 1;
        this.V = null;
        this.W = null;
        this.X = new x9(60);
        this.Y = null;
        this.Z = false;
        this.a0 = VideoOutput.SourceState.INACTIVE;
        this.b0 = null;
        this.c0 = false;
        this.e0 = null;
        this.f0 = 0.0d;
        this.g0 = false;
        this.h0 = null;
        this.b = executor;
        executor = executor == null ? androidx.camera.core.impl.utils.executor.c.d() : executor;
        this.c = executor;
        Executor executorG = androidx.camera.core.impl.utils.executor.c.g(executor);
        this.d = executorG;
        this.C = om1.i(y(pVar));
        this.i = i2;
        this.a = om1.i(StreamInfo.d(this.l, I(this.j)));
        this.e = ig0Var;
        this.f = ig0Var2;
        this.d0 = new VideoEncoderSession(ig0Var, executorG, executor);
    }

    private void A0(h hVar) {
        p pVar = (p) E(this.C);
        jb jbVarD = eb.d(pVar, this.t);
        Timebase timebase = Timebase.UPTIME;
        kb kbVarE = eb.e(jbVarD, pVar.b());
        if (this.D != null) {
            n0();
        }
        AudioSource audioSourceB0 = B0(hVar, kbVarE);
        this.D = audioSourceB0;
        androidx.camera.core.x.a("Recorder", String.format("Set up new audio source: 0x%x", Integer.valueOf(audioSourceB0.hashCode())));
        androidx.camera.video.internal.encoder.c cVarA = this.f.a(this.c, eb.c(jbVarD, timebase, kbVarE, pVar.b()));
        this.G = cVarA;
        androidx.camera.video.internal.encoder.c.b bVarB = cVarA.b();
        if (!(bVarB instanceof androidx.camera.video.internal.encoder.c.a)) {
            throw new AssertionError("The EncoderInput of audio isn't a ByteBufferInput.");
        }
        this.D.M((androidx.camera.video.internal.encoder.c.a) bVarB);
    }

    private void B(h hVar, int i2, Throwable th) {
        Uri uri = Uri.EMPTY;
        hVar.V(uri);
        hVar.N0(w0.b(hVar.k0(), l0.d(0L, 0L, androidx.camera.video.b.d(1, this.Y, 0.0d)), q.b(uri), i2, th));
    }

    private AudioSource B0(h hVar, kb kbVar) {
        return hVar.L0(kbVar, p0);
    }

    private List C(long j) {
        ArrayList arrayList = new ArrayList();
        while (!this.X.isEmpty()) {
            dg0 dg0Var = (dg0) this.X.a();
            if (dg0Var.q0() >= j) {
                arrayList.add(dg0Var);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:50:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:51:0x00ec  */
    private void D0(h hVar) {
        AudioState audioState;
        if (this.p != null) {
            throw new AssertionError("Attempted to start a new recording while another was in progress.");
        }
        if (hVar.k0().b() > 0) {
            this.S = Math.round(hVar.k0().b() * 0.95d);
            androidx.camera.core.x.a("Recorder", "File size limit in bytes: " + this.S);
        } else {
            this.S = 0L;
        }
        if (hVar.k0().a() > 0) {
            this.T = TimeUnit.MILLISECONDS.toNanos(hVar.k0().a());
            androidx.camera.core.x.a("Recorder", "Duration limit in nanoseconds: " + this.T);
        } else {
            this.T = 0L;
        }
        this.p = hVar;
        int iOrdinal = this.I.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                u0(hVar.t0() ? AudioState.ENABLED : AudioState.DISABLED);
            } else if (iOrdinal == 2 || iOrdinal == 3 || iOrdinal == 4 || iOrdinal == 5) {
                throw new AssertionError("Incorrectly invoke startInternal in audio state " + this.I);
            }
        } else if (hVar.t0()) {
            if (!K()) {
                throw new AssertionError("The Recorder doesn't support recording with audio");
            }
            try {
                if (!this.p.A0() || this.G == null) {
                    A0(hVar);
                }
                u0(AudioState.ENABLED);
            } catch (AudioSourceAccessException e2) {
                e = e2;
                androidx.camera.core.x.d("Recorder", "Unable to create audio resource with error: ", e);
                if (e instanceof InvalidConfigException) {
                    audioState = AudioState.ERROR_ENCODER;
                } else {
                    audioState = AudioState.ERROR_SOURCE;
                }
                u0(audioState);
                this.Y = e;
            } catch (InvalidConfigException e3) {
                e = e3;
                androidx.camera.core.x.d("Recorder", "Unable to create audio resource with error: ", e);
                if (e instanceof InvalidConfigException) {
                    audioState = AudioState.ERROR_ENCODER;
                } else {
                    audioState = AudioState.ERROR_SOURCE;
                }
                u0(audioState);
                this.Y = e;
            }
        }
        K0(hVar, false);
        if (J()) {
            this.D.O(hVar.y0());
            this.G.start();
        }
        this.E.start();
        h hVar2 = this.p;
        hVar2.N0(w0.f(hVar2.k0(), D()));
    }

    private void E0(h hVar, boolean z) {
        D0(hVar);
        if (z) {
            j0(hVar);
        }
    }

    public static m0 F(yt ytVar) {
        return G(ytVar, 0);
    }

    public static m0 G(yt ytVar, int i2) {
        return new j0(i2, (zt) ytVar, androidx.camera.video.internal.encoder.c0.d);
    }

    private int H(AudioState audioState) {
        int iOrdinal = audioState.ordinal();
        if (iOrdinal == 0 || iOrdinal == 2) {
            return 1;
        }
        if (iOrdinal == 3) {
            h hVar = this.p;
            if (hVar == null || !hVar.y0()) {
                return this.Z ? 2 : 0;
            }
            return 5;
        }
        if (iOrdinal == 4) {
            return 3;
        }
        if (iOrdinal == 5) {
            return 4;
        }
        throw new AssertionError("Invalid internal audio state: " + audioState);
    }

    private static int H0(vd3 vd3Var, int i2) {
        if (vd3Var != null) {
            int iB = vd3Var.b();
            if (iB == 1) {
                return 2;
            }
            if (iB == 2) {
                return 0;
            }
            if (iB == 9) {
                return 1;
            }
        }
        return i2;
    }

    private StreamInfo.StreamState I(State state) {
        return (state == State.RECORDING || (state == State.STOPPING && ((c70) va0.a(c70.class)) == null)) ? StreamInfo.StreamState.ACTIVE : StreamInfo.StreamState.INACTIVE;
    }

    private void I0() {
        VideoEncoderSession videoEncoderSession = this.e0;
        if (videoEncoderSession == null) {
            s0();
            return;
        }
        b52.i(videoEncoderSession.m() == this.E);
        androidx.camera.core.x.a("Recorder", "Releasing video encoder: " + this.E);
        this.e0.x();
        this.e0 = null;
        this.E = null;
        this.F = null;
        w0(null);
    }

    private void K0(final h hVar, boolean z) {
        if (!this.u.isEmpty()) {
            ub1 ub1VarK = os0.k(this.u);
            if (!ub1VarK.isDone()) {
                ub1VarK.cancel(true);
            }
            this.u.clear();
        }
        this.u.add(CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: androidx.camera.video.z
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
            public final Object a(CallbackToFutureAdapter.a aVar) {
                return this.a.W(hVar, aVar);
            }
        }));
        if (J() && !z) {
            this.u.add(CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: androidx.camera.video.a0
                @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
                public final Object a(CallbackToFutureAdapter.a aVar) {
                    return this.a.Y(hVar, aVar);
                }
            }));
        }
        os0.j(os0.k(this.u), new f(), androidx.camera.core.impl.utils.executor.c.b());
    }

    private static boolean M(k0 k0Var, h hVar) {
        return hVar != null && k0Var.y() == hVar.m0();
    }

    private void M0(State state) {
        if (!i0.contains(this.j)) {
            throw new AssertionError("Can only updated non-pending state from a pending state, but state is " + this.j);
        }
        if (!j0.contains(state)) {
            throw new AssertionError("Invalid state transition. State is not a valid non-pending state while in a pending state: " + state);
        }
        if (this.k != state) {
            this.k = state;
            this.a.h(StreamInfo.e(this.l, I(state), this.r));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void N(x0.a aVar) {
        aVar.b(l0.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O(SurfaceRequest.g gVar) {
        this.s = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(Uri uri) {
        this.J = uri;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T() {
        SurfaceRequest surfaceRequest = this.x;
        if (surfaceRequest == null) {
            throw new AssertionError("surface request is required to retry initialization.");
        }
        z(surfaceRequest, this.y, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void V(androidx.camera.video.internal.encoder.c cVar) {
        androidx.camera.core.x.a("Recorder", "The source didn't become non-streaming before timeout. Waited 1000ms");
        if (va0.a(c70.class) != null) {
            a0(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object W(h hVar, CallbackToFutureAdapter.a aVar) {
        this.E.e(new c(aVar, hVar), this.d);
        return "videoEncodingFuture";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X(CallbackToFutureAdapter.a aVar, Throwable th) {
        if (this.Y == null) {
            if (th instanceof EncodeException) {
                u0(AudioState.ERROR_ENCODER);
            } else {
                u0(AudioState.ERROR_SOURCE);
            }
            this.Y = th;
            L0();
            aVar.c(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object Y(h hVar, final CallbackToFutureAdapter.a aVar) {
        q20 q20Var = new q20() { // from class: ud2
            @Override // defpackage.q20
            public final void accept(Object obj) {
                this.a.X(aVar, (Throwable) obj);
            }
        };
        this.D.L(this.d, new d(q20Var));
        this.G.e(new e(aVar, q20Var, hVar), this.d);
        return "audioEncodingFuture";
    }

    private h Z(State state) {
        boolean z;
        if (state == State.PENDING_PAUSED) {
            z = true;
        } else {
            if (state != State.PENDING_RECORDING) {
                throw new AssertionError("makePendingRecordingActiveLocked() can only be called from a pending state.");
            }
            z = false;
        }
        if (this.m != null) {
            throw new AssertionError("Cannot make pending recording active because another recording is already active.");
        }
        h hVar = this.n;
        if (hVar == null) {
            throw new AssertionError("Pending recording should exist when in a PENDING state.");
        }
        this.m = hVar;
        this.n = null;
        if (z) {
            x0(State.PAUSED);
        } else {
            x0(State.RECORDING);
        }
        return hVar;
    }

    static void a0(androidx.camera.video.internal.encoder.c cVar) {
        if (cVar instanceof EncoderImpl) {
            ((EncoderImpl) cVar).m0();
        }
    }

    /* JADX WARN: Code duplicated, block: B:32:0x006d A[Catch: all -> 0x002f, TryCatch #0 {all -> 0x002f, blocks: (B:4:0x0003, B:6:0x0007, B:7:0x0012, B:46:0x00ad, B:11:0x001e, B:13:0x0022, B:15:0x0028, B:21:0x0033, B:23:0x003e, B:26:0x004b, B:27:0x0063, B:30:0x0067, B:32:0x006d, B:33:0x007d, B:35:0x0081, B:37:0x0087, B:41:0x008f, B:42:0x0098, B:44:0x009c, B:60:0x00d6, B:61:0x00dd), top: B:64:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x007d A[Catch: all -> 0x002f, TryCatch #0 {all -> 0x002f, blocks: (B:4:0x0003, B:6:0x0007, B:7:0x0012, B:46:0x00ad, B:11:0x001e, B:13:0x0022, B:15:0x0028, B:21:0x0033, B:23:0x003e, B:26:0x004b, B:27:0x0063, B:30:0x0067, B:32:0x006d, B:33:0x007d, B:35:0x0081, B:37:0x0087, B:41:0x008f, B:42:0x0098, B:44:0x009c, B:60:0x00d6, B:61:0x00dd), top: B:64:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x0081 A[Catch: all -> 0x002f, TryCatch #0 {all -> 0x002f, blocks: (B:4:0x0003, B:6:0x0007, B:7:0x0012, B:46:0x00ad, B:11:0x001e, B:13:0x0022, B:15:0x0028, B:21:0x0033, B:23:0x003e, B:26:0x004b, B:27:0x0063, B:30:0x0067, B:32:0x006d, B:33:0x007d, B:35:0x0081, B:37:0x0087, B:41:0x008f, B:42:0x0098, B:44:0x009c, B:60:0x00d6, B:61:0x00dd), top: B:64:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x008e  */
    /* JADX WARN: Code duplicated, block: B:42:0x0098 A[Catch: all -> 0x002f, TryCatch #0 {all -> 0x002f, blocks: (B:4:0x0003, B:6:0x0007, B:7:0x0012, B:46:0x00ad, B:11:0x001e, B:13:0x0022, B:15:0x0028, B:21:0x0033, B:23:0x003e, B:26:0x004b, B:27:0x0063, B:30:0x0067, B:32:0x006d, B:33:0x007d, B:35:0x0081, B:37:0x0087, B:41:0x008f, B:42:0x0098, B:44:0x009c, B:60:0x00d6, B:61:0x00dd), top: B:64:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x009c A[Catch: all -> 0x002f, TryCatch #0 {all -> 0x002f, blocks: (B:4:0x0003, B:6:0x0007, B:7:0x0012, B:46:0x00ad, B:11:0x001e, B:13:0x0022, B:15:0x0028, B:21:0x0033, B:23:0x003e, B:26:0x004b, B:27:0x0063, B:30:0x0067, B:32:0x006d, B:33:0x007d, B:35:0x0081, B:37:0x0087, B:41:0x008f, B:42:0x0098, B:44:0x009c, B:60:0x00d6, B:61:0x00dd), top: B:64:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x00a9  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13, types: [androidx.camera.video.Recorder$h] */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r8v0, types: [androidx.camera.video.Recorder] */
    private void e0(h hVar) {
        h hVarZ;
        boolean z;
        Object obj;
        Exception exc;
        int i2;
        int i3;
        int i4;
        SurfaceRequest surfaceRequest;
        ?? r2;
        synchronized (this.g) {
            try {
                if (this.m != hVar) {
                    throw new AssertionError("Active recording did not match finalized recording on finalize.");
                }
                hVarZ = null;
                exc = null;
                hVarZ = null;
                hVarZ = null;
                hVarZ = null;
                this.m = null;
                int i5 = 1;
                switch (this.j.ordinal()) {
                    case 1:
                        z = false;
                        if (this.a0 == VideoOutput.SourceState.INACTIVE) {
                            h hVar2 = this.n;
                            this.n = null;
                            x0(State.CONFIGURING);
                            exc = n0;
                            i3 = 0;
                            i4 = 4;
                            i2 = 0;
                            r2 = hVar2;
                        } else {
                            if (this.h) {
                                this.A = null;
                                surfaceRequest = this.x;
                                if (surfaceRequest != null || surfaceRequest.r()) {
                                    i5 = 0;
                                }
                                M0(State.CONFIGURING);
                                i2 = i5;
                                i3 = 0;
                                i4 = i3;
                            } else if (this.E != null) {
                                exc = null;
                                i2 = 0;
                                i3 = 0;
                                i4 = 0;
                                hVarZ = Z(this.j);
                            } else {
                                obj = null;
                                exc = null;
                                i2 = 0;
                                i3 = i2;
                                i4 = i3;
                                r2 = obj;
                            }
                            r2 = exc;
                        }
                        break;
                    case 2:
                        z = true;
                        if (this.a0 == VideoOutput.SourceState.INACTIVE) {
                            h hVar3 = this.n;
                            this.n = null;
                            x0(State.CONFIGURING);
                            exc = n0;
                            i3 = 0;
                            i4 = 4;
                            i2 = 0;
                            r2 = hVar3;
                        } else {
                            if (this.h) {
                                this.A = null;
                                surfaceRequest = this.x;
                                if (surfaceRequest != null) {
                                    i5 = 0;
                                } else {
                                    i5 = 0;
                                }
                                M0(State.CONFIGURING);
                                i2 = i5;
                                i3 = 0;
                                i4 = i3;
                            } else if (this.E != null) {
                                exc = null;
                                i2 = 0;
                                i3 = 0;
                                i4 = 0;
                                hVarZ = Z(this.j);
                            } else {
                                obj = null;
                                exc = null;
                                i2 = 0;
                                i3 = i2;
                                i4 = i3;
                                r2 = obj;
                            }
                            r2 = exc;
                        }
                        break;
                    case 3:
                        throw new AssertionError("Unexpected state on finalize of recording: " + this.j);
                    case 4:
                    case 5:
                    case 6:
                        if (!this.h) {
                            x0(State.IDLING);
                            obj = null;
                            exc = null;
                            z = false;
                            i2 = 0;
                            i3 = i2;
                            i4 = i3;
                            r2 = obj;
                        } else {
                            this.A = null;
                            SurfaceRequest surfaceRequest2 = this.x;
                            if (surfaceRequest2 == null || surfaceRequest2.r()) {
                                i5 = 0;
                            }
                            x0(State.CONFIGURING);
                            i2 = i5;
                            z = false;
                            i3 = 0;
                            i4 = i3;
                            r2 = exc;
                        }
                        break;
                    case 7:
                        exc = null;
                        i3 = 1;
                        z = false;
                        i2 = 0;
                        i4 = 0;
                        r2 = exc;
                        break;
                    default:
                        obj = null;
                        exc = null;
                        z = false;
                        i2 = 0;
                        i3 = i2;
                        i4 = i3;
                        r2 = obj;
                        break;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (i2 != 0) {
            z(this.x, this.y, false);
            return;
        }
        if (i3 != 0) {
            p0();
            return;
        }
        if (hVarZ != null) {
            if (this.h) {
                throw new AssertionError("Attempt to start a pending recording while the Recorder is waiting for a new surface request.");
            }
            E0(hVarZ, z);
        } else if (r2 != 0) {
            B(r2, i4, exc);
        }
    }

    private void f0() {
        boolean z;
        SurfaceRequest surfaceRequest;
        synchronized (this.g) {
            try {
                switch (this.j.ordinal()) {
                    case 1:
                    case 2:
                        M0(State.CONFIGURING);
                        z = true;
                        break;
                    case 4:
                    case 5:
                    case 8:
                        if (L()) {
                            z = false;
                            break;
                        }
                    case 3:
                    case 6:
                    case 7:
                        x0(State.CONFIGURING);
                        z = true;
                        break;
                    default:
                        z = true;
                        break;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.c0 = false;
        if (!z || (surfaceRequest = this.x) == null || surfaceRequest.r()) {
            return;
        }
        z(this.x, this.y, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: h0, reason: merged with bridge method [inline-methods] */
    public void Q(SurfaceRequest surfaceRequest, Timebase timebase) {
        SurfaceRequest surfaceRequest2 = this.x;
        if (surfaceRequest2 != null && !surfaceRequest2.r()) {
            this.x.E();
        }
        this.x = surfaceRequest;
        this.y = timebase;
        z(surfaceRequest, timebase, true);
    }

    private void j0(h hVar) {
        if (this.p != hVar || this.f158q) {
            return;
        }
        if (J()) {
            this.G.pause();
        }
        this.E.pause();
        h hVar2 = this.p;
        hVar2.N0(w0.d(hVar2.k0(), D()));
    }

    private r m0(Context context, fy1 fy1Var) {
        b52.h(fy1Var, "The OutputOptions cannot be null.");
        return new r(context, this, fy1Var);
    }

    private void n0() {
        AudioSource audioSource = this.D;
        if (audioSource == null) {
            throw new AssertionError("Cannot release null audio source.");
        }
        this.D = null;
        androidx.camera.core.x.a("Recorder", String.format("Releasing audio source: 0x%x", Integer.valueOf(audioSource.hashCode())));
        os0.j(audioSource.H(), new b(audioSource), androidx.camera.core.impl.utils.executor.c.b());
    }

    private void p0() {
        if (this.G != null) {
            androidx.camera.core.x.a("Recorder", "Releasing audio encoder.");
            this.G.release();
            this.G = null;
            this.H = null;
        }
        if (this.D != null) {
            n0();
        }
        u0(AudioState.INITIALIZING);
        q0();
    }

    private void q0() {
        if (this.E != null) {
            androidx.camera.core.x.a("Recorder", "Releasing video encoder.");
            I0();
        }
        f0();
    }

    private void r0() {
        if (i0.contains(this.j)) {
            x0(this.k);
            return;
        }
        throw new AssertionError("Cannot restore non-pending state when in state " + this.j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ub1 s0() {
        androidx.camera.core.x.a("Recorder", "Try to safely release video encoder: " + this.E);
        return this.d0.w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ScheduledFuture t0(final Runnable runnable, final Executor executor, long j, TimeUnit timeUnit) {
        return androidx.camera.core.impl.utils.executor.c.e().schedule(new Runnable() { // from class: vd2
            @Override // java.lang.Runnable
            public final void run() {
                executor.execute(runnable);
            }
        }, j, timeUnit);
    }

    private void x() {
        while (!this.X.isEmpty()) {
            this.X.a();
        }
    }

    private p y(p pVar) {
        p.a aVarI = pVar.i();
        if (pVar.d().b() == -1) {
            aVarI.b(new q20() { // from class: sd2
                @Override // defpackage.q20
                public final void accept(Object obj) {
                    Recorder.N((x0.a) obj);
                }
            });
        }
        return aVarI.a();
    }

    private void y0(int i2) {
        if (this.l == i2) {
            return;
        }
        androidx.camera.core.x.a("Recorder", "Transitioning streamId: " + this.l + " --> " + i2);
        this.l = i2;
        this.a.h(StreamInfo.e(i2, I(this.j), this.r));
    }

    private void z(SurfaceRequest surfaceRequest, Timebase timebase, boolean z) {
        if (surfaceRequest.r()) {
            androidx.camera.core.x.k("Recorder", "Ignore the SurfaceRequest since it is already served.");
            return;
        }
        surfaceRequest.C(this.d, new SurfaceRequest.h() { // from class: zd2
            @Override // androidx.camera.core.SurfaceRequest.h
            public final void a(SurfaceRequest.g gVar) {
                this.a.O(gVar);
            }
        });
        Size sizeO = surfaceRequest.o();
        ie0 ie0VarM = surfaceRequest.m();
        m0 m0VarF = F(surfaceRequest.k().a());
        s sVarB = m0VarF.b(sizeO, ie0VarM);
        androidx.camera.core.x.a("Recorder", "Using supported quality of " + sVarB + " for surface size " + sizeO);
        if (sVarB != s.g) {
            vd3 vd3VarD = m0VarF.d(sVarB, ie0VarM);
            this.t = vd3VarD;
            if (vd3VarD == null) {
                throw new AssertionError("Camera advertised available quality but did not produce EncoderProfiles  for advertised quality.");
            }
        }
        i iVar = this.h0;
        if (iVar != null) {
            iVar.j();
        }
        i iVar2 = new i(surfaceRequest, timebase, z ? q0 : 0);
        this.h0 = iVar2;
        iVar2.m();
    }

    void A(int i2, Throwable th) {
        if (this.p == null) {
            throw new AssertionError("Attempted to finalize in-progress recording, but no recording is in progress.");
        }
        MediaMuxer mediaMuxer = this.B;
        if (mediaMuxer != null) {
            try {
                mediaMuxer.stop();
                this.B.release();
            } catch (IllegalStateException e2) {
                androidx.camera.core.x.c("Recorder", "MediaMuxer failed to stop or release with error: " + e2.getMessage());
                if (i2 == 0) {
                    i2 = 1;
                }
            }
            this.B = null;
        } else if (i2 == 0) {
            i2 = 8;
        }
        this.p.V(this.J);
        fy1 fy1VarK0 = this.p.k0();
        l0 l0VarD = D();
        q qVarB = q.b(this.J);
        this.p.N0(i2 == 0 ? w0.a(fy1VarK0, l0VarD, qVarB) : w0.b(fy1VarK0, l0VarD, qVarB, i2, th));
        h hVar = this.p;
        this.p = null;
        this.f158q = false;
        this.v = null;
        this.w = null;
        this.u.clear();
        this.J = Uri.EMPTY;
        this.K = 0L;
        this.L = 0L;
        this.M = Long.MAX_VALUE;
        this.P = Long.MAX_VALUE;
        this.Q = Long.MAX_VALUE;
        this.R = Long.MAX_VALUE;
        this.U = 1;
        this.V = null;
        this.Y = null;
        this.f0 = 0.0d;
        x();
        v0(null);
        int iOrdinal = this.I.ordinal();
        if (iOrdinal == 1) {
            throw new AssertionError("Incorrectly finalize recording when audio state is IDLING");
        }
        if (iOrdinal == 2 || iOrdinal == 3) {
            u0(AudioState.IDLING);
            this.D.Q();
        } else if (iOrdinal == 4 || iOrdinal == 5) {
            u0(AudioState.INITIALIZING);
        }
        e0(hVar);
    }

    k0 C0(r rVar) {
        long j;
        h hVar;
        int i2;
        h hVar2;
        b52.h(rVar, "The given PendingRecording cannot be null.");
        synchronized (this.g) {
            try {
                j = this.o + 1;
                this.o = j;
                hVar = null;
                i2 = 0;
                switch (this.j) {
                    case CONFIGURING:
                    case IDLING:
                    case STOPPING:
                    case RESETTING:
                    case ERROR:
                        State state = this.j;
                        State state2 = State.IDLING;
                        if (state == state2) {
                            b52.j(this.m == null && this.n == null, "Expected recorder to be idle but a recording is either pending or in progress.");
                        }
                        try {
                            h hVarE0 = h.e0(rVar, j);
                            hVarE0.w0(rVar.a());
                            this.n = hVarE0;
                            State state3 = this.j;
                            if (state3 == state2) {
                                x0(State.PENDING_RECORDING);
                                this.d.execute(new Runnable() { // from class: androidx.camera.video.x
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        this.a.J0();
                                    }
                                });
                            } else if (state3 == State.ERROR) {
                                x0(State.PENDING_RECORDING);
                                this.d.execute(new Runnable() { // from class: yd2
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        this.a.T();
                                    }
                                });
                            } else {
                                x0(State.PENDING_RECORDING);
                            }
                            e = null;
                        } catch (IOException e2) {
                            e = e2;
                            i2 = 5;
                        }
                        break;
                    case PENDING_RECORDING:
                    case PENDING_PAUSED:
                        hVar2 = (h) b52.g(this.n);
                        hVar = hVar2;
                        e = null;
                        break;
                    case RECORDING:
                    case PAUSED:
                        hVar2 = this.m;
                        hVar = hVar2;
                        e = null;
                        break;
                    default:
                        e = null;
                        break;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (hVar != null) {
            throw new IllegalStateException("A recording is already in progress. Previous recordings must be stopped before a new recording can be started.");
        }
        if (i2 == 0) {
            return k0.u(rVar, j);
        }
        androidx.camera.core.x.c("Recorder", "Recording was started when the Recorder had encountered error " + e);
        B(h.e0(rVar, j), i2, e);
        return k0.n(rVar, j);
    }

    l0 D() {
        return l0.d(this.L, this.K, androidx.camera.video.b.d(H(this.I), this.Y, this.f0));
    }

    Object E(rt2 rt2Var) {
        try {
            return rt2Var.d().get();
        } catch (InterruptedException | ExecutionException e2) {
            throw new IllegalStateException(e2);
        }
    }

    void F0(k0 k0Var, final int i2, final Throwable th) {
        synchronized (this.g) {
            try {
                if (!M(k0Var, this.n) && !M(k0Var, this.m)) {
                    androidx.camera.core.x.a("Recorder", "stop() called on a recording that is no longer active: " + k0Var.w());
                    return;
                }
                h hVar = null;
                switch (this.j) {
                    case CONFIGURING:
                    case IDLING:
                        throw new IllegalStateException("Calling stop() while idling or initializing is invalid.");
                    case PENDING_RECORDING:
                    case PENDING_PAUSED:
                        b52.i(M(k0Var, this.n));
                        h hVar2 = this.n;
                        this.n = null;
                        r0();
                        hVar = hVar2;
                        break;
                    case RECORDING:
                    case PAUSED:
                        x0(State.STOPPING);
                        final long micros = TimeUnit.NANOSECONDS.toMicros(System.nanoTime());
                        final h hVar3 = this.m;
                        this.d.execute(new Runnable() { // from class: androidx.camera.video.y
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.a.U(hVar3, micros, i2, th);
                            }
                        });
                        break;
                    case STOPPING:
                    case RESETTING:
                        b52.i(M(k0Var, this.m));
                        break;
                }
                if (hVar != null) {
                    if (i2 == 10) {
                        androidx.camera.core.x.c("Recorder", "Recording was stopped due to recording being garbage collected before any valid data has been produced.");
                    }
                    B(hVar, 8, new RuntimeException("Recording was stopped before any data could be produced.", th));
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: renamed from: G0, reason: merged with bridge method [inline-methods] */
    public void U(h hVar, long j, int i2, Throwable th) {
        if (this.p != hVar || this.f158q) {
            return;
        }
        this.f158q = true;
        this.U = i2;
        this.V = th;
        if (J()) {
            x();
            this.G.a(j);
        }
        dg0 dg0Var = this.W;
        if (dg0Var != null) {
            dg0Var.close();
            this.W = null;
        }
        if (this.a0 != VideoOutput.SourceState.ACTIVE_NON_STREAMING) {
            final androidx.camera.video.internal.encoder.c cVar = this.E;
            this.b0 = t0(new Runnable() { // from class: ae2
                @Override // java.lang.Runnable
                public final void run() {
                    Recorder.V(cVar);
                }
            }, this.d, 1000L, TimeUnit.MILLISECONDS);
        } else {
            a0(this.E);
        }
        this.E.a(j);
    }

    boolean J() {
        return this.I == AudioState.ENABLED;
    }

    void J0() {
        boolean z;
        h hVarZ;
        int i2;
        Throwable th;
        synchronized (this.g) {
            try {
                int iOrdinal = this.j.ordinal();
                boolean z2 = true;
                z = false;
                i2 = 0;
                hVarZ = null;
                if (iOrdinal != 1) {
                    if (iOrdinal != 2) {
                    }
                    th = hVarZ;
                } else {
                    z2 = false;
                }
                if (this.m == null && !this.c0) {
                    if (this.a0 == VideoOutput.SourceState.INACTIVE) {
                        hVarZ = this.n;
                        this.n = null;
                        r0();
                        i2 = 4;
                        z = z2;
                        th = n0;
                    } else if (this.E != null) {
                        i2 = 0;
                        z = z2;
                        th = null;
                        hVarZ = Z(this.j);
                        hVarZ = null;
                    }
                }
                z = z2;
                th = hVarZ;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (hVarZ != null) {
            E0(hVarZ, z);
        } else if (hVarZ != null) {
            B(hVarZ, i2, th);
        }
    }

    boolean K() {
        return ((p) E(this.C)).b().c() != 0;
    }

    boolean L() {
        h hVar = this.p;
        return hVar != null && hVar.A0();
    }

    void L0() {
        h hVar = this.p;
        if (hVar != null) {
            hVar.N0(w0.g(hVar.k0(), D()));
        }
    }

    void N0(dg0 dg0Var, h hVar) {
        long size = this.K + dg0Var.size();
        long j = this.S;
        if (j != 0 && size > j) {
            androidx.camera.core.x.a("Recorder", String.format("Reach file size limit %d > %d", Long.valueOf(size), Long.valueOf(this.S)));
            d0(hVar, 2, null);
            return;
        }
        long jQ0 = dg0Var.q0();
        long j2 = this.P;
        if (j2 == Long.MAX_VALUE) {
            this.P = jQ0;
            androidx.camera.core.x.a("Recorder", String.format("First audio time: %d (%s)", Long.valueOf(jQ0), l70.c(this.P)));
        } else {
            TimeUnit timeUnit = TimeUnit.MICROSECONDS;
            long nanos = timeUnit.toNanos(jQ0 - Math.min(this.M, j2));
            b52.j(this.R != Long.MAX_VALUE, "There should be a previous data for adjusting the duration.");
            long nanos2 = nanos + timeUnit.toNanos(jQ0 - this.R);
            long j3 = this.T;
            if (j3 != 0 && nanos2 > j3) {
                androidx.camera.core.x.a("Recorder", String.format("Audio data reaches duration limit %d > %d", Long.valueOf(nanos2), Long.valueOf(this.T)));
                d0(hVar, 9, null);
                return;
            }
        }
        this.B.writeSampleData(this.v.intValue(), dg0Var.m(), dg0Var.N());
        this.K = size;
        this.R = jQ0;
    }

    void O0(dg0 dg0Var, h hVar) {
        if (this.w == null) {
            throw new AssertionError("Video data comes before the track is added to MediaMuxer.");
        }
        long size = this.K + dg0Var.size();
        long j = this.S;
        long j2 = 0;
        if (j != 0 && size > j) {
            androidx.camera.core.x.a("Recorder", String.format("Reach file size limit %d > %d", Long.valueOf(size), Long.valueOf(this.S)));
            d0(hVar, 2, null);
            return;
        }
        long jQ0 = dg0Var.q0();
        long j3 = this.M;
        if (j3 == Long.MAX_VALUE) {
            this.M = jQ0;
            androidx.camera.core.x.a("Recorder", String.format("First video time: %d (%s)", Long.valueOf(jQ0), l70.c(this.M)));
        } else {
            TimeUnit timeUnit = TimeUnit.MICROSECONDS;
            long nanos = timeUnit.toNanos(jQ0 - Math.min(j3, this.P));
            b52.j(this.Q != Long.MAX_VALUE, "There should be a previous data for adjusting the duration.");
            long nanos2 = timeUnit.toNanos(jQ0 - this.Q) + nanos;
            long j4 = this.T;
            if (j4 != 0 && nanos2 > j4) {
                androidx.camera.core.x.a("Recorder", String.format("Video data reaches duration limit %d > %d", Long.valueOf(nanos2), Long.valueOf(this.T)));
                d0(hVar, 9, null);
                return;
            }
            j2 = nanos;
        }
        this.B.writeSampleData(this.w.intValue(), dg0Var.m(), dg0Var.N());
        this.K = size;
        this.L = j2;
        this.Q = jQ0;
        L0();
    }

    @Override // androidx.camera.video.VideoOutput
    public void a(SurfaceRequest surfaceRequest) {
        b(surfaceRequest, Timebase.UPTIME);
    }

    @Override // androidx.camera.video.VideoOutput
    public void b(final SurfaceRequest surfaceRequest, final Timebase timebase) {
        synchronized (this.g) {
            try {
                androidx.camera.core.x.a("Recorder", "Surface is requested in state: " + this.j + ", Current surface: " + this.l);
                if (this.j == State.ERROR) {
                    x0(State.CONFIGURING);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.d.execute(new Runnable() { // from class: be2
            @Override // java.lang.Runnable
            public final void run() {
                this.a.Q(surfaceRequest, timebase);
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:24:0x005c  */
    /* JADX WARN: Code duplicated, block: B:26:0x0061 A[Catch: all -> 0x001a, TryCatch #0 {all -> 0x001a, blocks: (B:4:0x0003, B:5:0x000c, B:32:0x0089, B:7:0x0011, B:10:0x001d, B:13:0x0023, B:14:0x002a, B:17:0x002e, B:18:0x003c, B:19:0x0054, B:22:0x0058, B:26:0x0061, B:28:0x0067, B:29:0x0073, B:30:0x007f), top: B:46:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:28:0x0067 A[Catch: all -> 0x001a, TryCatch #0 {all -> 0x001a, blocks: (B:4:0x0003, B:5:0x000c, B:32:0x0089, B:7:0x0011, B:10:0x001d, B:13:0x0023, B:14:0x002a, B:17:0x002e, B:18:0x003c, B:19:0x0054, B:22:0x0058, B:26:0x0061, B:28:0x0067, B:29:0x0073, B:30:0x007f), top: B:46:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x0073 A[Catch: all -> 0x001a, TryCatch #0 {all -> 0x001a, blocks: (B:4:0x0003, B:5:0x000c, B:32:0x0089, B:7:0x0011, B:10:0x001d, B:13:0x0023, B:14:0x002a, B:17:0x002e, B:18:0x003c, B:19:0x0054, B:22:0x0058, B:26:0x0061, B:28:0x0067, B:29:0x0073, B:30:0x007f), top: B:46:0x0003 }] */
    void b0() {
        h hVarZ;
        boolean z;
        Exception exc;
        int i2;
        int i3;
        h hVar;
        synchronized (this.g) {
            try {
                hVarZ = null;
                switch (this.j) {
                    case CONFIGURING:
                        x0(State.IDLING);
                        hVar = null;
                        exc = null;
                        z = false;
                        i2 = 0;
                        i3 = i2;
                        break;
                    case PENDING_RECORDING:
                        z = false;
                        if (this.m != null) {
                            hVar = null;
                            exc = null;
                            i2 = 0;
                            i3 = i2;
                        } else if (this.a0 == VideoOutput.SourceState.INACTIVE) {
                            hVar = this.n;
                            this.n = null;
                            r0();
                            exc = n0;
                            i2 = 4;
                            i3 = 0;
                        } else {
                            exc = null;
                            i2 = 0;
                            i3 = 0;
                            hVarZ = Z(this.j);
                            hVar = null;
                        }
                        break;
                    case PENDING_PAUSED:
                        z = true;
                        if (this.m != null) {
                            hVar = null;
                            exc = null;
                            i2 = 0;
                            i3 = i2;
                        } else if (this.a0 == VideoOutput.SourceState.INACTIVE) {
                            hVar = this.n;
                            this.n = null;
                            r0();
                            exc = n0;
                            i2 = 4;
                            i3 = 0;
                        } else {
                            exc = null;
                            i2 = 0;
                            i3 = 0;
                            hVarZ = Z(this.j);
                            hVar = null;
                        }
                        break;
                    case IDLING:
                    case RESETTING:
                        throw new AssertionError("Incorrectly invoke onConfigured() in state " + this.j);
                    case RECORDING:
                        z = false;
                        b52.j(L(), "Unexpectedly invoke onConfigured() when there's a non-persistent in-progress recording");
                        i3 = 1;
                        hVar = null;
                        exc = null;
                        i2 = 0;
                        break;
                    case PAUSED:
                        z = true;
                        b52.j(L(), "Unexpectedly invoke onConfigured() when there's a non-persistent in-progress recording");
                        i3 = 1;
                        hVar = null;
                        exc = null;
                        i2 = 0;
                        break;
                    case STOPPING:
                        if (!this.h) {
                            throw new AssertionError("Unexpectedly invoke onConfigured() in a STOPPING state when it's not waiting for a new surface.");
                        }
                        hVar = null;
                        exc = null;
                        z = false;
                        i2 = 0;
                        i3 = i2;
                        break;
                        break;
                    case ERROR:
                        androidx.camera.core.x.c("Recorder", "onConfigured() was invoked when the Recorder had encountered error");
                        hVar = null;
                        exc = null;
                        z = false;
                        i2 = 0;
                        i3 = i2;
                        break;
                    default:
                        hVar = null;
                        exc = null;
                        z = false;
                        i2 = 0;
                        i3 = i2;
                        break;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (i3 == 0) {
            if (hVarZ != null) {
                E0(hVarZ, z);
                return;
            } else {
                if (hVar != null) {
                    B(hVar, i2, exc);
                    return;
                }
                return;
            }
        }
        K0(this.p, true);
        this.E.start();
        if (this.g0) {
            h hVar2 = this.p;
            hVar2.N0(w0.e(hVar2.k0(), D()));
            this.g0 = false;
        }
        if (z) {
            this.E.pause();
        }
    }

    @Override // androidx.camera.video.VideoOutput
    public ut1 c() {
        return this.C;
    }

    void c0(Throwable th) {
        h hVar;
        synchronized (this.g) {
            try {
                hVar = null;
                switch (this.j) {
                    case PENDING_RECORDING:
                    case PENDING_PAUSED:
                        h hVar2 = this.n;
                        this.n = null;
                        hVar = hVar2;
                    case CONFIGURING:
                        y0(-1);
                        x0(State.ERROR);
                        break;
                    case IDLING:
                    case RECORDING:
                    case PAUSED:
                    case STOPPING:
                    case RESETTING:
                        throw new AssertionError("Encountered encoder setup error while in unexpected state " + this.j + ": " + th);
                    default:
                        break;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (hVar != null) {
            B(hVar, 7, th);
        }
    }

    @Override // androidx.camera.video.VideoOutput
    public m0 d(yt ytVar) {
        return G(ytVar, this.i);
    }

    void d0(h hVar, int i2, Throwable th) {
        boolean z;
        if (hVar != this.p) {
            throw new AssertionError("Internal error occurred on recording that is not the current in-progress recording.");
        }
        synchronized (this.g) {
            try {
                z = false;
                switch (this.j) {
                    case CONFIGURING:
                    case IDLING:
                    case ERROR:
                        throw new AssertionError("In-progress recording error occurred while in unexpected state: " + this.j);
                    case RECORDING:
                    case PAUSED:
                        x0(State.STOPPING);
                        z = true;
                    case PENDING_RECORDING:
                    case PENDING_PAUSED:
                    case STOPPING:
                    case RESETTING:
                        if (hVar != this.m) {
                            throw new AssertionError("Internal error occurred for recording but it is not the active recording.");
                        }
                        break;
                    default:
                        break;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (z) {
            U(hVar, -1L, i2, th);
        }
    }

    @Override // androidx.camera.video.VideoOutput
    public ut1 e() {
        return this.a;
    }

    @Override // androidx.camera.video.VideoOutput
    public void f(final VideoOutput.SourceState sourceState) {
        this.d.execute(new Runnable() { // from class: td2
            @Override // java.lang.Runnable
            public final void run() {
                this.a.P(sourceState);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: renamed from: g0, reason: merged with bridge method [inline-methods] */
    public void P(VideoOutput.SourceState sourceState) {
        ScheduledFuture scheduledFuture;
        androidx.camera.video.internal.encoder.c cVar;
        VideoOutput.SourceState sourceState2 = this.a0;
        this.a0 = sourceState;
        if (sourceState2 == sourceState) {
            androidx.camera.core.x.a("Recorder", "Video source transitions to the same state: " + sourceState);
            return;
        }
        androidx.camera.core.x.a("Recorder", "Video source has transitioned to state: " + sourceState);
        if (sourceState != VideoOutput.SourceState.INACTIVE) {
            if (sourceState != VideoOutput.SourceState.ACTIVE_NON_STREAMING || (scheduledFuture = this.b0) == null || !scheduledFuture.cancel(false) || (cVar = this.E) == null) {
                return;
            }
            a0(cVar);
            return;
        }
        if (this.A == null) {
            i iVar = this.h0;
            if (iVar != null) {
                iVar.j();
                this.h0 = null;
            }
            o0(4, null, false);
            return;
        }
        this.c0 = true;
        h hVar = this.p;
        if (hVar == null || hVar.A0()) {
            return;
        }
        d0(this.p, 4, null);
    }

    void i0(VideoEncoderSession videoEncoderSession) {
        androidx.camera.video.internal.encoder.c cVarM = videoEncoderSession.m();
        this.E = cVarM;
        this.O = ((pc3) cVarM.c()).c();
        this.N = this.E.g();
        Surface surfaceK = videoEncoderSession.k();
        this.A = surfaceK;
        w0(surfaceK);
        videoEncoderSession.v(this.d, new androidx.camera.video.internal.encoder.c.InterfaceC0011c.a() { // from class: androidx.camera.video.w
            @Override // androidx.camera.video.internal.encoder.c.InterfaceC0011c.a
            public final void a(Surface surface) {
                this.a.w0(surface);
            }
        });
        os0.j(videoEncoderSession.l(), new a(videoEncoderSession), this.d);
    }

    public r k0(Context context, sm0 sm0Var) {
        return m0(context, sm0Var);
    }

    public r l0(Context context, bi1 bi1Var) {
        return m0(context, bi1Var);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    void o0(int i2, Throwable th, boolean z) {
        boolean z2;
        boolean z3;
        synchronized (this.g) {
            try {
                z2 = true;
                z3 = false;
                switch (this.j) {
                    case CONFIGURING:
                    case IDLING:
                    case ERROR:
                        break;
                    case PENDING_RECORDING:
                    case PENDING_PAUSED:
                        M0(State.RESETTING);
                        break;
                    case RECORDING:
                    case PAUSED:
                        b52.j(this.p != null, "In-progress recording shouldn't be null when in state " + this.j);
                        if (this.m != this.p) {
                            throw new AssertionError("In-progress recording does not match the active recording. Unable to reset encoder.");
                        }
                        if (!L()) {
                            x0(State.RESETTING);
                            z3 = true;
                            z2 = false;
                        }
                        break;
                        break;
                    case STOPPING:
                        x0(State.RESETTING);
                        z2 = false;
                        break;
                    case RESETTING:
                    default:
                        z2 = false;
                        break;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (!z2) {
            if (z3) {
                U(this.p, -1L, i2, th);
            }
        } else if (z) {
            q0();
        } else {
            p0();
        }
    }

    void u0(AudioState audioState) {
        androidx.camera.core.x.a("Recorder", "Transitioning audio state: " + this.I + " --> " + audioState);
        this.I = audioState;
    }

    void v0(SurfaceRequest.g gVar) {
        androidx.camera.core.x.a("Recorder", "Update stream transformation info: " + gVar);
        this.r = gVar;
        synchronized (this.g) {
            this.a.h(StreamInfo.e(this.l, I(this.j), gVar));
        }
    }

    void w0(Surface surface) {
        int iHashCode;
        if (this.z == surface) {
            return;
        }
        this.z = surface;
        synchronized (this.g) {
            if (surface != null) {
                try {
                    iHashCode = surface.hashCode();
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                iHashCode = 0;
            }
            y0(iHashCode);
        }
    }

    void x0(State state) {
        if (this.j == state) {
            throw new AssertionError("Attempted to transition to state " + state + ", but Recorder is already in state " + state);
        }
        androidx.camera.core.x.a("Recorder", "Transitioning Recorder internal state: " + this.j + " --> " + state);
        Set set = i0;
        StreamInfo.StreamState streamStateI = null;
        if (set.contains(state)) {
            if (!set.contains(this.j)) {
                if (!j0.contains(this.j)) {
                    throw new AssertionError("Invalid state transition. Should not be transitioning to a PENDING state from state " + this.j);
                }
                State state2 = this.j;
                this.k = state2;
                streamStateI = I(state2);
            }
        } else if (this.k != null) {
            this.k = null;
        }
        this.j = state;
        if (streamStateI == null) {
            streamStateI = I(state);
        }
        this.a.h(StreamInfo.e(this.l, streamStateI, this.r));
    }

    void z0(h hVar) {
        if (this.B != null) {
            throw new AssertionError("Unable to set up media muxer when one already exists.");
        }
        if (J() && this.X.isEmpty()) {
            throw new AssertionError("Audio is enabled but no audio sample is ready. Cannot start media muxer.");
        }
        dg0 dg0Var = this.W;
        if (dg0Var == null) {
            throw new AssertionError("Media muxer cannot be started without an encoded video frame.");
        }
        try {
            this.W = null;
            List listC = C(dg0Var.q0());
            long size = dg0Var.size();
            Iterator it = listC.iterator();
            while (it.hasNext()) {
                size += ((dg0) it.next()).size();
            }
            long j = this.S;
            if (j != 0 && size > j) {
                androidx.camera.core.x.a("Recorder", String.format("Initial data exceeds file size limit %d > %d", Long.valueOf(size), Long.valueOf(this.S)));
                d0(hVar, 2, null);
                dg0Var.close();
                return;
            }
            try {
                p pVar = (p) E(this.C);
                MediaMuxer mediaMuxerM0 = hVar.M0(pVar.c() == -1 ? H0(this.t, p.g(m0.c())) : p.g(pVar.c()), new q20() { // from class: wd2
                    @Override // defpackage.q20
                    public final void accept(Object obj) {
                        this.a.S((Uri) obj);
                    }
                });
                SurfaceRequest.g gVar = this.s;
                if (gVar != null) {
                    v0(gVar);
                    mediaMuxerM0.setOrientationHint(gVar.b());
                }
                Location locationC = hVar.k0().c();
                if (locationC != null) {
                    try {
                        Pair pairA = q40.a(locationC.getLatitude(), locationC.getLongitude());
                        mediaMuxerM0.setLocation((float) ((Double) pairA.first).doubleValue(), (float) ((Double) pairA.second).doubleValue());
                    } catch (IllegalArgumentException e2) {
                        mediaMuxerM0.release();
                        d0(hVar, 5, e2);
                        dg0Var.close();
                        return;
                    }
                }
                this.w = Integer.valueOf(mediaMuxerM0.addTrack(this.F.a()));
                if (J()) {
                    this.v = Integer.valueOf(mediaMuxerM0.addTrack(this.H.a()));
                }
                mediaMuxerM0.start();
                this.B = mediaMuxerM0;
                O0(dg0Var, hVar);
                Iterator it2 = listC.iterator();
                while (it2.hasNext()) {
                    N0((dg0) it2.next(), hVar);
                }
                dg0Var.close();
            } catch (IOException e3) {
                d0(hVar, 5, e3);
                dg0Var.close();
            }
        } catch (Throwable th) {
            if (dg0Var != null) {
                try {
                    dg0Var.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }
}
