package defpackage;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes4.dex */
public class gm2 extends lf0 {
    public gm2(of0 of0Var, jf0 jf0Var, int i) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(jf0Var.a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.a = of0Var.e0(byteBufferAllocate, jf0Var.d + ((long) (i * jf0Var.g)) + 44);
    }
}
