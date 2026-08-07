package defpackage;

import androidx.camera.core.v;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class d51 {
    private final z11 a;

    public d51(w92 w92Var) {
        this.a = (z11) w92Var.b(z11.class);
    }

    public byte[] a(v vVar) {
        z11 z11Var = this.a;
        if (z11Var != null) {
            return z11Var.i(vVar);
        }
        ByteBuffer byteBufferB = vVar.r()[0].b();
        byte[] bArr = new byte[byteBufferB.capacity()];
        byteBufferB.rewind();
        byteBufferB.get(bArr);
        return bArr;
    }
}
