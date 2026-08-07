package androidx.camera.core.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class c0 {
    private final String a;
    private final Map b = new LinkedHashMap();

    /* JADX INFO: Access modifiers changed from: private */
    interface a {
        boolean a(b bVar);
    }

    public static final class b {
        private final SessionConfig a;
        private final d0 b;
        private final x c;
        private final List d;
        private boolean e = false;
        private boolean f = false;

        b(SessionConfig sessionConfig, d0 d0Var, x xVar, List list) {
            this.a = sessionConfig;
            this.b = d0Var;
            this.c = xVar;
            this.d = list;
        }

        boolean a() {
            return this.f;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean b() {
            return this.e;
        }

        public List c() {
            return this.d;
        }

        public SessionConfig d() {
            return this.a;
        }

        public x e() {
            return this.c;
        }

        public d0 f() {
            return this.b;
        }

        void g(boolean z) {
            this.f = z;
        }

        void h(boolean z) {
            this.e = z;
        }

        public String toString() {
            return "UseCaseAttachInfo{mSessionConfig=" + this.a + ", mUseCaseConfig=" + this.b + ", mStreamSpec=" + this.c + ", mCaptureTypes=" + this.d + ", mAttached=" + this.e + ", mActive=" + this.f + '}';
        }
    }

    public c0(String str) {
        this.a = str;
    }

    private b k(String str, SessionConfig sessionConfig, d0 d0Var, x xVar, List list) {
        b bVar = (b) this.b.get(str);
        if (bVar != null) {
            return bVar;
        }
        b bVar2 = new b(sessionConfig, d0Var, xVar, list);
        this.b.put(str, bVar2);
        return bVar2;
    }

    private Collection l(a aVar) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : this.b.entrySet()) {
            if (aVar == null || aVar.a((b) entry.getValue())) {
                arrayList.add(((b) entry.getValue()).d());
            }
        }
        return arrayList;
    }

    private Collection m(a aVar) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : this.b.entrySet()) {
            if (aVar == null || aVar.a((b) entry.getValue())) {
                arrayList.add(((b) entry.getValue()).f());
            }
        }
        return arrayList;
    }

    private Collection n(a aVar) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : this.b.entrySet()) {
            if (aVar == null || aVar.a((b) entry.getValue())) {
                arrayList.add((b) entry.getValue());
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean p(b bVar) {
        return bVar.a() && bVar.b();
    }

    public SessionConfig.f e() {
        SessionConfig.f fVar = new SessionConfig.f();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : this.b.entrySet()) {
            b bVar = (b) entry.getValue();
            if (bVar.a() && bVar.b()) {
                String str = (String) entry.getKey();
                fVar.a(bVar.d());
                arrayList.add(str);
            }
        }
        androidx.camera.core.x.a("UseCaseAttachState", "Active and attached use case: " + arrayList + " for camera: " + this.a);
        return fVar;
    }

    public Collection f() {
        return Collections.unmodifiableCollection(l(new a() { // from class: androidx.camera.core.impl.a0
            @Override // androidx.camera.core.impl.c0.a
            public final boolean a(c0.b bVar) {
                return c0.p(bVar);
            }
        }));
    }

    public SessionConfig.f g() {
        SessionConfig.f fVar = new SessionConfig.f();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : this.b.entrySet()) {
            b bVar = (b) entry.getValue();
            if (bVar.b()) {
                fVar.a(bVar.d());
                arrayList.add((String) entry.getKey());
            }
        }
        androidx.camera.core.x.a("UseCaseAttachState", "All use case: " + arrayList + " for camera: " + this.a);
        return fVar;
    }

    public Collection h() {
        return Collections.unmodifiableCollection(l(new a() { // from class: androidx.camera.core.impl.y
            @Override // androidx.camera.core.impl.c0.a
            public final boolean a(c0.b bVar) {
                return bVar.b();
            }
        }));
    }

    public Collection i() {
        return Collections.unmodifiableCollection(m(new a() { // from class: androidx.camera.core.impl.z
            @Override // androidx.camera.core.impl.c0.a
            public final boolean a(c0.b bVar) {
                return bVar.b();
            }
        }));
    }

    public Collection j() {
        return Collections.unmodifiableCollection(n(new a() { // from class: androidx.camera.core.impl.b0
            @Override // androidx.camera.core.impl.c0.a
            public final boolean a(c0.b bVar) {
                return bVar.b();
            }
        }));
    }

    public boolean o(String str) {
        if (this.b.containsKey(str)) {
            return ((b) this.b.get(str)).b();
        }
        return false;
    }

    public void t(String str) {
        this.b.remove(str);
    }

    public void u(String str, SessionConfig sessionConfig, d0 d0Var, x xVar, List list) {
        k(str, sessionConfig, d0Var, xVar, list).g(true);
    }

    public void v(String str, SessionConfig sessionConfig, d0 d0Var, x xVar, List list) {
        k(str, sessionConfig, d0Var, xVar, list).h(true);
        y(str, sessionConfig, d0Var, xVar, list);
    }

    public void w(String str) {
        if (this.b.containsKey(str)) {
            b bVar = (b) this.b.get(str);
            bVar.h(false);
            if (bVar.a()) {
                return;
            }
            this.b.remove(str);
        }
    }

    public void x(String str) {
        if (this.b.containsKey(str)) {
            b bVar = (b) this.b.get(str);
            bVar.g(false);
            if (bVar.b()) {
                return;
            }
            this.b.remove(str);
        }
    }

    public void y(String str, SessionConfig sessionConfig, d0 d0Var, x xVar, List list) {
        if (this.b.containsKey(str)) {
            b bVar = new b(sessionConfig, d0Var, xVar, list);
            b bVar2 = (b) this.b.get(str);
            bVar.h(bVar2.b());
            bVar.g(bVar2.a());
            this.b.put(str, bVar);
        }
    }
}
