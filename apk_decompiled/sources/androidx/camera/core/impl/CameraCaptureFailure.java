package androidx.camera.core.impl;

/* JADX INFO: loaded from: classes.dex */
public class CameraCaptureFailure {
    private final Reason a;

    public enum Reason {
        ERROR
    }

    public CameraCaptureFailure(Reason reason) {
        this.a = reason;
    }

    public Reason a() {
        return this.a;
    }
}
