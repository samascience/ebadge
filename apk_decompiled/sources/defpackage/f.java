package defpackage;

import com.jieli.jl_rcsp.constant.AttrAndFunCode;
import kotlin.text.i;
import okio.ByteString;

/* JADX INFO: loaded from: classes4.dex */
public abstract class f {
    private static final fo.a a = new fo.a();
    private static final int b = -1234567890;

    public static final boolean a(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        p31.f(bArr, "a");
        p31.f(bArr2, "b");
        for (int i4 = 0; i4 < i3; i4++) {
            if (bArr[i4 + i] != bArr2[i4 + i2]) {
                return false;
            }
        }
        return true;
    }

    public static final void b(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException("size=" + j + " offset=" + j2 + " byteCount=" + j3);
        }
    }

    public static final int c() {
        return b;
    }

    public static final fo.a d() {
        return a;
    }

    public static final int e(ByteString byteString, int i) {
        p31.f(byteString, "<this>");
        return i == b ? byteString.size() : i;
    }

    public static final int f(byte[] bArr, int i) {
        p31.f(bArr, "<this>");
        return i == b ? bArr.length : i;
    }

    public static final fo.a g(fo.a aVar) {
        p31.f(aVar, "unsafeCursor");
        return aVar == a ? new fo.a() : aVar;
    }

    public static final int h(int i) {
        return ((i & 255) << 24) | (((-16777216) & i) >>> 24) | ((16711680 & i) >>> 8) | ((65280 & i) << 8);
    }

    public static final long i(long j) {
        return ((j & 255) << 56) | (((-72057594037927936L) & j) >>> 56) | ((71776119061217280L & j) >>> 40) | ((280375465082880L & j) >>> 24) | ((1095216660480L & j) >>> 8) | ((4278190080L & j) << 8) | ((16711680 & j) << 24) | ((65280 & j) << 40);
    }

    public static final short j(short s) {
        return (short) (((s & 255) << 8) | ((65280 & s) >>> 8));
    }

    public static final String k(byte b2) {
        return i.q(new char[]{c.f()[(b2 >> 4) & 15], c.f()[b2 & AttrAndFunCode.SYS_INFO_ATTR_PHONE_STATUS]});
    }

    public static final String l(int i) {
        int i2 = 0;
        if (i == 0) {
            return "0";
        }
        char[] cArr = {c.f()[(i >> 28) & 15], c.f()[(i >> 24) & 15], c.f()[(i >> 20) & 15], c.f()[(i >> 16) & 15], c.f()[(i >> 12) & 15], c.f()[(i >> 8) & 15], c.f()[(i >> 4) & 15], c.f()[i & 15]};
        while (i2 < 8 && cArr[i2] == '0') {
            i2++;
        }
        return i.r(cArr, i2, 8);
    }
}
