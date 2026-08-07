package defpackage;

import com.tencent.connect.common.Constants;

/* JADX INFO: loaded from: classes.dex */
public abstract class l63 {
    public static String a(byte b) {
        return b(new byte[]{b});
    }

    public static String b(byte[] bArr) {
        String upperCase;
        String str = Constants.STR_EMPTY;
        if (bArr == null) {
            return Constants.STR_EMPTY;
        }
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b);
            int length = hexString.length();
            if (length > 2) {
                upperCase = hexString.substring(length - 2).toUpperCase();
            } else if (length == 1) {
                upperCase = "0" + hexString.toUpperCase();
            } else {
                upperCase = hexString.toUpperCase();
            }
            str = str + upperCase;
        }
        return str;
    }

    public static String c(byte[] bArr, int i) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < i; i2++) {
            String hexString = Integer.toHexString(bArr[i2] & 255);
            if (hexString.length() == 1) {
                hexString = '0' + hexString;
            }
            stringBuffer.append(hexString.toUpperCase());
            stringBuffer.append(" ");
        }
        return stringBuffer.toString();
    }

    public static long d(byte[] bArr) {
        long j = 0;
        if (bArr != null) {
            long j2 = 0;
            for (int i = 0; i < bArr.length; i++) {
                j |= ((long) (bArr[(bArr.length - 1) - i] & 255)) << ((int) j2);
                j2 += 8;
            }
        }
        return j;
    }

    public static long e(byte[] bArr) {
        long j = 0;
        if (bArr != null) {
            long j2 = 0;
            for (byte b : bArr) {
                j |= (long) ((b & 255) << ((int) j2));
                j2 += 8;
            }
        }
        return j;
    }

    public static long f(byte[] bArr, int i, int i2) {
        int i3;
        long j = 0;
        if (bArr != null && bArr.length > i && bArr.length >= (i3 = i2 + i)) {
            long j2 = 0;
            while (i < i3) {
                j |= ((long) (bArr[i] & 255)) << ((int) j2);
                j2 += 8;
                i++;
            }
        }
        return j;
    }

    public static String g(String str) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < str.length() - 1) {
            int i2 = i + 2;
            sb.append((char) Integer.parseInt(str.substring(i, i2), 16));
            i = i2;
        }
        return sb.toString();
    }

    public static byte[] h(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = Integer.valueOf(str.substring(i2, i2 + 2), 16).byteValue();
        }
        return bArr;
    }

    public static String i(int i, int i2) {
        String hexString = Integer.toHexString(i);
        int length = (i2 << 1) - hexString.length();
        if (length > 0) {
            for (int i3 = 0; i3 < length; i3++) {
                hexString = "0" + hexString;
            }
        }
        return hexString.toUpperCase();
    }

    public static String j(long j, int i) {
        String hexString = Long.toHexString(j);
        int length = (i << 1) - hexString.length();
        if (length > 0) {
            for (int i2 = 0; i2 < length; i2++) {
                hexString = "0" + hexString;
            }
        }
        return hexString.toUpperCase();
    }
}
