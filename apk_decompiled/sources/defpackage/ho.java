package defpackage;

import android.media.MediaCodec;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public class ho implements dg0 {
    private final ByteBuffer a;
    private final MediaCodec.BufferInfo b;
    private final ub1 c;
    private final CallbackToFutureAdapter.a d;

    public ho(dg0 dg0Var) {
        this.b = w(dg0Var);
        this.a = u(dg0Var);
        final AtomicReference atomicReference = new AtomicReference();
        this.c = CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: go
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
            public final Object a(CallbackToFutureAdapter.a aVar) {
                return ho.y(atomicReference, aVar);
            }
        });
        this.d = (CallbackToFutureAdapter.a) b52.g((CallbackToFutureAdapter.a) atomicReference.get());
    }

    private ByteBuffer u(dg0 dg0Var) {
        ByteBuffer byteBufferM = dg0Var.m();
        MediaCodec.BufferInfo bufferInfoN = dg0Var.N();
        byteBufferM.position(bufferInfoN.offset);
        byteBufferM.limit(bufferInfoN.offset + bufferInfoN.size);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bufferInfoN.size);
        byteBufferAllocate.order(byteBufferM.order());
        byteBufferAllocate.put(byteBufferM);
        byteBufferAllocate.flip();
        return byteBufferAllocate;
    }

    private MediaCodec.BufferInfo w(dg0 dg0Var) {
        MediaCodec.BufferInfo bufferInfoN = dg0Var.N();
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        bufferInfo.set(0, bufferInfoN.size, bufferInfoN.presentationTimeUs, bufferInfoN.flags);
        return bufferInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object y(AtomicReference atomicReference, CallbackToFutureAdapter.a aVar) {
        atomicReference.set(aVar);
        return "Data closed";
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
        this.d.c(null);
    }

    @Override // defpackage.dg0
    public ByteBuffer m() {
        return this.a;
    }

    @Override // defpackage.dg0
    public long q0() {
        return this.b.presentationTimeUs;
    }

    @Override // defpackage.dg0
    public long size() {
        return this.b.size;
    }
}
