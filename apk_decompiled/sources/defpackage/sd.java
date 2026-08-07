package defpackage;

import androidx.camera.core.ImageCaptureException;

/* JADX INFO: loaded from: classes.dex */
final class sd extends d03.b {
    private final int a;
    private final ImageCaptureException b;

    sd(int i, ImageCaptureException imageCaptureException) {
        this.a = i;
        if (imageCaptureException == null) {
            throw new NullPointerException("Null imageCaptureException");
        }
        this.b = imageCaptureException;
    }

    @Override // d03.b
    ImageCaptureException a() {
        return this.b;
    }

    @Override // d03.b
    int b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d03.b)) {
            return false;
        }
        d03.b bVar = (d03.b) obj;
        return this.a == bVar.b() && this.b.equals(bVar.a());
    }

    public int hashCode() {
        return ((this.a ^ 1000003) * 1000003) ^ this.b.hashCode();
    }

    public String toString() {
        return "CaptureError{requestId=" + this.a + ", imageCaptureException=" + this.b + "}";
    }
}
