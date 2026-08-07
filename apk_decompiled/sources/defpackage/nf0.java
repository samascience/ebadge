package defpackage;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes4.dex */
public class nf0 extends jf0 {
    private final of0 j;

    public nf0(boolean z, of0 of0Var) {
        this.a = z;
        this.j = of0Var;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(z ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.b = of0Var.D(byteBufferAllocate, 16L);
        this.c = of0Var.V(byteBufferAllocate, 32L);
        this.d = of0Var.V(byteBufferAllocate, 40L);
        this.e = of0Var.D(byteBufferAllocate, 54L);
        this.f = of0Var.D(byteBufferAllocate, 56L);
        this.g = of0Var.D(byteBufferAllocate, 58L);
        this.h = of0Var.D(byteBufferAllocate, 60L);
        this.i = of0Var.D(byteBufferAllocate, 62L);
    }

    @Override // defpackage.jf0
    public if0 a(long j, int i) {
        return new ge0(this.j, this, j, i);
    }

    @Override // defpackage.jf0
    public kf0 b(long j) {
        return new z72(this.j, this, j);
    }

    @Override // defpackage.jf0
    public lf0 c(int i) {
        return new gm2(this.j, this, i);
    }
}
