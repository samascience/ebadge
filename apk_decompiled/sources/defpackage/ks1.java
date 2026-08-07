package defpackage;

import com.jieli.jl_rcsp.constant.AttrAndFunCode;
import com.tencent.connect.common.Constants;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ks1 {
    private static final ThreadLocal a = new a();

    class a extends ThreadLocal {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public DecimalFormat initialValue() {
            return (DecimalFormat) NumberFormat.getInstance();
        }
    }

    public static byte a(byte[] bArr) {
        String str = Constants.STR_EMPTY;
        for (int length = bArr.length - 1; length >= 0; length--) {
            str = str + ((int) bArr[length]);
        }
        return new BigInteger(str.trim(), 2).byteValue();
    }

    public static int b(byte[] bArr) {
        int i = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            i = (i << 8) | (bArr[i2] & 255);
        }
        return i;
    }

    public static int c(byte[] bArr) {
        int i = bArr[0] & 255;
        int i2 = bArr[1] & 255;
        return ((bArr[3] & 255) << 24) | i | (i2 << 8) | ((bArr[2] & 255) << 16);
    }

    public static int d(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | ((bArr[i] << 24) & (-16777216)) | ((bArr[i + 1] << AttrAndFunCode.SYS_INFO_ATTR_FIXED_LEN_DATA_FUN) & 16711680) | ((bArr[i + 2] << 8) & 65280);
    }

    public static long e(byte[] bArr, boolean z) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr, 0, 8);
        if (z) {
            byteBufferWrap.order(ByteOrder.LITTLE_ENDIAN);
        }
        return byteBufferWrap.getLong();
    }

    public static short f(byte[] bArr) {
        return (short) (((bArr[0] & 255) << 8) | (bArr[1] & 255));
    }

    public static short g(byte[] bArr) {
        return (short) (((bArr[1] & 255) << 8) | (bArr[0] & 255));
    }

    public static byte[] h(byte[]... bArr) {
        int length = 0;
        for (byte[] bArr2 : bArr) {
            length += bArr2.length;
        }
        byte[] bArr3 = new byte[length];
        int i = 0;
        for (byte[] bArr4 : bArr) {
            int length2 = bArr4.length;
            int i2 = 0;
            while (i2 < length2) {
                bArr3[i] = bArr4[i2];
                i2++;
                i++;
            }
        }
        return bArr3;
    }

    public static short i(byte b) {
        return (short) (b & 255);
    }

    public static int j(short s) {
        return s & 65535;
    }

    public static byte[] k(int i) {
        byte[] bArr = new byte[32];
        for (int i2 = 0; i2 < 8; i2++) {
            bArr[i2] = (byte) ((i >> i2) & 1);
        }
        return bArr;
    }

    public static byte[] l(int i) {
        byte[] bArr = new byte[4];
        for (int i2 = 0; i2 < 4; i2++) {
            bArr[i2] = (byte) (i >>> (24 - (i2 * 8)));
        }
        return bArr;
    }

    public static byte[] m(int i) {
        return new byte[]{(byte) ((i >>> 24) & 255), (byte) ((i >>> 16) & 255), (byte) ((i >>> 8) & 255), (byte) (i & 255)};
    }

    public static float n(float f, int i) {
        return new BigDecimal(f).setScale(i, 3).floatValue();
    }

    public static byte[] o(short s) {
        return new byte[]{(byte) ((s >> 8) & 255), (byte) (s & 255)};
    }

    public static long p(int i) {
        return ((long) i) & 4294967295L;
    }
}
