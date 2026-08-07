package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.DynamicRangeProfiles;
import android.os.Build;
import android.view.Surface;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.SessionConfig;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import defpackage.ab;
import defpackage.as;
import defpackage.b52;
import defpackage.bs0;
import defpackage.cs0;
import defpackage.dw;
import defpackage.ie0;
import defpackage.jn2;
import defpackage.k43;
import defpackage.ke0;
import defpackage.m13;
import defpackage.mu2;
import defpackage.nf2;
import defpackage.o21;
import defpackage.os0;
import defpackage.re0;
import defpackage.ub1;
import defpackage.w92;
import defpackage.yr;
import defpackage.zx1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes.dex */
final class CaptureSession implements x1 {
    final Object a;
    private final List b;
    private final c c;
    t2.a d;
    t2 e;
    SessionConfig f;
    private final Map g;
    List h;
    State i;
    ub1 j;
    CallbackToFutureAdapter.a k;
    private Map l;
    private final mu2 m;
    private final k43 n;
    private final nf2 o;
    private final re0 p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final m13 f148q;

    enum State {
        UNINITIALIZED,
        INITIALIZED,
        GET_SURFACE,
        OPENING,
        OPENED,
        CLOSED,
        RELEASING,
        RELEASED
    }

    class a implements bs0 {
        a() {
        }

        @Override // defpackage.bs0
        public void a(Throwable th) {
            synchronized (CaptureSession.this.a) {
                try {
                    CaptureSession.this.d.stop();
                    int iOrdinal = CaptureSession.this.i.ordinal();
                    if ((iOrdinal == 3 || iOrdinal == 5 || iOrdinal == 6) && !(th instanceof CancellationException)) {
                        androidx.camera.core.x.l("CaptureSession", "Opening session with fail " + CaptureSession.this.i, th);
                        CaptureSession.this.p();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // defpackage.bs0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Void r1) {
        }
    }

    class b extends CameraCaptureSession.CaptureCallback {
        b() {
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
            synchronized (CaptureSession.this.a) {
                try {
                    SessionConfig sessionConfig = CaptureSession.this.f;
                    if (sessionConfig == null) {
                        return;
                    }
                    androidx.camera.core.impl.k kVarI = sessionConfig.i();
                    androidx.camera.core.x.a("CaptureSession", "Submit FLASH_MODE_OFF request");
                    CaptureSession captureSession = CaptureSession.this;
                    captureSession.e(Collections.singletonList(captureSession.n.a(kVarI)));
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    final class c extends t2.c {
        c() {
        }

        @Override // androidx.camera.camera2.internal.t2.c
        public void r(t2 t2Var) {
            synchronized (CaptureSession.this.a) {
                try {
                    switch (CaptureSession.this.i) {
                        case UNINITIALIZED:
                        case INITIALIZED:
                        case GET_SURFACE:
                        case OPENED:
                            throw new IllegalStateException("onConfigureFailed() should not be possible in state: " + CaptureSession.this.i);
                        case OPENING:
                        case CLOSED:
                        case RELEASING:
                            CaptureSession.this.p();
                            break;
                        case RELEASED:
                            androidx.camera.core.x.a("CaptureSession", "ConfigureFailed callback after change to RELEASED state");
                            break;
                    }
                    androidx.camera.core.x.c("CaptureSession", "CameraCaptureSession.onConfigureFailed() " + CaptureSession.this.i);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // androidx.camera.camera2.internal.t2.c
        public void s(t2 t2Var) {
            synchronized (CaptureSession.this.a) {
                try {
                    switch (CaptureSession.this.i) {
                        case UNINITIALIZED:
                        case INITIALIZED:
                        case GET_SURFACE:
                        case OPENED:
                        case RELEASED:
                            throw new IllegalStateException("onConfigured() should not be possible in state: " + CaptureSession.this.i);
                        case OPENING:
                            CaptureSession captureSession = CaptureSession.this;
                            captureSession.i = State.OPENED;
                            captureSession.e = t2Var;
                            androidx.camera.core.x.a("CaptureSession", "Attempting to send capture request onConfigured");
                            CaptureSession captureSession2 = CaptureSession.this;
                            captureSession2.u(captureSession2.f);
                            CaptureSession.this.t();
                            break;
                        case CLOSED:
                            CaptureSession.this.e = t2Var;
                            break;
                        case RELEASING:
                            t2Var.close();
                            break;
                    }
                    androidx.camera.core.x.a("CaptureSession", "CameraCaptureSession.onConfigured() mState=" + CaptureSession.this.i);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // androidx.camera.camera2.internal.t2.c
        public void t(t2 t2Var) {
            synchronized (CaptureSession.this.a) {
                try {
                    if (CaptureSession.this.i.ordinal() == 0) {
                        throw new IllegalStateException("onReady() should not be possible in state: " + CaptureSession.this.i);
                    }
                    androidx.camera.core.x.a("CaptureSession", "CameraCaptureSession.onReady() " + CaptureSession.this.i);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // androidx.camera.camera2.internal.t2.c
        public void u(t2 t2Var) {
            synchronized (CaptureSession.this.a) {
                try {
                    if (CaptureSession.this.i == State.UNINITIALIZED) {
                        throw new IllegalStateException("onSessionFinished() should not be possible in state: " + CaptureSession.this.i);
                    }
                    androidx.camera.core.x.a("CaptureSession", "onSessionFinished()");
                    CaptureSession.this.p();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    CaptureSession(re0 re0Var) {
        this(re0Var, null);
    }

    private CameraCaptureSession.CaptureCallback o(List list, CameraCaptureSession.CaptureCallback... captureCallbackArr) {
        ArrayList arrayList = new ArrayList(list.size() + captureCallbackArr.length);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(s1.a((as) it.next()));
        }
        Collections.addAll(arrayList, captureCallbackArr);
        return e0.a(arrayList);
    }

    private zx1 q(SessionConfig.e eVar, Map map, String str) {
        long jLongValue;
        DynamicRangeProfiles dynamicRangeProfilesD;
        Surface surface = (Surface) map.get(eVar.f());
        b52.h(surface, "Surface in OutputConfig not found in configuredSurfaceMap.");
        zx1 zx1Var = new zx1(eVar.g(), surface);
        if (str != null) {
            zx1Var.g(str);
        } else {
            zx1Var.g(eVar.d());
        }
        if (eVar.c() == 0) {
            zx1Var.f(1);
        } else if (eVar.c() == 1) {
            zx1Var.f(2);
        }
        if (!eVar.e().isEmpty()) {
            zx1Var.b();
            Iterator it = eVar.e().iterator();
            while (it.hasNext()) {
                Surface surface2 = (Surface) map.get((DeferrableSurface) it.next());
                b52.h(surface2, "Surface in OutputConfig not found in configuredSurfaceMap.");
                zx1Var.a(surface2);
            }
        }
        if (Build.VERSION.SDK_INT < 33 || (dynamicRangeProfilesD = this.p.d()) == null) {
            jLongValue = 1;
        } else {
            ie0 ie0VarB = eVar.b();
            Long lA = ke0.a(ie0VarB, dynamicRangeProfilesD);
            if (lA == null) {
                androidx.camera.core.x.c("CaptureSession", "Requested dynamic range is not supported. Defaulting to STANDARD dynamic range profile.\nRequested dynamic range:\n  " + ie0VarB);
                jLongValue = 1;
            } else {
                jLongValue = lA.longValue();
            }
        }
        zx1Var.e(jLongValue);
        return zx1Var;
    }

    private List r(List list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zx1 zx1Var = (zx1) it.next();
            if (!arrayList.contains(zx1Var.d())) {
                arrayList.add(zx1Var.d());
                arrayList2.add(zx1Var);
            }
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(CameraCaptureSession cameraCaptureSession, int i, boolean z) {
        synchronized (this.a) {
            try {
                if (this.i == State.OPENED) {
                    u(this.f);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w() {
        synchronized (this.a) {
            if (this.b.isEmpty()) {
                return;
            }
            try {
                s(this.b);
                this.b.clear();
            } catch (Throwable th) {
                this.b.clear();
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object y(CallbackToFutureAdapter.a aVar) {
        String str;
        synchronized (this.a) {
            b52.j(this.k == null, "Release completer expected to be null");
            this.k = aVar;
            str = "Release[session=" + this + "]";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public ub1 x(List list, SessionConfig sessionConfig, CameraDevice cameraDevice) {
        synchronized (this.a) {
            try {
                int iOrdinal = this.i.ordinal();
                if (iOrdinal != 0 && iOrdinal != 1) {
                    if (iOrdinal == 2) {
                        this.g.clear();
                        for (int i = 0; i < list.size(); i++) {
                            this.g.put((DeferrableSurface) this.h.get(i), (Surface) list.get(i));
                        }
                        this.i = State.OPENING;
                        androidx.camera.core.x.a("CaptureSession", "Opening capture session.");
                        t2.c cVarW = e3.w(this.c, new e3.a(sessionConfig.j()));
                        yr yrVar = new yr(sessionConfig.e());
                        androidx.camera.core.impl.k.a aVarK = androidx.camera.core.impl.k.a.k(sessionConfig.i());
                        ArrayList arrayList = new ArrayList();
                        String strC0 = yrVar.c0(null);
                        for (SessionConfig.e eVar : sessionConfig.g()) {
                            zx1 zx1VarQ = q(eVar, this.g, strC0);
                            if (this.l.containsKey(eVar.f())) {
                                zx1VarQ.h(((Long) this.l.get(eVar.f())).longValue());
                            }
                            arrayList.add(zx1VarQ);
                        }
                        jn2 jn2VarK = this.d.k(sessionConfig.k(), r(arrayList), cVarW);
                        if (sessionConfig.n() == 5 && sessionConfig.f() != null) {
                            jn2VarK.f(o21.b(sessionConfig.f()));
                        }
                        try {
                            CaptureRequest captureRequestF = j1.f(aVarK.h(), cameraDevice, this.f148q);
                            if (captureRequestF != null) {
                                jn2VarK.g(captureRequestF);
                            }
                            return this.d.j(cameraDevice, jn2VarK, this.h);
                        } catch (CameraAccessException e) {
                            return os0.n(e);
                        }
                    }
                    if (iOrdinal != 4) {
                        return os0.n(new CancellationException("openCaptureSession() not execute in state: " + this.i));
                    }
                }
                return os0.n(new IllegalStateException("openCaptureSession() should not be possible in state: " + this.i));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.camera.camera2.internal.x1
    public void a() {
        ArrayList<androidx.camera.core.impl.k> arrayList;
        synchronized (this.a) {
            try {
                if (this.b.isEmpty()) {
                    arrayList = null;
                } else {
                    arrayList = new ArrayList(this.b);
                    this.b.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (arrayList != null) {
            for (androidx.camera.core.impl.k kVar : arrayList) {
                Iterator it = kVar.c().iterator();
                while (it.hasNext()) {
                    ((as) it.next()).a(kVar.f());
                }
            }
        }
    }

    @Override // androidx.camera.camera2.internal.x1
    public ub1 b(final SessionConfig sessionConfig, final CameraDevice cameraDevice, t2.a aVar) {
        synchronized (this.a) {
            try {
                if (this.i.ordinal() == 1) {
                    this.i = State.GET_SURFACE;
                    ArrayList arrayList = new ArrayList(sessionConfig.m());
                    this.h = arrayList;
                    this.d = aVar;
                    cs0 cs0VarF = cs0.b(aVar.m(arrayList, 5000L)).f(new ab() { // from class: androidx.camera.camera2.internal.u1
                        @Override // defpackage.ab
                        public final ub1 apply(Object obj) {
                            return this.a.x(sessionConfig, cameraDevice, (List) obj);
                        }
                    }, this.d.b());
                    os0.j(cs0VarF, new a(), this.d.b());
                    return os0.B(cs0VarF);
                }
                androidx.camera.core.x.c("CaptureSession", "Open not allowed in state: " + this.i);
                return os0.n(new IllegalStateException("open() should not allow the state: " + this.i));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.camera.camera2.internal.x1
    public ub1 c(boolean z) {
        synchronized (this.a) {
            switch (this.i) {
                case UNINITIALIZED:
                    throw new IllegalStateException("release() should not be possible in state: " + this.i);
                case GET_SURFACE:
                    b52.h(this.d, "The Opener shouldn't null in state:" + this.i);
                    this.d.stop();
                case INITIALIZED:
                    this.i = State.RELEASED;
                    return os0.p(null);
                case OPENED:
                case CLOSED:
                    t2 t2Var = this.e;
                    if (t2Var != null) {
                        if (z) {
                            try {
                                t2Var.g();
                            } catch (CameraAccessException e) {
                                androidx.camera.core.x.d("CaptureSession", "Unable to abort captures.", e);
                            }
                        }
                        this.e.close();
                        break;
                    }
                case OPENING:
                    this.i = State.RELEASING;
                    this.o.i();
                    b52.h(this.d, "The Opener shouldn't null in state:" + this.i);
                    if (this.d.stop()) {
                        p();
                        return os0.p(null);
                    }
                case RELEASING:
                    if (this.j == null) {
                        this.j = CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: androidx.camera.camera2.internal.t1
                            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
                            public final Object a(CallbackToFutureAdapter.a aVar) {
                                return this.a.y(aVar);
                            }
                        });
                    }
                    return this.j;
                default:
                    return os0.p(null);
            }
        }
    }

    @Override // androidx.camera.camera2.internal.x1
    public void close() {
        synchronized (this.a) {
            try {
                int iOrdinal = this.i.ordinal();
                if (iOrdinal == 0) {
                    throw new IllegalStateException("close() should not be possible in state: " + this.i);
                }
                if (iOrdinal == 1) {
                    this.i = State.RELEASED;
                } else if (iOrdinal == 2) {
                    b52.h(this.d, "The Opener shouldn't null in state:" + this.i);
                    this.d.stop();
                    this.i = State.RELEASED;
                } else if (iOrdinal == 3 || iOrdinal == 4) {
                    b52.h(this.d, "The Opener shouldn't null in state:" + this.i);
                    this.d.stop();
                    this.i = State.CLOSED;
                    this.o.i();
                    this.f = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.camera.camera2.internal.x1
    public List d() {
        List listUnmodifiableList;
        synchronized (this.a) {
            listUnmodifiableList = Collections.unmodifiableList(this.b);
        }
        return listUnmodifiableList;
    }

    @Override // androidx.camera.camera2.internal.x1
    public void e(List list) {
        synchronized (this.a) {
            try {
                switch (this.i) {
                    case UNINITIALIZED:
                        throw new IllegalStateException("issueCaptureRequests() should not be possible in state: " + this.i);
                    case INITIALIZED:
                    case GET_SURFACE:
                    case OPENING:
                        this.b.addAll(list);
                        break;
                    case OPENED:
                        this.b.addAll(list);
                        t();
                        break;
                    case CLOSED:
                    case RELEASING:
                    case RELEASED:
                        throw new IllegalStateException("Cannot issue capture request on a closed/released session.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.camera.camera2.internal.x1
    public SessionConfig f() {
        SessionConfig sessionConfig;
        synchronized (this.a) {
            sessionConfig = this.f;
        }
        return sessionConfig;
    }

    @Override // androidx.camera.camera2.internal.x1
    public void g(SessionConfig sessionConfig) {
        synchronized (this.a) {
            try {
                switch (this.i) {
                    case UNINITIALIZED:
                        throw new IllegalStateException("setSessionConfig() should not be possible in state: " + this.i);
                    case INITIALIZED:
                    case GET_SURFACE:
                    case OPENING:
                        this.f = sessionConfig;
                        break;
                    case OPENED:
                        this.f = sessionConfig;
                        if (sessionConfig == null) {
                            return;
                        }
                        if (!this.g.keySet().containsAll(sessionConfig.m())) {
                            androidx.camera.core.x.c("CaptureSession", "Does not have the proper configured lists");
                            return;
                        } else {
                            androidx.camera.core.x.a("CaptureSession", "Attempting to submit CaptureRequest after setting");
                            u(this.f);
                        }
                        break;
                    case CLOSED:
                    case RELEASING:
                    case RELEASED:
                        throw new IllegalStateException("Session configuration cannot be set on a closed/released session.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.camera.camera2.internal.x1
    public boolean h() {
        boolean z;
        synchronized (this.a) {
            try {
                State state = this.i;
                z = state == State.OPENED || state == State.OPENING;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    @Override // androidx.camera.camera2.internal.x1
    public void i(Map map) {
        synchronized (this.a) {
            this.l = map;
        }
    }

    void p() {
        State state = this.i;
        State state2 = State.RELEASED;
        if (state == state2) {
            androidx.camera.core.x.a("CaptureSession", "Skipping finishClose due to being state RELEASED.");
            return;
        }
        this.i = state2;
        this.e = null;
        CallbackToFutureAdapter.a aVar = this.k;
        if (aVar != null) {
            aVar.c(null);
            this.k = null;
        }
    }

    int s(List list) {
        synchronized (this.a) {
            try {
                if (this.i != State.OPENED) {
                    androidx.camera.core.x.a("CaptureSession", "Skipping issueBurstCaptureRequest due to session closed");
                    return -1;
                }
                if (list.isEmpty()) {
                    return -1;
                }
                try {
                    n1 n1Var = new n1();
                    ArrayList arrayList = new ArrayList();
                    androidx.camera.core.x.a("CaptureSession", "Issuing capture request.");
                    Iterator it = list.iterator();
                    boolean z = false;
                    while (it.hasNext()) {
                        androidx.camera.core.impl.k kVar = (androidx.camera.core.impl.k) it.next();
                        if (!kVar.i().isEmpty()) {
                            Iterator it2 = kVar.i().iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    if (kVar.k() == 2) {
                                        z = true;
                                    }
                                    androidx.camera.core.impl.k.a aVarK = androidx.camera.core.impl.k.a.k(kVar);
                                    if (kVar.k() == 5 && kVar.d() != null) {
                                        aVarK.p(kVar.d());
                                    }
                                    SessionConfig sessionConfig = this.f;
                                    if (sessionConfig != null) {
                                        aVarK.e(sessionConfig.i().g());
                                    }
                                    aVarK.e(kVar.g());
                                    CaptureRequest captureRequestE = j1.e(aVarK.h(), this.e.h(), this.g, false, this.f148q);
                                    if (captureRequestE != null) {
                                        ArrayList arrayList2 = new ArrayList();
                                        Iterator it3 = kVar.c().iterator();
                                        while (it3.hasNext()) {
                                            s1.b((as) it3.next(), arrayList2);
                                        }
                                        n1Var.a(captureRequestE, arrayList2);
                                        arrayList.add(captureRequestE);
                                        break;
                                    }
                                    androidx.camera.core.x.a("CaptureSession", "Skipping issuing request without surface.");
                                    return -1;
                                }
                                DeferrableSurface deferrableSurface = (DeferrableSurface) it2.next();
                                if (!this.g.containsKey(deferrableSurface)) {
                                    androidx.camera.core.x.a("CaptureSession", "Skipping capture request with invalid surface: " + deferrableSurface);
                                    break;
                                }
                            }
                        } else {
                            androidx.camera.core.x.a("CaptureSession", "Skipping issuing empty capture request.");
                        }
                    }
                    if (arrayList.isEmpty()) {
                        androidx.camera.core.x.a("CaptureSession", "Skipping issuing burst request due to no valid request elements");
                        return -1;
                    }
                    if (this.m.a(arrayList, z)) {
                        this.e.l();
                        n1Var.c(new n1.a() { // from class: androidx.camera.camera2.internal.w1
                            @Override // androidx.camera.camera2.internal.n1.a
                            public final void a(CameraCaptureSession cameraCaptureSession, int i, boolean z2) {
                                this.a.v(cameraCaptureSession, i, z2);
                            }
                        });
                    }
                    if (this.n.b(arrayList, z)) {
                        n1Var.a((CaptureRequest) arrayList.get(arrayList.size() - 1), Collections.singletonList(new b()));
                    }
                    return this.e.d(arrayList, n1Var);
                } catch (CameraAccessException e) {
                    androidx.camera.core.x.c("CaptureSession", "Unable to access camera: " + e.getMessage());
                    Thread.dumpStack();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void t() {
        this.o.e().a(new Runnable() { // from class: androidx.camera.camera2.internal.v1
            @Override // java.lang.Runnable
            public final void run() {
                this.a.w();
            }
        }, androidx.camera.core.impl.utils.executor.c.b());
    }

    int u(SessionConfig sessionConfig) {
        synchronized (this.a) {
            try {
                if (sessionConfig == null) {
                    androidx.camera.core.x.a("CaptureSession", "Skipping issueRepeatingCaptureRequests for no configuration case.");
                    return -1;
                }
                if (this.i != State.OPENED) {
                    androidx.camera.core.x.a("CaptureSession", "Skipping issueRepeatingCaptureRequests due to session closed");
                    return -1;
                }
                androidx.camera.core.impl.k kVarI = sessionConfig.i();
                if (kVarI.i().isEmpty()) {
                    androidx.camera.core.x.a("CaptureSession", "Skipping issueRepeatingCaptureRequests for no surface.");
                    try {
                        this.e.l();
                    } catch (CameraAccessException e) {
                        androidx.camera.core.x.c("CaptureSession", "Unable to access camera: " + e.getMessage());
                        Thread.dumpStack();
                    }
                    return -1;
                }
                try {
                    androidx.camera.core.x.a("CaptureSession", "Issuing request for session.");
                    CaptureRequest captureRequestE = j1.e(kVarI, this.e.h(), this.g, true, this.f148q);
                    if (captureRequestE == null) {
                        androidx.camera.core.x.a("CaptureSession", "Skipping issuing empty request for session.");
                        return -1;
                    }
                    return this.e.i(captureRequestE, this.o.d(o(kVarI.c(), new CameraCaptureSession.CaptureCallback[0])));
                } catch (CameraAccessException e2) {
                    androidx.camera.core.x.c("CaptureSession", "Unable to access camera: " + e2.getMessage());
                    Thread.dumpStack();
                    return -1;
                }
                throw th;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    CaptureSession(re0 re0Var, w92 w92Var) {
        this.a = new Object();
        this.b = new ArrayList();
        this.g = new HashMap();
        this.h = Collections.emptyList();
        this.i = State.UNINITIALIZED;
        this.l = new HashMap();
        this.m = new mu2();
        this.n = new k43();
        this.i = State.INITIALIZED;
        this.p = re0Var;
        this.c = new c();
        this.o = new nf2(w92Var != null && w92Var.a(dw.class));
        this.f148q = new m13(w92Var);
    }
}
