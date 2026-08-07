package androidx.camera.video.internal.encoder;

import android.media.MediaCodec;
import androidx.camera.video.internal.encoder.b;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import defpackage.b52;
import defpackage.dg0;
import defpackage.os0;
import defpackage.ub1;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public class b implements dg0 {
    private final MediaCodec a;
    private final MediaCodec.BufferInfo b;
    private final int c;
    private final ByteBuffer d;
    private final ub1 e;
    private final CallbackToFutureAdapter.a f;
    private final AtomicBoolean g = new AtomicBoolean(false);

    b(MediaCodec mediaCodec, int i, MediaCodec.BufferInfo bufferInfo) {
        this.a = (MediaCodec) b52.g(mediaCodec);
        this.c = i;
        this.d = mediaCodec.getOutputBuffer(i);
        this.b = (MediaCodec.BufferInfo) b52.g(bufferInfo);
        final AtomicReference atomicReference = new AtomicReference();
        this.e = CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: eg0
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
            public final Object a(CallbackToFutureAdapter.a aVar) {
                return b.w(atomicReference, aVar);
            }
        });
        this.f = (CallbackToFutureAdapter.a) b52.g((CallbackToFutureAdapter.a) atomicReference.get());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object w(AtomicReference atomicReference, CallbackToFutureAdapter.a aVar) {
        atomicReference.set(aVar);
        return "Data closed";
    }

    private void y() {
        if (this.g.get()) {
            throw new IllegalStateException("encoded data is closed.");
        }
    }

    @Override // defpackage.dg0
    public MediaCodec.BufferInfo N() {
        return this.b;
    }

    @Override // defpackage.dg0
    public boolean Q() {
        return (this.b.flags & 1) != 0;
    }

    @Override // defpackage.dg0, java.lang.AutoCloseable
    public void close() {
        if (this.g.getAndSet(true)) {
            return;
        }
        try {
            this.a.releaseOutputBuffer(this.c, false);
            this.f.c(null);
        } catch (IllegalStateException e) {
            this.f.f(e);
        }
    }

    @Override // defpackage.dg0
    public ByteBuffer m() {
        y();
        this.d.position(this.b.offset);
        ByteBuffer byteBuffer = this.d;
        MediaCodec.BufferInfo bufferInfo = this.b;
        byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
        return this.d;
    }

    @Override // defpackage.dg0
    public long q0() {
        return this.b.presentationTimeUs;
    }

    @Override // defpackage.dg0
    public long size() {
        return this.b.size;
    }

    public ub1 u() {
        return os0.B(this.e);
    }
}
