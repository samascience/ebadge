package androidx.camera.camera2.internal;

import androidx.camera.core.CameraState;
import androidx.camera.core.impl.CameraInternal;
import androidx.lifecycle.LiveData;
import defpackage.im1;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
class p1 {
    private final androidx.camera.core.impl.j a;
    private final im1 b;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[CameraInternal.State.values().length];
            a = iArr;
            try {
                iArr[CameraInternal.State.PENDING_OPEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[CameraInternal.State.OPENING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[CameraInternal.State.OPEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[CameraInternal.State.CONFIGURED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[CameraInternal.State.CLOSING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[CameraInternal.State.RELEASING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[CameraInternal.State.CLOSED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[CameraInternal.State.RELEASED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    p1(androidx.camera.core.impl.j jVar) {
        this.a = jVar;
        im1 im1Var = new im1();
        this.b = im1Var;
        im1Var.m(CameraState.a(CameraState.Type.CLOSED));
    }

    private CameraState b() {
        return this.a.c() ? CameraState.a(CameraState.Type.OPENING) : CameraState.a(CameraState.Type.PENDING_OPEN);
    }

    public LiveData a() {
        return this.b;
    }

    public void c(CameraInternal.State state, CameraState.a aVar) {
        CameraState cameraStateB;
        switch (a.a[state.ordinal()]) {
            case 1:
                cameraStateB = b();
                break;
            case 2:
                cameraStateB = CameraState.b(CameraState.Type.OPENING, aVar);
                break;
            case 3:
            case 4:
                cameraStateB = CameraState.b(CameraState.Type.OPEN, aVar);
                break;
            case 5:
            case 6:
                cameraStateB = CameraState.b(CameraState.Type.CLOSING, aVar);
                break;
            case 7:
            case 8:
                cameraStateB = CameraState.b(CameraState.Type.CLOSED, aVar);
                break;
            default:
                throw new IllegalStateException("Unknown internal camera state: " + state);
        }
        androidx.camera.core.x.a("CameraStateMachine", "New public camera state " + cameraStateB + " from " + state + " and " + aVar);
        if (Objects.equals((CameraState) this.b.f(), cameraStateB)) {
            return;
        }
        androidx.camera.core.x.a("CameraStateMachine", "Publishing new public camera state " + cameraStateB);
        this.b.m(cameraStateB);
    }
}
