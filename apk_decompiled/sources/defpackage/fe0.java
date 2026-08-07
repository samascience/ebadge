package defpackage;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes4.dex */
public class fe0 extends if0 {
    public fe0(of0 of0Var, jf0 jf0Var, long j, int i) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.order(jf0Var.a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j2 = j + ((long) (i * 8));
        this.a = of0Var.e0(byteBufferAllocate, j2);
        this.b = of0Var.e0(byteBufferAllocate, j2 + 4);
    }
}
