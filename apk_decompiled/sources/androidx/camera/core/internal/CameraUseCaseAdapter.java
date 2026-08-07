package androidx.camera.core.internal;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.util.Log;
import android.util.Pair;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.d0;
import androidx.camera.core.impl.g;
import androidx.camera.core.impl.p;
import androidx.camera.core.impl.t;
import androidx.camera.core.impl.utils.executor.c;
import androidx.camera.core.impl.v;
import androidx.camera.core.impl.x;
import androidx.camera.core.internal.CameraUseCaseAdapter;
import androidx.camera.core.u;
import defpackage.az0;
import defpackage.b52;
import defpackage.e43;
import defpackage.ev2;
import defpackage.gt;
import defpackage.hh2;
import defpackage.ie0;
import defpackage.ih2;
import defpackage.m03;
import defpackage.n52;
import defpackage.q20;
import defpackage.st;
import defpackage.te3;
import defpackage.tw2;
import defpackage.ve3;
import defpackage.y43;
import defpackage.yt;
import defpackage.zr;
import defpackage.zt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class CameraUseCaseAdapter implements zr {
    private final CameraInternal a;
    private final st b;
    private final UseCaseConfigFactory c;
    private final a d;
    private final gt g;
    private te3 h;
    private final g j;
    private UseCase n;
    private ev2 o;
    private final hh2 p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final ih2 f154q;
    private final List e = new ArrayList();
    private final List f = new ArrayList();
    private List i = Collections.emptyList();
    private final Object k = new Object();
    private boolean l = true;
    private Config m = null;

    public static final class CameraException extends Exception {
        public CameraException() {
        }

        public CameraException(String str) {
            super(str);
        }

        public CameraException(Throwable th) {
            super(th);
        }
    }

    public static abstract class a {
        public static a a(String str, az0 az0Var) {
            return new androidx.camera.core.internal.a(str, az0Var);
        }

        public abstract az0 b();

        public abstract String c();
    }

    private static class b {
        d0 a;
        d0 b;

        b(d0 d0Var, d0 d0Var2) {
            this.a = d0Var;
            this.b = d0Var2;
        }
    }

    public CameraUseCaseAdapter(CameraInternal cameraInternal, ih2 ih2Var, gt gtVar, st stVar, UseCaseConfigFactory useCaseConfigFactory) {
        this.a = cameraInternal;
        this.g = gtVar;
        this.b = stVar;
        this.c = useCaseConfigFactory;
        g gVarP = ih2Var.p();
        this.j = gVarP;
        gVarP.X(null);
        this.p = new hh2(cameraInternal.h(), null);
        this.f154q = ih2Var;
        this.d = z(ih2Var);
    }

    private static d0 A(UseCaseConfigFactory useCaseConfigFactory, ev2 ev2Var) {
        d0 d0VarK = new n52.a().c().k(false, useCaseConfigFactory);
        if (d0VarK == null) {
            return null;
        }
        t tVarD0 = t.d0(d0VarK);
        tVarD0.e0(m03.c);
        return ev2Var.w(tVarD0).b();
    }

    private int C() {
        synchronized (this.k) {
            try {
                return this.g.a() == 2 ? 1 : 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static Map D(Collection collection, UseCaseConfigFactory useCaseConfigFactory, UseCaseConfigFactory useCaseConfigFactory2) {
        HashMap map = new HashMap();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            UseCase useCase = (UseCase) it.next();
            map.put(useCase, new b(ev2.i0(useCase) ? A(useCaseConfigFactory, (ev2) useCase) : useCase.k(false, useCaseConfigFactory), useCase.k(true, useCaseConfigFactory2)));
        }
        return map;
    }

    private int E(boolean z) {
        int i;
        synchronized (this.k) {
            try {
                Iterator it = this.i.iterator();
                if (it.hasNext()) {
                    e43.a(it.next());
                    throw null;
                }
                i = z ? 3 : 0;
            } catch (Throwable th) {
                throw th;
            }
        }
        return i;
    }

    private Set F(Collection collection, boolean z) {
        HashSet hashSet = new HashSet();
        int iE = E(z);
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            UseCase useCase = (UseCase) it.next();
            b52.b(!ev2.i0(useCase), "Only support one level of sharing for now.");
            if (useCase.z(iE)) {
                hashSet.add(useCase);
            }
        }
        return hashSet;
    }

    private boolean H() {
        synchronized (this.k) {
            this.j.X(null);
        }
        return false;
    }

    private static boolean I(x xVar, SessionConfig sessionConfig) {
        Config configD = xVar.d();
        Config configE = sessionConfig.e();
        if (configD.e().size() != sessionConfig.e().e().size()) {
            return true;
        }
        for (Config.a aVar : configD.e()) {
            if (!configE.b(aVar) || !Objects.equals(configE.a(aVar), configD.a(aVar))) {
                return true;
            }
        }
        return false;
    }

    private static boolean J(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (Q(((UseCase) it.next()).j().k())) {
                return true;
            }
        }
        return false;
    }

    private static boolean K(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            UseCase useCase = (UseCase) it.next();
            if (P(useCase)) {
                d0 d0VarJ = useCase.j();
                Config.a aVar = p.N;
                if (d0VarJ.b(aVar) && ((Integer) b52.g((Integer) d0VarJ.a(aVar))).intValue() == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean L(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (T((UseCase) it.next())) {
                return true;
            }
        }
        return false;
    }

    private boolean M() {
        boolean z;
        synchronized (this.k) {
            z = true;
            if (this.j.D() != 1) {
                z = false;
            }
        }
        return z;
    }

    private static boolean N(Collection collection) {
        Iterator it = collection.iterator();
        boolean z = false;
        boolean z2 = false;
        while (it.hasNext()) {
            UseCase useCase = (UseCase) it.next();
            if (R(useCase) || ev2.i0(useCase)) {
                z = true;
            } else if (P(useCase)) {
                z2 = true;
            }
        }
        return z && !z2;
    }

    private static boolean O(Collection collection) {
        Iterator it = collection.iterator();
        boolean z = false;
        boolean z2 = false;
        while (it.hasNext()) {
            UseCase useCase = (UseCase) it.next();
            if (R(useCase) || ev2.i0(useCase)) {
                z2 = true;
            } else if (P(useCase)) {
                z = true;
            }
        }
        return z && !z2;
    }

    private static boolean P(UseCase useCase) {
        return useCase instanceof u;
    }

    private static boolean Q(ie0 ie0Var) {
        return (ie0Var.a() == 10) || (ie0Var.b() != 1 && ie0Var.b() != 0);
    }

    private static boolean R(UseCase useCase) {
        return useCase instanceof n52;
    }

    static boolean S(Collection collection) {
        int[] iArr = {1, 2, 4};
        HashSet hashSet = new HashSet();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            UseCase useCase = (UseCase) it.next();
            for (int i = 0; i < 3; i++) {
                int i2 = iArr[i];
                if (useCase.z(i2)) {
                    if (hashSet.contains(Integer.valueOf(i2))) {
                        return false;
                    }
                    hashSet.add(Integer.valueOf(i2));
                }
            }
        }
        return true;
    }

    private static boolean T(UseCase useCase) {
        if (useCase != null) {
            if (useCase.j().b(d0.F)) {
                return useCase.j().F() == UseCaseConfigFactory.CaptureType.VIDEO_CAPTURE;
            }
            Log.e("CameraUseCaseAdapter", useCase + " UseCase does not have capture type.");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void U(Surface surface, SurfaceTexture surfaceTexture, SurfaceRequest.f fVar) {
        surface.release();
        surfaceTexture.release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void V(SurfaceRequest surfaceRequest) {
        final SurfaceTexture surfaceTexture = new SurfaceTexture(0);
        surfaceTexture.setDefaultBufferSize(surfaceRequest.o().getWidth(), surfaceRequest.o().getHeight());
        surfaceTexture.detachFromGLContext();
        final Surface surface = new Surface(surfaceTexture);
        surfaceRequest.B(surface, c.b(), new q20() { // from class: zu
            @Override // defpackage.q20
            public final void accept(Object obj) {
                CameraUseCaseAdapter.U(surface, surfaceTexture, (SurfaceRequest.f) obj);
            }
        });
    }

    private void X() {
        synchronized (this.k) {
            try {
                if (this.m != null) {
                    this.a.h().c(this.m);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static List Z(List list, Collection collection) {
        ArrayList arrayList = new ArrayList(list);
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            ((UseCase) it.next()).Q(null);
            Iterator it2 = list.iterator();
            if (it2.hasNext()) {
                e43.a(it2.next());
                throw null;
            }
        }
        return arrayList;
    }

    static void b0(List list, Collection collection, Collection collection2) {
        List listZ = Z(list, collection);
        ArrayList arrayList = new ArrayList(collection2);
        arrayList.removeAll(collection);
        List listZ2 = Z(listZ, arrayList);
        if (listZ2.size() > 0) {
            androidx.camera.core.x.k("CameraUseCaseAdapter", "Unused effects: " + listZ2);
        }
    }

    private void e0(Map map, Collection collection) {
        synchronized (this.k) {
            try {
                if (this.h != null && !collection.isEmpty()) {
                    Map mapA = ve3.a(this.a.h().d(), this.a.n().f() == 0, this.h.a(), this.a.n().k(this.h.c()), this.h.d(), this.h.b(), map);
                    Iterator it = collection.iterator();
                    while (it.hasNext()) {
                        UseCase useCase = (UseCase) it.next();
                        useCase.S((Rect) b52.g((Rect) mapA.get(useCase)));
                        useCase.R(s(this.a.h().d(), ((x) b52.g((x) map.get(useCase))).e()));
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void p() {
        synchronized (this.k) {
            CameraControlInternal cameraControlInternalH = this.a.h();
            this.m = cameraControlInternalH.f();
            cameraControlInternalH.h();
        }
    }

    static Collection q(Collection collection, UseCase useCase, ev2 ev2Var) {
        ArrayList arrayList = new ArrayList(collection);
        if (useCase != null) {
            arrayList.add(useCase);
        }
        if (ev2Var != null) {
            arrayList.add(ev2Var);
            arrayList.removeAll(ev2Var.d0());
        }
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0049  */
    private UseCase r(Collection collection, ev2 ev2Var) {
        UseCase useCaseV;
        synchronized (this.k) {
            try {
                ArrayList arrayList = new ArrayList(collection);
                if (ev2Var != null) {
                    arrayList.add(ev2Var);
                    arrayList.removeAll(ev2Var.d0());
                }
                if (!M()) {
                    useCaseV = null;
                } else if (O(arrayList)) {
                    useCaseV = R(this.n) ? this.n : w();
                } else if (N(arrayList)) {
                    useCaseV = P(this.n) ? this.n : v();
                } else {
                    useCaseV = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return useCaseV;
    }

    private static Matrix s(Rect rect, Size size) {
        b52.b(rect.width() > 0 && rect.height() > 0, "Cannot compute viewport crop rects zero sized sensor rect.");
        RectF rectF = new RectF(rect);
        Matrix matrix = new Matrix();
        matrix.setRectToRect(new RectF(0.0f, 0.0f, size.getWidth(), size.getHeight()), rectF, Matrix.ScaleToFit.CENTER);
        matrix.invert(matrix);
        return matrix;
    }

    private Map t(int i, zt ztVar, Collection collection, Collection collection2, Map map) {
        Rect rectD;
        tw2 tw2Var;
        Iterator it;
        boolean z;
        ArrayList arrayList = new ArrayList();
        String strD = ztVar.d();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        Iterator it2 = collection2.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            UseCase useCase = (UseCase) it2.next();
            androidx.camera.core.impl.a aVarA = androidx.camera.core.impl.a.a(this.b.b(i, strD, useCase.m(), useCase.f()), useCase.m(), useCase.f(), ((x) b52.g(useCase.e())).b(), ev2.c0(useCase), useCase.e().d(), useCase.j().J(null));
            arrayList.add(aVarA);
            map3.put(aVarA, useCase);
            map2.put(useCase, useCase.e());
        }
        if (!collection.isEmpty()) {
            HashMap map4 = new HashMap();
            HashMap map5 = new HashMap();
            try {
                rectD = this.a.h().d();
                loop1: while (true) {
                    z = false;
                    while (true) {
                        if (!it.hasNext()) {
                            break loop1;
                        }
                        UseCase useCase2 = (UseCase) it.next();
                        b bVar = (b) map.get(useCase2);
                        d0 d0VarB = useCase2.B(ztVar, bVar.a, bVar.b);
                        map4.put(d0VarB, useCase2);
                        map5.put(d0VarB, tw2Var.m(d0VarB));
                        if (useCase2.j() instanceof v) {
                            if (((v) useCase2.j()).P() == 2) {
                                z = true;
                            }
                        }
                    }
                }
            } catch (NullPointerException unused) {
                rectD = null;
            }
            tw2Var = new tw2(ztVar, rectD != null ? y43.m(rectD) : null);
            it = collection.iterator();
            Pair pairA = this.b.a(i, strD, arrayList, map5, z);
            for (Map.Entry entry : map4.entrySet()) {
                map2.put((UseCase) entry.getValue(), (x) ((Map) pairA.first).get(entry.getKey()));
            }
            for (Map.Entry entry2 : ((Map) pairA.second).entrySet()) {
                if (map3.containsKey(entry2.getKey())) {
                    map2.put((UseCase) map3.get(entry2.getKey()), (x) entry2.getValue());
                }
            }
        }
        return map2;
    }

    private void u(Collection collection) {
        if (H() && J(collection)) {
            throw new IllegalArgumentException("Extensions are only supported for use with standard dynamic range.");
        }
        synchronized (this.k) {
            try {
                if (!this.i.isEmpty() && K(collection)) {
                    throw new IllegalArgumentException("Ultra HDR image capture does not support for use with CameraEffect.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private u v() {
        return new u.b().n("ImageCapture-Extra").c();
    }

    private n52 w() {
        n52 n52VarC = new n52.a().l("Preview-Extra").c();
        n52VarC.h0(new n52.c() { // from class: yu
            @Override // n52.c
            public final void a(SurfaceRequest surfaceRequest) {
                CameraUseCaseAdapter.V(surfaceRequest);
            }
        });
        return n52VarC;
    }

    private ev2 x(Collection collection, boolean z) {
        synchronized (this.k) {
            try {
                Set setF = F(collection, z);
                if (setF.size() >= 2 || (H() && L(setF))) {
                    ev2 ev2Var = this.o;
                    if (ev2Var != null && ev2Var.d0().equals(setF)) {
                        ev2 ev2Var2 = this.o;
                        Objects.requireNonNull(ev2Var2);
                        return ev2Var2;
                    }
                    if (!S(setF)) {
                        return null;
                    }
                    return new ev2(this.a, setF, this.c);
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static a z(ih2 ih2Var) {
        return a.a(ih2Var.d(), ih2Var.p().Q());
    }

    public a B() {
        return this.d;
    }

    public List G() {
        ArrayList arrayList;
        synchronized (this.k) {
            arrayList = new ArrayList(this.e);
        }
        return arrayList;
    }

    public void W(Collection collection) {
        synchronized (this.k) {
            LinkedHashSet linkedHashSet = new LinkedHashSet(this.e);
            linkedHashSet.removeAll(collection);
            c0(linkedHashSet);
        }
    }

    public void Y(List list) {
        synchronized (this.k) {
            this.i = list;
        }
    }

    @Override // defpackage.zr
    public yt a() {
        return this.f154q;
    }

    public void a0(te3 te3Var) {
        synchronized (this.k) {
            this.h = te3Var;
        }
    }

    void c0(Collection collection) {
        d0(collection, false);
    }

    void d0(Collection collection, boolean z) {
        x xVar;
        Config configD;
        synchronized (this.k) {
            try {
                u(collection);
                if (!z && H() && L(collection)) {
                    d0(collection, true);
                    return;
                }
                ev2 ev2VarX = x(collection, z);
                UseCase useCaseR = r(collection, ev2VarX);
                Collection collectionQ = q(collection, useCaseR, ev2VarX);
                ArrayList<UseCase> arrayList = new ArrayList(collectionQ);
                arrayList.removeAll(this.f);
                ArrayList<UseCase> arrayList2 = new ArrayList(collectionQ);
                arrayList2.retainAll(this.f);
                ArrayList arrayList3 = new ArrayList(this.f);
                arrayList3.removeAll(collectionQ);
                Map mapD = D(arrayList, this.j.j(), this.c);
                try {
                    Map map = mapD;
                    Map mapT = t(C(), this.a.n(), arrayList, arrayList2, mapD);
                    e0(mapT, collectionQ);
                    b0(this.i, collectionQ, collection);
                    Iterator it = arrayList3.iterator();
                    while (it.hasNext()) {
                        ((UseCase) it.next()).T(this.a);
                    }
                    this.a.l(arrayList3);
                    if (!arrayList3.isEmpty()) {
                        for (UseCase useCase : arrayList2) {
                            if (mapT.containsKey(useCase) && (configD = (xVar = (x) mapT.get(useCase)).d()) != null && I(xVar, useCase.t())) {
                                useCase.W(configD);
                            }
                        }
                    }
                    for (UseCase useCase2 : arrayList) {
                        Map map2 = map;
                        b bVar = (b) map2.get(useCase2);
                        Objects.requireNonNull(bVar);
                        useCase2.b(this.a, bVar.a, bVar.b);
                        useCase2.V((x) b52.g((x) mapT.get(useCase2)));
                        map = map2;
                    }
                    if (this.l) {
                        this.a.k(arrayList);
                    }
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        ((UseCase) it2.next()).F();
                    }
                    this.e.clear();
                    this.e.addAll(collection);
                    this.f.clear();
                    this.f.addAll(collectionQ);
                    this.n = useCaseR;
                    this.o = ev2VarX;
                } catch (IllegalArgumentException e) {
                    if (z || H() || this.g.a() == 2) {
                        throw e;
                    }
                    d0(collection, true);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void f(Collection collection) {
        synchronized (this.k) {
            try {
                this.a.e(this.j);
                LinkedHashSet linkedHashSet = new LinkedHashSet(this.e);
                linkedHashSet.addAll(collection);
                try {
                    c0(linkedHashSet);
                } catch (IllegalArgumentException e) {
                    throw new CameraException(e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void j(boolean z) {
        this.a.j(z);
    }

    public void o() {
        synchronized (this.k) {
            try {
                if (!this.l) {
                    if (!this.f.isEmpty()) {
                        this.a.e(this.j);
                    }
                    this.a.k(this.f);
                    X();
                    Iterator it = this.f.iterator();
                    while (it.hasNext()) {
                        ((UseCase) it.next()).F();
                    }
                    this.l = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void y() {
        synchronized (this.k) {
            try {
                if (this.l) {
                    this.a.l(new ArrayList(this.f));
                    p();
                    this.l = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
