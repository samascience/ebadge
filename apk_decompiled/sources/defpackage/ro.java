package defpackage;

import java.nio.channels.WritableByteChannel;
import okio.ByteString;

/* JADX INFO: loaded from: classes4.dex */
public interface ro extends er2, WritableByteChannel {
    ro A();

    ro B(int i);

    ro C0(long j);

    ro F(int i);

    ro I(int i);

    long L(ks2 ks2Var);

    ro M();

    ro S(String str);

    ro Z(byte[] bArr, int i, int i2);

    fo b();

    ro c0(long j);

    @Override // defpackage.er2, java.io.Flushable
    void flush();

    ro u0(byte[] bArr);

    ro v0(ByteString byteString);
}
