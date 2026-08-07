package defpackage;

import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
import okio.ByteString;

/* JADX INFO: loaded from: classes4.dex */
public interface so extends ks2, ReadableByteChannel {
    void B0(long j);

    long D0();

    InputStream E0();

    byte[] G();

    boolean H();

    int J(qx1 qx1Var);

    long K(ByteString byteString);

    String O(long j);

    long T(er2 er2Var);

    void X(fo foVar, long j);

    String Y(Charset charset);

    void a(long j);

    fo b();

    ByteString f0();

    String n0();

    int o0();

    byte[] p0(long j);

    byte readByte();

    void readFully(byte[] bArr);

    int readInt();

    long readLong();

    short readShort();

    boolean request(long j);

    String s(long j);

    ByteString x(long j);

    short x0();

    long z0();
}
