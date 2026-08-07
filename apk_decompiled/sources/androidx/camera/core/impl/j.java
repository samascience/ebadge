package androidx.camera.core.impl;

import defpackage.b52;
import defpackage.gt;
import defpackage.zr;
import defpackage.zt;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes.dex */
public final class j implements gt.a {
    private final StringBuilder a = new StringBuilder();
    private final Object b;
    private int c;
    private final gt d;
    private final Map e;
    private int f;

    private static class a {
        private CameraInternal.State a;
        private final Executor b;
        private final b c;
        private final c d;

        a(CameraInternal.State state, Executor executor, b bVar, c cVar) {
            this.a = state;
            this.b = executor;
            this.c = bVar;
            this.d = cVar;
        }

        CameraInternal.State a() {
            return this.a;
        }

        void b() {
            try {
                Executor executor = this.b;
                final b bVar = this.c;
                Objects.requireNonNull(bVar);
                executor.execute(new Runnable() { // from class: vu
                    @Override // java.lang.Runnable
                    public final void run() {
                        bVar.a();
                    }
                });
            } catch (RejectedExecutionException e) {
                androidx.camera.core.x.d("CameraStateRegistry", "Unable to notify camera to configure.", e);
            }
        }

        void c() {
            try {
                Executor executor = this.b;
                final c cVar = this.d;
                Objects.requireNonNull(cVar);
                executor.execute(new Runnable() { // from class: uu
                    @Override // java.lang.Runnable
                    public final void run() {
                        cVar.a();
                    }
                });
            } catch (RejectedExecutionException e) {
                androidx.camera.core.x.d("CameraStateRegistry", "Unable to notify camera to open.", e);
            }
        }

        CameraInternal.State d(CameraInternal.State state) {
            CameraInternal.State state2 = this.a;
            this.a = state;
            return state2;
        }
    }

    public interface b {
        void a();
    }

    public interface c {
        void a();
    }

    public j(gt gtVar, int i) {
        Object obj = new Object();
        this.b = obj;
        this.e = new HashMap();
        this.c = i;
        synchronized (obj) {
            this.d = gtVar;
            this.f = this.c;
        }
    }

    private a b(String str) {
        for (zr zrVar : this.e.keySet()) {
            if (str.equals(((zt) zrVar.a()).d())) {
                return (a) this.e.get(zrVar);
            }
        }
        return null;
    }

    private static boolean d(CameraInternal.State state) {
        return state != null && state.holdsCameraSlot();
    }

    private void f() {
        if (androidx.camera.core.x.f("CameraStateRegistry")) {
            this.a.setLength(0);
            this.a.append("Recalculating open cameras:\n");
            this.a.append(String.format(Locale.US, "%-45s%-22s\n", "Camera", "State"));
            this.a.append("-------------------------------------------------------------------\n");
        }
        int i = 0;
        for (Map.Entry entry : this.e.entrySet()) {
            if (androidx.camera.core.x.f("CameraStateRegistry")) {
                this.a.append(String.format(Locale.US, "%-45s%-22s\n", ((zr) entry.getKey()).toString(), ((a) entry.getValue()).a() != null ? ((a) entry.getValue()).a().toString() : "UNKNOWN"));
            }
            if (d(((a) entry.getValue()).a())) {
                i++;
            }
        }
        if (androidx.camera.core.x.f("CameraStateRegistry")) {
            this.a.append("-------------------------------------------------------------------\n");
            this.a.append(String.format(Locale.US, "Open count: %d (Max allowed: %d)", Integer.valueOf(i), Integer.valueOf(this.c)));
            androidx.camera.core.x.a("CameraStateRegistry", this.a.toString());
        }
        this.f = Math.max(this.c - i, 0);
    }

    private CameraInternal.State j(zr zrVar) {
        a aVar = (a) this.e.remove(zrVar);
        if (aVar == null) {
            return null;
        }
        f();
        return aVar.a();
    }

    private CameraInternal.State k(zr zrVar, CameraInternal.State state) {
        CameraInternal.State stateD = ((a) b52.h((a) this.e.get(zrVar), "Cannot update state of camera which has not yet been registered. Register with CameraStateRegistry.registerCamera()")).d(state);
        CameraInternal.State state2 = CameraInternal.State.OPENING;
        if (state == state2) {
            b52.j(d(state) || stateD == state2, "Cannot mark camera as opening until camera was successful at calling CameraStateRegistry.tryOpenCamera()");
        }
        if (stateD != state) {
            f();
        }
        return stateD;
    }

    @Override // gt.a
    public void a(int i, int i2) {
        synchronized (this.b) {
            boolean z = true;
            this.c = i2 == 2 ? 2 : 1;
            boolean z2 = i != 2 && i2 == 2;
            if (i != 2 || i2 == 2) {
                z = false;
            }
            if (z2 || z) {
                f();
            }
        }
    }

    public boolean c() {
        synchronized (this.b) {
            try {
                Iterator it = this.e.entrySet().iterator();
                while (it.hasNext()) {
                    if (((a) ((Map.Entry) it.next()).getValue()).a() == CameraInternal.State.CLOSING) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x003e  */
    public void e(zr zrVar, CameraInternal.State state, boolean z) {
        a aVarB;
        synchronized (this.b) {
            try {
                int i = this.f;
                if ((state == CameraInternal.State.RELEASED ? j(zrVar) : k(zrVar, state)) == state) {
                    return;
                }
                HashMap map = null;
                if (this.d.a() == 2 && state == CameraInternal.State.CONFIGURED) {
                    String strC = this.d.c(((zt) zrVar.a()).d());
                    if (strC != null) {
                        aVarB = b(strC);
                    } else {
                        aVarB = null;
                    }
                } else {
                    aVarB = null;
                }
                if (i < 1 && this.f > 0) {
                    map = new HashMap();
                    for (Map.Entry entry : this.e.entrySet()) {
                        if (((a) entry.getValue()).a() == CameraInternal.State.PENDING_OPEN) {
                            map.put((zr) entry.getKey(), (a) entry.getValue());
                        }
                    }
                } else if (state == CameraInternal.State.PENDING_OPEN && this.f > 0) {
                    map = new HashMap();
                    map.put(zrVar, (a) this.e.get(zrVar));
                }
                if (map != null && !z) {
                    map.remove(zrVar);
                }
                if (map != null) {
                    Iterator it = map.values().iterator();
                    while (it.hasNext()) {
                        ((a) it.next()).c();
                    }
                }
                if (aVarB != null) {
                    aVarB.b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void g(zr zrVar, Executor executor, b bVar, c cVar) {
        synchronized (this.b) {
            b52.j(!this.e.containsKey(zrVar), "Camera is already registered: " + zrVar);
            this.e.put(zrVar, new a(null, executor, bVar, cVar));
        }
    }

    public boolean h(zr zrVar) {
        boolean z;
        synchronized (this.b) {
            try {
                a aVar = (a) b52.h((a) this.e.get(zrVar), "Camera must first be registered with registerCamera()");
                z = false;
                if (androidx.camera.core.x.f("CameraStateRegistry")) {
                    this.a.setLength(0);
                    this.a.append(String.format(Locale.US, "tryOpenCamera(%s) [Available Cameras: %d, Already Open: %b (Previous state: %s)]", zrVar, Integer.valueOf(this.f), Boolean.valueOf(d(aVar.a())), aVar.a()));
                }
                if (this.f > 0 || d(aVar.a())) {
                    aVar.d(CameraInternal.State.OPENING);
                    z = true;
                }
                if (androidx.camera.core.x.f("CameraStateRegistry")) {
                    this.a.append(String.format(Locale.US, " --> %s", z ? "SUCCESS" : "FAIL"));
                    androidx.camera.core.x.a("CameraStateRegistry", this.a.toString());
                }
                if (z) {
                    f();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    public boolean i(String str, String str2) {
        synchronized (this.b) {
            try {
                boolean z = true;
                if (this.d.a() != 2) {
                    return true;
                }
                CameraInternal.State stateA = null;
                CameraInternal.State stateA2 = b(str) != null ? b(str).a() : null;
                if (str2 != null && b(str2) != null) {
                    stateA = b(str2).a();
                }
                CameraInternal.State state = CameraInternal.State.OPEN;
                boolean z2 = state.equals(stateA2) || CameraInternal.State.CONFIGURED.equals(stateA2);
                boolean z3 = state.equals(stateA) || CameraInternal.State.CONFIGURED.equals(stateA);
                if (!z2 || !z3) {
                    z = false;
                }
                return z;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
