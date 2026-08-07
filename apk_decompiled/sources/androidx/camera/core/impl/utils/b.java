package androidx.camera.core.impl.utils;

import com.tencent.connect.common.Constants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes.dex */
final class b {
    static final Charset e = StandardCharsets.US_ASCII;
    static final String[] f = {Constants.STR_EMPTY, "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
    static final int[] g = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
    static final byte[] h = {65, 83, 67, 73, 73, 0, 0, 0};
    public final int a;
    public final int b;
    public final long c;
    public final byte[] d;

    b(int i, int i2, byte[] bArr) {
        this(i, i2, -1L, bArr);
    }

    public static b a(String str) {
        if (str.length() == 1 && str.charAt(0) >= '0' && str.charAt(0) <= '1') {
            return new b(1, 1, new byte[]{(byte) (str.charAt(0) - '0')});
        }
        byte[] bytes = str.getBytes(e);
        return new b(1, bytes.length, bytes);
    }

    public static b b(double[] dArr, ByteOrder byteOrder) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[g[12] * dArr.length]);
        byteBufferWrap.order(byteOrder);
        for (double d : dArr) {
            byteBufferWrap.putDouble(d);
        }
        return new b(12, dArr.length, byteBufferWrap.array());
    }

    public static b c(int[] iArr, ByteOrder byteOrder) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[g[9] * iArr.length]);
        byteBufferWrap.order(byteOrder);
        for (int i : iArr) {
            byteBufferWrap.putInt(i);
        }
        return new b(9, iArr.length, byteBufferWrap.array());
    }

    public static b d(e[] eVarArr, ByteOrder byteOrder) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[g[10] * eVarArr.length]);
        byteBufferWrap.order(byteOrder);
        for (e eVar : eVarArr) {
            byteBufferWrap.putInt((int) eVar.b());
            byteBufferWrap.putInt((int) eVar.a());
        }
        return new b(10, eVarArr.length, byteBufferWrap.array());
    }

    public static b e(String str) {
        byte[] bytes = (str + (char) 0).getBytes(e);
        return new b(2, bytes.length, bytes);
    }

    public static b f(long j, ByteOrder byteOrder) {
        return g(new long[]{j}, byteOrder);
    }

    public static b g(long[] jArr, ByteOrder byteOrder) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[g[4] * jArr.length]);
        byteBufferWrap.order(byteOrder);
        for (long j : jArr) {
            byteBufferWrap.putInt((int) j);
        }
        return new b(4, jArr.length, byteBufferWrap.array());
    }

    public static b h(e[] eVarArr, ByteOrder byteOrder) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[g[5] * eVarArr.length]);
        byteBufferWrap.order(byteOrder);
        for (e eVar : eVarArr) {
            byteBufferWrap.putInt((int) eVar.b());
            byteBufferWrap.putInt((int) eVar.a());
        }
        return new b(5, eVarArr.length, byteBufferWrap.array());
    }

    public static b i(int[] iArr, ByteOrder byteOrder) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[g[3] * iArr.length]);
        byteBufferWrap.order(byteOrder);
        for (int i : iArr) {
            byteBufferWrap.putShort((short) i);
        }
        return new b(3, iArr.length, byteBufferWrap.array());
    }

    public int j() {
        return g[this.a] * this.b;
    }

    public String toString() {
        return "(" + f[this.a] + ", data length:" + this.d.length + ")";
    }

    b(int i, int i2, long j, byte[] bArr) {
        this.a = i;
        this.b = i2;
        this.c = j;
        this.d = bArr;
    }
}
