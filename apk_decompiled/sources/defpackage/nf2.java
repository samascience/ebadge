package defpackage;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.util.Log;
import androidx.camera.camera2.internal.e0;
import androidx.camera.core.impl.utils.executor.c;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class nf2 {
    private final boolean a;
    private final List b = Collections.synchronizedList(new ArrayList());

    static class a extends CameraCaptureSession.CaptureCallback {
        final ub1 a = CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: mf2
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
            public final Object a(CallbackToFutureAdapter.a aVar) {
                return this.a.c(aVar);
            }
        });
        CallbackToFutureAdapter.a b;

        a() {
        }

        private void b() {
            CallbackToFutureAdapter.a aVar = this.b;
            if (aVar != null) {
                aVar.c(null);
                this.b = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Object c(CallbackToFutureAdapter.a aVar) {
            this.b = aVar;
            return "RequestCompleteListener[" + this + "]";
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
            b();
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureFailed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureFailure captureFailure) {
            b();
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureSequenceAborted(CameraCaptureSession cameraCaptureSession, int i) {
            b();
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureSequenceCompleted(CameraCaptureSession cameraCaptureSession, int i, long j) {
            b();
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureStarted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, long j, long j2) {
            b();
        }
    }

    public nf2(boolean z) {
        this.a = z;
    }

    private CameraCaptureSession.CaptureCallback c() {
        final a aVar = new a();
        final ub1 ub1Var = aVar.a;
        this.b.add(ub1Var);
        Log.d("RequestMonitor", "RequestListener " + aVar + " monitoring " + this);
        ub1Var.a(new Runnable() { // from class: kf2
            @Override // java.lang.Runnable
            public final void run() {
                this.a.f(aVar, ub1Var);
            }
        }, c.b());
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(a aVar, ub1 ub1Var) {
        Log.d("RequestMonitor", "RequestListener " + aVar + " done " + this);
        this.b.remove(ub1Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Void g(List list) {
        return null;
    }

    public CameraCaptureSession.CaptureCallback d(CameraCaptureSession.CaptureCallback captureCallback) {
        return h() ? e0.b(c(), captureCallback) : captureCallback;
    }

    public ub1 e() {
        return this.b.isEmpty() ? os0.p(null) : os0.B(os0.G(os0.F(new ArrayList(this.b)), new wr0() { // from class: lf2
            @Override // defpackage.wr0
            public final Object apply(Object obj) {
                return nf2.g((List) obj);
            }
        }, c.b()));
    }

    public boolean h() {
        return this.a;
    }

    public void i() {
        LinkedList linkedList = new LinkedList(this.b);
        while (!linkedList.isEmpty()) {
            ub1 ub1Var = (ub1) linkedList.poll();
            Objects.requireNonNull(ub1Var);
            ub1Var.cancel(true);
        }
    }
}
