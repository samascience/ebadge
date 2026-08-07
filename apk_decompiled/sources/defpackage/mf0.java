package defpackage;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes4.dex */
public class mf0 extends jf0 {
    private final of0 j;

    public mf0(boolean z, of0 of0Var) {
        this.a = z;
        this.j = of0Var;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.order(z ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.b = of0Var.D(byteBufferAllocate, 16L);
        this.c = of0Var.e0(byteBufferAllocate, 28L);
        this.d = of0Var.e0(byteBufferAllocate, 32L);
        this.e = of0Var.D(byteBufferAllocate, 42L);
        this.f = of0Var.D(byteBufferAllocate, 44L);
        this.g = of0Var.D(byteBufferAllocate, 46L);
        this.h = of0Var.D(byteBufferAllocate, 48L);
        this.i = of0Var.D(byteBufferAllocate, 50L);
    }

    @Override // defpackage.jf0
    public if0 a(long j, int i) {
        return new fe0(this.j, this, j, i);
    }

    @Override // defpackage.jf0
    public kf0 b(long j) {
        return new y72(this.j, this, j);
    }

    @Override // defpackage.jf0
    public lf0 c(int i) {
        return new fm2(this.j, this, i);
    }
}
