package androidx.camera.core;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.location.Location;
import android.net.Uri;
import android.os.Looper;
import android.util.Log;
import android.util.Pair;
import android.util.Rational;
import android.util.Size;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.internal.utils.ImageUtil;
import androidx.camera.core.u;
import defpackage.b52;
import defpackage.d03;
import defpackage.gj0;
import defpackage.i03;
import defpackage.ie0;
import defpackage.kl2;
import defpackage.kn2;
import defpackage.m03;
import defpackage.os0;
import defpackage.qa;
import defpackage.r01;
import defpackage.rz0;
import defpackage.s31;
import defpackage.t23;
import defpackage.ub1;
import defpackage.wf2;
import defpackage.wr0;
import defpackage.x01;
import defpackage.xr2;
import defpackage.y43;
import defpackage.yf2;
import defpackage.zt;
import java.io.File;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import no.nordicsemi.android.dfu.DfuBaseService;

/* JADX INFO: loaded from: classes.dex */
public final class u extends UseCase {
    public static final c y = new c();
    static final gj0 z = new gj0();
    private final x01.a n;
    private final int o;
    private final AtomicReference p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final int f157q;
    private int r;
    private Rational s;
    private kl2 t;
    SessionConfig.b u;
    private r01 v;
    private d03 w;
    private final rz0 x;

    class a implements rz0 {
        a() {
        }

        @Override // defpackage.rz0
        public ub1 a(List list) {
            return u.this.A0(list);
        }

        @Override // defpackage.rz0
        public void b() {
            u.this.u0();
        }

        @Override // defpackage.rz0
        public void c() {
            u.this.E0();
        }
    }

    public static final class b implements androidx.camera.core.impl.d0.a {
        private final androidx.camera.core.impl.t a;

        public b() {
            this(androidx.camera.core.impl.t.c0());
        }

        public static b d(Config config) {
            return new b(androidx.camera.core.impl.t.d0(config));
        }

        @Override // defpackage.oj0
        public androidx.camera.core.impl.s a() {
            return this.a;
        }

        public u c() {
            Integer num = (Integer) a().f(androidx.camera.core.impl.p.M, null);
            if (num != null) {
                a().x(androidx.camera.core.impl.q.l, num);
            } else if (u.o0(a())) {
                a().x(androidx.camera.core.impl.q.l, Integer.valueOf(DfuBaseService.ERROR_SERVICE_DISCOVERY_NOT_STARTED));
                a().x(androidx.camera.core.impl.q.m, ie0.e);
            } else {
                a().x(androidx.camera.core.impl.q.l, 256);
            }
            androidx.camera.core.impl.p pVarB = b();
            androidx.camera.core.impl.r.E(pVarB);
            u uVar = new u(pVarB);
            Size size = (Size) a().f(androidx.camera.core.impl.r.r, null);
            if (size != null) {
                uVar.w0(new Rational(size.getWidth(), size.getHeight()));
            }
            b52.h((Executor) a().f(s31.a, androidx.camera.core.impl.utils.executor.c.d()), "The IO executor can't be null");
            androidx.camera.core.impl.s sVarA = a();
            Config.a aVar = androidx.camera.core.impl.p.K;
            if (sVarA.b(aVar)) {
                Integer num2 = (Integer) a().a(aVar);
                if (num2 == null || !(num2.intValue() == 0 || num2.intValue() == 1 || num2.intValue() == 3 || num2.intValue() == 2)) {
                    throw new IllegalArgumentException("The flash mode is not allowed to set: " + num2);
                }
                if (num2.intValue() == 3 && a().f(androidx.camera.core.impl.p.T, null) == null) {
                    throw new IllegalArgumentException("The flash mode is not allowed to set to FLASH_MODE_SCREEN without setting ScreenFlash");
                }
            }
            return uVar;
        }

        @Override // androidx.camera.core.impl.d0.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public androidx.camera.core.impl.p b() {
            return new androidx.camera.core.impl.p(androidx.camera.core.impl.u.a0(this.a));
        }

        public b f(int i) {
            a().x(androidx.camera.core.impl.p.J, Integer.valueOf(i));
            return this;
        }

        public b g(UseCaseConfigFactory.CaptureType captureType) {
            a().x(androidx.camera.core.impl.d0.F, captureType);
            return this;
        }

        public b h(ie0 ie0Var) {
            a().x(androidx.camera.core.impl.q.m, ie0Var);
            return this;
        }

        public b i(int i) {
            a().x(androidx.camera.core.impl.p.N, Integer.valueOf(i));
            return this;
        }

        public b j(wf2 wf2Var) {
            a().x(androidx.camera.core.impl.r.v, wf2Var);
            return this;
        }

        public b k(int i) {
            a().x(androidx.camera.core.impl.d0.B, Integer.valueOf(i));
            return this;
        }

        public b l(int i) {
            if (i == -1) {
                i = 0;
            }
            a().x(androidx.camera.core.impl.r.n, Integer.valueOf(i));
            return this;
        }

        public b m(Class cls) {
            a().x(m03.c, cls);
            if (a().f(m03.b, null) == null) {
                n(cls.getCanonicalName() + "-" + UUID.randomUUID());
            }
            return this;
        }

        public b n(String str) {
            a().x(m03.b, str);
            return this;
        }

        private b(androidx.camera.core.impl.t tVar) {
            this.a = tVar;
            Class cls = (Class) tVar.f(m03.c, null);
            if (cls == null || cls.equals(u.class)) {
                g(UseCaseConfigFactory.CaptureType.IMAGE_CAPTURE);
                m(u.class);
                return;
            }
            throw new IllegalArgumentException("Invalid target class configuration for " + this + ": " + cls);
        }
    }

    public static final class c {
        private static final wf2 a;
        private static final androidx.camera.core.impl.p b;
        private static final ie0 c;

        static {
            wf2 wf2VarA = new wf2.a().d(qa.c).f(yf2.c).a();
            a = wf2VarA;
            ie0 ie0Var = ie0.d;
            c = ie0Var;
            b = new b().k(4).l(0).j(wf2VarA).i(0).h(ie0Var).b();
        }

        public androidx.camera.core.impl.p a() {
            return b;
        }
    }

    public static final class d {
        private boolean a;
        private boolean b = false;
        private boolean c;
        private Location d;

        public Location a() {
            return this.d;
        }

        public boolean b() {
            return this.a;
        }

        public boolean c() {
            return this.c;
        }

        public void d(boolean z) {
            this.a = z;
            this.b = true;
        }

        public String toString() {
            return "Metadata{mIsReversedHorizontal=" + this.a + ", mIsReversedVertical=" + this.c + ", mLocation=" + this.d + "}";
        }
    }

    public static abstract class e {
    }

    public interface f {
        default void a(Bitmap bitmap) {
        }

        default void b() {
        }

        void c(h hVar);

        void d(ImageCaptureException imageCaptureException);
    }

    public static final class g {
        private final File a;
        private final ContentResolver b;
        private final Uri c;
        private final ContentValues d;
        private final OutputStream e;
        private final d f;

        g(File file, ContentResolver contentResolver, Uri uri, ContentValues contentValues, OutputStream outputStream, d dVar) {
            this.a = file;
            this.b = contentResolver;
            this.c = uri;
            this.d = contentValues;
            this.e = outputStream;
            this.f = dVar == null ? new d() : dVar;
        }

        public ContentResolver a() {
            return this.b;
        }

        public ContentValues b() {
            return this.d;
        }

        public File c() {
            return this.a;
        }

        public d d() {
            return this.f;
        }

        public OutputStream e() {
            return this.e;
        }

        public Uri f() {
            return this.c;
        }

        public String toString() {
            return "OutputFileOptions{mFile=" + this.a + ", mContentResolver=" + this.b + ", mSaveCollection=" + this.c + ", mContentValues=" + this.d + ", mOutputStream=" + this.e + ", mMetadata=" + this.f + "}";
        }

        public static final class a {
            private File a;
            private ContentResolver b;
            private Uri c;
            private ContentValues d;
            private OutputStream e;
            private d f;

            public a(File file) {
                this.a = file;
            }

            public g a() {
                return new g(this.a, this.b, this.c, this.d, this.e, this.f);
            }

            public a b(d dVar) {
                this.f = dVar;
                return this;
            }

            public a(ContentResolver contentResolver, Uri uri, ContentValues contentValues) {
                this.b = contentResolver;
                this.c = uri;
                this.d = contentValues;
            }
        }
    }

    public static class h {
        private final Uri a;

        public h(Uri uri) {
            this.a = uri;
        }

        public Uri a() {
            return this.a;
        }
    }

    public interface i {
        void a(long j, j jVar);

        void clear();
    }

    public interface j {
        void a();
    }

    u(androidx.camera.core.impl.p pVar) {
        super(pVar);
        this.n = new x01.a() { // from class: pz0
            @Override // x01.a
            public final void a(x01 x01Var) {
                u.r0(x01Var);
            }
        };
        this.p = new AtomicReference(null);
        this.r = -1;
        this.s = null;
        this.x = new a();
        androidx.camera.core.impl.p pVar2 = (androidx.camera.core.impl.p) j();
        if (pVar2.b(androidx.camera.core.impl.p.J)) {
            this.o = pVar2.Z();
        } else {
            this.o = 1;
        }
        this.f157q = pVar2.b0(0);
        this.t = kl2.g(pVar2.f0());
    }

    private void C0(Executor executor, e eVar, f fVar, g gVar) {
        t23.a();
        if (j0() == 3 && this.t.h() == null) {
            throw new IllegalArgumentException("ScreenFlash not set for FLASH_MODE_SCREEN");
        }
        Log.d("ImageCapture", "takePictureInternal");
        CameraInternal cameraInternalG = g();
        if (cameraInternalG == null) {
            v0(executor, eVar, fVar);
            return;
        }
        d03 d03Var = this.w;
        Objects.requireNonNull(d03Var);
        d03Var.j(i03.t(executor, eVar, fVar, gVar, m0(), s(), q(cameraInternalG), k0(), i0(), this.u.s()));
    }

    private void D0() {
        synchronized (this.p) {
            try {
                if (this.p.get() != null) {
                    return;
                }
                h().e(j0());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void b0() {
        this.t.f();
        d03 d03Var = this.w;
        if (d03Var != null) {
            d03Var.e();
        }
    }

    private void d0() {
        e0(false);
    }

    private void e0(boolean z2) {
        d03 d03Var;
        Log.d("ImageCapture", "clearPipeline");
        t23.a();
        r01 r01Var = this.v;
        if (r01Var != null) {
            r01Var.a();
            this.v = null;
        }
        if (z2 || (d03Var = this.w) == null) {
            return;
        }
        d03Var.e();
        this.w = null;
    }

    private SessionConfig.b f0(final String str, final androidx.camera.core.impl.p pVar, final androidx.camera.core.impl.x xVar) {
        t23.a();
        Log.d("ImageCapture", String.format("createPipeline(cameraId: %s, streamSpec: %s)", str, xVar));
        Size sizeE = xVar.e();
        CameraInternal cameraInternalG = g();
        Objects.requireNonNull(cameraInternalG);
        boolean z2 = !cameraInternalG.m() || p0();
        if (this.v != null) {
            b52.i(z2);
            this.v.a();
        }
        if (((Boolean) j().f(androidx.camera.core.impl.p.V, Boolean.FALSE)).booleanValue()) {
            l0();
        }
        l();
        this.v = new r01(pVar, sizeE, null, z2, null, 35);
        if (this.w == null) {
            this.w = new d03(this.x);
        }
        this.w.m(this.v);
        SessionConfig.b bVarF = this.v.f(xVar.e());
        if (i0() == 2) {
            h().a(bVarF);
        }
        if (xVar.d() != null) {
            bVarF.h(xVar.d());
        }
        bVarF.g(new SessionConfig.c() { // from class: nz0
            @Override // androidx.camera.core.impl.SessionConfig.c
            public final void a(SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
                this.a.q0(str, pVar, xVar, sessionConfig, sessionError);
            }
        });
        return bVarF;
    }

    private int h0() {
        CameraInternal cameraInternalG = g();
        if (cameraInternalG != null) {
            return cameraInternalG.a().f();
        }
        return -1;
    }

    private int k0() {
        androidx.camera.core.impl.p pVar = (androidx.camera.core.impl.p) j();
        if (pVar.b(androidx.camera.core.impl.p.S)) {
            return pVar.e0();
        }
        int i2 = this.o;
        if (i2 == 0) {
            return 100;
        }
        if (i2 == 1 || i2 == 2) {
            return 95;
        }
        throw new IllegalStateException("CaptureMode " + this.o + " is invalid");
    }

    private kn2 l0() {
        g().i().X(null);
        return null;
    }

    private Rect m0() {
        Rect rectX = x();
        Size sizeF = f();
        Objects.requireNonNull(sizeF);
        if (rectX != null) {
            return rectX;
        }
        if (!ImageUtil.h(this.s)) {
            return new Rect(0, 0, sizeF.getWidth(), sizeF.getHeight());
        }
        CameraInternal cameraInternalG = g();
        Objects.requireNonNull(cameraInternalG);
        int iQ = q(cameraInternalG);
        Rational rational = new Rational(this.s.getDenominator(), this.s.getNumerator());
        if (!y43.i(iQ)) {
            rational = this.s;
        }
        Rect rectA = ImageUtil.a(sizeF, rational);
        Objects.requireNonNull(rectA);
        return rectA;
    }

    private static boolean n0(List list, int i2) {
        if (list == null) {
            return false;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (((Integer) ((Pair) it.next()).first).equals(Integer.valueOf(i2))) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean o0(androidx.camera.core.impl.s sVar) {
        return Objects.equals(sVar.f(androidx.camera.core.impl.p.N, null), 1);
    }

    private boolean p0() {
        if (g() == null) {
            return false;
        }
        g().i().X(null);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q0(String str, androidx.camera.core.impl.p pVar, androidx.camera.core.impl.x xVar, SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
        if (!y(str)) {
            d0();
            return;
        }
        this.w.k();
        e0(true);
        SessionConfig.b bVarF0 = f0(str, pVar, xVar);
        this.u = bVarF0;
        U(bVarF0.p());
        E();
        this.w.l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void r0(x01 x01Var) {
        try {
            v vVarC = x01Var.c();
            try {
                Log.d("ImageCapture", "Discarding ImageProxy which was inadvertently acquired: " + vVarC);
                if (vVarC != null) {
                    vVarC.close();
                }
            } catch (Throwable th) {
                if (vVarC != null) {
                    try {
                        vVarC.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (IllegalStateException e2) {
            Log.e("ImageCapture", "Failed to acquire latest image.", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Void s0(List list) {
        return null;
    }

    private void v0(Executor executor, e eVar, f fVar) {
        ImageCaptureException imageCaptureException = new ImageCaptureException(4, "Not bound to a valid Camera [" + this + "]", null);
        if (fVar == null) {
            throw new IllegalArgumentException("Must have either in-memory or on-disk callback.");
        }
        fVar.d(imageCaptureException);
    }

    private void y0() {
        z0(this.t);
    }

    private void z0(i iVar) {
        h().g(iVar);
    }

    ub1 A0(List list) {
        t23.a();
        return os0.G(h().b(list, this.o, this.f157q), new wr0() { // from class: qz0
            @Override // defpackage.wr0
            public final Object apply(Object obj) {
                return u.s0((List) obj);
            }
        }, androidx.camera.core.impl.utils.executor.c.b());
    }

    /* JADX INFO: renamed from: B0, reason: merged with bridge method [inline-methods] */
    public void t0(final g gVar, final Executor executor, final f fVar) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            androidx.camera.core.impl.utils.executor.c.e().execute(new Runnable() { // from class: oz0
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.t0(gVar, executor, fVar);
                }
            });
        } else {
            C0(executor, null, fVar, gVar);
        }
    }

    void E0() {
        synchronized (this.p) {
            try {
                Integer num = (Integer) this.p.getAndSet(null);
                if (num == null) {
                    return;
                }
                if (num.intValue() != j0()) {
                    D0();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.camera.core.UseCase
    public void H() {
        b52.h(g(), "Attached camera cannot be null");
        if (j0() == 3 && h0() != 0) {
            throw new IllegalArgumentException("Not a front camera despite setting FLASH_MODE_SCREEN in ImageCapture");
        }
    }

    @Override // androidx.camera.core.UseCase
    public void I() {
        D0();
        y0();
    }

    @Override // androidx.camera.core.UseCase
    protected androidx.camera.core.impl.d0 J(zt ztVar, androidx.camera.core.impl.d0.a aVar) {
        if (ztVar.m().a(xr2.class)) {
            Boolean bool = Boolean.FALSE;
            androidx.camera.core.impl.s sVarA = aVar.a();
            Config.a aVar2 = androidx.camera.core.impl.p.Q;
            Boolean bool2 = Boolean.TRUE;
            if (bool.equals(sVarA.f(aVar2, bool2))) {
                x.k("ImageCapture", "Device quirk suggests software JPEG encoder, but it has been explicitly disabled.");
            } else {
                x.e("ImageCapture", "Requesting software JPEG due to device quirk.");
                aVar.a().x(aVar2, bool2);
            }
        }
        boolean zG0 = g0(aVar.a());
        Integer num = (Integer) aVar.a().f(androidx.camera.core.impl.p.M, null);
        if (num != null) {
            b52.b(!p0() || num.intValue() == 256, "Cannot set non-JPEG buffer format with Extensions enabled.");
            aVar.a().x(androidx.camera.core.impl.q.l, Integer.valueOf(zG0 ? 35 : num.intValue()));
        } else if (o0(aVar.a())) {
            aVar.a().x(androidx.camera.core.impl.q.l, Integer.valueOf(DfuBaseService.ERROR_SERVICE_DISCOVERY_NOT_STARTED));
            aVar.a().x(androidx.camera.core.impl.q.m, ie0.e);
        } else if (zG0) {
            aVar.a().x(androidx.camera.core.impl.q.l, 35);
        } else {
            List list = (List) aVar.a().f(androidx.camera.core.impl.r.u, null);
            if (list == null || n0(list, 256)) {
                aVar.a().x(androidx.camera.core.impl.q.l, 256);
            } else if (n0(list, 35)) {
                aVar.a().x(androidx.camera.core.impl.q.l, 35);
            }
        }
        return aVar.b();
    }

    @Override // androidx.camera.core.UseCase
    public void L() {
        b0();
    }

    @Override // androidx.camera.core.UseCase
    protected androidx.camera.core.impl.x M(Config config) {
        this.u.h(config);
        U(this.u.p());
        return e().f().d(config).a();
    }

    @Override // androidx.camera.core.UseCase
    protected androidx.camera.core.impl.x N(androidx.camera.core.impl.x xVar) {
        SessionConfig.b bVarF0 = f0(i(), (androidx.camera.core.impl.p) j(), xVar);
        this.u = bVarF0;
        U(bVarF0.p());
        C();
        return xVar;
    }

    @Override // androidx.camera.core.UseCase
    public void O() {
        b0();
        d0();
        z0(null);
    }

    boolean g0(androidx.camera.core.impl.s sVar) {
        boolean z2;
        Boolean bool = Boolean.TRUE;
        Config.a aVar = androidx.camera.core.impl.p.Q;
        Boolean bool2 = Boolean.FALSE;
        boolean z3 = false;
        if (bool.equals(sVar.f(aVar, bool2))) {
            if (p0()) {
                x.k("ImageCapture", "Software JPEG cannot be used with Extensions.");
                z2 = false;
            } else {
                z2 = true;
            }
            Integer num = (Integer) sVar.f(androidx.camera.core.impl.p.M, null);
            if (num == null || num.intValue() == 256) {
                z3 = z2;
            } else {
                x.k("ImageCapture", "Software JPEG cannot be used with non-JPEG output buffer format.");
            }
            if (!z3) {
                x.k("ImageCapture", "Unable to support software JPEG. Disabling.");
                sVar.x(aVar, bool2);
            }
        }
        return z3;
    }

    public int i0() {
        return this.o;
    }

    public int j0() {
        int iA0;
        synchronized (this.p) {
            iA0 = this.r;
            if (iA0 == -1) {
                iA0 = ((androidx.camera.core.impl.p) j()).a0(2);
            }
        }
        return iA0;
    }

    @Override // androidx.camera.core.UseCase
    public androidx.camera.core.impl.d0 k(boolean z2, UseCaseConfigFactory useCaseConfigFactory) {
        c cVar = y;
        Config configA = useCaseConfigFactory.a(cVar.a().F(), i0());
        if (z2) {
            configA = Config.I(configA, cVar.a());
        }
        if (configA == null) {
            return null;
        }
        return w(configA).b();
    }

    public String toString() {
        return "ImageCapture:" + o();
    }

    @Override // androidx.camera.core.UseCase
    public Set u() {
        HashSet hashSet = new HashSet();
        hashSet.add(4);
        return hashSet;
    }

    void u0() {
        synchronized (this.p) {
            try {
                if (this.p.get() != null) {
                    return;
                }
                this.p.set(Integer.valueOf(j0()));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.camera.core.UseCase
    public androidx.camera.core.impl.d0.a w(Config config) {
        return b.d(config);
    }

    public void w0(Rational rational) {
        this.s = rational;
    }

    public void x0(int i2) {
        if (i2 != 0 && i2 != 1 && i2 != 2) {
            if (i2 != 3) {
                throw new IllegalArgumentException("Invalid flash mode: " + i2);
            }
            if (this.t.h() == null) {
                throw new IllegalArgumentException("ScreenFlash not set for FLASH_MODE_SCREEN");
            }
            if (g() != null && h0() != 0) {
                throw new IllegalArgumentException("Not a front camera despite setting FLASH_MODE_SCREEN");
            }
        }
        synchronized (this.p) {
            this.r = i2;
            D0();
        }
    }
}
