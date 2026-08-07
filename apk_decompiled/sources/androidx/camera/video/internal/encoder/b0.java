package androidx.camera.video.internal.encoder;

import android.media.MediaCodec;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import defpackage.b52;
import defpackage.n21;
import defpackage.os0;
import defpackage.ub1;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
class b0 implements n21 {
    private final MediaCodec a;
    private final int b;
    private final ByteBuffer c;
    private final ub1 d;
    private final CallbackToFutureAdapter.a e;
    private final AtomicBoolean f = new AtomicBoolean(false);
    private long g = 0;
    private boolean h = false;

    b0(MediaCodec mediaCodec, int i) {
        this.a = (MediaCodec) b52.g(mediaCodec);
        this.b = b52.d(i);
        this.c = mediaCodec.getInputBuffer(i);
        final AtomicReference atomicReference = new AtomicReference();
        this.d = CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: androidx.camera.video.internal.encoder.a0
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
            public final Object a(CallbackToFutureAdapter.a aVar) {
                return b0.f(atomicReference, aVar);
            }
        });
        this.e = (CallbackToFutureAdapter.a) b52.g((CallbackToFutureAdapter.a) atomicReference.get());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object f(AtomicReference atomicReference, CallbackToFutureAdapter.a aVar) {
        atomicReference.set(aVar);
        return "Terminate InputBuffer";
    }

    private void g() {
        if (this.f.get()) {
            throw new IllegalStateException("The buffer is submitted or canceled.");
        }
    }

    @Override // defpackage.n21
    public ub1 a() {
        return os0.B(this.d);
    }

    @Override // defpackage.n21
    public void b(boolean z) {
        g();
        this.h = z;
    }

    @Override // defpackage.n21
    public boolean c() {
        if (this.f.getAndSet(true)) {
            return false;
        }
        try {
            this.a.queueInputBuffer(this.b, this.c.position(), this.c.limit(), this.g, this.h ? 4 : 0);
            this.e.c(null);
            return true;
        } catch (IllegalStateException e) {
            this.e.f(e);
            return false;
        }
    }

    @Override // defpackage.n21
    public boolean cancel() {
        if (this.f.getAndSet(true)) {
            return false;
        }
        try {
            this.a.queueInputBuffer(this.b, 0, 0, 0L, 0);
            this.e.c(null);
        } catch (IllegalStateException e) {
            this.e.f(e);
        }
        return true;
    }

    @Override // defpackage.n21
    public void d(long j) {
        g();
        b52.a(j >= 0);
        this.g = j;
    }

    @Override // defpackage.n21
    public ByteBuffer m() {
        g();
        return this.c;
    }
}
