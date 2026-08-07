package defpackage;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.InputConfiguration;
import android.hardware.camera2.params.OutputConfiguration;
import android.hardware.camera2.params.SessionConfiguration;
import android.os.Build;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class jn2 {
    private final c a;

    private static final class b implements c {
        private final List a;
        private final CameraCaptureSession.StateCallback b;
        private final Executor c;
        private final int d;
        private o21 e = null;
        private CaptureRequest f = null;

        b(int i, List list, Executor executor, CameraCaptureSession.StateCallback stateCallback) {
            this.d = i;
            this.a = Collections.unmodifiableList(new ArrayList(list));
            this.b = stateCallback;
            this.c = executor;
        }

        @Override // jn2.c
        public o21 a() {
            return this.e;
        }

        @Override // jn2.c
        public Executor b() {
            return this.c;
        }

        @Override // jn2.c
        public CameraCaptureSession.StateCallback c() {
            return this.b;
        }

        @Override // jn2.c
        public Object d() {
            return null;
        }

        @Override // jn2.c
        public int e() {
            return this.d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (Objects.equals(this.e, bVar.e) && this.d == bVar.d && this.a.size() == bVar.a.size()) {
                    for (int i = 0; i < this.a.size(); i++) {
                        if (!((zx1) this.a.get(i)).equals(bVar.a.get(i))) {
                            return false;
                        }
                    }
                    return true;
                }
            }
            return false;
        }

        @Override // jn2.c
        public List f() {
            return this.a;
        }

        @Override // jn2.c
        public void g(CaptureRequest captureRequest) {
            this.f = captureRequest;
        }

        @Override // jn2.c
        public void h(o21 o21Var) {
            if (this.d == 1) {
                throw new UnsupportedOperationException("Method not supported for high speed session types");
            }
            this.e = o21Var;
        }

        public int hashCode() {
            int iHashCode = this.a.hashCode() ^ 31;
            int i = (iHashCode << 5) - iHashCode;
            o21 o21Var = this.e;
            int iHashCode2 = (o21Var == null ? 0 : o21Var.hashCode()) ^ i;
            return this.d ^ ((iHashCode2 << 5) - iHashCode2);
        }
    }

    private interface c {
        o21 a();

        Executor b();

        CameraCaptureSession.StateCallback c();

        Object d();

        int e();

        List f();

        void g(CaptureRequest captureRequest);

        void h(o21 o21Var);
    }

    public jn2(int i, List list, Executor executor, CameraCaptureSession.StateCallback stateCallback) {
        if (Build.VERSION.SDK_INT < 28) {
            this.a = new b(i, list, executor, stateCallback);
        } else {
            this.a = new a(i, list, executor, stateCallback);
        }
    }

    public static List h(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add((OutputConfiguration) ((zx1) it.next()).i());
        }
        return arrayList;
    }

    static List i(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(zx1.j((OutputConfiguration) it.next()));
        }
        return arrayList;
    }

    public Executor a() {
        return this.a.b();
    }

    public o21 b() {
        return this.a.a();
    }

    public List c() {
        return this.a.f();
    }

    public int d() {
        return this.a.e();
    }

    public CameraCaptureSession.StateCallback e() {
        return this.a.c();
    }

    public boolean equals(Object obj) {
        if (obj instanceof jn2) {
            return this.a.equals(((jn2) obj).a);
        }
        return false;
    }

    public void f(o21 o21Var) {
        this.a.h(o21Var);
    }

    public void g(CaptureRequest captureRequest) {
        this.a.g(captureRequest);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public Object j() {
        return this.a.d();
    }

    private static final class a implements c {
        private final SessionConfiguration a;
        private final List b;

        a(Object obj) {
            SessionConfiguration sessionConfiguration = (SessionConfiguration) obj;
            this.a = sessionConfiguration;
            this.b = Collections.unmodifiableList(jn2.i(sessionConfiguration.getOutputConfigurations()));
        }

        @Override // jn2.c
        public o21 a() {
            return o21.b(this.a.getInputConfiguration());
        }

        @Override // jn2.c
        public Executor b() {
            return this.a.getExecutor();
        }

        @Override // jn2.c
        public CameraCaptureSession.StateCallback c() {
            return this.a.getStateCallback();
        }

        @Override // jn2.c
        public Object d() {
            return this.a;
        }

        @Override // jn2.c
        public int e() {
            return this.a.getSessionType();
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                return Objects.equals(this.a, ((a) obj).a);
            }
            return false;
        }

        @Override // jn2.c
        public List f() {
            return this.b;
        }

        @Override // jn2.c
        public void g(CaptureRequest captureRequest) {
            this.a.setSessionParameters(captureRequest);
        }

        @Override // jn2.c
        public void h(o21 o21Var) {
            this.a.setInputConfiguration((InputConfiguration) o21Var.a());
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        a(int i, List list, Executor executor, CameraCaptureSession.StateCallback stateCallback) {
            this(new SessionConfiguration(i, jn2.h(list), executor, stateCallback));
        }
    }
}
