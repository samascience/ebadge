package androidx.camera.video;

import android.graphics.Rect;
import android.media.MediaCodec;
import android.os.SystemClock;
import android.util.Range;
import android.util.Size;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.Timebase;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.processing.SurfaceProcessorNode;
import androidx.camera.video.n0;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import defpackage.as;
import defpackage.b52;
import defpackage.bs0;
import defpackage.cs;
import defpackage.eh0;
import defpackage.fr2;
import defpackage.ie0;
import defpackage.ir2;
import defpackage.ix2;
import defpackage.iy2;
import defpackage.m03;
import defpackage.me0;
import defpackage.os0;
import defpackage.ox2;
import defpackage.pc3;
import defpackage.pd3;
import defpackage.rc3;
import defpackage.t23;
import defpackage.ub1;
import defpackage.ut1;
import defpackage.va0;
import defpackage.vd3;
import defpackage.vj0;
import defpackage.w80;
import defpackage.wr0;
import defpackage.xb3;
import defpackage.y43;
import defpackage.yb3;
import defpackage.yt;
import defpackage.zt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class n0 extends UseCase {
    static boolean A;
    private static final e z = new e();
    DeferrableSurface n;
    private ix2 o;
    StreamInfo p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    SessionConfig.b f161q;
    ub1 r;
    private SurfaceRequest s;
    VideoOutput.SourceState t;
    private SurfaceProcessorNode u;
    private Rect v;
    private int w;
    private boolean x;
    private final ut1.a y;

    class a implements ut1.a {
        a() {
        }

        @Override // ut1.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(StreamInfo streamInfo) {
            if (streamInfo == null) {
                throw new IllegalArgumentException("StreamInfo can't be null");
            }
            if (n0.this.t == VideoOutput.SourceState.INACTIVE) {
                return;
            }
            androidx.camera.core.x.a("VideoCapture", "Stream info update: old: " + n0.this.p + " new: " + streamInfo);
            n0 n0Var = n0.this;
            StreamInfo streamInfo2 = n0Var.p;
            n0Var.p = streamInfo;
            androidx.camera.core.impl.x xVar = (androidx.camera.core.impl.x) b52.g(n0Var.e());
            if (n0.this.G0(streamInfo2.a(), streamInfo.a()) || n0.this.b1(streamInfo2, streamInfo)) {
                n0 n0Var2 = n0.this;
                n0Var2.P0(n0Var2.i(), (xb3) n0.this.j(), (androidx.camera.core.impl.x) b52.g(n0.this.e()));
                return;
            }
            if ((streamInfo2.a() != -1 && streamInfo.a() == -1) || (streamInfo2.a() == -1 && streamInfo.a() != -1)) {
                n0 n0Var3 = n0.this;
                n0Var3.r0(n0Var3.f161q, streamInfo, xVar);
                n0 n0Var4 = n0.this;
                n0Var4.U(n0Var4.f161q.p());
                n0.this.E();
                return;
            }
            if (streamInfo2.c() != streamInfo.c()) {
                n0 n0Var5 = n0.this;
                n0Var5.r0(n0Var5.f161q, streamInfo, xVar);
                n0 n0Var6 = n0.this;
                n0Var6.U(n0Var6.f161q.p());
                n0.this.G();
            }
        }

        @Override // ut1.a
        public void onError(Throwable th) {
            androidx.camera.core.x.l("VideoCapture", "Receive onError from StreamState observer", th);
        }
    }

    class b extends as {
        private boolean a = true;
        final /* synthetic */ AtomicBoolean b;
        final /* synthetic */ CallbackToFutureAdapter.a c;
        final /* synthetic */ SessionConfig.b d;

        b(AtomicBoolean atomicBoolean, CallbackToFutureAdapter.a aVar, SessionConfig.b bVar) {
            this.b = atomicBoolean;
            this.c = aVar;
            this.d = bVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f(SessionConfig.b bVar) {
            bVar.t(this);
        }

        @Override // defpackage.as
        public void b(int i, cs csVar) {
            Object objD;
            super.b(i, csVar);
            if (this.a) {
                this.a = false;
                androidx.camera.core.x.a("VideoCapture", "cameraCaptureResult timestampNs = " + csVar.c() + ", current system uptimeMs = " + SystemClock.uptimeMillis() + ", current system realtimeMs = " + SystemClock.elapsedRealtime());
            }
            if (this.b.get() || (objD = csVar.a().d("androidx.camera.video.VideoCapture.streamUpdate")) == null || ((Integer) objD).intValue() != this.c.hashCode() || !this.c.c(null) || this.b.getAndSet(true)) {
                return;
            }
            ScheduledExecutorService scheduledExecutorServiceE = androidx.camera.core.impl.utils.executor.c.e();
            final SessionConfig.b bVar = this.d;
            scheduledExecutorServiceE.execute(new Runnable() { // from class: androidx.camera.video.o0
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.f(bVar);
                }
            });
        }
    }

    class c implements bs0 {
        final /* synthetic */ ub1 a;
        final /* synthetic */ boolean b;

        c(ub1 ub1Var, boolean z) {
            this.a = ub1Var;
            this.b = z;
        }

        @Override // defpackage.bs0
        public void a(Throwable th) {
            if (th instanceof CancellationException) {
                return;
            }
            androidx.camera.core.x.d("VideoCapture", "Surface update completed with unexpected exception", th);
        }

        @Override // defpackage.bs0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Void r3) {
            ub1 ub1Var = this.a;
            n0 n0Var = n0.this;
            if (ub1Var != n0Var.r || n0Var.t == VideoOutput.SourceState.INACTIVE) {
                return;
            }
            n0Var.U0(this.b ? VideoOutput.SourceState.ACTIVE_STREAMING : VideoOutput.SourceState.ACTIVE_NON_STREAMING);
        }
    }

    public static final class d implements androidx.camera.core.impl.d0.a {
        private final androidx.camera.core.impl.t a;

        public d(VideoOutput videoOutput) {
            this(d(videoOutput));
        }

        private static androidx.camera.core.impl.t d(VideoOutput videoOutput) {
            androidx.camera.core.impl.t tVarC0 = androidx.camera.core.impl.t.c0();
            tVarC0.x(xb3.J, videoOutput);
            return tVarC0;
        }

        static d e(Config config) {
            return new d(androidx.camera.core.impl.t.d0(config));
        }

        @Override // defpackage.oj0
        public androidx.camera.core.impl.s a() {
            return this.a;
        }

        public n0 c() {
            return new n0(b());
        }

        @Override // androidx.camera.core.impl.d0.a
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public xb3 b() {
            return new xb3(androidx.camera.core.impl.u.a0(this.a));
        }

        public d g(UseCaseConfigFactory.CaptureType captureType) {
            a().x(androidx.camera.core.impl.d0.F, captureType);
            return this;
        }

        public d h(ie0 ie0Var) {
            a().x(androidx.camera.core.impl.q.m, ie0Var);
            return this;
        }

        public d i(int i) {
            a().x(androidx.camera.core.impl.d0.B, Integer.valueOf(i));
            return this;
        }

        public d j(Class cls) {
            a().x(m03.c, cls);
            if (a().f(m03.b, null) == null) {
                k(cls.getCanonicalName() + "-" + UUID.randomUUID());
            }
            return this;
        }

        public d k(String str) {
            a().x(m03.b, str);
            return this;
        }

        d l(wr0 wr0Var) {
            a().x(xb3.K, wr0Var);
            return this;
        }

        private d(androidx.camera.core.impl.t tVar) {
            this.a = tVar;
            if (!tVar.b(xb3.J)) {
                throw new IllegalArgumentException("VideoOutput is required");
            }
            Class cls = (Class) tVar.f(m03.c, null);
            if (cls == null || cls.equals(n0.class)) {
                g(UseCaseConfigFactory.CaptureType.VIDEO_CAPTURE);
                j(n0.class);
                return;
            }
            throw new IllegalArgumentException("Invalid target class configuration for " + this + ": " + cls);
        }
    }

    public static final class e {
        private static final VideoOutput a;
        private static final xb3 b;
        private static final wr0 c;
        static final Range d;
        static final ie0 e;

        static {
            VideoOutput videoOutput = new VideoOutput() { // from class: wb3
                @Override // androidx.camera.video.VideoOutput
                public final void a(SurfaceRequest surfaceRequest) {
                    surfaceRequest.E();
                }
            };
            a = videoOutput;
            wr0 wr0Var = androidx.camera.video.internal.encoder.c0.d;
            c = wr0Var;
            d = new Range(30, 30);
            ie0 ie0Var = ie0.d;
            e = ie0Var;
            b = new d(videoOutput).i(5).l(wr0Var).h(ie0Var).b();
        }

        public xb3 a() {
            return b;
        }
    }

    static {
        A = E0() || (va0.a(vj0.class) != null);
    }

    n0(xb3 xb3Var) {
        super(xb3Var);
        this.p = StreamInfo.a;
        this.f161q = new SessionConfig.b();
        this.r = null;
        this.t = VideoOutput.SourceState.INACTIVE;
        this.x = false;
        this.y = new a();
    }

    private p B0() {
        return (p) w0(C0().c(), null);
    }

    private m0 D0(yt ytVar) {
        return C0().d(ytVar);
    }

    private static boolean E0() {
        Iterator it = va0.c(pd3.class).iterator();
        while (it.hasNext()) {
            if (((pd3) it.next()).a()) {
                return true;
            }
        }
        return false;
    }

    private boolean F0(CameraInternal cameraInternal, xb3 xb3Var, Rect rect, Size size) {
        l();
        return Y0(cameraInternal, xb3Var) || Z0(cameraInternal) || X0(rect, size) || a1(cameraInternal) || W0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int H0(Rect rect, Size size, Size size2) {
        return (Math.abs(size.getWidth() - rect.width()) + Math.abs(size.getHeight() - rect.height())) - (Math.abs(size2.getWidth() - rect.width()) + Math.abs(size2.getHeight() - rect.height()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K0(DeferrableSurface deferrableSurface) {
        if (deferrableSurface == this.n) {
            t0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L0(String str, xb3 xb3Var, androidx.camera.core.impl.x xVar, SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
        P0(str, xb3Var, xVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void M0(AtomicBoolean atomicBoolean, SessionConfig.b bVar, as asVar) {
        b52.j(t23.c(), "Surface update cancellation should only occur on main thread.");
        atomicBoolean.set(true);
        bVar.t(asVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object N0(final SessionConfig.b bVar, CallbackToFutureAdapter.a aVar) {
        bVar.o("androidx.camera.video.VideoCapture.streamUpdate", Integer.valueOf(aVar.hashCode()));
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final b bVar2 = new b(atomicBoolean, aVar, bVar);
        aVar.a(new Runnable() { // from class: ub3
            @Override // java.lang.Runnable
            public final void run() {
                n0.M0(atomicBoolean, bVar, bVar2);
            }
        }, androidx.camera.core.impl.utils.executor.c.b());
        bVar.k(bVar2);
        return String.format("%s[0x%x]", "androidx.camera.video.VideoCapture.streamUpdate", Integer.valueOf(aVar.hashCode()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: O0, reason: merged with bridge method [inline-methods] */
    public void J0(ix2 ix2Var, CameraInternal cameraInternal, xb3 xb3Var, Timebase timebase) {
        if (cameraInternal == g()) {
            this.s = ix2Var.k(cameraInternal);
            xb3Var.Z().b(this.s, timebase);
            T0();
        }
    }

    private static Range Q0(androidx.camera.core.impl.x xVar) {
        Range rangeC = xVar.c();
        return Objects.equals(rangeC, androidx.camera.core.impl.x.a) ? e.d : rangeC;
    }

    private static Timebase R0(CameraInternal cameraInternal, SurfaceProcessorNode surfaceProcessorNode) {
        return (surfaceProcessorNode == null && cameraInternal.m()) ? Timebase.UPTIME : cameraInternal.n().h();
    }

    private static pc3 S0(wr0 wr0Var, vd3 vd3Var, p pVar, Size size, ie0 ie0Var, Range range) {
        pc3 pc3Var = (pc3) wr0Var.apply(yb3.c(yb3.d(pVar, ie0Var, vd3Var), Timebase.UPTIME, pVar.d(), size, ie0Var, range));
        if (pc3Var != null) {
            return rc3.l(pc3Var, vd3Var != null ? new Size(vd3Var.k().k(), vd3Var.k().h()) : null);
        }
        androidx.camera.core.x.k("VideoCapture", "Can't find videoEncoderInfo");
        return null;
    }

    private void T0() {
        CameraInternal cameraInternalG = g();
        ix2 ix2Var = this.o;
        if (cameraInternalG == null || ix2Var == null) {
            return;
        }
        int iZ0 = z0(cameraInternalG);
        this.w = iZ0;
        ix2Var.C(iZ0, d());
    }

    private void V0(final SessionConfig.b bVar, boolean z2) {
        ub1 ub1Var = this.r;
        if (ub1Var != null && ub1Var.cancel(false)) {
            androidx.camera.core.x.a("VideoCapture", "A newer surface update is requested. Previous surface update cancelled.");
        }
        ub1 ub1VarA = CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: pb3
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
            public final Object a(CallbackToFutureAdapter.a aVar) {
                return this.a.N0(bVar, aVar);
            }
        });
        this.r = ub1VarA;
        os0.j(ub1VarA, new c(ub1VarA, z2), androidx.camera.core.impl.utils.executor.c.e());
    }

    private boolean W0() {
        return this.p.b() != null;
    }

    private static boolean X0(Rect rect, Size size) {
        return (size.getWidth() == rect.width() && size.getHeight() == rect.height()) ? false : true;
    }

    private static boolean Y0(CameraInternal cameraInternal, xb3 xb3Var) {
        return cameraInternal.m() && xb3Var.a0();
    }

    private static boolean Z0(CameraInternal cameraInternal) {
        return cameraInternal.m() && (A || ox2.b(cameraInternal.n().m()));
    }

    private boolean a1(CameraInternal cameraInternal) {
        return cameraInternal.m() && A(cameraInternal);
    }

    private void c1(zt ztVar, androidx.camera.core.impl.d0.a aVar) {
        p pVarB0 = B0();
        b52.b(pVarB0 != null, "Unable to update target resolution by null MediaSpec.");
        ie0 ie0VarA0 = A0();
        m0 m0VarD0 = D0(ztVar);
        List listC = m0VarD0.c(ie0VarA0);
        if (listC.isEmpty()) {
            androidx.camera.core.x.k("VideoCapture", "Can't find any supported quality on the device.");
            return;
        }
        x0 x0VarD = pVarB0.d();
        v vVarE = x0VarD.e();
        List listG = vVarE.g(listC);
        androidx.camera.core.x.a("VideoCapture", "Found selectedQualities " + listG + " by " + vVarE);
        if (listG.isEmpty()) {
            throw new IllegalArgumentException("Unable to find supported quality by QualitySelector");
        }
        int iB = x0VarD.b();
        Map mapI = v.i(m0VarD0, ie0VarA0);
        u uVar = new u(ztVar.n(m()), mapI);
        ArrayList arrayList = new ArrayList();
        Iterator it = listG.iterator();
        while (it.hasNext()) {
            arrayList.addAll(uVar.g((s) it.next(), iB));
        }
        List listX0 = x0((xb3) aVar.b(), pVarB0, ie0VarA0, m0VarD0, arrayList, mapI);
        androidx.camera.core.x.a("VideoCapture", "Set custom ordered resolutions = " + listX0);
        aVar.a().x(androidx.camera.core.impl.r.w, listX0);
    }

    public static n0 d1(VideoOutput videoOutput) {
        return new d((VideoOutput) b52.g(videoOutput)).c();
    }

    private static void j0(Set set, int i, int i2, Size size, pc3 pc3Var) {
        if (i > size.getWidth() || i2 > size.getHeight()) {
            return;
        }
        try {
            set.add(new Size(i, ((Integer) pc3Var.f(i).clamp(Integer.valueOf(i2))).intValue()));
        } catch (IllegalArgumentException e2) {
            androidx.camera.core.x.l("VideoCapture", "No supportedHeights for width: " + i, e2);
        }
        try {
            set.add(new Size(((Integer) pc3Var.e(i2).clamp(Integer.valueOf(i))).intValue(), i2));
        } catch (IllegalArgumentException e3) {
            androidx.camera.core.x.l("VideoCapture", "No supportedWidths for height: " + i2, e3);
        }
    }

    private static Rect k0(Rect rect, int i, boolean z2, pc3 pc3Var) {
        fr2 fr2Var = (fr2) va0.a(fr2.class);
        if (fr2Var == null) {
            return rect;
        }
        if (!z2) {
            i = 0;
        }
        return fr2Var.f(rect, i, pc3Var);
    }

    private static Rect l0(final Rect rect, Size size, pc3 pc3Var) {
        androidx.camera.core.x.a("VideoCapture", String.format("Adjust cropRect %s by width/height alignment %d/%d and supported widths %s / supported heights %s", y43.n(rect), Integer.valueOf(pc3Var.b()), Integer.valueOf(pc3Var.g()), pc3Var.h(), pc3Var.j()));
        if ((!pc3Var.h().contains(Integer.valueOf(rect.width())) || !pc3Var.j().contains(Integer.valueOf(rect.height()))) && pc3Var.d() && pc3Var.j().contains(Integer.valueOf(rect.width())) && pc3Var.h().contains(Integer.valueOf(rect.height()))) {
            pc3Var = new iy2(pc3Var);
        }
        int iB = pc3Var.b();
        int iG = pc3Var.g();
        Range rangeH = pc3Var.h();
        Range rangeJ = pc3Var.j();
        int iP0 = p0(rect.width(), iB, rangeH);
        int iQ0 = q0(rect.width(), iB, rangeH);
        int iP1 = p0(rect.height(), iG, rangeJ);
        int iQ1 = q0(rect.height(), iG, rangeJ);
        HashSet hashSet = new HashSet();
        j0(hashSet, iP0, iP1, size, pc3Var);
        j0(hashSet, iP0, iQ1, size, pc3Var);
        j0(hashSet, iQ0, iP1, size, pc3Var);
        j0(hashSet, iQ0, iQ1, size, pc3Var);
        if (hashSet.isEmpty()) {
            androidx.camera.core.x.k("VideoCapture", "Can't find valid cropped size");
            return rect;
        }
        ArrayList arrayList = new ArrayList(hashSet);
        androidx.camera.core.x.a("VideoCapture", "candidatesList = " + arrayList);
        Collections.sort(arrayList, new Comparator() { // from class: vb3
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return n0.H0(rect, (Size) obj, (Size) obj2);
            }
        });
        androidx.camera.core.x.a("VideoCapture", "sorted candidatesList = " + arrayList);
        Size size2 = (Size) arrayList.get(0);
        int width = size2.getWidth();
        int height = size2.getHeight();
        if (width == rect.width() && height == rect.height()) {
            androidx.camera.core.x.a("VideoCapture", "No need to adjust cropRect because crop size is valid.");
            return rect;
        }
        b52.i(width % 2 == 0 && height % 2 == 0 && width <= size.getWidth() && height <= size.getHeight());
        Rect rect2 = new Rect(rect);
        if (width != rect.width()) {
            int iMax = Math.max(0, rect.centerX() - (width / 2));
            rect2.left = iMax;
            int i = iMax + width;
            rect2.right = i;
            if (i > size.getWidth()) {
                int width2 = size.getWidth();
                rect2.right = width2;
                rect2.left = width2 - width;
            }
        }
        if (height != rect.height()) {
            int iMax2 = Math.max(0, rect.centerY() - (height / 2));
            rect2.top = iMax2;
            int i2 = iMax2 + height;
            rect2.bottom = i2;
            if (i2 > size.getHeight()) {
                int height2 = size.getHeight();
                rect2.bottom = height2;
                rect2.top = height2 - height;
            }
        }
        androidx.camera.core.x.a("VideoCapture", String.format("Adjust cropRect from %s to %s", y43.n(rect), y43.n(rect2)));
        return rect2;
    }

    private Rect m0(Rect rect, int i) {
        return W0() ? y43.q(y43.f(((SurfaceRequest.g) b52.g(this.p.b())).a(), i)) : rect;
    }

    private Size n0(Size size, Rect rect, Rect rect2) {
        if (!W0() || rect2.equals(rect)) {
            return size;
        }
        float fHeight = rect2.height() / rect.height();
        return new Size((int) Math.ceil(size.getWidth() * fHeight), (int) Math.ceil(size.getHeight() * fHeight));
    }

    private static int o0(boolean z2, int i, int i2, Range range) {
        int i3 = i % i2;
        if (i3 != 0) {
            i = z2 ? i - i3 : i + (i2 - i3);
        }
        return ((Integer) range.clamp(Integer.valueOf(i))).intValue();
    }

    private static int p0(int i, int i2, Range range) {
        return o0(true, i, i2, range);
    }

    private static int q0(int i, int i2, Range range) {
        return o0(false, i, i2, range);
    }

    private Rect s0(Size size, pc3 pc3Var) {
        Rect rectX = x() != null ? x() : new Rect(0, 0, size.getWidth(), size.getHeight());
        return (pc3Var == null || pc3Var.a(rectX.width(), rectX.height())) ? rectX : l0(rectX, size, pc3Var);
    }

    private void t0() {
        t23.a();
        DeferrableSurface deferrableSurface = this.n;
        if (deferrableSurface != null) {
            deferrableSurface.d();
            this.n = null;
        }
        SurfaceProcessorNode surfaceProcessorNode = this.u;
        if (surfaceProcessorNode != null) {
            surfaceProcessorNode.i();
            this.u = null;
        }
        ix2 ix2Var = this.o;
        if (ix2Var != null) {
            ix2Var.i();
            this.o = null;
        }
        this.v = null;
        this.s = null;
        this.p = StreamInfo.a;
        this.w = 0;
        this.x = false;
    }

    private SurfaceProcessorNode u0(CameraInternal cameraInternal, xb3 xb3Var, Rect rect, Size size, ie0 ie0Var) {
        if (!F0(cameraInternal, xb3Var, rect, size)) {
            return null;
        }
        androidx.camera.core.x.a("VideoCapture", "Surface processing is enabled.");
        CameraInternal cameraInternalG = g();
        Objects.requireNonNull(cameraInternalG);
        l();
        return new SurfaceProcessorNode(cameraInternalG, w80.a.a(ie0Var));
    }

    private SessionConfig.b v0(final String str, final xb3 xb3Var, final androidx.camera.core.impl.x xVar) {
        t23.a();
        final CameraInternal cameraInternal = (CameraInternal) b52.g(g());
        Size sizeE = xVar.e();
        Runnable runnable = new Runnable() { // from class: qb3
            @Override // java.lang.Runnable
            public final void run() {
                this.a.E();
            }
        };
        Range rangeQ0 = Q0(xVar);
        p pVarB0 = B0();
        Objects.requireNonNull(pVarB0);
        m0 m0VarD0 = D0(cameraInternal.a());
        ie0 ie0VarB = xVar.b();
        pc3 pc3VarS0 = S0(xb3Var.Y(), m0VarD0.a(sizeE, ie0VarB), pVarB0, sizeE, ie0VarB, rangeQ0);
        this.w = z0(cameraInternal);
        Rect rectS0 = s0(sizeE, pc3VarS0);
        Rect rectM0 = m0(rectS0, this.w);
        this.v = rectM0;
        Size sizeN0 = n0(sizeE, rectS0, rectM0);
        if (W0()) {
            this.x = true;
        }
        Rect rect = this.v;
        Rect rectK0 = k0(rect, this.w, F0(cameraInternal, xb3Var, rect, sizeE), pc3VarS0);
        this.v = rectK0;
        SurfaceProcessorNode surfaceProcessorNodeU0 = u0(cameraInternal, xb3Var, rectK0, sizeE, ie0VarB);
        this.u = surfaceProcessorNodeU0;
        final Timebase timebaseR0 = R0(cameraInternal, surfaceProcessorNodeU0);
        androidx.camera.core.x.a("VideoCapture", "camera timebase = " + cameraInternal.n().h() + ", processing timebase = " + timebaseR0);
        androidx.camera.core.impl.x xVarA = xVar.f().e(sizeN0).c(rangeQ0).a();
        b52.i(this.o == null);
        ix2 ix2Var = new ix2(2, 34, xVarA, s(), cameraInternal.m(), this.v, this.w, d(), a1(cameraInternal));
        this.o = ix2Var;
        ix2Var.e(runnable);
        if (this.u != null) {
            SurfaceProcessorNode.c cVarJ = SurfaceProcessorNode.c.j(this.o);
            final ix2 ix2Var2 = this.u.m(SurfaceProcessorNode.b.c(this.o, Collections.singletonList(cVarJ))).get(cVarJ);
            Objects.requireNonNull(ix2Var2);
            ix2Var2.e(new Runnable() { // from class: rb3
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.J0(ix2Var2, cameraInternal, xb3Var, timebaseR0);
                }
            });
            this.s = ix2Var2.k(cameraInternal);
            final DeferrableSurface deferrableSurfaceN = this.o.n();
            this.n = deferrableSurfaceN;
            deferrableSurfaceN.k().a(new Runnable() { // from class: sb3
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.K0(deferrableSurfaceN);
                }
            }, androidx.camera.core.impl.utils.executor.c.e());
        } else {
            SurfaceRequest surfaceRequestK = this.o.k(cameraInternal);
            this.s = surfaceRequestK;
            this.n = surfaceRequestK.l();
        }
        xb3Var.Z().b(this.s, timebaseR0);
        T0();
        this.n.s(MediaCodec.class);
        SessionConfig.b bVarR = SessionConfig.b.r(xb3Var, xVar.e());
        bVarR.u(xVar.c());
        bVarR.A(xb3Var.G());
        bVarR.g(new SessionConfig.c() { // from class: tb3
            @Override // androidx.camera.core.impl.SessionConfig.c
            public final void a(SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
                this.a.L0(str, xb3Var, xVar, sessionConfig, sessionError);
            }
        });
        if (xVar.d() != null) {
            bVarR.h(xVar.d());
        }
        return bVarR;
    }

    private static Object w0(ut1 ut1Var, Object obj) {
        ub1 ub1VarD = ut1Var.d();
        if (!ub1VarD.isDone()) {
            return obj;
        }
        try {
            return ub1VarD.get();
        } catch (InterruptedException | ExecutionException e2) {
            throw new IllegalStateException(e2);
        }
    }

    private static List x0(xb3 xb3Var, p pVar, ie0 ie0Var, m0 m0Var, List list, Map map) {
        vd3 vd3VarA;
        if (list.isEmpty()) {
            return list;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Size size = (Size) it.next();
            if (!map.containsValue(size) && (vd3VarA = m0Var.a(size, ie0Var)) != null) {
                wr0 wr0VarY = xb3Var.Y();
                Range rangeJ = xb3Var.J(e.d);
                Objects.requireNonNull(rangeJ);
                pc3 pc3VarY0 = y0(wr0VarY, vd3VarA, ie0Var, pVar, size, rangeJ);
                if (pc3VarY0 != null && !pc3VarY0.a(size.getWidth(), size.getHeight())) {
                    it.remove();
                }
            }
        }
        return list;
    }

    private static pc3 y0(wr0 wr0Var, vd3 vd3Var, ie0 ie0Var, p pVar, Size size, Range range) {
        pc3 pc3VarS0;
        int iB;
        if (ie0Var.e()) {
            return S0(wr0Var, vd3Var, pVar, size, ie0Var, range);
        }
        pc3 pc3Var = null;
        int i = Integer.MIN_VALUE;
        for (eh0.c cVar : vd3Var.d()) {
            if (me0.f(cVar, ie0Var) && (pc3VarS0 = S0(wr0Var, vd3Var, pVar, size, new ie0(me0.h(cVar.g()), me0.g(cVar.b())), range)) != null && (iB = ir2.b(((Integer) pc3VarS0.h().getUpper()).intValue(), ((Integer) pc3VarS0.j().getUpper()).intValue())) > i) {
                pc3Var = pc3VarS0;
                i = iB;
            }
        }
        return pc3Var;
    }

    private int z0(CameraInternal cameraInternal) {
        boolean zA = A(cameraInternal);
        int iR = r(cameraInternal, zA);
        if (!W0()) {
            return iR;
        }
        SurfaceRequest.g gVarB = this.p.b();
        Objects.requireNonNull(gVarB);
        int iB = gVarB.b();
        if (zA != gVarB.f()) {
            iB = -iB;
        }
        return y43.v(iR - iB);
    }

    public ie0 A0() {
        return j().u() ? j().k() : e.e;
    }

    public VideoOutput C0() {
        return ((xb3) j()).Z();
    }

    boolean G0(int i, int i2) {
        Set set = StreamInfo.b;
        return (set.contains(Integer.valueOf(i)) || set.contains(Integer.valueOf(i2)) || i == i2) ? false : true;
    }

    @Override // androidx.camera.core.UseCase
    protected androidx.camera.core.impl.d0 J(zt ztVar, androidx.camera.core.impl.d0.a aVar) {
        c1(ztVar, aVar);
        return aVar.b();
    }

    @Override // androidx.camera.core.UseCase
    public void K() {
        super.K();
        b52.h(e(), "The suggested stream specification should be already updated and shouldn't be null.");
        b52.j(this.s == null, "The surface request should be null when VideoCapture is attached.");
        androidx.camera.core.impl.x xVar = (androidx.camera.core.impl.x) b52.g(e());
        this.p = (StreamInfo) w0(C0().e(), StreamInfo.a);
        SessionConfig.b bVarV0 = v0(i(), (xb3) j(), xVar);
        this.f161q = bVarV0;
        r0(bVarV0, this.p, xVar);
        U(this.f161q.p());
        C();
        C0().e().a(androidx.camera.core.impl.utils.executor.c.e(), this.y);
        U0(VideoOutput.SourceState.ACTIVE_NON_STREAMING);
    }

    @Override // androidx.camera.core.UseCase
    public void L() {
        b52.j(t23.c(), "VideoCapture can only be detached on the main thread.");
        U0(VideoOutput.SourceState.INACTIVE);
        C0().e().e(this.y);
        ub1 ub1Var = this.r;
        if (ub1Var != null && ub1Var.cancel(false)) {
            androidx.camera.core.x.a("VideoCapture", "VideoCapture is detached from the camera. Surface update cancelled.");
        }
        t0();
    }

    @Override // androidx.camera.core.UseCase
    protected androidx.camera.core.impl.x M(Config config) {
        this.f161q.h(config);
        U(this.f161q.p());
        androidx.camera.core.impl.x xVarE = e();
        Objects.requireNonNull(xVarE);
        return xVarE.f().d(config).a();
    }

    @Override // androidx.camera.core.UseCase
    protected androidx.camera.core.impl.x N(androidx.camera.core.impl.x xVar) {
        androidx.camera.core.x.a("VideoCapture", "onSuggestedStreamSpecUpdated: " + xVar);
        List listO = ((xb3) j()).o(null);
        if (listO != null && !listO.contains(xVar.e())) {
            androidx.camera.core.x.k("VideoCapture", "suggested resolution " + xVar.e() + " is not in custom ordered resolutions " + listO);
        }
        return xVar;
    }

    void P0(String str, xb3 xb3Var, androidx.camera.core.impl.x xVar) {
        t0();
        if (y(str)) {
            SessionConfig.b bVarV0 = v0(str, xb3Var, xVar);
            this.f161q = bVarV0;
            r0(bVarV0, this.p, xVar);
            U(this.f161q.p());
            E();
        }
    }

    @Override // androidx.camera.core.UseCase
    public void S(Rect rect) {
        super.S(rect);
        T0();
    }

    void U0(VideoOutput.SourceState sourceState) {
        if (sourceState != this.t) {
            this.t = sourceState;
            C0().f(sourceState);
        }
    }

    boolean b1(StreamInfo streamInfo, StreamInfo streamInfo2) {
        return this.x && streamInfo.b() != null && streamInfo2.b() == null;
    }

    @Override // androidx.camera.core.UseCase
    public androidx.camera.core.impl.d0 k(boolean z2, UseCaseConfigFactory useCaseConfigFactory) {
        e eVar = z;
        Config configA = useCaseConfigFactory.a(eVar.a().F(), 1);
        if (z2) {
            configA = Config.I(configA, eVar.a());
        }
        if (configA == null) {
            return null;
        }
        return w(configA).b();
    }

    void r0(SessionConfig.b bVar, StreamInfo streamInfo, androidx.camera.core.impl.x xVar) {
        DeferrableSurface deferrableSurface;
        boolean z2 = streamInfo.a() == -1;
        boolean z3 = streamInfo.c() == StreamInfo.StreamState.ACTIVE;
        if (z2 && z3) {
            throw new IllegalStateException("Unexpected stream state, stream is error but active");
        }
        bVar.q();
        ie0 ie0VarB = xVar.b();
        if (!z2 && (deferrableSurface = this.n) != null) {
            if (z3) {
                bVar.n(deferrableSurface, ie0VarB, null, -1);
            } else {
                bVar.j(deferrableSurface, ie0VarB);
            }
        }
        V0(bVar, z3);
    }

    public String toString() {
        return "VideoCapture:" + o();
    }

    @Override // androidx.camera.core.UseCase
    public Set u() {
        HashSet hashSet = new HashSet();
        hashSet.add(2);
        return hashSet;
    }

    @Override // androidx.camera.core.UseCase
    public androidx.camera.core.impl.d0.a w(Config config) {
        return d.e(config);
    }
}
