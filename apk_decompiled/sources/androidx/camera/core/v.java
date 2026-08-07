package androidx.camera.core;

import android.graphics.Rect;
import android.media.Image;
import defpackage.n01;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public interface v extends AutoCloseable {

    public interface a {
        int a();

        ByteBuffer b();

        int c();
    }

    @Override // java.lang.AutoCloseable
    void close();

    void d0(Rect rect);

    int getHeight();

    int getWidth();

    n01 h0();

    int q();

    a[] r();

    Image s0();
}
