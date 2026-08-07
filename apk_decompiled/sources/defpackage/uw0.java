package defpackage;

import com.jieli.jl_rcsp.constant.AttrAndFunCode;
import com.tencent.connect.common.Constants;

/* JADX INFO: loaded from: classes.dex */
public abstract class uw0 {
    static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String a(byte[] bArr) {
        return b(bArr, (char) 0, bArr.length);
    }

    public static String b(byte[] bArr, char c, int i) {
        StringBuffer stringBuffer = new StringBuffer((i << 1) + (c == 0 ? 0 : i));
        for (int i2 = 0; i2 < i; i2++) {
            char[] cArr = a;
            stringBuffer.append(cArr[(bArr[i2] >>> 4) & 15]);
            stringBuffer.append(cArr[bArr[i2] & AttrAndFunCode.SYS_INFO_ATTR_PHONE_STATUS]);
            if (c != 0 && i2 < i - 1) {
                stringBuffer.append(c);
            }
        }
        return stringBuffer.toString();
    }

    public static String c(int i) {
        String hexString = Integer.toHexString(i & 255);
        if (hexString.length() != 1) {
            return hexString;
        }
        return '0' + hexString;
    }

    public static byte[] d(String str) {
        int i;
        bp bpVar = new bp(str.length() / 2);
        int length = str.length();
        if (str.startsWith("0x")) {
            length -= 2;
            i = 2;
        } else {
            i = 0;
        }
        while (length > 0) {
            if (!Character.isLetterOrDigit(str.charAt(i))) {
                i++;
                length--;
            }
            if (length < 2) {
                throw new NumberFormatException("Odd number of hexadecimal digits");
            }
            int i2 = i + 2;
            bpVar.a((byte) Integer.parseInt(str.substring(i, i2), 16));
            length -= 2;
            i = i2;
        }
        return bpVar.c();
    }

    public static String e(byte[] bArr) {
        String str = Constants.STR_EMPTY;
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                hexString = '0' + hexString;
            }
            str = str + hexString.toUpperCase();
        }
        return str;
    }
}
