package androidx.camera.video;

import android.net.Uri;
import defpackage.b52;

/* JADX INFO: loaded from: classes.dex */
public abstract class q {
    static q b(Uri uri) {
        b52.h(uri, "OutputUri cannot be null.");
        return new g(uri);
    }

    public abstract Uri a();
}
