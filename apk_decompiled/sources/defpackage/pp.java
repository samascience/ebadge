package defpackage;

import com.jieli.jl_rcsp.util.CHexConver;
import com.tencent.connect.common.Constants;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public abstract class pp {
    public static byte[] a(byte[] bArr, Integer num, Integer num2) {
        return Arrays.copyOfRange(bArr, num.intValue(), num2.intValue());
    }

    public static String b(int i) {
        String hexString = Integer.toHexString(i);
        if (hexString.length() % 2 == 1) {
            hexString = "0" + hexString;
        }
        return hexString.toUpperCase();
    }

    public static int c(String str) {
        int length = str.length();
        int iPow = 0;
        for (int i = length; i > 0; i--) {
            iPow = (int) (((double) iPow) + (Math.pow(2.0d, length - i) * ((double) (str.charAt(i - 1) - '0'))));
        }
        return iPow;
    }

    public static String d(byte[] bArr) {
        StringBuilder sb = new StringBuilder(Constants.STR_EMPTY);
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static String e(byte[] bArr) {
        String str = Constants.STR_EMPTY;
        for (byte b : bArr) {
            str = str + ((char) b);
        }
        return str;
    }

    public static byte f(char c) {
        return (byte) CHexConver.b.indexOf(c);
    }

    public static int g(String str) {
        return c(h(str));
    }

    public static String h(String str) {
        String upperCase = str.toUpperCase();
        int length = upperCase.length();
        String str2 = Constants.STR_EMPTY;
        for (int i = 0; i < length; i++) {
            char cCharAt = upperCase.charAt(i);
            switch (cCharAt) {
                case '0':
                    str2 = str2 + "0000";
                    break;
                case '1':
                    str2 = str2 + "0001";
                    break;
                case '2':
                    str2 = str2 + "0010";
                    break;
                case '3':
                    str2 = str2 + "0011";
                    break;
                case '4':
                    str2 = str2 + "0100";
                    break;
                case '5':
                    str2 = str2 + "0101";
                    break;
                case '6':
                    str2 = str2 + "0110";
                    break;
                case '7':
                    str2 = str2 + "0111";
                    break;
                case '8':
                    str2 = str2 + Constants.DEFAULT_UIN;
                    break;
                case '9':
                    str2 = str2 + "1001";
                    break;
                default:
                    switch (cCharAt) {
                        case 'A':
                            str2 = str2 + "1010";
                            break;
                        case 'B':
                            str2 = str2 + "1011";
                            break;
                        case 'C':
                            str2 = str2 + "1100";
                            break;
                        case 'D':
                            str2 = str2 + "1101";
                            break;
                        case 'E':
                            str2 = str2 + "1110";
                            break;
                        case 'F':
                            str2 = str2 + "1111";
                            break;
                    }
                    break;
            }
        }
        return str2;
    }

    public static byte[] i(String str) {
        if (str == null || str.equals(Constants.STR_EMPTY)) {
            return null;
        }
        String upperCase = str.toUpperCase();
        int length = upperCase.length() / 2;
        char[] charArray = upperCase.toCharArray();
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) (f(charArray[i2 + 1]) | (f(charArray[i2]) << 4));
        }
        return bArr;
    }

    public static byte[] j(int i) {
        byte[] bArr = new byte[4];
        for (int i2 = 0; i2 < 4; i2++) {
            bArr[i2] = (byte) (i >> (24 - (i2 * 8)));
        }
        return bArr;
    }

    public static byte[] k(short s) {
        byte[] bArr = new byte[2];
        int i = 0;
        int i2 = s;
        while (i < 2) {
            bArr[i] = new Integer(i2 & 255).byteValue();
            i++;
            i2 >>= 8;
        }
        return bArr;
    }

    public static String l(String str, int i, int i2) {
        int length = str.length();
        String str2 = Constants.STR_EMPTY;
        int i3 = 0;
        for (int i4 = 0; i4 <= length; i4++) {
            if (i4 >= i) {
                str2 = str2 + str.charAt(i4);
                i3++;
            }
            if (i3 >= i2) {
                break;
            }
        }
        return str2;
    }
}
