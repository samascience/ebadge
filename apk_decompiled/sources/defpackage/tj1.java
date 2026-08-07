package defpackage;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public final class tj1 extends sz2 {
    public static tj1 h(ByteBuffer byteBuffer) {
        return i(byteBuffer, new tj1());
    }

    public static tj1 i(ByteBuffer byteBuffer, tj1 tj1Var) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return tj1Var.f(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public tj1 f(int i, ByteBuffer byteBuffer) {
        g(i, byteBuffer);
        return this;
    }

    public void g(int i, ByteBuffer byteBuffer) {
        c(i, byteBuffer);
    }

    public sj1 j(sj1 sj1Var, int i) {
        int iB = b(6);
        if (iB != 0) {
            return sj1Var.f(a(d(iB) + (i * 4)), this.b);
        }
        return null;
    }

    public int k() {
        int iB = b(6);
        if (iB != 0) {
            return e(iB);
        }
        return 0;
    }

    public int l() {
        int iB = b(4);
        if (iB != 0) {
            return this.b.getInt(iB + this.a);
        }
        return 0;
    }
}
