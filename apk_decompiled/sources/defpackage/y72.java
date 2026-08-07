package defpackage;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes4.dex */
public class y72 extends kf0 {
    public y72(of0 of0Var, jf0 jf0Var, long j) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.order(jf0Var.a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j2 = jf0Var.c + (j * ((long) jf0Var.e));
        this.a = of0Var.e0(byteBufferAllocate, j2);
        this.b = of0Var.e0(byteBufferAllocate, 4 + j2);
        this.c = of0Var.e0(byteBufferAllocate, 8 + j2);
        this.d = of0Var.e0(byteBufferAllocate, j2 + 20);
    }
}
