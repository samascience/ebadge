package androidx.camera.video;

import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
final class g extends q {
    private final Uri a;

    g(Uri uri) {
        if (uri == null) {
            throw new NullPointerException("Null outputUri");
        }
        this.a = uri;
    }

    @Override // androidx.camera.video.q
    public Uri a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof q) {
            return this.a.equals(((q) obj).a());
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "OutputResults{outputUri=" + this.a + "}";
    }
}
