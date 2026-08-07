package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraDevice;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
class a2 {
    final Executor a;
    final Object b = new Object();
    final Set c = new LinkedHashSet();
    final Set d = new LinkedHashSet();
    final Set e = new LinkedHashSet();
    private final CameraDevice.StateCallback f = new a();

    class a extends CameraDevice.StateCallback {
        a() {
        }

        private void c() {
            List listF;
            synchronized (a2.this.b) {
                listF = a2.this.f();
                a2.this.e.clear();
                a2.this.c.clear();
                a2.this.d.clear();
            }
            Iterator it = listF.iterator();
            while (it.hasNext()) {
                ((t2) it.next()).a();
            }
        }

        private void d(final int i) {
            final LinkedHashSet linkedHashSet = new LinkedHashSet();
            synchronized (a2.this.b) {
                linkedHashSet.addAll(a2.this.e);
                linkedHashSet.addAll(a2.this.c);
            }
            a2.this.a.execute(new Runnable() { // from class: androidx.camera.camera2.internal.z1
                @Override // java.lang.Runnable
                public final void run() {
                    a2.a.f(linkedHashSet, i);
                }
            });
        }

        private void e() {
            final LinkedHashSet linkedHashSet = new LinkedHashSet();
            synchronized (a2.this.b) {
                linkedHashSet.addAll(a2.this.e);
                linkedHashSet.addAll(a2.this.c);
            }
            a2.this.a.execute(new Runnable() { // from class: androidx.camera.camera2.internal.y1
                @Override // java.lang.Runnable
                public final void run() {
                    a2.b(linkedHashSet);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void f(LinkedHashSet linkedHashSet, int i) {
            Iterator it = linkedHashSet.iterator();
            while (it.hasNext()) {
                ((t2) it.next()).f(i);
            }
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onClosed(CameraDevice cameraDevice) {
            e();
            c();
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onDisconnected(CameraDevice cameraDevice) {
            e();
            c();
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onError(CameraDevice cameraDevice, int i) {
            e();
            d(i);
            c();
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onOpened(CameraDevice cameraDevice) {
        }
    }

    a2(Executor executor) {
        this.a = executor;
    }

    private void a(t2 t2Var) {
        t2 t2Var2;
        Iterator it = f().iterator();
        while (it.hasNext() && (t2Var2 = (t2) it.next()) != t2Var) {
            t2Var2.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(Set set) {
        Iterator it = set.iterator();
        while (it.hasNext()) {
            t2 t2Var = (t2) it.next();
            t2Var.c().q(t2Var);
        }
    }

    CameraDevice.StateCallback c() {
        return this.f;
    }

    List d() {
        ArrayList arrayList;
        synchronized (this.b) {
            arrayList = new ArrayList(this.c);
        }
        return arrayList;
    }

    List e() {
        ArrayList arrayList;
        synchronized (this.b) {
            arrayList = new ArrayList(this.e);
        }
        return arrayList;
    }

    List f() {
        ArrayList arrayList;
        synchronized (this.b) {
            arrayList = new ArrayList();
            arrayList.addAll(d());
            arrayList.addAll(e());
        }
        return arrayList;
    }

    void g(t2 t2Var) {
        synchronized (this.b) {
            this.c.remove(t2Var);
            this.d.remove(t2Var);
        }
    }

    void h(t2 t2Var) {
        synchronized (this.b) {
            this.d.add(t2Var);
        }
    }

    void i(t2 t2Var) {
        a(t2Var);
        synchronized (this.b) {
            this.e.remove(t2Var);
        }
    }

    void j(t2 t2Var) {
        synchronized (this.b) {
            this.c.add(t2Var);
            this.e.remove(t2Var);
        }
        a(t2Var);
    }

    void k(t2 t2Var) {
        synchronized (this.b) {
            this.e.add(t2Var);
        }
    }
}
