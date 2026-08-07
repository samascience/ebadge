package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import android.view.Surface;
import defpackage.ws;
import defpackage.x7;
import defpackage.z7;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class e3 extends t2.c {
    private final List a;

    e3(List list) {
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
        arrayList.addAll(list);
    }

    static t2.c w(t2.c... cVarArr) {
        return new e3(Arrays.asList(cVarArr));
    }

    @Override // androidx.camera.camera2.internal.t2.c
    public void o(t2 t2Var) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((t2.c) it.next()).o(t2Var);
        }
    }

    @Override // androidx.camera.camera2.internal.t2.c
    public void p(t2 t2Var) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((t2.c) it.next()).p(t2Var);
        }
    }

    @Override // androidx.camera.camera2.internal.t2.c
    public void q(t2 t2Var) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((t2.c) it.next()).q(t2Var);
        }
    }

    @Override // androidx.camera.camera2.internal.t2.c
    public void r(t2 t2Var) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((t2.c) it.next()).r(t2Var);
        }
    }

    @Override // androidx.camera.camera2.internal.t2.c
    public void s(t2 t2Var) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((t2.c) it.next()).s(t2Var);
        }
    }

    @Override // androidx.camera.camera2.internal.t2.c
    public void t(t2 t2Var) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((t2.c) it.next()).t(t2Var);
        }
    }

    @Override // androidx.camera.camera2.internal.t2.c
    void u(t2 t2Var) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((t2.c) it.next()).u(t2Var);
        }
    }

    @Override // androidx.camera.camera2.internal.t2.c
    public void v(t2 t2Var, Surface surface) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((t2.c) it.next()).v(t2Var, surface);
        }
    }

    static class a extends t2.c {
        private final CameraCaptureSession.StateCallback a;

        a(CameraCaptureSession.StateCallback stateCallback) {
            this.a = stateCallback;
        }

        @Override // androidx.camera.camera2.internal.t2.c
        public void o(t2 t2Var) {
            this.a.onActive(t2Var.e().c());
        }

        @Override // androidx.camera.camera2.internal.t2.c
        public void p(t2 t2Var) {
            z7.b(this.a, t2Var.e().c());
        }

        @Override // androidx.camera.camera2.internal.t2.c
        public void q(t2 t2Var) {
            this.a.onClosed(t2Var.e().c());
        }

        @Override // androidx.camera.camera2.internal.t2.c
        public void r(t2 t2Var) {
            this.a.onConfigureFailed(t2Var.e().c());
        }

        @Override // androidx.camera.camera2.internal.t2.c
        public void s(t2 t2Var) {
            this.a.onConfigured(t2Var.e().c());
        }

        @Override // androidx.camera.camera2.internal.t2.c
        public void t(t2 t2Var) {
            this.a.onReady(t2Var.e().c());
        }

        @Override // androidx.camera.camera2.internal.t2.c
        void u(t2 t2Var) {
        }

        @Override // androidx.camera.camera2.internal.t2.c
        public void v(t2 t2Var, Surface surface) {
            x7.a(this.a, t2Var.e().c(), surface);
        }

        a(List list) {
            this(ws.a(list));
        }
    }
}
