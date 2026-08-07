package defpackage;

import android.media.MediaCodec;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public interface dg0 extends AutoCloseable {
    MediaCodec.BufferInfo N();

    boolean Q();

    @Override // java.lang.AutoCloseable
    void close();

    ByteBuffer m();

    long q0();

    long size();
}
