package androidx.camera.lifecycle;

import androidx.camera.core.internal.CameraUseCaseAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.j;
import defpackage.b52;
import defpackage.cb1;
import defpackage.db1;
import defpackage.gt;
import defpackage.ih2;
import defpackage.te3;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
final class LifecycleCameraRepository {
    private final Object a = new Object();
    private final Map b = new HashMap();
    private final Map c = new HashMap();
    private final ArrayDeque d = new ArrayDeque();
    gt e;

    private static class LifecycleCameraRepositoryObserver implements cb1 {
        private final LifecycleCameraRepository a;
        private final db1 b;

        LifecycleCameraRepositoryObserver(db1 db1Var, LifecycleCameraRepository lifecycleCameraRepository) {
            this.b = db1Var;
            this.a = lifecycleCameraRepository;
        }

        db1 a() {
            return this.b;
        }

        @j(Lifecycle.Event.ON_DESTROY)
        public void onDestroy(db1 db1Var) {
            this.a.l(db1Var);
        }

        @j(Lifecycle.Event.ON_START)
        public void onStart(db1 db1Var) {
            this.a.h(db1Var);
        }

        @j(Lifecycle.Event.ON_STOP)
        public void onStop(db1 db1Var) {
            this.a.i(db1Var);
        }
    }

    static abstract class a {
        a() {
        }

        static a a(db1 db1Var, CameraUseCaseAdapter.a aVar) {
            return new androidx.camera.lifecycle.a(db1Var, aVar);
        }

        public abstract CameraUseCaseAdapter.a b();

        public abstract db1 c();
    }

    LifecycleCameraRepository() {
    }

    private LifecycleCameraRepositoryObserver d(db1 db1Var) {
        synchronized (this.a) {
            try {
                for (LifecycleCameraRepositoryObserver lifecycleCameraRepositoryObserver : this.c.keySet()) {
                    if (db1Var.equals(lifecycleCameraRepositoryObserver.a())) {
                        return lifecycleCameraRepositoryObserver;
                    }
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private boolean f(db1 db1Var) {
        synchronized (this.a) {
            try {
                LifecycleCameraRepositoryObserver lifecycleCameraRepositoryObserverD = d(db1Var);
                if (lifecycleCameraRepositoryObserverD == null) {
                    return false;
                }
                Iterator it = ((Set) this.c.get(lifecycleCameraRepositoryObserverD)).iterator();
                while (it.hasNext()) {
                    if (!((LifecycleCamera) b52.g((LifecycleCamera) this.b.get((a) it.next()))).q().isEmpty()) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void g(LifecycleCamera lifecycleCamera) {
        synchronized (this.a) {
            try {
                db1 db1VarP = lifecycleCamera.p();
                a aVarA = a.a(db1VarP, CameraUseCaseAdapter.z((ih2) lifecycleCamera.a()));
                LifecycleCameraRepositoryObserver lifecycleCameraRepositoryObserverD = d(db1VarP);
                Set hashSet = lifecycleCameraRepositoryObserverD != null ? (Set) this.c.get(lifecycleCameraRepositoryObserverD) : new HashSet();
                hashSet.add(aVarA);
                this.b.put(aVarA, lifecycleCamera);
                if (lifecycleCameraRepositoryObserverD == null) {
                    LifecycleCameraRepositoryObserver lifecycleCameraRepositoryObserver = new LifecycleCameraRepositoryObserver(db1VarP, this);
                    this.c.put(lifecycleCameraRepositoryObserver, hashSet);
                    db1VarP.getLifecycle().a(lifecycleCameraRepositoryObserver);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void j(db1 db1Var) {
        synchronized (this.a) {
            try {
                LifecycleCameraRepositoryObserver lifecycleCameraRepositoryObserverD = d(db1Var);
                if (lifecycleCameraRepositoryObserverD == null) {
                    return;
                }
                Iterator it = ((Set) this.c.get(lifecycleCameraRepositoryObserverD)).iterator();
                while (it.hasNext()) {
                    ((LifecycleCamera) b52.g((LifecycleCamera) this.b.get((a) it.next()))).s();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void m(db1 db1Var) {
        synchronized (this.a) {
            try {
                Iterator it = ((Set) this.c.get(d(db1Var))).iterator();
                while (it.hasNext()) {
                    LifecycleCamera lifecycleCamera = (LifecycleCamera) this.b.get((a) it.next());
                    if (!((LifecycleCamera) b52.g(lifecycleCamera)).q().isEmpty()) {
                        lifecycleCamera.u();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void a(LifecycleCamera lifecycleCamera, te3 te3Var, List list, Collection collection, gt gtVar) {
        synchronized (this.a) {
            try {
                b52.a(!collection.isEmpty());
                this.e = gtVar;
                db1 db1VarP = lifecycleCamera.p();
                Set set = (Set) this.c.get(d(db1VarP));
                gt gtVar2 = this.e;
                if (gtVar2 == null || gtVar2.a() != 2) {
                    Iterator it = set.iterator();
                    while (it.hasNext()) {
                        LifecycleCamera lifecycleCamera2 = (LifecycleCamera) b52.g((LifecycleCamera) this.b.get((a) it.next()));
                        if (!lifecycleCamera2.equals(lifecycleCamera) && !lifecycleCamera2.q().isEmpty()) {
                            throw new IllegalArgumentException("Multiple LifecycleCameras with use cases are registered to the same LifecycleOwner.");
                        }
                    }
                }
                try {
                    lifecycleCamera.o().a0(te3Var);
                    lifecycleCamera.o().Y(list);
                    lifecycleCamera.f(collection);
                    if (db1VarP.getLifecycle().b().isAtLeast(Lifecycle.State.STARTED)) {
                        h(db1VarP);
                    }
                } catch (CameraUseCaseAdapter.CameraException e) {
                    throw new IllegalArgumentException(e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    LifecycleCamera b(db1 db1Var, CameraUseCaseAdapter cameraUseCaseAdapter) {
        LifecycleCamera lifecycleCamera;
        synchronized (this.a) {
            try {
                b52.b(this.b.get(a.a(db1Var, cameraUseCaseAdapter.B())) == null, "LifecycleCamera already exists for the given LifecycleOwner and set of cameras");
                if (db1Var.getLifecycle().b() == Lifecycle.State.DESTROYED) {
                    throw new IllegalArgumentException("Trying to create LifecycleCamera with destroyed lifecycle.");
                }
                lifecycleCamera = new LifecycleCamera(db1Var, cameraUseCaseAdapter);
                if (cameraUseCaseAdapter.G().isEmpty()) {
                    lifecycleCamera.s();
                }
                g(lifecycleCamera);
            } catch (Throwable th) {
                throw th;
            }
        }
        return lifecycleCamera;
    }

    LifecycleCamera c(db1 db1Var, CameraUseCaseAdapter.a aVar) {
        LifecycleCamera lifecycleCamera;
        synchronized (this.a) {
            lifecycleCamera = (LifecycleCamera) this.b.get(a.a(db1Var, aVar));
        }
        return lifecycleCamera;
    }

    Collection e() {
        Collection collectionUnmodifiableCollection;
        synchronized (this.a) {
            collectionUnmodifiableCollection = Collections.unmodifiableCollection(this.b.values());
        }
        return collectionUnmodifiableCollection;
    }

    void h(db1 db1Var) {
        synchronized (this.a) {
            try {
                if (f(db1Var)) {
                    if (this.d.isEmpty()) {
                        this.d.push(db1Var);
                    } else {
                        gt gtVar = this.e;
                        if (gtVar == null || gtVar.a() != 2) {
                            db1 db1Var2 = (db1) this.d.peek();
                            if (!db1Var.equals(db1Var2)) {
                                j(db1Var2);
                                this.d.remove(db1Var);
                                this.d.push(db1Var);
                            }
                        }
                    }
                    m(db1Var);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void i(db1 db1Var) {
        synchronized (this.a) {
            try {
                this.d.remove(db1Var);
                j(db1Var);
                if (!this.d.isEmpty()) {
                    m((db1) this.d.peek());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void k() {
        synchronized (this.a) {
            try {
                Iterator it = this.b.keySet().iterator();
                while (it.hasNext()) {
                    LifecycleCamera lifecycleCamera = (LifecycleCamera) this.b.get((a) it.next());
                    lifecycleCamera.t();
                    i(lifecycleCamera.p());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void l(db1 db1Var) {
        synchronized (this.a) {
            try {
                LifecycleCameraRepositoryObserver lifecycleCameraRepositoryObserverD = d(db1Var);
                if (lifecycleCameraRepositoryObserverD == null) {
                    return;
                }
                i(db1Var);
                Iterator it = ((Set) this.c.get(lifecycleCameraRepositoryObserverD)).iterator();
                while (it.hasNext()) {
                    this.b.remove((a) it.next());
                }
                this.c.remove(lifecycleCameraRepositoryObserverD);
                lifecycleCameraRepositoryObserverD.a().getLifecycle().d(lifecycleCameraRepositoryObserverD);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
